package dev.fluttercommunity.plus.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import dev.fluttercommunity.plus.connectivity.ConnectivityBroadcastReceiver;
import java.util.List;
import u1.e;

/* loaded from: /root/release/classes.dex */
public class ConnectivityBroadcastReceiver extends BroadcastReceiver implements e.d {

    /* renamed from: c, reason: collision with root package name */
    private final Context f2466c;

    /* renamed from: d, reason: collision with root package name */
    private final dev.fluttercommunity.plus.connectivity.a f2467d;

    /* renamed from: f, reason: collision with root package name */
    private e.b f2468f;

    /* renamed from: g, reason: collision with root package name */
    private final Handler f2469g = new Handler(Looper.getMainLooper());

    /* renamed from: h, reason: collision with root package name */
    private ConnectivityManager.NetworkCallback f2470h;

    class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            ConnectivityBroadcastReceiver connectivityBroadcastReceiver = ConnectivityBroadcastReceiver.this;
            connectivityBroadcastReceiver.k(connectivityBroadcastReceiver.f2467d.a(network));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            ConnectivityBroadcastReceiver connectivityBroadcastReceiver = ConnectivityBroadcastReceiver.this;
            connectivityBroadcastReceiver.k(connectivityBroadcastReceiver.f2467d.b(networkCapabilities));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            ConnectivityBroadcastReceiver.this.j();
        }
    }

    public ConnectivityBroadcastReceiver(Context context, dev.fluttercommunity.plus.connectivity.a aVar) {
        this.f2466c = context;
        this.f2467d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        this.f2468f.a(this.f2467d.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(List list) {
        this.f2468f.a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f2469g.postDelayed(new Runnable() { // from class: d1.d
            @Override // java.lang.Runnable
            public final void run() {
                ConnectivityBroadcastReceiver.this.h();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final List<String> list) {
        this.f2469g.post(new Runnable() { // from class: d1.c
            @Override // java.lang.Runnable
            public final void run() {
                ConnectivityBroadcastReceiver.this.i(list);
            }
        });
    }

    @Override // u1.e.d
    public void a(Object obj) {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                this.f2466c.unregisterReceiver(this);
            } catch (Exception unused) {
            }
        } else if (this.f2470h != null) {
            this.f2467d.c().unregisterNetworkCallback(this.f2470h);
            this.f2470h = null;
        }
    }

    @Override // u1.e.d
    public void c(Object obj, e.b bVar) {
        this.f2468f = bVar;
        if (Build.VERSION.SDK_INT >= 24) {
            this.f2470h = new a();
            this.f2467d.c().registerDefaultNetworkCallback(this.f2470h);
        } else {
            this.f2466c.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        k(this.f2467d.d());
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        e.b bVar = this.f2468f;
        if (bVar != null) {
            bVar.a(this.f2467d.d());
        }
    }
}
