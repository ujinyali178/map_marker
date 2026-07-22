package org.mapsforge.map.android.input;

import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.Scroller;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Point;
import org.mapsforge.map.android.view.MapView;
import org.mapsforge.map.layer.Layer;
import org.mapsforge.map.model.IMapViewPosition;

/* loaded from: /root/release/classes2.dex */
public class TouchGestureHandler extends GestureDetector.SimpleOnGestureListener implements ScaleGestureDetector.OnScaleGestureListener, Runnable {
    private int flingLastX;
    private int flingLastY;
    private final Scroller flinger;
    private float focusX;
    private float focusY;
    private boolean isInDoubleTap;
    private boolean isInScale;
    private final MapView mapView;
    private LatLong pivot;
    private float scaleFactorCumulative;
    private boolean doubleTapEnabled = true;
    private final Handler handler = new Handler();
    private boolean scaleEnabled = true;

    public TouchGestureHandler(MapView mapView) {
        this.mapView = mapView;
        this.flinger = new Scroller(mapView.getContext());
    }

    public void destroy() {
        this.handler.removeCallbacksAndMessages(null);
    }

    public boolean isDoubleTapEnabled() {
        return this.doubleTapEnabled;
    }

    public boolean isScaleEnabled() {
        return this.scaleEnabled;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        if (!this.scaleEnabled) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.isInDoubleTap = true;
        } else if (actionMasked == 1 && this.isInDoubleTap) {
            IMapViewPosition iMapViewPosition = this.mapView.getModel().mapViewPosition;
            if (this.doubleTapEnabled && iMapViewPosition.getZoomLevel() < iMapViewPosition.getZoomLevelMax()) {
                Point center = this.mapView.getModel().mapViewDimension.getDimension().getCenter();
                double d3 = 1;
                double x3 = (center.f4076x - motionEvent.getX()) / Math.pow(2.0d, d3);
                double y3 = (center.f4077y - motionEvent.getY()) / Math.pow(2.0d, d3);
                LatLong fromPixels = this.mapView.getMapViewProjection().fromPixels(motionEvent.getX(), motionEvent.getY());
                if (fromPixels != null) {
                    this.mapView.onMoveEvent();
                    this.mapView.onZoomEvent();
                    iMapViewPosition.setPivot(fromPixels);
                    iMapViewPosition.moveCenterAndZoom(x3, y3, (byte) 1);
                }
            }
            this.isInDoubleTap = false;
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.isInScale = false;
        this.flinger.forceFinished(true);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f3, float f4) {
        if (this.isInScale || motionEvent.getPointerCount() != 1 || motionEvent2.getPointerCount() != 1) {
            return false;
        }
        this.flinger.fling(0, 0, (int) (-f3), (int) (-f4), Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.flingLastY = 0;
        this.flingLastX = 0;
        this.handler.removeCallbacksAndMessages(null);
        this.handler.post(this);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.isInScale || this.isInDoubleTap) {
            return;
        }
        Point point = new Point(motionEvent.getX(), motionEvent.getY());
        LatLong fromPixels = this.mapView.getMapViewProjection().fromPixels(point.f4076x, point.f4077y);
        if (fromPixels != null) {
            for (int size = this.mapView.getLayerManager().getLayers().size() - 1; size >= 0; size--) {
                Layer layer = this.mapView.getLayerManager().getLayers().get(size);
                if (layer.onLongPress(fromPixels, this.mapView.getMapViewProjection().toPixels(layer.getPosition()), point)) {
                    return;
                }
            }
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        this.scaleFactorCumulative *= scaleGestureDetector.getScaleFactor();
        this.mapView.getModel().mapViewPosition.setPivot(this.pivot);
        this.mapView.getModel().mapViewPosition.setScaleFactorAdjustment(this.scaleFactorCumulative);
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        LatLong fromPixels;
        if (!this.scaleEnabled) {
            return false;
        }
        this.isInScale = true;
        this.scaleFactorCumulative = 1.0f;
        if (this.isInDoubleTap) {
            this.mapView.onZoomEvent();
            fromPixels = null;
        } else {
            this.mapView.onMoveEvent();
            this.mapView.onZoomEvent();
            this.focusX = scaleGestureDetector.getFocusX();
            this.focusY = scaleGestureDetector.getFocusY();
            fromPixels = this.mapView.getMapViewProjection().fromPixels(this.focusX, this.focusY);
        }
        this.pivot = fromPixels;
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        double d3;
        double log = Math.log(this.scaleFactorCumulative) / Math.log(2.0d);
        double d4 = 0.0d;
        if (Math.abs(log) > 1.0d) {
            log = log < 0.0d ? Math.floor(log) : Math.ceil(log);
        }
        byte round = (byte) Math.round(log);
        IMapViewPosition iMapViewPosition = this.mapView.getModel().mapViewPosition;
        if (round == 0 || this.pivot == null) {
            iMapViewPosition.zoom(round);
        } else {
            Point center = this.mapView.getModel().mapViewDimension.getDimension().getCenter();
            if (round > 0) {
                int i3 = 1;
                d3 = 0.0d;
                while (i3 <= round && iMapViewPosition.getZoomLevel() + i3 <= iMapViewPosition.getZoomLevelMax()) {
                    double d5 = i3;
                    double pow = d4 + ((center.f4076x - this.focusX) / Math.pow(2.0d, d5));
                    d3 += (center.f4077y - this.focusY) / Math.pow(2.0d, d5);
                    i3++;
                    d4 = pow;
                }
            } else {
                int i4 = -1;
                d3 = 0.0d;
                while (i4 >= round && iMapViewPosition.getZoomLevel() + i4 >= iMapViewPosition.getZoomLevelMin()) {
                    double d6 = i4 + 1;
                    double pow2 = d4 - ((center.f4076x - this.focusX) / Math.pow(2.0d, d6));
                    d3 -= (center.f4077y - this.focusY) / Math.pow(2.0d, d6);
                    i4--;
                    d4 = pow2;
                }
            }
            iMapViewPosition.setPivot(this.pivot);
            iMapViewPosition.moveCenterAndZoom(d4, d3, round);
        }
        this.isInDoubleTap = false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f3, float f4) {
        if (this.isInScale || motionEvent.getPointerCount() != 1 || motionEvent2.getPointerCount() != 1) {
            return false;
        }
        for (int size = this.mapView.getLayerManager().getLayers().size() - 1; size >= 0; size--) {
            if (this.mapView.getLayerManager().getLayers().get(size).onScroll(motionEvent.getX(), motionEvent.getY(), motionEvent2.getX(), motionEvent2.getY())) {
                return true;
            }
        }
        this.mapView.onMoveEvent();
        this.mapView.getModel().mapViewPosition.moveCenter(-f3, -f4, false);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Point point = new Point(motionEvent.getX(), motionEvent.getY());
        LatLong fromPixels = this.mapView.getMapViewProjection().fromPixels(point.f4076x, point.f4077y);
        if (fromPixels == null) {
            return false;
        }
        for (int size = this.mapView.getLayerManager().getLayers().size() - 1; size >= 0; size--) {
            Layer layer = this.mapView.getLayerManager().getLayers().get(size);
            if (layer.onTap(fromPixels, this.mapView.getMapViewProjection().toPixels(layer.getPosition()), point)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z3 = !this.flinger.isFinished() && this.flinger.computeScrollOffset();
        this.mapView.getModel().mapViewPosition.moveCenter(this.flingLastX - this.flinger.getCurrX(), this.flingLastY - this.flinger.getCurrY());
        this.flingLastX = this.flinger.getCurrX();
        this.flingLastY = this.flinger.getCurrY();
        if (z3) {
            this.handler.post(this);
        }
    }

    public void setDoubleTapEnabled(boolean z3) {
        this.doubleTapEnabled = z3;
    }

    public void setScaleEnabled(boolean z3) {
        this.scaleEnabled = z3;
    }
}
