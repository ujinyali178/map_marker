package org.mapsforge.map.rendertheme;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* loaded from: /root/release/classes2.dex */
public class ExternalRenderTheme implements XmlRenderTheme {
    private final long lastModifiedTime;
    private XmlRenderThemeMenuCallback menuCallback;
    private final File renderThemeFile;

    public ExternalRenderTheme(File file) {
        this(file, (XmlRenderThemeMenuCallback) null);
    }

    public ExternalRenderTheme(File file, XmlRenderThemeMenuCallback xmlRenderThemeMenuCallback) {
        if (!file.exists()) {
            throw new FileNotFoundException("file does not exist: " + file.getAbsolutePath());
        }
        if (!file.isFile()) {
            throw new FileNotFoundException("not a file: " + file.getAbsolutePath());
        }
        if (!file.canRead()) {
            throw new FileNotFoundException("cannot read file: " + file.getAbsolutePath());
        }
        long lastModified = file.lastModified();
        this.lastModifiedTime = lastModified;
        if (lastModified != 0) {
            this.renderThemeFile = file;
            this.menuCallback = xmlRenderThemeMenuCallback;
        } else {
            throw new FileNotFoundException("cannot read last modified time: " + file.getAbsolutePath());
        }
    }

    public ExternalRenderTheme(String str) {
        this(str, (XmlRenderThemeMenuCallback) null);
    }

    public ExternalRenderTheme(String str, XmlRenderThemeMenuCallback xmlRenderThemeMenuCallback) {
        this(new File(str), xmlRenderThemeMenuCallback);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExternalRenderTheme)) {
            return false;
        }
        ExternalRenderTheme externalRenderTheme = (ExternalRenderTheme) obj;
        if (this.lastModifiedTime != externalRenderTheme.lastModifiedTime) {
            return false;
        }
        File file = this.renderThemeFile;
        File file2 = externalRenderTheme.renderThemeFile;
        if (file == null) {
            if (file2 != null) {
                return false;
            }
        } else if (!file.equals(file2)) {
            return false;
        }
        return true;
    }

    @Override // org.mapsforge.map.rendertheme.XmlRenderTheme
    public XmlRenderThemeMenuCallback getMenuCallback() {
        return this.menuCallback;
    }

    @Override // org.mapsforge.map.rendertheme.XmlRenderTheme
    public String getRelativePathPrefix() {
        return this.renderThemeFile.getParent();
    }

    @Override // org.mapsforge.map.rendertheme.XmlRenderTheme
    public InputStream getRenderThemeAsStream() {
        return new FileInputStream(this.renderThemeFile);
    }

    public int hashCode() {
        long j3 = this.lastModifiedTime;
        int i3 = (((int) (j3 ^ (j3 >>> 32))) + 31) * 31;
        File file = this.renderThemeFile;
        return i3 + (file == null ? 0 : file.hashCode());
    }

    @Override // org.mapsforge.map.rendertheme.XmlRenderTheme
    public void setMenuCallback(XmlRenderThemeMenuCallback xmlRenderThemeMenuCallback) {
        this.menuCallback = xmlRenderThemeMenuCallback;
    }
}
