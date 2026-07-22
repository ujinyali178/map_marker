package com.google.common.base;

import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public class Joiner {
    private final String separator;

    public static final class MapJoiner {
        private final Joiner joiner;
        private final String keyValueSeparator;

        private MapJoiner(Joiner joiner, String str) {
            this.joiner = joiner;
            this.keyValueSeparator = (String) Preconditions.checkNotNull(str);
        }

        public <A extends Appendable> A appendTo(A a4, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return (A) appendTo((MapJoiner) a4, iterable.iterator());
        }

        public <A extends Appendable> A appendTo(A a4, Iterator<? extends Map.Entry<?, ?>> it) {
            Preconditions.checkNotNull(a4);
            if (it.hasNext()) {
                while (true) {
                    Map.Entry<?, ?> next = it.next();
                    a4.append(this.joiner.toString(next.getKey()));
                    a4.append(this.keyValueSeparator);
                    a4.append(this.joiner.toString(next.getValue()));
                    if (!it.hasNext()) {
                        break;
                    }
                    a4.append(this.joiner.separator);
                }
            }
            return a4;
        }

        public <A extends Appendable> A appendTo(A a4, Map<?, ?> map) {
            return (A) appendTo((MapJoiner) a4, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        public StringBuilder appendTo(StringBuilder sb, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return appendTo(sb, iterable.iterator());
        }

        public StringBuilder appendTo(StringBuilder sb, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                appendTo((MapJoiner) sb, it);
                return sb;
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        public StringBuilder appendTo(StringBuilder sb, Map<?, ?> map) {
            return appendTo(sb, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        public String join(Iterable<? extends Map.Entry<?, ?>> iterable) {
            return join(iterable.iterator());
        }

        public String join(Iterator<? extends Map.Entry<?, ?>> it) {
            return appendTo(new StringBuilder(), it).toString();
        }

        public String join(Map<?, ?> map) {
            return join(map.entrySet());
        }

        public MapJoiner useForNull(String str) {
            return new MapJoiner(this.joiner.useForNull(str), this.keyValueSeparator);
        }
    }

    private Joiner(Joiner joiner) {
        this.separator = joiner.separator;
    }

    private Joiner(String str) {
        this.separator = (String) Preconditions.checkNotNull(str);
    }

    private static Iterable<Object> iterable(@CheckForNull final Object obj, @CheckForNull final Object obj2, final Object[] objArr) {
        Preconditions.checkNotNull(objArr);
        return new AbstractList<Object>() { // from class: com.google.common.base.Joiner.3
            @Override // java.util.AbstractList, java.util.List
            @CheckForNull
            public Object get(int i3) {
                return i3 != 0 ? i3 != 1 ? objArr[i3 - 2] : obj2 : obj;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return objArr.length + 2;
            }
        };
    }

    public static Joiner on(char c3) {
        return new Joiner(String.valueOf(c3));
    }

    public static Joiner on(String str) {
        return new Joiner(str);
    }

    public <A extends Appendable> A appendTo(A a4, Iterable<? extends Object> iterable) {
        return (A) appendTo((Joiner) a4, iterable.iterator());
    }

    public final <A extends Appendable> A appendTo(A a4, @CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) {
        return (A) appendTo((Joiner) a4, iterable(obj, obj2, objArr));
    }

    public <A extends Appendable> A appendTo(A a4, Iterator<? extends Object> it) {
        Preconditions.checkNotNull(a4);
        if (it.hasNext()) {
            while (true) {
                a4.append(toString(it.next()));
                if (!it.hasNext()) {
                    break;
                }
                a4.append(this.separator);
            }
        }
        return a4;
    }

    public final <A extends Appendable> A appendTo(A a4, Object[] objArr) {
        return (A) appendTo((Joiner) a4, (Iterable<? extends Object>) Arrays.asList(objArr));
    }

    public final StringBuilder appendTo(StringBuilder sb, Iterable<? extends Object> iterable) {
        return appendTo(sb, iterable.iterator());
    }

    public final StringBuilder appendTo(StringBuilder sb, @CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) {
        return appendTo(sb, iterable(obj, obj2, objArr));
    }

    public final StringBuilder appendTo(StringBuilder sb, Iterator<? extends Object> it) {
        try {
            appendTo((Joiner) sb, it);
            return sb;
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }

    public final StringBuilder appendTo(StringBuilder sb, Object[] objArr) {
        return appendTo(sb, (Iterable<? extends Object>) Arrays.asList(objArr));
    }

    public final String join(Iterable<? extends Object> iterable) {
        return join(iterable.iterator());
    }

    public final String join(@CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) {
        return join(iterable(obj, obj2, objArr));
    }

    public final String join(Iterator<? extends Object> it) {
        return appendTo(new StringBuilder(), it).toString();
    }

    public final String join(Object[] objArr) {
        return join(Arrays.asList(objArr));
    }

    public Joiner skipNulls() {
        return new Joiner(this) { // from class: com.google.common.base.Joiner.2
            @Override // com.google.common.base.Joiner
            public <A extends Appendable> A appendTo(A a4, Iterator<? extends Object> it) {
                Preconditions.checkNotNull(a4, "appendable");
                Preconditions.checkNotNull(it, "parts");
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (next != null) {
                        a4.append(Joiner.this.toString(next));
                        break;
                    }
                }
                while (it.hasNext()) {
                    Object next2 = it.next();
                    if (next2 != null) {
                        a4.append(Joiner.this.separator);
                        a4.append(Joiner.this.toString(next2));
                    }
                }
                return a4;
            }

            @Override // com.google.common.base.Joiner
            public Joiner useForNull(String str) {
                throw new UnsupportedOperationException("already specified skipNulls");
            }

            @Override // com.google.common.base.Joiner
            public MapJoiner withKeyValueSeparator(String str) {
                throw new UnsupportedOperationException("can't use .skipNulls() with maps");
            }
        };
    }

    CharSequence toString(@CheckForNull Object obj) {
        java.util.Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public Joiner useForNull(final String str) {
        Preconditions.checkNotNull(str);
        return new Joiner(this) { // from class: com.google.common.base.Joiner.1
            @Override // com.google.common.base.Joiner
            public Joiner skipNulls() {
                throw new UnsupportedOperationException("already specified useForNull");
            }

            @Override // com.google.common.base.Joiner
            CharSequence toString(@CheckForNull Object obj) {
                return obj == null ? str : Joiner.this.toString(obj);
            }

            @Override // com.google.common.base.Joiner
            public Joiner useForNull(String str2) {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    public MapJoiner withKeyValueSeparator(char c3) {
        return withKeyValueSeparator(String.valueOf(c3));
    }

    public MapJoiner withKeyValueSeparator(String str) {
        return new MapJoiner(str);
    }
}
