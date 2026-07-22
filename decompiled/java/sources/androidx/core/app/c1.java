package androidx.core.app;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.app.Person;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: /root/release/classes.dex */
public class c1 {

    /* renamed from: a, reason: collision with root package name */
    CharSequence f495a;

    /* renamed from: b, reason: collision with root package name */
    IconCompat f496b;

    /* renamed from: c, reason: collision with root package name */
    String f497c;

    /* renamed from: d, reason: collision with root package name */
    String f498d;

    /* renamed from: e, reason: collision with root package name */
    boolean f499e;

    /* renamed from: f, reason: collision with root package name */
    boolean f500f;

    static class a {
        static c1 a(Person person) {
            return new b().f(person.getName()).c(person.getIcon() != null ? IconCompat.a(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        static Person b(c1 c1Var) {
            return new Object() { // from class: android.app.Person.Builder
                static {
                    throw new NoClassDefFoundError();
                }

                @NonNull
                public native /* synthetic */ Person build();

                @NonNull
                public native /* synthetic */ Builder setBot(boolean z3);

                @NonNull
                public native /* synthetic */ Builder setIcon(@Nullable Icon icon);

                @NonNull
                public native /* synthetic */ Builder setImportant(boolean z3);

                @NonNull
                public native /* synthetic */ Builder setKey(@Nullable String str);

                @NonNull
                public native /* synthetic */ Builder setName(@Nullable CharSequence charSequence);

                @NonNull
                public native /* synthetic */ Builder setUri(@Nullable String str);
            }.setName(c1Var.c()).setIcon(c1Var.a() != null ? c1Var.a().r() : null).setUri(c1Var.d()).setKey(c1Var.b()).setBot(c1Var.e()).setImportant(c1Var.f()).build();
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        CharSequence f501a;

        /* renamed from: b, reason: collision with root package name */
        IconCompat f502b;

        /* renamed from: c, reason: collision with root package name */
        String f503c;

        /* renamed from: d, reason: collision with root package name */
        String f504d;

        /* renamed from: e, reason: collision with root package name */
        boolean f505e;

        /* renamed from: f, reason: collision with root package name */
        boolean f506f;

        public c1 a() {
            return new c1(this);
        }

        public b b(boolean z3) {
            this.f505e = z3;
            return this;
        }

        public b c(IconCompat iconCompat) {
            this.f502b = iconCompat;
            return this;
        }

        public b d(boolean z3) {
            this.f506f = z3;
            return this;
        }

        public b e(String str) {
            this.f504d = str;
            return this;
        }

        public b f(CharSequence charSequence) {
            this.f501a = charSequence;
            return this;
        }

        public b g(String str) {
            this.f503c = str;
            return this;
        }
    }

    c1(b bVar) {
        this.f495a = bVar.f501a;
        this.f496b = bVar.f502b;
        this.f497c = bVar.f503c;
        this.f498d = bVar.f504d;
        this.f499e = bVar.f505e;
        this.f500f = bVar.f506f;
    }

    public IconCompat a() {
        return this.f496b;
    }

    public String b() {
        return this.f498d;
    }

    public CharSequence c() {
        return this.f495a;
    }

    public String d() {
        return this.f497c;
    }

    public boolean e() {
        return this.f499e;
    }

    public boolean f() {
        return this.f500f;
    }

    public String g() {
        String str = this.f497c;
        if (str != null) {
            return str;
        }
        if (this.f495a == null) {
            return "";
        }
        return "name:" + ((Object) this.f495a);
    }

    public Person h() {
        return a.b(this);
    }

    public Bundle i() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f495a);
        IconCompat iconCompat = this.f496b;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.q() : null);
        bundle.putString("uri", this.f497c);
        bundle.putString("key", this.f498d);
        bundle.putBoolean("isBot", this.f499e);
        bundle.putBoolean("isImportant", this.f500f);
        return bundle;
    }
}
