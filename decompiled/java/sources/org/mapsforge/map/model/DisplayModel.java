package org.mapsforge.map.model;

import org.mapsforge.core.graphics.Filter;
import org.mapsforge.map.model.common.Observable;
import org.mapsforge.map.rendertheme.ThemeCallback;

/* loaded from: /root/release/classes2.dex */
public class DisplayModel extends Observable {
    private static final int DEFAULT_BACKGROUND_COLOR = -1118482;
    private static final int DEFAULT_MAX_TEXT_WIDTH = 179;
    private static final float DEFAULT_MAX_TEXT_WIDTH_FACTOR = 0.7f;
    private static final int DEFAULT_TILE_SIZE = 256;
    private static float defaultUserScaleFactor = 1.0f;
    private static float deviceScaleFactor = 1.0f;
    private int fixedTileSize;
    private ThemeCallback themeCallback;
    private int backgroundColor = DEFAULT_BACKGROUND_COLOR;
    private Filter filter = Filter.NONE;
    private int maxTextWidth = DEFAULT_MAX_TEXT_WIDTH;
    private float maxTextWidthFactor = DEFAULT_MAX_TEXT_WIDTH_FACTOR;
    private int tileSize = 256;
    private int tileSizeMultiple = 64;
    private float userScaleFactor = defaultUserScaleFactor;

    public DisplayModel() {
        setTileSize();
    }

    public static synchronized float getDefaultUserScaleFactor() {
        float f3;
        synchronized (DisplayModel.class) {
            f3 = defaultUserScaleFactor;
        }
        return f3;
    }

    public static synchronized float getDeviceScaleFactor() {
        float f3;
        synchronized (DisplayModel.class) {
            f3 = deviceScaleFactor;
        }
        return f3;
    }

    public static synchronized void setDefaultUserScaleFactor(float f3) {
        synchronized (DisplayModel.class) {
            defaultUserScaleFactor = f3;
        }
    }

    public static synchronized void setDeviceScaleFactor(float f3) {
        synchronized (DisplayModel.class) {
            deviceScaleFactor = f3;
        }
    }

    private void setMaxTextWidth() {
        this.maxTextWidth = (int) (this.tileSize * this.maxTextWidthFactor);
    }

    private void setTileSize() {
        int i3 = this.fixedTileSize;
        if (i3 == 0) {
            float f3 = deviceScaleFactor * 256.0f * this.userScaleFactor;
            int i4 = this.tileSizeMultiple;
            i3 = Math.max(i4, Math.round(f3 / i4) * this.tileSizeMultiple);
        }
        this.tileSize = i3;
        setMaxTextWidth();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DisplayModel)) {
            return false;
        }
        DisplayModel displayModel = (DisplayModel) obj;
        return this.backgroundColor == displayModel.backgroundColor && this.filter == displayModel.filter && this.fixedTileSize == displayModel.fixedTileSize && this.maxTextWidth == displayModel.maxTextWidth && Float.floatToIntBits(this.maxTextWidthFactor) == Float.floatToIntBits(displayModel.maxTextWidthFactor) && this.tileSize == displayModel.tileSize && this.tileSizeMultiple == displayModel.tileSizeMultiple && Float.floatToIntBits(this.userScaleFactor) == Float.floatToIntBits(displayModel.userScaleFactor);
    }

    public synchronized int getBackgroundColor() {
        return this.backgroundColor;
    }

    public synchronized Filter getFilter() {
        return this.filter;
    }

    public int getMaxTextWidth() {
        return this.maxTextWidth;
    }

    public synchronized float getScaleFactor() {
        return deviceScaleFactor * this.userScaleFactor;
    }

    public synchronized ThemeCallback getThemeCallback() {
        return this.themeCallback;
    }

    public synchronized int getTileSize() {
        return this.tileSize;
    }

    public synchronized int getTileSizeMultiple() {
        return this.tileSizeMultiple;
    }

    public synchronized float getUserScaleFactor() {
        return this.userScaleFactor;
    }

    public int hashCode() {
        return ((((((((((((((this.backgroundColor + 31) * 31) + this.filter.hashCode()) * 31) + this.fixedTileSize) * 31) + this.maxTextWidth) * 31) + Float.floatToIntBits(this.maxTextWidthFactor)) * 31) + this.tileSize) * 31) + this.tileSizeMultiple) * 31) + Float.floatToIntBits(this.userScaleFactor);
    }

    public synchronized void setBackgroundColor(int i3) {
        this.backgroundColor = i3;
    }

    public synchronized void setFilter(Filter filter) {
        this.filter = filter;
    }

    public void setFixedTileSize(int i3) {
        this.fixedTileSize = i3;
        setTileSize();
    }

    public void setMaxTextWidthFactor(float f3) {
        this.maxTextWidthFactor = f3;
        setMaxTextWidth();
    }

    public synchronized void setThemeCallback(ThemeCallback themeCallback) {
        this.themeCallback = themeCallback;
    }

    public synchronized void setTileSizeMultiple(int i3) {
        this.tileSizeMultiple = i3;
        setTileSize();
    }

    public synchronized void setUserScaleFactor(float f3) {
        this.userScaleFactor = f3;
        setTileSize();
    }
}
