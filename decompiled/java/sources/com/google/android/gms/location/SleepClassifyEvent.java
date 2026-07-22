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
public class SleepClassifyEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SleepClassifyEvent> CREATOR = new zzaf();
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final boolean zzh;
    private final int zzi;

    public SleepClassifyEvent(int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z3, int i10) {
        this.zza = i3;
        this.zzb = i4;
        this.zzc = i5;
        this.zzd = i6;
        this.zze = i7;
        this.zzf = i8;
        this.zzg = i9;
        this.zzh = z3;
        this.zzi = i10;
    }

    public static List<SleepClassifyEvent> extractEvents(Intent intent) {
        ArrayList arrayList;
        Preconditions.checkNotNull(intent);
        if (hasEvents(intent) && (arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.internal.EXTRA_SLEEP_CLASSIFY_RESULT")) != null) {
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                byte[] bArr = (byte[]) arrayList.get(i3);
                Preconditions.checkNotNull(bArr);
                arrayList2.add((SleepClassifyEvent) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR));
            }
            return Collections.unmodifiableList(arrayList2);
        }
        return Collections.emptyList();
    }

    public static boolean hasEvents(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.location.internal.EXTRA_SLEEP_CLASSIFY_RESULT");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepClassifyEvent)) {
            return false;
        }
        SleepClassifyEvent sleepClassifyEvent = (SleepClassifyEvent) obj;
        return this.zza == sleepClassifyEvent.zza && this.zzb == sleepClassifyEvent.zzb;
    }

    public int getConfidence() {
        return this.zzb;
    }

    public int getLight() {
        return this.zzd;
    }

    public int getMotion() {
        return this.zzc;
    }

    public long getTimestampMillis() {
        return this.zza * 1000;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb));
    }

    public String toString() {
        return this.zza + " Conf:" + this.zzb + " Motion:" + this.zzc + " Light:" + this.zzd;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, getConfidence());
        SafeParcelWriter.writeInt(parcel, 3, getMotion());
        SafeParcelWriter.writeInt(parcel, 4, getLight());
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeInt(parcel, 7, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
