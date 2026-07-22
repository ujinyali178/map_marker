package m;

import androidx.fragment.app.Fragment;

/* loaded from: /root/release/classes.dex */
public final class l extends n {

    /* renamed from: d, reason: collision with root package name */
    private final boolean f3947d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Fragment fragment, boolean z3) {
        super(fragment, "Attempting to set user visible hint to " + z3 + " for fragment " + fragment);
        kotlin.jvm.internal.k.e(fragment, "fragment");
        this.f3947d = z3;
    }
}
