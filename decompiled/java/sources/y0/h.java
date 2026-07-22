package y0;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /root/release/classes.dex */
public class h implements i {

    /* renamed from: a, reason: collision with root package name */
    private final Cipher f4662a;

    /* renamed from: b, reason: collision with root package name */
    private final SecureRandom f4663b = new SecureRandom();

    /* renamed from: c, reason: collision with root package name */
    private Key f4664c;

    public h(Context context, a aVar) {
        String a4 = a();
        SharedPreferences sharedPreferences = context.getSharedPreferences("FlutterSecureKeyStorage", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String string = sharedPreferences.getString(a4, null);
        this.f4662a = b();
        if (string != null) {
            try {
                this.f4664c = aVar.b(Base64.decode(string, 0), "AES");
                return;
            } catch (Exception e3) {
                Log.e("StorageCipher18Impl", "unwrap key failed", e3);
            }
        }
        byte[] bArr = new byte[16];
        this.f4663b.nextBytes(bArr);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f4664c = secretKeySpec;
        edit.putString(a4, Base64.encodeToString(aVar.a(secretKeySpec), 0));
        edit.apply();
    }

    protected String a() {
        return "VGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK";
    }

    protected Cipher b() {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    protected int c() {
        return 16;
    }

    protected AlgorithmParameterSpec d(byte[] bArr) {
        return new IvParameterSpec(bArr);
    }

    @Override // y0.i
    public byte[] decrypt(byte[] bArr) {
        int c3 = c();
        byte[] bArr2 = new byte[c3];
        System.arraycopy(bArr, 0, bArr2, 0, c3);
        AlgorithmParameterSpec d3 = d(bArr2);
        int length = bArr.length - c();
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, c3, bArr3, 0, length);
        this.f4662a.init(2, this.f4664c, d3);
        return this.f4662a.doFinal(bArr3);
    }

    @Override // y0.i
    public byte[] encrypt(byte[] bArr) {
        int c3 = c();
        byte[] bArr2 = new byte[c3];
        this.f4663b.nextBytes(bArr2);
        this.f4662a.init(1, this.f4664c, d(bArr2));
        byte[] doFinal = this.f4662a.doFinal(bArr);
        byte[] bArr3 = new byte[doFinal.length + c3];
        System.arraycopy(bArr2, 0, bArr3, 0, c3);
        System.arraycopy(doFinal, 0, bArr3, c3, doFinal.length);
        return bArr3;
    }
}
