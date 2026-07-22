package kotlin.jvm.internal;

/* loaded from: /root/release/classes.dex */
public class s {
    public t2.e a(i iVar) {
        return iVar;
    }

    public t2.c b(Class cls) {
        return new e(cls);
    }

    public t2.d c(Class cls, String str) {
        return new m(cls, str);
    }

    public t2.f d(n nVar) {
        return nVar;
    }

    public String e(h hVar) {
        String obj = hVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public String f(l lVar) {
        return e(lVar);
    }
}
