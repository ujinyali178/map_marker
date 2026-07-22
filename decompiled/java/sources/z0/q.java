package z0;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
class q implements o {

    /* renamed from: a, reason: collision with root package name */
    final String f4790a;

    /* renamed from: b, reason: collision with root package name */
    final int f4791b;

    /* renamed from: c, reason: collision with root package name */
    final int f4792c;

    /* renamed from: d, reason: collision with root package name */
    private final LinkedList<k> f4793d = new LinkedList<>();

    /* renamed from: e, reason: collision with root package name */
    private final Set<m> f4794e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private final Set<m> f4795f = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    private final Map<Integer, m> f4796g = new HashMap();

    q(String str, int i3, int i4) {
        this.f4790a = str;
        this.f4791b = i3;
        this.f4792c = i4;
    }

    private synchronized k f(m mVar) {
        k next;
        m mVar2;
        ListIterator<k> listIterator = this.f4793d.listIterator();
        do {
            if (!listIterator.hasNext()) {
                return null;
            }
            next = listIterator.next();
            mVar2 = next.a() != null ? this.f4796g.get(next.a()) : null;
            if (mVar2 == null) {
                break;
            }
        } while (mVar2 != mVar);
        listIterator.remove();
        return next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public synchronized void g(m mVar) {
        HashSet hashSet = new HashSet(this.f4794e);
        this.f4795f.remove(mVar);
        this.f4794e.add(mVar);
        if (!mVar.b() && mVar.d() != null) {
            this.f4796g.remove(mVar.d());
        }
        i(mVar);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            i((m) it.next());
        }
    }

    private synchronized void i(m mVar) {
        k f3 = f(mVar);
        if (f3 != null) {
            this.f4795f.add(mVar);
            this.f4794e.remove(mVar);
            if (f3.a() != null) {
                this.f4796g.put(f3.a(), mVar);
            }
            mVar.e(f3);
        }
    }

    @Override // z0.o
    public synchronized void a() {
        Iterator<m> it = this.f4794e.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
        Iterator<m> it2 = this.f4795f.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
    }

    @Override // z0.o
    public /* synthetic */ void b(i iVar, Runnable runnable) {
        n.a(this, iVar, runnable);
    }

    @Override // z0.o
    public synchronized void c(k kVar) {
        this.f4793d.add(kVar);
        Iterator it = new HashSet(this.f4794e).iterator();
        while (it.hasNext()) {
            i((m) it.next());
        }
    }

    protected m e(String str, int i3) {
        return new m(str, i3);
    }

    @Override // z0.o
    public synchronized void start() {
        for (int i3 = 0; i3 < this.f4791b; i3++) {
            final m e3 = e(this.f4790a + i3, this.f4792c);
            e3.g(new Runnable() { // from class: z0.p
                @Override // java.lang.Runnable
                public final void run() {
                    q.this.g(e3);
                }
            });
            this.f4794e.add(e3);
        }
    }
}
