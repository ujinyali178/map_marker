package f2;

import android.content.Context;
import android.widget.Toast;
import android.widget.Toast$Callback;
import kotlin.jvm.internal.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
public final class d implements l.c {

    /* renamed from: c, reason: collision with root package name */
    private Context f2527c;

    /* renamed from: d, reason: collision with root package name */
    private Toast f2528d;

    public static final class a extends Toast$Callback {
        a() {
        }

        @Override // android.widget.Toast$Callback
        public void onToastHidden() {
            super.onToastHidden();
            d.this.f2528d = null;
        }
    }

    public d(Context context) {
        k.e(context, "context");
        this.f2527c = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(d this$0) {
        k.e(this$0, "this$0");
        Toast toast = this$0.f2528d;
        if (toast != null) {
            toast.show();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x010a, code lost:
    
        if (r1 != null) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0134  */
    @Override // u1.l.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n(u1.k r11, u1.l.d r12) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.d.n(u1.k, u1.l$d):void");
    }
}
