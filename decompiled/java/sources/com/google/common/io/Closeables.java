package com.google.common.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class Closeables {
    static final Logger logger = Logger.getLogger(Closeables.class.getName());

    private Closeables() {
    }

    public static void close(@CheckForNull Closeable closeable, boolean z3) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e3) {
            if (!z3) {
                throw e3;
            }
            logger.log(Level.WARNING, "IOException thrown while closing Closeable.", (Throwable) e3);
        }
    }

    public static void closeQuietly(@CheckForNull InputStream inputStream) {
        try {
            close(inputStream, true);
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }

    public static void closeQuietly(@CheckForNull Reader reader) {
        try {
            close(reader, true);
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }
}
