package com.google.common.xml;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public class XmlEscapers {
    private static final char MAX_ASCII_CONTROL_CHAR = 31;
    private static final char MIN_ASCII_CONTROL_CHAR = 0;
    private static final Escaper XML_ATTRIBUTE_ESCAPER;
    private static final Escaper XML_CONTENT_ESCAPER;
    private static final Escaper XML_ESCAPER;

    static {
        Escapers.Builder builder = Escapers.builder();
        builder.setSafeRange((char) 0, (char) 65533);
        builder.setUnsafeReplacement("�");
        for (char c3 = 0; c3 <= 31; c3 = (char) (c3 + 1)) {
            if (c3 != '\t' && c3 != '\n' && c3 != '\r') {
                builder.addEscape(c3, "�");
            }
        }
        builder.addEscape('&', "&amp;");
        builder.addEscape('<', "&lt;");
        builder.addEscape('>', "&gt;");
        XML_CONTENT_ESCAPER = builder.build();
        builder.addEscape('\'', "&apos;");
        builder.addEscape('\"', "&quot;");
        XML_ESCAPER = builder.build();
        builder.addEscape('\t', "&#x9;");
        builder.addEscape('\n', "&#xA;");
        builder.addEscape('\r', "&#xD;");
        XML_ATTRIBUTE_ESCAPER = builder.build();
    }

    private XmlEscapers() {
    }

    public static Escaper xmlAttributeEscaper() {
        return XML_ATTRIBUTE_ESCAPER;
    }

    public static Escaper xmlContentEscaper() {
        return XML_CONTENT_ESCAPER;
    }
}
