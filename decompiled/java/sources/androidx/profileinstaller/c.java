package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.i;
import com.google.android.gms.maps.R;
import com.google.android.gms.maps.model.PinConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* loaded from: /root/release/classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final AssetManager f1379a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f1380b;

    /* renamed from: c, reason: collision with root package name */
    private final i.c f1381c;

    /* renamed from: e, reason: collision with root package name */
    private final File f1383e;

    /* renamed from: f, reason: collision with root package name */
    private final String f1384f;

    /* renamed from: g, reason: collision with root package name */
    private final String f1385g;

    /* renamed from: h, reason: collision with root package name */
    private final String f1386h;

    /* renamed from: j, reason: collision with root package name */
    private d[] f1388j;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f1389k;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1387i = false;

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f1382d = d();

    public c(AssetManager assetManager, Executor executor, i.c cVar, String str, String str2, String str3, File file) {
        this.f1379a = assetManager;
        this.f1380b = executor;
        this.f1381c = cVar;
        this.f1384f = str;
        this.f1385g = str2;
        this.f1386h = str3;
        this.f1383e = file;
    }

    private c b(d[] dVarArr, byte[] bArr) {
        i.c cVar;
        int i3;
        InputStream h3;
        try {
            h3 = h(this.f1379a, this.f1386h);
        } catch (FileNotFoundException e3) {
            e = e3;
            cVar = this.f1381c;
            i3 = 9;
            cVar.b(i3, e);
            return null;
        } catch (IOException e4) {
            e = e4;
            cVar = this.f1381c;
            i3 = 7;
            cVar.b(i3, e);
            return null;
        } catch (IllegalStateException e5) {
            e = e5;
            this.f1388j = null;
            cVar = this.f1381c;
            i3 = 8;
            cVar.b(i3, e);
            return null;
        }
        if (h3 == null) {
            if (h3 != null) {
                h3.close();
            }
            return null;
        }
        try {
            this.f1388j = n.q(h3, n.o(h3, n.f1417b), bArr, dVarArr);
            h3.close();
            return this;
        } finally {
        }
    }

    private void c() {
        if (!this.f1387i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    private static byte[] d() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 24 || i3 > 33) {
            return null;
        }
        switch (i3) {
            case 24:
            case R.styleable.MapAttrs_zOrderOnTop /* 25 */:
                return p.f1432e;
            case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                return p.f1431d;
            case 27:
                return p.f1430c;
            case 28:
            case 29:
            case 30:
                return p.f1429b;
            case 31:
            case 32:
            case 33:
                return p.f1428a;
            default:
                return null;
        }
    }

    private InputStream f(AssetManager assetManager) {
        i.c cVar;
        int i3;
        try {
            return h(assetManager, this.f1385g);
        } catch (FileNotFoundException e3) {
            e = e3;
            cVar = this.f1381c;
            i3 = 6;
            cVar.b(i3, e);
            return null;
        } catch (IOException e4) {
            e = e4;
            cVar = this.f1381c;
            i3 = 7;
            cVar.b(i3, e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i3, Object obj) {
        this.f1381c.b(i3, obj);
    }

    private InputStream h(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e3) {
            String message = e3.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            this.f1381c.a(5, null);
            return null;
        }
    }

    private d[] j(InputStream inputStream) {
        try {
        } catch (IOException e3) {
            this.f1381c.b(7, e3);
        }
        try {
            try {
                d[] w3 = n.w(inputStream, n.o(inputStream, n.f1416a), this.f1384f);
                try {
                    inputStream.close();
                    return w3;
                } catch (IOException e4) {
                    this.f1381c.b(7, e4);
                    return w3;
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    this.f1381c.b(7, e5);
                }
                throw th;
            }
        } catch (IOException e6) {
            this.f1381c.b(7, e6);
            inputStream.close();
            return null;
        } catch (IllegalStateException e7) {
            this.f1381c.b(8, e7);
            inputStream.close();
            return null;
        }
    }

    private static boolean k() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 24 || i3 > 33) {
            return false;
        }
        if (i3 != 24 && i3 != 25) {
            switch (i3) {
                case 31:
                case 32:
                case 33:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private void l(final int i3, final Object obj) {
        this.f1380b.execute(new Runnable() { // from class: androidx.profileinstaller.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.g(i3, obj);
            }
        });
    }

    public boolean e() {
        int i3;
        Integer num;
        if (this.f1382d == null) {
            i3 = 3;
            num = Integer.valueOf(Build.VERSION.SDK_INT);
        } else {
            if (this.f1383e.canWrite()) {
                this.f1387i = true;
                return true;
            }
            i3 = 4;
            num = null;
        }
        l(i3, num);
        return false;
    }

    public c i() {
        c b4;
        c();
        if (this.f1382d == null) {
            return this;
        }
        InputStream f3 = f(this.f1379a);
        if (f3 != null) {
            this.f1388j = j(f3);
        }
        d[] dVarArr = this.f1388j;
        return (dVarArr == null || !k() || (b4 = b(dVarArr, this.f1382d)) == null) ? this : b4;
    }

    public c m() {
        i.c cVar;
        int i3;
        ByteArrayOutputStream byteArrayOutputStream;
        d[] dVarArr = this.f1388j;
        byte[] bArr = this.f1382d;
        if (dVarArr != null && bArr != null) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    n.E(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                cVar = this.f1381c;
                i3 = 7;
                cVar.b(i3, e);
                this.f1388j = null;
                return this;
            } catch (IllegalStateException e4) {
                e = e4;
                cVar = this.f1381c;
                i3 = 8;
                cVar.b(i3, e);
                this.f1388j = null;
                return this;
            }
            if (!n.B(byteArrayOutputStream, bArr, dVarArr)) {
                this.f1381c.b(5, null);
                this.f1388j = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.f1389k = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.f1388j = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean n() {
        byte[] bArr = this.f1389k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f1383e);
                    try {
                        e.l(byteArrayInputStream, fileOutputStream);
                        l(1, null);
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        return true;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
                this.f1389k = null;
                this.f1388j = null;
            }
        } catch (FileNotFoundException e3) {
            l(6, e3);
            return false;
        } catch (IOException e4) {
            l(7, e4);
            return false;
        }
    }
}
