package a2;

import a2.e;
import com.android.billingclient.api.AccountIdentifiers;
import com.android.billingclient.api.AlternativeBillingOnlyReportingDetails;
import com.android.billingclient.api.BillingConfig;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.UserChoiceDetails;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /root/release/classes.dex */
class i0 {

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f188a;

        static {
            int[] iArr = new int[e.p.values().length];
            f188a = iArr;
            try {
                iArr[e.p.INAPP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f188a[e.p.SUBS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static e.g a(BillingResult billingResult, AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails) {
        return new e.g.a().b(c(billingResult)).c(alternativeBillingOnlyReportingDetails == null ? "" : alternativeBillingOnlyReportingDetails.getExternalTransactionToken()).a();
    }

    static e.i b(BillingResult billingResult, BillingConfig billingConfig) {
        return new e.i.a().b(c(billingResult)).c(billingConfig == null ? "" : billingConfig.getCountryCode()).a();
    }

    static e.k c(BillingResult billingResult) {
        return new e.k.a().c(Long.valueOf(billingResult.getResponseCode())).b(billingResult.getDebugMessage()).a();
    }

    static e.l d(ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails) {
        if (oneTimePurchaseOfferDetails == null) {
            return null;
        }
        return new e.l.a().c(Long.valueOf(oneTimePurchaseOfferDetails.getPriceAmountMicros())).d(oneTimePurchaseOfferDetails.getPriceCurrencyCode()).b(oneTimePurchaseOfferDetails.getFormattedPrice()).a();
    }

    static e.m e(ProductDetails.PricingPhase pricingPhase) {
        return new e.m.a().d(pricingPhase.getFormattedPrice()).f(pricingPhase.getPriceCurrencyCode()).e(Long.valueOf(pricingPhase.getPriceAmountMicros())).b(Long.valueOf(pricingPhase.getBillingCycleCount())).c(pricingPhase.getBillingPeriod()).g(t(pricingPhase.getRecurrenceMode())).a();
    }

    static List<e.m> f(ProductDetails.PricingPhases pricingPhases) {
        ArrayList arrayList = new ArrayList();
        Iterator<ProductDetails.PricingPhase> it = pricingPhases.getPricingPhaseList().iterator();
        while (it.hasNext()) {
            arrayList.add(e(it.next()));
        }
        return arrayList;
    }

    static e.n g(ProductDetails productDetails) {
        return new e.n.a().h(productDetails.getTitle()).b(productDetails.getDescription()).e(productDetails.getProductId()).f(r(productDetails.getProductType())).c(productDetails.getName()).d(d(productDetails.getOneTimePurchaseOfferDetails())).g(n(productDetails.getSubscriptionOfferDetails())).a();
    }

    static List<e.n> h(List<ProductDetails> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ProductDetails> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(g(it.next()));
        }
        return arrayList;
    }

    static e.q i(Purchase purchase) {
        e.q.a m3 = new e.q.a().f(purchase.getOrderId()).h(purchase.getPackageName()).k(Long.valueOf(purchase.getPurchaseTime())).l(purchase.getPurchaseToken()).n(purchase.getSignature()).i(purchase.getProducts()).e(Boolean.valueOf(purchase.isAutoRenewing())).g(purchase.getOriginalJson()).c(purchase.getDeveloperPayload()).d(Boolean.valueOf(purchase.isAcknowledged())).j(s(purchase.getPurchaseState())).m(Long.valueOf(purchase.getQuantity()));
        AccountIdentifiers accountIdentifiers = purchase.getAccountIdentifiers();
        if (accountIdentifiers != null) {
            m3.b(new e.f.a().b(accountIdentifiers.getObfuscatedAccountId()).c(accountIdentifiers.getObfuscatedProfileId()).a());
        }
        return m3.a();
    }

    static e.r j(PurchaseHistoryRecord purchaseHistoryRecord) {
        return new e.r.a().e(Long.valueOf(purchaseHistoryRecord.getPurchaseTime())).f(purchaseHistoryRecord.getPurchaseToken()).h(purchaseHistoryRecord.getSignature()).d(purchaseHistoryRecord.getProducts()).b(purchaseHistoryRecord.getDeveloperPayload()).c(purchaseHistoryRecord.getOriginalJson()).g(Long.valueOf(purchaseHistoryRecord.getQuantity())).a();
    }

    static List<e.r> k(List<PurchaseHistoryRecord> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PurchaseHistoryRecord> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(j(it.next()));
        }
        return arrayList;
    }

    static List<e.q> l(List<Purchase> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Purchase> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(i(it.next()));
        }
        return arrayList;
    }

    static e.x m(ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails) {
        return new e.x.a().c(subscriptionOfferDetails.getOfferId()).b(subscriptionOfferDetails.getBasePlanId()).d(subscriptionOfferDetails.getOfferTags()).e(subscriptionOfferDetails.getOfferToken()).f(f(subscriptionOfferDetails.getPricingPhases())).a();
    }

    static List<e.x> n(List<ProductDetails.SubscriptionOfferDetails> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ProductDetails.SubscriptionOfferDetails> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(m(it.next()));
        }
        return arrayList;
    }

    static e.y o(UserChoiceDetails userChoiceDetails) {
        return new e.y.a().b(userChoiceDetails.getExternalTransactionToken()).c(userChoiceDetails.getOriginalExternalTransactionId()).d(q(userChoiceDetails.getProducts())).a();
    }

    static e.z p(UserChoiceDetails.Product product) {
        return new e.z.a().b(product.getId()).c(product.getOfferToken()).d(r(product.getType())).a();
    }

    static List<e.z> q(List<UserChoiceDetails.Product> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<UserChoiceDetails.Product> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(p(it.next()));
        }
        return arrayList;
    }

    static e.p r(String str) {
        char c3;
        int hashCode = str.hashCode();
        if (hashCode != 3541555) {
            if (hashCode == 100343516 && str.equals("inapp")) {
                c3 = 0;
            }
            c3 = 65535;
        } else {
            if (str.equals("subs")) {
                c3 = 2;
            }
            c3 = 65535;
        }
        return c3 != 2 ? e.p.INAPP : e.p.SUBS;
    }

    static e.t s(int i3) {
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? e.t.UNSPECIFIED : e.t.PENDING : e.t.PURCHASED : e.t.UNSPECIFIED;
    }

    static e.w t(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? e.w.NON_RECURRING : e.w.NON_RECURRING : e.w.FINITE_RECURRING : e.w.INFINITE_RECURRING;
    }

    static QueryProductDetailsParams.Product u(e.v vVar) {
        return QueryProductDetailsParams.Product.newBuilder().setProductId(vVar.b()).setProductType(w(vVar.c())).build();
    }

    static List<QueryProductDetailsParams.Product> v(List<e.v> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<e.v> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(u(it.next()));
        }
        return arrayList;
    }

    static String w(e.p pVar) {
        int i3 = a.f188a[pVar.ordinal()];
        if (i3 == 1) {
            return "inapp";
        }
        if (i3 == 2) {
            return "subs";
        }
        throw new e.a("UNKNOWN_TYPE", "Unknown product type: " + pVar, null);
    }
}
