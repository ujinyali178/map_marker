package a2;

import a2.e;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import java.util.List;

/* loaded from: /root/release/classes.dex */
class h0 implements PurchasesUpdatedListener {

    /* renamed from: a, reason: collision with root package name */
    private final e.d f185a;

    class a implements e.b0 {
        a() {
        }

        @Override // a2.e.b0
        public void a() {
        }

        @Override // a2.e.b0
        public void b(Throwable th) {
            g1.b.b("IN_APP_PURCHASE", "onPurchaseUpdated handler error: " + th);
        }
    }

    h0(e.d dVar) {
        this.f185a = dVar;
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
        this.f185a.i(new e.u.a().b(i0.c(billingResult)).c(i0.l(list)).a(), new a());
    }
}
