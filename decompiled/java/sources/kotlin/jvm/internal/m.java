package kotlin.jvm.internal;

/* loaded from: /root/release/classes.dex */
public final class m implements d {

    /* renamed from: c, reason: collision with root package name */
    private final Class<?> f3765c;

    /* renamed from: d, reason: collision with root package name */
    private final String f3766d;

    public m(Class<?> jClass, String moduleName) {
        k.e(jClass, "jClass");
        k.e(moduleName, "moduleName");
        this.f3765c = jClass;
        this.f3766d = moduleName;
    }

    @Override // kotlin.jvm.internal.d
    public Class<?> b() {
        return this.f3765c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && k.a(b(), ((m) obj).b());
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
