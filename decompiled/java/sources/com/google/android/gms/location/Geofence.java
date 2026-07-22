package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.location.zzdh;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: /root/release/classes.dex */
public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {
        private double zze;
        private double zzf;
        private float zzg;
        private String zza = null;
        private int zzb = 0;
        private long zzc = Long.MIN_VALUE;
        private short zzd = -1;
        private int zzh = 0;
        private int zzi = -1;

        public Geofence build() {
            if (this.zza == null) {
                throw new IllegalArgumentException("Request ID not set.");
            }
            int i3 = this.zzb;
            if (i3 == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            }
            if ((i3 & 4) != 0 && this.zzi < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELL.");
            }
            if (this.zzc == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            }
            if (this.zzd == -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            }
            if (this.zzh >= 0) {
                return new zzdh(this.zza, this.zzb, (short) 1, this.zze, this.zzf, this.zzg, this.zzc, this.zzh, this.zzi);
            }
            throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
        }

        public Builder setCircularRegion(double d3, double d4, float f3) {
            Preconditions.checkArgument(d3 >= -90.0d && d3 <= 90.0d, "Invalid latitude: " + d3);
            Preconditions.checkArgument(d4 >= -180.0d && d4 <= 180.0d, "Invalid longitude: " + d4);
            Preconditions.checkArgument(f3 > BitmapDescriptorFactory.HUE_RED, "Invalid radius: " + f3);
            this.zzd = (short) 1;
            this.zze = d3;
            this.zzf = d4;
            this.zzg = f3;
            return this;
        }

        public Builder setExpirationDuration(long j3) {
            if (j3 < 0) {
                this.zzc = -1L;
            } else {
                this.zzc = DefaultClock.getInstance().elapsedRealtime() + j3;
            }
            return this;
        }

        public Builder setLoiteringDelay(int i3) {
            this.zzi = i3;
            return this;
        }

        public Builder setNotificationResponsiveness(int i3) {
            this.zzh = i3;
            return this;
        }

        public Builder setRequestId(String str) {
            this.zza = (String) Preconditions.checkNotNull(str, "Request ID can't be set to null");
            return this;
        }

        public Builder setTransitionTypes(int i3) {
            this.zzb = i3;
            return this;
        }
    }

    public @interface GeofenceTransition {
    }

    public @interface TransitionTypes {
    }

    long getExpirationTime();

    double getLatitude();

    int getLoiteringDelay();

    double getLongitude();

    int getNotificationResponsiveness();

    float getRadius();

    String getRequestId();

    int getTransitionTypes();
}
