package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* loaded from: /root/release/classes.dex */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    final int zzb;
    private final int zzc;
    private final String zzd;
    private final PendingIntent zze;
    private final ConnectionResult zzf;
    public static final Status RESULT_SUCCESS_CACHE = new Status(-1);
    public static final Status RESULT_SUCCESS = new Status(0);
    public static final Status RESULT_INTERRUPTED = new Status(14);
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);
    public static final Status RESULT_TIMEOUT = new Status(15);
    public static final Status RESULT_CANCELED = new Status(16);
    public static final Status zza = new Status(17);
    public static final Status RESULT_DEAD_CLIENT = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new zzb();

    public Status(int i3) {
        this(i3, (String) null);
    }

    Status(int i3, int i4, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = str;
        this.zze = pendingIntent;
        this.zzf = connectionResult;
    }

    public Status(int i3, String str) {
        this(1, i3, str, null, null);
    }

    public Status(int i3, String str, PendingIntent pendingIntent) {
        this(1, i3, str, pendingIntent, null);
    }

    public Status(ConnectionResult connectionResult, String str) {
        this(connectionResult, str, 17);
    }

    @Deprecated
    public Status(ConnectionResult connectionResult, String str, int i3) {
        this(1, i3, str, connectionResult.getResolution(), connectionResult);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.zzb == status.zzb && this.zzc == status.zzc && Objects.equal(this.zzd, status.zzd) && Objects.equal(this.zze, status.zze) && Objects.equal(this.zzf, status.zzf);
    }

    public ConnectionResult getConnectionResult() {
        return this.zzf;
    }

    public PendingIntent getResolution() {
        return this.zze;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this;
    }

    @ResultIgnorabilityUnspecified
    public int getStatusCode() {
        return this.zzc;
    }

    public String getStatusMessage() {
        return this.zzd;
    }

    public boolean hasResolution() {
        return this.zze != null;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd, this.zze, this.zzf);
    }

    public boolean isCanceled() {
        return this.zzc == 16;
    }

    public boolean isInterrupted() {
        return this.zzc == 14;
    }

    @CheckReturnValue
    public boolean isSuccess() {
        return this.zzc <= 0;
    }

    public void startResolutionForResult(Activity activity, int i3) {
        if (hasResolution()) {
            PendingIntent pendingIntent = this.zze;
            Preconditions.checkNotNull(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i3, null, 0, 0, 0);
        }
    }

    public String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("statusCode", zza());
        stringHelper.add("resolution", this.zze);
        return stringHelper.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getStatusCode());
        SafeParcelWriter.writeString(parcel, 2, getStatusMessage(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zze, i3, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getConnectionResult(), i3, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zza() {
        String str = this.zzd;
        return str != null ? str : CommonStatusCodes.getStatusCodeString(this.zzc);
    }
}
