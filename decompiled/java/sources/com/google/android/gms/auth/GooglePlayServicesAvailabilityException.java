package com.google.android.gms.auth;

import android.content.Intent;

/* loaded from: /root/release/classes.dex */
public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
    private final int zza;

    GooglePlayServicesAvailabilityException(int i3, String str, Intent intent) {
        super(str, intent);
        this.zza = i3;
    }

    public int getConnectionStatusCode() {
        return this.zza;
    }
}
