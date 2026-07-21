import 'dart:convert';

import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:http/http.dart' as http;

import 'search_state.dart';

class SearchCubit extends Cubit<SearchState> {
  SearchCubit() : super(const SearchState());

  Future<void> search(String query) async {
    if (query.trim().isEmpty) {
      emit(state.copyWith(results: [], clearError: true, lastQuery: ''));
      return;
    }

    emit(state.copyWith(isLoading: true, clearError: true, lastQuery: query));

    try {
      final encodedQuery = Uri.encodeComponent(query.trim());
      final url = Uri.parse(
        'https://nominatim.openstreetmap.org/search'
        '?q=$encodedQuery&format=json&limit=10',
      );

      final response = await http.get(
        url,
        headers: {
          'Accept': 'application/json',
          'User-Agent': 'MapMarker/1.0 (Flutter POI app)',
        },
      );

      if (response.statusCode != 200) {
        emit(state.copyWith(
          isLoading: false,
          error: 'Search failed: HTTP ${response.statusCode}',
        ));
        return;
      }

      final List<dynamic> data = json.decode(response.body);

      final results = data.map<SearchResult>((item) {
        return SearchResult(
          name: item['display_name'] as String? ?? '',
          lat: double.parse(item['lat'] as String),
          lng: double.parse(item['lon'] as String),
          address: _buildAddress(item['address']),
          osmId: item['osm_id']?.toString(),
          type: item['type'] as String?,
        );
      }).toList();

      emit(state.copyWith(
        isLoading: false,
        results: results,
      ));
    } catch (e) {
      emit(state.copyWith(
        isLoading: false,
        error: e.toString(),
      ));
    }
  }

  void clearResults() {
    emit(const SearchState());
  }

  String? _buildAddress(dynamic addressData) {
    if (addressData == null || addressData is! Map) return null;

    final parts = <String>[];
    for (final key in [
      'house_number',
      'road',
      'neighbourhood',
      'suburb',
      'city',
      'town',
      'village',
      'state',
      'country',
    ]) {
      if (addressData[key] != null) {
        parts.add(addressData[key].toString());
      }
    }

    return parts.isEmpty ? null : parts.join(', ');
  }
}
