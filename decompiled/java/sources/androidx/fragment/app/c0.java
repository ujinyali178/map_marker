package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.e;

/* loaded from: /root/release/classes.dex */
final class c0 implements Parcelable {
    public static final Parcelable.Creator<c0> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    final String f979c;

    /* renamed from: d, reason: collision with root package name */
    final String f980d;

    /* renamed from: f, reason: collision with root package name */
    final boolean f981f;

    /* renamed from: g, reason: collision with root package name */
    final int f982g;

    /* renamed from: h, reason: collision with root package name */
    final int f983h;

    /* renamed from: i, reason: collision with root package name */
    final String f984i;

    /* renamed from: j, reason: collision with root package name */
    final boolean f985j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f986k;

    /* renamed from: l, reason: collision with root package name */
    final boolean f987l;

    /* renamed from: m, reason: collision with root package name */
    final Bundle f988m;

    /* renamed from: n, reason: collision with root package name */
    final boolean f989n;

    /* renamed from: o, reason: collision with root package name */
    final int f990o;

    /* renamed from: p, reason: collision with root package name */
    Bundle f991p;

    class a implements Parcelable.Creator<c0> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c0 createFromParcel(Parcel parcel) {
            return new c0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c0[] newArray(int i3) {
            return new c0[i3];
        }
    }

    c0(Parcel parcel) {
        this.f979c = parcel.readString();
        this.f980d = parcel.readString();
        this.f981f = parcel.readInt() != 0;
        this.f982g = parcel.readInt();
        this.f983h = parcel.readInt();
        this.f984i = parcel.readString();
        this.f985j = parcel.readInt() != 0;
        this.f986k = parcel.readInt() != 0;
        this.f987l = parcel.readInt() != 0;
        this.f988m = parcel.readBundle();
        this.f989n = parcel.readInt() != 0;
        this.f991p = parcel.readBundle();
        this.f990o = parcel.readInt();
    }

    c0(Fragment fragment) {
        this.f979c = fragment.getClass().getName();
        this.f980d = fragment.mWho;
        this.f981f = fragment.mFromLayout;
        this.f982g = fragment.mFragmentId;
        this.f983h = fragment.mContainerId;
        this.f984i = fragment.mTag;
        this.f985j = fragment.mRetainInstance;
        this.f986k = fragment.mRemoving;
        this.f987l = fragment.mDetached;
        this.f988m = fragment.mArguments;
        this.f989n = fragment.mHidden;
        this.f990o = fragment.mMaxState.ordinal();
    }

    Fragment a(n nVar, ClassLoader classLoader) {
        Fragment a4 = nVar.a(classLoader, this.f979c);
        Bundle bundle = this.f988m;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a4.setArguments(this.f988m);
        a4.mWho = this.f980d;
        a4.mFromLayout = this.f981f;
        a4.mRestored = true;
        a4.mFragmentId = this.f982g;
        a4.mContainerId = this.f983h;
        a4.mTag = this.f984i;
        a4.mRetainInstance = this.f985j;
        a4.mRemoving = this.f986k;
        a4.mDetached = this.f987l;
        a4.mHidden = this.f989n;
        a4.mMaxState = e.b.values()[this.f990o];
        Bundle bundle2 = this.f991p;
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        a4.mSavedFragmentState = bundle2;
        return a4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f979c);
        sb.append(" (");
        sb.append(this.f980d);
        sb.append(")}:");
        if (this.f981f) {
            sb.append(" fromLayout");
        }
        if (this.f983h != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f983h));
        }
        String str = this.f984i;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f984i);
        }
        if (this.f985j) {
            sb.append(" retainInstance");
        }
        if (this.f986k) {
            sb.append(" removing");
        }
        if (this.f987l) {
            sb.append(" detached");
        }
        if (this.f989n) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f979c);
        parcel.writeString(this.f980d);
        parcel.writeInt(this.f981f ? 1 : 0);
        parcel.writeInt(this.f982g);
        parcel.writeInt(this.f983h);
        parcel.writeString(this.f984i);
        parcel.writeInt(this.f985j ? 1 : 0);
        parcel.writeInt(this.f986k ? 1 : 0);
        parcel.writeInt(this.f987l ? 1 : 0);
        parcel.writeBundle(this.f988m);
        parcel.writeInt(this.f989n ? 1 : 0);
        parcel.writeBundle(this.f991p);
        parcel.writeInt(this.f990o);
    }
}
