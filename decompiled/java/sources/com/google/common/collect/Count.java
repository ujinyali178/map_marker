package com.google.common.collect;

import java.io.Serializable;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class Count implements Serializable {
    private int value;

    Count(int i3) {
        this.value = i3;
    }

    public void add(int i3) {
        this.value += i3;
    }

    public int addAndGet(int i3) {
        int i4 = this.value + i3;
        this.value = i4;
        return i4;
    }

    public boolean equals(@CheckForNull Object obj) {
        return (obj instanceof Count) && ((Count) obj).value == this.value;
    }

    public int get() {
        return this.value;
    }

    public int getAndSet(int i3) {
        int i4 = this.value;
        this.value = i3;
        return i4;
    }

    public int hashCode() {
        return this.value;
    }

    public void set(int i3) {
        this.value = i3;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
