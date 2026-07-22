package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /root/release/classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private final t.a f1492c;

    static class a implements Parcelable.Creator<ParcelImpl> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelImpl[] newArray(int i3) {
            return new ParcelImpl[i3];
        }
    }

    protected ParcelImpl(Parcel parcel) {
        this.f1492c = new b(parcel).u();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        new b(parcel).L(this.f1492c);
    }
}
