package com.mr.flutter.plugin.filepicker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import u1.e;
import u1.l;
import u1.n;

/* loaded from: /root/release/classes.dex */
public class b implements n.a, n.d {

    /* renamed from: n, reason: collision with root package name */
    private static final int f2413n = (FilePickerPlugin.class.hashCode() + 43) & 65535;

    /* renamed from: o, reason: collision with root package name */
    private static final int f2414o = (FilePickerPlugin.class.hashCode() + 83) & 65535;

    /* renamed from: c, reason: collision with root package name */
    private final Activity f2415c;

    /* renamed from: d, reason: collision with root package name */
    private final d f2416d;

    /* renamed from: f, reason: collision with root package name */
    private l.d f2417f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2418g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2419h;

    /* renamed from: i, reason: collision with root package name */
    private String f2420i;

    /* renamed from: j, reason: collision with root package name */
    private int f2421j;

    /* renamed from: k, reason: collision with root package name */
    private String[] f2422k;

    /* renamed from: l, reason: collision with root package name */
    private e.b f2423l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f2424m;

    class a implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f2425a;

        a(Activity activity) {
            this.f2425a = activity;
        }

        @Override // com.mr.flutter.plugin.filepicker.b.d
        public void a(String str, int i3) {
            androidx.core.app.a.c(this.f2425a, new String[]{str}, i3);
        }

        @Override // com.mr.flutter.plugin.filepicker.b.d
        public boolean b(String str) {
            return androidx.core.content.a.checkSelfPermission(this.f2425a, str) == 0;
        }
    }

    /* renamed from: com.mr.flutter.plugin.filepicker.b$b, reason: collision with other inner class name */
    class RunnableC0069b implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f2426c;

        RunnableC0069b(Intent intent) {
            this.f2426c = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            String str;
            Uri uri;
            com.mr.flutter.plugin.filepicker.a m3;
            if (this.f2426c != null) {
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                if (this.f2426c.getClipData() != null) {
                    int itemCount = this.f2426c.getClipData().getItemCount();
                    while (i3 < itemCount) {
                        Uri uri2 = this.f2426c.getClipData().getItemAt(i3).getUri();
                        if (Objects.equals(b.this.f2420i, "image/*") && b.this.f2421j > 0) {
                            uri2 = com.mr.flutter.plugin.filepicker.c.b(uri2, b.this.f2421j, b.this.f2415c.getApplicationContext());
                        }
                        com.mr.flutter.plugin.filepicker.a m4 = com.mr.flutter.plugin.filepicker.c.m(b.this.f2415c, uri2, b.this.f2419h);
                        if (m4 != null) {
                            arrayList.add(m4);
                            Log.d("FilePickerDelegate", "[MultiFilePick] File #" + i3 + " - URI: " + uri2.getPath());
                        }
                        i3++;
                    }
                } else if (this.f2426c.getData() != null) {
                    Uri data = this.f2426c.getData();
                    if (Objects.equals(b.this.f2420i, "image/*") && b.this.f2421j > 0) {
                        data = com.mr.flutter.plugin.filepicker.c.b(data, b.this.f2421j, b.this.f2415c.getApplicationContext());
                    }
                    if (b.this.f2420i.equals("dir")) {
                        Uri buildDocumentUriUsingTree = DocumentsContract.buildDocumentUriUsingTree(data, DocumentsContract.getTreeDocumentId(data));
                        Log.d("FilePickerDelegate", "[SingleFilePick] File URI:" + buildDocumentUriUsingTree.toString());
                        String g3 = com.mr.flutter.plugin.filepicker.c.g(buildDocumentUriUsingTree, b.this.f2415c);
                        if (g3 != null) {
                            b.this.n(g3);
                            return;
                        } else {
                            b.this.m("unknown_path", "Failed to retrieve directory path.");
                            return;
                        }
                    }
                    com.mr.flutter.plugin.filepicker.a m5 = com.mr.flutter.plugin.filepicker.c.m(b.this.f2415c, data, b.this.f2419h);
                    if (m5 != null) {
                        arrayList.add(m5);
                    }
                    if (arrayList.isEmpty()) {
                        bVar = b.this;
                        str = "Failed to retrieve path.";
                        bVar.m("unknown_path", str);
                        return;
                    } else {
                        Log.d("FilePickerDelegate", "File path:" + arrayList.toString());
                    }
                } else if (this.f2426c.getExtras() != null) {
                    Bundle extras = this.f2426c.getExtras();
                    if (!extras.keySet().contains("selectedItems")) {
                        bVar = b.this;
                        str = "Failed to retrieve path from bundle.";
                        bVar.m("unknown_path", str);
                        return;
                    }
                    ArrayList o3 = b.this.o(extras);
                    if (o3 != null) {
                        Iterator it = o3.iterator();
                        while (it.hasNext()) {
                            Parcelable parcelable = (Parcelable) it.next();
                            if ((parcelable instanceof Uri) && (m3 = com.mr.flutter.plugin.filepicker.c.m(b.this.f2415c, (uri = (Uri) parcelable), b.this.f2419h)) != null) {
                                arrayList.add(m3);
                                Log.d("FilePickerDelegate", "[MultiFilePick] File #" + i3 + " - URI: " + uri.getPath());
                            }
                            i3++;
                        }
                    }
                }
                b.this.n(arrayList);
                return;
            }
            b.this.m("unknown_activity", "Unknown activity error, please fill an issue.");
        }
    }

    class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f2428a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Looper looper, boolean z3) {
            super(looper);
            this.f2428a = z3;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b.this.f2423l.a(Boolean.valueOf(this.f2428a));
        }
    }

    interface d {
        void a(String str, int i3);

        boolean b(String str);
    }

    public b(Activity activity) {
        this(activity, null, new a(activity));
    }

    b(Activity activity, l.d dVar, d dVar2) {
        this.f2418g = false;
        this.f2419h = false;
        this.f2421j = 20;
        this.f2415c = activity;
        this.f2417f = dVar;
        this.f2416d = dVar2;
    }

    private void j() {
        this.f2417f = null;
    }

    private void k(boolean z3) {
        if (this.f2423l == null || this.f2420i.equals("dir")) {
            return;
        }
        new c(Looper.getMainLooper(), z3).obtainMessage().sendToTarget();
    }

    private static void l(l.d dVar) {
        dVar.b("already_active", "File picker is already active", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, String str2) {
        if (this.f2417f == null) {
            return;
        }
        k(false);
        this.f2417f.b(str, str2, null);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Object obj) {
        k(false);
        if (this.f2417f != null) {
            if (obj != null && !(obj instanceof String)) {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    arrayList.add(((com.mr.flutter.plugin.filepicker.a) it.next()).a());
                }
                obj = arrayList;
            }
            this.f2417f.a(obj);
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<Parcelable> o(Bundle bundle) {
        return Build.VERSION.SDK_INT >= 33 ? bundle.getParcelableArrayList("selectedItems", Parcelable.class) : bundle.getParcelableArrayList("selectedItems");
    }

    private boolean r(l.d dVar) {
        if (this.f2417f != null) {
            return false;
        }
        this.f2417f = dVar;
        return true;
    }

    private void s() {
        Intent intent;
        String str = this.f2420i;
        if (str == null) {
            return;
        }
        if (str.equals("dir")) {
            intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        } else {
            if (this.f2420i.equals("image/*")) {
                intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            } else {
                intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
            }
            Uri parse = Uri.parse(Environment.getExternalStorageDirectory().getPath() + File.separator);
            Log.d("FilePickerDelegate", "Selected type " + this.f2420i);
            intent.setDataAndType(parse, this.f2420i);
            intent.setType(this.f2420i);
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", this.f2418g);
            intent.putExtra("multi-pick", this.f2418g);
            if (this.f2420i.contains(",")) {
                this.f2422k = this.f2420i.split(",");
            }
            String[] strArr = this.f2422k;
            if (strArr != null) {
                intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
            }
        }
        if (intent.resolveActivity(this.f2415c.getPackageManager()) != null) {
            this.f2415c.startActivityForResult(Intent.createChooser(intent, null), f2413n);
        } else {
            Log.e("FilePickerDelegate", "Can't find a valid activity to handle the request. Make sure you've a file explorer installed.");
            m("invalid_format_type", "Can't handle the provided file type.");
        }
    }

    @Override // u1.n.a
    public boolean a(int i3, int i4, Intent intent) {
        if (i3 != f2414o) {
            if (this.f2420i == null) {
                return false;
            }
            int i5 = f2413n;
            if (i3 == i5 && i4 == -1) {
                k(true);
                new Thread(new RunnableC0069b(intent)).start();
                return true;
            }
            if (i3 == i5 && i4 == 0) {
                Log.i("FilePickerDelegate", "User cancelled the picker request");
                n(null);
                return true;
            }
            if (i3 == i5) {
                m("unknown_activity", "Unknown activity error, please fill an issue.");
            }
            return false;
        }
        if (i4 == -1) {
            k(true);
            Uri data = intent.getData();
            if (data != null) {
                String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + File.separator + com.mr.flutter.plugin.filepicker.c.f(data, this.f2415c);
                try {
                    OutputStream openOutputStream = this.f2415c.getContentResolver().openOutputStream(data);
                    if (openOutputStream != null) {
                        openOutputStream.write(this.f2424m);
                        openOutputStream.flush();
                        openOutputStream.close();
                    }
                    n(str);
                    return true;
                } catch (IOException e3) {
                    Log.i("FilePickerDelegate", "Error while saving file", e3);
                    m("Error while saving file", e3.getMessage());
                }
            }
        }
        if (i4 == 0) {
            Log.i("FilePickerDelegate", "User cancelled the save request");
            n(null);
        }
        return false;
    }

    @Override // u1.n.d
    public boolean onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        boolean z3 = false;
        if (f2413n != i3) {
            return false;
        }
        if (iArr.length > 0 && iArr[0] == 0) {
            z3 = true;
        }
        if (z3) {
            s();
        } else {
            m("read_external_storage_denied", "User did not allow reading external storage");
        }
        return true;
    }

    public void p(String str, String str2, String str3, String[] strArr, byte[] bArr, l.d dVar) {
        if (!r(dVar)) {
            l(dVar);
            return;
        }
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (str != null && !str.isEmpty()) {
            intent.putExtra("android.intent.extra.TITLE", str);
        }
        this.f2424m = bArr;
        if (str2 == null || "dir".equals(str2) || str2.split(",").length != 1) {
            intent.setType("*/*");
        } else {
            intent.setType(str2);
        }
        if (str3 != null && !str3.isEmpty() && Build.VERSION.SDK_INT >= 26) {
            intent.putExtra("android.provider.extra.INITIAL_URI", Uri.parse(str3));
        }
        if (strArr != null && strArr.length > 0) {
            intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
        }
        if (intent.resolveActivity(this.f2415c.getPackageManager()) != null) {
            this.f2415c.startActivityForResult(intent, f2414o);
        } else {
            Log.e("FilePickerDelegate", "Can't find a valid activity to handle the request. Make sure you've a file explorer installed.");
            m("invalid_format_type", "Can't handle the provided file type.");
        }
    }

    public void q(e.b bVar) {
        this.f2423l = bVar;
    }

    public void t(String str, boolean z3, boolean z4, String[] strArr, int i3, l.d dVar) {
        if (!r(dVar)) {
            l(dVar);
            return;
        }
        this.f2420i = str;
        this.f2418g = z3;
        this.f2419h = z4;
        this.f2422k = strArr;
        this.f2421j = i3;
        if (Build.VERSION.SDK_INT >= 33 || this.f2416d.b("android.permission.READ_EXTERNAL_STORAGE")) {
            s();
        } else {
            this.f2416d.a("android.permission.READ_EXTERNAL_STORAGE", f2413n);
        }
    }
}
