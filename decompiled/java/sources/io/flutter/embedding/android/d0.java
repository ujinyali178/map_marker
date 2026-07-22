package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import io.flutter.plugin.editing.d;
import java.util.HashSet;
import java.util.Map;
import t1.f;

/* loaded from: /root/release/classes.dex */
public class d0 implements d.a, f.b {

    /* renamed from: a, reason: collision with root package name */
    protected final d[] f2736a;

    /* renamed from: b, reason: collision with root package name */
    private final HashSet<KeyEvent> f2737b = new HashSet<>();

    /* renamed from: c, reason: collision with root package name */
    private final e f2738c;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f2739a = 0;

        Character a(int i3) {
            char c3 = (char) i3;
            if ((Integer.MIN_VALUE & i3) != 0) {
                int i4 = i3 & Integer.MAX_VALUE;
                int i5 = this.f2739a;
                if (i5 != 0) {
                    i4 = KeyCharacterMap.getDeadChar(i5, i4);
                }
                this.f2739a = i4;
            } else {
                int i6 = this.f2739a;
                if (i6 != 0) {
                    int deadChar = KeyCharacterMap.getDeadChar(i6, i3);
                    if (deadChar > 0) {
                        c3 = (char) deadChar;
                    }
                    this.f2739a = 0;
                }
            }
            return Character.valueOf(c3);
        }
    }

    private class c {

        /* renamed from: a, reason: collision with root package name */
        final KeyEvent f2740a;

        /* renamed from: b, reason: collision with root package name */
        int f2741b;

        /* renamed from: c, reason: collision with root package name */
        boolean f2742c = false;

        private class a implements d.a {

            /* renamed from: a, reason: collision with root package name */
            boolean f2744a;

            private a() {
                this.f2744a = false;
            }

            @Override // io.flutter.embedding.android.d0.d.a
            public void a(boolean z3) {
                if (this.f2744a) {
                    throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
                }
                this.f2744a = true;
                c cVar = c.this;
                int i3 = cVar.f2741b - 1;
                cVar.f2741b = i3;
                boolean z4 = z3 | cVar.f2742c;
                cVar.f2742c = z4;
                if (i3 != 0 || z4) {
                    return;
                }
                d0.this.e(cVar.f2740a);
            }
        }

        c(KeyEvent keyEvent) {
            this.f2741b = d0.this.f2736a.length;
            this.f2740a = keyEvent;
        }

        public d.a a() {
            return new a();
        }
    }

    public interface d {

        public interface a {
            void a(boolean z3);
        }

        void a(KeyEvent keyEvent, a aVar);
    }

    public interface e {
        void g(KeyEvent keyEvent);

        u1.d getBinaryMessenger();

        boolean l(KeyEvent keyEvent);
    }

    public d0(e eVar) {
        this.f2738c = eVar;
        this.f2736a = new d[]{new c0(eVar.getBinaryMessenger()), new x(new t1.e(eVar.getBinaryMessenger()))};
        new t1.f(eVar.getBinaryMessenger()).b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(KeyEvent keyEvent) {
        e eVar = this.f2738c;
        if (eVar == null || eVar.l(keyEvent)) {
            return;
        }
        this.f2737b.add(keyEvent);
        this.f2738c.g(keyEvent);
        if (this.f2737b.remove(keyEvent)) {
            g1.b.g("KeyboardManager", "A redispatched key event was consumed before reaching KeyboardManager");
        }
    }

    @Override // io.flutter.plugin.editing.d.a
    public boolean a(KeyEvent keyEvent) {
        if (this.f2737b.remove(keyEvent)) {
            return false;
        }
        if (this.f2736a.length <= 0) {
            e(keyEvent);
            return true;
        }
        c cVar = new c(keyEvent);
        for (d dVar : this.f2736a) {
            dVar.a(keyEvent, cVar.a());
        }
        return true;
    }

    @Override // t1.f.b
    public Map<Long, Long> b() {
        return ((c0) this.f2736a[0]).h();
    }

    public void d() {
        int size = this.f2737b.size();
        if (size > 0) {
            g1.b.g("KeyboardManager", "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
        }
    }
}
