import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:latlong2/latlong.dart';

import '../../bloc/track_cubit/track_cubit.dart';
import '../../bloc/track_cubit/track_state.dart';

class TrackRecordingScreen extends StatefulWidget {
  const TrackRecordingScreen({super.key});

  @override
  State<TrackRecordingScreen> createState() => _TrackRecordingScreenState();
}

class _TrackRecordingScreenState extends State<TrackRecordingScreen> with SingleTickerProviderStateMixin {
  late TabController _tabController;
  final MapController _mapController = MapController();

  static const _jakartaCenter = LatLng(-6.2088, 106.8456);

  @override
  void initState() {
    super.initState();
    _tabController = TabController(length: 2, vsync: this);
    context.read<TrackCubit>().loadTracks();
  }

  @override
  void dispose() {
    _tabController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);

    return Scaffold(
      appBar: AppBar(
        title: const Text('Track'),
        bottom: TabBar(
          controller: _tabController,
          tabs: const [
            Tab(icon: Icon(Icons.fiber_manual_record), text: 'Rekam'),
            Tab(icon: Icon(Icons.list), text: 'Track Saya'),
          ],
        ),
      ),
      body: TabBarView(
        controller: _tabController,
        children: [
          _buildRecordingTab(theme),
          _buildTrackListTab(theme),
        ],
      ),
    );
  }

  Widget _buildRecordingTab(ThemeData theme) {
    return BlocBuilder<TrackCubit, TrackState>(
      builder: (context, state) {
        return Column(
          children: [
            Expanded(
              flex: 3,
              child: Stack(
                children: [
                  FlutterMap(
                    mapController: _mapController,
                    options: MapOptions(initialCenter: _jakartaCenter, initialZoom: 14),
                    children: [
                      TileLayer(urlTemplate: 'https://tile.openstreetmap.org/{z}/{x}/{y}.png', userAgentPackageName: 'com.mapmarker.app'),
                      if (state.isRecording && state.pointsCount > 0)
                        PolylineLayer(
                          polylines: [
                            Polyline(
                              points: state.trackPoints,
                              color: theme.colorScheme.primary, strokeWidth: 4,
                            ),
                          ],
                        ),
                    ],
                  ),
                  if (state.isRecording)
                    Positioned(
                      top: 8, left: 8,
                      child: Container(
                        padding: const EdgeInsets.symmetric(horizontal: 12, vertical: 6),
                        decoration: BoxDecoration(color: state.isPaused ? Colors.orange : Colors.red, borderRadius: BorderRadius.circular(20)),
                        child: Row(
                          mainAxisSize: MainAxisSize.min,
                          children: [
                            Container(width: 8, height: 8, decoration: const BoxDecoration(color: Colors.white, shape: BoxShape.circle)),
                            const SizedBox(width: 6),
                            Text(state.isPaused ? 'Dijeda' : 'Merekam', style: const TextStyle(color: Colors.white, fontWeight: FontWeight.bold, fontSize: 12)),
                          ],
                        ),
                      ),
                    ),
                ],
              ),
            ),
            Expanded(
              flex: 2,
              child: Container(
                padding: const EdgeInsets.all(16),
                color: theme.colorScheme.surface,
                child: Column(
                  children: [
                    if (state.isRecording) ...[
                      _buildLiveStats(theme, state),
                      const SizedBox(height: 16),
                    ],
                    _buildRecordingControls(theme, state),
                  ],
                ),
              ),
            ),
          ],
        );
      },
    );
  }

  Widget _buildLiveStats(ThemeData theme, TrackState state) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceAround,
      children: [
        _buildStatItem(theme, icon: Icons.timer, label: 'Durasi', value: state.durationFormatted, color: theme.colorScheme.primary),
        _buildStatItem(theme, icon: Icons.straighten, label: 'Jarak', value: state.distanceFormatted, color: theme.colorScheme.secondary),
        _buildStatItem(theme, icon: Icons.speed, label: 'Kecepatan', value: '${state.currentSpeed.toStringAsFixed(1)} km/j', color: theme.colorScheme.tertiary),
      ],
    );
  }

  Widget _buildStatItem(ThemeData theme, {required IconData icon, required String label, required String value, required Color color}) {
    return Column(
      children: [
        Icon(icon, color: color, size: 20),
        const SizedBox(height: 4),
        Text(value, style: theme.textTheme.bodyMedium?.copyWith(fontWeight: FontWeight.bold)),
        Text(label, style: theme.textTheme.bodySmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.5))),
      ],
    );
  }

  Widget _buildRecordingControls(ThemeData theme, TrackState state) {
    final cubit = context.read<TrackCubit>();

    if (!state.isRecording) {
      return Column(
        children: [
          Icon(Icons.fiber_manual_record, size: 64, color: theme.colorScheme.error.withOpacity(0.3)),
          const SizedBox(height: 16),
          Text('Siap merekam track?', style: theme.textTheme.titleMedium?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.5))),
          const SizedBox(height: 16),
          SizedBox(
            width: double.infinity, height: 56,
            child: FilledButton.icon(
              onPressed: () => cubit.startRecording(),
              icon: const Icon(Icons.fiber_manual_record, size: 24),
              label: const Text('Mulai Merekam', style: TextStyle(fontSize: 16)),
              style: FilledButton.styleFrom(
                backgroundColor: theme.colorScheme.error, foregroundColor: theme.colorScheme.onError,
                shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(16)),
              ),
            ),
          ),
        ],
      );
    }

    return Row(
      children: [
        Expanded(
          child: state.isPaused
              ? FilledButton.icon(
                  onPressed: () => cubit.resumeRecording(),
                  icon: const Icon(Icons.play_arrow), label: const Text('Lanjut'),
                  style: FilledButton.styleFrom(backgroundColor: Colors.green, padding: const EdgeInsets.symmetric(vertical: 14), shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12))),
                )
              : OutlinedButton.icon(
                  onPressed: () => cubit.pauseRecording(),
                  icon: const Icon(Icons.pause), label: const Text('Jeda'),
                  style: OutlinedButton.styleFrom(padding: const EdgeInsets.symmetric(vertical: 14), shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12))),
                ),
        ),
        const SizedBox(width: 12),
        Expanded(
          child: FilledButton.icon(
            onPressed: () => cubit.stopRecording(),
            icon: const Icon(Icons.stop), label: const Text('Selesai'),
            style: FilledButton.styleFrom(backgroundColor: theme.colorScheme.error, padding: const EdgeInsets.symmetric(vertical: 14), shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12))),
          ),
        ),
      ],
    );
  }

  Widget _buildTrackListTab(ThemeData theme) {
    return BlocBuilder<TrackCubit, TrackState>(
      builder: (context, state) {
        if (state.isLoading) return const Center(child: CircularProgressIndicator());
        if (state.savedTracks.isEmpty) {
          return Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Icon(Icons.route, size: 80, color: theme.colorScheme.onSurface.withOpacity(0.15)),
                const SizedBox(height: 16),
                Text('Belum ada track', style: theme.textTheme.headlineSmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.4))),
                const SizedBox(height: 8),
                Text('Mulai merekam track pertama Anda', style: theme.textTheme.bodyMedium?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.3))),
              ],
            ),
          );
        }

        return ListView.builder(
          padding: const EdgeInsets.symmetric(vertical: 8),
          itemCount: state.savedTracks.length,
          itemBuilder: (context, index) {
            final track = state.savedTracks[index];
            return Card(
              margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 4),
              shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
              child: Padding(
                padding: const EdgeInsets.all(16),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Row(
                      children: [
                        Container(
                          width: 40, height: 40,
                          decoration: BoxDecoration(color: theme.colorScheme.primaryContainer, borderRadius: BorderRadius.circular(10)),
                          child: Icon(Icons.route, color: theme.colorScheme.primary),
                        ),
                        const SizedBox(width: 12),
                        Expanded(
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(track.name, style: theme.textTheme.titleMedium?.copyWith(fontWeight: FontWeight.bold)),
                              Text('${_formatDate(track.startedAt)}', style: theme.textTheme.bodySmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.5))),
                            ],
                          ),
                        ),
                      ],
                    ),
                    const SizedBox(height: 12),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceAround,
                      children: [
                        _buildMiniStat('Jarak', _formatDistance(track.distanceMeters)),
                        _buildMiniStat('Waktu', _formatDuration(track.duration)),
                      ],
                    ),
                  ],
                ),
              ),
            );
          },
        );
      },
    );
  }

  Widget _buildMiniStat(String label, String value) {
    return Column(
      children: [
        Text(value, style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 13)),
        Text(label, style: const TextStyle(fontSize: 11, color: Colors.grey)),
      ],
    );
  }

  String _formatDistance(double meters) {
    if (meters < 1000) return '${meters.round()} m';
    return '${(meters / 1000).toStringAsFixed(1)} km';
  }

  String _formatDuration(Duration duration) {
    if (duration.inHours > 0) {
      return '${duration.inHours}:${(duration.inMinutes % 60).toString().padLeft(2, '0')}:${(duration.inSeconds % 60).toString().padLeft(2, '0')}';
    }
    return '${duration.inMinutes}:${(duration.inSeconds % 60).toString().padLeft(2, '0')}';
  }

  String _formatDate(DateTime date) {
    return '${date.day}/${date.month}/${date.year}';
  }
}
