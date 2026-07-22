package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zbm;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

/* loaded from: /root/release/classes.dex */
public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {
    private static final zbb zbb = new zbb(null);
    static int zba = 1;

    GoogleSignInClient(Activity activity, GoogleSignInOptions googleSignInOptions) {
        super(activity, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    GoogleSignInClient(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }

    private final synchronized int zba() {
        int i3;
        i3 = zba;
        if (i3 == 1) {
            Context applicationContext = getApplicationContext();
            GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
            int isGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(applicationContext, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (isGooglePlayServicesAvailable == 0) {
                zba = 4;
                i3 = 4;
            } else if (googleApiAvailability.getErrorResolutionIntent(applicationContext, isGooglePlayServicesAvailable, null) != null || DynamiteModule.getLocalVersion(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                zba = 2;
                i3 = 2;
            } else {
                zba = 3;
                i3 = 3;
            }
        }
        return i3;
    }

    public Intent getSignInIntent() {
        Context applicationContext = getApplicationContext();
        int zba2 = zba();
        int i3 = zba2 - 1;
        if (zba2 != 0) {
            return i3 != 2 ? i3 != 3 ? zbm.zbb(applicationContext, getApiOptions()) : zbm.zbc(applicationContext, getApiOptions()) : zbm.zba(applicationContext, getApiOptions());
        }
        throw null;
    }

    public Task<Void> revokeAccess() {
        return PendingResultUtil.toVoidTask(zbm.zbf(asGoogleApiClient(), getApplicationContext(), zba() == 3));
    }

    public Task<Void> signOut() {
        return PendingResultUtil.toVoidTask(zbm.zbg(asGoogleApiClient(), getApplicationContext(), zba() == 3));
    }

    public Task<GoogleSignInAccount> silentSignIn() {
        return PendingResultUtil.toTask(zbm.zbe(asGoogleApiClient(), getApplicationContext(), getApiOptions(), zba() == 3), zbb);
    }
}
