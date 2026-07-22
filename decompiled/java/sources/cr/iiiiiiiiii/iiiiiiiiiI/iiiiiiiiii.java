package cr.iiiiiiiiii.iiiiiiiiiI;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Process;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cr.iiiiiiiiii.DialogInterfaceOnClickListenerC0116iiiiiiiiii;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/* compiled from: Dialog Maker */
/* loaded from: /root/release/classes.dex */
public class iiiiiiiiii {
    public static Object iiiiiiiIII() {
        return new String("Error: failed to decode one or multiple special characters".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiIIi() {
        return new String("UTF-8".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiIiI() {
        return new String("isShowing".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiIii() {
        return new String("logo.png".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiIil() {
        return new String("show".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiiII() {
        return new String("#FF8BC368".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiiIi() {
        return new String("#FF2196F3".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiiIl() {
        return new String("#FFFFFFFF".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiiiI() {
        return new String("GoogleSans-Regular.ttf".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiiii() {
        return new String("files_dir".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiiil() {
        return new String("#FF888888".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiilI() {
        return new String("Canale Telegram".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiili() {
        return new String("Per+non+perderti+altre+mie+mod+seguimi+su+Telegram+%E2%99%A5%EF%B8%8F".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiill() {
        return new String("Ignora".getBytes(), StandardCharsets.UTF_8);
    }

    public static Object iiiiiiiiii(Context context) {
        Bitmap bitmap = null;
        if (0 == 0) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), 0);
            String obj = iiiiiiiiii().toString();
            if (!sharedPreferences.getString(obj, "").equals("")) {
                return null;
            }
            sharedPreferences.edit().putString(obj, context.getFilesDir().getAbsolutePath()).apply();
        }
        Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), iiiiiiiiiI().toString());
        ImageView imageView = new ImageView(context);
        int parseColor = Color.parseColor(iiiiiiiiil().toString());
        int parseColor2 = Color.parseColor(iiiiiiiiIi().toString());
        int parseColor3 = Color.parseColor(iiiiiiiiII().toString());
        int parseColor4 = Color.parseColor(iiiiiiiiIl().toString());
        AlertDialog create = new AlertDialog.Builder(context, R.style.Theme.Material.Light.Dialog.NoActionBar.MinWidth).setCustomTitle(imageView).setMessage(iiiiiiiili().toString()).setPositiveButton(iiiiiiiilI().toString(), new cr.iiiiiiiiii()).setNeutralButton(iiiiiiiill().toString(), new DialogInterfaceOnClickListenerC0116iiiiiiiiii()).setCancelable(false).create();
        cr.iiiiiiiiiI.iiiiiiiiii iiiiiiiiii = new cr.iiiiiiiiiI.iiiiiiiiii().iiiiiiiiii(parseColor4, 20);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        create.getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        try {
            bitmap = BitmapFactory.decodeStream(context.getAssets().open(iiiiiiiIii().toString()));
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            float f3 = width / height;
            float f4 = height / width;
            if (height > 600.0f) {
                bitmap = Bitmap.createScaledBitmap(bitmap, (int) (f3 * 600.0f), (int) 600.0f, true);
            }
            float f5 = displayMetrics.widthPixels - 300;
            if (bitmap.getWidth() > f5) {
                bitmap = Bitmap.createScaledBitmap(bitmap, (int) f5, (int) (f5 * f4), true);
            }
        } catch (IOException unused) {
            Process.killProcess(Process.myPid());
        }
        imageView.setImageBitmap(bitmap);
        imageView.setClipToOutline(true);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackground(iiiiiiiiii);
        imageView.setPadding(0, 0, 0, (int) TypedValue.applyDimension(1, 12.0f, displayMetrics));
        create.getWindow().setBackgroundDrawable(new cr.iiiiiiiiiI.iiiiiiiiii().iiiiiiiiii(parseColor4, 20));
        create.show();
        if (!create.isShowing()) {
            create.show();
        }
        try {
            if (create.getClass().getMethod(iiiiiiiIiI().toString(), new Class[0]).invoke(create, new Object[0]) == Boolean.FALSE) {
                create.getClass().getMethod(iiiiiiiIil().toString(), new Class[0]).invoke(create, new Object[0]);
            }
        } catch (Exception unused2) {
            Runtime.getRuntime().exit(1);
        }
        create.getWindow().setLayout(bitmap.getWidth(), -2);
        TextView textView = (TextView) create.findViewById(R.id.message);
        Button button = (Button) create.findViewById(R.id.button1);
        Button button2 = (Button) create.findViewById(R.id.button3);
        try {
            textView.setText(URLDecoder.decode(textView.getText().toString(), iiiiiiiIIi().toString()));
        } catch (Exception unused3) {
            textView.setText(iiiiiiiIII().toString());
        }
        textView.setTextAlignment(1);
        textView.setGravity(17);
        textView.setTextColor(parseColor);
        button.setTextColor(parseColor2);
        button2.setTextColor(parseColor3);
        textView.setTypeface(createFromAsset);
        button.setTypeface(createFromAsset);
        button2.setTypeface(createFromAsset);
        return createFromAsset;
    }
}
