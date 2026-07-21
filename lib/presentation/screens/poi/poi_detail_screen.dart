import 'dart:io';

import 'package:collection/collection.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:latlong2/latlong.dart';

import '../../../data/models/poi_model.dart';
import '../../bloc/poi_cubit/poi_cubit.dart';
import '../../bloc/poi_cubit/poi_state.dart';

class PoiDetailScreen extends StatefulWidget {
  final String? poiId;
  const PoiDetailScreen({super.key, this.poiId});

  @override
  State<PoiDetailScreen> createState() => _PoiDetailScreenState();
}

class _PoiDetailScreenState extends State<PoiDetailScreen> {
  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);

    return BlocBuilder<PoiCubit, PoiState>(
      builder: (context, state) {
        final poi = state.pois.firstWhereOrNull((p) => p.id == widget.poiId);

        if (poi == null) {
          return Scaffold(
            appBar: AppBar(),
            body: const Center(child: Text('POI tidak ditemukan')),
          );
        }

        final markerColor = Color(poi.color);
        final poiLocation = LatLng(poi.latitude, poi.longitude);

        return Scaffold(
          body: CustomScrollView(
            slivers: [
              SliverAppBar(
                expandedHeight: 280,
                pinned: true,
                stretch: true,
                actions: [
                  IconButton(
                    onPressed: () {
                      context.read<PoiCubit>().toggleFavorite(poi.id);
                    },
                    icon: Icon(poi.isFavorite ? Icons.favorite : Icons.favorite_border, color: poi.isFavorite ? Colors.red : null),
                    tooltip: 'Favorit',
                  ),
                  PopupMenuButton<String>(
                    itemBuilder: (_) => <PopupMenuEntry<String>>[
                      const PopupMenuItem(value: 'edit', child: ListTile(leading: Icon(Icons.edit), title: Text('Edit'), dense: true)),
                      const PopupMenuItem(value: 'navigate', child: ListTile(leading: Icon(Icons.navigation), title: Text('Navigasi'), dense: true)),
                      const PopupMenuDivider(),
                      const PopupMenuItem(value: 'delete', child: ListTile(leading: Icon(Icons.delete, color: Colors.red), title: Text('Hapus', style: TextStyle(color: Colors.red)), dense: true)),
                    ],
                    onSelected: (value) => _handleMenuAction(poi, value),
                  ),
                ],
                flexibleSpace: FlexibleSpaceBar(
                  title: Text(poi.name, style: const TextStyle(shadows: [Shadow(blurRadius: 8, color: Colors.black54)])),
                  background: Container(
                    color: theme.colorScheme.primaryContainer,
                    child: Center(
                      child: Icon(Icons.location_on, size: 64, color: markerColor.withOpacity(0.5)),
                    ),
                  ),
                ),
              ),
              SliverToBoxAdapter(
                child: Padding(
                  padding: const EdgeInsets.all(16),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      _buildLocationChip(theme, poi, markerColor),
                      const SizedBox(height: 16),
                      if (poi.description.isNotEmpty) ...[
                        Text('Deskripsi', style: theme.textTheme.titleMedium?.copyWith(fontWeight: FontWeight.bold)),
                        const SizedBox(height: 8),
                        Text(poi.description, style: theme.textTheme.bodyLarge?.copyWith(height: 1.6, color: theme.colorScheme.onSurface.withOpacity(0.8))),
                        const SizedBox(height: 24),
                      ],
                      if (poi.note.isNotEmpty) ...[
                        Row(
                          children: [
                            Icon(Icons.note_outlined, size: 20, color: theme.colorScheme.tertiary),
                            const SizedBox(width: 8),
                            Text('Catatan', style: theme.textTheme.titleMedium?.copyWith(fontWeight: FontWeight.bold)),
                          ],
                        ),
                        const SizedBox(height: 8),
                        Container(
                          width: double.infinity, padding: const EdgeInsets.all(12),
                          decoration: BoxDecoration(
                            color: theme.colorScheme.tertiaryContainer.withOpacity(0.3),
                            borderRadius: BorderRadius.circular(8),
                            border: Border.all(color: theme.colorScheme.tertiary.withOpacity(0.3)),
                          ),
                          child: Text(poi.note, style: theme.textTheme.bodyMedium?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.7), height: 1.5)),
                        ),
                        const SizedBox(height: 24),
                      ],
                      Text('Lokasi di Peta', style: theme.textTheme.titleMedium?.copyWith(fontWeight: FontWeight.bold)),
                      const SizedBox(height: 8),
                      ClipRRect(
                        borderRadius: BorderRadius.circular(12),
                        child: SizedBox(
                          height: 200,
                          child: FlutterMap(
                            options: MapOptions(
                              initialCenter: poiLocation,
                              initialZoom: 15,
                              interactionOptions: const InteractionOptions(flags: InteractiveFlag.none),
                            ),
                            children: [
                              TileLayer(urlTemplate: 'https://tile.openstreetmap.org/{z}/{x}/{y}.png', userAgentPackageName: 'com.mapmarker.app'),
                              MarkerLayer(
                                markers: [
                                  Marker(width: 40, height: 48, point: poiLocation, child: Icon(Icons.location_on, color: markerColor, size: 36)),
                                ],
                              ),
                            ],
                          ),
                        ),
                      ),
                      const SizedBox(height: 24),
                      Row(
                        children: [
                          Expanded(
                            child: FilledButton.icon(
                              onPressed: () => _startNavigation(poi),
                              icon: const Icon(Icons.navigation),
                              label: const Text('Navigasi'),
                              style: FilledButton.styleFrom(padding: const EdgeInsets.symmetric(vertical: 14), shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12))),
                            ),
                          ),
                          const SizedBox(width: 12),
                          Expanded(
                            child: OutlinedButton.icon(
                              onPressed: () => _editPoi(poi),
                              icon: const Icon(Icons.edit),
                              label: const Text('Edit'),
                              style: OutlinedButton.styleFrom(padding: const EdgeInsets.symmetric(vertical: 14), shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12))),
                            ),
                          ),
                        ],
                      ),
                      const SizedBox(height: 12),
                      SizedBox(
                        width: double.infinity,
                        child: OutlinedButton.icon(
                          onPressed: () => _deletePoi(poi),
                          icon: const Icon(Icons.delete_outline, color: Colors.red),
                          label: const Text('Hapus', style: TextStyle(color: Colors.red)),
                          style: OutlinedButton.styleFrom(padding: const EdgeInsets.symmetric(vertical: 14), shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)), side: BorderSide(color: Colors.red.withOpacity(0.3))),
                        ),
                      ),
                      const SizedBox(height: 32),
                    ],
                  ),
                ),
              ),
            ],
          ),
        );
      },
    );
  }

  Widget _buildLocationChip(ThemeData theme, PoiModel poi, Color markerColor) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 12),
      decoration: BoxDecoration(color: theme.colorScheme.surfaceContainerHighest.withOpacity(0.3), borderRadius: BorderRadius.circular(12)),
      child: Row(
        children: [
          Icon(Icons.place, color: markerColor, size: 20),
          const SizedBox(width: 8),
          Expanded(
            child: Text(
              '${poi.latitude.toStringAsFixed(4)}, ${poi.longitude.toStringAsFixed(4)}',
              style: theme.textTheme.bodyMedium?.copyWith(fontFamily: 'monospace'),
            ),
          ),
        ],
      ),
    );
  }

  void _handleMenuAction(PoiModel poi, String action) {
    switch (action) {
      case 'edit': _editPoi(poi); break;
      case 'navigate': _startNavigation(poi); break;
      case 'delete': _deletePoi(poi); break;
    }
  }

  void _startNavigation(PoiModel poi) {
    Navigator.of(context).pushNamed('/navigation', arguments: {
      'destination': LatLng(poi.latitude, poi.longitude),
      'destinationName': poi.name,
    });
  }

  void _editPoi(PoiModel poi) {
    Navigator.of(context).pushNamed('/poi/editor', arguments: {'poiId': poi.id});
  }

  void _deletePoi(PoiModel poi) {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: const Text('Hapus POI?'),
        content: Text('Apakah Anda yakin ingin menghapus "${poi.name}"?'),
        actions: [
          TextButton(onPressed: () => Navigator.pop(context), child: const Text('Batal')),
          FilledButton(
            onPressed: () {
              Navigator.pop(context);
              context.read<PoiCubit>().deletePoi(poi.id);
              ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
                content: Text('POI berhasil dihapus'), behavior: SnackBarBehavior.floating,
              ));
              Navigator.of(context).pop();
            },
            style: FilledButton.styleFrom(backgroundColor: Colors.red),
            child: const Text('Hapus'),
          ),
        ],
      ),
    );
  }
}
