package h2;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes.dex */
public class s extends r {
    public static <T> boolean j(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        kotlin.jvm.internal.k.e(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        boolean z3 = false;
        Iterator<? extends T> it = elements.iterator();
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z3 = true;
            }
        }
        return z3;
    }
}
