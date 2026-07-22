package n0;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.List;
import u1.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
public final class e extends g {

    /* renamed from: f, reason: collision with root package name */
    private final k f4060f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(k call, l.d result) {
        super(result);
        kotlin.jvm.internal.k.e(call, "call");
        kotlin.jvm.internal.k.e(result, "result");
        this.f4060f = call;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(e this$0, Context context) {
        int i3;
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(context, "$context");
        Object obj = this$0.f4060f.f4373b;
        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        kotlin.jvm.internal.k.c(obj2, "null cannot be cast to non-null type kotlin.ByteArray");
        byte[] bArr = (byte[]) obj2;
        Object obj3 = list.get(1);
        kotlin.jvm.internal.k.c(obj3, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj3).intValue();
        Object obj4 = list.get(2);
        kotlin.jvm.internal.k.c(obj4, "null cannot be cast to non-null type kotlin.Int");
        int intValue2 = ((Integer) obj4).intValue();
        Object obj5 = list.get(3);
        kotlin.jvm.internal.k.c(obj5, "null cannot be cast to non-null type kotlin.Int");
        int intValue3 = ((Integer) obj5).intValue();
        Object obj6 = list.get(4);
        kotlin.jvm.internal.k.c(obj6, "null cannot be cast to non-null type kotlin.Int");
        int intValue4 = ((Integer) obj6).intValue();
        Object obj7 = list.get(5);
        kotlin.jvm.internal.k.c(obj7, "null cannot be cast to non-null type kotlin.Boolean");
        boolean booleanValue = ((Boolean) obj7).booleanValue();
        Object obj8 = list.get(6);
        kotlin.jvm.internal.k.c(obj8, "null cannot be cast to non-null type kotlin.Int");
        int intValue5 = ((Integer) obj8).intValue();
        Object obj9 = list.get(7);
        kotlin.jvm.internal.k.c(obj9, "null cannot be cast to non-null type kotlin.Boolean");
        boolean booleanValue2 = ((Boolean) obj9).booleanValue();
        Object obj10 = list.get(8);
        kotlin.jvm.internal.k.c(obj10, "null cannot be cast to non-null type kotlin.Int");
        int intValue6 = ((Integer) obj10).intValue();
        int c3 = booleanValue ? o0.a.f4072a.c(bArr) : 0;
        if (c3 == 90 || c3 == 270) {
            i3 = intValue2;
        } else {
            i3 = intValue;
            intValue = intValue2;
        }
        r0.a a4 = q0.a.f4092a.a(intValue5);
        if (a4 == null) {
            u0.a.a("No support format.");
            this$0.c(null);
            return;
        }
        int i4 = intValue4 + c3;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                a4.b(context, bArr, byteArrayOutputStream, i3, intValue, intValue3, i4, booleanValue2, intValue6);
                this$0.c(byteArrayOutputStream.toByteArray());
            } catch (Exception e3) {
                if (m0.a.f3950f.a()) {
                    e3.printStackTrace();
                }
                this$0.c(null);
            }
        } finally {
            byteArrayOutputStream.close();
        }
    }

    public final void f(final Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        g.f4063c.a().execute(new Runnable() { // from class: n0.d
            @Override // java.lang.Runnable
            public final void run() {
                e.g(e.this, context);
            }
        });
    }
}
