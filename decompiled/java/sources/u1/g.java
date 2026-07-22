package u1;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: /root/release/classes.dex */
public final class g implements j<Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final g f4370a = new g();

    private g() {
    }

    @Override // u1.j
    public ByteBuffer a(Object obj) {
        q qVar;
        String obj2;
        if (obj == null) {
            return null;
        }
        Object a4 = i.a(obj);
        if (a4 instanceof String) {
            qVar = q.f4390b;
            obj2 = JSONObject.quote((String) a4);
        } else {
            qVar = q.f4390b;
            obj2 = a4.toString();
        }
        return qVar.a(obj2);
    }

    @Override // u1.j
    public Object b(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            JSONTokener jSONTokener = new JSONTokener(q.f4390b.b(byteBuffer));
            Object nextValue = jSONTokener.nextValue();
            if (jSONTokener.more()) {
                throw new IllegalArgumentException("Invalid JSON");
            }
            return nextValue;
        } catch (JSONException e3) {
            throw new IllegalArgumentException("Invalid JSON", e3);
        }
    }
}
