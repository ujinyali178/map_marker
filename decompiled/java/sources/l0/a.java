package l0;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import java.io.OutputStream;

/* loaded from: /root/release/classes.dex */
public class a {

    /* renamed from: l0.a$a, reason: collision with other inner class name */
    class RunnableC0094a implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f3906c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3907d;

        RunnableC0094a(Activity activity, String str) {
            this.f3906c = activity;
            this.f3907d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(this.f3906c, this.f3907d, 0).show();
        }
    }

    public static void a(Activity activity, String str) {
        activity.runOnUiThread(new RunnableC0094a(activity, str));
    }

    public static OutputStream b(Context context, Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            return context.getContentResolver().openOutputStream(uri, "w");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
