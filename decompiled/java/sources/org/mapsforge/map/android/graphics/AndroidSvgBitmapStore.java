package org.mapsforge.map.android.graphics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Logger;
import org.mapsforge.core.util.IOUtils;

/* loaded from: /root/release/classes2.dex */
public class AndroidSvgBitmapStore {
    private static final Logger LOGGER = Logger.getLogger(AndroidSvgBitmapStore.class.getName());
    private static final String SVG_PREFIX = "svg-";
    private static final String SVG_SUFFIX = ".png";

    private static class SvgStorer implements Runnable {
        private Bitmap bitmap;
        private int hash;

        public SvgStorer(int i3, Bitmap bitmap) {
            this.hash = i3;
            this.bitmap = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger logger;
            String str;
            String createFileName = AndroidSvgBitmapStore.createFileName(this.hash);
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    fileOutputStream = AndroidGraphicFactory.INSTANCE.openFileOutput(createFileName, 0);
                    if (!this.bitmap.compress(Bitmap.CompressFormat.PNG, 0, fileOutputStream)) {
                        AndroidSvgBitmapStore.LOGGER.warning("SVG Failed to write svg bitmap " + createFileName);
                    }
                } catch (FileNotFoundException unused) {
                    logger = AndroidSvgBitmapStore.LOGGER;
                    str = "SVG Failed to create file for svg bitmap " + createFileName;
                    logger.warning(str);
                } catch (IllegalStateException unused2) {
                    logger = AndroidSvgBitmapStore.LOGGER;
                    str = "SVG Failed to stream bitmap to file " + createFileName;
                    logger.warning(str);
                }
            } finally {
                IOUtils.closeQuietly(fileOutputStream);
            }
        }
    }

    private AndroidSvgBitmapStore() {
    }

    public static void clear() {
        for (String str : AndroidGraphicFactory.INSTANCE.fileList()) {
            if (str.startsWith(SVG_PREFIX) && str.endsWith(SVG_SUFFIX)) {
                AndroidGraphicFactory.INSTANCE.deleteFile(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String createFileName(int i3) {
        return SVG_PREFIX + i3 + SVG_SUFFIX;
    }

    public static Bitmap get(int i3) {
        Throwable th;
        FileInputStream fileInputStream;
        try {
            fileInputStream = AndroidGraphicFactory.INSTANCE.openFileInput(createFileName(i3));
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                IOUtils.closeQuietly(fileInputStream);
                return decodeStream;
            } catch (FileNotFoundException unused) {
                IOUtils.closeQuietly(fileInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (FileNotFoundException unused2) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static void put(int i3, Bitmap bitmap) {
        new Thread(new SvgStorer(i3, bitmap)).start();
    }
}
