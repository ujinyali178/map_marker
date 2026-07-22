package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: /root/release/classes.dex */
public interface IMapViewDelegate extends IInterface {
    IGoogleMapDelegate getMap();

    void getMapAsync(zzat zzatVar);

    IObjectWrapper getView();

    void onCreate(Bundle bundle);

    void onDestroy();

    void onEnterAmbient(Bundle bundle);

    void onExitAmbient();

    void onLowMemory();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();
}
