package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class CharEscaperBuilder {
    private int max = -1;
    private final Map<Character, String> map = new HashMap();

    private static class CharArrayDecorator extends CharEscaper {
        private final int replaceLength;
        private final char[][] replacements;

        CharArrayDecorator(char[][] cArr) {
            this.replacements = cArr;
            this.replaceLength = cArr.length;
        }

        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String escape(String str) {
            int length = str.length();
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                char[][] cArr = this.replacements;
                if (charAt < cArr.length && cArr[charAt] != null) {
                    return escapeSlow(str, i3);
                }
            }
            return str;
        }

        @Override // com.google.common.escape.CharEscaper
        @CheckForNull
        protected char[] escape(char c3) {
            if (c3 < this.replaceLength) {
                return this.replacements[c3];
            }
            return null;
        }
    }

    public CharEscaperBuilder addEscape(char c3, String str) {
        this.map.put(Character.valueOf(c3), (String) Preconditions.checkNotNull(str));
        if (c3 > this.max) {
            this.max = c3;
        }
        return this;
    }

    public CharEscaperBuilder addEscapes(char[] cArr, String str) {
        Preconditions.checkNotNull(str);
        for (char c3 : cArr) {
            addEscape(c3, str);
        }
        return this;
    }

    public char[][] toArray() {
        char[][] cArr = new char[this.max + 1][];
        for (Map.Entry<Character, String> entry : this.map.entrySet()) {
            cArr[entry.getKey().charValue()] = entry.getValue().toCharArray();
        }
        return cArr;
    }

    public Escaper toEscaper() {
        return new CharArrayDecorator(toArray());
    }
}
