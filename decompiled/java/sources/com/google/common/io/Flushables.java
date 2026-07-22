package com.google.common.io;

import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class Flushables {
    private static final Logger logger = Logger.getLogger(Flushables.class.getName());

    private Flushables() {
    }

    public static void flush(Flushable flushable, boolean z3) {
        try {
            flushable.flush();
        } catch (IOException e3) {
            if (!z3) {
                throw e3;
            }
            logger.log(Level.WARNING, "IOException thrown while flushing Flushable.", (Throwable) e3);
        }
    }

    public static void flushQuietly(Flushable flushable) {
        try {
            flush(flushable, true);
        } catch (IOException e3) {
            logger.log(Level.SEVERE, "IOException should not have been thrown.", (Throwable) e3);
        }
    }
}
