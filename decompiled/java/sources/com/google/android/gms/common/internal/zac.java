package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.g;
import com.google.android.gms.base.R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;

/* loaded from: /root/release/classes.dex */
public final class zac {
    private static final g zaa = new g();
    private static Locale zab;

    public static String zaa(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String zab(Context context) {
        return context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
    }

    public static String zac(Context context, int i3) {
        return context.getResources().getString(i3 != 1 ? i3 != 2 ? i3 != 3 ? android.R.string.ok : R.string.common_google_play_services_enable_button : R.string.common_google_play_services_update_button : R.string.common_google_play_services_install_button);
    }

    public static String zad(Context context, int i3) {
        Resources resources = context.getResources();
        String zaa2 = zaa(context);
        if (i3 == 1) {
            return resources.getString(R.string.common_google_play_services_install_text, zaa2);
        }
        if (i3 == 2) {
            return DeviceProperties.isWearableWithoutPlayStore(context) ? resources.getString(R.string.common_google_play_services_wear_update_text) : resources.getString(R.string.common_google_play_services_update_text, zaa2);
        }
        if (i3 == 3) {
            return resources.getString(R.string.common_google_play_services_enable_text, zaa2);
        }
        if (i3 == 5) {
            return zah(context, "common_google_play_services_invalid_account_text", zaa2);
        }
        if (i3 == 7) {
            return zah(context, "common_google_play_services_network_error_text", zaa2);
        }
        if (i3 == 9) {
            return resources.getString(R.string.common_google_play_services_unsupported_text, zaa2);
        }
        if (i3 == 20) {
            return zah(context, "common_google_play_services_restricted_profile_text", zaa2);
        }
        switch (i3) {
            case 16:
                return zah(context, "common_google_play_services_api_unavailable_text", zaa2);
            case 17:
                return zah(context, "common_google_play_services_sign_in_failed_text", zaa2);
            case 18:
                return resources.getString(R.string.common_google_play_services_updating_text, zaa2);
            default:
                return resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue, zaa2);
        }
    }

    public static String zae(Context context, int i3) {
        return (i3 == 6 || i3 == 19) ? zah(context, "common_google_play_services_resolution_required_text", zaa(context)) : zad(context, i3);
    }

    public static String zaf(Context context, int i3) {
        String zai = i3 == 6 ? zai(context, "common_google_play_services_resolution_required_title") : zag(context, i3);
        return zai == null ? context.getResources().getString(R.string.common_google_play_services_notification_ticker) : zai;
    }

    public static String zag(Context context, int i3) {
        String str;
        Resources resources = context.getResources();
        switch (i3) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return zai(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return zai(context, "common_google_play_services_network_error_title");
            case 8:
                str = "Internal error occurred. Please see logs for detailed information";
                break;
            case 9:
                str = "Google Play services is invalid. Cannot recover.";
                break;
            case 10:
                str = "Developer error occurred. Please see logs for detailed information";
                break;
            case 11:
                str = "The application is not licensed to the user.";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                str = "Unexpected error code " + i3;
                break;
            case 16:
                str = "One of the API components you attempted to connect to is not available.";
                break;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return zai(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return zai(context, "common_google_play_services_restricted_profile_title");
        }
        Log.e("GoogleApiAvailability", str);
        return null;
    }

    private static String zah(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zai = zai(context, str);
        if (zai == null) {
            zai = resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zai, str2);
    }

    private static String zai(Context context, String str) {
        g gVar = zaa;
        synchronized (gVar) {
            Locale d3 = androidx.core.os.g.a(context.getResources().getConfiguration()).d(0);
            if (!d3.equals(zab)) {
                gVar.clear();
                zab = d3;
            }
            String str2 = (String) gVar.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                Log.w("GoogleApiAvailability", "Missing resource: " + str);
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (!TextUtils.isEmpty(string)) {
                gVar.put(str, string);
                return string;
            }
            Log.w("GoogleApiAvailability", "Got empty resource: " + str);
            return null;
        }
    }
}
