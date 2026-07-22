package s2;

import h2.a0;
import java.util.NoSuchElementException;

/* loaded from: /root/release/classes.dex */
public final class b extends a0 {

    /* renamed from: c, reason: collision with root package name */
    private final int f4109c;

    /* renamed from: d, reason: collision with root package name */
    private final int f4110d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f4111f;

    /* renamed from: g, reason: collision with root package name */
    private int f4112g;

    public b(int i3, int i4, int i5) {
        this.f4109c = i5;
        this.f4110d = i4;
        boolean z3 = true;
        if (i5 <= 0 ? i3 < i4 : i3 > i4) {
            z3 = false;
        }
        this.f4111f = z3;
        this.f4112g = z3 ? i3 : i4;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f4111f;
    }

    @Override // h2.a0
    public int nextInt() {
        int i3 = this.f4112g;
        if (i3 != this.f4110d) {
            this.f4112g = this.f4109c + i3;
        } else {
            if (!this.f4111f) {
                throw new NoSuchElementException();
            }
            this.f4111f = false;
        }
        return i3;
    }
}
