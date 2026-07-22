package androidx.core.view;

import android.os.Build;
import android.view.View;

/* loaded from: /root/release/classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private final c f817a;

    private static class a extends c {

        /* renamed from: a, reason: collision with root package name */
        private final View f818a;

        a(View view) {
            this.f818a = view;
        }
    }

    private static class b extends a {

        /* renamed from: b, reason: collision with root package name */
        private View f819b;

        b(View view) {
            super(view);
            this.f819b = view;
        }
    }

    private static class c {
        c() {
        }
    }

    public l(View view) {
        this.f817a = Build.VERSION.SDK_INT >= 30 ? new b(view) : new a(view);
    }
}
