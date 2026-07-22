package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.common.api.Status;

/* loaded from: /root/release/classes.dex */
public abstract class zbl extends zbb implements zbm {
    public zbl() {
        super("com.google.android.gms.auth.api.identity.internal.IBeginSignInCallback");
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    protected final boolean zba(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            return false;
        }
        Status status = (Status) zbc.zba(parcel, Status.CREATOR);
        BeginSignInResult beginSignInResult = (BeginSignInResult) zbc.zba(parcel, BeginSignInResult.CREATOR);
        zbc.zbb(parcel);
        zbb(status, beginSignInResult);
        return true;
    }
}
