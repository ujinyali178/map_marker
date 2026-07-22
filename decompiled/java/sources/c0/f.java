package c0;

import c0.b;
import c0.g;

/* loaded from: /root/release/classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    b.r f1706a;

    /* renamed from: b, reason: collision with root package name */
    e f1707b;

    /* renamed from: c, reason: collision with root package name */
    String f1708c;

    /* renamed from: d, reason: collision with root package name */
    g.b f1709d;

    /* renamed from: e, reason: collision with root package name */
    String f1710e;

    /* renamed from: f, reason: collision with root package name */
    g.b f1711f;

    public f() {
        this.f1706a = null;
        this.f1707b = null;
        this.f1708c = null;
        this.f1709d = null;
        this.f1710e = null;
        this.f1711f = null;
    }

    public f(f fVar) {
        this.f1706a = null;
        this.f1707b = null;
        this.f1708c = null;
        this.f1709d = null;
        this.f1710e = null;
        this.f1711f = null;
        if (fVar == null) {
            return;
        }
        this.f1706a = fVar.f1706a;
        this.f1707b = fVar.f1707b;
        this.f1709d = fVar.f1709d;
        this.f1710e = fVar.f1710e;
        this.f1711f = fVar.f1711f;
    }

    public boolean a() {
        b.r rVar = this.f1706a;
        return rVar != null && rVar.f() > 0;
    }

    public boolean b() {
        return this.f1707b != null;
    }

    public boolean c() {
        return this.f1708c != null;
    }

    public boolean d() {
        return this.f1710e != null;
    }

    public boolean e() {
        return this.f1709d != null;
    }

    public boolean f() {
        return this.f1711f != null;
    }

    public f g(float f3, float f4, float f5, float f6) {
        this.f1711f = new g.b(f3, f4, f5, f6);
        return this;
    }
}
