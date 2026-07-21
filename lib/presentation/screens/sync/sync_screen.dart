import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import '../../bloc/sync_cubit/sync_cubit.dart';
import '../../bloc/sync_cubit/sync_state.dart';

class SyncScreen extends StatelessWidget {
  const SyncScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return BlocBuilder<SyncCubit, SyncState>(
      builder: (context, state) {
        final theme = Theme.of(context);

        return Scaffold(
          appBar: AppBar(title: const Text('Sinkronisasi')),
          body: ListView(
            padding: const EdgeInsets.all(16),
            children: [
              _buildSyncStatusCard(theme, state, context),
              const SizedBox(height: 24),
              Text('Layanan Cloud', style: theme.textTheme.titleMedium?.copyWith(fontWeight: FontWeight.bold)),
              const SizedBox(height: 12),
              _buildServiceCard(
                theme, icon: Icons.cloud, title: 'Google Drive', isConnected: state.interfaceType == SyncInterfaceType.googleDrive,
                onConnect: () => context.read<SyncCubit>().connectToGoogleDrive(),
                color: Colors.blue,
              ),
              const SizedBox(height: 12),
              _buildServiceCard(
                theme, icon: Icons.cloud_queue, title: 'Dropbox', isConnected: state.interfaceType == SyncInterfaceType.dropbox,
                onConnect: () => context.read<SyncCubit>().connectToDropbox(),
                color: Colors.indigo,
              ),
              const SizedBox(height: 24),
              if (state.isSyncing) _buildSyncProgress(state, theme),
              if (state.interfaceType == SyncInterfaceType.none) ...[
                const SizedBox(height: 32),
                Center(
                  child: Column(
                    children: [
                      Icon(Icons.cloud_off, size: 64, color: theme.colorScheme.onSurface.withOpacity(0.15)),
                      const SizedBox(height: 16),
                      Text('Belum terhubung ke layanan cloud', style: theme.textTheme.bodyLarge?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.4))),
                      const SizedBox(height: 8),
                      Text('Hubungkan Google Drive atau Dropbox\nuntuk menyinkronkan data Anda', textAlign: TextAlign.center,
                          style: theme.textTheme.bodyMedium?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.3))),
                    ],
                  ),
                ),
              ],
            ],
          ),
        );
      },
    );
  }

  Widget _buildSyncStatusCard(ThemeData theme, SyncState state, BuildContext ctx) {
    final cubit = ctx.read<SyncCubit>();
    return Card(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(16)),
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
                  child: Icon(Icons.sync, color: theme.colorScheme.primary),
                ),
                const SizedBox(width: 12),
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text('Status Sinkronisasi', style: theme.textTheme.titleMedium?.copyWith(fontWeight: FontWeight.bold)),
                      Text(state.isConnected ? 'Terhubung' : 'Tidak terhubung',
                          style: theme.textTheme.bodySmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.5))),
                    ],
        ),
                ),
              ],
            ),
            if (state.lastSyncTime != null) ...[
              const SizedBox(height: 12),
              Divider(color: theme.colorScheme.outline.withOpacity(0.2)),
              const SizedBox(height: 12),
              Row(
                children: [
                  Icon(Icons.access_time, size: 16, color: theme.colorScheme.onSurface.withOpacity(0.4)),
                  const SizedBox(width: 8),
                  Text(
                    'Terakhir disinkronkan: ${_formatDateTime(state.lastSyncTime!)}',
                    style: theme.textTheme.bodySmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.5)),
                  ),
                ],
              ),
            ],
            const SizedBox(height: 12),
            SizedBox(
              width: double.infinity,
              child: FilledButton.icon(
                onPressed: state.isConnected && !state.isSyncing ? () => cubit.syncNow() : null,
                icon: state.isSyncing
                    ? const SizedBox(width: 18, height: 18, child: CircularProgressIndicator(strokeWidth: 2, color: Colors.white))
                    : const Icon(Icons.sync),
                label: Text(state.isSyncing ? 'Menyinkronkan...' : 'Sinkronkan Sekarang'),
                style: FilledButton.styleFrom(padding: const EdgeInsets.symmetric(vertical: 12), shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12))),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildServiceCard(
    ThemeData theme, {
    required IconData icon, required String title,
    required bool isConnected, required VoidCallback onConnect,
    required Color color,
  }) {
    return Card(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
      child: ListTile(
        contentPadding: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
        leading: Container(
          width: 44, height: 44,
          decoration: BoxDecoration(
            color: isConnected ? color.withOpacity(0.1) : theme.colorScheme.surfaceContainerHighest,
            borderRadius: BorderRadius.circular(10),
          ),
          child: Icon(icon, color: isConnected ? color : theme.colorScheme.onSurface.withOpacity(0.3)),
        ),
        title: Text(title, style: theme.textTheme.bodyLarge?.copyWith(fontWeight: FontWeight.w500)),
        subtitle: Text(isConnected ? 'Terhubung' : 'Tidak terhubung',
            style: theme.textTheme.bodySmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.4))),
        trailing: isConnected
            ? TextButton(onPressed: () {}, child: const Text('Putuskan', style: TextStyle(color: Colors.red)))
            : FilledButton.tonal(onPressed: onConnect, child: const Text('Hubungkan')),
      ),
    );
  }

  Widget _buildSyncProgress(SyncState state, ThemeData theme) {
    return Card(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
      child: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Row(
              children: [
                const SizedBox(width: 20, height: 20, child: CircularProgressIndicator(strokeWidth: 2)),
                const SizedBox(width: 12),
                Text('Menyinkronkan data...', style: theme.textTheme.bodyMedium?.copyWith(fontWeight: FontWeight.w500)),
              ],
            ),
            const SizedBox(height: 12),
            ClipRRect(
              borderRadius: BorderRadius.circular(4),
              child: LinearProgressIndicator(value: state.progress, minHeight: 8),
            ),
            const SizedBox(height: 8),
            Text('${(state.progress * 100).round()}%', style: theme.textTheme.bodySmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.5))),
          ],
        ),
      ),
    );
  }

  String _formatDateTime(DateTime dateTime) {
    final now = DateTime.now();
    final diff = now.difference(dateTime);
    if (diff.inMinutes < 1) return 'Baru saja';
    if (diff.inMinutes < 60) return '${diff.inMinutes} menit lalu';
    if (diff.inHours < 24) return '${diff.inHours} jam lalu';
    return '${dateTime.day}/${dateTime.month}/${dateTime.year}';
  }
}
