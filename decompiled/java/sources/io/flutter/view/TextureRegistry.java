package io.flutter.view;

import android.graphics.SurfaceTexture;
import android.media.Image;
import android.view.Surface;

/* loaded from: /root/release/classes.dex */
public interface TextureRegistry {

    public interface GLTextureConsumer {
        SurfaceTexture getSurfaceTexture();
    }

    public interface ImageConsumer {
        Image acquireLatestImage();
    }

    public interface ImageTextureEntry {
        /* synthetic */ long id();

        void pushImage(Image image);

        /* synthetic */ void release();
    }

    public interface SurfaceProducer {
        int getHeight();

        Surface getSurface();

        int getWidth();

        /* synthetic */ long id();

        /* synthetic */ void release();

        void scheduleFrame();

        void setSize(int i3, int i4);
    }

    public interface SurfaceTextureEntry {
        /* synthetic */ long id();

        /* synthetic */ void release();

        void setOnFrameConsumedListener(a aVar);

        void setOnTrimMemoryListener(b bVar);

        SurfaceTexture surfaceTexture();
    }

    public interface a {
        void a();
    }

    public interface b {
        void onTrimMemory(int i3);
    }

    ImageTextureEntry h();

    SurfaceProducer j();

    SurfaceTextureEntry k();
}
