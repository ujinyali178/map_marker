package androidx.activity.result;

import b.d;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private d.f f333a = d.b.f1521a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private d.f f334a = d.b.f1521a;

        public final f a() {
            f fVar = new f();
            fVar.b(this.f334a);
            return fVar;
        }

        public final a b(d.f mediaType) {
            k.e(mediaType, "mediaType");
            this.f334a = mediaType;
            return this;
        }
    }

    public final d.f a() {
        return this.f333a;
    }

    public final void b(d.f fVar) {
        k.e(fVar, "<set-?>");
        this.f333a = fVar;
    }
}
