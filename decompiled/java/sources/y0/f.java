package y0;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.security.auth.x500.X500Principal;

/* loaded from: /root/release/classes.dex */
class f implements a {

    /* renamed from: a, reason: collision with root package name */
    protected final String f4660a = c();

    /* renamed from: b, reason: collision with root package name */
    protected final Context f4661b;

    public f(Context context) {
        this.f4661b = context;
        e(context);
    }

    private void d(Context context) {
        Locale locale = Locale.getDefault();
        try {
            l(Locale.ENGLISH);
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 25);
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            keyPairGenerator.initialize(Build.VERSION.SDK_INT < 23 ? k(context, calendar, calendar2) : j(context, calendar, calendar2));
            keyPairGenerator.generateKeyPair();
        } finally {
            l(locale);
        }
    }

    private void e(Context context) {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        if (keyStore.getKey(this.f4660a, null) == null) {
            d(context);
        }
    }

    private PrivateKey g() {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        Key key = keyStore.getKey(this.f4660a, null);
        if (key != null) {
            if (key instanceof PrivateKey) {
                return (PrivateKey) key;
            }
            throw new Exception("Not an instance of a PrivateKey");
        }
        throw new Exception("No key found under alias: " + this.f4660a);
    }

    private PublicKey h() {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        Certificate certificate = keyStore.getCertificate(this.f4660a);
        if (certificate == null) {
            throw new Exception("No certificate found under alias: " + this.f4660a);
        }
        PublicKey publicKey = certificate.getPublicKey();
        if (publicKey != null) {
            return publicKey;
        }
        throw new Exception("No key found under alias: " + this.f4660a);
    }

    private AlgorithmParameterSpec k(Context context, Calendar calendar, Calendar calendar2) {
        return new KeyPairGeneratorSpec.Builder(context).setAlias(this.f4660a).setSubject(new X500Principal("CN=" + this.f4660a)).setSerialNumber(BigInteger.valueOf(1L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
    }

    private void l(Locale locale) {
        Locale.setDefault(locale);
        Configuration configuration = this.f4661b.getResources().getConfiguration();
        configuration.setLocale(locale);
        this.f4661b.createConfigurationContext(configuration);
    }

    @Override // y0.a
    public byte[] a(Key key) {
        PublicKey h3 = h();
        Cipher i3 = i();
        i3.init(3, h3, f());
        return i3.wrap(key);
    }

    @Override // y0.a
    public Key b(byte[] bArr, String str) {
        PrivateKey g3 = g();
        Cipher i3 = i();
        i3.init(4, g3, f());
        return i3.unwrap(bArr, str, 3);
    }

    protected String c() {
        return this.f4661b.getPackageName() + ".FlutterSecureStoragePluginKey";
    }

    protected AlgorithmParameterSpec f() {
        return null;
    }

    protected Cipher i() {
        return Cipher.getInstance("RSA/ECB/PKCS1Padding", Build.VERSION.SDK_INT < 23 ? "AndroidOpenSSL" : "AndroidKeyStoreBCWorkaround");
    }

    protected AlgorithmParameterSpec j(Context context, Calendar calendar, Calendar calendar2) {
        return new KeyGenParameterSpec.Builder(this.f4660a, 3).setCertificateSubject(new X500Principal("CN=" + this.f4660a)).setDigests("SHA-256").setBlockModes("ECB").setEncryptionPaddings("PKCS1Padding").setCertificateSerialNumber(BigInteger.valueOf(1L)).setCertificateNotBefore(calendar.getTime()).setCertificateNotAfter(calendar2.getTime()).build();
    }
}
