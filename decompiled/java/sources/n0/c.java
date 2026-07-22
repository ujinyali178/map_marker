package n0;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;
import n2.i;
import u1.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
public final class c extends g {

    /* renamed from: f, reason: collision with root package name */
    private final k f4057f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(k call, l.d result) {
        super(result);
        kotlin.jvm.internal.k.e(call, "call");
        kotlin.jvm.internal.k.e(result, "result");
        this.f4057f = call;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(c this$0, Context context) {
        int i3;
        byte[] a4;
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(context, "$context");
        Object obj = this$0.f4057f.f4373b;
        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        int i4 = 0;
        Object obj2 = list.get(0);
        kotlin.jvm.internal.k.c(obj2, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj2;
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
        Object obj11 = list.get(9);
        kotlin.jvm.internal.k.c(obj11, "null cannot be cast to non-null type kotlin.Int");
        int intValue7 = ((Integer) obj11).intValue();
        r0.a a5 = q0.a.f4092a.a(intValue5);
        if (a5 == null) {
            u0.a.a("No support format.");
            this$0.c(null);
            return;
        }
        if (booleanValue) {
            a4 = i.a(new File(str));
            i4 = o0.a.f4072a.c(a4);
        }
        if (i4 == 90 || i4 == 270) {
            i3 = intValue;
        } else {
            i3 = intValue2;
            intValue2 = intValue;
        }
        int i5 = intValue4 + i4;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                a5.c(context, str, byteArrayOutputStream, intValue2, i3, intValue3, i5, booleanValue2, intValue6, intValue7);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x011b: MOVE (r14 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]), block:B:31:0x011b */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(n0.c r17, android.content.Context r18) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.c.j(n0.c, android.content.Context):void");
    }

    public final void g(final Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        g.f4063c.a().execute(new Runnable() { // from class: n0.a
            @Override // java.lang.Runnable
            public final void run() {
                c.h(c.this, context);
            }
        });
    }

    public final void i(final Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        g.f4063c.a().execute(new Runnable() { // from class: n0.b
            @Override // java.lang.Runnable
            public final void run() {
                c.j(c.this, context);
            }
        });
    }
}
