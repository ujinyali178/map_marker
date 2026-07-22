package f1;

import android.os.Build;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
public final class a implements l.c {

    /* renamed from: c, reason: collision with root package name */
    private final c f2508c;

    /* renamed from: d, reason: collision with root package name */
    private final e f2509d;

    public a(c share, e manager) {
        k.e(share, "share");
        k.e(manager, "manager");
        this.f2508c = share;
        this.f2509d = manager;
    }

    private final void a(u1.k kVar) {
        if (!(kVar.f4373b instanceof Map)) {
            throw new IllegalArgumentException("Map arguments expected".toString());
        }
    }

    private final void b(boolean z3, l.d dVar) {
        if (z3) {
            return;
        }
        dVar.a("dev.fluttercommunity.plus/share/unavailable");
    }

    @Override // u1.l.c
    public void n(u1.k call, l.d result) {
        k.e(call, "call");
        k.e(result, "result");
        a(call);
        boolean z3 = Build.VERSION.SDK_INT >= 22;
        if (z3) {
            this.f2509d.d(result);
        }
        try {
            String str = call.f4372a;
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1811378728) {
                    if (hashCode != -743768819) {
                        if (hashCode == 109400031 && str.equals("share")) {
                            c cVar = this.f2508c;
                            Object a4 = call.a("text");
                            k.c(a4, "null cannot be cast to non-null type kotlin.String");
                            cVar.m((String) a4, (String) call.a("subject"), z3);
                            b(z3, result);
                            return;
                        }
                    } else if (str.equals("shareUri")) {
                        c cVar2 = this.f2508c;
                        Object a5 = call.a("uri");
                        k.c(a5, "null cannot be cast to non-null type kotlin.String");
                        cVar2.m((String) a5, null, z3);
                        b(z3, result);
                        return;
                    }
                } else if (str.equals("shareFiles")) {
                    c cVar3 = this.f2508c;
                    Object a6 = call.a("paths");
                    k.b(a6);
                    cVar3.n((List) a6, (List) call.a("mimeTypes"), (String) call.a("text"), (String) call.a("subject"), z3);
                    b(z3, result);
                    return;
                }
            }
            result.c();
        } catch (Throwable th) {
            this.f2509d.b();
            result.b("Share failed", th.getMessage(), th);
        }
    }
}
