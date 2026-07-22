package org.mapsforge.map.rendertheme;

import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.Display;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Position;
import org.mapsforge.map.datastore.PointOfInterest;
import org.mapsforge.map.layer.renderer.PolylineContainer;

/* loaded from: /root/release/classes2.dex */
public interface RenderCallback {
    void renderArea(RenderContext renderContext, Paint paint, Paint paint2, int i3, PolylineContainer polylineContainer);

    void renderAreaCaption(RenderContext renderContext, Display display, int i3, String str, float f3, float f4, Paint paint, Paint paint2, Position position, int i4, PolylineContainer polylineContainer);

    void renderAreaSymbol(RenderContext renderContext, Display display, int i3, Bitmap bitmap, PolylineContainer polylineContainer);

    void renderPointOfInterestCaption(RenderContext renderContext, Display display, int i3, String str, float f3, float f4, Paint paint, Paint paint2, Position position, int i4, PointOfInterest pointOfInterest);

    void renderPointOfInterestCircle(RenderContext renderContext, float f3, Paint paint, Paint paint2, int i3, PointOfInterest pointOfInterest);

    void renderPointOfInterestSymbol(RenderContext renderContext, Display display, int i3, Bitmap bitmap, PointOfInterest pointOfInterest);

    void renderWay(RenderContext renderContext, Paint paint, float f3, int i3, PolylineContainer polylineContainer);

    void renderWaySymbol(RenderContext renderContext, Display display, int i3, Bitmap bitmap, float f3, boolean z3, boolean z4, float f4, float f5, boolean z5, PolylineContainer polylineContainer);

    void renderWayText(RenderContext renderContext, Display display, int i3, String str, float f3, Paint paint, Paint paint2, boolean z3, float f4, float f5, boolean z4, PolylineContainer polylineContainer);
}
