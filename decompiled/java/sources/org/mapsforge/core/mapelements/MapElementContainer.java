package org.mapsforge.core.mapelements;

import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.graphics.Display;
import org.mapsforge.core.graphics.Filter;
import org.mapsforge.core.graphics.Matrix;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.model.Rectangle;

/* loaded from: /root/release/classes2.dex */
public abstract class MapElementContainer implements Comparable<MapElementContainer> {
    protected Rectangle boundary;
    protected Rectangle boundaryAbsolute;
    protected Display display;
    protected final int priority;
    protected final Point xy;

    protected MapElementContainer(Point point, Display display, int i3) {
        this.xy = point;
        this.display = display;
        this.priority = i3;
    }

    public boolean clashesWith(MapElementContainer mapElementContainer) {
        Display display = Display.ALWAYS;
        if (display == this.display || display == mapElementContainer.display) {
            return false;
        }
        return getBoundaryAbsolute().intersects(mapElementContainer.getBoundaryAbsolute());
    }

    @Override // java.lang.Comparable
    public int compareTo(MapElementContainer mapElementContainer) {
        int i3 = this.priority;
        int i4 = mapElementContainer.priority;
        if (i3 < i4) {
            return -1;
        }
        return i3 > i4 ? 1 : 0;
    }

    public abstract void draw(Canvas canvas, Point point, Matrix matrix, Filter filter);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapElementContainer)) {
            return false;
        }
        MapElementContainer mapElementContainer = (MapElementContainer) obj;
        return this.priority == mapElementContainer.priority && this.xy.equals(mapElementContainer.xy);
    }

    protected Rectangle getBoundaryAbsolute() {
        if (this.boundaryAbsolute == null) {
            this.boundaryAbsolute = this.boundary.shift(this.xy);
        }
        return this.boundaryAbsolute;
    }

    public Point getPoint() {
        return this.xy;
    }

    public int getPriority() {
        return this.priority;
    }

    public int hashCode() {
        return ((217 + this.xy.hashCode()) * 31) + this.priority;
    }

    public boolean intersects(Rectangle rectangle) {
        return getBoundaryAbsolute().intersects(rectangle);
    }

    public String toString() {
        return "xy=" + this.xy + ", priority=" + this.priority;
    }
}
