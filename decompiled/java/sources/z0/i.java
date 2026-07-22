package z0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import u1.l;

/* loaded from: /root/release/classes.dex */
class i {

    /* renamed from: n, reason: collision with root package name */
    private static Boolean f4761n;

    /* renamed from: a, reason: collision with root package name */
    final boolean f4762a;

    /* renamed from: b, reason: collision with root package name */
    final String f4763b;

    /* renamed from: c, reason: collision with root package name */
    final int f4764c;

    /* renamed from: d, reason: collision with root package name */
    final int f4765d;

    /* renamed from: e, reason: collision with root package name */
    final Context f4766e;

    /* renamed from: h, reason: collision with root package name */
    public o f4769h;

    /* renamed from: i, reason: collision with root package name */
    SQLiteDatabase f4770i;

    /* renamed from: l, reason: collision with root package name */
    private Integer f4773l;

    /* renamed from: f, reason: collision with root package name */
    final List<b1.g> f4767f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    final Map<Integer, t> f4768g = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private int f4771j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f4772k = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f4774m = 0;

    class a implements DatabaseErrorHandler {
        a() {
        }

        @Override // android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        }
    }

    i(Context context, String str, int i3, boolean z3, int i4) {
        this.f4766e = context;
        this.f4763b = str;
        this.f4762a = z3;
        this.f4764c = i3;
        this.f4765d = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Cursor G(d0 d0Var, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        d0Var.a(sQLiteQuery);
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(b1.e eVar) {
        Boolean i3 = eVar.i();
        boolean z3 = Boolean.TRUE.equals(i3) && eVar.g();
        if (z3) {
            int i4 = this.f4772k + 1;
            this.f4772k = i4;
            this.f4773l = Integer.valueOf(i4);
        }
        if (!w(eVar)) {
            if (z3) {
                this.f4773l = null;
            }
        } else if (z3) {
            HashMap hashMap = new HashMap();
            hashMap.put("transactionId", this.f4773l);
            eVar.a(hashMap);
        } else {
            if (Boolean.FALSE.equals(i3)) {
                this.f4773l = null;
            }
            eVar.a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        while (!this.f4767f.isEmpty() && this.f4773l == null) {
            this.f4767f.get(0).a();
            this.f4767f.remove(0);
        }
    }

    private void S(b1.e eVar, Runnable runnable) {
        Integer f3 = eVar.f();
        Integer num = this.f4773l;
        if (num == null) {
            runnable.run();
            return;
        }
        if (f3 == null || !(f3.equals(num) || f3.intValue() == -1)) {
            this.f4767f.add(new b1.g(eVar, runnable));
            return;
        }
        runnable.run();
        if (this.f4773l != null || this.f4767f.isEmpty()) {
            return;
        }
        this.f4769h.b(this, new Runnable() { // from class: z0.h
            @Override // java.lang.Runnable
            public final void run() {
                i.this.Q();
            }
        });
    }

    protected static boolean i(Context context, String str, boolean z3) {
        try {
            String packageName = context.getPackageName();
            return (Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(128L)) : y(context, packageName, 128)).metaData.getBoolean(str, z3);
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    protected static boolean j(Context context) {
        return i(context, "com.tekartik.sqflite.wal_enabled", false);
    }

    private void l(int i3) {
        t tVar = this.f4768g.get(Integer.valueOf(i3));
        if (tVar != null) {
            m(tVar);
        }
    }

    private void m(t tVar) {
        try {
            int i3 = tVar.f4801a;
            if (r.c(this.f4765d)) {
                Log.d("Sqflite", A() + "closing cursor " + i3);
            }
            this.f4768g.remove(Integer.valueOf(i3));
            tVar.f4803c.close();
        } catch (Exception unused) {
        }
    }

    private Map<String, Object> n(Cursor cursor, Integer num) {
        HashMap hashMap = null;
        ArrayList arrayList = null;
        int i3 = 0;
        while (cursor.moveToNext()) {
            if (hashMap == null) {
                ArrayList arrayList2 = new ArrayList();
                HashMap hashMap2 = new HashMap();
                i3 = cursor.getColumnCount();
                hashMap2.put("columns", Arrays.asList(cursor.getColumnNames()));
                hashMap2.put("rows", arrayList2);
                arrayList = arrayList2;
                hashMap = hashMap2;
            }
            arrayList.add(e0.a(cursor, i3));
            if (num != null && arrayList.size() >= num.intValue()) {
                break;
            }
        }
        return hashMap == null ? new HashMap() : hashMap;
    }

    static void o(String str) {
        SQLiteDatabase.deleteDatabase(new File(str));
    }

    private boolean p(b1.e eVar) {
        if (!w(eVar)) {
            return false;
        }
        eVar.a(null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cf  */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean I(b1.e r10) {
        /*
            r9 = this;
            boolean r0 = r9.w(r10)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            boolean r0 = r10.e()
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L14
            r10.a(r2)
            return r3
        L14:
            java.lang.String r0 = "SELECT changes(), last_insert_rowid()"
            android.database.sqlite.SQLiteDatabase r4 = r9.C()     // Catch: java.lang.Throwable -> Lbc java.lang.Exception -> Lbe
            android.database.Cursor r0 = r4.rawQuery(r0, r2)     // Catch: java.lang.Throwable -> Lbc java.lang.Exception -> Lbe
            java.lang.String r4 = "Sqflite"
            if (r0 == 0) goto L9b
            int r5 = r0.getCount()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            if (r5 <= 0) goto L9b
            boolean r5 = r0.moveToFirst()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            if (r5 == 0) goto L9b
            int r5 = r0.getInt(r1)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            if (r5 != 0) goto L67
            int r5 = r9.f4765d     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            boolean r5 = z0.r.b(r5)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            if (r5 == 0) goto L60
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r5.<init>()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r6 = r9.A()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r5.append(r6)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r6 = "no changes (id was "
            r5.append(r6)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            long r6 = r0.getLong(r3)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r5.append(r6)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            android.util.Log.d(r4, r5)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
        L60:
            r10.a(r2)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r0.close()
            return r3
        L67:
            long r5 = r0.getLong(r3)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            int r2 = r9.f4765d     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            boolean r2 = z0.r.b(r2)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            if (r2 == 0) goto L8e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r2.<init>()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r7 = r9.A()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r2.append(r7)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r7 = "inserted "
            r2.append(r7)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r2.append(r5)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            android.util.Log.d(r4, r2)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
        L8e:
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r10.a(r2)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r0.close()
            return r3
        L99:
            r2 = move-exception
            goto Lc2
        L9b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r5.<init>()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r6 = r9.A()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r5.append(r6)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r6 = "fail to read changes for Insert"
            r5.append(r6)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            android.util.Log.e(r4, r5)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r10.a(r2)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            if (r0 == 0) goto Lbb
            r0.close()
        Lbb:
            return r3
        Lbc:
            r10 = move-exception
            goto Lcd
        Lbe:
            r0 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
        Lc2:
            r9.D(r2, r10)     // Catch: java.lang.Throwable -> Lcb
            if (r0 == 0) goto Lca
            r0.close()
        Lca:
            return r1
        Lcb:
            r10 = move-exception
            r2 = r0
        Lcd:
            if (r2 == 0) goto Ld2
            r2.close()
        Ld2:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.i.I(b1.e):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public boolean J(b1.e eVar) {
        Cursor cursor;
        Integer num = (Integer) eVar.c("cursorPageSize");
        final d0 d3 = eVar.d();
        if (r.b(this.f4765d)) {
            Log.d("Sqflite", A() + d3);
        }
        t tVar = null;
        try {
            cursor = z().rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: z0.f
                @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                    Cursor G;
                    G = i.G(d0.this, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                    return G;
                }
            }, d3.c(), z0.a.f4721a, null);
            try {
                try {
                    Map<String, Object> n3 = n(cursor, num);
                    if ((num == null || cursor.isLast() || cursor.isAfterLast()) ? false : true) {
                        int i3 = this.f4774m + 1;
                        this.f4774m = i3;
                        n3.put("cursorId", Integer.valueOf(i3));
                        t tVar2 = new t(i3, num.intValue(), cursor);
                        try {
                            this.f4768g.put(Integer.valueOf(i3), tVar2);
                            tVar = tVar2;
                        } catch (Exception e3) {
                            e = e3;
                            tVar = tVar2;
                            D(e, eVar);
                            if (tVar != null) {
                                m(tVar);
                            }
                            if (tVar == null && cursor != null) {
                                cursor.close();
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            tVar = tVar2;
                            if (tVar == null && cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    eVar.a(n3);
                    if (tVar == null && cursor != null) {
                        cursor.close();
                    }
                    return true;
                } catch (Exception e4) {
                    e = e4;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public boolean K(b1.e eVar) {
        boolean z3;
        int intValue = ((Integer) eVar.c("cursorId")).intValue();
        boolean equals = Boolean.TRUE.equals(eVar.c("cancel"));
        if (r.c(this.f4765d)) {
            StringBuilder sb = new StringBuilder();
            sb.append(A());
            sb.append("cursor ");
            sb.append(intValue);
            sb.append(equals ? " cancel" : " next");
            Log.d("Sqflite", sb.toString());
        }
        t tVar = null;
        if (equals) {
            l(intValue);
            eVar.a(null);
            return true;
        }
        t tVar2 = this.f4768g.get(Integer.valueOf(intValue));
        boolean z4 = false;
        try {
            if (tVar2 == null) {
                throw new IllegalStateException("Cursor " + intValue + " not found");
            }
            Cursor cursor = tVar2.f4803c;
            Map<String, Object> n3 = n(cursor, Integer.valueOf(tVar2.f4802b));
            z3 = (cursor.isLast() || cursor.isAfterLast()) ? false : true;
            if (z3) {
                try {
                    try {
                        n3.put("cursorId", Integer.valueOf(intValue));
                    } catch (Exception e3) {
                        e = e3;
                        D(e, eVar);
                        if (tVar2 != null) {
                            m(tVar2);
                        } else {
                            tVar = tVar2;
                        }
                        if (!z3 && tVar != null) {
                            m(tVar);
                        }
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    z4 = z3;
                    if (!z4 && tVar2 != null) {
                        m(tVar2);
                    }
                    throw th;
                }
            }
            eVar.a(n3);
            if (!z3) {
                m(tVar2);
            }
            return true;
        } catch (Exception e4) {
            e = e4;
            z3 = false;
        } catch (Throwable th2) {
            th = th2;
            if (!z4) {
                m(tVar2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public boolean L(b1.e eVar) {
        if (!w(eVar)) {
            return false;
        }
        Cursor cursor = null;
        if (eVar.e()) {
            eVar.a(null);
            return true;
        }
        try {
            try {
                Cursor rawQuery = C().rawQuery("SELECT changes()", null);
                if (rawQuery != null) {
                    try {
                        if (rawQuery.getCount() > 0 && rawQuery.moveToFirst()) {
                            int i3 = rawQuery.getInt(0);
                            if (r.b(this.f4765d)) {
                                Log.d("Sqflite", A() + "changed " + i3);
                            }
                            eVar.a(Integer.valueOf(i3));
                            rawQuery.close();
                            return true;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        cursor = rawQuery;
                        D(e, eVar);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                Log.e("Sqflite", A() + "fail to read changes for Update/Delete");
                eVar.a(null);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return true;
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean w(b1.e eVar) {
        d0 d3 = eVar.d();
        if (r.b(this.f4765d)) {
            Log.d("Sqflite", A() + d3);
        }
        Boolean i3 = eVar.i();
        try {
            C().execSQL(d3.c(), d3.d());
            u(i3);
            return true;
        } catch (Exception e3) {
            D(e3, eVar);
            return false;
        }
    }

    public static boolean x(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    static ApplicationInfo y(Context context, String str, int i3) {
        return context.getPackageManager().getApplicationInfo(str, i3);
    }

    String A() {
        return "[" + B() + "] ";
    }

    String B() {
        Thread currentThread = Thread.currentThread();
        return this.f4764c + "," + currentThread.getName() + "(" + currentThread.getId() + ")";
    }

    public SQLiteDatabase C() {
        return this.f4770i;
    }

    void D(Exception exc, b1.e eVar) {
        String message;
        Map<String, Object> a4;
        if (exc instanceof SQLiteCantOpenDatabaseException) {
            message = "open_failed " + this.f4763b;
            a4 = null;
        } else {
            boolean z3 = exc instanceof SQLException;
            message = exc.getMessage();
            a4 = b1.h.a(eVar);
        }
        eVar.b("sqlite_error", message, a4);
    }

    public void E(final b1.e eVar) {
        S(eVar, new Runnable() { // from class: z0.d
            @Override // java.lang.Runnable
            public final void run() {
                i.this.I(eVar);
            }
        });
    }

    synchronized boolean F() {
        return this.f4771j > 0;
    }

    public void M() {
        if (f4761n == null) {
            Boolean valueOf = Boolean.valueOf(j(this.f4766e));
            f4761n = valueOf;
            if (valueOf.booleanValue() && r.c(this.f4765d)) {
                Log.d("Sqflite", A() + "[sqflite] WAL enabled");
            }
        }
        this.f4770i = SQLiteDatabase.openDatabase(this.f4763b, null, f4761n.booleanValue() ? 805306368 : 268435456);
    }

    public void N() {
        this.f4770i = SQLiteDatabase.openDatabase(this.f4763b, null, 1, new a());
    }

    public void O(final b1.e eVar) {
        S(eVar, new Runnable() { // from class: z0.e
            @Override // java.lang.Runnable
            public final void run() {
                i.this.J(eVar);
            }
        });
    }

    public void P(final b1.e eVar) {
        S(eVar, new Runnable() { // from class: z0.b
            @Override // java.lang.Runnable
            public final void run() {
                i.this.K(eVar);
            }
        });
    }

    public void R(final b1.e eVar) {
        S(eVar, new Runnable() { // from class: z0.g
            @Override // java.lang.Runnable
            public final void run() {
                i.this.L(eVar);
            }
        });
    }

    void h(u1.k kVar, l.d dVar) {
        b1.c cVar;
        String method;
        b1.d dVar2 = new b1.d(kVar, dVar);
        boolean e3 = dVar2.e();
        boolean k3 = dVar2.k();
        List list = (List) dVar2.c("operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            cVar = new b1.c((Map) it.next(), e3);
            method = cVar.getMethod();
            method.hashCode();
            switch (method) {
                case "execute":
                    if (p(cVar)) {
                        cVar.s(arrayList);
                    } else {
                        if (!k3) {
                            cVar.q(dVar);
                            break;
                        }
                        cVar.r(arrayList);
                    }
                case "insert":
                    if (I(cVar)) {
                        cVar.s(arrayList);
                    } else {
                        if (!k3) {
                            cVar.q(dVar);
                            break;
                        }
                        cVar.r(arrayList);
                    }
                case "update":
                    if (L(cVar)) {
                        cVar.s(arrayList);
                    } else {
                        if (!k3) {
                            cVar.q(dVar);
                            break;
                        }
                        cVar.r(arrayList);
                    }
                case "query":
                    if (J(cVar)) {
                        cVar.s(arrayList);
                    } else {
                        if (!k3) {
                            cVar.q(dVar);
                            break;
                        }
                        cVar.r(arrayList);
                    }
                default:
                    dVar.b("bad_param", "Batch method '" + method + "' not supported", null);
                    break;
            }
            return;
        }
        if (e3) {
            dVar.a(null);
        } else {
            dVar.a(arrayList);
        }
    }

    public void k() {
        if (!this.f4768g.isEmpty() && r.b(this.f4765d)) {
            Log.d("Sqflite", A() + this.f4768g.size() + " cursor(s) are left opened");
        }
        this.f4770i.close();
    }

    synchronized void u(Boolean bool) {
        if (Boolean.TRUE.equals(bool)) {
            this.f4771j++;
        } else if (Boolean.FALSE.equals(bool)) {
            this.f4771j--;
        }
    }

    public void v(final b1.e eVar) {
        S(eVar, new Runnable() { // from class: z0.c
            @Override // java.lang.Runnable
            public final void run() {
                i.this.H(eVar);
            }
        });
    }

    public SQLiteDatabase z() {
        return this.f4770i;
    }
}
