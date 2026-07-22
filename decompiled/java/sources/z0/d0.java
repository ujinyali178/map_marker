package z0;

import android.database.sqlite.SQLiteProgram;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public class d0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f4753a;

    /* renamed from: b, reason: collision with root package name */
    private final List<Object> f4754b;

    public d0(String str, List<Object> list) {
        this.f4753a = str;
        this.f4754b = list == null ? new ArrayList<>() : list;
    }

    private Object[] e(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(f(it.next()));
            }
        }
        return arrayList.toArray(new Object[0]);
    }

    private static Object f(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof List)) {
            return obj;
        }
        List list = (List) obj;
        byte[] bArr = new byte[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            bArr[i3] = (byte) ((Integer) list.get(i3)).intValue();
        }
        return bArr;
    }

    public void a(SQLiteProgram sQLiteProgram) {
        long j3;
        List<Object> list = this.f4754b;
        if (list != null) {
            int size = list.size();
            int i3 = 0;
            while (i3 < size) {
                Object f3 = f(this.f4754b.get(i3));
                int i4 = i3 + 1;
                if (f3 == null) {
                    sQLiteProgram.bindNull(i4);
                } else if (f3 instanceof byte[]) {
                    sQLiteProgram.bindBlob(i4, (byte[]) f3);
                } else if (f3 instanceof Double) {
                    sQLiteProgram.bindDouble(i4, ((Double) f3).doubleValue());
                } else {
                    if (f3 instanceof Integer) {
                        j3 = ((Integer) f3).intValue();
                    } else if (f3 instanceof Long) {
                        j3 = ((Long) f3).longValue();
                    } else if (f3 instanceof String) {
                        sQLiteProgram.bindString(i4, (String) f3);
                    } else {
                        if (!(f3 instanceof Boolean)) {
                            throw new IllegalArgumentException("Could not bind " + f3 + " from index " + i3 + ": Supported types are null, byte[], double, long, boolean and String");
                        }
                        j3 = ((Boolean) f3).booleanValue() ? 1L : 0L;
                    }
                    sQLiteProgram.bindLong(i4, j3);
                }
                i3 = i4;
            }
        }
    }

    public List<Object> b() {
        return this.f4754b;
    }

    public String c() {
        return this.f4753a;
    }

    public Object[] d() {
        return e(this.f4754b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        String str = this.f4753a;
        if (str != null) {
            if (!str.equals(d0Var.f4753a)) {
                return false;
            }
        } else if (d0Var.f4753a != null) {
            return false;
        }
        if (this.f4754b.size() != d0Var.f4754b.size()) {
            return false;
        }
        for (int i3 = 0; i3 < this.f4754b.size(); i3++) {
            if ((this.f4754b.get(i3) instanceof byte[]) && (d0Var.f4754b.get(i3) instanceof byte[])) {
                if (!Arrays.equals((byte[]) this.f4754b.get(i3), (byte[]) d0Var.f4754b.get(i3))) {
                    return false;
                }
            } else if (!this.f4754b.get(i3).equals(d0Var.f4754b.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        String str = this.f4753a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4753a);
        List<Object> list = this.f4754b;
        if (list == null || list.isEmpty()) {
            str = "";
        } else {
            str = " " + this.f4754b;
        }
        sb.append(str);
        return sb.toString();
    }
}
