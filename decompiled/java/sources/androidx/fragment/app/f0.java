package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.e;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: /root/release/classes.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    private final n f1057a;

    /* renamed from: b, reason: collision with root package name */
    private final ClassLoader f1058b;

    /* renamed from: d, reason: collision with root package name */
    int f1060d;

    /* renamed from: e, reason: collision with root package name */
    int f1061e;

    /* renamed from: f, reason: collision with root package name */
    int f1062f;

    /* renamed from: g, reason: collision with root package name */
    int f1063g;

    /* renamed from: h, reason: collision with root package name */
    int f1064h;

    /* renamed from: i, reason: collision with root package name */
    boolean f1065i;

    /* renamed from: k, reason: collision with root package name */
    String f1067k;

    /* renamed from: l, reason: collision with root package name */
    int f1068l;

    /* renamed from: m, reason: collision with root package name */
    CharSequence f1069m;

    /* renamed from: n, reason: collision with root package name */
    int f1070n;

    /* renamed from: o, reason: collision with root package name */
    CharSequence f1071o;

    /* renamed from: p, reason: collision with root package name */
    ArrayList<String> f1072p;

    /* renamed from: q, reason: collision with root package name */
    ArrayList<String> f1073q;

    /* renamed from: s, reason: collision with root package name */
    ArrayList<Runnable> f1075s;

    /* renamed from: c, reason: collision with root package name */
    ArrayList<a> f1059c = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    boolean f1066j = true;

    /* renamed from: r, reason: collision with root package name */
    boolean f1074r = false;

    static final class a {

        /* renamed from: a, reason: collision with root package name */
        int f1076a;

        /* renamed from: b, reason: collision with root package name */
        Fragment f1077b;

        /* renamed from: c, reason: collision with root package name */
        boolean f1078c;

        /* renamed from: d, reason: collision with root package name */
        int f1079d;

        /* renamed from: e, reason: collision with root package name */
        int f1080e;

        /* renamed from: f, reason: collision with root package name */
        int f1081f;

        /* renamed from: g, reason: collision with root package name */
        int f1082g;

        /* renamed from: h, reason: collision with root package name */
        e.b f1083h;

        /* renamed from: i, reason: collision with root package name */
        e.b f1084i;

        a() {
        }

        a(int i3, Fragment fragment) {
            this.f1076a = i3;
            this.f1077b = fragment;
            this.f1078c = false;
            e.b bVar = e.b.RESUMED;
            this.f1083h = bVar;
            this.f1084i = bVar;
        }

        a(int i3, Fragment fragment, boolean z3) {
            this.f1076a = i3;
            this.f1077b = fragment;
            this.f1078c = z3;
            e.b bVar = e.b.RESUMED;
            this.f1083h = bVar;
            this.f1084i = bVar;
        }
    }

    f0(n nVar, ClassLoader classLoader) {
        this.f1057a = nVar;
        this.f1058b = classLoader;
    }

    public f0 b(int i3, Fragment fragment, String str) {
        k(i3, fragment, str, 1);
        return this;
    }

    f0 c(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return b(viewGroup.getId(), fragment, str);
    }

    public f0 d(Fragment fragment, String str) {
        k(0, fragment, str, 1);
        return this;
    }

    void e(a aVar) {
        this.f1059c.add(aVar);
        aVar.f1079d = this.f1060d;
        aVar.f1080e = this.f1061e;
        aVar.f1081f = this.f1062f;
        aVar.f1082g = this.f1063g;
    }

    public abstract int f();

    public abstract int g();

    public abstract void h();

    public abstract void i();

    public f0 j() {
        if (this.f1065i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f1066j = false;
        return this;
    }

    void k(int i3, Fragment fragment, String str, int i4) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            m.d.h(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i3 != 0) {
            if (i3 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i5 = fragment.mFragmentId;
            if (i5 != 0 && i5 != i3) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i3);
            }
            fragment.mFragmentId = i3;
            fragment.mContainerId = i3;
        }
        e(new a(i4, fragment));
    }

    public f0 l(Fragment fragment) {
        e(new a(3, fragment));
        return this;
    }

    public f0 m(boolean z3) {
        this.f1074r = z3;
        return this;
    }
}
