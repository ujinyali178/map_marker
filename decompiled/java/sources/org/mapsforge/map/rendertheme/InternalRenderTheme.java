package org.mapsforge.map.rendertheme;

import java.io.InputStream;

/* loaded from: /root/release/classes2.dex */
public enum InternalRenderTheme implements XmlRenderTheme {
    DEFAULT("/assets/mapsforge/default.xml"),
    OSMARENDER("/assets/mapsforge/osmarender.xml");

    private final String path;

    InternalRenderTheme(String str) {
        this.path = str;
    }

    @Override // org.mapsforge.map.rendertheme.XmlRenderTheme
    public XmlRenderThemeMenuCallback getMenuCallback() {
        return null;
    }

    @Override // org.mapsforge.map.rendertheme.XmlRenderTheme
    public String getRelativePathPrefix() {
        return "/assets/";
    }

    @Override // org.mapsforge.map.rendertheme.XmlRenderTheme
    public InputStream getRenderThemeAsStream() {
        return InternalRenderTheme.class.getResourceAsStream(this.path);
    }

    @Override // org.mapsforge.map.rendertheme.XmlRenderTheme
    public void setMenuCallback(XmlRenderThemeMenuCallback xmlRenderThemeMenuCallback) {
    }
}
