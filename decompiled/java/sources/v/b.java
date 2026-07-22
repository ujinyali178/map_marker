package v;

import android.location.Address;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.io.IOUtils;

/* loaded from: /root/release/classes.dex */
public class b {
    private static Map<String, Object> a(Address address) {
        HashMap hashMap = new HashMap();
        String a4 = a.a(address.getAddressLine(0));
        hashMap.put("name", address.getFeatureName());
        hashMap.put("street", a4);
        hashMap.put("isoCountryCode", address.getCountryCode());
        hashMap.put("country", address.getCountryName());
        hashMap.put("thoroughfare", address.getThoroughfare());
        hashMap.put("subThoroughfare", address.getSubThoroughfare());
        hashMap.put("postalCode", address.getPostalCode());
        hashMap.put("administrativeArea", address.getAdminArea());
        hashMap.put("subAdministrativeArea", address.getSubAdminArea());
        hashMap.put("locality", address.getLocality());
        hashMap.put("subLocality", address.getSubLocality());
        return hashMap;
    }

    public static List<Map<String, Object>> b(List<Address> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Address> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public static List<Map<String, Object>> c(List<Address> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Address> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(d(it.next()));
        }
        return arrayList;
    }

    private static Map<String, Object> d(Address address) {
        HashMap hashMap = new HashMap();
        hashMap.put("title", address.getFeatureName());
        int maxAddressLineIndex = address.getMaxAddressLineIndex();
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 <= maxAddressLineIndex; i3++) {
            if (i3 > 0) {
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            sb.append(address.getAddressLine(i3));
        }
        hashMap.put("description", sb.toString());
        hashMap.put("latitude", Double.valueOf(address.getLatitude()));
        hashMap.put("longitude", Double.valueOf(address.getLongitude()));
        hashMap.put("timestamp", Long.valueOf(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis()));
        return hashMap;
    }
}
