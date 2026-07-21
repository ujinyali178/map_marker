import 'package:flutter/material.dart';

class RoutePanel extends StatelessWidget {
  final String remainingDistance;
  final String remainingTime;
  final String nextInstruction;
  final double? distanceToNextStep;
  final VoidCallback? onStopNavigation;
  final bool isNavigating;

  const RoutePanel({
    super.key,
    this.remainingDistance = '0 km',
    this.remainingTime = '0 menit',
    this.nextInstruction = '',
    this.distanceToNextStep,
    this.onStopNavigation,
    this.isNavigating = false,
  });

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);

    return Container(
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
            const SizedBox(height: 8),
            Container(
              width: 40,
              height: 4,
              decoration: BoxDecoration(
                color: theme.colorScheme.onSurface.withOpacity(0.2),
                borderRadius: BorderRadius.circular(2),
              ),
            ),
            const SizedBox(height: 16),
            if (nextInstruction.isNotEmpty) ...[
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 20),
                child: Row(
                  children: [
                    Container(
                      padding: const EdgeInsets.all(12),
                      decoration: BoxDecoration(
                        color: theme.colorScheme.primaryContainer,
                        borderRadius: BorderRadius.circular(16),
                      ),
                      child: Icon(
                        _getDirectionIcon(nextInstruction),
                        color: theme.colorScheme.onPrimaryContainer,
                        size: 28,
                      ),
                    ),
                    const SizedBox(width: 16),
                    Expanded(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            nextInstruction,
                            style: theme.textTheme.titleMedium?.copyWith(
                              fontWeight: FontWeight.bold,
                            ),
                            maxLines: 2,
                            overflow: TextOverflow.ellipsis,
                          ),
                          if (distanceToNextStep != null)
                            Text(
                              _formatDistance(distanceToNextStep!),
                              style: theme.textTheme.bodyMedium?.copyWith(
                                color: theme.colorScheme.onSurface.withOpacity(0.6),
                              ),
                            ),
                        ],
                      ),
                    ),
                  ],
                ),
              ),
              const SizedBox(height: 16),
              Divider(
                height: 1,
                color: theme.colorScheme.outline.withOpacity(0.2),
              ),
            ],
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 12),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: [
                  _StatItem(
                    icon: Icons.route,
                    label: 'Sisa',
                    value: remainingDistance,
                    color: theme.colorScheme.primary,
                  ),
                  _StatItem(
                    icon: Icons.access_time,
                    label: 'Estimasi',
                    value: remainingTime,
                    color: theme.colorScheme.tertiary,
                  ),
                  _StatItem(
                    icon: Icons.navigation,
                    label: 'Langkah',
                    value: nextInstruction.isEmpty ? 'Mulai' : '1',
                    color: theme.colorScheme.secondary,
                  ),
                ],
              ),
            ),
            Padding(
              padding: const EdgeInsets.fromLTRB(20, 0, 20, 12),
              child: SizedBox(
                width: double.infinity,
                height: 48,
                child: FilledButton.icon(
                  onPressed: onStopNavigation,
                  icon: const Icon(Icons.stop),
                  label: const Text('Hentikan Navigasi'),
                  style: FilledButton.styleFrom(
                    backgroundColor: theme.colorScheme.error,
                    foregroundColor: theme.colorScheme.onError,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(12),
                    ),
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  IconData _getDirectionIcon(String instruction) {
    final lower = instruction.toLowerCase();
    if (lower.contains('belok kiri') || lower.contains('kiri')) {
      return Icons.turn_left;
    }
    if (lower.contains('belok kanan') || lower.contains('kanan')) {
      return Icons.turn_right;
    }
    if (lower.contains('lurus') || lower.contains('terus')) {
      return Icons.straight;
    }
    if (lower.contains('u-turn') || lower.contains('putar balik')) {
      return Icons.u_turn_left;
    }
    if (lower.contains('keluar')) {
      return Icons.exit_to_app;
    }
    return Icons.navigation;
  }

  String _formatDistance(double meters) {
    if (meters < 1000) {
      return '${meters.round()} m';
    }
    return '${(meters / 1000).toStringAsFixed(1)} km';
  }
}

class _StatItem extends StatelessWidget {
  final IconData icon;
  final String label;
  final String value;
  final Color color;

  const _StatItem({
    required this.icon,
    required this.label,
    required this.value,
    required this.color,
  });

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);

    return Column(
      children: [
        Icon(icon, color: color, size: 24),
        const SizedBox(height: 4),
        Text(
          value,
          style: theme.textTheme.titleMedium?.copyWith(
            fontWeight: FontWeight.bold,
          ),
        ),
        Text(
          label,
          style: theme.textTheme.bodySmall?.copyWith(
            color: theme.colorScheme.onSurface.withOpacity(0.6),
          ),
        ),
      ],
    );
  }
}
