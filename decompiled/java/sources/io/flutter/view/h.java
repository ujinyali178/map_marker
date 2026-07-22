package io.flutter.view;

import android.R;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import io.flutter.view.h;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import t1.a;

/* loaded from: /root/release/classes.dex */
public class h extends AccessibilityNodeProvider {

    /* renamed from: a, reason: collision with root package name */
    private final View f3477a;

    /* renamed from: b, reason: collision with root package name */
    private final t1.a f3478b;

    /* renamed from: c, reason: collision with root package name */
    private final AccessibilityManager f3479c;

    /* renamed from: d, reason: collision with root package name */
    private final AccessibilityViewEmbedder f3480d;

    /* renamed from: e, reason: collision with root package name */
    private final io.flutter.plugin.platform.s f3481e;

    /* renamed from: f, reason: collision with root package name */
    private final ContentResolver f3482f;

    /* renamed from: g, reason: collision with root package name */
    private final Map<Integer, l> f3483g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<Integer, C0089h> f3484h;

    /* renamed from: i, reason: collision with root package name */
    private l f3485i;

    /* renamed from: j, reason: collision with root package name */
    private Integer f3486j;

    /* renamed from: k, reason: collision with root package name */
    private Integer f3487k;

    /* renamed from: l, reason: collision with root package name */
    private int f3488l;

    /* renamed from: m, reason: collision with root package name */
    private l f3489m;

    /* renamed from: n, reason: collision with root package name */
    private l f3490n;

    /* renamed from: o, reason: collision with root package name */
    private l f3491o;

    /* renamed from: p, reason: collision with root package name */
    private final List<Integer> f3492p;

    /* renamed from: q, reason: collision with root package name */
    private int f3493q;

    /* renamed from: r, reason: collision with root package name */
    private Integer f3494r;

    /* renamed from: s, reason: collision with root package name */
    private k f3495s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f3496t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f3497u;

    /* renamed from: v, reason: collision with root package name */
    private final a.b f3498v;

    /* renamed from: w, reason: collision with root package name */
    private final AccessibilityManager.AccessibilityStateChangeListener f3499w;

    /* renamed from: x, reason: collision with root package name */
    private final AccessibilityManager.TouchExplorationStateChangeListener f3500x;

    /* renamed from: y, reason: collision with root package name */
    private final ContentObserver f3501y;

    /* renamed from: z, reason: collision with root package name */
    private static final int f3476z = ((g.SCROLL_RIGHT.f3539c | g.SCROLL_LEFT.f3539c) | g.SCROLL_UP.f3539c) | g.SCROLL_DOWN.f3539c;
    private static final int A = ((((((((((i.HAS_CHECKED_STATE.f3567c | i.IS_CHECKED.f3567c) | i.IS_SELECTED.f3567c) | i.IS_TEXT_FIELD.f3567c) | i.IS_FOCUSED.f3567c) | i.HAS_ENABLED_STATE.f3567c) | i.IS_ENABLED.f3567c) | i.IS_IN_MUTUALLY_EXCLUSIVE_GROUP.f3567c) | i.HAS_TOGGLED_STATE.f3567c) | i.IS_TOGGLED.f3567c) | i.IS_FOCUSABLE.f3567c) | i.IS_SLIDER.f3567c;
    private static int B = 267386881;
    static int C = (g.DID_GAIN_ACCESSIBILITY_FOCUS.f3539c & g.DID_LOSE_ACCESSIBILITY_FOCUS.f3539c) & g.SHOW_ON_SCREEN.f3539c;

    class a implements a.b {
        a() {
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.a
        public void a(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            for (ByteBuffer byteBuffer2 : byteBufferArr) {
                byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
            }
            h.this.e0(byteBuffer, strArr, byteBufferArr);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.a
        public void b(ByteBuffer byteBuffer, String[] strArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            h.this.d0(byteBuffer, strArr);
        }

        @Override // t1.a.b
        public void c(int i3) {
            h.this.U(i3, 1);
        }

        @Override // t1.a.b
        public void d(String str) {
            h.this.f3477a.announceForAccessibility(str);
        }

        @Override // t1.a.b
        public void e(String str) {
            if (Build.VERSION.SDK_INT >= 28) {
                return;
            }
            AccessibilityEvent I = h.this.I(0, 32);
            I.getText().add(str);
            h.this.V(I);
        }

        @Override // t1.a.b
        public void f(int i3) {
            h.this.U(i3, 8);
        }

        @Override // t1.a.b
        public void g(int i3) {
            h.this.U(i3, 2);
        }
    }

    class b implements AccessibilityManager.AccessibilityStateChangeListener {
        b() {
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z3) {
            if (h.this.f3497u) {
                return;
            }
            h hVar = h.this;
            if (z3) {
                hVar.f3478b.g(h.this.f3498v);
                h.this.f3478b.e();
            } else {
                hVar.Z(false);
                h.this.f3478b.g(null);
                h.this.f3478b.d();
            }
            if (h.this.f3495s != null) {
                h.this.f3495s.a(z3, h.this.f3479c.isTouchExplorationEnabled());
            }
        }
    }

    class c extends ContentObserver {
        c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3) {
            onChange(z3, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3, Uri uri) {
            if (h.this.f3497u) {
                return;
            }
            String string = Settings.Global.getString(h.this.f3482f, "transition_animation_scale");
            if (string != null && string.equals("0")) {
                h.f(h.this, f.DISABLE_ANIMATIONS.f3516c);
            } else {
                h.e(h.this, ~f.DISABLE_ANIMATIONS.f3516c);
            }
            h.this.W();
        }
    }

    class d implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccessibilityManager f3505a;

        d(AccessibilityManager accessibilityManager) {
            this.f3505a = accessibilityManager;
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z3) {
            if (h.this.f3497u) {
                return;
            }
            if (!z3) {
                h.this.Z(false);
                h.this.N();
            }
            if (h.this.f3495s != null) {
                h.this.f3495s.a(this.f3505a.isEnabled(), z3);
            }
        }
    }

    static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3507a;

        static {
            int[] iArr = new int[o.values().length];
            f3507a = iArr;
            try {
                iArr[o.SPELLOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3507a[o.LOCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum f {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4),
        BOLD_TEXT(8),
        REDUCE_MOTION(16),
        HIGH_CONTRAST(32),
        ON_OFF_SWITCH_LABELS(64);


        /* renamed from: c, reason: collision with root package name */
        final int f3516c;

        f(int i3) {
            this.f3516c = i3;
        }
    }

    public enum g {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(UserVerificationMethods.USER_VERIFY_HANDPRINT),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(UserVerificationMethods.USER_VERIFY_NONE),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(UserVerificationMethods.USER_VERIFY_ALL),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(8192),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(65536),
        CUSTOM_ACTION(131072),
        DISMISS(262144),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576),
        SET_TEXT(2097152);


        /* renamed from: c, reason: collision with root package name */
        public final int f3539c;

        g(int i3) {
            this.f3539c = i3;
        }
    }

    /* renamed from: io.flutter.view.h$h, reason: collision with other inner class name */
    private static class C0089h {

        /* renamed from: a, reason: collision with root package name */
        private int f3540a = -1;

        /* renamed from: b, reason: collision with root package name */
        private int f3541b = -1;

        /* renamed from: c, reason: collision with root package name */
        private int f3542c = -1;

        /* renamed from: d, reason: collision with root package name */
        private String f3543d;

        /* renamed from: e, reason: collision with root package name */
        private String f3544e;

        C0089h() {
        }
    }

    enum i {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(UserVerificationMethods.USER_VERIFY_HANDPRINT),
        IS_HEADER(UserVerificationMethods.USER_VERIFY_NONE),
        IS_OBSCURED(UserVerificationMethods.USER_VERIFY_ALL),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(8192),
        IS_IMAGE(16384),
        IS_LIVE_REGION(32768),
        HAS_TOGGLED_STATE(65536),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(262144),
        IS_MULTILINE(524288),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(2097152),
        IS_LINK(4194304),
        IS_SLIDER(8388608),
        IS_KEYBOARD_KEY(16777216),
        IS_CHECK_STATE_MIXED(33554432),
        HAS_EXPANDED_STATE(67108864),
        IS_EXPANDED(134217728);


        /* renamed from: c, reason: collision with root package name */
        final int f3567c;

        i(int i3) {
            this.f3567c = i3;
        }
    }

    private static class j extends n {

        /* renamed from: d, reason: collision with root package name */
        String f3568d;

        private j() {
            super(null);
        }

        /* synthetic */ j(a aVar) {
            this();
        }
    }

    public interface k {
        void a(boolean z3, boolean z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class l {
        private p B;
        private int D;
        private int E;
        private int F;
        private int G;
        private float H;
        private float I;
        private float J;
        private String K;
        private String L;
        private float M;
        private float N;
        private float O;
        private float P;
        private float[] Q;
        private l R;
        private List<C0089h> U;
        private C0089h V;
        private C0089h W;
        private float[] Y;

        /* renamed from: a, reason: collision with root package name */
        final h f3569a;

        /* renamed from: a0, reason: collision with root package name */
        private float[] f3570a0;

        /* renamed from: b0, reason: collision with root package name */
        private Rect f3572b0;

        /* renamed from: c, reason: collision with root package name */
        private int f3573c;

        /* renamed from: d, reason: collision with root package name */
        private int f3574d;

        /* renamed from: e, reason: collision with root package name */
        private int f3575e;

        /* renamed from: f, reason: collision with root package name */
        private int f3576f;

        /* renamed from: g, reason: collision with root package name */
        private int f3577g;

        /* renamed from: h, reason: collision with root package name */
        private int f3578h;

        /* renamed from: i, reason: collision with root package name */
        private int f3579i;

        /* renamed from: j, reason: collision with root package name */
        private int f3580j;

        /* renamed from: k, reason: collision with root package name */
        private int f3581k;

        /* renamed from: l, reason: collision with root package name */
        private float f3582l;

        /* renamed from: m, reason: collision with root package name */
        private float f3583m;

        /* renamed from: n, reason: collision with root package name */
        private float f3584n;

        /* renamed from: o, reason: collision with root package name */
        private String f3585o;

        /* renamed from: p, reason: collision with root package name */
        private String f3586p;

        /* renamed from: q, reason: collision with root package name */
        private List<n> f3587q;

        /* renamed from: r, reason: collision with root package name */
        private String f3588r;

        /* renamed from: s, reason: collision with root package name */
        private List<n> f3589s;

        /* renamed from: t, reason: collision with root package name */
        private String f3590t;

        /* renamed from: u, reason: collision with root package name */
        private List<n> f3591u;

        /* renamed from: v, reason: collision with root package name */
        private String f3592v;

        /* renamed from: w, reason: collision with root package name */
        private List<n> f3593w;

        /* renamed from: x, reason: collision with root package name */
        private String f3594x;

        /* renamed from: y, reason: collision with root package name */
        private List<n> f3595y;

        /* renamed from: z, reason: collision with root package name */
        private String f3596z;

        /* renamed from: b, reason: collision with root package name */
        private int f3571b = -1;
        private int A = -1;
        private boolean C = false;
        private List<l> S = new ArrayList();
        private List<l> T = new ArrayList();
        private boolean X = true;
        private boolean Z = true;

        l(h hVar) {
            this.f3569a = hVar;
        }

        private float A0(float f3, float f4, float f5, float f6) {
            return Math.max(f3, Math.max(f4, Math.max(f5, f6)));
        }

        private float B0(float f3, float f4, float f5, float f6) {
            return Math.min(f3, Math.min(f4, Math.min(f5, f6)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean C0(l lVar, e2.d<l> dVar) {
            return (lVar == null || lVar.l0(dVar) == null) ? false : true;
        }

        private void D0(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f3 = fArr[3];
            fArr[0] = fArr[0] / f3;
            fArr[1] = fArr[1] / f3;
            fArr[2] = fArr[2] / f3;
            fArr[3] = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E0(float[] fArr, Set<l> set, boolean z3) {
            set.add(this);
            if (this.Z) {
                z3 = true;
            }
            if (z3) {
                if (this.f3570a0 == null) {
                    this.f3570a0 = new float[16];
                }
                if (this.Q == null) {
                    this.Q = new float[16];
                }
                Matrix.multiplyMM(this.f3570a0, 0, fArr, 0, this.Q, 0);
                float[] fArr2 = {this.M, this.N, BitmapDescriptorFactory.HUE_RED, 1.0f};
                float[] fArr3 = new float[4];
                float[] fArr4 = new float[4];
                float[] fArr5 = new float[4];
                float[] fArr6 = new float[4];
                D0(fArr3, this.f3570a0, fArr2);
                fArr2[0] = this.O;
                fArr2[1] = this.N;
                D0(fArr4, this.f3570a0, fArr2);
                fArr2[0] = this.O;
                fArr2[1] = this.P;
                D0(fArr5, this.f3570a0, fArr2);
                fArr2[0] = this.M;
                fArr2[1] = this.P;
                D0(fArr6, this.f3570a0, fArr2);
                if (this.f3572b0 == null) {
                    this.f3572b0 = new Rect();
                }
                this.f3572b0.set(Math.round(B0(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(B0(fArr3[1], fArr4[1], fArr5[1], fArr6[1])), Math.round(A0(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(A0(fArr3[1], fArr4[1], fArr5[1], fArr6[1])));
                this.Z = false;
            }
            int i3 = -1;
            for (l lVar : this.S) {
                lVar.A = i3;
                i3 = lVar.f3571b;
                lVar.E0(this.f3570a0, set, z3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F0(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            this.C = true;
            this.K = this.f3588r;
            this.L = this.f3586p;
            this.D = this.f3573c;
            this.E = this.f3574d;
            this.F = this.f3577g;
            this.G = this.f3578h;
            this.H = this.f3582l;
            this.I = this.f3583m;
            this.J = this.f3584n;
            this.f3573c = byteBuffer.getInt();
            this.f3574d = byteBuffer.getInt();
            this.f3575e = byteBuffer.getInt();
            this.f3576f = byteBuffer.getInt();
            this.f3577g = byteBuffer.getInt();
            this.f3578h = byteBuffer.getInt();
            this.f3579i = byteBuffer.getInt();
            this.f3580j = byteBuffer.getInt();
            this.f3581k = byteBuffer.getInt();
            this.f3582l = byteBuffer.getFloat();
            this.f3583m = byteBuffer.getFloat();
            this.f3584n = byteBuffer.getFloat();
            int i3 = byteBuffer.getInt();
            this.f3585o = i3 == -1 ? null : strArr[i3];
            int i4 = byteBuffer.getInt();
            this.f3586p = i4 == -1 ? null : strArr[i4];
            this.f3587q = q0(byteBuffer, byteBufferArr);
            int i5 = byteBuffer.getInt();
            this.f3588r = i5 == -1 ? null : strArr[i5];
            this.f3589s = q0(byteBuffer, byteBufferArr);
            int i6 = byteBuffer.getInt();
            this.f3590t = i6 == -1 ? null : strArr[i6];
            this.f3591u = q0(byteBuffer, byteBufferArr);
            int i7 = byteBuffer.getInt();
            this.f3592v = i7 == -1 ? null : strArr[i7];
            this.f3593w = q0(byteBuffer, byteBufferArr);
            int i8 = byteBuffer.getInt();
            this.f3594x = i8 == -1 ? null : strArr[i8];
            this.f3595y = q0(byteBuffer, byteBufferArr);
            int i9 = byteBuffer.getInt();
            this.f3596z = i9 == -1 ? null : strArr[i9];
            this.B = p.b(byteBuffer.getInt());
            this.M = byteBuffer.getFloat();
            this.N = byteBuffer.getFloat();
            this.O = byteBuffer.getFloat();
            this.P = byteBuffer.getFloat();
            if (this.Q == null) {
                this.Q = new float[16];
            }
            for (int i10 = 0; i10 < 16; i10++) {
                this.Q[i10] = byteBuffer.getFloat();
            }
            this.X = true;
            this.Z = true;
            int i11 = byteBuffer.getInt();
            this.S.clear();
            this.T.clear();
            for (int i12 = 0; i12 < i11; i12++) {
                l z3 = this.f3569a.z(byteBuffer.getInt());
                z3.R = this;
                this.S.add(z3);
            }
            for (int i13 = 0; i13 < i11; i13++) {
                l z4 = this.f3569a.z(byteBuffer.getInt());
                z4.R = this;
                this.T.add(z4);
            }
            int i14 = byteBuffer.getInt();
            if (i14 == 0) {
                this.U = null;
                return;
            }
            List<C0089h> list = this.U;
            if (list == null) {
                this.U = new ArrayList(i14);
            } else {
                list.clear();
            }
            for (int i15 = 0; i15 < i14; i15++) {
                C0089h y3 = this.f3569a.y(byteBuffer.getInt());
                if (y3.f3542c == g.TAP.f3539c) {
                    this.V = y3;
                } else if (y3.f3542c == g.LONG_PRESS.f3539c) {
                    this.W = y3;
                } else {
                    this.U.add(y3);
                }
                this.U.add(y3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g0(List<l> list) {
            if (x0(i.SCOPES_ROUTE)) {
                list.add(this);
            }
            Iterator<l> it = this.S.iterator();
            while (it.hasNext()) {
                it.next().g0(list);
            }
        }

        private SpannableString h0(String str, List<n> list) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            if (list != null) {
                for (n nVar : list) {
                    int i3 = e.f3507a[nVar.f3599c.ordinal()];
                    if (i3 == 1) {
                        spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), nVar.f3597a, nVar.f3598b, 0);
                    } else if (i3 == 2) {
                        spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(((j) nVar).f3568d)), nVar.f3597a, nVar.f3598b, 0);
                    }
                }
            }
            return spannableString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean i0() {
            String str;
            String str2 = this.f3586p;
            if (str2 == null && this.L == null) {
                return false;
            }
            return str2 == null || (str = this.L) == null || !str2.equals(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean j0() {
            return (Float.isNaN(this.f3582l) || Float.isNaN(this.H) || this.H == this.f3582l) ? false : true;
        }

        private void k0() {
            if (this.X) {
                this.X = false;
                if (this.Y == null) {
                    this.Y = new float[16];
                }
                if (Matrix.invertM(this.Y, 0, this.Q, 0)) {
                    return;
                }
                Arrays.fill(this.Y, BitmapDescriptorFactory.HUE_RED);
            }
        }

        private l l0(e2.d<l> dVar) {
            for (l lVar = this.R; lVar != null; lVar = lVar.R) {
                if (dVar.test(lVar)) {
                    return lVar;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Rect m0() {
            return this.f3572b0;
        }

        static /* synthetic */ int n(l lVar, int i3) {
            int i4 = lVar.f3578h + i3;
            lVar.f3578h = i4;
            return i4;
        }

        private CharSequence n0() {
            return h0(this.f3594x, this.f3595y);
        }

        static /* synthetic */ int o(l lVar, int i3) {
            int i4 = lVar.f3578h - i3;
            lVar.f3578h = i4;
            return i4;
        }

        private CharSequence o0() {
            return h0(this.f3586p, this.f3587q);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String p0() {
            String str;
            if (x0(i.NAMES_ROUTE) && (str = this.f3586p) != null && !str.isEmpty()) {
                return this.f3586p;
            }
            Iterator<l> it = this.S.iterator();
            while (it.hasNext()) {
                String p02 = it.next().p0();
                if (p02 != null && !p02.isEmpty()) {
                    return p02;
                }
            }
            return null;
        }

        private List<n> q0(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
            int i3 = byteBuffer.getInt();
            a aVar = null;
            if (i3 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i3);
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = byteBuffer.getInt();
                int i6 = byteBuffer.getInt();
                o oVar = o.values()[byteBuffer.getInt()];
                int i7 = e.f3507a[oVar.ordinal()];
                if (i7 == 1) {
                    byteBuffer.getInt();
                    m mVar = new m(aVar);
                    mVar.f3597a = i5;
                    mVar.f3598b = i6;
                    mVar.f3599c = oVar;
                    arrayList.add(mVar);
                } else if (i7 == 2) {
                    ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                    j jVar = new j(aVar);
                    jVar.f3597a = i5;
                    jVar.f3598b = i6;
                    jVar.f3599c = oVar;
                    jVar.f3568d = Charset.forName("UTF-8").decode(byteBuffer2).toString();
                    arrayList.add(jVar);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence r0() {
            CharSequence[] charSequenceArr = {o0(), n0()};
            CharSequence charSequence = null;
            for (int i3 = 0; i3 < 2; i3++) {
                CharSequence charSequence2 = charSequenceArr[i3];
                if (charSequence2 != null && charSequence2.length() > 0) {
                    charSequence = (charSequence == null || charSequence.length() == 0) ? charSequence2 : TextUtils.concat(charSequence, ", ", charSequence2);
                }
            }
            return charSequence;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence s0() {
            return h0(this.f3588r, this.f3589s);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence t0() {
            CharSequence[] charSequenceArr = {s0(), o0(), n0()};
            CharSequence charSequence = null;
            for (int i3 = 0; i3 < 3; i3++) {
                CharSequence charSequence2 = charSequenceArr[i3];
                if (charSequence2 != null && charSequence2.length() > 0) {
                    charSequence = (charSequence == null || charSequence.length() == 0) ? charSequence2 : TextUtils.concat(charSequence, ", ", charSequence2);
                }
            }
            return charSequence;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean u0(g gVar) {
            return (gVar.f3539c & this.E) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean v0(i iVar) {
            return (iVar.f3567c & this.D) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean w0(g gVar) {
            return (gVar.f3539c & this.f3574d) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean x0(i iVar) {
            return (iVar.f3567c & this.f3573c) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public l y0(float[] fArr, boolean z3) {
            float f3 = fArr[3];
            boolean z4 = false;
            float f4 = fArr[0] / f3;
            float f5 = fArr[1] / f3;
            if (f4 < this.M || f4 >= this.O || f5 < this.N || f5 >= this.P) {
                return null;
            }
            float[] fArr2 = new float[4];
            for (l lVar : this.T) {
                if (!lVar.x0(i.IS_HIDDEN)) {
                    lVar.k0();
                    Matrix.multiplyMV(fArr2, 0, lVar.Y, 0, fArr, 0);
                    l y02 = lVar.y0(fArr2, z3);
                    if (y02 != null) {
                        return y02;
                    }
                }
            }
            if (z3 && this.f3579i != -1) {
                z4 = true;
            }
            if (z0() || z4) {
                return this;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean z0() {
            String str;
            String str2;
            String str3;
            if (x0(i.SCOPES_ROUTE)) {
                return false;
            }
            return (!x0(i.IS_FOCUSABLE) && (this.f3574d & (~h.f3476z)) == 0 && (this.f3573c & h.A) == 0 && ((str = this.f3586p) == null || str.isEmpty()) && (((str2 = this.f3588r) == null || str2.isEmpty()) && ((str3 = this.f3594x) == null || str3.isEmpty()))) ? false : true;
        }
    }

    private static class m extends n {
        private m() {
            super(null);
        }

        /* synthetic */ m(a aVar) {
            this();
        }
    }

    private static class n {

        /* renamed from: a, reason: collision with root package name */
        int f3597a;

        /* renamed from: b, reason: collision with root package name */
        int f3598b;

        /* renamed from: c, reason: collision with root package name */
        o f3599c;

        private n() {
        }

        /* synthetic */ n(a aVar) {
            this();
        }
    }

    private enum o {
        SPELLOUT,
        LOCALE
    }

    private enum p {
        UNKNOWN,
        LTR,
        RTL;

        public static p b(int i3) {
            return i3 != 1 ? i3 != 2 ? UNKNOWN : LTR : RTL;
        }
    }

    public h(View view, t1.a aVar, AccessibilityManager accessibilityManager, ContentResolver contentResolver, io.flutter.plugin.platform.s sVar) {
        this(view, aVar, accessibilityManager, contentResolver, new AccessibilityViewEmbedder(view, 65536), sVar);
    }

    public h(View view, t1.a aVar, AccessibilityManager accessibilityManager, ContentResolver contentResolver, AccessibilityViewEmbedder accessibilityViewEmbedder, io.flutter.plugin.platform.s sVar) {
        this.f3483g = new HashMap();
        this.f3484h = new HashMap();
        this.f3488l = 0;
        this.f3492p = new ArrayList();
        this.f3493q = 0;
        this.f3494r = 0;
        this.f3496t = false;
        this.f3497u = false;
        this.f3498v = new a();
        b bVar = new b();
        this.f3499w = bVar;
        c cVar = new c(new Handler());
        this.f3501y = cVar;
        this.f3477a = view;
        this.f3478b = aVar;
        this.f3479c = accessibilityManager;
        this.f3482f = contentResolver;
        this.f3480d = accessibilityViewEmbedder;
        this.f3481e = sVar;
        bVar.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        accessibilityManager.addAccessibilityStateChangeListener(bVar);
        d dVar = new d(accessibilityManager);
        this.f3500x = dVar;
        dVar.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
        accessibilityManager.addTouchExplorationStateChangeListener(dVar);
        cVar.onChange(false);
        contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, cVar);
        if (Build.VERSION.SDK_INT >= 31) {
            a0();
        }
        sVar.a(this);
    }

    private l A() {
        return this.f3483g.get(0);
    }

    private void B(float f3, float f4, boolean z3) {
        l y02;
        if (this.f3483g.isEmpty() || (y02 = A().y0(new float[]{f3, f4, BitmapDescriptorFactory.HUE_RED, 1.0f}, z3)) == this.f3491o) {
            return;
        }
        if (y02 != null) {
            U(y02.f3571b, 128);
        }
        l lVar = this.f3491o;
        if (lVar != null) {
            U(lVar.f3571b, UserVerificationMethods.USER_VERIFY_HANDPRINT);
        }
        this.f3491o = y02;
    }

    private boolean D(l lVar) {
        if (lVar.x0(i.SCOPES_ROUTE)) {
            return false;
        }
        return (lVar.t0() == null && (lVar.f3574d & (~C)) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean F(l lVar, l lVar2) {
        return lVar2 == lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean G(l lVar) {
        return lVar.x0(i.HAS_IMPLICIT_SCROLLING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AccessibilityEvent I(int i3, int i4) {
        AccessibilityEvent H = H(i4);
        H.setPackageName(this.f3477a.getContext().getPackageName());
        H.setSource(this.f3477a, i3);
        return H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        l lVar = this.f3491o;
        if (lVar != null) {
            U(lVar.f3571b, UserVerificationMethods.USER_VERIFY_HANDPRINT);
            this.f3491o = null;
        }
    }

    private void O(l lVar) {
        String p02 = lVar.p0();
        if (p02 == null) {
            p02 = " ";
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Y(p02);
            return;
        }
        AccessibilityEvent I = I(lVar.f3571b, 32);
        I.getText().add(p02);
        V(I);
    }

    private boolean P(l lVar, int i3, Bundle bundle, boolean z3) {
        int i4 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        boolean z4 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        int i5 = lVar.f3577g;
        int i6 = lVar.f3578h;
        R(lVar, i4, z3, z4);
        if (i5 != lVar.f3577g || i6 != lVar.f3578h) {
            String str = lVar.f3588r != null ? lVar.f3588r : "";
            AccessibilityEvent I = I(lVar.f3571b, 8192);
            I.getText().add(str);
            I.setFromIndex(lVar.f3577g);
            I.setToIndex(lVar.f3578h);
            I.setItemCount(str.length());
            V(I);
        }
        if (i4 == 1) {
            if (z3) {
                g gVar = g.MOVE_CURSOR_FORWARD_BY_CHARACTER;
                if (lVar.w0(gVar)) {
                    this.f3478b.c(i3, gVar, Boolean.valueOf(z4));
                    return true;
                }
            }
            if (z3) {
                return false;
            }
            g gVar2 = g.MOVE_CURSOR_BACKWARD_BY_CHARACTER;
            if (!lVar.w0(gVar2)) {
                return false;
            }
            this.f3478b.c(i3, gVar2, Boolean.valueOf(z4));
            return true;
        }
        if (i4 != 2) {
            return i4 == 4 || i4 == 8 || i4 == 16;
        }
        if (z3) {
            g gVar3 = g.MOVE_CURSOR_FORWARD_BY_WORD;
            if (lVar.w0(gVar3)) {
                this.f3478b.c(i3, gVar3, Boolean.valueOf(z4));
                return true;
            }
        }
        if (z3) {
            return false;
        }
        g gVar4 = g.MOVE_CURSOR_BACKWARD_BY_WORD;
        if (!lVar.w0(gVar4)) {
            return false;
        }
        this.f3478b.c(i3, gVar4, Boolean.valueOf(z4));
        return true;
    }

    private boolean Q(l lVar, int i3, Bundle bundle) {
        String string = (bundle == null || !bundle.containsKey("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) ? "" : bundle.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
        this.f3478b.c(i3, g.SET_TEXT, string);
        lVar.f3588r = string;
        lVar.f3589s = null;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0022, code lost:
    
        if (r6 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0024, code lost:
    
        r5 = r4.f3588r.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002c, code lost:
    
        r4.f3578h = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:
    
        r4.f3578h = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
    
        if (r5.find() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        io.flutter.view.h.l.n(r4, r5.start(1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
    
        if (r5.find() != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008f, code lost:
    
        r5 = r5.start(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c1, code lost:
    
        if (r5.find() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e6, code lost:
    
        if (r5.find() != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void R(io.flutter.view.h.l r4, int r5, boolean r6, boolean r7) {
        /*
            r3 = this;
            int r0 = io.flutter.view.h.l.l(r4)
            if (r0 < 0) goto L111
            int r0 = io.flutter.view.h.l.j(r4)
            if (r0 >= 0) goto Le
            goto L111
        Le:
            r0 = 1
            if (r5 == r0) goto Le9
            r1 = 2
            r2 = 0
            if (r5 == r1) goto L94
            r1 = 4
            if (r5 == r1) goto L36
            r0 = 8
            if (r5 == r0) goto L22
            r0 = 16
            if (r5 == r0) goto L22
            goto L108
        L22:
            if (r6 == 0) goto L31
        L24:
            java.lang.String r5 = io.flutter.view.h.l.r(r4)
            int r5 = r5.length()
        L2c:
            io.flutter.view.h.l.m(r4, r5)
            goto L108
        L31:
            io.flutter.view.h.l.m(r4, r2)
            goto L108
        L36:
            if (r6 == 0) goto L6b
            int r5 = io.flutter.view.h.l.l(r4)
            java.lang.String r1 = io.flutter.view.h.l.r(r4)
            int r1 = r1.length()
            if (r5 >= r1) goto L6b
            java.lang.String r5 = "(?!^)(\\n)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.h.l.r(r4)
            int r1 = io.flutter.view.h.l.l(r4)
            java.lang.String r6 = r6.substring(r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L24
        L62:
            int r5 = r5.start(r0)
            io.flutter.view.h.l.n(r4, r5)
            goto L108
        L6b:
            if (r6 != 0) goto L108
            int r5 = io.flutter.view.h.l.l(r4)
            if (r5 <= 0) goto L108
            java.lang.String r5 = "(?s:.*)(\\n)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.h.l.r(r4)
            int r1 = io.flutter.view.h.l.l(r4)
            java.lang.String r6 = r6.substring(r2, r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L31
        L8f:
            int r5 = r5.start(r0)
            goto L2c
        L94:
            if (r6 == 0) goto Lc4
            int r5 = io.flutter.view.h.l.l(r4)
            java.lang.String r1 = io.flutter.view.h.l.r(r4)
            int r1 = r1.length()
            if (r5 >= r1) goto Lc4
            java.lang.String r5 = "\\p{L}(\\b)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.h.l.r(r4)
            int r1 = io.flutter.view.h.l.l(r4)
            java.lang.String r6 = r6.substring(r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            r5.find()
            boolean r6 = r5.find()
            if (r6 == 0) goto L24
            goto L62
        Lc4:
            if (r6 != 0) goto L108
            int r5 = io.flutter.view.h.l.l(r4)
            if (r5 <= 0) goto L108
            java.lang.String r5 = "(?s:.*)(\\b)\\p{L}"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.h.l.r(r4)
            int r1 = io.flutter.view.h.l.l(r4)
            java.lang.String r6 = r6.substring(r2, r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L108
            goto L8f
        Le9:
            if (r6 == 0) goto Lfd
            int r5 = io.flutter.view.h.l.l(r4)
            java.lang.String r1 = io.flutter.view.h.l.r(r4)
            int r1 = r1.length()
            if (r5 >= r1) goto Lfd
            io.flutter.view.h.l.n(r4, r0)
            goto L108
        Lfd:
            if (r6 != 0) goto L108
            int r5 = io.flutter.view.h.l.l(r4)
            if (r5 <= 0) goto L108
            io.flutter.view.h.l.o(r4, r0)
        L108:
            if (r7 != 0) goto L111
            int r5 = io.flutter.view.h.l.l(r4)
            io.flutter.view.h.l.k(r4, r5)
        L111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.h.R(io.flutter.view.h$l, int, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(AccessibilityEvent accessibilityEvent) {
        if (this.f3479c.isEnabled()) {
            this.f3477a.getParent().requestSendAccessibilityEvent(this.f3477a, accessibilityEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        this.f3478b.f(this.f3488l);
    }

    private void X(int i3) {
        AccessibilityEvent I = I(i3, 2048);
        I.setContentChangeTypes(1);
        V(I);
    }

    private void Y(String str) {
        this.f3477a.setAccessibilityPaneTitle(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(boolean z3) {
        if (this.f3496t == z3) {
            return;
        }
        this.f3496t = z3;
        this.f3488l = z3 ? this.f3488l | f.ACCESSIBLE_NAVIGATION.f3516c : this.f3488l & (~f.ACCESSIBLE_NAVIGATION.f3516c);
        W();
    }

    private void a0() {
        View view = this.f3477a;
        if (view == null || view.getResources() == null) {
            return;
        }
        int i3 = this.f3477a.getResources().getConfiguration().fontWeightAdjustment;
        this.f3488l = i3 != Integer.MAX_VALUE && i3 >= 300 ? this.f3488l | f.BOLD_TEXT.f3516c : this.f3488l & f.BOLD_TEXT.f3516c;
        W();
    }

    private boolean c0(final l lVar) {
        return lVar.f3580j > 0 && (l.C0(this.f3485i, new e2.d() { // from class: io.flutter.view.f
            @Override // e2.d
            public final boolean test(Object obj) {
                boolean F;
                F = h.F(h.l.this, (h.l) obj);
                return F;
            }
        }) || !l.C0(this.f3485i, new e2.d() { // from class: io.flutter.view.g
            @Override // e2.d
            public final boolean test(Object obj) {
                boolean G;
                G = h.G((h.l) obj);
                return G;
            }
        }));
    }

    static /* synthetic */ int e(h hVar, int i3) {
        int i4 = i3 & hVar.f3488l;
        hVar.f3488l = i4;
        return i4;
    }

    static /* synthetic */ int f(h hVar, int i3) {
        int i4 = i3 | hVar.f3488l;
        hVar.f3488l = i4;
        return i4;
    }

    private void f0(l lVar) {
        View b4;
        Integer num;
        lVar.R = null;
        if (lVar.f3579i != -1 && (num = this.f3486j) != null && this.f3480d.platformViewOfNode(num.intValue()) == this.f3481e.b(lVar.f3579i)) {
            U(this.f3486j.intValue(), 65536);
            this.f3486j = null;
        }
        if (lVar.f3579i != -1 && (b4 = this.f3481e.b(lVar.f3579i)) != null) {
            b4.setImportantForAccessibility(4);
        }
        l lVar2 = this.f3485i;
        if (lVar2 == lVar) {
            U(lVar2.f3571b, 65536);
            this.f3485i = null;
        }
        if (this.f3489m == lVar) {
            this.f3489m = null;
        }
        if (this.f3491o == lVar) {
            this.f3491o = null;
        }
    }

    private AccessibilityEvent u(int i3, String str, String str2) {
        AccessibilityEvent I = I(i3, 16);
        I.setBeforeText(str);
        I.getText().add(str2);
        int i4 = 0;
        while (i4 < str.length() && i4 < str2.length() && str.charAt(i4) == str2.charAt(i4)) {
            i4++;
        }
        if (i4 >= str.length() && i4 >= str2.length()) {
            return null;
        }
        I.setFromIndex(i4);
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        while (length >= i4 && length2 >= i4 && str.charAt(length) == str2.charAt(length2)) {
            length--;
            length2--;
        }
        I.setRemovedCount((length - i4) + 1);
        I.setAddedCount((length2 - i4) + 1);
        return I;
    }

    private boolean v() {
        Activity e3 = e2.h.e(this.f3477a.getContext());
        if (e3 == null || e3.getWindow() == null) {
            return false;
        }
        int i3 = e3.getWindow().getAttributes().layoutInDisplayCutoutMode;
        return i3 == 2 || i3 == 0;
    }

    private Rect x(Rect rect) {
        Rect rect2 = new Rect(rect);
        int[] iArr = new int[2];
        this.f3477a.getLocationOnScreen(iArr);
        rect2.offset(iArr[0], iArr[1]);
        return rect2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0089h y(int i3) {
        C0089h c0089h = this.f3484h.get(Integer.valueOf(i3));
        if (c0089h != null) {
            return c0089h;
        }
        C0089h c0089h2 = new C0089h();
        c0089h2.f3541b = i3;
        c0089h2.f3540a = B + i3;
        this.f3484h.put(Integer.valueOf(i3), c0089h2);
        return c0089h2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l z(int i3) {
        l lVar = this.f3483g.get(Integer.valueOf(i3));
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this);
        lVar2.f3571b = i3;
        this.f3483g.put(Integer.valueOf(i3), lVar2);
        return lVar2;
    }

    public boolean C() {
        return this.f3479c.isEnabled();
    }

    public boolean E() {
        return this.f3479c.isTouchExplorationEnabled();
    }

    public AccessibilityEvent H(int i3) {
        return AccessibilityEvent.obtain(i3);
    }

    public AccessibilityNodeInfo J(View view) {
        return AccessibilityNodeInfo.obtain(view);
    }

    public AccessibilityNodeInfo K(View view, int i3) {
        return AccessibilityNodeInfo.obtain(view, i3);
    }

    public boolean L(MotionEvent motionEvent) {
        return M(motionEvent, false);
    }

    public boolean M(MotionEvent motionEvent, boolean z3) {
        if (!this.f3479c.isTouchExplorationEnabled() || this.f3483g.isEmpty()) {
            return false;
        }
        l y02 = A().y0(new float[]{motionEvent.getX(), motionEvent.getY(), BitmapDescriptorFactory.HUE_RED, 1.0f}, z3);
        if (y02 != null && y02.f3579i != -1) {
            if (z3) {
                return false;
            }
            return this.f3480d.onAccessibilityHoverEvent(y02.f3571b, motionEvent);
        }
        if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
            B(motionEvent.getX(), motionEvent.getY(), z3);
        } else {
            if (motionEvent.getAction() != 10) {
                g1.b.a("flutter", "unexpected accessibility hover event: " + motionEvent);
                return false;
            }
            N();
        }
        return true;
    }

    public void S() {
        this.f3497u = true;
        this.f3481e.d();
        b0(null);
        this.f3479c.removeAccessibilityStateChangeListener(this.f3499w);
        this.f3479c.removeTouchExplorationStateChangeListener(this.f3500x);
        this.f3482f.unregisterContentObserver(this.f3501y);
        this.f3478b.g(null);
    }

    public void T() {
        this.f3483g.clear();
        l lVar = this.f3485i;
        if (lVar != null) {
            U(lVar.f3571b, 65536);
        }
        this.f3485i = null;
        this.f3491o = null;
        X(0);
    }

    public void U(int i3, int i4) {
        if (this.f3479c.isEnabled()) {
            V(I(i3, i4));
        }
    }

    public void b0(k kVar) {
        this.f3495s = kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:173:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0473  */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.accessibility.AccessibilityNodeInfo createAccessibilityNodeInfo(int r14) {
        /*
            Method dump skipped, instructions count: 1197
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.h.createAccessibilityNodeInfo(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    void d0(ByteBuffer byteBuffer, String[] strArr) {
        while (byteBuffer.hasRemaining()) {
            C0089h y3 = y(byteBuffer.getInt());
            y3.f3542c = byteBuffer.getInt();
            int i3 = byteBuffer.getInt();
            String str = null;
            y3.f3543d = i3 == -1 ? null : strArr[i3];
            int i4 = byteBuffer.getInt();
            if (i4 != -1) {
                str = strArr[i4];
            }
            y3.f3544e = str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0080, code lost:
    
        r4 = r8.f3477a.getRootWindowInsets();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void e0(java.nio.ByteBuffer r9, java.lang.String[] r10, java.nio.ByteBuffer[] r11) {
        /*
            Method dump skipped, instructions count: 833
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.h.e0(java.nio.ByteBuffer, java.lang.String[], java.nio.ByteBuffer[]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0016, code lost:
    
        if (r2 != null) goto L14;
     */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.accessibility.AccessibilityNodeInfo findFocus(int r2) {
        /*
            r1 = this;
            r0 = 1
            if (r2 == r0) goto L7
            r0 = 2
            if (r2 == r0) goto L1d
            goto L27
        L7:
            io.flutter.view.h$l r2 = r1.f3489m
            if (r2 == 0) goto L14
        Lb:
            int r2 = io.flutter.view.h.l.a(r2)
        Lf:
            android.view.accessibility.AccessibilityNodeInfo r2 = r1.createAccessibilityNodeInfo(r2)
            return r2
        L14:
            java.lang.Integer r2 = r1.f3487k
            if (r2 == 0) goto L1d
        L18:
            int r2 = r2.intValue()
            goto Lf
        L1d:
            io.flutter.view.h$l r2 = r1.f3485i
            if (r2 == 0) goto L22
            goto Lb
        L22:
            java.lang.Integer r2 = r1.f3486j
            if (r2 == 0) goto L27
            goto L18
        L27:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.h.findFocus(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i3, int i4, Bundle bundle) {
        int i5;
        if (i3 >= 65536) {
            boolean performAction = this.f3480d.performAction(i3, i4, bundle);
            if (performAction && i4 == 128) {
                this.f3486j = null;
            }
            return performAction;
        }
        l lVar = this.f3483g.get(Integer.valueOf(i3));
        boolean z3 = false;
        if (lVar == null) {
            return false;
        }
        switch (i4) {
            case 16:
                this.f3478b.b(i3, g.TAP);
                return true;
            case 32:
                this.f3478b.b(i3, g.LONG_PRESS);
                return true;
            case 64:
                if (this.f3485i == null) {
                    this.f3477a.invalidate();
                }
                this.f3485i = lVar;
                this.f3478b.b(i3, g.DID_GAIN_ACCESSIBILITY_FOCUS);
                HashMap hashMap = new HashMap();
                hashMap.put("type", "didGainFocus");
                hashMap.put("nodeId", Integer.valueOf(lVar.f3571b));
                this.f3478b.f4115a.c(hashMap);
                U(i3, 32768);
                if (lVar.w0(g.INCREASE) || lVar.w0(g.DECREASE)) {
                    U(i3, 4);
                }
                return true;
            case 128:
                l lVar2 = this.f3485i;
                if (lVar2 != null && lVar2.f3571b == i3) {
                    this.f3485i = null;
                }
                Integer num = this.f3486j;
                if (num != null && num.intValue() == i3) {
                    this.f3486j = null;
                }
                this.f3478b.b(i3, g.DID_LOSE_ACCESSIBILITY_FOCUS);
                U(i3, 65536);
                return true;
            case UserVerificationMethods.USER_VERIFY_HANDPRINT /* 256 */:
                return P(lVar, i3, bundle, true);
            case UserVerificationMethods.USER_VERIFY_NONE /* 512 */:
                return P(lVar, i3, bundle, false);
            case 4096:
                g gVar = g.SCROLL_UP;
                if (!lVar.w0(gVar)) {
                    gVar = g.SCROLL_LEFT;
                    if (!lVar.w0(gVar)) {
                        gVar = g.INCREASE;
                        if (!lVar.w0(gVar)) {
                            return false;
                        }
                        lVar.f3588r = lVar.f3590t;
                        lVar.f3589s = lVar.f3591u;
                        U(i3, 4);
                    }
                }
                this.f3478b.b(i3, gVar);
                return true;
            case 8192:
                g gVar2 = g.SCROLL_DOWN;
                if (!lVar.w0(gVar2)) {
                    gVar2 = g.SCROLL_RIGHT;
                    if (!lVar.w0(gVar2)) {
                        gVar2 = g.DECREASE;
                        if (!lVar.w0(gVar2)) {
                            return false;
                        }
                        lVar.f3588r = lVar.f3592v;
                        lVar.f3589s = lVar.f3593w;
                        U(i3, 4);
                    }
                }
                this.f3478b.b(i3, gVar2);
                return true;
            case 16384:
                this.f3478b.b(i3, g.COPY);
                return true;
            case 32768:
                this.f3478b.b(i3, g.PASTE);
                return true;
            case 65536:
                this.f3478b.b(i3, g.CUT);
                return true;
            case 131072:
                HashMap hashMap2 = new HashMap();
                if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT") && bundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                    z3 = true;
                }
                if (z3) {
                    hashMap2.put("base", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
                    i5 = bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
                } else {
                    hashMap2.put("base", Integer.valueOf(lVar.f3578h));
                    i5 = lVar.f3578h;
                }
                hashMap2.put("extent", Integer.valueOf(i5));
                this.f3478b.c(i3, g.SET_SELECTION, hashMap2);
                l lVar3 = this.f3483g.get(Integer.valueOf(i3));
                lVar3.f3577g = ((Integer) hashMap2.get("base")).intValue();
                lVar3.f3578h = ((Integer) hashMap2.get("extent")).intValue();
                return true;
            case 1048576:
                this.f3478b.b(i3, g.DISMISS);
                return true;
            case 2097152:
                return Q(lVar, i3, bundle);
            case R.id.accessibilityActionShowOnScreen:
                this.f3478b.b(i3, g.SHOW_ON_SCREEN);
                return true;
            default:
                C0089h c0089h = this.f3484h.get(Integer.valueOf(i4 - B));
                if (c0089h == null) {
                    return false;
                }
                this.f3478b.c(i3, g.CUSTOM_ACTION, Integer.valueOf(c0089h.f3541b));
                return true;
        }
    }

    public boolean w(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        if (!this.f3480d.requestSendAccessibilityEvent(view, view2, accessibilityEvent) || (recordFlutterId = this.f3480d.getRecordFlutterId(view, accessibilityEvent)) == null) {
            return false;
        }
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 8) {
            this.f3487k = recordFlutterId;
            this.f3489m = null;
            return true;
        }
        if (eventType == 128) {
            this.f3491o = null;
            return true;
        }
        if (eventType == 32768) {
            this.f3486j = recordFlutterId;
            this.f3485i = null;
            return true;
        }
        if (eventType != 65536) {
            return true;
        }
        this.f3487k = null;
        this.f3486j = null;
        return true;
    }
}
