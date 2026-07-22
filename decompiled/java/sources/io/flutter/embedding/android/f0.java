package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /root/release/classes.dex */
public final class f0 {

    /* renamed from: c, reason: collision with root package name */
    private static f0 f2773c;

    /* renamed from: a, reason: collision with root package name */
    private final LongSparseArray<MotionEvent> f2774a = new LongSparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private final PriorityQueue<Long> f2775b = new PriorityQueue<>();

    public static class a {

        /* renamed from: b, reason: collision with root package name */
        private static final AtomicLong f2776b = new AtomicLong(0);

        /* renamed from: a, reason: collision with root package name */
        private final long f2777a;

        private a(long j3) {
            this.f2777a = j3;
        }

        public static a b() {
            return c(f2776b.incrementAndGet());
        }

        public static a c(long j3) {
            return new a(j3);
        }

        public long d() {
            return this.f2777a;
        }
    }

    private f0() {
    }

    public static f0 a() {
        if (f2773c == null) {
            f2773c = new f0();
        }
        return f2773c;
    }

    public MotionEvent b(a aVar) {
        while (!this.f2775b.isEmpty() && this.f2775b.peek().longValue() < aVar.f2777a) {
            this.f2774a.remove(this.f2775b.poll().longValue());
        }
        if (!this.f2775b.isEmpty() && this.f2775b.peek().longValue() == aVar.f2777a) {
            this.f2775b.poll();
        }
        MotionEvent motionEvent = this.f2774a.get(aVar.f2777a);
        this.f2774a.remove(aVar.f2777a);
        return motionEvent;
    }

    public a c(MotionEvent motionEvent) {
        a b4 = a.b();
        this.f2774a.put(b4.f2777a, MotionEvent.obtain(motionEvent));
        this.f2775b.add(Long.valueOf(b4.f2777a));
        return b4;
    }
}
