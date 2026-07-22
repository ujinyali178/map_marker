package io.flutter.plugins;

import a2.d;
import b0.m;
import b2.j;
import com.mr.flutter.plugin.filepicker.FilePickerPlugin;
import dev.fluttercommunity.plus.connectivity.c;
import g1.b;
import io.flutter.embedding.engine.a;
import io.flutter.plugins.googlemaps.l;
import io.flutter.plugins.imagepicker.ImagePickerPlugin;
import x0.e;
import z0.c0;

/* loaded from: /root/release/classes.dex */
public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(a aVar) {
        try {
            aVar.r().d(new c1.a());
        } catch (Exception e3) {
            b.c(TAG, "Error registering plugin android_intent_plus, dev.fluttercommunity.plus.androidintent.AndroidIntentPlugin", e3);
        }
        try {
            aVar.r().d(new c());
        } catch (Exception e4) {
            b.c(TAG, "Error registering plugin connectivity_plus, dev.fluttercommunity.plus.connectivity.ConnectivityPlugin", e4);
        }
        try {
            aVar.r().d(new e1.a());
        } catch (Exception e5) {
            b.c(TAG, "Error registering plugin device_info_plus, dev.fluttercommunity.plus.device_info.DeviceInfoPlusPlugin", e5);
        }
        try {
            aVar.r().d(new FilePickerPlugin());
        } catch (Exception e6) {
            b.c(TAG, "Error registering plugin file_picker, com.mr.flutter.plugin.filepicker.FilePickerPlugin", e6);
        }
        try {
            aVar.r().d(new w0.a());
        } catch (Exception e7) {
            b.c(TAG, "Error registering plugin flutter_compass, com.hemanthraj.fluttercompass.FlutterCompassPlugin", e7);
        }
        try {
            aVar.r().d(new m0.a());
        } catch (Exception e8) {
            b.c(TAG, "Error registering plugin flutter_image_compress_common, com.fluttercandies.flutter_image_compress.ImageCompressPlugin", e8);
        }
        try {
            aVar.r().d(new d0.a());
        } catch (Exception e9) {
            b.c(TAG, "Error registering plugin flutter_native_image, com.example.flutternativeimage.FlutterNativeImagePlugin", e9);
        }
        try {
            aVar.r().d(new y1.a());
        } catch (Exception e10) {
            b.c(TAG, "Error registering plugin flutter_plugin_android_lifecycle, io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin", e10);
        }
        try {
            aVar.r().d(new e());
        } catch (Exception e11) {
            b.c(TAG, "Error registering plugin flutter_secure_storage, com.it_nomads.fluttersecurestorage.FlutterSecureStoragePlugin", e11);
        }
        try {
            aVar.r().d(new f2.a());
        } catch (Exception e12) {
            b.c(TAG, "Error registering plugin fluttertoast, io.github.ponnamkarthik.toast.fluttertoast.FlutterToastPlugin", e12);
        }
        try {
            aVar.r().d(new u.b());
        } catch (Exception e13) {
            b.c(TAG, "Error registering plugin geocoding, com.baseflow.geocoding.GeocodingPlugin", e13);
        }
        try {
            aVar.r().d(new com.baseflow.geolocator.a());
        } catch (Exception e14) {
            b.c(TAG, "Error registering plugin geolocator_android, com.baseflow.geolocator.GeolocatorPlugin", e14);
        }
        try {
            aVar.r().d(new l());
        } catch (Exception e15) {
            b.c(TAG, "Error registering plugin google_maps_flutter_android, io.flutter.plugins.googlemaps.GoogleMapsPlugin", e15);
        }
        try {
            aVar.r().d(new z1.e());
        } catch (Exception e16) {
            b.c(TAG, "Error registering plugin google_sign_in_android, io.flutter.plugins.googlesignin.GoogleSignInPlugin", e16);
        }
        try {
            aVar.r().d(new ImagePickerPlugin());
        } catch (Exception e17) {
            b.c(TAG, "Error registering plugin image_picker_android, io.flutter.plugins.imagepicker.ImagePickerPlugin", e17);
        }
        try {
            aVar.r().d(new d());
        } catch (Exception e18) {
            b.c(TAG, "Error registering plugin in_app_purchase_android, io.flutter.plugins.inapppurchase.InAppPurchasePlugin", e18);
        }
        try {
            aVar.r().d(new j());
        } catch (Exception e19) {
            b.c(TAG, "Error registering plugin path_provider_android, io.flutter.plugins.pathprovider.PathProviderPlugin", e19);
        }
        try {
            aVar.r().d(new m());
        } catch (Exception e20) {
            b.c(TAG, "Error registering plugin permission_handler_android, com.baseflow.permissionhandler.PermissionHandlerPlugin", e20);
        }
        try {
            aVar.r().d(new f1.d());
        } catch (Exception e21) {
            b.c(TAG, "Error registering plugin share_plus, dev.fluttercommunity.plus.share.SharePlusPlugin", e21);
        }
        try {
            aVar.r().d(new c2.l());
        } catch (Exception e22) {
            b.c(TAG, "Error registering plugin shared_preferences_android, io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", e22);
        }
        try {
            aVar.r().d(new c0());
        } catch (Exception e23) {
            b.c(TAG, "Error registering plugin sqflite, com.tekartik.sqflite.SqflitePlugin", e23);
        }
        try {
            aVar.r().d(new d2.j());
        } catch (Exception e24) {
            b.c(TAG, "Error registering plugin url_launcher_android, io.flutter.plugins.urllauncher.UrlLauncherPlugin", e24);
        }
    }
}
