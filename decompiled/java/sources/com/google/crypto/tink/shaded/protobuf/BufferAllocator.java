package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
abstract class BufferAllocator {
    private static final BufferAllocator UNPOOLED = new BufferAllocator() { // from class: com.google.crypto.tink.shaded.protobuf.BufferAllocator.1
        @Override // com.google.crypto.tink.shaded.protobuf.BufferAllocator
        public AllocatedBuffer allocateDirectBuffer(int i3) {
            return AllocatedBuffer.wrap(ByteBuffer.allocateDirect(i3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BufferAllocator
        public AllocatedBuffer allocateHeapBuffer(int i3) {
            return AllocatedBuffer.wrap(new byte[i3]);
        }
    };

    BufferAllocator() {
    }

    public static BufferAllocator unpooled() {
        return UNPOOLED;
    }

    public abstract AllocatedBuffer allocateDirectBuffer(int i3);

    public abstract AllocatedBuffer allocateHeapBuffer(int i3);
}
