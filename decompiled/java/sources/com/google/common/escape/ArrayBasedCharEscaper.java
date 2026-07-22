package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class ArrayBasedCharEscaper extends CharEscaper {
    private final char[][] replacements;
    private final int replacementsLength;
    private final char safeMax;
    private final char safeMin;

    protected ArrayBasedCharEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, char c3, char c4) {
        Preconditions.checkNotNull(arrayBasedEscaperMap);
        char[][] replacementArray = arrayBasedEscaperMap.getReplacementArray();
        this.replacements = replacementArray;
        this.replacementsLength = replacementArray.length;
        if (c4 < c3) {
            c4 = 0;
            c3 = 65535;
        }
        this.safeMin = c3;
        this.safeMax = c4;
    }

    protected ArrayBasedCharEscaper(Map<Character, String> map, char c3, char c4) {
        this(ArrayBasedEscaperMap.create(map), c3, c4);
    }

    @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
    public final String escape(String str) {
        Preconditions.checkNotNull(str);
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if ((charAt < this.replacementsLength && this.replacements[charAt] != null) || charAt > this.safeMax || charAt < this.safeMin) {
                return escapeSlow(str, i3);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.CharEscaper
    @CheckForNull
    protected final char[] escape(char c3) {
        char[] cArr;
        if (c3 < this.replacementsLength && (cArr = this.replacements[c3]) != null) {
            return cArr;
        }
        if (c3 < this.safeMin || c3 > this.safeMax) {
            return escapeUnsafe(c3);
        }
        return null;
    }

    @CheckForNull
    protected abstract char[] escapeUnsafe(char c3);
}
