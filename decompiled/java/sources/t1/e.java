package t1;

import android.view.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import t1.e;
import u1.b;

/* loaded from: /root/release/classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final u1.b<Object> f4129a;

    public interface a {
        void a(boolean z3);
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final KeyEvent f4130a;

        /* renamed from: b, reason: collision with root package name */
        public final Character f4131b;

        public b(KeyEvent keyEvent, Character ch) {
            this.f4130a = keyEvent;
            this.f4131b = ch;
        }
    }

    public e(u1.d dVar) {
        this.f4129a = new u1.b<>(dVar, "flutter/keyevent", u1.g.f4370a);
    }

    private static b.e<Object> b(final a aVar) {
        return new b.e() { // from class: t1.d
            @Override // u1.b.e
            public final void a(Object obj) {
                e.d(e.a.this, obj);
            }
        };
    }

    private Map<String, Object> c(b bVar, boolean z3) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", z3 ? "keyup" : "keydown");
        hashMap.put("keymap", "android");
        hashMap.put("flags", Integer.valueOf(bVar.f4130a.getFlags()));
        hashMap.put("plainCodePoint", Integer.valueOf(bVar.f4130a.getUnicodeChar(0)));
        hashMap.put("codePoint", Integer.valueOf(bVar.f4130a.getUnicodeChar()));
        hashMap.put("keyCode", Integer.valueOf(bVar.f4130a.getKeyCode()));
        hashMap.put("scanCode", Integer.valueOf(bVar.f4130a.getScanCode()));
        hashMap.put("metaState", Integer.valueOf(bVar.f4130a.getMetaState()));
        Character ch = bVar.f4131b;
        if (ch != null) {
            hashMap.put("character", ch.toString());
        }
        hashMap.put("source", Integer.valueOf(bVar.f4130a.getSource()));
        hashMap.put("deviceId", Integer.valueOf(bVar.f4130a.getDeviceId()));
        hashMap.put("repeatCount", Integer.valueOf(bVar.f4130a.getRepeatCount()));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(a aVar, Object obj) {
        boolean z3 = false;
        if (obj != null) {
            try {
                z3 = ((JSONObject) obj).getBoolean("handled");
            } catch (JSONException e3) {
                g1.b.b("KeyEventChannel", "Unable to unpack JSON message: " + e3);
            }
        }
        aVar.a(z3);
    }

    public void e(b bVar, boolean z3, a aVar) {
        this.f4129a.d(c(bVar, z3), b(aVar));
    }
}
