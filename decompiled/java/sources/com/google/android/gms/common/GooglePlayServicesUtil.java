package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.zag;

/* loaded from: /root/release/classes.dex */
public final class GooglePlayServicesUtil extends GooglePlayServicesUtilLight {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";

    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";

    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i3, Activity activity, int i4) {
        return getErrorDialog(i3, activity, i4, null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i3, Activity activity, int i4, DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i3)) {
            i3 = 18;
        }
        return GoogleApiAvailability.getInstance().getErrorDialog(activity, i3, i4, onCancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i3, Context context, int i4) {
        return GooglePlayServicesUtilLight.getErrorPendingIntent(i3, context, i4);
    }

    @Deprecated
    public static String getErrorString(int i3) {
        return GooglePlayServicesUtilLight.getErrorString(i3);
    }

    public static Context getRemoteContext(Context context) {
        return GooglePlayServicesUtilLight.getRemoteContext(context);
    }

    public static Resources getRemoteResource(Context context) {
        return GooglePlayServicesUtilLight.getRemoteResource(context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context, int i3) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i3);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i3) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(i3);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i3, Activity activity, int i4) {
        return showErrorDialogFragment(i3, activity, i4, null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i3, Activity activity, int i4, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i3, activity, null, i4, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i3, Activity activity, Fragment fragment, int i4, DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i3)) {
            i3 = 18;
        }
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (fragment == null) {
            return googleApiAvailability.showErrorDialogFragment(activity, i3, i4, onCancelListener);
        }
        Dialog zaa = googleApiAvailability.zaa(activity, i3, zag.zac(fragment, GoogleApiAvailability.getInstance().getErrorResolutionIntent(activity, i3, "d"), i4), onCancelListener);
        if (zaa == null) {
            return false;
        }
        googleApiAvailability.zad(activity, zaa, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i3, Context context) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i3) || GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i3)) {
            googleApiAvailability.zaf(context);
        } else {
            googleApiAvailability.showErrorNotification(context, i3);
        }
    }
}
