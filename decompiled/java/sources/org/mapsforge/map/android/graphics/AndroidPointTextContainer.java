package org.mapsforge.map.android.graphics;

import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.mapsforge.core.graphics.Display;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Position;
import org.mapsforge.core.mapelements.PointTextContainer;
import org.mapsforge.core.mapelements.SymbolContainer;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.model.Rectangle;

/* loaded from: /root/release/classes2.dex */
public class AndroidPointTextContainer extends PointTextContainer {
    private StaticLayout backLayout;
    private StaticLayout frontLayout;

    /* renamed from: org.mapsforge.map.android.graphics.AndroidPointTextContainer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$core$graphics$Position;

        static {
            int[] iArr = new int[Position.values().length];
            $SwitchMap$org$mapsforge$core$graphics$Position = iArr;
            try {
                iArr[Position.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Position[Position.BELOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Position[Position.BELOW_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Position[Position.BELOW_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Position[Position.ABOVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Position[Position.ABOVE_LEFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Position[Position.ABOVE_RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Position[Position.LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Position[Position.RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    AndroidPointTextContainer(Point point, Display display, int i3, String str, Paint paint, Paint paint2, SymbolContainer symbolContainer, Position position, int i4) {
        super(point, display, i3, str, paint, paint2, symbolContainer, position, i4);
        float f3;
        int i5;
        Rectangle rectangle;
        int i6 = this.textWidth;
        if (i6 > this.maxTextWidth) {
            TextPaint textPaint = new TextPaint(AndroidGraphicFactory.getPaint(this.paintFront));
            TextPaint textPaint2 = this.paintBack != null ? new TextPaint(AndroidGraphicFactory.getPaint(this.paintBack)) : null;
            Layout.Alignment alignment = Layout.Alignment.ALIGN_CENTER;
            Position position2 = Position.LEFT;
            Position position3 = this.position;
            if (position2 == position3 || Position.BELOW_LEFT == position3 || Position.ABOVE_LEFT == position3) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (Position.RIGHT == position3 || Position.BELOW_RIGHT == position3 || Position.ABOVE_RIGHT == position3) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            }
            textPaint.setTextAlign(Paint.Align.LEFT);
            if (this.paintBack != null) {
                textPaint2.setTextAlign(Paint.Align.LEFT);
            }
            this.frontLayout = new StaticLayout(this.text, textPaint, this.maxTextWidth, alignment, 1.0f, BitmapDescriptorFactory.HUE_RED, false);
            this.backLayout = null;
            if (this.paintBack != null) {
                this.backLayout = new StaticLayout(this.text, textPaint2, this.maxTextWidth, alignment, 1.0f, BitmapDescriptorFactory.HUE_RED, false);
            }
            f3 = this.frontLayout.getWidth();
            i5 = this.frontLayout.getHeight();
        } else {
            f3 = i6;
            i5 = this.textHeight;
        }
        float f4 = i5;
        switch (AnonymousClass1.$SwitchMap$org$mapsforge$core$graphics$Position[this.position.ordinal()]) {
            case 1:
                rectangle = new Rectangle((-f3) / 2.0f, (-f4) / 2.0f, f3 / 2.0f, f4 / 2.0f);
                break;
            case 2:
                rectangle = new Rectangle((-f3) / 2.0f, 0.0d, f3 / 2.0f, f4);
                break;
            case 3:
                rectangle = new Rectangle(-f3, 0.0d, 0.0d, f4);
                break;
            case 4:
                rectangle = new Rectangle(0.0d, 0.0d, f3, f4);
                break;
            case 5:
                rectangle = new Rectangle((-f3) / 2.0f, -f4, f3 / 2.0f, 0.0d);
                break;
            case 6:
                rectangle = new Rectangle(-f3, -f4, 0.0d, 0.0d);
                break;
            case 7:
                rectangle = new Rectangle(0.0d, -f4, f3, 0.0d);
                break;
            case 8:
                rectangle = new Rectangle(-f3, (-f4) / 2.0f, 0.0d, f4 / 2.0f);
                break;
            case 9:
                rectangle = new Rectangle(0.0d, (-f4) / 2.0f, f3, f4 / 2.0f);
                break;
            default:
                return;
        }
        this.boundary = rectangle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a5, code lost:
    
        if (r0 != 9) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @Override // org.mapsforge.core.mapelements.MapElementContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(org.mapsforge.core.graphics.Canvas r7, org.mapsforge.core.model.Point r8, org.mapsforge.core.graphics.Matrix r9, org.mapsforge.core.graphics.Filter r10) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mapsforge.map.android.graphics.AndroidPointTextContainer.draw(org.mapsforge.core.graphics.Canvas, org.mapsforge.core.model.Point, org.mapsforge.core.graphics.Matrix, org.mapsforge.core.graphics.Filter):void");
    }
}
