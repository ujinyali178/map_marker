package io.flutter.plugin.platform;

import android.view.Surface;

/* loaded from: /root/release/classes.dex */
public interface p {
    void a(int i3, int i4);

    int getHeight();

    long getId();

    Surface getSurface();

    int getWidth();

    void release();

    void scheduleFrame();
}
