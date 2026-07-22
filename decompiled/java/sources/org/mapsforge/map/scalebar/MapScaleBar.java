package org.mapsforge.map.scalebar;

import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.graphics.GraphicContext;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.model.MapPosition;
import org.mapsforge.core.util.MercatorProjection;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.model.IMapViewPosition;
import org.mapsforge.map.model.MapViewDimension;

/* loaded from: /root/release/classes2.dex */
public abstract class MapScaleBar {
    private static final ScaleBarPosition DEFAULT_SCALE_BAR_POSITION = ScaleBarPosition.BOTTOM_LEFT;
    private static final double LATITUDE_REDRAW_THRESHOLD = 0.2d;
    protected final DisplayModel displayModel;
    protected DistanceUnitAdapter distanceUnitAdapter;
    protected final GraphicFactory graphicFactory;
    protected final Bitmap mapScaleBitmap;
    protected final Canvas mapScaleCanvas;
    private final MapViewDimension mapViewDimension;
    private final IMapViewPosition mapViewPosition;
    private int marginHorizontal;
    private int marginVertical;
    protected MapPosition prevMapPosition;
    protected boolean redrawNeeded;
    protected final float scale;
    protected ScaleBarPosition scaleBarPosition;
    private boolean visible;

    /* renamed from: org.mapsforge.map.scalebar.MapScaleBar$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition;

        static {
            int[] iArr = new int[ScaleBarPosition.values().length];
            $SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition = iArr;
            try {
                iArr[ScaleBarPosition.BOTTOM_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition[ScaleBarPosition.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition[ScaleBarPosition.BOTTOM_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition[ScaleBarPosition.TOP_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition[ScaleBarPosition.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition[ScaleBarPosition.TOP_RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    protected static class ScaleBarLengthAndValue {
        public int scaleBarLength;
        public int scaleBarValue;

        public ScaleBarLengthAndValue(int i3, int i4) {
            this.scaleBarLength = i3;
            this.scaleBarValue = i4;
        }
    }

    public enum ScaleBarPosition {
        BOTTOM_CENTER,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP_CENTER,
        TOP_LEFT,
        TOP_RIGHT
    }

    public MapScaleBar(IMapViewPosition iMapViewPosition, MapViewDimension mapViewDimension, DisplayModel displayModel, GraphicFactory graphicFactory, int i3, int i4, float f3) {
        this.mapViewPosition = iMapViewPosition;
        this.mapViewDimension = mapViewDimension;
        this.displayModel = displayModel;
        this.graphicFactory = graphicFactory;
        Bitmap createBitmap = graphicFactory.createBitmap(i3, i4);
        this.mapScaleBitmap = createBitmap;
        this.scale = f3;
        this.scaleBarPosition = DEFAULT_SCALE_BAR_POSITION;
        Canvas createCanvas = graphicFactory.createCanvas();
        this.mapScaleCanvas = createCanvas;
        createCanvas.setBitmap(createBitmap);
        this.distanceUnitAdapter = MetricUnitAdapter.INSTANCE;
        this.visible = true;
        this.redrawNeeded = true;
    }

    private int calculatePositionLeft(int i3, int i4, int i5) {
        switch (AnonymousClass1.$SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition[this.scaleBarPosition.ordinal()]) {
            case 1:
            case 2:
                return this.marginHorizontal;
            case 3:
            case 4:
                return ((i4 - i3) - i5) / 2;
            case 5:
            case 6:
                return ((i4 - i3) - i5) - this.marginHorizontal;
            default:
                throw new IllegalArgumentException("unknown horizontal position: " + this.scaleBarPosition);
        }
    }

    private int calculatePositionTop(int i3, int i4, int i5) {
        switch (AnonymousClass1.$SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition[this.scaleBarPosition.ordinal()]) {
            case 1:
            case 3:
            case 5:
                return ((i4 - i3) - i5) - this.marginVertical;
            case 2:
            case 4:
            case 6:
                return this.marginVertical;
            default:
                throw new IllegalArgumentException("unknown vertical position: " + this.scaleBarPosition);
        }
    }

    protected ScaleBarLengthAndValue calculateScaleBarLengthAndValue() {
        return calculateScaleBarLengthAndValue(this.distanceUnitAdapter);
    }

    protected ScaleBarLengthAndValue calculateScaleBarLengthAndValue(DistanceUnitAdapter distanceUnitAdapter) {
        MapPosition mapPosition = this.mapViewPosition.getMapPosition();
        this.prevMapPosition = mapPosition;
        double calculateGroundResolution = MercatorProjection.calculateGroundResolution(mapPosition.latLong.latitude, MercatorProjection.getMapSize(mapPosition.zoomLevel, this.displayModel.getTileSize())) / distanceUnitAdapter.getMeterRatio();
        int[] scaleBarValues = distanceUnitAdapter.getScaleBarValues();
        int length = scaleBarValues.length;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            i4 = scaleBarValues[i5];
            i3 = (int) (i4 / calculateGroundResolution);
            if (i3 < this.mapScaleBitmap.getWidth() - (this.scale * 10.0f)) {
                break;
            }
        }
        return new ScaleBarLengthAndValue(i3, i4);
    }

    public void destroy() {
        this.mapScaleBitmap.decrementRefCount();
        this.mapScaleCanvas.destroy();
    }

    public void draw(GraphicContext graphicContext) {
        if (this.visible && this.mapViewDimension.getDimension() != null) {
            if (isRedrawNecessary()) {
                redraw(this.mapScaleCanvas);
                this.redrawNeeded = false;
            }
            graphicContext.drawBitmap(this.mapScaleBitmap, calculatePositionLeft(0, this.mapViewDimension.getDimension().width, this.mapScaleBitmap.getWidth()), calculatePositionTop(0, this.mapViewDimension.getDimension().height, this.mapScaleBitmap.getHeight()));
        }
    }

    public void drawScaleBar() {
        draw(this.mapScaleCanvas);
    }

    public DistanceUnitAdapter getDistanceUnitAdapter() {
        return this.distanceUnitAdapter;
    }

    public int getMarginHorizontal() {
        return this.marginHorizontal;
    }

    public int getMarginVertical() {
        return this.marginVertical;
    }

    public ScaleBarPosition getScaleBarPosition() {
        return this.scaleBarPosition;
    }

    protected boolean isRedrawNecessary() {
        if (this.redrawNeeded || this.prevMapPosition == null) {
            return true;
        }
        MapPosition mapPosition = this.mapViewPosition.getMapPosition();
        byte b4 = mapPosition.zoomLevel;
        MapPosition mapPosition2 = this.prevMapPosition;
        return b4 != mapPosition2.zoomLevel || Math.abs(mapPosition.latLong.latitude - mapPosition2.latLong.latitude) > LATITUDE_REDRAW_THRESHOLD;
    }

    public boolean isVisible() {
        return this.visible;
    }

    protected abstract void redraw(Canvas canvas);

    public void redrawScaleBar() {
        this.redrawNeeded = true;
    }

    public void setDistanceUnitAdapter(DistanceUnitAdapter distanceUnitAdapter) {
        if (distanceUnitAdapter == null) {
            throw new IllegalArgumentException("adapter must not be null");
        }
        this.distanceUnitAdapter = distanceUnitAdapter;
        this.redrawNeeded = true;
    }

    public void setMarginHorizontal(int i3) {
        if (this.marginHorizontal != i3) {
            this.marginHorizontal = i3;
            this.redrawNeeded = true;
        }
    }

    public void setMarginVertical(int i3) {
        if (this.marginVertical != i3) {
            this.marginVertical = i3;
            this.redrawNeeded = true;
        }
    }

    public void setScaleBarPosition(ScaleBarPosition scaleBarPosition) {
        if (this.scaleBarPosition != scaleBarPosition) {
            this.scaleBarPosition = scaleBarPosition;
            this.redrawNeeded = true;
        }
    }

    public void setVisible(boolean z3) {
        this.visible = z3;
    }
}
