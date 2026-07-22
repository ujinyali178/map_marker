package androidx.lifecycle;

import androidx.lifecycle.a0;

/* loaded from: /root/release/classes.dex */
public final /* synthetic */ class b0 {
    public static z a(a0.b bVar, Class modelClass) {
        kotlin.jvm.internal.k.e(modelClass, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    public static z b(a0.b bVar, Class modelClass, p.a extras) {
        kotlin.jvm.internal.k.e(modelClass, "modelClass");
        kotlin.jvm.internal.k.e(extras, "extras");
        return bVar.a(modelClass);
    }
}
