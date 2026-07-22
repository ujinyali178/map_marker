package cr;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Dialog Maker */
/* loaded from: /root/release/classes.dex */
public class iiiiiiiiii implements DialogInterface.OnClickListener {
    public static Object iiiiiiiiII() {
        return new String("Dialog Channel Link Clicked".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiiIi() {
        return new String("Redirected".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiiiI() {
        return new String("android.intent.action.VIEW".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiiii() {
        return new String("https://t.me/ApplicazioniCR".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiiil() {
        return new String("Dialog".getBytes(), StandardCharsets.UTF_8);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        ((Dialog) dialogInterface).getContext().startActivity(new Intent(iiiiiiiiiI().toString(), Uri.parse(iiiiiiiiii().toString())));
        Log.i(iiiiiiiiil().toString(), iiiiiiiiIi().toString());
        Logger.getGlobal().log(Level.INFO, iiiiiiiiII().toString());
    }
}
