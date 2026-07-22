package org.mapsforge.map.layer.hills;

import java.io.File;
import org.mapsforge.core.graphics.HillshadingBitmap;
import org.mapsforge.map.layer.hills.HgtCache;

/* loaded from: /root/release/classes2.dex */
public interface ShadingAlgorithm {

    public interface RawHillTileSource {
        double eastLng();

        File getFile();

        HillshadingBitmap getFinishedConverted();

        long getSize();

        double northLat();

        double southLat();

        double westLng();
    }

    public static class RawShadingResult {
        public final byte[] bytes;
        public final int height;
        public final int padding;
        public final int width;

        public RawShadingResult(byte[] bArr, int i3, int i4, int i5) {
            this.bytes = bArr;
            this.width = i3;
            this.height = i4;
            this.padding = i5;
        }

        public void fillPadding() {
            if (this.padding < 1) {
                return;
            }
            fillPadding(HillshadingBitmap.Border.EAST);
            fillPadding(HillshadingBitmap.Border.WEST);
            fillPadding(HillshadingBitmap.Border.NORTH);
            fillPadding(HillshadingBitmap.Border.SOUTH);
            int i3 = this.padding;
            int i4 = this.width;
            int i5 = (i3 * 2) + i4;
            int i6 = i4 + i3;
            int i7 = this.height + i3;
            byte[] bArr = this.bytes;
            byte b4 = bArr[(i5 * i3) + i3];
            byte b5 = bArr[((i5 * i3) + i6) - 1];
            int i8 = (i7 - 1) * i5;
            byte b6 = bArr[i3 + i8];
            byte b7 = bArr[i8 + (i6 - 1)];
            int i9 = i7 * i5;
            int i10 = i9 + i6;
            for (int i11 = 0; i11 < this.padding; i11++) {
                int i12 = i5 * i11;
                for (int i13 = 0; i13 < this.padding; i13++) {
                    byte[] bArr2 = this.bytes;
                    int i14 = i13 + i12;
                    bArr2[i14] = b4;
                    bArr2[i14 + i6] = b5;
                    bArr2[i14 + i9] = b6;
                    bArr2[i14 + i10] = b7;
                }
            }
        }

        void fillPadding(HillshadingBitmap.Border border) {
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9 = this.padding;
            int i10 = this.width;
            int i11 = (i9 * 2) + i10;
            if (border.vertical) {
                int i12 = i10 + i9;
                int i13 = this.height;
                if (border == HillshadingBitmap.Border.WEST) {
                    i3 = i9 * i11;
                    i8 = i3 + i9;
                } else {
                    i3 = (i9 * i11) + i9 + i10;
                    i8 = i3 - 1;
                }
                i5 = 0;
                int i14 = i8;
                i10 = i9;
                i9 = i13;
                i7 = i12;
                i6 = i14;
            } else {
                int i15 = i9 * 2;
                if (border == HillshadingBitmap.Border.NORTH) {
                    i4 = (i11 * i9) + i9;
                    i3 = i9;
                } else {
                    i3 = ((this.height + i9) * i11) + i9;
                    i4 = i3 - i11;
                }
                i5 = 1;
                i6 = i4;
                i11 = -i10;
                i7 = i15;
            }
            for (int i16 = 0; i16 < i9; i16++) {
                for (int i17 = 0; i17 < i10; i17++) {
                    byte[] bArr = this.bytes;
                    bArr[i3] = bArr[i6];
                    i3++;
                    i6 += i5;
                }
                i3 += i7;
                i6 += i11;
            }
        }
    }

    int getAxisLenght(HgtCache.HgtFileInfo hgtFileInfo);

    RawShadingResult transformToByteBuffer(HgtCache.HgtFileInfo hgtFileInfo, int i3);
}
