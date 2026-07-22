package cr.iiiiiiiiii;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.util.Log;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Dialog Maker */
/* renamed from: cr.iiiiiiiiii.iiiiiiiiii, reason: case insensitive filesystem */
/* loaded from: /root/release/classes.dex */
public class DialogInterfaceOnClickListenerC0116iiiiiiiiii implements DialogInterface.OnClickListener {
    public static Object iiiiiiiiiI() {
        return new String("Dismissed".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiiii() {
        return new String("Dialog".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiiil() {
        return new String("Dialog Cancelled".getBytes(), StandardCharsets.UTF_8);
    }

    protected void iiiiiiiiii(Object obj) {
        if (obj instanceof AlertDialog) {
            ((AlertDialog) obj).dismiss();
        } else if (obj instanceof Dialog) {
            ((Dialog) obj).dismiss();
        } else {
            ((DialogInterface) obj).dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        iiiiiiiiii(dialogInterface);
        Log.i(iiiiiiiiii().toString(), iiiiiiiiiI().toString());
        Logger.getGlobal().log(Level.INFO, iiiiiiiiil().toString());
    }
}
