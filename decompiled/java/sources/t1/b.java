package t1;

import android.window.BackEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final u1.l f4120a;

    /* renamed from: b, reason: collision with root package name */
    private final l.c f4121b;

    class a implements l.c {
        a() {
        }

        @Override // u1.l.c
        public void n(u1.k kVar, l.d dVar) {
            dVar.a(null);
        }
    }

    public b(i1.a aVar) {
        a aVar2 = new a();
        this.f4121b = aVar2;
        u1.l lVar = new u1.l(aVar, "flutter/backgesture", u1.p.f4387b);
        this.f4120a = lVar;
        lVar.e(aVar2);
    }

    private Map<String, Object> a(BackEvent backEvent) {
        HashMap hashMap = new HashMap(3);
        float touchX = backEvent.getTouchX();
        float touchY = backEvent.getTouchY();
        hashMap.put("touchOffset", (Float.isNaN(touchX) || Float.isNaN(touchY)) ? null : Arrays.asList(Float.valueOf(touchX), Float.valueOf(touchY)));
        hashMap.put("progress", Float.valueOf(backEvent.getProgress()));
        hashMap.put("swipeEdge", Integer.valueOf(backEvent.getSwipeEdge()));
        return hashMap;
    }

    public void b() {
        g1.b.f("BackGestureChannel", "Sending message to cancel back gesture");
        this.f4120a.c("cancelBackGesture", null);
    }

    public void c() {
        g1.b.f("BackGestureChannel", "Sending message to commit back gesture");
        this.f4120a.c("commitBackGesture", null);
    }

    public void d(BackEvent backEvent) {
        g1.b.f("BackGestureChannel", "Sending message to start back gesture");
        this.f4120a.c("startBackGesture", a(backEvent));
    }

    public void e(BackEvent backEvent) {
        g1.b.f("BackGestureChannel", "Sending message to update back gesture progress");
        this.f4120a.c("updateBackGestureProgress", a(backEvent));
    }
}
