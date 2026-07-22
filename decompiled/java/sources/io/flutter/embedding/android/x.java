package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.d0;
import t1.e;

/* loaded from: /root/release/classes.dex */
public class x implements d0.d {

    /* renamed from: a, reason: collision with root package name */
    private final t1.e f2888a;

    /* renamed from: b, reason: collision with root package name */
    private final d0.b f2889b = new d0.b();

    public x(t1.e eVar) {
        this.f2888a = eVar;
    }

    @Override // io.flutter.embedding.android.d0.d
    public void a(KeyEvent keyEvent, final d0.d.a aVar) {
        int action = keyEvent.getAction();
        if (action == 0 || action == 1) {
            this.f2888a.e(new e.b(keyEvent, this.f2889b.a(keyEvent.getUnicodeChar())), action != 0, new e.a() { // from class: io.flutter.embedding.android.w
                @Override // t1.e.a
                public final void a(boolean z3) {
                    d0.d.a.this.a(z3);
                }
            });
        } else {
            aVar.a(false);
        }
    }
}
