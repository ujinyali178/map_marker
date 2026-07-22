package z0;

import android.database.Cursor;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: /root/release/classes.dex */
public class e0 {
    public static List<Object> a(Cursor cursor, int i3) {
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            Object b4 = b(cursor, i4);
            if (a1.a.f4c) {
                String name = b4 != null ? b4.getClass().isArray() ? "array(" + b4.getClass().getComponentType().getName() + ")" : b4.getClass().getName() : null;
                StringBuilder sb = new StringBuilder();
                sb.append("column ");
                sb.append(i4);
                sb.append(" ");
                sb.append(cursor.getType(i4));
                sb.append(": ");
                sb.append(b4);
                sb.append(name == null ? "" : " (" + name + ")");
                Log.d("Sqflite", sb.toString());
            }
            arrayList.add(b4);
        }
        return arrayList;
    }

    public static Object b(Cursor cursor, int i3) {
        int type = cursor.getType(i3);
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i3));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i3));
        }
        if (type == 3) {
            return cursor.getString(i3);
        }
        if (type != 4) {
            return null;
        }
        return cursor.getBlob(i3);
    }

    static Locale c(String str) {
        return Locale.forLanguageTag(str);
    }

    static Locale d(String str) {
        return c(str);
    }
}
