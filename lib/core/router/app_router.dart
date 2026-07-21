import 'package:flutter/material.dart';
import 'package:latlong2/latlong.dart';

import '../../presentation/screens/folder/folder_editor_screen.dart';
import '../../presentation/screens/folder/folder_list_screen.dart';
import '../../presentation/screens/home/home_screen.dart';
import '../../presentation/screens/map/map_screen.dart';
import '../../presentation/screens/navigation/navigation_screen.dart';
import '../../presentation/screens/poi/poi_detail_screen.dart';
import '../../presentation/screens/poi/poi_editor_screen.dart';
import '../../presentation/screens/search/search_screen.dart';
import '../../presentation/screens/settings/settings_screen.dart';
import '../../presentation/screens/sync/sync_screen.dart';
import '../../presentation/screens/track/track_recording_screen.dart';

class AppRouter {
  AppRouter();

  Route? onGenerateRoute(RouteSettings settings) {
    switch (settings.name) {
      case '/':
      case '/home':
        return MaterialPageRoute(builder: (_) => const HomeScreen(), settings: settings);

      case '/map':
        return MaterialPageRoute(builder: (_) => const MapScreen(), settings: settings);

      case '/poi/editor':
        final args = settings.arguments as Map<String, dynamic>?;
        return MaterialPageRoute(
          builder: (_) => PoiEditorScreen(
            poiId: args?['poiId'] as String?,
            initialLatitude: args?['latitude']?.toDouble(),
            initialLongitude: args?['longitude']?.toDouble(),
          ),
          settings: settings,
        );

      case '/poi/detail':
        final args = settings.arguments as Map<String, dynamic>?;
        return MaterialPageRoute(
          builder: (_) => PoiDetailScreen(poiId: args?['poiId'] as String?),
          settings: settings,
        );

      case '/folder/list':
        return MaterialPageRoute(builder: (_) => const FolderListScreen(), settings: settings);

      case '/folder/editor':
        final args = settings.arguments as Map<String, dynamic>?;
        return MaterialPageRoute(
          builder: (_) => FolderEditorScreen(
            folderId: args?['folderId'] as String?,
            parentId: args?['parentId'] as String?,
          ),
          settings: settings,
        );

      case '/search':
        return MaterialPageRoute(builder: (_) => const SearchScreen(), settings: settings);

      case '/navigation':
        final args = settings.arguments as Map<String, dynamic>?;
        return MaterialPageRoute(
          builder: (_) => NavigationScreen(
            destination: args?['destination'] as LatLng?,
            destinationName: args?['destinationName'] as String?,
          ),
          settings: settings,
        );

      case '/track/recording':
        return MaterialPageRoute(builder: (_) => const TrackRecordingScreen(), settings: settings);

      case '/sync':
        return MaterialPageRoute(builder: (_) => const SyncScreen(), settings: settings);

      case '/settings':
        return MaterialPageRoute(builder: (_) => const SettingsScreen(), settings: settings);

      default:
        return MaterialPageRoute(
          builder: (_) => const Scaffold(body: Center(child: Text('Route not found'))),
          settings: settings,
        );
    }
  }
}
