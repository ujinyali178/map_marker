package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class FuturesGetChecked {
    private static final Ordering<Constructor<?>> WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new Function() { // from class: com.google.common.util.concurrent.v
        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            Boolean lambda$static$0;
            lambda$static$0 = FuturesGetChecked.lambda$static$0((Constructor) obj);
            return lambda$static$0;
        }
    }).reverse();

    interface GetCheckedTypeValidator {
        void validateClass(Class<? extends Exception> cls);
    }

    static class GetCheckedTypeValidatorHolder {
        static final GetCheckedTypeValidator BEST_VALIDATOR = getBestValidator();

        enum WeakSetValidator implements GetCheckedTypeValidator {
            INSTANCE;

            private static final Set<WeakReference<Class<? extends Exception>>> validClasses = new CopyOnWriteArraySet();

            @Override // com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator
            public void validateClass(Class<? extends Exception> cls) {
                Iterator<WeakReference<Class<? extends Exception>>> it = validClasses.iterator();
                while (it.hasNext()) {
                    if (cls.equals(it.next().get())) {
                        return;
                    }
                }
                FuturesGetChecked.checkExceptionClassValidity(cls);
                Set<WeakReference<Class<? extends Exception>>> set = validClasses;
                if (set.size() > 1000) {
                    set.clear();
                }
                set.add(new WeakReference<>(cls));
            }
        }

        GetCheckedTypeValidatorHolder() {
        }

        static GetCheckedTypeValidator getBestValidator() {
            return FuturesGetChecked.weakSetValidator();
        }
    }

    private FuturesGetChecked() {
    }

    private static GetCheckedTypeValidator bestGetCheckedTypeValidator() {
        return GetCheckedTypeValidatorHolder.BEST_VALIDATOR;
    }

    static void checkExceptionClassValidity(Class<? extends Exception> cls) {
        Preconditions.checkArgument(isCheckedException(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        Preconditions.checkArgument(hasConstructorUsableByGetChecked(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
    }

    @ParametricNullness
    static <V, X extends Exception> V getChecked(GetCheckedTypeValidator getCheckedTypeValidator, Future<V> future, Class<X> cls) {
        getCheckedTypeValidator.validateClass(cls);
        try {
            return future.get();
        } catch (InterruptedException e3) {
            Thread.currentThread().interrupt();
            throw newWithCause(cls, e3);
        } catch (ExecutionException e4) {
            wrapAndThrowExceptionOrError(e4.getCause(), cls);
            throw new AssertionError();
        }
    }

    @ParametricNullness
    static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls) {
        return (V) getChecked(bestGetCheckedTypeValidator(), future, cls);
    }

    @ParametricNullness
    static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls, long j3, TimeUnit timeUnit) {
        bestGetCheckedTypeValidator().validateClass(cls);
        try {
            return future.get(j3, timeUnit);
        } catch (InterruptedException e3) {
            Thread.currentThread().interrupt();
            throw newWithCause(cls, e3);
        } catch (ExecutionException e4) {
            wrapAndThrowExceptionOrError(e4.getCause(), cls);
            throw new AssertionError();
        } catch (TimeoutException e5) {
            throw newWithCause(cls, e5);
        }
    }

    private static boolean hasConstructorUsableByGetChecked(Class<? extends Exception> cls) {
        try {
            newWithCause(cls, new Exception());
            return true;
        } catch (Error | RuntimeException unused) {
            return false;
        }
    }

    static boolean isCheckedException(Class<? extends Exception> cls) {
        return !RuntimeException.class.isAssignableFrom(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$static$0(Constructor constructor) {
        return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(String.class));
    }

    @CheckForNull
    private static <X> X newFromConstructor(Constructor<X> constructor, Throwable th) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i3 = 0; i3 < parameterTypes.length; i3++) {
            Class<?> cls = parameterTypes[i3];
            if (cls.equals(String.class)) {
                objArr[i3] = th.toString();
            } else {
                if (!cls.equals(Throwable.class)) {
                    return null;
                }
                objArr[i3] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static <X extends Exception> X newWithCause(Class<X> cls, Throwable th) {
        Iterator it = preferringStrings(Arrays.asList(cls.getConstructors())).iterator();
        while (it.hasNext()) {
            X x3 = (X) newFromConstructor((Constructor) it.next(), th);
            if (x3 != null) {
                if (x3.getCause() == null) {
                    x3.initCause(th);
                }
                return x3;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + cls + " in response to chained exception", th);
    }

    private static <X extends Exception> List<Constructor<X>> preferringStrings(List<Constructor<X>> list) {
        return (List<Constructor<X>>) WITH_STRING_PARAM_FIRST.sortedCopy(list);
    }

    static GetCheckedTypeValidator weakSetValidator() {
        return GetCheckedTypeValidatorHolder.WeakSetValidator.INSTANCE;
    }

    private static <X extends Exception> void wrapAndThrowExceptionOrError(Throwable th, Class<X> cls) {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        if (!(th instanceof RuntimeException)) {
            throw newWithCause(cls, th);
        }
        throw new UncheckedExecutionException(th);
    }
}
