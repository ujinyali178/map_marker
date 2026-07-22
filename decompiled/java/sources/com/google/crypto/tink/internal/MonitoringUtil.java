package com.google.crypto.tink.internal;

import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.monitoring.MonitoringClient;
import com.google.crypto.tink.monitoring.MonitoringKeysetInfo;
import com.google.crypto.tink.proto.KeyStatusType;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public final class MonitoringUtil {
    public static final MonitoringClient.Logger DO_NOTHING_LOGGER = new DoNothingLogger(null);
    private static final String TYPE_URL_PREFIX = "type.googleapis.com/google.crypto.";

    /* renamed from: com.google.crypto.tink.internal.MonitoringUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$KeyStatusType;

        static {
            int[] iArr = new int[KeyStatusType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$KeyStatusType = iArr;
            try {
                iArr[KeyStatusType.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static class DoNothingLogger implements MonitoringClient.Logger {
        private DoNothingLogger() {
        }

        /* synthetic */ DoNothingLogger(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.crypto.tink.monitoring.MonitoringClient.Logger
        public void log(int i3, long j3) {
        }

        @Override // com.google.crypto.tink.monitoring.MonitoringClient.Logger
        public void logFailure() {
        }
    }

    private MonitoringUtil() {
    }

    public static <P> MonitoringKeysetInfo getMonitoringKeysetInfo(PrimitiveSet<P> primitiveSet) {
        MonitoringKeysetInfo.Builder newBuilder = MonitoringKeysetInfo.newBuilder();
        newBuilder.setAnnotations(primitiveSet.getAnnotations());
        Iterator<List<PrimitiveSet.Entry<P>>> it = primitiveSet.getAll().iterator();
        while (it.hasNext()) {
            for (PrimitiveSet.Entry<P> entry : it.next()) {
                newBuilder.addEntry(parseStatus(entry.getStatus()), entry.getKeyId(), parseKeyTypeUrl(entry.getKeyType()), entry.getOutputPrefixType().name());
            }
        }
        if (primitiveSet.getPrimary() != null) {
            newBuilder.setPrimaryKeyId(primitiveSet.getPrimary().getKeyId());
        }
        try {
            return newBuilder.build();
        } catch (GeneralSecurityException e3) {
            throw new IllegalStateException(e3);
        }
    }

    private static String parseKeyTypeUrl(String str) {
        return !str.startsWith(TYPE_URL_PREFIX) ? str : str.substring(34);
    }

    private static KeyStatus parseStatus(KeyStatusType keyStatusType) {
        int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$KeyStatusType[keyStatusType.ordinal()];
        if (i3 == 1) {
            return KeyStatus.ENABLED;
        }
        if (i3 == 2) {
            return KeyStatus.DISABLED;
        }
        if (i3 == 3) {
            return KeyStatus.DESTROYED;
        }
        throw new IllegalStateException("Unknown key status");
    }
}
