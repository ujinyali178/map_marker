package org.mapsforge.core.model;

import java.io.Serializable;

/* loaded from: /root/release/classes2.dex */
public class Point implements Comparable<Point>, Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: x, reason: collision with root package name */
    public final double f4076x;

    /* renamed from: y, reason: collision with root package name */
    public final double f4077y;

    public Point(double d3, double d4) {
        this.f4076x = d3;
        this.f4077y = d4;
    }

    @Override // java.lang.Comparable
    public int compareTo(Point point) {
        double d3 = this.f4076x;
        double d4 = point.f4076x;
        if (d3 > d4) {
            return 1;
        }
        if (d3 < d4) {
            return -1;
        }
        double d5 = this.f4077y;
        double d6 = point.f4077y;
        if (d5 > d6) {
            return 1;
        }
        return d5 < d6 ? -1 : 0;
    }

    public double distance(Point point) {
        return Math.hypot(this.f4076x - point.f4076x, this.f4077y - point.f4077y);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return Double.doubleToLongBits(this.f4076x) == Double.doubleToLongBits(point.f4076x) && Double.doubleToLongBits(this.f4077y) == Double.doubleToLongBits(point.f4077y);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f4076x);
        int i3 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f4077y);
        return (i3 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public Point offset(double d3, double d4) {
        return (0.0d == d3 && 0.0d == d4) ? this : new Point(this.f4076x + d3, this.f4077y + d4);
    }

    public String toString() {
        return "x=" + this.f4076x + ", y=" + this.f4077y;
    }
}
