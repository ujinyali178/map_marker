package h2;

/* loaded from: /root/release/classes.dex */
public final class l extends v {
    public static /* bridge */ /* synthetic */ Appendable p(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, p2.l lVar, int i4, Object obj) {
        Appendable o3;
        o3 = v.o(iterable, appendable, (r14 & 2) != 0 ? ", " : charSequence, (r14 & 4) != 0 ? "" : charSequence2, (r14 & 8) == 0 ? charSequence3 : "", (r14 & 16) != 0 ? -1 : i3, (r14 & 32) != 0 ? "..." : charSequence4, (r14 & 64) != 0 ? null : lVar);
        return o3;
    }
}
