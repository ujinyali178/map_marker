package com.google.android.gms.common.internal.safeparcel;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    public static int beginObjectHeader(Parcel parcel) {
        return zza(parcel, 20293);
    }

    public static void finishObjectHeader(Parcel parcel, int i3) {
        zzb(parcel, i3);
    }

    public static void writeBigDecimal(Parcel parcel, int i3, BigDecimal bigDecimal, boolean z3) {
        if (bigDecimal == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            zzb(parcel, zza);
        }
    }

    public static void writeBigDecimalArray(Parcel parcel, int i3, BigDecimal[] bigDecimalArr, boolean z3) {
        if (bigDecimalArr == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i4 = 0; i4 < length; i4++) {
            parcel.writeByteArray(bigDecimalArr[i4].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i4].scale());
        }
        zzb(parcel, zza);
    }

    public static void writeBigInteger(Parcel parcel, int i3, BigInteger bigInteger, boolean z3) {
        if (bigInteger == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeByteArray(bigInteger.toByteArray());
            zzb(parcel, zza);
        }
    }

    public static void writeBigIntegerArray(Parcel parcel, int i3, BigInteger[] bigIntegerArr, boolean z3) {
        if (bigIntegerArr == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        zzb(parcel, zza);
    }

    public static void writeBoolean(Parcel parcel, int i3, boolean z3) {
        zzc(parcel, i3, 4);
        parcel.writeInt(z3 ? 1 : 0);
    }

    public static void writeBooleanArray(Parcel parcel, int i3, boolean[] zArr, boolean z3) {
        if (zArr == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeBooleanArray(zArr);
            zzb(parcel, zza);
        }
    }

    public static void writeBooleanList(Parcel parcel, int i3, List<Boolean> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        int size = list.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            parcel.writeInt(list.get(i4).booleanValue() ? 1 : 0);
        }
        zzb(parcel, zza);
    }

    public static void writeBooleanObject(Parcel parcel, int i3, Boolean bool, boolean z3) {
        if (bool != null) {
            zzc(parcel, i3, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z3) {
            zzc(parcel, i3, 0);
        }
    }

    public static void writeBundle(Parcel parcel, int i3, Bundle bundle, boolean z3) {
        if (bundle == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeBundle(bundle);
            zzb(parcel, zza);
        }
    }

    public static void writeByte(Parcel parcel, int i3, byte b4) {
        zzc(parcel, i3, 4);
        parcel.writeInt(b4);
    }

    public static void writeByteArray(Parcel parcel, int i3, byte[] bArr, boolean z3) {
        if (bArr == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeByteArray(bArr);
            zzb(parcel, zza);
        }
    }

    public static void writeByteArrayArray(Parcel parcel, int i3, byte[][] bArr, boolean z3) {
        if (bArr == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        zzb(parcel, zza);
    }

    public static void writeByteArraySparseArray(Parcel parcel, int i3, SparseArray<byte[]> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            parcel.writeInt(sparseArray.keyAt(i4));
            parcel.writeByteArray(sparseArray.valueAt(i4));
        }
        zzb(parcel, zza);
    }

    public static void writeChar(Parcel parcel, int i3, char c3) {
        zzc(parcel, i3, 4);
        parcel.writeInt(c3);
    }

    public static void writeCharArray(Parcel parcel, int i3, char[] cArr, boolean z3) {
        if (cArr == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeCharArray(cArr);
            zzb(parcel, zza);
        }
    }

    public static void writeDouble(Parcel parcel, int i3, double d3) {
        zzc(parcel, i3, 8);
        parcel.writeDouble(d3);
    }

    public static void writeDoubleArray(Parcel parcel, int i3, double[] dArr, boolean z3) {
        if (dArr == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeDoubleArray(dArr);
            zzb(parcel, zza);
        }
    }

    public static void writeDoubleList(Parcel parcel, int i3, List<Double> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        int size = list.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            parcel.writeDouble(list.get(i4).doubleValue());
        }
        zzb(parcel, zza);
    }

    public static void writeDoubleObject(Parcel parcel, int i3, Double d3, boolean z3) {
        if (d3 != null) {
            zzc(parcel, i3, 8);
            parcel.writeDouble(d3.doubleValue());
        } else if (z3) {
            zzc(parcel, i3, 0);
        }
    }

    public static void writeDoubleSparseArray(Parcel parcel, int i3, SparseArray<Double> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            parcel.writeInt(sparseArray.keyAt(i4));
            parcel.writeDouble(sparseArray.valueAt(i4).doubleValue());
        }
        zzb(parcel, zza);
    }

    public static void writeFloat(Parcel parcel, int i3, float f3) {
        zzc(parcel, i3, 4);
        parcel.writeFloat(f3);
    }

    public static void writeFloatArray(Parcel parcel, int i3, float[] fArr, boolean z3) {
        if (fArr == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeFloatArray(fArr);
            zzb(parcel, zza);
        }
    }

    public static void writeFloatList(Parcel parcel, int i3, List<Float> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        int size = list.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            parcel.writeFloat(list.get(i4).floatValue());
        }
        zzb(parcel, zza);
    }

    public static void writeFloatObject(Parcel parcel, int i3, Float f3, boolean z3) {
        if (f3 != null) {
            zzc(parcel, i3, 4);
            parcel.writeFloat(f3.floatValue());
        } else if (z3) {
            zzc(parcel, i3, 0);
        }
    }

    public static void writeFloatSparseArray(Parcel parcel, int i3, SparseArray<Float> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            parcel.writeInt(sparseArray.keyAt(i4));
            parcel.writeFloat(sparseArray.valueAt(i4).floatValue());
        }
        zzb(parcel, zza);
    }

    public static void writeIBinder(Parcel parcel, int i3, IBinder iBinder, boolean z3) {
        if (iBinder == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeStrongBinder(iBinder);
            zzb(parcel, zza);
        }
    }

    public static void writeIBinderArray(Parcel parcel, int i3, IBinder[] iBinderArr, boolean z3) {
        if (iBinderArr == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeBinderArray(iBinderArr);
            zzb(parcel, zza);
        }
    }

    public static void writeIBinderList(Parcel parcel, int i3, List<IBinder> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeBinderList(list);
            zzb(parcel, zza);
        }
    }

    public static void writeIBinderSparseArray(Parcel parcel, int i3, SparseArray<IBinder> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            parcel.writeInt(sparseArray.keyAt(i4));
            parcel.writeStrongBinder(sparseArray.valueAt(i4));
        }
        zzb(parcel, zza);
    }

    public static void writeInt(Parcel parcel, int i3, int i4) {
        zzc(parcel, i3, 4);
        parcel.writeInt(i4);
    }

    public static void writeIntArray(Parcel parcel, int i3, int[] iArr, boolean z3) {
        if (iArr == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeIntArray(iArr);
            zzb(parcel, zza);
        }
    }

    public static void writeIntegerList(Parcel parcel, int i3, List<Integer> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        int size = list.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            parcel.writeInt(list.get(i4).intValue());
        }
        zzb(parcel, zza);
    }

    public static void writeIntegerObject(Parcel parcel, int i3, Integer num, boolean z3) {
        if (num != null) {
            zzc(parcel, i3, 4);
            parcel.writeInt(num.intValue());
        } else if (z3) {
            zzc(parcel, i3, 0);
        }
    }

    public static void writeList(Parcel parcel, int i3, List list, boolean z3) {
        if (list == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeList(list);
            zzb(parcel, zza);
        }
    }

    public static void writeLong(Parcel parcel, int i3, long j3) {
        zzc(parcel, i3, 8);
        parcel.writeLong(j3);
    }

    public static void writeLongArray(Parcel parcel, int i3, long[] jArr, boolean z3) {
        if (jArr == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeLongArray(jArr);
            zzb(parcel, zza);
        }
    }

    public static void writeLongList(Parcel parcel, int i3, List<Long> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        int size = list.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            parcel.writeLong(list.get(i4).longValue());
        }
        zzb(parcel, zza);
    }

    public static void writeLongObject(Parcel parcel, int i3, Long l3, boolean z3) {
        if (l3 != null) {
            zzc(parcel, i3, 8);
            parcel.writeLong(l3.longValue());
        } else if (z3) {
            zzc(parcel, i3, 0);
        }
    }

    public static void writeParcel(Parcel parcel, int i3, Parcel parcel2, boolean z3) {
        if (parcel2 == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            zzb(parcel, zza);
        }
    }

    public static void writeParcelArray(Parcel parcel, int i3, Parcel[] parcelArr, boolean z3) {
        if (parcelArr == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        parcel.writeInt(parcelArr.length);
        for (Parcel parcel2 : parcelArr) {
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzb(parcel, zza);
    }

    public static void writeParcelList(Parcel parcel, int i3, List<Parcel> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        int size = list.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            Parcel parcel2 = list.get(i4);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzb(parcel, zza);
    }

    public static void writeParcelSparseArray(Parcel parcel, int i3, SparseArray<Parcel> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            parcel.writeInt(sparseArray.keyAt(i4));
            Parcel valueAt = sparseArray.valueAt(i4);
            if (valueAt != null) {
                parcel.writeInt(valueAt.dataSize());
                parcel.appendFrom(valueAt, 0, valueAt.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzb(parcel, zza);
    }

    public static void writeParcelable(Parcel parcel, int i3, Parcelable parcelable, int i4, boolean z3) {
        if (parcelable == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcelable.writeToParcel(parcel, i4);
            zzb(parcel, zza);
        }
    }

    public static void writePendingIntent(Parcel parcel, int i3, PendingIntent pendingIntent, boolean z3) {
        if (pendingIntent == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            PendingIntent.writePendingIntentOrNullToParcel(pendingIntent, parcel);
            zzb(parcel, zza);
        }
    }

    public static void writeShort(Parcel parcel, int i3, short s3) {
        zzc(parcel, i3, 4);
        parcel.writeInt(s3);
    }

    public static void writeSparseBooleanArray(Parcel parcel, int i3, SparseBooleanArray sparseBooleanArray, boolean z3) {
        if (sparseBooleanArray == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            zzb(parcel, zza);
        }
    }

    public static void writeSparseIntArray(Parcel parcel, int i3, SparseIntArray sparseIntArray, boolean z3) {
        if (sparseIntArray == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        int size = sparseIntArray.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            parcel.writeInt(sparseIntArray.keyAt(i4));
            parcel.writeInt(sparseIntArray.valueAt(i4));
        }
        zzb(parcel, zza);
    }

    public static void writeSparseLongArray(Parcel parcel, int i3, SparseLongArray sparseLongArray, boolean z3) {
        if (sparseLongArray == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        int size = sparseLongArray.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            parcel.writeInt(sparseLongArray.keyAt(i4));
            parcel.writeLong(sparseLongArray.valueAt(i4));
        }
        zzb(parcel, zza);
    }

    public static void writeString(Parcel parcel, int i3, String str, boolean z3) {
        if (str == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeString(str);
            zzb(parcel, zza);
        }
    }

    public static void writeStringArray(Parcel parcel, int i3, String[] strArr, boolean z3) {
        if (strArr == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeStringArray(strArr);
            zzb(parcel, zza);
        }
    }

    public static void writeStringList(Parcel parcel, int i3, List<String> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zzc(parcel, i3, 0);
            }
        } else {
            int zza = zza(parcel, i3);
            parcel.writeStringList(list);
            zzb(parcel, zza);
        }
    }

    public static void writeStringSparseArray(Parcel parcel, int i3, SparseArray<String> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            parcel.writeInt(sparseArray.keyAt(i4));
            parcel.writeString(sparseArray.valueAt(i4));
        }
        zzb(parcel, zza);
    }

    public static <T extends Parcelable> void writeTypedArray(Parcel parcel, int i3, T[] tArr, int i4, boolean z3) {
        if (tArr == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        parcel.writeInt(tArr.length);
        for (T t3 : tArr) {
            if (t3 == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, t3, i4);
            }
        }
        zzb(parcel, zza);
    }

    public static <T extends Parcelable> void writeTypedList(Parcel parcel, int i3, List<T> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        int size = list.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            T t3 = list.get(i4);
            if (t3 == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, t3, 0);
            }
        }
        zzb(parcel, zza);
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel parcel, int i3, SparseArray<T> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                zzc(parcel, i3, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i3);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            parcel.writeInt(sparseArray.keyAt(i4));
            T valueAt = sparseArray.valueAt(i4);
            if (valueAt == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, valueAt, 0);
            }
        }
        zzb(parcel, zza);
    }

    private static int zza(Parcel parcel, int i3) {
        parcel.writeInt(i3 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void zzb(Parcel parcel, int i3) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i3 - 4);
        parcel.writeInt(dataPosition - i3);
        parcel.setDataPosition(dataPosition);
    }

    private static void zzc(Parcel parcel, int i3, int i4) {
        parcel.writeInt(i3 | (i4 << 16));
    }

    private static void zzd(Parcel parcel, Parcelable parcelable, int i3) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i3);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
