import 'package:flutter/material.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:latlong2/latlong.dart';

import '../../../core/constants/app_constants.dart';

class SelectLocationScreen extends StatefulWidget {
  const SelectLocationScreen({super.key});

  @override
  State<SelectLocationScreen> createState() => _SelectLocationScreenState();
}

class _SelectLocationScreenState extends State<SelectLocationScreen> {
  LatLng? _selectedPoint;
  final MapController _mapController = MapController();

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);

    return Scaffold(
      appBar: AppBar(
        title: const Text('Pilih Lokasi'),
        actions: [
          TextButton(
            onPressed: _selectedPoint == null
                ? null
                : () => Navigator.of(context).pop({
                      'latitude': _selectedPoint!.latitude,
                      'longitude': _selectedPoint!.longitude,
                    }),
            child: const Text('Pilih'),
          ),
        ],
      ),
      body: Stack(
        children: [
          FlutterMap(
            mapController: _mapController,
            options: MapOptions(
              initialCenter: const LatLng(
                AppConstants.defaultLatitude,
                AppConstants.defaultLongitude,
              ),
              initialZoom: 14,
              onTap: (tapPosition, point) {
                setState(() => _selectedPoint = point);
              },
            ),
            children: [
              TileLayer(
                urlTemplate:
                    'https://tile.openstreetmap.org/{z}/{x}/{y}.png',
                userAgentPackageName: 'com.mapmarker.app',
              ),
              if (_selectedPoint != null)
                MarkerLayer(
                  markers: [
                    Marker(
                      width: 40,
                      height: 48,
                      point: _selectedPoint!,
                      child: Icon(
                        Icons.location_on,
                        color: theme.colorScheme.error,
                        size: 40,
                      ),
                    ),
                  ],
                ),
            ],
          ),
          Positioned(
            bottom: 24,
            left: 16,
            right: 16,
            child: Container(
              padding: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: theme.colorScheme.surface,
                borderRadius: BorderRadius.circular(16),
                boxShadow: [
                  BoxShadow(
                    color: Colors.black.withValues(alpha: 0.15),
                    blurRadius: 12,
                  ),
                ],
              ),
              child: Text(
                _selectedPoint != null
                    ? 'Lat: ${_selectedPoint!.latitude.toStringAsFixed(6)}, Lng: ${_selectedPoint!.longitude.toStringAsFixed(6)}\nTap di peta untuk mengubah lokasi'
                    : 'Tap di peta untuk memilih lokasi',
                textAlign: TextAlign.center,
                style: theme.textTheme.bodyMedium,
              ),
            ),
          ),
        ],
      ),
    );
  }
}
