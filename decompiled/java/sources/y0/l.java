package y0;

import android.content.Context;

/* loaded from: /root/release/classes.dex */
enum l {
    AES_CBC_PKCS7Padding(new n() { // from class: y0.j
        @Override // y0.n
        public final i a(Context context, a aVar) {
            return new h(context, aVar);
        }
    }, 1),
    AES_GCM_NoPadding(new n() { // from class: y0.k
        @Override // y0.n
        public final i a(Context context, a aVar) {
            return new o(context, aVar);
        }
    }, 23);


    /* renamed from: c, reason: collision with root package name */
    final n f4668c;

    /* renamed from: d, reason: collision with root package name */
    final int f4669d;

    l(n nVar, int i3) {
        this.f4668c = nVar;
        this.f4669d = i3;
    }
}
