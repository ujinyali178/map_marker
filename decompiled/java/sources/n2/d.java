package n2;

import java.io.ByteArrayOutputStream;

/* loaded from: /root/release/classes.dex */
final class d extends ByteArrayOutputStream {
    public d(int i3) {
        super(i3);
    }

    public final byte[] a() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        kotlin.jvm.internal.k.d(buf, "buf");
        return buf;
    }
}
