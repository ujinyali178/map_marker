package io.flutter.embedding.android;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import io.flutter.embedding.android.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public class j extends Fragment implements f.d, ComponentCallbacks2, f.c {

    /* renamed from: h, reason: collision with root package name */
    public static final int f2789h = View.generateViewId();

    /* renamed from: d, reason: collision with root package name */
    f f2791d;

    /* renamed from: c, reason: collision with root package name */
    private final ViewTreeObserver.OnWindowFocusChangeListener f2790c = new a();

    /* renamed from: f, reason: collision with root package name */
    private f.c f2792f = this;

    /* renamed from: g, reason: collision with root package name */
    private final androidx.activity.l f2793g = new b(true);

    class a implements ViewTreeObserver.OnWindowFocusChangeListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z3) {
            if (j.this.J("onWindowFocusChanged")) {
                j.this.f2791d.I(z3);
            }
        }
    }

    class b extends androidx.activity.l {
        b(boolean z3) {
            super(z3);
        }

        @Override // androidx.activity.l
        public void b() {
            j.this.H();
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final Class<? extends j> f2796a;

        /* renamed from: b, reason: collision with root package name */
        private final String f2797b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f2798c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f2799d;

        /* renamed from: e, reason: collision with root package name */
        private g0 f2800e;

        /* renamed from: f, reason: collision with root package name */
        private h0 f2801f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f2802g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f2803h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f2804i;

        public c(Class<? extends j> cls, String str) {
            this.f2798c = false;
            this.f2799d = false;
            this.f2800e = g0.surface;
            this.f2801f = h0.transparent;
            this.f2802g = true;
            this.f2803h = false;
            this.f2804i = false;
            this.f2796a = cls;
            this.f2797b = str;
        }

        private c(String str) {
            this((Class<? extends j>) j.class, str);
        }

        /* synthetic */ c(String str, a aVar) {
            this(str);
        }

        public <T extends j> T a() {
            try {
                T t3 = (T) this.f2796a.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (t3 != null) {
                    t3.setArguments(b());
                    return t3;
                }
                throw new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.f2796a.getCanonicalName() + ") does not match the expected return type.");
            } catch (Exception e3) {
                throw new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.f2796a.getName() + ")", e3);
            }
        }

        protected Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putString("cached_engine_id", this.f2797b);
            bundle.putBoolean("destroy_engine_with_fragment", this.f2798c);
            bundle.putBoolean("handle_deeplinking", this.f2799d);
            g0 g0Var = this.f2800e;
            if (g0Var == null) {
                g0Var = g0.surface;
            }
            bundle.putString("flutterview_render_mode", g0Var.name());
            h0 h0Var = this.f2801f;
            if (h0Var == null) {
                h0Var = h0.transparent;
            }
            bundle.putString("flutterview_transparency_mode", h0Var.name());
            bundle.putBoolean("should_attach_engine_to_activity", this.f2802g);
            bundle.putBoolean("should_automatically_handle_on_back_pressed", this.f2803h);
            bundle.putBoolean("should_delay_first_android_view_draw", this.f2804i);
            return bundle;
        }

        public c c(boolean z3) {
            this.f2798c = z3;
            return this;
        }

        public c d(Boolean bool) {
            this.f2799d = bool.booleanValue();
            return this;
        }

        public c e(g0 g0Var) {
            this.f2800e = g0Var;
            return this;
        }

        public c f(boolean z3) {
            this.f2802g = z3;
            return this;
        }

        public c g(boolean z3) {
            this.f2804i = z3;
            return this;
        }

        public c h(h0 h0Var) {
            this.f2801f = h0Var;
            return this;
        }
    }

    public static class d {

        /* renamed from: d, reason: collision with root package name */
        private List<String> f2808d;

        /* renamed from: b, reason: collision with root package name */
        private String f2806b = "main";

        /* renamed from: c, reason: collision with root package name */
        private String f2807c = null;

        /* renamed from: e, reason: collision with root package name */
        private String f2809e = "/";

        /* renamed from: f, reason: collision with root package name */
        private boolean f2810f = false;

        /* renamed from: g, reason: collision with root package name */
        private String f2811g = null;

        /* renamed from: h, reason: collision with root package name */
        private io.flutter.embedding.engine.g f2812h = null;

        /* renamed from: i, reason: collision with root package name */
        private g0 f2813i = g0.surface;

        /* renamed from: j, reason: collision with root package name */
        private h0 f2814j = h0.transparent;

        /* renamed from: k, reason: collision with root package name */
        private boolean f2815k = true;

        /* renamed from: l, reason: collision with root package name */
        private boolean f2816l = false;

        /* renamed from: m, reason: collision with root package name */
        private boolean f2817m = false;

        /* renamed from: a, reason: collision with root package name */
        private final Class<? extends j> f2805a = j.class;

        public d a(String str) {
            this.f2811g = str;
            return this;
        }

        public <T extends j> T b() {
            try {
                T t3 = (T) this.f2805a.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (t3 != null) {
                    t3.setArguments(c());
                    return t3;
                }
                throw new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.f2805a.getCanonicalName() + ") does not match the expected return type.");
            } catch (Exception e3) {
                throw new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.f2805a.getName() + ")", e3);
            }
        }

        protected Bundle c() {
            Bundle bundle = new Bundle();
            bundle.putString("initial_route", this.f2809e);
            bundle.putBoolean("handle_deeplinking", this.f2810f);
            bundle.putString("app_bundle_path", this.f2811g);
            bundle.putString("dart_entrypoint", this.f2806b);
            bundle.putString("dart_entrypoint_uri", this.f2807c);
            bundle.putStringArrayList("dart_entrypoint_args", this.f2808d != null ? new ArrayList<>(this.f2808d) : null);
            io.flutter.embedding.engine.g gVar = this.f2812h;
            if (gVar != null) {
                bundle.putStringArray("initialization_args", gVar.b());
            }
            g0 g0Var = this.f2813i;
            if (g0Var == null) {
                g0Var = g0.surface;
            }
            bundle.putString("flutterview_render_mode", g0Var.name());
            h0 h0Var = this.f2814j;
            if (h0Var == null) {
                h0Var = h0.transparent;
            }
            bundle.putString("flutterview_transparency_mode", h0Var.name());
            bundle.putBoolean("should_attach_engine_to_activity", this.f2815k);
            bundle.putBoolean("destroy_engine_with_fragment", true);
            bundle.putBoolean("should_automatically_handle_on_back_pressed", this.f2816l);
            bundle.putBoolean("should_delay_first_android_view_draw", this.f2817m);
            return bundle;
        }

        public d d(String str) {
            this.f2806b = str;
            return this;
        }

        public d e(List<String> list) {
            this.f2808d = list;
            return this;
        }

        public d f(String str) {
            this.f2807c = str;
            return this;
        }

        public d g(io.flutter.embedding.engine.g gVar) {
            this.f2812h = gVar;
            return this;
        }

        public d h(Boolean bool) {
            this.f2810f = bool.booleanValue();
            return this;
        }

        public d i(String str) {
            this.f2809e = str;
            return this;
        }

        public d j(g0 g0Var) {
            this.f2813i = g0Var;
            return this;
        }

        public d k(boolean z3) {
            this.f2815k = z3;
            return this;
        }

        public d l(boolean z3) {
            this.f2817m = z3;
            return this;
        }

        public d m(h0 h0Var) {
            this.f2814j = h0Var;
            return this;
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private final Class<? extends j> f2818a;

        /* renamed from: b, reason: collision with root package name */
        private final String f2819b;

        /* renamed from: c, reason: collision with root package name */
        private String f2820c;

        /* renamed from: d, reason: collision with root package name */
        private String f2821d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f2822e;

        /* renamed from: f, reason: collision with root package name */
        private g0 f2823f;

        /* renamed from: g, reason: collision with root package name */
        private h0 f2824g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f2825h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f2826i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f2827j;

        public e(Class<? extends j> cls, String str) {
            this.f2820c = "main";
            this.f2821d = "/";
            this.f2822e = false;
            this.f2823f = g0.surface;
            this.f2824g = h0.transparent;
            this.f2825h = true;
            this.f2826i = false;
            this.f2827j = false;
            this.f2818a = cls;
            this.f2819b = str;
        }

        public e(String str) {
            this(j.class, str);
        }

        public <T extends j> T a() {
            try {
                T t3 = (T) this.f2818a.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (t3 != null) {
                    t3.setArguments(b());
                    return t3;
                }
                throw new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.f2818a.getCanonicalName() + ") does not match the expected return type.");
            } catch (Exception e3) {
                throw new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.f2818a.getName() + ")", e3);
            }
        }

        protected Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putString("cached_engine_group_id", this.f2819b);
            bundle.putString("dart_entrypoint", this.f2820c);
            bundle.putString("initial_route", this.f2821d);
            bundle.putBoolean("handle_deeplinking", this.f2822e);
            g0 g0Var = this.f2823f;
            if (g0Var == null) {
                g0Var = g0.surface;
            }
            bundle.putString("flutterview_render_mode", g0Var.name());
            h0 h0Var = this.f2824g;
            if (h0Var == null) {
                h0Var = h0.transparent;
            }
            bundle.putString("flutterview_transparency_mode", h0Var.name());
            bundle.putBoolean("should_attach_engine_to_activity", this.f2825h);
            bundle.putBoolean("destroy_engine_with_fragment", true);
            bundle.putBoolean("should_automatically_handle_on_back_pressed", this.f2826i);
            bundle.putBoolean("should_delay_first_android_view_draw", this.f2827j);
            return bundle;
        }

        public e c(String str) {
            this.f2820c = str;
            return this;
        }

        public e d(boolean z3) {
            this.f2822e = z3;
            return this;
        }

        public e e(String str) {
            this.f2821d = str;
            return this;
        }

        public e f(g0 g0Var) {
            this.f2823f = g0Var;
            return this;
        }

        public e g(boolean z3) {
            this.f2825h = z3;
            return this;
        }

        public e h(boolean z3) {
            this.f2827j = z3;
            return this;
        }

        public e i(h0 h0Var) {
            this.f2824g = h0Var;
            return this;
        }
    }

    public j() {
        setArguments(new Bundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J(String str) {
        StringBuilder sb;
        String str2;
        f fVar = this.f2791d;
        if (fVar == null) {
            sb = new StringBuilder();
            sb.append("FlutterFragment ");
            sb.append(hashCode());
            sb.append(" ");
            sb.append(str);
            str2 = " called after release.";
        } else {
            if (fVar.o()) {
                return true;
            }
            sb = new StringBuilder();
            sb.append("FlutterFragment ");
            sb.append(hashCode());
            sb.append(" ");
            sb.append(str);
            str2 = " called after detach.";
        }
        sb.append(str2);
        g1.b.g("FlutterFragment", sb.toString());
        return false;
    }

    public static c K(String str) {
        return new c(str, (a) null);
    }

    public static d L() {
        return new d();
    }

    public static e M(String str) {
        return new e(str);
    }

    @Override // io.flutter.embedding.android.f.d
    public io.flutter.embedding.engine.g A() {
        String[] stringArray = getArguments().getStringArray("initialization_args");
        if (stringArray == null) {
            stringArray = new String[0];
        }
        return new io.flutter.embedding.engine.g(stringArray);
    }

    @Override // io.flutter.embedding.android.f.d
    public g0 B() {
        return g0.valueOf(getArguments().getString("flutterview_render_mode", g0.surface.name()));
    }

    @Override // io.flutter.embedding.android.f.d
    public h0 D() {
        return h0.valueOf(getArguments().getString("flutterview_transparency_mode", h0.transparent.name()));
    }

    public io.flutter.embedding.engine.a F() {
        return this.f2791d.n();
    }

    boolean G() {
        return this.f2791d.p();
    }

    public void H() {
        if (J("onBackPressed")) {
            this.f2791d.t();
        }
    }

    boolean I() {
        return getArguments().getBoolean("should_delay_first_android_view_draw");
    }

    @Override // io.flutter.plugin.platform.g.d
    public boolean a() {
        FragmentActivity activity;
        if (!getArguments().getBoolean("should_automatically_handle_on_back_pressed", false) || (activity = getActivity()) == null) {
            return false;
        }
        this.f2793g.f(false);
        activity.getOnBackPressedDispatcher().e();
        this.f2793g.f(true);
        return true;
    }

    @Override // io.flutter.embedding.android.f.d
    public void b() {
        androidx.core.content.l activity = getActivity();
        if (activity instanceof io.flutter.embedding.engine.renderer.d) {
            ((io.flutter.embedding.engine.renderer.d) activity).b();
        }
    }

    @Override // io.flutter.embedding.android.f.d
    public void c() {
        g1.b.g("FlutterFragment", "FlutterFragment " + this + " connection to the engine " + F() + " evicted by another attaching activity");
        f fVar = this.f2791d;
        if (fVar != null) {
            fVar.v();
            this.f2791d.w();
        }
    }

    @Override // io.flutter.embedding.android.f.d, io.flutter.embedding.android.i
    public io.flutter.embedding.engine.a d(Context context) {
        androidx.core.content.l activity = getActivity();
        if (!(activity instanceof i)) {
            return null;
        }
        g1.b.f("FlutterFragment", "Deferring to attached Activity to provide a FlutterEngine.");
        return ((i) activity).d(getContext());
    }

    @Override // io.flutter.embedding.android.f.d
    public void e() {
        androidx.core.content.l activity = getActivity();
        if (activity instanceof io.flutter.embedding.engine.renderer.d) {
            ((io.flutter.embedding.engine.renderer.d) activity).e();
        }
    }

    @Override // io.flutter.plugin.platform.g.d
    public /* synthetic */ void f(boolean z3) {
        io.flutter.plugin.platform.i.a(this, z3);
    }

    @Override // io.flutter.embedding.android.f.d, io.flutter.embedding.android.h
    public void g(io.flutter.embedding.engine.a aVar) {
        androidx.core.content.l activity = getActivity();
        if (activity instanceof h) {
            ((h) activity).g(aVar);
        }
    }

    @Override // io.flutter.embedding.android.f.d, io.flutter.embedding.android.h
    public void h(io.flutter.embedding.engine.a aVar) {
        androidx.core.content.l activity = getActivity();
        if (activity instanceof h) {
            ((h) activity).h(aVar);
        }
    }

    @Override // io.flutter.embedding.android.f.d
    public /* bridge */ /* synthetic */ Activity i() {
        return super.getActivity();
    }

    @Override // io.flutter.embedding.android.f.d
    public List<String> j() {
        return getArguments().getStringArrayList("dart_entrypoint_args");
    }

    @Override // io.flutter.embedding.android.f.d
    public String k() {
        return getArguments().getString("cached_engine_id", null);
    }

    @Override // io.flutter.embedding.android.f.d
    public boolean l() {
        return getArguments().containsKey("enable_state_restoration") ? getArguments().getBoolean("enable_state_restoration") : k() == null;
    }

    @Override // io.flutter.embedding.android.f.d
    public String m() {
        return getArguments().getString("dart_entrypoint", "main");
    }

    @Override // io.flutter.embedding.android.f.d
    public io.flutter.plugin.platform.g n(Activity activity, io.flutter.embedding.engine.a aVar) {
        if (activity != null) {
            return new io.flutter.plugin.platform.g(getActivity(), aVar.p(), this);
        }
        return null;
    }

    @Override // io.flutter.embedding.android.f.d
    public boolean o() {
        return getArguments().getBoolean("handle_deeplinking");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        if (J("onActivityResult")) {
            this.f2791d.r(i3, i4, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        f z3 = this.f2792f.z(this);
        this.f2791d = z3;
        z3.s(context);
        if (getArguments().getBoolean("should_automatically_handle_on_back_pressed", false)) {
            requireActivity().getOnBackPressedDispatcher().b(this, this.f2793g);
        }
        context.registerComponentCallbacks(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2791d.B(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f2791d.u(layoutInflater, viewGroup, bundle, f2789h, I());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        requireView().getViewTreeObserver().removeOnWindowFocusChangeListener(this.f2790c);
        if (J("onDestroyView")) {
            this.f2791d.v();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        getContext().unregisterComponentCallbacks(this);
        super.onDetach();
        f fVar = this.f2791d;
        if (fVar != null) {
            fVar.w();
            this.f2791d.J();
            this.f2791d = null;
        } else {
            g1.b.f("FlutterFragment", "FlutterFragment " + this + " onDetach called after release.");
        }
    }

    public void onNewIntent(Intent intent) {
        if (J("onNewIntent")) {
            this.f2791d.x(intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (J("onPause")) {
            this.f2791d.y();
        }
    }

    public void onPostResume() {
        if (J("onPostResume")) {
            this.f2791d.z();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        if (J("onRequestPermissionsResult")) {
            this.f2791d.A(i3, strArr, iArr);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (J("onResume")) {
            this.f2791d.C();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (J("onSaveInstanceState")) {
            this.f2791d.D(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (J("onStart")) {
            this.f2791d.E();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (J("onStop")) {
            this.f2791d.F();
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        if (J("onTrimMemory")) {
            this.f2791d.G(i3);
        }
    }

    public void onUserLeaveHint() {
        if (J("onUserLeaveHint")) {
            this.f2791d.H();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.getViewTreeObserver().addOnWindowFocusChangeListener(this.f2790c);
    }

    @Override // io.flutter.embedding.android.f.d
    public boolean p() {
        return true;
    }

    @Override // io.flutter.embedding.android.f.d
    public void q(p pVar) {
    }

    @Override // io.flutter.embedding.android.f.d
    public String r() {
        return getArguments().getString("cached_engine_group_id", null);
    }

    @Override // io.flutter.embedding.android.f.d
    public String s() {
        return getArguments().getString("initial_route");
    }

    @Override // io.flutter.embedding.android.f.d
    public boolean t() {
        return getArguments().getBoolean("should_attach_engine_to_activity");
    }

    @Override // io.flutter.embedding.android.f.d
    public boolean u() {
        boolean z3 = getArguments().getBoolean("destroy_engine_with_fragment", false);
        return (k() != null || this.f2791d.p()) ? z3 : getArguments().getBoolean("destroy_engine_with_fragment", true);
    }

    @Override // io.flutter.embedding.android.f.d
    public boolean v() {
        return true;
    }

    @Override // io.flutter.embedding.android.f.d
    public String w() {
        return getArguments().getString("dart_entrypoint_uri");
    }

    @Override // io.flutter.embedding.android.f.d
    public void x(o oVar) {
    }

    @Override // io.flutter.embedding.android.f.d
    public String y() {
        return getArguments().getString("app_bundle_path");
    }

    @Override // io.flutter.embedding.android.f.c
    public f z(f.d dVar) {
        return new f(dVar);
    }
}
