package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Preconditions;
import java.util.NoSuchElementException;

/* loaded from: /root/release/classes.dex */
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {
    private Object zac;

    public SingleRefDataBufferIterator(DataBuffer dataBuffer) {
        super(dataBuffer);
    }

    @Override // com.google.android.gms.common.data.DataBufferIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zab);
        }
        int i3 = this.zab + 1;
        this.zab = i3;
        if (i3 == 0) {
            Object checkNotNull = Preconditions.checkNotNull(this.zaa.get(0));
            this.zac = checkNotNull;
            if (!(checkNotNull instanceof DataBufferRef)) {
                throw new IllegalStateException("DataBuffer reference of type " + String.valueOf(checkNotNull.getClass()) + " is not movable");
            }
        } else {
            ((DataBufferRef) Preconditions.checkNotNull(this.zac)).zaa(this.zab);
        }
        return this.zac;
    }
}
