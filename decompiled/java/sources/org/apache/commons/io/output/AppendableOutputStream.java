package org.apache.commons.io.output;

import java.io.OutputStream;
import java.lang.Appendable;

/* loaded from: /root/release/classes2.dex */
public class AppendableOutputStream<T extends Appendable> extends OutputStream {
    private final T appendable;

    public AppendableOutputStream(T t3) {
        this.appendable = t3;
    }

    public T getAppendable() {
        return this.appendable;
    }

    @Override // java.io.OutputStream
    public void write(int i3) {
        this.appendable.append((char) i3);
    }
}
