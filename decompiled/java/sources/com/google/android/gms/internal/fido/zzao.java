package com.google.android.gms.internal.fido;

import java.util.NoSuchElementException;

/* loaded from: /root/release/classes.dex */
abstract class zzao extends zzba {
    private final int zza;
    private int zzb;

    protected zzao(int i3, int i4) {
        zzam.zzb(i4, i3, "index");
        this.zza = i3;
        this.zzb = i4;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i3 = this.zzb;
        this.zzb = i3 + 1;
        return zza(i3);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzb;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i3 = this.zzb - 1;
        this.zzb = i3;
        return zza(i3);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzb - 1;
    }

    protected abstract Object zza(int i3);
}
