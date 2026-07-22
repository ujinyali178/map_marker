package m;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* loaded from: /root/release/classes.dex */
public final class e extends n {

    /* renamed from: d, reason: collision with root package name */
    private final ViewGroup f3944d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Fragment fragment, ViewGroup viewGroup) {
        super(fragment, "Attempting to use <fragment> tag to add fragment " + fragment + " to container " + viewGroup);
        kotlin.jvm.internal.k.e(fragment, "fragment");
        this.f3944d = viewGroup;
    }
}
