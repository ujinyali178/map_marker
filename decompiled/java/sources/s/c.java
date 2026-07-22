package s;

import android.os.Trace;

/* loaded from: /root/release/classes.dex */
final class c {
    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
