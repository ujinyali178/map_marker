package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;

/* loaded from: /root/release/classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(androidx.versionedparcelable.a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f668a = aVar.p(iconCompat.f668a, 1);
        iconCompat.f670c = aVar.j(iconCompat.f670c, 2);
        iconCompat.f671d = aVar.r(iconCompat.f671d, 3);
        iconCompat.f672e = aVar.p(iconCompat.f672e, 4);
        iconCompat.f673f = aVar.p(iconCompat.f673f, 5);
        iconCompat.f674g = (ColorStateList) aVar.r(iconCompat.f674g, 6);
        iconCompat.f676i = aVar.t(iconCompat.f676i, 7);
        iconCompat.f677j = aVar.t(iconCompat.f677j, 8);
        iconCompat.o();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(true, true);
        iconCompat.p(aVar.f());
        int i3 = iconCompat.f668a;
        if (-1 != i3) {
            aVar.F(i3, 1);
        }
        byte[] bArr = iconCompat.f670c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f671d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i4 = iconCompat.f672e;
        if (i4 != 0) {
            aVar.F(i4, 4);
        }
        int i5 = iconCompat.f673f;
        if (i5 != 0) {
            aVar.F(i5, 5);
        }
        ColorStateList colorStateList = iconCompat.f674g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f676i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f677j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
