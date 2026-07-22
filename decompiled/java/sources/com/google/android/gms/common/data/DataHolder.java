package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new zaf();
    private static final Builder zaf = new zab(new String[0], null);
    final int zaa;
    Bundle zab;
    int[] zac;
    int zad;
    boolean zae;
    private final String[] zag;
    private final CursorWindow[] zah;
    private final int zai;
    private final Bundle zaj;
    private boolean zak;

    public static class Builder {
        private final String[] zaa;
        private final ArrayList zab = new ArrayList();
        private final HashMap zac = new HashMap();

        /* synthetic */ Builder(String[] strArr, String str, zac zacVar) {
            this.zaa = (String[]) Preconditions.checkNotNull(strArr);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DataHolder build(int i3) {
            return new DataHolder(this, i3);
        }

        public DataHolder build(int i3, Bundle bundle) {
            return new DataHolder(this, i3, bundle);
        }

        public Builder withRow(ContentValues contentValues) {
            Asserts.checkNotNull(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return zaa(hashMap);
        }

        public Builder zaa(HashMap hashMap) {
            Asserts.checkNotNull(hashMap);
            this.zab.add(hashMap);
            return this;
        }
    }

    DataHolder(int i3, String[] strArr, CursorWindow[] cursorWindowArr, int i4, Bundle bundle) {
        this.zae = false;
        this.zak = true;
        this.zaa = i3;
        this.zag = strArr;
        this.zah = cursorWindowArr;
        this.zai = i4;
        this.zaj = bundle;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DataHolder(android.database.Cursor r8, int r9, android.os.Bundle r10) {
        /*
            r7 = this;
            com.google.android.gms.common.sqlite.CursorWrapper r0 = new com.google.android.gms.common.sqlite.CursorWrapper
            r0.<init>(r8)
            java.lang.String[] r8 = r0.getColumnNames()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r0.getCount()     // Catch: java.lang.Throwable -> L76
            android.database.CursorWindow r3 = r0.getWindow()     // Catch: java.lang.Throwable -> L76
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L2e
            int r6 = r3.getStartPosition()     // Catch: java.lang.Throwable -> L76
            if (r6 != 0) goto L2e
            r3.acquireReference()     // Catch: java.lang.Throwable -> L76
            r0.setWindow(r4)     // Catch: java.lang.Throwable -> L76
            r1.add(r3)     // Catch: java.lang.Throwable -> L76
            int r3 = r3.getNumRows()     // Catch: java.lang.Throwable -> L76
            goto L2f
        L2e:
            r3 = 0
        L2f:
            if (r3 >= r2) goto L63
            boolean r6 = r0.moveToPosition(r3)     // Catch: java.lang.Throwable -> L76
            if (r6 == 0) goto L63
            android.database.CursorWindow r6 = r0.getWindow()     // Catch: java.lang.Throwable -> L76
            if (r6 == 0) goto L44
            r6.acquireReference()     // Catch: java.lang.Throwable -> L76
            r0.setWindow(r4)     // Catch: java.lang.Throwable -> L76
            goto L4f
        L44:
            android.database.CursorWindow r6 = new android.database.CursorWindow     // Catch: java.lang.Throwable -> L76
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L76
            r6.setStartPosition(r3)     // Catch: java.lang.Throwable -> L76
            r0.fillWindow(r3, r6)     // Catch: java.lang.Throwable -> L76
        L4f:
            int r3 = r6.getNumRows()     // Catch: java.lang.Throwable -> L76
            if (r3 != 0) goto L56
            goto L63
        L56:
            r1.add(r6)     // Catch: java.lang.Throwable -> L76
            int r3 = r6.getStartPosition()     // Catch: java.lang.Throwable -> L76
            int r6 = r6.getNumRows()     // Catch: java.lang.Throwable -> L76
            int r3 = r3 + r6
            goto L2f
        L63:
            r0.close()
            int r0 = r1.size()
            android.database.CursorWindow[] r0 = new android.database.CursorWindow[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            android.database.CursorWindow[] r0 = (android.database.CursorWindow[]) r0
            r7.<init>(r8, r0, r9, r10)
            return
        L76:
            r8 = move-exception
            r0.close()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.<init>(android.database.Cursor, int, android.os.Bundle):void");
    }

    private DataHolder(Builder builder, int i3, Bundle bundle) {
        this(builder.zaa, zaf(builder, -1), i3, (Bundle) null);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i3, Bundle bundle) {
        this.zae = false;
        this.zak = true;
        this.zaa = 1;
        this.zag = (String[]) Preconditions.checkNotNull(strArr);
        this.zah = (CursorWindow[]) Preconditions.checkNotNull(cursorWindowArr);
        this.zai = i3;
        this.zaj = bundle;
        zad();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder builder(String[] strArr) {
        return new Builder(strArr, null, 0 == true ? 1 : 0);
    }

    public static DataHolder empty(int i3) {
        return new DataHolder(zaf, i3, (Bundle) null);
    }

    private final void zae(String str, int i3) {
        Bundle bundle = this.zab;
        if (bundle == null || !bundle.containsKey(str)) {
            throw new IllegalArgumentException("No such column: ".concat(String.valueOf(str)));
        }
        if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i3 < 0 || i3 >= this.zad) {
            throw new CursorIndexOutOfBoundsException(i3, this.zad);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x012e, code lost:
    
        if (r5 != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0130, code lost:
    
        android.util.Log.d("DataHolder", "Couldn't populate window data for row " + r4 + " - allocating new window.");
        r2.freeLastRow();
        r2 = new android.database.CursorWindow(false);
        r2.setStartPosition(r4);
        r2.setNumColumns(r13.zaa.length);
        r3.add(r2);
        r4 = r4 - 1;
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0163, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x016d, code lost:
    
        throw new com.google.android.gms.common.data.zad("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.database.CursorWindow[] zaf(com.google.android.gms.common.data.DataHolder.Builder r13, int r14) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.zaf(com.google.android.gms.common.data.DataHolder$Builder, int):android.database.CursorWindow[]");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.zae) {
                this.zae = true;
                int i3 = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.zah;
                    if (i3 >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i3].close();
                    i3++;
                }
            }
        }
    }

    protected final void finalize() {
        try {
            if (this.zak && this.zah.length > 0 && !isClosed()) {
                close();
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: " + toString() + ")");
            }
        } finally {
            super.finalize();
        }
    }

    public boolean getBoolean(String str, int i3, int i4) {
        zae(str, i3);
        return Long.valueOf(this.zah[i4].getLong(i3, this.zab.getInt(str))).longValue() == 1;
    }

    public byte[] getByteArray(String str, int i3, int i4) {
        zae(str, i3);
        return this.zah[i4].getBlob(i3, this.zab.getInt(str));
    }

    public int getCount() {
        return this.zad;
    }

    public int getInteger(String str, int i3, int i4) {
        zae(str, i3);
        return this.zah[i4].getInt(i3, this.zab.getInt(str));
    }

    public long getLong(String str, int i3, int i4) {
        zae(str, i3);
        return this.zah[i4].getLong(i3, this.zab.getInt(str));
    }

    public Bundle getMetadata() {
        return this.zaj;
    }

    public int getStatusCode() {
        return this.zai;
    }

    public String getString(String str, int i3, int i4) {
        zae(str, i3);
        return this.zah[i4].getString(i3, this.zab.getInt(str));
    }

    public int getWindowIndex(int i3) {
        int length;
        int i4 = 0;
        Preconditions.checkState(i3 >= 0 && i3 < this.zad);
        while (true) {
            int[] iArr = this.zac;
            length = iArr.length;
            if (i4 >= length) {
                break;
            }
            if (i3 < iArr[i4]) {
                i4--;
                break;
            }
            i4++;
        }
        return i4 == length ? i4 - 1 : i4;
    }

    public boolean hasColumn(String str) {
        return this.zab.containsKey(str);
    }

    public boolean hasNull(String str, int i3, int i4) {
        zae(str, i3);
        return this.zah[i4].isNull(i3, this.zab.getInt(str));
    }

    public boolean isClosed() {
        boolean z3;
        synchronized (this) {
            z3 = this.zae;
        }
        return z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.zag, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zah, i3, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zaa);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i3 & 1) != 0) {
            close();
        }
    }

    public final double zaa(String str, int i3, int i4) {
        zae(str, i3);
        return this.zah[i4].getDouble(i3, this.zab.getInt(str));
    }

    public final float zab(String str, int i3, int i4) {
        zae(str, i3);
        return this.zah[i4].getFloat(i3, this.zab.getInt(str));
    }

    public final void zac(String str, int i3, int i4, CharArrayBuffer charArrayBuffer) {
        zae(str, i3);
        this.zah[i4].copyStringToBuffer(i3, this.zab.getInt(str), charArrayBuffer);
    }

    public final void zad() {
        this.zab = new Bundle();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            String[] strArr = this.zag;
            if (i4 >= strArr.length) {
                break;
            }
            this.zab.putInt(strArr[i4], i4);
            i4++;
        }
        this.zac = new int[this.zah.length];
        int i5 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.zah;
            if (i3 >= cursorWindowArr.length) {
                this.zad = i5;
                return;
            }
            this.zac[i3] = i5;
            i5 += this.zah[i3].getNumRows() - (i5 - cursorWindowArr[i3].getStartPosition());
            i3++;
        }
    }
}
