package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class e implements Parcelable {

    /* renamed from: c, reason: collision with root package name */
    private final IntentSender f325c;

    /* renamed from: d, reason: collision with root package name */
    private final Intent f326d;

    /* renamed from: f, reason: collision with root package name */
    private final int f327f;

    /* renamed from: g, reason: collision with root package name */
    private final int f328g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f324h = new c(null);
    public static final Parcelable.Creator<e> CREATOR = new b();

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final IntentSender f329a;

        /* renamed from: b, reason: collision with root package name */
        private Intent f330b;

        /* renamed from: c, reason: collision with root package name */
        private int f331c;

        /* renamed from: d, reason: collision with root package name */
        private int f332d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a(android.app.PendingIntent r2) {
            /*
                r1 = this;
                java.lang.String r0 = "pendingIntent"
                kotlin.jvm.internal.k.e(r2, r0)
                android.content.IntentSender r2 = r2.getIntentSender()
                java.lang.String r0 = "pendingIntent.intentSender"
                kotlin.jvm.internal.k.d(r2, r0)
                r1.<init>(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.e.a.<init>(android.app.PendingIntent):void");
        }

        public a(IntentSender intentSender) {
            k.e(intentSender, "intentSender");
            this.f329a = intentSender;
        }

        public final e a() {
            return new e(this.f329a, this.f330b, this.f331c, this.f332d);
        }

        public final a b(Intent intent) {
            this.f330b = intent;
            return this;
        }

        public final a c(int i3, int i4) {
            this.f332d = i3;
            this.f331c = i4;
            return this;
        }
    }

    public static final class b implements Parcelable.Creator<e> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel inParcel) {
            k.e(inParcel, "inParcel");
            return new e(inParcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i3) {
            return new e[i3];
        }
    }

    public static final class c {
        private c() {
        }

        public /* synthetic */ c(g gVar) {
            this();
        }
    }

    public e(IntentSender intentSender, Intent intent, int i3, int i4) {
        k.e(intentSender, "intentSender");
        this.f325c = intentSender;
        this.f326d = intent;
        this.f327f = i3;
        this.f328g = i4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(android.os.Parcel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.k.e(r4, r0)
            java.lang.Class<android.content.IntentSender> r0 = android.content.IntentSender.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r4.readParcelable(r0)
            kotlin.jvm.internal.k.b(r0)
            android.content.IntentSender r0 = (android.content.IntentSender) r0
            java.lang.Class<android.content.Intent> r1 = android.content.Intent.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r1 = r4.readParcelable(r1)
            android.content.Intent r1 = (android.content.Intent) r1
            int r2 = r4.readInt()
            int r4 = r4.readInt()
            r3.<init>(r0, r1, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.e.<init>(android.os.Parcel):void");
    }

    public final Intent a() {
        return this.f326d;
    }

    public final int b() {
        return this.f327f;
    }

    public final int c() {
        return this.f328g;
    }

    public final IntentSender d() {
        return this.f325c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        k.e(dest, "dest");
        dest.writeParcelable(this.f325c, i3);
        dest.writeParcelable(this.f326d, i3);
        dest.writeInt(this.f327f);
        dest.writeInt(this.f328g);
    }
}
