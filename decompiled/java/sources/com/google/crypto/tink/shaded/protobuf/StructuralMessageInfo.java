package com.google.crypto.tink.shaded.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
final class StructuralMessageInfo implements MessageInfo {
    private final int[] checkInitialized;
    private final MessageLite defaultInstance;
    private final FieldInfo[] fields;
    private final boolean messageSetWireFormat;
    private final ProtoSyntax syntax;

    public static final class Builder {
        private int[] checkInitialized;
        private Object defaultInstance;
        private final List<FieldInfo> fields;
        private boolean messageSetWireFormat;
        private ProtoSyntax syntax;
        private boolean wasBuilt;

        public Builder() {
            this.checkInitialized = null;
            this.fields = new ArrayList();
        }

        public Builder(int i3) {
            this.checkInitialized = null;
            this.fields = new ArrayList(i3);
        }

        public StructuralMessageInfo build() {
            if (this.wasBuilt) {
                throw new IllegalStateException("Builder can only build once");
            }
            if (this.syntax == null) {
                throw new IllegalStateException("Must specify a proto syntax");
            }
            this.wasBuilt = true;
            Collections.sort(this.fields);
            return new StructuralMessageInfo(this.syntax, this.messageSetWireFormat, this.checkInitialized, (FieldInfo[]) this.fields.toArray(new FieldInfo[0]), this.defaultInstance);
        }

        public void withCheckInitialized(int[] iArr) {
            this.checkInitialized = iArr;
        }

        public void withDefaultInstance(Object obj) {
            this.defaultInstance = obj;
        }

        public void withField(FieldInfo fieldInfo) {
            if (this.wasBuilt) {
                throw new IllegalStateException("Builder can only build once");
            }
            this.fields.add(fieldInfo);
        }

        public void withMessageSetWireFormat(boolean z3) {
            this.messageSetWireFormat = z3;
        }

        public void withSyntax(ProtoSyntax protoSyntax) {
            this.syntax = (ProtoSyntax) Internal.checkNotNull(protoSyntax, "syntax");
        }
    }

    StructuralMessageInfo(ProtoSyntax protoSyntax, boolean z3, int[] iArr, FieldInfo[] fieldInfoArr, Object obj) {
        this.syntax = protoSyntax;
        this.messageSetWireFormat = z3;
        this.checkInitialized = iArr;
        this.fields = fieldInfoArr;
        this.defaultInstance = (MessageLite) Internal.checkNotNull(obj, "defaultInstance");
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(int i3) {
        return new Builder(i3);
    }

    public int[] getCheckInitialized() {
        return this.checkInitialized;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    public FieldInfo[] getFields() {
        return this.fields;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        return this.syntax;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public boolean isMessageSetWireFormat() {
        return this.messageSetWireFormat;
    }
}
