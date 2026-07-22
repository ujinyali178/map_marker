package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;

/* loaded from: /root/release/classes.dex */
public final class e {
    public static final Bundle a(g2.j<String, ? extends Object>... jVarArr) {
        Bundle bundle = new Bundle(jVarArr.length);
        for (g2.j<String, ? extends Object> jVar : jVarArr) {
            String a4 = jVar.a();
            Object b4 = jVar.b();
            if (b4 == null) {
                bundle.putString(a4, null);
            } else if (b4 instanceof Boolean) {
                bundle.putBoolean(a4, ((Boolean) b4).booleanValue());
            } else if (b4 instanceof Byte) {
                bundle.putByte(a4, ((Number) b4).byteValue());
            } else if (b4 instanceof Character) {
                bundle.putChar(a4, ((Character) b4).charValue());
            } else if (b4 instanceof Double) {
                bundle.putDouble(a4, ((Number) b4).doubleValue());
            } else if (b4 instanceof Float) {
                bundle.putFloat(a4, ((Number) b4).floatValue());
            } else if (b4 instanceof Integer) {
                bundle.putInt(a4, ((Number) b4).intValue());
            } else if (b4 instanceof Long) {
                bundle.putLong(a4, ((Number) b4).longValue());
            } else if (b4 instanceof Short) {
                bundle.putShort(a4, ((Number) b4).shortValue());
            } else if (b4 instanceof Bundle) {
                bundle.putBundle(a4, (Bundle) b4);
            } else if (b4 instanceof CharSequence) {
                bundle.putCharSequence(a4, (CharSequence) b4);
            } else if (b4 instanceof Parcelable) {
                bundle.putParcelable(a4, (Parcelable) b4);
            } else if (b4 instanceof boolean[]) {
                bundle.putBooleanArray(a4, (boolean[]) b4);
            } else if (b4 instanceof byte[]) {
                bundle.putByteArray(a4, (byte[]) b4);
            } else if (b4 instanceof char[]) {
                bundle.putCharArray(a4, (char[]) b4);
            } else if (b4 instanceof double[]) {
                bundle.putDoubleArray(a4, (double[]) b4);
            } else if (b4 instanceof float[]) {
                bundle.putFloatArray(a4, (float[]) b4);
            } else if (b4 instanceof int[]) {
                bundle.putIntArray(a4, (int[]) b4);
            } else if (b4 instanceof long[]) {
                bundle.putLongArray(a4, (long[]) b4);
            } else if (b4 instanceof short[]) {
                bundle.putShortArray(a4, (short[]) b4);
            } else if (b4 instanceof Object[]) {
                Class<?> componentType = b4.getClass().getComponentType();
                kotlin.jvm.internal.k.b(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    kotlin.jvm.internal.k.c(b4, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                    bundle.putParcelableArray(a4, (Parcelable[]) b4);
                } else if (String.class.isAssignableFrom(componentType)) {
                    kotlin.jvm.internal.k.c(b4, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    bundle.putStringArray(a4, (String[]) b4);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    kotlin.jvm.internal.k.c(b4, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                    bundle.putCharSequenceArray(a4, (CharSequence[]) b4);
                } else {
                    if (!Serializable.class.isAssignableFrom(componentType)) {
                        throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + a4 + '\"');
                    }
                    bundle.putSerializable(a4, (Serializable) b4);
                }
            } else {
                if (!(b4 instanceof Serializable)) {
                    if (b4 instanceof IBinder) {
                        b.a(bundle, a4, (IBinder) b4);
                    } else if (b4 instanceof Size) {
                        c.a(bundle, a4, (Size) b4);
                    } else {
                        if (!(b4 instanceof SizeF)) {
                            throw new IllegalArgumentException("Illegal value type " + b4.getClass().getCanonicalName() + " for key \"" + a4 + '\"');
                        }
                        c.b(bundle, a4, (SizeF) b4);
                    }
                }
                bundle.putSerializable(a4, (Serializable) b4);
            }
        }
        return bundle;
    }
}
