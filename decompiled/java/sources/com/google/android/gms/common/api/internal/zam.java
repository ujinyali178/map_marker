package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: /root/release/classes.dex */
final class zam {
    private final int zaa;
    private final ConnectionResult zab;

    zam(ConnectionResult connectionResult, int i3) {
        Preconditions.checkNotNull(connectionResult);
        this.zab = connectionResult;
        this.zaa = i3;
    }

    final int zaa() {
        return this.zaa;
    }

    final ConnectionResult zab() {
        return this.zab;
    }
}
