package c2;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public class a {

    /* renamed from: c2.a$a, reason: collision with other inner class name */
    public static class C0046a extends RuntimeException {

        /* renamed from: c, reason: collision with root package name */
        public final String f2076c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f2077d;
    }

    public interface b {
        Map<String, Object> a(String str, List<String> list);

        Boolean c(String str, List<String> list);

        Boolean d(String str, List<String> list);

        Boolean f(String str, Long l3);

        Boolean g(String str, String str2);

        Boolean h(String str, Boolean bool);

        Boolean i(String str, Double d3);

        Boolean remove(String str);
    }

    protected static ArrayList<Object> a(Throwable th) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof C0046a) {
            C0046a c0046a = (C0046a) th;
            arrayList.add(c0046a.f2076c);
            arrayList.add(c0046a.getMessage());
            obj = c0046a.f2077d;
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            obj = "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th);
        }
        arrayList.add(obj);
        return arrayList;
    }
}
