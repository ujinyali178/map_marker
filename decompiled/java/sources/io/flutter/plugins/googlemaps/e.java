package io.flutter.plugins.googlemaps;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.google.maps.android.collections.MarkerManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import u1.l;

/* loaded from: /root/release/classes.dex */
class e implements GoogleMap.OnCameraIdleListener, ClusterManager.OnClusterClickListener<n> {

    /* renamed from: c, reason: collision with root package name */
    private final Context f3272c;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, ClusterManager<n>> f3273d = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private final u1.l f3274f;

    /* renamed from: g, reason: collision with root package name */
    private MarkerManager f3275g;

    /* renamed from: h, reason: collision with root package name */
    private GoogleMap f3276h;

    /* renamed from: i, reason: collision with root package name */
    private ClusterManager.OnClusterItemClickListener<n> f3277i;

    /* renamed from: j, reason: collision with root package name */
    private b<n> f3278j;

    private static class a<T extends n> extends DefaultClusterRenderer<T> {

        /* renamed from: a, reason: collision with root package name */
        private final e f3279a;

        public a(Context context, GoogleMap googleMap, ClusterManager<T> clusterManager, e eVar) {
            super(context, googleMap, clusterManager);
            this.f3279a = eVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.maps.android.clustering.view.DefaultClusterRenderer
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onBeforeClusterItemRendered(T t3, MarkerOptions markerOptions) {
            t3.o(markerOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.maps.android.clustering.view.DefaultClusterRenderer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onClusterItemRendered(T t3, Marker marker) {
            super.onClusterItemRendered(t3, marker);
            this.f3279a.i(t3, marker);
        }
    }

    public interface b<T extends ClusterItem> {
        void u(T t3, Marker marker);
    }

    e(u1.l lVar, Context context) {
        this.f3272c = context;
        this.f3274f = lVar;
    }

    private static String d(Object obj) {
        return (String) ((Map) obj).get("clusterManagerId");
    }

    private void g(ClusterManager<n> clusterManager, ClusterManager.OnClusterClickListener<n> onClusterClickListener, ClusterManager.OnClusterItemClickListener<n> onClusterItemClickListener) {
        clusterManager.setOnClusterClickListener(onClusterClickListener);
        clusterManager.setOnClusterItemClickListener(onClusterItemClickListener);
    }

    private void h() {
        Iterator<Map.Entry<String, ClusterManager<n>>> it = this.f3273d.entrySet().iterator();
        while (it.hasNext()) {
            g(it.next().getValue(), this, this.f3277i);
        }
    }

    private void j(Object obj) {
        ClusterManager<n> remove = this.f3273d.remove(obj);
        if (remove == null) {
            return;
        }
        g(remove, null, null);
        remove.clearItems();
        remove.cluster();
    }

    void a(Object obj) {
        String d3 = d(obj);
        if (d3 == null) {
            throw new IllegalArgumentException("clusterManagerId was null");
        }
        ClusterManager<n> clusterManager = new ClusterManager<>(this.f3272c, this.f3276h, this.f3275g);
        clusterManager.setRenderer(new a(this.f3272c, this.f3276h, clusterManager, this));
        g(clusterManager, this, this.f3277i);
        this.f3273d.put(d3, clusterManager);
    }

    void b(List<Object> list) {
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public void c(n nVar) {
        ClusterManager<n> clusterManager = this.f3273d.get(nVar.l());
        if (clusterManager != null) {
            clusterManager.addItem(nVar);
            clusterManager.cluster();
        }
    }

    public void e(String str, l.d dVar) {
        ClusterManager<n> clusterManager = this.f3273d.get(str);
        if (clusterManager != null) {
            dVar.a(f.d(str, clusterManager.getAlgorithm().getClusters(this.f3276h.getCameraPosition().zoom)));
            return;
        }
        dVar.b("Invalid clusterManagerId", "getClusters called with invalid clusterManagerId:" + str, null);
    }

    void f(GoogleMap googleMap, MarkerManager markerManager) {
        this.f3275g = markerManager;
        this.f3276h = googleMap;
    }

    void i(n nVar, Marker marker) {
        b<n> bVar = this.f3278j;
        if (bVar != null) {
            bVar.u(nVar, marker);
        }
    }

    public void k(List<Object> list) {
        for (Object obj : list) {
            if (obj != null) {
                j((String) obj);
            }
        }
    }

    public void l(n nVar) {
        ClusterManager<n> clusterManager = this.f3273d.get(nVar.l());
        if (clusterManager != null) {
            clusterManager.removeItem(nVar);
            clusterManager.cluster();
        }
    }

    void m(ClusterManager.OnClusterItemClickListener<n> onClusterItemClickListener) {
        this.f3277i = onClusterItemClickListener;
        h();
    }

    void n(b<n> bVar) {
        this.f3278j = bVar;
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
    public void onCameraIdle() {
        Iterator<Map.Entry<String, ClusterManager<n>>> it = this.f3273d.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onCameraIdle();
        }
    }

    @Override // com.google.maps.android.clustering.ClusterManager.OnClusterClickListener
    public boolean onClusterClick(Cluster<n> cluster) {
        if (cluster.getSize() > 0) {
            this.f3274f.c("cluster#onTap", f.c(((n[]) cluster.getItems().toArray(new n[0]))[0].l(), cluster));
        }
        return false;
    }
}
