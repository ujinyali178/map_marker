package org.mapsforge.core.model;

import java.io.Serializable;

/* loaded from: /root/release/classes2.dex */
public class Tag implements Comparable<Tag>, Serializable {
    public static final char KEY_VALUE_SEPARATOR = '=';
    private static final long serialVersionUID = 1;
    public final String key;
    public final String value;

    public Tag(String str) {
        this(str, str.indexOf(61));
    }

    private Tag(String str, int i3) {
        this(str.substring(0, i3), str.substring(i3 + 1));
    }

    public Tag(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    @Override // java.lang.Comparable
    public int compareTo(Tag tag) {
        int compareTo = this.key.compareTo(tag.key);
        return compareTo != 0 ? compareTo : this.value.compareTo(tag.value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        String str = this.key;
        if (str == null) {
            if (tag.key != null) {
                return false;
            }
        } else {
            if (!str.equals(tag.key)) {
                return false;
            }
            String str2 = this.value;
            String str3 = tag.value;
            if (str2 == null) {
                if (str3 != null) {
                    return false;
                }
            } else if (!str2.equals(str3)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        String str = this.key;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.value;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "key=" + this.key + ", value=" + this.value;
    }
}
