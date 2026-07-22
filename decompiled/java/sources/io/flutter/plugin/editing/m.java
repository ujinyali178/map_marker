package io.flutter.plugin.editing;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.android.d0;
import io.flutter.plugin.editing.e;
import io.flutter.plugin.platform.y;
import java.util.HashMap;
import t1.s;

/* loaded from: /root/release/classes.dex */
public class m implements e.b {

    /* renamed from: a, reason: collision with root package name */
    private final View f3091a;

    /* renamed from: b, reason: collision with root package name */
    private final InputMethodManager f3092b;

    /* renamed from: c, reason: collision with root package name */
    private final AutofillManager f3093c;

    /* renamed from: d, reason: collision with root package name */
    private final s f3094d;

    /* renamed from: e, reason: collision with root package name */
    private c f3095e = new c(c.a.NO_TARGET, 0);

    /* renamed from: f, reason: collision with root package name */
    private s.b f3096f;

    /* renamed from: g, reason: collision with root package name */
    private SparseArray<s.b> f3097g;

    /* renamed from: h, reason: collision with root package name */
    private e f3098h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3099i;

    /* renamed from: j, reason: collision with root package name */
    private InputConnection f3100j;

    /* renamed from: k, reason: collision with root package name */
    private y f3101k;

    /* renamed from: l, reason: collision with root package name */
    private Rect f3102l;

    /* renamed from: m, reason: collision with root package name */
    private ImeSyncDeferringInsetsCallback f3103m;

    /* renamed from: n, reason: collision with root package name */
    private s.e f3104n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f3105o;

    class a implements s.f {
        a() {
        }

        @Override // t1.s.f
        public void a(int i3, s.b bVar) {
            m.this.C(i3, bVar);
        }

        @Override // t1.s.f
        public void b(s.e eVar) {
            m mVar = m.this;
            mVar.D(mVar.f3091a, eVar);
        }

        @Override // t1.s.f
        public void c(String str, Bundle bundle) {
            m.this.A(str, bundle);
        }

        @Override // t1.s.f
        public void d(int i3, boolean z3) {
            m.this.B(i3, z3);
        }

        @Override // t1.s.f
        public void e(double d3, double d4, double[] dArr) {
            m.this.z(d3, d4, dArr);
        }

        @Override // t1.s.f
        public void f() {
            m.this.w();
        }

        @Override // t1.s.f
        public void g(boolean z3) {
            if (Build.VERSION.SDK_INT < 26 || m.this.f3093c == null) {
                return;
            }
            if (z3) {
                m.this.f3093c.commit();
            } else {
                m.this.f3093c.cancel();
            }
        }

        @Override // t1.s.f
        public void h() {
            m.this.l();
        }

        @Override // t1.s.f
        public void i() {
            m mVar = m.this;
            mVar.E(mVar.f3091a);
        }

        @Override // t1.s.f
        public void j() {
            if (m.this.f3095e.f3111a == c.a.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
                m.this.x();
            } else {
                m mVar = m.this;
                mVar.r(mVar.f3091a);
            }
        }
    }

    class b implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3107a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ double[] f3108b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ double[] f3109c;

        b(boolean z3, double[] dArr, double[] dArr2) {
            this.f3107a = z3;
            this.f3108b = dArr;
            this.f3109c = dArr2;
        }

        @Override // io.flutter.plugin.editing.m.d
        public void a(double d3, double d4) {
            double d5 = 1.0d;
            if (!this.f3107a) {
                double[] dArr = this.f3108b;
                d5 = 1.0d / (((dArr[3] * d3) + (dArr[7] * d4)) + dArr[15]);
            }
            double[] dArr2 = this.f3108b;
            double d6 = ((dArr2[0] * d3) + (dArr2[4] * d4) + dArr2[12]) * d5;
            double d7 = ((dArr2[1] * d3) + (dArr2[5] * d4) + dArr2[13]) * d5;
            double[] dArr3 = this.f3109c;
            if (d6 < dArr3[0]) {
                dArr3[0] = d6;
            } else if (d6 > dArr3[1]) {
                dArr3[1] = d6;
            }
            if (d7 < dArr3[2]) {
                dArr3[2] = d7;
            } else if (d7 > dArr3[3]) {
                dArr3[3] = d7;
            }
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        a f3111a;

        /* renamed from: b, reason: collision with root package name */
        int f3112b;

        enum a {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            VIRTUAL_DISPLAY_PLATFORM_VIEW,
            PHYSICAL_DISPLAY_PLATFORM_VIEW
        }

        public c(a aVar, int i3) {
            this.f3111a = aVar;
            this.f3112b = i3;
        }
    }

    private interface d {
        void a(double d3, double d4);
    }

    public m(View view, s sVar, y yVar) {
        Object systemService;
        this.f3091a = view;
        AutofillManager autofillManager = null;
        this.f3098h = new e(null, view);
        this.f3092b = (InputMethodManager) view.getContext().getSystemService("input_method");
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            systemService = view.getContext().getSystemService((Class<Object>) AutofillManager.class);
            autofillManager = (AutofillManager) systemService;
        }
        this.f3093c = autofillManager;
        if (i3 >= 30) {
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view);
            this.f3103m = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
        }
        this.f3094d = sVar;
        sVar.n(new a());
        sVar.k();
        this.f3101k = yVar;
        yVar.D(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i3, boolean z3) {
        if (!z3) {
            this.f3095e = new c(c.a.PHYSICAL_DISPLAY_PLATFORM_VIEW, i3);
            this.f3100j = null;
        } else {
            this.f3091a.requestFocus();
            this.f3095e = new c(c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW, i3);
            this.f3092b.restartInput(this.f3091a);
            this.f3099i = false;
        }
    }

    private void G(s.b bVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (bVar == null || bVar.f4298j == null) {
            this.f3097g = null;
            return;
        }
        s.b[] bVarArr = bVar.f4300l;
        SparseArray<s.b> sparseArray = new SparseArray<>();
        this.f3097g = sparseArray;
        if (bVarArr == null) {
            sparseArray.put(bVar.f4298j.f4301a.hashCode(), bVar);
            return;
        }
        for (s.b bVar2 : bVarArr) {
            s.b.a aVar = bVar2.f4298j;
            if (aVar != null) {
                this.f3097g.put(aVar.f4301a.hashCode(), bVar2);
                this.f3093c.notifyValueChanged(this.f3091a, aVar.f4301a.hashCode(), AutofillValue.forText(aVar.f4303c.f4314a));
            }
        }
    }

    private static boolean m(s.e eVar, s.e eVar2) {
        int i3 = eVar.f4318e - eVar.f4317d;
        if (i3 != eVar2.f4318e - eVar2.f4317d) {
            return true;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (eVar.f4314a.charAt(eVar.f4317d + i4) != eVar2.f4314a.charAt(eVar2.f4317d + i4)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(View view) {
        x();
        this.f3092b.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    private static int s(s.c cVar, boolean z3, boolean z4, boolean z5, boolean z6, s.d dVar) {
        s.g gVar = cVar.f4305a;
        if (gVar == s.g.DATETIME) {
            return 4;
        }
        if (gVar == s.g.NUMBER) {
            int i3 = cVar.f4306b ? 4098 : 2;
            return cVar.f4307c ? i3 | 8192 : i3;
        }
        if (gVar == s.g.PHONE) {
            return 3;
        }
        if (gVar == s.g.NONE) {
            return 0;
        }
        int i4 = 1;
        if (gVar == s.g.MULTILINE) {
            i4 = 131073;
        } else if (gVar == s.g.EMAIL_ADDRESS) {
            i4 = 33;
        } else if (gVar == s.g.URL) {
            i4 = 17;
        } else if (gVar == s.g.VISIBLE_PASSWORD) {
            i4 = 145;
        } else if (gVar == s.g.NAME) {
            i4 = 97;
        } else if (gVar == s.g.POSTAL_ADDRESS) {
            i4 = 113;
        }
        if (z3) {
            i4 = i4 | 524288 | 128;
        } else {
            if (z4) {
                i4 |= 32768;
            }
            if (!z5) {
                i4 = i4 | 524288 | 144;
            }
        }
        return dVar == s.d.CHARACTERS ? i4 | 4096 : dVar == s.d.WORDS ? i4 | 8192 : dVar == s.d.SENTENCES ? i4 | 16384 : i4;
    }

    private boolean u() {
        return this.f3097g != null;
    }

    private void v(String str) {
        if (Build.VERSION.SDK_INT < 26 || this.f3093c == null || !u()) {
            return;
        }
        this.f3093c.notifyValueChanged(this.f3091a, this.f3096f.f4298j.f4301a.hashCode(), AutofillValue.forText(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (Build.VERSION.SDK_INT < 26 || this.f3093c == null || !u()) {
            return;
        }
        String str = this.f3096f.f4298j.f4301a;
        int[] iArr = new int[2];
        this.f3091a.getLocationOnScreen(iArr);
        Rect rect = new Rect(this.f3102l);
        rect.offset(iArr[0], iArr[1]);
        this.f3093c.notifyViewEntered(this.f3091a, str.hashCode(), rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        s.b bVar;
        if (Build.VERSION.SDK_INT < 26 || this.f3093c == null || (bVar = this.f3096f) == null || bVar.f4298j == null || !u()) {
            return;
        }
        this.f3093c.notifyViewExited(this.f3091a, this.f3096f.f4298j.f4301a.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(double d3, double d4, double[] dArr) {
        double[] dArr2 = new double[4];
        boolean z3 = dArr[3] == 0.0d && dArr[7] == 0.0d && dArr[15] == 1.0d;
        double d5 = dArr[12];
        double d6 = dArr[15];
        double d7 = d5 / d6;
        dArr2[1] = d7;
        dArr2[0] = d7;
        double d8 = dArr[13] / d6;
        dArr2[3] = d8;
        dArr2[2] = d8;
        b bVar = new b(z3, dArr, dArr2);
        bVar.a(d3, 0.0d);
        bVar.a(d3, d4);
        bVar.a(0.0d, d4);
        Float valueOf = Float.valueOf(this.f3091a.getContext().getResources().getDisplayMetrics().density);
        this.f3102l = new Rect((int) (dArr2[0] * valueOf.floatValue()), (int) (dArr2[2] * valueOf.floatValue()), (int) Math.ceil(dArr2[1] * valueOf.floatValue()), (int) Math.ceil(dArr2[3] * valueOf.floatValue()));
    }

    public void A(String str, Bundle bundle) {
        this.f3092b.sendAppPrivateCommand(this.f3091a, str, bundle);
    }

    void C(int i3, s.b bVar) {
        x();
        this.f3096f = bVar;
        this.f3095e = new c(c.a.FRAMEWORK_CLIENT, i3);
        this.f3098h.l(this);
        s.b.a aVar = bVar.f4298j;
        this.f3098h = new e(aVar != null ? aVar.f4303c : null, this.f3091a);
        G(bVar);
        this.f3099i = true;
        F();
        this.f3102l = null;
        this.f3098h.a(this);
    }

    void D(View view, s.e eVar) {
        s.e eVar2;
        if (!this.f3099i && (eVar2 = this.f3104n) != null && eVar2.b()) {
            boolean m3 = m(this.f3104n, eVar);
            this.f3099i = m3;
            if (m3) {
                g1.b.e("TextInputPlugin", "Composing region changed by the framework. Restarting the input method.");
            }
        }
        this.f3104n = eVar;
        this.f3098h.n(eVar);
        if (this.f3099i) {
            this.f3092b.restartInput(view);
            this.f3099i = false;
        }
    }

    void E(View view) {
        s.c cVar;
        s.b bVar = this.f3096f;
        if (bVar != null && (cVar = bVar.f4295g) != null && cVar.f4305a == s.g.NONE) {
            r(view);
        } else {
            view.requestFocus();
            this.f3092b.showSoftInput(view, 0);
        }
    }

    public void F() {
        if (this.f3095e.f3111a == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.f3105o = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
    
        if (r7 == r1.f4318e) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    @Override // io.flutter.plugin.editing.e.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r9, boolean r10, boolean r11) {
        /*
            r8 = this;
            if (r9 == 0) goto Lb
            io.flutter.plugin.editing.e r9 = r8.f3098h
            java.lang.String r9 = r9.toString()
            r8.v(r9)
        Lb:
            io.flutter.plugin.editing.e r9 = r8.f3098h
            int r9 = r9.i()
            io.flutter.plugin.editing.e r10 = r8.f3098h
            int r10 = r10.h()
            io.flutter.plugin.editing.e r11 = r8.f3098h
            int r11 = r11.g()
            io.flutter.plugin.editing.e r0 = r8.f3098h
            int r7 = r0.f()
            io.flutter.plugin.editing.e r0 = r8.f3098h
            java.util.ArrayList r0 = r0.e()
            t1.s$e r1 = r8.f3104n
            if (r1 == 0) goto L52
            io.flutter.plugin.editing.e r1 = r8.f3098h
            java.lang.String r1 = r1.toString()
            t1.s$e r2 = r8.f3104n
            java.lang.String r2 = r2.f4314a
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L50
            t1.s$e r1 = r8.f3104n
            int r2 = r1.f4315b
            if (r9 != r2) goto L50
            int r2 = r1.f4316c
            if (r10 != r2) goto L50
            int r2 = r1.f4317d
            if (r11 != r2) goto L50
            int r1 = r1.f4318e
            if (r7 != r1) goto L50
            goto L52
        L50:
            r1 = 0
            goto L53
        L52:
            r1 = 1
        L53:
            if (r1 != 0) goto Lac
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "send EditingState to flutter: "
            r1.append(r2)
            io.flutter.plugin.editing.e r2 = r8.f3098h
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "TextInputPlugin"
            g1.b.f(r2, r1)
            t1.s$b r1 = r8.f3096f
            boolean r1 = r1.f4293e
            if (r1 == 0) goto L86
            t1.s r1 = r8.f3094d
            io.flutter.plugin.editing.m$c r2 = r8.f3095e
            int r2 = r2.f3112b
            r1.q(r2, r0)
            io.flutter.plugin.editing.e r0 = r8.f3098h
            r0.c()
            goto L99
        L86:
            t1.s r0 = r8.f3094d
            io.flutter.plugin.editing.m$c r1 = r8.f3095e
            int r1 = r1.f3112b
            io.flutter.plugin.editing.e r2 = r8.f3098h
            java.lang.String r2 = r2.toString()
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r7
            r0.p(r1, r2, r3, r4, r5, r6)
        L99:
            t1.s$e r6 = new t1.s$e
            io.flutter.plugin.editing.e r0 = r8.f3098h
            java.lang.String r1 = r0.toString()
            r0 = r6
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r8.f3104n = r6
            goto Lb1
        Lac:
            io.flutter.plugin.editing.e r9 = r8.f3098h
            r9.c()
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.m.a(boolean, boolean, boolean):void");
    }

    public void j(SparseArray<AutofillValue> sparseArray) {
        s.b bVar;
        s.b.a aVar;
        s.b.a aVar2;
        if (Build.VERSION.SDK_INT < 26 || (bVar = this.f3096f) == null || this.f3097g == null || (aVar = bVar.f4298j) == null) {
            return;
        }
        HashMap<String, s.e> hashMap = new HashMap<>();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            s.b bVar2 = this.f3097g.get(sparseArray.keyAt(i3));
            if (bVar2 != null && (aVar2 = bVar2.f4298j) != null) {
                String charSequence = sparseArray.valueAt(i3).getTextValue().toString();
                s.e eVar = new s.e(charSequence, charSequence.length(), charSequence.length(), -1, -1);
                if (aVar2.f4301a.equals(aVar.f4301a)) {
                    this.f3098h.n(eVar);
                } else {
                    hashMap.put(aVar2.f4301a, eVar);
                }
            }
        }
        this.f3094d.r(this.f3095e.f3112b, hashMap);
    }

    public void k(int i3) {
        c cVar = this.f3095e;
        c.a aVar = cVar.f3111a;
        if ((aVar == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW || aVar == c.a.PHYSICAL_DISPLAY_PLATFORM_VIEW) && cVar.f3112b == i3) {
            this.f3095e = new c(c.a.NO_TARGET, 0);
            x();
            this.f3092b.hideSoftInputFromWindow(this.f3091a.getApplicationWindowToken(), 0);
            this.f3092b.restartInput(this.f3091a);
            this.f3099i = false;
        }
    }

    void l() {
        if (this.f3095e.f3111a == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            return;
        }
        this.f3098h.l(this);
        x();
        this.f3096f = null;
        G(null);
        this.f3095e = new c(c.a.NO_TARGET, 0);
        F();
        this.f3102l = null;
        this.f3092b.restartInput(this.f3091a);
    }

    public InputConnection n(View view, d0 d0Var, EditorInfo editorInfo) {
        c cVar = this.f3095e;
        c.a aVar = cVar.f3111a;
        if (aVar == c.a.NO_TARGET) {
            this.f3100j = null;
            return null;
        }
        if (aVar == c.a.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
            return null;
        }
        if (aVar == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            if (this.f3105o) {
                return this.f3100j;
            }
            InputConnection onCreateInputConnection = this.f3101k.b(cVar.f3112b).onCreateInputConnection(editorInfo);
            this.f3100j = onCreateInputConnection;
            return onCreateInputConnection;
        }
        s.b bVar = this.f3096f;
        int s3 = s(bVar.f4295g, bVar.f4289a, bVar.f4290b, bVar.f4291c, bVar.f4292d, bVar.f4294f);
        editorInfo.inputType = s3;
        editorInfo.imeOptions = 33554432;
        if (Build.VERSION.SDK_INT >= 26 && !this.f3096f.f4292d) {
            editorInfo.imeOptions = 33554432 | 16777216;
        }
        Integer num = this.f3096f.f4296h;
        int intValue = num == null ? (s3 & 131072) != 0 ? 1 : 6 : num.intValue();
        s.b bVar2 = this.f3096f;
        String str = bVar2.f4297i;
        if (str != null) {
            editorInfo.actionLabel = str;
            editorInfo.actionId = intValue;
        }
        editorInfo.imeOptions = intValue | editorInfo.imeOptions;
        String[] strArr = bVar2.f4299k;
        if (strArr != null) {
            k.a.a(editorInfo, strArr);
        }
        io.flutter.plugin.editing.d dVar = new io.flutter.plugin.editing.d(view, this.f3095e.f3112b, this.f3094d, d0Var, this.f3098h, editorInfo);
        editorInfo.initialSelStart = this.f3098h.i();
        editorInfo.initialSelEnd = this.f3098h.h();
        this.f3100j = dVar;
        return dVar;
    }

    public void o() {
        this.f3101k.Q();
        this.f3094d.n(null);
        x();
        this.f3098h.l(this);
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.f3103m;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    public InputMethodManager p() {
        return this.f3092b;
    }

    public boolean q(KeyEvent keyEvent) {
        InputConnection inputConnection;
        if (!p().isAcceptingText() || (inputConnection = this.f3100j) == null) {
            return false;
        }
        return inputConnection instanceof io.flutter.plugin.editing.d ? ((io.flutter.plugin.editing.d) inputConnection).f(keyEvent) : inputConnection.sendKeyEvent(keyEvent);
    }

    public void t() {
        if (this.f3095e.f3111a == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.f3105o = true;
        }
    }

    public void y(ViewStructure viewStructure, int i3) {
        AutofillId autofillId;
        Rect rect;
        if (Build.VERSION.SDK_INT < 26 || !u()) {
            return;
        }
        String str = this.f3096f.f4298j.f4301a;
        autofillId = viewStructure.getAutofillId();
        for (int i4 = 0; i4 < this.f3097g.size(); i4++) {
            int keyAt = this.f3097g.keyAt(i4);
            s.b.a aVar = this.f3097g.valueAt(i4).f4298j;
            if (aVar != null) {
                viewStructure.addChildCount(1);
                ViewStructure newChild = viewStructure.newChild(i4);
                newChild.setAutofillId(autofillId, keyAt);
                String[] strArr = aVar.f4302b;
                if (strArr.length > 0) {
                    newChild.setAutofillHints(strArr);
                }
                newChild.setAutofillType(1);
                newChild.setVisibility(0);
                String str2 = aVar.f4304d;
                if (str2 != null) {
                    newChild.setHint(str2);
                }
                if (str.hashCode() != keyAt || (rect = this.f3102l) == null) {
                    newChild.setDimens(0, 0, 0, 0, 1, 1);
                    newChild.setAutofillValue(AutofillValue.forText(aVar.f4303c.f4314a));
                } else {
                    newChild.setDimens(rect.left, rect.top, 0, 0, rect.width(), this.f3102l.height());
                    newChild.setAutofillValue(AutofillValue.forText(this.f3098h));
                }
            }
        }
    }
}
