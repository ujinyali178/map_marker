package u1;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: /root/release/classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f4372a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4373b;

    public k(String str, Object obj) {
        this.f4372a = str;
        this.f4373b = obj;
    }

    public <T> T a(String str) {
        Object obj = this.f4373b;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return (T) ((Map) obj).get(str);
        }
        if (obj instanceof JSONObject) {
            return (T) ((JSONObject) obj).opt(str);
        }
        throw new ClassCastException();
    }

    public <T> T b() {
        return (T) this.f4373b;
    }

    public boolean c(String str) {
        Object obj = this.f4373b;
        if (obj == null) {
            return false;
        }
        if (obj instanceof Map) {
            return ((Map) obj).containsKey(str);
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).has(str);
        }
        throw new ClassCastException();
    }
}
