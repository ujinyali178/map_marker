package org.mapsforge.core.mapelements;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.graphics.Display;
import org.mapsforge.core.graphics.Filter;
import org.mapsforge.core.graphics.Matrix;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.model.Rectangle;

/* loaded from: /root/release/classes2.dex */
public class SymbolContainer extends MapElementContainer {
    final boolean alignCenter;
    public Bitmap symbol;
    public final float theta;

    public SymbolContainer(Point point, Display display, int i3, Bitmap bitmap) {
        this(point, display, i3, bitmap, BitmapDescriptorFactory.HUE_RED, true);
    }

    public SymbolContainer(Point point, Display display, int i3, Bitmap bitmap, float f3, boolean z3) {
        super(point, display, i3);
        Rectangle rectangle;
        this.symbol = bitmap;
        this.theta = f3;
        this.alignCenter = z3;
        if (z3) {
            double width = bitmap.getWidth() / 2.0d;
            double height = this.symbol.getHeight() / 2.0d;
            rectangle = new Rectangle(-width, -height, width, height);
        } else {
            rectangle = new Rectangle(0.0d, 0.0d, bitmap.getWidth(), this.symbol.getHeight());
        }
        this.boundary = rectangle;
        this.symbol.incrementRefCount();
    }

    @Override // org.mapsforge.core.mapelements.MapElementContainer
    public void draw(Canvas canvas, Point point, Matrix matrix, Filter filter) {
        matrix.reset();
        double d3 = this.xy.f4076x - point.f4076x;
        Rectangle rectangle = this.boundary;
        matrix.translate((int) (d3 + rectangle.left), (int) ((r0.f4077y - point.f4077y) + rectangle.top));
        float f3 = this.theta;
        if (f3 == BitmapDescriptorFactory.HUE_RED || !this.alignCenter) {
            matrix.rotate(f3);
        } else {
            Rectangle rectangle2 = this.boundary;
            matrix.rotate(f3, (float) (-rectangle2.left), (float) (-rectangle2.top));
        }
        canvas.drawBitmap(this.symbol, matrix, 1.0f, filter);
    }

    @Override // org.mapsforge.core.mapelements.MapElementContainer
    public boolean equals(Object obj) {
        return super.equals(obj) && (obj instanceof SymbolContainer) && this.symbol == ((SymbolContainer) obj).symbol;
    }

    @Override // org.mapsforge.core.mapelements.MapElementContainer
    public int hashCode() {
        return (super.hashCode() * 31) + this.symbol.hashCode();
    }
}
