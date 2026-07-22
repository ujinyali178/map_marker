package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

/* loaded from: /root/release/classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private static final androidx.concurrent.futures.c<c> f1418a = androidx.concurrent.futures.c.q();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f1419b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static c f1420c = null;

    private static class a {
        static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        final int f1421a;

        /* renamed from: b, reason: collision with root package name */
        final int f1422b;

        /* renamed from: c, reason: collision with root package name */
        final long f1423c;

        /* renamed from: d, reason: collision with root package name */
        final long f1424d;

        b(int i3, int i4, long j3, long j4) {
            this.f1421a = i3;
            this.f1422b = i4;
            this.f1423c = j3;
            this.f1424d = j4;
        }

        static b a(File file) {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        void b(File file) {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f1421a);
                dataOutputStream.writeInt(this.f1422b);
                dataOutputStream.writeLong(this.f1423c);
                dataOutputStream.writeLong(this.f1424d);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f1422b == bVar.f1422b && this.f1423c == bVar.f1423c && this.f1421a == bVar.f1421a && this.f1424d == bVar.f1424d;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f1422b), Long.valueOf(this.f1423c), Integer.valueOf(this.f1421a), Long.valueOf(this.f1424d));
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final int f1425a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f1426b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f1427c;

        c(int i3, boolean z3, boolean z4) {
            this.f1425a = i3;
            this.f1427c = z4;
            this.f1426b = z3;
        }
    }

    private static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return (Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context) : packageManager.getPackageInfo(context.getPackageName(), 0)).lastUpdateTime;
    }

    private static c b(int i3, boolean z3, boolean z4) {
        c cVar = new c(i3, z3, z4);
        f1420c = cVar;
        f1418a.o(cVar);
        return f1420c;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:14|(1:77)(1:18)|19|(1:76)(1:23)|24|25|26|(2:62|63)|28|(8:35|(1:39)|(1:46)|47|(2:54|55)|51|52|53)|(1:61)|(1:39)|(3:41|44|46)|47|(1:49)|54|55|51|52|53) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00cc, code lost:
    
        r3 = 196608;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009d, code lost:
    
        r3 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static androidx.profileinstaller.o.c c(android.content.Context r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.o.c(android.content.Context, boolean):androidx.profileinstaller.o$c");
    }
}
