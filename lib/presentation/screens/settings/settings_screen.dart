import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import '../../bloc/settings_cubit/settings_cubit.dart';
import '../../bloc/settings_cubit/settings_state.dart';

class SettingsScreen extends StatelessWidget {
  const SettingsScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return BlocBuilder<SettingsCubit, SettingsState>(
      builder: (context, state) {
        final theme = Theme.of(context);
        return Scaffold(
          appBar: AppBar(title: const Text('Pengaturan')),
          body: ListView(
            children: [
              _buildAccountSection(theme, state),
              const Divider(height: 1),
              _buildMapSettingsSection(theme, state, context),
              const Divider(height: 1),
              _buildSyncSettingsSection(theme, state, context),
              const Divider(height: 1),
              _buildDisplaySettingsSection(theme, state, context),
              const Divider(height: 1),
              _buildAboutSection(theme),
              const SizedBox(height: 32),
            ],
          ),
        );
      },
    );
  }

  Widget _buildAccountSection(ThemeData theme, SettingsState state) {
    return Padding(
      padding: const EdgeInsets.all(16),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text('Akun', style: theme.textTheme.titleSmall?.copyWith(color: theme.colorScheme.primary, fontWeight: FontWeight.bold)),
          const SizedBox(height: 12),
          ListTile(
            contentPadding: EdgeInsets.zero,
            leading: CircleAvatar(
              radius: 24, backgroundColor: theme.colorScheme.primaryContainer,
              child: Icon(Icons.person, color: theme.colorScheme.onPrimaryContainer),
            ),
            title: const Text('Pengguna'),
            subtitle: Text('pengguna@email.com', style: theme.textTheme.bodySmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.5))),
            trailing: TextButton(onPressed: () {}, child: const Text('Edit')),
          ),
        ],
      ),
    );
  }

  Widget _buildMapSettingsSection(ThemeData theme, SettingsState state, BuildContext ctx) {
    final cubit = ctx.read<SettingsCubit>();
    return Padding(
      padding: const EdgeInsets.all(16),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text('Peta', style: theme.textTheme.titleSmall?.copyWith(color: theme.colorScheme.primary, fontWeight: FontWeight.bold)),
          const SizedBox(height: 8),
          ListTile(
            contentPadding: EdgeInsets.zero,
            leading: const Icon(Icons.map_outlined),
            title: const Text('Jenis Peta Default'),
            subtitle: Text(state.mapType.name),
            trailing: const Icon(Icons.chevron_right),
            onTap: () => _showMapTypeSelector(ctx, cubit, state),
          ),
          ListTile(
            contentPadding: EdgeInsets.zero,
            leading: const Icon(Icons.zoom_in),
            title: const Text('Zoom Default'),
            subtitle: Text('Level ${state.defaultZoom.round()}'),
            trailing: SizedBox(
              width: 150,
              child: Slider(
                value: state.defaultZoom, min: 3, max: 18, divisions: 15,
                onChanged: (value) => cubit.updateDefaultZoom(value),
              ),
            ),
          ),
          SwitchListTile(
            contentPadding: EdgeInsets.zero,
            secondary: const Icon(Icons.offline_bolt_outlined),
            title: const Text('Peta Offline'),
            subtitle: Text(state.offlineMapsEnabled ? 'Aktif - Menghemat kuota' : 'Nonaktif',
                style: theme.textTheme.bodySmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.5))),
            value: state.offlineMapsEnabled,
            onChanged: (value) => cubit.updateOfflineMaps(value),
          ),
        ],
      ),
    );
  }

  Widget _buildSyncSettingsSection(ThemeData theme, SettingsState state, BuildContext ctx) {
    final cubit = ctx.read<SettingsCubit>();
    return Padding(
      padding: const EdgeInsets.all(16),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text('Sinkronisasi', style: theme.textTheme.titleSmall?.copyWith(color: theme.colorScheme.primary, fontWeight: FontWeight.bold)),
          const SizedBox(height: 8),
          SwitchListTile(
            contentPadding: EdgeInsets.zero,
            secondary: const Icon(Icons.sync),
            title: const Text('Sinkronisasi Otomatis'),
            subtitle: Text(state.autoSync ? 'Aktif - Data tersinkron saat ada perubahan' : 'Nonaktif - Hanya sinkron manual',
                style: theme.textTheme.bodySmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.5))),
            value: state.autoSync,
            onChanged: (value) => cubit.updateAutoSync(value),
          ),
        ],
      ),
    );
  }

  Widget _buildDisplaySettingsSection(ThemeData theme, SettingsState state, BuildContext ctx) {
    final cubit = ctx.read<SettingsCubit>();
    return Padding(
      padding: const EdgeInsets.all(16),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text('Tampilan', style: theme.textTheme.titleSmall?.copyWith(color: theme.colorScheme.primary, fontWeight: FontWeight.bold)),
          const SizedBox(height: 8),
          ListTile(
            contentPadding: EdgeInsets.zero,
            leading: const Icon(Icons.straighten),
            title: const Text('Satuan Jarak'),
            trailing: SegmentedButton<String>(
              segments: const [
                ButtonSegment(value: 'km', label: Text('km')),
                ButtonSegment(value: 'miles', label: Text('mil')),
              ],
              selected: {state.distanceUnit == DistanceUnit.km ? 'km' : 'miles'},
              onSelectionChanged: (selected) {
                cubit.updateDistanceUnit(selected.first == 'km' ? DistanceUnit.km : DistanceUnit.miles);
              },
            ),
          ),
          ListTile(
            contentPadding: EdgeInsets.zero,
            leading: const Icon(Icons.dark_mode_outlined),
            title: const Text('Tema'),
            subtitle: Text(state.themeMode.name),
            trailing: const Icon(Icons.chevron_right),
            onTap: () => _showThemeSelector(ctx, cubit, state),
          ),
        ],
      ),
    );
  }

  Widget _buildAboutSection(ThemeData theme) {
    return Padding(
      padding: const EdgeInsets.all(16),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text('Tentang', style: theme.textTheme.titleSmall?.copyWith(color: theme.colorScheme.primary, fontWeight: FontWeight.bold)),
          const SizedBox(height: 8),
          const ListTile(contentPadding: EdgeInsets.zero, leading: Icon(Icons.info_outline), title: Text('Versi'), subtitle: Text('1.0.0 (Build 1)')),
        ],
      ),
    );
  }

  void _showMapTypeSelector(BuildContext ctx, SettingsCubit cubit, SettingsState state) {
    showModalBottomSheet(
      context: ctx,
      builder: (_) => SafeArea(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            const SizedBox(height: 8),
            Container(width: 40, height: 4, decoration: BoxDecoration(color: Theme.of(ctx).colorScheme.onSurface.withOpacity(0.2), borderRadius: BorderRadius.circular(2))),
            const SizedBox(height: 16),
            Text('Jenis Peta Default', style: Theme.of(ctx).textTheme.titleMedium),
            const SizedBox(height: 8),
            ...MapTypeOption.values.map((opt) => RadioListTile<MapTypeOption>(
              title: Text(opt.name),
              value: opt, groupValue: state.mapType,
              onChanged: (value) { cubit.updateMapType(value!); Navigator.pop(ctx); },
            )),
            const SizedBox(height: 16),
          ],
        ),
      ),
    );
  }

  void _showThemeSelector(BuildContext ctx, SettingsCubit cubit, SettingsState state) {
    showModalBottomSheet(
      context: ctx,
      builder: (_) => SafeArea(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            const SizedBox(height: 8),
            Container(width: 40, height: 4, decoration: BoxDecoration(color: Theme.of(ctx).colorScheme.onSurface.withOpacity(0.2), borderRadius: BorderRadius.circular(2))),
            const SizedBox(height: 16),
            Text('Pilih Tema', style: Theme.of(ctx).textTheme.titleMedium),
            const SizedBox(height: 8),
            ...ThemeModeOption.values.map((opt) => RadioListTile<ThemeModeOption>(
              title: Text(opt.name),
              value: opt, groupValue: state.themeMode,
              onChanged: (value) { cubit.updateThemeMode(value!); Navigator.pop(ctx); },
            )),
            const SizedBox(height: 16),
          ],
        ),
      ),
    );
  }
}
