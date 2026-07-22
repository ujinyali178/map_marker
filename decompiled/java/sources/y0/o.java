package y0;

import android.content.Context;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: /root/release/classes.dex */
public class o extends h {
    public o(Context context, a aVar) {
        super(context, aVar);
    }

    @Override // y0.h
    protected String a() {
        return "VGhpcyBpcyB0aGUga2V5IGZvcihBIHNlY3XyZZBzdG9yYWdlIEFFUyBLZXkK";
    }

    @Override // y0.h
    protected Cipher b() {
        return Cipher.getInstance("AES/GCM/NoPadding");
    }

    @Override // y0.h
    protected int c() {
        return 12;
    }

    @Override // y0.h
    protected AlgorithmParameterSpec d(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }
}
