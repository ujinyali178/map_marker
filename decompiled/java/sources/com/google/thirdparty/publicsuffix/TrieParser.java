package com.google.thirdparty.publicsuffix;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Queues;
import java.util.Deque;

/* loaded from: /root/release/classes.dex */
final class TrieParser {
    private static final Joiner DIRECT_JOINER = Joiner.on("");

    TrieParser() {
    }

    private static int doParseTrieToBuilder(Deque<CharSequence> deque, CharSequence charSequence, int i3, ImmutableMap.Builder<String, PublicSuffixType> builder) {
        int length = charSequence.length();
        char c3 = 0;
        int i4 = i3;
        while (i4 < length && (c3 = charSequence.charAt(i4)) != '&' && c3 != '?' && c3 != '!' && c3 != ':' && c3 != ',') {
            i4++;
        }
        deque.push(reverse(charSequence.subSequence(i3, i4)));
        if (c3 == '!' || c3 == '?' || c3 == ':' || c3 == ',') {
            String join = DIRECT_JOINER.join(deque);
            if (join.length() > 0) {
                builder.put(join, PublicSuffixType.fromCode(c3));
            }
        }
        int i5 = i4 + 1;
        if (c3 != '?' && c3 != ',') {
            while (i5 < length) {
                i5 += doParseTrieToBuilder(deque, charSequence, i5, builder);
                if (charSequence.charAt(i5) == '?' || charSequence.charAt(i5) == ',') {
                    i5++;
                    break;
                }
            }
        }
        deque.pop();
        return i5 - i3;
    }

    static ImmutableMap<String, PublicSuffixType> parseFullString(String str) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            i3 += doParseTrieToBuilder(Queues.newArrayDeque(), str, i3, builder);
        }
        return builder.buildOrThrow();
    }

    static ImmutableMap<String, PublicSuffixType> parseTrie(CharSequence... charSequenceArr) {
        return parseFullString(DIRECT_JOINER.join(charSequenceArr));
    }

    private static CharSequence reverse(CharSequence charSequence) {
        return new StringBuilder(charSequence).reverse();
    }
}
