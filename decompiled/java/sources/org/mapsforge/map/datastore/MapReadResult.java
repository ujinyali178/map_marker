package org.mapsforge.map.datastore;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /root/release/classes2.dex */
public class MapReadResult {
    public boolean isWater;
    public List<PointOfInterest> pointOfInterests = new ArrayList();
    public List<Way> ways = new ArrayList();

    public void add(MapReadResult mapReadResult, boolean z3) {
        if (!z3) {
            this.pointOfInterests.addAll(mapReadResult.pointOfInterests);
            this.ways.addAll(mapReadResult.ways);
            return;
        }
        for (PointOfInterest pointOfInterest : mapReadResult.pointOfInterests) {
            if (!this.pointOfInterests.contains(pointOfInterest)) {
                this.pointOfInterests.add(pointOfInterest);
            }
        }
        for (Way way : mapReadResult.ways) {
            if (!this.ways.contains(way)) {
                this.ways.add(way);
            }
        }
    }

    public void add(PoiWayBundle poiWayBundle) {
        this.pointOfInterests.addAll(poiWayBundle.pois);
        this.ways.addAll(poiWayBundle.ways);
    }
}
