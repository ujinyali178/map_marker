package io.flutter.plugins.googlemaps;

import android.content.Context;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapsSdkInitializedCallback;
import u1.l;

/* loaded from: /root/release/classes.dex */
final class i implements OnMapsSdkInitializedCallback, l.c {

    /* renamed from: g, reason: collision with root package name */
    private static l.d f3307g;

    /* renamed from: c, reason: collision with root package name */
    private final u1.l f3308c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f3309d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3310f = false;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3311a;

        static {
            int[] iArr = new int[MapsInitializer.Renderer.values().length];
            f3311a = iArr;
            try {
                iArr[MapsInitializer.Renderer.LATEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3311a[MapsInitializer.Renderer.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    i(Context context, u1.d dVar) {
        this.f3309d = context;
        u1.l lVar = new u1.l(dVar, "plugins.flutter.dev/google_maps_android_initializer");
        this.f3308c = lVar;
        lVar.e(this);
    }

    private void a(String str, l.d dVar) {
        MapsInitializer.Renderer renderer;
        if (this.f3310f || f3307g != null) {
            dVar.b("Renderer already initialized", "Renderer initialization called multiple times", null);
            return;
        }
        f3307g = dVar;
        str.hashCode();
        switch (str) {
            case "latest":
                renderer = MapsInitializer.Renderer.LATEST;
                break;
            case "legacy":
                renderer = MapsInitializer.Renderer.LEGACY;
                break;
            case "default":
                b(null);
                return;
            default:
                f3307g.b("Invalid renderer type", "Renderer initialization called with invalid renderer type", null);
                f3307g = null;
                return;
        }
        b(renderer);
    }

    public void b(MapsInitializer.Renderer renderer) {
        MapsInitializer.initialize(this.f3309d, renderer, this);
    }

    @Override // u1.l.c
    public void n(u1.k kVar, l.d dVar) {
        String str = kVar.f4372a;
        str.hashCode();
        if (str.equals("initializer#preferRenderer")) {
            a((String) kVar.a("value"), dVar);
        } else {
            dVar.c();
        }
    }

    @Override // com.google.android.gms.maps.OnMapsSdkInitializedCallback
    public void onMapsSdkInitialized(MapsInitializer.Renderer renderer) {
        l.d dVar;
        String str;
        this.f3310f = true;
        if (f3307g != null) {
            int i3 = a.f3311a[renderer.ordinal()];
            if (i3 == 1) {
                dVar = f3307g;
                str = "latest";
            } else if (i3 != 2) {
                f3307g.b("Unknown renderer type", "Initialized with unknown renderer type", null);
                f3307g = null;
            } else {
                dVar = f3307g;
                str = "legacy";
            }
            dVar.a(str);
            f3307g = null;
        }
    }
}
