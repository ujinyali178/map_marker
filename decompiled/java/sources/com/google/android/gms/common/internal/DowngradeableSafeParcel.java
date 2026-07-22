package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: /root/release/classes.dex */
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    private static final Object zza = new Object();
    private boolean zzb = false;

    protected static boolean canUnparcelSafely(String str) {
        synchronized (zza) {
        }
        return true;
    }

    protected static Integer getUnparcelClientVersion() {
        synchronized (zza) {
        }
        return null;
    }

    protected abstract boolean prepareForClientVersion(int i3);

    public void setShouldDowngrade(boolean z3) {
        this.zzb = z3;
    }

    protected boolean shouldDowngrade() {
        return this.zzb;
    }
}
