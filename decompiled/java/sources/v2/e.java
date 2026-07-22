package v2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes.dex */
public class e {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    public static <T> void a(Appendable appendable, T t3, p2.l<? super T, ? extends CharSequence> lVar) {
        CharSequence valueOf;
        kotlin.jvm.internal.k.e(appendable, "<this>");
        if (lVar != null) {
            t3 = (T) lVar.invoke(t3);
        } else {
            if (!(t3 == 0 ? true : t3 instanceof CharSequence)) {
                if (t3 instanceof Character) {
                    appendable.append(((Character) t3).charValue());
                    return;
                } else {
                    valueOf = String.valueOf((Object) t3);
                    appendable.append(valueOf);
                }
            }
        }
        valueOf = (CharSequence) t3;
        appendable.append(valueOf);
    }
}
