package org.mapsforge.map.rendertheme;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /root/release/classes2.dex */
public class XmlRenderThemeStyleMenu implements Serializable {
    private static final long serialVersionUID = 1;
    private final String defaultLanguage;
    private final String defaultValue;
    private final String id;
    private final Map<String, XmlRenderThemeStyleLayer> layers = new LinkedHashMap();

    public XmlRenderThemeStyleMenu(String str, String str2, String str3) {
        this.defaultLanguage = str2;
        this.defaultValue = str3;
        this.id = str;
    }

    public XmlRenderThemeStyleLayer createLayer(String str, boolean z3, boolean z4) {
        XmlRenderThemeStyleLayer xmlRenderThemeStyleLayer = new XmlRenderThemeStyleLayer(str, z3, z4, this.defaultLanguage);
        this.layers.put(str, xmlRenderThemeStyleLayer);
        return xmlRenderThemeStyleLayer;
    }

    public String getDefaultLanguage() {
        return this.defaultLanguage;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public String getId() {
        return this.id;
    }

    public XmlRenderThemeStyleLayer getLayer(String str) {
        return this.layers.get(str);
    }

    public Map<String, XmlRenderThemeStyleLayer> getLayers() {
        return this.layers;
    }
}
