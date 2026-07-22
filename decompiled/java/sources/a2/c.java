package a2;

import a2.e;
import android.content.Context;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.UserChoiceBillingListener;
import com.android.billingclient.api.UserChoiceDetails;

/* loaded from: /root/release/classes.dex */
final class c implements a2.a {

    class a implements e.b0 {
        a() {
        }

        @Override // a2.e.b0
        public void a() {
        }

        @Override // a2.e.b0
        public void b(Throwable th) {
            g1.b.b("IN_APP_PURCHASE", "userSelectedalternativeBilling handler error: " + th);
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10a;

        static {
            int[] iArr = new int[e.h.values().length];
            f10a = iArr;
            try {
                iArr[e.h.ALTERNATIVE_BILLING_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10a[e.h.USER_CHOICE_BILLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10a[e.h.PLAY_BILLING_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(e.d dVar, UserChoiceDetails userChoiceDetails) {
        dVar.j(i0.o(userChoiceDetails), new a());
    }

    @Override // a2.a
    public BillingClient a(Context context, e.d dVar, e.h hVar) {
        BillingClient.Builder enablePendingPurchases = BillingClient.newBuilder(context).enablePendingPurchases();
        int i3 = b.f10a[hVar.ordinal()];
        if (i3 == 1) {
            enablePendingPurchases.enableAlternativeBillingOnly();
        } else if (i3 == 2) {
            enablePendingPurchases.enableUserChoiceBilling(c(dVar));
        } else if (i3 != 3) {
            g1.b.b("BillingClientFactoryImpl", "Unknown BillingChoiceMode " + hVar + ", Defaulting to PLAY_BILLING_ONLY");
        }
        return enablePendingPurchases.setListener(new h0(dVar)).build();
    }

    UserChoiceBillingListener c(final e.d dVar) {
        return new UserChoiceBillingListener() { // from class: a2.b
            @Override // com.android.billingclient.api.UserChoiceBillingListener
            public final void userSelectedAlternativeBilling(UserChoiceDetails userChoiceDetails) {
                c.this.d(dVar, userChoiceDetails);
            }
        };
    }
}
