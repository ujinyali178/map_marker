package androidx.loader.app;

import android.os.Bundle;
import androidx.lifecycle.e0;
import androidx.lifecycle.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: /root/release/classes.dex */
public abstract class a {

    /* renamed from: androidx.loader.app.a$a, reason: collision with other inner class name */
    public interface InterfaceC0028a<D> {
        androidx.loader.content.b<D> onCreateLoader(int i3, Bundle bundle);

        void onLoadFinished(androidx.loader.content.b<D> bVar, D d3);

        void onLoaderReset(androidx.loader.content.b<D> bVar);
    }

    public static <T extends i & e0> a b(T t3) {
        return new b(t3, t3.getViewModelStore());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract <D> androidx.loader.content.b<D> c(int i3, Bundle bundle, InterfaceC0028a<D> interfaceC0028a);

    public abstract void d();
}
