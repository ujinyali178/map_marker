package t1;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final u1.l f4148a;

    /* renamed from: b, reason: collision with root package name */
    private b f4149b;

    /* renamed from: c, reason: collision with root package name */
    public final l.c f4150c;

    class a implements l.c {
        a() {
        }

        @Override // u1.l.c
        public void n(u1.k kVar, l.d dVar) {
            if (h.this.f4149b == null) {
                return;
            }
            String str = kVar.f4372a;
            str.hashCode();
            if (!str.equals("Localization.getStringResource")) {
                dVar.c();
                return;
            }
            JSONObject jSONObject = (JSONObject) kVar.b();
            try {
                dVar.a(h.this.f4149b.a(jSONObject.getString("key"), jSONObject.has("locale") ? jSONObject.getString("locale") : null));
            } catch (JSONException e3) {
                dVar.b("error", e3.getMessage(), null);
            }
        }
    }

    public interface b {
        String a(String str, String str2);
    }

    public h(i1.a aVar) {
        a aVar2 = new a();
        this.f4150c = aVar2;
        u1.l lVar = new u1.l(aVar, "flutter/localization", u1.h.f4371a);
        this.f4148a = lVar;
        lVar.e(aVar2);
    }

    public void b(List<Locale> list) {
        g1.b.f("LocalizationChannel", "Sending Locales to Flutter.");
        ArrayList arrayList = new ArrayList();
        for (Locale locale : list) {
            g1.b.f("LocalizationChannel", "Locale (Language: " + locale.getLanguage() + ", Country: " + locale.getCountry() + ", Variant: " + locale.getVariant() + ")");
            arrayList.add(locale.getLanguage());
            arrayList.add(locale.getCountry());
            arrayList.add(locale.getScript());
            arrayList.add(locale.getVariant());
        }
        this.f4148a.c("setLocale", arrayList);
    }

    public void c(b bVar) {
        this.f4149b = bVar;
    }
}
