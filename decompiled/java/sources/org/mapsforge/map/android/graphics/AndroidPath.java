package org.mapsforge.map.android.graphics;

import android.graphics.Path;
import org.mapsforge.core.graphics.FillRule;
import org.mapsforge.core.graphics.Path;

/* loaded from: /root/release/classes2.dex */
class AndroidPath implements Path {
    final android.graphics.Path path = new android.graphics.Path();

    /* renamed from: org.mapsforge.map.android.graphics.AndroidPath$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$core$graphics$FillRule;

        static {
            int[] iArr = new int[FillRule.values().length];
            $SwitchMap$org$mapsforge$core$graphics$FillRule = iArr;
            try {
                iArr[FillRule.EVEN_ODD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$FillRule[FillRule.NON_ZERO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    AndroidPath() {
    }

    private static Path.FillType getWindingRule(FillRule fillRule) {
        int i3 = AnonymousClass1.$SwitchMap$org$mapsforge$core$graphics$FillRule[fillRule.ordinal()];
        if (i3 == 1) {
            return Path.FillType.EVEN_ODD;
        }
        if (i3 == 2) {
            return Path.FillType.WINDING;
        }
        throw new IllegalArgumentException("unknown fill rule:" + fillRule);
    }

    @Override // org.mapsforge.core.graphics.Path
    public void clear() {
        this.path.rewind();
    }

    @Override // org.mapsforge.core.graphics.Path
    public void close() {
        this.path.close();
    }

    @Override // org.mapsforge.core.graphics.Path
    public boolean isEmpty() {
        return this.path.isEmpty();
    }

    @Override // org.mapsforge.core.graphics.Path
    public void lineTo(float f3, float f4) {
        this.path.lineTo(f3, f4);
    }

    @Override // org.mapsforge.core.graphics.Path
    public void moveTo(float f3, float f4) {
        this.path.moveTo(f3, f4);
    }

    @Override // org.mapsforge.core.graphics.Path
    public void setFillRule(FillRule fillRule) {
        this.path.setFillType(getWindingRule(fillRule));
    }
}
