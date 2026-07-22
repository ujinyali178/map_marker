package y0;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import java.math.BigInteger;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.security.auth.x500.X500Principal;

/* loaded from: /root/release/classes.dex */
public class g extends f {
    public g(Context context) {
        super(context);
    }

    @Override // y0.f, y0.a
    public /* bridge */ /* synthetic */ byte[] a(Key key) {
        return super.a(key);
    }

    @Override // y0.f, y0.a
    public /* bridge */ /* synthetic */ Key b(byte[] bArr, String str) {
        return super.b(bArr, str);
    }

    @Override // y0.f
    protected String c() {
        return this.f4661b.getPackageName() + ".FlutterSecureStoragePluginKeyOAEP";
    }

    @Override // y0.f
    protected AlgorithmParameterSpec f() {
        return new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
    }

    @Override // y0.f
    protected Cipher i() {
        return Cipher.getInstance("RSA/ECB/OAEPPadding", "AndroidKeyStoreBCWorkaround");
    }

    @Override // y0.f
    protected AlgorithmParameterSpec j(Context context, Calendar calendar, Calendar calendar2) {
        return new KeyGenParameterSpec.Builder(this.f4660a, 3).setCertificateSubject(new X500Principal("CN=" + this.f4660a)).setDigests("SHA-256").setBlockModes("ECB").setEncryptionPaddings("OAEPPadding").setCertificateSerialNumber(BigInteger.valueOf(1L)).setCertificateNotBefore(calendar.getTime()).setCertificateNotAfter(calendar2.getTime()).build();
    }
}
