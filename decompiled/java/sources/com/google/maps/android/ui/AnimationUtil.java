package com.google.maps.android.ui;

import android.os.Handler;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

/* loaded from: /root/release/classes.dex */
public class AnimationUtil {

    interface LatLngInterpolator {

        public static class Linear implements LatLngInterpolator {
            @Override // com.google.maps.android.ui.AnimationUtil.LatLngInterpolator
            public LatLng interpolate(float f3, LatLng latLng, LatLng latLng2) {
                double d3 = latLng2.latitude;
                double d4 = latLng.latitude;
                double d5 = f3;
                double d6 = ((d3 - d4) * d5) + d4;
                double d7 = latLng2.longitude - latLng.longitude;
                if (Math.abs(d7) > 180.0d) {
                    d7 -= Math.signum(d7) * 360.0d;
                }
                return new LatLng(d6, (d7 * d5) + latLng.longitude);
            }
        }

        LatLng interpolate(float f3, LatLng latLng, LatLng latLng2);
    }

    public static void animateMarkerTo(final Marker marker, final LatLng latLng) {
        final LatLngInterpolator.Linear linear = new LatLngInterpolator.Linear();
        final LatLng position = marker.getPosition();
        final Handler handler = new Handler();
        final long uptimeMillis = SystemClock.uptimeMillis();
        final AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        handler.post(new Runnable() { // from class: com.google.maps.android.ui.AnimationUtil.1
            long elapsed;

            /* renamed from: t, reason: collision with root package name */
            float f2377t;

            /* renamed from: v, reason: collision with root package name */
            float f2378v;

            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                this.elapsed = uptimeMillis2;
                float f3 = uptimeMillis2 / 2000.0f;
                this.f2377t = f3;
                float interpolation = accelerateDecelerateInterpolator.getInterpolation(f3);
                this.f2378v = interpolation;
                marker.setPosition(linear.interpolate(interpolation, position, latLng));
                if (this.f2377t < 1.0f) {
                    handler.postDelayed(this, 16L);
                }
            }
        });
    }
}
