package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.s;
import androidx.core.graphics.drawable.IconCompat;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /root/release/classes.dex */
class w implements r {

    /* renamed from: a, reason: collision with root package name */
    private final Context f607a;

    /* renamed from: b, reason: collision with root package name */
    private final Notification.Builder f608b;

    /* renamed from: c, reason: collision with root package name */
    private final s.d f609c;

    /* renamed from: d, reason: collision with root package name */
    private RemoteViews f610d;

    /* renamed from: e, reason: collision with root package name */
    private RemoteViews f611e;

    /* renamed from: f, reason: collision with root package name */
    private final List<Bundle> f612f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private final Bundle f613g = new Bundle();

    /* renamed from: h, reason: collision with root package name */
    private int f614h;

    /* renamed from: i, reason: collision with root package name */
    private RemoteViews f615i;

    static class a {
        static Notification a(Notification.Builder builder) {
            return builder.build();
        }

        static Notification.Builder b(Notification.Builder builder, int i3) {
            return builder.setPriority(i3);
        }

        static Notification.Builder c(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSubText(charSequence);
        }

        static Notification.Builder d(Notification.Builder builder, boolean z3) {
            return builder.setUsesChronometer(z3);
        }
    }

    static class b {
        static Notification.Builder a(Notification.Builder builder, boolean z3) {
            return builder.setShowWhen(z3);
        }
    }

    static class c {
        static Notification.Builder a(Notification.Builder builder, Bundle bundle) {
            return builder.setExtras(bundle);
        }
    }

    static class d {
        static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        static Notification.Action.Builder e(int i3, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i3, charSequence, pendingIntent);
        }

        static String f(Notification notification) {
            return notification.getGroup();
        }

        static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        static Notification.Builder h(Notification.Builder builder, boolean z3) {
            return builder.setGroupSummary(z3);
        }

        static Notification.Builder i(Notification.Builder builder, boolean z3) {
            return builder.setLocalOnly(z3);
        }

        static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    static class e {
        static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        static Notification.Builder c(Notification.Builder builder, int i3) {
            return builder.setColor(i3);
        }

        static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        static Notification.Builder f(Notification.Builder builder, int i3) {
            return builder.setVisibility(i3);
        }
    }

    static class f {
        static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        static Notification.Builder b(Notification.Builder builder, Icon icon) {
            Notification.Builder largeIcon;
            largeIcon = builder.setLargeIcon(icon);
            return largeIcon;
        }

        static Notification.Builder c(Notification.Builder builder, Object obj) {
            Notification.Builder smallIcon;
            smallIcon = builder.setSmallIcon((Icon) obj);
            return smallIcon;
        }
    }

    static class g {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z3) {
            Notification.Action.Builder allowGeneratedReplies;
            allowGeneratedReplies = builder.setAllowGeneratedReplies(z3);
            return allowGeneratedReplies;
        }

        static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            Notification.Builder customBigContentView;
            customBigContentView = builder.setCustomBigContentView(remoteViews);
            return customBigContentView;
        }

        static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            Notification.Builder customContentView;
            customContentView = builder.setCustomContentView(remoteViews);
            return customContentView;
        }

        static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            Notification.Builder customHeadsUpContentView;
            customHeadsUpContentView = builder.setCustomHeadsUpContentView(remoteViews);
            return customHeadsUpContentView;
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            Notification.Builder remoteInputHistory;
            remoteInputHistory = builder.setRemoteInputHistory(charSequenceArr);
            return remoteInputHistory;
        }
    }

    static class h {
        static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        static Notification.Builder b(Notification.Builder builder, int i3) {
            Notification.Builder badgeIconType;
            badgeIconType = builder.setBadgeIconType(i3);
            return badgeIconType;
        }

        static Notification.Builder c(Notification.Builder builder, boolean z3) {
            Notification.Builder colorized;
            colorized = builder.setColorized(z3);
            return colorized;
        }

        static Notification.Builder d(Notification.Builder builder, int i3) {
            Notification.Builder groupAlertBehavior;
            groupAlertBehavior = builder.setGroupAlertBehavior(i3);
            return groupAlertBehavior;
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            Notification.Builder settingsText;
            settingsText = builder.setSettingsText(charSequence);
            return settingsText;
        }

        static Notification.Builder f(Notification.Builder builder, String str) {
            Notification.Builder shortcutId;
            shortcutId = builder.setShortcutId(str);
            return shortcutId;
        }

        static Notification.Builder g(Notification.Builder builder, long j3) {
            Notification.Builder timeoutAfter;
            timeoutAfter = builder.setTimeoutAfter(j3);
            return timeoutAfter;
        }
    }

    static class i {
        static Notification.Builder a(Notification.Builder builder, Person person) {
            Notification.Builder addPerson;
            addPerson = builder.addPerson(person);
            return addPerson;
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, int i3) {
            Notification.Action.Builder semanticAction;
            semanticAction = builder.setSemanticAction(i3);
            return semanticAction;
        }
    }

    static class j {
        static Notification.Builder a(Notification.Builder builder, boolean z3) {
            Notification.Builder allowSystemGeneratedContextualActions;
            allowSystemGeneratedContextualActions = builder.setAllowSystemGeneratedContextualActions(z3);
            return allowSystemGeneratedContextualActions;
        }

        static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            Notification.Builder bubbleMetadata2;
            bubbleMetadata2 = builder.setBubbleMetadata(bubbleMetadata);
            return bubbleMetadata2;
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z3) {
            Notification.Action.Builder contextual;
            contextual = builder.setContextual(z3);
            return contextual;
        }

        static Notification.Builder d(Notification.Builder builder, Object obj) {
            Notification.Builder locusId;
            locusId = builder.setLocusId((LocusId) obj);
            return locusId;
        }
    }

    static class k {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z3) {
            Notification.Action.Builder authenticationRequired;
            authenticationRequired = builder.setAuthenticationRequired(z3);
            return authenticationRequired;
        }

        static Notification.Builder b(Notification.Builder builder, int i3) {
            Notification.Builder foregroundServiceBehavior;
            foregroundServiceBehavior = builder.setForegroundServiceBehavior(i3);
            return foregroundServiceBehavior;
        }
    }

    w(s.d dVar) {
        int i3;
        Object obj;
        this.f609c = dVar;
        Context context = dVar.f544a;
        this.f607a = context;
        int i4 = Build.VERSION.SDK_INT;
        this.f608b = i4 >= 26 ? h.a(context, dVar.K) : new Notification.Builder(dVar.f544a);
        Notification notification = dVar.R;
        this.f608b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.f552i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.f548e).setContentText(dVar.f549f).setContentInfo(dVar.f554k).setContentIntent(dVar.f550g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.f551h, (notification.flags & 128) != 0).setNumber(dVar.f555l).setProgress(dVar.f563t, dVar.f564u, dVar.f565v);
        if (i4 < 23) {
            Notification.Builder builder = this.f608b;
            IconCompat iconCompat = dVar.f553j;
            builder.setLargeIcon(iconCompat == null ? null : iconCompat.i());
        } else {
            Notification.Builder builder2 = this.f608b;
            IconCompat iconCompat2 = dVar.f553j;
            f.b(builder2, iconCompat2 == null ? null : iconCompat2.s(context));
        }
        a.b(a.d(a.c(this.f608b, dVar.f560q), dVar.f558o), dVar.f556m);
        s.f fVar = dVar.f559p;
        if (fVar instanceof s.e) {
            Iterator<s.a> it = ((s.e) fVar).h().iterator();
            while (it.hasNext()) {
                b(it.next());
            }
        } else {
            Iterator<s.a> it2 = dVar.f545b.iterator();
            while (it2.hasNext()) {
                b(it2.next());
            }
        }
        Bundle bundle = dVar.D;
        if (bundle != null) {
            this.f613g.putAll(bundle);
        }
        int i5 = Build.VERSION.SDK_INT;
        this.f610d = dVar.H;
        this.f611e = dVar.I;
        b.a(this.f608b, dVar.f557n);
        d.i(this.f608b, dVar.f569z);
        d.g(this.f608b, dVar.f566w);
        d.j(this.f608b, dVar.f568y);
        d.h(this.f608b, dVar.f567x);
        this.f614h = dVar.O;
        e.b(this.f608b, dVar.C);
        e.c(this.f608b, dVar.E);
        e.f(this.f608b, dVar.F);
        e.d(this.f608b, dVar.G);
        e.e(this.f608b, notification.sound, notification.audioAttributes);
        List e3 = i5 < 28 ? e(f(dVar.f546c), dVar.U) : dVar.U;
        if (e3 != null && !e3.isEmpty()) {
            Iterator it3 = e3.iterator();
            while (it3.hasNext()) {
                e.a(this.f608b, (String) it3.next());
            }
        }
        this.f615i = dVar.J;
        if (dVar.f547d.size() > 0) {
            Bundle bundle2 = dVar.c().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i6 = 0; i6 < dVar.f547d.size(); i6++) {
                bundle4.putBundle(Integer.toString(i6), p0.a(dVar.f547d.get(i6)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            dVar.c().putBundle("android.car.EXTENSIONS", bundle2);
            this.f613g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 23 && (obj = dVar.T) != null) {
            f.c(this.f608b, obj);
        }
        if (i7 >= 24) {
            c.a(this.f608b, dVar.D);
            g.e(this.f608b, dVar.f562s);
            RemoteViews remoteViews = dVar.H;
            if (remoteViews != null) {
                g.c(this.f608b, remoteViews);
            }
            RemoteViews remoteViews2 = dVar.I;
            if (remoteViews2 != null) {
                g.b(this.f608b, remoteViews2);
            }
            RemoteViews remoteViews3 = dVar.J;
            if (remoteViews3 != null) {
                g.d(this.f608b, remoteViews3);
            }
        }
        if (i7 >= 26) {
            h.b(this.f608b, dVar.L);
            h.e(this.f608b, dVar.f561r);
            h.f(this.f608b, dVar.M);
            h.g(this.f608b, dVar.N);
            h.d(this.f608b, dVar.O);
            if (dVar.B) {
                h.c(this.f608b, dVar.A);
            }
            if (!TextUtils.isEmpty(dVar.K)) {
                this.f608b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i7 >= 28) {
            Iterator<c1> it4 = dVar.f546c.iterator();
            while (it4.hasNext()) {
                i.a(this.f608b, it4.next().h());
            }
        }
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 29) {
            j.a(this.f608b, dVar.Q);
            j.b(this.f608b, s.c.a(null));
        }
        if (i8 >= 31 && (i3 = dVar.P) != 0) {
            k.b(this.f608b, i3);
        }
        if (dVar.S) {
            if (this.f609c.f567x) {
                this.f614h = 2;
            } else {
                this.f614h = 1;
            }
            this.f608b.setVibrate(null);
            this.f608b.setSound(null);
            int i9 = notification.defaults & (-2) & (-3);
            notification.defaults = i9;
            this.f608b.setDefaults(i9);
            if (i8 >= 26) {
                if (TextUtils.isEmpty(this.f609c.f566w)) {
                    d.g(this.f608b, "silent");
                }
                h.d(this.f608b, this.f614h);
            }
        }
    }

    private void b(s.a aVar) {
        int i3 = Build.VERSION.SDK_INT;
        IconCompat d3 = aVar.d();
        Notification.Action.Builder a4 = i3 >= 23 ? f.a(d3 != null ? d3.r() : null, aVar.h(), aVar.a()) : d.e(d3 != null ? d3.j() : 0, aVar.h(), aVar.a());
        if (aVar.e() != null) {
            for (RemoteInput remoteInput : e1.b(aVar.e())) {
                d.c(a4, remoteInput);
            }
        }
        Bundle bundle = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 24) {
            g.a(a4, aVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.f());
        if (i4 >= 28) {
            i.b(a4, aVar.f());
        }
        if (i4 >= 29) {
            j.c(a4, aVar.j());
        }
        if (i4 >= 31) {
            k.a(a4, aVar.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.g());
        d.b(a4, bundle);
        d.a(this.f608b, d.d(a4));
    }

    private static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        androidx.collection.b bVar = new androidx.collection.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    private static List<String> f(List<c1> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<c1> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().g());
        }
        return arrayList;
    }

    private void g(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults = notification.defaults & (-2) & (-3);
    }

    @Override // androidx.core.app.r
    public Notification.Builder a() {
        return this.f608b;
    }

    public Notification c() {
        Bundle a4;
        RemoteViews f3;
        RemoteViews d3;
        s.f fVar = this.f609c.f559p;
        if (fVar != null) {
            fVar.b(this);
        }
        RemoteViews e3 = fVar != null ? fVar.e(this) : null;
        Notification d4 = d();
        if (e3 != null || (e3 = this.f609c.H) != null) {
            d4.contentView = e3;
        }
        if (fVar != null && (d3 = fVar.d(this)) != null) {
            d4.bigContentView = d3;
        }
        if (fVar != null && (f3 = this.f609c.f559p.f(this)) != null) {
            d4.headsUpContentView = f3;
        }
        if (fVar != null && (a4 = s.a(d4)) != null) {
            fVar.a(a4);
        }
        return d4;
    }

    protected Notification d() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            return a.a(this.f608b);
        }
        if (i3 >= 24) {
            Notification a4 = a.a(this.f608b);
            if (this.f614h != 0) {
                if (d.f(a4) != null && (a4.flags & UserVerificationMethods.USER_VERIFY_NONE) != 0 && this.f614h == 2) {
                    g(a4);
                }
                if (d.f(a4) != null && (a4.flags & UserVerificationMethods.USER_VERIFY_NONE) == 0 && this.f614h == 1) {
                    g(a4);
                }
            }
            return a4;
        }
        c.a(this.f608b, this.f613g);
        Notification a5 = a.a(this.f608b);
        RemoteViews remoteViews = this.f610d;
        if (remoteViews != null) {
            a5.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f611e;
        if (remoteViews2 != null) {
            a5.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.f615i;
        if (remoteViews3 != null) {
            a5.headsUpContentView = remoteViews3;
        }
        if (this.f614h != 0) {
            if (d.f(a5) != null && (a5.flags & UserVerificationMethods.USER_VERIFY_NONE) != 0 && this.f614h == 2) {
                g(a5);
            }
            if (d.f(a5) != null && (a5.flags & UserVerificationMethods.USER_VERIFY_NONE) == 0 && this.f614h == 1) {
                g(a5);
            }
        }
        return a5;
    }
}
