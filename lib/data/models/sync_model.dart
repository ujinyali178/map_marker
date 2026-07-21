import 'package:equatable/equatable.dart';

enum SyncStateInterfaceType {
  none,
  googleDrive,
  dropbox,
}

class SyncModel extends Equatable {
  final SyncStateInterfaceType interfaceType;
  final String accountName;
  final String cloudFolderId;
  final DateTime? lastSyncTime;
  final bool hasRemoteChanges;
  final bool isReadOnly;
  final String shareUrl;

  const SyncModel({
    this.interfaceType = SyncStateInterfaceType.none,
    this.accountName = '',
    this.cloudFolderId = '',
    this.lastSyncTime,
    this.hasRemoteChanges = false,
    this.isReadOnly = false,
    this.shareUrl = '',
  });

  SyncModel copyWith({
    SyncStateInterfaceType? interfaceType,
    String? accountName,
    String? cloudFolderId,
    DateTime? lastSyncTime,
    bool? hasRemoteChanges,
    bool? isReadOnly,
    String? shareUrl,
  }) {
    return SyncModel(
      interfaceType: interfaceType ?? this.interfaceType,
      accountName: accountName ?? this.accountName,
      cloudFolderId: cloudFolderId ?? this.cloudFolderId,
      lastSyncTime: lastSyncTime ?? this.lastSyncTime,
      hasRemoteChanges: hasRemoteChanges ?? this.hasRemoteChanges,
      isReadOnly: isReadOnly ?? this.isReadOnly,
      shareUrl: shareUrl ?? this.shareUrl,
    );
  }

  bool get isConnected => interfaceType != SyncStateInterfaceType.none;

  factory SyncModel.fromJson(Map<String, dynamic> json) {
    return SyncModel(
      interfaceType: _parseInterfaceType(json['interfaceType'] as String?),
      accountName: json['accountName'] as String? ?? '',
      cloudFolderId: json['cloudFolderId'] as String? ?? '',
      lastSyncTime: json['lastSyncTime'] != null
          ? DateTime.parse(json['lastSyncTime'] as String)
          : null,
      hasRemoteChanges: json['hasRemoteChanges'] as bool? ?? false,
      isReadOnly: json['isReadOnly'] as bool? ?? false,
      shareUrl: json['shareUrl'] as String? ?? '',
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'interfaceType': interfaceType.name,
      'accountName': accountName,
      'cloudFolderId': cloudFolderId,
      'lastSyncTime': lastSyncTime?.toIso8601String(),
      'hasRemoteChanges': hasRemoteChanges,
      'isReadOnly': isReadOnly,
      'shareUrl': shareUrl,
    };
  }

  static SyncStateInterfaceType _parseInterfaceType(String? value) {
    if (value == null) return SyncStateInterfaceType.none;
    return SyncStateInterfaceType.values.firstWhere(
      (e) => e.name == value,
      orElse: () => SyncStateInterfaceType.none,
    );
  }

  @override
  List<Object?> get props => [
    interfaceType, accountName, cloudFolderId, lastSyncTime,
    hasRemoteChanges, isReadOnly, shareUrl,
  ];
}
