package z1;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import m1.a;
import u1.n;
import z1.c;
import z1.e;
import z1.n;

/* loaded from: /root/release/classes.dex */
public class e implements m1.a, n1.a {

    /* renamed from: c, reason: collision with root package name */
    private b f4833c;

    /* renamed from: d, reason: collision with root package name */
    private u1.d f4834d;

    /* renamed from: f, reason: collision with root package name */
    private n1.c f4835f;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4836a;

        static {
            int[] iArr = new int[n.f.values().length];
            f4836a = iArr;
            try {
                iArr[n.f.GAMES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4836a[n.f.STANDARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class b implements n.a, n.b {

        /* renamed from: c, reason: collision with root package name */
        private final Context f4837c;

        /* renamed from: d, reason: collision with root package name */
        private n.c f4838d;

        /* renamed from: f, reason: collision with root package name */
        private Activity f4839f;

        /* renamed from: g, reason: collision with root package name */
        private final c f4840g = new c(1);

        /* renamed from: h, reason: collision with root package name */
        private final m f4841h;

        /* renamed from: i, reason: collision with root package name */
        private GoogleSignInClient f4842i;

        /* renamed from: j, reason: collision with root package name */
        private List<String> f4843j;

        /* renamed from: k, reason: collision with root package name */
        private a f4844k;

        private static class a {

            /* renamed from: a, reason: collision with root package name */
            final String f4845a;

            /* renamed from: b, reason: collision with root package name */
            final n.e<n.g> f4846b;

            /* renamed from: c, reason: collision with root package name */
            final n.e<Void> f4847c;

            /* renamed from: d, reason: collision with root package name */
            final n.e<Boolean> f4848d;

            /* renamed from: e, reason: collision with root package name */
            final n.e<String> f4849e;

            /* renamed from: f, reason: collision with root package name */
            final Object f4850f;

            a(String str, n.e<n.g> eVar, n.e<Void> eVar2, n.e<Boolean> eVar3, n.e<String> eVar4, Object obj) {
                this.f4845a = str;
                this.f4846b = eVar;
                this.f4847c = eVar2;
                this.f4848d = eVar3;
                this.f4849e = eVar4;
                this.f4850f = obj;
            }
        }

        public b(Context context, m mVar) {
            this.f4837c = context;
            this.f4841h = mVar;
        }

        private void A() {
            n.e<Void> eVar = this.f4844k.f4847c;
            Objects.requireNonNull(eVar);
            eVar.a(null);
            this.f4844k = null;
        }

        private void B(n.g gVar) {
            n.e<n.g> eVar = this.f4844k.f4846b;
            Objects.requireNonNull(eVar);
            eVar.a(gVar);
            this.f4844k = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Void E(String str) {
            GoogleAuthUtil.clearToken(this.f4837c, str);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void F(n.e eVar, Future future) {
            try {
                eVar.a((Void) future.get());
            } catch (InterruptedException e3) {
                eVar.b(new n.a("exception", e3.getMessage(), null));
                Thread.currentThread().interrupt();
            } catch (ExecutionException e4) {
                Throwable cause = e4.getCause();
                eVar.b(new n.a("exception", cause == null ? null : cause.getMessage(), null));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void G(Task task) {
            if (task.isSuccessful()) {
                A();
            } else {
                z("status", "Failed to disconnect.");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ String H(String str) {
            return GoogleAuthUtil.getToken(this.f4837c, new Account(str, "com.google"), "oauth2:" + Joiner.on(' ').join(this.f4843j));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void I(n.e eVar, Boolean bool, String str, Future future) {
            n.a aVar;
            try {
                eVar.a((String) future.get());
            } catch (InterruptedException e3) {
                eVar.b(new n.a("exception", e3.getMessage(), null));
                Thread.currentThread().interrupt();
            } catch (ExecutionException e4) {
                if (!(e4.getCause() instanceof UserRecoverableAuthException)) {
                    Throwable cause = e4.getCause();
                    eVar.b(new n.a("exception", cause == null ? null : cause.getMessage(), null));
                    return;
                }
                if (bool.booleanValue() && this.f4844k == null) {
                    Activity D = D();
                    if (D != null) {
                        r("getTokens", eVar, str);
                        D.startActivityForResult(((UserRecoverableAuthException) e4.getCause()).getIntent(), 53294);
                        return;
                    } else {
                        aVar = new n.a("user_recoverable_auth", "Cannot recover auth because app is not in foreground. " + e4.getLocalizedMessage(), null);
                    }
                } else {
                    aVar = new n.a("user_recoverable_auth", e4.getLocalizedMessage(), null);
                }
                eVar.b(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void J(Task task) {
            if (task.isSuccessful()) {
                A();
            } else {
                z("status", "Failed to signout.");
            }
        }

        private void K(GoogleSignInAccount googleSignInAccount) {
            n.g.a b4 = new n.g.a().c(googleSignInAccount.getEmail()).d(googleSignInAccount.getId()).e(googleSignInAccount.getIdToken()).g(googleSignInAccount.getServerAuthCode()).b(googleSignInAccount.getDisplayName());
            if (googleSignInAccount.getPhotoUrl() != null) {
                b4.f(googleSignInAccount.getPhotoUrl().toString());
            }
            B(b4.a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void L(Task<GoogleSignInAccount> task) {
            String obj;
            String str;
            try {
                K(task.getResult(ApiException.class));
            } catch (ApiException e3) {
                str = x(e3.getStatusCode());
                obj = e3.toString();
                z(str, obj);
            } catch (RuntimeExecutionException e4) {
                obj = e4.toString();
                str = "exception";
                z(str, obj);
            }
        }

        private void r(String str, n.e<String> eVar, Object obj) {
            v(str, eVar, obj);
        }

        private void s(String str, n.e<Boolean> eVar) {
            t(str, null, null, eVar, null, null);
        }

        private void t(String str, n.e<n.g> eVar, n.e<Void> eVar2, n.e<Boolean> eVar3, n.e<String> eVar4, Object obj) {
            if (this.f4844k == null) {
                this.f4844k = new a(str, eVar, eVar2, eVar3, eVar4, obj);
                return;
            }
            throw new IllegalStateException("Concurrent operations detected: " + this.f4844k.f4845a + ", " + str);
        }

        private void u(String str, n.e<n.g> eVar) {
            t(str, eVar, null, null, null, null);
        }

        private void v(String str, n.e<String> eVar, Object obj) {
            t(str, null, null, null, eVar, obj);
        }

        private void w(String str, n.e<Void> eVar) {
            t(str, null, eVar, null, null, null);
        }

        private String x(int i3) {
            return i3 != 4 ? i3 != 7 ? i3 != 12501 ? "sign_in_failed" : "sign_in_canceled" : "network_error" : "sign_in_required";
        }

        private void y(Boolean bool) {
            n.e<Boolean> eVar = this.f4844k.f4848d;
            Objects.requireNonNull(eVar);
            eVar.a(bool);
            this.f4844k = null;
        }

        private void z(String str, String str2) {
            a aVar = this.f4844k;
            n.e eVar = aVar.f4846b;
            if (eVar == null && (eVar = aVar.f4848d) == null && (eVar = aVar.f4849e) == null) {
                eVar = aVar.f4847c;
            }
            Objects.requireNonNull(eVar);
            eVar.b(new n.a(str, str2, null));
            this.f4844k = null;
        }

        public Activity D() {
            n.c cVar = this.f4838d;
            return cVar != null ? cVar.c() : this.f4839f;
        }

        public void M(Activity activity) {
            this.f4839f = activity;
        }

        @Override // u1.n.a
        public boolean a(int i3, int i4, Intent intent) {
            a aVar = this.f4844k;
            if (aVar == null) {
                return false;
            }
            switch (i3) {
                case 53293:
                    if (intent == null) {
                        z("sign_in_failed", "Signin failed");
                        break;
                    } else {
                        L(GoogleSignIn.getSignedInAccountFromIntent(intent));
                        break;
                    }
                case 53294:
                    if (i4 != -1) {
                        z("failed_to_recover_auth", "Failed attempt to recover authentication");
                        break;
                    } else {
                        n.e<String> eVar = aVar.f4849e;
                        Objects.requireNonNull(eVar);
                        Object obj = this.f4844k.f4850f;
                        Objects.requireNonNull(obj);
                        this.f4844k = null;
                        g((String) obj, Boolean.FALSE, eVar);
                        break;
                    }
                case 53295:
                    y(Boolean.valueOf(i4 == -1));
                    break;
            }
            return false;
        }

        @Override // z1.n.b
        public void b(List<String> list, n.e<Boolean> eVar) {
            s("requestScopes", eVar);
            GoogleSignInAccount b4 = this.f4841h.b(this.f4837c);
            if (b4 == null) {
                z("sign_in_required", "No account to grant scopes.");
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                Scope scope = new Scope(it.next());
                if (!this.f4841h.c(b4, scope)) {
                    arrayList.add(scope);
                }
            }
            if (arrayList.isEmpty()) {
                y(Boolean.TRUE);
            } else {
                this.f4841h.d(D(), 53295, b4, (Scope[]) arrayList.toArray(new Scope[0]));
            }
        }

        @Override // z1.n.b
        public void c(final String str, final n.e<Void> eVar) {
            this.f4840g.f(new Callable() { // from class: z1.j
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Void E;
                    E = e.b.this.E(str);
                    return E;
                }
            }, new c.a() { // from class: z1.k
                @Override // z1.c.a
                public final void a(Future future) {
                    e.b.F(n.e.this, future);
                }
            });
        }

        @Override // z1.n.b
        public void d(n.e<Void> eVar) {
            w("disconnect", eVar);
            this.f4842i.revokeAccess().addOnCompleteListener(new OnCompleteListener() { // from class: z1.i
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    e.b.this.G(task);
                }
            });
        }

        @Override // z1.n.b
        public Boolean e() {
            return Boolean.valueOf(GoogleSignIn.getLastSignedInAccount(this.f4837c) != null);
        }

        @Override // z1.n.b
        public void f(n.e<n.g> eVar) {
            u("signInSilently", eVar);
            Task<GoogleSignInAccount> silentSignIn = this.f4842i.silentSignIn();
            if (silentSignIn.isComplete()) {
                L(silentSignIn);
            } else {
                silentSignIn.addOnCompleteListener(new OnCompleteListener() { // from class: z1.l
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        e.b.this.L(task);
                    }
                });
            }
        }

        @Override // z1.n.b
        public void g(final String str, final Boolean bool, final n.e<String> eVar) {
            this.f4840g.f(new Callable() { // from class: z1.f
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    String H;
                    H = e.b.this.H(str);
                    return H;
                }
            }, new c.a() { // from class: z1.g
                @Override // z1.c.a
                public final void a(Future future) {
                    e.b.this.I(eVar, bool, str, future);
                }
            });
        }

        @Override // z1.n.b
        public void h(n.e<Void> eVar) {
            w("signOut", eVar);
            this.f4842i.signOut().addOnCompleteListener(new OnCompleteListener() { // from class: z1.h
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    e.b.this.J(task);
                }
            });
        }

        @Override // z1.n.b
        public void i(n.e<n.g> eVar) {
            if (D() == null) {
                throw new IllegalStateException("signIn needs a foreground activity");
            }
            u("signIn", eVar);
            D().startActivityForResult(this.f4842i.getSignInIntent(), 53293);
        }

        @Override // z1.n.b
        public void j(n.d dVar) {
            GoogleSignInOptions.Builder builder;
            int identifier;
            try {
                int i3 = a.f4836a[dVar.g().ordinal()];
                if (i3 == 1) {
                    builder = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN);
                } else {
                    if (i3 != 2) {
                        throw new IllegalStateException("Unknown signInOption");
                    }
                    builder = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail();
                }
                String f3 = dVar.f();
                if (!Strings.isNullOrEmpty(dVar.b()) && Strings.isNullOrEmpty(f3)) {
                    Log.w("google_sign_in", "clientId is not supported on Android and is interpreted as serverClientId. Use serverClientId instead to suppress this warning.");
                    f3 = dVar.b();
                }
                if (Strings.isNullOrEmpty(f3) && (identifier = this.f4837c.getResources().getIdentifier("default_web_client_id", "string", this.f4837c.getPackageName())) != 0) {
                    f3 = this.f4837c.getString(identifier);
                }
                if (!Strings.isNullOrEmpty(f3)) {
                    builder.requestIdToken(f3);
                    builder.requestServerAuthCode(f3, dVar.c().booleanValue());
                }
                List<String> e3 = dVar.e();
                this.f4843j = e3;
                Iterator<String> it = e3.iterator();
                while (it.hasNext()) {
                    builder.requestScopes(new Scope(it.next()), new Scope[0]);
                }
                if (!Strings.isNullOrEmpty(dVar.d())) {
                    builder.setHostedDomain(dVar.d());
                }
                this.f4842i = this.f4841h.a(this.f4837c, builder.build());
            } catch (Exception e4) {
                throw new n.a("exception", e4.getMessage(), null);
            }
        }
    }

    private void a(n1.c cVar) {
        this.f4835f = cVar;
        cVar.a(this.f4833c);
        this.f4833c.M(cVar.i());
    }

    private void c() {
        this.f4833c = null;
        u1.d dVar = this.f4834d;
        if (dVar != null) {
            x.k(dVar, null);
            this.f4834d = null;
        }
    }

    private void f() {
        this.f4835f.d(this.f4833c);
        this.f4833c.M(null);
        this.f4835f = null;
    }

    @Override // m1.a
    public void b(a.b bVar) {
        g(bVar.b(), bVar.a(), new m());
    }

    @Override // n1.a
    public void d(n1.c cVar) {
        a(cVar);
    }

    @Override // m1.a
    public void e(a.b bVar) {
        c();
    }

    public void g(u1.d dVar, Context context, m mVar) {
        this.f4834d = dVar;
        b bVar = new b(context, mVar);
        this.f4833c = bVar;
        x.k(dVar, bVar);
    }

    @Override // n1.a
    public void h() {
        f();
    }

    @Override // n1.a
    public void i() {
        f();
    }

    @Override // n1.a
    public void j(n1.c cVar) {
        a(cVar);
    }
}
