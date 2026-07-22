package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /root/release/classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0003a();

    /* renamed from: c, reason: collision with root package name */
    private final int f322c;

    /* renamed from: d, reason: collision with root package name */
    private final Intent f323d;

    /* renamed from: androidx.activity.result.a$a, reason: collision with other inner class name */
    class C0003a implements Parcelable.Creator<a> {
        C0003a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
        }
    }

    public a(int i3, Intent intent) {
        this.f322c = i3;
        this.f323d = intent;
    }

    a(Parcel parcel) {
        this.f322c = parcel.readInt();
        this.f323d = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }

    public static String c(int i3) {
        return i3 != -1 ? i3 != 0 ? String.valueOf(i3) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public Intent a() {
        return this.f323d;
    }

    public int b() {
        return this.f322c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + c(this.f322c) + ", data=" + this.f323d + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f322c);
        parcel.writeInt(this.f323d == null ? 0 : 1);
        Intent intent = this.f323d;
        if (intent != null) {
            intent.writeToParcel(parcel, i3);
        }
    }
}
