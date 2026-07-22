package io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import java.util.ArrayList;
import java.util.Iterator;
import t1.s;

/* loaded from: /root/release/classes.dex */
class e extends SpannableStringBuilder {

    /* renamed from: c, reason: collision with root package name */
    private int f3065c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f3066d = 0;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<b> f3067f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<b> f3068g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<g> f3069h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private String f3070i;

    /* renamed from: j, reason: collision with root package name */
    private String f3071j;

    /* renamed from: k, reason: collision with root package name */
    private int f3072k;

    /* renamed from: l, reason: collision with root package name */
    private int f3073l;

    /* renamed from: m, reason: collision with root package name */
    private int f3074m;

    /* renamed from: n, reason: collision with root package name */
    private int f3075n;

    /* renamed from: o, reason: collision with root package name */
    private BaseInputConnection f3076o;

    class a extends BaseInputConnection {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Editable f3077a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, boolean z3, Editable editable) {
            super(view, z3);
            this.f3077a = editable;
        }

        @Override // android.view.inputmethod.BaseInputConnection
        public Editable getEditable() {
            return this.f3077a;
        }
    }

    interface b {
        void a(boolean z3, boolean z4, boolean z5);
    }

    public e(s.e eVar, View view) {
        this.f3076o = new a(view, true, this);
        if (eVar != null) {
            n(eVar);
        }
    }

    private void j(b bVar, boolean z3, boolean z4, boolean z5) {
        this.f3066d++;
        bVar.a(z3, z4, z5);
        this.f3066d--;
    }

    private void k(boolean z3, boolean z4, boolean z5) {
        if (z3 || z4 || z5) {
            Iterator<b> it = this.f3067f.iterator();
            while (it.hasNext()) {
                j(it.next(), z3, z4, z5);
            }
        }
    }

    public void a(b bVar) {
        ArrayList<b> arrayList;
        if (this.f3066d > 0) {
            g1.b.b("ListenableEditingState", "adding a listener " + bVar.toString() + " in a listener callback");
        }
        if (this.f3065c > 0) {
            g1.b.g("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
            arrayList = this.f3068g;
        } else {
            arrayList = this.f3067f;
        }
        arrayList.add(bVar);
    }

    public void b() {
        this.f3065c++;
        if (this.f3066d > 0) {
            g1.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        if (this.f3065c != 1 || this.f3067f.isEmpty()) {
            return;
        }
        this.f3071j = toString();
        this.f3072k = i();
        this.f3073l = h();
        this.f3074m = g();
        this.f3075n = f();
    }

    public void c() {
        this.f3069h.clear();
    }

    public void d() {
        int i3 = this.f3065c;
        if (i3 == 0) {
            g1.b.b("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        if (i3 == 1) {
            Iterator<b> it = this.f3068g.iterator();
            while (it.hasNext()) {
                j(it.next(), true, true, true);
            }
            if (!this.f3067f.isEmpty()) {
                g1.b.f("ListenableEditingState", "didFinishBatchEdit with " + String.valueOf(this.f3067f.size()) + " listener(s)");
                k(!toString().equals(this.f3071j), (this.f3072k == i() && this.f3073l == h()) ? false : true, (this.f3074m == g() && this.f3075n == f()) ? false : true);
            }
        }
        this.f3067f.addAll(this.f3068g);
        this.f3068g.clear();
        this.f3065c--;
    }

    public ArrayList<g> e() {
        ArrayList<g> arrayList = new ArrayList<>(this.f3069h);
        this.f3069h.clear();
        return arrayList;
    }

    public final int f() {
        return BaseInputConnection.getComposingSpanEnd(this);
    }

    public final int g() {
        return BaseInputConnection.getComposingSpanStart(this);
    }

    public final int h() {
        return Selection.getSelectionEnd(this);
    }

    public final int i() {
        return Selection.getSelectionStart(this);
    }

    public void l(b bVar) {
        if (this.f3066d > 0) {
            g1.b.b("ListenableEditingState", "removing a listener " + bVar.toString() + " in a listener callback");
        }
        this.f3067f.remove(bVar);
        if (this.f3065c > 0) {
            this.f3068g.remove(bVar);
        }
    }

    public void m(int i3, int i4) {
        if (i3 < 0 || i3 >= i4) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.f3076o.setComposingRegion(i3, i4);
        }
    }

    public void n(s.e eVar) {
        b();
        replace(0, length(), (CharSequence) eVar.f4314a);
        if (eVar.c()) {
            Selection.setSelection(this, eVar.f4315b, eVar.f4316c);
        } else {
            Selection.removeSelection(this);
        }
        m(eVar.f4317d, eVar.f4318e);
        c();
        d();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i3, int i4, CharSequence charSequence, int i5, int i6) {
        boolean z3;
        boolean z4;
        if (this.f3066d > 0) {
            g1.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        String eVar = toString();
        int i7 = i4 - i3;
        boolean z5 = i7 != i6 - i5;
        for (int i8 = 0; i8 < i7 && !z5; i8++) {
            z5 |= charAt(i3 + i8) != charSequence.charAt(i5 + i8);
        }
        if (z5) {
            this.f3070i = null;
        }
        int i9 = i();
        int h3 = h();
        int g3 = g();
        int f3 = f();
        SpannableStringBuilder replace = super.replace(i3, i4, charSequence, i5, i6);
        boolean z6 = z5;
        this.f3069h.add(new g(eVar, i3, i4, charSequence, i(), h(), g(), f()));
        if (this.f3065c > 0) {
            return replace;
        }
        boolean z7 = (i() == i9 && h() == h3) ? false : true;
        if (g() == g3 && f() == f3) {
            z3 = z6;
            z4 = false;
        } else {
            z3 = z6;
            z4 = true;
        }
        k(z3, z7, z4);
        return replace;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i3, int i4, int i5) {
        super.setSpan(obj, i3, i4, i5);
        this.f3069h.add(new g(toString(), i(), h(), g(), f()));
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public String toString() {
        String str = this.f3070i;
        if (str != null) {
            return str;
        }
        String spannableStringBuilder = super.toString();
        this.f3070i = spannableStringBuilder;
        return spannableStringBuilder;
    }
}
