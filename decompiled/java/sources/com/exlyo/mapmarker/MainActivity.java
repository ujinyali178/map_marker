package com.exlyo.mapmarker;

import android.content.Intent;
import android.os.Bundle;
import io.flutter.embedding.android.FlutterActivity;
import k0.b;
import u1.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class MainActivity extends FlutterActivity {

    /* renamed from: i, reason: collision with root package name */
    b f2150i;

    /* renamed from: j, reason: collision with root package name */
    private final h0.a f2151j = new h0.a(this);

    /* renamed from: k, reason: collision with root package name */
    private final i0.a f2152k = new i0.a(this);

    /* renamed from: l, reason: collision with root package name */
    private final f0.a f2153l = new f0.a(this);

    /* renamed from: m, reason: collision with root package name */
    private final g0.a f2154m = new g0.a(this);

    /* renamed from: n, reason: collision with root package name */
    private final j0.a f2155n = new j0.a(this);

    /* renamed from: o, reason: collision with root package name */
    private final e0.a f2156o = new e0.a(this);

    class a implements l.c {
        a() {
        }

        @Override // u1.l.c
        public void n(k kVar, l.d dVar) {
            MainActivity mainActivity = MainActivity.this;
            if (mainActivity.f2150i == null) {
                mainActivity.f2150i = new b(mainActivity);
            }
            MainActivity.this.f2150i.i(kVar, dVar);
        }
    }

    private void U(Intent intent) {
        if (this.f2156o.c(intent)) {
            return;
        }
        this.f2151j.l(intent);
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.f.d, io.flutter.embedding.android.h
    public void g(io.flutter.embedding.engine.a aVar) {
        super.g(aVar);
        new l(aVar.k().k(), "com.exlyo.mapmarker/offline_maps").e(new a());
        this.f2151j.d(aVar);
        this.f2152k.b(aVar);
        this.f2153l.h(aVar);
        this.f2154m.c(aVar);
        this.f2155n.c(aVar);
        this.f2156o.b(aVar);
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        super.onActivityResult(i3, i4, intent);
        this.f2153l.l(i3, i4, intent);
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        U(getIntent());
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        U(intent);
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f2156o.d();
    }
}
