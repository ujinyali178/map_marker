import 'package:equatable/equatable.dart';

class AuthUser extends Equatable {
  final String name;
  final String email;
  final String? photoUrl;

  const AuthUser({
    required this.name,
    required this.email,
    this.photoUrl,
  });

  @override
  List<Object?> get props => [name, email, photoUrl];
}

class AuthState extends Equatable {
  final bool isAuthenticated;
  final AuthUser? user;
  final String? error;

  const AuthState({
    this.isAuthenticated = false,
    this.user,
    this.error,
  });

  AuthState copyWith({
    bool? isAuthenticated,
    AuthUser? user,
    String? error,
    bool clearError = false,
    bool clearUser = false,
  }) {
    return AuthState(
      isAuthenticated: isAuthenticated ?? this.isAuthenticated,
      user: clearUser ? null : (user ?? this.user),
      error: clearError ? null : (error ?? this.error),
    );
  }

  @override
  List<Object?> get props => [isAuthenticated, user, error];
}
