package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* loaded from: /root/release/classes.dex */
final class k0 extends Writer {

    /* renamed from: c, reason: collision with root package name */
    private final String f1123c;

    /* renamed from: d, reason: collision with root package name */
    private StringBuilder f1124d = new StringBuilder(128);

    k0(String str) {
        this.f1123c = str;
    }

    private void a() {
        if (this.f1124d.length() > 0) {
            Log.d(this.f1123c, this.f1124d.toString());
            StringBuilder sb = this.f1124d;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            char c3 = cArr[i3 + i5];
            if (c3 == '\n') {
                a();
            } else {
                this.f1124d.append(c3);
            }
        }
    }
}
