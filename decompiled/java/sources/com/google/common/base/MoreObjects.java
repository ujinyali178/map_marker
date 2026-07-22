package com.google.common.base;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import javax.annotation.CheckForNull;
import org.mapsforge.core.model.Tag;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class MoreObjects {

    public static final class ToStringHelper {
        private final String className;
        private final ValueHolder holderHead;
        private ValueHolder holderTail;
        private boolean omitEmptyValues;
        private boolean omitNullValues;

        private static final class UnconditionalValueHolder extends ValueHolder {
            private UnconditionalValueHolder() {
                super();
            }
        }

        private static class ValueHolder {

            @CheckForNull
            String name;

            @CheckForNull
            ValueHolder next;

            @CheckForNull
            Object value;

            private ValueHolder() {
            }
        }

        private ToStringHelper(String str) {
            ValueHolder valueHolder = new ValueHolder();
            this.holderHead = valueHolder;
            this.holderTail = valueHolder;
            this.omitNullValues = false;
            this.omitEmptyValues = false;
            this.className = (String) Preconditions.checkNotNull(str);
        }

        private ValueHolder addHolder() {
            ValueHolder valueHolder = new ValueHolder();
            this.holderTail.next = valueHolder;
            this.holderTail = valueHolder;
            return valueHolder;
        }

        private ToStringHelper addHolder(@CheckForNull Object obj) {
            addHolder().value = obj;
            return this;
        }

        private ToStringHelper addHolder(String str, @CheckForNull Object obj) {
            ValueHolder addHolder = addHolder();
            addHolder.value = obj;
            addHolder.name = (String) Preconditions.checkNotNull(str);
            return this;
        }

        private UnconditionalValueHolder addUnconditionalHolder() {
            UnconditionalValueHolder unconditionalValueHolder = new UnconditionalValueHolder();
            this.holderTail.next = unconditionalValueHolder;
            this.holderTail = unconditionalValueHolder;
            return unconditionalValueHolder;
        }

        private ToStringHelper addUnconditionalHolder(Object obj) {
            addUnconditionalHolder().value = obj;
            return this;
        }

        private ToStringHelper addUnconditionalHolder(String str, Object obj) {
            UnconditionalValueHolder addUnconditionalHolder = addUnconditionalHolder();
            addUnconditionalHolder.value = obj;
            addUnconditionalHolder.name = (String) Preconditions.checkNotNull(str);
            return this;
        }

        private static boolean isEmpty(Object obj) {
            return obj instanceof CharSequence ? ((CharSequence) obj).length() == 0 : obj instanceof Collection ? ((Collection) obj).isEmpty() : obj instanceof Map ? ((Map) obj).isEmpty() : obj instanceof Optional ? !((Optional) obj).isPresent() : obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        public ToStringHelper add(String str, char c3) {
            return addUnconditionalHolder(str, String.valueOf(c3));
        }

        public ToStringHelper add(String str, double d3) {
            return addUnconditionalHolder(str, String.valueOf(d3));
        }

        public ToStringHelper add(String str, float f3) {
            return addUnconditionalHolder(str, String.valueOf(f3));
        }

        public ToStringHelper add(String str, int i3) {
            return addUnconditionalHolder(str, String.valueOf(i3));
        }

        public ToStringHelper add(String str, long j3) {
            return addUnconditionalHolder(str, String.valueOf(j3));
        }

        public ToStringHelper add(String str, @CheckForNull Object obj) {
            return addHolder(str, obj);
        }

        public ToStringHelper add(String str, boolean z3) {
            return addUnconditionalHolder(str, String.valueOf(z3));
        }

        public ToStringHelper addValue(char c3) {
            return addUnconditionalHolder(String.valueOf(c3));
        }

        public ToStringHelper addValue(double d3) {
            return addUnconditionalHolder(String.valueOf(d3));
        }

        public ToStringHelper addValue(float f3) {
            return addUnconditionalHolder(String.valueOf(f3));
        }

        public ToStringHelper addValue(int i3) {
            return addUnconditionalHolder(String.valueOf(i3));
        }

        public ToStringHelper addValue(long j3) {
            return addUnconditionalHolder(String.valueOf(j3));
        }

        public ToStringHelper addValue(@CheckForNull Object obj) {
            return addHolder(obj);
        }

        public ToStringHelper addValue(boolean z3) {
            return addUnconditionalHolder(String.valueOf(z3));
        }

        public ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        public String toString() {
            boolean z3 = this.omitNullValues;
            boolean z4 = this.omitEmptyValues;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.className);
            sb.append('{');
            String str = "";
            for (ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
                Object obj = valueHolder.value;
                if (!(valueHolder instanceof UnconditionalValueHolder)) {
                    if (obj == null) {
                        if (z3) {
                        }
                    } else if (z4 && isEmpty(obj)) {
                    }
                }
                sb.append(str);
                String str2 = valueHolder.name;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append(Tag.KEY_VALUE_SEPARATOR);
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb.append(obj);
                } else {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                }
                str = ", ";
            }
            sb.append('}');
            return sb.toString();
        }
    }

    private MoreObjects() {
    }

    public static <T> T firstNonNull(@CheckForNull T t3, @CheckForNull T t4) {
        if (t3 != null) {
            return t3;
        }
        if (t4 != null) {
            return t4;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper toStringHelper(Class<?> cls) {
        return new ToStringHelper(cls.getSimpleName());
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }

    public static ToStringHelper toStringHelper(String str) {
        return new ToStringHelper(str);
    }
}
