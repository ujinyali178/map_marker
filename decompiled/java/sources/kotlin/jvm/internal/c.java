package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public abstract class c implements t2.b, Serializable {
    public static final Object NO_RECEIVER = a.f3756c;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient t2.b reflected;
    private final String signature;

    private static class a implements Serializable {

        /* renamed from: c, reason: collision with root package name */
        private static final a f3756c = new a();

        private a() {
        }
    }

    public c() {
        this(NO_RECEIVER);
    }

    protected c(Object obj) {
        this(obj, null, null, null, false);
    }

    protected c(Object obj, Class cls, String str, String str2, boolean z3) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z3;
    }

    @Override // t2.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // t2.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public t2.b compute() {
        t2.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        t2.b computeReflected = computeReflected();
        this.reflected = computeReflected;
        return computeReflected;
    }

    protected abstract t2.b computeReflected();

    @Override // t2.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public t2.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? r.c(cls) : r.b(cls);
    }

    @Override // t2.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    protected t2.b getReflected() {
        t2.b compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new o2.b();
    }

    @Override // t2.b
    public t2.h getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // t2.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // t2.b
    public t2.i getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // t2.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // t2.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // t2.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // t2.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
