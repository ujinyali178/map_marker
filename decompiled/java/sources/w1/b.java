package w1;

import android.view.PointerIcon;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.HashMap;
import t1.i;

/* loaded from: /root/release/classes.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, Integer> f4436c;

    /* renamed from: a, reason: collision with root package name */
    private final c f4437a;

    /* renamed from: b, reason: collision with root package name */
    private final i f4438b;

    class a implements i.b {
        a() {
        }

        @Override // t1.i.b
        public void a(String str) {
            b.this.f4437a.setPointerIcon(b.this.d(str));
        }
    }

    /* renamed from: w1.b$b, reason: collision with other inner class name */
    class C0110b extends HashMap<String, Integer> {
        C0110b() {
            put("alias", 1010);
            put("allScroll", 1013);
            put("basic", 1000);
            put("cell", 1006);
            put("click", 1002);
            put("contextMenu", 1001);
            put("copy", 1011);
            put("forbidden", 1012);
            put("grab", 1020);
            put("grabbing", 1021);
            put("help", 1003);
            put("move", 1013);
            put(DevicePublicKeyStringDef.NONE, 0);
            put("noDrop", 1012);
            put("precise", 1007);
            put("text", 1008);
            put("resizeColumn", 1014);
            put("resizeDown", 1015);
            put("resizeUpLeft", 1016);
            put("resizeDownRight", 1017);
            put("resizeLeft", 1014);
            put("resizeLeftRight", 1014);
            put("resizeRight", 1014);
            put("resizeRow", 1015);
            put("resizeUp", 1015);
            put("resizeUpDown", 1015);
            put("resizeUpLeft", 1017);
            put("resizeUpRight", 1016);
            put("resizeUpLeftDownRight", 1017);
            put("resizeUpRightDownLeft", 1016);
            put("verticalText", 1009);
            put("wait", Integer.valueOf(GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION));
            put("zoomIn", 1018);
            put("zoomOut", 1019);
        }
    }

    public interface c {
        PointerIcon c(int i3);

        void setPointerIcon(PointerIcon pointerIcon);
    }

    public b(c cVar, i iVar) {
        this.f4437a = cVar;
        this.f4438b = iVar;
        iVar.b(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointerIcon d(String str) {
        Object orDefault;
        if (f4436c == null) {
            f4436c = new C0110b();
        }
        orDefault = f4436c.getOrDefault(str, 1000);
        return this.f4437a.c(((Integer) orDefault).intValue());
    }

    public void c() {
        this.f4438b.b(null);
    }
}
