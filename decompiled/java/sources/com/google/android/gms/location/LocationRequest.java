package com.google.android.gms.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zzdj;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: /root/release/classes.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzx();

    @Deprecated
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;

    @Deprecated
    public static final int PRIORITY_HIGH_ACCURACY = 100;

    @Deprecated
    public static final int PRIORITY_LOW_POWER = 104;

    @Deprecated
    public static final int PRIORITY_NO_POWER = 105;
    private int zza;
    private long zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private int zzf;
    private float zzg;
    private boolean zzh;
    private long zzi;
    private final int zzj;
    private final int zzk;
    private final String zzl;
    private final boolean zzm;
    private final WorkSource zzn;
    private final com.google.android.gms.internal.location.zzd zzo;

    public static final class Builder {
        public static final long IMPLICIT_MAX_UPDATE_AGE = -1;
        public static final long IMPLICIT_MIN_UPDATE_INTERVAL = -1;
        private int zza;
        private long zzb;
        private long zzc;
        private long zzd;
        private long zze;
        private int zzf;
        private float zzg;
        private boolean zzh;
        private long zzi;
        private int zzj;
        private int zzk;
        private String zzl;
        private boolean zzm;
        private WorkSource zzn;
        private com.google.android.gms.internal.location.zzd zzo;

        public Builder(int i3, long j3) {
            Preconditions.checkArgument(j3 >= 0, "intervalMillis must be greater than or equal to 0");
            zzae.zza(i3);
            this.zza = i3;
            this.zzb = j3;
            this.zzc = -1L;
            this.zzd = 0L;
            this.zze = Long.MAX_VALUE;
            this.zzf = Integer.MAX_VALUE;
            this.zzg = BitmapDescriptorFactory.HUE_RED;
            this.zzh = true;
            this.zzi = -1L;
            this.zzj = 0;
            this.zzk = 0;
            this.zzl = null;
            this.zzm = false;
            this.zzn = null;
            this.zzo = null;
        }

        public Builder(long j3) {
            Preconditions.checkArgument(j3 >= 0, "intervalMillis must be greater than or equal to 0");
            this.zzb = j3;
            this.zza = 102;
            this.zzc = -1L;
            this.zzd = 0L;
            this.zze = Long.MAX_VALUE;
            this.zzf = Integer.MAX_VALUE;
            this.zzg = BitmapDescriptorFactory.HUE_RED;
            this.zzh = true;
            this.zzi = -1L;
            this.zzj = 0;
            this.zzk = 0;
            this.zzl = null;
            this.zzm = false;
            this.zzn = null;
            this.zzo = null;
        }

        public Builder(LocationRequest locationRequest) {
            this.zza = locationRequest.getPriority();
            this.zzb = locationRequest.getIntervalMillis();
            this.zzc = locationRequest.getMinUpdateIntervalMillis();
            this.zzd = locationRequest.getMaxUpdateDelayMillis();
            this.zze = locationRequest.getDurationMillis();
            this.zzf = locationRequest.getMaxUpdates();
            this.zzg = locationRequest.getMinUpdateDistanceMeters();
            this.zzh = locationRequest.isWaitForAccurateLocation();
            this.zzi = locationRequest.getMaxUpdateAgeMillis();
            this.zzj = locationRequest.getGranularity();
            this.zzk = locationRequest.zza();
            this.zzl = locationRequest.zzd();
            this.zzm = locationRequest.zze();
            this.zzn = locationRequest.zzb();
            this.zzo = locationRequest.zzc();
        }

        public LocationRequest build() {
            int i3 = this.zza;
            long j3 = this.zzb;
            long j4 = this.zzc;
            if (j4 == -1) {
                j4 = j3;
            } else if (i3 != 105) {
                j4 = Math.min(j4, j3);
            }
            long max = Math.max(this.zzd, this.zzb);
            long j5 = this.zze;
            int i4 = this.zzf;
            float f3 = this.zzg;
            boolean z3 = this.zzh;
            long j6 = this.zzi;
            return new LocationRequest(i3, j3, j4, max, Long.MAX_VALUE, j5, i4, f3, z3, j6 == -1 ? this.zzb : j6, this.zzj, this.zzk, this.zzl, this.zzm, new WorkSource(this.zzn), this.zzo);
        }

        public Builder setDurationMillis(long j3) {
            Preconditions.checkArgument(j3 > 0, "durationMillis must be greater than 0");
            this.zze = j3;
            return this;
        }

        public Builder setGranularity(int i3) {
            zzo.zza(i3);
            this.zzj = i3;
            return this;
        }

        public Builder setIntervalMillis(long j3) {
            Preconditions.checkArgument(j3 >= 0, "intervalMillis must be greater than or equal to 0");
            this.zzb = j3;
            return this;
        }

        public Builder setMaxUpdateAgeMillis(long j3) {
            boolean z3 = true;
            if (j3 != -1 && j3 < 0) {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
            this.zzi = j3;
            return this;
        }

        public Builder setMaxUpdateDelayMillis(long j3) {
            Preconditions.checkArgument(j3 >= 0, "maxUpdateDelayMillis must be greater than or equal to 0");
            this.zzd = j3;
            return this;
        }

        public Builder setMaxUpdates(int i3) {
            Preconditions.checkArgument(i3 > 0, "maxUpdates must be greater than 0");
            this.zzf = i3;
            return this;
        }

        public Builder setMinUpdateDistanceMeters(float f3) {
            Preconditions.checkArgument(f3 >= BitmapDescriptorFactory.HUE_RED, "minUpdateDistanceMeters must be greater than or equal to 0");
            this.zzg = f3;
            return this;
        }

        public Builder setMinUpdateIntervalMillis(long j3) {
            boolean z3 = true;
            if (j3 != -1 && j3 < 0) {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "minUpdateIntervalMillis must be greater than or equal to 0, or IMPLICIT_MIN_UPDATE_INTERVAL");
            this.zzc = j3;
            return this;
        }

        public Builder setPriority(int i3) {
            zzae.zza(i3);
            this.zza = i3;
            return this;
        }

        public Builder setWaitForAccurateLocation(boolean z3) {
            this.zzh = z3;
            return this;
        }

        public final Builder zza(boolean z3) {
            this.zzm = z3;
            return this;
        }

        @Deprecated
        public final Builder zzb(String str) {
            if (Build.VERSION.SDK_INT < 30) {
                this.zzl = str;
            }
            return this;
        }

        public final Builder zzc(int i3) {
            boolean z3;
            int i4 = 2;
            if (i3 == 0 || i3 == 1) {
                i4 = i3;
            } else {
                if (i3 != 2) {
                    i4 = i3;
                    z3 = false;
                    Preconditions.checkArgument(z3, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i3));
                    this.zzk = i4;
                    return this;
                }
                i3 = 2;
            }
            z3 = true;
            Preconditions.checkArgument(z3, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i3));
            this.zzk = i4;
            return this;
        }

        public final Builder zzd(WorkSource workSource) {
            this.zzn = workSource;
            return this;
        }
    }

    @Deprecated
    public LocationRequest() {
        this(102, 3600000L, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Integer.MAX_VALUE, BitmapDescriptorFactory.HUE_RED, true, 3600000L, 0, 0, null, false, new WorkSource(), null);
    }

    LocationRequest(int i3, long j3, long j4, long j5, long j6, long j7, int i4, float f3, boolean z3, long j8, int i5, int i6, String str, boolean z4, WorkSource workSource, com.google.android.gms.internal.location.zzd zzdVar) {
        this.zza = i3;
        long j9 = j3;
        this.zzb = j9;
        this.zzc = j4;
        this.zzd = j5;
        this.zze = j6 == Long.MAX_VALUE ? j7 : Math.min(Math.max(1L, j6 - SystemClock.elapsedRealtime()), j7);
        this.zzf = i4;
        this.zzg = f3;
        this.zzh = z3;
        this.zzi = j8 != -1 ? j8 : j9;
        this.zzj = i5;
        this.zzk = i6;
        this.zzl = str;
        this.zzm = z4;
        this.zzn = workSource;
        this.zzo = zzdVar;
    }

    @Deprecated
    public static LocationRequest create() {
        return new LocationRequest(102, 3600000L, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Integer.MAX_VALUE, BitmapDescriptorFactory.HUE_RED, true, 3600000L, 0, 0, null, false, new WorkSource(), null);
    }

    private static String zzf(long j3) {
        return j3 == Long.MAX_VALUE ? "∞" : zzdj.zza(j3);
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.zza == locationRequest.zza && ((isPassive() || this.zzb == locationRequest.zzb) && this.zzc == locationRequest.zzc && isBatched() == locationRequest.isBatched() && ((!isBatched() || this.zzd == locationRequest.zzd) && this.zze == locationRequest.zze && this.zzf == locationRequest.zzf && this.zzg == locationRequest.zzg && this.zzh == locationRequest.zzh && this.zzj == locationRequest.zzj && this.zzk == locationRequest.zzk && this.zzm == locationRequest.zzm && this.zzn.equals(locationRequest.zzn) && Objects.equal(this.zzl, locationRequest.zzl) && Objects.equal(this.zzo, locationRequest.zzo)))) {
                return true;
            }
        }
        return false;
    }

    @Pure
    public long getDurationMillis() {
        return this.zze;
    }

    @Deprecated
    @Pure
    public long getExpirationTime() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = this.zze;
        long j4 = elapsedRealtime + j3;
        if (((elapsedRealtime ^ j4) & (j3 ^ j4)) < 0) {
            return Long.MAX_VALUE;
        }
        return j4;
    }

    @Deprecated
    @Pure
    public long getFastestInterval() {
        return getMinUpdateIntervalMillis();
    }

    @Pure
    public int getGranularity() {
        return this.zzj;
    }

    @Deprecated
    @Pure
    public long getInterval() {
        return getIntervalMillis();
    }

    @Pure
    public long getIntervalMillis() {
        return this.zzb;
    }

    @Pure
    public long getMaxUpdateAgeMillis() {
        return this.zzi;
    }

    @Pure
    public long getMaxUpdateDelayMillis() {
        return this.zzd;
    }

    @Pure
    public int getMaxUpdates() {
        return this.zzf;
    }

    @Deprecated
    @Pure
    public long getMaxWaitTime() {
        return Math.max(this.zzd, this.zzb);
    }

    @Pure
    public float getMinUpdateDistanceMeters() {
        return this.zzg;
    }

    @Pure
    public long getMinUpdateIntervalMillis() {
        return this.zzc;
    }

    @Deprecated
    @Pure
    public int getNumUpdates() {
        return getMaxUpdates();
    }

    @Pure
    public int getPriority() {
        return this.zza;
    }

    @Deprecated
    @Pure
    public float getSmallestDisplacement() {
        return getMinUpdateDistanceMeters();
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), Long.valueOf(this.zzc), this.zzn);
    }

    @Pure
    public boolean isBatched() {
        long j3 = this.zzd;
        return j3 > 0 && (j3 >> 1) >= this.zzb;
    }

    @Deprecated
    @Pure
    public boolean isFastestIntervalExplicitlySet() {
        return true;
    }

    @Pure
    public boolean isPassive() {
        return this.zza == 105;
    }

    public boolean isWaitForAccurateLocation() {
        return this.zzh;
    }

    @Deprecated
    public LocationRequest setExpirationDuration(long j3) {
        Preconditions.checkArgument(j3 > 0, "durationMillis must be greater than 0");
        this.zze = j3;
        return this;
    }

    @Deprecated
    public LocationRequest setExpirationTime(long j3) {
        this.zze = Math.max(1L, j3 - SystemClock.elapsedRealtime());
        return this;
    }

    @Deprecated
    public LocationRequest setFastestInterval(long j3) {
        Preconditions.checkArgument(j3 >= 0, "illegal fastest interval: %d", Long.valueOf(j3));
        this.zzc = j3;
        return this;
    }

    @Deprecated
    public LocationRequest setInterval(long j3) {
        Preconditions.checkArgument(j3 >= 0, "intervalMillis must be greater than or equal to 0");
        long j4 = this.zzc;
        long j5 = this.zzb;
        if (j4 == j5 / 6) {
            this.zzc = j3 / 6;
        }
        if (this.zzi == j5) {
            this.zzi = j3;
        }
        this.zzb = j3;
        return this;
    }

    @Deprecated
    public LocationRequest setMaxWaitTime(long j3) {
        Preconditions.checkArgument(j3 >= 0, "illegal max wait time: %d", Long.valueOf(j3));
        this.zzd = j3;
        return this;
    }

    @Deprecated
    public LocationRequest setNumUpdates(int i3) {
        if (i3 > 0) {
            this.zzf = i3;
            return this;
        }
        throw new IllegalArgumentException("invalid numUpdates: " + i3);
    }

    @Deprecated
    public LocationRequest setPriority(int i3) {
        zzae.zza(i3);
        this.zza = i3;
        return this;
    }

    @Deprecated
    public LocationRequest setSmallestDisplacement(float f3) {
        if (f3 >= BitmapDescriptorFactory.HUE_RED) {
            this.zzg = f3;
            return this;
        }
        throw new IllegalArgumentException("invalid displacement: " + f3);
    }

    @Deprecated
    public LocationRequest setWaitForAccurateLocation(boolean z3) {
        this.zzh = z3;
        return this;
    }

    public String toString() {
        long j3;
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (!isPassive()) {
            sb.append("@");
            if (isBatched()) {
                zzdj.zzb(this.zzb, sb);
                sb.append("/");
                j3 = this.zzd;
            } else {
                j3 = this.zzb;
            }
            zzdj.zzb(j3, sb);
            sb.append(" ");
        }
        sb.append(zzae.zzb(this.zza));
        if (isPassive() || this.zzc != this.zzb) {
            sb.append(", minUpdateInterval=");
            sb.append(zzf(this.zzc));
        }
        if (this.zzg > 0.0d) {
            sb.append(", minUpdateDistance=");
            sb.append(this.zzg);
        }
        boolean isPassive = isPassive();
        long j4 = this.zzi;
        if (!isPassive ? j4 != this.zzb : j4 != Long.MAX_VALUE) {
            sb.append(", maxUpdateAge=");
            sb.append(zzf(this.zzi));
        }
        if (this.zze != Long.MAX_VALUE) {
            sb.append(", duration=");
            zzdj.zzb(this.zze, sb);
        }
        if (this.zzf != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.zzf);
        }
        if (this.zzk != 0) {
            sb.append(", ");
            sb.append(zzai.zza(this.zzk));
        }
        if (this.zzj != 0) {
            sb.append(", ");
            sb.append(zzo.zzb(this.zzj));
        }
        if (this.zzh) {
            sb.append(", waitForAccurateLocation");
        }
        if (this.zzm) {
            sb.append(", bypass");
        }
        if (this.zzl != null) {
            sb.append(", moduleId=");
            sb.append(this.zzl);
        }
        if (!WorkSourceUtil.isEmpty(this.zzn)) {
            sb.append(", ");
            sb.append(this.zzn);
        }
        if (this.zzo != null) {
            sb.append(", impersonation=");
            sb.append(this.zzo);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getPriority());
        SafeParcelWriter.writeLong(parcel, 2, getIntervalMillis());
        SafeParcelWriter.writeLong(parcel, 3, getMinUpdateIntervalMillis());
        SafeParcelWriter.writeInt(parcel, 6, getMaxUpdates());
        SafeParcelWriter.writeFloat(parcel, 7, getMinUpdateDistanceMeters());
        SafeParcelWriter.writeLong(parcel, 8, getMaxUpdateDelayMillis());
        SafeParcelWriter.writeBoolean(parcel, 9, isWaitForAccurateLocation());
        SafeParcelWriter.writeLong(parcel, 10, getDurationMillis());
        SafeParcelWriter.writeLong(parcel, 11, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 12, getGranularity());
        SafeParcelWriter.writeInt(parcel, 13, this.zzk);
        SafeParcelWriter.writeString(parcel, 14, this.zzl, false);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzm);
        SafeParcelWriter.writeParcelable(parcel, 16, this.zzn, i3, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzo, i3, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Pure
    public final int zza() {
        return this.zzk;
    }

    @Pure
    public final WorkSource zzb() {
        return this.zzn;
    }

    @Pure
    public final com.google.android.gms.internal.location.zzd zzc() {
        return this.zzo;
    }

    @Deprecated
    @Pure
    public final String zzd() {
        return this.zzl;
    }

    @Pure
    public final boolean zze() {
        return this.zzm;
    }
}
