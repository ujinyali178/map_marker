package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zam;

/* loaded from: /root/release/classes.dex */
public abstract class zag {
    final zad zaa;
    protected int zab;

    public zag(Uri uri, int i3) {
        this.zab = 0;
        this.zaa = new zad(uri);
        this.zab = i3;
    }

    protected abstract void zaa(Drawable drawable, boolean z3, boolean z4, boolean z5);

    final void zab(Context context, zam zamVar, boolean z3) {
        int i3 = this.zab;
        zaa(i3 != 0 ? context.getResources().getDrawable(i3) : null, z3, false, false);
    }

    final void zac(Context context, Bitmap bitmap, boolean z3) {
        Asserts.checkNotNull(bitmap);
        zaa(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
