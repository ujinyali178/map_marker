package org.mapsforge.map.model;

import com.google.common.base.Ascii;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.MapPosition;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.util.MercatorProjection;
import org.mapsforge.map.model.common.Observable;
import org.mapsforge.map.model.common.Persistable;
import org.mapsforge.map.model.common.PreferencesFacade;
import org.mapsforge.map.util.PausableThread;

/* loaded from: /root/release/classes2.dex */
public class MapViewPosition extends Observable implements IMapViewPosition, Persistable {
    private static final String LATITUDE = "latitude";
    private static final String LATITUDE_MAX = "latitudeMax";
    private static final String LATITUDE_MIN = "latitudeMin";
    private static final String LONGITUDE = "longitude";
    private static final String LONGITUDE_MAX = "longitudeMax";
    private static final String LONGITUDE_MIN = "longitudeMin";
    private static final String ZOOM_LEVEL = "zoomLevel";
    private static final String ZOOM_LEVEL_MAX = "zoomLevelMax";
    private static final String ZOOM_LEVEL_MIN = "zoomLevelMin";
    private final Animator animator;
    private final DisplayModel displayModel;
    private double latitude;
    private double longitude;
    private BoundingBox mapLimit;
    private LatLong pivot;
    private double scaleFactor;
    private byte zoomLevel;
    private byte zoomLevelMax = Ascii.DEL;
    private byte zoomLevelMin;

    private class Animator extends PausableThread {
        private static final int DEFAULT_DURATION = 250;
        private static final int DEFAULT_MOVE_STEPS = 25;
        private static final int FRAME_LENGTH_IN_MS = 15;
        private long mapSize;
        private int moveSteps;
        private double scaleDifference;
        private double startScaleFactor;
        private double targetPixelX;
        private double targetPixelY;
        private long timeEnd;
        private long timeStart;
        private boolean zoomAnimation;

        private Animator() {
        }

        private double calculateScaleFactor(float f3) {
            return this.startScaleFactor + (this.scaleDifference * f3);
        }

        private void doWorkMove() {
            if (this.moveSteps == 0) {
                return;
            }
            double longitudeToPixelX = MercatorProjection.longitudeToPixelX(MapViewPosition.this.longitude, this.mapSize);
            double latitudeToPixelY = MercatorProjection.latitudeToPixelY(MapViewPosition.this.latitude, this.mapSize);
            double abs = Math.abs(this.targetPixelX - longitudeToPixelX) / this.moveSteps;
            double abs2 = Math.abs(this.targetPixelY - latitudeToPixelY) / this.moveSteps;
            this.moveSteps--;
            MapViewPosition.this.moveCenter(abs * Math.signum(longitudeToPixelX - this.targetPixelX), abs2 * Math.signum(latitudeToPixelY - this.targetPixelY));
        }

        private void doWorkZoom() {
            if (this.zoomAnimation) {
                if (System.currentTimeMillis() < this.timeEnd) {
                    MapViewPosition.this.setScaleFactor(calculateScaleFactor((System.currentTimeMillis() - this.timeStart) / 250.0f));
                } else {
                    this.zoomAnimation = false;
                    MapViewPosition.this.setScaleFactor(calculateScaleFactor(1.0f));
                    MapViewPosition.this.setPivot(null);
                }
            }
        }

        @Override // org.mapsforge.map.util.PausableThread
        protected void doWork() {
            doWorkMove();
            doWorkZoom();
            Thread.sleep(15L);
        }

        @Override // org.mapsforge.map.util.PausableThread
        protected PausableThread.ThreadPriority getThreadPriority() {
            return PausableThread.ThreadPriority.ABOVE_NORMAL;
        }

        @Override // org.mapsforge.map.util.PausableThread
        protected boolean hasWork() {
            return this.moveSteps > 0 || this.zoomAnimation;
        }

        void startAnimationMove(LatLong latLong) {
            long mapSize = MercatorProjection.getMapSize(MapViewPosition.this.zoomLevel, MapViewPosition.this.displayModel.getTileSize());
            this.mapSize = mapSize;
            this.targetPixelX = MercatorProjection.longitudeToPixelX(latLong.longitude, mapSize);
            this.targetPixelY = MercatorProjection.latitudeToPixelY(latLong.latitude, this.mapSize);
            this.moveSteps = 25;
            synchronized (this) {
                notify();
            }
        }

        void startAnimationZoom(double d3, double d4) {
            this.startScaleFactor = d3;
            this.scaleDifference = d4 - d3;
            this.zoomAnimation = true;
            long currentTimeMillis = System.currentTimeMillis();
            this.timeStart = currentTimeMillis;
            this.timeEnd = currentTimeMillis + 250;
            synchronized (this) {
                notify();
            }
        }
    }

    public MapViewPosition(DisplayModel displayModel) {
        this.displayModel = displayModel;
        Animator animator = new Animator();
        this.animator = animator;
        animator.start();
    }

    private static boolean isNan(double... dArr) {
        for (double d3 : dArr) {
            if (Double.isNaN(d3)) {
                return true;
            }
        }
        return false;
    }

    private void setCenterInternal(double d3, double d4) {
        BoundingBox boundingBox = this.mapLimit;
        if (boundingBox == null) {
            this.latitude = d3;
            this.longitude = d4;
        } else {
            this.latitude = Math.max(Math.min(d3, boundingBox.maxLatitude), this.mapLimit.minLatitude);
            this.longitude = Math.max(Math.min(d4, this.mapLimit.maxLongitude), this.mapLimit.minLongitude);
        }
    }

    private void setZoomLevelInternal(int i3, boolean z3) {
        byte max = (byte) Math.max(Math.min(i3, (int) this.zoomLevelMax), (int) this.zoomLevelMin);
        this.zoomLevel = max;
        if (z3) {
            this.animator.startAnimationZoom(getScaleFactor(), Math.pow(2.0d, this.zoomLevel));
        } else {
            setScaleFactor(Math.pow(2.0d, max));
            setPivot(null);
        }
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void animateTo(LatLong latLong) {
        this.animator.startAnimationMove(latLong);
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public boolean animationInProgress() {
        return this.scaleFactor != MercatorProjection.zoomLevelToScaleFactor(this.zoomLevel);
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void destroy() {
        this.animator.finish();
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public synchronized LatLong getCenter() {
        return new LatLong(this.latitude, this.longitude);
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public synchronized BoundingBox getMapLimit() {
        return this.mapLimit;
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public synchronized MapPosition getMapPosition() {
        return new MapPosition(getCenter(), this.zoomLevel);
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public synchronized LatLong getPivot() {
        return this.pivot;
    }

    public synchronized Point getPivotXY(byte b4) {
        LatLong latLong = this.pivot;
        if (latLong == null) {
            return null;
        }
        return MercatorProjection.getPixel(latLong, MercatorProjection.getMapSize(b4, this.displayModel.getTileSize()));
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public synchronized double getScaleFactor() {
        return this.scaleFactor;
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public synchronized byte getZoomLevel() {
        return this.zoomLevel;
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public synchronized byte getZoomLevelMax() {
        return this.zoomLevelMax;
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public synchronized byte getZoomLevelMin() {
        return this.zoomLevelMin;
    }

    @Override // org.mapsforge.map.model.IMapViewPosition, org.mapsforge.map.model.common.Persistable
    public synchronized void init(PreferencesFacade preferencesFacade) {
        this.latitude = preferencesFacade.getDouble(LATITUDE, 0.0d);
        this.longitude = preferencesFacade.getDouble(LONGITUDE, 0.0d);
        double d3 = preferencesFacade.getDouble(LATITUDE_MAX, Double.NaN);
        double d4 = preferencesFacade.getDouble(LATITUDE_MIN, Double.NaN);
        double d5 = preferencesFacade.getDouble(LONGITUDE_MAX, Double.NaN);
        double d6 = preferencesFacade.getDouble(LONGITUDE_MIN, Double.NaN);
        if (isNan(d3, d4, d5, d6)) {
            this.mapLimit = null;
        } else {
            this.mapLimit = new BoundingBox(d4, d6, d3, d5);
        }
        this.zoomLevel = preferencesFacade.getByte(ZOOM_LEVEL, (byte) 0);
        this.zoomLevelMax = preferencesFacade.getByte(ZOOM_LEVEL_MAX, Ascii.DEL);
        this.zoomLevelMin = preferencesFacade.getByte(ZOOM_LEVEL_MIN, (byte) 0);
        this.scaleFactor = Math.pow(2.0d, this.zoomLevel);
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void moveCenter(double d3, double d4) {
        moveCenterAndZoom(d3, d4, (byte) 0, true);
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void moveCenter(double d3, double d4, boolean z3) {
        moveCenterAndZoom(d3, d4, (byte) 0, z3);
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void moveCenterAndZoom(double d3, double d4, byte b4) {
        moveCenterAndZoom(d3, d4, b4, true);
    }

    public void moveCenterAndZoom(double d3, double d4, byte b4, boolean z3) {
        synchronized (this) {
            long mapSize = MercatorProjection.getMapSize(this.zoomLevel, this.displayModel.getTileSize());
            double d5 = mapSize;
            setCenterInternal(MercatorProjection.pixelYToLatitude(Math.min(Math.max(0.0d, MercatorProjection.latitudeToPixelY(this.latitude, mapSize) - d4), d5), mapSize), MercatorProjection.pixelXToLongitude(Math.min(Math.max(0.0d, MercatorProjection.longitudeToPixelX(this.longitude, mapSize) - d3), d5), mapSize));
            setZoomLevelInternal(this.zoomLevel + b4, z3);
        }
        notifyObservers();
    }

    @Override // org.mapsforge.map.model.IMapViewPosition, org.mapsforge.map.model.common.Persistable
    public synchronized void save(PreferencesFacade preferencesFacade) {
        String str;
        double d3;
        preferencesFacade.putDouble(LATITUDE, this.latitude);
        preferencesFacade.putDouble(LONGITUDE, this.longitude);
        BoundingBox boundingBox = this.mapLimit;
        if (boundingBox == null) {
            d3 = Double.NaN;
            preferencesFacade.putDouble(LATITUDE_MAX, Double.NaN);
            preferencesFacade.putDouble(LATITUDE_MIN, Double.NaN);
            preferencesFacade.putDouble(LONGITUDE_MAX, Double.NaN);
            str = LONGITUDE_MIN;
        } else {
            preferencesFacade.putDouble(LATITUDE_MAX, boundingBox.maxLatitude);
            preferencesFacade.putDouble(LATITUDE_MIN, this.mapLimit.minLatitude);
            preferencesFacade.putDouble(LONGITUDE_MAX, this.mapLimit.maxLongitude);
            str = LONGITUDE_MIN;
            d3 = this.mapLimit.minLongitude;
        }
        preferencesFacade.putDouble(str, d3);
        preferencesFacade.putByte(ZOOM_LEVEL, this.zoomLevel);
        preferencesFacade.putByte(ZOOM_LEVEL_MAX, this.zoomLevelMax);
        preferencesFacade.putByte(ZOOM_LEVEL_MIN, this.zoomLevelMin);
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void setCenter(LatLong latLong) {
        synchronized (this) {
            setCenterInternal(latLong.latitude, latLong.longitude);
        }
        notifyObservers();
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void setMapLimit(BoundingBox boundingBox) {
        synchronized (this) {
            this.mapLimit = boundingBox;
        }
        notifyObservers();
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void setMapPosition(MapPosition mapPosition) {
        setMapPosition(mapPosition, true);
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void setMapPosition(MapPosition mapPosition, boolean z3) {
        synchronized (this) {
            LatLong latLong = mapPosition.latLong;
            setCenterInternal(latLong.latitude, latLong.longitude);
            setZoomLevelInternal(mapPosition.zoomLevel, z3);
        }
        notifyObservers();
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void setPivot(LatLong latLong) {
        synchronized (this) {
            this.pivot = latLong;
        }
    }

    public void setScaleFactor(double d3) {
        synchronized (this) {
            this.scaleFactor = d3;
        }
        notifyObservers();
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void setScaleFactorAdjustment(double d3) {
        synchronized (this) {
            setScaleFactor(Math.pow(2.0d, this.zoomLevel) * d3);
        }
        notifyObservers();
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void setZoomLevel(byte b4) {
        setZoomLevel(b4, true);
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void setZoomLevel(byte b4, boolean z3) {
        if (b4 >= 0) {
            synchronized (this) {
                setZoomLevelInternal(b4, z3);
            }
            notifyObservers();
        } else {
            throw new IllegalArgumentException("zoomLevel must not be negative: " + ((int) b4));
        }
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void setZoomLevelMax(byte b4) {
        if (b4 < 0) {
            throw new IllegalArgumentException("zoomLevelMax must not be negative: " + ((int) b4));
        }
        synchronized (this) {
            if (b4 < this.zoomLevelMin) {
                throw new IllegalArgumentException("zoomLevelMax must be >= zoomLevelMin: " + ((int) b4));
            }
            this.zoomLevelMax = b4;
        }
        notifyObservers();
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void setZoomLevelMin(byte b4) {
        if (b4 < 0) {
            throw new IllegalArgumentException("zoomLevelMin must not be negative: " + ((int) b4));
        }
        synchronized (this) {
            if (b4 > this.zoomLevelMax) {
                throw new IllegalArgumentException("zoomLevelMin must be <= zoomLevelMax: " + ((int) b4));
            }
            this.zoomLevelMin = b4;
        }
        notifyObservers();
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void zoom(byte b4) {
        zoom(b4, true);
    }

    public void zoom(byte b4, boolean z3) {
        synchronized (this) {
            setZoomLevelInternal(this.zoomLevel + b4, z3);
        }
        notifyObservers();
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void zoomIn() {
        zoomIn(true);
    }

    public void zoomIn(boolean z3) {
        zoom((byte) 1, z3);
    }

    @Override // org.mapsforge.map.model.IMapViewPosition
    public void zoomOut() {
        zoomOut(true);
    }

    public void zoomOut(boolean z3) {
        zoom((byte) -1, z3);
    }
}
