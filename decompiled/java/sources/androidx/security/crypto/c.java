package androidx.security.crypto;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* loaded from: /root/release/classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f1474a;

    /* renamed from: b, reason: collision with root package name */
    private final KeyGenParameterSpec f1475b;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final String f1476a;

        /* renamed from: b, reason: collision with root package name */
        KeyGenParameterSpec f1477b;

        /* renamed from: c, reason: collision with root package name */
        b f1478c;

        /* renamed from: d, reason: collision with root package name */
        boolean f1479d;

        /* renamed from: e, reason: collision with root package name */
        int f1480e;

        /* renamed from: f, reason: collision with root package name */
        boolean f1481f;

        /* renamed from: g, reason: collision with root package name */
        final Context f1482g;

        /* renamed from: androidx.security.crypto.c$a$a, reason: collision with other inner class name */
        static class C0036a {

            /* renamed from: androidx.security.crypto.c$a$a$a, reason: collision with other inner class name */
            static class C0037a {
                static void a(KeyGenParameterSpec.Builder builder) {
                    builder.setIsStrongBoxBacked(true);
                }
            }

            /* renamed from: androidx.security.crypto.c$a$a$b */
            static class b {
                static void a(KeyGenParameterSpec.Builder builder, int i3, int i4) {
                    builder.setUserAuthenticationParameters(i3, i4);
                }
            }

            static c a(a aVar) {
                b bVar = aVar.f1478c;
                if (bVar == null && aVar.f1477b == null) {
                    throw new IllegalArgumentException("build() called before setKeyGenParameterSpec or setKeyScheme.");
                }
                if (bVar == b.AES256_GCM) {
                    KeyGenParameterSpec.Builder keySize = new KeyGenParameterSpec.Builder(aVar.f1476a, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    if (aVar.f1479d) {
                        keySize.setUserAuthenticationRequired(true);
                        if (Build.VERSION.SDK_INT >= 30) {
                            b.a(keySize, aVar.f1480e, 3);
                        } else {
                            keySize.setUserAuthenticationValidityDurationSeconds(aVar.f1480e);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 28 && aVar.f1481f && aVar.f1482g.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore")) {
                        C0037a.a(keySize);
                    }
                    aVar.f1477b = keySize.build();
                }
                KeyGenParameterSpec keyGenParameterSpec = aVar.f1477b;
                if (keyGenParameterSpec != null) {
                    return new c(e.c(keyGenParameterSpec), aVar.f1477b);
                }
                throw new NullPointerException("KeyGenParameterSpec was null after build() check");
            }

            static String b(KeyGenParameterSpec keyGenParameterSpec) {
                return keyGenParameterSpec.getKeystoreAlias();
            }
        }

        public a(Context context) {
            this(context, "_androidx_security_master_key_");
        }

        public a(Context context, String str) {
            this.f1482g = context.getApplicationContext();
            this.f1476a = str;
        }

        public c a() {
            return Build.VERSION.SDK_INT >= 23 ? C0036a.a(this) : new c(this.f1476a, null);
        }

        public a b(KeyGenParameterSpec keyGenParameterSpec) {
            if (this.f1478c != null) {
                throw new IllegalArgumentException("KeyGenParamSpec set after setting a KeyScheme");
            }
            if (this.f1476a.equals(C0036a.b(keyGenParameterSpec))) {
                this.f1477b = keyGenParameterSpec;
                return this;
            }
            throw new IllegalArgumentException("KeyGenParamSpec's key alias does not match provided alias (" + this.f1476a + " vs " + C0036a.b(keyGenParameterSpec));
        }
    }

    public enum b {
        AES256_GCM
    }

    c(String str, Object obj) {
        this.f1474a = str;
        if (Build.VERSION.SDK_INT >= 23) {
            this.f1475b = (KeyGenParameterSpec) obj;
        } else {
            this.f1475b = null;
        }
    }

    String a() {
        return this.f1474a;
    }

    public boolean b() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.containsAlias(this.f1474a);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException unused) {
            return false;
        }
    }

    public String toString() {
        return "MasterKey{keyAlias=" + this.f1474a + ", isKeyStoreBacked=" + b() + "}";
    }
}
