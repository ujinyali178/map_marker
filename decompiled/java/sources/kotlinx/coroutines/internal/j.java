package kotlinx.coroutines.internal;

import java.util.ArrayList;

/* loaded from: /root/release/classes2.dex */
public final class j<E> {
    public static <E> Object a(Object obj) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, int i3, kotlin.jvm.internal.g gVar) {
        if ((i3 & 1) != 0) {
            obj = null;
        }
        return a(obj);
    }

    public static final Object c(Object obj, E e3) {
        if (obj == null) {
            return a(e3);
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e3);
            return a(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e3);
        return a(arrayList);
    }
}
