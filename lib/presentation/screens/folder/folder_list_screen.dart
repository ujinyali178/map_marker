import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import '../../../data/models/folder_model.dart';
import '../../bloc/folder_cubit/folder_cubit.dart';
import '../../bloc/folder_cubit/folder_state.dart';

class FolderListScreen extends StatefulWidget {
  const FolderListScreen({super.key});

  @override
  State<FolderListScreen> createState() => _FolderListScreenState();
}

class _FolderListScreenState extends State<FolderListScreen> {
  @override
  void initState() {
    super.initState();
    context.read<FolderCubit>().loadFolders();
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);

    return Scaffold(
      appBar: AppBar(
        title: const Text('Folder'),
        actions: [
          IconButton(onPressed: _showSortOptions, icon: const Icon(Icons.sort), tooltip: 'Urutkan'),
        ],
      ),
      body: BlocBuilder<FolderCubit, FolderState>(
        builder: (context, state) {
          if (state.isLoading) return const Center(child: CircularProgressIndicator());
          if (state.folders.isEmpty) return _buildEmptyState(theme);
          return ListView.builder(
            padding: const EdgeInsets.symmetric(vertical: 8),
            itemCount: state.folders.length,
            itemBuilder: (context, index) => _buildFolderTile(state.folders[index], theme, state.folders.where((f) => f.parentId == state.folders[index].id).toList()),
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () => Navigator.of(context).pushNamed('/folder/editor'),
        child: const Icon(Icons.create_new_folder),
        tooltip: 'Buat Folder',
      ),
    );
  }

  Widget _buildEmptyState(ThemeData theme) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Icon(Icons.folder_off, size: 80, color: theme.colorScheme.onSurface.withOpacity(0.2)),
          const SizedBox(height: 16),
          Text('Belum ada folder', style: theme.textTheme.headlineSmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.4))),
          const SizedBox(height: 8),
          Text('Buat folder untuk mengorganisir POI Anda', style: theme.textTheme.bodyMedium?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.3))),
          const SizedBox(height: 24),
          FilledButton.icon(
            onPressed: () => Navigator.of(context).pushNamed('/folder/editor'),
            icon: const Icon(Icons.create_new_folder), label: const Text('Buat Folder'),
          ),
        ],
      ),
    );
  }

  Widget _buildFolderTile(FolderModel folder, ThemeData theme, List<FolderModel> subs) {
    final color = Color(folder.color);
    final hasSubfolders = subs.isNotEmpty;

    return ExpansionTile(
      leading: Container(
        width: 40, height: 40,
        decoration: BoxDecoration(color: color.withOpacity(0.15), borderRadius: BorderRadius.circular(10)),
        child: Icon(hasSubfolders ? Icons.folder : Icons.folder_outlined, color: color),
      ),
      title: Text(folder.name, style: theme.textTheme.bodyLarge?.copyWith(fontWeight: FontWeight.w500)),
      subtitle: Text('Folder', style: theme.textTheme.bodySmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.5))),
      trailing: hasSubfolders ? null : PopupMenuButton<String>(
        itemBuilder: (_) => <PopupMenuEntry<String>>[
          const PopupMenuItem(value: 'edit', child: ListTile(leading: Icon(Icons.edit), title: Text('Edit'), dense: true)),
          const PopupMenuDivider(),
          const PopupMenuItem(value: 'delete', child: ListTile(leading: Icon(Icons.delete, color: Colors.red), title: Text('Hapus', style: TextStyle(color: Colors.red)), dense: true)),
        ],
        onSelected: (value) => _handleFolderAction(folder, value),
      ),
      children: hasSubfolders
          ? [
              ...subs.map((sub) => ListTile(
                contentPadding: const EdgeInsets.only(left: 72, right: 16),
                leading: Container(
                  width: 32, height: 32,
                  decoration: BoxDecoration(color: color.withOpacity(0.1), borderRadius: BorderRadius.circular(8)),
                  child: Icon(Icons.folder_outlined, color: color, size: 18),
                ),
                title: Text(sub.name),
                onTap: () {},
              )),
              Padding(
                padding: const EdgeInsets.only(left: 72),
                child: ListTile(
                  leading: Icon(Icons.add, color: theme.colorScheme.primary, size: 20),
                  title: Text('Tambah Subfolder', style: TextStyle(color: theme.colorScheme.primary, fontSize: 14)),
                  onTap: () => Navigator.of(context).pushNamed('/folder/editor', arguments: {'parentId': folder.id}),
                ),
              ),
            ]
          : [],
    );
  }

  void _handleFolderAction(FolderModel folder, String action) {
    switch (action) {
      case 'edit':
        Navigator.of(context).pushNamed('/folder/editor', arguments: {'folderId': folder.id});
        break;
      case 'delete':
        _showDeleteConfirmation(folder);
        break;
    }
  }

  void _showDeleteConfirmation(FolderModel folder) {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: const Text('Hapus Folder?'),
        content: Text('Apakah Anda yakin ingin menghapus folder "${folder.name}"?'),
        actions: [
          TextButton(onPressed: () => Navigator.pop(context), child: const Text('Batal')),
          FilledButton(
            onPressed: () {
              Navigator.pop(context);
              context.read<FolderCubit>().deleteFolder(folder.id);
              ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                content: Text('Folder "${folder.name}" dihapus'), behavior: SnackBarBehavior.floating,
              ));
            },
            style: FilledButton.styleFrom(backgroundColor: Colors.red),
            child: const Text('Hapus'),
          ),
        ],
      ),
    );
  }

  void _showSortOptions() {
    showModalBottomSheet(
      context: context,
      builder: (_) => SafeArea(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            const SizedBox(height: 8),
            Container(width: 40, height: 4, decoration: BoxDecoration(color: Theme.of(context).colorScheme.onSurface.withOpacity(0.2), borderRadius: BorderRadius.circular(2))),
            const SizedBox(height: 16),
            Text('Urutkan Berdasarkan', style: Theme.of(context).textTheme.titleMedium),
            const SizedBox(height: 8),
            const ListTile(leading: Icon(Icons.sort_by_alpha), title: Text('Nama (A-Z)')),
            const ListTile(leading: Icon(Icons.calendar_today), title: Text('Terbaru')),
            const SizedBox(height: 16),
          ],
        ),
      ),
    );
  }
}
