package androidx.profileinstaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: /root/release/classes.dex */
class n {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f1416a = {112, 114, 111, 0};

    /* renamed from: b, reason: collision with root package name */
    static final byte[] f1417b = {112, 114, 109, 0};

    private static void A(InputStream inputStream) {
        e.h(inputStream);
        int j3 = e.j(inputStream);
        if (j3 == 6 || j3 == 7) {
            return;
        }
        while (j3 > 0) {
            e.j(inputStream);
            for (int j4 = e.j(inputStream); j4 > 0; j4--) {
                e.h(inputStream);
            }
            j3--;
        }
    }

    static boolean B(OutputStream outputStream, byte[] bArr, d[] dVarArr) {
        if (Arrays.equals(bArr, p.f1428a)) {
            N(outputStream, dVarArr);
            return true;
        }
        if (Arrays.equals(bArr, p.f1429b)) {
            M(outputStream, dVarArr);
            return true;
        }
        if (Arrays.equals(bArr, p.f1431d)) {
            K(outputStream, dVarArr);
            return true;
        }
        if (Arrays.equals(bArr, p.f1430c)) {
            L(outputStream, dVarArr);
            return true;
        }
        if (!Arrays.equals(bArr, p.f1432e)) {
            return false;
        }
        J(outputStream, dVarArr);
        return true;
    }

    private static void C(OutputStream outputStream, d dVar) {
        int i3 = 0;
        for (int i4 : dVar.f1397h) {
            Integer valueOf = Integer.valueOf(i4);
            e.p(outputStream, valueOf.intValue() - i3);
            i3 = valueOf.intValue();
        }
    }

    private static q D(d[] dVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            e.p(byteArrayOutputStream, dVarArr.length);
            int i3 = 2;
            for (d dVar : dVarArr) {
                e.q(byteArrayOutputStream, dVar.f1392c);
                e.q(byteArrayOutputStream, dVar.f1393d);
                e.q(byteArrayOutputStream, dVar.f1396g);
                String j3 = j(dVar.f1390a, dVar.f1391b, p.f1428a);
                int k3 = e.k(j3);
                e.p(byteArrayOutputStream, k3);
                i3 = i3 + 4 + 4 + 4 + 2 + (k3 * 1);
                e.n(byteArrayOutputStream, j3);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i3 == byteArray.length) {
                q qVar = new q(f.DEX_FILES, i3, byteArray, false);
                byteArrayOutputStream.close();
                return qVar;
            }
            throw e.c("Expected size " + i3 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    static void E(OutputStream outputStream, byte[] bArr) {
        outputStream.write(f1416a);
        outputStream.write(bArr);
    }

    private static void F(OutputStream outputStream, d dVar) {
        I(outputStream, dVar);
        C(outputStream, dVar);
        H(outputStream, dVar);
    }

    private static void G(OutputStream outputStream, d dVar, String str) {
        e.p(outputStream, e.k(str));
        e.p(outputStream, dVar.f1394e);
        e.q(outputStream, dVar.f1395f);
        e.q(outputStream, dVar.f1392c);
        e.q(outputStream, dVar.f1396g);
        e.n(outputStream, str);
    }

    private static void H(OutputStream outputStream, d dVar) {
        byte[] bArr = new byte[k(dVar.f1396g)];
        for (Map.Entry<Integer, Integer> entry : dVar.f1398i.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            if ((intValue2 & 2) != 0) {
                z(bArr, 2, intValue, dVar);
            }
            if ((intValue2 & 4) != 0) {
                z(bArr, 4, intValue, dVar);
            }
        }
        outputStream.write(bArr);
    }

    private static void I(OutputStream outputStream, d dVar) {
        int i3 = 0;
        for (Map.Entry<Integer, Integer> entry : dVar.f1398i.entrySet()) {
            int intValue = entry.getKey().intValue();
            if ((entry.getValue().intValue() & 1) != 0) {
                e.p(outputStream, intValue - i3);
                e.p(outputStream, 0);
                i3 = intValue;
            }
        }
    }

    private static void J(OutputStream outputStream, d[] dVarArr) {
        e.p(outputStream, dVarArr.length);
        for (d dVar : dVarArr) {
            String j3 = j(dVar.f1390a, dVar.f1391b, p.f1432e);
            e.p(outputStream, e.k(j3));
            e.p(outputStream, dVar.f1398i.size());
            e.p(outputStream, dVar.f1397h.length);
            e.q(outputStream, dVar.f1392c);
            e.n(outputStream, j3);
            Iterator<Integer> it = dVar.f1398i.keySet().iterator();
            while (it.hasNext()) {
                e.p(outputStream, it.next().intValue());
            }
            for (int i3 : dVar.f1397h) {
                e.p(outputStream, i3);
            }
        }
    }

    private static void K(OutputStream outputStream, d[] dVarArr) {
        e.r(outputStream, dVarArr.length);
        for (d dVar : dVarArr) {
            int size = dVar.f1398i.size() * 4;
            String j3 = j(dVar.f1390a, dVar.f1391b, p.f1431d);
            e.p(outputStream, e.k(j3));
            e.p(outputStream, dVar.f1397h.length);
            e.q(outputStream, size);
            e.q(outputStream, dVar.f1392c);
            e.n(outputStream, j3);
            Iterator<Integer> it = dVar.f1398i.keySet().iterator();
            while (it.hasNext()) {
                e.p(outputStream, it.next().intValue());
                e.p(outputStream, 0);
            }
            for (int i3 : dVar.f1397h) {
                e.p(outputStream, i3);
            }
        }
    }

    private static void L(OutputStream outputStream, d[] dVarArr) {
        byte[] b4 = b(dVarArr, p.f1430c);
        e.r(outputStream, dVarArr.length);
        e.m(outputStream, b4);
    }

    private static void M(OutputStream outputStream, d[] dVarArr) {
        byte[] b4 = b(dVarArr, p.f1429b);
        e.r(outputStream, dVarArr.length);
        e.m(outputStream, b4);
    }

    private static void N(OutputStream outputStream, d[] dVarArr) {
        O(outputStream, dVarArr);
    }

    private static void O(OutputStream outputStream, d[] dVarArr) {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(dVarArr));
        arrayList.add(c(dVarArr));
        arrayList.add(d(dVarArr));
        long length2 = p.f1428a.length + f1416a.length + 4 + (arrayList.size() * 16);
        e.q(outputStream, arrayList.size());
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            q qVar = (q) arrayList.get(i3);
            e.q(outputStream, qVar.f1435a.b());
            e.q(outputStream, length2);
            if (qVar.f1438d) {
                byte[] bArr = qVar.f1437c;
                long length3 = bArr.length;
                byte[] b4 = e.b(bArr);
                arrayList2.add(b4);
                e.q(outputStream, b4.length);
                e.q(outputStream, length3);
                length = b4.length;
            } else {
                arrayList2.add(qVar.f1437c);
                e.q(outputStream, qVar.f1437c.length);
                e.q(outputStream, 0L);
                length = qVar.f1437c.length;
            }
            length2 += length;
        }
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            outputStream.write((byte[]) arrayList2.get(i4));
        }
    }

    private static int a(d dVar) {
        Iterator<Map.Entry<Integer, Integer>> it = dVar.f1398i.entrySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 |= it.next().getValue().intValue();
        }
        return i3;
    }

    private static byte[] b(d[] dVarArr, byte[] bArr) {
        int i3 = 0;
        int i4 = 0;
        for (d dVar : dVarArr) {
            i4 += e.k(j(dVar.f1390a, dVar.f1391b, bArr)) + 16 + (dVar.f1394e * 2) + dVar.f1395f + k(dVar.f1396g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i4);
        if (Arrays.equals(bArr, p.f1430c)) {
            int length = dVarArr.length;
            while (i3 < length) {
                d dVar2 = dVarArr[i3];
                G(byteArrayOutputStream, dVar2, j(dVar2.f1390a, dVar2.f1391b, bArr));
                F(byteArrayOutputStream, dVar2);
                i3++;
            }
        } else {
            for (d dVar3 : dVarArr) {
                G(byteArrayOutputStream, dVar3, j(dVar3.f1390a, dVar3.f1391b, bArr));
            }
            int length2 = dVarArr.length;
            while (i3 < length2) {
                F(byteArrayOutputStream, dVarArr[i3]);
                i3++;
            }
        }
        if (byteArrayOutputStream.size() == i4) {
            return byteArrayOutputStream.toByteArray();
        }
        throw e.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i4);
    }

    private static q c(d[] dVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 0;
        for (int i4 = 0; i4 < dVarArr.length; i4++) {
            try {
                d dVar = dVarArr[i4];
                e.p(byteArrayOutputStream, i4);
                e.p(byteArrayOutputStream, dVar.f1394e);
                i3 = i3 + 2 + 2 + (dVar.f1394e * 2);
                C(byteArrayOutputStream, dVar);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i3 == byteArray.length) {
            q qVar = new q(f.CLASSES, i3, byteArray, true);
            byteArrayOutputStream.close();
            return qVar;
        }
        throw e.c("Expected size " + i3 + ", does not match actual size " + byteArray.length);
    }

    private static q d(d[] dVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 0;
        for (int i4 = 0; i4 < dVarArr.length; i4++) {
            try {
                d dVar = dVarArr[i4];
                int a4 = a(dVar);
                byte[] e3 = e(dVar);
                byte[] f3 = f(dVar);
                e.p(byteArrayOutputStream, i4);
                int length = e3.length + 2 + f3.length;
                e.q(byteArrayOutputStream, length);
                e.p(byteArrayOutputStream, a4);
                byteArrayOutputStream.write(e3);
                byteArrayOutputStream.write(f3);
                i3 = i3 + 2 + 4 + length;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i3 == byteArray.length) {
            q qVar = new q(f.METHODS, i3, byteArray, true);
            byteArrayOutputStream.close();
            return qVar;
        }
        throw e.c("Expected size " + i3 + ", does not match actual size " + byteArray.length);
    }

    private static byte[] e(d dVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, dVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static byte[] f(d dVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, dVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static String g(String str, String str2) {
        return "!".equals(str2) ? str.replace(":", "!") : ":".equals(str2) ? str.replace("!", ":") : str;
    }

    private static String h(String str) {
        int indexOf = str.indexOf("!");
        if (indexOf < 0) {
            indexOf = str.indexOf(":");
        }
        return indexOf > 0 ? str.substring(indexOf + 1) : str;
    }

    private static d i(d[] dVarArr, String str) {
        if (dVarArr.length <= 0) {
            return null;
        }
        String h3 = h(str);
        for (int i3 = 0; i3 < dVarArr.length; i3++) {
            if (dVarArr[i3].f1391b.equals(h3)) {
                return dVarArr[i3];
            }
        }
        return null;
    }

    private static String j(String str, String str2, byte[] bArr) {
        String a4 = p.a(bArr);
        if (str.length() <= 0) {
            return g(str2, a4);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return g(str2, a4);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + p.a(bArr) + str2;
    }

    private static int k(int i3) {
        return y(i3 * 2) / 8;
    }

    private static int l(int i3, int i4, int i5) {
        if (i3 == 1) {
            throw e.c("HOT methods are not stored in the bitmap");
        }
        if (i3 == 2) {
            return i4;
        }
        if (i3 == 4) {
            return i4 + i5;
        }
        throw e.c("Unexpected flag: " + i3);
    }

    private static int[] m(InputStream inputStream, int i3) {
        int[] iArr = new int[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            i4 += e.h(inputStream);
            iArr[i5] = i4;
        }
        return iArr;
    }

    private static int n(BitSet bitSet, int i3, int i4) {
        int i5 = bitSet.get(l(2, i3, i4)) ? 2 : 0;
        return bitSet.get(l(4, i3, i4)) ? i5 | 4 : i5;
    }

    static byte[] o(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, e.d(inputStream, bArr.length))) {
            return e.d(inputStream, p.f1429b.length);
        }
        throw e.c("Invalid magic");
    }

    private static void p(InputStream inputStream, d dVar) {
        int available = inputStream.available() - dVar.f1395f;
        int i3 = 0;
        while (inputStream.available() > available) {
            i3 += e.h(inputStream);
            dVar.f1398i.put(Integer.valueOf(i3), 1);
            for (int h3 = e.h(inputStream); h3 > 0; h3--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != available) {
            throw e.c("Read too much data during profile line parse");
        }
    }

    static d[] q(InputStream inputStream, byte[] bArr, byte[] bArr2, d[] dVarArr) {
        if (Arrays.equals(bArr, p.f1433f)) {
            if (Arrays.equals(p.f1428a, bArr2)) {
                throw e.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return r(inputStream, bArr, dVarArr);
        }
        if (Arrays.equals(bArr, p.f1434g)) {
            return t(inputStream, bArr2, dVarArr);
        }
        throw e.c("Unsupported meta version");
    }

    static d[] r(InputStream inputStream, byte[] bArr, d[] dVarArr) {
        if (!Arrays.equals(bArr, p.f1433f)) {
            throw e.c("Unsupported meta version");
        }
        int j3 = e.j(inputStream);
        byte[] e3 = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
        if (inputStream.read() > 0) {
            throw e.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e3);
        try {
            d[] s3 = s(byteArrayInputStream, j3, dVarArr);
            byteArrayInputStream.close();
            return s3;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static d[] s(InputStream inputStream, int i3, d[] dVarArr) {
        if (inputStream.available() == 0) {
            return new d[0];
        }
        if (i3 != dVarArr.length) {
            throw e.c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i3];
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int h3 = e.h(inputStream);
            iArr[i4] = e.h(inputStream);
            strArr[i4] = e.f(inputStream, h3);
        }
        for (int i5 = 0; i5 < i3; i5++) {
            d dVar = dVarArr[i5];
            if (!dVar.f1391b.equals(strArr[i5])) {
                throw e.c("Order of dexfiles in metadata did not match baseline");
            }
            int i6 = iArr[i5];
            dVar.f1394e = i6;
            dVar.f1397h = m(inputStream, i6);
        }
        return dVarArr;
    }

    static d[] t(InputStream inputStream, byte[] bArr, d[] dVarArr) {
        int h3 = e.h(inputStream);
        byte[] e3 = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
        if (inputStream.read() > 0) {
            throw e.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e3);
        try {
            d[] u3 = u(byteArrayInputStream, bArr, h3, dVarArr);
            byteArrayInputStream.close();
            return u3;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static d[] u(InputStream inputStream, byte[] bArr, int i3, d[] dVarArr) {
        if (inputStream.available() == 0) {
            return new d[0];
        }
        if (i3 != dVarArr.length) {
            throw e.c("Mismatched number of dex files found in metadata");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            e.h(inputStream);
            String f3 = e.f(inputStream, e.h(inputStream));
            long i5 = e.i(inputStream);
            int h3 = e.h(inputStream);
            d i6 = i(dVarArr, f3);
            if (i6 == null) {
                throw e.c("Missing profile key: " + f3);
            }
            i6.f1393d = i5;
            int[] m3 = m(inputStream, h3);
            if (Arrays.equals(bArr, p.f1432e)) {
                i6.f1394e = h3;
                i6.f1397h = m3;
            }
        }
        return dVarArr;
    }

    private static void v(InputStream inputStream, d dVar) {
        BitSet valueOf = BitSet.valueOf(e.d(inputStream, e.a(dVar.f1396g * 2)));
        int i3 = 0;
        while (true) {
            int i4 = dVar.f1396g;
            if (i3 >= i4) {
                return;
            }
            int n3 = n(valueOf, i3, i4);
            if (n3 != 0) {
                Integer num = dVar.f1398i.get(Integer.valueOf(i3));
                if (num == null) {
                    num = 0;
                }
                dVar.f1398i.put(Integer.valueOf(i3), Integer.valueOf(n3 | num.intValue()));
            }
            i3++;
        }
    }

    static d[] w(InputStream inputStream, byte[] bArr, String str) {
        if (!Arrays.equals(bArr, p.f1429b)) {
            throw e.c("Unsupported version");
        }
        int j3 = e.j(inputStream);
        byte[] e3 = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
        if (inputStream.read() > 0) {
            throw e.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e3);
        try {
            d[] x3 = x(byteArrayInputStream, str, j3);
            byteArrayInputStream.close();
            return x3;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static d[] x(InputStream inputStream, String str, int i3) {
        if (inputStream.available() == 0) {
            return new d[0];
        }
        d[] dVarArr = new d[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int h3 = e.h(inputStream);
            int h4 = e.h(inputStream);
            long i5 = e.i(inputStream);
            dVarArr[i4] = new d(str, e.f(inputStream, h3), e.i(inputStream), 0L, h4, (int) i5, (int) e.i(inputStream), new int[h4], new TreeMap());
        }
        for (int i6 = 0; i6 < i3; i6++) {
            d dVar = dVarArr[i6];
            p(inputStream, dVar);
            dVar.f1397h = m(inputStream, dVar.f1394e);
            v(inputStream, dVar);
        }
        return dVarArr;
    }

    private static int y(int i3) {
        return ((i3 + 8) - 1) & (-8);
    }

    private static void z(byte[] bArr, int i3, int i4, d dVar) {
        int l3 = l(i3, i4, dVar.f1396g);
        int i5 = l3 / 8;
        bArr[i5] = (byte) ((1 << (l3 % 8)) | bArr[i5]);
    }
}
