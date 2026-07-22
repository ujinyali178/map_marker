package io.flutter.plugin.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.l0;
import io.flutter.plugin.platform.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import t1.k;

/* loaded from: /root/release/classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f3139a;

    /* renamed from: b, reason: collision with root package name */
    private final t1.k f3140b;

    /* renamed from: c, reason: collision with root package name */
    private final d f3141c;

    /* renamed from: d, reason: collision with root package name */
    private k.j f3142d;

    /* renamed from: e, reason: collision with root package name */
    private int f3143e;

    /* renamed from: f, reason: collision with root package name */
    final k.h f3144f;

    class a implements k.h {
        a() {
        }

        @Override // t1.k.h
        public void a() {
            g.this.t();
        }

        @Override // t1.k.h
        public CharSequence b(k.e eVar) {
            return g.this.r(eVar);
        }

        @Override // t1.k.h
        public void c(List<k.l> list) {
            g.this.A(list);
        }

        @Override // t1.k.h
        public void d(k.EnumC0104k enumC0104k) {
            g.this.z(enumC0104k);
        }

        @Override // t1.k.h
        public void e(String str) {
            g.this.v(str);
        }

        @Override // t1.k.h
        public void f(boolean z3) {
            g.this.w(z3);
        }

        @Override // t1.k.h
        public void g(String str) {
            g.this.D(str);
        }

        @Override // t1.k.h
        public void h(k.i iVar) {
            g.this.s(iVar);
        }

        @Override // t1.k.h
        public void i(k.j jVar) {
            g.this.C(jVar);
        }

        @Override // t1.k.h
        public void j() {
            g.this.y();
        }

        @Override // t1.k.h
        public void k(k.c cVar) {
            g.this.x(cVar);
        }

        @Override // t1.k.h
        public void l() {
            g.this.u();
        }

        @Override // t1.k.h
        public void m(int i3) {
            g.this.B(i3);
        }

        @Override // t1.k.h
        public void n(k.g gVar) {
            g.this.F(gVar);
        }

        @Override // t1.k.h
        public boolean o() {
            return g.this.p();
        }
    }

    class b implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f3146a;

        b(View view) {
            this.f3146a = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i3) {
            t1.k kVar;
            boolean z3;
            if ((i3 & 4) == 0) {
                kVar = g.this.f3140b;
                z3 = true;
            } else {
                kVar = g.this.f3140b;
                z3 = false;
            }
            kVar.m(z3);
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(final int i3) {
            this.f3146a.post(new Runnable() { // from class: io.flutter.plugin.platform.h
                @Override // java.lang.Runnable
                public final void run() {
                    g.b.this.b(i3);
                }
            });
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3148a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f3149b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f3150c;

        static {
            int[] iArr = new int[k.d.values().length];
            f3150c = iArr;
            try {
                iArr[k.d.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3150c[k.d.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[k.l.values().length];
            f3149b = iArr2;
            try {
                iArr2[k.l.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3149b[k.l.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[k.g.values().length];
            f3148a = iArr3;
            try {
                iArr3[k.g.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3148a[k.g.LIGHT_IMPACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3148a[k.g.MEDIUM_IMPACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3148a[k.g.HEAVY_IMPACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3148a[k.g.SELECTION_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public interface d {
        boolean a();

        void f(boolean z3);
    }

    public g(Activity activity, t1.k kVar) {
        this(activity, kVar, null);
    }

    public g(Activity activity, t1.k kVar, d dVar) {
        a aVar = new a();
        this.f3144f = aVar;
        this.f3139a = activity;
        this.f3140b = kVar;
        kVar.l(aVar);
        this.f3141c = dVar;
        this.f3143e = 1280;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(List<k.l> list) {
        int i3 = list.size() == 0 ? 5894 : 1798;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int i5 = c.f3149b[list.get(i4).ordinal()];
            if (i5 == 1) {
                i3 &= -5;
            } else if (i5 == 2) {
                i3 = i3 & (-513) & (-3);
            }
        }
        this.f3143e = i3;
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i3) {
        this.f3139a.setRequestedOrientation(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(k.j jVar) {
        Window window = this.f3139a.getWindow();
        l0 l0Var = new l0(window, window.getDecorView());
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 30) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(201326592);
        }
        if (i3 >= 23) {
            k.d dVar = jVar.f4193b;
            if (dVar != null) {
                int i4 = c.f3150c[dVar.ordinal()];
                if (i4 == 1) {
                    l0Var.b(true);
                } else if (i4 == 2) {
                    l0Var.b(false);
                }
            }
            Integer num = jVar.f4192a;
            if (num != null) {
                window.setStatusBarColor(num.intValue());
            }
        }
        Boolean bool = jVar.f4194c;
        if (bool != null && i3 >= 29) {
            window.setStatusBarContrastEnforced(bool.booleanValue());
        }
        if (i3 >= 26) {
            k.d dVar2 = jVar.f4196e;
            if (dVar2 != null) {
                int i5 = c.f3150c[dVar2.ordinal()];
                if (i5 == 1) {
                    l0Var.a(true);
                } else if (i5 == 2) {
                    l0Var.a(false);
                }
            }
            Integer num2 = jVar.f4195d;
            if (num2 != null) {
                window.setNavigationBarColor(num2.intValue());
            }
        }
        Integer num3 = jVar.f4197f;
        if (num3 != null && i3 >= 28) {
            window.setNavigationBarDividerColor(num3.intValue());
        }
        Boolean bool2 = jVar.f4198g;
        if (bool2 != null && i3 >= 29) {
            window.setNavigationBarContrastEnforced(bool2.booleanValue());
        }
        this.f3142d = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        this.f3139a.startActivity(Intent.createChooser(intent, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        ClipDescription primaryClipDescription;
        ClipboardManager clipboardManager = (ClipboardManager) this.f3139a.getSystemService("clipboard");
        if (clipboardManager.hasPrimaryClip() && (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) != null) {
            return primaryClipDescription.hasMimeType("text/*");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence r(k.e eVar) {
        ClipboardManager clipboardManager = (ClipboardManager) this.f3139a.getSystemService("clipboard");
        CharSequence charSequence = null;
        if (!clipboardManager.hasPrimaryClip()) {
            return null;
        }
        try {
            try {
                ClipData primaryClip = clipboardManager.getPrimaryClip();
                if (primaryClip == null) {
                    return null;
                }
                if (eVar != null && eVar != k.e.PLAIN_TEXT) {
                    return null;
                }
                ClipData.Item itemAt = primaryClip.getItemAt(0);
                CharSequence text = itemAt.getText();
                if (text == null) {
                    try {
                        Uri uri = itemAt.getUri();
                        if (uri == null) {
                            g1.b.g("PlatformPlugin", "Clipboard item contained no textual content nor a URI to retrieve it from.");
                            return null;
                        }
                        String scheme = uri.getScheme();
                        if (!scheme.equals("content")) {
                            g1.b.g("PlatformPlugin", "Clipboard item contains a Uri with scheme '" + scheme + "'that is unhandled.");
                            return null;
                        }
                        AssetFileDescriptor openTypedAssetFileDescriptor = this.f3139a.getContentResolver().openTypedAssetFileDescriptor(uri, "text/*", null);
                        text = itemAt.coerceToText(this.f3139a);
                        if (openTypedAssetFileDescriptor != null) {
                            openTypedAssetFileDescriptor.close();
                        }
                    } catch (IOException e3) {
                        e = e3;
                        charSequence = text;
                        g1.b.h("PlatformPlugin", "Failed to close AssetFileDescriptor while trying to read text from URI.", e);
                        return charSequence;
                    }
                }
                return text;
            } catch (IOException e4) {
                e = e4;
            }
        } catch (FileNotFoundException unused) {
            g1.b.g("PlatformPlugin", "Clipboard text was unable to be received from content URI.");
            return null;
        } catch (SecurityException e5) {
            g1.b.h("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", e5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(k.i iVar) {
        if (iVar == k.i.CLICK) {
            this.f3139a.getWindow().getDecorView().playSoundEffect(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void t() {
        d dVar = this.f3141c;
        if (dVar == null || !dVar.a()) {
            Activity activity = this.f3139a;
            if (activity instanceof androidx.activity.n) {
                ((androidx.activity.n) activity).getOnBackPressedDispatcher().e();
            } else {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str) {
        ((ClipboardManager) this.f3139a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z3) {
        d dVar = this.f3141c;
        if (dVar != null) {
            dVar.f(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(k.c cVar) {
        if (Build.VERSION.SDK_INT < 28) {
            this.f3139a.setTaskDescription(new ActivityManager.TaskDescription(cVar.f4167b, (Bitmap) null, cVar.f4166a));
        } else {
            this.f3139a.setTaskDescription(new ActivityManager.TaskDescription(cVar.f4167b, 0, cVar.f4166a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        View decorView = this.f3139a.getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new b(decorView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(k.EnumC0104k enumC0104k) {
        int i3;
        if (enumC0104k == k.EnumC0104k.LEAN_BACK) {
            i3 = 1798;
        } else if (enumC0104k == k.EnumC0104k.IMMERSIVE) {
            i3 = 3846;
        } else if (enumC0104k == k.EnumC0104k.IMMERSIVE_STICKY) {
            i3 = 5894;
        } else if (enumC0104k != k.EnumC0104k.EDGE_TO_EDGE || Build.VERSION.SDK_INT < 29) {
            return;
        } else {
            i3 = 1792;
        }
        this.f3143e = i3;
        E();
    }

    public void E() {
        this.f3139a.getWindow().getDecorView().setSystemUiVisibility(this.f3143e);
        k.j jVar = this.f3142d;
        if (jVar != null) {
            C(jVar);
        }
    }

    void F(k.g gVar) {
        int i3;
        View decorView = this.f3139a.getWindow().getDecorView();
        int i4 = c.f3148a[gVar.ordinal()];
        int i5 = 1;
        if (i4 != 1) {
            if (i4 != 2) {
                i5 = 3;
                if (i4 != 3) {
                    i5 = 4;
                    if (i4 != 4) {
                        if (i4 != 5) {
                            return;
                        }
                    } else if (Build.VERSION.SDK_INT < 23) {
                        return;
                    } else {
                        i3 = 6;
                    }
                }
            }
            decorView.performHapticFeedback(i5);
            return;
        }
        i3 = 0;
        decorView.performHapticFeedback(i3);
    }

    public void q() {
        this.f3140b.l(null);
    }
}
