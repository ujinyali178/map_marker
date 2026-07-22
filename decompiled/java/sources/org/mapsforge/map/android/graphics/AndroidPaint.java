package org.mapsforge.map.android.graphics;

import android.graphics.BitmapShader;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.mapsforge.core.graphics.Align;
import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.Cap;
import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.FontFamily;
import org.mapsforge.core.graphics.FontStyle;
import org.mapsforge.core.graphics.Join;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Style;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.util.Parameters;

/* loaded from: /root/release/classes2.dex */
class AndroidPaint implements Paint {
    final android.graphics.Paint paint;
    private final Rect rect = new Rect();
    private int shaderHeight;
    private int shaderWidth;

    /* renamed from: org.mapsforge.map.android.graphics.AndroidPaint$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$core$graphics$Align;
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$core$graphics$Cap;
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$core$graphics$FontFamily;
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$core$graphics$FontStyle;
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$core$graphics$Join;
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$core$graphics$Style;

        static {
            int[] iArr = new int[FontFamily.values().length];
            $SwitchMap$org$mapsforge$core$graphics$FontFamily = iArr;
            try {
                iArr[FontFamily.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$FontFamily[FontFamily.MONOSPACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$FontFamily[FontFamily.SANS_SERIF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$FontFamily[FontFamily.SERIF.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[FontStyle.values().length];
            $SwitchMap$org$mapsforge$core$graphics$FontStyle = iArr2;
            try {
                iArr2[FontStyle.BOLD.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$FontStyle[FontStyle.BOLD_ITALIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$FontStyle[FontStyle.ITALIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$FontStyle[FontStyle.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[Style.values().length];
            $SwitchMap$org$mapsforge$core$graphics$Style = iArr3;
            try {
                iArr3[Style.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Style[Style.STROKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr4 = new int[Join.values().length];
            $SwitchMap$org$mapsforge$core$graphics$Join = iArr4;
            try {
                iArr4[Join.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Join[Join.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Join[Join.MITER.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr5 = new int[Cap.values().length];
            $SwitchMap$org$mapsforge$core$graphics$Cap = iArr5;
            try {
                iArr5[Cap.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Cap[Cap.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Cap[Cap.SQUARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            int[] iArr6 = new int[Align.values().length];
            $SwitchMap$org$mapsforge$core$graphics$Align = iArr6;
            try {
                iArr6[Align.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Align[Align.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Align[Align.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    AndroidPaint() {
        android.graphics.Paint paint = new android.graphics.Paint();
        this.paint = paint;
        paint.setAntiAlias(Parameters.ANTI_ALIASING);
        paint.setStrokeCap(getAndroidCap(Cap.ROUND));
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(getAndroidStyle(Style.FILL));
    }

    AndroidPaint(org.mapsforge.core.graphics.Paint paint) {
        this.paint = new android.graphics.Paint(((AndroidPaint) paint).paint);
    }

    private static Paint.Align getAndroidAlign(Align align) {
        int i3 = AnonymousClass1.$SwitchMap$org$mapsforge$core$graphics$Align[align.ordinal()];
        if (i3 == 1) {
            return Paint.Align.CENTER;
        }
        if (i3 == 2) {
            return Paint.Align.LEFT;
        }
        if (i3 == 3) {
            return Paint.Align.RIGHT;
        }
        throw new IllegalArgumentException("unknown align: " + align);
    }

    private static Paint.Cap getAndroidCap(Cap cap) {
        int i3 = AnonymousClass1.$SwitchMap$org$mapsforge$core$graphics$Cap[cap.ordinal()];
        if (i3 == 1) {
            return Paint.Cap.BUTT;
        }
        if (i3 == 2) {
            return Paint.Cap.ROUND;
        }
        if (i3 == 3) {
            return Paint.Cap.SQUARE;
        }
        throw new IllegalArgumentException("unknown cap: " + cap);
    }

    private static Paint.Join getAndroidJoin(Join join) {
        int i3 = AnonymousClass1.$SwitchMap$org$mapsforge$core$graphics$Join[join.ordinal()];
        if (i3 == 1) {
            return Paint.Join.BEVEL;
        }
        if (i3 == 2) {
            return Paint.Join.ROUND;
        }
        if (i3 == 3) {
            return Paint.Join.MITER;
        }
        throw new IllegalArgumentException("unknown join: " + join);
    }

    private static Paint.Style getAndroidStyle(Style style) {
        int i3 = AnonymousClass1.$SwitchMap$org$mapsforge$core$graphics$Style[style.ordinal()];
        if (i3 == 1) {
            return Paint.Style.FILL;
        }
        if (i3 == 2) {
            return Paint.Style.STROKE;
        }
        throw new IllegalArgumentException("unknown style: " + style);
    }

    private static int getFontStyle(FontStyle fontStyle) {
        int i3 = AnonymousClass1.$SwitchMap$org$mapsforge$core$graphics$FontStyle[fontStyle.ordinal()];
        int i4 = 1;
        if (i3 != 1) {
            i4 = 3;
            if (i3 != 2) {
                if (i3 == 3) {
                    return 2;
                }
                if (i3 == 4) {
                    return 0;
                }
                throw new IllegalArgumentException("unknown font style: " + fontStyle);
            }
        }
        return i4;
    }

    private static Typeface getTypeface(FontFamily fontFamily) {
        int i3 = AnonymousClass1.$SwitchMap$org$mapsforge$core$graphics$FontFamily[fontFamily.ordinal()];
        if (i3 == 1) {
            return Typeface.DEFAULT;
        }
        if (i3 == 2) {
            return Typeface.MONOSPACE;
        }
        if (i3 == 3) {
            return Typeface.SANS_SERIF;
        }
        if (i3 == 4) {
            return Typeface.SERIF;
        }
        throw new IllegalArgumentException("unknown font family: " + fontFamily);
    }

    @Override // org.mapsforge.core.graphics.Paint
    public int getColor() {
        return this.paint.getColor();
    }

    @Override // org.mapsforge.core.graphics.Paint
    public float getStrokeWidth() {
        return this.paint.getStrokeWidth();
    }

    @Override // org.mapsforge.core.graphics.Paint
    public int getTextHeight(String str) {
        this.paint.getTextBounds(str, 0, str.length(), this.rect);
        return this.rect.height();
    }

    @Override // org.mapsforge.core.graphics.Paint
    public int getTextWidth(String str) {
        return (int) this.paint.measureText(str);
    }

    @Override // org.mapsforge.core.graphics.Paint
    public boolean isTransparent() {
        return this.paint.getShader() == null && this.paint.getAlpha() == 0;
    }

    @Override // org.mapsforge.core.graphics.Paint
    public void setBitmapShader(Bitmap bitmap) {
        android.graphics.Bitmap bitmap2;
        if (bitmap == null || (bitmap2 = AndroidGraphicFactory.getBitmap(bitmap)) == null) {
            return;
        }
        this.shaderWidth = bitmap.getWidth();
        this.shaderHeight = bitmap.getHeight();
        this.paint.setColor(AndroidGraphicFactory.getColor(Color.WHITE));
        android.graphics.Paint paint = this.paint;
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        paint.setShader(new BitmapShader(bitmap2, tileMode, tileMode));
    }

    @Override // org.mapsforge.core.graphics.Paint
    public void setBitmapShaderShift(Point point) {
        Shader shader = this.paint.getShader();
        if (shader != null) {
            int i3 = ((int) (-point.f4076x)) % this.shaderWidth;
            int i4 = ((int) (-point.f4077y)) % this.shaderHeight;
            Matrix matrix = new Matrix();
            matrix.setTranslate(i3, i4);
            shader.setLocalMatrix(matrix);
        }
    }

    @Override // org.mapsforge.core.graphics.Paint
    public void setColor(int i3) {
        this.paint.setColor(i3);
    }

    @Override // org.mapsforge.core.graphics.Paint
    public void setColor(Color color) {
        this.paint.setColor(AndroidGraphicFactory.getColor(color));
    }

    @Override // org.mapsforge.core.graphics.Paint
    public void setDashPathEffect(float[] fArr) {
        this.paint.setPathEffect(new DashPathEffect(fArr, BitmapDescriptorFactory.HUE_RED));
    }

    @Override // org.mapsforge.core.graphics.Paint
    public void setStrokeCap(Cap cap) {
        this.paint.setStrokeCap(getAndroidCap(cap));
    }

    @Override // org.mapsforge.core.graphics.Paint
    public void setStrokeJoin(Join join) {
        this.paint.setStrokeJoin(getAndroidJoin(join));
    }

    @Override // org.mapsforge.core.graphics.Paint
    public void setStrokeWidth(float f3) {
        this.paint.setStrokeWidth(f3);
    }

    @Override // org.mapsforge.core.graphics.Paint
    public void setStyle(Style style) {
        this.paint.setStyle(getAndroidStyle(style));
    }

    @Override // org.mapsforge.core.graphics.Paint
    public void setTextAlign(Align align) {
        this.paint.setTextAlign(getAndroidAlign(align));
    }

    @Override // org.mapsforge.core.graphics.Paint
    public void setTextSize(float f3) {
        this.paint.setTextSize(f3);
    }

    @Override // org.mapsforge.core.graphics.Paint
    public void setTypeface(FontFamily fontFamily, FontStyle fontStyle) {
        this.paint.setTypeface(Typeface.create(getTypeface(fontFamily), getFontStyle(fontStyle)));
    }
}
