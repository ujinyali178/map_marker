import 'package:collection/collection.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_colorpicker/flutter_colorpicker.dart';

import '../../../data/models/folder_model.dart';
import '../../bloc/folder_cubit/folder_cubit.dart';

class FolderEditorScreen extends StatefulWidget {
  final String? folderId;
  final String? parentId;

  const FolderEditorScreen({super.key, this.folderId, this.parentId});

  @override
  State<FolderEditorScreen> createState() => _FolderEditorScreenState();
}

class _FolderEditorScreenState extends State<FolderEditorScreen> {
  final _formKey = GlobalKey<FormState>();
  final _nameController = TextEditingController();
  Color _selectedColor = Colors.blue;
  bool _isSaving = false;

  @override
  void initState() {
    super.initState();
    if (widget.folderId != null) _loadFolderData();
  }

  void _loadFolderData() {
    final state = context.read<FolderCubit>().state;
    final folder = state.folders.where((f) => f.id == widget.folderId).isNotEmpty
        ? state.folders.firstWhere((f) => f.id == widget.folderId)
        : null;
    if (folder == null) return;
    _nameController.text = folder.name;
    _selectedColor = Color(folder.color);
  }

  @override
  void dispose() {
    _nameController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final isEditing = widget.folderId != null;

    return Scaffold(
      appBar: AppBar(
        title: Text(isEditing ? 'Edit Folder' : 'Folder Baru'),
        actions: [
          TextButton(
            onPressed: _isSaving ? null : _saveFolder,
            child: _isSaving
                ? const SizedBox(width: 20, height: 20, child: CircularProgressIndicator(strokeWidth: 2))
                : const Text('Simpan'),
          ),
        ],
      ),
      body: Form(
        key: _formKey,
        child: ListView(
          padding: const EdgeInsets.all(16),
          children: [
            Center(
              child: Container(
                padding: const EdgeInsets.symmetric(horizontal: 24, vertical: 16),
                decoration: BoxDecoration(
                  color: _selectedColor.withOpacity(0.1),
                  borderRadius: BorderRadius.circular(16),
                  border: Border.all(color: _selectedColor.withOpacity(0.3)),
                ),
                child: Column(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    Icon(Icons.folder, size: 48, color: _selectedColor),
                    const SizedBox(height: 8),
                    Text(
                      _nameController.text.isEmpty ? 'Nama Folder' : _nameController.text,
                      style: theme.textTheme.titleMedium?.copyWith(
                        fontWeight: FontWeight.bold,
                        color: _nameController.text.isEmpty ? theme.colorScheme.onSurface.withOpacity(0.3) : null,
                      ),
                    ),
                  ],
                ),
              ),
            ),
            const SizedBox(height: 32),
            TextFormField(
              controller: _nameController,
              decoration: InputDecoration(
                labelText: 'Nama Folder', hintText: 'Contoh: Wisata Jakarta',
                prefixIcon: const Icon(Icons.folder_outlined),
                border: OutlineInputBorder(borderRadius: BorderRadius.circular(12)),
              ),
              textCapitalization: TextCapitalization.words,
              onChanged: (_) => setState(() {}),
              validator: (value) => value == null || value.trim().isEmpty ? 'Nama folder harus diisi' : null,
            ),
            const SizedBox(height: 24),
            Text('Warna Folder', style: theme.textTheme.titleSmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.6))),
            const SizedBox(height: 8),
            Wrap(
              spacing: 8, runSpacing: 8,
              children: [
                Colors.red, Colors.pink, Colors.purple, Colors.deepPurple, Colors.indigo, Colors.blue,
                Colors.teal, Colors.green, Colors.lightGreen, Colors.orange, Colors.deepOrange, Colors.brown, Colors.grey, Colors.cyan,
              ].map((color) {
                final isSelected = _selectedColor.value == color.value;
                return GestureDetector(
                  onTap: () => setState(() => _selectedColor = color),
                  child: Container(
                    width: 44, height: 44,
                    decoration: BoxDecoration(
                      color: color, shape: BoxShape.circle,
                      border: isSelected ? Border.all(color: Colors.white, width: 3) : null,
                      boxShadow: isSelected ? [BoxShadow(color: color.withOpacity(0.5), blurRadius: 8, spreadRadius: 2)] : null,
                    ),
                    child: isSelected ? const Icon(Icons.check, color: Colors.white, size: 22) : null,
                  ),
                );
              }).toList()
                ..add(GestureDetector(
                  onTap: _showCustomColorPicker,
                  child: Container(
                    width: 44, height: 44,
                    decoration: BoxDecoration(
                      color: theme.colorScheme.surfaceContainerHighest, shape: BoxShape.circle,
                      border: Border.all(color: theme.colorScheme.outline.withOpacity(0.3)),
                    ),
                    child: Icon(Icons.colorize, color: theme.colorScheme.onSurface.withOpacity(0.5), size: 20),
                  ),
                )),
            ),
            const SizedBox(height: 32),
            FilledButton(
              onPressed: _isSaving ? null : _saveFolder,
              style: FilledButton.styleFrom(padding: const EdgeInsets.symmetric(vertical: 16), shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12))),
              child: _isSaving
                  ? const SizedBox(width: 24, height: 24, child: CircularProgressIndicator(strokeWidth: 2, color: Colors.white))
                  : Text(isEditing ? 'Perbarui Folder' : 'Buat Folder'),
            ),
          ],
        ),
      ),
    );
  }

  void _showCustomColorPicker() {
    Color pickerColor = _selectedColor;
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: const Text('Pilih Warna Kustom'),
        content: SingleChildScrollView(
          child: ColorPicker(
            pickerColor: pickerColor, onColorChanged: (color) => pickerColor = color,
            enableAlpha: false, labelTypes: const [],
          ),
        ),
        actions: [
          TextButton(onPressed: () => Navigator.pop(context), child: const Text('Batal')),
          FilledButton(onPressed: () { setState(() => _selectedColor = pickerColor); Navigator.pop(context); }, child: const Text('Pilih')),
        ],
      ),
    );
  }

  Future<void> _saveFolder() async {
    if (!_formKey.currentState!.validate()) return;
    setState(() => _isSaving = true);

    final cubit = context.read<FolderCubit>();
    if (widget.folderId != null) {
      final existing = cubit.state.folders.firstWhereOrNull((f) => f.id == widget.folderId);
      if (existing == null) {
        if (mounted) Navigator.of(context).pop();
        return;
      }
      await cubit.updateFolder(existing.copyWith(
        name: _nameController.text.trim(),
        color: _selectedColor.value,
      ));
    } else {
      await cubit.addFolder(cubit.createNewFolder(
        name: _nameController.text.trim(),
        color: _selectedColor.value,
        parentId: widget.parentId,
      ));
    }

    if (mounted) {
      setState(() => _isSaving = false);
      ScaffoldMessenger.of(context).showSnackBar(SnackBar(
        content: Text(widget.folderId != null ? 'Folder berhasil diperbarui' : 'Folder berhasil dibuat'),
        behavior: SnackBarBehavior.floating,
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
      ));
      Navigator.of(context).pop();
    }
  }
}
