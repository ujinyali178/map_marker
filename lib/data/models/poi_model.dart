import 'package:equatable/equatable.dart';

class PoiModel extends Equatable {
  final String id;
  final String name;
  final String description;
  final double latitude;
  final double longitude;
  final int color;
  final String iconKey;
  final String? folderId;
  final List<String> images;
  final DateTime createdAt;
  final DateTime updatedAt;
  final bool isFavorite;
  final String note;

  const PoiModel({
    required this.id,
    required this.name,
    this.description = '',
    required this.latitude,
    required this.longitude,
    this.color = 0xFF4CAF50,
    this.iconKey = 'default',
    this.folderId,
    this.images = const [],
    required this.createdAt,
    required this.updatedAt,
    this.isFavorite = false,
    this.note = '',
  });

  PoiModel copyWith({
    String? id,
    String? name,
    String? description,
    double? latitude,
    double? longitude,
    int? color,
    String? iconKey,
    String? folderId,
    List<String>? images,
    DateTime? createdAt,
    DateTime? updatedAt,
    bool? isFavorite,
    String? note,
  }) {
    return PoiModel(
      id: id ?? this.id,
      name: name ?? this.name,
      description: description ?? this.description,
      latitude: latitude ?? this.latitude,
      longitude: longitude ?? this.longitude,
      color: color ?? this.color,
      iconKey: iconKey ?? this.iconKey,
      folderId: folderId ?? this.folderId,
      images: images ?? this.images,
      createdAt: createdAt ?? this.createdAt,
      updatedAt: updatedAt ?? this.updatedAt,
      isFavorite: isFavorite ?? this.isFavorite,
      note: note ?? this.note,
    );
  }

  factory PoiModel.fromJson(Map<String, dynamic> json) {
    return PoiModel(
      id: json['id'] as String,
      name: json['name'] as String,
      description: json['description'] as String? ?? '',
      latitude: (json['latitude'] as num).toDouble(),
      longitude: (json['longitude'] as num).toDouble(),
      color: json['color'] as int? ?? 0xFF4CAF50,
      iconKey: json['iconKey'] as String? ?? 'default',
      folderId: json['folderId'] as String?,
      images: (json['images'] as List<dynamic>?)
              ?.map((e) => e as String)
              .toList() ??
          [],
      createdAt: DateTime.parse(json['createdAt'] as String),
      updatedAt: DateTime.parse(json['updatedAt'] as String),
      isFavorite: json['isFavorite'] as bool? ?? false,
      note: json['note'] as String? ?? '',
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'description': description,
      'latitude': latitude,
      'longitude': longitude,
      'color': color,
      'iconKey': iconKey,
      'folderId': folderId,
      'images': images,
      'createdAt': createdAt.toIso8601String(),
      'updatedAt': updatedAt.toIso8601String(),
      'isFavorite': isFavorite,
      'note': note,
    };
  }

  @override
  List<Object?> get props => [
        id,
        name,
        description,
        latitude,
        longitude,
        color,
        iconKey,
        folderId,
        images,
        createdAt,
        updatedAt,
        isFavorite,
        note,
      ];
}
