package io.flutter.embedding.android;

import android.app.Activity;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.WindowLayoutInfo;
import java.util.concurrent.Executor;

/* loaded from: /root/release/classes.dex */
public class i0 {

    /* renamed from: a, reason: collision with root package name */
    final WindowInfoTrackerCallbackAdapter f2788a;

    public i0(WindowInfoTrackerCallbackAdapter windowInfoTrackerCallbackAdapter) {
        this.f2788a = windowInfoTrackerCallbackAdapter;
    }

    public void a(Activity activity, Executor executor, androidx.core.util.a<WindowLayoutInfo> aVar) {
        this.f2788a.addWindowLayoutInfoListener(activity, executor, aVar);
    }

    public void b(androidx.core.util.a<WindowLayoutInfo> aVar) {
        this.f2788a.removeWindowLayoutInfoListener(aVar);
    }
}
