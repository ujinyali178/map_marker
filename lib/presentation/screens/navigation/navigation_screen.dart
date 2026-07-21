import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:latlong2/latlong.dart';

import '../../bloc/nav_cubit/nav_cubit.dart';
import '../../bloc/nav_cubit/nav_state.dart';
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

  static const LatLng _jakartaCenter = LatLng(-6.2088, 106.8456);

  @override
  void initState() {
    super.initState();
    _startNavigation();
  }

  void _startNavigation() {
    final dest = widget.destination;
    if (dest == null) return;

    context.read<NavigationCubit>().startNavigation(
          NavDestination(
            id: 'nav_dest',
            name: widget.destinationName ?? 'Tujuan',
            latitude: dest.latitude,
            longitude: dest.longitude,
          ),
        );
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final destination = widget.destination ?? _jakartaCenter;

    return Scaffold(
      body: BlocConsumer<NavigationCubit, NavState>(
        listener: (context, navState) {
          if (!navState.isActive && navState.routePoints.isEmpty) return;
          if (navState.routePoints.isNotEmpty) {
            _mapController.fitCamera(
              CameraFit.bounds(
                bounds: LatLngBounds.fromPoints(navState.routePoints),
                padding: const EdgeInsets.all(50),
              ),
            );
          }
        },
        builder: (context, navState) {
          return Stack(
            children: [
              FlutterMap(
                mapController: _mapController,
                options: MapOptions(
                  initialCenter: navState.routePoints.isNotEmpty
                      ? navState.routePoints.first
                      : _jakartaCenter,
                  initialZoom: 14,
                ),
                children: [
                  TileLayer(
                    urlTemplate:
                        'https://tile.openstreetmap.org/{z}/{x}/{y}.png',
                    userAgentPackageName: 'com.mapmarker.app',
                  ),
                  if (navState.routePoints.isNotEmpty)
                    PolylineLayer(
                      polylines: [
                        Polyline(
                          points: navState.routePoints,
                          color: theme.colorScheme.primary,
                          strokeWidth: 5,
                        ),
                      ],
                    ),
                  MarkerLayer(
                    markers: [
                      if (navState.routePoints.isNotEmpty)
                        Marker(
                          width: 24,
                          height: 24,
                          point: navState.routePoints.first,
                          child: Container(
                            decoration: BoxDecoration(
                              color: Colors.blue,
                              shape: BoxShape.circle,
                              border:
                                  Border.all(color: Colors.white, width: 3),
                              boxShadow: [
                                BoxShadow(
                                  color: Colors.blue.withValues(alpha: 0.4),
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
                                  color:
                                      theme.colorScheme.onErrorContainer,
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
                child: _buildDirectionBanner(theme, navState),
              ),
              Positioned(
                top: MediaQuery.of(context).padding.top + 140,
                right: 16,
                child: Column(
                  children: [
                    _buildSpeedIndicator(theme, navState),
                    const SizedBox(height: 8),
                    Container(
                      decoration: BoxDecoration(
                        color: theme.colorScheme.surface,
                        borderRadius: BorderRadius.circular(12),
                        boxShadow: [
                          BoxShadow(
                            color: Colors.black.withValues(alpha: 0.1),
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
                            color: theme.colorScheme.outline
                                .withValues(alpha: 0.2),
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
                child: navState.isActive
                    ? RoutePanel(
                        remainingDistance: _formatDistance(
                            navState.remainingDistance),
                        remainingTime: _formatDuration(Duration(
                            seconds: navState.remainingDuration.round())),
                        nextInstruction: navState.currentStep <
                                navState.steps.length
                            ? _getStepInstruction(
                                navState.steps[navState.currentStep])
                            : 'Menuju tujuan...',
                        distanceToNextStep: navState.currentStep <
                                navState.steps.length
                            ? navState.steps[navState.currentStep].distance
                            : 0,
                        isNavigating: true,
                        onStopNavigation: _stopNavigation,
                      )
                    : _buildArrivalPanel(theme, navState),
              ),
            ],
          );
        },
      ),
    );
  }

  String _getStepInstruction(NavStep step) {
    final parts = <String>[];
    if (step.modifier != null) {
      parts.add(step.modifier!);
    }
    if (step.instruction.isNotEmpty) {
      parts.add(step.instruction);
    }
    return parts.isNotEmpty ? parts.join(' ') : 'Lurus terus';
  }

  Widget _buildDirectionBanner(ThemeData theme, NavState navState) {
    if (!navState.isActive || navState.steps.isEmpty) {
      return const SizedBox.shrink();
    }

    final stepIndex = navState.currentStep;
    if (stepIndex >= navState.steps.length) return const SizedBox.shrink();
    final step = navState.steps[stepIndex];

    return Container(
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(
        color: theme.colorScheme.primaryContainer,
        borderRadius: BorderRadius.circular(16),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withValues(alpha: 0.1),
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
              _getStepIcon(step),
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
                  _getStepInstruction(step),
                  style: theme.textTheme.titleMedium?.copyWith(
                    fontWeight: FontWeight.bold,
                  ),
                  maxLines: 2,
                  overflow: TextOverflow.ellipsis,
                ),
                if (step.distance > 0)
                  Text(
                    _formatDistance(step.distance),
                    style: theme.textTheme.bodySmall?.copyWith(
                      color: theme.colorScheme.onPrimaryContainer
                          .withValues(alpha: 0.7),
                    ),
                  ),
              ],
            ),
          ),
        ],
      ),
    );
  }

  IconData _getStepIcon(NavStep step) {
    final modifier = step.modifier ?? '';
    if (modifier.contains('left')) return Icons.turn_left;
    if (modifier.contains('right')) return Icons.turn_right;
    if (modifier.contains('straight') || step.mode == 'driving') {
      return Icons.straight;
    }
    return Icons.navigation;
  }

  Widget _buildSpeedIndicator(ThemeData theme, NavState navState) {
    final speed = navState.remainingDistance > 0 && navState.remainingDuration > 0
        ? (navState.remainingDistance / navState.remainingDuration) * 3.6
        : 0.0;

    return Container(
      padding: const EdgeInsets.all(12),
      decoration: BoxDecoration(
        color: theme.colorScheme.surface,
        borderRadius: BorderRadius.circular(12),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withValues(alpha: 0.1),
            blurRadius: 8,
          ),
        ],
      ),
      child: Column(
        children: [
          Text(
            '${speed.round()}',
            style: theme.textTheme.headlineMedium?.copyWith(
              fontWeight: FontWeight.bold,
              color:
                  speed > 60 ? theme.colorScheme.error : null,
            ),
          ),
          Text(
            'km/j',
            style: theme.textTheme.bodySmall?.copyWith(
              color:
                  theme.colorScheme.onSurface.withValues(alpha: 0.5),
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildArrivalPanel(ThemeData theme, NavState navState) {
    return Container(
      padding: const EdgeInsets.all(20),
      decoration: BoxDecoration(
        color: theme.colorScheme.surface,
        borderRadius:
            const BorderRadius.vertical(top: Radius.circular(20)),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withValues(alpha: 0.15),
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
            const Icon(
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
                color:
                    theme.colorScheme.onSurface.withValues(alpha: 0.6),
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

  void _stopNavigation() {
    showDialog(
      context: context,
      builder: (dialogContext) => AlertDialog(
        title: const Text('Hentikan Navigasi?'),
        content: const Text(
            'Apakah Anda yakin ingin menghentikan navigasi?'),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(dialogContext),
            child: const Text('Lanjutkan'),
          ),
          FilledButton(
            onPressed: () {
              Navigator.pop(dialogContext);
              context.read<NavigationCubit>().stopNavigation();
              Navigator.of(context).pop();
            },
            style: FilledButton.styleFrom(
                backgroundColor: Colors.red),
            child: const Text('Hentikan'),
          ),
        ],
      ),
    );
  }
}
