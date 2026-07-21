import 'package:equatable/equatable.dart';

class FolderModel extends Equatable {
  final String id;
  final String name;
  final int color;
  final String? parentId;
  final DateTime createdAt;
  final int sortOrder;

  const FolderModel({
    required this.id,
    required this.name,
    this.color = 0xFF757575,
    this.parentId,
    required this.createdAt,
    this.sortOrder = 0,
  });

  FolderModel copyWith({
    String? id,
    String? name,
    int? color,
    String? parentId,
    DateTime? createdAt,
    int? sortOrder,
  }) {
    return FolderModel(
      id: id ?? this.id,
      name: name ?? this.name,
      color: color ?? this.color,
      parentId: parentId ?? this.parentId,
      createdAt: createdAt ?? this.createdAt,
      sortOrder: sortOrder ?? this.sortOrder,
    );
  }

  factory FolderModel.fromJson(Map<String, dynamic> json) {
    return FolderModel(
      id: json['id'] as String,
      name: json['name'] as String,
      color: json['color'] as int? ?? 0xFF757575,
      parentId: json['parentId'] as String?,
      createdAt: DateTime.parse(json['createdAt'] as String),
      sortOrder: json['sortOrder'] as int? ?? 0,
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'color': color,
      'parentId': parentId,
      'createdAt': createdAt.toIso8601String(),
      'sortOrder': sortOrder,
    };
  }

  @override
  List<Object?> get props => [
        id,
        name,
        color,
        parentId,
        createdAt,
        sortOrder,
      ];
}
