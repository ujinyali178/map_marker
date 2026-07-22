package m;

import androidx.fragment.app.Fragment;

/* loaded from: /root/release/classes.dex */
public final class k extends m {

    /* renamed from: d, reason: collision with root package name */
    private final Fragment f3945d;

    /* renamed from: f, reason: collision with root package name */
    private final int f3946f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Fragment fragment, Fragment targetFragment, int i3) {
        super(fragment, "Attempting to set target fragment " + targetFragment + " with request code " + i3 + " for fragment " + fragment);
        kotlin.jvm.internal.k.e(fragment, "fragment");
        kotlin.jvm.internal.k.e(targetFragment, "targetFragment");
        this.f3945d = targetFragment;
        this.f3946f = i3;
    }
}
