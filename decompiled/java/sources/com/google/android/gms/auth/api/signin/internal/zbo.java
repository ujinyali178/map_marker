package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public abstract class zbo extends com.google.android.gms.internal.p000authapi.zbb implements zbp {
    public zbo() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    protected final boolean zba(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 == 1) {
            zbc();
        } else {
            if (i3 != 2) {
                return false;
            }
            zbb();
        }
        return true;
    }
}
