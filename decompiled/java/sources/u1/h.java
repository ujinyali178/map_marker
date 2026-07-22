package u1;

import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /root/release/classes.dex */
public final class h implements m {

    /* renamed from: a, reason: collision with root package name */
    public static final h f4371a = new h();

    private h() {
    }

    @Override // u1.m
    public k a(ByteBuffer byteBuffer) {
        try {
            Object b4 = g.f4370a.b(byteBuffer);
            if (b4 instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) b4;
                Object obj = jSONObject.get("method");
                Object g3 = g(jSONObject.opt("args"));
                if (obj instanceof String) {
                    return new k((String) obj, g3);
                }
            }
            throw new IllegalArgumentException("Invalid method call: " + b4);
        } catch (JSONException e3) {
            throw new IllegalArgumentException("Invalid JSON", e3);
        }
    }

    @Override // u1.m
    public ByteBuffer b(k kVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", kVar.f4372a);
            jSONObject.put("args", i.a(kVar.f4373b));
            return g.f4370a.a(jSONObject);
        } catch (JSONException e3) {
            throw new IllegalArgumentException("Invalid JSON", e3);
        }
    }

    @Override // u1.m
    public ByteBuffer c(Object obj) {
        return g.f4370a.a(new JSONArray().put(i.a(obj)));
    }

    @Override // u1.m
    public ByteBuffer d(String str, String str2, Object obj, String str3) {
        return g.f4370a.a(new JSONArray().put(str).put(i.a(str2)).put(i.a(obj)).put(i.a(str3)));
    }

    @Override // u1.m
    public ByteBuffer e(String str, String str2, Object obj) {
        return g.f4370a.a(new JSONArray().put(str).put(i.a(str2)).put(i.a(obj)));
    }

    @Override // u1.m
    public Object f(ByteBuffer byteBuffer) {
        try {
            Object b4 = g.f4370a.b(byteBuffer);
            if (b4 instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) b4;
                if (jSONArray.length() == 1) {
                    return g(jSONArray.opt(0));
                }
                if (jSONArray.length() == 3) {
                    Object obj = jSONArray.get(0);
                    Object g3 = g(jSONArray.opt(1));
                    Object g4 = g(jSONArray.opt(2));
                    if ((obj instanceof String) && (g3 == null || (g3 instanceof String))) {
                        throw new f((String) obj, (String) g3, g4);
                    }
                }
            }
            throw new IllegalArgumentException("Invalid envelope: " + b4);
        } catch (JSONException e3) {
            throw new IllegalArgumentException("Invalid JSON", e3);
        }
    }

    Object g(Object obj) {
        if (obj == JSONObject.NULL) {
            return null;
        }
        return obj;
    }
}
