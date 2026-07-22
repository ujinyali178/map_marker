package io.flutter.plugins.googlemaps;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import io.flutter.plugins.googlemaps.e0;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import u1.l;

/* loaded from: /root/release/classes.dex */
class e0 implements TileProvider {

    /* renamed from: a, reason: collision with root package name */
    protected final String f3280a;

    /* renamed from: b, reason: collision with root package name */
    protected final u1.l f3281b;

    /* renamed from: c, reason: collision with root package name */
    protected final Handler f3282c = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    final class a implements l.d {

        /* renamed from: a, reason: collision with root package name */
        private final CountDownLatch f3283a = new CountDownLatch(1);

        /* renamed from: b, reason: collision with root package name */
        private final int f3284b;

        /* renamed from: c, reason: collision with root package name */
        private final int f3285c;

        /* renamed from: d, reason: collision with root package name */
        private final int f3286d;

        /* renamed from: e, reason: collision with root package name */
        private Map<String, ?> f3287e;

        a(int i3, int i4, int i5) {
            this.f3284b = i3;
            this.f3285c = i4;
            this.f3286d = i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            e0 e0Var = e0.this;
            e0Var.f3281b.d("tileOverlay#getTile", f.t(e0Var.f3280a, this.f3284b, this.f3285c, this.f3286d), this);
        }

        @Override // u1.l.d
        public void a(Object obj) {
            this.f3287e = (Map) obj;
            this.f3283a.countDown();
        }

        @Override // u1.l.d
        public void b(String str, String str2, Object obj) {
            Log.e("TileProviderController", "Can't get tile: errorCode = " + str + ", errorMessage = " + str + ", date = " + obj);
            this.f3287e = null;
            this.f3283a.countDown();
        }

        @Override // u1.l.d
        public void c() {
            Log.e("TileProviderController", "Can't get tile: notImplemented");
            this.f3287e = null;
            this.f3283a.countDown();
        }

        Tile e() {
            String format;
            e0.this.f3282c.post(new Runnable() { // from class: io.flutter.plugins.googlemaps.d0
                @Override // java.lang.Runnable
                public final void run() {
                    e0.a.this.f();
                }
            });
            try {
                this.f3283a.await();
            } catch (InterruptedException e3) {
                e = e3;
                format = String.format("countDownLatch: can't get tile: x = %d, y= %d, zoom = %d", Integer.valueOf(this.f3284b), Integer.valueOf(this.f3285c), Integer.valueOf(this.f3286d));
            }
            try {
                return f.l(this.f3287e);
            } catch (Exception e4) {
                e = e4;
                format = "Can't parse tile data";
                Log.e("TileProviderController", format, e);
                return TileProvider.NO_TILE;
            }
        }
    }

    e0(u1.l lVar, String str) {
        this.f3280a = str;
        this.f3281b = lVar;
    }

    @Override // com.google.android.gms.maps.model.TileProvider
    public Tile getTile(int i3, int i4, int i5) {
        return new a(i3, i4, i5).e();
    }
}
