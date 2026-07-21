import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:latlong2/latlong.dart';

import '../../../data/models/poi_model.dart';
import '../../bloc/poi_cubit/poi_cubit.dart';
import '../../bloc/poi_cubit/poi_state.dart';
import '../../widgets/poi_marker.dart';
import '../../widgets/poi_bottom_sheet.dart';
import '../../widgets/search_bar_widget.dart';
import '../../widgets/route_panel.dart';

class MapScreen extends StatefulWidget {
  const MapScreen({super.key});

  @override
  State<MapScreen> createState() => _MapScreenState();
}

class _MapScreenState extends State<MapScreen> {
  bool _isNavigating = false;
  bool _isLongPressPlacing = false;
  LatLng? _longPressLocation;
  PoiModel? _selectedPoi;

  @override
  void initState() {
    super.initState();
    context.read<PoiCubit>().loadPois();
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);

    return Scaffold(
      body: BlocBuilder<PoiCubit, PoiState>(
        builder: (context, poiState) {
          return Stack(
            children: [
              FlutterMap(
                options: MapOptions(
                  initialCenter: const LatLng(-6.2088, 106.8456),
                  initialZoom: 13,
                  onLongPress: _onMapLongPress,
                  onTap: (_, __) {
                    if (_isLongPressPlacing) {
                      setState(() {
                        _isLongPressPlacing = false;
                        _longPressLocation = null;
                      });
                    }
                  },
                ),
                children: [
                  TileLayer(
                    urlTemplate: 'https://tile.openstreetmap.org/{z}/{x}/{y}.png',
                    userAgentPackageName: 'com.mapmarker.app',
                    maxZoom: 19,
                  ),
                  MarkerLayer(
                    markers: poiState.pois.map((poi) {
                      return Marker(
                        width: 40,
                        height: 48,
                        point: LatLng(poi.latitude, poi.longitude),
                        child: PoiMarker(
                          color: Color(poi.color),
                          icon: _getIconData(poi.iconKey),
                          isSelected: _selectedPoi?.id == poi.id,
                          onTap: () => _selectPoi(poi),
                        ),
                      );
                    }).toList(),
                  ),
                  if (_longPressLocation != null)
                    MarkerLayer(
                      markers: [
                        Marker(
                          width: 40,
                          height: 52,
                          point: _longPressLocation!,
                          child: Column(
                            mainAxisSize: MainAxisSize.min,
                            children: [
                              Icon(
                                Icons.add_location_alt,
                                color: theme.colorScheme.primary,
                                size: 36,
                              ),
                              Container(
                                padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 4),
                                decoration: BoxDecoration(
                                  color: theme.colorScheme.primaryContainer,
                                  borderRadius: BorderRadius.circular(8),
                                ),
                                child: Text('Tap untuk simpan', style: theme.textTheme.labelSmall),
                              ),
                            ],
                          ),
                        ),
                      ],
                    ),
                ],
              ),
              Positioned(
                top: MediaQuery.of(context).padding.top + 8,
                left: 0,
                right: 0,
                child: SearchBarWidget(
                  onTap: () => Navigator.of(context).pushNamed('/search'),
                ),
              ),
              Positioned(
                right: 16,
                bottom: 100,
                child: Column(
                  children: [
                    FloatingActionButton.small(
                      heroTag: 'zoom_in',
                      onPressed: () {},
                      child: const Icon(Icons.add),
                    ),
                    const SizedBox(height: 8),
                    FloatingActionButton.small(
                      heroTag: 'zoom_out',
                      onPressed: () {},
                      child: const Icon(Icons.remove),
                    ),
                    const SizedBox(height: 8),
                    FloatingActionButton.small(
                      heroTag: 'my_location',
                      onPressed: () {},
                      child: const Icon(Icons.my_location),
                    ),
                  ],
                ),
              ),
              Positioned(
                left: 16,
                bottom: 100,
                child: Column(
                  children: [
                    FloatingActionButton.small(
                      heroTag: 'layers',
                      onPressed: _showLayerOptions,
                      child: const Icon(Icons.layers),
                    ),
                    const SizedBox(height: 8),
                    FloatingActionButton.small(
                      heroTag: 'compass',
                      onPressed: () {},
                      child: const Icon(Icons.explore),
                    ),
                  ],
                ),
              ),
              Positioned(
                top: MediaQuery.of(context).padding.top + 60,
                left: 16,
                child: FloatingActionButton(
                  heroTag: 'drawer',
                  mini: true,
                  onPressed: () => Scaffold.of(context).openDrawer(),
                  child: const Icon(Icons.menu),
                ),
              ),
              if (_isLongPressPlacing)
                Positioned.fill(
                  child: Container(
                    color: Colors.black.withOpacity(0.3),
                    child: Center(
                      child: Card(
                        margin: const EdgeInsets.symmetric(horizontal: 32),
                        child: Padding(
                          padding: const EdgeInsets.all(20),
                          child: Column(
                            mainAxisSize: MainAxisSize.min,
                            children: [
                              Icon(Icons.add_location_alt, size: 48, color: theme.colorScheme.primary),
                              const SizedBox(height: 12),
                              Text('Buat POI baru di lokasi ini?', style: theme.textTheme.titleMedium, textAlign: TextAlign.center),
                              const SizedBox(height: 16),
                              Row(
                                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                                children: [
                                  TextButton(
                                    onPressed: () => setState(() { _isLongPressPlacing = false; _longPressLocation = null; }),
                                    child: const Text('Batal'),
                                  ),
                                  FilledButton(
                                    onPressed: () {
                                      setState(() => _isLongPressPlacing = false);
                                      Navigator.of(context).pushNamed(
                                        '/poi/editor',
                                        arguments: {
                                          'latitude': _longPressLocation?.latitude,
                                          'longitude': _longPressLocation?.longitude,
                                        },
                                      );
                                    },
                                    child: const Text('Buat POI'),
                                  ),
                                ],
                              ),
                            ],
                          ),
                        ),
                      ),
                    ),
                  ),
                ),
            ],
          );
        },
      ),
      floatingActionButton: !_isNavigating
          ? FloatingActionButton.extended(
              onPressed: () => Navigator.of(context).pushNamed('/poi/editor'),
              icon: const Icon(Icons.add),
              label: const Text('Tambah POI'),
            )
          : null,
    );
  }

  void _onMapLongPress(TapPosition tapPosition, LatLng point) {
    setState(() {
      _longPressLocation = point;
      _isLongPressPlacing = true;
    });
  }

  void _selectPoi(PoiModel poi) {
    setState(() => _selectedPoi = poi);
    _showPoiBottomSheet(poi);
  }

  void _showPoiBottomSheet(PoiModel poi) {
    showModalBottomSheet(
      context: context,
      isScrollControlled: true,
      backgroundColor: Colors.transparent,
      builder: (_) => PoiBottomSheet(
        name: poi.name,
        description: poi.description,
        markerColor: Color(poi.color),
        onNavigate: () {
          Navigator.pop(context);
          Navigator.of(context).pushNamed('/navigation', arguments: {
            'destination': LatLng(poi.latitude, poi.longitude),
            'destinationName': poi.name,
          });
        },
        onEdit: () {
          Navigator.pop(context);
          Navigator.of(context).pushNamed('/poi/editor', arguments: {'poiId': poi.id});
        },
        onShare: () => Navigator.pop(context),
        onViewDetail: () {
          Navigator.pop(context);
          Navigator.of(context).pushNamed('/poi/detail', arguments: {'poiId': poi.id});
        },
      ),
    );
  }

  void _showLayerOptions() {
    showModalBottomSheet(
      context: context,
      builder: (_) => SafeArea(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            const SizedBox(height: 8),
            Container(width: 40, height: 4, decoration: BoxDecoration(color: Theme.of(context).colorScheme.onSurface.withOpacity(0.2), borderRadius: BorderRadius.circular(2))),
            const SizedBox(height: 16),
            Text('Jenis Peta', style: Theme.of(context).textTheme.titleMedium),
            const SizedBox(height: 8),
            ListTile(leading: const Icon(Icons.map), title: const Text('Standar (OSM)'), onTap: () => Navigator.pop(context)),
            ListTile(leading: const Icon(Icons.terrain), title: const Text('Topografi'), onTap: () => Navigator.pop(context)),
            ListTile(leading: const Icon(Icons.satellite_alt), title: const Text('Satelit'), onTap: () => Navigator.pop(context)),
            const SizedBox(height: 16),
          ],
        ),
      ),
    );
  }

  IconData _getIconData(String iconKey) {
    const iconMap = <String, IconData>{
      'default': Icons.location_on,
      'star': Icons.star,
      'restaurant': Icons.restaurant,
      'hotel': Icons.hotel,
      'hospital': Icons.local_hospital,
      'school': Icons.school,
      'park': Icons.park,
      'shopping': Icons.shopping_cart,
      'cafe': Icons.local_cafe,
      'bar': Icons.local_bar,
      'gas_station': Icons.local_gas_station,
      'grocery': Icons.local_grocery_store,
      'pharmacy': Icons.local_pharmacy,
      'police': Icons.local_police,
      'theater': Icons.theaters,
      'museum': Icons.museum,
      'library': Icons.library_books,
      'sports': Icons.sports_soccer,
      'pool': Icons.pool,
      'flight': Icons.flight,
      'bus': Icons.directions_bus,
      'train': Icons.train,
      'beach': Icons.beach_access,
      'cabin': Icons.cabin,
      'mosque': Icons.mosque,
      'church': Icons.church,
      'government': Icons.account_balance,
      'flag': Icons.flag,
      'bookmark': Icons.bookmark,
      'favorite': Icons.favorite,
    };
    return iconMap[iconKey] ?? Icons.location_on;
  }
}
