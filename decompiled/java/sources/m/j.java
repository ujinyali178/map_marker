package m;

import androidx.fragment.app.Fragment;

/* loaded from: /root/release/classes.dex */
public final class j extends i {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Fragment fragment) {
        super(fragment, "Attempting to set retain instance for fragment " + fragment);
        kotlin.jvm.internal.k.e(fragment, "fragment");
    }
}
