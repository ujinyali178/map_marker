package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: /root/release/classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f667k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f668a;

    /* renamed from: b, reason: collision with root package name */
    Object f669b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f670c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f671d;

    /* renamed from: e, reason: collision with root package name */
    public int f672e;

    /* renamed from: f, reason: collision with root package name */
    public int f673f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f674g;

    /* renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f675h;

    /* renamed from: i, reason: collision with root package name */
    public String f676i;

    /* renamed from: j, reason: collision with root package name */
    public String f677j;

    static class a {
        static IconCompat a(Object obj) {
            androidx.core.util.d.e(obj);
            int d3 = d(obj);
            if (d3 == 2) {
                return IconCompat.h(null, c(obj), b(obj));
            }
            if (d3 == 4) {
                return IconCompat.e(e(obj));
            }
            if (d3 == 6) {
                return IconCompat.c(e(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f669b = obj;
            return iconCompat;
        }

        static int b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e3) {
                Log.e("IconCompat", "Unable to get icon resource", e3);
                return 0;
            } catch (NoSuchMethodException e4) {
                Log.e("IconCompat", "Unable to get icon resource", e4);
                return 0;
            } catch (InvocationTargetException e5) {
                Log.e("IconCompat", "Unable to get icon resource", e5);
                return 0;
            }
        }

        static String c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e3) {
                Log.e("IconCompat", "Unable to get icon package", e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.e("IconCompat", "Unable to get icon package", e4);
                return null;
            } catch (InvocationTargetException e5) {
                Log.e("IconCompat", "Unable to get icon package", e5);
                return null;
            }
        }

        static int d(Object obj) {
            StringBuilder sb;
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e3) {
                e = e3;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            } catch (NoSuchMethodException e4) {
                e = e4;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            } catch (InvocationTargetException e5) {
                e = e5;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            }
        }

        static Uri e(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e3) {
                Log.e("IconCompat", "Unable to get icon uri", e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.e("IconCompat", "Unable to get icon uri", e4);
                return null;
            } catch (InvocationTargetException e5) {
                Log.e("IconCompat", "Unable to get icon uri", e5);
                return null;
            }
        }

        static Drawable f(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x002c, code lost:
        
            if (r0 >= 26) goto L22;
         */
        /* JADX WARN: Removed duplicated region for block: B:11:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x00b1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        static android.graphics.drawable.Icon g(androidx.core.graphics.drawable.IconCompat r4, android.content.Context r5) {
            /*
                int r0 = r4.f668a
                r1 = 0
                r2 = 26
                switch(r0) {
                    case -1: goto Lb5;
                    case 0: goto L8;
                    case 1: goto L9c;
                    case 2: goto L91;
                    case 3: goto L84;
                    case 4: goto L7b;
                    case 5: goto L65;
                    case 6: goto L10;
                    default: goto L8;
                }
            L8:
                java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
                java.lang.String r5 = "Unknown type"
                r4.<init>(r5)
                throw r4
            L10:
                int r0 = android.os.Build.VERSION.SDK_INT
                r3 = 30
                if (r0 < r3) goto L20
                android.net.Uri r5 = r4.m()
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.IconCompat.d.a(r5)
                goto La4
            L20:
                if (r5 == 0) goto L4a
                java.io.InputStream r5 = r4.n(r5)
                if (r5 == 0) goto L2f
                android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r5)
                if (r0 < r2) goto L76
                goto L6d
            L2f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Cannot load adaptive icon from uri: "
                r0.append(r1)
                android.net.Uri r4 = r4.m()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r5.<init>(r4)
                throw r5
            L4a:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Context is required to resolve the file uri of the icon: "
                r0.append(r1)
                android.net.Uri r4 = r4.m()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r5.<init>(r4)
                throw r5
            L65:
                int r5 = android.os.Build.VERSION.SDK_INT
                if (r5 < r2) goto L72
                java.lang.Object r5 = r4.f669b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            L6d:
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.IconCompat.b.b(r5)
                goto La4
            L72:
                java.lang.Object r5 = r4.f669b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            L76:
                android.graphics.Bitmap r5 = androidx.core.graphics.drawable.IconCompat.b(r5, r1)
                goto La0
            L7b:
                java.lang.Object r5 = r4.f669b
                java.lang.String r5 = (java.lang.String) r5
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithContentUri(r5)
                goto La4
            L84:
                java.lang.Object r5 = r4.f669b
                byte[] r5 = (byte[]) r5
                int r0 = r4.f672e
                int r1 = r4.f673f
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithData(r5, r0, r1)
                goto La4
            L91:
                java.lang.String r5 = r4.k()
                int r0 = r4.f672e
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithResource(r5, r0)
                goto La4
            L9c:
                java.lang.Object r5 = r4.f669b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            La0:
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithBitmap(r5)
            La4:
                android.content.res.ColorStateList r0 = r4.f674g
                if (r0 == 0) goto Lab
                r5.setTintList(r0)
            Lab:
                android.graphics.PorterDuff$Mode r4 = r4.f675h
                android.graphics.PorterDuff$Mode r0 = androidx.core.graphics.drawable.IconCompat.f667k
                if (r4 == r0) goto Lb4
                r5.setTintMode(r4)
            Lb4:
                return r5
            Lb5:
                java.lang.Object r4 = r4.f669b
                android.graphics.drawable.Icon r4 = (android.graphics.drawable.Icon) r4
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.a.g(androidx.core.graphics.drawable.IconCompat, android.content.Context):android.graphics.drawable.Icon");
        }
    }

    static class b {
        static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        static Icon b(Bitmap bitmap) {
            Icon createWithAdaptiveBitmap;
            createWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
            return createWithAdaptiveBitmap;
        }
    }

    static class c {
        static int a(Object obj) {
            int resId;
            resId = ((Icon) obj).getResId();
            return resId;
        }

        static String b(Object obj) {
            String resPackage;
            resPackage = ((Icon) obj).getResPackage();
            return resPackage;
        }

        static int c(Object obj) {
            int type;
            type = ((Icon) obj).getType();
            return type;
        }

        static Uri d(Object obj) {
            Uri uri;
            uri = ((Icon) obj).getUri();
            return uri;
        }
    }

    static class d {
        static Icon a(Uri uri) {
            Icon createWithAdaptiveBitmapContentUri;
            createWithAdaptiveBitmapContentUri = Icon.createWithAdaptiveBitmapContentUri(uri);
            return createWithAdaptiveBitmapContentUri;
        }
    }

    public IconCompat() {
        this.f668a = -1;
        this.f670c = null;
        this.f671d = null;
        this.f672e = 0;
        this.f673f = 0;
        this.f674g = null;
        this.f675h = f667k;
        this.f676i = null;
    }

    IconCompat(int i3) {
        this.f670c = null;
        this.f671d = null;
        this.f672e = 0;
        this.f673f = 0;
        this.f674g = null;
        this.f675h = f667k;
        this.f676i = null;
        this.f668a = i3;
    }

    public static IconCompat a(Icon icon) {
        return a.a(icon);
    }

    static Bitmap b(Bitmap bitmap, boolean z3) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f3 = min;
        float f4 = 0.5f * f3;
        float f5 = 0.9166667f * f4;
        if (z3) {
            float f6 = 0.010416667f * f3;
            paint.setColor(0);
            paint.setShadowLayer(f6, BitmapDescriptorFactory.HUE_RED, f3 * 0.020833334f, 1023410176);
            canvas.drawCircle(f4, f4, f5, paint);
            paint.setShadowLayer(f6, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 503316480);
            canvas.drawCircle(f4, f4, f5, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2.0f, (-(bitmap.getHeight() - min)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f4, f4, f5, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat c(Uri uri) {
        androidx.core.util.b.c(uri);
        return d(uri.toString());
    }

    public static IconCompat d(String str) {
        androidx.core.util.b.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f669b = str;
        return iconCompat;
    }

    public static IconCompat e(Uri uri) {
        androidx.core.util.b.c(uri);
        return f(uri.toString());
    }

    public static IconCompat f(String str) {
        androidx.core.util.b.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f669b = str;
        return iconCompat;
    }

    public static IconCompat g(Context context, int i3) {
        androidx.core.util.b.c(context);
        return h(context.getResources(), context.getPackageName(), i3);
    }

    public static IconCompat h(Resources resources, String str, int i3) {
        androidx.core.util.b.c(str);
        if (i3 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f672e = i3;
        if (resources != null) {
            try {
                iconCompat.f669b = resources.getResourceName(i3);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f669b = str;
        }
        iconCompat.f677j = str;
        return iconCompat;
    }

    private static String t(int i3) {
        switch (i3) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public Bitmap i() {
        int i3 = this.f668a;
        if (i3 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f669b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i3 == 1) {
            return (Bitmap) this.f669b;
        }
        if (i3 == 5) {
            return b((Bitmap) this.f669b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int j() {
        int i3 = this.f668a;
        if (i3 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.b(this.f669b);
        }
        if (i3 == 2) {
            return this.f672e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String k() {
        int i3 = this.f668a;
        if (i3 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.c(this.f669b);
        }
        if (i3 == 2) {
            String str = this.f677j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f669b).split(":", -1)[0] : this.f677j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int l() {
        int i3 = this.f668a;
        return (i3 != -1 || Build.VERSION.SDK_INT < 23) ? i3 : a.d(this.f669b);
    }

    public Uri m() {
        int i3 = this.f668a;
        if (i3 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.e(this.f669b);
        }
        if (i3 == 4 || i3 == 6) {
            return Uri.parse((String) this.f669b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream n(Context context) {
        StringBuilder sb;
        String str;
        Uri m3 = m();
        String scheme = m3.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(m3);
            } catch (Exception e3) {
                e = e3;
                sb = new StringBuilder();
                str = "Unable to load image from URI: ";
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f669b));
            } catch (FileNotFoundException e4) {
                e = e4;
                sb = new StringBuilder();
                str = "Unable to load image from path: ";
            }
        }
        sb.append(str);
        sb.append(m3);
        Log.w("IconCompat", sb.toString(), e);
        return null;
    }

    public void o() {
        Parcelable parcelable;
        this.f675h = PorterDuff.Mode.valueOf(this.f676i);
        switch (this.f668a) {
            case -1:
                parcelable = this.f671d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                parcelable = this.f671d;
                if (parcelable == null) {
                    byte[] bArr = this.f670c;
                    this.f669b = bArr;
                    this.f668a = 3;
                    this.f672e = 0;
                    this.f673f = bArr.length;
                    return;
                }
                break;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f670c, Charset.forName("UTF-16"));
                this.f669b = str;
                if (this.f668a == 2 && this.f677j == null) {
                    this.f677j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f669b = this.f670c;
                return;
        }
        this.f669b = parcelable;
    }

    public void p(boolean z3) {
        this.f676i = this.f675h.name();
        switch (this.f668a) {
            case -1:
                if (z3) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z3) {
                    Bitmap bitmap = (Bitmap) this.f669b;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f670c = byteArrayOutputStream.toByteArray();
                    return;
                }
                break;
            case 2:
                this.f670c = ((String) this.f669b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f670c = (byte[]) this.f669b;
                return;
            case 4:
            case 6:
                this.f670c = this.f669b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
        this.f671d = (Parcelable) this.f669b;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.Bundle q() {
        /*
            r3 = this;
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            int r1 = r3.f668a
            java.lang.String r2 = "obj"
            switch(r1) {
                case -1: goto L29;
                case 0: goto Lc;
                case 1: goto L24;
                case 2: goto L1c;
                case 3: goto L14;
                case 4: goto L1c;
                case 5: goto L24;
                case 6: goto L1c;
                default: goto Lc;
            }
        Lc:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Invalid icon"
            r0.<init>(r1)
            throw r0
        L14:
            java.lang.Object r1 = r3.f669b
            byte[] r1 = (byte[]) r1
            r0.putByteArray(r2, r1)
            goto L30
        L1c:
            java.lang.Object r1 = r3.f669b
            java.lang.String r1 = (java.lang.String) r1
            r0.putString(r2, r1)
            goto L30
        L24:
            java.lang.Object r1 = r3.f669b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            goto L2d
        L29:
            java.lang.Object r1 = r3.f669b
            android.os.Parcelable r1 = (android.os.Parcelable) r1
        L2d:
            r0.putParcelable(r2, r1)
        L30:
            int r1 = r3.f668a
            java.lang.String r2 = "type"
            r0.putInt(r2, r1)
            int r1 = r3.f672e
            java.lang.String r2 = "int1"
            r0.putInt(r2, r1)
            int r1 = r3.f673f
            java.lang.String r2 = "int2"
            r0.putInt(r2, r1)
            java.lang.String r1 = r3.f677j
            java.lang.String r2 = "string1"
            r0.putString(r2, r1)
            android.content.res.ColorStateList r1 = r3.f674g
            if (r1 == 0) goto L55
            java.lang.String r2 = "tint_list"
            r0.putParcelable(r2, r1)
        L55:
            android.graphics.PorterDuff$Mode r1 = r3.f675h
            android.graphics.PorterDuff$Mode r2 = androidx.core.graphics.drawable.IconCompat.f667k
            if (r1 == r2) goto L64
            java.lang.String r1 = r1.name()
            java.lang.String r2 = "tint_mode"
            r0.putString(r2, r1)
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.q():android.os.Bundle");
    }

    @Deprecated
    public Icon r() {
        return s(null);
    }

    public Icon s(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.g(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public String toString() {
        int height;
        if (this.f668a == -1) {
            return String.valueOf(this.f669b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(t(this.f668a));
        switch (this.f668a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f669b).getWidth());
                sb.append("x");
                height = ((Bitmap) this.f669b).getHeight();
                sb.append(height);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f677j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(j())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f672e);
                if (this.f673f != 0) {
                    sb.append(" off=");
                    height = this.f673f;
                    sb.append(height);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f669b);
                break;
        }
        if (this.f674g != null) {
            sb.append(" tint=");
            sb.append(this.f674g);
        }
        if (this.f675h != f667k) {
            sb.append(" mode=");
            sb.append(this.f675h);
        }
        sb.append(")");
        return sb.toString();
    }
}
