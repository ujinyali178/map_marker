package p002.p003;

import android.text.TextPaint;
import android.text.style.UnderlineSpan;

/* loaded from: /root/release/classes2.dex */
class bl0 extends UnderlineSpan {
    bl0() {
    }

    @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
    }
}
