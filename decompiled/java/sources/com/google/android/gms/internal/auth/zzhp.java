package com.google.android.gms.internal.auth;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: /root/release/classes.dex */
public enum zzhp {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzef.zzb),
    ENUM(null),
    MESSAGE(null);

    private final Object zzk;

    zzhp(Object obj) {
        this.zzk = obj;
    }
}
