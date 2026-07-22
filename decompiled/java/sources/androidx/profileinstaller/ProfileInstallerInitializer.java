package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /root/release/classes.dex */
public class ProfileInstallerInitializer implements r.a<c> {

    /* JADX INFO: Access modifiers changed from: private */
    static class a {
        public static void c(final Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.profileinstaller.m
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j3) {
                    runnable.run();
                }
            });
        }
    }

    private static class b {
        public static Handler a(Looper looper) {
            Handler createAsync;
            createAsync = Handler.createAsync(looper);
            return createAsync;
        }
    }

    public static class c {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(final Context context) {
        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new Runnable() { // from class: androidx.profileinstaller.l
            @Override // java.lang.Runnable
            public final void run() {
                i.i(context);
            }
        });
    }

    @Override // r.a
    public List<Class<? extends r.a<?>>> dependencies() {
        return Collections.emptyList();
    }

    @Override // r.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public c a(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new c();
        }
        f(context.getApplicationContext());
        return new c();
    }

    void f(final Context context) {
        a.c(new Runnable() { // from class: androidx.profileinstaller.j
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstallerInitializer.this.h(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void h(final Context context) {
        (Build.VERSION.SDK_INT >= 28 ? b.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new Runnable() { // from class: androidx.profileinstaller.k
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstallerInitializer.k(context);
            }
        }, new Random().nextInt(Math.max(1000, 1)) + 5000);
    }
}
