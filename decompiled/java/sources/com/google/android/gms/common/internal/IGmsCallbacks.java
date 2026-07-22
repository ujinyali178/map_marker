package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: /root/release/classes.dex */
public interface IGmsCallbacks extends IInterface {
    void onPostInitComplete(int i3, IBinder iBinder, Bundle bundle);

    void zzb(int i3, Bundle bundle);

    void zzc(int i3, IBinder iBinder, zzk zzkVar);
}
