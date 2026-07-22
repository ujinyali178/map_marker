package m;

import androidx.fragment.app.Fragment;

/* loaded from: /root/release/classes.dex */
public abstract class n extends RuntimeException {

    /* renamed from: c, reason: collision with root package name */
    private final Fragment f3948c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Fragment fragment, String str) {
        super(str);
        kotlin.jvm.internal.k.e(fragment, "fragment");
        this.f3948c = fragment;
    }

    public final Fragment a() {
        return this.f3948c;
    }
}
