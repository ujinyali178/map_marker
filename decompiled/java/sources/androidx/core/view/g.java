package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /root/release/classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f809a;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<h> f810b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final Map<h, a> f811c = new HashMap();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        final androidx.lifecycle.e f812a;

        /* renamed from: b, reason: collision with root package name */
        private androidx.lifecycle.g f813b;

        a(androidx.lifecycle.e eVar, androidx.lifecycle.g gVar) {
            this.f812a = eVar;
            this.f813b = gVar;
            eVar.a(gVar);
        }

        void a() {
            this.f812a.c(this.f813b);
            this.f813b = null;
        }
    }

    public g(Runnable runnable) {
        this.f809a = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(h hVar, androidx.lifecycle.i iVar, e.a aVar) {
        if (aVar == e.a.ON_DESTROY) {
            l(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(e.b bVar, h hVar, androidx.lifecycle.i iVar, e.a aVar) {
        if (aVar == e.a.d(bVar)) {
            c(hVar);
            return;
        }
        if (aVar == e.a.ON_DESTROY) {
            l(hVar);
        } else if (aVar == e.a.b(bVar)) {
            this.f810b.remove(hVar);
            this.f809a.run();
        }
    }

    public void c(h hVar) {
        this.f810b.add(hVar);
        this.f809a.run();
    }

    public void d(final h hVar, androidx.lifecycle.i iVar) {
        c(hVar);
        androidx.lifecycle.e lifecycle = iVar.getLifecycle();
        a remove = this.f811c.remove(hVar);
        if (remove != null) {
            remove.a();
        }
        this.f811c.put(hVar, new a(lifecycle, new androidx.lifecycle.g() { // from class: androidx.core.view.e
            @Override // androidx.lifecycle.g
            public final void e(androidx.lifecycle.i iVar2, e.a aVar) {
                g.this.f(hVar, iVar2, aVar);
            }
        }));
    }

    public void e(final h hVar, androidx.lifecycle.i iVar, final e.b bVar) {
        androidx.lifecycle.e lifecycle = iVar.getLifecycle();
        a remove = this.f811c.remove(hVar);
        if (remove != null) {
            remove.a();
        }
        this.f811c.put(hVar, new a(lifecycle, new androidx.lifecycle.g() { // from class: androidx.core.view.f
            @Override // androidx.lifecycle.g
            public final void e(androidx.lifecycle.i iVar2, e.a aVar) {
                g.this.g(bVar, hVar, iVar2, aVar);
            }
        }));
    }

    public void h(Menu menu, MenuInflater menuInflater) {
        Iterator<h> it = this.f810b.iterator();
        while (it.hasNext()) {
            it.next().c(menu, menuInflater);
        }
    }

    public void i(Menu menu) {
        Iterator<h> it = this.f810b.iterator();
        while (it.hasNext()) {
            it.next().b(menu);
        }
    }

    public boolean j(MenuItem menuItem) {
        Iterator<h> it = this.f810b.iterator();
        while (it.hasNext()) {
            if (it.next().a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void k(Menu menu) {
        Iterator<h> it = this.f810b.iterator();
        while (it.hasNext()) {
            it.next().d(menu);
        }
    }

    public void l(h hVar) {
        this.f810b.remove(hVar);
        a remove = this.f811c.remove(hVar);
        if (remove != null) {
            remove.a();
        }
        this.f809a.run();
    }
}
