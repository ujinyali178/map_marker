package j2;

import g2.l;
import g2.q;
import i2.g;
import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.j;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import p2.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes.dex */
public class c {

    public static final class a extends j {

        /* renamed from: c, reason: collision with root package name */
        private int f3693c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ p f3694d;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f3695f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i2.d dVar, p pVar, Object obj) {
            super(dVar);
            this.f3694d = pVar;
            this.f3695f = obj;
            k.c(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        protected Object invokeSuspend(Object obj) {
            int i3 = this.f3693c;
            if (i3 == 0) {
                this.f3693c = 1;
                l.b(obj);
                k.c(this.f3694d, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) t.a(this.f3694d, 2)).invoke(this.f3695f, this);
            }
            if (i3 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f3693c = 2;
            l.b(obj);
            return obj;
        }
    }

    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: c, reason: collision with root package name */
        private int f3696c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ p f3697d;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f3698f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i2.d dVar, g gVar, p pVar, Object obj) {
            super(dVar, gVar);
            this.f3697d = pVar;
            this.f3698f = obj;
            k.c(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        protected Object invokeSuspend(Object obj) {
            int i3 = this.f3696c;
            if (i3 == 0) {
                this.f3696c = 1;
                l.b(obj);
                k.c(this.f3697d, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) t.a(this.f3697d, 2)).invoke(this.f3698f, this);
            }
            if (i3 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f3696c = 2;
            l.b(obj);
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, T> i2.d<q> a(p<? super R, ? super i2.d<? super T>, ? extends Object> pVar, R r3, i2.d<? super T> completion) {
        k.e(pVar, "<this>");
        k.e(completion, "completion");
        i2.d<?> a4 = h.a(completion);
        if (pVar instanceof kotlin.coroutines.jvm.internal.a) {
            return ((kotlin.coroutines.jvm.internal.a) pVar).create(r3, a4);
        }
        g context = a4.getContext();
        return context == i2.h.f2693c ? new a(a4, pVar, r3) : new b(a4, context, pVar, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> i2.d<T> b(i2.d<? super T> dVar) {
        i2.d<T> dVar2;
        k.e(dVar, "<this>");
        kotlin.coroutines.jvm.internal.d dVar3 = dVar instanceof kotlin.coroutines.jvm.internal.d ? (kotlin.coroutines.jvm.internal.d) dVar : null;
        return (dVar3 == null || (dVar2 = (i2.d<T>) dVar3.intercepted()) == null) ? dVar : dVar2;
    }
}
