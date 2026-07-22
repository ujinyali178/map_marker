package org.mapsforge.map.rendertheme.renderinstruction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mapsforge.core.model.Tag;

/* loaded from: /root/release/classes2.dex */
final class TextKey {
    private static final Map<String, TextKey> TEXT_KEYS = new HashMap();
    private final String key;

    private TextKey(String str) {
        this.key = str;
    }

    static TextKey getInstance(String str) {
        Map<String, TextKey> map = TEXT_KEYS;
        TextKey textKey = map.get(str);
        if (textKey != null) {
            return textKey;
        }
        TextKey textKey2 = new TextKey(str);
        map.put(str, textKey2);
        return textKey2;
    }

    String getValue(List<Tag> list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.key.equals(list.get(i3).key)) {
                return list.get(i3).value;
            }
        }
        return null;
    }
}
