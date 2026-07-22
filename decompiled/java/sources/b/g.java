package b;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class g extends b.a<androidx.activity.result.e, androidx.activity.result.a> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1527a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    @Override // b.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, androidx.activity.result.e input) {
        k.e(context, "context");
        k.e(input, "input");
        Intent putExtra = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", input);
        k.d(putExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
        return putExtra;
    }

    @Override // b.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public androidx.activity.result.a c(int i3, Intent intent) {
        return new androidx.activity.result.a(i3, intent);
    }
}
