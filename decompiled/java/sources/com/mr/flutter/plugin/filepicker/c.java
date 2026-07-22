package com.mr.flutter.plugin.filepicker;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.mr.flutter.plugin.filepicker.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: /root/release/classes.dex */
public class c {
    public static boolean a(Context context) {
        try {
            File[] listFiles = new File(context.getCacheDir() + "/file_picker/").listFiles();
            if (listFiles == null) {
                return true;
            }
            for (File file : listFiles) {
                file.delete();
            }
            return true;
        } catch (Exception e3) {
            Log.e("FilePickerUtils", "There was an error while clearing cached files: " + e3.toString());
            return false;
        }
    }

    public static Uri b(Uri uri, int i3, Context context) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            try {
                File c3 = c();
                Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream);
                FileOutputStream fileOutputStream = new FileOutputStream(c3);
                decodeStream.compress(Bitmap.CompressFormat.JPEG, i3, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                Uri fromFile = Uri.fromFile(c3);
                if (openInputStream != null) {
                    openInputStream.close();
                }
                return fromFile;
            } finally {
            }
        } catch (FileNotFoundException e3) {
            throw new RuntimeException(e3);
        } catch (IOException e4) {
            throw new RuntimeException(e4);
        }
    }

    private static File c() {
        return File.createTempFile("JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_", ".jpg", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
    }

    private static String d(Class<?> cls, Object obj) {
        if (Build.VERSION.SDK_INT < 30) {
            return (String) cls.getMethod("getPath", new Class[0]).invoke(obj, new Object[0]);
        }
        File file = (File) cls.getMethod("getDirectory", new Class[0]).invoke(obj, new Object[0]);
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    private static String e(Uri uri) {
        String str;
        String[] split = DocumentsContract.getTreeDocumentId(uri).split(":");
        return (split.length < 2 || (str = split[1]) == null) ? File.separator : str;
    }

    public static String f(Uri uri, Context context) {
        String str = null;
        try {
            if (uri.getScheme().equals("content")) {
                Cursor query = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            str = query.getString(query.getColumnIndexOrThrow("_display_name"));
                        }
                    } finally {
                        query.close();
                    }
                }
            }
            if (str != null) {
                return str;
            }
            String path = uri.getPath();
            int lastIndexOf = path.lastIndexOf(47);
            return lastIndexOf != -1 ? path.substring(lastIndexOf + 1) : path;
        } catch (Exception e3) {
            Log.e("FilePickerUtils", "Failed to handle file name: " + e3.toString());
            return null;
        }
    }

    public static String g(Uri uri, Context context) {
        if (uri == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 30 && k(uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            if (documentId.equals("downloads")) {
                return path;
            }
            if (!documentId.matches("^ms[df]\\:.*")) {
                if (documentId.startsWith("raw:")) {
                    return documentId.split(":")[1];
                }
                return null;
            }
            return path + "/" + f(uri, context);
        }
        String j3 = j(i(uri), context);
        new a.C0068a();
        if (j3 == null) {
            return File.separator;
        }
        String str = File.separator;
        if (j3.endsWith(str)) {
            j3 = j3.substring(0, j3.length() - 1);
        }
        String e3 = e(uri);
        if (e3.endsWith(str)) {
            e3 = e3.substring(0, e3.length() - 1);
        }
        if (e3.length() <= 0) {
            return j3;
        }
        if (e3.startsWith(str)) {
            return j3 + e3;
        }
        return j3 + str + e3;
    }

    public static String[] h(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(arrayList.get(i3));
            if (mimeTypeFromExtension == null) {
                Log.w("FilePickerUtils", "Custom file type " + arrayList.get(i3) + " is unsupported and will be ignored.");
            } else {
                arrayList2.add(mimeTypeFromExtension);
            }
        }
        Log.d("FilePickerUtils", "Allowed file extensions mimes: " + arrayList2);
        return (String[]) arrayList2.toArray(new String[0]);
    }

    private static String i(Uri uri) {
        String[] split = DocumentsContract.getTreeDocumentId(uri).split(":");
        if (split.length > 0) {
            return split[0];
        }
        return null;
    }

    private static String j(String str, Context context) {
        Class<?> cls;
        Method method;
        Method method2;
        Object invoke;
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            cls = Class.forName("android.os.storage.StorageVolume");
            Method method3 = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            method = cls.getMethod("getUuid", new Class[0]);
            method2 = cls.getMethod("isPrimary", new Class[0]);
            invoke = method3.invoke(storageManager, new Object[0]);
        } catch (Exception unused) {
        }
        if (invoke == null) {
            return null;
        }
        int length = Array.getLength(invoke);
        for (int i3 = 0; i3 < length; i3++) {
            Object obj = Array.get(invoke, i3);
            String str2 = (String) method.invoke(obj, new Object[0]);
            if (((Boolean) method2.invoke(obj, new Object[0])) != null && "primary".equals(str)) {
                return d(cls, obj);
            }
            if (str2 != null && str2.equals(str)) {
                return d(cls, obj);
            }
        }
        return null;
    }

    public static boolean k(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static void l(File file, a.C0068a c0068a) {
        String str;
        try {
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                bufferedInputStream.read(bArr, 0, length);
                bufferedInputStream.close();
            } catch (FileNotFoundException e3) {
                str = "File not found: " + e3.getMessage();
                Log.e("FilePickerUtils", str, null);
                c0068a.b(bArr);
            } catch (IOException e4) {
                str = "Failed to close file streams: " + e4.getMessage();
                Log.e("FilePickerUtils", str, null);
                c0068a.b(bArr);
            }
            c0068a.b(bArr);
        } catch (Exception e5) {
            Log.e("FilePickerUtils", "Failed to load bytes into memory with error " + e5.toString() + ". Probably the file is too big to fit device memory. Bytes won't be added to the file this time.");
        }
    }

    public static a m(Context context, Uri uri, boolean z3) {
        FileOutputStream fileOutputStream;
        StringBuilder sb;
        String str;
        Log.i("FilePickerUtils", "Caching from URI: " + uri.toString());
        a.C0068a c0068a = new a.C0068a();
        String f3 = f(uri, context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getCacheDir().getAbsolutePath());
        sb2.append("/file_picker/");
        sb2.append(System.currentTimeMillis());
        sb2.append("/");
        sb2.append(f3 != null ? f3 : "unamed");
        String sb3 = sb2.toString();
        File file = new File(sb3);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                fileOutputStream = new FileOutputStream(sb3);
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            }
            try {
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = openInputStream.read(bArr);
                        if (read < 0) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    fileOutputStream.getFD().sync();
                } catch (Throwable th) {
                    fileOutputStream.getFD().sync();
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    fileOutputStream.close();
                    sb = new StringBuilder();
                    str = "Failed to retrieve path: ";
                } catch (IOException | NullPointerException unused) {
                    sb = new StringBuilder();
                    str = "Failed to close file streams: ";
                }
                sb.append(str);
                sb.append(e.getMessage());
                Log.e("FilePickerUtils", sb.toString(), null);
                return null;
            }
        }
        Log.d("FilePickerUtils", "File loaded and cached at:" + sb3);
        if (z3) {
            l(file, c0068a);
        }
        c0068a.d(sb3).c(f3).f(uri).e(Long.parseLong(String.valueOf(file.length())));
        return c0068a.a();
    }
}
