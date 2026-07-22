package com.google.maps.android.geometry;

/* loaded from: /root/release/classes.dex */
public class Bounds {
    public final double maxX;
    public final double maxY;
    public final double midX;
    public final double midY;
    public final double minX;
    public final double minY;

    public Bounds(double d3, double d4, double d5, double d6) {
        this.minX = d3;
        this.minY = d5;
        this.maxX = d4;
        this.maxY = d6;
        this.midX = (d3 + d4) / 2.0d;
        this.midY = (d5 + d6) / 2.0d;
    }

    public boolean contains(double d3, double d4) {
        return this.minX <= d3 && d3 <= this.maxX && this.minY <= d4 && d4 <= this.maxY;
    }

    public boolean contains(Bounds bounds) {
        return bounds.minX >= this.minX && bounds.maxX <= this.maxX && bounds.minY >= this.minY && bounds.maxY <= this.maxY;
    }

    public boolean contains(Point point) {
        return contains(point.f2375x, point.f2376y);
    }

    public boolean intersects(double d3, double d4, double d5, double d6) {
        return d3 < this.maxX && this.minX < d4 && d5 < this.maxY && this.minY < d6;
    }

    public boolean intersects(Bounds bounds) {
        return intersects(bounds.minX, bounds.maxX, bounds.minY, bounds.maxY);
    }
}
