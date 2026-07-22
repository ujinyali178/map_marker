package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.d0;
import io.flutter.embedding.android.e0;
import io.flutter.embedding.android.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import u1.d;

/* loaded from: /root/release/classes.dex */
public class c0 implements d0.d {

    /* renamed from: a, reason: collision with root package name */
    private final u1.d f2731a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<Long, Long> f2732b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<Long, e0.e> f2733c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final d0.b f2734d = new d0.b();

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2735a;

        static {
            int[] iArr = new int[y.b.values().length];
            f2735a = iArr;
            try {
                iArr[y.b.kDown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2735a[y.b.kUp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2735a[y.b.kRepeat.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public c0(u1.d dVar) {
        this.f2731a = dVar;
        for (e0.e eVar : e0.a()) {
            this.f2733c.put(Long.valueOf(eVar.f2756c), eVar);
        }
    }

    private static y.b e(KeyEvent keyEvent) {
        boolean z3 = keyEvent.getRepeatCount() > 0;
        int action = keyEvent.getAction();
        if (action == 0) {
            return z3 ? y.b.kRepeat : y.b.kDown;
        }
        if (action == 1) {
            return y.b.kUp;
        }
        throw new AssertionError("Unexpected event type");
    }

    private Long f(KeyEvent keyEvent) {
        Long l3 = e0.f2748b.get(Long.valueOf(keyEvent.getKeyCode()));
        return l3 != null ? l3 : Long.valueOf(j(keyEvent.getKeyCode(), 73014444032L));
    }

    private Long g(KeyEvent keyEvent) {
        int scanCode;
        long scanCode2 = keyEvent.getScanCode();
        if (scanCode2 == 0) {
            scanCode = keyEvent.getKeyCode();
        } else {
            Long l3 = e0.f2747a.get(Long.valueOf(scanCode2));
            if (l3 != null) {
                return l3;
            }
            scanCode = keyEvent.getScanCode();
        }
        return Long.valueOf(j(scanCode, 73014444032L));
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0144 A[LOOP:2: B:62:0x013e->B:64:0x0144, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean i(android.view.KeyEvent r18, io.flutter.embedding.android.d0.d.a r19) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.c0.i(android.view.KeyEvent, io.flutter.embedding.android.d0$d$a):boolean");
    }

    private static long j(long j3, long j4) {
        return (j3 & 4294967295L) | j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(d0.d.a aVar, ByteBuffer byteBuffer) {
        Boolean bool = Boolean.FALSE;
        if (byteBuffer != null) {
            byteBuffer.rewind();
            if (byteBuffer.capacity() != 0) {
                bool = Boolean.valueOf(byteBuffer.get() != 0);
            }
        } else {
            g1.b.g("KeyEmbedderResponder", "A null reply was received when sending a key event to the framework.");
        }
        aVar.a(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(e0.c cVar, long j3, KeyEvent keyEvent) {
        q(false, Long.valueOf(cVar.f2751b), Long.valueOf(j3), keyEvent.getEventTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(e0.c cVar, KeyEvent keyEvent) {
        q(false, Long.valueOf(cVar.f2751b), Long.valueOf(cVar.f2750a), keyEvent.getEventTime());
    }

    private void n(y yVar, final d0.d.a aVar) {
        this.f2731a.i("flutter/keydata", yVar.a(), aVar == null ? null : new d.b() { // from class: io.flutter.embedding.android.z
            @Override // u1.d.b
            public final void a(ByteBuffer byteBuffer) {
                c0.k(d0.d.a.this, byteBuffer);
            }
        });
    }

    private void q(boolean z3, Long l3, Long l4, long j3) {
        y yVar = new y();
        yVar.f2890a = j3;
        yVar.f2891b = z3 ? y.b.kDown : y.b.kUp;
        yVar.f2893d = l3.longValue();
        yVar.f2892c = l4.longValue();
        yVar.f2896g = null;
        yVar.f2894e = true;
        yVar.f2895f = y.a.kKeyboard;
        if (l4.longValue() != 0 && l3.longValue() != 0) {
            if (!z3) {
                l3 = null;
            }
            r(l4, l3);
        }
        n(yVar, null);
    }

    @Override // io.flutter.embedding.android.d0.d
    public void a(KeyEvent keyEvent, d0.d.a aVar) {
        if (i(keyEvent, aVar)) {
            return;
        }
        q(true, 0L, 0L, 0L);
        aVar.a(true);
    }

    public Map<Long, Long> h() {
        return Collections.unmodifiableMap(this.f2732b);
    }

    void o(e0.d dVar, boolean z3, long j3, final long j4, final KeyEvent keyEvent, ArrayList<Runnable> arrayList) {
        e0.c[] cVarArr = dVar.f2753b;
        boolean[] zArr = new boolean[cVarArr.length];
        Boolean[] boolArr = new Boolean[cVarArr.length];
        boolean z4 = false;
        int i3 = 0;
        while (true) {
            e0.c[] cVarArr2 = dVar.f2753b;
            boolean z5 = true;
            if (i3 >= cVarArr2.length) {
                break;
            }
            final e0.c cVar = cVarArr2[i3];
            boolean containsKey = this.f2732b.containsKey(Long.valueOf(cVar.f2750a));
            zArr[i3] = containsKey;
            if (cVar.f2751b == j3) {
                int i4 = a.f2735a[e(keyEvent).ordinal()];
                if (i4 == 1) {
                    boolArr[i3] = Boolean.FALSE;
                    if (!z3) {
                        arrayList.add(new Runnable() { // from class: io.flutter.embedding.android.a0
                            @Override // java.lang.Runnable
                            public final void run() {
                                c0.this.l(cVar, j4, keyEvent);
                            }
                        });
                    }
                } else if (i4 == 2) {
                    boolArr[i3] = Boolean.valueOf(zArr[i3]);
                } else if (i4 == 3) {
                    if (!z3) {
                        arrayList.add(new Runnable() { // from class: io.flutter.embedding.android.b0
                            @Override // java.lang.Runnable
                            public final void run() {
                                c0.this.m(cVar, keyEvent);
                            }
                        });
                    }
                    boolArr[i3] = Boolean.valueOf(zArr[i3]);
                }
                z4 = true;
            } else {
                if (!z4 && !containsKey) {
                    z5 = false;
                }
                z4 = z5;
            }
            i3++;
        }
        if (z3) {
            for (int i5 = 0; i5 < dVar.f2753b.length; i5++) {
                if (boolArr[i5] == null) {
                    if (z4) {
                        boolArr[i5] = Boolean.valueOf(zArr[i5]);
                    } else {
                        boolArr[i5] = Boolean.TRUE;
                        z4 = true;
                    }
                }
            }
            if (!z4) {
                boolArr[0] = Boolean.TRUE;
            }
        } else {
            for (int i6 = 0; i6 < dVar.f2753b.length; i6++) {
                if (boolArr[i6] == null) {
                    boolArr[i6] = Boolean.FALSE;
                }
            }
        }
        for (int i7 = 0; i7 < dVar.f2753b.length; i7++) {
            if (zArr[i7] != boolArr[i7].booleanValue()) {
                e0.c cVar2 = dVar.f2753b[i7];
                q(boolArr[i7].booleanValue(), Long.valueOf(cVar2.f2751b), Long.valueOf(cVar2.f2750a), keyEvent.getEventTime());
            }
        }
    }

    void p(e0.e eVar, boolean z3, long j3, KeyEvent keyEvent) {
        if (eVar.f2756c == j3 || eVar.f2757d == z3) {
            return;
        }
        boolean z4 = !this.f2732b.containsKey(Long.valueOf(eVar.f2755b));
        if (z4) {
            eVar.f2757d = !eVar.f2757d;
        }
        q(z4, Long.valueOf(eVar.f2756c), Long.valueOf(eVar.f2755b), keyEvent.getEventTime());
        if (!z4) {
            eVar.f2757d = !eVar.f2757d;
        }
        q(!z4, Long.valueOf(eVar.f2756c), Long.valueOf(eVar.f2755b), keyEvent.getEventTime());
    }

    void r(Long l3, Long l4) {
        if (l4 != null) {
            if (this.f2732b.put(l3, l4) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (this.f2732b.remove(l3) == null) {
            throw new AssertionError("The key was empty");
        }
    }
}
