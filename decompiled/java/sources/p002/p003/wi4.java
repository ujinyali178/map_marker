package p002.p003;

import android.app.AlertDialog;
import android.view.View;

/* loaded from: /root/release/classes2.dex */
class wi4 implements View.OnClickListener {
    private final AlertDialog val$create;

    wi4(AlertDialog alertDialog) {
        this.val$create = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.val$create.dismiss();
    }
}
