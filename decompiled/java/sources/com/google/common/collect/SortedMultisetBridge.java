package com.google.common.collect;

import java.util.Set;
import java.util.SortedSet;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
interface SortedMultisetBridge<E> extends Multiset<E> {
    @Override // com.google.common.collect.Multiset
    /* bridge */ /* synthetic */ Set elementSet();

    @Override // com.google.common.collect.Multiset
    SortedSet<E> elementSet();
}
