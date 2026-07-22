package b2;

import android.content.Context;
import android.util.Log;
import b2.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import m1.a;

/* loaded from: /root/release/classes.dex */
public class j implements m1.a, a.b {

    /* renamed from: c, reason: collision with root package name */
    private Context f1587c;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1588a;

        static {
            int[] iArr = new int[a.c.values().length];
            f1588a = iArr;
            try {
                iArr[a.c.ROOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1588a[a.c.MUSIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1588a[a.c.PODCASTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1588a[a.c.RINGTONES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1588a[a.c.ALARMS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1588a[a.c.NOTIFICATIONS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1588a[a.c.PICTURES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1588a[a.c.MOVIES.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1588a[a.c.DOWNLOADS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1588a[a.c.DCIM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1588a[a.c.DOCUMENTS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private String j() {
        return e2.b.d(this.f1587c);
    }

    private String k() {
        return e2.b.c(this.f1587c);
    }

    private List<String> l() {
        ArrayList arrayList = new ArrayList();
        for (File file : this.f1587c.getExternalCacheDirs()) {
            if (file != null) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return arrayList;
    }

    private List<String> m(a.c cVar) {
        ArrayList arrayList = new ArrayList();
        for (File file : this.f1587c.getExternalFilesDirs(p(cVar))) {
            if (file != null) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return arrayList;
    }

    private String n() {
        File externalFilesDir = this.f1587c.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    private String o() {
        return this.f1587c.getCacheDir().getPath();
    }

    private String p(a.c cVar) {
        switch (a.f1588a[cVar.ordinal()]) {
            case 1:
                return null;
            case 2:
                return "music";
            case 3:
                return "podcasts";
            case 4:
                return "ringtones";
            case 5:
                return "alarms";
            case 6:
                return "notifications";
            case 7:
                return "pictures";
            case 8:
                return "movies";
            case 9:
                return "downloads";
            case 10:
                return "dcim";
            case 11:
                return "documents";
            default:
                throw new RuntimeException("Unrecognized directory: " + cVar);
        }
    }

    private void q(u1.d dVar, Context context) {
        try {
            i.i(dVar, this);
        } catch (Exception e3) {
            Log.e("PathProviderPlugin", "Received exception while setting up PathProviderPlugin", e3);
        }
        this.f1587c = context;
    }

    @Override // b2.a.b
    public List<String> a() {
        return l();
    }

    @Override // m1.a
    public void b(a.b bVar) {
        q(bVar.b(), bVar.a());
    }

    @Override // b2.a.b
    public String c() {
        return n();
    }

    @Override // b2.a.b
    public String d() {
        return o();
    }

    @Override // m1.a
    public void e(a.b bVar) {
        i.i(bVar.b(), null);
    }

    @Override // b2.a.b
    public String f() {
        return this.f1587c.getCacheDir().getPath();
    }

    @Override // b2.a.b
    public String g() {
        return k();
    }

    @Override // b2.a.b
    public List<String> h(a.c cVar) {
        return m(cVar);
    }

    @Override // b2.a.b
    public String i() {
        return j();
    }
}
