package k0;

import android.app.Activity;
import android.os.AsyncTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l0.d;
import org.mapsforge.core.model.Tile;
import org.mapsforge.map.android.graphics.AndroidGraphicFactory;
import org.mapsforge.map.android.graphics.AndroidTileBitmap;
import org.mapsforge.map.datastore.MultiMapDataStore;
import org.mapsforge.map.layer.cache.InMemoryTileCache;
import org.mapsforge.map.layer.labels.TileBasedLabelStore;
import org.mapsforge.map.layer.renderer.DatabaseRenderer;
import org.mapsforge.map.layer.renderer.RendererJob;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.reader.MapFile;
import org.mapsforge.map.rendertheme.InternalRenderTheme;
import org.mapsforge.map.rendertheme.rule.RenderThemeFuture;
import u1.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private final float f3703d;

    /* renamed from: e, reason: collision with root package name */
    private final Activity f3704e;

    /* renamed from: f, reason: collision with root package name */
    private final DisplayModel f3705f;

    /* renamed from: a, reason: collision with root package name */
    private RenderThemeFuture f3700a = null;

    /* renamed from: b, reason: collision with root package name */
    private DatabaseRenderer f3701b = null;

    /* renamed from: c, reason: collision with root package name */
    private MultiMapDataStore f3702c = null;

    /* renamed from: g, reason: collision with root package name */
    private List<File> f3706g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    boolean f3707h = false;

    /* renamed from: i, reason: collision with root package name */
    private final List<l0.c<k, l.d>> f3708i = new ArrayList();

    class a implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f3709c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l.d f3710d;

        a(k kVar, l.d dVar) {
            this.f3709c = kVar;
            this.f3710d = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.h(this.f3709c, this.f3710d);
        }
    }

    /* renamed from: k0.b$b, reason: collision with other inner class name */
    class RunnableC0091b implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f3712c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l.d f3713d;

        RunnableC0091b(k kVar, l.d dVar) {
            this.f3712c = kVar;
            this.f3713d = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.j(this.f3712c, this.f3713d);
        }
    }

    class c implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f3715c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l.d f3716d;

        c(k kVar, l.d dVar) {
            this.f3715c = kVar;
            this.f3716d = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.g(this.f3715c);
                synchronized (b.this.f3708i) {
                    b bVar = b.this;
                    bVar.f3707h = false;
                    if (!bVar.f3708i.isEmpty()) {
                        l0.c cVar = (l0.c) b.this.f3708i.remove(b.this.f3708i.size() - 1);
                        b.this.i((k) cVar.a(), (l.d) cVar.b());
                    }
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    synchronized (b.this.f3708i) {
                        b bVar2 = b.this;
                        bVar2.f3707h = false;
                        if (!bVar2.f3708i.isEmpty()) {
                            l0.c cVar2 = (l0.c) b.this.f3708i.remove(b.this.f3708i.size() - 1);
                            b.this.i((k) cVar2.a(), (l.d) cVar2.b());
                        }
                    }
                } catch (Throwable th2) {
                    synchronized (b.this.f3708i) {
                        b.this.f3707h = false;
                        if (!b.this.f3708i.isEmpty()) {
                            l0.c cVar3 = (l0.c) b.this.f3708i.remove(b.this.f3708i.size() - 1);
                            b.this.i((k) cVar3.a(), (l.d) cVar3.b());
                        }
                        throw th2;
                    }
                }
            }
            this.f3716d.a(null);
        }
    }

    public b(Activity activity) {
        this.f3704e = activity;
        float f3 = activity.getResources().getDisplayMetrics().density;
        this.f3703d = f3;
        DisplayModel displayModel = new DisplayModel();
        this.f3705f = displayModel;
        displayModel.setFixedTileSize((int) (f3 * 256.0f));
    }

    private synchronized byte[] e(int i3, int i4, int i5) {
        List<File> list = this.f3706g;
        if (list.isEmpty()) {
            return null;
        }
        m(list);
        try {
            return k0.a.a(AndroidGraphicFactory.getBitmap((AndroidTileBitmap) this.f3701b.executeJob(new RendererJob(new Tile(i3, i4, (byte) i5, (int) (this.f3703d * 256.0f)), this.f3702c, this.f3700a, this.f3705f, 1.0f, false, false))));
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private void f(k kVar, l.d dVar) {
        synchronized (this.f3708i) {
            if (this.f3707h) {
                this.f3708i.add(new l0.c<>(kVar, dVar));
            } else {
                this.f3707h = true;
                l(new c(kVar, dVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(k kVar) {
        byte[] e3;
        List list = (List) kVar.f4373b;
        Integer num = (Integer) list.get(0);
        Integer num2 = (Integer) list.get(1);
        Integer num3 = (Integer) list.get(2);
        String str = (String) list.get(3);
        File file = new File(str);
        if (file.isFile() || (e3 = e(num.intValue(), num2.intValue(), num3.intValue())) == null) {
            return;
        }
        String str2 = str + ".tmp";
        k0.a.b(e3, str2);
        d.f(new File(str2), file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(k kVar, l.d dVar) {
        dVar.a(Boolean.valueOf(k(new File(((List) kVar.f4373b).get(0).toString()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(k kVar, l.d dVar) {
        List list = (List) ((List) kVar.f4373b).get(0);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new File(it.next().toString()));
        }
        m(arrayList);
        dVar.a(null);
    }

    static boolean k(File file) {
        if (file == null) {
            return false;
        }
        try {
            try {
                new MapFile(file).close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void l(Runnable runnable) {
        AsyncTask.execute(runnable);
    }

    private void m(List<File> list) {
        if (this.f3706g == list) {
            return;
        }
        this.f3706g = list;
        MultiMapDataStore multiMapDataStore = this.f3702c;
        if (multiMapDataStore != null) {
            multiMapDataStore.close();
        }
        this.f3702c = new MultiMapDataStore(MultiMapDataStore.DataPolicy.RETURN_ALL);
        Iterator<File> it = this.f3706g.iterator();
        while (it.hasNext()) {
            try {
                MapFile mapFile = new MapFile(it.next(), "en-US");
                try {
                    this.f3702c.addMapDataStore(mapFile, false, false);
                } catch (Throwable th) {
                    th.printStackTrace();
                    mapFile.close();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        AndroidGraphicFactory.createInstance(this.f3704e.getApplication());
        if (AndroidGraphicFactory.INSTANCE == null) {
            throw new RuntimeException("Need to initialize the AndroidGraphicFactory.INSTANCE via AndroidGraphicFactory.createInstance(context);");
        }
        this.f3701b = new DatabaseRenderer(this.f3702c, AndroidGraphicFactory.INSTANCE, new InMemoryTileCache(2), new TileBasedLabelStore(2), true, true, null);
        if (this.f3700a == null) {
            RenderThemeFuture renderThemeFuture = new RenderThemeFuture(AndroidGraphicFactory.INSTANCE, InternalRenderTheme.DEFAULT, this.f3705f);
            this.f3700a = renderThemeFuture;
            renderThemeFuture.run();
        }
    }

    public void i(k kVar, l.d dVar) {
        Runnable runnableC0091b;
        if (kVar.f4372a.equals("isOfflineMapFileValid")) {
            runnableC0091b = new a(kVar, dVar);
        } else {
            if (!kVar.f4372a.equals("setOfflineMapFiles")) {
                if (kVar.f4372a.equals("buildPngMapTile")) {
                    f(kVar, dVar);
                    return;
                } else {
                    dVar.c();
                    return;
                }
            }
            runnableC0091b = new RunnableC0091b(kVar, dVar);
        }
        l(runnableC0091b);
    }
}
