package org.mapsforge.core.mapelements;

import org.mapsforge.core.graphics.Display;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Position;
import org.mapsforge.core.model.Point;

/* loaded from: /root/release/classes2.dex */
public abstract class PointTextContainer extends MapElementContainer {
    public final boolean isVisible;
    public final int maxTextWidth;
    public final Paint paintBack;
    public final Paint paintFront;
    public final Position position;
    public final SymbolContainer symbolContainer;
    public final String text;
    public final int textHeight;
    public final int textWidth;

    protected PointTextContainer(Point point, Display display, int i3, String str, Paint paint, Paint paint2, SymbolContainer symbolContainer, Position position, int i4) {
        super(point, display, i3);
        int textHeight;
        this.maxTextWidth = i4;
        this.text = str;
        this.symbolContainer = symbolContainer;
        this.paintFront = paint;
        this.paintBack = paint2;
        this.position = position;
        if (paint2 != null) {
            this.textWidth = paint2.getTextWidth(str);
            textHeight = paint2.getTextHeight(str);
        } else {
            this.textWidth = paint.getTextWidth(str);
            textHeight = paint.getTextHeight(str);
        }
        this.textHeight = textHeight;
        this.isVisible = (paint.isTransparent() && (paint2 == null || paint2.isTransparent())) ? false : true;
    }

    @Override // org.mapsforge.core.mapelements.MapElementContainer
    public boolean clashesWith(MapElementContainer mapElementContainer) {
        if (super.clashesWith(mapElementContainer)) {
            return true;
        }
        if (!(mapElementContainer instanceof PointTextContainer)) {
            return false;
        }
        PointTextContainer pointTextContainer = (PointTextContainer) mapElementContainer;
        return this.text.equals(pointTextContainer.text) && this.xy.distance(pointTextContainer.xy) < 200.0d;
    }

    @Override // org.mapsforge.core.mapelements.MapElementContainer
    public boolean equals(Object obj) {
        return super.equals(obj) && (obj instanceof PointTextContainer) && this.text.equals(((PointTextContainer) obj).text);
    }

    @Override // org.mapsforge.core.mapelements.MapElementContainer
    public int hashCode() {
        return (super.hashCode() * 31) + this.text.hashCode();
    }

    @Override // org.mapsforge.core.mapelements.MapElementContainer
    public String toString() {
        return super.toString() + ", text=" + this.text;
    }
}
