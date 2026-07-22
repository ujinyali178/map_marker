package com.google.android.gms.fido.fido2;

import android.app.Activity;

@Deprecated
/* loaded from: /root/release/classes.dex */
public interface Fido2PendingIntent {
    boolean hasPendingIntent();

    void launchPendingIntent(Activity activity, int i3);
}
