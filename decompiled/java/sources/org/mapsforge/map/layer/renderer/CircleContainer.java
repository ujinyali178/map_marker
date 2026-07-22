package org.mapsforge.map.layer.renderer;

import org.mapsforge.core.model.Point;

/* loaded from: /root/release/classes2.dex */
class CircleContainer implements ShapeContainer {
    final Point point;
    final float radius;

    CircleContainer(Point point, float f3) {
        this.point = point;
        this.radius = f3;
    }

    @Override // org.mapsforge.map.layer.renderer.ShapeContainer
    public ShapeType getShapeType() {
        return ShapeType.CIRCLE;
    }
}
