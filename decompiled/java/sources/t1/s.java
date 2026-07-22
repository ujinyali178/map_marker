package t1;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public final u1.l f4285a;

    /* renamed from: b, reason: collision with root package name */
    private f f4286b;

    /* renamed from: c, reason: collision with root package name */
    final l.c f4287c;

    class a implements l.c {
        a() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // u1.l.c
        public void n(u1.k kVar, l.d dVar) {
            Bundle bundle;
            if (s.this.f4286b == null) {
            }
            String str = kVar.f4372a;
            Object obj = kVar.f4373b;
            g1.b.f("TextInputChannel", "Received '" + str + "' message.");
            str.hashCode();
            char c3 = 65535;
            switch (str.hashCode()) {
                case -1779068172:
                    if (str.equals("TextInput.setPlatformViewClient")) {
                        c3 = 0;
                        break;
                    }
                    break;
                case -1015421462:
                    if (str.equals("TextInput.setEditingState")) {
                        c3 = 1;
                        break;
                    }
                    break;
                case -37561188:
                    if (str.equals("TextInput.setClient")) {
                        c3 = 2;
                        break;
                    }
                    break;
                case 270476819:
                    if (str.equals("TextInput.hide")) {
                        c3 = 3;
                        break;
                    }
                    break;
                case 270803918:
                    if (str.equals("TextInput.show")) {
                        c3 = 4;
                        break;
                    }
                    break;
                case 649192816:
                    if (str.equals("TextInput.sendAppPrivateCommand")) {
                        c3 = 5;
                        break;
                    }
                    break;
                case 1204752139:
                    if (str.equals("TextInput.setEditableSizeAndTransform")) {
                        c3 = 6;
                        break;
                    }
                    break;
                case 1727570905:
                    if (str.equals("TextInput.finishAutofillContext")) {
                        c3 = 7;
                        break;
                    }
                    break;
                case 1904427655:
                    if (str.equals("TextInput.clearClient")) {
                        c3 = '\b';
                        break;
                    }
                    break;
                case 2113369584:
                    if (str.equals("TextInput.requestAutofill")) {
                        c3 = '\t';
                        break;
                    }
                    break;
            }
            try {
                switch (c3) {
                    case 0:
                        JSONObject jSONObject = (JSONObject) obj;
                        s.this.f4286b.d(jSONObject.getInt("platformViewId"), jSONObject.optBoolean("usesVirtualDisplay", false));
                        dVar.a(null);
                        break;
                    case 1:
                        s.this.f4286b.b(e.a((JSONObject) obj));
                        dVar.a(null);
                        break;
                    case 2:
                        try {
                            JSONArray jSONArray = (JSONArray) obj;
                            s.this.f4286b.a(jSONArray.getInt(0), b.a(jSONArray.getJSONObject(1)));
                            dVar.a(null);
                            break;
                        } catch (NoSuchFieldException e3) {
                            e = e3;
                            dVar.b("error", e.getMessage(), null);
                            return;
                        }
                    case 3:
                        s.this.f4286b.j();
                        dVar.a(null);
                        break;
                    case 4:
                        s.this.f4286b.i();
                        dVar.a(null);
                        break;
                    case 5:
                        JSONObject jSONObject2 = (JSONObject) obj;
                        String string = jSONObject2.getString("action");
                        String string2 = jSONObject2.getString("data");
                        if (string2 == null || string2.isEmpty()) {
                            bundle = null;
                        } else {
                            bundle = new Bundle();
                            bundle.putString("data", string2);
                        }
                        s.this.f4286b.c(string, bundle);
                        dVar.a(null);
                        break;
                    case 6:
                        JSONObject jSONObject3 = (JSONObject) obj;
                        double d3 = jSONObject3.getDouble("width");
                        double d4 = jSONObject3.getDouble("height");
                        JSONArray jSONArray2 = jSONObject3.getJSONArray("transform");
                        double[] dArr = new double[16];
                        for (int i3 = 0; i3 < 16; i3++) {
                            dArr[i3] = jSONArray2.getDouble(i3);
                        }
                        s.this.f4286b.e(d3, d4, dArr);
                        dVar.a(null);
                        break;
                    case 7:
                        s.this.f4286b.g(((Boolean) obj).booleanValue());
                        dVar.a(null);
                        break;
                    case '\b':
                        s.this.f4286b.h();
                        dVar.a(null);
                        break;
                    case '\t':
                        s.this.f4286b.f();
                        dVar.a(null);
                        break;
                    default:
                        dVar.c();
                        break;
                }
            } catch (JSONException e4) {
                e = e4;
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f4289a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f4290b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f4291c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f4292d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f4293e;

        /* renamed from: f, reason: collision with root package name */
        public final d f4294f;

        /* renamed from: g, reason: collision with root package name */
        public final c f4295g;

        /* renamed from: h, reason: collision with root package name */
        public final Integer f4296h;

        /* renamed from: i, reason: collision with root package name */
        public final String f4297i;

        /* renamed from: j, reason: collision with root package name */
        public final a f4298j;

        /* renamed from: k, reason: collision with root package name */
        public final String[] f4299k;

        /* renamed from: l, reason: collision with root package name */
        public final b[] f4300l;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public final String f4301a;

            /* renamed from: b, reason: collision with root package name */
            public final String[] f4302b;

            /* renamed from: c, reason: collision with root package name */
            public final e f4303c;

            /* renamed from: d, reason: collision with root package name */
            public final String f4304d;

            public a(String str, String[] strArr, String str2, e eVar) {
                this.f4301a = str;
                this.f4302b = strArr;
                this.f4304d = str2;
                this.f4303c = eVar;
            }

            public static a a(JSONObject jSONObject) {
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                String string2 = jSONObject.isNull("hintText") ? null : jSONObject.getString("hintText");
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                String[] strArr = new String[jSONArray.length()];
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    strArr[i3] = b(jSONArray.getString(i3));
                }
                return new a(string, strArr, string2, e.a(jSONObject2));
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:74:0x00a3, code lost:
            
                if (r16.equals("familyName") == false) goto L7;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            private static java.lang.String b(java.lang.String r16) {
                /*
                    Method dump skipped, instructions count: 802
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: t1.s.b.a.b(java.lang.String):java.lang.String");
            }
        }

        public b(boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, d dVar, c cVar, Integer num, String str, a aVar, String[] strArr, b[] bVarArr) {
            this.f4289a = z3;
            this.f4290b = z4;
            this.f4291c = z5;
            this.f4292d = z6;
            this.f4293e = z7;
            this.f4294f = dVar;
            this.f4295g = cVar;
            this.f4296h = num;
            this.f4297i = str;
            this.f4298j = aVar;
            this.f4299k = strArr;
            this.f4300l = bVarArr;
        }

        public static b a(JSONObject jSONObject) {
            b[] bVarArr;
            String string = jSONObject.getString("inputAction");
            if (string == null) {
                throw new JSONException("Configuration JSON missing 'inputAction' property.");
            }
            if (jSONObject.isNull("fields")) {
                bVarArr = null;
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("fields");
                int length = jSONArray.length();
                b[] bVarArr2 = new b[length];
                for (int i3 = 0; i3 < length; i3++) {
                    bVarArr2[i3] = a(jSONArray.getJSONObject(i3));
                }
                bVarArr = bVarArr2;
            }
            Integer b4 = b(string);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = jSONObject.isNull("contentCommitMimeTypes") ? null : jSONObject.getJSONArray("contentCommitMimeTypes");
            if (jSONArray2 != null) {
                for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                    arrayList.add(jSONArray2.optString(i4));
                }
            }
            return new b(jSONObject.optBoolean("obscureText"), jSONObject.optBoolean("autocorrect", true), jSONObject.optBoolean("enableSuggestions"), jSONObject.optBoolean("enableIMEPersonalizedLearning"), jSONObject.optBoolean("enableDeltaModel"), d.b(jSONObject.getString("textCapitalization")), c.a(jSONObject.getJSONObject("inputType")), b4, jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel"), jSONObject.isNull("autofill") ? null : a.a(jSONObject.getJSONObject("autofill")), (String[]) arrayList.toArray(new String[arrayList.size()]), bVarArr);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0072, code lost:
        
            if (r12.equals("TextInputAction.done") == false) goto L4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static java.lang.Integer b(java.lang.String r12) {
            /*
                r12.hashCode()
                int r0 = r12.hashCode()
                r1 = 7
                r2 = 6
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 2
                r7 = 1
                java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
                r9 = 0
                java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
                r11 = -1
                switch(r0) {
                    case -810971940: goto L75;
                    case -737377923: goto L6c;
                    case -737089298: goto L61;
                    case -737080013: goto L56;
                    case -736940669: goto L4b;
                    case 469250275: goto L40;
                    case 1241689507: goto L35;
                    case 1539450297: goto L2a;
                    case 2110497650: goto L1e;
                    default: goto L1b;
                }
            L1b:
                r7 = -1
                goto L7f
            L1e:
                java.lang.String r0 = "TextInputAction.previous"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L27
                goto L1b
            L27:
                r7 = 8
                goto L7f
            L2a:
                java.lang.String r0 = "TextInputAction.newline"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L33
                goto L1b
            L33:
                r7 = 7
                goto L7f
            L35:
                java.lang.String r0 = "TextInputAction.go"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L3e
                goto L1b
            L3e:
                r7 = 6
                goto L7f
            L40:
                java.lang.String r0 = "TextInputAction.search"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L49
                goto L1b
            L49:
                r7 = 5
                goto L7f
            L4b:
                java.lang.String r0 = "TextInputAction.send"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L54
                goto L1b
            L54:
                r7 = 4
                goto L7f
            L56:
                java.lang.String r0 = "TextInputAction.none"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L5f
                goto L1b
            L5f:
                r7 = 3
                goto L7f
            L61:
                java.lang.String r0 = "TextInputAction.next"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L6a
                goto L1b
            L6a:
                r7 = 2
                goto L7f
            L6c:
                java.lang.String r0 = "TextInputAction.done"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L7f
                goto L1b
            L75:
                java.lang.String r0 = "TextInputAction.unspecified"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L7e
                goto L1b
            L7e:
                r7 = 0
            L7f:
                switch(r7) {
                    case 0: goto La3;
                    case 1: goto L9e;
                    case 2: goto L99;
                    case 3: goto L98;
                    case 4: goto L93;
                    case 5: goto L8e;
                    case 6: goto L89;
                    case 7: goto L88;
                    case 8: goto L83;
                    default: goto L82;
                }
            L82:
                return r10
            L83:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
                return r12
            L88:
                return r8
            L89:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
                return r12
            L8e:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r5)
                return r12
            L93:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r4)
                return r12
            L98:
                return r8
            L99:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r3)
                return r12
            L9e:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r2)
                return r12
            La3:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: t1.s.b.b(java.lang.String):java.lang.Integer");
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final g f4305a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f4306b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f4307c;

        public c(g gVar, boolean z3, boolean z4) {
            this.f4305a = gVar;
            this.f4306b = z3;
            this.f4307c = z4;
        }

        public static c a(JSONObject jSONObject) {
            return new c(g.b(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }
    }

    public enum d {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");


        /* renamed from: c, reason: collision with root package name */
        private final String f4313c;

        d(String str) {
            this.f4313c = str;
        }

        static d b(String str) {
            for (d dVar : values()) {
                if (dVar.f4313c.equals(str)) {
                    return dVar;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final String f4314a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4315b;

        /* renamed from: c, reason: collision with root package name */
        public final int f4316c;

        /* renamed from: d, reason: collision with root package name */
        public final int f4317d;

        /* renamed from: e, reason: collision with root package name */
        public final int f4318e;

        public e(String str, int i3, int i4, int i5, int i6) {
            if (!(i3 == -1 && i4 == -1) && (i3 < 0 || i4 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i3) + ", " + String.valueOf(i4) + ")");
            }
            if (!(i5 == -1 && i6 == -1) && (i5 < 0 || i5 > i6)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i5) + ", " + String.valueOf(i6) + ")");
            }
            if (i6 > str.length()) {
                throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i5));
            }
            if (i3 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i3));
            }
            if (i4 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i4));
            }
            this.f4314a = str;
            this.f4315b = i3;
            this.f4316c = i4;
            this.f4317d = i5;
            this.f4318e = i6;
        }

        public static e a(JSONObject jSONObject) {
            return new e(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }

        public boolean b() {
            int i3 = this.f4317d;
            return i3 >= 0 && this.f4318e > i3;
        }

        public boolean c() {
            return this.f4315b >= 0;
        }
    }

    public interface f {
        void a(int i3, b bVar);

        void b(e eVar);

        void c(String str, Bundle bundle);

        void d(int i3, boolean z3);

        void e(double d3, double d4, double[] dArr);

        void f();

        void g(boolean z3);

        void h();

        void i();

        void j();
    }

    public enum g {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword"),
        NONE("TextInputType.none");


        /* renamed from: c, reason: collision with root package name */
        private final String f4331c;

        g(String str) {
            this.f4331c = str;
        }

        static g b(String str) {
            for (g gVar : values()) {
                if (gVar.f4331c.equals(str)) {
                    return gVar;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }
    }

    public s(i1.a aVar) {
        a aVar2 = new a();
        this.f4287c = aVar2;
        u1.l lVar = new u1.l(aVar, "flutter/textinput", u1.h.f4371a);
        this.f4285a = lVar;
        lVar.e(aVar2);
    }

    private static HashMap<Object, Object> c(ArrayList<io.flutter.plugin.editing.g> arrayList) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        JSONArray jSONArray = new JSONArray();
        Iterator<io.flutter.plugin.editing.g> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().b());
        }
        hashMap.put("deltas", jSONArray);
        return hashMap;
    }

    private static HashMap<Object, Object> d(String str, int i3, int i4, int i5, int i6) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i3));
        hashMap.put("selectionExtent", Integer.valueOf(i4));
        hashMap.put("composingBase", Integer.valueOf(i5));
        hashMap.put("composingExtent", Integer.valueOf(i6));
        return hashMap;
    }

    public void b(int i3, Map<String, Object> map) {
        g1.b.f("TextInputChannel", "Sending 'commitContent' message.");
        this.f4285a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i3), "TextInputAction.commitContent", map));
    }

    public void e(int i3) {
        g1.b.f("TextInputChannel", "Sending 'done' message.");
        this.f4285a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i3), "TextInputAction.done"));
    }

    public void f(int i3) {
        g1.b.f("TextInputChannel", "Sending 'go' message.");
        this.f4285a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i3), "TextInputAction.go"));
    }

    public void g(int i3) {
        g1.b.f("TextInputChannel", "Sending 'newline' message.");
        this.f4285a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i3), "TextInputAction.newline"));
    }

    public void h(int i3) {
        g1.b.f("TextInputChannel", "Sending 'next' message.");
        this.f4285a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i3), "TextInputAction.next"));
    }

    public void i(int i3, String str, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        if (bundle != null) {
            HashMap hashMap2 = new HashMap();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof byte[]) {
                    hashMap2.put(str2, bundle.getByteArray(str2));
                } else if (obj instanceof Byte) {
                    hashMap2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                } else if (obj instanceof char[]) {
                    hashMap2.put(str2, bundle.getCharArray(str2));
                } else if (obj instanceof Character) {
                    hashMap2.put(str2, Character.valueOf(bundle.getChar(str2)));
                } else if (obj instanceof CharSequence[]) {
                    hashMap2.put(str2, bundle.getCharSequenceArray(str2));
                } else if (obj instanceof CharSequence) {
                    hashMap2.put(str2, bundle.getCharSequence(str2));
                } else if (obj instanceof float[]) {
                    hashMap2.put(str2, bundle.getFloatArray(str2));
                } else if (obj instanceof Float) {
                    hashMap2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                }
            }
            hashMap.put("data", hashMap2);
        }
        this.f4285a.c("TextInputClient.performPrivateCommand", Arrays.asList(Integer.valueOf(i3), hashMap));
    }

    public void j(int i3) {
        g1.b.f("TextInputChannel", "Sending 'previous' message.");
        this.f4285a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i3), "TextInputAction.previous"));
    }

    public void k() {
        this.f4285a.c("TextInputClient.requestExistingInputState", null);
    }

    public void l(int i3) {
        g1.b.f("TextInputChannel", "Sending 'search' message.");
        this.f4285a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i3), "TextInputAction.search"));
    }

    public void m(int i3) {
        g1.b.f("TextInputChannel", "Sending 'send' message.");
        this.f4285a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i3), "TextInputAction.send"));
    }

    public void n(f fVar) {
        this.f4286b = fVar;
    }

    public void o(int i3) {
        g1.b.f("TextInputChannel", "Sending 'unspecified' message.");
        this.f4285a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i3), "TextInputAction.unspecified"));
    }

    public void p(int i3, String str, int i4, int i5, int i6, int i7) {
        g1.b.f("TextInputChannel", "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i4 + "\nSelection end: " + i5 + "\nComposing start: " + i6 + "\nComposing end: " + i7);
        this.f4285a.c("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i3), d(str, i4, i5, i6, i7)));
    }

    public void q(int i3, ArrayList<io.flutter.plugin.editing.g> arrayList) {
        g1.b.f("TextInputChannel", "Sending message to update editing state with deltas: \nNumber of deltas: " + arrayList.size());
        this.f4285a.c("TextInputClient.updateEditingStateWithDeltas", Arrays.asList(Integer.valueOf(i3), c(arrayList)));
    }

    public void r(int i3, HashMap<String, e> hashMap) {
        g1.b.f("TextInputChannel", "Sending message to update editing state for " + String.valueOf(hashMap.size()) + " field(s).");
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, e> entry : hashMap.entrySet()) {
            e value = entry.getValue();
            hashMap2.put(entry.getKey(), d(value.f4314a, value.f4315b, value.f4316c, -1, -1));
        }
        this.f4285a.c("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i3), hashMap2));
    }
}
