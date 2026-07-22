package h2;

import java.lang.reflect.Array;

/* loaded from: /root/release/classes.dex */
class g {
    public static final <T> T[] a(T[] reference, int i3) {
        kotlin.jvm.internal.k.e(reference, "reference");
        Object newInstance = Array.newInstance(reference.getClass().getComponentType(), i3);
        kotlin.jvm.internal.k.c(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) newInstance);
    }
}
