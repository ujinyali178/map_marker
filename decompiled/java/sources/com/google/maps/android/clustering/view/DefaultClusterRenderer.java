package com.google.maps.android.clustering.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.R;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import com.google.maps.android.ui.IconGenerator;
import com.google.maps.android.ui.SquareTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /root/release/classes.dex */
public class DefaultClusterRenderer<T extends ClusterItem> implements ClusterRenderer<T> {
    private ClusterManager.OnClusterClickListener<T> mClickListener;
    private final ClusterManager<T> mClusterManager;
    private MarkerCache<Cluster<T>> mClusterMarkerCache;
    private Set<? extends Cluster<T>> mClusters;
    private ShapeDrawable mColoredCircleBackground;
    private final float mDensity;
    private final IconGenerator mIconGenerator;
    private ClusterManager.OnClusterInfoWindowClickListener<T> mInfoWindowClickListener;
    private ClusterManager.OnClusterInfoWindowLongClickListener<T> mInfoWindowLongClickListener;
    private ClusterManager.OnClusterItemClickListener<T> mItemClickListener;
    private ClusterManager.OnClusterItemInfoWindowClickListener<T> mItemInfoWindowClickListener;
    private ClusterManager.OnClusterItemInfoWindowLongClickListener<T> mItemInfoWindowLongClickListener;
    private final GoogleMap mMap;
    private MarkerCache<T> mMarkerCache;
    private final DefaultClusterRenderer<T>.ViewModifier mViewModifier;
    private float mZoom;
    private static final int[] BUCKETS = {10, 20, 50, 100, 200, 500, 1000};
    private static final TimeInterpolator ANIMATION_INTERP = new DecelerateInterpolator();
    private final Executor mExecutor = Executors.newSingleThreadExecutor();
    private Set<MarkerWithPosition> mMarkers = Collections.newSetFromMap(new ConcurrentHashMap());
    private SparseArray<BitmapDescriptor> mIcons = new SparseArray<>();
    private int mMinClusterSize = 4;
    private boolean mAnimate = true;
    private long mAnimationDurationMs = 300;

    private class AnimationTask extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private final LatLng from;
        private MarkerManager mMarkerManager;
        private boolean mRemoveOnComplete;
        private final Marker marker;
        private final MarkerWithPosition markerWithPosition;
        private final LatLng to;

        private AnimationTask(MarkerWithPosition markerWithPosition, LatLng latLng, LatLng latLng2) {
            this.markerWithPosition = markerWithPosition;
            this.marker = markerWithPosition.marker;
            this.from = latLng;
            this.to = latLng2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.mRemoveOnComplete) {
                DefaultClusterRenderer.this.mMarkerCache.remove(this.marker);
                DefaultClusterRenderer.this.mClusterMarkerCache.remove(this.marker);
                this.mMarkerManager.remove(this.marker);
            }
            this.markerWithPosition.position = this.to;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.to == null || this.from == null || this.marker == null) {
                return;
            }
            float animatedFraction = valueAnimator.getAnimatedFraction();
            LatLng latLng = this.to;
            double d3 = latLng.latitude;
            LatLng latLng2 = this.from;
            double d4 = latLng2.latitude;
            double d5 = animatedFraction;
            double d6 = ((d3 - d4) * d5) + d4;
            double d7 = latLng.longitude - latLng2.longitude;
            if (Math.abs(d7) > 180.0d) {
                d7 -= Math.signum(d7) * 360.0d;
            }
            this.marker.setPosition(new LatLng(d6, (d7 * d5) + this.from.longitude));
        }

        public void perform() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(BitmapDescriptorFactory.HUE_RED, 1.0f);
            ofFloat.setInterpolator(DefaultClusterRenderer.ANIMATION_INTERP);
            ofFloat.setDuration(DefaultClusterRenderer.this.mAnimationDurationMs);
            ofFloat.addUpdateListener(this);
            ofFloat.addListener(this);
            ofFloat.start();
        }

        public void removeOnAnimationComplete(MarkerManager markerManager) {
            this.mMarkerManager = markerManager;
            this.mRemoveOnComplete = true;
        }
    }

    private class CreateMarkerTask {
        private final LatLng animateFrom;
        private final Cluster<T> cluster;
        private final Set<MarkerWithPosition> newMarkers;

        public CreateMarkerTask(Cluster<T> cluster, Set<MarkerWithPosition> set, LatLng latLng) {
            this.cluster = cluster;
            this.newMarkers = set;
            this.animateFrom = latLng;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void perform(DefaultClusterRenderer<T>.MarkerModifier markerModifier) {
            MarkerWithPosition markerWithPosition;
            MarkerWithPosition markerWithPosition2;
            if (DefaultClusterRenderer.this.shouldRenderAsCluster(this.cluster)) {
                Marker marker = DefaultClusterRenderer.this.mClusterMarkerCache.get((MarkerCache) this.cluster);
                if (marker == null) {
                    MarkerOptions markerOptions = new MarkerOptions();
                    LatLng latLng = this.animateFrom;
                    if (latLng == null) {
                        latLng = this.cluster.getPosition();
                    }
                    MarkerOptions position = markerOptions.position(latLng);
                    DefaultClusterRenderer.this.onBeforeClusterRendered(this.cluster, position);
                    marker = DefaultClusterRenderer.this.mClusterManager.getClusterMarkerCollection().addMarker(position);
                    DefaultClusterRenderer.this.mClusterMarkerCache.put(this.cluster, marker);
                    markerWithPosition = new MarkerWithPosition(marker);
                    LatLng latLng2 = this.animateFrom;
                    if (latLng2 != null) {
                        markerModifier.animate(markerWithPosition, latLng2, this.cluster.getPosition());
                    }
                } else {
                    markerWithPosition = new MarkerWithPosition(marker);
                    DefaultClusterRenderer.this.onClusterUpdated(this.cluster, marker);
                }
                DefaultClusterRenderer.this.onClusterRendered(this.cluster, marker);
                this.newMarkers.add(markerWithPosition);
                return;
            }
            for (T t3 : this.cluster.getItems()) {
                Marker marker2 = DefaultClusterRenderer.this.mMarkerCache.get((MarkerCache) t3);
                if (marker2 == null) {
                    MarkerOptions markerOptions2 = new MarkerOptions();
                    LatLng latLng3 = this.animateFrom;
                    if (latLng3 != null) {
                        markerOptions2.position(latLng3);
                    } else {
                        markerOptions2.position(t3.getPosition());
                        if (t3.getZIndex() != null) {
                            markerOptions2.zIndex(t3.getZIndex().floatValue());
                        }
                    }
                    DefaultClusterRenderer.this.onBeforeClusterItemRendered(t3, markerOptions2);
                    marker2 = DefaultClusterRenderer.this.mClusterManager.getMarkerCollection().addMarker(markerOptions2);
                    markerWithPosition2 = new MarkerWithPosition(marker2);
                    DefaultClusterRenderer.this.mMarkerCache.put(t3, marker2);
                    LatLng latLng4 = this.animateFrom;
                    if (latLng4 != null) {
                        markerModifier.animate(markerWithPosition2, latLng4, t3.getPosition());
                    }
                } else {
                    markerWithPosition2 = new MarkerWithPosition(marker2);
                    DefaultClusterRenderer.this.onClusterItemUpdated(t3, marker2);
                }
                DefaultClusterRenderer.this.onClusterItemRendered(t3, marker2);
                this.newMarkers.add(markerWithPosition2);
            }
        }
    }

    private static class MarkerCache<T> {
        private Map<T, Marker> mCache;
        private Map<Marker, T> mCacheReverse;

        private MarkerCache() {
            this.mCache = new HashMap();
            this.mCacheReverse = new HashMap();
        }

        public Marker get(T t3) {
            return this.mCache.get(t3);
        }

        public T get(Marker marker) {
            return this.mCacheReverse.get(marker);
        }

        public void put(T t3, Marker marker) {
            this.mCache.put(t3, marker);
            this.mCacheReverse.put(marker, t3);
        }

        public void remove(Marker marker) {
            T t3 = this.mCacheReverse.get(marker);
            this.mCacheReverse.remove(marker);
            this.mCache.remove(t3);
        }
    }

    private class MarkerModifier extends Handler implements MessageQueue.IdleHandler {
        private static final int BLANK = 0;
        private final Condition busyCondition;
        private final Lock lock;
        private Queue<DefaultClusterRenderer<T>.AnimationTask> mAnimationTasks;
        private Queue<DefaultClusterRenderer<T>.CreateMarkerTask> mCreateMarkerTasks;
        private boolean mListenerAdded;
        private Queue<DefaultClusterRenderer<T>.CreateMarkerTask> mOnScreenCreateMarkerTasks;
        private Queue<Marker> mOnScreenRemoveMarkerTasks;
        private Queue<Marker> mRemoveMarkerTasks;

        private MarkerModifier() {
            super(Looper.getMainLooper());
            ReentrantLock reentrantLock = new ReentrantLock();
            this.lock = reentrantLock;
            this.busyCondition = reentrantLock.newCondition();
            this.mCreateMarkerTasks = new LinkedList();
            this.mOnScreenCreateMarkerTasks = new LinkedList();
            this.mRemoveMarkerTasks = new LinkedList();
            this.mOnScreenRemoveMarkerTasks = new LinkedList();
            this.mAnimationTasks = new LinkedList();
        }

        private void performNextTask() {
            Queue<Marker> queue;
            Queue<DefaultClusterRenderer<T>.CreateMarkerTask> queue2;
            if (this.mOnScreenRemoveMarkerTasks.isEmpty()) {
                if (!this.mAnimationTasks.isEmpty()) {
                    this.mAnimationTasks.poll().perform();
                    return;
                }
                if (!this.mOnScreenCreateMarkerTasks.isEmpty()) {
                    queue2 = this.mOnScreenCreateMarkerTasks;
                } else if (!this.mCreateMarkerTasks.isEmpty()) {
                    queue2 = this.mCreateMarkerTasks;
                } else if (this.mRemoveMarkerTasks.isEmpty()) {
                    return;
                } else {
                    queue = this.mRemoveMarkerTasks;
                }
                queue2.poll().perform(this);
                return;
            }
            queue = this.mOnScreenRemoveMarkerTasks;
            removeMarker(queue.poll());
        }

        private void removeMarker(Marker marker) {
            DefaultClusterRenderer.this.mMarkerCache.remove(marker);
            DefaultClusterRenderer.this.mClusterMarkerCache.remove(marker);
            DefaultClusterRenderer.this.mClusterManager.getMarkerManager().remove(marker);
        }

        public void add(boolean z3, DefaultClusterRenderer<T>.CreateMarkerTask createMarkerTask) {
            this.lock.lock();
            sendEmptyMessage(0);
            (z3 ? this.mOnScreenCreateMarkerTasks : this.mCreateMarkerTasks).add(createMarkerTask);
            this.lock.unlock();
        }

        public void animate(MarkerWithPosition markerWithPosition, LatLng latLng, LatLng latLng2) {
            this.lock.lock();
            this.mAnimationTasks.add(new AnimationTask(markerWithPosition, latLng, latLng2));
            this.lock.unlock();
        }

        public void animateThenRemove(MarkerWithPosition markerWithPosition, LatLng latLng, LatLng latLng2) {
            this.lock.lock();
            DefaultClusterRenderer<T>.AnimationTask animationTask = new AnimationTask(markerWithPosition, latLng, latLng2);
            animationTask.removeOnAnimationComplete(DefaultClusterRenderer.this.mClusterManager.getMarkerManager());
            this.mAnimationTasks.add(animationTask);
            this.lock.unlock();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (!this.mListenerAdded) {
                Looper.myQueue().addIdleHandler(this);
                this.mListenerAdded = true;
            }
            removeMessages(0);
            this.lock.lock();
            for (int i3 = 0; i3 < 10; i3++) {
                try {
                    performNextTask();
                } finally {
                    this.lock.unlock();
                }
            }
            if (isBusy()) {
                sendEmptyMessageDelayed(0, 10L);
            } else {
                this.mListenerAdded = false;
                Looper.myQueue().removeIdleHandler(this);
                this.busyCondition.signalAll();
            }
        }

        public boolean isBusy() {
            boolean z3;
            try {
                this.lock.lock();
                if (this.mCreateMarkerTasks.isEmpty() && this.mOnScreenCreateMarkerTasks.isEmpty() && this.mOnScreenRemoveMarkerTasks.isEmpty() && this.mRemoveMarkerTasks.isEmpty()) {
                    if (this.mAnimationTasks.isEmpty()) {
                        z3 = false;
                        return z3;
                    }
                }
                z3 = true;
                return z3;
            } finally {
                this.lock.unlock();
            }
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            sendEmptyMessage(0);
            return true;
        }

        public void remove(boolean z3, Marker marker) {
            this.lock.lock();
            sendEmptyMessage(0);
            (z3 ? this.mOnScreenRemoveMarkerTasks : this.mRemoveMarkerTasks).add(marker);
            this.lock.unlock();
        }

        public void waitUntilFree() {
            while (isBusy()) {
                sendEmptyMessage(0);
                this.lock.lock();
                try {
                    try {
                        if (isBusy()) {
                            this.busyCondition.await();
                        }
                    } catch (InterruptedException e3) {
                        throw new RuntimeException(e3);
                    }
                } finally {
                    this.lock.unlock();
                }
            }
        }
    }

    private static class MarkerWithPosition {
        private final Marker marker;
        private LatLng position;

        private MarkerWithPosition(Marker marker) {
            this.marker = marker;
            this.position = marker.getPosition();
        }

        public boolean equals(Object obj) {
            if (obj instanceof MarkerWithPosition) {
                return this.marker.equals(((MarkerWithPosition) obj).marker);
            }
            return false;
        }

        public int hashCode() {
            return this.marker.hashCode();
        }
    }

    private class RenderTask implements Runnable {
        final Set<? extends Cluster<T>> clusters;
        private Runnable mCallback;
        private float mMapZoom;
        private Projection mProjection;
        private SphericalMercatorProjection mSphericalMercatorProjection;

        private RenderTask(Set<? extends Cluster<T>> set) {
            this.clusters = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            LatLngBounds build;
            ArrayList arrayList;
            DefaultClusterRenderer defaultClusterRenderer = DefaultClusterRenderer.this;
            if (defaultClusterRenderer.shouldRender(defaultClusterRenderer.immutableOf(defaultClusterRenderer.mClusters), DefaultClusterRenderer.this.immutableOf(this.clusters))) {
                ArrayList arrayList2 = null;
                MarkerModifier markerModifier = new MarkerModifier();
                float f3 = this.mMapZoom;
                boolean z3 = f3 > DefaultClusterRenderer.this.mZoom;
                float f4 = f3 - DefaultClusterRenderer.this.mZoom;
                Set<MarkerWithPosition> set = DefaultClusterRenderer.this.mMarkers;
                try {
                    build = this.mProjection.getVisibleRegion().latLngBounds;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    build = LatLngBounds.builder().include(new LatLng(0.0d, 0.0d)).build();
                }
                if (DefaultClusterRenderer.this.mClusters == null || !DefaultClusterRenderer.this.mAnimate) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    for (Cluster<T> cluster : DefaultClusterRenderer.this.mClusters) {
                        if (DefaultClusterRenderer.this.shouldRenderAsCluster(cluster) && build.contains(cluster.getPosition())) {
                            arrayList.add(this.mSphericalMercatorProjection.toPoint(cluster.getPosition()));
                        }
                    }
                }
                Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
                for (Cluster<T> cluster2 : this.clusters) {
                    boolean contains = build.contains(cluster2.getPosition());
                    if (z3 && contains && DefaultClusterRenderer.this.mAnimate) {
                        Point findClosestCluster = DefaultClusterRenderer.this.findClosestCluster(arrayList, this.mSphericalMercatorProjection.toPoint(cluster2.getPosition()));
                        if (findClosestCluster != null) {
                            markerModifier.add(true, new CreateMarkerTask(cluster2, newSetFromMap, this.mSphericalMercatorProjection.toLatLng(findClosestCluster)));
                        } else {
                            markerModifier.add(true, new CreateMarkerTask(cluster2, newSetFromMap, null));
                        }
                    } else {
                        markerModifier.add(contains, new CreateMarkerTask(cluster2, newSetFromMap, null));
                    }
                }
                markerModifier.waitUntilFree();
                set.removeAll(newSetFromMap);
                if (DefaultClusterRenderer.this.mAnimate) {
                    arrayList2 = new ArrayList();
                    for (Cluster<T> cluster3 : this.clusters) {
                        if (DefaultClusterRenderer.this.shouldRenderAsCluster(cluster3) && build.contains(cluster3.getPosition())) {
                            arrayList2.add(this.mSphericalMercatorProjection.toPoint(cluster3.getPosition()));
                        }
                    }
                }
                for (MarkerWithPosition markerWithPosition : set) {
                    boolean contains2 = build.contains(markerWithPosition.position);
                    if (z3 || f4 <= -3.0f || !contains2 || !DefaultClusterRenderer.this.mAnimate) {
                        markerModifier.remove(contains2, markerWithPosition.marker);
                    } else {
                        Point findClosestCluster2 = DefaultClusterRenderer.this.findClosestCluster(arrayList2, this.mSphericalMercatorProjection.toPoint(markerWithPosition.position));
                        if (findClosestCluster2 != null) {
                            markerModifier.animateThenRemove(markerWithPosition, markerWithPosition.position, this.mSphericalMercatorProjection.toLatLng(findClosestCluster2));
                        } else {
                            markerModifier.remove(true, markerWithPosition.marker);
                        }
                    }
                }
                markerModifier.waitUntilFree();
                DefaultClusterRenderer.this.mMarkers = newSetFromMap;
                DefaultClusterRenderer.this.mClusters = this.clusters;
                DefaultClusterRenderer.this.mZoom = f3;
            }
            this.mCallback.run();
        }

        public void setCallback(Runnable runnable) {
            this.mCallback = runnable;
        }

        public void setMapZoom(float f3) {
            this.mMapZoom = f3;
            this.mSphericalMercatorProjection = new SphericalMercatorProjection(Math.pow(2.0d, Math.min(f3, DefaultClusterRenderer.this.mZoom)) * 256.0d);
        }

        public void setProjection(Projection projection) {
            this.mProjection = projection;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ViewModifier extends Handler {
        private static final int RUN_TASK = 0;
        private static final int TASK_FINISHED = 1;
        private DefaultClusterRenderer<T>.RenderTask mNextClusters;
        private boolean mViewModificationInProgress;

        private ViewModifier() {
            this.mViewModificationInProgress = false;
            this.mNextClusters = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$0() {
            sendEmptyMessage(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            DefaultClusterRenderer<T>.RenderTask renderTask;
            if (message.what == 1) {
                this.mViewModificationInProgress = false;
                if (this.mNextClusters != null) {
                    sendEmptyMessage(0);
                    return;
                }
                return;
            }
            removeMessages(0);
            if (this.mViewModificationInProgress || this.mNextClusters == null) {
                return;
            }
            Projection projection = DefaultClusterRenderer.this.mMap.getProjection();
            synchronized (this) {
                renderTask = this.mNextClusters;
                this.mNextClusters = null;
                this.mViewModificationInProgress = true;
            }
            renderTask.setCallback(new Runnable() { // from class: com.google.maps.android.clustering.view.e
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultClusterRenderer.ViewModifier.this.lambda$handleMessage$0();
                }
            });
            renderTask.setProjection(projection);
            renderTask.setMapZoom(DefaultClusterRenderer.this.mMap.getCameraPosition().zoom);
            DefaultClusterRenderer.this.mExecutor.execute(renderTask);
        }

        public void queue(Set<? extends Cluster<T>> set) {
            synchronized (this) {
                this.mNextClusters = new RenderTask(set);
            }
            sendEmptyMessage(0);
        }
    }

    public DefaultClusterRenderer(Context context, GoogleMap googleMap, ClusterManager<T> clusterManager) {
        this.mMarkerCache = new MarkerCache<>();
        this.mClusterMarkerCache = new MarkerCache<>();
        this.mViewModifier = new ViewModifier();
        this.mMap = googleMap;
        this.mDensity = context.getResources().getDisplayMetrics().density;
        IconGenerator iconGenerator = new IconGenerator(context);
        this.mIconGenerator = iconGenerator;
        iconGenerator.setContentView(makeSquareTextView(context));
        iconGenerator.setTextAppearance(R.style.amu_ClusterIcon_TextAppearance);
        iconGenerator.setBackground(makeClusterBackground());
        this.mClusterManager = clusterManager;
    }

    private static double distanceSquared(Point point, Point point2) {
        double d3 = point.f2375x;
        double d4 = point2.f2375x;
        double d5 = (d3 - d4) * (d3 - d4);
        double d6 = point.f2376y;
        double d7 = point2.f2376y;
        return d5 + ((d6 - d7) * (d6 - d7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Point findClosestCluster(List<Point> list, Point point) {
        Point point2 = null;
        if (list != null && !list.isEmpty()) {
            int maxDistanceBetweenClusteredItems = this.mClusterManager.getAlgorithm().getMaxDistanceBetweenClusteredItems();
            double d3 = maxDistanceBetweenClusteredItems * maxDistanceBetweenClusteredItems;
            for (Point point3 : list) {
                double distanceSquared = distanceSquared(point3, point);
                if (distanceSquared < d3) {
                    point2 = point3;
                    d3 = distanceSquared;
                }
            }
        }
        return point2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<? extends Cluster<T>> immutableOf(Set<? extends Cluster<T>> set) {
        return set != null ? Collections.unmodifiableSet(set) : Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdd$0(Marker marker) {
        ClusterManager.OnClusterItemInfoWindowLongClickListener<T> onClusterItemInfoWindowLongClickListener = this.mItemInfoWindowLongClickListener;
        if (onClusterItemInfoWindowLongClickListener != null) {
            onClusterItemInfoWindowLongClickListener.onClusterItemInfoWindowLongClick(this.mMarkerCache.get(marker));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onAdd$1(Marker marker) {
        ClusterManager.OnClusterClickListener<T> onClusterClickListener = this.mClickListener;
        return onClusterClickListener != null && onClusterClickListener.onClusterClick(this.mClusterMarkerCache.get(marker));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdd$2(Marker marker) {
        ClusterManager.OnClusterInfoWindowClickListener<T> onClusterInfoWindowClickListener = this.mInfoWindowClickListener;
        if (onClusterInfoWindowClickListener != null) {
            onClusterInfoWindowClickListener.onClusterInfoWindowClick(this.mClusterMarkerCache.get(marker));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdd$3(Marker marker) {
        ClusterManager.OnClusterInfoWindowLongClickListener<T> onClusterInfoWindowLongClickListener = this.mInfoWindowLongClickListener;
        if (onClusterInfoWindowLongClickListener != null) {
            onClusterInfoWindowLongClickListener.onClusterInfoWindowLongClick(this.mClusterMarkerCache.get(marker));
        }
    }

    private LayerDrawable makeClusterBackground() {
        this.mColoredCircleBackground = new ShapeDrawable(new OvalShape());
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(-2130706433);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, this.mColoredCircleBackground});
        int i3 = (int) (this.mDensity * 3.0f);
        layerDrawable.setLayerInset(1, i3, i3, i3, i3);
        return layerDrawable;
    }

    private SquareTextView makeSquareTextView(Context context) {
        SquareTextView squareTextView = new SquareTextView(context);
        squareTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        squareTextView.setId(R.id.amu_text);
        int i3 = (int) (this.mDensity * 12.0f);
        squareTextView.setPadding(i3, i3, i3, i3);
        return squareTextView;
    }

    protected int getBucket(Cluster<T> cluster) {
        int size = cluster.getSize();
        int i3 = 0;
        if (size <= BUCKETS[0]) {
            return size;
        }
        while (true) {
            int[] iArr = BUCKETS;
            if (i3 >= iArr.length - 1) {
                return iArr[iArr.length - 1];
            }
            int i4 = i3 + 1;
            if (size < iArr[i4]) {
                return iArr[i3];
            }
            i3 = i4;
        }
    }

    public Cluster<T> getCluster(Marker marker) {
        return this.mClusterMarkerCache.get(marker);
    }

    public T getClusterItem(Marker marker) {
        return this.mMarkerCache.get(marker);
    }

    protected String getClusterText(int i3) {
        if (i3 < BUCKETS[0]) {
            return String.valueOf(i3);
        }
        return i3 + "+";
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public int getClusterTextAppearance(int i3) {
        return R.style.amu_ClusterIcon_TextAppearance;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public int getColor(int i3) {
        float min = 300.0f - Math.min(i3, 300.0f);
        return Color.HSVToColor(new float[]{((min * min) / 90000.0f) * 220.0f, 1.0f, 0.6f});
    }

    protected BitmapDescriptor getDescriptorForCluster(Cluster<T> cluster) {
        int bucket = getBucket(cluster);
        BitmapDescriptor bitmapDescriptor = this.mIcons.get(bucket);
        if (bitmapDescriptor != null) {
            return bitmapDescriptor;
        }
        this.mColoredCircleBackground.getPaint().setColor(getColor(bucket));
        this.mIconGenerator.setTextAppearance(getClusterTextAppearance(bucket));
        BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(this.mIconGenerator.makeIcon(getClusterText(bucket)));
        this.mIcons.put(bucket, fromBitmap);
        return fromBitmap;
    }

    public Marker getMarker(Cluster<T> cluster) {
        return this.mClusterMarkerCache.get((MarkerCache<Cluster<T>>) cluster);
    }

    public Marker getMarker(T t3) {
        return this.mMarkerCache.get((MarkerCache<T>) t3);
    }

    public int getMinClusterSize() {
        return this.mMinClusterSize;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void onAdd() {
        this.mClusterManager.getMarkerCollection().setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() { // from class: com.google.maps.android.clustering.view.DefaultClusterRenderer.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
            public boolean onMarkerClick(Marker marker) {
                return DefaultClusterRenderer.this.mItemClickListener != null && DefaultClusterRenderer.this.mItemClickListener.onClusterItemClick((ClusterItem) DefaultClusterRenderer.this.mMarkerCache.get(marker));
            }
        });
        this.mClusterManager.getMarkerCollection().setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() { // from class: com.google.maps.android.clustering.view.DefaultClusterRenderer.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
            public void onInfoWindowClick(Marker marker) {
                if (DefaultClusterRenderer.this.mItemInfoWindowClickListener != null) {
                    DefaultClusterRenderer.this.mItemInfoWindowClickListener.onClusterItemInfoWindowClick((ClusterItem) DefaultClusterRenderer.this.mMarkerCache.get(marker));
                }
            }
        });
        this.mClusterManager.getMarkerCollection().setOnInfoWindowLongClickListener(new GoogleMap.OnInfoWindowLongClickListener() { // from class: com.google.maps.android.clustering.view.a
            @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowLongClickListener
            public final void onInfoWindowLongClick(Marker marker) {
                DefaultClusterRenderer.this.lambda$onAdd$0(marker);
            }
        });
        this.mClusterManager.getClusterMarkerCollection().setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() { // from class: com.google.maps.android.clustering.view.b
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
            public final boolean onMarkerClick(Marker marker) {
                boolean lambda$onAdd$1;
                lambda$onAdd$1 = DefaultClusterRenderer.this.lambda$onAdd$1(marker);
                return lambda$onAdd$1;
            }
        });
        this.mClusterManager.getClusterMarkerCollection().setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() { // from class: com.google.maps.android.clustering.view.c
            @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
            public final void onInfoWindowClick(Marker marker) {
                DefaultClusterRenderer.this.lambda$onAdd$2(marker);
            }
        });
        this.mClusterManager.getClusterMarkerCollection().setOnInfoWindowLongClickListener(new GoogleMap.OnInfoWindowLongClickListener() { // from class: com.google.maps.android.clustering.view.d
            @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowLongClickListener
            public final void onInfoWindowLongClick(Marker marker) {
                DefaultClusterRenderer.this.lambda$onAdd$3(marker);
            }
        });
    }

    protected void onBeforeClusterItemRendered(T t3, MarkerOptions markerOptions) {
        String snippet;
        if (t3.getTitle() != null && t3.getSnippet() != null) {
            markerOptions.title(t3.getTitle());
            markerOptions.snippet(t3.getSnippet());
            return;
        }
        if (t3.getTitle() != null) {
            snippet = t3.getTitle();
        } else if (t3.getSnippet() == null) {
            return;
        } else {
            snippet = t3.getSnippet();
        }
        markerOptions.title(snippet);
    }

    protected void onBeforeClusterRendered(Cluster<T> cluster, MarkerOptions markerOptions) {
        markerOptions.icon(getDescriptorForCluster(cluster));
    }

    protected void onClusterItemRendered(T t3, Marker marker) {
    }

    protected void onClusterItemUpdated(T t3, Marker marker) {
        String title;
        boolean z3 = true;
        boolean z4 = false;
        if (t3.getTitle() == null || t3.getSnippet() == null) {
            if (t3.getSnippet() != null && !t3.getSnippet().equals(marker.getTitle())) {
                title = t3.getSnippet();
            } else if (t3.getTitle() != null && !t3.getTitle().equals(marker.getTitle())) {
                title = t3.getTitle();
            }
            marker.setTitle(title);
            z4 = true;
        } else {
            if (!t3.getTitle().equals(marker.getTitle())) {
                marker.setTitle(t3.getTitle());
                z4 = true;
            }
            if (!t3.getSnippet().equals(marker.getSnippet())) {
                marker.setSnippet(t3.getSnippet());
                z4 = true;
            }
        }
        if (marker.getPosition().equals(t3.getPosition())) {
            z3 = z4;
        } else {
            marker.setPosition(t3.getPosition());
            if (t3.getZIndex() != null) {
                marker.setZIndex(t3.getZIndex().floatValue());
            }
        }
        if (z3 && marker.isInfoWindowShown()) {
            marker.showInfoWindow();
        }
    }

    protected void onClusterRendered(Cluster<T> cluster, Marker marker) {
    }

    protected void onClusterUpdated(Cluster<T> cluster, Marker marker) {
        marker.setIcon(getDescriptorForCluster(cluster));
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void onClustersChanged(Set<? extends Cluster<T>> set) {
        this.mViewModifier.queue(set);
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void onRemove() {
        this.mClusterManager.getMarkerCollection().setOnMarkerClickListener(null);
        this.mClusterManager.getMarkerCollection().setOnInfoWindowClickListener(null);
        this.mClusterManager.getMarkerCollection().setOnInfoWindowLongClickListener(null);
        this.mClusterManager.getClusterMarkerCollection().setOnMarkerClickListener(null);
        this.mClusterManager.getClusterMarkerCollection().setOnInfoWindowClickListener(null);
        this.mClusterManager.getClusterMarkerCollection().setOnInfoWindowLongClickListener(null);
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setAnimation(boolean z3) {
        this.mAnimate = z3;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setAnimationDuration(long j3) {
        this.mAnimationDurationMs = j3;
    }

    public void setMinClusterSize(int i3) {
        this.mMinClusterSize = i3;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setOnClusterClickListener(ClusterManager.OnClusterClickListener<T> onClusterClickListener) {
        this.mClickListener = onClusterClickListener;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setOnClusterInfoWindowClickListener(ClusterManager.OnClusterInfoWindowClickListener<T> onClusterInfoWindowClickListener) {
        this.mInfoWindowClickListener = onClusterInfoWindowClickListener;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setOnClusterInfoWindowLongClickListener(ClusterManager.OnClusterInfoWindowLongClickListener<T> onClusterInfoWindowLongClickListener) {
        this.mInfoWindowLongClickListener = onClusterInfoWindowLongClickListener;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setOnClusterItemClickListener(ClusterManager.OnClusterItemClickListener<T> onClusterItemClickListener) {
        this.mItemClickListener = onClusterItemClickListener;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setOnClusterItemInfoWindowClickListener(ClusterManager.OnClusterItemInfoWindowClickListener<T> onClusterItemInfoWindowClickListener) {
        this.mItemInfoWindowClickListener = onClusterItemInfoWindowClickListener;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setOnClusterItemInfoWindowLongClickListener(ClusterManager.OnClusterItemInfoWindowLongClickListener<T> onClusterItemInfoWindowLongClickListener) {
        this.mItemInfoWindowLongClickListener = onClusterItemInfoWindowLongClickListener;
    }

    protected boolean shouldRender(Set<? extends Cluster<T>> set, Set<? extends Cluster<T>> set2) {
        return !set2.equals(set);
    }

    protected boolean shouldRenderAsCluster(Cluster<T> cluster) {
        return cluster.getSize() >= this.mMinClusterSize;
    }
}
