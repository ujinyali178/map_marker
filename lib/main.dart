import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:firebase_core/firebase_core.dart';

import 'core/router/app_router.dart';
import 'core/theme/app_theme.dart';
// import 'firebase_options.dart' if (dart.library.io) 'dummy_firebase.dart';
import 'data/repositories/folder_repository.dart';
import 'data/repositories/poi_repository.dart';
import 'data/repositories/sync_repository.dart';
import 'data/repositories/track_repository.dart';
import 'data/sources/local/app_database.dart';
import 'presentation/bloc/auth_cubit/auth_cubit.dart';
import 'presentation/bloc/folder_cubit/folder_cubit.dart';
import 'presentation/bloc/live_location_cubit/live_location_cubit.dart';
import 'presentation/bloc/map_cubit/map_cubit.dart';
import 'presentation/bloc/nav_cubit/nav_cubit.dart';
import 'presentation/bloc/poi_cubit/poi_cubit.dart';
import 'presentation/bloc/search_cubit/search_cubit.dart';
import 'presentation/bloc/settings_cubit/settings_cubit.dart';
import 'presentation/bloc/sync_cubit/sync_cubit.dart';
import 'presentation/bloc/track_cubit/track_cubit.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  try {
    await Firebase.initializeApp();
  } catch (_) {
    // Firebase not configured, running offline
  }

  SystemChrome.setSystemUIOverlayStyle(
    const SystemUiOverlayStyle(
      statusBarColor: Colors.transparent,
      statusBarIconBrightness: Brightness.dark,
      systemNavigationBarColor: Colors.white,
      systemNavigationBarIconBrightness: Brightness.dark,
    ),
  );

  final database = AppDatabase();
  final poiRepository = PoiRepository(database);
  final folderRepository = FolderRepository(database);
  final trackRepository = TrackRepository(database);
  final syncRepository = SyncRepository(database);

  runApp(
    MultiBlocProvider(
      providers: [
        BlocProvider(create: (_) => PoiCubit(poiRepository)..loadPois()),
        BlocProvider(create: (_) => FolderCubit(folderRepository)..loadFolders()),
        BlocProvider(create: (_) => TrackCubit(trackRepository)),
        BlocProvider(create: (_) => SyncCubit(syncRepository)..loadState()),
        BlocProvider(create: (_) => MapCubit()),
        BlocProvider(create: (_) => NavigationCubit()),
        BlocProvider(create: (_) => SearchCubit()),
        BlocProvider(create: (_) => SettingsCubit()..loadSettings()),
        BlocProvider(create: (_) => LiveLocationCubit()),
        BlocProvider(create: (_) => AuthCubit()),
      ],
      child: const MyApp(),
    ),
  );
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    final appRouter = AppRouter();

    return MaterialApp(
      title: 'Map Marker',
      debugShowCheckedModeBanner: false,
      theme: AppTheme.lightTheme,
      darkTheme: AppTheme.darkTheme,
      themeMode: ThemeMode.system,
      onGenerateRoute: appRouter.onGenerateRoute,
    );
  }
}
