package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import org.apache.commons.io.IOUtils;

/* loaded from: /root/release/classes.dex */
public final class g {
    private static final void a(int i3, int i4) {
        if (i4 <= i3) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i3 + ", got " + i4 + ". Please update the Kotlin standard library.").toString());
    }

    private static final f b(a aVar) {
        return (f) aVar.getClass().getAnnotation(f.class);
    }

    private static final int c(a aVar) {
        try {
            Field declaredField = aVar.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(aVar);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(a aVar) {
        String str;
        kotlin.jvm.internal.k.e(aVar, "<this>");
        f b4 = b(aVar);
        if (b4 == null) {
            return null;
        }
        a(1, b4.v());
        int c3 = c(aVar);
        int i3 = c3 < 0 ? -1 : b4.l()[c3];
        String b5 = i.f3748a.b(aVar);
        if (b5 == null) {
            str = b4.c();
        } else {
            str = b5 + IOUtils.DIR_SEPARATOR_UNIX + b4.c();
        }
        return new StackTraceElement(str, b4.m(), b4.f(), i3);
    }
}
