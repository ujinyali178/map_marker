import 'package:equatable/equatable.dart';

import '../../../data/models/sync_model.dart' as model;

typedef SyncInterfaceType = model.SyncStateInterfaceType;
const syncStates = model.SyncStateInterfaceType;

class SyncState extends Equatable {
  final bool isConnected;
  final SyncInterfaceType interfaceType;
  final String? accountName;
  final DateTime? lastSyncTime;
  final bool isSyncing;
  final double progress;
  final String? error;

  const SyncState({
    this.isConnected = false,
    this.interfaceType = SyncInterfaceType.none,
    this.accountName,
    this.lastSyncTime,
    this.isSyncing = false,
    this.progress = 0.0,
    this.error,
  });

  SyncState copyWith({
    bool? isConnected,
    SyncInterfaceType? interfaceType,
    String? accountName,
    DateTime? lastSyncTime,
    bool? isSyncing,
    double? progress,
    String? error,
    bool clearError = false,
    bool clearAccount = false,
  }) {
    return SyncState(
      isConnected: isConnected ?? this.isConnected,
      interfaceType: interfaceType ?? this.interfaceType,
      accountName: clearAccount ? null : (accountName ?? this.accountName),
      lastSyncTime: lastSyncTime ?? this.lastSyncTime,
      isSyncing: isSyncing ?? this.isSyncing,
      progress: progress ?? this.progress,
      error: clearError ? null : (error ?? this.error),
    );
  }

  @override
  List<Object?> get props => [
    isConnected, interfaceType, accountName, lastSyncTime, isSyncing, progress, error,
  ];
}
