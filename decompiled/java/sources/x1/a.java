package x1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;
import m1.a;
import n1.c;
import t1.n;
import u1.l;
import u1.n;

/* loaded from: /root/release/classes.dex */
public class a implements m1.a, n1.a, n.a, n.b {

    /* renamed from: c, reason: collision with root package name */
    private final t1.n f4572c;

    /* renamed from: d, reason: collision with root package name */
    private final PackageManager f4573d;

    /* renamed from: f, reason: collision with root package name */
    private c f4574f;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, ResolveInfo> f4575g;

    /* renamed from: h, reason: collision with root package name */
    private Map<Integer, l.d> f4576h = new HashMap();

    public a(t1.n nVar) {
        this.f4572c = nVar;
        this.f4573d = nVar.f4249b;
        nVar.b(this);
    }

    private void g() {
        this.f4575g = new HashMap();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 23) {
            return;
        }
        Intent type = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        for (ResolveInfo resolveInfo : i3 >= 33 ? this.f4573d.queryIntentActivities(type, PackageManager.ResolveInfoFlags.of(0L)) : this.f4573d.queryIntentActivities(type, 0)) {
            String str = resolveInfo.activityInfo.name;
            resolveInfo.loadLabel(this.f4573d).toString();
            this.f4575g.put(str, resolveInfo);
        }
    }

    @Override // u1.n.a
    public boolean a(int i3, int i4, Intent intent) {
        if (!this.f4576h.containsKey(Integer.valueOf(i3))) {
            return false;
        }
        this.f4576h.remove(Integer.valueOf(i3)).a(i4 == -1 ? intent.getStringExtra("android.intent.extra.PROCESS_TEXT") : null);
        return true;
    }

    @Override // m1.a
    public void b(a.b bVar) {
    }

    @Override // t1.n.b
    public void c(String str, String str2, boolean z3, l.d dVar) {
        if (this.f4574f == null) {
            dVar.b("error", "Plugin not bound to an Activity", null);
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            dVar.b("error", "Android version not supported", null);
            return;
        }
        Map<String, ResolveInfo> map = this.f4575g;
        if (map == null) {
            dVar.b("error", "Can not process text actions before calling queryTextActions", null);
            return;
        }
        ResolveInfo resolveInfo = map.get(str);
        if (resolveInfo == null) {
            dVar.b("error", "Text processing activity not found", null);
            return;
        }
        Integer valueOf = Integer.valueOf(dVar.hashCode());
        this.f4576h.put(valueOf, dVar);
        Intent intent = new Intent();
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent.setClassName(activityInfo.packageName, activityInfo.name);
        intent.setAction("android.intent.action.PROCESS_TEXT");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.PROCESS_TEXT", str2);
        intent.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", z3);
        this.f4574f.i().startActivityForResult(intent, valueOf.intValue());
    }

    @Override // n1.a
    public void d(c cVar) {
        this.f4574f = cVar;
        cVar.a(this);
    }

    @Override // m1.a
    public void e(a.b bVar) {
    }

    @Override // t1.n.b
    public Map<String, String> f() {
        if (this.f4575g == null) {
            g();
        }
        HashMap hashMap = new HashMap();
        for (String str : this.f4575g.keySet()) {
            hashMap.put(str, this.f4575g.get(str).loadLabel(this.f4573d).toString());
        }
        return hashMap;
    }

    @Override // n1.a
    public void h() {
        this.f4574f.d(this);
        this.f4574f = null;
    }

    @Override // n1.a
    public void i() {
        this.f4574f.d(this);
        this.f4574f = null;
    }

    @Override // n1.a
    public void j(c cVar) {
        this.f4574f = cVar;
        cVar.a(this);
    }
}
