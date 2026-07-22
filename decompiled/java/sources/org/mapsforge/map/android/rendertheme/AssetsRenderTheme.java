package org.mapsforge.map.android.rendertheme;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.InputStream;
import org.mapsforge.core.util.Utils;
import org.mapsforge.map.rendertheme.XmlRenderTheme;
import org.mapsforge.map.rendertheme.XmlRenderThemeMenuCallback;

/* loaded from: /root/release/classes2.dex */
public class AssetsRenderTheme implements XmlRenderTheme {
    private final String assetName;
    private final InputStream inputStream;
    private XmlRenderThemeMenuCallback menuCallback;
    private final String relativePathPrefix;

    public AssetsRenderTheme(Context context, String str, String str2) {
        this(context, str, str2, null);
    }

    public AssetsRenderTheme(Context context, String str, String str2, XmlRenderThemeMenuCallback xmlRenderThemeMenuCallback) {
        this.assetName = str2;
        this.relativePathPrefix = str;
        AssetManager assets = context.getAssets();
        StringBuilder sb = new StringBuilder();
        sb.append(TextUtils.isEmpty(str) ? "" : str);
        sb.append(str2);
        this.inputStream = assets.open(sb.toString());
        this.menuCallback = xmlRenderThemeMenuCallback;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AssetsRenderTheme)) {
            return false;
        }
        AssetsRenderTheme assetsRenderTheme = (AssetsRenderTheme) obj;
        return Utils.equals(this.assetName, assetsRenderTheme.assetName) && Utils.equals(this.relativePathPrefix, assetsRenderTheme.relativePathPrefix);
    }

    @Override // org.mapsforge.map.rendertheme.XmlRenderTheme
    public XmlRenderThemeMenuCallback getMenuCallback() {
        return this.menuCallback;
    }

    @Override // org.mapsforge.map.rendertheme.XmlRenderTheme
    public String getRelativePathPrefix() {
        return this.relativePathPrefix;
    }

    @Override // org.mapsforge.map.rendertheme.XmlRenderTheme
    public InputStream getRenderThemeAsStream() {
        return this.inputStream;
    }

    public int hashCode() {
        String str = this.assetName;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.relativePathPrefix;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // org.mapsforge.map.rendertheme.XmlRenderTheme
    public void setMenuCallback(XmlRenderThemeMenuCallback xmlRenderThemeMenuCallback) {
        this.menuCallback = xmlRenderThemeMenuCallback;
    }
}
