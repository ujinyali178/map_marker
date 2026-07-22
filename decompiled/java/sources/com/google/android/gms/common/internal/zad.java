package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* loaded from: /root/release/classes.dex */
final class zad extends zag {
    final /* synthetic */ Intent zaa;
    final /* synthetic */ Activity zab;
    final /* synthetic */ int zac;

    zad(Intent intent, Activity activity, int i3) {
        this.zaa = intent;
        this.zab = activity;
        this.zac = i3;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void zaa() {
        Intent intent = this.zaa;
        if (intent != null) {
            this.zab.startActivityForResult(intent, this.zac);
        }
    }
}
