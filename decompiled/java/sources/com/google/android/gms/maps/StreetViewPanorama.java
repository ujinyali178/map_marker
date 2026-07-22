package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;

/* loaded from: /root/release/classes.dex */
public class StreetViewPanorama {
    private final IStreetViewPanoramaDelegate zza;

    public interface OnStreetViewPanoramaCameraChangeListener {
        void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera);
    }

    public interface OnStreetViewPanoramaChangeListener {
        void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation);
    }

    public interface OnStreetViewPanoramaClickListener {
        void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    public interface OnStreetViewPanoramaLongClickListener {
        void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    public StreetViewPanorama(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
        this.zza = (IStreetViewPanoramaDelegate) Preconditions.checkNotNull(iStreetViewPanoramaDelegate, "delegate");
    }

    public void animateTo(StreetViewPanoramaCamera streetViewPanoramaCamera, long j3) {
        Preconditions.checkNotNull(streetViewPanoramaCamera);
        try {
            this.zza.animateTo(streetViewPanoramaCamera, j3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public StreetViewPanoramaLocation getLocation() {
        try {
            return this.zza.getStreetViewPanoramaLocation();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public StreetViewPanoramaCamera getPanoramaCamera() {
        try {
            return this.zza.getPanoramaCamera();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isPanningGesturesEnabled() {
        try {
            return this.zza.isPanningGesturesEnabled();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isStreetNamesEnabled() {
        try {
            return this.zza.isStreetNamesEnabled();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isUserNavigationEnabled() {
        try {
            return this.zza.isUserNavigationEnabled();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.zza.isZoomGesturesEnabled();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public Point orientationToPoint(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        try {
            IObjectWrapper orientationToPoint = this.zza.orientationToPoint(streetViewPanoramaOrientation);
            if (orientationToPoint == null) {
                return null;
            }
            return (Point) ObjectWrapper.unwrap(orientationToPoint);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public StreetViewPanoramaOrientation pointToOrientation(Point point) {
        try {
            return this.zza.pointToOrientation(ObjectWrapper.wrap(point));
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void setOnStreetViewPanoramaCameraChangeListener(OnStreetViewPanoramaCameraChangeListener onStreetViewPanoramaCameraChangeListener) {
        try {
            if (onStreetViewPanoramaCameraChangeListener == null) {
                this.zza.setOnStreetViewPanoramaCameraChangeListener(null);
            } else {
                this.zza.setOnStreetViewPanoramaCameraChangeListener(new zzak(this, onStreetViewPanoramaCameraChangeListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void setOnStreetViewPanoramaChangeListener(OnStreetViewPanoramaChangeListener onStreetViewPanoramaChangeListener) {
        try {
            if (onStreetViewPanoramaChangeListener == null) {
                this.zza.setOnStreetViewPanoramaChangeListener(null);
            } else {
                this.zza.setOnStreetViewPanoramaChangeListener(new zzaj(this, onStreetViewPanoramaChangeListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void setOnStreetViewPanoramaClickListener(OnStreetViewPanoramaClickListener onStreetViewPanoramaClickListener) {
        try {
            if (onStreetViewPanoramaClickListener == null) {
                this.zza.setOnStreetViewPanoramaClickListener(null);
            } else {
                this.zza.setOnStreetViewPanoramaClickListener(new zzal(this, onStreetViewPanoramaClickListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void setOnStreetViewPanoramaLongClickListener(OnStreetViewPanoramaLongClickListener onStreetViewPanoramaLongClickListener) {
        try {
            if (onStreetViewPanoramaLongClickListener == null) {
                this.zza.setOnStreetViewPanoramaLongClickListener(null);
            } else {
                this.zza.setOnStreetViewPanoramaLongClickListener(new zzam(this, onStreetViewPanoramaLongClickListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setPanningGesturesEnabled(boolean z3) {
        try {
            this.zza.enablePanning(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            this.zza.setPosition(latLng);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setPosition(LatLng latLng, int i3) {
        try {
            this.zza.setPositionWithRadius(latLng, i3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setPosition(LatLng latLng, int i3, StreetViewSource streetViewSource) {
        try {
            this.zza.setPositionWithRadiusAndSource(latLng, i3, streetViewSource);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setPosition(LatLng latLng, StreetViewSource streetViewSource) {
        try {
            this.zza.setPositionWithSource(latLng, streetViewSource);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setPosition(String str) {
        try {
            this.zza.setPositionWithID(str);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setStreetNamesEnabled(boolean z3) {
        try {
            this.zza.enableStreetNames(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setUserNavigationEnabled(boolean z3) {
        try {
            this.zza.enableUserNavigation(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void setZoomGesturesEnabled(boolean z3) {
        try {
            this.zza.enableZoom(z3);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
