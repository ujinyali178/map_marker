package t1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public final u1.l f4159a;

    /* renamed from: b, reason: collision with root package name */
    private h f4160b;

    /* renamed from: c, reason: collision with root package name */
    final l.c f4161c;

    class a implements l.c {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0143 A[Catch: JSONException -> 0x024c, TryCatch #11 {JSONException -> 0x024c, blocks: (B:7:0x002c, B:8:0x0030, B:12:0x00db, B:14:0x00e0, B:15:0x00eb, B:17:0x00f0, B:19:0x0109, B:20:0x0119, B:28:0x011d, B:23:0x0137, B:25:0x0143, B:30:0x0122, B:31:0x0150, B:32:0x015a, B:33:0x018c, B:34:0x0197, B:36:0x0218, B:44:0x0232, B:60:0x0183, B:41:0x0187, B:66:0x01bb, B:78:0x01d9, B:54:0x01f5, B:72:0x0212, B:40:0x022c, B:48:0x0246, B:79:0x0035, B:82:0x0040, B:85:0x004b, B:88:0x0057, B:91:0x0063, B:94:0x006e, B:97:0x0079, B:100:0x0083, B:103:0x008d, B:106:0x0097, B:109:0x00a1, B:112:0x00ab, B:115:0x00b6, B:118:0x00c1, B:121:0x00cc, B:50:0x01de), top: B:6:0x002c, inners: #1, #2, #5, #8 }] */
        @Override // u1.l.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void n(u1.k r6, u1.l.d r7) {
            /*
                Method dump skipped, instructions count: 710
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: t1.k.a.n(u1.k, u1.l$d):void");
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4163a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f4164b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f4165c;

        static {
            int[] iArr = new int[EnumC0104k.values().length];
            f4165c = iArr;
            try {
                iArr[EnumC0104k.LEAN_BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4165c[EnumC0104k.IMMERSIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4165c[EnumC0104k.IMMERSIVE_STICKY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4165c[EnumC0104k.EDGE_TO_EDGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[l.values().length];
            f4164b = iArr2;
            try {
                iArr2[l.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4164b[l.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[f.values().length];
            f4163a = iArr3;
            try {
                iArr3[f.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4163a[f.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4163a[f.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4163a[f.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f4166a;

        /* renamed from: b, reason: collision with root package name */
        public final String f4167b;

        public c(int i3, String str) {
            this.f4166a = i3;
            this.f4167b = str;
        }
    }

    public enum d {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");


        /* renamed from: c, reason: collision with root package name */
        private String f4171c;

        d(String str) {
            this.f4171c = str;
        }

        static d b(String str) {
            for (d dVar : values()) {
                if (dVar.f4171c.equals(str)) {
                    return dVar;
                }
            }
            throw new NoSuchFieldException("No such Brightness: " + str);
        }
    }

    public enum e {
        PLAIN_TEXT("text/plain");


        /* renamed from: c, reason: collision with root package name */
        private String f4174c;

        e(String str) {
            this.f4174c = str;
        }

        static e b(String str) {
            for (e eVar : values()) {
                if (eVar.f4174c.equals(str)) {
                    return eVar;
                }
            }
            throw new NoSuchFieldException("No such ClipboardContentFormat: " + str);
        }
    }

    public enum f {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");


        /* renamed from: c, reason: collision with root package name */
        private String f4180c;

        f(String str) {
            this.f4180c = str;
        }

        static f b(String str) {
            for (f fVar : values()) {
                if (fVar.f4180c.equals(str)) {
                    return fVar;
                }
            }
            throw new NoSuchFieldException("No such DeviceOrientation: " + str);
        }
    }

    public enum g {
        STANDARD(null),
        LIGHT_IMPACT("HapticFeedbackType.lightImpact"),
        MEDIUM_IMPACT("HapticFeedbackType.mediumImpact"),
        HEAVY_IMPACT("HapticFeedbackType.heavyImpact"),
        SELECTION_CLICK("HapticFeedbackType.selectionClick");


        /* renamed from: c, reason: collision with root package name */
        private final String f4187c;

        g(String str) {
            this.f4187c = str;
        }

        static g b(String str) {
            for (g gVar : values()) {
                String str2 = gVar.f4187c;
                if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                    return gVar;
                }
            }
            throw new NoSuchFieldException("No such HapticFeedbackType: " + str);
        }
    }

    public interface h {
        void a();

        CharSequence b(e eVar);

        void c(List<l> list);

        void d(EnumC0104k enumC0104k);

        void e(String str);

        void f(boolean z3);

        void g(String str);

        void h(i iVar);

        void i(j jVar);

        void j();

        void k(c cVar);

        void l();

        void m(int i3);

        void n(g gVar);

        boolean o();
    }

    public enum i {
        CLICK("SystemSoundType.click"),
        ALERT("SystemSoundType.alert");


        /* renamed from: c, reason: collision with root package name */
        private final String f4191c;

        i(String str) {
            this.f4191c = str;
        }

        static i b(String str) {
            for (i iVar : values()) {
                if (iVar.f4191c.equals(str)) {
                    return iVar;
                }
            }
            throw new NoSuchFieldException("No such SoundType: " + str);
        }
    }

    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public final Integer f4192a;

        /* renamed from: b, reason: collision with root package name */
        public final d f4193b;

        /* renamed from: c, reason: collision with root package name */
        public final Boolean f4194c;

        /* renamed from: d, reason: collision with root package name */
        public final Integer f4195d;

        /* renamed from: e, reason: collision with root package name */
        public final d f4196e;

        /* renamed from: f, reason: collision with root package name */
        public final Integer f4197f;

        /* renamed from: g, reason: collision with root package name */
        public final Boolean f4198g;

        public j(Integer num, d dVar, Boolean bool, Integer num2, d dVar2, Integer num3, Boolean bool2) {
            this.f4192a = num;
            this.f4193b = dVar;
            this.f4194c = bool;
            this.f4195d = num2;
            this.f4196e = dVar2;
            this.f4197f = num3;
            this.f4198g = bool2;
        }
    }

    /* renamed from: t1.k$k, reason: collision with other inner class name */
    public enum EnumC0104k {
        LEAN_BACK("SystemUiMode.leanBack"),
        IMMERSIVE("SystemUiMode.immersive"),
        IMMERSIVE_STICKY("SystemUiMode.immersiveSticky"),
        EDGE_TO_EDGE("SystemUiMode.edgeToEdge");


        /* renamed from: c, reason: collision with root package name */
        private String f4204c;

        EnumC0104k(String str) {
            this.f4204c = str;
        }

        static EnumC0104k b(String str) {
            for (EnumC0104k enumC0104k : values()) {
                if (enumC0104k.f4204c.equals(str)) {
                    return enumC0104k;
                }
            }
            throw new NoSuchFieldException("No such SystemUiMode: " + str);
        }
    }

    public enum l {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");


        /* renamed from: c, reason: collision with root package name */
        private String f4208c;

        l(String str) {
            this.f4208c = str;
        }

        static l b(String str) {
            for (l lVar : values()) {
                if (lVar.f4208c.equals(str)) {
                    return lVar;
                }
            }
            throw new NoSuchFieldException("No such SystemUiOverlay: " + str);
        }
    }

    public k(i1.a aVar) {
        a aVar2 = new a();
        this.f4161c = aVar2;
        u1.l lVar = new u1.l(aVar, "flutter/platform", u1.h.f4371a);
        this.f4159a = lVar;
        lVar.e(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c g(JSONObject jSONObject) {
        int i3 = jSONObject.getInt("primaryColor");
        if (i3 != 0) {
            i3 |= -16777216;
        }
        return new c(i3, jSONObject.getString("label"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0053 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int h(org.json.JSONArray r10) {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
        L4:
            int r4 = r10.length()
            r5 = 4
            r6 = 2
            r7 = 1
            if (r1 >= r4) goto L38
            java.lang.String r4 = r10.getString(r1)
            t1.k$f r4 = t1.k.f.b(r4)
            int[] r8 = t1.k.b.f4163a
            int r4 = r4.ordinal()
            r4 = r8[r4]
            if (r4 == r7) goto L30
            if (r4 == r6) goto L2d
            r6 = 3
            if (r4 == r6) goto L2a
            if (r4 == r5) goto L27
            goto L32
        L27:
            r2 = r2 | 8
            goto L32
        L2a:
            r2 = r2 | 2
            goto L32
        L2d:
            r2 = r2 | 4
            goto L32
        L30:
            r2 = r2 | 1
        L32:
            if (r3 != 0) goto L35
            r3 = r2
        L35:
            int r1 = r1 + 1
            goto L4
        L38:
            if (r2 == 0) goto L57
            r10 = 9
            r1 = 8
            switch(r2) {
                case 2: goto L56;
                case 3: goto L4d;
                case 4: goto L4c;
                case 5: goto L4a;
                case 6: goto L4d;
                case 7: goto L4d;
                case 8: goto L49;
                case 9: goto L4d;
                case 10: goto L46;
                case 11: goto L45;
                case 12: goto L4d;
                case 13: goto L4d;
                case 14: goto L4d;
                case 15: goto L42;
                default: goto L41;
            }
        L41:
            goto L53
        L42:
            r10 = 13
            return r10
        L45:
            return r6
        L46:
            r10 = 11
            return r10
        L49:
            return r1
        L4a:
            r10 = 12
        L4c:
            return r10
        L4d:
            if (r3 == r6) goto L56
            if (r3 == r5) goto L55
            if (r3 == r1) goto L54
        L53:
            return r7
        L54:
            return r1
        L55:
            return r10
        L56:
            return r0
        L57:
            r10 = -1
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.k.h(org.json.JSONArray):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j i(JSONObject jSONObject) {
        return new j(!jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null, !jSONObject.isNull("statusBarIconBrightness") ? d.b(jSONObject.getString("statusBarIconBrightness")) : null, !jSONObject.isNull("systemStatusBarContrastEnforced") ? Boolean.valueOf(jSONObject.getBoolean("systemStatusBarContrastEnforced")) : null, !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null, !jSONObject.isNull("systemNavigationBarIconBrightness") ? d.b(jSONObject.getString("systemNavigationBarIconBrightness")) : null, !jSONObject.isNull("systemNavigationBarDividerColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor")) : null, jSONObject.isNull("systemNavigationBarContrastEnforced") ? null : Boolean.valueOf(jSONObject.getBoolean("systemNavigationBarContrastEnforced")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EnumC0104k j(String str) {
        int i3 = b.f4165c[EnumC0104k.b(str).ordinal()];
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? EnumC0104k.EDGE_TO_EDGE : EnumC0104k.EDGE_TO_EDGE : EnumC0104k.IMMERSIVE_STICKY : EnumC0104k.IMMERSIVE : EnumC0104k.LEAN_BACK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<l> k(JSONArray jSONArray) {
        l lVar;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            int i4 = b.f4164b[l.b(jSONArray.getString(i3)).ordinal()];
            if (i4 == 1) {
                lVar = l.TOP_OVERLAYS;
            } else if (i4 == 2) {
                lVar = l.BOTTOM_OVERLAYS;
            }
            arrayList.add(lVar);
        }
        return arrayList;
    }

    public void l(h hVar) {
        this.f4160b = hVar;
    }

    public void m(boolean z3) {
        g1.b.f("PlatformChannel", "Sending 'systemUIChange' message.");
        this.f4159a.c("SystemChrome.systemUIChange", Arrays.asList(Boolean.valueOf(z3)));
    }
}
