package com.google.crypto.tink.shaded.protobuf;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
final class RawMessageInfo implements MessageInfo {
    private final MessageLite defaultInstance;
    private final int flags;
    private final String info;
    private final Object[] objects;

    RawMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        char charAt;
        this.defaultInstance = messageLite;
        this.info = str;
        this.objects = objArr;
        int charAt2 = str.charAt(0);
        if (charAt2 >= 55296) {
            int i3 = charAt2 & 8191;
            int i4 = 13;
            int i5 = 1;
            while (true) {
                int i6 = i5 + 1;
                charAt = str.charAt(i5);
                if (charAt < 55296) {
                    break;
                }
                i3 |= (charAt & 8191) << i4;
                i4 += 13;
                i5 = i6;
            }
            charAt2 = i3 | (charAt << i4);
        }
        this.flags = charAt2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    Object[] getObjects() {
        return this.objects;
    }

    String getStringInfo() {
        return this.info;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        return (this.flags & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public boolean isMessageSetWireFormat() {
        return (this.flags & 2) == 2;
    }
}
