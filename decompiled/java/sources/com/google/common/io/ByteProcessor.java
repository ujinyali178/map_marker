package com.google.common.io;

import com.google.errorprone.annotations.DoNotMock;

@ElementTypesAreNonnullByDefault
@DoNotMock("Implement it normally")
/* loaded from: /root/release/classes.dex */
public interface ByteProcessor<T> {
    @ParametricNullness
    T getResult();

    boolean processBytes(byte[] bArr, int i3, int i4);
}
