package b2;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public class a {

    /* renamed from: b2.a$a, reason: collision with other inner class name */
    public static class C0041a extends RuntimeException {

        /* renamed from: c, reason: collision with root package name */
        public final String f1565c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f1566d;
    }

    public interface b {
        List<String> a();

        String c();

        String d();

        String f();

        String g();

        List<String> h(c cVar);

        String i();
    }

    public enum c {
        ROOT(0),
        MUSIC(1),
        PODCASTS(2),
        RINGTONES(3),
        ALARMS(4),
        NOTIFICATIONS(5),
        PICTURES(6),
        MOVIES(7),
        DOWNLOADS(8),
        DCIM(9),
        DOCUMENTS(10);


        /* renamed from: c, reason: collision with root package name */
        final int f1579c;

        c(int i3) {
            this.f1579c = i3;
        }
    }

    protected static ArrayList<Object> a(Throwable th) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof C0041a) {
            C0041a c0041a = (C0041a) th;
            arrayList.add(c0041a.f1565c);
            arrayList.add(c0041a.getMessage());
            obj = c0041a.f1566d;
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            obj = "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th);
        }
        arrayList.add(obj);
        return arrayList;
    }
}
