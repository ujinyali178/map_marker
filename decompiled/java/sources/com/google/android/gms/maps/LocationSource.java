package com.google.android.gms.maps;

import android.location.Location;

/* loaded from: /root/release/classes.dex */
public interface LocationSource {

    public interface OnLocationChangedListener {
        void onLocationChanged(Location location);
    }

    void activate(OnLocationChangedListener onLocationChangedListener);

    void deactivate();
}
