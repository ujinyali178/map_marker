package org.mapsforge.core.graphics;

import java.io.InputStream;
import org.mapsforge.core.mapelements.PointTextContainer;
import org.mapsforge.core.mapelements.SymbolContainer;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.Point;

/* loaded from: /root/release/classes2.dex */
public interface GraphicFactory {
    Bitmap createBitmap(int i3, int i4);

    Bitmap createBitmap(int i3, int i4, boolean z3);

    Canvas createCanvas();

    int createColor(int i3, int i4, int i5, int i6);

    int createColor(Color color);

    Matrix createMatrix();

    HillshadingBitmap createMonoBitmap(int i3, int i4, byte[] bArr, int i5, BoundingBox boundingBox);

    Paint createPaint();

    Paint createPaint(Paint paint);

    Path createPath();

    PointTextContainer createPointTextContainer(Point point, Display display, int i3, String str, Paint paint, Paint paint2, SymbolContainer symbolContainer, Position position, int i4);

    ResourceBitmap createResourceBitmap(InputStream inputStream, float f3, int i3, int i4, int i5, int i6);

    TileBitmap createTileBitmap(int i3, boolean z3);

    TileBitmap createTileBitmap(InputStream inputStream, int i3, boolean z3);

    InputStream platformSpecificSources(String str, String str2);

    ResourceBitmap renderSvg(InputStream inputStream, float f3, int i3, int i4, int i5, int i6);
}
