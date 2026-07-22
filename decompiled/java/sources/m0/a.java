package m0;

import android.content.Context;
import android.os.Build;
import kotlin.jvm.internal.g;
import m1.a;
import n0.c;
import n0.e;
import u1.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
public final class a implements m1.a, l.c {

    /* renamed from: f, reason: collision with root package name */
    public static final C0097a f3950f = new C0097a(null);

    /* renamed from: g, reason: collision with root package name */
    private static boolean f3951g;

    /* renamed from: c, reason: collision with root package name */
    private Context f3952c;

    /* renamed from: d, reason: collision with root package name */
    private l f3953d;

    /* renamed from: m0.a$a, reason: collision with other inner class name */
    public static final class C0097a {
        private C0097a() {
        }

        public /* synthetic */ C0097a(g gVar) {
            this();
        }

        public final boolean a() {
            return a.f3951g;
        }
    }

    public a() {
        q0.a aVar = q0.a.f4092a;
        aVar.b(new s0.a(0));
        aVar.b(new s0.a(1));
        aVar.b(new t0.a());
        aVar.b(new s0.a(3));
    }

    private final int c(k kVar) {
        f3951g = kotlin.jvm.internal.k.a((Boolean) kVar.b(), Boolean.TRUE);
        return 1;
    }

    @Override // m1.a
    public void b(a.b binding) {
        kotlin.jvm.internal.k.e(binding, "binding");
        Context a4 = binding.a();
        kotlin.jvm.internal.k.d(a4, "binding.applicationContext");
        this.f3952c = a4;
        l lVar = new l(binding.b(), "flutter_image_compress");
        this.f3953d = lVar;
        lVar.e(this);
    }

    @Override // m1.a
    public void e(a.b binding) {
        kotlin.jvm.internal.k.e(binding, "binding");
        l lVar = this.f3953d;
        if (lVar != null) {
            lVar.e(null);
        }
        this.f3953d = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // u1.l.c
    public void n(k call, l.d result) {
        int i3;
        kotlin.jvm.internal.k.e(call, "call");
        kotlin.jvm.internal.k.e(result, "result");
        String str = call.f4372a;
        if (str != null) {
            Context context = null;
            switch (str.hashCode()) {
                case -129880033:
                    if (str.equals("compressWithFileAndGetFile")) {
                        c cVar = new c(call, result);
                        Context context2 = this.f3952c;
                        if (context2 == null) {
                            kotlin.jvm.internal.k.o("context");
                        } else {
                            context = context2;
                        }
                        cVar.i(context);
                        return;
                    }
                    break;
                case 86054116:
                    if (str.equals("compressWithFile")) {
                        c cVar2 = new c(call, result);
                        Context context3 = this.f3952c;
                        if (context3 == null) {
                            kotlin.jvm.internal.k.o("context");
                        } else {
                            context = context3;
                        }
                        cVar2.g(context);
                        return;
                    }
                    break;
                case 86233094:
                    if (str.equals("compressWithList")) {
                        e eVar = new e(call, result);
                        Context context4 = this.f3952c;
                        if (context4 == null) {
                            kotlin.jvm.internal.k.o("context");
                        } else {
                            context = context4;
                        }
                        eVar.f(context);
                        return;
                    }
                    break;
                case 1262746611:
                    if (str.equals("getSystemVersion")) {
                        i3 = Build.VERSION.SDK_INT;
                        break;
                    }
                    break;
                case 2067272455:
                    if (str.equals("showLog")) {
                        i3 = c(call);
                        break;
                    }
                    break;
            }
            result.a(Integer.valueOf(i3));
            return;
        }
        result.c();
    }
}
