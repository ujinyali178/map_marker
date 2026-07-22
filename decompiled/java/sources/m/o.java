package m;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* loaded from: /root/release/classes.dex */
public final class o extends n {

    /* renamed from: d, reason: collision with root package name */
    private final ViewGroup f3949d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Fragment fragment, ViewGroup container) {
        super(fragment, "Attempting to add fragment " + fragment + " to container " + container + " which is not a FragmentContainerView");
        kotlin.jvm.internal.k.e(fragment, "fragment");
        kotlin.jvm.internal.k.e(container, "container");
        this.f3949d = container;
    }
}
