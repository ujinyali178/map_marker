package com.google.android.gms.internal.fido;

import android.app.Activity;
import android.app.PendingIntent;
import com.google.android.gms.fido.u2f.U2fPendingIntent;

/* loaded from: /root/release/classes.dex */
public final class zzt implements U2fPendingIntent {
    private final PendingIntent zza;

    public zzt(PendingIntent pendingIntent) {
        this.zza = pendingIntent;
    }

    @Override // com.google.android.gms.fido.u2f.U2fPendingIntent
    public final boolean hasPendingIntent() {
        return this.zza != null;
    }

    @Override // com.google.android.gms.fido.u2f.U2fPendingIntent
    public final void launchPendingIntent(Activity activity, int i3) {
        PendingIntent pendingIntent = this.zza;
        if (pendingIntent == null) {
            throw new IllegalStateException("No PendingIntent available");
        }
        activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i3, null, 0, 0, 0);
    }
}
