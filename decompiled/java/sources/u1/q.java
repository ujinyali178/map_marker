package u1;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: /root/release/classes.dex */
public final class q implements j<String> {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f4389a = Charset.forName("UTF8");

    /* renamed from: b, reason: collision with root package name */
    public static final q f4390b = new q();

    private q() {
    }

    @Override // u1.j
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String b(ByteBuffer byteBuffer) {
        byte[] bArr;
        int i3;
        if (byteBuffer == null) {
            return null;
        }
        int remaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            bArr = byteBuffer.array();
            i3 = byteBuffer.arrayOffset();
        } else {
            bArr = new byte[remaining];
            byteBuffer.get(bArr);
            i3 = 0;
        }
        return new String(bArr, i3, remaining, f4389a);
    }

    @Override // u1.j
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ByteBuffer a(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(f4389a);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length);
        allocateDirect.put(bytes);
        return allocateDirect;
    }
}
