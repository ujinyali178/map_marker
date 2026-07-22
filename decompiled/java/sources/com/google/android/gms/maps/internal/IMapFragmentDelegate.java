package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.GoogleMapOptions;
import javax.annotation.Nullable;

/* loaded from: /root/release/classes.dex */
public interface IMapFragmentDelegate extends IInterface {
    IGoogleMapDelegate getMap();

    void getMapAsync(zzat zzatVar);

    boolean isReady();

    void onCreate(Bundle bundle);

    IObjectWrapper onCreateView(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, Bundle bundle);

    void onDestroy();

    void onDestroyView();

    void onEnterAmbient(Bundle bundle);

    void onExitAmbient();

    void onInflate(IObjectWrapper iObjectWrapper, @Nullable GoogleMapOptions googleMapOptions, Bundle bundle);

    void onLowMemory();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();
}
