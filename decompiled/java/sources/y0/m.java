package y0;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public class m {

    /* renamed from: e, reason: collision with root package name */
    private static final d f4670e = d.RSA_ECB_PKCS1Padding;

    /* renamed from: f, reason: collision with root package name */
    private static final l f4671f = l.AES_CBC_PKCS7Padding;

    /* renamed from: a, reason: collision with root package name */
    private final d f4672a;

    /* renamed from: b, reason: collision with root package name */
    private final l f4673b;

    /* renamed from: c, reason: collision with root package name */
    private final d f4674c;

    /* renamed from: d, reason: collision with root package name */
    private final l f4675d;

    public m(SharedPreferences sharedPreferences, Map<String, Object> map) {
        d dVar = f4670e;
        this.f4672a = d.valueOf(sharedPreferences.getString("FlutterSecureSAlgorithmKey", dVar.name()));
        l lVar = f4671f;
        this.f4673b = l.valueOf(sharedPreferences.getString("FlutterSecureSAlgorithmStorage", lVar.name()));
        d valueOf = d.valueOf(b(map, "keyCipherAlgorithm", dVar.name()));
        int i3 = valueOf.f4659d;
        int i4 = Build.VERSION.SDK_INT;
        this.f4674c = i3 <= i4 ? valueOf : dVar;
        l valueOf2 = l.valueOf(b(map, "storageCipherAlgorithm", lVar.name()));
        this.f4675d = valueOf2.f4669d <= i4 ? valueOf2 : lVar;
    }

    private String b(Map<String, Object> map, String str, String str2) {
        Object obj = map.get(str);
        return obj != null ? obj.toString() : str2;
    }

    public i a(Context context) {
        return this.f4675d.f4668c.a(context, this.f4674c.f4658c.a(context));
    }

    public i c(Context context) {
        return this.f4673b.f4668c.a(context, this.f4672a.f4658c.a(context));
    }

    public void d(SharedPreferences.Editor editor) {
        editor.remove("FlutterSecureSAlgorithmKey");
        editor.remove("FlutterSecureSAlgorithmStorage");
    }

    public boolean e() {
        return (this.f4672a == this.f4674c && this.f4673b == this.f4675d) ? false : true;
    }

    public void f(SharedPreferences.Editor editor) {
        editor.putString("FlutterSecureSAlgorithmKey", this.f4674c.name());
        editor.putString("FlutterSecureSAlgorithmStorage", this.f4675d.name());
    }
}
