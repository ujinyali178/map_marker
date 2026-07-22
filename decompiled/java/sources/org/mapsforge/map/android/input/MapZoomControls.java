package org.mapsforge.map.android.input;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.ZoomButton;
import android.widget.ZoomControls;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.mapsforge.map.android.util.AndroidUtil;
import org.mapsforge.map.android.view.MapView;
import org.mapsforge.map.model.common.Observer;

/* loaded from: /root/release/classes2.dex */
public class MapZoomControls extends LinearLayout implements Observer {
    private static final int DEFAULT_HORIZONTAL_MARGIN = 5;
    private static final int DEFAULT_VERTICAL_MARGIN = 0;
    private static final int DEFAULT_ZOOM_CONTROLS_GRAVITY = 85;
    private static final byte DEFAULT_ZOOM_LEVEL_MAX = 22;
    private static final byte DEFAULT_ZOOM_LEVEL_MIN = 0;
    private static final long DEFAULT_ZOOM_SPEED = 500;
    private static final int MSG_ZOOM_CONTROLS_HIDE = 0;
    private static final long ZOOM_CONTROLS_TIMEOUT = ViewConfiguration.getZoomControlsTimeout();
    private boolean autoHide;
    private final ZoomButton buttonZoomIn;
    private final ZoomButton buttonZoomOut;
    private final MapView mapView;
    private boolean showMapZoomControls;
    private int zoomControlsGravity;
    private final Handler zoomControlsHideHandler;
    private byte zoomLevelMax;
    private byte zoomLevelMin;

    public enum Orientation {
        HORIZONTAL_IN_OUT(0, true),
        HORIZONTAL_OUT_IN(0, false),
        VERTICAL_IN_OUT(1, true),
        VERTICAL_OUT_IN(1, false);

        public final int layoutOrientation;
        public final boolean zoomInFirst;

        Orientation(int i3, boolean z3) {
            this.layoutOrientation = i3;
            this.zoomInFirst = z3;
        }
    }

    public MapZoomControls(Context context, final MapView mapView) {
        super(context);
        this.mapView = mapView;
        this.autoHide = true;
        setMarginHorizontal(5);
        setMarginVertical(0);
        this.showMapZoomControls = true;
        this.zoomLevelMax = (byte) 22;
        this.zoomLevelMin = (byte) 0;
        setVisibility(8);
        this.zoomControlsGravity = DEFAULT_ZOOM_CONTROLS_GRAVITY;
        this.zoomControlsHideHandler = new Handler() { // from class: org.mapsforge.map.android.input.MapZoomControls.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                MapZoomControls.this.hide();
            }
        };
        ZoomControls zoomControls = new ZoomControls(context);
        ZoomButton zoomButton = (ZoomButton) zoomControls.getChildAt(1);
        this.buttonZoomIn = zoomButton;
        ZoomButton zoomButton2 = (ZoomButton) zoomControls.getChildAt(0);
        this.buttonZoomOut = zoomButton2;
        zoomControls.removeAllViews();
        setOrientation(zoomControls.getOrientation());
        setZoomInFirst(false);
        setZoomSpeed(DEFAULT_ZOOM_SPEED);
        zoomButton.setOnClickListener(new View.OnClickListener() { // from class: org.mapsforge.map.android.input.MapZoomControls.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                mapView.onZoomEvent();
                MapZoomControls.this.mapView.getModel().mapViewPosition.zoomIn();
            }
        });
        zoomButton2.setOnClickListener(new View.OnClickListener() { // from class: org.mapsforge.map.android.input.MapZoomControls.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                mapView.onZoomEvent();
                MapZoomControls.this.mapView.getModel().mapViewPosition.zoomOut();
            }
        });
        mapView.getModel().mapViewPosition.addObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeZoomControls(int i3) {
        this.buttonZoomIn.setEnabled(i3 < this.zoomLevelMax);
        this.buttonZoomOut.setEnabled(i3 > this.zoomLevelMin);
    }

    private void fade(int i3, float f3, float f4) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setDuration(DEFAULT_ZOOM_SPEED);
        startAnimation(alphaAnimation);
        setVisibility(i3);
    }

    private void showZoomControls() {
        this.zoomControlsHideHandler.removeMessages(0);
        if (getVisibility() != 0) {
            show();
        }
    }

    private void showZoomControlsWithTimeout() {
        showZoomControls();
        this.zoomControlsHideHandler.sendEmptyMessageDelayed(0, ZOOM_CONTROLS_TIMEOUT);
    }

    public void destroy() {
        this.mapView.getModel().mapViewPosition.removeObserver(this);
    }

    public int getZoomControlsGravity() {
        return this.zoomControlsGravity;
    }

    public byte getZoomLevelMax() {
        return this.zoomLevelMax;
    }

    public byte getZoomLevelMin() {
        return this.zoomLevelMin;
    }

    public void hide() {
        fade(8, 1.0f, BitmapDescriptorFactory.HUE_RED);
    }

    public boolean isAutoHide() {
        return this.autoHide;
    }

    public boolean isShowMapZoomControls() {
        return this.showMapZoomControls;
    }

    @Override // org.mapsforge.map.model.common.Observer
    public void onChange() {
        onZoomLevelChange(this.mapView.getModel().mapViewPosition.getZoomLevel());
    }

    public void onMapViewTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() <= 1 && this.showMapZoomControls && this.autoHide) {
            int action = motionEvent.getAction();
            if (action == 0) {
                showZoomControls();
            } else if (action == 1 || action == 3) {
                showZoomControlsWithTimeout();
            }
        }
    }

    public void onZoomLevelChange(final int i3) {
        if (AndroidUtil.currentThreadIsUiThread()) {
            changeZoomControls(i3);
        } else {
            this.mapView.post(new Runnable() { // from class: org.mapsforge.map.android.input.MapZoomControls.4
                @Override // java.lang.Runnable
                public void run() {
                    MapZoomControls.this.changeZoomControls(i3);
                }
            });
        }
    }

    public void setAutoHide(boolean z3) {
        this.autoHide = z3;
        if (z3) {
            return;
        }
        showZoomControls();
    }

    public void setMarginHorizontal(int i3) {
        setPadding(i3, getPaddingTop(), i3, getPaddingBottom());
        this.mapView.requestLayout();
    }

    public void setMarginVertical(int i3) {
        setPadding(getPaddingLeft(), i3, getPaddingRight(), i3);
        this.mapView.requestLayout();
    }

    public void setShowMapZoomControls(boolean z3) {
        this.showMapZoomControls = z3;
    }

    public void setZoomControlsGravity(int i3) {
        this.zoomControlsGravity = i3;
        this.mapView.requestLayout();
    }

    public void setZoomControlsOrientation(Orientation orientation) {
        setOrientation(orientation.layoutOrientation);
        setZoomInFirst(orientation.zoomInFirst);
    }

    public void setZoomInFirst(boolean z3) {
        ZoomButton zoomButton;
        removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (z3) {
            addView(this.buttonZoomIn, layoutParams);
            zoomButton = this.buttonZoomOut;
        } else {
            addView(this.buttonZoomOut, layoutParams);
            zoomButton = this.buttonZoomIn;
        }
        addView(zoomButton, layoutParams);
    }

    public void setZoomInResource(int i3) {
        this.buttonZoomIn.setBackgroundResource(i3);
    }

    public void setZoomLevelMax(byte b4) {
        if (b4 < this.zoomLevelMin) {
            throw new IllegalArgumentException();
        }
        this.zoomLevelMax = b4;
    }

    public void setZoomLevelMin(byte b4) {
        if (b4 > this.zoomLevelMax) {
            throw new IllegalArgumentException();
        }
        this.zoomLevelMin = b4;
    }

    public void setZoomOutResource(int i3) {
        this.buttonZoomOut.setBackgroundResource(i3);
    }

    public void setZoomSpeed(long j3) {
        this.buttonZoomIn.setZoomSpeed(j3);
        this.buttonZoomOut.setZoomSpeed(j3);
    }

    public void show() {
        fade(0, BitmapDescriptorFactory.HUE_RED, 1.0f);
    }
}
