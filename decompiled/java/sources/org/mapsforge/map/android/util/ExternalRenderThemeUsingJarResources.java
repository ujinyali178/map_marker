package org.mapsforge.map.android.util;

import java.io.File;
import org.mapsforge.map.rendertheme.ExternalRenderTheme;

/* loaded from: /root/release/classes2.dex */
public class ExternalRenderThemeUsingJarResources extends ExternalRenderTheme {
    public ExternalRenderThemeUsingJarResources(File file) {
        super(file);
    }

    @Override // org.mapsforge.map.rendertheme.ExternalRenderTheme, org.mapsforge.map.rendertheme.XmlRenderTheme
    public String getRelativePathPrefix() {
        return "/assets/";
    }
}
