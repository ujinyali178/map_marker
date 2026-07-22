package androidx.browser.trusted;

import android.os.IBinder;
import android.support.customtabs.trusted.ITrustedWebActivityCallback;

/* loaded from: /root/release/classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final ITrustedWebActivityCallback f372a;

    private c(ITrustedWebActivityCallback iTrustedWebActivityCallback) {
        this.f372a = iTrustedWebActivityCallback;
    }

    static c a(IBinder iBinder) {
        ITrustedWebActivityCallback asInterface = iBinder == null ? null : ITrustedWebActivityCallback.Stub.asInterface(iBinder);
        if (asInterface == null) {
            return null;
        }
        return new c(asInterface);
    }
}
