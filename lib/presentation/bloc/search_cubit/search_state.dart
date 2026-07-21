import 'package:equatable/equatable.dart';

class SearchResult extends Equatable {
  final String name;
  final double lat;
  final double lng;
  final String? address;
  final String? osmId;
  final String? type;

  const SearchResult({
    required this.name,
    required this.lat,
    required this.lng,
    this.address,
    this.osmId,
    this.type,
  });

  @override
  List<Object?> get props => [name, lat, lng, address, osmId, type];
}

class SearchState extends Equatable {
  final List<SearchResult> results;
  final bool isLoading;
  final String? error;
  final String lastQuery;

  const SearchState({
    this.results = const [],
    this.isLoading = false,
    this.error,
    this.lastQuery = '',
  });

  SearchState copyWith({
    List<SearchResult>? results,
    bool? isLoading,
    String? error,
    String? lastQuery,
    bool clearError = false,
  }) {
    return SearchState(
      results: results ?? this.results,
      isLoading: isLoading ?? this.isLoading,
      error: clearError ? null : (error ?? this.error),
      lastQuery: lastQuery ?? this.lastQuery,
    );
  }

  @override
  List<Object?> get props => [results, isLoading, error, lastQuery];
}
