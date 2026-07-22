package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Internal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
abstract class ListFieldSchema {
    private static final ListFieldSchema FULL_INSTANCE;
    private static final ListFieldSchema LITE_INSTANCE;

    private static final class ListFieldSchemaFull extends ListFieldSchema {
        private static final Class<?> UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private ListFieldSchemaFull() {
            super();
        }

        static <E> List<E> getList(Object obj, long j3) {
            return (List) UnsafeUtil.getObject(obj, j3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <L> List<L> mutableListAt(Object obj, long j3, int i3) {
            List<L> mutableCopyWithCapacity2;
            LazyStringArrayList lazyStringArrayList;
            List<L> list = getList(obj, j3);
            if (!list.isEmpty()) {
                if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                    ArrayList arrayList = new ArrayList(list.size() + i3);
                    arrayList.addAll(list);
                    lazyStringArrayList = arrayList;
                } else if (list instanceof UnmodifiableLazyStringList) {
                    LazyStringArrayList lazyStringArrayList2 = new LazyStringArrayList(list.size() + i3);
                    lazyStringArrayList2.addAll((UnmodifiableLazyStringList) list);
                    lazyStringArrayList = lazyStringArrayList2;
                } else {
                    if (!(list instanceof PrimitiveNonBoxingCollection) || !(list instanceof Internal.ProtobufList)) {
                        return list;
                    }
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        return list;
                    }
                    mutableCopyWithCapacity2 = protobufList.mutableCopyWithCapacity2(list.size() + i3);
                }
                UnsafeUtil.putObject(obj, j3, lazyStringArrayList);
                return lazyStringArrayList;
            }
            mutableCopyWithCapacity2 = list instanceof LazyStringList ? new LazyStringArrayList(i3) : ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) ? ((Internal.ProtobufList) list).mutableCopyWithCapacity2(i3) : new ArrayList<>(i3);
            UnsafeUtil.putObject(obj, j3, mutableCopyWithCapacity2);
            return mutableCopyWithCapacity2;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        void makeImmutableListAt(Object obj, long j3) {
            Object unmodifiableList;
            List list = (List) UnsafeUtil.getObject(obj, j3);
            if (list instanceof LazyStringList) {
                unmodifiableList = ((LazyStringList) list).getUnmodifiableView();
            } else {
                if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                        return;
                    }
                    return;
                }
                unmodifiableList = Collections.unmodifiableList(list);
            }
            UnsafeUtil.putObject(obj, j3, unmodifiableList);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        <E> void mergeListsAt(Object obj, Object obj2, long j3) {
            List list = getList(obj2, j3);
            List mutableListAt = mutableListAt(obj, j3, list.size());
            int size = mutableListAt.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                mutableListAt.addAll(list);
            }
            if (size > 0) {
                list = mutableListAt;
            }
            UnsafeUtil.putObject(obj, j3, list);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        <L> List<L> mutableListAt(Object obj, long j3) {
            return mutableListAt(obj, j3, 10);
        }
    }

    private static final class ListFieldSchemaLite extends ListFieldSchema {
        private ListFieldSchemaLite() {
            super();
        }

        static <E> Internal.ProtobufList<E> getProtobufList(Object obj, long j3) {
            return (Internal.ProtobufList) UnsafeUtil.getObject(obj, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        void makeImmutableListAt(Object obj, long j3) {
            getProtobufList(obj, j3).makeImmutable();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        <E> void mergeListsAt(Object obj, Object obj2, long j3) {
            Internal.ProtobufList protobufList = getProtobufList(obj, j3);
            Internal.ProtobufList protobufList2 = getProtobufList(obj2, j3);
            int size = protobufList.size();
            int size2 = protobufList2.size();
            if (size > 0 && size2 > 0) {
                if (!protobufList.isModifiable()) {
                    protobufList = protobufList.mutableCopyWithCapacity2(size2 + size);
                }
                protobufList.addAll(protobufList2);
            }
            if (size > 0) {
                protobufList2 = protobufList;
            }
            UnsafeUtil.putObject(obj, j3, protobufList2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        <L> List<L> mutableListAt(Object obj, long j3) {
            Internal.ProtobufList protobufList = getProtobufList(obj, j3);
            if (protobufList.isModifiable()) {
                return protobufList;
            }
            int size = protobufList.size();
            Internal.ProtobufList mutableCopyWithCapacity2 = protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            UnsafeUtil.putObject(obj, j3, mutableCopyWithCapacity2);
            return mutableCopyWithCapacity2;
        }
    }

    static {
        FULL_INSTANCE = new ListFieldSchemaFull();
        LITE_INSTANCE = new ListFieldSchemaLite();
    }

    private ListFieldSchema() {
    }

    static ListFieldSchema full() {
        return FULL_INSTANCE;
    }

    static ListFieldSchema lite() {
        return LITE_INSTANCE;
    }

    abstract void makeImmutableListAt(Object obj, long j3);

    abstract <L> void mergeListsAt(Object obj, Object obj2, long j3);

    abstract <L> List<L> mutableListAt(Object obj, long j3);
}
