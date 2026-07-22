package x0;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import android.util.Log;
import androidx.security.crypto.a;
import androidx.security.crypto.c;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import y0.i;
import y0.m;

/* loaded from: /root/release/classes.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private final Context f4548c;

    /* renamed from: e, reason: collision with root package name */
    protected Map<String, Object> f4550e;

    /* renamed from: g, reason: collision with root package name */
    private SharedPreferences f4552g;

    /* renamed from: h, reason: collision with root package name */
    private i f4553h;

    /* renamed from: i, reason: collision with root package name */
    private m f4554i;

    /* renamed from: a, reason: collision with root package name */
    private final String f4546a = "SecureStorageAndroid";

    /* renamed from: d, reason: collision with root package name */
    protected String f4549d = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIHNlY3VyZSBzdG9yYWdlCg";

    /* renamed from: f, reason: collision with root package name */
    private String f4551f = "FlutterSecureStorage";

    /* renamed from: j, reason: collision with root package name */
    private Boolean f4555j = Boolean.FALSE;

    /* renamed from: b, reason: collision with root package name */
    private final Charset f4547b = StandardCharsets.UTF_8;

    public a(Context context, Map<String, Object> map) {
        this.f4550e = map;
        this.f4548c = context.getApplicationContext();
    }

    private void b(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        try {
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                Object value = entry.getValue();
                String key = entry.getKey();
                if ((value instanceof String) && key.contains(this.f4549d)) {
                    sharedPreferences2.edit().putString(key, d((String) value)).apply();
                    sharedPreferences.edit().remove(key).apply();
                }
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            this.f4554i.d(edit);
            edit.apply();
        } catch (Exception e3) {
            Log.e("SecureStorageAndroid", "Data migration failed", e3);
        }
    }

    private String d(String str) {
        if (str == null) {
            return null;
        }
        return new String(this.f4553h.decrypt(Base64.decode(str, 0)), this.f4547b);
    }

    private void g() {
        h();
        SharedPreferences sharedPreferences = this.f4548c.getSharedPreferences(this.f4551f, 0);
        if (this.f4553h == null) {
            try {
                k(sharedPreferences);
            } catch (Exception e3) {
                Log.e("SecureStorageAndroid", "StorageCipher initialization failed", e3);
            }
        }
        if (!j() || Build.VERSION.SDK_INT < 23) {
            this.f4552g = sharedPreferences;
            return;
        }
        try {
            SharedPreferences l3 = l(this.f4548c);
            this.f4552g = l3;
            b(sharedPreferences, l3);
        } catch (Exception e4) {
            Log.e("SecureStorageAndroid", "EncryptedSharedPreferences initialization failed", e4);
            this.f4552g = sharedPreferences;
            this.f4555j = Boolean.TRUE;
        }
    }

    private boolean j() {
        return !this.f4555j.booleanValue() && this.f4550e.containsKey("encryptedSharedPreferences") && this.f4550e.get("encryptedSharedPreferences").equals("true") && Build.VERSION.SDK_INT >= 23;
    }

    private void k(SharedPreferences sharedPreferences) {
        i a4;
        this.f4554i = new m(sharedPreferences, this.f4550e);
        if (j()) {
            a4 = this.f4554i.c(this.f4548c);
        } else {
            if (this.f4554i.e()) {
                m(this.f4554i, sharedPreferences);
                return;
            }
            a4 = this.f4554i.a(this.f4548c);
        }
        this.f4553h = a4;
    }

    private SharedPreferences l(Context context) {
        return androidx.security.crypto.a.a(context, this.f4551f, new c.a(context).b(new KeyGenParameterSpec.Builder("_androidx_security_master_key_", 3).setEncryptionPaddings("NoPadding").setBlockModes("GCM").setKeySize(UserVerificationMethods.USER_VERIFY_HANDPRINT).build()).a(), a.d.AES256_SIV, a.e.AES256_GCM);
    }

    private void m(m mVar, SharedPreferences sharedPreferences) {
        try {
            this.f4553h = mVar.c(this.f4548c);
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                Object value = entry.getValue();
                String key = entry.getKey();
                if ((value instanceof String) && key.contains(this.f4549d)) {
                    hashMap.put(key, d((String) value));
                }
            }
            this.f4553h = mVar.a(this.f4548c);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            for (Map.Entry entry2 : hashMap.entrySet()) {
                edit.putString((String) entry2.getKey(), Base64.encodeToString(this.f4553h.encrypt(((String) entry2.getValue()).getBytes(this.f4547b)), 0));
            }
            mVar.f(edit);
            edit.apply();
        } catch (Exception e3) {
            Log.e("SecureStorageAndroid", "re-encryption failed", e3);
            this.f4553h = mVar.c(this.f4548c);
        }
    }

    public String a(String str) {
        return this.f4549d + "_" + str;
    }

    public boolean c(String str) {
        g();
        return this.f4552g.contains(str);
    }

    public void e(String str) {
        g();
        SharedPreferences.Editor edit = this.f4552g.edit();
        edit.remove(str);
        edit.apply();
    }

    public void f() {
        g();
        SharedPreferences.Editor edit = this.f4552g.edit();
        edit.clear();
        if (!j()) {
            this.f4554i.f(edit);
        }
        edit.apply();
    }

    protected void h() {
        if (this.f4550e.containsKey("sharedPreferencesName") && !((String) this.f4550e.get("sharedPreferencesName")).isEmpty()) {
            this.f4551f = (String) this.f4550e.get("sharedPreferencesName");
        }
        if (!this.f4550e.containsKey("preferencesKeyPrefix") || ((String) this.f4550e.get("preferencesKeyPrefix")).isEmpty()) {
            return;
        }
        this.f4549d = (String) this.f4550e.get("preferencesKeyPrefix");
    }

    boolean i() {
        return this.f4550e.containsKey("resetOnError") && this.f4550e.get("resetOnError").equals("true");
    }

    public String n(String str) {
        g();
        String string = this.f4552g.getString(str, null);
        return j() ? string : d(string);
    }

    public Map<String, String> o() {
        g();
        Map<String, ?> all = this.f4552g.getAll();
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getKey().contains(this.f4549d)) {
                String replaceFirst = entry.getKey().replaceFirst(this.f4549d + '_', "");
                boolean j3 = j();
                String str = (String) entry.getValue();
                if (!j3) {
                    str = d(str);
                }
                hashMap.put(replaceFirst, str);
            }
        }
        return hashMap;
    }

    public void p(String str, String str2) {
        g();
        SharedPreferences.Editor edit = this.f4552g.edit();
        if (!j()) {
            str2 = Base64.encodeToString(this.f4553h.encrypt(str2.getBytes(this.f4547b)), 0);
        }
        edit.putString(str, str2);
        edit.apply();
    }
}
