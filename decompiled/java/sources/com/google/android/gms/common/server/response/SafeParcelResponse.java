package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zaq();
    private final int zaa;
    private final Parcel zab;
    private final int zac;
    private final zan zad;
    private final String zae;
    private int zaf;
    private int zag;

    SafeParcelResponse(int i3, Parcel parcel, zan zanVar) {
        this.zaa = i3;
        this.zab = (Parcel) Preconditions.checkNotNull(parcel);
        this.zac = 2;
        this.zad = zanVar;
        this.zae = zanVar == null ? null : zanVar.zaa();
        this.zaf = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, zan zanVar, String str) {
        this.zaa = 1;
        Parcel obtain = Parcel.obtain();
        this.zab = obtain;
        safeParcelable.writeToParcel(obtain, 0);
        this.zac = 1;
        this.zad = (zan) Preconditions.checkNotNull(zanVar);
        this.zae = (String) Preconditions.checkNotNull(str);
        this.zaf = 2;
    }

    public SafeParcelResponse(zan zanVar, String str) {
        this.zaa = 1;
        this.zab = Parcel.obtain();
        this.zac = 0;
        this.zad = (zan) Preconditions.checkNotNull(zanVar);
        this.zae = (String) Preconditions.checkNotNull(str);
        this.zaf = 0;
    }

    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse from(T t3) {
        String str = (String) Preconditions.checkNotNull(t3.getClass().getCanonicalName());
        zan zanVar = new zan(t3.getClass());
        zaF(zanVar, t3);
        zanVar.zac();
        zanVar.zad();
        return new SafeParcelResponse(t3, zanVar, str);
    }

    private static void zaF(zan zanVar, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (zanVar.zaf(cls)) {
            return;
        }
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        zanVar.zae(cls, fieldMappings);
        Iterator<String> it = fieldMappings.keySet().iterator();
        while (it.hasNext()) {
            FastJsonResponse.Field<?, ?> field = fieldMappings.get(it.next());
            Class cls2 = field.zag;
            if (cls2 != null) {
                try {
                    zaF(zanVar, (FastJsonResponse) cls2.newInstance());
                } catch (IllegalAccessException e3) {
                    throw new IllegalStateException("Could not access object of type ".concat(String.valueOf(((Class) Preconditions.checkNotNull(field.zag)).getCanonicalName())), e3);
                } catch (InstantiationException e4) {
                    throw new IllegalStateException("Could not instantiate an object of type ".concat(String.valueOf(((Class) Preconditions.checkNotNull(field.zag)).getCanonicalName())), e4);
                }
            }
        }
    }

    private final void zaG(FastJsonResponse.Field field) {
        if (field.zaf == -1) {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
        Parcel parcel = this.zab;
        if (parcel == null) {
            throw new IllegalStateException("Internal Parcel object is null.");
        }
        int i3 = this.zaf;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
            }
        } else {
            this.zag = SafeParcelWriter.beginObjectHeader(parcel);
            this.zaf = 1;
        }
    }

    private final void zaH(StringBuilder sb, Map map, Parcel parcel) {
        Object createBigInteger;
        String escapeString;
        String str;
        Object valueOf;
        Object zaD;
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) entry.getValue()).getSafeParcelableFieldId(), entry);
        }
        sb.append('{');
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z3 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.getFieldId(readHeader));
            if (entry2 != null) {
                if (z3) {
                    sb.append(",");
                }
                String str2 = (String) entry2.getKey();
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry2.getValue();
                sb.append("\"");
                sb.append(str2);
                sb.append("\":");
                if (field.zaj()) {
                    int i3 = field.zac;
                    switch (i3) {
                        case 0:
                            valueOf = Integer.valueOf(SafeParcelReader.readInt(parcel, readHeader));
                            zaD = FastJsonResponse.zaD(field, valueOf);
                            zaJ(sb, field, zaD);
                            break;
                        case 1:
                            valueOf = SafeParcelReader.createBigInteger(parcel, readHeader);
                            zaD = FastJsonResponse.zaD(field, valueOf);
                            zaJ(sb, field, zaD);
                            break;
                        case 2:
                            valueOf = Long.valueOf(SafeParcelReader.readLong(parcel, readHeader));
                            zaD = FastJsonResponse.zaD(field, valueOf);
                            zaJ(sb, field, zaD);
                            break;
                        case 3:
                            valueOf = Float.valueOf(SafeParcelReader.readFloat(parcel, readHeader));
                            zaD = FastJsonResponse.zaD(field, valueOf);
                            zaJ(sb, field, zaD);
                            break;
                        case 4:
                            valueOf = Double.valueOf(SafeParcelReader.readDouble(parcel, readHeader));
                            zaD = FastJsonResponse.zaD(field, valueOf);
                            zaJ(sb, field, zaD);
                            break;
                        case 5:
                            valueOf = SafeParcelReader.createBigDecimal(parcel, readHeader);
                            zaD = FastJsonResponse.zaD(field, valueOf);
                            zaJ(sb, field, zaD);
                            break;
                        case 6:
                            valueOf = Boolean.valueOf(SafeParcelReader.readBoolean(parcel, readHeader));
                            zaD = FastJsonResponse.zaD(field, valueOf);
                            zaJ(sb, field, zaD);
                            break;
                        case 7:
                            valueOf = SafeParcelReader.createString(parcel, readHeader);
                            zaD = FastJsonResponse.zaD(field, valueOf);
                            zaJ(sb, field, zaD);
                            break;
                        case 8:
                        case 9:
                            zaD = FastJsonResponse.zaD(field, SafeParcelReader.createByteArray(parcel, readHeader));
                            zaJ(sb, field, zaD);
                            break;
                        case 10:
                            Bundle createBundle = SafeParcelReader.createBundle(parcel, readHeader);
                            HashMap hashMap = new HashMap();
                            for (String str3 : createBundle.keySet()) {
                                hashMap.put(str3, (String) Preconditions.checkNotNull(createBundle.getString(str3)));
                            }
                            zaD = FastJsonResponse.zaD(field, hashMap);
                            zaJ(sb, field, zaD);
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException("Unknown field out type = " + i3);
                    }
                } else {
                    if (field.zad) {
                        sb.append("[");
                        switch (field.zac) {
                            case 0:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createIntArray(parcel, readHeader));
                                break;
                            case 1:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createBigIntegerArray(parcel, readHeader));
                                break;
                            case 2:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createLongArray(parcel, readHeader));
                                break;
                            case 3:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createFloatArray(parcel, readHeader));
                                break;
                            case 4:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createDoubleArray(parcel, readHeader));
                                break;
                            case 5:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createBigDecimalArray(parcel, readHeader));
                                break;
                            case 6:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createBooleanArray(parcel, readHeader));
                                break;
                            case 7:
                                ArrayUtils.writeStringArray(sb, SafeParcelReader.createStringArray(parcel, readHeader));
                                break;
                            case 8:
                            case 9:
                            case 10:
                                throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                            case 11:
                                Parcel[] createParcelArray = SafeParcelReader.createParcelArray(parcel, readHeader);
                                int length = createParcelArray.length;
                                for (int i4 = 0; i4 < length; i4++) {
                                    if (i4 > 0) {
                                        sb.append(",");
                                    }
                                    createParcelArray[i4].setDataPosition(0);
                                    zaH(sb, field.zah(), createParcelArray[i4]);
                                }
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out.");
                        }
                        str = "]";
                    } else {
                        switch (field.zac) {
                            case 0:
                                sb.append(SafeParcelReader.readInt(parcel, readHeader));
                                break;
                            case 1:
                                createBigInteger = SafeParcelReader.createBigInteger(parcel, readHeader);
                                sb.append(createBigInteger);
                                break;
                            case 2:
                                sb.append(SafeParcelReader.readLong(parcel, readHeader));
                                break;
                            case 3:
                                sb.append(SafeParcelReader.readFloat(parcel, readHeader));
                                break;
                            case 4:
                                sb.append(SafeParcelReader.readDouble(parcel, readHeader));
                                break;
                            case 5:
                                createBigInteger = SafeParcelReader.createBigDecimal(parcel, readHeader);
                                sb.append(createBigInteger);
                                break;
                            case 6:
                                sb.append(SafeParcelReader.readBoolean(parcel, readHeader));
                                break;
                            case 7:
                                String createString = SafeParcelReader.createString(parcel, readHeader);
                                sb.append("\"");
                                escapeString = JsonUtils.escapeString(createString);
                                sb.append(escapeString);
                                sb.append("\"");
                                break;
                            case 8:
                                byte[] createByteArray = SafeParcelReader.createByteArray(parcel, readHeader);
                                sb.append("\"");
                                escapeString = Base64Utils.encode(createByteArray);
                                sb.append(escapeString);
                                sb.append("\"");
                                break;
                            case 9:
                                byte[] createByteArray2 = SafeParcelReader.createByteArray(parcel, readHeader);
                                sb.append("\"");
                                escapeString = Base64Utils.encodeUrlSafe(createByteArray2);
                                sb.append(escapeString);
                                sb.append("\"");
                                break;
                            case 10:
                                Bundle createBundle2 = SafeParcelReader.createBundle(parcel, readHeader);
                                Set<String> keySet = createBundle2.keySet();
                                sb.append("{");
                                boolean z4 = true;
                                for (String str4 : keySet) {
                                    if (!z4) {
                                        sb.append(",");
                                    }
                                    sb.append("\"");
                                    sb.append(str4);
                                    sb.append("\":\"");
                                    sb.append(JsonUtils.escapeString(createBundle2.getString(str4)));
                                    sb.append("\"");
                                    z4 = false;
                                }
                                str = "}";
                                break;
                            case 11:
                                Parcel createParcel = SafeParcelReader.createParcel(parcel, readHeader);
                                createParcel.setDataPosition(0);
                                zaH(sb, field.zah(), createParcel);
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out");
                        }
                    }
                    sb.append(str);
                }
                z3 = true;
            }
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            sb.append('}');
            return;
        }
        throw new SafeParcelReader.ParseException("Overread allowed size end=" + validateObjectHeader, parcel);
    }

    private static final void zaI(StringBuilder sb, int i3, Object obj) {
        switch (i3) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(JsonUtils.escapeString(Preconditions.checkNotNull(obj).toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(Base64Utils.encode((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(Base64Utils.encodeUrlSafe((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                MapUtils.writeStringMapToJson(sb, (HashMap) Preconditions.checkNotNull(obj));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i3);
        }
    }

    private static final void zaJ(StringBuilder sb, FastJsonResponse.Field field, Object obj) {
        if (!field.zab) {
            zaI(sb, field.zaa, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb.append("[");
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            zaI(sb, field.zaa, arrayList.get(i3));
        }
        sb.append("]");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field field, String str, ArrayList<T> arrayList) {
        zaG(field);
        ArrayList arrayList2 = new ArrayList();
        ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList2.add(((SafeParcelResponse) arrayList.get(i3)).zaE());
        }
        SafeParcelWriter.writeParcelList(this.zab, field.getSafeParcelableFieldId(), arrayList2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field field, String str, T t3) {
        zaG(field);
        SafeParcelWriter.writeParcel(this.zab, field.getSafeParcelableFieldId(), ((SafeParcelResponse) t3).zaE(), true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        zan zanVar = this.zad;
        if (zanVar == null) {
            return null;
        }
        return zanVar.zab((String) Preconditions.checkNotNull(this.zae));
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setBooleanInternal(FastJsonResponse.Field<?, ?> field, String str, boolean z3) {
        zaG(field);
        SafeParcelWriter.writeBoolean(this.zab, field.getSafeParcelableFieldId(), z3);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        zaG(field);
        SafeParcelWriter.writeByteArray(this.zab, field.getSafeParcelableFieldId(), bArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, int i3) {
        zaG(field);
        SafeParcelWriter.writeInt(this.zab, field.getSafeParcelableFieldId(), i3);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setLongInternal(FastJsonResponse.Field<?, ?> field, String str, long j3) {
        zaG(field);
        SafeParcelWriter.writeLong(this.zab, field.getSafeParcelableFieldId(), j3);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        zaG(field);
        SafeParcelWriter.writeString(this.zab, field.getSafeParcelableFieldId(), str2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setStringMapInternal(FastJsonResponse.Field<?, ?> field, String str, Map<String, String> map) {
        zaG(field);
        Bundle bundle = new Bundle();
        for (String str2 : ((Map) Preconditions.checkNotNull(map)).keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        SafeParcelWriter.writeBundle(this.zab, field.getSafeParcelableFieldId(), bundle, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void setStringsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        String[] strArr = new String[size];
        for (int i3 = 0; i3 < size; i3++) {
            strArr[i3] = arrayList.get(i3);
        }
        SafeParcelWriter.writeStringArray(this.zab, field.getSafeParcelableFieldId(), strArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final String toString() {
        Preconditions.checkNotNull(this.zad, "Cannot convert to JSON on client side.");
        Parcel zaE = zaE();
        zaE.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zaH(sb, (Map) Preconditions.checkNotNull(this.zad.zab((String) Preconditions.checkNotNull(this.zae))), zaE);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeParcel(parcel, 2, zaE(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zac != 0 ? this.zad : null, i3, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final Parcel zaE() {
        int i3 = this.zaf;
        if (i3 != 0) {
            if (i3 == 1) {
                SafeParcelWriter.finishObjectHeader(this.zab, this.zag);
            }
            return this.zab;
        }
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(this.zab);
        this.zag = beginObjectHeader;
        SafeParcelWriter.finishObjectHeader(this.zab, beginObjectHeader);
        this.zaf = 2;
        return this.zab;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zab(FastJsonResponse.Field field, String str, BigDecimal bigDecimal) {
        zaG(field);
        SafeParcelWriter.writeBigDecimal(this.zab, field.getSafeParcelableFieldId(), bigDecimal, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zad(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i3 = 0; i3 < size; i3++) {
            bigDecimalArr[i3] = (BigDecimal) arrayList.get(i3);
        }
        SafeParcelWriter.writeBigDecimalArray(this.zab, field.getSafeParcelableFieldId(), bigDecimalArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zaf(FastJsonResponse.Field field, String str, BigInteger bigInteger) {
        zaG(field);
        SafeParcelWriter.writeBigInteger(this.zab, field.getSafeParcelableFieldId(), bigInteger, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zah(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i3 = 0; i3 < size; i3++) {
            bigIntegerArr[i3] = (BigInteger) arrayList.get(i3);
        }
        SafeParcelWriter.writeBigIntegerArray(this.zab, field.getSafeParcelableFieldId(), bigIntegerArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zak(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        boolean[] zArr = new boolean[size];
        for (int i3 = 0; i3 < size; i3++) {
            zArr[i3] = ((Boolean) arrayList.get(i3)).booleanValue();
        }
        SafeParcelWriter.writeBooleanArray(this.zab, field.getSafeParcelableFieldId(), zArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zan(FastJsonResponse.Field field, String str, double d3) {
        zaG(field);
        SafeParcelWriter.writeDouble(this.zab, field.getSafeParcelableFieldId(), d3);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zap(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        double[] dArr = new double[size];
        for (int i3 = 0; i3 < size; i3++) {
            dArr[i3] = ((Double) arrayList.get(i3)).doubleValue();
        }
        SafeParcelWriter.writeDoubleArray(this.zab, field.getSafeParcelableFieldId(), dArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zar(FastJsonResponse.Field field, String str, float f3) {
        zaG(field);
        SafeParcelWriter.writeFloat(this.zab, field.getSafeParcelableFieldId(), f3);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zat(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        float[] fArr = new float[size];
        for (int i3 = 0; i3 < size; i3++) {
            fArr[i3] = ((Float) arrayList.get(i3)).floatValue();
        }
        SafeParcelWriter.writeFloatArray(this.zab, field.getSafeParcelableFieldId(), fArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zaw(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        SafeParcelWriter.writeIntArray(this.zab, field.getSafeParcelableFieldId(), iArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void zaz(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        long[] jArr = new long[size];
        for (int i3 = 0; i3 < size; i3++) {
            jArr[i3] = ((Long) arrayList.get(i3)).longValue();
        }
        SafeParcelWriter.writeLongArray(this.zab, field.getSafeParcelableFieldId(), jArr, true);
    }
}
