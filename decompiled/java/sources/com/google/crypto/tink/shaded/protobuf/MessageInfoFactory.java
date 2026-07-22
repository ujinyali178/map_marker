package com.google.crypto.tink.shaded.protobuf;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
interface MessageInfoFactory {
    boolean isSupported(Class<?> cls);

    MessageInfo messageInfoFor(Class<?> cls);
}
