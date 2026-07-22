package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: /root/release/classes.dex */
public abstract class o<E> extends k {

    /* renamed from: c, reason: collision with root package name */
    private final Activity f1161c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f1162d;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f1163f;

    /* renamed from: g, reason: collision with root package name */
    private final int f1164g;

    /* renamed from: h, reason: collision with root package name */
    final w f1165h;

    o(Activity activity, Context context, Handler handler, int i3) {
        this.f1165h = new x();
        this.f1161c = activity;
        this.f1162d = (Context) androidx.core.util.d.f(context, "context == null");
        this.f1163f = (Handler) androidx.core.util.d.f(handler, "handler == null");
        this.f1164g = i3;
    }

    o(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    @Override // androidx.fragment.app.k
    public View c(int i3) {
        return null;
    }

    @Override // androidx.fragment.app.k
    public boolean d() {
        return true;
    }

    Activity e() {
        return this.f1161c;
    }

    Context f() {
        return this.f1162d;
    }

    public Handler g() {
        return this.f1163f;
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract E i();

    public LayoutInflater j() {
        return LayoutInflater.from(this.f1162d);
    }

    @Deprecated
    public void k(Fragment fragment, String[] strArr, int i3) {
    }

    public boolean l(String str) {
        return false;
    }

    public void m(Fragment fragment, Intent intent, int i3, Bundle bundle) {
        if (i3 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        androidx.core.content.a.startActivity(this.f1162d, intent, bundle);
    }

    @Deprecated
    public void n(Fragment fragment, IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        if (i3 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        androidx.core.app.a.h(this.f1161c, intentSender, i3, intent, i4, i5, i6, bundle);
    }

    public void o() {
    }
}
