package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.base.zak;
import com.google.android.gms.internal.base.zal;
import java.lang.ref.WeakReference;

/* loaded from: /root/release/classes.dex */
public final class zae extends zag {
    private final WeakReference zac;

    public zae(ImageView imageView, int i3) {
        super(Uri.EMPTY, i3);
        Asserts.checkNotNull(imageView);
        this.zac = new WeakReference(imageView);
    }

    public zae(ImageView imageView, Uri uri) {
        super(uri, 0);
        Asserts.checkNotNull(imageView);
        this.zac = new WeakReference(imageView);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zae)) {
            return false;
        }
        ImageView imageView = (ImageView) this.zac.get();
        ImageView imageView2 = (ImageView) ((zae) obj).zac.get();
        return (imageView2 == null || imageView == null || !Objects.equal(imageView2, imageView)) ? false : true;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.gms.common.images.zag
    protected final void zaa(Drawable drawable, boolean z3, boolean z4, boolean z5) {
        ImageView imageView = (ImageView) this.zac.get();
        if (imageView != null) {
            if (!z4 && !z5 && (imageView instanceof zal)) {
                throw null;
            }
            boolean z6 = false;
            if (!z4 && !z3) {
                z6 = true;
            }
            if (z6) {
                Drawable drawable2 = imageView.getDrawable();
                if (drawable2 == null) {
                    drawable2 = null;
                } else if (drawable2 instanceof zak) {
                    drawable2 = ((zak) drawable2).zaa();
                }
                drawable = new zak(drawable2, drawable);
            }
            imageView.setImageDrawable(drawable);
            if (imageView instanceof zal) {
                throw null;
            }
            if (drawable == null || !z6) {
                return;
            }
            ((zak) drawable).zab(250);
        }
    }
}
