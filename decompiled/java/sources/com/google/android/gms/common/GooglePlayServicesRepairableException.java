package com.google.android.gms.common;

import android.content.Intent;

/* loaded from: /root/release/classes.dex */
public class GooglePlayServicesRepairableException extends UserRecoverableException {
    private final int zza;

    public GooglePlayServicesRepairableException(int i3, String str, Intent intent) {
        super(str, intent);
        this.zza = i3;
    }

    public int getConnectionStatusCode() {
        return this.zza;
    }
}
