package h2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes.dex */
public class v extends u {
    public static <T, R> List<g2.j<T, R>> A(Iterable<? extends T> iterable, Iterable<? extends R> other) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        kotlin.jvm.internal.k.e(other, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(o.i(iterable, 10), o.i(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(g2.n.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static <T> boolean k(Iterable<? extends T> iterable, T t3) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t3) : n(iterable, t3) >= 0;
    }

    public static <T> T l(List<? extends T> list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static <T> T m(List<? extends T> list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final <T> int n(Iterable<? extends T> iterable, T t3) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t3);
        }
        int i3 = 0;
        for (T t4 : iterable) {
            if (i3 < 0) {
                n.h();
            }
            if (kotlin.jvm.internal.k.a(t3, t4)) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A o(Iterable<? extends T> iterable, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, p2.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        kotlin.jvm.internal.k.e(buffer, "buffer");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        buffer.append(prefix);
        int i4 = 0;
        for (T t3 : iterable) {
            i4++;
            if (i4 > 1) {
                buffer.append(separator);
            }
            if (i3 >= 0 && i4 > i3) {
                break;
            }
            v2.e.a(buffer, t3, lVar);
        }
        if (i3 >= 0 && i4 > i3) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> String q(Iterable<? extends T> iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, p2.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        String sb = ((StringBuilder) o(iterable, new StringBuilder(), separator, prefix, postfix, i3, truncated, lVar)).toString();
        kotlin.jvm.internal.k.d(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String r(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, p2.l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i4 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i4 & 4) == 0 ? charSequence3 : "";
        int i5 = (i4 & 8) != 0 ? -1 : i3;
        if ((i4 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i4 & 32) != 0) {
            lVar = null;
        }
        return q(iterable, charSequence, charSequence5, charSequence6, i5, charSequence7, lVar);
    }

    public static <T extends Comparable<? super T>> T s(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T> T t(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) u((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final <T> T u(List<? extends T> list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static final <T, C extends Collection<? super T>> C v(Iterable<? extends T> iterable, C destination) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static <T> List<T> w(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return n.g(x(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return n.d();
        }
        if (size != 1) {
            return y(collection);
        }
        return m.b(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> List<T> x(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        return iterable instanceof Collection ? y((Collection) iterable) : (List) v(iterable, new ArrayList());
    }

    public static final <T> List<T> y(Collection<? extends T> collection) {
        kotlin.jvm.internal.k.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> Set<T> z(Iterable<? extends T> iterable) {
        Set<T> b4;
        int a4;
        kotlin.jvm.internal.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return j0.c((Set) v(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            b4 = j0.b();
            return b4;
        }
        if (size == 1) {
            return i0.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        a4 = d0.a(collection.size());
        return (Set) v(iterable, new LinkedHashSet(a4));
    }
}
