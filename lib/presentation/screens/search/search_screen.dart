import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import '../../bloc/search_cubit/search_cubit.dart';
import '../../bloc/search_cubit/search_state.dart';

class SearchScreen extends StatefulWidget {
  const SearchScreen({super.key});

  @override
  State<SearchScreen> createState() => _SearchScreenState();
}

class _SearchScreenState extends State<SearchScreen> {
  final _searchController = TextEditingController();
  final _focusNode = FocusNode();
  Timer? _debounce;

  @override
  void initState() {
    super.initState();
    WidgetsBinding.instance.addPostFrameCallback((_) => _focusNode.requestFocus());
  }

  @override
  void dispose() {
    _debounce?.cancel();
    _searchController.dispose();
    _focusNode.dispose();
    super.dispose();
  }

  void _onSearchChanged(String query) {
    _debounce?.cancel();
    _debounce = Timer(const Duration(milliseconds: 500), () {
      context.read<SearchCubit>().search(query);
    });
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);

    return BlocBuilder<SearchCubit, SearchState>(
      builder: (context, state) {
        return Scaffold(
          appBar: AppBar(
            title: TextField(
              controller: _searchController,
              focusNode: _focusNode,
              onChanged: _onSearchChanged,
              style: theme.textTheme.bodyLarge,
              decoration: InputDecoration(
                hintText: 'Cari lokasi...',
                hintStyle: theme.textTheme.bodyLarge?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.4)),
                border: InputBorder.none,
                prefixIcon: const Icon(Icons.search),
                suffixIcon: _searchController.text.isNotEmpty
                    ? IconButton(
                        icon: const Icon(Icons.clear),
                        onPressed: () {
                          _searchController.clear();
                          context.read<SearchCubit>().search('');
                        },
                      )
                    : null,
              ),
            ),
          ),
          body: Column(
            children: [
              if (state.isLoading) const LinearProgressIndicator(minHeight: 2),
              Expanded(
                child: state.lastQuery.isEmpty
                    ? _buildEmptyState(theme)
                    : _buildResults(state, theme),
              ),
            ],
          ),
        );
      },
    );
  }

  Widget _buildEmptyState(ThemeData theme) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Icon(Icons.search, size: 64, color: theme.colorScheme.onSurface.withOpacity(0.15)),
          const SizedBox(height: 16),
          Text('Cari lokasi', style: theme.textTheme.headlineSmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.4))),
        ],
      ),
    );
  }

  Widget _buildResults(SearchState state, ThemeData theme) {
    if (state.isLoading && state.results.isEmpty) {
      return Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const CircularProgressIndicator(),
            const SizedBox(height: 16),
            Text('Mencari...', style: theme.textTheme.bodyMedium?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.5))),
          ],
        ),
      );
    }

    if (state.error != null && state.results.isEmpty) {
      return Center(
        child: Text(state.error!, style: theme.textTheme.bodyMedium?.copyWith(color: theme.colorScheme.error)),
      );
    }

    if (state.results.isEmpty) {
      return Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(Icons.search_off, size: 64, color: theme.colorScheme.onSurface.withOpacity(0.15)),
            const SizedBox(height: 16),
            Text('Tidak ditemukan', style: theme.textTheme.headlineSmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.4))),
          ],
        ),
      );
    }

    return ListView.builder(
      itemCount: state.results.length,
      itemBuilder: (context, index) {
        final result = state.results[index];
        return ListTile(
          leading: Container(
            width: 40, height: 40,
            decoration: BoxDecoration(color: theme.colorScheme.primaryContainer.withOpacity(0.5), borderRadius: BorderRadius.circular(10)),
            child: Icon(Icons.place, color: theme.colorScheme.primary, size: 20),
          ),
          title: Text(result.name, maxLines: 2, overflow: TextOverflow.ellipsis),
          subtitle: Text('${result.lat.toStringAsFixed(4)}, ${result.lng.toStringAsFixed(4)}',
              style: theme.textTheme.bodySmall?.copyWith(fontFamily: 'monospace', color: theme.colorScheme.onSurface.withOpacity(0.4))),
          onTap: () => Navigator.of(context).pop({
            'latitude': result.lat,
            'longitude': result.lng,
            'name': result.name,
          }),
        );
      },
    );
  }
}
