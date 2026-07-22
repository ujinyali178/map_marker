package com.google.crypto.tink.daead;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.MonitoringUtil;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.monitoring.MonitoringClient;
import com.google.crypto.tink.monitoring.MonitoringKeysetInfo;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

/* loaded from: /root/release/classes.dex */
public class DeterministicAeadWrapper implements PrimitiveWrapper<DeterministicAead, DeterministicAead> {
    private static final Logger logger = Logger.getLogger(DeterministicAeadWrapper.class.getName());
    private static final DeterministicAeadWrapper WRAPPER = new DeterministicAeadWrapper();

    private static class WrappedDeterministicAead implements DeterministicAead {
        private final MonitoringClient.Logger decLogger;
        private final MonitoringClient.Logger encLogger;
        private final PrimitiveSet<DeterministicAead> primitives;

        public WrappedDeterministicAead(PrimitiveSet<DeterministicAead> primitiveSet) {
            MonitoringClient.Logger logger;
            this.primitives = primitiveSet;
            if (primitiveSet.hasAnnotations()) {
                MonitoringClient monitoringClient = MutableMonitoringRegistry.globalInstance().getMonitoringClient();
                MonitoringKeysetInfo monitoringKeysetInfo = MonitoringUtil.getMonitoringKeysetInfo(primitiveSet);
                this.encLogger = monitoringClient.createLogger(monitoringKeysetInfo, "daead", "encrypt");
                logger = monitoringClient.createLogger(monitoringKeysetInfo, "daead", "decrypt");
            } else {
                logger = MonitoringUtil.DO_NOTHING_LOGGER;
                this.encLogger = logger;
            }
            this.decLogger = logger;
        }

        @Override // com.google.crypto.tink.DeterministicAead
        public byte[] decryptDeterministically(byte[] bArr, byte[] bArr2) {
            if (bArr.length > 5) {
                byte[] copyOf = Arrays.copyOf(bArr, 5);
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (PrimitiveSet.Entry<DeterministicAead> entry : this.primitives.getPrimitive(copyOf)) {
                    try {
                        byte[] decryptDeterministically = entry.getPrimitive().decryptDeterministically(copyOfRange, bArr2);
                        this.decLogger.log(entry.getKeyId(), copyOfRange.length);
                        return decryptDeterministically;
                    } catch (GeneralSecurityException e3) {
                        DeterministicAeadWrapper.logger.info("ciphertext prefix matches a key, but cannot decrypt: " + e3);
                    }
                }
            }
            for (PrimitiveSet.Entry<DeterministicAead> entry2 : this.primitives.getRawPrimitives()) {
                try {
                    byte[] decryptDeterministically2 = entry2.getPrimitive().decryptDeterministically(bArr, bArr2);
                    this.decLogger.log(entry2.getKeyId(), bArr.length);
                    return decryptDeterministically2;
                } catch (GeneralSecurityException unused) {
                }
            }
            this.decLogger.logFailure();
            throw new GeneralSecurityException("decryption failed");
        }

        @Override // com.google.crypto.tink.DeterministicAead
        public byte[] encryptDeterministically(byte[] bArr, byte[] bArr2) {
            try {
                byte[] concat = Bytes.concat(this.primitives.getPrimary().getIdentifier(), this.primitives.getPrimary().getPrimitive().encryptDeterministically(bArr, bArr2));
                this.encLogger.log(this.primitives.getPrimary().getKeyId(), bArr.length);
                return concat;
            } catch (GeneralSecurityException e3) {
                this.encLogger.logFailure();
                throw e3;
            }
        }
    }

    DeterministicAeadWrapper() {
    }

    public static void register() {
        Registry.registerPrimitiveWrapper(WRAPPER);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<DeterministicAead> getInputPrimitiveClass() {
        return DeterministicAead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<DeterministicAead> getPrimitiveClass() {
        return DeterministicAead.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public DeterministicAead wrap(PrimitiveSet<DeterministicAead> primitiveSet) {
        return new WrappedDeterministicAead(primitiveSet);
    }
}
