package m;

import androidx.fragment.app.Fragment;

/* loaded from: /root/release/classes.dex */
public final class a extends n {

    /* renamed from: d, reason: collision with root package name */
    private final String f3923d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Fragment fragment, String previousFragmentId) {
        super(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + previousFragmentId);
        kotlin.jvm.internal.k.e(fragment, "fragment");
        kotlin.jvm.internal.k.e(previousFragmentId, "previousFragmentId");
        this.f3923d = previousFragmentId;
    }
}
