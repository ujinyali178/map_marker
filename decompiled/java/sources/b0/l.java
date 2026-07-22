package b0;

import android.content.Context;
import b0.a;
import b0.u;
import b0.y;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import u1.l;

/* loaded from: /root/release/classes.dex */
final class l implements l.c {

    /* renamed from: c, reason: collision with root package name */
    private final Context f1537c;

    /* renamed from: d, reason: collision with root package name */
    private final a f1538d;

    /* renamed from: f, reason: collision with root package name */
    private final u f1539f;

    /* renamed from: g, reason: collision with root package name */
    private final y f1540g;

    l(Context context, a aVar, u uVar, y yVar) {
        this.f1537c = context;
        this.f1538d = aVar;
        this.f1539f = uVar;
        this.f1540g = yVar;
    }

    @Override // u1.l.c
    public void n(u1.k kVar, final l.d dVar) {
        String str = kVar.f4372a;
        str.hashCode();
        switch (str) {
            case "checkServiceStatus":
                int parseInt = Integer.parseInt(kVar.f4373b.toString());
                y yVar = this.f1540g;
                Context context = this.f1537c;
                Objects.requireNonNull(dVar);
                yVar.a(parseInt, context, new y.a() { // from class: b0.c
                    @Override // b0.y.a
                    public final void a(int i3) {
                        l.d.this.a(Integer.valueOf(i3));
                    }
                }, new b() { // from class: b0.d
                    @Override // b0.b
                    public final void a(String str2, String str3) {
                        l.d.this.b(str2, str3, null);
                    }
                });
                break;
            case "shouldShowRequestPermissionRationale":
                int parseInt2 = Integer.parseInt(kVar.f4373b.toString());
                u uVar = this.f1539f;
                Objects.requireNonNull(dVar);
                uVar.j(parseInt2, new u.c() { // from class: b0.h
                    @Override // b0.u.c
                    public final void a(boolean z3) {
                        l.d.this.a(Boolean.valueOf(z3));
                    }
                }, new b() { // from class: b0.i
                    @Override // b0.b
                    public final void a(String str2, String str3) {
                        l.d.this.b(str2, str3, null);
                    }
                });
                break;
            case "checkPermissionStatus":
                int parseInt3 = Integer.parseInt(kVar.f4373b.toString());
                u uVar2 = this.f1539f;
                Objects.requireNonNull(dVar);
                uVar2.d(parseInt3, new u.a() { // from class: b0.e
                    @Override // b0.u.a
                    public final void a(int i3) {
                        l.d.this.a(Integer.valueOf(i3));
                    }
                });
                break;
            case "openAppSettings":
                a aVar = this.f1538d;
                Context context2 = this.f1537c;
                Objects.requireNonNull(dVar);
                aVar.a(context2, new a.InterfaceC0040a() { // from class: b0.j
                    @Override // b0.a.InterfaceC0040a
                    public final void a(boolean z3) {
                        l.d.this.a(Boolean.valueOf(z3));
                    }
                }, new b() { // from class: b0.k
                    @Override // b0.b
                    public final void a(String str2, String str3) {
                        l.d.this.b(str2, str3, null);
                    }
                });
                break;
            case "requestPermissions":
                List<Integer> list = (List) kVar.b();
                u uVar3 = this.f1539f;
                Objects.requireNonNull(dVar);
                uVar3.h(list, new u.b() { // from class: b0.f
                    @Override // b0.u.b
                    public final void a(Map map) {
                        l.d.this.a(map);
                    }
                }, new b() { // from class: b0.g
                    @Override // b0.b
                    public final void a(String str2, String str3) {
                        l.d.this.b(str2, str3, null);
                    }
                });
                break;
            default:
                dVar.c();
                break;
        }
    }
}
