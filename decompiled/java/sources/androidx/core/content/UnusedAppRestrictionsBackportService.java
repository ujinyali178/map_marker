package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import i.b;

/* loaded from: /root/release/classes.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {

    /* renamed from: c, reason: collision with root package name */
    private b.a f624c = new a();

    class a extends b.a {
        a() {
        }

        @Override // i.b
        public void a(i.a aVar) {
            if (aVar == null) {
                return;
            }
            UnusedAppRestrictionsBackportService.this.a(new o(aVar));
        }
    }

    protected abstract void a(o oVar);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f624c;
    }
}
