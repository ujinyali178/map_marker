package org.apache.commons.io.input;

import java.io.InputStream;
import java.security.MessageDigest;
import org.apache.commons.io.input.ObservableInputStream;

/* loaded from: /root/release/classes2.dex */
public class MessageDigestCalculatingInputStream extends ObservableInputStream {
    private final MessageDigest messageDigest;

    public static class MessageDigestMaintainingObserver extends ObservableInputStream.Observer {
        private final MessageDigest md;

        public MessageDigestMaintainingObserver(MessageDigest messageDigest) {
            this.md = messageDigest;
        }

        @Override // org.apache.commons.io.input.ObservableInputStream.Observer
        void data(int i3) {
            this.md.update((byte) i3);
        }

        @Override // org.apache.commons.io.input.ObservableInputStream.Observer
        void data(byte[] bArr, int i3, int i4) {
            this.md.update(bArr, i3, i4);
        }
    }

    public MessageDigestCalculatingInputStream(InputStream inputStream) {
        this(inputStream, MessageDigest.getInstance("MD5"));
    }

    public MessageDigestCalculatingInputStream(InputStream inputStream, String str) {
        this(inputStream, MessageDigest.getInstance(str));
    }

    public MessageDigestCalculatingInputStream(InputStream inputStream, MessageDigest messageDigest) {
        super(inputStream);
        this.messageDigest = messageDigest;
        add(new MessageDigestMaintainingObserver(messageDigest));
    }

    public MessageDigest getMessageDigest() {
        return this.messageDigest;
    }
}
