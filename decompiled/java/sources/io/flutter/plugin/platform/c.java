package io.flutter.plugin.platform;

import android.content.Context;
import android.view.MotionEvent;
import io.flutter.embedding.android.n;

/* loaded from: /root/release/classes.dex */
public class c extends io.flutter.embedding.android.n {

    /* renamed from: j, reason: collision with root package name */
    private a f3135j;

    public c(Context context, int i3, int i4, a aVar) {
        super(context, i3, i4, n.b.overlay);
        this.f3135j = aVar;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        a aVar = this.f3135j;
        if (aVar == null || !aVar.a(motionEvent, true)) {
            return super.onHoverEvent(motionEvent);
        }
        return true;
    }
}
