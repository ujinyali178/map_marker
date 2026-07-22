package v1;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import t1.h;

/* loaded from: /root/release/classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final h f4398a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f4399b;

    /* renamed from: c, reason: collision with root package name */
    final h.b f4400c;

    class a implements h.b {
        a() {
        }

        @Override // t1.h.b
        public String a(String str, String str2) {
            Context context = b.this.f4399b;
            if (str2 != null) {
                Locale b4 = b.b(str2);
                Configuration configuration = new Configuration(b.this.f4399b.getResources().getConfiguration());
                configuration.setLocale(b4);
                context = b.this.f4399b.createConfigurationContext(configuration);
            }
            int identifier = context.getResources().getIdentifier(str, "string", b.this.f4399b.getPackageName());
            if (identifier != 0) {
                return context.getResources().getString(identifier);
            }
            return null;
        }
    }

    public b(Context context, h hVar) {
        a aVar = new a();
        this.f4400c = aVar;
        this.f4399b = context;
        this.f4398a = hVar;
        hVar.c(aVar);
    }

    public static Locale b(String str) {
        String str2;
        String[] split = str.replace('_', '-').split("-", -1);
        String str3 = split[0];
        String str4 = "";
        int i3 = 1;
        if (split.length <= 1 || split[1].length() != 4) {
            str2 = "";
        } else {
            str2 = split[1];
            i3 = 2;
        }
        if (split.length > i3 && split[i3].length() >= 2 && split[i3].length() <= 3) {
            str4 = split[i3];
        }
        return new Locale(str3, str4, str2);
    }

    public Locale c(List<Locale> list) {
        LocaleList locales;
        LocaleList locales2;
        Locale lookup;
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            ArrayList arrayList = new ArrayList();
            locales2 = this.f4399b.getResources().getConfiguration().getLocales();
            int size = locales2.size();
            for (int i4 = 0; i4 < size; i4++) {
                Locale locale = locales2.get(i4);
                String language = locale.getLanguage();
                if (!locale.getScript().isEmpty()) {
                    language = language + "-" + locale.getScript();
                }
                if (!locale.getCountry().isEmpty()) {
                    language = language + "-" + locale.getCountry();
                }
                arrayList.add(new Locale.LanguageRange(language));
                arrayList.add(new Locale.LanguageRange(locale.getLanguage()));
                arrayList.add(new Locale.LanguageRange(locale.getLanguage() + "-*"));
            }
            lookup = Locale.lookup(arrayList, list);
            if (lookup != null) {
                return lookup;
            }
        } else if (i3 >= 24) {
            locales = this.f4399b.getResources().getConfiguration().getLocales();
            for (int i5 = 0; i5 < locales.size(); i5++) {
                Locale locale2 = locales.get(i5);
                for (Locale locale3 : list) {
                    if (locale2.equals(locale3)) {
                        return locale3;
                    }
                }
                for (Locale locale4 : list) {
                    if (locale2.getLanguage().equals(locale4.toLanguageTag())) {
                        return locale4;
                    }
                }
                for (Locale locale5 : list) {
                    if (locale2.getLanguage().equals(locale5.getLanguage())) {
                        return locale5;
                    }
                }
            }
        } else {
            Locale locale6 = this.f4399b.getResources().getConfiguration().locale;
            if (locale6 != null) {
                for (Locale locale7 : list) {
                    if (locale6.equals(locale7)) {
                        return locale7;
                    }
                }
                for (Locale locale8 : list) {
                    if (locale6.getLanguage().equals(locale8.toString())) {
                        return locale8;
                    }
                }
            }
        }
        return list.get(0);
    }

    public void d(Configuration configuration) {
        LocaleList locales;
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            locales = configuration.getLocales();
            int size = locales.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(locales.get(i3));
            }
        } else {
            arrayList.add(configuration.locale);
        }
        this.f4398a.b(arrayList);
    }
}
