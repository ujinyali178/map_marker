package y2;

/* loaded from: /root/release/classes2.dex */
public final class h {
    public static final <E> f<E> a(int i3, e eVar, p2.l<? super E, g2.q> lVar) {
        if (i3 == -2) {
            return new d(eVar == e.SUSPEND ? f.f4703a.a() : 1, eVar, lVar);
        }
        if (i3 != -1) {
            return i3 != 0 ? i3 != Integer.MAX_VALUE ? (i3 == 1 && eVar == e.DROP_OLDEST) ? new m(lVar) : new d(i3, eVar, lVar) : new n(lVar) : eVar == e.SUSPEND ? new r(lVar) : new d(1, eVar, lVar);
        }
        if ((eVar != e.SUSPEND ? 0 : 1) != 0) {
            return new m(lVar);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
    }

    public static /* synthetic */ f b(int i3, e eVar, p2.l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 0;
        }
        if ((i4 & 2) != 0) {
            eVar = e.SUSPEND;
        }
        if ((i4 & 4) != 0) {
            lVar = null;
        }
        return a(i3, eVar, lVar);
    }
}
