package org.mapsforge.map.layer.renderer;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.mapsforge.core.model.Tile;
import org.mapsforge.map.datastore.MapDataStore;
import org.mapsforge.map.layer.queue.Job;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.rendertheme.rule.RenderThemeFuture;

/* loaded from: /root/release/classes2.dex */
public class RendererJob extends Job {
    public final DisplayModel displayModel;
    private final int hashCodeValue;
    public boolean labelsOnly;
    public final MapDataStore mapDataStore;
    public final RenderThemeFuture renderThemeFuture;
    public final float textScale;

    public RendererJob(Tile tile, MapDataStore mapDataStore, RenderThemeFuture renderThemeFuture, DisplayModel displayModel, float f3, boolean z3, boolean z4) {
        super(tile, z3);
        if (mapDataStore == null) {
            throw new IllegalArgumentException("mapFile must not be null");
        }
        if (f3 <= BitmapDescriptorFactory.HUE_RED || Float.isNaN(f3)) {
            throw new IllegalArgumentException("invalid textScale: " + f3);
        }
        this.labelsOnly = z4;
        this.displayModel = displayModel;
        this.mapDataStore = mapDataStore;
        this.renderThemeFuture = renderThemeFuture;
        this.textScale = f3;
        this.hashCodeValue = calculateHashCode();
    }

    private int calculateHashCode() {
        int hashCode = (((super.hashCode() * 31) + this.mapDataStore.hashCode()) * 31) + Float.floatToIntBits(this.textScale);
        RenderThemeFuture renderThemeFuture = this.renderThemeFuture;
        return renderThemeFuture != null ? (hashCode * 31) + renderThemeFuture.hashCode() : hashCode;
    }

    @Override // org.mapsforge.map.layer.queue.Job
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || !(obj instanceof RendererJob)) {
            return false;
        }
        RendererJob rendererJob = (RendererJob) obj;
        if (!this.mapDataStore.equals(rendererJob.mapDataStore) || Float.floatToIntBits(this.textScale) != Float.floatToIntBits(rendererJob.textScale)) {
            return false;
        }
        RenderThemeFuture renderThemeFuture = this.renderThemeFuture;
        if (renderThemeFuture != null || rendererJob.renderThemeFuture == null) {
            return (renderThemeFuture == null || renderThemeFuture.equals(rendererJob.renderThemeFuture)) && this.labelsOnly == rendererJob.labelsOnly && this.displayModel.equals(rendererJob.displayModel);
        }
        return false;
    }

    @Override // org.mapsforge.map.layer.queue.Job
    public int hashCode() {
        return this.hashCodeValue;
    }

    public RendererJob otherTile(Tile tile) {
        return new RendererJob(tile, this.mapDataStore, this.renderThemeFuture, this.displayModel, this.textScale, this.hasAlpha, this.labelsOnly);
    }

    public void setRetrieveLabelsOnly() {
        this.labelsOnly = true;
    }
}
