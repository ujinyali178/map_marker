package h2;

import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes.dex */
public class o extends n {
    public static <T> int i(Iterable<? extends T> iterable, int i3) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i3;
    }
}
