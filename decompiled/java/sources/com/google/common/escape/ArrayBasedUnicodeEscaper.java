package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class ArrayBasedUnicodeEscaper extends UnicodeEscaper {
    private final char[][] replacements;
    private final int replacementsLength;
    private final int safeMax;
    private final char safeMaxChar;
    private final int safeMin;
    private final char safeMinChar;

    protected ArrayBasedUnicodeEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, int i3, int i4, String str) {
        char min;
        Preconditions.checkNotNull(arrayBasedEscaperMap);
        char[][] replacementArray = arrayBasedEscaperMap.getReplacementArray();
        this.replacements = replacementArray;
        this.replacementsLength = replacementArray.length;
        if (i4 < i3) {
            i4 = -1;
            i3 = Integer.MAX_VALUE;
        }
        this.safeMin = i3;
        this.safeMax = i4;
        if (i3 >= 55296) {
            this.safeMinChar = (char) 65535;
            min = 0;
        } else {
            this.safeMinChar = (char) i3;
            min = (char) Math.min(i4, 55295);
        }
        this.safeMaxChar = min;
    }

    protected ArrayBasedUnicodeEscaper(Map<Character, String> map, int i3, int i4, String str) {
        this(ArrayBasedEscaperMap.create(map), i3, i4, str);
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public final String escape(String str) {
        Preconditions.checkNotNull(str);
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if ((charAt < this.replacementsLength && this.replacements[charAt] != null) || charAt > this.safeMaxChar || charAt < this.safeMinChar) {
                return escapeSlow(str, i3);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    @CheckForNull
    protected final char[] escape(int i3) {
        char[] cArr;
        if (i3 < this.replacementsLength && (cArr = this.replacements[i3]) != null) {
            return cArr;
        }
        if (i3 < this.safeMin || i3 > this.safeMax) {
            return escapeUnsafe(i3);
        }
        return null;
    }

    @CheckForNull
    protected abstract char[] escapeUnsafe(int i3);

    @Override // com.google.common.escape.UnicodeEscaper
    protected final int nextEscapeIndex(CharSequence charSequence, int i3, int i4) {
        while (i3 < i4) {
            char charAt = charSequence.charAt(i3);
            if ((charAt < this.replacementsLength && this.replacements[charAt] != null) || charAt > this.safeMaxChar || charAt < this.safeMinChar) {
                break;
            }
            i3++;
        }
        return i3;
    }
}
