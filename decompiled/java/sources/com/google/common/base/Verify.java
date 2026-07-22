package com.google.common.base;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class Verify {
    private Verify() {
    }

    public static void verify(boolean z3) {
        if (!z3) {
            throw new VerifyException();
        }
    }

    public static void verify(boolean z3, String str, char c3) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c3)));
        }
    }

    public static void verify(boolean z3, String str, char c3, char c4) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c3), Character.valueOf(c4)));
        }
    }

    public static void verify(boolean z3, String str, char c3, int i3) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c3), Integer.valueOf(i3)));
        }
    }

    public static void verify(boolean z3, String str, char c3, long j3) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c3), Long.valueOf(j3)));
        }
    }

    public static void verify(boolean z3, String str, char c3, @CheckForNull Object obj) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c3), obj));
        }
    }

    public static void verify(boolean z3, String str, int i3) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i3)));
        }
    }

    public static void verify(boolean z3, String str, int i3, char c3) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i3), Character.valueOf(c3)));
        }
    }

    public static void verify(boolean z3, String str, int i3, int i4) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i3), Integer.valueOf(i4)));
        }
    }

    public static void verify(boolean z3, String str, int i3, long j3) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i3), Long.valueOf(j3)));
        }
    }

    public static void verify(boolean z3, String str, int i3, @CheckForNull Object obj) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i3), obj));
        }
    }

    public static void verify(boolean z3, String str, long j3) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j3)));
        }
    }

    public static void verify(boolean z3, String str, long j3, char c3) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j3), Character.valueOf(c3)));
        }
    }

    public static void verify(boolean z3, String str, long j3, int i3) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j3), Integer.valueOf(i3)));
        }
    }

    public static void verify(boolean z3, String str, long j3, long j4) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j3), Long.valueOf(j4)));
        }
    }

    public static void verify(boolean z3, String str, long j3, @CheckForNull Object obj) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j3), obj));
        }
    }

    public static void verify(boolean z3, String str, @CheckForNull Object obj) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, obj));
        }
    }

    public static void verify(boolean z3, String str, @CheckForNull Object obj, char c3) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Character.valueOf(c3)));
        }
    }

    public static void verify(boolean z3, String str, @CheckForNull Object obj, int i3) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Integer.valueOf(i3)));
        }
    }

    public static void verify(boolean z3, String str, @CheckForNull Object obj, long j3) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Long.valueOf(j3)));
        }
    }

    public static void verify(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void verify(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void verify(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    public static void verify(boolean z3, String str, @CheckForNull Object... objArr) {
        if (!z3) {
            throw new VerifyException(Strings.lenientFormat(str, objArr));
        }
    }

    public static <T> T verifyNotNull(@CheckForNull T t3) {
        return (T) verifyNotNull(t3, "expected a non-null reference", new Object[0]);
    }

    public static <T> T verifyNotNull(@CheckForNull T t3, String str, @CheckForNull Object... objArr) {
        if (t3 != null) {
            return t3;
        }
        throw new VerifyException(Strings.lenientFormat(str, objArr));
    }
}
