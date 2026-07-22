package v2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /root/release/classes.dex */
final class c implements u2.b<s2.c> {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f4402a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4403b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4404c;

    /* renamed from: d, reason: collision with root package name */
    private final p2.p<CharSequence, Integer, g2.j<Integer, Integer>> f4405d;

    public static final class a implements Iterator<s2.c> {

        /* renamed from: c, reason: collision with root package name */
        private int f4406c = -1;

        /* renamed from: d, reason: collision with root package name */
        private int f4407d;

        /* renamed from: f, reason: collision with root package name */
        private int f4408f;

        /* renamed from: g, reason: collision with root package name */
        private s2.c f4409g;

        /* renamed from: h, reason: collision with root package name */
        private int f4410h;

        a() {
            int e3;
            e3 = s2.f.e(c.this.f4403b, 0, c.this.f4402a.length());
            this.f4407d = e3;
            this.f4408f = e3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        
            if (r0 < r6.f4411i.f4404c) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f4408f
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f4406c = r1
                r0 = 0
                r6.f4409g = r0
                goto L99
            Lc:
                v2.c r0 = v2.c.this
                int r0 = v2.c.c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f4410h
                int r0 = r0 + r3
                r6.f4410h = r0
                v2.c r4 = v2.c.this
                int r4 = v2.c.c(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f4408f
                v2.c r4 = v2.c.this
                java.lang.CharSequence r4 = v2.c.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                s2.c r0 = new s2.c
                int r1 = r6.f4407d
                v2.c r4 = v2.c.this
                java.lang.CharSequence r4 = v2.c.b(r4)
                int r4 = v2.n.u(r4)
                r0.<init>(r1, r4)
            L42:
                r6.f4409g = r0
            L44:
                r6.f4408f = r2
                goto L97
            L47:
                v2.c r0 = v2.c.this
                p2.p r0 = v2.c.a(r0)
                v2.c r4 = v2.c.this
                java.lang.CharSequence r4 = v2.c.b(r4)
                int r5 = r6.f4408f
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                g2.j r0 = (g2.j) r0
                if (r0 != 0) goto L73
                s2.c r0 = new s2.c
                int r1 = r6.f4407d
                v2.c r4 = v2.c.this
                java.lang.CharSequence r4 = v2.c.b(r4)
                int r4 = v2.n.u(r4)
                r0.<init>(r1, r4)
                goto L42
            L73:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f4407d
                s2.c r4 = s2.d.g(r4, r2)
                r6.f4409g = r4
                int r2 = r2 + r0
                r6.f4407d = r2
                if (r0 != 0) goto L95
                r1 = 1
            L95:
                int r2 = r2 + r1
                goto L44
            L97:
                r6.f4406c = r3
            L99:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: v2.c.a.a():void");
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public s2.c next() {
            if (this.f4406c == -1) {
                a();
            }
            if (this.f4406c == 0) {
                throw new NoSuchElementException();
            }
            s2.c cVar = this.f4409g;
            kotlin.jvm.internal.k.c(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f4409g = null;
            this.f4406c = -1;
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f4406c == -1) {
                a();
            }
            return this.f4406c == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(CharSequence input, int i3, int i4, p2.p<? super CharSequence, ? super Integer, g2.j<Integer, Integer>> getNextMatch) {
        kotlin.jvm.internal.k.e(input, "input");
        kotlin.jvm.internal.k.e(getNextMatch, "getNextMatch");
        this.f4402a = input;
        this.f4403b = i3;
        this.f4404c = i4;
        this.f4405d = getNextMatch;
    }

    @Override // u2.b
    public Iterator<s2.c> iterator() {
        return new a();
    }
}
