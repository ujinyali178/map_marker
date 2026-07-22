package p002.p003;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import p002.p003.up;

/* loaded from: /root/release/classes2.dex */
class up1 implements Runnable {
    private final Context val$ctx;
    private final StringBuilder val$sb2;
    private final StringBuilder val$sb4;
    private final StringBuilder val$sb5;
    private final StringBuilder val$sb6;
    private final StringBuilder val$sb7;
    private final StringBuilder val$sb8;
    private final StringBuilder val$sb9;

    up1(Context context, StringBuilder sb, StringBuilder sb2, StringBuilder sb3, StringBuilder sb4, StringBuilder sb5, StringBuilder sb6, StringBuilder sb7) {
        this.val$ctx = context;
        this.val$sb9 = sb;
        this.val$sb6 = sb2;
        this.val$sb2 = sb3;
        this.val$sb4 = sb4;
        this.val$sb5 = sb5;
        this.val$sb7 = sb6;
        this.val$sb8 = sb7;
    }

    /* JADX WARN: Type inference failed for: r7v43, types: [ī.íì.up1$100000006] */
    /* JADX WARN: Type inference failed for: r7v45, types: [ī.íì.up1$100000007] */
    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        Activity activity = (Activity) this.val$ctx;
        ArrayList arrayList = new ArrayList();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.val$sb9.toString()).openConnection();
            httpURLConnection.setConnectTimeout(60000);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else {
                    arrayList.add(readLine);
                }
            }
            bufferedReader.close();
            int i3 = Build.VERSION.SDK_INT >= 28 ? 134217728 : 64;
            ApplicationInfo applicationInfo = this.val$ctx.getApplicationInfo();
            PackageInfo packageInfo = this.val$ctx.getPackageManager().getPackageInfo(this.val$ctx.getPackageName(), i3);
            if (applicationInfo != null) {
                String stringBuffer = new StringBuffer().append("v").append(packageInfo.versionName).toString();
                if (Build.VERSION.SDK_INT >= 28) {
                    str = String.valueOf(packageInfo.getLongVersionCode());
                    str2 = stringBuffer;
                } else {
                    str = String.valueOf(packageInfo.versionCode);
                    str2 = stringBuffer;
                }
            } else {
                str = "";
                str2 = "";
            }
            StringBuilder sb = new StringBuilder();
            for (float f3 : new float[]{9.0f, 12.5f}) {
                sb.append((char) (f3 * 4.0f));
            }
            float[] v3 = new up.ok().v();
            StringBuilder sb2 = new StringBuilder();
            for (float f4 : v3) {
                sb2.append((char) (f4 * 4.0f));
            }
            String replaceAll = ((String) arrayList.get(0)).replaceAll(sb2.toString(), sb.toString());
            float[] vc = new up.ok().vc();
            StringBuilder sb3 = new StringBuilder();
            for (float f5 : vc) {
                sb3.append((char) (f5 * 4.0f));
            }
            String replaceAll2 = ((String) arrayList.get(1)).replaceAll(sb3.toString(), sb.toString());
            float[] u3 = new up.ok().u();
            StringBuilder sb4 = new StringBuilder();
            for (float f6 : u3) {
                sb4.append((char) (f6 * 4.0f));
            }
            StringBuilder sb5 = new StringBuilder();
            for (float f7 : new up.ok().bb()) {
                sb5.append((char) (f7 * 4.0f));
            }
            StringBuilder sb6 = new StringBuilder();
            for (float f8 : new float[]{12.25f, 27.25f, 27.75f, 25.0f, 11.5f, 24.75f, 27.75f}) {
                sb6.append((char) (f8 * 4.0f));
            }
            StringBuilder sb7 = new StringBuilder();
            for (float f9 : new float[]{14.25f, 27.25f, 27.75f, 25.0f, 11.5f, 24.75f, 27.75f, 27.25f}) {
                sb7.append((char) (f9 * 4.0f));
            }
            this.val$sb6.toString();
            String sb8 = ((String) arrayList.get(2)) == null ? this.val$sb6.toString() : ((String) arrayList.get(2)).replaceAll(sb4.toString(), sb.toString());
            String replaceAll3 = ((String) arrayList.get(2)) == "" ? sb8 : ((String) arrayList.get(2)).replaceAll(sb4.toString(), sb.toString());
            String str3 = replaceAll3.equals((String) arrayList.get(2)) ? sb8 : replaceAll3;
            if (!str3.contains(sb5.toString()) && !str3.contains(sb6.toString()) && !str3.contains(sb7.toString())) {
                str3 = this.val$sb6.toString();
            }
            Uri parse = Uri.parse(str3);
            AlertDialog create = new AlertDialog.Builder(this.val$ctx).create();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 17;
            layoutParams.weight = 1.0f;
            LinearLayout linearLayout = new LinearLayout(this.val$ctx);
            TextView textView = new TextView(this.val$ctx);
            TextView textView2 = new TextView(this.val$ctx);
            LinearLayout linearLayout2 = new LinearLayout(this.val$ctx);
            TextView textView3 = new TextView(this.val$ctx);
            TextView textView4 = new TextView(this.val$ctx);
            View textView5 = new TextView(this.val$ctx);
            TextView textView6 = new TextView(this.val$ctx);
            boolean parseBoolean = Boolean.parseBoolean(new up.ctr().en()[0]);
            boolean parseBoolean2 = Boolean.parseBoolean(new up.ctr().en()[1]);
            boolean parseBoolean3 = Boolean.parseBoolean(new up.ctr().en()[2]);
            StringBuilder sb9 = new StringBuilder();
            for (float f10 : new float[]{17.0f, 27.75f, 27.5f, 29.0f, 8.0f, 28.75f, 26.0f, 27.75f, 29.75f, 8.0f, 24.25f, 25.75f, 24.25f, 26.25f, 27.5f}) {
                sb9.append((char) (f10 * 4.0f));
            }
            CheckBox checkBox = new CheckBox(this.val$ctx);
            checkBox.setLayoutParams(layoutParams);
            checkBox.setText(sb9);
            checkBox.setTextColor(-65536);
            checkBox.setTypeface(textView.getTypeface(), 1);
            if (Build.VERSION.SDK_INT >= 21) {
                checkBox.setButtonTintList(new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{-1, -1}));
            }
            textView.setGravity(17);
            textView.setLayoutParams(layoutParams);
            textView.setText(this.val$sb2);
            textView2.setLayoutParams(layoutParams);
            StringBuilder sb10 = new StringBuilder();
            for (float f11 : new float[]{19.25f, 25.25f, 28.75f, 28.75f, 24.25f, 25.75f, 25.25f, 15.25f}) {
                sb10.append((char) (f11 * 4.0f));
            }
            StringBuilder sb11 = new StringBuilder();
            for (float f12 : new float[]{22.75f, 29.5f, 25.25f, 28.5f, 28.75f, 26.25f, 27.75f, 27.5f, 23.25f}) {
                sb11.append((char) (f12 * 4.0f));
            }
            StringBuilder sb12 = new StringBuilder();
            for (float f13 : new float[]{22.75f, 24.75f, 27.75f, 25.0f, 25.25f, 23.25f}) {
                sb12.append((char) (f13 * 4.0f));
            }
            StringBuilder sb13 = new StringBuilder();
            for (float f14 : new float[]{10.0f}) {
                sb13.append((char) (f14 * 4.0f));
            }
            StringBuilder sb14 = new StringBuilder();
            for (float f15 : new float[]{10.25f}) {
                sb14.append((char) (f15 * 4.0f));
            }
            StringBuilder sb15 = new StringBuilder();
            for (float f16 : new float[]{24.25f, 27.5f, 25.0f, 28.5f, 27.75f, 26.25f, 25.0f, 11.5f, 29.0f, 25.25f, 30.0f, 29.0f, 11.5f, 28.75f, 29.0f, 30.25f, 27.0f, 25.25f, 11.5f, 21.25f, 20.5f, 19.0f, 20.75f, 28.0f, 24.25f, 27.5f}) {
                sb15.append((char) (f16 * 4.0f));
            }
            String stringBuffer2 = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append((Object) this.val$sb4).append(replaceAll).toString()).append("(").toString()).append(replaceAll2).toString()).append(")").toString()).append((Object) this.val$sb5).toString();
            Spannable spannable = Build.VERSION.SDK_INT >= 24 ? (Spannable) Html.fromHtml(stringBuffer2, 0) : (Spannable) Html.fromHtml(stringBuffer2);
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), Class.forName(sb15.toString()));
            for (URLSpan uRLSpan : uRLSpanArr) {
                spannable.setSpan(new up.und(), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 0);
            }
            textView2.setText(spannable);
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            textView2.setGravity(17);
            textView6.setGravity(17);
            textView3.setText(this.val$sb7);
            textView4.setText(this.val$sb8);
            textView.setPadding(0, 0, 0, 50);
            textView2.setPadding(0, 0, 0, 10);
            textView6.setPadding(0, 0, 0, 50);
            textView.setTextSize(20.0f);
            textView.setTextColor(Color.parseColor("#ff0092ff"));
            textView.setTypeface(textView.getTypeface(), 1);
            textView2.setTextSize(16.0f);
            String[] strArr = {"#FFBF00", "#DF3A01", "#04B486", "#DF01D7", "#fc00fc", "#9A2EFE", "#31B404", "#ff0092ff", "#0040FF"};
            String str4 = strArr[new Random().nextInt(strArr.length)];
            textView2.setTextColor(-1);
            textView6.setTextSize(16.0f);
            textView6.setTextColor(Color.parseColor("#ffffff"));
            textView3.setTextSize(15.0f);
            textView3.setPadding(25, 7, 25, 7);
            textView3.setGravity(17);
            textView3.setTextColor(Color.parseColor("#ffffff"));
            textView3.setTypeface(textView3.getTypeface(), 1);
            textView4.setTextSize(15.0f);
            textView4.setPadding(25, 7, 25, 7);
            textView4.setGravity(17);
            textView4.setTextColor(Color.parseColor("#ffffff"));
            textView4.setTypeface(textView4.getTypeface(), 1);
            textView3.setBackgroundDrawable(new GradientDrawable(this) { // from class: ī.íì.up1.100000006
                private final up1 this$0;

                {
                    this.this$0 = this;
                }

                public GradientDrawable getIns(int i4, int i5) {
                    setCornerRadius(i4);
                    setColor(i5);
                    return this;
                }
            }.getIns(15, Color.parseColor(str4)));
            textView4.setBackgroundDrawable(new GradientDrawable(this) { // from class: ī.íì.up1.100000007
                private final up1 this$0;

                {
                    this.this$0 = this;
                }

                public GradientDrawable getIns(int i4, int i5) {
                    setCornerRadius(i4);
                    setColor(i5);
                    return this;
                }
            }.getIns(15, Color.parseColor(str4)));
            linearLayout2.setPadding(0, 20, 0, 0);
            linearLayout2.setOrientation(0);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 16;
            layoutParams2.weight = 1.0f;
            layoutParams2.setMargins(20, 0, 20, 0);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 17;
            layoutParams3.weight = 1.0f;
            linearLayout2.setLayoutParams(layoutParams3);
            textView5.setLayoutParams(layoutParams3);
            textView3.setGravity(17);
            linearLayout.setBackgroundColor(-16777216);
            linearLayout2.setBackgroundColor(0);
            if (!parseBoolean && parseBoolean2) {
                linearLayout.addView(textView, 0);
                linearLayout.addView(textView2, 1);
                linearLayout.addView(linearLayout2, 2);
                linearLayout2.addView(textView5, 0);
                linearLayout2.addView(textView4, 1);
            } else if (parseBoolean2 || !parseBoolean) {
                linearLayout.addView(textView, 0);
                linearLayout.addView(textView2, 1);
                linearLayout.addView(checkBox, 2);
                linearLayout.addView(linearLayout2, 3);
                linearLayout2.addView(textView3, 0);
                linearLayout2.addView(textView5, 1);
                linearLayout2.addView(textView4, 2);
            } else if (parseBoolean3) {
                linearLayout.addView(textView, 0);
                linearLayout.addView(textView2, 1);
                linearLayout.addView(linearLayout2, 2);
                linearLayout2.addView(textView3, 0);
                linearLayout2.addView(textView5, 1);
                linearLayout2.addView(textView4, 2);
            } else {
                linearLayout.addView(textView, 0);
                linearLayout.addView(textView2, 1);
                linearLayout.addView(linearLayout2, 2);
                linearLayout2.addView(textView5, 0);
                linearLayout2.addView(textView4, 1);
            }
            linearLayout.setPadding(50, 50, 50, 50);
            linearLayout.setElevation(4.0f);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(layoutParams2);
            create.setView(linearLayout, 0, 0, 0, 0);
            create.setCancelable(false);
            create.requestWindowFeature(1);
            create.getWindow().setSoftInputMode(3);
            StringBuilder sb16 = new StringBuilder();
            for (float f17 : new float[]{24.25f, 27.5f, 25.0f, 28.5f, 27.75f, 26.25f, 25.0f, 11.5f, 26.25f, 27.5f, 29.0f, 25.25f, 27.5f, 29.0f, 11.5f, 24.25f, 24.75f, 29.0f, 26.25f, 27.75f, 27.5f, 11.5f, 21.5f, 18.25f, 17.25f, 21.75f}) {
                sb16.append((char) (f17 * 4.0f));
            }
            textView4.setOnClickListener(new View.OnClickListener(this, create, activity, sb16, parse) { // from class: ī.íì.up1.100000008
                private final up1 this$0;
                private final Activity val$activity;
                private final AlertDialog val$create;
                private final Uri val$parse;
                private final StringBuilder val$sb18;

                {
                    this.this$0 = this;
                    this.val$create = create;
                    this.val$activity = activity;
                    this.val$sb18 = sb16;
                    this.val$parse = parse;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.val$create.dismiss();
                    this.val$activity.startActivity(new Intent(this.val$sb18.toString(), this.val$parse));
                }
            });
            textView3.setOnClickListener(new View.OnClickListener(this, parseBoolean, create, checkBox, this.val$ctx) { // from class: ī.íì.up1.100000009
                private final up1 this$0;
                private final CheckBox val$checkBox;
                private final AlertDialog val$create;
                private final Context val$ctx;
                private final boolean val$parseBoolean;

                {
                    this.this$0 = this;
                    this.val$parseBoolean = parseBoolean;
                    this.val$create = create;
                    this.val$checkBox = checkBox;
                    this.val$ctx = r5;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!this.val$parseBoolean) {
                        this.val$create.dismiss();
                    } else if (this.val$checkBox.isChecked()) {
                        this.val$create.dismiss();
                        this.val$ctx.getSharedPreferences("", 0).edit().putBoolean("dont", true).commit();
                    } else {
                        this.val$create.dismiss();
                        this.val$ctx.getSharedPreferences("", 0).edit().putBoolean("dont", false).commit();
                    }
                }
            });
            StringBuilder sb17 = new StringBuilder();
            for (float f18 : new float[]{24.25f, 27.5f, 25.0f, 28.5f, 27.75f, 26.25f, 25.0f, 11.5f, 24.25f, 28.0f, 28.0f, 11.5f, 17.0f, 26.25f, 24.25f, 27.0f, 27.75f, 25.75f}) {
                sb17.append((char) (f18 * 4.0f));
            }
            StringBuilder sb18 = new StringBuilder();
            for (float f19 : new float[]{28.75f, 26.0f, 27.75f, 29.75f}) {
                sb18.append((char) (f19 * 4.0f));
            }
            if (!"show".equals(sb18.toString())) {
                throw null;
            }
            StringBuilder sb19 = new StringBuilder();
            for (float f20 : new float[]{26.25f, 28.75f, 20.75f, 26.0f, 27.75f, 29.75f, 26.25f, 27.5f, 25.75f}) {
                sb19.append((char) (f20 * 4.0f));
            }
            boolean booleanValue = ((Boolean) Class.forName(sb17.toString()).getDeclaredMethod(sb19.toString(), new Class[0]).invoke(create, new Object[0])).booleanValue();
            if (!replaceAll.equals(str2) && !booleanValue) {
                Class.forName(sb17.toString()).getDeclaredMethod(sb18.toString(), new Class[0]).invoke(create, new Object[0]);
            }
            if (!replaceAll2.equals(str) && !booleanValue) {
                Class.forName(sb17.toString()).getDeclaredMethod(sb18.toString(), new Class[0]).invoke(create, new Object[0]);
            }
            StringBuilder sb20 = new StringBuilder();
            for (float f21 : new float[]{26.0f, 26.25f, 25.0f, 25.25f}) {
                sb20.append((char) (f21 * 4.0f));
            }
            if ("show".equals(sb20.toString())) {
                throw null;
            }
        } catch (Exception e3) {
            Log.e("", e3.getMessage());
        }
    }
}
