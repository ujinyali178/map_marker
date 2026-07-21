import 'package:equatable/equatable.dart';

class WorkspaceModel extends Equatable {
  final String id;
  final String name;
  final DateTime createdAt;
  final bool isActive;

  const WorkspaceModel({
    required this.id,
    required this.name,
    required this.createdAt,
    this.isActive = false,
  });

  WorkspaceModel copyWith({
    String? id,
    String? name,
    DateTime? createdAt,
    bool? isActive,
  }) {
    return WorkspaceModel(
      id: id ?? this.id,
      name: name ?? this.name,
      createdAt: createdAt ?? this.createdAt,
      isActive: isActive ?? this.isActive,
    );
  }

  factory WorkspaceModel.fromJson(Map<String, dynamic> json) {
    return WorkspaceModel(
      id: json['id'] as String,
      name: json['name'] as String,
      createdAt: DateTime.parse(json['createdAt'] as String),
      isActive: json['isActive'] as bool? ?? false,
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'createdAt': createdAt.toIso8601String(),
      'isActive': isActive,
    };
  }

  @override
  List<Object?> get props => [id, name, createdAt, isActive];
}
