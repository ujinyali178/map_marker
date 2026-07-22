package io.flutter.plugin.platform;

import android.view.Surface;
import io.flutter.view.TextureRegistry;

/* loaded from: /root/release/classes.dex */
public class f0 implements p {

    /* renamed from: a, reason: collision with root package name */
    private TextureRegistry.SurfaceProducer f3138a;

    public f0(TextureRegistry.SurfaceProducer surfaceProducer) {
        this.f3138a = surfaceProducer;
    }

    @Override // io.flutter.plugin.platform.p
    public void a(int i3, int i4) {
        this.f3138a.setSize(i3, i4);
    }

    @Override // io.flutter.plugin.platform.p
    public int getHeight() {
        return this.f3138a.getHeight();
    }

    @Override // io.flutter.plugin.platform.p
    public long getId() {
        return this.f3138a.id();
    }

    @Override // io.flutter.plugin.platform.p
    public Surface getSurface() {
        return this.f3138a.getSurface();
    }

    @Override // io.flutter.plugin.platform.p
    public int getWidth() {
        return this.f3138a.getWidth();
    }

    @Override // io.flutter.plugin.platform.p
    public void release() {
        this.f3138a.release();
        this.f3138a = null;
    }

    @Override // io.flutter.plugin.platform.p
    public void scheduleFrame() {
        this.f3138a.scheduleFrame();
    }
}
