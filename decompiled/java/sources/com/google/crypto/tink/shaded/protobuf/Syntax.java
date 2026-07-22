package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* loaded from: /root/release/classes.dex */
public enum Syntax implements Internal.EnumLite {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);

    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    private static final Internal.EnumLiteMap<Syntax> internalValueMap = new Internal.EnumLiteMap<Syntax>() { // from class: com.google.crypto.tink.shaded.protobuf.Syntax.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public Syntax findValueByNumber(int i3) {
            return Syntax.forNumber(i3);
        }
    };
    private final int value;

    private static final class SyntaxVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new SyntaxVerifier();

        private SyntaxVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i3) {
            return Syntax.forNumber(i3) != null;
        }
    }

    Syntax(int i3) {
        this.value = i3;
    }

    public static Syntax forNumber(int i3) {
        if (i3 == 0) {
            return SYNTAX_PROTO2;
        }
        if (i3 != 1) {
            return null;
        }
        return SYNTAX_PROTO3;
    }

    public static Internal.EnumLiteMap<Syntax> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return SyntaxVerifier.INSTANCE;
    }

    @Deprecated
    public static Syntax valueOf(int i3) {
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
