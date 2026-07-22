package com.google.thirdparty.publicsuffix;

/* loaded from: /root/release/classes.dex */
public enum PublicSuffixType {
    PRIVATE(':', ','),
    REGISTRY('!', '?');

    private final char innerNodeCode;
    private final char leafNodeCode;

    PublicSuffixType(char c3, char c4) {
        this.innerNodeCode = c3;
        this.leafNodeCode = c4;
    }

    static PublicSuffixType fromCode(char c3) {
        for (PublicSuffixType publicSuffixType : values()) {
            if (publicSuffixType.getInnerNodeCode() == c3 || publicSuffixType.getLeafNodeCode() == c3) {
                return publicSuffixType;
            }
        }
        throw new IllegalArgumentException("No enum corresponding to given code: " + c3);
    }

    char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    char getLeafNodeCode() {
        return this.leafNodeCode;
    }
}
