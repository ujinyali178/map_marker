package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /root/release/classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected final androidx.collection.a<String, Method> f1493a;

    /* renamed from: b, reason: collision with root package name */
    protected final androidx.collection.a<String, Method> f1494b;

    /* renamed from: c, reason: collision with root package name */
    protected final androidx.collection.a<String, Class> f1495c;

    public a(androidx.collection.a<String, Method> aVar, androidx.collection.a<String, Method> aVar2, androidx.collection.a<String, Class> aVar3) {
        this.f1493a = aVar;
        this.f1494b = aVar2;
        this.f1495c = aVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void N(t.a aVar) {
        try {
            I(c(aVar.getClass()).getName());
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException(aVar.getClass().getSimpleName() + " does not have a Parcelizer", e3);
        }
    }

    private Class c(Class<? extends t.a> cls) {
        Class cls2 = this.f1495c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f1495c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) {
        Method method = this.f1493a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        this.f1493a.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method e(Class cls) {
        Method method = this.f1494b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class c3 = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = c3.getDeclaredMethod("write", cls, a.class);
        this.f1494b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    protected abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i3) {
        w(i3);
        A(bArr);
    }

    protected abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i3) {
        w(i3);
        C(charSequence);
    }

    protected abstract void E(int i3);

    public void F(int i3, int i4) {
        w(i4);
        E(i3);
    }

    protected abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i3) {
        w(i3);
        G(parcelable);
    }

    protected abstract void I(String str);

    public void J(String str, int i3) {
        w(i3);
        I(str);
    }

    protected <T extends t.a> void K(T t3, a aVar) {
        try {
            e(t3.getClass()).invoke(null, t3, aVar);
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e3);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e5);
        } catch (InvocationTargetException e6) {
            if (!(e6.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
            }
            throw ((RuntimeException) e6.getCause());
        }
    }

    protected void L(t.a aVar) {
        if (aVar == null) {
            I(null);
            return;
        }
        N(aVar);
        a b4 = b();
        K(aVar, b4);
        b4.a();
    }

    public void M(t.a aVar, int i3) {
        w(i3);
        L(aVar);
    }

    protected abstract void a();

    protected abstract a b();

    public boolean f() {
        return false;
    }

    protected abstract boolean g();

    public boolean h(boolean z3, int i3) {
        return !m(i3) ? z3 : g();
    }

    protected abstract byte[] i();

    public byte[] j(byte[] bArr, int i3) {
        return !m(i3) ? bArr : i();
    }

    protected abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i3) {
        return !m(i3) ? charSequence : k();
    }

    protected abstract boolean m(int i3);

    protected <T extends t.a> T n(String str, a aVar) {
        try {
            return (T) d(str).invoke(null, aVar);
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e3);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e5);
        } catch (InvocationTargetException e6) {
            if (e6.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e6.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
        }
    }

    protected abstract int o();

    public int p(int i3, int i4) {
        return !m(i4) ? i3 : o();
    }

    protected abstract <T extends Parcelable> T q();

    public <T extends Parcelable> T r(T t3, int i3) {
        return !m(i3) ? t3 : (T) q();
    }

    protected abstract String s();

    public String t(String str, int i3) {
        return !m(i3) ? str : s();
    }

    protected <T extends t.a> T u() {
        String s3 = s();
        if (s3 == null) {
            return null;
        }
        return (T) n(s3, b());
    }

    public <T extends t.a> T v(T t3, int i3) {
        return !m(i3) ? t3 : (T) u();
    }

    protected abstract void w(int i3);

    public void x(boolean z3, boolean z4) {
    }

    protected abstract void y(boolean z3);

    public void z(boolean z3, int i3) {
        w(i3);
        y(z3);
    }
}
