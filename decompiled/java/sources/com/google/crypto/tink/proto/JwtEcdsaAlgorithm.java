package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* loaded from: /root/release/classes.dex */
public enum JwtEcdsaAlgorithm implements Internal.EnumLite {
    ES_UNKNOWN(0),
    ES256(1),
    ES384(2),
    ES512(3),
    UNRECOGNIZED(-1);

    public static final int ES256_VALUE = 1;
    public static final int ES384_VALUE = 2;
    public static final int ES512_VALUE = 3;
    public static final int ES_UNKNOWN_VALUE = 0;
    private static final Internal.EnumLiteMap<JwtEcdsaAlgorithm> internalValueMap = new Internal.EnumLiteMap<JwtEcdsaAlgorithm>() { // from class: com.google.crypto.tink.proto.JwtEcdsaAlgorithm.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public JwtEcdsaAlgorithm findValueByNumber(int i3) {
            return JwtEcdsaAlgorithm.forNumber(i3);
        }
    };
    private final int value;

    private static final class JwtEcdsaAlgorithmVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new JwtEcdsaAlgorithmVerifier();

        private JwtEcdsaAlgorithmVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i3) {
            return JwtEcdsaAlgorithm.forNumber(i3) != null;
        }
    }

    JwtEcdsaAlgorithm(int i3) {
        this.value = i3;
    }

    public static JwtEcdsaAlgorithm forNumber(int i3) {
        if (i3 == 0) {
            return ES_UNKNOWN;
        }
        if (i3 == 1) {
            return ES256;
        }
        if (i3 == 2) {
            return ES384;
        }
        if (i3 != 3) {
            return null;
        }
        return ES512;
    }

    public static Internal.EnumLiteMap<JwtEcdsaAlgorithm> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return JwtEcdsaAlgorithmVerifier.INSTANCE;
    }

    @Deprecated
    public static JwtEcdsaAlgorithm valueOf(int i3) {
        return forNumber(i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
