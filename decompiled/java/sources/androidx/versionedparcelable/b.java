package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* loaded from: /root/release/classes.dex */
class b extends a {

    /* renamed from: d, reason: collision with root package name */
    private final SparseIntArray f1496d;

    /* renamed from: e, reason: collision with root package name */
    private final Parcel f1497e;

    /* renamed from: f, reason: collision with root package name */
    private final int f1498f;

    /* renamed from: g, reason: collision with root package name */
    private final int f1499g;

    /* renamed from: h, reason: collision with root package name */
    private final String f1500h;

    /* renamed from: i, reason: collision with root package name */
    private int f1501i;

    /* renamed from: j, reason: collision with root package name */
    private int f1502j;

    /* renamed from: k, reason: collision with root package name */
    private int f1503k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new androidx.collection.a(), new androidx.collection.a(), new androidx.collection.a());
    }

    private b(Parcel parcel, int i3, int i4, String str, androidx.collection.a<String, Method> aVar, androidx.collection.a<String, Method> aVar2, androidx.collection.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f1496d = new SparseIntArray();
        this.f1501i = -1;
        this.f1503k = -1;
        this.f1497e = parcel;
        this.f1498f = i3;
        this.f1499g = i4;
        this.f1502j = i3;
        this.f1500h = str;
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f1497e.writeInt(-1);
        } else {
            this.f1497e.writeInt(bArr.length);
            this.f1497e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f1497e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i3) {
        this.f1497e.writeInt(i3);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.f1497e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.f1497e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i3 = this.f1501i;
        if (i3 >= 0) {
            int i4 = this.f1496d.get(i3);
            int dataPosition = this.f1497e.dataPosition();
            this.f1497e.setDataPosition(i4);
            this.f1497e.writeInt(dataPosition - i4);
            this.f1497e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.f1497e;
        int dataPosition = parcel.dataPosition();
        int i3 = this.f1502j;
        if (i3 == this.f1498f) {
            i3 = this.f1499g;
        }
        return new b(parcel, dataPosition, i3, this.f1500h + "  ", this.f1493a, this.f1494b, this.f1495c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.f1497e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int readInt = this.f1497e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f1497e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f1497e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i3) {
        while (this.f1502j < this.f1499g) {
            int i4 = this.f1503k;
            if (i4 == i3) {
                return true;
            }
            if (String.valueOf(i4).compareTo(String.valueOf(i3)) > 0) {
                return false;
            }
            this.f1497e.setDataPosition(this.f1502j);
            int readInt = this.f1497e.readInt();
            this.f1503k = this.f1497e.readInt();
            this.f1502j += readInt;
        }
        return this.f1503k == i3;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.f1497e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public <T extends Parcelable> T q() {
        return (T) this.f1497e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.f1497e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i3) {
        a();
        this.f1501i = i3;
        this.f1496d.put(i3, this.f1497e.dataPosition());
        E(0);
        E(i3);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z3) {
        this.f1497e.writeInt(z3 ? 1 : 0);
    }
}
