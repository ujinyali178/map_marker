package org.mapsforge.map.rendertheme;

import java.io.InputStream;

/* loaded from: /root/release/classes2.dex */
public interface XmlRenderTheme {
    XmlRenderThemeMenuCallback getMenuCallback();

    String getRelativePathPrefix();

    InputStream getRenderThemeAsStream();

    void setMenuCallback(XmlRenderThemeMenuCallback xmlRenderThemeMenuCallback);
}
