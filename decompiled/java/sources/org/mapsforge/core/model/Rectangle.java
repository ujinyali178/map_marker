package org.mapsforge.core.model;

import java.io.Serializable;

/* loaded from: /root/release/classes2.dex */
public class Rectangle implements Serializable {
    private static final long serialVersionUID = 1;
    public final double bottom;
    public final double left;
    public final double right;
    public final double top;

    public Rectangle(double d3, double d4, double d5, double d6) {
        if (d3 > d5) {
            throw new IllegalArgumentException("left: " + d3 + ", right: " + d5);
        }
        if (d4 <= d6) {
            this.left = d3;
            this.top = d4;
            this.right = d5;
            this.bottom = d6;
            return;
        }
        throw new IllegalArgumentException("top: " + d4 + ", bottom: " + d6);
    }

    public boolean contains(Point point) {
        double d3 = this.left;
        double d4 = point.f4076x;
        if (d3 <= d4 && this.right >= d4) {
            double d5 = this.top;
            double d6 = point.f4077y;
            if (d5 <= d6 && this.bottom >= d6) {
                return true;
            }
        }
        return false;
    }

    public Rectangle enlarge(double d3, double d4, double d5, double d6) {
        return new Rectangle(this.left - d3, this.top - d4, this.right + d5, this.bottom + d6);
    }

    public Rectangle envelope(double d3) {
        return new Rectangle(this.left - d3, this.top - d3, this.right + d3, this.bottom + d3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rectangle)) {
            return false;
        }
        Rectangle rectangle = (Rectangle) obj;
        return Double.doubleToLongBits(this.left) == Double.doubleToLongBits(rectangle.left) && Double.doubleToLongBits(this.top) == Double.doubleToLongBits(rectangle.top) && Double.doubleToLongBits(this.right) == Double.doubleToLongBits(rectangle.right) && Double.doubleToLongBits(this.bottom) == Double.doubleToLongBits(rectangle.bottom);
    }

    public Point getCenter() {
        return new Point(getCenterX(), getCenterY());
    }

    public double getCenterX() {
        return (this.left + this.right) / 2.0d;
    }

    public double getCenterY() {
        return (this.top + this.bottom) / 2.0d;
    }

    public double getHeight() {
        return this.bottom - this.top;
    }

    public double getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.left);
        long doubleToLongBits2 = Double.doubleToLongBits(this.top);
        int i3 = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.right);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.bottom);
        return (i4 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
    }

    public boolean intersects(Rectangle rectangle) {
        if (this == rectangle) {
            return true;
        }
        return this.left <= rectangle.right && rectangle.left <= this.right && this.top <= rectangle.bottom && rectangle.top <= this.bottom;
    }

    public boolean intersectsCircle(double d3, double d4, double d5) {
        double width = getWidth() / 2.0d;
        double height = getHeight() / 2.0d;
        double abs = Math.abs(d3 - getCenterX());
        double abs2 = Math.abs(d4 - getCenterY());
        if (abs > width + d5 || abs2 > height + d5) {
            return false;
        }
        if (abs <= width || abs2 <= height) {
            return true;
        }
        double d6 = abs - width;
        double d7 = abs2 - height;
        return (d6 * d6) + (d7 * d7) <= d5 * d5;
    }

    public Rectangle shift(Point point) {
        double d3 = point.f4076x;
        if (d3 == 0.0d && point.f4077y == 0.0d) {
            return this;
        }
        double d4 = this.left + d3;
        double d5 = this.top;
        double d6 = point.f4077y;
        return new Rectangle(d4, d5 + d6, this.right + d3, this.bottom + d6);
    }

    public String toString() {
        return "left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom;
    }
}
