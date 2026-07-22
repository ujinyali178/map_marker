package org.mapsforge.map.layer.renderer;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.Filter;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.GraphicUtils;
import org.mapsforge.core.graphics.Matrix;
import org.mapsforge.core.graphics.Path;
import org.mapsforge.core.mapelements.MapElementContainer;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.model.Rectangle;
import org.mapsforge.core.model.Tile;
import org.mapsforge.map.rendertheme.RenderContext;

/* loaded from: /root/release/classes2.dex */
public class CanvasRasterer {
    private final Canvas canvas;
    private final Path path;
    private final Matrix symbolMatrix;

    /* renamed from: org.mapsforge.map.layer.renderer.CanvasRasterer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$map$layer$renderer$ShapeType;

        static {
            int[] iArr = new int[ShapeType.values().length];
            $SwitchMap$org$mapsforge$map$layer$renderer$ShapeType = iArr;
            try {
                iArr[ShapeType.CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mapsforge$map$layer$renderer$ShapeType[ShapeType.HILLSHADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mapsforge$map$layer$renderer$ShapeType[ShapeType.POLYLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public CanvasRasterer(GraphicFactory graphicFactory) {
        this.canvas = graphicFactory.createCanvas();
        this.path = graphicFactory.createPath();
        this.symbolMatrix = graphicFactory.createMatrix();
    }

    private void drawCircleContainer(ShapePaintContainer shapePaintContainer) {
        CircleContainer circleContainer = (CircleContainer) shapePaintContainer.shapeContainer;
        Point point = circleContainer.point;
        this.canvas.drawCircle((int) point.f4076x, (int) point.f4077y, (int) circleContainer.radius, shapePaintContainer.paint);
    }

    private void drawHillshading(HillshadingContainer hillshadingContainer) {
        this.canvas.shadeBitmap(hillshadingContainer.bitmap, hillshadingContainer.hillsRect, hillshadingContainer.tileRect, hillshadingContainer.magnitude);
    }

    private void drawPath(ShapePaintContainer shapePaintContainer, Point[][] pointArr, float f3) {
        this.path.clear();
        int length = pointArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            Point[] pointArr2 = pointArr[i3];
            if (f3 != BitmapDescriptorFactory.HUE_RED) {
                pointArr2 = RendererUtils.parallelPath(pointArr2, f3);
            }
            if (pointArr2.length >= 2) {
                Point point = pointArr2[0];
                this.path.moveTo((float) point.f4076x, (float) point.f4077y);
                for (int i4 = 1; i4 < pointArr2.length; i4++) {
                    Point point2 = pointArr2[i4];
                    this.path.lineTo((int) point2.f4076x, (int) point2.f4077y);
                }
            }
        }
        this.canvas.drawPath(this.path, shapePaintContainer.paint);
    }

    private void drawShapePaintContainer(ShapePaintContainer shapePaintContainer) {
        ShapeContainer shapeContainer = shapePaintContainer.shapeContainer;
        int i3 = AnonymousClass1.$SwitchMap$org$mapsforge$map$layer$renderer$ShapeType[shapeContainer.getShapeType().ordinal()];
        if (i3 == 1) {
            drawCircleContainer(shapePaintContainer);
        } else if (i3 == 2) {
            drawHillshading((HillshadingContainer) shapeContainer);
        } else {
            if (i3 != 3) {
                return;
            }
            drawPath(shapePaintContainer, ((PolylineContainer) shapeContainer).getCoordinatesRelativeToOrigin(), shapePaintContainer.dy);
        }
    }

    public void destroy() {
        this.canvas.destroy();
    }

    void drawMapElements(Set<MapElementContainer> set, Tile tile) {
        ArrayList arrayList = new ArrayList(set);
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((MapElementContainer) it.next()).draw(this.canvas, tile.getOrigin(), this.symbolMatrix, Filter.NONE);
        }
    }

    void drawWays(RenderContext renderContext) {
        int size = renderContext.ways.get(0).size();
        int size2 = renderContext.ways.size();
        for (int i3 = 0; i3 < size2; i3++) {
            List<List<ShapePaintContainer>> list = renderContext.ways.get(i3);
            for (int i4 = 0; i4 < size; i4++) {
                List<ShapePaintContainer> list2 = list.get(i4);
                for (int size3 = list2.size() - 1; size3 >= 0; size3--) {
                    drawShapePaintContainer(list2.get(size3));
                }
            }
        }
    }

    void fill(int i3) {
        if (GraphicUtils.getAlpha(i3) > 0) {
            this.canvas.fillColor(i3);
        }
    }

    void fillOutsideAreas(int i3, Rectangle rectangle) {
        this.canvas.setClipDifference((int) rectangle.left, (int) rectangle.top, (int) rectangle.getWidth(), (int) rectangle.getHeight());
        this.canvas.fillColor(i3);
        this.canvas.resetClip();
    }

    void fillOutsideAreas(Color color, Rectangle rectangle) {
        this.canvas.setClipDifference((int) rectangle.left, (int) rectangle.top, (int) rectangle.getWidth(), (int) rectangle.getHeight());
        this.canvas.fillColor(color);
        this.canvas.resetClip();
    }

    void setCanvasBitmap(Bitmap bitmap) {
        this.canvas.setBitmap(bitmap);
    }
}
