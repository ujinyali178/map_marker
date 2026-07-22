package org.mapsforge.map.android.view;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.Dimension;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Point;
import org.mapsforge.map.android.graphics.AndroidGraphicFactory;
import org.mapsforge.map.android.input.MapZoomControls;
import org.mapsforge.map.android.input.TouchGestureHandler;
import org.mapsforge.map.controller.FrameBufferController;
import org.mapsforge.map.controller.LayerManagerController;
import org.mapsforge.map.controller.MapViewController;
import org.mapsforge.map.layer.Layer;
import org.mapsforge.map.layer.LayerManager;
import org.mapsforge.map.layer.TileLayer;
import org.mapsforge.map.layer.labels.LabelStore;
import org.mapsforge.map.layer.renderer.TileRendererLayer;
import org.mapsforge.map.model.Model;
import org.mapsforge.map.model.common.Observer;
import org.mapsforge.map.scalebar.DefaultMapScaleBar;
import org.mapsforge.map.scalebar.MapScaleBar;
import org.mapsforge.map.util.MapPositionUtil;
import org.mapsforge.map.util.MapViewProjection;
import org.mapsforge.map.view.FpsCounter;
import org.mapsforge.map.view.FrameBuffer;
import org.mapsforge.map.view.FrameBufferHA2;
import org.mapsforge.map.view.InputListener;

/* loaded from: /root/release/classes2.dex */
public class MapView extends ViewGroup implements org.mapsforge.map.view.MapView, Observer {
    private static final GraphicFactory GRAPHIC_FACTORY = AndroidGraphicFactory.INSTANCE;
    private final FpsCounter fpsCounter;
    private final FrameBuffer frameBuffer;
    private final FrameBufferController frameBufferController;
    private final GestureDetector gestureDetector;
    private GestureDetector gestureDetectorExternal;
    private final List<InputListener> inputListeners;
    private final LayerManager layerManager;
    private final Handler layoutHandler;
    private MapScaleBar mapScaleBar;
    private final MapViewProjection mapViewProjection;
    private final MapZoomControls mapZoomControls;
    private final Model model;
    private final ScaleGestureDetector scaleGestureDetector;
    private final TouchGestureHandler touchGestureHandler;

    /* renamed from: org.mapsforge.map.android.view.MapView$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$map$android$view$MapView$LayoutParams$Alignment;

        static {
            int[] iArr = new int[LayoutParams.Alignment.values().length];
            $SwitchMap$org$mapsforge$map$android$view$MapView$LayoutParams$Alignment = iArr;
            try {
                iArr[LayoutParams.Alignment.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mapsforge$map$android$view$MapView$LayoutParams$Alignment[LayoutParams.Alignment.TOP_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mapsforge$map$android$view$MapView$LayoutParams$Alignment[LayoutParams.Alignment.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$mapsforge$map$android$view$MapView$LayoutParams$Alignment[LayoutParams.Alignment.CENTER_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$mapsforge$map$android$view$MapView$LayoutParams$Alignment[LayoutParams.Alignment.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$mapsforge$map$android$view$MapView$LayoutParams$Alignment[LayoutParams.Alignment.CENTER_RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$mapsforge$map$android$view$MapView$LayoutParams$Alignment[LayoutParams.Alignment.BOTTOM_LEFT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$mapsforge$map$android$view$MapView$LayoutParams$Alignment[LayoutParams.Alignment.BOTTOM_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$mapsforge$map$android$view$MapView$LayoutParams$Alignment[LayoutParams.Alignment.BOTTOM_RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        public Alignment alignment;
        public LatLong latLong;

        public enum Alignment {
            TOP_LEFT,
            TOP_CENTER,
            TOP_RIGHT,
            CENTER_LEFT,
            CENTER,
            CENTER_RIGHT,
            BOTTOM_LEFT,
            BOTTOM_CENTER,
            BOTTOM_RIGHT
        }

        public LayoutParams(int i3, int i4, LatLong latLong, Alignment alignment) {
            super(i3, i4);
            this.latLong = latLong;
            this.alignment = alignment;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.alignment = Alignment.BOTTOM_CENTER;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public MapView(Context context) {
        this(context, null);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inputListeners = new CopyOnWriteArrayList();
        this.layoutHandler = new Handler();
        setClickable(true);
        setDescendantFocusability(393216);
        setWillNotDraw(false);
        Model model = new Model();
        this.model = model;
        GraphicFactory graphicFactory = GRAPHIC_FACTORY;
        this.fpsCounter = new FpsCounter(graphicFactory, model.displayModel);
        FrameBufferHA2 frameBufferHA2 = new FrameBufferHA2(model.frameBufferModel, model.displayModel, graphicFactory);
        this.frameBuffer = frameBufferHA2;
        this.frameBufferController = FrameBufferController.create(frameBufferHA2, model);
        LayerManager layerManager = new LayerManager(this, model.mapViewPosition, graphicFactory);
        this.layerManager = layerManager;
        layerManager.start();
        LayerManagerController.create(layerManager, model);
        MapViewController.create(this, model);
        TouchGestureHandler touchGestureHandler = new TouchGestureHandler(this);
        this.touchGestureHandler = touchGestureHandler;
        this.gestureDetector = new GestureDetector(context, touchGestureHandler);
        this.scaleGestureDetector = new ScaleGestureDetector(context, touchGestureHandler);
        MapZoomControls mapZoomControls = new MapZoomControls(context, this);
        this.mapZoomControls = mapZoomControls;
        addView(mapZoomControls, new ViewGroup.LayoutParams(-2, -2));
        this.mapScaleBar = new DefaultMapScaleBar(model.mapViewPosition, model.mapViewDimension, graphicFactory, model.displayModel);
        this.mapViewProjection = new MapViewProjection(this);
        model.mapViewPosition.addObserver(this);
    }

    public void addInputListener(InputListener inputListener) {
        if (inputListener == null) {
            throw new IllegalArgumentException("listener must not be null");
        }
        if (!this.inputListeners.contains(inputListener)) {
            this.inputListeners.add(inputListener);
            return;
        }
        throw new IllegalArgumentException("listener is already registered: " + inputListener);
    }

    @Override // org.mapsforge.map.view.MapView
    public void addLayer(Layer layer) {
        this.layerManager.getLayers().add(layer);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // org.mapsforge.map.view.MapView
    public void destroy() {
        this.touchGestureHandler.destroy();
        this.layoutHandler.removeCallbacksAndMessages(null);
        this.layerManager.finish();
        this.frameBufferController.destroy();
        this.frameBuffer.destroy();
        MapScaleBar mapScaleBar = this.mapScaleBar;
        if (mapScaleBar != null) {
            mapScaleBar.destroy();
        }
        this.mapZoomControls.destroy();
        getModel().mapViewPosition.destroy();
    }

    @Override // org.mapsforge.map.view.MapView
    public void destroyAll() {
        LabelStore labelStore;
        Iterator<Layer> it = this.layerManager.getLayers().iterator();
        while (it.hasNext()) {
            Layer next = it.next();
            this.layerManager.getLayers().remove(next);
            next.onDestroy();
            if (next instanceof TileLayer) {
                ((TileLayer) next).getTileCache().destroy();
            }
            if ((next instanceof TileRendererLayer) && (labelStore = ((TileRendererLayer) next).getLabelStore()) != null) {
                labelStore.clear();
            }
        }
        destroy();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2, null, LayoutParams.Alignment.BOTTOM_CENTER);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // org.mapsforge.map.view.MapView
    public BoundingBox getBoundingBox() {
        return MapPositionUtil.getBoundingBox(this.model.mapViewPosition.getMapPosition(), getDimension(), this.model.displayModel.getTileSize());
    }

    @Override // org.mapsforge.map.view.MapView
    public Dimension getDimension() {
        return new Dimension(getWidth(), getHeight());
    }

    @Override // org.mapsforge.map.view.MapView
    public FpsCounter getFpsCounter() {
        return this.fpsCounter;
    }

    @Override // org.mapsforge.map.view.MapView
    public FrameBuffer getFrameBuffer() {
        return this.frameBuffer;
    }

    @Override // org.mapsforge.map.view.MapView
    public LayerManager getLayerManager() {
        return this.layerManager;
    }

    @Override // org.mapsforge.map.view.MapView
    public MapScaleBar getMapScaleBar() {
        return this.mapScaleBar;
    }

    @Override // org.mapsforge.map.view.MapView
    public MapViewProjection getMapViewProjection() {
        return this.mapViewProjection;
    }

    public MapZoomControls getMapZoomControls() {
        return this.mapZoomControls;
    }

    @Override // org.mapsforge.map.view.MapView
    public Model getModel() {
        return this.model;
    }

    public TouchGestureHandler getTouchGestureHandler() {
        return this.touchGestureHandler;
    }

    @Override // org.mapsforge.map.model.common.Observer
    public void onChange() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (!getChildAt(i3).equals(this.mapZoomControls)) {
                this.layoutHandler.post(new Runnable() { // from class: org.mapsforge.map.android.view.MapView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MapView.this.requestLayout();
                    }
                });
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        org.mapsforge.core.graphics.Canvas createGraphicContext = AndroidGraphicFactory.createGraphicContext(canvas);
        this.frameBuffer.draw(createGraphicContext);
        MapScaleBar mapScaleBar = this.mapScaleBar;
        if (mapScaleBar != null) {
            mapScaleBar.draw(createGraphicContext);
        }
        this.fpsCounter.draw(createGraphicContext);
        createGraphicContext.destroy();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        if (this.mapZoomControls.getVisibility() != 8) {
            int zoomControlsGravity = this.mapZoomControls.getZoomControlsGravity();
            int measuredWidth = this.mapZoomControls.getMeasuredWidth();
            int measuredHeight = this.mapZoomControls.getMeasuredHeight();
            int i7 = zoomControlsGravity & 7;
            if (i7 == 1) {
                i3 += ((i5 - i3) - measuredWidth) / 2;
            } else if (i7 != 3) {
                i3 = i5 - measuredWidth;
            }
            int i8 = zoomControlsGravity & 112;
            if (i8 == 16) {
                i4 += ((i6 - i4) - measuredHeight) / 2;
            } else if (i8 != 48) {
                i4 = i6 - measuredHeight;
            }
            this.mapZoomControls.layout(i3, i4, measuredWidth + i3, measuredHeight + i4);
        }
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (!childAt.equals(this.mapZoomControls) && childAt.getVisibility() != 8 && checkLayoutParams(childAt.getLayoutParams())) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth2 = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                Point pixels = this.mapViewProjection.toPixels(layoutParams.latLong);
                if (pixels != null) {
                    int paddingLeft = getPaddingLeft() + ((int) Math.round(pixels.f4076x));
                    int paddingTop = getPaddingTop() + ((int) Math.round(pixels.f4077y));
                    switch (AnonymousClass2.$SwitchMap$org$mapsforge$map$android$view$MapView$LayoutParams$Alignment[layoutParams.alignment.ordinal()]) {
                        case 2:
                            paddingLeft -= measuredWidth2 / 2;
                            break;
                        case 3:
                            paddingLeft -= measuredWidth2;
                            break;
                        case 4:
                            paddingTop -= measuredHeight2 / 2;
                            break;
                        case 5:
                            paddingLeft -= measuredWidth2 / 2;
                            paddingTop -= measuredHeight2 / 2;
                            break;
                        case 6:
                            paddingLeft -= measuredWidth2;
                            paddingTop -= measuredHeight2 / 2;
                            break;
                        case 7:
                            paddingTop -= measuredHeight2;
                            break;
                        case 8:
                            paddingLeft -= measuredWidth2 / 2;
                            paddingTop -= measuredHeight2;
                            break;
                        case 9:
                            paddingLeft -= measuredWidth2;
                            paddingTop -= measuredHeight2;
                            break;
                    }
                    childAt.layout(paddingLeft, paddingTop, measuredWidth2 + paddingLeft, measuredHeight2 + paddingTop);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        measureChildren(i3, i4);
        super.onMeasure(i3, i4);
    }

    public void onMoveEvent() {
        Iterator<InputListener> it = this.inputListeners.iterator();
        while (it.hasNext()) {
            it.next().onMoveEvent();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        this.model.mapViewDimension.setDimension(new Dimension(i3, i4));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isClickable()) {
            return false;
        }
        this.mapZoomControls.onMapViewTouchEvent(motionEvent);
        GestureDetector gestureDetector = this.gestureDetectorExternal;
        if (gestureDetector == null || !gestureDetector.onTouchEvent(motionEvent)) {
            return !this.scaleGestureDetector.isInProgress() ? this.gestureDetector.onTouchEvent(motionEvent) : this.scaleGestureDetector.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void onZoomEvent() {
        Iterator<InputListener> it = this.inputListeners.iterator();
        while (it.hasNext()) {
            it.next().onZoomEvent();
        }
    }

    public void removeInputListener(InputListener inputListener) {
        if (inputListener == null) {
            throw new IllegalArgumentException("listener must not be null");
        }
        if (this.inputListeners.contains(inputListener)) {
            this.inputListeners.remove(inputListener);
            return;
        }
        throw new IllegalArgumentException("listener is not registered: " + inputListener);
    }

    @Override // org.mapsforge.map.view.MapView
    public void repaint() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    public void setBuiltInZoomControls(boolean z3) {
        this.mapZoomControls.setShowMapZoomControls(z3);
    }

    @Override // org.mapsforge.map.view.MapView
    public void setCenter(LatLong latLong) {
        this.model.mapViewPosition.setCenter(latLong);
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.gestureDetectorExternal = gestureDetector;
    }

    @Override // org.mapsforge.map.view.MapView
    public void setMapScaleBar(MapScaleBar mapScaleBar) {
        MapScaleBar mapScaleBar2 = this.mapScaleBar;
        if (mapScaleBar2 != null) {
            mapScaleBar2.destroy();
        }
        this.mapScaleBar = mapScaleBar;
    }

    @Override // org.mapsforge.map.view.MapView
    public void setZoomLevel(byte b4) {
        this.model.mapViewPosition.setZoomLevel(b4);
    }

    @Override // org.mapsforge.map.view.MapView
    public void setZoomLevelMax(byte b4) {
        this.model.mapViewPosition.setZoomLevelMax(b4);
        this.mapZoomControls.setZoomLevelMax(b4);
    }

    @Override // org.mapsforge.map.view.MapView
    public void setZoomLevelMin(byte b4) {
        this.model.mapViewPosition.setZoomLevelMin(b4);
        this.mapZoomControls.setZoomLevelMin(b4);
    }
}
