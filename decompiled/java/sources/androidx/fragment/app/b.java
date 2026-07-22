package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.f0;
import androidx.lifecycle.e;
import java.util.ArrayList;

/* loaded from: /root/release/classes.dex */
final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    final int[] f963c;

    /* renamed from: d, reason: collision with root package name */
    final ArrayList<String> f964d;

    /* renamed from: f, reason: collision with root package name */
    final int[] f965f;

    /* renamed from: g, reason: collision with root package name */
    final int[] f966g;

    /* renamed from: h, reason: collision with root package name */
    final int f967h;

    /* renamed from: i, reason: collision with root package name */
    final String f968i;

    /* renamed from: j, reason: collision with root package name */
    final int f969j;

    /* renamed from: k, reason: collision with root package name */
    final int f970k;

    /* renamed from: l, reason: collision with root package name */
    final CharSequence f971l;

    /* renamed from: m, reason: collision with root package name */
    final int f972m;

    /* renamed from: n, reason: collision with root package name */
    final CharSequence f973n;

    /* renamed from: o, reason: collision with root package name */
    final ArrayList<String> f974o;

    /* renamed from: p, reason: collision with root package name */
    final ArrayList<String> f975p;

    /* renamed from: q, reason: collision with root package name */
    final boolean f976q;

    class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i3) {
            return new b[i3];
        }
    }

    b(Parcel parcel) {
        this.f963c = parcel.createIntArray();
        this.f964d = parcel.createStringArrayList();
        this.f965f = parcel.createIntArray();
        this.f966g = parcel.createIntArray();
        this.f967h = parcel.readInt();
        this.f968i = parcel.readString();
        this.f969j = parcel.readInt();
        this.f970k = parcel.readInt();
        this.f971l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f972m = parcel.readInt();
        this.f973n = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f974o = parcel.createStringArrayList();
        this.f975p = parcel.createStringArrayList();
        this.f976q = parcel.readInt() != 0;
    }

    b(androidx.fragment.app.a aVar) {
        int size = aVar.f1059c.size();
        this.f963c = new int[size * 6];
        if (!aVar.f1065i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f964d = new ArrayList<>(size);
        this.f965f = new int[size];
        this.f966g = new int[size];
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            f0.a aVar2 = aVar.f1059c.get(i3);
            int i5 = i4 + 1;
            this.f963c[i4] = aVar2.f1076a;
            ArrayList<String> arrayList = this.f964d;
            Fragment fragment = aVar2.f1077b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f963c;
            int i6 = i5 + 1;
            iArr[i5] = aVar2.f1078c ? 1 : 0;
            int i7 = i6 + 1;
            iArr[i6] = aVar2.f1079d;
            int i8 = i7 + 1;
            iArr[i7] = aVar2.f1080e;
            int i9 = i8 + 1;
            iArr[i8] = aVar2.f1081f;
            iArr[i9] = aVar2.f1082g;
            this.f965f[i3] = aVar2.f1083h.ordinal();
            this.f966g[i3] = aVar2.f1084i.ordinal();
            i3++;
            i4 = i9 + 1;
        }
        this.f967h = aVar.f1064h;
        this.f968i = aVar.f1067k;
        this.f969j = aVar.f961v;
        this.f970k = aVar.f1068l;
        this.f971l = aVar.f1069m;
        this.f972m = aVar.f1070n;
        this.f973n = aVar.f1071o;
        this.f974o = aVar.f1072p;
        this.f975p = aVar.f1073q;
        this.f976q = aVar.f1074r;
    }

    private void a(androidx.fragment.app.a aVar) {
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z3 = true;
            if (i3 >= this.f963c.length) {
                aVar.f1064h = this.f967h;
                aVar.f1067k = this.f968i;
                aVar.f1065i = true;
                aVar.f1068l = this.f970k;
                aVar.f1069m = this.f971l;
                aVar.f1070n = this.f972m;
                aVar.f1071o = this.f973n;
                aVar.f1072p = this.f974o;
                aVar.f1073q = this.f975p;
                aVar.f1074r = this.f976q;
                return;
            }
            f0.a aVar2 = new f0.a();
            int i5 = i3 + 1;
            aVar2.f1076a = this.f963c[i3];
            if (w.I0(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i4 + " base fragment #" + this.f963c[i5]);
            }
            aVar2.f1083h = e.b.values()[this.f965f[i4]];
            aVar2.f1084i = e.b.values()[this.f966g[i4]];
            int[] iArr = this.f963c;
            int i6 = i5 + 1;
            if (iArr[i5] == 0) {
                z3 = false;
            }
            aVar2.f1078c = z3;
            int i7 = i6 + 1;
            int i8 = iArr[i6];
            aVar2.f1079d = i8;
            int i9 = i7 + 1;
            int i10 = iArr[i7];
            aVar2.f1080e = i10;
            int i11 = i9 + 1;
            int i12 = iArr[i9];
            aVar2.f1081f = i12;
            int i13 = iArr[i11];
            aVar2.f1082g = i13;
            aVar.f1060d = i8;
            aVar.f1061e = i10;
            aVar.f1062f = i12;
            aVar.f1063g = i13;
            aVar.e(aVar2);
            i4++;
            i3 = i11 + 1;
        }
    }

    public androidx.fragment.app.a b(w wVar) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(wVar);
        a(aVar);
        aVar.f961v = this.f969j;
        for (int i3 = 0; i3 < this.f964d.size(); i3++) {
            String str = this.f964d.get(i3);
            if (str != null) {
                aVar.f1059c.get(i3).f1077b = wVar.g0(str);
            }
        }
        aVar.n(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeIntArray(this.f963c);
        parcel.writeStringList(this.f964d);
        parcel.writeIntArray(this.f965f);
        parcel.writeIntArray(this.f966g);
        parcel.writeInt(this.f967h);
        parcel.writeString(this.f968i);
        parcel.writeInt(this.f969j);
        parcel.writeInt(this.f970k);
        TextUtils.writeToParcel(this.f971l, parcel, 0);
        parcel.writeInt(this.f972m);
        TextUtils.writeToParcel(this.f973n, parcel, 0);
        parcel.writeStringList(this.f974o);
        parcel.writeStringList(this.f975p);
        parcel.writeInt(this.f976q ? 1 : 0);
    }
}
