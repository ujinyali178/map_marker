package u;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import java.util.List;
import java.util.Locale;

/* loaded from: /root/release/classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4337a;

    a(Context context) {
        this.f4337a = context;
    }

    private static Geocoder a(Context context, Locale locale) {
        return locale != null ? new Geocoder(context, locale) : new Geocoder(context);
    }

    List<Address> b(String str, Locale locale, Double d3, Double d4, Double d5, Double d6) {
        Geocoder a4 = a(this.f4337a, locale);
        return (d3 == null || d4 == null || d5 == null || d6 == null) ? a4.getFromLocationName(str, 5) : a4.getFromLocationName(str, 5, d3.doubleValue(), d4.doubleValue(), d5.doubleValue(), d6.doubleValue());
    }

    List<Address> c(double d3, double d4, Locale locale) {
        return a(this.f4337a, locale).getFromLocation(d3, d4, 5);
    }
}
