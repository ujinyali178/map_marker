package cr.iiiiiiiiiI;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

/* compiled from: Dialog Maker */
/* loaded from: /root/release/classes.dex */
public class iiiiiiiiii extends GradientDrawable {
    public iiiiiiiiii() {
        iiiiiiiiii(-1);
        iiiiiiiiii(false);
    }

    public iiiiiiiiii iiiiiiiiii(int i3, int i4) {
        setColor(i3);
        setCornerRadius(i4);
        iiiiiiiiii(i3);
        iiiiiiiiii(true);
        return this;
    }

    private void iiiiiiiiii(int i3) {
        setTint(i3);
        setAlpha(255);
    }

    private void iiiiiiiiii(boolean z3) {
        setAutoMirrored(z3);
        setStroke(0, Color.argb(100, 125, 127, 95));
    }
}
