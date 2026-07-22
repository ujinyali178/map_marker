package org.apache.commons.io;

import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: /root/release/classes2.dex */
public class EndianUtils {
    private static int read(InputStream inputStream) {
        int read = inputStream.read();
        if (-1 != read) {
            return read;
        }
        throw new EOFException("Unexpected EOF reached");
    }

    public static double readSwappedDouble(InputStream inputStream) {
        return Double.longBitsToDouble(readSwappedLong(inputStream));
    }

    public static double readSwappedDouble(byte[] bArr, int i3) {
        return Double.longBitsToDouble(readSwappedLong(bArr, i3));
    }

    public static float readSwappedFloat(InputStream inputStream) {
        return Float.intBitsToFloat(readSwappedInteger(inputStream));
    }

    public static float readSwappedFloat(byte[] bArr, int i3) {
        return Float.intBitsToFloat(readSwappedInteger(bArr, i3));
    }

    public static int readSwappedInteger(InputStream inputStream) {
        return ((read(inputStream) & 255) << 0) + ((read(inputStream) & 255) << 8) + ((read(inputStream) & 255) << 16) + ((read(inputStream) & 255) << 24);
    }

    public static int readSwappedInteger(byte[] bArr, int i3) {
        return ((bArr[i3 + 0] & UnsignedBytes.MAX_VALUE) << 0) + ((bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) << 8) + ((bArr[i3 + 2] & UnsignedBytes.MAX_VALUE) << 16) + ((bArr[i3 + 3] & UnsignedBytes.MAX_VALUE) << 24);
    }

    public static long readSwappedLong(InputStream inputStream) {
        byte[] bArr = new byte[8];
        for (int i3 = 0; i3 < 8; i3++) {
            bArr[i3] = (byte) read(inputStream);
        }
        return readSwappedLong(bArr, 0);
    }

    public static long readSwappedLong(byte[] bArr, int i3) {
        return (readSwappedInteger(bArr, i3 + 4) << 32) + (readSwappedInteger(bArr, i3) & 4294967295L);
    }

    public static short readSwappedShort(InputStream inputStream) {
        return (short) (((read(inputStream) & 255) << 0) + ((read(inputStream) & 255) << 8));
    }

    public static short readSwappedShort(byte[] bArr, int i3) {
        return (short) (((bArr[i3 + 0] & UnsignedBytes.MAX_VALUE) << 0) + ((bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) << 8));
    }

    public static long readSwappedUnsignedInteger(InputStream inputStream) {
        return ((read(inputStream) & 255) << 24) + ((((read(inputStream) & 255) << 0) + ((read(inputStream) & 255) << 8) + ((read(inputStream) & 255) << 16)) & 4294967295L);
    }

    public static long readSwappedUnsignedInteger(byte[] bArr, int i3) {
        return ((bArr[i3 + 3] & UnsignedBytes.MAX_VALUE) << 24) + ((((bArr[i3 + 0] & UnsignedBytes.MAX_VALUE) << 0) + ((bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) << 8) + ((bArr[i3 + 2] & UnsignedBytes.MAX_VALUE) << 16)) & 4294967295L);
    }

    public static int readSwappedUnsignedShort(InputStream inputStream) {
        return ((read(inputStream) & 255) << 0) + ((read(inputStream) & 255) << 8);
    }

    public static int readSwappedUnsignedShort(byte[] bArr, int i3) {
        return ((bArr[i3 + 0] & UnsignedBytes.MAX_VALUE) << 0) + ((bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) << 8);
    }

    public static double swapDouble(double d3) {
        return Double.longBitsToDouble(swapLong(Double.doubleToLongBits(d3)));
    }

    public static float swapFloat(float f3) {
        return Float.intBitsToFloat(swapInteger(Float.floatToIntBits(f3)));
    }

    public static int swapInteger(int i3) {
        return (((i3 >> 0) & 255) << 24) + (((i3 >> 8) & 255) << 16) + (((i3 >> 16) & 255) << 8) + (((i3 >> 24) & 255) << 0);
    }

    public static long swapLong(long j3) {
        return (((j3 >> 0) & 255) << 56) + (((j3 >> 8) & 255) << 48) + (((j3 >> 16) & 255) << 40) + (((j3 >> 24) & 255) << 32) + (((j3 >> 32) & 255) << 24) + (((j3 >> 40) & 255) << 16) + (((j3 >> 48) & 255) << 8) + (((j3 >> 56) & 255) << 0);
    }

    public static short swapShort(short s3) {
        return (short) ((((s3 >> 0) & 255) << 8) + (((s3 >> 8) & 255) << 0));
    }

    public static void writeSwappedDouble(OutputStream outputStream, double d3) {
        writeSwappedLong(outputStream, Double.doubleToLongBits(d3));
    }

    public static void writeSwappedDouble(byte[] bArr, int i3, double d3) {
        writeSwappedLong(bArr, i3, Double.doubleToLongBits(d3));
    }

    public static void writeSwappedFloat(OutputStream outputStream, float f3) {
        writeSwappedInteger(outputStream, Float.floatToIntBits(f3));
    }

    public static void writeSwappedFloat(byte[] bArr, int i3, float f3) {
        writeSwappedInteger(bArr, i3, Float.floatToIntBits(f3));
    }

    public static void writeSwappedInteger(OutputStream outputStream, int i3) {
        outputStream.write((byte) ((i3 >> 0) & 255));
        outputStream.write((byte) ((i3 >> 8) & 255));
        outputStream.write((byte) ((i3 >> 16) & 255));
        outputStream.write((byte) ((i3 >> 24) & 255));
    }

    public static void writeSwappedInteger(byte[] bArr, int i3, int i4) {
        bArr[i3 + 0] = (byte) ((i4 >> 0) & 255);
        bArr[i3 + 1] = (byte) ((i4 >> 8) & 255);
        bArr[i3 + 2] = (byte) ((i4 >> 16) & 255);
        bArr[i3 + 3] = (byte) ((i4 >> 24) & 255);
    }

    public static void writeSwappedLong(OutputStream outputStream, long j3) {
        outputStream.write((byte) ((j3 >> 0) & 255));
        outputStream.write((byte) ((j3 >> 8) & 255));
        outputStream.write((byte) ((j3 >> 16) & 255));
        outputStream.write((byte) ((j3 >> 24) & 255));
        outputStream.write((byte) ((j3 >> 32) & 255));
        outputStream.write((byte) ((j3 >> 40) & 255));
        outputStream.write((byte) ((j3 >> 48) & 255));
        outputStream.write((byte) ((j3 >> 56) & 255));
    }

    public static void writeSwappedLong(byte[] bArr, int i3, long j3) {
        bArr[i3 + 0] = (byte) ((j3 >> 0) & 255);
        bArr[i3 + 1] = (byte) ((j3 >> 8) & 255);
        bArr[i3 + 2] = (byte) ((j3 >> 16) & 255);
        bArr[i3 + 3] = (byte) ((j3 >> 24) & 255);
        bArr[i3 + 4] = (byte) ((j3 >> 32) & 255);
        bArr[i3 + 5] = (byte) ((j3 >> 40) & 255);
        bArr[i3 + 6] = (byte) ((j3 >> 48) & 255);
        bArr[i3 + 7] = (byte) ((j3 >> 56) & 255);
    }

    public static void writeSwappedShort(OutputStream outputStream, short s3) {
        outputStream.write((byte) ((s3 >> 0) & 255));
        outputStream.write((byte) ((s3 >> 8) & 255));
    }

    public static void writeSwappedShort(byte[] bArr, int i3, short s3) {
        bArr[i3 + 0] = (byte) ((s3 >> 0) & 255);
        bArr[i3 + 1] = (byte) ((s3 >> 8) & 255);
    }
}
