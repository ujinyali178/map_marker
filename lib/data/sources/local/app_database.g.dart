// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'app_database.dart';

// ignore_for_file: type=lint
class $PoiTableTable extends PoiTable
    with TableInfo<$PoiTableTable, PoiTableData> {
  @override
  final GeneratedDatabase attachedDatabase;
  final String? _alias;
  $PoiTableTable(this.attachedDatabase, [this._alias]);
  static const VerificationMeta _idMeta = const VerificationMeta('id');
  @override
  late final GeneratedColumn<String> id = GeneratedColumn<String>(
    'id',
    aliasedName,
    false,
    type: DriftSqlType.string,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _nameMeta = const VerificationMeta('name');
  @override
  late final GeneratedColumn<String> name = GeneratedColumn<String>(
    'name',
    aliasedName,
    false,
    type: DriftSqlType.string,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _descriptionMeta = const VerificationMeta(
    'description',
  );
  @override
  late final GeneratedColumn<String> description = GeneratedColumn<String>(
    'description',
    aliasedName,
    false,
    type: DriftSqlType.string,
    requiredDuringInsert: false,
    defaultValue: const Constant(''),
  );
  static const VerificationMeta _latitudeMeta = const VerificationMeta(
    'latitude',
  );
  @override
  late final GeneratedColumn<double> latitude = GeneratedColumn<double>(
    'latitude',
    aliasedName,
    false,
    type: DriftSqlType.double,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _longitudeMeta = const VerificationMeta(
    'longitude',
  );
  @override
  late final GeneratedColumn<double> longitude = GeneratedColumn<double>(
    'longitude',
    aliasedName,
    false,
    type: DriftSqlType.double,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _colorMeta = const VerificationMeta('color');
  @override
  late final GeneratedColumn<int> color = GeneratedColumn<int>(
    'color',
    aliasedName,
    false,
    type: DriftSqlType.int,
    requiredDuringInsert: false,
    defaultValue: const Constant(0xFF4CAF50),
  );
  static const VerificationMeta _iconKeyMeta = const VerificationMeta(
    'iconKey',
  );
  @override
  late final GeneratedColumn<String> iconKey = GeneratedColumn<String>(
    'icon_key',
    aliasedName,
    false,
    type: DriftSqlType.string,
    requiredDuringInsert: false,
    defaultValue: const Constant('default'),
  );
  static const VerificationMeta _folderIdMeta = const VerificationMeta(
    'folderId',
  );
  @override
  late final GeneratedColumn<String> folderId = GeneratedColumn<String>(
    'folder_id',
    aliasedName,
    true,
    type: DriftSqlType.string,
    requiredDuringInsert: false,
  );
  static const VerificationMeta _imagesMeta = const VerificationMeta('images');
  @override
  late final GeneratedColumn<String> images = GeneratedColumn<String>(
    'images',
    aliasedName,
    false,
    type: DriftSqlType.string,
    requiredDuringInsert: false,
    defaultValue: const Constant('[]'),
  );
  static const VerificationMeta _createdAtMeta = const VerificationMeta(
    'createdAt',
  );
  @override
  late final GeneratedColumn<int> createdAt = GeneratedColumn<int>(
    'created_at',
    aliasedName,
    false,
    type: DriftSqlType.int,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _updatedAtMeta = const VerificationMeta(
    'updatedAt',
  );
  @override
  late final GeneratedColumn<int> updatedAt = GeneratedColumn<int>(
    'updated_at',
    aliasedName,
    false,
    type: DriftSqlType.int,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _isFavoriteMeta = const VerificationMeta(
    'isFavorite',
  );
  @override
  late final GeneratedColumn<int> isFavorite = GeneratedColumn<int>(
    'is_favorite',
    aliasedName,
    false,
    type: DriftSqlType.int,
    requiredDuringInsert: false,
    defaultValue: const Constant(0),
  );
  static const VerificationMeta _noteMeta = const VerificationMeta('note');
  @override
  late final GeneratedColumn<String> note = GeneratedColumn<String>(
    'note',
    aliasedName,
    false,
    type: DriftSqlType.string,
    requiredDuringInsert: false,
    defaultValue: const Constant(''),
  );
  @override
  List<GeneratedColumn> get $columns => [
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
  @override
  String get aliasedName => _alias ?? actualTableName;
  @override
  String get actualTableName => $name;
  static const String $name = 'poi_table';
  @override
  VerificationContext validateIntegrity(
    Insertable<PoiTableData> instance, {
    bool isInserting = false,
  }) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id')) {
      context.handle(_idMeta, id.isAcceptableOrUnknown(data['id']!, _idMeta));
    } else if (isInserting) {
      context.missing(_idMeta);
    }
    if (data.containsKey('name')) {
      context.handle(
        _nameMeta,
        name.isAcceptableOrUnknown(data['name']!, _nameMeta),
      );
    } else if (isInserting) {
      context.missing(_nameMeta);
    }
    if (data.containsKey('description')) {
      context.handle(
        _descriptionMeta,
        description.isAcceptableOrUnknown(
          data['description']!,
          _descriptionMeta,
        ),
      );
    }
    if (data.containsKey('latitude')) {
      context.handle(
        _latitudeMeta,
        latitude.isAcceptableOrUnknown(data['latitude']!, _latitudeMeta),
      );
    } else if (isInserting) {
      context.missing(_latitudeMeta);
    }
    if (data.containsKey('longitude')) {
      context.handle(
        _longitudeMeta,
        longitude.isAcceptableOrUnknown(data['longitude']!, _longitudeMeta),
      );
    } else if (isInserting) {
      context.missing(_longitudeMeta);
    }
    if (data.containsKey('color')) {
      context.handle(
        _colorMeta,
        color.isAcceptableOrUnknown(data['color']!, _colorMeta),
      );
    }
    if (data.containsKey('icon_key')) {
      context.handle(
        _iconKeyMeta,
        iconKey.isAcceptableOrUnknown(data['icon_key']!, _iconKeyMeta),
      );
    }
    if (data.containsKey('folder_id')) {
      context.handle(
        _folderIdMeta,
        folderId.isAcceptableOrUnknown(data['folder_id']!, _folderIdMeta),
      );
    }
    if (data.containsKey('images')) {
      context.handle(
        _imagesMeta,
        images.isAcceptableOrUnknown(data['images']!, _imagesMeta),
      );
    }
    if (data.containsKey('created_at')) {
      context.handle(
        _createdAtMeta,
        createdAt.isAcceptableOrUnknown(data['created_at']!, _createdAtMeta),
      );
    } else if (isInserting) {
      context.missing(_createdAtMeta);
    }
    if (data.containsKey('updated_at')) {
      context.handle(
        _updatedAtMeta,
        updatedAt.isAcceptableOrUnknown(data['updated_at']!, _updatedAtMeta),
      );
    } else if (isInserting) {
      context.missing(_updatedAtMeta);
    }
    if (data.containsKey('is_favorite')) {
      context.handle(
        _isFavoriteMeta,
        isFavorite.isAcceptableOrUnknown(data['is_favorite']!, _isFavoriteMeta),
      );
    }
    if (data.containsKey('note')) {
      context.handle(
        _noteMeta,
        note.isAcceptableOrUnknown(data['note']!, _noteMeta),
      );
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {id};
  @override
  PoiTableData map(Map<String, dynamic> data, {String? tablePrefix}) {
    final effectivePrefix = tablePrefix != null ? '$tablePrefix.' : '';
    return PoiTableData(
      id: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}id'],
      )!,
      name: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}name'],
      )!,
      description: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}description'],
      )!,
      latitude: attachedDatabase.typeMapping.read(
        DriftSqlType.double,
        data['${effectivePrefix}latitude'],
      )!,
      longitude: attachedDatabase.typeMapping.read(
        DriftSqlType.double,
        data['${effectivePrefix}longitude'],
      )!,
      color: attachedDatabase.typeMapping.read(
        DriftSqlType.int,
        data['${effectivePrefix}color'],
      )!,
      iconKey: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}icon_key'],
      )!,
      folderId: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}folder_id'],
      ),
      images: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}images'],
      )!,
      createdAt: attachedDatabase.typeMapping.read(
        DriftSqlType.int,
        data['${effectivePrefix}created_at'],
      )!,
      updatedAt: attachedDatabase.typeMapping.read(
        DriftSqlType.int,
        data['${effectivePrefix}updated_at'],
      )!,
      isFavorite: attachedDatabase.typeMapping.read(
        DriftSqlType.int,
        data['${effectivePrefix}is_favorite'],
      )!,
      note: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}note'],
      )!,
    );
  }

  @override
  $PoiTableTable createAlias(String alias) {
    return $PoiTableTable(attachedDatabase, alias);
  }
}

class PoiTableData extends DataClass implements Insertable<PoiTableData> {
  final String id;
  final String name;
  final String description;
  final double latitude;
  final double longitude;
  final int color;
  final String iconKey;
  final String? folderId;
  final String images;
  final int createdAt;
  final int updatedAt;
  final int isFavorite;
  final String note;
  const PoiTableData({
    required this.id,
    required this.name,
    required this.description,
    required this.latitude,
    required this.longitude,
    required this.color,
    required this.iconKey,
    this.folderId,
    required this.images,
    required this.createdAt,
    required this.updatedAt,
    required this.isFavorite,
    required this.note,
  });
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    map['id'] = Variable<String>(id);
    map['name'] = Variable<String>(name);
    map['description'] = Variable<String>(description);
    map['latitude'] = Variable<double>(latitude);
    map['longitude'] = Variable<double>(longitude);
    map['color'] = Variable<int>(color);
    map['icon_key'] = Variable<String>(iconKey);
    if (!nullToAbsent || folderId != null) {
      map['folder_id'] = Variable<String>(folderId);
    }
    map['images'] = Variable<String>(images);
    map['created_at'] = Variable<int>(createdAt);
    map['updated_at'] = Variable<int>(updatedAt);
    map['is_favorite'] = Variable<int>(isFavorite);
    map['note'] = Variable<String>(note);
    return map;
  }

  PoiTableCompanion toCompanion(bool nullToAbsent) {
    return PoiTableCompanion(
      id: Value(id),
      name: Value(name),
      description: Value(description),
      latitude: Value(latitude),
      longitude: Value(longitude),
      color: Value(color),
      iconKey: Value(iconKey),
      folderId: folderId == null && nullToAbsent
          ? const Value.absent()
          : Value(folderId),
      images: Value(images),
      createdAt: Value(createdAt),
      updatedAt: Value(updatedAt),
      isFavorite: Value(isFavorite),
      note: Value(note),
    );
  }

  factory PoiTableData.fromJson(
    Map<String, dynamic> json, {
    ValueSerializer? serializer,
  }) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return PoiTableData(
      id: serializer.fromJson<String>(json['id']),
      name: serializer.fromJson<String>(json['name']),
      description: serializer.fromJson<String>(json['description']),
      latitude: serializer.fromJson<double>(json['latitude']),
      longitude: serializer.fromJson<double>(json['longitude']),
      color: serializer.fromJson<int>(json['color']),
      iconKey: serializer.fromJson<String>(json['iconKey']),
      folderId: serializer.fromJson<String?>(json['folderId']),
      images: serializer.fromJson<String>(json['images']),
      createdAt: serializer.fromJson<int>(json['createdAt']),
      updatedAt: serializer.fromJson<int>(json['updatedAt']),
      isFavorite: serializer.fromJson<int>(json['isFavorite']),
      note: serializer.fromJson<String>(json['note']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'id': serializer.toJson<String>(id),
      'name': serializer.toJson<String>(name),
      'description': serializer.toJson<String>(description),
      'latitude': serializer.toJson<double>(latitude),
      'longitude': serializer.toJson<double>(longitude),
      'color': serializer.toJson<int>(color),
      'iconKey': serializer.toJson<String>(iconKey),
      'folderId': serializer.toJson<String?>(folderId),
      'images': serializer.toJson<String>(images),
      'createdAt': serializer.toJson<int>(createdAt),
      'updatedAt': serializer.toJson<int>(updatedAt),
      'isFavorite': serializer.toJson<int>(isFavorite),
      'note': serializer.toJson<String>(note),
    };
  }

  PoiTableData copyWith({
    String? id,
    String? name,
    String? description,
    double? latitude,
    double? longitude,
    int? color,
    String? iconKey,
    Value<String?> folderId = const Value.absent(),
    String? images,
    int? createdAt,
    int? updatedAt,
    int? isFavorite,
    String? note,
  }) => PoiTableData(
    id: id ?? this.id,
    name: name ?? this.name,
    description: description ?? this.description,
    latitude: latitude ?? this.latitude,
    longitude: longitude ?? this.longitude,
    color: color ?? this.color,
    iconKey: iconKey ?? this.iconKey,
    folderId: folderId.present ? folderId.value : this.folderId,
    images: images ?? this.images,
    createdAt: createdAt ?? this.createdAt,
    updatedAt: updatedAt ?? this.updatedAt,
    isFavorite: isFavorite ?? this.isFavorite,
    note: note ?? this.note,
  );
  PoiTableData copyWithCompanion(PoiTableCompanion data) {
    return PoiTableData(
      id: data.id.present ? data.id.value : this.id,
      name: data.name.present ? data.name.value : this.name,
      description: data.description.present
          ? data.description.value
          : this.description,
      latitude: data.latitude.present ? data.latitude.value : this.latitude,
      longitude: data.longitude.present ? data.longitude.value : this.longitude,
      color: data.color.present ? data.color.value : this.color,
      iconKey: data.iconKey.present ? data.iconKey.value : this.iconKey,
      folderId: data.folderId.present ? data.folderId.value : this.folderId,
      images: data.images.present ? data.images.value : this.images,
      createdAt: data.createdAt.present ? data.createdAt.value : this.createdAt,
      updatedAt: data.updatedAt.present ? data.updatedAt.value : this.updatedAt,
      isFavorite: data.isFavorite.present
          ? data.isFavorite.value
          : this.isFavorite,
      note: data.note.present ? data.note.value : this.note,
    );
  }

  @override
  String toString() {
    return (StringBuffer('PoiTableData(')
          ..write('id: $id, ')
          ..write('name: $name, ')
          ..write('description: $description, ')
          ..write('latitude: $latitude, ')
          ..write('longitude: $longitude, ')
          ..write('color: $color, ')
          ..write('iconKey: $iconKey, ')
          ..write('folderId: $folderId, ')
          ..write('images: $images, ')
          ..write('createdAt: $createdAt, ')
          ..write('updatedAt: $updatedAt, ')
          ..write('isFavorite: $isFavorite, ')
          ..write('note: $note')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode => Object.hash(
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
  );
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is PoiTableData &&
          other.id == this.id &&
          other.name == this.name &&
          other.description == this.description &&
          other.latitude == this.latitude &&
          other.longitude == this.longitude &&
          other.color == this.color &&
          other.iconKey == this.iconKey &&
          other.folderId == this.folderId &&
          other.images == this.images &&
          other.createdAt == this.createdAt &&
          other.updatedAt == this.updatedAt &&
          other.isFavorite == this.isFavorite &&
          other.note == this.note);
}

class PoiTableCompanion extends UpdateCompanion<PoiTableData> {
  final Value<String> id;
  final Value<String> name;
  final Value<String> description;
  final Value<double> latitude;
  final Value<double> longitude;
  final Value<int> color;
  final Value<String> iconKey;
  final Value<String?> folderId;
  final Value<String> images;
  final Value<int> createdAt;
  final Value<int> updatedAt;
  final Value<int> isFavorite;
  final Value<String> note;
  final Value<int> rowid;
  const PoiTableCompanion({
    this.id = const Value.absent(),
    this.name = const Value.absent(),
    this.description = const Value.absent(),
    this.latitude = const Value.absent(),
    this.longitude = const Value.absent(),
    this.color = const Value.absent(),
    this.iconKey = const Value.absent(),
    this.folderId = const Value.absent(),
    this.images = const Value.absent(),
    this.createdAt = const Value.absent(),
    this.updatedAt = const Value.absent(),
    this.isFavorite = const Value.absent(),
    this.note = const Value.absent(),
    this.rowid = const Value.absent(),
  });
  PoiTableCompanion.insert({
    required String id,
    required String name,
    this.description = const Value.absent(),
    required double latitude,
    required double longitude,
    this.color = const Value.absent(),
    this.iconKey = const Value.absent(),
    this.folderId = const Value.absent(),
    this.images = const Value.absent(),
    required int createdAt,
    required int updatedAt,
    this.isFavorite = const Value.absent(),
    this.note = const Value.absent(),
    this.rowid = const Value.absent(),
  }) : id = Value(id),
       name = Value(name),
       latitude = Value(latitude),
       longitude = Value(longitude),
       createdAt = Value(createdAt),
       updatedAt = Value(updatedAt);
  static Insertable<PoiTableData> custom({
    Expression<String>? id,
    Expression<String>? name,
    Expression<String>? description,
    Expression<double>? latitude,
    Expression<double>? longitude,
    Expression<int>? color,
    Expression<String>? iconKey,
    Expression<String>? folderId,
    Expression<String>? images,
    Expression<int>? createdAt,
    Expression<int>? updatedAt,
    Expression<int>? isFavorite,
    Expression<String>? note,
    Expression<int>? rowid,
  }) {
    return RawValuesInsertable({
      if (id != null) 'id': id,
      if (name != null) 'name': name,
      if (description != null) 'description': description,
      if (latitude != null) 'latitude': latitude,
      if (longitude != null) 'longitude': longitude,
      if (color != null) 'color': color,
      if (iconKey != null) 'icon_key': iconKey,
      if (folderId != null) 'folder_id': folderId,
      if (images != null) 'images': images,
      if (createdAt != null) 'created_at': createdAt,
      if (updatedAt != null) 'updated_at': updatedAt,
      if (isFavorite != null) 'is_favorite': isFavorite,
      if (note != null) 'note': note,
      if (rowid != null) 'rowid': rowid,
    });
  }

  PoiTableCompanion copyWith({
    Value<String>? id,
    Value<String>? name,
    Value<String>? description,
    Value<double>? latitude,
    Value<double>? longitude,
    Value<int>? color,
    Value<String>? iconKey,
    Value<String?>? folderId,
    Value<String>? images,
    Value<int>? createdAt,
    Value<int>? updatedAt,
    Value<int>? isFavorite,
    Value<String>? note,
    Value<int>? rowid,
  }) {
    return PoiTableCompanion(
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
      rowid: rowid ?? this.rowid,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (id.present) {
      map['id'] = Variable<String>(id.value);
    }
    if (name.present) {
      map['name'] = Variable<String>(name.value);
    }
    if (description.present) {
      map['description'] = Variable<String>(description.value);
    }
    if (latitude.present) {
      map['latitude'] = Variable<double>(latitude.value);
    }
    if (longitude.present) {
      map['longitude'] = Variable<double>(longitude.value);
    }
    if (color.present) {
      map['color'] = Variable<int>(color.value);
    }
    if (iconKey.present) {
      map['icon_key'] = Variable<String>(iconKey.value);
    }
    if (folderId.present) {
      map['folder_id'] = Variable<String>(folderId.value);
    }
    if (images.present) {
      map['images'] = Variable<String>(images.value);
    }
    if (createdAt.present) {
      map['created_at'] = Variable<int>(createdAt.value);
    }
    if (updatedAt.present) {
      map['updated_at'] = Variable<int>(updatedAt.value);
    }
    if (isFavorite.present) {
      map['is_favorite'] = Variable<int>(isFavorite.value);
    }
    if (note.present) {
      map['note'] = Variable<String>(note.value);
    }
    if (rowid.present) {
      map['rowid'] = Variable<int>(rowid.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('PoiTableCompanion(')
          ..write('id: $id, ')
          ..write('name: $name, ')
          ..write('description: $description, ')
          ..write('latitude: $latitude, ')
          ..write('longitude: $longitude, ')
          ..write('color: $color, ')
          ..write('iconKey: $iconKey, ')
          ..write('folderId: $folderId, ')
          ..write('images: $images, ')
          ..write('createdAt: $createdAt, ')
          ..write('updatedAt: $updatedAt, ')
          ..write('isFavorite: $isFavorite, ')
          ..write('note: $note, ')
          ..write('rowid: $rowid')
          ..write(')'))
        .toString();
  }
}

class $FolderTableTable extends FolderTable
    with TableInfo<$FolderTableTable, FolderTableData> {
  @override
  final GeneratedDatabase attachedDatabase;
  final String? _alias;
  $FolderTableTable(this.attachedDatabase, [this._alias]);
  static const VerificationMeta _idMeta = const VerificationMeta('id');
  @override
  late final GeneratedColumn<String> id = GeneratedColumn<String>(
    'id',
    aliasedName,
    false,
    type: DriftSqlType.string,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _nameMeta = const VerificationMeta('name');
  @override
  late final GeneratedColumn<String> name = GeneratedColumn<String>(
    'name',
    aliasedName,
    false,
    type: DriftSqlType.string,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _colorMeta = const VerificationMeta('color');
  @override
  late final GeneratedColumn<int> color = GeneratedColumn<int>(
    'color',
    aliasedName,
    false,
    type: DriftSqlType.int,
    requiredDuringInsert: false,
    defaultValue: const Constant(0xFF757575),
  );
  static const VerificationMeta _parentIdMeta = const VerificationMeta(
    'parentId',
  );
  @override
  late final GeneratedColumn<String> parentId = GeneratedColumn<String>(
    'parent_id',
    aliasedName,
    true,
    type: DriftSqlType.string,
    requiredDuringInsert: false,
  );
  static const VerificationMeta _createdAtMeta = const VerificationMeta(
    'createdAt',
  );
  @override
  late final GeneratedColumn<int> createdAt = GeneratedColumn<int>(
    'created_at',
    aliasedName,
    false,
    type: DriftSqlType.int,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _sortOrderMeta = const VerificationMeta(
    'sortOrder',
  );
  @override
  late final GeneratedColumn<int> sortOrder = GeneratedColumn<int>(
    'sort_order',
    aliasedName,
    false,
    type: DriftSqlType.int,
    requiredDuringInsert: false,
    defaultValue: const Constant(0),
  );
  @override
  List<GeneratedColumn> get $columns => [
    id,
    name,
    color,
    parentId,
    createdAt,
    sortOrder,
  ];
  @override
  String get aliasedName => _alias ?? actualTableName;
  @override
  String get actualTableName => $name;
  static const String $name = 'folder_table';
  @override
  VerificationContext validateIntegrity(
    Insertable<FolderTableData> instance, {
    bool isInserting = false,
  }) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id')) {
      context.handle(_idMeta, id.isAcceptableOrUnknown(data['id']!, _idMeta));
    } else if (isInserting) {
      context.missing(_idMeta);
    }
    if (data.containsKey('name')) {
      context.handle(
        _nameMeta,
        name.isAcceptableOrUnknown(data['name']!, _nameMeta),
      );
    } else if (isInserting) {
      context.missing(_nameMeta);
    }
    if (data.containsKey('color')) {
      context.handle(
        _colorMeta,
        color.isAcceptableOrUnknown(data['color']!, _colorMeta),
      );
    }
    if (data.containsKey('parent_id')) {
      context.handle(
        _parentIdMeta,
        parentId.isAcceptableOrUnknown(data['parent_id']!, _parentIdMeta),
      );
    }
    if (data.containsKey('created_at')) {
      context.handle(
        _createdAtMeta,
        createdAt.isAcceptableOrUnknown(data['created_at']!, _createdAtMeta),
      );
    } else if (isInserting) {
      context.missing(_createdAtMeta);
    }
    if (data.containsKey('sort_order')) {
      context.handle(
        _sortOrderMeta,
        sortOrder.isAcceptableOrUnknown(data['sort_order']!, _sortOrderMeta),
      );
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {id};
  @override
  FolderTableData map(Map<String, dynamic> data, {String? tablePrefix}) {
    final effectivePrefix = tablePrefix != null ? '$tablePrefix.' : '';
    return FolderTableData(
      id: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}id'],
      )!,
      name: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}name'],
      )!,
      color: attachedDatabase.typeMapping.read(
        DriftSqlType.int,
        data['${effectivePrefix}color'],
      )!,
      parentId: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}parent_id'],
      ),
      createdAt: attachedDatabase.typeMapping.read(
        DriftSqlType.int,
        data['${effectivePrefix}created_at'],
      )!,
      sortOrder: attachedDatabase.typeMapping.read(
        DriftSqlType.int,
        data['${effectivePrefix}sort_order'],
      )!,
    );
  }

  @override
  $FolderTableTable createAlias(String alias) {
    return $FolderTableTable(attachedDatabase, alias);
  }
}

class FolderTableData extends DataClass implements Insertable<FolderTableData> {
  final String id;
  final String name;
  final int color;
  final String? parentId;
  final int createdAt;
  final int sortOrder;
  const FolderTableData({
    required this.id,
    required this.name,
    required this.color,
    this.parentId,
    required this.createdAt,
    required this.sortOrder,
  });
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    map['id'] = Variable<String>(id);
    map['name'] = Variable<String>(name);
    map['color'] = Variable<int>(color);
    if (!nullToAbsent || parentId != null) {
      map['parent_id'] = Variable<String>(parentId);
    }
    map['created_at'] = Variable<int>(createdAt);
    map['sort_order'] = Variable<int>(sortOrder);
    return map;
  }

  FolderTableCompanion toCompanion(bool nullToAbsent) {
    return FolderTableCompanion(
      id: Value(id),
      name: Value(name),
      color: Value(color),
      parentId: parentId == null && nullToAbsent
          ? const Value.absent()
          : Value(parentId),
      createdAt: Value(createdAt),
      sortOrder: Value(sortOrder),
    );
  }

  factory FolderTableData.fromJson(
    Map<String, dynamic> json, {
    ValueSerializer? serializer,
  }) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return FolderTableData(
      id: serializer.fromJson<String>(json['id']),
      name: serializer.fromJson<String>(json['name']),
      color: serializer.fromJson<int>(json['color']),
      parentId: serializer.fromJson<String?>(json['parentId']),
      createdAt: serializer.fromJson<int>(json['createdAt']),
      sortOrder: serializer.fromJson<int>(json['sortOrder']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'id': serializer.toJson<String>(id),
      'name': serializer.toJson<String>(name),
      'color': serializer.toJson<int>(color),
      'parentId': serializer.toJson<String?>(parentId),
      'createdAt': serializer.toJson<int>(createdAt),
      'sortOrder': serializer.toJson<int>(sortOrder),
    };
  }

  FolderTableData copyWith({
    String? id,
    String? name,
    int? color,
    Value<String?> parentId = const Value.absent(),
    int? createdAt,
    int? sortOrder,
  }) => FolderTableData(
    id: id ?? this.id,
    name: name ?? this.name,
    color: color ?? this.color,
    parentId: parentId.present ? parentId.value : this.parentId,
    createdAt: createdAt ?? this.createdAt,
    sortOrder: sortOrder ?? this.sortOrder,
  );
  FolderTableData copyWithCompanion(FolderTableCompanion data) {
    return FolderTableData(
      id: data.id.present ? data.id.value : this.id,
      name: data.name.present ? data.name.value : this.name,
      color: data.color.present ? data.color.value : this.color,
      parentId: data.parentId.present ? data.parentId.value : this.parentId,
      createdAt: data.createdAt.present ? data.createdAt.value : this.createdAt,
      sortOrder: data.sortOrder.present ? data.sortOrder.value : this.sortOrder,
    );
  }

  @override
  String toString() {
    return (StringBuffer('FolderTableData(')
          ..write('id: $id, ')
          ..write('name: $name, ')
          ..write('color: $color, ')
          ..write('parentId: $parentId, ')
          ..write('createdAt: $createdAt, ')
          ..write('sortOrder: $sortOrder')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode =>
      Object.hash(id, name, color, parentId, createdAt, sortOrder);
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is FolderTableData &&
          other.id == this.id &&
          other.name == this.name &&
          other.color == this.color &&
          other.parentId == this.parentId &&
          other.createdAt == this.createdAt &&
          other.sortOrder == this.sortOrder);
}

class FolderTableCompanion extends UpdateCompanion<FolderTableData> {
  final Value<String> id;
  final Value<String> name;
  final Value<int> color;
  final Value<String?> parentId;
  final Value<int> createdAt;
  final Value<int> sortOrder;
  final Value<int> rowid;
  const FolderTableCompanion({
    this.id = const Value.absent(),
    this.name = const Value.absent(),
    this.color = const Value.absent(),
    this.parentId = const Value.absent(),
    this.createdAt = const Value.absent(),
    this.sortOrder = const Value.absent(),
    this.rowid = const Value.absent(),
  });
  FolderTableCompanion.insert({
    required String id,
    required String name,
    this.color = const Value.absent(),
    this.parentId = const Value.absent(),
    required int createdAt,
    this.sortOrder = const Value.absent(),
    this.rowid = const Value.absent(),
  }) : id = Value(id),
       name = Value(name),
       createdAt = Value(createdAt);
  static Insertable<FolderTableData> custom({
    Expression<String>? id,
    Expression<String>? name,
    Expression<int>? color,
    Expression<String>? parentId,
    Expression<int>? createdAt,
    Expression<int>? sortOrder,
    Expression<int>? rowid,
  }) {
    return RawValuesInsertable({
      if (id != null) 'id': id,
      if (name != null) 'name': name,
      if (color != null) 'color': color,
      if (parentId != null) 'parent_id': parentId,
      if (createdAt != null) 'created_at': createdAt,
      if (sortOrder != null) 'sort_order': sortOrder,
      if (rowid != null) 'rowid': rowid,
    });
  }

  FolderTableCompanion copyWith({
    Value<String>? id,
    Value<String>? name,
    Value<int>? color,
    Value<String?>? parentId,
    Value<int>? createdAt,
    Value<int>? sortOrder,
    Value<int>? rowid,
  }) {
    return FolderTableCompanion(
      id: id ?? this.id,
      name: name ?? this.name,
      color: color ?? this.color,
      parentId: parentId ?? this.parentId,
      createdAt: createdAt ?? this.createdAt,
      sortOrder: sortOrder ?? this.sortOrder,
      rowid: rowid ?? this.rowid,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (id.present) {
      map['id'] = Variable<String>(id.value);
    }
    if (name.present) {
      map['name'] = Variable<String>(name.value);
    }
    if (color.present) {
      map['color'] = Variable<int>(color.value);
    }
    if (parentId.present) {
      map['parent_id'] = Variable<String>(parentId.value);
    }
    if (createdAt.present) {
      map['created_at'] = Variable<int>(createdAt.value);
    }
    if (sortOrder.present) {
      map['sort_order'] = Variable<int>(sortOrder.value);
    }
    if (rowid.present) {
      map['rowid'] = Variable<int>(rowid.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('FolderTableCompanion(')
          ..write('id: $id, ')
          ..write('name: $name, ')
          ..write('color: $color, ')
          ..write('parentId: $parentId, ')
          ..write('createdAt: $createdAt, ')
          ..write('sortOrder: $sortOrder, ')
          ..write('rowid: $rowid')
          ..write(')'))
        .toString();
  }
}

class $WorkspaceTableTable extends WorkspaceTable
    with TableInfo<$WorkspaceTableTable, WorkspaceTableData> {
  @override
  final GeneratedDatabase attachedDatabase;
  final String? _alias;
  $WorkspaceTableTable(this.attachedDatabase, [this._alias]);
  static const VerificationMeta _idMeta = const VerificationMeta('id');
  @override
  late final GeneratedColumn<String> id = GeneratedColumn<String>(
    'id',
    aliasedName,
    false,
    type: DriftSqlType.string,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _nameMeta = const VerificationMeta('name');
  @override
  late final GeneratedColumn<String> name = GeneratedColumn<String>(
    'name',
    aliasedName,
    false,
    type: DriftSqlType.string,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _createdAtMeta = const VerificationMeta(
    'createdAt',
  );
  @override
  late final GeneratedColumn<int> createdAt = GeneratedColumn<int>(
    'created_at',
    aliasedName,
    false,
    type: DriftSqlType.int,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _isActiveMeta = const VerificationMeta(
    'isActive',
  );
  @override
  late final GeneratedColumn<int> isActive = GeneratedColumn<int>(
    'is_active',
    aliasedName,
    false,
    type: DriftSqlType.int,
    requiredDuringInsert: false,
    defaultValue: const Constant(0),
  );
  @override
  List<GeneratedColumn> get $columns => [id, name, createdAt, isActive];
  @override
  String get aliasedName => _alias ?? actualTableName;
  @override
  String get actualTableName => $name;
  static const String $name = 'workspace_table';
  @override
  VerificationContext validateIntegrity(
    Insertable<WorkspaceTableData> instance, {
    bool isInserting = false,
  }) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id')) {
      context.handle(_idMeta, id.isAcceptableOrUnknown(data['id']!, _idMeta));
    } else if (isInserting) {
      context.missing(_idMeta);
    }
    if (data.containsKey('name')) {
      context.handle(
        _nameMeta,
        name.isAcceptableOrUnknown(data['name']!, _nameMeta),
      );
    } else if (isInserting) {
      context.missing(_nameMeta);
    }
    if (data.containsKey('created_at')) {
      context.handle(
        _createdAtMeta,
        createdAt.isAcceptableOrUnknown(data['created_at']!, _createdAtMeta),
      );
    } else if (isInserting) {
      context.missing(_createdAtMeta);
    }
    if (data.containsKey('is_active')) {
      context.handle(
        _isActiveMeta,
        isActive.isAcceptableOrUnknown(data['is_active']!, _isActiveMeta),
      );
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {id};
  @override
  WorkspaceTableData map(Map<String, dynamic> data, {String? tablePrefix}) {
    final effectivePrefix = tablePrefix != null ? '$tablePrefix.' : '';
    return WorkspaceTableData(
      id: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}id'],
      )!,
      name: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}name'],
      )!,
      createdAt: attachedDatabase.typeMapping.read(
        DriftSqlType.int,
        data['${effectivePrefix}created_at'],
      )!,
      isActive: attachedDatabase.typeMapping.read(
        DriftSqlType.int,
        data['${effectivePrefix}is_active'],
      )!,
    );
  }

  @override
  $WorkspaceTableTable createAlias(String alias) {
    return $WorkspaceTableTable(attachedDatabase, alias);
  }
}

class WorkspaceTableData extends DataClass
    implements Insertable<WorkspaceTableData> {
  final String id;
  final String name;
  final int createdAt;
  final int isActive;
  const WorkspaceTableData({
    required this.id,
    required this.name,
    required this.createdAt,
    required this.isActive,
  });
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    map['id'] = Variable<String>(id);
    map['name'] = Variable<String>(name);
    map['created_at'] = Variable<int>(createdAt);
    map['is_active'] = Variable<int>(isActive);
    return map;
  }

  WorkspaceTableCompanion toCompanion(bool nullToAbsent) {
    return WorkspaceTableCompanion(
      id: Value(id),
      name: Value(name),
      createdAt: Value(createdAt),
      isActive: Value(isActive),
    );
  }

  factory WorkspaceTableData.fromJson(
    Map<String, dynamic> json, {
    ValueSerializer? serializer,
  }) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return WorkspaceTableData(
      id: serializer.fromJson<String>(json['id']),
      name: serializer.fromJson<String>(json['name']),
      createdAt: serializer.fromJson<int>(json['createdAt']),
      isActive: serializer.fromJson<int>(json['isActive']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'id': serializer.toJson<String>(id),
      'name': serializer.toJson<String>(name),
      'createdAt': serializer.toJson<int>(createdAt),
      'isActive': serializer.toJson<int>(isActive),
    };
  }

  WorkspaceTableData copyWith({
    String? id,
    String? name,
    int? createdAt,
    int? isActive,
  }) => WorkspaceTableData(
    id: id ?? this.id,
    name: name ?? this.name,
    createdAt: createdAt ?? this.createdAt,
    isActive: isActive ?? this.isActive,
  );
  WorkspaceTableData copyWithCompanion(WorkspaceTableCompanion data) {
    return WorkspaceTableData(
      id: data.id.present ? data.id.value : this.id,
      name: data.name.present ? data.name.value : this.name,
      createdAt: data.createdAt.present ? data.createdAt.value : this.createdAt,
      isActive: data.isActive.present ? data.isActive.value : this.isActive,
    );
  }

  @override
  String toString() {
    return (StringBuffer('WorkspaceTableData(')
          ..write('id: $id, ')
          ..write('name: $name, ')
          ..write('createdAt: $createdAt, ')
          ..write('isActive: $isActive')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode => Object.hash(id, name, createdAt, isActive);
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is WorkspaceTableData &&
          other.id == this.id &&
          other.name == this.name &&
          other.createdAt == this.createdAt &&
          other.isActive == this.isActive);
}

class WorkspaceTableCompanion extends UpdateCompanion<WorkspaceTableData> {
  final Value<String> id;
  final Value<String> name;
  final Value<int> createdAt;
  final Value<int> isActive;
  final Value<int> rowid;
  const WorkspaceTableCompanion({
    this.id = const Value.absent(),
    this.name = const Value.absent(),
    this.createdAt = const Value.absent(),
    this.isActive = const Value.absent(),
    this.rowid = const Value.absent(),
  });
  WorkspaceTableCompanion.insert({
    required String id,
    required String name,
    required int createdAt,
    this.isActive = const Value.absent(),
    this.rowid = const Value.absent(),
  }) : id = Value(id),
       name = Value(name),
       createdAt = Value(createdAt);
  static Insertable<WorkspaceTableData> custom({
    Expression<String>? id,
    Expression<String>? name,
    Expression<int>? createdAt,
    Expression<int>? isActive,
    Expression<int>? rowid,
  }) {
    return RawValuesInsertable({
      if (id != null) 'id': id,
      if (name != null) 'name': name,
      if (createdAt != null) 'created_at': createdAt,
      if (isActive != null) 'is_active': isActive,
      if (rowid != null) 'rowid': rowid,
    });
  }

  WorkspaceTableCompanion copyWith({
    Value<String>? id,
    Value<String>? name,
    Value<int>? createdAt,
    Value<int>? isActive,
    Value<int>? rowid,
  }) {
    return WorkspaceTableCompanion(
      id: id ?? this.id,
      name: name ?? this.name,
      createdAt: createdAt ?? this.createdAt,
      isActive: isActive ?? this.isActive,
      rowid: rowid ?? this.rowid,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (id.present) {
      map['id'] = Variable<String>(id.value);
    }
    if (name.present) {
      map['name'] = Variable<String>(name.value);
    }
    if (createdAt.present) {
      map['created_at'] = Variable<int>(createdAt.value);
    }
    if (isActive.present) {
      map['is_active'] = Variable<int>(isActive.value);
    }
    if (rowid.present) {
      map['rowid'] = Variable<int>(rowid.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('WorkspaceTableCompanion(')
          ..write('id: $id, ')
          ..write('name: $name, ')
          ..write('createdAt: $createdAt, ')
          ..write('isActive: $isActive, ')
          ..write('rowid: $rowid')
          ..write(')'))
        .toString();
  }
}

class $TrackTableTable extends TrackTable
    with TableInfo<$TrackTableTable, TrackTableData> {
  @override
  final GeneratedDatabase attachedDatabase;
  final String? _alias;
  $TrackTableTable(this.attachedDatabase, [this._alias]);
  static const VerificationMeta _idMeta = const VerificationMeta('id');
  @override
  late final GeneratedColumn<String> id = GeneratedColumn<String>(
    'id',
    aliasedName,
    false,
    type: DriftSqlType.string,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _nameMeta = const VerificationMeta('name');
  @override
  late final GeneratedColumn<String> name = GeneratedColumn<String>(
    'name',
    aliasedName,
    false,
    type: DriftSqlType.string,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _startedAtMeta = const VerificationMeta(
    'startedAt',
  );
  @override
  late final GeneratedColumn<int> startedAt = GeneratedColumn<int>(
    'started_at',
    aliasedName,
    false,
    type: DriftSqlType.int,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _finishedAtMeta = const VerificationMeta(
    'finishedAt',
  );
  @override
  late final GeneratedColumn<int> finishedAt = GeneratedColumn<int>(
    'finished_at',
    aliasedName,
    true,
    type: DriftSqlType.int,
    requiredDuringInsert: false,
  );
  static const VerificationMeta _distanceMetersMeta = const VerificationMeta(
    'distanceMeters',
  );
  @override
  late final GeneratedColumn<double> distanceMeters = GeneratedColumn<double>(
    'distance_meters',
    aliasedName,
    false,
    type: DriftSqlType.double,
    requiredDuringInsert: false,
    defaultValue: const Constant(0.0),
  );
  @override
  List<GeneratedColumn> get $columns => [
    id,
    name,
    startedAt,
    finishedAt,
    distanceMeters,
  ];
  @override
  String get aliasedName => _alias ?? actualTableName;
  @override
  String get actualTableName => $name;
  static const String $name = 'track_table';
  @override
  VerificationContext validateIntegrity(
    Insertable<TrackTableData> instance, {
    bool isInserting = false,
  }) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id')) {
      context.handle(_idMeta, id.isAcceptableOrUnknown(data['id']!, _idMeta));
    } else if (isInserting) {
      context.missing(_idMeta);
    }
    if (data.containsKey('name')) {
      context.handle(
        _nameMeta,
        name.isAcceptableOrUnknown(data['name']!, _nameMeta),
      );
    } else if (isInserting) {
      context.missing(_nameMeta);
    }
    if (data.containsKey('started_at')) {
      context.handle(
        _startedAtMeta,
        startedAt.isAcceptableOrUnknown(data['started_at']!, _startedAtMeta),
      );
    } else if (isInserting) {
      context.missing(_startedAtMeta);
    }
    if (data.containsKey('finished_at')) {
      context.handle(
        _finishedAtMeta,
        finishedAt.isAcceptableOrUnknown(data['finished_at']!, _finishedAtMeta),
      );
    }
    if (data.containsKey('distance_meters')) {
      context.handle(
        _distanceMetersMeta,
        distanceMeters.isAcceptableOrUnknown(
          data['distance_meters']!,
          _distanceMetersMeta,
        ),
      );
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {id};
  @override
  TrackTableData map(Map<String, dynamic> data, {String? tablePrefix}) {
    final effectivePrefix = tablePrefix != null ? '$tablePrefix.' : '';
    return TrackTableData(
      id: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}id'],
      )!,
      name: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}name'],
      )!,
      startedAt: attachedDatabase.typeMapping.read(
        DriftSqlType.int,
        data['${effectivePrefix}started_at'],
      )!,
      finishedAt: attachedDatabase.typeMapping.read(
        DriftSqlType.int,
        data['${effectivePrefix}finished_at'],
      ),
      distanceMeters: attachedDatabase.typeMapping.read(
        DriftSqlType.double,
        data['${effectivePrefix}distance_meters'],
      )!,
    );
  }

  @override
  $TrackTableTable createAlias(String alias) {
    return $TrackTableTable(attachedDatabase, alias);
  }
}

class TrackTableData extends DataClass implements Insertable<TrackTableData> {
  final String id;
  final String name;
  final int startedAt;
  final int? finishedAt;
  final double distanceMeters;
  const TrackTableData({
    required this.id,
    required this.name,
    required this.startedAt,
    this.finishedAt,
    required this.distanceMeters,
  });
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    map['id'] = Variable<String>(id);
    map['name'] = Variable<String>(name);
    map['started_at'] = Variable<int>(startedAt);
    if (!nullToAbsent || finishedAt != null) {
      map['finished_at'] = Variable<int>(finishedAt);
    }
    map['distance_meters'] = Variable<double>(distanceMeters);
    return map;
  }

  TrackTableCompanion toCompanion(bool nullToAbsent) {
    return TrackTableCompanion(
      id: Value(id),
      name: Value(name),
      startedAt: Value(startedAt),
      finishedAt: finishedAt == null && nullToAbsent
          ? const Value.absent()
          : Value(finishedAt),
      distanceMeters: Value(distanceMeters),
    );
  }

  factory TrackTableData.fromJson(
    Map<String, dynamic> json, {
    ValueSerializer? serializer,
  }) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return TrackTableData(
      id: serializer.fromJson<String>(json['id']),
      name: serializer.fromJson<String>(json['name']),
      startedAt: serializer.fromJson<int>(json['startedAt']),
      finishedAt: serializer.fromJson<int?>(json['finishedAt']),
      distanceMeters: serializer.fromJson<double>(json['distanceMeters']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'id': serializer.toJson<String>(id),
      'name': serializer.toJson<String>(name),
      'startedAt': serializer.toJson<int>(startedAt),
      'finishedAt': serializer.toJson<int?>(finishedAt),
      'distanceMeters': serializer.toJson<double>(distanceMeters),
    };
  }

  TrackTableData copyWith({
    String? id,
    String? name,
    int? startedAt,
    Value<int?> finishedAt = const Value.absent(),
    double? distanceMeters,
  }) => TrackTableData(
    id: id ?? this.id,
    name: name ?? this.name,
    startedAt: startedAt ?? this.startedAt,
    finishedAt: finishedAt.present ? finishedAt.value : this.finishedAt,
    distanceMeters: distanceMeters ?? this.distanceMeters,
  );
  TrackTableData copyWithCompanion(TrackTableCompanion data) {
    return TrackTableData(
      id: data.id.present ? data.id.value : this.id,
      name: data.name.present ? data.name.value : this.name,
      startedAt: data.startedAt.present ? data.startedAt.value : this.startedAt,
      finishedAt: data.finishedAt.present
          ? data.finishedAt.value
          : this.finishedAt,
      distanceMeters: data.distanceMeters.present
          ? data.distanceMeters.value
          : this.distanceMeters,
    );
  }

  @override
  String toString() {
    return (StringBuffer('TrackTableData(')
          ..write('id: $id, ')
          ..write('name: $name, ')
          ..write('startedAt: $startedAt, ')
          ..write('finishedAt: $finishedAt, ')
          ..write('distanceMeters: $distanceMeters')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode =>
      Object.hash(id, name, startedAt, finishedAt, distanceMeters);
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is TrackTableData &&
          other.id == this.id &&
          other.name == this.name &&
          other.startedAt == this.startedAt &&
          other.finishedAt == this.finishedAt &&
          other.distanceMeters == this.distanceMeters);
}

class TrackTableCompanion extends UpdateCompanion<TrackTableData> {
  final Value<String> id;
  final Value<String> name;
  final Value<int> startedAt;
  final Value<int?> finishedAt;
  final Value<double> distanceMeters;
  final Value<int> rowid;
  const TrackTableCompanion({
    this.id = const Value.absent(),
    this.name = const Value.absent(),
    this.startedAt = const Value.absent(),
    this.finishedAt = const Value.absent(),
    this.distanceMeters = const Value.absent(),
    this.rowid = const Value.absent(),
  });
  TrackTableCompanion.insert({
    required String id,
    required String name,
    required int startedAt,
    this.finishedAt = const Value.absent(),
    this.distanceMeters = const Value.absent(),
    this.rowid = const Value.absent(),
  }) : id = Value(id),
       name = Value(name),
       startedAt = Value(startedAt);
  static Insertable<TrackTableData> custom({
    Expression<String>? id,
    Expression<String>? name,
    Expression<int>? startedAt,
    Expression<int>? finishedAt,
    Expression<double>? distanceMeters,
    Expression<int>? rowid,
  }) {
    return RawValuesInsertable({
      if (id != null) 'id': id,
      if (name != null) 'name': name,
      if (startedAt != null) 'started_at': startedAt,
      if (finishedAt != null) 'finished_at': finishedAt,
      if (distanceMeters != null) 'distance_meters': distanceMeters,
      if (rowid != null) 'rowid': rowid,
    });
  }

  TrackTableCompanion copyWith({
    Value<String>? id,
    Value<String>? name,
    Value<int>? startedAt,
    Value<int?>? finishedAt,
    Value<double>? distanceMeters,
    Value<int>? rowid,
  }) {
    return TrackTableCompanion(
      id: id ?? this.id,
      name: name ?? this.name,
      startedAt: startedAt ?? this.startedAt,
      finishedAt: finishedAt ?? this.finishedAt,
      distanceMeters: distanceMeters ?? this.distanceMeters,
      rowid: rowid ?? this.rowid,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (id.present) {
      map['id'] = Variable<String>(id.value);
    }
    if (name.present) {
      map['name'] = Variable<String>(name.value);
    }
    if (startedAt.present) {
      map['started_at'] = Variable<int>(startedAt.value);
    }
    if (finishedAt.present) {
      map['finished_at'] = Variable<int>(finishedAt.value);
    }
    if (distanceMeters.present) {
      map['distance_meters'] = Variable<double>(distanceMeters.value);
    }
    if (rowid.present) {
      map['rowid'] = Variable<int>(rowid.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('TrackTableCompanion(')
          ..write('id: $id, ')
          ..write('name: $name, ')
          ..write('startedAt: $startedAt, ')
          ..write('finishedAt: $finishedAt, ')
          ..write('distanceMeters: $distanceMeters, ')
          ..write('rowid: $rowid')
          ..write(')'))
        .toString();
  }
}

class $TrackPointTableTable extends TrackPointTable
    with TableInfo<$TrackPointTableTable, TrackPointTableData> {
  @override
  final GeneratedDatabase attachedDatabase;
  final String? _alias;
  $TrackPointTableTable(this.attachedDatabase, [this._alias]);
  static const VerificationMeta _idMeta = const VerificationMeta('id');
  @override
  late final GeneratedColumn<int> id = GeneratedColumn<int>(
    'id',
    aliasedName,
    false,
    hasAutoIncrement: true,
    type: DriftSqlType.int,
    requiredDuringInsert: false,
    defaultConstraints: GeneratedColumn.constraintIsAlways(
      'PRIMARY KEY AUTOINCREMENT',
    ),
  );
  static const VerificationMeta _trackIdMeta = const VerificationMeta(
    'trackId',
  );
  @override
  late final GeneratedColumn<String> trackId = GeneratedColumn<String>(
    'track_id',
    aliasedName,
    false,
    type: DriftSqlType.string,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _latitudeMeta = const VerificationMeta(
    'latitude',
  );
  @override
  late final GeneratedColumn<double> latitude = GeneratedColumn<double>(
    'latitude',
    aliasedName,
    false,
    type: DriftSqlType.double,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _longitudeMeta = const VerificationMeta(
    'longitude',
  );
  @override
  late final GeneratedColumn<double> longitude = GeneratedColumn<double>(
    'longitude',
    aliasedName,
    false,
    type: DriftSqlType.double,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _altitudeMeta = const VerificationMeta(
    'altitude',
  );
  @override
  late final GeneratedColumn<double> altitude = GeneratedColumn<double>(
    'altitude',
    aliasedName,
    true,
    type: DriftSqlType.double,
    requiredDuringInsert: false,
  );
  static const VerificationMeta _timestampMeta = const VerificationMeta(
    'timestamp',
  );
  @override
  late final GeneratedColumn<int> timestamp = GeneratedColumn<int>(
    'timestamp',
    aliasedName,
    false,
    type: DriftSqlType.int,
    requiredDuringInsert: true,
  );
  static const VerificationMeta _speedMeta = const VerificationMeta('speed');
  @override
  late final GeneratedColumn<double> speed = GeneratedColumn<double>(
    'speed',
    aliasedName,
    true,
    type: DriftSqlType.double,
    requiredDuringInsert: false,
  );
  @override
  List<GeneratedColumn> get $columns => [
    id,
    trackId,
    latitude,
    longitude,
    altitude,
    timestamp,
    speed,
  ];
  @override
  String get aliasedName => _alias ?? actualTableName;
  @override
  String get actualTableName => $name;
  static const String $name = 'track_point_table';
  @override
  VerificationContext validateIntegrity(
    Insertable<TrackPointTableData> instance, {
    bool isInserting = false,
  }) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id')) {
      context.handle(_idMeta, id.isAcceptableOrUnknown(data['id']!, _idMeta));
    }
    if (data.containsKey('track_id')) {
      context.handle(
        _trackIdMeta,
        trackId.isAcceptableOrUnknown(data['track_id']!, _trackIdMeta),
      );
    } else if (isInserting) {
      context.missing(_trackIdMeta);
    }
    if (data.containsKey('latitude')) {
      context.handle(
        _latitudeMeta,
        latitude.isAcceptableOrUnknown(data['latitude']!, _latitudeMeta),
      );
    } else if (isInserting) {
      context.missing(_latitudeMeta);
    }
    if (data.containsKey('longitude')) {
      context.handle(
        _longitudeMeta,
        longitude.isAcceptableOrUnknown(data['longitude']!, _longitudeMeta),
      );
    } else if (isInserting) {
      context.missing(_longitudeMeta);
    }
    if (data.containsKey('altitude')) {
      context.handle(
        _altitudeMeta,
        altitude.isAcceptableOrUnknown(data['altitude']!, _altitudeMeta),
      );
    }
    if (data.containsKey('timestamp')) {
      context.handle(
        _timestampMeta,
        timestamp.isAcceptableOrUnknown(data['timestamp']!, _timestampMeta),
      );
    } else if (isInserting) {
      context.missing(_timestampMeta);
    }
    if (data.containsKey('speed')) {
      context.handle(
        _speedMeta,
        speed.isAcceptableOrUnknown(data['speed']!, _speedMeta),
      );
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {id};
  @override
  TrackPointTableData map(Map<String, dynamic> data, {String? tablePrefix}) {
    final effectivePrefix = tablePrefix != null ? '$tablePrefix.' : '';
    return TrackPointTableData(
      id: attachedDatabase.typeMapping.read(
        DriftSqlType.int,
        data['${effectivePrefix}id'],
      )!,
      trackId: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}track_id'],
      )!,
      latitude: attachedDatabase.typeMapping.read(
        DriftSqlType.double,
        data['${effectivePrefix}latitude'],
      )!,
      longitude: attachedDatabase.typeMapping.read(
        DriftSqlType.double,
        data['${effectivePrefix}longitude'],
      )!,
      altitude: attachedDatabase.typeMapping.read(
        DriftSqlType.double,
        data['${effectivePrefix}altitude'],
      ),
      timestamp: attachedDatabase.typeMapping.read(
        DriftSqlType.int,
        data['${effectivePrefix}timestamp'],
      )!,
      speed: attachedDatabase.typeMapping.read(
        DriftSqlType.double,
        data['${effectivePrefix}speed'],
      ),
    );
  }

  @override
  $TrackPointTableTable createAlias(String alias) {
    return $TrackPointTableTable(attachedDatabase, alias);
  }
}

class TrackPointTableData extends DataClass
    implements Insertable<TrackPointTableData> {
  final int id;
  final String trackId;
  final double latitude;
  final double longitude;
  final double? altitude;
  final int timestamp;
  final double? speed;
  const TrackPointTableData({
    required this.id,
    required this.trackId,
    required this.latitude,
    required this.longitude,
    this.altitude,
    required this.timestamp,
    this.speed,
  });
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    map['id'] = Variable<int>(id);
    map['track_id'] = Variable<String>(trackId);
    map['latitude'] = Variable<double>(latitude);
    map['longitude'] = Variable<double>(longitude);
    if (!nullToAbsent || altitude != null) {
      map['altitude'] = Variable<double>(altitude);
    }
    map['timestamp'] = Variable<int>(timestamp);
    if (!nullToAbsent || speed != null) {
      map['speed'] = Variable<double>(speed);
    }
    return map;
  }

  TrackPointTableCompanion toCompanion(bool nullToAbsent) {
    return TrackPointTableCompanion(
      id: Value(id),
      trackId: Value(trackId),
      latitude: Value(latitude),
      longitude: Value(longitude),
      altitude: altitude == null && nullToAbsent
          ? const Value.absent()
          : Value(altitude),
      timestamp: Value(timestamp),
      speed: speed == null && nullToAbsent
          ? const Value.absent()
          : Value(speed),
    );
  }

  factory TrackPointTableData.fromJson(
    Map<String, dynamic> json, {
    ValueSerializer? serializer,
  }) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return TrackPointTableData(
      id: serializer.fromJson<int>(json['id']),
      trackId: serializer.fromJson<String>(json['trackId']),
      latitude: serializer.fromJson<double>(json['latitude']),
      longitude: serializer.fromJson<double>(json['longitude']),
      altitude: serializer.fromJson<double?>(json['altitude']),
      timestamp: serializer.fromJson<int>(json['timestamp']),
      speed: serializer.fromJson<double?>(json['speed']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'id': serializer.toJson<int>(id),
      'trackId': serializer.toJson<String>(trackId),
      'latitude': serializer.toJson<double>(latitude),
      'longitude': serializer.toJson<double>(longitude),
      'altitude': serializer.toJson<double?>(altitude),
      'timestamp': serializer.toJson<int>(timestamp),
      'speed': serializer.toJson<double?>(speed),
    };
  }

  TrackPointTableData copyWith({
    int? id,
    String? trackId,
    double? latitude,
    double? longitude,
    Value<double?> altitude = const Value.absent(),
    int? timestamp,
    Value<double?> speed = const Value.absent(),
  }) => TrackPointTableData(
    id: id ?? this.id,
    trackId: trackId ?? this.trackId,
    latitude: latitude ?? this.latitude,
    longitude: longitude ?? this.longitude,
    altitude: altitude.present ? altitude.value : this.altitude,
    timestamp: timestamp ?? this.timestamp,
    speed: speed.present ? speed.value : this.speed,
  );
  TrackPointTableData copyWithCompanion(TrackPointTableCompanion data) {
    return TrackPointTableData(
      id: data.id.present ? data.id.value : this.id,
      trackId: data.trackId.present ? data.trackId.value : this.trackId,
      latitude: data.latitude.present ? data.latitude.value : this.latitude,
      longitude: data.longitude.present ? data.longitude.value : this.longitude,
      altitude: data.altitude.present ? data.altitude.value : this.altitude,
      timestamp: data.timestamp.present ? data.timestamp.value : this.timestamp,
      speed: data.speed.present ? data.speed.value : this.speed,
    );
  }

  @override
  String toString() {
    return (StringBuffer('TrackPointTableData(')
          ..write('id: $id, ')
          ..write('trackId: $trackId, ')
          ..write('latitude: $latitude, ')
          ..write('longitude: $longitude, ')
          ..write('altitude: $altitude, ')
          ..write('timestamp: $timestamp, ')
          ..write('speed: $speed')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode =>
      Object.hash(id, trackId, latitude, longitude, altitude, timestamp, speed);
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is TrackPointTableData &&
          other.id == this.id &&
          other.trackId == this.trackId &&
          other.latitude == this.latitude &&
          other.longitude == this.longitude &&
          other.altitude == this.altitude &&
          other.timestamp == this.timestamp &&
          other.speed == this.speed);
}

class TrackPointTableCompanion extends UpdateCompanion<TrackPointTableData> {
  final Value<int> id;
  final Value<String> trackId;
  final Value<double> latitude;
  final Value<double> longitude;
  final Value<double?> altitude;
  final Value<int> timestamp;
  final Value<double?> speed;
  const TrackPointTableCompanion({
    this.id = const Value.absent(),
    this.trackId = const Value.absent(),
    this.latitude = const Value.absent(),
    this.longitude = const Value.absent(),
    this.altitude = const Value.absent(),
    this.timestamp = const Value.absent(),
    this.speed = const Value.absent(),
  });
  TrackPointTableCompanion.insert({
    this.id = const Value.absent(),
    required String trackId,
    required double latitude,
    required double longitude,
    this.altitude = const Value.absent(),
    required int timestamp,
    this.speed = const Value.absent(),
  }) : trackId = Value(trackId),
       latitude = Value(latitude),
       longitude = Value(longitude),
       timestamp = Value(timestamp);
  static Insertable<TrackPointTableData> custom({
    Expression<int>? id,
    Expression<String>? trackId,
    Expression<double>? latitude,
    Expression<double>? longitude,
    Expression<double>? altitude,
    Expression<int>? timestamp,
    Expression<double>? speed,
  }) {
    return RawValuesInsertable({
      if (id != null) 'id': id,
      if (trackId != null) 'track_id': trackId,
      if (latitude != null) 'latitude': latitude,
      if (longitude != null) 'longitude': longitude,
      if (altitude != null) 'altitude': altitude,
      if (timestamp != null) 'timestamp': timestamp,
      if (speed != null) 'speed': speed,
    });
  }

  TrackPointTableCompanion copyWith({
    Value<int>? id,
    Value<String>? trackId,
    Value<double>? latitude,
    Value<double>? longitude,
    Value<double?>? altitude,
    Value<int>? timestamp,
    Value<double?>? speed,
  }) {
    return TrackPointTableCompanion(
      id: id ?? this.id,
      trackId: trackId ?? this.trackId,
      latitude: latitude ?? this.latitude,
      longitude: longitude ?? this.longitude,
      altitude: altitude ?? this.altitude,
      timestamp: timestamp ?? this.timestamp,
      speed: speed ?? this.speed,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (id.present) {
      map['id'] = Variable<int>(id.value);
    }
    if (trackId.present) {
      map['track_id'] = Variable<String>(trackId.value);
    }
    if (latitude.present) {
      map['latitude'] = Variable<double>(latitude.value);
    }
    if (longitude.present) {
      map['longitude'] = Variable<double>(longitude.value);
    }
    if (altitude.present) {
      map['altitude'] = Variable<double>(altitude.value);
    }
    if (timestamp.present) {
      map['timestamp'] = Variable<int>(timestamp.value);
    }
    if (speed.present) {
      map['speed'] = Variable<double>(speed.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('TrackPointTableCompanion(')
          ..write('id: $id, ')
          ..write('trackId: $trackId, ')
          ..write('latitude: $latitude, ')
          ..write('longitude: $longitude, ')
          ..write('altitude: $altitude, ')
          ..write('timestamp: $timestamp, ')
          ..write('speed: $speed')
          ..write(')'))
        .toString();
  }
}

class $SyncStateTableTable extends SyncStateTable
    with TableInfo<$SyncStateTableTable, SyncStateTableData> {
  @override
  final GeneratedDatabase attachedDatabase;
  final String? _alias;
  $SyncStateTableTable(this.attachedDatabase, [this._alias]);
  static const VerificationMeta _idMeta = const VerificationMeta('id');
  @override
  late final GeneratedColumn<int> id = GeneratedColumn<int>(
    'id',
    aliasedName,
    false,
    type: DriftSqlType.int,
    requiredDuringInsert: false,
  );
  static const VerificationMeta _interfaceTypeMeta = const VerificationMeta(
    'interfaceType',
  );
  @override
  late final GeneratedColumn<String> interfaceType = GeneratedColumn<String>(
    'interface_type',
    aliasedName,
    false,
    type: DriftSqlType.string,
    requiredDuringInsert: false,
    defaultValue: const Constant('none'),
  );
  static const VerificationMeta _accountNameMeta = const VerificationMeta(
    'accountName',
  );
  @override
  late final GeneratedColumn<String> accountName = GeneratedColumn<String>(
    'account_name',
    aliasedName,
    false,
    type: DriftSqlType.string,
    requiredDuringInsert: false,
    defaultValue: const Constant(''),
  );
  static const VerificationMeta _cloudFolderIdMeta = const VerificationMeta(
    'cloudFolderId',
  );
  @override
  late final GeneratedColumn<String> cloudFolderId = GeneratedColumn<String>(
    'cloud_folder_id',
    aliasedName,
    false,
    type: DriftSqlType.string,
    requiredDuringInsert: false,
    defaultValue: const Constant(''),
  );
  static const VerificationMeta _lastSyncTimeMeta = const VerificationMeta(
    'lastSyncTime',
  );
  @override
  late final GeneratedColumn<int> lastSyncTime = GeneratedColumn<int>(
    'last_sync_time',
    aliasedName,
    true,
    type: DriftSqlType.int,
    requiredDuringInsert: false,
  );
  static const VerificationMeta _hasRemoteChangesMeta = const VerificationMeta(
    'hasRemoteChanges',
  );
  @override
  late final GeneratedColumn<int> hasRemoteChanges = GeneratedColumn<int>(
    'has_remote_changes',
    aliasedName,
    false,
    type: DriftSqlType.int,
    requiredDuringInsert: false,
    defaultValue: const Constant(0),
  );
  static const VerificationMeta _isReadOnlyMeta = const VerificationMeta(
    'isReadOnly',
  );
  @override
  late final GeneratedColumn<int> isReadOnly = GeneratedColumn<int>(
    'is_read_only',
    aliasedName,
    false,
    type: DriftSqlType.int,
    requiredDuringInsert: false,
    defaultValue: const Constant(0),
  );
  static const VerificationMeta _shareUrlMeta = const VerificationMeta(
    'shareUrl',
  );
  @override
  late final GeneratedColumn<String> shareUrl = GeneratedColumn<String>(
    'share_url',
    aliasedName,
    false,
    type: DriftSqlType.string,
    requiredDuringInsert: false,
    defaultValue: const Constant(''),
  );
  @override
  List<GeneratedColumn> get $columns => [
    id,
    interfaceType,
    accountName,
    cloudFolderId,
    lastSyncTime,
    hasRemoteChanges,
    isReadOnly,
    shareUrl,
  ];
  @override
  String get aliasedName => _alias ?? actualTableName;
  @override
  String get actualTableName => $name;
  static const String $name = 'sync_state_table';
  @override
  VerificationContext validateIntegrity(
    Insertable<SyncStateTableData> instance, {
    bool isInserting = false,
  }) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id')) {
      context.handle(_idMeta, id.isAcceptableOrUnknown(data['id']!, _idMeta));
    }
    if (data.containsKey('interface_type')) {
      context.handle(
        _interfaceTypeMeta,
        interfaceType.isAcceptableOrUnknown(
          data['interface_type']!,
          _interfaceTypeMeta,
        ),
      );
    }
    if (data.containsKey('account_name')) {
      context.handle(
        _accountNameMeta,
        accountName.isAcceptableOrUnknown(
          data['account_name']!,
          _accountNameMeta,
        ),
      );
    }
    if (data.containsKey('cloud_folder_id')) {
      context.handle(
        _cloudFolderIdMeta,
        cloudFolderId.isAcceptableOrUnknown(
          data['cloud_folder_id']!,
          _cloudFolderIdMeta,
        ),
      );
    }
    if (data.containsKey('last_sync_time')) {
      context.handle(
        _lastSyncTimeMeta,
        lastSyncTime.isAcceptableOrUnknown(
          data['last_sync_time']!,
          _lastSyncTimeMeta,
        ),
      );
    }
    if (data.containsKey('has_remote_changes')) {
      context.handle(
        _hasRemoteChangesMeta,
        hasRemoteChanges.isAcceptableOrUnknown(
          data['has_remote_changes']!,
          _hasRemoteChangesMeta,
        ),
      );
    }
    if (data.containsKey('is_read_only')) {
      context.handle(
        _isReadOnlyMeta,
        isReadOnly.isAcceptableOrUnknown(
          data['is_read_only']!,
          _isReadOnlyMeta,
        ),
      );
    }
    if (data.containsKey('share_url')) {
      context.handle(
        _shareUrlMeta,
        shareUrl.isAcceptableOrUnknown(data['share_url']!, _shareUrlMeta),
      );
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {id};
  @override
  SyncStateTableData map(Map<String, dynamic> data, {String? tablePrefix}) {
    final effectivePrefix = tablePrefix != null ? '$tablePrefix.' : '';
    return SyncStateTableData(
      id: attachedDatabase.typeMapping.read(
        DriftSqlType.int,
        data['${effectivePrefix}id'],
      )!,
      interfaceType: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}interface_type'],
      )!,
      accountName: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}account_name'],
      )!,
      cloudFolderId: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}cloud_folder_id'],
      )!,
      lastSyncTime: attachedDatabase.typeMapping.read(
        DriftSqlType.int,
        data['${effectivePrefix}last_sync_time'],
      ),
      hasRemoteChanges: attachedDatabase.typeMapping.read(
        DriftSqlType.int,
        data['${effectivePrefix}has_remote_changes'],
      )!,
      isReadOnly: attachedDatabase.typeMapping.read(
        DriftSqlType.int,
        data['${effectivePrefix}is_read_only'],
      )!,
      shareUrl: attachedDatabase.typeMapping.read(
        DriftSqlType.string,
        data['${effectivePrefix}share_url'],
      )!,
    );
  }

  @override
  $SyncStateTableTable createAlias(String alias) {
    return $SyncStateTableTable(attachedDatabase, alias);
  }
}

class SyncStateTableData extends DataClass
    implements Insertable<SyncStateTableData> {
  final int id;
  final String interfaceType;
  final String accountName;
  final String cloudFolderId;
  final int? lastSyncTime;
  final int hasRemoteChanges;
  final int isReadOnly;
  final String shareUrl;
  const SyncStateTableData({
    required this.id,
    required this.interfaceType,
    required this.accountName,
    required this.cloudFolderId,
    this.lastSyncTime,
    required this.hasRemoteChanges,
    required this.isReadOnly,
    required this.shareUrl,
  });
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    map['id'] = Variable<int>(id);
    map['interface_type'] = Variable<String>(interfaceType);
    map['account_name'] = Variable<String>(accountName);
    map['cloud_folder_id'] = Variable<String>(cloudFolderId);
    if (!nullToAbsent || lastSyncTime != null) {
      map['last_sync_time'] = Variable<int>(lastSyncTime);
    }
    map['has_remote_changes'] = Variable<int>(hasRemoteChanges);
    map['is_read_only'] = Variable<int>(isReadOnly);
    map['share_url'] = Variable<String>(shareUrl);
    return map;
  }

  SyncStateTableCompanion toCompanion(bool nullToAbsent) {
    return SyncStateTableCompanion(
      id: Value(id),
      interfaceType: Value(interfaceType),
      accountName: Value(accountName),
      cloudFolderId: Value(cloudFolderId),
      lastSyncTime: lastSyncTime == null && nullToAbsent
          ? const Value.absent()
          : Value(lastSyncTime),
      hasRemoteChanges: Value(hasRemoteChanges),
      isReadOnly: Value(isReadOnly),
      shareUrl: Value(shareUrl),
    );
  }

  factory SyncStateTableData.fromJson(
    Map<String, dynamic> json, {
    ValueSerializer? serializer,
  }) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return SyncStateTableData(
      id: serializer.fromJson<int>(json['id']),
      interfaceType: serializer.fromJson<String>(json['interfaceType']),
      accountName: serializer.fromJson<String>(json['accountName']),
      cloudFolderId: serializer.fromJson<String>(json['cloudFolderId']),
      lastSyncTime: serializer.fromJson<int?>(json['lastSyncTime']),
      hasRemoteChanges: serializer.fromJson<int>(json['hasRemoteChanges']),
      isReadOnly: serializer.fromJson<int>(json['isReadOnly']),
      shareUrl: serializer.fromJson<String>(json['shareUrl']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'id': serializer.toJson<int>(id),
      'interfaceType': serializer.toJson<String>(interfaceType),
      'accountName': serializer.toJson<String>(accountName),
      'cloudFolderId': serializer.toJson<String>(cloudFolderId),
      'lastSyncTime': serializer.toJson<int?>(lastSyncTime),
      'hasRemoteChanges': serializer.toJson<int>(hasRemoteChanges),
      'isReadOnly': serializer.toJson<int>(isReadOnly),
      'shareUrl': serializer.toJson<String>(shareUrl),
    };
  }

  SyncStateTableData copyWith({
    int? id,
    String? interfaceType,
    String? accountName,
    String? cloudFolderId,
    Value<int?> lastSyncTime = const Value.absent(),
    int? hasRemoteChanges,
    int? isReadOnly,
    String? shareUrl,
  }) => SyncStateTableData(
    id: id ?? this.id,
    interfaceType: interfaceType ?? this.interfaceType,
    accountName: accountName ?? this.accountName,
    cloudFolderId: cloudFolderId ?? this.cloudFolderId,
    lastSyncTime: lastSyncTime.present ? lastSyncTime.value : this.lastSyncTime,
    hasRemoteChanges: hasRemoteChanges ?? this.hasRemoteChanges,
    isReadOnly: isReadOnly ?? this.isReadOnly,
    shareUrl: shareUrl ?? this.shareUrl,
  );
  SyncStateTableData copyWithCompanion(SyncStateTableCompanion data) {
    return SyncStateTableData(
      id: data.id.present ? data.id.value : this.id,
      interfaceType: data.interfaceType.present
          ? data.interfaceType.value
          : this.interfaceType,
      accountName: data.accountName.present
          ? data.accountName.value
          : this.accountName,
      cloudFolderId: data.cloudFolderId.present
          ? data.cloudFolderId.value
          : this.cloudFolderId,
      lastSyncTime: data.lastSyncTime.present
          ? data.lastSyncTime.value
          : this.lastSyncTime,
      hasRemoteChanges: data.hasRemoteChanges.present
          ? data.hasRemoteChanges.value
          : this.hasRemoteChanges,
      isReadOnly: data.isReadOnly.present
          ? data.isReadOnly.value
          : this.isReadOnly,
      shareUrl: data.shareUrl.present ? data.shareUrl.value : this.shareUrl,
    );
  }

  @override
  String toString() {
    return (StringBuffer('SyncStateTableData(')
          ..write('id: $id, ')
          ..write('interfaceType: $interfaceType, ')
          ..write('accountName: $accountName, ')
          ..write('cloudFolderId: $cloudFolderId, ')
          ..write('lastSyncTime: $lastSyncTime, ')
          ..write('hasRemoteChanges: $hasRemoteChanges, ')
          ..write('isReadOnly: $isReadOnly, ')
          ..write('shareUrl: $shareUrl')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode => Object.hash(
    id,
    interfaceType,
    accountName,
    cloudFolderId,
    lastSyncTime,
    hasRemoteChanges,
    isReadOnly,
    shareUrl,
  );
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is SyncStateTableData &&
          other.id == this.id &&
          other.interfaceType == this.interfaceType &&
          other.accountName == this.accountName &&
          other.cloudFolderId == this.cloudFolderId &&
          other.lastSyncTime == this.lastSyncTime &&
          other.hasRemoteChanges == this.hasRemoteChanges &&
          other.isReadOnly == this.isReadOnly &&
          other.shareUrl == this.shareUrl);
}

class SyncStateTableCompanion extends UpdateCompanion<SyncStateTableData> {
  final Value<int> id;
  final Value<String> interfaceType;
  final Value<String> accountName;
  final Value<String> cloudFolderId;
  final Value<int?> lastSyncTime;
  final Value<int> hasRemoteChanges;
  final Value<int> isReadOnly;
  final Value<String> shareUrl;
  const SyncStateTableCompanion({
    this.id = const Value.absent(),
    this.interfaceType = const Value.absent(),
    this.accountName = const Value.absent(),
    this.cloudFolderId = const Value.absent(),
    this.lastSyncTime = const Value.absent(),
    this.hasRemoteChanges = const Value.absent(),
    this.isReadOnly = const Value.absent(),
    this.shareUrl = const Value.absent(),
  });
  SyncStateTableCompanion.insert({
    this.id = const Value.absent(),
    this.interfaceType = const Value.absent(),
    this.accountName = const Value.absent(),
    this.cloudFolderId = const Value.absent(),
    this.lastSyncTime = const Value.absent(),
    this.hasRemoteChanges = const Value.absent(),
    this.isReadOnly = const Value.absent(),
    this.shareUrl = const Value.absent(),
  });
  static Insertable<SyncStateTableData> custom({
    Expression<int>? id,
    Expression<String>? interfaceType,
    Expression<String>? accountName,
    Expression<String>? cloudFolderId,
    Expression<int>? lastSyncTime,
    Expression<int>? hasRemoteChanges,
    Expression<int>? isReadOnly,
    Expression<String>? shareUrl,
  }) {
    return RawValuesInsertable({
      if (id != null) 'id': id,
      if (interfaceType != null) 'interface_type': interfaceType,
      if (accountName != null) 'account_name': accountName,
      if (cloudFolderId != null) 'cloud_folder_id': cloudFolderId,
      if (lastSyncTime != null) 'last_sync_time': lastSyncTime,
      if (hasRemoteChanges != null) 'has_remote_changes': hasRemoteChanges,
      if (isReadOnly != null) 'is_read_only': isReadOnly,
      if (shareUrl != null) 'share_url': shareUrl,
    });
  }

  SyncStateTableCompanion copyWith({
    Value<int>? id,
    Value<String>? interfaceType,
    Value<String>? accountName,
    Value<String>? cloudFolderId,
    Value<int?>? lastSyncTime,
    Value<int>? hasRemoteChanges,
    Value<int>? isReadOnly,
    Value<String>? shareUrl,
  }) {
    return SyncStateTableCompanion(
      id: id ?? this.id,
      interfaceType: interfaceType ?? this.interfaceType,
      accountName: accountName ?? this.accountName,
      cloudFolderId: cloudFolderId ?? this.cloudFolderId,
      lastSyncTime: lastSyncTime ?? this.lastSyncTime,
      hasRemoteChanges: hasRemoteChanges ?? this.hasRemoteChanges,
      isReadOnly: isReadOnly ?? this.isReadOnly,
      shareUrl: shareUrl ?? this.shareUrl,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (id.present) {
      map['id'] = Variable<int>(id.value);
    }
    if (interfaceType.present) {
      map['interface_type'] = Variable<String>(interfaceType.value);
    }
    if (accountName.present) {
      map['account_name'] = Variable<String>(accountName.value);
    }
    if (cloudFolderId.present) {
      map['cloud_folder_id'] = Variable<String>(cloudFolderId.value);
    }
    if (lastSyncTime.present) {
      map['last_sync_time'] = Variable<int>(lastSyncTime.value);
    }
    if (hasRemoteChanges.present) {
      map['has_remote_changes'] = Variable<int>(hasRemoteChanges.value);
    }
    if (isReadOnly.present) {
      map['is_read_only'] = Variable<int>(isReadOnly.value);
    }
    if (shareUrl.present) {
      map['share_url'] = Variable<String>(shareUrl.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('SyncStateTableCompanion(')
          ..write('id: $id, ')
          ..write('interfaceType: $interfaceType, ')
          ..write('accountName: $accountName, ')
          ..write('cloudFolderId: $cloudFolderId, ')
          ..write('lastSyncTime: $lastSyncTime, ')
          ..write('hasRemoteChanges: $hasRemoteChanges, ')
          ..write('isReadOnly: $isReadOnly, ')
          ..write('shareUrl: $shareUrl')
          ..write(')'))
        .toString();
  }
}

abstract class _$AppDatabase extends GeneratedDatabase {
  _$AppDatabase(QueryExecutor e) : super(e);
  $AppDatabaseManager get managers => $AppDatabaseManager(this);
  late final $PoiTableTable poiTable = $PoiTableTable(this);
  late final $FolderTableTable folderTable = $FolderTableTable(this);
  late final $WorkspaceTableTable workspaceTable = $WorkspaceTableTable(this);
  late final $TrackTableTable trackTable = $TrackTableTable(this);
  late final $TrackPointTableTable trackPointTable = $TrackPointTableTable(
    this,
  );
  late final $SyncStateTableTable syncStateTable = $SyncStateTableTable(this);
  @override
  Iterable<TableInfo<Table, Object?>> get allTables =>
      allSchemaEntities.whereType<TableInfo<Table, Object?>>();
  @override
  List<DatabaseSchemaEntity> get allSchemaEntities => [
    poiTable,
    folderTable,
    workspaceTable,
    trackTable,
    trackPointTable,
    syncStateTable,
  ];
}

typedef $$PoiTableTableCreateCompanionBuilder =
    PoiTableCompanion Function({
      required String id,
      required String name,
      Value<String> description,
      required double latitude,
      required double longitude,
      Value<int> color,
      Value<String> iconKey,
      Value<String?> folderId,
      Value<String> images,
      required int createdAt,
      required int updatedAt,
      Value<int> isFavorite,
      Value<String> note,
      Value<int> rowid,
    });
typedef $$PoiTableTableUpdateCompanionBuilder =
    PoiTableCompanion Function({
      Value<String> id,
      Value<String> name,
      Value<String> description,
      Value<double> latitude,
      Value<double> longitude,
      Value<int> color,
      Value<String> iconKey,
      Value<String?> folderId,
      Value<String> images,
      Value<int> createdAt,
      Value<int> updatedAt,
      Value<int> isFavorite,
      Value<String> note,
      Value<int> rowid,
    });

class $$PoiTableTableFilterComposer
    extends Composer<_$AppDatabase, $PoiTableTable> {
  $$PoiTableTableFilterComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnFilters<String> get id => $composableBuilder(
    column: $table.id,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<String> get name => $composableBuilder(
    column: $table.name,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<String> get description => $composableBuilder(
    column: $table.description,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<double> get latitude => $composableBuilder(
    column: $table.latitude,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<double> get longitude => $composableBuilder(
    column: $table.longitude,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<int> get color => $composableBuilder(
    column: $table.color,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<String> get iconKey => $composableBuilder(
    column: $table.iconKey,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<String> get folderId => $composableBuilder(
    column: $table.folderId,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<String> get images => $composableBuilder(
    column: $table.images,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<int> get createdAt => $composableBuilder(
    column: $table.createdAt,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<int> get updatedAt => $composableBuilder(
    column: $table.updatedAt,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<int> get isFavorite => $composableBuilder(
    column: $table.isFavorite,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<String> get note => $composableBuilder(
    column: $table.note,
    builder: (column) => ColumnFilters(column),
  );
}

class $$PoiTableTableOrderingComposer
    extends Composer<_$AppDatabase, $PoiTableTable> {
  $$PoiTableTableOrderingComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnOrderings<String> get id => $composableBuilder(
    column: $table.id,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<String> get name => $composableBuilder(
    column: $table.name,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<String> get description => $composableBuilder(
    column: $table.description,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<double> get latitude => $composableBuilder(
    column: $table.latitude,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<double> get longitude => $composableBuilder(
    column: $table.longitude,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<int> get color => $composableBuilder(
    column: $table.color,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<String> get iconKey => $composableBuilder(
    column: $table.iconKey,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<String> get folderId => $composableBuilder(
    column: $table.folderId,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<String> get images => $composableBuilder(
    column: $table.images,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<int> get createdAt => $composableBuilder(
    column: $table.createdAt,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<int> get updatedAt => $composableBuilder(
    column: $table.updatedAt,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<int> get isFavorite => $composableBuilder(
    column: $table.isFavorite,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<String> get note => $composableBuilder(
    column: $table.note,
    builder: (column) => ColumnOrderings(column),
  );
}

class $$PoiTableTableAnnotationComposer
    extends Composer<_$AppDatabase, $PoiTableTable> {
  $$PoiTableTableAnnotationComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  GeneratedColumn<String> get id =>
      $composableBuilder(column: $table.id, builder: (column) => column);

  GeneratedColumn<String> get name =>
      $composableBuilder(column: $table.name, builder: (column) => column);

  GeneratedColumn<String> get description => $composableBuilder(
    column: $table.description,
    builder: (column) => column,
  );

  GeneratedColumn<double> get latitude =>
      $composableBuilder(column: $table.latitude, builder: (column) => column);

  GeneratedColumn<double> get longitude =>
      $composableBuilder(column: $table.longitude, builder: (column) => column);

  GeneratedColumn<int> get color =>
      $composableBuilder(column: $table.color, builder: (column) => column);

  GeneratedColumn<String> get iconKey =>
      $composableBuilder(column: $table.iconKey, builder: (column) => column);

  GeneratedColumn<String> get folderId =>
      $composableBuilder(column: $table.folderId, builder: (column) => column);

  GeneratedColumn<String> get images =>
      $composableBuilder(column: $table.images, builder: (column) => column);

  GeneratedColumn<int> get createdAt =>
      $composableBuilder(column: $table.createdAt, builder: (column) => column);

  GeneratedColumn<int> get updatedAt =>
      $composableBuilder(column: $table.updatedAt, builder: (column) => column);

  GeneratedColumn<int> get isFavorite => $composableBuilder(
    column: $table.isFavorite,
    builder: (column) => column,
  );

  GeneratedColumn<String> get note =>
      $composableBuilder(column: $table.note, builder: (column) => column);
}

class $$PoiTableTableTableManager
    extends
        RootTableManager<
          _$AppDatabase,
          $PoiTableTable,
          PoiTableData,
          $$PoiTableTableFilterComposer,
          $$PoiTableTableOrderingComposer,
          $$PoiTableTableAnnotationComposer,
          $$PoiTableTableCreateCompanionBuilder,
          $$PoiTableTableUpdateCompanionBuilder,
          (
            PoiTableData,
            BaseReferences<_$AppDatabase, $PoiTableTable, PoiTableData>,
          ),
          PoiTableData,
          PrefetchHooks Function()
        > {
  $$PoiTableTableTableManager(_$AppDatabase db, $PoiTableTable table)
    : super(
        TableManagerState(
          db: db,
          table: table,
          createFilteringComposer: () =>
              $$PoiTableTableFilterComposer($db: db, $table: table),
          createOrderingComposer: () =>
              $$PoiTableTableOrderingComposer($db: db, $table: table),
          createComputedFieldComposer: () =>
              $$PoiTableTableAnnotationComposer($db: db, $table: table),
          updateCompanionCallback:
              ({
                Value<String> id = const Value.absent(),
                Value<String> name = const Value.absent(),
                Value<String> description = const Value.absent(),
                Value<double> latitude = const Value.absent(),
                Value<double> longitude = const Value.absent(),
                Value<int> color = const Value.absent(),
                Value<String> iconKey = const Value.absent(),
                Value<String?> folderId = const Value.absent(),
                Value<String> images = const Value.absent(),
                Value<int> createdAt = const Value.absent(),
                Value<int> updatedAt = const Value.absent(),
                Value<int> isFavorite = const Value.absent(),
                Value<String> note = const Value.absent(),
                Value<int> rowid = const Value.absent(),
              }) => PoiTableCompanion(
                id: id,
                name: name,
                description: description,
                latitude: latitude,
                longitude: longitude,
                color: color,
                iconKey: iconKey,
                folderId: folderId,
                images: images,
                createdAt: createdAt,
                updatedAt: updatedAt,
                isFavorite: isFavorite,
                note: note,
                rowid: rowid,
              ),
          createCompanionCallback:
              ({
                required String id,
                required String name,
                Value<String> description = const Value.absent(),
                required double latitude,
                required double longitude,
                Value<int> color = const Value.absent(),
                Value<String> iconKey = const Value.absent(),
                Value<String?> folderId = const Value.absent(),
                Value<String> images = const Value.absent(),
                required int createdAt,
                required int updatedAt,
                Value<int> isFavorite = const Value.absent(),
                Value<String> note = const Value.absent(),
                Value<int> rowid = const Value.absent(),
              }) => PoiTableCompanion.insert(
                id: id,
                name: name,
                description: description,
                latitude: latitude,
                longitude: longitude,
                color: color,
                iconKey: iconKey,
                folderId: folderId,
                images: images,
                createdAt: createdAt,
                updatedAt: updatedAt,
                isFavorite: isFavorite,
                note: note,
                rowid: rowid,
              ),
          withReferenceMapper: (p0) => p0
              .map((e) => (e.readTable(table), BaseReferences(db, table, e)))
              .toList(),
          prefetchHooksCallback: null,
        ),
      );
}

typedef $$PoiTableTableProcessedTableManager =
    ProcessedTableManager<
      _$AppDatabase,
      $PoiTableTable,
      PoiTableData,
      $$PoiTableTableFilterComposer,
      $$PoiTableTableOrderingComposer,
      $$PoiTableTableAnnotationComposer,
      $$PoiTableTableCreateCompanionBuilder,
      $$PoiTableTableUpdateCompanionBuilder,
      (
        PoiTableData,
        BaseReferences<_$AppDatabase, $PoiTableTable, PoiTableData>,
      ),
      PoiTableData,
      PrefetchHooks Function()
    >;
typedef $$FolderTableTableCreateCompanionBuilder =
    FolderTableCompanion Function({
      required String id,
      required String name,
      Value<int> color,
      Value<String?> parentId,
      required int createdAt,
      Value<int> sortOrder,
      Value<int> rowid,
    });
typedef $$FolderTableTableUpdateCompanionBuilder =
    FolderTableCompanion Function({
      Value<String> id,
      Value<String> name,
      Value<int> color,
      Value<String?> parentId,
      Value<int> createdAt,
      Value<int> sortOrder,
      Value<int> rowid,
    });

class $$FolderTableTableFilterComposer
    extends Composer<_$AppDatabase, $FolderTableTable> {
  $$FolderTableTableFilterComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnFilters<String> get id => $composableBuilder(
    column: $table.id,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<String> get name => $composableBuilder(
    column: $table.name,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<int> get color => $composableBuilder(
    column: $table.color,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<String> get parentId => $composableBuilder(
    column: $table.parentId,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<int> get createdAt => $composableBuilder(
    column: $table.createdAt,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<int> get sortOrder => $composableBuilder(
    column: $table.sortOrder,
    builder: (column) => ColumnFilters(column),
  );
}

class $$FolderTableTableOrderingComposer
    extends Composer<_$AppDatabase, $FolderTableTable> {
  $$FolderTableTableOrderingComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnOrderings<String> get id => $composableBuilder(
    column: $table.id,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<String> get name => $composableBuilder(
    column: $table.name,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<int> get color => $composableBuilder(
    column: $table.color,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<String> get parentId => $composableBuilder(
    column: $table.parentId,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<int> get createdAt => $composableBuilder(
    column: $table.createdAt,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<int> get sortOrder => $composableBuilder(
    column: $table.sortOrder,
    builder: (column) => ColumnOrderings(column),
  );
}

class $$FolderTableTableAnnotationComposer
    extends Composer<_$AppDatabase, $FolderTableTable> {
  $$FolderTableTableAnnotationComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  GeneratedColumn<String> get id =>
      $composableBuilder(column: $table.id, builder: (column) => column);

  GeneratedColumn<String> get name =>
      $composableBuilder(column: $table.name, builder: (column) => column);

  GeneratedColumn<int> get color =>
      $composableBuilder(column: $table.color, builder: (column) => column);

  GeneratedColumn<String> get parentId =>
      $composableBuilder(column: $table.parentId, builder: (column) => column);

  GeneratedColumn<int> get createdAt =>
      $composableBuilder(column: $table.createdAt, builder: (column) => column);

  GeneratedColumn<int> get sortOrder =>
      $composableBuilder(column: $table.sortOrder, builder: (column) => column);
}

class $$FolderTableTableTableManager
    extends
        RootTableManager<
          _$AppDatabase,
          $FolderTableTable,
          FolderTableData,
          $$FolderTableTableFilterComposer,
          $$FolderTableTableOrderingComposer,
          $$FolderTableTableAnnotationComposer,
          $$FolderTableTableCreateCompanionBuilder,
          $$FolderTableTableUpdateCompanionBuilder,
          (
            FolderTableData,
            BaseReferences<_$AppDatabase, $FolderTableTable, FolderTableData>,
          ),
          FolderTableData,
          PrefetchHooks Function()
        > {
  $$FolderTableTableTableManager(_$AppDatabase db, $FolderTableTable table)
    : super(
        TableManagerState(
          db: db,
          table: table,
          createFilteringComposer: () =>
              $$FolderTableTableFilterComposer($db: db, $table: table),
          createOrderingComposer: () =>
              $$FolderTableTableOrderingComposer($db: db, $table: table),
          createComputedFieldComposer: () =>
              $$FolderTableTableAnnotationComposer($db: db, $table: table),
          updateCompanionCallback:
              ({
                Value<String> id = const Value.absent(),
                Value<String> name = const Value.absent(),
                Value<int> color = const Value.absent(),
                Value<String?> parentId = const Value.absent(),
                Value<int> createdAt = const Value.absent(),
                Value<int> sortOrder = const Value.absent(),
                Value<int> rowid = const Value.absent(),
              }) => FolderTableCompanion(
                id: id,
                name: name,
                color: color,
                parentId: parentId,
                createdAt: createdAt,
                sortOrder: sortOrder,
                rowid: rowid,
              ),
          createCompanionCallback:
              ({
                required String id,
                required String name,
                Value<int> color = const Value.absent(),
                Value<String?> parentId = const Value.absent(),
                required int createdAt,
                Value<int> sortOrder = const Value.absent(),
                Value<int> rowid = const Value.absent(),
              }) => FolderTableCompanion.insert(
                id: id,
                name: name,
                color: color,
                parentId: parentId,
                createdAt: createdAt,
                sortOrder: sortOrder,
                rowid: rowid,
              ),
          withReferenceMapper: (p0) => p0
              .map((e) => (e.readTable(table), BaseReferences(db, table, e)))
              .toList(),
          prefetchHooksCallback: null,
        ),
      );
}

typedef $$FolderTableTableProcessedTableManager =
    ProcessedTableManager<
      _$AppDatabase,
      $FolderTableTable,
      FolderTableData,
      $$FolderTableTableFilterComposer,
      $$FolderTableTableOrderingComposer,
      $$FolderTableTableAnnotationComposer,
      $$FolderTableTableCreateCompanionBuilder,
      $$FolderTableTableUpdateCompanionBuilder,
      (
        FolderTableData,
        BaseReferences<_$AppDatabase, $FolderTableTable, FolderTableData>,
      ),
      FolderTableData,
      PrefetchHooks Function()
    >;
typedef $$WorkspaceTableTableCreateCompanionBuilder =
    WorkspaceTableCompanion Function({
      required String id,
      required String name,
      required int createdAt,
      Value<int> isActive,
      Value<int> rowid,
    });
typedef $$WorkspaceTableTableUpdateCompanionBuilder =
    WorkspaceTableCompanion Function({
      Value<String> id,
      Value<String> name,
      Value<int> createdAt,
      Value<int> isActive,
      Value<int> rowid,
    });

class $$WorkspaceTableTableFilterComposer
    extends Composer<_$AppDatabase, $WorkspaceTableTable> {
  $$WorkspaceTableTableFilterComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnFilters<String> get id => $composableBuilder(
    column: $table.id,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<String> get name => $composableBuilder(
    column: $table.name,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<int> get createdAt => $composableBuilder(
    column: $table.createdAt,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<int> get isActive => $composableBuilder(
    column: $table.isActive,
    builder: (column) => ColumnFilters(column),
  );
}

class $$WorkspaceTableTableOrderingComposer
    extends Composer<_$AppDatabase, $WorkspaceTableTable> {
  $$WorkspaceTableTableOrderingComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnOrderings<String> get id => $composableBuilder(
    column: $table.id,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<String> get name => $composableBuilder(
    column: $table.name,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<int> get createdAt => $composableBuilder(
    column: $table.createdAt,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<int> get isActive => $composableBuilder(
    column: $table.isActive,
    builder: (column) => ColumnOrderings(column),
  );
}

class $$WorkspaceTableTableAnnotationComposer
    extends Composer<_$AppDatabase, $WorkspaceTableTable> {
  $$WorkspaceTableTableAnnotationComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  GeneratedColumn<String> get id =>
      $composableBuilder(column: $table.id, builder: (column) => column);

  GeneratedColumn<String> get name =>
      $composableBuilder(column: $table.name, builder: (column) => column);

  GeneratedColumn<int> get createdAt =>
      $composableBuilder(column: $table.createdAt, builder: (column) => column);

  GeneratedColumn<int> get isActive =>
      $composableBuilder(column: $table.isActive, builder: (column) => column);
}

class $$WorkspaceTableTableTableManager
    extends
        RootTableManager<
          _$AppDatabase,
          $WorkspaceTableTable,
          WorkspaceTableData,
          $$WorkspaceTableTableFilterComposer,
          $$WorkspaceTableTableOrderingComposer,
          $$WorkspaceTableTableAnnotationComposer,
          $$WorkspaceTableTableCreateCompanionBuilder,
          $$WorkspaceTableTableUpdateCompanionBuilder,
          (
            WorkspaceTableData,
            BaseReferences<
              _$AppDatabase,
              $WorkspaceTableTable,
              WorkspaceTableData
            >,
          ),
          WorkspaceTableData,
          PrefetchHooks Function()
        > {
  $$WorkspaceTableTableTableManager(
    _$AppDatabase db,
    $WorkspaceTableTable table,
  ) : super(
        TableManagerState(
          db: db,
          table: table,
          createFilteringComposer: () =>
              $$WorkspaceTableTableFilterComposer($db: db, $table: table),
          createOrderingComposer: () =>
              $$WorkspaceTableTableOrderingComposer($db: db, $table: table),
          createComputedFieldComposer: () =>
              $$WorkspaceTableTableAnnotationComposer($db: db, $table: table),
          updateCompanionCallback:
              ({
                Value<String> id = const Value.absent(),
                Value<String> name = const Value.absent(),
                Value<int> createdAt = const Value.absent(),
                Value<int> isActive = const Value.absent(),
                Value<int> rowid = const Value.absent(),
              }) => WorkspaceTableCompanion(
                id: id,
                name: name,
                createdAt: createdAt,
                isActive: isActive,
                rowid: rowid,
              ),
          createCompanionCallback:
              ({
                required String id,
                required String name,
                required int createdAt,
                Value<int> isActive = const Value.absent(),
                Value<int> rowid = const Value.absent(),
              }) => WorkspaceTableCompanion.insert(
                id: id,
                name: name,
                createdAt: createdAt,
                isActive: isActive,
                rowid: rowid,
              ),
          withReferenceMapper: (p0) => p0
              .map((e) => (e.readTable(table), BaseReferences(db, table, e)))
              .toList(),
          prefetchHooksCallback: null,
        ),
      );
}

typedef $$WorkspaceTableTableProcessedTableManager =
    ProcessedTableManager<
      _$AppDatabase,
      $WorkspaceTableTable,
      WorkspaceTableData,
      $$WorkspaceTableTableFilterComposer,
      $$WorkspaceTableTableOrderingComposer,
      $$WorkspaceTableTableAnnotationComposer,
      $$WorkspaceTableTableCreateCompanionBuilder,
      $$WorkspaceTableTableUpdateCompanionBuilder,
      (
        WorkspaceTableData,
        BaseReferences<_$AppDatabase, $WorkspaceTableTable, WorkspaceTableData>,
      ),
      WorkspaceTableData,
      PrefetchHooks Function()
    >;
typedef $$TrackTableTableCreateCompanionBuilder =
    TrackTableCompanion Function({
      required String id,
      required String name,
      required int startedAt,
      Value<int?> finishedAt,
      Value<double> distanceMeters,
      Value<int> rowid,
    });
typedef $$TrackTableTableUpdateCompanionBuilder =
    TrackTableCompanion Function({
      Value<String> id,
      Value<String> name,
      Value<int> startedAt,
      Value<int?> finishedAt,
      Value<double> distanceMeters,
      Value<int> rowid,
    });

class $$TrackTableTableFilterComposer
    extends Composer<_$AppDatabase, $TrackTableTable> {
  $$TrackTableTableFilterComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnFilters<String> get id => $composableBuilder(
    column: $table.id,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<String> get name => $composableBuilder(
    column: $table.name,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<int> get startedAt => $composableBuilder(
    column: $table.startedAt,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<int> get finishedAt => $composableBuilder(
    column: $table.finishedAt,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<double> get distanceMeters => $composableBuilder(
    column: $table.distanceMeters,
    builder: (column) => ColumnFilters(column),
  );
}

class $$TrackTableTableOrderingComposer
    extends Composer<_$AppDatabase, $TrackTableTable> {
  $$TrackTableTableOrderingComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnOrderings<String> get id => $composableBuilder(
    column: $table.id,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<String> get name => $composableBuilder(
    column: $table.name,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<int> get startedAt => $composableBuilder(
    column: $table.startedAt,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<int> get finishedAt => $composableBuilder(
    column: $table.finishedAt,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<double> get distanceMeters => $composableBuilder(
    column: $table.distanceMeters,
    builder: (column) => ColumnOrderings(column),
  );
}

class $$TrackTableTableAnnotationComposer
    extends Composer<_$AppDatabase, $TrackTableTable> {
  $$TrackTableTableAnnotationComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  GeneratedColumn<String> get id =>
      $composableBuilder(column: $table.id, builder: (column) => column);

  GeneratedColumn<String> get name =>
      $composableBuilder(column: $table.name, builder: (column) => column);

  GeneratedColumn<int> get startedAt =>
      $composableBuilder(column: $table.startedAt, builder: (column) => column);

  GeneratedColumn<int> get finishedAt => $composableBuilder(
    column: $table.finishedAt,
    builder: (column) => column,
  );

  GeneratedColumn<double> get distanceMeters => $composableBuilder(
    column: $table.distanceMeters,
    builder: (column) => column,
  );
}

class $$TrackTableTableTableManager
    extends
        RootTableManager<
          _$AppDatabase,
          $TrackTableTable,
          TrackTableData,
          $$TrackTableTableFilterComposer,
          $$TrackTableTableOrderingComposer,
          $$TrackTableTableAnnotationComposer,
          $$TrackTableTableCreateCompanionBuilder,
          $$TrackTableTableUpdateCompanionBuilder,
          (
            TrackTableData,
            BaseReferences<_$AppDatabase, $TrackTableTable, TrackTableData>,
          ),
          TrackTableData,
          PrefetchHooks Function()
        > {
  $$TrackTableTableTableManager(_$AppDatabase db, $TrackTableTable table)
    : super(
        TableManagerState(
          db: db,
          table: table,
          createFilteringComposer: () =>
              $$TrackTableTableFilterComposer($db: db, $table: table),
          createOrderingComposer: () =>
              $$TrackTableTableOrderingComposer($db: db, $table: table),
          createComputedFieldComposer: () =>
              $$TrackTableTableAnnotationComposer($db: db, $table: table),
          updateCompanionCallback:
              ({
                Value<String> id = const Value.absent(),
                Value<String> name = const Value.absent(),
                Value<int> startedAt = const Value.absent(),
                Value<int?> finishedAt = const Value.absent(),
                Value<double> distanceMeters = const Value.absent(),
                Value<int> rowid = const Value.absent(),
              }) => TrackTableCompanion(
                id: id,
                name: name,
                startedAt: startedAt,
                finishedAt: finishedAt,
                distanceMeters: distanceMeters,
                rowid: rowid,
              ),
          createCompanionCallback:
              ({
                required String id,
                required String name,
                required int startedAt,
                Value<int?> finishedAt = const Value.absent(),
                Value<double> distanceMeters = const Value.absent(),
                Value<int> rowid = const Value.absent(),
              }) => TrackTableCompanion.insert(
                id: id,
                name: name,
                startedAt: startedAt,
                finishedAt: finishedAt,
                distanceMeters: distanceMeters,
                rowid: rowid,
              ),
          withReferenceMapper: (p0) => p0
              .map((e) => (e.readTable(table), BaseReferences(db, table, e)))
              .toList(),
          prefetchHooksCallback: null,
        ),
      );
}

typedef $$TrackTableTableProcessedTableManager =
    ProcessedTableManager<
      _$AppDatabase,
      $TrackTableTable,
      TrackTableData,
      $$TrackTableTableFilterComposer,
      $$TrackTableTableOrderingComposer,
      $$TrackTableTableAnnotationComposer,
      $$TrackTableTableCreateCompanionBuilder,
      $$TrackTableTableUpdateCompanionBuilder,
      (
        TrackTableData,
        BaseReferences<_$AppDatabase, $TrackTableTable, TrackTableData>,
      ),
      TrackTableData,
      PrefetchHooks Function()
    >;
typedef $$TrackPointTableTableCreateCompanionBuilder =
    TrackPointTableCompanion Function({
      Value<int> id,
      required String trackId,
      required double latitude,
      required double longitude,
      Value<double?> altitude,
      required int timestamp,
      Value<double?> speed,
    });
typedef $$TrackPointTableTableUpdateCompanionBuilder =
    TrackPointTableCompanion Function({
      Value<int> id,
      Value<String> trackId,
      Value<double> latitude,
      Value<double> longitude,
      Value<double?> altitude,
      Value<int> timestamp,
      Value<double?> speed,
    });

class $$TrackPointTableTableFilterComposer
    extends Composer<_$AppDatabase, $TrackPointTableTable> {
  $$TrackPointTableTableFilterComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnFilters<int> get id => $composableBuilder(
    column: $table.id,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<String> get trackId => $composableBuilder(
    column: $table.trackId,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<double> get latitude => $composableBuilder(
    column: $table.latitude,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<double> get longitude => $composableBuilder(
    column: $table.longitude,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<double> get altitude => $composableBuilder(
    column: $table.altitude,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<int> get timestamp => $composableBuilder(
    column: $table.timestamp,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<double> get speed => $composableBuilder(
    column: $table.speed,
    builder: (column) => ColumnFilters(column),
  );
}

class $$TrackPointTableTableOrderingComposer
    extends Composer<_$AppDatabase, $TrackPointTableTable> {
  $$TrackPointTableTableOrderingComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnOrderings<int> get id => $composableBuilder(
    column: $table.id,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<String> get trackId => $composableBuilder(
    column: $table.trackId,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<double> get latitude => $composableBuilder(
    column: $table.latitude,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<double> get longitude => $composableBuilder(
    column: $table.longitude,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<double> get altitude => $composableBuilder(
    column: $table.altitude,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<int> get timestamp => $composableBuilder(
    column: $table.timestamp,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<double> get speed => $composableBuilder(
    column: $table.speed,
    builder: (column) => ColumnOrderings(column),
  );
}

class $$TrackPointTableTableAnnotationComposer
    extends Composer<_$AppDatabase, $TrackPointTableTable> {
  $$TrackPointTableTableAnnotationComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  GeneratedColumn<int> get id =>
      $composableBuilder(column: $table.id, builder: (column) => column);

  GeneratedColumn<String> get trackId =>
      $composableBuilder(column: $table.trackId, builder: (column) => column);

  GeneratedColumn<double> get latitude =>
      $composableBuilder(column: $table.latitude, builder: (column) => column);

  GeneratedColumn<double> get longitude =>
      $composableBuilder(column: $table.longitude, builder: (column) => column);

  GeneratedColumn<double> get altitude =>
      $composableBuilder(column: $table.altitude, builder: (column) => column);

  GeneratedColumn<int> get timestamp =>
      $composableBuilder(column: $table.timestamp, builder: (column) => column);

  GeneratedColumn<double> get speed =>
      $composableBuilder(column: $table.speed, builder: (column) => column);
}

class $$TrackPointTableTableTableManager
    extends
        RootTableManager<
          _$AppDatabase,
          $TrackPointTableTable,
          TrackPointTableData,
          $$TrackPointTableTableFilterComposer,
          $$TrackPointTableTableOrderingComposer,
          $$TrackPointTableTableAnnotationComposer,
          $$TrackPointTableTableCreateCompanionBuilder,
          $$TrackPointTableTableUpdateCompanionBuilder,
          (
            TrackPointTableData,
            BaseReferences<
              _$AppDatabase,
              $TrackPointTableTable,
              TrackPointTableData
            >,
          ),
          TrackPointTableData,
          PrefetchHooks Function()
        > {
  $$TrackPointTableTableTableManager(
    _$AppDatabase db,
    $TrackPointTableTable table,
  ) : super(
        TableManagerState(
          db: db,
          table: table,
          createFilteringComposer: () =>
              $$TrackPointTableTableFilterComposer($db: db, $table: table),
          createOrderingComposer: () =>
              $$TrackPointTableTableOrderingComposer($db: db, $table: table),
          createComputedFieldComposer: () =>
              $$TrackPointTableTableAnnotationComposer($db: db, $table: table),
          updateCompanionCallback:
              ({
                Value<int> id = const Value.absent(),
                Value<String> trackId = const Value.absent(),
                Value<double> latitude = const Value.absent(),
                Value<double> longitude = const Value.absent(),
                Value<double?> altitude = const Value.absent(),
                Value<int> timestamp = const Value.absent(),
                Value<double?> speed = const Value.absent(),
              }) => TrackPointTableCompanion(
                id: id,
                trackId: trackId,
                latitude: latitude,
                longitude: longitude,
                altitude: altitude,
                timestamp: timestamp,
                speed: speed,
              ),
          createCompanionCallback:
              ({
                Value<int> id = const Value.absent(),
                required String trackId,
                required double latitude,
                required double longitude,
                Value<double?> altitude = const Value.absent(),
                required int timestamp,
                Value<double?> speed = const Value.absent(),
              }) => TrackPointTableCompanion.insert(
                id: id,
                trackId: trackId,
                latitude: latitude,
                longitude: longitude,
                altitude: altitude,
                timestamp: timestamp,
                speed: speed,
              ),
          withReferenceMapper: (p0) => p0
              .map((e) => (e.readTable(table), BaseReferences(db, table, e)))
              .toList(),
          prefetchHooksCallback: null,
        ),
      );
}

typedef $$TrackPointTableTableProcessedTableManager =
    ProcessedTableManager<
      _$AppDatabase,
      $TrackPointTableTable,
      TrackPointTableData,
      $$TrackPointTableTableFilterComposer,
      $$TrackPointTableTableOrderingComposer,
      $$TrackPointTableTableAnnotationComposer,
      $$TrackPointTableTableCreateCompanionBuilder,
      $$TrackPointTableTableUpdateCompanionBuilder,
      (
        TrackPointTableData,
        BaseReferences<
          _$AppDatabase,
          $TrackPointTableTable,
          TrackPointTableData
        >,
      ),
      TrackPointTableData,
      PrefetchHooks Function()
    >;
typedef $$SyncStateTableTableCreateCompanionBuilder =
    SyncStateTableCompanion Function({
      Value<int> id,
      Value<String> interfaceType,
      Value<String> accountName,
      Value<String> cloudFolderId,
      Value<int?> lastSyncTime,
      Value<int> hasRemoteChanges,
      Value<int> isReadOnly,
      Value<String> shareUrl,
    });
typedef $$SyncStateTableTableUpdateCompanionBuilder =
    SyncStateTableCompanion Function({
      Value<int> id,
      Value<String> interfaceType,
      Value<String> accountName,
      Value<String> cloudFolderId,
      Value<int?> lastSyncTime,
      Value<int> hasRemoteChanges,
      Value<int> isReadOnly,
      Value<String> shareUrl,
    });

class $$SyncStateTableTableFilterComposer
    extends Composer<_$AppDatabase, $SyncStateTableTable> {
  $$SyncStateTableTableFilterComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnFilters<int> get id => $composableBuilder(
    column: $table.id,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<String> get interfaceType => $composableBuilder(
    column: $table.interfaceType,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<String> get accountName => $composableBuilder(
    column: $table.accountName,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<String> get cloudFolderId => $composableBuilder(
    column: $table.cloudFolderId,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<int> get lastSyncTime => $composableBuilder(
    column: $table.lastSyncTime,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<int> get hasRemoteChanges => $composableBuilder(
    column: $table.hasRemoteChanges,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<int> get isReadOnly => $composableBuilder(
    column: $table.isReadOnly,
    builder: (column) => ColumnFilters(column),
  );

  ColumnFilters<String> get shareUrl => $composableBuilder(
    column: $table.shareUrl,
    builder: (column) => ColumnFilters(column),
  );
}

class $$SyncStateTableTableOrderingComposer
    extends Composer<_$AppDatabase, $SyncStateTableTable> {
  $$SyncStateTableTableOrderingComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnOrderings<int> get id => $composableBuilder(
    column: $table.id,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<String> get interfaceType => $composableBuilder(
    column: $table.interfaceType,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<String> get accountName => $composableBuilder(
    column: $table.accountName,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<String> get cloudFolderId => $composableBuilder(
    column: $table.cloudFolderId,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<int> get lastSyncTime => $composableBuilder(
    column: $table.lastSyncTime,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<int> get hasRemoteChanges => $composableBuilder(
    column: $table.hasRemoteChanges,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<int> get isReadOnly => $composableBuilder(
    column: $table.isReadOnly,
    builder: (column) => ColumnOrderings(column),
  );

  ColumnOrderings<String> get shareUrl => $composableBuilder(
    column: $table.shareUrl,
    builder: (column) => ColumnOrderings(column),
  );
}

class $$SyncStateTableTableAnnotationComposer
    extends Composer<_$AppDatabase, $SyncStateTableTable> {
  $$SyncStateTableTableAnnotationComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  GeneratedColumn<int> get id =>
      $composableBuilder(column: $table.id, builder: (column) => column);

  GeneratedColumn<String> get interfaceType => $composableBuilder(
    column: $table.interfaceType,
    builder: (column) => column,
  );

  GeneratedColumn<String> get accountName => $composableBuilder(
    column: $table.accountName,
    builder: (column) => column,
  );

  GeneratedColumn<String> get cloudFolderId => $composableBuilder(
    column: $table.cloudFolderId,
    builder: (column) => column,
  );

  GeneratedColumn<int> get lastSyncTime => $composableBuilder(
    column: $table.lastSyncTime,
    builder: (column) => column,
  );

  GeneratedColumn<int> get hasRemoteChanges => $composableBuilder(
    column: $table.hasRemoteChanges,
    builder: (column) => column,
  );

  GeneratedColumn<int> get isReadOnly => $composableBuilder(
    column: $table.isReadOnly,
    builder: (column) => column,
  );

  GeneratedColumn<String> get shareUrl =>
      $composableBuilder(column: $table.shareUrl, builder: (column) => column);
}

class $$SyncStateTableTableTableManager
    extends
        RootTableManager<
          _$AppDatabase,
          $SyncStateTableTable,
          SyncStateTableData,
          $$SyncStateTableTableFilterComposer,
          $$SyncStateTableTableOrderingComposer,
          $$SyncStateTableTableAnnotationComposer,
          $$SyncStateTableTableCreateCompanionBuilder,
          $$SyncStateTableTableUpdateCompanionBuilder,
          (
            SyncStateTableData,
            BaseReferences<
              _$AppDatabase,
              $SyncStateTableTable,
              SyncStateTableData
            >,
          ),
          SyncStateTableData,
          PrefetchHooks Function()
        > {
  $$SyncStateTableTableTableManager(
    _$AppDatabase db,
    $SyncStateTableTable table,
  ) : super(
        TableManagerState(
          db: db,
          table: table,
          createFilteringComposer: () =>
              $$SyncStateTableTableFilterComposer($db: db, $table: table),
          createOrderingComposer: () =>
              $$SyncStateTableTableOrderingComposer($db: db, $table: table),
          createComputedFieldComposer: () =>
              $$SyncStateTableTableAnnotationComposer($db: db, $table: table),
          updateCompanionCallback:
              ({
                Value<int> id = const Value.absent(),
                Value<String> interfaceType = const Value.absent(),
                Value<String> accountName = const Value.absent(),
                Value<String> cloudFolderId = const Value.absent(),
                Value<int?> lastSyncTime = const Value.absent(),
                Value<int> hasRemoteChanges = const Value.absent(),
                Value<int> isReadOnly = const Value.absent(),
                Value<String> shareUrl = const Value.absent(),
              }) => SyncStateTableCompanion(
                id: id,
                interfaceType: interfaceType,
                accountName: accountName,
                cloudFolderId: cloudFolderId,
                lastSyncTime: lastSyncTime,
                hasRemoteChanges: hasRemoteChanges,
                isReadOnly: isReadOnly,
                shareUrl: shareUrl,
              ),
          createCompanionCallback:
              ({
                Value<int> id = const Value.absent(),
                Value<String> interfaceType = const Value.absent(),
                Value<String> accountName = const Value.absent(),
                Value<String> cloudFolderId = const Value.absent(),
                Value<int?> lastSyncTime = const Value.absent(),
                Value<int> hasRemoteChanges = const Value.absent(),
                Value<int> isReadOnly = const Value.absent(),
                Value<String> shareUrl = const Value.absent(),
              }) => SyncStateTableCompanion.insert(
                id: id,
                interfaceType: interfaceType,
                accountName: accountName,
                cloudFolderId: cloudFolderId,
                lastSyncTime: lastSyncTime,
                hasRemoteChanges: hasRemoteChanges,
                isReadOnly: isReadOnly,
                shareUrl: shareUrl,
              ),
          withReferenceMapper: (p0) => p0
              .map((e) => (e.readTable(table), BaseReferences(db, table, e)))
              .toList(),
          prefetchHooksCallback: null,
        ),
      );
}

typedef $$SyncStateTableTableProcessedTableManager =
    ProcessedTableManager<
      _$AppDatabase,
      $SyncStateTableTable,
      SyncStateTableData,
      $$SyncStateTableTableFilterComposer,
      $$SyncStateTableTableOrderingComposer,
      $$SyncStateTableTableAnnotationComposer,
      $$SyncStateTableTableCreateCompanionBuilder,
      $$SyncStateTableTableUpdateCompanionBuilder,
      (
        SyncStateTableData,
        BaseReferences<_$AppDatabase, $SyncStateTableTable, SyncStateTableData>,
      ),
      SyncStateTableData,
      PrefetchHooks Function()
    >;

class $AppDatabaseManager {
  final _$AppDatabase _db;
  $AppDatabaseManager(this._db);
  $$PoiTableTableTableManager get poiTable =>
      $$PoiTableTableTableManager(_db, _db.poiTable);
  $$FolderTableTableTableManager get folderTable =>
      $$FolderTableTableTableManager(_db, _db.folderTable);
  $$WorkspaceTableTableTableManager get workspaceTable =>
      $$WorkspaceTableTableTableManager(_db, _db.workspaceTable);
  $$TrackTableTableTableManager get trackTable =>
      $$TrackTableTableTableManager(_db, _db.trackTable);
  $$TrackPointTableTableTableManager get trackPointTable =>
      $$TrackPointTableTableTableManager(_db, _db.trackPointTable);
  $$SyncStateTableTableTableManager get syncStateTable =>
      $$SyncStateTableTableTableManager(_db, _db.syncStateTable);
}
