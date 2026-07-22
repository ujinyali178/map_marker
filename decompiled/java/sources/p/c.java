package p;

import androidx.lifecycle.a0;
import androidx.lifecycle.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.k;
import p2.l;

/* loaded from: /root/release/classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final List<f<?>> f4082a = new ArrayList();

    public final <T extends z> void a(t2.c<T> clazz, l<? super a, ? extends T> initializer) {
        k.e(clazz, "clazz");
        k.e(initializer, "initializer");
        this.f4082a.add(new f<>(o2.a.a(clazz), initializer));
    }

    public final a0.b b() {
        f[] fVarArr = (f[]) this.f4082a.toArray(new f[0]);
        return new b((f[]) Arrays.copyOf(fVarArr, fVarArr.length));
    }
}
