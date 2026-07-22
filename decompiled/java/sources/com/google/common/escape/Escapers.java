package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class Escapers {
    private static final Escaper NULL_ESCAPER = new CharEscaper() { // from class: com.google.common.escape.Escapers.1
        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String escape(String str) {
            return (String) Preconditions.checkNotNull(str);
        }

        @Override // com.google.common.escape.CharEscaper
        @CheckForNull
        protected char[] escape(char c3) {
            return null;
        }
    };

    public static final class Builder {
        private final Map<Character, String> replacementMap;
        private char safeMax;
        private char safeMin;

        @CheckForNull
        private String unsafeReplacement;

        private Builder() {
            this.replacementMap = new HashMap();
            this.safeMin = (char) 0;
            this.safeMax = (char) 65535;
            this.unsafeReplacement = null;
        }

        public Builder addEscape(char c3, String str) {
            Preconditions.checkNotNull(str);
            this.replacementMap.put(Character.valueOf(c3), str);
            return this;
        }

        public Escaper build() {
            return new ArrayBasedCharEscaper(this.replacementMap, this.safeMin, this.safeMax) { // from class: com.google.common.escape.Escapers.Builder.1

                @CheckForNull
                private final char[] replacementChars;

                {
                    this.replacementChars = Builder.this.unsafeReplacement != null ? Builder.this.unsafeReplacement.toCharArray() : null;
                }

                @Override // com.google.common.escape.ArrayBasedCharEscaper
                @CheckForNull
                protected char[] escapeUnsafe(char c3) {
                    return this.replacementChars;
                }
            };
        }

        public Builder setSafeRange(char c3, char c4) {
            this.safeMin = c3;
            this.safeMax = c4;
            return this;
        }

        public Builder setUnsafeReplacement(String str) {
            this.unsafeReplacement = str;
            return this;
        }
    }

    private Escapers() {
    }

    static UnicodeEscaper asUnicodeEscaper(Escaper escaper) {
        Preconditions.checkNotNull(escaper);
        if (escaper instanceof UnicodeEscaper) {
            return (UnicodeEscaper) escaper;
        }
        if (escaper instanceof CharEscaper) {
            return wrap((CharEscaper) escaper);
        }
        throw new IllegalArgumentException("Cannot create a UnicodeEscaper from: " + escaper.getClass().getName());
    }

    public static Builder builder() {
        return new Builder();
    }

    @CheckForNull
    public static String computeReplacement(CharEscaper charEscaper, char c3) {
        return stringOrNull(charEscaper.escape(c3));
    }

    @CheckForNull
    public static String computeReplacement(UnicodeEscaper unicodeEscaper, int i3) {
        return stringOrNull(unicodeEscaper.escape(i3));
    }

    public static Escaper nullEscaper() {
        return NULL_ESCAPER;
    }

    @CheckForNull
    private static String stringOrNull(@CheckForNull char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    private static UnicodeEscaper wrap(final CharEscaper charEscaper) {
        return new UnicodeEscaper() { // from class: com.google.common.escape.Escapers.2
            @Override // com.google.common.escape.UnicodeEscaper
            @CheckForNull
            protected char[] escape(int i3) {
                if (i3 < 65536) {
                    return CharEscaper.this.escape((char) i3);
                }
                char[] cArr = new char[2];
                Character.toChars(i3, cArr, 0);
                char[] escape = CharEscaper.this.escape(cArr[0]);
                char[] escape2 = CharEscaper.this.escape(cArr[1]);
                if (escape == null && escape2 == null) {
                    return null;
                }
                int length = escape != null ? escape.length : 1;
                char[] cArr2 = new char[(escape2 != null ? escape2.length : 1) + length];
                if (escape != null) {
                    for (int i4 = 0; i4 < escape.length; i4++) {
                        cArr2[i4] = escape[i4];
                    }
                } else {
                    cArr2[0] = cArr[0];
                }
                if (escape2 != null) {
                    for (int i5 = 0; i5 < escape2.length; i5++) {
                        cArr2[length + i5] = escape2[i5];
                    }
                } else {
                    cArr2[length] = cArr[1];
                }
                return cArr2;
            }
        };
    }
}
