import 'dart:async';
import 'dart:math';

import 'package:flutter/material.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:geolocator/geolocator.dart';
import 'package:latlong2/latlong.dart';

import '../../widgets/route_panel.dart';

class NavigationScreen extends StatefulWidget {
  final LatLng? destination;
  final String? destinationName;

  const NavigationScreen({
    super.key,
    this.destination,
    this.destinationName,
  });

  @override
  State<NavigationScreen> createState() => _NavigationScreenState();
}

class _NavigationScreenState extends State<NavigationScreen> {
  final MapController _mapController = MapController();
  bool _isNavigating = true;
  double _currentHeading = 0;
  double _currentSpeed = 0;
  double _remainingDistance = 5200;
  Duration _remainingTime = const Duration(minutes: 15);
  int _currentStepIndex = 0;
  Timer? _simulationTimer;

  static const LatLng _jakartaCenter = LatLng(-6.2088, 106.8456);

  List<_NavigationStep> _steps = [];
  List<LatLng> _routePoints = [];

  @override
  void initState() {
    super.initState();
    _initRoute();
    _startSimulation();
  }

  void _initRoute() {
    final dest = widget.destination ?? _jakartaCenter;
    _routePoints = [
      _jakartaCenter,
      dest,
    ];
    final dist = Geolocator.distanceBetween(
      _jakartaCenter.latitude, _jakartaCenter.longitude,
      dest.latitude, dest.longitude,
    );
    _remainingDistance = dist;
    _remainingTime = Duration(seconds: (dist / 10).round());
    _steps = [
      _NavigationStep(instruction: 'Mulai navigasi dari lokasi Anda', distance: 0, icon: Icons.play_arrow),
      _NavigationStep(instruction: 'Menuju ${widget.destinationName ?? "tujuan"}', distance: dist.round(), icon: Icons.straight),
      _NavigationStep(instruction: 'Lokasi tujuan ada di sekitar Anda', distance: 0, icon: Icons.location_on),
    ];
  }

  void _startSimulation() {
    _simulationTimer = Timer.periodic(const Duration(seconds: 2), (timer) {
      if (!mounted || !_isNavigating) {
        timer.cancel();
        return;
      }

      final random = Random();
      setState(() {
        _currentSpeed = 30 + random.nextDouble() * 30;
        _remainingDistance = max(0, _remainingDistance - 50 - random.nextDouble() * 50);
        _remainingTime = Duration(
          seconds: (_remainingDistance / (_currentSpeed * 0.2778)).round(),
        );

        if (_remainingDistance < 500 && _currentStepIndex < _steps.length - 1) {
          _currentStepIndex++;
        }

        if (_remainingDistance <= 0) {
          _isNavigating = false;
          timer.cancel();
        }
      });
    });
  }

  @override
  void dispose() {
    _simulationTimer?.cancel();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final destination = widget.destination ?? const LatLng(-6.1751, 106.8650);

    return Scaffold(
      body: Stack(
        children: [
          FlutterMap(
            mapController: _mapController,
            options: MapOptions(
              initialCenter: _routePoints.first,
              initialZoom: 14,
            ),
            children: [
              TileLayer(
                urlTemplate: 'https://tile.openstreetmap.org/{z}/{x}/{y}.png',
                userAgentPackageName: 'com.mapmarker.app',
              ),
              PolylineLayer(
                polylines: [
                  Polyline(
                    points: _routePoints,
                    color: theme.colorScheme.primary,
                    strokeWidth: 5,
                  ),
                ],
              ),
              MarkerLayer(
                markers: [
                  Marker(
                    width: 24,
                    height: 24,
                    point: _routePoints.first,
                    child: Container(
                      decoration: BoxDecoration(
                        color: Colors.blue,
                        shape: BoxShape.circle,
                        border: Border.all(color: Colors.white, width: 3),
                        boxShadow: [
                          BoxShadow(
                            color: Colors.blue.withOpacity(0.4),
                            blurRadius: 8,
                            spreadRadius: 2,
                          ),
                        ],
                      ),
                    ),
                  ),
                  Marker(
                    width: 40,
                    height: 48,
                    point: destination,
                    child: Column(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Container(
                          padding: const EdgeInsets.symmetric(
                            horizontal: 8,
                            vertical: 4,
                          ),
                          decoration: BoxDecoration(
                            color: theme.colorScheme.errorContainer,
                            borderRadius: BorderRadius.circular(8),
                          ),
                          child: Text(
                            widget.destinationName ?? 'Tujuan',
                            style: theme.textTheme.labelSmall?.copyWith(
                              color: theme.colorScheme.onErrorContainer,
                            ),
                          ),
                        ),
                        Icon(
                          Icons.location_on,
                          color: theme.colorScheme.error,
                          size: 32,
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
            left: 16,
            right: 16,
            child: _buildDirectionBanner(theme),
          ),
          Positioned(
            top: MediaQuery.of(context).padding.top + 80,
            left: 0,
            right: 0,
            child: _buildCompassHeading(theme),
          ),
          Positioned(
            top: MediaQuery.of(context).padding.top + 140,
            right: 16,
            child: Column(
              children: [
                _buildSpeedIndicator(theme),
                const SizedBox(height: 8),
                Container(
                  decoration: BoxDecoration(
                    color: theme.colorScheme.surface,
                    borderRadius: BorderRadius.circular(12),
                    boxShadow: [
                      BoxShadow(
                        color: Colors.black.withOpacity(0.1),
                        blurRadius: 8,
                      ),
                    ],
                  ),
                  child: Column(
                    children: [
                      IconButton(
                        onPressed: () {
                          _mapController.move(
                            _mapController.camera.center,
                            _mapController.camera.zoom + 1,
                          );
                        },
                        icon: const Icon(Icons.add),
                      ),
                      Container(
                        height: 1,
                        color: theme.colorScheme.outline.withOpacity(0.2),
                      ),
                      IconButton(
                        onPressed: () {
                          _mapController.move(
                            _mapController.camera.center,
                            _mapController.camera.zoom - 1,
                          );
                        },
                        icon: const Icon(Icons.remove),
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ),
          Positioned(
            bottom: 0,
            left: 0,
            right: 0,
            child: _isNavigating
                ? RoutePanel(
                    remainingDistance: _formatDistance(_remainingDistance),
                    remainingTime: _formatDuration(_remainingTime),
                    nextInstruction: _currentStepIndex < _steps.length
                        ? _steps[_currentStepIndex].instruction
                        : 'Anda sudah sampai!',
                    distanceToNextStep: _currentStepIndex < _steps.length
                        ? _steps[_currentStepIndex].distance.toDouble()
                        : 0,
                    isNavigating: true,
                    onStopNavigation: _stopNavigation,
                  )
                : _buildArrivalPanel(theme),
          ),
        ],
      ),
    );
  }

  Widget _buildDirectionBanner(ThemeData theme) {
    if (_currentStepIndex >= _steps.length) return const SizedBox.shrink();

    final step = _steps[_currentStepIndex];

    return Container(
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(
        color: theme.colorScheme.primaryContainer,
        borderRadius: BorderRadius.circular(16),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withOpacity(0.1),
            blurRadius: 8,
          ),
        ],
      ),
      child: Row(
        children: [
          Container(
            width: 48,
            height: 48,
            decoration: BoxDecoration(
              color: theme.colorScheme.primary,
              borderRadius: BorderRadius.circular(12),
            ),
            child: Icon(
              step.icon,
              color: theme.colorScheme.onPrimary,
              size: 28,
            ),
          ),
          const SizedBox(width: 12),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              mainAxisSize: MainAxisSize.min,
              children: [
                Text(
                  step.instruction,
                  style: theme.textTheme.titleMedium?.copyWith(
                    fontWeight: FontWeight.bold,
                  ),
                  maxLines: 2,
                  overflow: TextOverflow.ellipsis,
                ),
                if (step.distance > 0)
                  Text(
                    _formatDistance(step.distance.toDouble()),
                    style: theme.textTheme.bodySmall?.copyWith(
                      color: theme.colorScheme.onPrimaryContainer.withOpacity(0.7),
                    ),
                  ),
              ],
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildCompassHeading(ThemeData theme) {
    return Center(
      child: Container(
        padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
        decoration: BoxDecoration(
          color: theme.colorScheme.surface.withOpacity(0.9),
          borderRadius: BorderRadius.circular(20),
          boxShadow: [
            BoxShadow(
              color: Colors.black.withOpacity(0.1),
              blurRadius: 4,
            ),
          ],
        ),
        child: Row(
          mainAxisSize: MainAxisSize.min,
          children: [
            Transform.rotate(
              angle: _currentHeading * pi / 180,
              child: Icon(
                Icons.navigation,
                color: theme.colorScheme.primary,
                size: 20,
              ),
            ),
            const SizedBox(width: 8),
            Text(
              '${_currentHeading.round()}° ${_getCardinalDirection(_currentHeading)}',
              style: theme.textTheme.bodyMedium?.copyWith(
                fontWeight: FontWeight.w500,
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildSpeedIndicator(ThemeData theme) {
    return Container(
      padding: const EdgeInsets.all(12),
      decoration: BoxDecoration(
        color: theme.colorScheme.surface,
        borderRadius: BorderRadius.circular(12),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withOpacity(0.1),
            blurRadius: 8,
          ),
        ],
      ),
      child: Column(
        children: [
          Text(
            '${_currentSpeed.round()}',
            style: theme.textTheme.headlineMedium?.copyWith(
              fontWeight: FontWeight.bold,
              color: _currentSpeed > 60 ? theme.colorScheme.error : null,
            ),
          ),
          Text(
            'km/j',
            style: theme.textTheme.bodySmall?.copyWith(
              color: theme.colorScheme.onSurface.withOpacity(0.5),
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildArrivalPanel(ThemeData theme) {
    return Container(
      padding: const EdgeInsets.all(20),
      decoration: BoxDecoration(
        color: theme.colorScheme.surface,
        borderRadius: const BorderRadius.vertical(top: Radius.circular(20)),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withOpacity(0.15),
            blurRadius: 12,
            offset: const Offset(0, -4),
          ),
        ],
      ),
      child: SafeArea(
        top: false,
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Icon(
              Icons.check_circle,
              color: Colors.green,
              size: 64,
            ),
            const SizedBox(height: 12),
            Text(
              'Anda Sudah Sampai!',
              style: theme.textTheme.headlineSmall?.copyWith(
                fontWeight: FontWeight.bold,
              ),
            ),
            const SizedBox(height: 8),
            Text(
              widget.destinationName ?? 'Tujuan',
              style: theme.textTheme.bodyLarge?.copyWith(
                color: theme.colorScheme.onSurface.withOpacity(0.6),
              ),
            ),
            const SizedBox(height: 20),
            SizedBox(
              width: double.infinity,
              child: FilledButton(
                onPressed: () => Navigator.of(context).pop(),
                style: FilledButton.styleFrom(
                  padding: const EdgeInsets.symmetric(vertical: 14),
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(12),
                  ),
                ),
                child: const Text('Kembali ke Peta'),
              ),
            ),
          ],
        ),
      ),
    );
  }

  String _formatDistance(double meters) {
    if (meters < 1000) {
      return '${meters.round()} m';
    }
    return '${(meters / 1000).toStringAsFixed(1)} km';
  }

  String _formatDuration(Duration duration) {
    if (duration.inHours > 0) {
      return '${duration.inHours} jam ${duration.inMinutes % 60} menit';
    }
    return '${duration.inMinutes} menit';
  }

  String _getCardinalDirection(double heading) {
    if (heading >= 337.5 || heading < 22.5) return 'U';
    if (heading >= 22.5 && heading < 67.5) return 'TL';
    if (heading >= 67.5 && heading < 112.5) return 'T';
    if (heading >= 112.5 && heading < 157.5) return 'TG';
    if (heading >= 157.5 && heading < 202.5) return 'S';
    if (heading >= 202.5 && heading < 247.5) return 'BD';
    if (heading >= 247.5 && heading < 292.5) return 'B';
    return 'BL';
  }

  void _stopNavigation() {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: const Text('Hentikan Navigasi?'),
        content: const Text('Apakah Anda yakin ingin menghentikan navigasi?'),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context),
            child: const Text('Lanjutkan'),
          ),
          FilledButton(
            onPressed: () {
              Navigator.pop(context);
              setState(() => _isNavigating = false);
              Navigator.of(context).pop();
            },
            style: FilledButton.styleFrom(backgroundColor: Colors.red),
            child: const Text('Hentikan'),
          ),
        ],
      ),
    );
  }
}

class _NavigationStep {
  final String instruction;
  final int distance;
  final IconData icon;

  _NavigationStep({
    required this.instruction,
    required this.distance,
    required this.icon,
  });
}
