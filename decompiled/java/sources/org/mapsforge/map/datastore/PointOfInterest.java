package org.mapsforge.map.datastore;

import com.google.common.base.Ascii;
import java.util.List;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Tag;

/* loaded from: /root/release/classes2.dex */
public class PointOfInterest {
    public final byte layer;
    public final LatLong position;
    public final List<Tag> tags;

    public PointOfInterest(byte b4, List<Tag> list, LatLong latLong) {
        this.layer = b4;
        this.tags = list;
        this.position = latLong;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointOfInterest)) {
            return false;
        }
        PointOfInterest pointOfInterest = (PointOfInterest) obj;
        return this.layer == pointOfInterest.layer && this.tags.equals(pointOfInterest.tags) && this.position.equals(pointOfInterest.position);
    }

    public int hashCode() {
        return ((((this.layer + Ascii.US) * 31) + this.tags.hashCode()) * 31) + this.position.hashCode();
    }
}
