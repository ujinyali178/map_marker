package com.google.common.base;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    private static String badElementIndex(int i3, int i4, String str) {
        if (i3 < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i3));
        }
        if (i4 >= 0) {
            return Strings.lenientFormat("%s (%s) must be less than size (%s)", str, Integer.valueOf(i3), Integer.valueOf(i4));
        }
        throw new IllegalArgumentException("negative size: " + i4);
    }

    private static String badPositionIndex(int i3, int i4, String str) {
        if (i3 < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i3));
        }
        if (i4 >= 0) {
            return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i3), Integer.valueOf(i4));
        }
        throw new IllegalArgumentException("negative size: " + i4);
    }

    private static String badPositionIndexes(int i3, int i4, int i5) {
        return (i3 < 0 || i3 > i5) ? badPositionIndex(i3, i5, "start index") : (i4 < 0 || i4 > i5) ? badPositionIndex(i4, i5, "end index") : Strings.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(i4), Integer.valueOf(i3));
    }

    public static void checkArgument(boolean z3) {
        if (!z3) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z3, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z3, String str, char c3) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c3)));
        }
    }

    public static void checkArgument(boolean z3, String str, char c3, char c4) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c3), Character.valueOf(c4)));
        }
    }

    public static void checkArgument(boolean z3, String str, char c3, int i3) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c3), Integer.valueOf(i3)));
        }
    }

    public static void checkArgument(boolean z3, String str, char c3, long j3) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c3), Long.valueOf(j3)));
        }
    }

    public static void checkArgument(boolean z3, String str, char c3, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c3), obj));
        }
    }

    public static void checkArgument(boolean z3, String str, int i3) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i3)));
        }
    }

    public static void checkArgument(boolean z3, String str, int i3, char c3) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i3), Character.valueOf(c3)));
        }
    }

    public static void checkArgument(boolean z3, String str, int i3, int i4) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i3), Integer.valueOf(i4)));
        }
    }

    public static void checkArgument(boolean z3, String str, int i3, long j3) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i3), Long.valueOf(j3)));
        }
    }

    public static void checkArgument(boolean z3, String str, int i3, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i3), obj));
        }
    }

    public static void checkArgument(boolean z3, String str, long j3) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j3)));
        }
    }

    public static void checkArgument(boolean z3, String str, long j3, char c3) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j3), Character.valueOf(c3)));
        }
    }

    public static void checkArgument(boolean z3, String str, long j3, int i3) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j3), Integer.valueOf(i3)));
        }
    }

    public static void checkArgument(boolean z3, String str, long j3, long j4) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j3), Long.valueOf(j4)));
        }
    }

    public static void checkArgument(boolean z3, String str, long j3, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j3), obj));
        }
    }

    public static void checkArgument(boolean z3, String str, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj));
        }
    }

    public static void checkArgument(boolean z3, String str, @CheckForNull Object obj, char c3) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Character.valueOf(c3)));
        }
    }

    public static void checkArgument(boolean z3, String str, @CheckForNull Object obj, int i3) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Integer.valueOf(i3)));
        }
    }

    public static void checkArgument(boolean z3, String str, @CheckForNull Object obj, long j3) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Long.valueOf(j3)));
        }
    }

    public static void checkArgument(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void checkArgument(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void checkArgument(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    public static void checkArgument(boolean z3, String str, @CheckForNull Object... objArr) {
        if (!z3) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, objArr));
        }
    }

    public static int checkElementIndex(int i3, int i4) {
        return checkElementIndex(i3, i4, "index");
    }

    public static int checkElementIndex(int i3, int i4, String str) {
        if (i3 < 0 || i3 >= i4) {
            throw new IndexOutOfBoundsException(badElementIndex(i3, i4, str));
        }
        return i3;
    }

    public static <T> T checkNotNull(@CheckForNull T t3) {
        t3.getClass();
        return t3;
    }

    public static <T> T checkNotNull(@CheckForNull T t3, @CheckForNull Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, char c3) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c3)));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, char c3, char c4) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c3), Character.valueOf(c4)));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, char c3, int i3) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c3), Integer.valueOf(i3)));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, char c3, long j3) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c3), Long.valueOf(j3)));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, char c3, @CheckForNull Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c3), obj));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, int i3) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i3)));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, int i3, char c3) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i3), Character.valueOf(c3)));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, int i3, int i4) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i3), Integer.valueOf(i4)));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, int i3, long j3) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i3), Long.valueOf(j3)));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, int i3, @CheckForNull Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i3), obj));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, long j3) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j3)));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, long j3, char c3) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j3), Character.valueOf(c3)));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, long j3, int i3) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j3), Integer.valueOf(i3)));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, long j3, long j4) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j3), Long.valueOf(j4)));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, long j3, @CheckForNull Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j3), obj));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, @CheckForNull Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, @CheckForNull Object obj, char c3) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Character.valueOf(c3)));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, @CheckForNull Object obj, int i3) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Integer.valueOf(i3)));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, @CheckForNull Object obj, long j3) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Long.valueOf(j3)));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
    }

    public static <T> T checkNotNull(@CheckForNull T t3, String str, @CheckForNull Object... objArr) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(Strings.lenientFormat(str, objArr));
    }

    public static int checkPositionIndex(int i3, int i4) {
        return checkPositionIndex(i3, i4, "index");
    }

    public static int checkPositionIndex(int i3, int i4, String str) {
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException(badPositionIndex(i3, i4, str));
        }
        return i3;
    }

    public static void checkPositionIndexes(int i3, int i4, int i5) {
        if (i3 < 0 || i4 < i3 || i4 > i5) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i3, i4, i5));
        }
    }

    public static void checkState(boolean z3) {
        if (!z3) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean z3, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkState(boolean z3, String str, char c3) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c3)));
        }
    }

    public static void checkState(boolean z3, String str, char c3, char c4) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c3), Character.valueOf(c4)));
        }
    }

    public static void checkState(boolean z3, String str, char c3, int i3) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c3), Integer.valueOf(i3)));
        }
    }

    public static void checkState(boolean z3, String str, char c3, long j3) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c3), Long.valueOf(j3)));
        }
    }

    public static void checkState(boolean z3, String str, char c3, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c3), obj));
        }
    }

    public static void checkState(boolean z3, String str, int i3) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i3)));
        }
    }

    public static void checkState(boolean z3, String str, int i3, char c3) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i3), Character.valueOf(c3)));
        }
    }

    public static void checkState(boolean z3, String str, int i3, int i4) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i3), Integer.valueOf(i4)));
        }
    }

    public static void checkState(boolean z3, String str, int i3, long j3) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i3), Long.valueOf(j3)));
        }
    }

    public static void checkState(boolean z3, String str, int i3, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i3), obj));
        }
    }

    public static void checkState(boolean z3, String str, long j3) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j3)));
        }
    }

    public static void checkState(boolean z3, String str, long j3, char c3) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j3), Character.valueOf(c3)));
        }
    }

    public static void checkState(boolean z3, String str, long j3, int i3) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j3), Integer.valueOf(i3)));
        }
    }

    public static void checkState(boolean z3, String str, long j3, long j4) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j3), Long.valueOf(j4)));
        }
    }

    public static void checkState(boolean z3, String str, long j3, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j3), obj));
        }
    }

    public static void checkState(boolean z3, String str, @CheckForNull Object obj) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj));
        }
    }

    public static void checkState(boolean z3, String str, @CheckForNull Object obj, char c3) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Character.valueOf(c3)));
        }
    }

    public static void checkState(boolean z3, String str, @CheckForNull Object obj, int i3) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Integer.valueOf(i3)));
        }
    }

    public static void checkState(boolean z3, String str, @CheckForNull Object obj, long j3) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Long.valueOf(j3)));
        }
    }

    public static void checkState(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void checkState(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void checkState(boolean z3, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    public static void checkState(boolean z3, @CheckForNull String str, @CheckForNull Object... objArr) {
        if (!z3) {
            throw new IllegalStateException(Strings.lenientFormat(str, objArr));
        }
    }
}
