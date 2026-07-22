package com.google.common.base;

import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class Converter<A, B> implements Function<A, B> {
    private final boolean handleNullAutomatically;

    @CheckForNull
    @LazyInit
    private transient Converter<B, A> reverse;

    private static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> first;
        final Converter<B, C> second;

        ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        A correctedDoBackward(@CheckForNull C c3) {
            return (A) this.first.correctedDoBackward(this.second.correctedDoBackward(c3));
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        C correctedDoForward(@CheckForNull A a4) {
            return (C) this.second.correctedDoForward(this.first.correctedDoForward(a4));
        }

        @Override // com.google.common.base.Converter
        protected A doBackward(C c3) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        protected C doForward(A a4) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ConverterComposition)) {
                return false;
            }
            ConverterComposition converterComposition = (ConverterComposition) obj;
            return this.first.equals(converterComposition.first) && this.second.equals(converterComposition.second);
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            return this.first + ".andThen(" + this.second + ")";
        }
    }

    private static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final Function<? super B, ? extends A> backwardFunction;
        private final Function<? super A, ? extends B> forwardFunction;

        private FunctionBasedConverter(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
            this.forwardFunction = (Function) Preconditions.checkNotNull(function);
            this.backwardFunction = (Function) Preconditions.checkNotNull(function2);
        }

        @Override // com.google.common.base.Converter
        protected A doBackward(B b4) {
            return this.backwardFunction.apply(b4);
        }

        @Override // com.google.common.base.Converter
        protected B doForward(A a4) {
            return this.forwardFunction.apply(a4);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof FunctionBasedConverter)) {
                return false;
            }
            FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
            return this.forwardFunction.equals(functionBasedConverter.forwardFunction) && this.backwardFunction.equals(functionBasedConverter.backwardFunction);
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
        }
    }

    private static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        static final IdentityConverter<?> INSTANCE = new IdentityConverter<>();
        private static final long serialVersionUID = 0;

        private IdentityConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        <S> Converter<T, S> doAndThen(Converter<T, S> converter) {
            return (Converter) Preconditions.checkNotNull(converter, "otherConverter");
        }

        @Override // com.google.common.base.Converter
        protected T doBackward(T t3) {
            return t3;
        }

        @Override // com.google.common.base.Converter
        protected T doForward(T t3) {
            return t3;
        }

        @Override // com.google.common.base.Converter
        public IdentityConverter<T> reverse() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }
    }

    private static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> original;

        ReverseConverter(Converter<A, B> converter) {
            this.original = converter;
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        B correctedDoBackward(@CheckForNull A a4) {
            return this.original.correctedDoForward(a4);
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        A correctedDoForward(@CheckForNull B b4) {
            return this.original.correctedDoBackward(b4);
        }

        @Override // com.google.common.base.Converter
        protected B doBackward(A a4) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        protected A doForward(B b4) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.original.equals(((ReverseConverter) obj).original);
            }
            return false;
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        @Override // com.google.common.base.Converter
        public Converter<A, B> reverse() {
            return this.original;
        }

        public String toString() {
            return this.original + ".reverse()";
        }
    }

    protected Converter() {
        this(true);
    }

    Converter(boolean z3) {
        this.handleNullAutomatically = z3;
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new FunctionBasedConverter(function, function2);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    private A unsafeDoBackward(@CheckForNull B b4) {
        return (A) doBackward(NullnessCasts.uncheckedCastNullableTToT(b4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    private B unsafeDoForward(@CheckForNull A a4) {
        return (B) doForward(NullnessCasts.uncheckedCastNullableTToT(a4));
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    @Override // com.google.common.base.Function
    @Deprecated
    public final B apply(A a4) {
        return convert(a4);
    }

    @CheckForNull
    public final B convert(@CheckForNull A a4) {
        return correctedDoForward(a4);
    }

    public Iterable<B> convertAll(final Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new Iterable<B>() { // from class: com.google.common.base.Converter.1
            @Override // java.lang.Iterable
            public Iterator<B> iterator() {
                return new Iterator<B>() { // from class: com.google.common.base.Converter.1.1
                    private final Iterator<? extends A> fromIterator;

                    {
                        this.fromIterator = iterable.iterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.fromIterator.hasNext();
                    }

                    @Override // java.util.Iterator
                    public B next() {
                        return (B) Converter.this.convert(this.fromIterator.next());
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.fromIterator.remove();
                    }
                };
            }
        };
    }

    @CheckForNull
    A correctedDoBackward(@CheckForNull B b4) {
        if (!this.handleNullAutomatically) {
            return unsafeDoBackward(b4);
        }
        if (b4 == null) {
            return null;
        }
        return (A) Preconditions.checkNotNull(doBackward(b4));
    }

    @CheckForNull
    B correctedDoForward(@CheckForNull A a4) {
        if (!this.handleNullAutomatically) {
            return unsafeDoForward(a4);
        }
        if (a4 == null) {
            return null;
        }
        return (B) Preconditions.checkNotNull(doForward(a4));
    }

    <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        return new ConverterComposition(this, (Converter) Preconditions.checkNotNull(converter));
    }

    protected abstract A doBackward(B b4);

    protected abstract B doForward(A a4);

    @Override // com.google.common.base.Function
    public boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @CheckReturnValue
    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.reverse;
        if (converter != null) {
            return converter;
        }
        ReverseConverter reverseConverter = new ReverseConverter(this);
        this.reverse = reverseConverter;
        return reverseConverter;
    }
}
