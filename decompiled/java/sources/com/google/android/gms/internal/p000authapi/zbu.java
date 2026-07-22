package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.Status;

/* loaded from: /root/release/classes.dex */
public abstract class zbu extends zbb implements zbv {
    public zbu() {
        super("com.google.android.gms.auth.api.identity.internal.ISavePasswordCallback");
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    protected final boolean zba(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        Status status = (Status) zbc.zba(parcel, Status.CREATOR);
        SavePasswordResult savePasswordResult = (SavePasswordResult) zbc.zba(parcel, SavePasswordResult.CREATOR);
        zbc.zbb(parcel);
        zbb(status, savePasswordResult);
        return true;
    }
}
