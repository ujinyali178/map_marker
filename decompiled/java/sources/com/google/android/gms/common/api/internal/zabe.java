package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

/* loaded from: /root/release/classes.dex */
public final class zabe extends GoogleApiClient implements zabz {
    zabx zab;
    final Map zac;
    Set zad;
    final ClientSettings zae;
    final Map zaf;
    final Api.AbstractClientBuilder zag;
    Set zah;
    final zadc zai;
    private final Lock zaj;
    private final com.google.android.gms.common.internal.zak zak;
    private final int zam;
    private final Context zan;
    private final Looper zao;
    private volatile boolean zap;
    private long zaq;
    private long zar;
    private final zabc zas;
    private final GoogleApiAvailability zat;
    private final ListenerHolders zau;
    private final ArrayList zav;
    private Integer zaw;
    private final com.google.android.gms.common.internal.zaj zax;
    private zaca zal = null;
    final Queue zaa = new LinkedList();

    public zabe(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder abstractClientBuilder, Map map, List list, List list2, Map map2, int i3, int i4, ArrayList arrayList) {
        this.zaq = true != ClientLibraryUtils.isPackageSide() ? 120000L : 10000L;
        this.zar = 5000L;
        this.zad = new HashSet();
        this.zau = new ListenerHolders();
        this.zaw = null;
        this.zah = null;
        zaay zaayVar = new zaay(this);
        this.zax = zaayVar;
        this.zan = context;
        this.zaj = lock;
        this.zak = new com.google.android.gms.common.internal.zak(looper, zaayVar);
        this.zao = looper;
        this.zas = new zabc(this, looper);
        this.zat = googleApiAvailability;
        this.zam = i3;
        if (i3 >= 0) {
            this.zaw = Integer.valueOf(i4);
        }
        this.zaf = map;
        this.zac = map2;
        this.zav = arrayList;
        this.zai = new zadc();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.zak.zaf((GoogleApiClient.ConnectionCallbacks) it.next());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            this.zak.zag((GoogleApiClient.OnConnectionFailedListener) it2.next());
        }
        this.zae = clientSettings;
        this.zag = abstractClientBuilder;
    }

    public static int zad(Iterable iterable, boolean z3) {
        Iterator it = iterable.iterator();
        boolean z4 = false;
        boolean z5 = false;
        while (it.hasNext()) {
            Api.Client client = (Api.Client) it.next();
            z4 |= client.requiresSignIn();
            z5 |= client.providesSignIn();
        }
        if (z4) {
            return (z5 && z3) ? 2 : 1;
        }
        return 3;
    }

    static String zag(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    static /* bridge */ /* synthetic */ void zai(zabe zabeVar) {
        zabeVar.zaj.lock();
        try {
            if (zabeVar.zap) {
                zabeVar.zan();
            }
        } finally {
            zabeVar.zaj.unlock();
        }
    }

    static /* bridge */ /* synthetic */ void zaj(zabe zabeVar) {
        zabeVar.zaj.lock();
        try {
            if (zabeVar.zak()) {
                zabeVar.zan();
            }
        } finally {
            zabeVar.zaj.unlock();
        }
    }

    private final void zal(int i3) {
        zaca zabiVar;
        Integer num = this.zaw;
        if (num == null) {
            this.zaw = Integer.valueOf(i3);
        } else if (num.intValue() != i3) {
            throw new IllegalStateException("Cannot use sign-in mode: " + zag(i3) + ". Mode was already set to " + zag(this.zaw.intValue()));
        }
        if (this.zal != null) {
            return;
        }
        boolean z3 = false;
        boolean z4 = false;
        for (Api.Client client : this.zac.values()) {
            z3 |= client.requiresSignIn();
            z4 |= client.providesSignIn();
        }
        int intValue = this.zaw.intValue();
        if (intValue == 1) {
            if (!z3) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            }
            if (z4) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
        } else if (intValue == 2 && z3) {
            zabiVar = zaaa.zag(this.zan, this, this.zaj, this.zao, this.zat, this.zac, this.zae, this.zaf, this.zag, this.zav);
            this.zal = zabiVar;
        }
        zabiVar = new zabi(this.zan, this, this.zaj, this.zao, this.zat, this.zac, this.zae, this.zaf, this.zag, this.zav, this);
        this.zal = zabiVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zam(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z3) {
        Common.zaa.zaa(googleApiClient).setResultCallback(new zabb(this, statusPendingResult, z3, googleApiClient));
    }

    private final void zan() {
        this.zak.zab();
        ((zaca) Preconditions.checkNotNull(this.zal)).zaq();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult blockingConnect() {
        boolean z3 = true;
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zaj.lock();
        try {
            if (this.zam >= 0) {
                if (this.zaw == null) {
                    z3 = false;
                }
                Preconditions.checkState(z3, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.zaw;
                if (num == null) {
                    this.zaw = Integer.valueOf(zad(this.zac.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            zal(((Integer) Preconditions.checkNotNull(this.zaw)).intValue());
            this.zak.zab();
            return ((zaca) Preconditions.checkNotNull(this.zal)).zab();
        } finally {
            this.zaj.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult blockingConnect(long j3, TimeUnit timeUnit) {
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        this.zaj.lock();
        try {
            Integer num = this.zaw;
            if (num == null) {
                this.zaw = Integer.valueOf(zad(this.zac.values(), false));
            } else if (num.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zal(((Integer) Preconditions.checkNotNull(this.zaw)).intValue());
            this.zak.zab();
            return ((zaca) Preconditions.checkNotNull(this.zal)).zac(j3, timeUnit);
        } finally {
            this.zaj.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
        Integer num = this.zaw;
        boolean z3 = true;
        if (num != null && num.intValue() == 2) {
            z3 = false;
        }
        Preconditions.checkState(z3, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult(this);
        if (this.zac.containsKey(Common.CLIENT_KEY)) {
            zam(this, statusPendingResult, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            zaaz zaazVar = new zaaz(this, atomicReference, statusPendingResult);
            zaba zabaVar = new zaba(this, statusPendingResult);
            GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this.zan);
            builder.addApi(Common.API);
            builder.addConnectionCallbacks(zaazVar);
            builder.addOnConnectionFailedListener(zabaVar);
            builder.setHandler(this.zas);
            GoogleApiClient build = builder.build();
            atomicReference.set(build);
            build.connect();
        }
        return statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect() {
        this.zaj.lock();
        try {
            int i3 = 2;
            boolean z3 = false;
            if (this.zam >= 0) {
                Preconditions.checkState(this.zaw != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.zaw;
                if (num == null) {
                    this.zaw = Integer.valueOf(zad(this.zac.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            int intValue = ((Integer) Preconditions.checkNotNull(this.zaw)).intValue();
            this.zaj.lock();
            if (intValue == 3 || intValue == 1) {
                i3 = intValue;
            } else if (intValue != 2) {
                i3 = intValue;
                Preconditions.checkArgument(z3, "Illegal sign-in mode: " + i3);
                zal(i3);
                zan();
                this.zaj.unlock();
            }
            z3 = true;
            Preconditions.checkArgument(z3, "Illegal sign-in mode: " + i3);
            zal(i3);
            zan();
            this.zaj.unlock();
        } catch (Throwable th) {
            throw th;
        } finally {
            this.zaj.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect(int i3) {
        this.zaj.lock();
        boolean z3 = true;
        if (i3 != 3 && i3 != 1) {
            if (i3 == 2) {
                i3 = 2;
            } else {
                z3 = false;
            }
        }
        try {
            Preconditions.checkArgument(z3, "Illegal sign-in mode: " + i3);
            zal(i3);
            zan();
        } finally {
            this.zaj.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void disconnect() {
        this.zaj.lock();
        try {
            this.zai.zab();
            zaca zacaVar = this.zal;
            if (zacaVar != null) {
                zacaVar.zar();
            }
            this.zau.zab();
            for (BaseImplementation.ApiMethodImpl apiMethodImpl : this.zaa) {
                apiMethodImpl.zan(null);
                apiMethodImpl.cancel();
            }
            this.zaa.clear();
            if (this.zal != null) {
                zak();
                this.zak.zaa();
            }
        } finally {
            this.zaj.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.zan);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.zap);
        printWriter.append(" mWorkQueue.size()=").print(this.zaa.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zai.zab.size());
        zaca zacaVar = this.zal;
        if (zacaVar != null) {
            zacaVar.zas(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t3) {
        Api<?> api = t3.getApi();
        Preconditions.checkArgument(this.zac.containsKey(t3.getClientKey()), "GoogleApiClient is not configured to use " + (api != null ? api.zad() : "the API") + " required for this call.");
        this.zaj.lock();
        try {
            zaca zacaVar = this.zal;
            if (zacaVar == null) {
                this.zaa.add(t3);
            } else {
                t3 = (T) zacaVar.zae(t3);
            }
            return t3;
        } finally {
            this.zaj.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t3) {
        Api<?> api = t3.getApi();
        Preconditions.checkArgument(this.zac.containsKey(t3.getClientKey()), "GoogleApiClient is not configured to use " + (api != null ? api.zad() : "the API") + " required for this call.");
        this.zaj.lock();
        try {
            zaca zacaVar = this.zal;
            if (zacaVar == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (this.zap) {
                this.zaa.add(t3);
                while (!this.zaa.isEmpty()) {
                    BaseImplementation.ApiMethodImpl apiMethodImpl = (BaseImplementation.ApiMethodImpl) this.zaa.remove();
                    this.zai.zaa(apiMethodImpl);
                    apiMethodImpl.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                }
            } else {
                t3 = (T) zacaVar.zaf(t3);
            }
            return t3;
        } finally {
            this.zaj.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <C extends Api.Client> C getClient(Api.AnyClientKey<C> anyClientKey) {
        C c3 = (C) this.zac.get(anyClientKey);
        Preconditions.checkNotNull(c3, "Appropriate Api was not requested.");
        return c3;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult getConnectionResult(Api<?> api) {
        ConnectionResult connectionResult;
        this.zaj.lock();
        try {
            if (!isConnected() && !this.zap) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            }
            if (!this.zac.containsKey(api.zab())) {
                throw new IllegalArgumentException(api.zad() + " was never registered with GoogleApiClient");
            }
            ConnectionResult zad = ((zaca) Preconditions.checkNotNull(this.zal)).zad(api);
            if (zad != null) {
                return zad;
            }
            if (this.zap) {
                connectionResult = ConnectionResult.RESULT_SUCCESS;
            } else {
                Log.w("GoogleApiClientImpl", zaf());
                Log.wtf("GoogleApiClientImpl", api.zad() + " requested in getConnectionResult is not connected but is not present in the failed  connections map", new Exception());
                connectionResult = new ConnectionResult(8, null);
            }
            return connectionResult;
        } finally {
            this.zaj.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Context getContext() {
        return this.zan;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper getLooper() {
        return this.zao;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean hasApi(Api<?> api) {
        return this.zac.containsKey(api.zab());
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean hasConnectedApi(Api<?> api) {
        Api.Client client;
        return isConnected() && (client = (Api.Client) this.zac.get(api.zab())) != null && client.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnected() {
        zaca zacaVar = this.zal;
        return zacaVar != null && zacaVar.zaw();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnecting() {
        zaca zacaVar = this.zal;
        return zacaVar != null && zacaVar.zax();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.zak.zaj(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.zak.zak(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        zaca zacaVar = this.zal;
        return zacaVar != null && zacaVar.zay(signInConnectionListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void maybeSignOut() {
        zaca zacaVar = this.zal;
        if (zacaVar != null) {
            zacaVar.zau();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void reconnect() {
        disconnect();
        connect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zak.zaf(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zak.zag(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <L> ListenerHolder<L> registerListener(L l3) {
        this.zaj.lock();
        try {
            return this.zau.zaa(l3, this.zao, "NO_TYPE");
        } finally {
            this.zaj.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void stopAutoManage(FragmentActivity fragmentActivity) {
        LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) fragmentActivity);
        if (this.zam < 0) {
            throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        }
        zak.zaa(lifecycleActivity).zae(this.zam);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zak.zah(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zak.zai(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zaa(ConnectionResult connectionResult) {
        if (!this.zat.isPlayServicesPossiblyUpdating(this.zan, connectionResult.getErrorCode())) {
            zak();
        }
        if (this.zap) {
            return;
        }
        this.zak.zac(connectionResult);
        this.zak.zaa();
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zab(Bundle bundle) {
        while (!this.zaa.isEmpty()) {
            execute((BaseImplementation.ApiMethodImpl) this.zaa.remove());
        }
        this.zak.zad(bundle);
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zac(int i3, boolean z3) {
        if (i3 == 1) {
            if (!z3 && !this.zap) {
                this.zap = true;
                if (this.zab == null && !ClientLibraryUtils.isPackageSide()) {
                    try {
                        this.zab = this.zat.zac(this.zan.getApplicationContext(), new zabd(this));
                    } catch (SecurityException unused) {
                    }
                }
                zabc zabcVar = this.zas;
                zabcVar.sendMessageDelayed(zabcVar.obtainMessage(1), this.zaq);
                zabc zabcVar2 = this.zas;
                zabcVar2.sendMessageDelayed(zabcVar2.obtainMessage(2), this.zar);
            }
            i3 = 1;
        }
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.zai.zab.toArray(new BasePendingResult[0])) {
            basePendingResult.forceFailureUnlessReady(zadc.zaa);
        }
        this.zak.zae(i3);
        this.zak.zaa();
        if (i3 == 2) {
            zan();
        }
    }

    final String zaf() {
        StringWriter stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    final boolean zak() {
        if (!this.zap) {
            return false;
        }
        this.zap = false;
        this.zas.removeMessages(2);
        this.zas.removeMessages(1);
        zabx zabxVar = this.zab;
        if (zabxVar != null) {
            zabxVar.zab();
            this.zab = null;
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zao(zada zadaVar) {
        this.zaj.lock();
        try {
            if (this.zah == null) {
                this.zah = new HashSet();
            }
            this.zah.add(zadaVar);
        } finally {
            this.zaj.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        if (r3 == false) goto L20;
     */
    @Override // com.google.android.gms.common.api.GoogleApiClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zap(com.google.android.gms.common.api.internal.zada r3) {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.zaj
            r0.lock()
            java.util.Set r0 = r2.zah     // Catch: java.lang.Throwable -> L54
            java.lang.String r1 = "GoogleApiClientImpl"
            if (r0 != 0) goto L16
            java.lang.Exception r3 = new java.lang.Exception     // Catch: java.lang.Throwable -> L54
            r3.<init>()     // Catch: java.lang.Throwable -> L54
            java.lang.String r0 = "Attempted to remove pending transform when no transforms are registered."
        L12:
            android.util.Log.wtf(r1, r0, r3)     // Catch: java.lang.Throwable -> L54
            goto L47
        L16:
            boolean r3 = r0.remove(r3)     // Catch: java.lang.Throwable -> L54
            if (r3 != 0) goto L24
            java.lang.Exception r3 = new java.lang.Exception     // Catch: java.lang.Throwable -> L54
            r3.<init>()     // Catch: java.lang.Throwable -> L54
            java.lang.String r0 = "Failed to remove pending transform - this may lead to memory leaks!"
            goto L12
        L24:
            java.util.concurrent.locks.Lock r3 = r2.zaj     // Catch: java.lang.Throwable -> L54
            r3.lock()     // Catch: java.lang.Throwable -> L54
            java.util.Set r3 = r2.zah     // Catch: java.lang.Throwable -> L4d
            if (r3 != 0) goto L33
            java.util.concurrent.locks.Lock r3 = r2.zaj     // Catch: java.lang.Throwable -> L54
            r3.unlock()     // Catch: java.lang.Throwable -> L54
            goto L40
        L33:
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L4d
            r3 = r3 ^ 1
            java.util.concurrent.locks.Lock r0 = r2.zaj     // Catch: java.lang.Throwable -> L54
            r0.unlock()     // Catch: java.lang.Throwable -> L54
            if (r3 != 0) goto L47
        L40:
            com.google.android.gms.common.api.internal.zaca r3 = r2.zal     // Catch: java.lang.Throwable -> L54
            if (r3 == 0) goto L47
            r3.zat()     // Catch: java.lang.Throwable -> L54
        L47:
            java.util.concurrent.locks.Lock r3 = r2.zaj
            r3.unlock()
            return
        L4d:
            r3 = move-exception
            java.util.concurrent.locks.Lock r0 = r2.zaj     // Catch: java.lang.Throwable -> L54
            r0.unlock()     // Catch: java.lang.Throwable -> L54
            throw r3     // Catch: java.lang.Throwable -> L54
        L54:
            r3 = move-exception
            java.util.concurrent.locks.Lock r0 = r2.zaj
            r0.unlock()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zabe.zap(com.google.android.gms.common.api.internal.zada):void");
    }
}
