import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import '../../../data/models/poi_model.dart';
import '../../../data/models/folder_model.dart';
import '../../bloc/poi_cubit/poi_cubit.dart';
import '../../bloc/poi_cubit/poi_state.dart';
import '../../bloc/folder_cubit/folder_cubit.dart';
import '../map/map_screen.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  int _currentNavIndex = 0;

  @override
  void initState() {
    super.initState();
    context.read<FolderCubit>().loadFolders();
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);

    return Scaffold(
      body: IndexedStack(
        index: _currentNavIndex,
        children: [
          const MapScreen(),
          _buildPoiListScreen(theme),
          _buildTracksScreen(theme),
          const SizedBox.shrink(),
        ],
      ),
      bottomNavigationBar: NavigationBar(
        selectedIndex: _currentNavIndex,
        onDestinationSelected: (index) {
          if (index == 3) {
            Navigator.of(context).pushNamed('/settings');
          } else {
            setState(() => _currentNavIndex = index);
          }
        },
        destinations: const [
          NavigationDestination(icon: Icon(Icons.map_outlined), selectedIcon: Icon(Icons.map), label: 'Peta'),
          NavigationDestination(icon: Icon(Icons.place_outlined), selectedIcon: Icon(Icons.place), label: 'POI'),
          NavigationDestination(icon: Icon(Icons.route_outlined), selectedIcon: Icon(Icons.route), label: 'Track'),
          NavigationDestination(icon: Icon(Icons.settings_outlined), selectedIcon: Icon(Icons.settings), label: 'Atur'),
        ],
      ),
      drawer: _buildDrawer(theme),
    );
  }

  Widget _buildDrawer(ThemeData theme) {
    return Drawer(
      child: SafeArea(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Container(
              padding: const EdgeInsets.fromLTRB(16, 24, 16, 16),
              decoration: BoxDecoration(color: theme.colorScheme.primaryContainer),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  CircleAvatar(
                    radius: 32,
                    backgroundColor: theme.colorScheme.primary,
                    child: Icon(Icons.person, size: 36, color: theme.colorScheme.onPrimary),
                  ),
                  const SizedBox(height: 12),
                  Text('MapMarker', style: theme.textTheme.headlineSmall?.copyWith(fontWeight: FontWeight.bold, color: theme.colorScheme.onPrimaryContainer)),
                  Text('Peta & POI Indonesia', style: theme.textTheme.bodyMedium?.copyWith(color: theme.colorScheme.onPrimaryContainer.withOpacity(0.7))),
                ],
              ),
            ),
            ListTile(leading: const Icon(Icons.map), title: const Text('Peta'), selected: _currentNavIndex == 0, onTap: () { setState(() => _currentNavIndex = 0); Navigator.pop(context); }),
            ListTile(leading: const Icon(Icons.place), title: const Text('POI Saya'), selected: _currentNavIndex == 1, onTap: () { setState(() => _currentNavIndex = 1); Navigator.pop(context); }),
            ListTile(leading: const Icon(Icons.folder_outlined), title: const Text('Folder'), onTap: () { Navigator.pop(context); Navigator.of(context).pushNamed('/folder/list'); }),
            ListTile(leading: const Icon(Icons.route), title: const Text('Track'), selected: _currentNavIndex == 2, onTap: () { setState(() => _currentNavIndex = 2); Navigator.pop(context); }),
            const Divider(),
            ListTile(leading: const Icon(Icons.search), title: const Text('Cari Lokasi'), onTap: () { Navigator.pop(context); Navigator.of(context).pushNamed('/search'); }),
            ListTile(leading: const Icon(Icons.sync), title: const Text('Sinkronisasi'), onTap: () { Navigator.pop(context); Navigator.of(context).pushNamed('/sync'); }),
            const Divider(),
            ListTile(leading: const Icon(Icons.settings), title: const Text('Pengaturan'), onTap: () { Navigator.pop(context); Navigator.of(context).pushNamed('/settings'); }),
            const Spacer(),
            Padding(padding: const EdgeInsets.all(16), child: Text('v1.0.0', style: theme.textTheme.bodySmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.3)), textAlign: TextAlign.center)),
          ],
        ),
      ),
    );
  }

  Widget _buildPoiListScreen(ThemeData theme) {
    return BlocBuilder<PoiCubit, PoiState>(
      builder: (context, state) {
        return Scaffold(
          appBar: AppBar(
            title: const Text('POI Saya'),
            actions: [
              IconButton(onPressed: () => Navigator.of(context).pushNamed('/search'), icon: const Icon(Icons.search)),
            ],
          ),
          body: state.isLoading
              ? const Center(child: CircularProgressIndicator())
              : state.pois.isEmpty
                  ? _buildEmptyPoiState(theme)
                  : ListView.builder(
                      padding: const EdgeInsets.symmetric(vertical: 8),
                      itemCount: state.pois.length,
                      itemBuilder: (context, index) {
                        final poi = state.pois[index];
                        return _buildPoiTile(poi, theme);
                      },
                    ),
          floatingActionButton: FloatingActionButton(
            onPressed: () => Navigator.of(context).pushNamed('/poi/editor'),
            child: const Icon(Icons.add),
            tooltip: 'Tambah POI',
          ),
        );
      },
    );
  }

  Widget _buildEmptyPoiState(ThemeData theme) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Icon(Icons.place_outlined, size: 80, color: theme.colorScheme.onSurface.withOpacity(0.15)),
          const SizedBox(height: 16),
          Text('Belum ada POI', style: theme.textTheme.headlineSmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.4))),
          const SizedBox(height: 8),
          Text('Tambah POI baru dari peta', style: theme.textTheme.bodyMedium?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.3))),
          const SizedBox(height: 24),
          FilledButton.icon(
            onPressed: () => Navigator.of(context).pushNamed('/poi/editor'),
            icon: const Icon(Icons.add),
            label: const Text('Tambah POI'),
          ),
        ],
      ),
    );
  }

  Widget _buildPoiTile(PoiModel poi, ThemeData theme) {
    final color = Color(poi.color);
    return ListTile(
      contentPadding: const EdgeInsets.symmetric(horizontal: 16, vertical: 4),
      leading: Container(
        width: 44,
        height: 44,
        decoration: BoxDecoration(color: color.withOpacity(0.12), borderRadius: BorderRadius.circular(10)),
        child: Icon(Icons.location_on, color: color),
      ),
      title: Text(poi.name, style: theme.textTheme.bodyLarge?.copyWith(fontWeight: FontWeight.w500)),
      subtitle: Text(
        poi.description.isNotEmpty ? poi.description : '${poi.latitude.toStringAsFixed(4)}, ${poi.longitude.toStringAsFixed(4)}',
        style: theme.textTheme.bodySmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.5)),
        maxLines: 1,
        overflow: TextOverflow.ellipsis,
      ),
      trailing: Row(
        mainAxisSize: MainAxisSize.min,
        children: [
          if (poi.isFavorite) Icon(Icons.favorite, color: Colors.red, size: 18),
          const Icon(Icons.chevron_right, size: 20),
        ],
      ),
      onTap: () => Navigator.of(context).pushNamed('/poi/detail', arguments: {'poiId': poi.id}),
    );
  }

  Widget _buildTracksScreen(ThemeData theme) {
    return Scaffold(
      appBar: AppBar(title: const Text('Track')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(Icons.route, size: 80, color: theme.colorScheme.onSurface.withOpacity(0.15)),
            const SizedBox(height: 16),
            Text('Rekam perjalanan Anda', style: theme.textTheme.headlineSmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.4))),
            const SizedBox(height: 8),
            Text('Mulai merekam track untuk melihat\nriwayat perjalanan di sini', textAlign: TextAlign.center, style: theme.textTheme.bodyMedium?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.3))),
            const SizedBox(height: 24),
            FilledButton.icon(
              onPressed: () => Navigator.of(context).pushNamed('/track/recording'),
              icon: const Icon(Icons.fiber_manual_record),
              label: const Text('Mulai Merekam'),
            ),
          ],
        ),
      ),
    );
  }
}
