package a2;

import a2.e;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.AlternativeBillingOnlyAvailabilityListener;
import com.android.billingclient.api.AlternativeBillingOnlyInformationDialogListener;
import com.android.billingclient.api.AlternativeBillingOnlyReportingDetails;
import com.android.billingclient.api.AlternativeBillingOnlyReportingDetailsListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingConfig;
import com.android.billingclient.api.BillingConfigResponseListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.GetBillingConfigParams;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.PurchaseHistoryResponseListener;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryPurchaseHistoryParams;
import com.android.billingclient.api.QueryPurchasesParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: /root/release/classes.dex */
class g0 implements Application.ActivityLifecycleCallbacks, e.b {

    /* renamed from: c, reason: collision with root package name */
    private BillingClient f173c;

    /* renamed from: d, reason: collision with root package name */
    private final a2.a f174d;

    /* renamed from: f, reason: collision with root package name */
    private Activity f175f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f176g;

    /* renamed from: h, reason: collision with root package name */
    final e.d f177h;

    /* renamed from: i, reason: collision with root package name */
    private final HashMap<String, ProductDetails> f178i = new HashMap<>();

    class a implements BillingClientStateListener {

        /* renamed from: a, reason: collision with root package name */
        private boolean f179a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e.a0 f180b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Long f181c;

        /* renamed from: a2.g0$a$a, reason: collision with other inner class name */
        class C0001a implements e.b0 {
            C0001a() {
            }

            @Override // a2.e.b0
            public void a() {
            }

            @Override // a2.e.b0
            public void b(Throwable th) {
                g1.b.b("IN_APP_PURCHASE", "onBillingServiceDisconnected handler error: " + th);
            }
        }

        a(e.a0 a0Var, Long l3) {
            this.f180b = a0Var;
            this.f181c = l3;
        }

        @Override // com.android.billingclient.api.BillingClientStateListener
        public void onBillingServiceDisconnected() {
            g0.this.f177h.h(this.f181c, new C0001a());
        }

        @Override // com.android.billingclient.api.BillingClientStateListener
        public void onBillingSetupFinished(BillingResult billingResult) {
            if (this.f179a) {
                Log.d("InAppPurchasePlugin", "Tried to call onBillingSetupFinished multiple times.");
            } else {
                this.f179a = true;
                this.f180b.a(i0.c(billingResult));
            }
        }
    }

    g0(Activity activity, Context context, e.d dVar, a2.a aVar) {
        this.f174d = aVar;
        this.f176g = context;
        this.f175f = activity;
        this.f177h = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A(e.a0 a0Var, BillingResult billingResult, AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails) {
        a0Var.a(i0.a(billingResult, alternativeBillingOnlyReportingDetails));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(e.a0 a0Var, BillingResult billingResult, BillingConfig billingConfig) {
        a0Var.a(i0.b(billingResult, billingConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(e.a0 a0Var, BillingResult billingResult) {
        a0Var.a(i0.c(billingResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(e.a0 a0Var, BillingResult billingResult, List list) {
        K(list);
        a0Var.a(new e.o.a().b(i0.c(billingResult)).c(i0.h(list)).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(e.a0 a0Var, BillingResult billingResult, List list) {
        a0Var.a(new e.s.a().b(i0.c(billingResult)).c(i0.k(list)).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F(e.a0 a0Var, BillingResult billingResult, List list) {
        a0Var.a(new e.u.a().b(i0.c(billingResult)).c(i0.l(list)).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G(e.a0 a0Var, BillingResult billingResult) {
        a0Var.a(i0.c(billingResult));
    }

    private void J(BillingFlowParams.SubscriptionUpdateParams.Builder builder, int i3) {
        builder.setReplaceProrationMode(i3);
    }

    private void w() {
        BillingClient billingClient = this.f173c;
        if (billingClient != null) {
            billingClient.endConnection();
            this.f173c = null;
        }
    }

    private e.a x() {
        return new e.a("UNAVAILABLE", "BillingClient is unset. Try reconnecting.", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(e.a0 a0Var, BillingResult billingResult) {
        a0Var.a(i0.c(billingResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(e.a0 a0Var, BillingResult billingResult, String str) {
        a0Var.a(i0.c(billingResult));
    }

    void H() {
        w();
    }

    void I(Activity activity) {
        this.f175f = activity;
    }

    protected void K(List<ProductDetails> list) {
        if (list == null) {
            return;
        }
        for (ProductDetails productDetails : list) {
            this.f178i.put(productDetails.getProductId(), productDetails);
        }
    }

    @Override // a2.e.b
    public void a(e.p pVar, final e.a0<e.s> a0Var) {
        BillingClient billingClient = this.f173c;
        if (billingClient == null) {
            a0Var.b(x());
            return;
        }
        try {
            billingClient.queryPurchaseHistoryAsync(QueryPurchaseHistoryParams.newBuilder().setProductType(i0.w(pVar)).build(), new PurchaseHistoryResponseListener() { // from class: a2.f0
                @Override // com.android.billingclient.api.PurchaseHistoryResponseListener
                public final void onPurchaseHistoryResponse(BillingResult billingResult, List list) {
                    g0.E(e.a0.this, billingResult, list);
                }
            });
        } catch (RuntimeException e3) {
            a0Var.b(new e.a("error", e3.getMessage(), Log.getStackTraceString(e3)));
        }
    }

    @Override // a2.e.b
    public void b(List<e.v> list, final e.a0<e.o> a0Var) {
        if (this.f173c == null) {
            a0Var.b(x());
            return;
        }
        try {
            this.f173c.queryProductDetailsAsync(QueryProductDetailsParams.newBuilder().setProductList(i0.v(list)).build(), new ProductDetailsResponseListener() { // from class: a2.y
                @Override // com.android.billingclient.api.ProductDetailsResponseListener
                public final void onProductDetailsResponse(BillingResult billingResult, List list2) {
                    g0.this.D(a0Var, billingResult, list2);
                }
            });
        } catch (RuntimeException e3) {
            a0Var.b(new e.a("error", e3.getMessage(), Log.getStackTraceString(e3)));
        }
    }

    @Override // a2.e.b
    public Boolean c(String str) {
        BillingClient billingClient = this.f173c;
        if (billingClient != null) {
            return Boolean.valueOf(billingClient.isFeatureSupported(str).getResponseCode() == 0);
        }
        throw x();
    }

    @Override // a2.e.b
    public void d(Long l3, e.h hVar, e.a0<e.k> a0Var) {
        if (this.f173c == null) {
            this.f173c = this.f174d.a(this.f176g, this.f177h, hVar);
        }
        try {
            this.f173c.startConnection(new a(a0Var, l3));
        } catch (RuntimeException e3) {
            a0Var.b(new e.a("error", e3.getMessage(), Log.getStackTraceString(e3)));
        }
    }

    @Override // a2.e.b
    public void e(e.p pVar, final e.a0<e.u> a0Var) {
        if (this.f173c == null) {
            a0Var.b(x());
            return;
        }
        try {
            QueryPurchasesParams.Builder newBuilder = QueryPurchasesParams.newBuilder();
            newBuilder.setProductType(i0.w(pVar));
            this.f173c.queryPurchasesAsync(newBuilder.build(), new PurchasesResponseListener() { // from class: a2.x
                @Override // com.android.billingclient.api.PurchasesResponseListener
                public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                    g0.F(e.a0.this, billingResult, list);
                }
            });
        } catch (RuntimeException e3) {
            a0Var.b(new e.a("error", e3.getMessage(), Log.getStackTraceString(e3)));
        }
    }

    @Override // a2.e.b
    public void f(final e.a0<e.k> a0Var) {
        BillingClient billingClient = this.f173c;
        if (billingClient == null) {
            a0Var.b(x());
            return;
        }
        try {
            billingClient.isAlternativeBillingOnlyAvailableAsync(new AlternativeBillingOnlyAvailabilityListener() { // from class: a2.b0
                @Override // com.android.billingclient.api.AlternativeBillingOnlyAvailabilityListener
                public final void onAlternativeBillingOnlyAvailabilityResponse(BillingResult billingResult) {
                    g0.C(e.a0.this, billingResult);
                }
            });
        } catch (RuntimeException e3) {
            a0Var.b(new e.a("error", e3.getMessage(), Log.getStackTraceString(e3)));
        }
    }

    @Override // a2.e.b
    public void g(String str, final e.a0<e.k> a0Var) {
        if (this.f173c == null) {
            a0Var.b(x());
            return;
        }
        try {
            ConsumeResponseListener consumeResponseListener = new ConsumeResponseListener() { // from class: a2.c0
                @Override // com.android.billingclient.api.ConsumeResponseListener
                public final void onConsumeResponse(BillingResult billingResult, String str2) {
                    g0.z(e.a0.this, billingResult, str2);
                }
            };
            this.f173c.consumeAsync(ConsumeParams.newBuilder().setPurchaseToken(str).build(), consumeResponseListener);
        } catch (RuntimeException e3) {
            a0Var.b(new e.a("error", e3.getMessage(), Log.getStackTraceString(e3)));
        }
    }

    @Override // a2.e.b
    public void h(final e.a0<e.i> a0Var) {
        BillingClient billingClient = this.f173c;
        if (billingClient == null) {
            a0Var.b(x());
            return;
        }
        try {
            billingClient.getBillingConfigAsync(GetBillingConfigParams.newBuilder().build(), new BillingConfigResponseListener() { // from class: a2.e0
                @Override // com.android.billingclient.api.BillingConfigResponseListener
                public final void onBillingConfigResponse(BillingResult billingResult, BillingConfig billingConfig) {
                    g0.B(e.a0.this, billingResult, billingConfig);
                }
            });
        } catch (RuntimeException e3) {
            a0Var.b(new e.a("error", e3.getMessage(), Log.getStackTraceString(e3)));
        }
    }

    @Override // a2.e.b
    public e.k i(e.j jVar) {
        if (this.f173c == null) {
            throw x();
        }
        ProductDetails productDetails = this.f178i.get(jVar.f());
        if (productDetails == null) {
            throw new e.a("NOT_FOUND", "Details for product " + jVar.f() + " are not available. It might because products were not fetched prior to the call. Please fetch the products first. An example of how to fetch the products could be found here: https://github.com/flutter/packages/blob/main/packages/in_app_purchase/in_app_purchase/README.md#loading-products-for-sale", null);
        }
        List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails = productDetails.getSubscriptionOfferDetails();
        if (subscriptionOfferDetails != null) {
            boolean z3 = false;
            Iterator<ProductDetails.SubscriptionOfferDetails> it = subscriptionOfferDetails.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ProductDetails.SubscriptionOfferDetails next = it.next();
                if (jVar.d() != null && jVar.d().equals(next.getOfferToken())) {
                    z3 = true;
                    break;
                }
            }
            if (!z3) {
                throw new e.a("INVALID_OFFER_TOKEN", "Offer token " + jVar.d() + " for product " + jVar.f() + " is not valid. Make sure to only pass offer tokens that belong to the product. To obtain offer tokens for a product, fetch the products. An example of how to fetch the products could be found here: https://github.com/flutter/packages/blob/main/packages/in_app_purchase/in_app_purchase/README.md#loading-products-for-sale", null);
            }
        }
        if (jVar.e() == null && jVar.g().longValue() != 0) {
            throw new e.a("IN_APP_PURCHASE_REQUIRE_OLD_PRODUCT", "launchBillingFlow failed because oldProduct is null. You must provide a valid oldProduct in order to use a proration mode.", null);
        }
        if (jVar.e() != null && !this.f178i.containsKey(jVar.e())) {
            throw new e.a("IN_APP_PURCHASE_INVALID_OLD_PRODUCT", "Details for product " + jVar.e() + " are not available. It might because products were not fetched prior to the call. Please fetch the products first. An example of how to fetch the products could be found here: https://github.com/flutter/packages/blob/main/packages/in_app_purchase/in_app_purchase/README.md#loading-products-for-sale", null);
        }
        if (this.f175f == null) {
            throw new e.a("ACTIVITY_UNAVAILABLE", "Details for product " + jVar.f() + " are not available. This method must be run with the app in foreground.", null);
        }
        BillingFlowParams.ProductDetailsParams.Builder newBuilder = BillingFlowParams.ProductDetailsParams.newBuilder();
        newBuilder.setProductDetails(productDetails);
        if (jVar.d() != null) {
            newBuilder.setOfferToken(jVar.d());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(newBuilder.build());
        BillingFlowParams.Builder productDetailsParamsList = BillingFlowParams.newBuilder().setProductDetailsParamsList(arrayList);
        if (jVar.b() != null && !jVar.b().isEmpty()) {
            productDetailsParamsList.setObfuscatedAccountId(jVar.b());
        }
        if (jVar.c() != null && !jVar.c().isEmpty()) {
            productDetailsParamsList.setObfuscatedProfileId(jVar.c());
        }
        BillingFlowParams.SubscriptionUpdateParams.Builder newBuilder2 = BillingFlowParams.SubscriptionUpdateParams.newBuilder();
        if (jVar.e() != null && !jVar.e().isEmpty() && jVar.h() != null) {
            newBuilder2.setOldPurchaseToken(jVar.h());
            J(newBuilder2, jVar.g().intValue());
            productDetailsParamsList.setSubscriptionUpdateParams(newBuilder2.build());
        }
        return i0.c(this.f173c.launchBillingFlow(this.f175f, productDetailsParamsList.build()));
    }

    @Override // a2.e.b
    public Boolean isReady() {
        BillingClient billingClient = this.f173c;
        if (billingClient != null) {
            return Boolean.valueOf(billingClient.isReady());
        }
        throw x();
    }

    @Override // a2.e.b
    public void j(final e.a0<e.g> a0Var) {
        BillingClient billingClient = this.f173c;
        if (billingClient == null) {
            a0Var.b(x());
            return;
        }
        try {
            billingClient.createAlternativeBillingOnlyReportingDetailsAsync(new AlternativeBillingOnlyReportingDetailsListener() { // from class: a2.a0
                @Override // com.android.billingclient.api.AlternativeBillingOnlyReportingDetailsListener
                public final void onAlternativeBillingOnlyTokenResponse(BillingResult billingResult, AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails) {
                    g0.A(e.a0.this, billingResult, alternativeBillingOnlyReportingDetails);
                }
            });
        } catch (RuntimeException e3) {
            a0Var.b(new e.a("error", e3.getMessage(), Log.getStackTraceString(e3)));
        }
    }

    @Override // a2.e.b
    public void k(String str, final e.a0<e.k> a0Var) {
        if (this.f173c == null) {
            a0Var.b(x());
            return;
        }
        try {
            this.f173c.acknowledgePurchase(AcknowledgePurchaseParams.newBuilder().setPurchaseToken(str).build(), new AcknowledgePurchaseResponseListener() { // from class: a2.d0
                @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
                public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                    g0.y(e.a0.this, billingResult);
                }
            });
        } catch (RuntimeException e3) {
            a0Var.b(new e.a("error", e3.getMessage(), Log.getStackTraceString(e3)));
        }
    }

    @Override // a2.e.b
    public void l(final e.a0<e.k> a0Var) {
        e.a aVar;
        BillingClient billingClient = this.f173c;
        if (billingClient == null) {
            aVar = x();
        } else {
            Activity activity = this.f175f;
            if (activity != null) {
                try {
                    billingClient.showAlternativeBillingOnlyInformationDialog(activity, new AlternativeBillingOnlyInformationDialogListener() { // from class: a2.z
                        @Override // com.android.billingclient.api.AlternativeBillingOnlyInformationDialogListener
                        public final void onAlternativeBillingOnlyInformationDialogResponse(BillingResult billingResult) {
                            g0.G(e.a0.this, billingResult);
                        }
                    });
                    return;
                } catch (RuntimeException e3) {
                    a0Var.b(new e.a("error", e3.getMessage(), Log.getStackTraceString(e3)));
                    return;
                }
            }
            aVar = new e.a("ACTIVITY_UNAVAILABLE", "Not attempting to show dialog", null);
        }
        a0Var.b(aVar);
    }

    @Override // a2.e.b
    public void m() {
        w();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Context context;
        if (this.f175f != activity || (context = this.f176g) == null) {
            return;
        }
        ((Application) context).unregisterActivityLifecycleCallbacks(this);
        w();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
