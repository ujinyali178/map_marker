package y0;

import android.content.Context;

/* loaded from: /root/release/classes.dex */
enum d {
    RSA_ECB_PKCS1Padding(new e() { // from class: y0.b
        @Override // y0.e
        public final a a(Context context) {
            return new f(context);
        }
    }, 1),
    RSA_ECB_OAEPwithSHA_256andMGF1Padding(new e() { // from class: y0.c
        @Override // y0.e
        public final a a(Context context) {
            return new g(context);
        }
    }, 23);


    /* renamed from: c, reason: collision with root package name */
    final e f4658c;

    /* renamed from: d, reason: collision with root package name */
    final int f4659d;

    d(e eVar, int i3) {
        this.f4658c = eVar;
        this.f4659d = i3;
    }
}
