package x2;

import android.os.Build;
import i2.g;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import w2.d0;

/* loaded from: /root/release/classes2.dex */
public final class b extends i2.a implements d0 {
    private volatile Object _preHandler;

    public b() {
        super(d0.f4455b);
        this._preHandler = this;
    }

    private final Method g() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            boolean z3 = false;
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            if (Modifier.isPublic(declaredMethod.getModifiers())) {
                if (Modifier.isStatic(declaredMethod.getModifiers())) {
                    z3 = true;
                }
            }
            if (z3) {
                method = declaredMethod;
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    @Override // w2.d0
    public void u(g gVar, Throwable th) {
        int i3 = Build.VERSION.SDK_INT;
        if (26 <= i3 && i3 < 28) {
            Method g3 = g();
            Object invoke = g3 != null ? g3.invoke(null, new Object[0]) : null;
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = invoke instanceof Thread.UncaughtExceptionHandler ? (Thread.UncaughtExceptionHandler) invoke : null;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
        }
    }
}
