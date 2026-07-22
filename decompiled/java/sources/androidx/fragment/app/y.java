package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.w;
import java.util.ArrayList;

/* loaded from: /root/release/classes.dex */
final class y implements Parcelable {
    public static final Parcelable.Creator<y> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    ArrayList<String> f1219c;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<String> f1220d;

    /* renamed from: f, reason: collision with root package name */
    b[] f1221f;

    /* renamed from: g, reason: collision with root package name */
    int f1222g;

    /* renamed from: h, reason: collision with root package name */
    String f1223h;

    /* renamed from: i, reason: collision with root package name */
    ArrayList<String> f1224i;

    /* renamed from: j, reason: collision with root package name */
    ArrayList<c> f1225j;

    /* renamed from: k, reason: collision with root package name */
    ArrayList<w.k> f1226k;

    class a implements Parcelable.Creator<y> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public y createFromParcel(Parcel parcel) {
            return new y(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public y[] newArray(int i3) {
            return new y[i3];
        }
    }

    public y() {
        this.f1223h = null;
        this.f1224i = new ArrayList<>();
        this.f1225j = new ArrayList<>();
    }

    public y(Parcel parcel) {
        this.f1223h = null;
        this.f1224i = new ArrayList<>();
        this.f1225j = new ArrayList<>();
        this.f1219c = parcel.createStringArrayList();
        this.f1220d = parcel.createStringArrayList();
        this.f1221f = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f1222g = parcel.readInt();
        this.f1223h = parcel.readString();
        this.f1224i = parcel.createStringArrayList();
        this.f1225j = parcel.createTypedArrayList(c.CREATOR);
        this.f1226k = parcel.createTypedArrayList(w.k.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeStringList(this.f1219c);
        parcel.writeStringList(this.f1220d);
        parcel.writeTypedArray(this.f1221f, i3);
        parcel.writeInt(this.f1222g);
        parcel.writeString(this.f1223h);
        parcel.writeStringList(this.f1224i);
        parcel.writeTypedList(this.f1225j);
        parcel.writeTypedList(this.f1226k);
    }
}
