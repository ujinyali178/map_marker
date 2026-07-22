package h1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import io.flutter.plugin.platform.y;
import io.flutter.view.t;
import io.flutter.view.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import u1.n;

@Deprecated
/* loaded from: /root/release/classes.dex */
public class b implements n, n.d, n.a, n.b, n.g, n.e, n.f {

    /* renamed from: c, reason: collision with root package name */
    private Activity f2610c;

    /* renamed from: d, reason: collision with root package name */
    private Context f2611d;

    /* renamed from: f, reason: collision with root package name */
    private t f2612f;

    /* renamed from: g, reason: collision with root package name */
    private v f2613g;

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, Object> f2615i = new LinkedHashMap(0);

    /* renamed from: j, reason: collision with root package name */
    private final List<n.d> f2616j = new ArrayList(0);

    /* renamed from: k, reason: collision with root package name */
    private final List<n.a> f2617k = new ArrayList(0);

    /* renamed from: l, reason: collision with root package name */
    private final List<n.b> f2618l = new ArrayList(0);

    /* renamed from: m, reason: collision with root package name */
    private final List<n.e> f2619m = new ArrayList(0);

    /* renamed from: n, reason: collision with root package name */
    private final List<n.g> f2620n = new ArrayList(0);

    /* renamed from: o, reason: collision with root package name */
    private final List<n.f> f2621o = new ArrayList(0);

    /* renamed from: h, reason: collision with root package name */
    private final y f2614h = new y();

    public b(t tVar, Context context) {
        this.f2612f = tVar;
        this.f2611d = context;
    }

    @Override // u1.n.a
    public boolean a(int i3, int i4, Intent intent) {
        Iterator<n.a> it = this.f2617k.iterator();
        while (it.hasNext()) {
            if (it.next().a(i3, i4, intent)) {
                return true;
            }
        }
        return false;
    }

    @Override // u1.n.f
    public boolean b(t tVar) {
        Iterator<n.f> it = this.f2621o.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            if (it.next().b(tVar)) {
                z3 = true;
            }
        }
        return z3;
    }

    public void c(v vVar, Activity activity) {
        this.f2613g = vVar;
        this.f2610c = activity;
        this.f2614h.C(activity, vVar, vVar.getDartExecutor());
    }

    public void d() {
        this.f2614h.i0();
    }

    public void e() {
        this.f2614h.O();
        this.f2614h.i0();
        this.f2613g = null;
        this.f2610c = null;
    }

    public y f() {
        return this.f2614h;
    }

    public void g() {
        this.f2614h.m0();
    }

    @Override // u1.n.b
    public boolean onNewIntent(Intent intent) {
        Iterator<n.b> it = this.f2618l.iterator();
        while (it.hasNext()) {
            if (it.next().onNewIntent(intent)) {
                return true;
            }
        }
        return false;
    }

    @Override // u1.n.d
    public boolean onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        Iterator<n.d> it = this.f2616j.iterator();
        while (it.hasNext()) {
            if (it.next().onRequestPermissionsResult(i3, strArr, iArr)) {
                return true;
            }
        }
        return false;
    }

    @Override // u1.n.e
    public void onUserLeaveHint() {
        Iterator<n.e> it = this.f2619m.iterator();
        while (it.hasNext()) {
            it.next().onUserLeaveHint();
        }
    }

    @Override // u1.n.g
    public void onWindowFocusChanged(boolean z3) {
        Iterator<n.g> it = this.f2620n.iterator();
        while (it.hasNext()) {
            it.next().onWindowFocusChanged(z3);
        }
    }
}
