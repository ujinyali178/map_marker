package v2;

/* loaded from: /root/release/classes.dex */
class p extends o {
    public static final String b0(String str, int i3) {
        int c3;
        kotlin.jvm.internal.k.e(str, "<this>");
        if (i3 >= 0) {
            c3 = s2.f.c(i3, str.length());
            String substring = str.substring(c3);
            kotlin.jvm.internal.k.d(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i3 + " is less than zero.").toString());
    }
}
