package u2;

import h2.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import p2.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes.dex */
public class h extends g {
    public static <T, R> b<R> c(b<? extends T> bVar, l<? super T, ? extends R> transform) {
        k.e(bVar, "<this>");
        k.e(transform, "transform");
        return new i(bVar, transform);
    }

    public static final <T, C extends Collection<? super T>> C d(b<? extends T> bVar, C destination) {
        k.e(bVar, "<this>");
        k.e(destination, "destination");
        Iterator<? extends T> it = bVar.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static <T> List<T> e(b<? extends T> bVar) {
        k.e(bVar, "<this>");
        return n.g(f(bVar));
    }

    public static final <T> List<T> f(b<? extends T> bVar) {
        k.e(bVar, "<this>");
        return (List) d(bVar, new ArrayList());
    }
}
