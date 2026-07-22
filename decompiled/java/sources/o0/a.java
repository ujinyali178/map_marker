package o0;

import java.io.ByteArrayInputStream;
import java.io.File;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4072a = new a();

    private a() {
    }

    private final int a(byte[] bArr) {
        return new androidx.exifinterface.media.a(new ByteArrayInputStream(bArr)).n();
    }

    public final int b(File file) {
        k.e(file, "file");
        try {
            return new androidx.exifinterface.media.a(file.getAbsolutePath()).n();
        } catch (Exception unused) {
            return 0;
        }
    }

    public final int c(byte[] _bytes) {
        k.e(_bytes, "_bytes");
        try {
            return a(_bytes);
        } catch (Exception unused) {
            return 0;
        }
    }
}
