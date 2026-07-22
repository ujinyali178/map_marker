package androidx.core.app;

import android.app.Notification;
import android.app.Notification$CallStyle;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
public class s {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Bundle f521a;

        /* renamed from: b, reason: collision with root package name */
        private IconCompat f522b;

        /* renamed from: c, reason: collision with root package name */
        private final e1[] f523c;

        /* renamed from: d, reason: collision with root package name */
        private final e1[] f524d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f525e;

        /* renamed from: f, reason: collision with root package name */
        boolean f526f;

        /* renamed from: g, reason: collision with root package name */
        private final int f527g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f528h;

        /* renamed from: i, reason: collision with root package name */
        @Deprecated
        public int f529i;

        /* renamed from: j, reason: collision with root package name */
        public CharSequence f530j;

        /* renamed from: k, reason: collision with root package name */
        public PendingIntent f531k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f532l;

        /* renamed from: androidx.core.app.s$a$a, reason: collision with other inner class name */
        public static final class C0010a {

            /* renamed from: a, reason: collision with root package name */
            private final IconCompat f533a;

            /* renamed from: b, reason: collision with root package name */
            private final CharSequence f534b;

            /* renamed from: c, reason: collision with root package name */
            private final PendingIntent f535c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f536d;

            /* renamed from: e, reason: collision with root package name */
            private final Bundle f537e;

            /* renamed from: f, reason: collision with root package name */
            private ArrayList<e1> f538f;

            /* renamed from: g, reason: collision with root package name */
            private int f539g;

            /* renamed from: h, reason: collision with root package name */
            private boolean f540h;

            /* renamed from: i, reason: collision with root package name */
            private boolean f541i;

            /* renamed from: j, reason: collision with root package name */
            private boolean f542j;

            public C0010a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            private C0010a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, e1[] e1VarArr, boolean z3, int i3, boolean z4, boolean z5, boolean z6) {
                this.f536d = true;
                this.f540h = true;
                this.f533a = iconCompat;
                this.f534b = d.d(charSequence);
                this.f535c = pendingIntent;
                this.f537e = bundle;
                this.f538f = e1VarArr == null ? null : new ArrayList<>(Arrays.asList(e1VarArr));
                this.f536d = z3;
                this.f539g = i3;
                this.f540h = z4;
                this.f541i = z5;
                this.f542j = z6;
            }

            private void b() {
                if (this.f541i && this.f535c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public a a() {
                b();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<e1> arrayList3 = this.f538f;
                if (arrayList3 != null) {
                    Iterator<e1> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        e1 next = it.next();
                        if (next.j()) {
                            arrayList.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                e1[] e1VarArr = arrayList.isEmpty() ? null : (e1[]) arrayList.toArray(new e1[arrayList.size()]);
                return new a(this.f533a, this.f534b, this.f535c, this.f537e, arrayList2.isEmpty() ? null : (e1[]) arrayList2.toArray(new e1[arrayList2.size()]), e1VarArr, this.f536d, this.f539g, this.f540h, this.f541i, this.f542j);
            }
        }

        public a(int i3, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i3 != 0 ? IconCompat.h(null, "", i3) : null, charSequence, pendingIntent);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, e1[] e1VarArr, e1[] e1VarArr2, boolean z3, int i3, boolean z4, boolean z5, boolean z6) {
            this.f526f = true;
            this.f522b = iconCompat;
            if (iconCompat != null && iconCompat.l() == 2) {
                this.f529i = iconCompat.j();
            }
            this.f530j = d.d(charSequence);
            this.f531k = pendingIntent;
            this.f521a = bundle == null ? new Bundle() : bundle;
            this.f523c = e1VarArr;
            this.f524d = e1VarArr2;
            this.f525e = z3;
            this.f527g = i3;
            this.f526f = z4;
            this.f528h = z5;
            this.f532l = z6;
        }

        public PendingIntent a() {
            return this.f531k;
        }

        public boolean b() {
            return this.f525e;
        }

        public Bundle c() {
            return this.f521a;
        }

        public IconCompat d() {
            int i3;
            if (this.f522b == null && (i3 = this.f529i) != 0) {
                this.f522b = IconCompat.h(null, "", i3);
            }
            return this.f522b;
        }

        public e1[] e() {
            return this.f523c;
        }

        public int f() {
            return this.f527g;
        }

        public boolean g() {
            return this.f526f;
        }

        public CharSequence h() {
            return this.f530j;
        }

        public boolean i() {
            return this.f532l;
        }

        public boolean j() {
            return this.f528h;
        }
    }

    public static class b extends f {

        /* renamed from: e, reason: collision with root package name */
        private CharSequence f543e;

        static class a {
            static Notification.BigTextStyle a(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.bigText(charSequence);
            }

            static Notification.BigTextStyle b(Notification.Builder builder) {
                return new Notification.BigTextStyle(builder);
            }

            static Notification.BigTextStyle c(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.setBigContentTitle(charSequence);
            }

            static Notification.BigTextStyle d(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.setSummaryText(charSequence);
            }
        }

        @Override // androidx.core.app.s.f
        public void a(Bundle bundle) {
            super.a(bundle);
        }

        @Override // androidx.core.app.s.f
        public void b(r rVar) {
            Notification.BigTextStyle a4 = a.a(a.c(a.b(rVar.a()), this.f581b), this.f543e);
            if (this.f583d) {
                a.d(a4, this.f582c);
            }
        }

        @Override // androidx.core.app.s.f
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public b h(CharSequence charSequence) {
            this.f543e = d.d(charSequence);
            return this;
        }
    }

    public static final class c {
        public static Notification.BubbleMetadata a(c cVar) {
            return null;
        }
    }

    public static class d {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        long N;
        int O;
        int P;
        boolean Q;
        Notification R;
        boolean S;
        Object T;

        @Deprecated
        public ArrayList<String> U;

        /* renamed from: a, reason: collision with root package name */
        public Context f544a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<a> f545b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<c1> f546c;

        /* renamed from: d, reason: collision with root package name */
        ArrayList<a> f547d;

        /* renamed from: e, reason: collision with root package name */
        CharSequence f548e;

        /* renamed from: f, reason: collision with root package name */
        CharSequence f549f;

        /* renamed from: g, reason: collision with root package name */
        PendingIntent f550g;

        /* renamed from: h, reason: collision with root package name */
        PendingIntent f551h;

        /* renamed from: i, reason: collision with root package name */
        RemoteViews f552i;

        /* renamed from: j, reason: collision with root package name */
        IconCompat f553j;

        /* renamed from: k, reason: collision with root package name */
        CharSequence f554k;

        /* renamed from: l, reason: collision with root package name */
        int f555l;

        /* renamed from: m, reason: collision with root package name */
        int f556m;

        /* renamed from: n, reason: collision with root package name */
        boolean f557n;

        /* renamed from: o, reason: collision with root package name */
        boolean f558o;

        /* renamed from: p, reason: collision with root package name */
        f f559p;

        /* renamed from: q, reason: collision with root package name */
        CharSequence f560q;

        /* renamed from: r, reason: collision with root package name */
        CharSequence f561r;

        /* renamed from: s, reason: collision with root package name */
        CharSequence[] f562s;

        /* renamed from: t, reason: collision with root package name */
        int f563t;

        /* renamed from: u, reason: collision with root package name */
        int f564u;

        /* renamed from: v, reason: collision with root package name */
        boolean f565v;

        /* renamed from: w, reason: collision with root package name */
        String f566w;

        /* renamed from: x, reason: collision with root package name */
        boolean f567x;

        /* renamed from: y, reason: collision with root package name */
        String f568y;

        /* renamed from: z, reason: collision with root package name */
        boolean f569z;

        @Deprecated
        public d(Context context) {
            this(context, null);
        }

        public d(Context context, String str) {
            this.f545b = new ArrayList<>();
            this.f546c = new ArrayList<>();
            this.f547d = new ArrayList<>();
            this.f557n = true;
            this.f569z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.O = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.R = notification;
            this.f544a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.R.audioStreamType = -1;
            this.f556m = 0;
            this.U = new ArrayList<>();
            this.Q = true;
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private void k(int i3, boolean z3) {
            Notification notification;
            int i4;
            if (z3) {
                notification = this.R;
                i4 = i3 | notification.flags;
            } else {
                notification = this.R;
                i4 = (~i3) & notification.flags;
            }
            notification.flags = i4;
        }

        public d a(int i3, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f545b.add(new a(i3, charSequence, pendingIntent));
            return this;
        }

        public Notification b() {
            return new w(this).c();
        }

        public Bundle c() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public d e(boolean z3) {
            k(16, z3);
            return this;
        }

        public d f(String str) {
            this.K = str;
            return this;
        }

        public d g(int i3) {
            this.E = i3;
            return this;
        }

        public d h(PendingIntent pendingIntent) {
            this.f550g = pendingIntent;
            return this;
        }

        public d i(CharSequence charSequence) {
            this.f549f = d(charSequence);
            return this;
        }

        public d j(CharSequence charSequence) {
            this.f548e = d(charSequence);
            return this;
        }

        public d l(boolean z3) {
            this.f569z = z3;
            return this;
        }

        public d m(boolean z3) {
            k(2, z3);
            return this;
        }

        public d n(int i3) {
            this.f556m = i3;
            return this;
        }

        public d o(int i3) {
            this.R.icon = i3;
            return this;
        }

        public d p(f fVar) {
            if (this.f559p != fVar) {
                this.f559p = fVar;
                if (fVar != null) {
                    fVar.g(this);
                }
            }
            return this;
        }

        public d q(CharSequence charSequence) {
            this.R.tickerText = d(charSequence);
            return this;
        }

        public d r(long j3) {
            this.R.when = j3;
            return this;
        }
    }

    public static class e extends f {

        /* renamed from: e, reason: collision with root package name */
        private int f570e;

        /* renamed from: f, reason: collision with root package name */
        private c1 f571f;

        /* renamed from: g, reason: collision with root package name */
        private PendingIntent f572g;

        /* renamed from: h, reason: collision with root package name */
        private PendingIntent f573h;

        /* renamed from: i, reason: collision with root package name */
        private PendingIntent f574i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f575j;

        /* renamed from: k, reason: collision with root package name */
        private Integer f576k;

        /* renamed from: l, reason: collision with root package name */
        private Integer f577l;

        /* renamed from: m, reason: collision with root package name */
        private IconCompat f578m;

        /* renamed from: n, reason: collision with root package name */
        private CharSequence f579n;

        static class a {
            static void a(Notification$CallStyle notification$CallStyle, Notification.Builder builder) {
                notification$CallStyle.setBuilder(builder);
            }
        }

        static class b {
            static Notification.Builder a(Notification.Builder builder, String str) {
                return builder.addPerson(str);
            }

            static Notification.Builder b(Notification.Builder builder, String str) {
                return builder.setCategory(str);
            }
        }

        static class c {
            static Parcelable a(Icon icon) {
                return icon;
            }

            static Notification.Action.Builder b(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(icon, charSequence, pendingIntent);
            }

            static void c(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
            }
        }

        static class d {
            static Notification.Builder a(Notification.Builder builder, Person person) {
                Notification.Builder addPerson;
                addPerson = builder.addPerson(person);
                return addPerson;
            }

            static Parcelable b(Person person) {
                return person;
            }
        }

        /* renamed from: androidx.core.app.s$e$e, reason: collision with other inner class name */
        static class C0011e {
            static Notification$CallStyle a(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification$CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
            }

            static Notification$CallStyle b(Person person, PendingIntent pendingIntent) {
                return Notification$CallStyle.forOngoingCall(person, pendingIntent);
            }

            static Notification$CallStyle c(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification$CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
            }

            static Notification$CallStyle d(Notification$CallStyle notification$CallStyle, int i3) {
                return notification$CallStyle.setAnswerButtonColorHint(i3);
            }

            static Notification.Action.Builder e(Notification.Action.Builder builder, boolean z3) {
                Notification.Action.Builder authenticationRequired;
                authenticationRequired = builder.setAuthenticationRequired(z3);
                return authenticationRequired;
            }

            static Notification$CallStyle f(Notification$CallStyle notification$CallStyle, int i3) {
                return notification$CallStyle.setDeclineButtonColorHint(i3);
            }

            static Notification$CallStyle g(Notification$CallStyle notification$CallStyle, boolean z3) {
                return notification$CallStyle.setIsVideo(z3);
            }

            static Notification$CallStyle h(Notification$CallStyle notification$CallStyle, Icon icon) {
                return notification$CallStyle.setVerificationIcon(icon);
            }

            static Notification$CallStyle i(Notification$CallStyle notification$CallStyle, CharSequence charSequence) {
                return notification$CallStyle.setVerificationText(charSequence);
            }
        }

        private String i() {
            Resources resources;
            int i3;
            int i4 = this.f570e;
            if (i4 == 1) {
                resources = this.f580a.f544a.getResources();
                i3 = h.e.f2593e;
            } else if (i4 == 2) {
                resources = this.f580a.f544a.getResources();
                i3 = h.e.f2594f;
            } else {
                if (i4 != 3) {
                    return null;
                }
                resources = this.f580a.f544a.getResources();
                i3 = h.e.f2595g;
            }
            return resources.getString(i3);
        }

        private boolean j(a aVar) {
            return aVar != null && aVar.c().getBoolean("key_action_priority");
        }

        private a k(int i3, int i4, Integer num, int i5, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(androidx.core.content.a.getColor(this.f580a.f544a, i5));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.f580a.f544a.getResources().getString(i4));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            a a4 = new a.C0010a(IconCompat.g(this.f580a.f544a, i3), spannableStringBuilder, pendingIntent).a();
            a4.c().putBoolean("key_action_priority", true);
            return a4;
        }

        private a l() {
            int i3 = h.c.f2561b;
            int i4 = h.c.f2560a;
            PendingIntent pendingIntent = this.f572g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z3 = this.f575j;
            return k(z3 ? i3 : i4, z3 ? h.e.f2590b : h.e.f2589a, this.f576k, h.b.f2558a, pendingIntent);
        }

        private a m() {
            int i3;
            Integer num;
            int i4;
            int i5 = h.c.f2562c;
            PendingIntent pendingIntent = this.f573h;
            if (pendingIntent == null) {
                i3 = h.e.f2592d;
                num = this.f577l;
                i4 = h.b.f2559b;
                pendingIntent = this.f574i;
            } else {
                i3 = h.e.f2591c;
                num = this.f577l;
                i4 = h.b.f2559b;
            }
            return k(i5, i3, num, i4, pendingIntent);
        }

        @Override // androidx.core.app.s.f
        public void a(Bundle bundle) {
            Parcelable q3;
            String str;
            Parcelable i3;
            String str2;
            super.a(bundle);
            bundle.putInt("android.callType", this.f570e);
            bundle.putBoolean("android.callIsVideo", this.f575j);
            c1 c1Var = this.f571f;
            if (c1Var != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    i3 = d.b(c1Var.h());
                    str2 = "android.callPerson";
                } else {
                    i3 = c1Var.i();
                    str2 = "android.callPersonCompat";
                }
                bundle.putParcelable(str2, i3);
            }
            IconCompat iconCompat = this.f578m;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    q3 = c.a(iconCompat.s(this.f580a.f544a));
                    str = "android.verificationIcon";
                } else {
                    q3 = iconCompat.q();
                    str = "android.verificationIconCompat";
                }
                bundle.putParcelable(str, q3);
            }
            bundle.putCharSequence("android.verificationText", this.f579n);
            bundle.putParcelable("android.answerIntent", this.f572g);
            bundle.putParcelable("android.declineIntent", this.f573h);
            bundle.putParcelable("android.hangUpIntent", this.f574i);
            Integer num = this.f576k;
            if (num != null) {
                bundle.putInt("android.answerColor", num.intValue());
            }
            Integer num2 = this.f577l;
            if (num2 != null) {
                bundle.putInt("android.declineColor", num2.intValue());
            }
        }

        @Override // androidx.core.app.s.f
        public void b(r rVar) {
            int i3 = Build.VERSION.SDK_INT;
            CharSequence charSequence = null;
            r1 = null;
            Notification$CallStyle a4 = null;
            charSequence = null;
            if (i3 < 31) {
                Notification.Builder a5 = rVar.a();
                c1 c1Var = this.f571f;
                a5.setContentTitle(c1Var != null ? c1Var.c() : null);
                Bundle bundle = this.f580a.D;
                if (bundle != null && bundle.containsKey("android.text")) {
                    charSequence = this.f580a.D.getCharSequence("android.text");
                }
                if (charSequence == null) {
                    charSequence = i();
                }
                a5.setContentText(charSequence);
                c1 c1Var2 = this.f571f;
                if (c1Var2 != null) {
                    if (i3 >= 23 && c1Var2.a() != null) {
                        c.c(a5, this.f571f.a().s(this.f580a.f544a));
                    }
                    if (i3 >= 28) {
                        d.a(a5, this.f571f.h());
                    } else {
                        b.a(a5, this.f571f.d());
                    }
                }
                b.b(a5, "call");
                return;
            }
            int i4 = this.f570e;
            if (i4 == 1) {
                a4 = C0011e.a(this.f571f.h(), this.f573h, this.f572g);
            } else if (i4 == 2) {
                a4 = C0011e.b(this.f571f.h(), this.f574i);
            } else if (i4 == 3) {
                a4 = C0011e.c(this.f571f.h(), this.f574i, this.f572g);
            } else if (Log.isLoggable("NotifCompat", 3)) {
                Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.f570e));
            }
            if (a4 != null) {
                a.a(a4, rVar.a());
                Integer num = this.f576k;
                if (num != null) {
                    C0011e.d(a4, num.intValue());
                }
                Integer num2 = this.f577l;
                if (num2 != null) {
                    C0011e.f(a4, num2.intValue());
                }
                C0011e.i(a4, this.f579n);
                IconCompat iconCompat = this.f578m;
                if (iconCompat != null) {
                    C0011e.h(a4, iconCompat.s(this.f580a.f544a));
                }
                C0011e.g(a4, this.f575j);
            }
        }

        @Override // androidx.core.app.s.f
        protected String c() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        public ArrayList<a> h() {
            a m3 = m();
            a l3 = l();
            ArrayList<a> arrayList = new ArrayList<>(3);
            arrayList.add(m3);
            int i3 = 2;
            ArrayList<a> arrayList2 = this.f580a.f545b;
            if (arrayList2 != null) {
                for (a aVar : arrayList2) {
                    if (aVar.j()) {
                        arrayList.add(aVar);
                    } else if (!j(aVar) && i3 > 1) {
                        arrayList.add(aVar);
                        i3--;
                    }
                    if (l3 != null && i3 == 1) {
                        arrayList.add(l3);
                        i3--;
                    }
                }
            }
            if (l3 != null && i3 >= 1) {
                arrayList.add(l3);
            }
            return arrayList;
        }
    }

    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        protected d f580a;

        /* renamed from: b, reason: collision with root package name */
        CharSequence f581b;

        /* renamed from: c, reason: collision with root package name */
        CharSequence f582c;

        /* renamed from: d, reason: collision with root package name */
        boolean f583d = false;

        public void a(Bundle bundle) {
            if (this.f583d) {
                bundle.putCharSequence("android.summaryText", this.f582c);
            }
            CharSequence charSequence = this.f581b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String c3 = c();
            if (c3 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c3);
            }
        }

        public abstract void b(r rVar);

        protected abstract String c();

        public RemoteViews d(r rVar) {
            return null;
        }

        public RemoteViews e(r rVar) {
            return null;
        }

        public RemoteViews f(r rVar) {
            return null;
        }

        public void g(d dVar) {
            if (this.f580a != dVar) {
                this.f580a = dVar;
                if (dVar != null) {
                    dVar.p(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }
}
