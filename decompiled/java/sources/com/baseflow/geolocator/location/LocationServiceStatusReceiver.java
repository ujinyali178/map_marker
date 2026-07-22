package com.baseflow.geolocator.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import u1.e;
import y.i0;

/* loaded from: /root/release/classes.dex */
public class LocationServiceStatusReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private final e.b f2140a;

    /* renamed from: b, reason: collision with root package name */
    private i0 f2141b;

    public LocationServiceStatusReceiver(e.b bVar) {
        this.f2140a = bVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        i0 i0Var;
        if ("android.location.PROVIDERS_CHANGED".equals(intent.getAction())) {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
            boolean isProviderEnabled2 = locationManager.isProviderEnabled("network");
            if (isProviderEnabled || isProviderEnabled2) {
                i0 i0Var2 = this.f2141b;
                if (i0Var2 != null && i0Var2 != i0.disabled) {
                    return;
                } else {
                    i0Var = i0.enabled;
                }
            } else {
                i0 i0Var3 = this.f2141b;
                if (i0Var3 != null && i0Var3 != i0.enabled) {
                    return;
                } else {
                    i0Var = i0.disabled;
                }
            }
            this.f2141b = i0Var;
            this.f2140a.a(Integer.valueOf(i0Var.ordinal()));
        }
    }
}
