package org.mapsforge.core.model;

import java.io.Serializable;

/* loaded from: /root/release/classes2.dex */
public class Dimension implements Serializable {
    private static final long serialVersionUID = 1;
    public final int height;
    public final int width;

    public Dimension(int i3, int i4) {
        if (i3 < 0) {
            throw new IllegalArgumentException("width must not be negative: " + i3);
        }
        if (i4 >= 0) {
            this.width = i3;
            this.height = i4;
        } else {
            throw new IllegalArgumentException("height must not be negative: " + i4);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Dimension)) {
            return false;
        }
        Dimension dimension = (Dimension) obj;
        return this.width == dimension.width && this.height == dimension.height;
    }

    public Point getCenter() {
        return new Point(this.width / 2.0f, this.height / 2.0f);
    }

    public int hashCode() {
        return ((this.width + 31) * 31) + this.height;
    }

    public String toString() {
        return "width=" + this.width + ", height=" + this.height;
    }
}
