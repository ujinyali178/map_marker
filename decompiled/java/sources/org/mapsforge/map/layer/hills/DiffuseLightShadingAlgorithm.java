package org.mapsforge.map.layer.hills;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mapsforge.core.util.MercatorProjection;
import org.mapsforge.map.layer.hills.HgtCache;
import org.mapsforge.map.layer.hills.ShadingAlgorithm;

/* loaded from: /root/release/classes2.dex */
public class DiffuseLightShadingAlgorithm implements ShadingAlgorithm {
    private static final Logger LOGGER = Logger.getLogger(DiffuseLightShadingAlgorithm.class.getName());
    private static final double halfPi = 1.5707963267948966d;

    /* renamed from: a, reason: collision with root package name */
    private double f4078a;
    private final double ast2;
    private final float heightAngle;
    private final double neutral;

    public DiffuseLightShadingAlgorithm() {
        this(50.0f);
    }

    public DiffuseLightShadingAlgorithm(float f3) {
        this.heightAngle = f3;
        double heightAngleToRelativeHeight = heightAngleToRelativeHeight(f3);
        this.f4078a = heightAngleToRelativeHeight;
        this.ast2 = Math.sqrt((heightAngleToRelativeHeight * heightAngleToRelativeHeight) + 2.0d);
        this.neutral = calculateRaw(0.0d, 0.0d);
    }

    private byte[] convert(MappedByteBuffer mappedByteBuffer, int i3, int i4, int i5, HgtCache.HgtFileInfo hgtFileInfo) {
        MappedByteBuffer mappedByteBuffer2 = mappedByteBuffer;
        int i6 = i3;
        int i7 = i4;
        short[] sArr = new short[i7];
        int i8 = i5 * 2;
        int i9 = i6 + i8;
        byte[] bArr = new byte[i9 * i9];
        int i10 = (i9 * i5) + i5;
        int i11 = 0;
        short s3 = 0;
        int i12 = 0;
        while (i11 < i7) {
            s3 = readNext(mappedByteBuffer2, s3);
            sArr[i12] = s3;
            i11++;
            i12++;
        }
        long j3 = i6 * 170;
        double d3 = i6 * 2;
        double calculateGroundResolution = MercatorProjection.calculateGroundResolution(hgtFileInfo.southLat(), j3) / d3;
        double calculateGroundResolution2 = MercatorProjection.calculateGroundResolution(hgtFileInfo.northLat(), j3) / d3;
        int i13 = 1;
        while (i13 <= i6) {
            if (i12 >= i7) {
                i12 = 0;
            }
            short s4 = sArr[i12];
            short readNext = readNext(mappedByteBuffer2, s4);
            int i14 = i12 + 1;
            sArr[i12] = readNext;
            int i15 = i8;
            double d4 = calculateGroundResolution;
            double d5 = (i13 * calculateGroundResolution) + ((i6 - i13) * calculateGroundResolution2);
            int i16 = i10;
            int i17 = 1;
            while (i17 <= i6) {
                short s5 = sArr[i14];
                short readNext2 = readNext(mappedByteBuffer2, s5);
                sArr[i14] = readNext2;
                bArr[i16] = (byte) (Math.min(255, Math.max(0, calculate((-((readNext2 - s5) + (readNext - s4))) / d5, (-((s5 - s4) + (readNext2 - readNext))) / d5) + 127)) & 255);
                i17++;
                mappedByteBuffer2 = mappedByteBuffer;
                i6 = i3;
                i16++;
                s4 = s5;
                sArr = sArr;
                i14++;
                readNext = readNext2;
            }
            i10 = i16 + i15;
            i13++;
            mappedByteBuffer2 = mappedByteBuffer;
            i6 = i3;
            i7 = i4;
            i8 = i15;
            i12 = i14;
            calculateGroundResolution = d4;
        }
        return bArr;
    }

    static double heightAngleToRelativeHeight(float f3) {
        return Math.tan((f3 / 180.0d) * 3.141592653589793d) * Math.sqrt(2.0d);
    }

    private static short readNext(ByteBuffer byteBuffer, short s3) {
        short s4 = byteBuffer.getShort();
        return s4 == Short.MIN_VALUE ? s3 : s4;
    }

    int calculate(double d3, double d4) {
        double d5;
        double d6;
        double calculateRaw = calculateRaw(d3, d4);
        double d7 = this.neutral;
        double d8 = calculateRaw - d7;
        if (d8 < 0.0d) {
            d5 = 128.0d;
            d6 = d8 / d7;
        } else {
            if (d8 <= 0.0d) {
                return 0;
            }
            d5 = 127.0d;
            d6 = d8 / (1.0d - d7);
        }
        return (int) Math.round(d6 * d5);
    }

    double calculateRaw(double d3, double d4) {
        return Math.max(0.0d, ((d4 + d3) + this.f4078a) / (this.ast2 * Math.sqrt(((d3 * d3) + (d4 * d4)) + 1.0d)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Double.compare(((DiffuseLightShadingAlgorithm) obj).f4078a, this.f4078a) == 0;
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

    public double getLightHeight() {
        return this.f4078a;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f4078a);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public String toString() {
        return "DiffuseLightShadingAlgorithm{heightAngle=" + this.heightAngle + '}';
    }

    /* JADX WARN: Not initialized variable reg: 15, insn: 0x007e: MOVE (r7 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]), block:B:58:0x007d */
    @Override // org.mapsforge.map.layer.hills.ShadingAlgorithm
    public ShadingAlgorithm.RawShadingResult transformToByteBuffer(HgtCache.HgtFileInfo hgtFileInfo, int i3) {
        Throwable th;
        FileInputStream fileInputStream;
        FileChannel fileChannel;
        AbstractInterruptibleChannel abstractInterruptibleChannel;
        File file;
        int axisLenght = getAxisLenght(hgtFileInfo);
        int i4 = axisLenght + 1;
        AbstractInterruptibleChannel abstractInterruptibleChannel2 = null;
        try {
            try {
                file = hgtFileInfo.getFile();
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th2) {
                th = th2;
                abstractInterruptibleChannel2 = abstractInterruptibleChannel;
            }
        } catch (IOException e3) {
            e = e3;
            fileInputStream = null;
            fileChannel = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        try {
            fileChannel = fileInputStream.getChannel();
            try {
                MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, file.length());
                map.order(ByteOrder.BIG_ENDIAN);
                ShadingAlgorithm.RawShadingResult rawShadingResult = new ShadingAlgorithm.RawShadingResult(convert(map, axisLenght, i4, i3, hgtFileInfo), axisLenght, axisLenght, i3);
                try {
                    fileChannel.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return rawShadingResult;
            } catch (IOException e6) {
                e = e6;
                LOGGER.log(Level.SEVERE, e.getMessage(), (Throwable) e);
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                return null;
            }
        } catch (IOException e9) {
            e = e9;
            fileChannel = null;
        } catch (Throwable th4) {
            th = th4;
            if (abstractInterruptibleChannel2 != null) {
                try {
                    abstractInterruptibleChannel2.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
            if (fileInputStream == null) {
                throw th;
            }
            try {
                fileInputStream.close();
                throw th;
            } catch (IOException e11) {
                e11.printStackTrace();
                throw th;
            }
        }
    }
}
