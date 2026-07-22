package org.mapsforge.map.layer.hills;

import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.util.logging.Logger;
import org.mapsforge.map.layer.hills.HgtCache;

/* loaded from: /root/release/classes2.dex */
public class SimpleShadingAlgorithm implements ShadingAlgorithm {
    private static final Logger LOGGER = Logger.getLogger(SimpleShadingAlgorithm.class.getName());
    public final double linearity;
    private byte[] lookup;
    private int lookupOffset;
    public final double scale;

    public SimpleShadingAlgorithm() {
        this(0.1d, 0.666d);
    }

    public SimpleShadingAlgorithm(double d3, double d4) {
        this.linearity = Math.min(1.0d, Math.max(0.0d, d3));
        this.scale = Math.max(0.0d, d4);
    }

    private byte[] convert(MappedByteBuffer mappedByteBuffer, int i3, int i4, int i5) {
        short[] sArr = new short[i4];
        int i6 = i5 * 2;
        int i7 = i3 + i6;
        byte[] bArr = new byte[i7 * i7];
        byte[] bArr2 = this.lookup;
        if (bArr2 == null) {
            fillLookup();
            bArr2 = this.lookup;
        }
        int i8 = (i7 * i5) + i5;
        int i9 = 0;
        short s3 = 0;
        int i10 = 0;
        while (i9 < i4) {
            s3 = readNext(mappedByteBuffer, s3);
            sArr[i10] = s3;
            i9++;
            i10++;
        }
        for (int i11 = 1; i11 <= i3; i11++) {
            if (i10 >= i4) {
                i10 = 0;
            }
            short s4 = sArr[i10];
            short readNext = readNext(mappedByteBuffer, s4);
            sArr[i10] = readNext;
            i10++;
            int i12 = 1;
            while (i12 <= i3) {
                short s5 = sArr[i10];
                short readNext2 = readNext(mappedByteBuffer, s5);
                int i13 = i10 + 1;
                sArr[i10] = readNext2;
                bArr[i8] = (byte) (Math.min(255, Math.max(0, exaggerate(bArr2, -((readNext2 - s5) + (readNext - s4))) + exaggerate(bArr2, -((s5 - s4) + (readNext2 - readNext))) + 127)) & 255);
                i12++;
                i8++;
                readNext = readNext2;
                i10 = i13;
                s4 = s5;
            }
            i8 += i6;
        }
        return bArr;
    }

    private byte exaggerate(byte[] bArr, int i3) {
        return bArr[Math.max(0, Math.min(bArr.length - 1, i3 + this.lookupOffset))];
    }

    private void fillLookup() {
        int i3 = 0;
        while (i3 > -1024) {
            double round = Math.round(exaggerate(i3));
            if (round <= -128.0d || round >= 127.0d) {
                break;
            } else {
                i3--;
            }
        }
        int i4 = 0;
        while (i4 < 1024) {
            double round2 = Math.round(exaggerate(i4));
            if (round2 <= -128.0d || round2 >= 127.0d) {
                break;
            } else {
                i4++;
            }
        }
        int i5 = (i4 + 1) - i3;
        byte[] bArr = new byte[i5];
        int i6 = i3;
        for (int i7 = 0; i7 < i5; i7++) {
            bArr[i7] = (byte) Math.round(exaggerate(i6));
            i6++;
        }
        this.lookup = bArr;
        this.lookupOffset = -i3;
    }

    private static short readNext(ByteBuffer byteBuffer, short s3) {
        short s4 = byteBuffer.getShort();
        return s4 == Short.MIN_VALUE ? s3 : s4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SimpleShadingAlgorithm simpleShadingAlgorithm = (SimpleShadingAlgorithm) obj;
        return Double.compare(simpleShadingAlgorithm.linearity, this.linearity) == 0 && Double.compare(simpleShadingAlgorithm.scale, this.scale) == 0;
    }

    protected double exaggerate(double d3) {
        double max = Math.max(-128.0d, Math.min(127.0d, d3 * this.scale));
        double sin = Math.sin(Math.sin(Math.sin((max * 1.5707963267948966d) / 128.0d) * 1.5707963267948966d) * 1.5707963267948966d) * 128.0d;
        double d4 = this.linearity;
        return (sin * (1.0d - d4)) + (max * d4);
    }

    @Override // org.mapsforge.map.layer.hills.ShadingAlgorithm
    public int getAxisLenght(HgtCache.HgtFileInfo hgtFileInfo) {
        long size = hgtFileInfo.getSize();
        int ceil = (int) Math.ceil(Math.sqrt(size / 2));
        if (ceil * ceil * 2 != size) {
            return 0;
        }
        return ceil - 1;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.linearity);
        int i3 = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        long doubleToLongBits2 = Double.doubleToLongBits(this.scale);
        return (i3 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return "SimpleShadingAlgorithm{linearity=" + this.linearity + ", scale=" + this.scale + '}';
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // org.mapsforge.map.layer.hills.ShadingAlgorithm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.mapsforge.map.layer.hills.ShadingAlgorithm.RawShadingResult transformToByteBuffer(org.mapsforge.map.layer.hills.HgtCache.HgtFileInfo r12, int r13) {
        /*
            r11 = this;
            int r0 = r11.getAxisLenght(r12)
            int r1 = r0 + 1
            r2 = 0
            java.io.File r12 = r12.getFile()     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4a
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4a
            r3.<init>(r12)     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L4a
            java.nio.channels.FileChannel r10 = r3.getChannel()     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L44
            java.nio.channels.FileChannel$MapMode r5 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L6d
            r6 = 0
            long r8 = r12.length()     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L6d
            r4 = r10
            java.nio.MappedByteBuffer r12 = r4.map(r5, r6, r8)     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L6d
            java.nio.ByteOrder r4 = java.nio.ByteOrder.BIG_ENDIAN     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L6d
            r12.order(r4)     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L6d
            byte[] r12 = r11.convert(r12, r0, r1, r13)     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L6d
            org.mapsforge.map.layer.hills.ShadingAlgorithm$RawShadingResult r1 = new org.mapsforge.map.layer.hills.ShadingAlgorithm$RawShadingResult     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L6d
            r1.<init>(r12, r0, r0, r13)     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L6d
            r10.close()     // Catch: java.io.IOException -> L33
            goto L37
        L33:
            r12 = move-exception
            r12.printStackTrace()
        L37:
            r3.close()     // Catch: java.io.IOException -> L3b
            goto L3f
        L3b:
            r12 = move-exception
            r12.printStackTrace()
        L3f:
            return r1
        L40:
            r12 = move-exception
            goto L4d
        L42:
            r12 = move-exception
            goto L6f
        L44:
            r12 = move-exception
            r10 = r2
            goto L4d
        L47:
            r12 = move-exception
            r3 = r2
            goto L6f
        L4a:
            r12 = move-exception
            r3 = r2
            r10 = r3
        L4d:
            java.util.logging.Logger r13 = org.mapsforge.map.layer.hills.SimpleShadingAlgorithm.LOGGER     // Catch: java.lang.Throwable -> L6d
            java.util.logging.Level r0 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = r12.getMessage()     // Catch: java.lang.Throwable -> L6d
            r13.log(r0, r1, r12)     // Catch: java.lang.Throwable -> L6d
            if (r10 == 0) goto L62
            r10.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r12 = move-exception
            r12.printStackTrace()
        L62:
            if (r3 == 0) goto L6c
            r3.close()     // Catch: java.io.IOException -> L68
            goto L6c
        L68:
            r12 = move-exception
            r12.printStackTrace()
        L6c:
            return r2
        L6d:
            r12 = move-exception
            r2 = r10
        L6f:
            if (r2 == 0) goto L79
            r2.close()     // Catch: java.io.IOException -> L75
            goto L79
        L75:
            r13 = move-exception
            r13.printStackTrace()
        L79:
            if (r3 == 0) goto L83
            r3.close()     // Catch: java.io.IOException -> L7f
            goto L83
        L7f:
            r13 = move-exception
            r13.printStackTrace()
        L83:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mapsforge.map.layer.hills.SimpleShadingAlgorithm.transformToByteBuffer(org.mapsforge.map.layer.hills.HgtCache$HgtFileInfo, int):org.mapsforge.map.layer.hills.ShadingAlgorithm$RawShadingResult");
    }
}
