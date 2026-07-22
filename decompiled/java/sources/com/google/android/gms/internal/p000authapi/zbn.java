package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;

/* loaded from: /root/release/classes.dex */
public final class zbn extends zba {
    zbn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ICredentialSavingService");
    }

    public final void zbc(zbt zbtVar, SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        Parcel zba = zba();
        zbc.zbd(zba, zbtVar);
        zbc.zbc(zba, saveAccountLinkingTokenRequest);
        zbb(1, zba);
    }

    public final void zbd(zbv zbvVar, SavePasswordRequest savePasswordRequest) {
        Parcel zba = zba();
        zbc.zbd(zba, zbvVar);
        zbc.zbc(zba, savePasswordRequest);
        zbb(2, zba);
    }
}
