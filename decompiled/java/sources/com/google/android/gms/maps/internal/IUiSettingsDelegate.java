package com.google.android.gms.maps.internal;

import android.os.IInterface;

/* loaded from: /root/release/classes.dex */
public interface IUiSettingsDelegate extends IInterface {
    boolean isCompassEnabled();

    boolean isIndoorLevelPickerEnabled();

    boolean isMapToolbarEnabled();

    boolean isMyLocationButtonEnabled();

    boolean isRotateGesturesEnabled();

    boolean isScrollGesturesEnabled();

    boolean isScrollGesturesEnabledDuringRotateOrZoom();

    boolean isTiltGesturesEnabled();

    boolean isZoomControlsEnabled();

    boolean isZoomGesturesEnabled();

    void setAllGesturesEnabled(boolean z3);

    void setCompassEnabled(boolean z3);

    void setIndoorLevelPickerEnabled(boolean z3);

    void setMapToolbarEnabled(boolean z3);

    void setMyLocationButtonEnabled(boolean z3);

    void setRotateGesturesEnabled(boolean z3);

    void setScrollGesturesEnabled(boolean z3);

    void setScrollGesturesEnabledDuringRotateOrZoom(boolean z3);

    void setTiltGesturesEnabled(boolean z3);

    void setZoomControlsEnabled(boolean z3);

    void setZoomGesturesEnabled(boolean z3);
}
