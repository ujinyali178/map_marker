import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:image_picker/image_picker.dart';
import 'package:flutter_colorpicker/flutter_colorpicker.dart';

import '../../../data/models/poi_model.dart';
import '../../../data/models/folder_model.dart';
import '../../bloc/poi_cubit/poi_cubit.dart';
import '../../bloc/folder_cubit/folder_cubit.dart';
import '../../bloc/folder_cubit/folder_state.dart';

class PoiEditorScreen extends StatefulWidget {
  final String? poiId;
  final double? initialLatitude;
  final double? initialLongitude;

  const PoiEditorScreen({
    super.key,
    this.poiId,
    this.initialLatitude,
    this.initialLongitude,
  });

  @override
  State<PoiEditorScreen> createState() => _PoiEditorScreenState();
}

class _PoiEditorScreenState extends State<PoiEditorScreen> {
  final _formKey = GlobalKey<FormState>();
  final _nameController = TextEditingController();
  final _descriptionController = TextEditingController();
  final _noteController = TextEditingController();

  Color _selectedColor = Colors.red;
  String _selectedIconKey = 'default';
  String? _selectedFolderId;
  double? _latitude;
  double? _longitude;
  final List<XFile> _images = [];
  final ImagePicker _picker = ImagePicker();
  bool _isSaving = false;

  static const _colorOptions = [
    Colors.red, Colors.pink, Colors.purple, Colors.deepPurple,
    Colors.indigo, Colors.blue, Colors.teal, Colors.green,
    Colors.lightGreen, Colors.orange, Colors.deepOrange, Colors.brown,
    Colors.grey, Colors.black, Colors.tealAccent, Colors.amber,
  ];

  final List<_IconOption> _availableIcons = [
    _IconOption('default', Icons.location_on),
    _IconOption('star', Icons.star),
    _IconOption('restaurant', Icons.restaurant),
    _IconOption('hotel', Icons.hotel),
    _IconOption('hospital', Icons.local_hospital),
    _IconOption('school', Icons.school),
    _IconOption('park', Icons.park),
  ];

  @override
  void initState() {
    super.initState();
    _latitude = widget.initialLatitude ?? -6.2088;
    _longitude = widget.initialLongitude ?? 106.8456;
    if (widget.poiId != null) _loadPoiData();
  }

  void _loadPoiData() {
    final state = context.read<PoiCubit>().state;
    final poi = state.pois.where((p) => p.id == widget.poiId).isNotEmpty
        ? state.pois.firstWhere((p) => p.id == widget.poiId)
        : null;
    if (poi == null) return;
    _nameController.text = poi.name;
    _descriptionController.text = poi.description;
    _noteController.text = poi.note;
    _selectedColor = Color(poi.color);
    _selectedIconKey = poi.iconKey;
    _selectedFolderId = poi.folderId;
    _latitude = poi.latitude;
    _longitude = poi.longitude;
  }

  @override
  void dispose() {
    _nameController.dispose();
    _descriptionController.dispose();
    _noteController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final isEditing = widget.poiId != null;

    return Scaffold(
      appBar: AppBar(
        title: Text(isEditing ? 'Edit POI' : 'Buat POI Baru'),
        actions: [
          TextButton(
            onPressed: _isSaving ? null : _savePoi,
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
            _buildImageSection(theme),
            const SizedBox(height: 16),
            TextFormField(
              controller: _nameController,
              decoration: InputDecoration(
                labelText: 'Nama POI', hintText: 'Contoh: Monas, Kota Tua',
                prefixIcon: const Icon(Icons.label_outline),
                border: OutlineInputBorder(borderRadius: BorderRadius.circular(12)),
              ),
              textCapitalization: TextCapitalization.words,
              validator: (value) => value == null || value.trim().isEmpty ? 'Nama POI harus diisi' : null,
            ),
            const SizedBox(height: 16),
            TextFormField(
              controller: _descriptionController,
              decoration: InputDecoration(
                labelText: 'Deskripsi', hintText: 'Deskripsi singkat tentang POI ini',
                prefixIcon: const Icon(Icons.description_outlined),
                border: OutlineInputBorder(borderRadius: BorderRadius.circular(12)),
              ),
              maxLines: 3, textCapitalization: TextCapitalization.sentences,
            ),
            const SizedBox(height: 16),
            TextFormField(
              controller: _noteController,
              decoration: InputDecoration(
                labelText: 'Catatan', hintText: 'Catatan pribadi tentang lokasi ini',
                prefixIcon: const Icon(Icons.note_outlined),
                border: OutlineInputBorder(borderRadius: BorderRadius.circular(12)),
              ),
              maxLines: 2, textCapitalization: TextCapitalization.sentences,
            ),
            const SizedBox(height: 24),
            _buildColorPicker(theme),
            const SizedBox(height: 24),
            _buildIconPicker(theme),
            const SizedBox(height: 24),
            _buildFolderSelector(theme),
            const SizedBox(height: 24),
            _buildCoordinatesSection(theme),
            const SizedBox(height: 32),
          ],
        ),
      ),
    );
  }

  Widget _buildImageSection(ThemeData theme) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text('Foto', style: theme.textTheme.titleSmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.6))),
        const SizedBox(height: 8),
        SizedBox(
          height: 160,
          child: ListView(
            scrollDirection: Axis.horizontal,
            children: [
              ..._images.map((img) => Padding(
                padding: const EdgeInsets.only(right: 8),
                child: Stack(
                  children: [
                    ClipRRect(
                      borderRadius: BorderRadius.circular(12),
                      child: Image.file(File(img.path), width: 160, height: 160, fit: BoxFit.cover),
                    ),
                    Positioned(
                      top: 4, right: 4,
                      child: GestureDetector(
                        onTap: () => setState(() => _images.remove(img)),
                        child: Container(
                          padding: const EdgeInsets.all(4),
                          decoration: BoxDecoration(color: Colors.black.withOpacity(0.6), shape: BoxShape.circle),
                          child: const Icon(Icons.close, color: Colors.white, size: 16),
                        ),
                      ),
                    ),
                  ],
                ),
              )),
              GestureDetector(
                onTap: _showImageSourceDialog,
                child: Container(
                  width: 160, height: 160,
                  decoration: BoxDecoration(
                    color: theme.colorScheme.surfaceContainerHighest,
                    borderRadius: BorderRadius.circular(12),
                    border: Border.all(color: theme.colorScheme.outline.withOpacity(0.3)),
                  ),
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Icon(Icons.add_a_photo_outlined, size: 36, color: theme.colorScheme.onSurface.withOpacity(0.5)),
                      const SizedBox(height: 8),
                      Text('Tambah Foto', style: theme.textTheme.bodySmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.5))),
                    ],
                  ),
                ),
              ),
            ],
          ),
        ),
      ],
    );
  }

  Widget _buildColorPicker(ThemeData theme) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text('Warna Marker', style: theme.textTheme.titleSmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.6))),
        const SizedBox(height: 8),
        Wrap(
          spacing: 8, runSpacing: 8,
          children: [
            ..._colorOptions.map((color) {
              final isSelected = _selectedColor.value == color.value;
              return GestureDetector(
                onTap: () => setState(() => _selectedColor = color),
                child: Container(
                  width: 40, height: 40,
                  decoration: BoxDecoration(
                    color: color, shape: BoxShape.circle,
                    border: isSelected ? Border.all(color: Colors.white, width: 3) : null,
                    boxShadow: isSelected ? [BoxShadow(color: color.withOpacity(0.5), blurRadius: 8, spreadRadius: 2)] : null,
                  ),
                  child: isSelected ? const Icon(Icons.check, color: Colors.white, size: 20) : null,
                ),
              );
            }),
            GestureDetector(
              onTap: _showCustomColorPicker,
              child: Container(
                width: 40, height: 40,
                decoration: BoxDecoration(
                  color: theme.colorScheme.surfaceContainerHighest, shape: BoxShape.circle,
                  border: Border.all(color: theme.colorScheme.outline.withOpacity(0.3)),
                ),
                child: Icon(Icons.colorize, color: theme.colorScheme.onSurface.withOpacity(0.5), size: 20),
              ),
            ),
          ],
        ),
      ],
    );
  }

  Widget _buildIconPicker(ThemeData theme) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text('Ikon Marker', style: theme.textTheme.titleSmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.6))),
        const SizedBox(height: 8),
        Container(
          decoration: BoxDecoration(
            border: Border.all(color: theme.colorScheme.outline.withOpacity(0.3)),
            borderRadius: BorderRadius.circular(12),
          ),
          padding: const EdgeInsets.all(12),
          child: GridView.builder(
            shrinkWrap: true, physics: const NeverScrollableScrollPhysics(),
            gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 7, mainAxisSpacing: 8, crossAxisSpacing: 8),
            itemCount: _availableIcons.length,
            itemBuilder: (context, index) {
              final icon = _availableIcons[index];
              final isSelected = _selectedIconKey == icon.key;
              return GestureDetector(
                onTap: () => setState(() => _selectedIconKey = icon.key),
                child: Container(
                  decoration: BoxDecoration(
                    color: isSelected ? _selectedColor.withOpacity(0.15) : Colors.transparent,
                    borderRadius: BorderRadius.circular(8),
                    border: isSelected ? Border.all(color: _selectedColor, width: 2) : null,
                  ),
                  child: Icon(icon.icon, color: isSelected ? _selectedColor : theme.colorScheme.onSurface.withOpacity(0.6), size: 22),
                ),
              );
            },
          ),
        ),
      ],
    );
  }

  Widget _buildFolderSelector(ThemeData theme) {
    return BlocBuilder<FolderCubit, FolderState>(
      builder: (context, folderState) {
        return DropdownButtonFormField<String>(
          value: _selectedFolderId,
          decoration: InputDecoration(
            labelText: 'Folder', hintText: 'Pilih folder (opsional)',
            prefixIcon: const Icon(Icons.folder_outlined),
            border: OutlineInputBorder(borderRadius: BorderRadius.circular(12)),
          ),
          items: [
            const DropdownMenuItem(value: null, child: Text('Tanpa folder')),
            ...folderState.folders.map((f) => DropdownMenuItem(value: f.id, child: Text(f.name))),
          ],
          onChanged: (value) => setState(() => _selectedFolderId = value),
        );
      },
    );
  }

  Widget _buildCoordinatesSection(ThemeData theme) {
    return Container(
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(
        color: theme.colorScheme.surfaceContainerHighest.withOpacity(0.3),
        borderRadius: BorderRadius.circular(12),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Row(
            children: [
              Icon(Icons.place, color: theme.colorScheme.primary, size: 20),
              const SizedBox(width: 8),
              Text('Lokasi', style: theme.textTheme.titleSmall?.copyWith(color: theme.colorScheme.onSurface.withOpacity(0.6))),
            ],
          ),
          const SizedBox(height: 8),
          Text('Lat: ${_latitude?.toStringAsFixed(6) ?? '-'}', style: theme.textTheme.bodyMedium?.copyWith(fontFamily: 'monospace')),
          Text('Lng: ${_longitude?.toStringAsFixed(6) ?? '-'}', style: theme.textTheme.bodyMedium?.copyWith(fontFamily: 'monospace')),
          const SizedBox(height: 12),
          OutlinedButton.icon(
            onPressed: _changeLocation,
            icon: const Icon(Icons.map, size: 18),
            label: const Text('Ubah Lokasi di Peta'),
            style: OutlinedButton.styleFrom(shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8))),
          ),
        ],
      ),
    );
  }

  void _showImageSourceDialog() {
    showModalBottomSheet(
      context: context,
      builder: (_) => SafeArea(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            const SizedBox(height: 8),
            Container(width: 40, height: 4, decoration: BoxDecoration(color: Theme.of(context).colorScheme.onSurface.withOpacity(0.2), borderRadius: BorderRadius.circular(2))),
            const SizedBox(height: 16),
            ListTile(
              leading: const Icon(Icons.camera_alt),
              title: const Text('Ambil Foto'),
              onTap: () async {
                Navigator.pop(context);
                final image = await _picker.pickImage(source: ImageSource.camera, maxWidth: 1920, maxHeight: 1920, imageQuality: 85);
                if (image != null) setState(() => _images.add(image));
              },
            ),
            ListTile(
              leading: const Icon(Icons.photo_library),
              title: const Text('Pilih dari Galeri'),
              onTap: () async {
                Navigator.pop(context);
                final images = await _picker.pickMultiImage(maxWidth: 1920, maxHeight: 1920, imageQuality: 85);
                if (images.isNotEmpty) setState(() => _images.addAll(images));
              },
            ),
            const SizedBox(height: 8),
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
            pickerColor: pickerColor,
            onColorChanged: (color) => pickerColor = color,
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

  void _changeLocation() async {
    final result = await Navigator.of(context).pushNamed('/map/select-location');
    if (result != null && result is Map<String, double>) {
      setState(() { _latitude = result['latitude']; _longitude = result['longitude']; });
    }
  }

  Future<void> _savePoi() async {
    if (!_formKey.currentState!.validate()) return;
    setState(() => _isSaving = true);

    final cubit = context.read<PoiCubit>();
    final images = _images.map((x) => x.path).toList();

    if (widget.poiId != null) {
      await cubit.updatePoi(PoiModel(
        id: widget.poiId!,
        name: _nameController.text.trim(),
        description: _descriptionController.text.trim(),
        latitude: _latitude!,
        longitude: _longitude!,
        color: _selectedColor.value,
        iconKey: _selectedIconKey,
        folderId: _selectedFolderId,
        images: images,
        createdAt: DateTime.now(),
        updatedAt: DateTime.now(),
      ));
    } else {
      await cubit.addPoi(cubit.createNewPoi(
        name: _nameController.text.trim(),
        description: _descriptionController.text.trim(),
        latitude: _latitude!,
        longitude: _longitude!,
        color: _selectedColor.value,
        iconKey: _selectedIconKey,
        folderId: _selectedFolderId,
        images: images,
      ));
    }

    if (mounted) {
      setState(() => _isSaving = false);
      ScaffoldMessenger.of(context).showSnackBar(SnackBar(
        content: Text(widget.poiId != null ? 'POI berhasil diperbarui' : 'POI berhasil disimpan'),
        behavior: SnackBarBehavior.floating,
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
      ));
      Navigator.of(context).pop();
    }
  }
}

class _IconOption {
  final String key;
  final IconData icon;
  const _IconOption(this.key, this.icon);
}
