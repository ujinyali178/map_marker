package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import javax.annotation.Nullable;

/* loaded from: /root/release/classes.dex */
public interface IGoogleMapDelegate extends IInterface {
    com.google.android.gms.internal.maps.zzl addCircle(CircleOptions circleOptions);

    com.google.android.gms.internal.maps.zzr addGroundOverlay(GroundOverlayOptions groundOverlayOptions);

    com.google.android.gms.internal.maps.zzad addMarker(MarkerOptions markerOptions);

    void addOnMapCapabilitiesChangedListener(zzal zzalVar);

    com.google.android.gms.internal.maps.zzag addPolygon(PolygonOptions polygonOptions);

    com.google.android.gms.internal.maps.zzaj addPolyline(PolylineOptions polylineOptions);

    com.google.android.gms.internal.maps.zzam addTileOverlay(TileOverlayOptions tileOverlayOptions);

    void animateCamera(IObjectWrapper iObjectWrapper);

    void animateCameraWithCallback(IObjectWrapper iObjectWrapper, @Nullable zzd zzdVar);

    void animateCameraWithDurationAndCallback(IObjectWrapper iObjectWrapper, int i3, @Nullable zzd zzdVar);

    void clear();

    CameraPosition getCameraPosition();

    com.google.android.gms.internal.maps.zzo getFeatureLayer(com.google.android.gms.maps.model.zzd zzdVar);

    com.google.android.gms.internal.maps.zzu getFocusedBuilding();

    void getMapAsync(zzat zzatVar);

    com.google.android.gms.internal.maps.zzaa getMapCapabilities();

    int getMapType();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    Location getMyLocation();

    IProjectionDelegate getProjection();

    IUiSettingsDelegate getUiSettings();

    boolean isBuildingsEnabled();

    boolean isIndoorEnabled();

    boolean isMyLocationEnabled();

    boolean isTrafficEnabled();

    void moveCamera(IObjectWrapper iObjectWrapper);

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

    void removeOnMapCapabilitiesChangedListener(zzal zzalVar);

    void resetMinMaxZoomPreference();

    void setBuildingsEnabled(boolean z3);

    void setContentDescription(@Nullable String str);

    boolean setIndoorEnabled(boolean z3);

    void setInfoWindowAdapter(@Nullable zzi zziVar);

    void setLatLngBoundsForCameraTarget(@Nullable LatLngBounds latLngBounds);

    void setLocationSource(@Nullable ILocationSourceDelegate iLocationSourceDelegate);

    boolean setMapStyle(@Nullable MapStyleOptions mapStyleOptions);

    void setMapType(int i3);

    void setMaxZoomPreference(float f3);

    void setMinZoomPreference(float f3);

    void setMyLocationEnabled(boolean z3);

    void setOnCameraChangeListener(@Nullable zzn zznVar);

    void setOnCameraIdleListener(@Nullable zzp zzpVar);

    void setOnCameraMoveCanceledListener(@Nullable zzr zzrVar);

    void setOnCameraMoveListener(@Nullable zzt zztVar);

    void setOnCameraMoveStartedListener(@Nullable zzv zzvVar);

    void setOnCircleClickListener(@Nullable zzx zzxVar);

    void setOnGroundOverlayClickListener(@Nullable zzz zzzVar);

    void setOnIndoorStateChangeListener(@Nullable zzab zzabVar);

    void setOnInfoWindowClickListener(@Nullable zzad zzadVar);

    void setOnInfoWindowCloseListener(@Nullable zzaf zzafVar);

    void setOnInfoWindowLongClickListener(@Nullable zzah zzahVar);

    void setOnMapClickListener(@Nullable zzan zzanVar);

    void setOnMapLoadedCallback(@Nullable zzap zzapVar);

    void setOnMapLongClickListener(@Nullable zzar zzarVar);

    void setOnMarkerClickListener(@Nullable zzav zzavVar);

    void setOnMarkerDragListener(@Nullable zzax zzaxVar);

    void setOnMyLocationButtonClickListener(@Nullable zzaz zzazVar);

    void setOnMyLocationChangeListener(@Nullable zzbb zzbbVar);

    void setOnMyLocationClickListener(@Nullable zzbd zzbdVar);

    void setOnPoiClickListener(@Nullable zzbf zzbfVar);

    void setOnPolygonClickListener(@Nullable zzbh zzbhVar);

    void setOnPolylineClickListener(@Nullable zzbj zzbjVar);

    void setPadding(int i3, int i4, int i5, int i6);

    void setTrafficEnabled(boolean z3);

    void setWatermarkEnabled(boolean z3);

    void snapshot(zzbw zzbwVar, @Nullable IObjectWrapper iObjectWrapper);

    void snapshotForTest(zzbw zzbwVar);

    void stopAnimation();

    boolean useViewLifecycleWhenInFragment();
}
