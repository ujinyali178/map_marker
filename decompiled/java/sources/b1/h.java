package b1;

import java.util.HashMap;
import java.util.Map;
import z0.d0;

/* loaded from: /root/release/classes.dex */
public class h {
    public static Map<String, Object> a(e eVar) {
        d0 d3 = eVar.d();
        if (d3 == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sql", d3.c());
        hashMap.put("arguments", d3.b());
        return hashMap;
    }
}
