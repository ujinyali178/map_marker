import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:google_sign_in/google_sign_in.dart';

import 'auth_state.dart';

class AuthCubit extends Cubit<AuthState> {
  final GoogleSignIn _googleSignIn;

  AuthCubit({GoogleSignIn? googleSignIn})
      : _googleSignIn = googleSignIn ?? GoogleSignIn(),
        super(const AuthState());

  Future<void> signIn() async {
    emit(state.copyWith(isAuthenticated: false, clearError: true, clearUser: true));

    try {
      final account = await _googleSignIn.signIn();

      if (account == null) {
        emit(state.copyWith(
          isAuthenticated: false,
          error: 'Sign in was cancelled.',
        ));
        return;
      }

      final user = AuthUser(
        name: account.displayName ?? account.email.split('@').first,
        email: account.email,
        photoUrl: account.photoUrl,
      );

      emit(state.copyWith(
        isAuthenticated: true,
        user: user,
      ));
    } catch (e) {
      emit(state.copyWith(
        isAuthenticated: false,
        error: e.toString(),
      ));
    }
  }

  Future<void> signOut() async {
    try {
      await _googleSignIn.signOut();
      emit(const AuthState());
    } catch (e) {
      emit(state.copyWith(error: e.toString()));
    }
  }

  AuthUser? getCurrentUser() {
    return state.user;
  }

  Future<void> checkSignInStatus() async {
    try {
      final isSignedIn = await _googleSignIn.isSignedIn();
      if (isSignedIn) {
        final account = await _googleSignIn.signInSilently();
        if (account != null) {
          final user = AuthUser(
            name: account.displayName ?? account.email.split('@').first,
            email: account.email,
            photoUrl: account.photoUrl,
          );
          emit(state.copyWith(
            isAuthenticated: true,
            user: user,
          ));
        }
      }
    } catch (e) {
      emit(state.copyWith(error: e.toString()));
    }
  }
}
