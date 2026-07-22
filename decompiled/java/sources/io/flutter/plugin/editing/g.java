package io.flutter.plugin.editing;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /root/release/classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private CharSequence f3083a;

    /* renamed from: b, reason: collision with root package name */
    private CharSequence f3084b;

    /* renamed from: c, reason: collision with root package name */
    private int f3085c;

    /* renamed from: d, reason: collision with root package name */
    private int f3086d;

    /* renamed from: e, reason: collision with root package name */
    private int f3087e;

    /* renamed from: f, reason: collision with root package name */
    private int f3088f;

    /* renamed from: g, reason: collision with root package name */
    private int f3089g;

    /* renamed from: h, reason: collision with root package name */
    private int f3090h;

    public g(CharSequence charSequence, int i3, int i4, int i5, int i6) {
        this.f3087e = i3;
        this.f3088f = i4;
        this.f3089g = i5;
        this.f3090h = i6;
        a(charSequence, "", -1, -1);
    }

    public g(CharSequence charSequence, int i3, int i4, CharSequence charSequence2, int i5, int i6, int i7, int i8) {
        this.f3087e = i5;
        this.f3088f = i6;
        this.f3089g = i7;
        this.f3090h = i8;
        a(charSequence, charSequence2.toString(), i3, i4);
    }

    private void a(CharSequence charSequence, CharSequence charSequence2, int i3, int i4) {
        this.f3083a = charSequence;
        this.f3084b = charSequence2;
        this.f3085c = i3;
        this.f3086d = i4;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oldText", this.f3083a.toString());
            jSONObject.put("deltaText", this.f3084b.toString());
            jSONObject.put("deltaStart", this.f3085c);
            jSONObject.put("deltaEnd", this.f3086d);
            jSONObject.put("selectionBase", this.f3087e);
            jSONObject.put("selectionExtent", this.f3088f);
            jSONObject.put("composingBase", this.f3089g);
            jSONObject.put("composingExtent", this.f3090h);
        } catch (JSONException e3) {
            g1.b.b("TextEditingDelta", "unable to create JSONObject: " + e3);
        }
        return jSONObject;
    }
}
