package s;

import android.os.Trace;

/* loaded from: /root/release/classes.dex */
final class f {
    public static void a(String str, int i3) {
        Trace.beginAsyncSection(str, i3);
    }

    public static void b(String str, int i3) {
        Trace.endAsyncSection(str, i3);
    }
}
