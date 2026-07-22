package io.flutter.embedding.android;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /root/release/classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    long f2890a;

    /* renamed from: b, reason: collision with root package name */
    b f2891b;

    /* renamed from: c, reason: collision with root package name */
    long f2892c;

    /* renamed from: d, reason: collision with root package name */
    long f2893d;

    /* renamed from: e, reason: collision with root package name */
    boolean f2894e;

    /* renamed from: f, reason: collision with root package name */
    a f2895f;

    /* renamed from: g, reason: collision with root package name */
    String f2896g;

    public enum a {
        kKeyboard(0),
        kDirectionalPad(1),
        kGamepad(2),
        kJoystick(3),
        kHdmi(4);


        /* renamed from: c, reason: collision with root package name */
        private final long f2903c;

        a(long j3) {
            this.f2903c = j3;
        }

        public long b() {
            return this.f2903c;
        }
    }

    public enum b {
        kDown(0),
        kUp(1),
        kRepeat(2);


        /* renamed from: c, reason: collision with root package name */
        private long f2908c;

        b(long j3) {
            this.f2908c = j3;
        }

        public long b() {
            return this.f2908c;
        }
    }

    ByteBuffer a() {
        try {
            String str = this.f2896g;
            byte[] bytes = str == null ? null : str.getBytes("UTF-8");
            int length = bytes == null ? 0 : bytes.length;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(length + 56);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.putLong(length);
            allocateDirect.putLong(this.f2890a);
            allocateDirect.putLong(this.f2891b.b());
            allocateDirect.putLong(this.f2892c);
            allocateDirect.putLong(this.f2893d);
            allocateDirect.putLong(this.f2894e ? 1L : 0L);
            allocateDirect.putLong(this.f2895f.b());
            if (bytes != null) {
                allocateDirect.put(bytes);
            }
            return allocateDirect;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 not supported");
        }
    }
}
