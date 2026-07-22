package org.mapsforge.map.rendertheme;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /root/release/classes2.dex */
public class XmlRenderThemeStyleLayer implements Serializable {
    private static final long serialVersionUID = 1;
    private final String defaultLanguage;
    private final boolean enabled;
    private final String id;
    private final boolean visible;
    private final Map<String, String> titles = new HashMap();
    private final Set<String> categories = new LinkedHashSet();
    private final List<XmlRenderThemeStyleLayer> overlays = new ArrayList();

    XmlRenderThemeStyleLayer(String str, boolean z3, boolean z4, String str2) {
        this.id = str;
        this.visible = z3;
        this.defaultLanguage = str2;
        this.enabled = z4;
    }

    public void addCategory(String str) {
        this.categories.add(str);
    }

    public void addOverlay(XmlRenderThemeStyleLayer xmlRenderThemeStyleLayer) {
        this.overlays.add(xmlRenderThemeStyleLayer);
    }

    public void addTranslation(String str, String str2) {
        this.titles.put(str, str2);
    }

    public Set<String> getCategories() {
        return this.categories;
    }

    public String getId() {
        return this.id;
    }

    public List<XmlRenderThemeStyleLayer> getOverlays() {
        return this.overlays;
    }

    public String getTitle(String str) {
        String str2 = this.titles.get(str);
        return str2 == null ? this.titles.get(this.defaultLanguage) : str2;
    }

    public Map<String, String> getTitles() {
        return this.titles;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isVisible() {
        return this.visible;
    }
}
