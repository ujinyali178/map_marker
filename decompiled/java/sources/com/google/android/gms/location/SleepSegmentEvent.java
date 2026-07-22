package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public class SleepSegmentEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SleepSegmentEvent> CREATOR = new zzag();
    public static final int STATUS_MISSING_DATA = 1;
    public static final int STATUS_NOT_DETECTED = 2;
    public static final int STATUS_SUCCESSFUL = 0;
    private final long zza;
    private final long zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;

    public SleepSegmentEvent(long j3, long j4, int i3, int i4, int i5) {
        Preconditions.checkArgument(j3 <= j4, "endTimeMillis must be greater than or equal to startTimeMillis");
        this.zza = j3;
        this.zzb = j4;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
    }

    public static List<SleepSegmentEvent> extractEvents(Intent intent) {
        ArrayList arrayList;
        Preconditions.checkNotNull(intent);
        if (hasEvents(intent) && (arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.internal.EXTRA_SLEEP_SEGMENT_RESULT")) != null) {
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                byte[] bArr = (byte[]) arrayList.get(i3);
                Preconditions.checkNotNull(bArr);
                arrayList2.add((SleepSegmentEvent) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR));
            }
            return Collections.unmodifiableList(arrayList2);
        }
        return Collections.emptyList();
    }

    public static boolean hasEvents(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.location.internal.EXTRA_SLEEP_SEGMENT_RESULT");
    }

    public boolean equals(Object obj) {
        if (obj instanceof SleepSegmentEvent) {
            SleepSegmentEvent sleepSegmentEvent = (SleepSegmentEvent) obj;
            if (this.zza == sleepSegmentEvent.getStartTimeMillis() && this.zzb == sleepSegmentEvent.getEndTimeMillis() && this.zzc == sleepSegmentEvent.getStatus() && this.zzd == sleepSegmentEvent.zzd && this.zze == sleepSegmentEvent.zze) {
                return true;
            }
        }
        return false;
    }

    public long getEndTimeMillis() {
        return this.zzb;
    }

    public long getSegmentDurationMillis() {
        return this.zzb - this.zza;
    }

    public long getStartTimeMillis() {
        return this.zza;
    }

    public int getStatus() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Long.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    public String toString() {
        return "startMillis=" + this.zza + ", endMillis=" + this.zzb + ", status=" + this.zzc;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getStartTimeMillis());
        SafeParcelWriter.writeLong(parcel, 2, getEndTimeMillis());
        SafeParcelWriter.writeInt(parcel, 3, getStatus());
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
