package org.mapsforge.core.util;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /root/release/classes2.dex */
public final class IOUtils {
    private static final Logger LOGGER = Logger.getLogger(IOUtils.class.getName());

    private IOUtils() {
        throw new IllegalStateException();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e3) {
                LOGGER.log(Level.FINE, e3.getMessage(), (Throwable) e3);
            }
        }
    }
}
