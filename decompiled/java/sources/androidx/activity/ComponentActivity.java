package androidx.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.app.a1;
import androidx.core.app.b1;
import androidx.core.app.d1;
import androidx.lifecycle.a0;
import androidx.lifecycle.d0;
import androidx.lifecycle.e;
import androidx.lifecycle.e0;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.u;
import androidx.lifecycle.x;
import androidx.savedstate.a;
import b.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /root/release/classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements e0, androidx.lifecycle.d, q.d, n, androidx.activity.result.d, androidx.core.content.l, androidx.core.content.m, a1, b1, androidx.core.view.d, k {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final a.a mContextAwareHelper;
    private a0.b mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    final j mFullyDrawnReporter;
    private final androidx.lifecycle.j mLifecycleRegistry;
    private final androidx.core.view.g mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<androidx.core.util.a<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<androidx.core.app.q>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<d1>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<Integer>> mOnTrimMemoryListeners;
    final f mReportFullyDrawnExecutor;
    final q.c mSavedStateRegistryController;
    private d0 mViewModelStore;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e3) {
                if (!TextUtils.equals(e3.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e3;
                }
            }
        }
    }

    class b extends ActivityResultRegistry {

        class a implements Runnable {

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f244c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a.C0038a f245d;

            a(int i3, a.C0038a c0038a) {
                this.f244c = i3;
                this.f245d = c0038a;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.c(this.f244c, this.f245d.a());
            }
        }

        /* renamed from: androidx.activity.ComponentActivity$b$b, reason: collision with other inner class name */
        class RunnableC0002b implements Runnable {

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f247c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ IntentSender.SendIntentException f248d;

            RunnableC0002b(int i3, IntentSender.SendIntentException sendIntentException) {
                this.f247c = i3;
                this.f248d = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b(this.f247c, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f248d));
            }
        }

        b() {
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public <I, O> void f(int i3, b.a<I, O> aVar, I i4, androidx.core.app.e eVar) {
            ComponentActivity componentActivity = ComponentActivity.this;
            a.C0038a<O> b4 = aVar.b(componentActivity, i4);
            if (b4 != null) {
                new Handler(Looper.getMainLooper()).post(new a(i3, b4));
                return;
            }
            Intent a4 = aVar.a(componentActivity, i4);
            Bundle bundle = null;
            if (a4.getExtras() != null && a4.getExtras().getClassLoader() == null) {
                a4.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (a4.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundle = a4.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                a4.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            }
            Bundle bundle2 = bundle;
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a4.getAction())) {
                String[] stringArrayExtra = a4.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                androidx.core.app.a.c(componentActivity, stringArrayExtra, i3);
                return;
            }
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a4.getAction())) {
                androidx.core.app.a.g(componentActivity, a4, i3, bundle2);
                return;
            }
            androidx.activity.result.e eVar2 = (androidx.activity.result.e) a4.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                androidx.core.app.a.h(componentActivity, eVar2.d(), i3, eVar2.a(), eVar2.b(), eVar2.c(), 0, bundle2);
            } catch (IntentSender.SendIntentException e3) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0002b(i3, e3));
            }
        }
    }

    static class c {
        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    static class d {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    static final class e {

        /* renamed from: a, reason: collision with root package name */
        Object f250a;

        /* renamed from: b, reason: collision with root package name */
        d0 f251b;

        e() {
        }
    }

    private interface f extends Executor {
        void b();

        void e(View view);
    }

    class g implements f, ViewTreeObserver.OnDrawListener, Runnable {

        /* renamed from: d, reason: collision with root package name */
        Runnable f253d;

        /* renamed from: c, reason: collision with root package name */
        final long f252c = SystemClock.uptimeMillis() + 10000;

        /* renamed from: f, reason: collision with root package name */
        boolean f254f = false;

        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            Runnable runnable = this.f253d;
            if (runnable != null) {
                runnable.run();
                this.f253d = null;
            }
        }

        @Override // androidx.activity.ComponentActivity.f
        public void b() {
            ComponentActivity.this.getWindow().getDecorView().removeCallbacks(this);
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // androidx.activity.ComponentActivity.f
        public void e(View view) {
            if (this.f254f) {
                return;
            }
            this.f254f = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f253d = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (!this.f254f) {
                decorView.postOnAnimation(new Runnable() { // from class: androidx.activity.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        ComponentActivity.g.this.c();
                    }
                });
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f253d;
            if (runnable != null) {
                runnable.run();
                this.f253d = null;
                if (!ComponentActivity.this.mFullyDrawnReporter.c()) {
                    return;
                }
            } else if (SystemClock.uptimeMillis() <= this.f252c) {
                return;
            }
            this.f254f = false;
            ComponentActivity.this.getWindow().getDecorView().post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new a.a();
        this.mMenuHostHelper = new androidx.core.view.g(new Runnable() { // from class: androidx.activity.b
            @Override // java.lang.Runnable
            public final void run() {
                ComponentActivity.this.invalidateMenu();
            }
        });
        this.mLifecycleRegistry = new androidx.lifecycle.j(this);
        q.c a4 = q.c.a(this);
        this.mSavedStateRegistryController = a4;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new a());
        f createFullyDrawnExecutor = createFullyDrawnExecutor();
        this.mReportFullyDrawnExecutor = createFullyDrawnExecutor;
        this.mFullyDrawnReporter = new j(createFullyDrawnExecutor, new p2.a() { // from class: androidx.activity.c
            @Override // p2.a
            public final Object invoke() {
                g2.q lambda$new$0;
                lambda$new$0 = ComponentActivity.this.lambda$new$0();
                return lambda$new$0;
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new b();
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i3 = Build.VERSION.SDK_INT;
        getLifecycle().a(new androidx.lifecycle.g() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.g
            public void e(androidx.lifecycle.i iVar, e.a aVar) {
                if (aVar == e.a.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View peekDecorView = window != null ? window.peekDecorView() : null;
                    if (peekDecorView != null) {
                        c.a(peekDecorView);
                    }
                }
            }
        });
        getLifecycle().a(new androidx.lifecycle.g() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.g
            public void e(androidx.lifecycle.i iVar, e.a aVar) {
                if (aVar == e.a.ON_DESTROY) {
                    ComponentActivity.this.mContextAwareHelper.b();
                    if (!ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.getViewModelStore().a();
                    }
                    ComponentActivity.this.mReportFullyDrawnExecutor.b();
                }
            }
        });
        getLifecycle().a(new androidx.lifecycle.g() { // from class: androidx.activity.ComponentActivity.5
            @Override // androidx.lifecycle.g
            public void e(androidx.lifecycle.i iVar, e.a aVar) {
                ComponentActivity.this.ensureViewModelStore();
                ComponentActivity.this.getLifecycle().c(this);
            }
        });
        a4.c();
        u.c(this);
        if (i3 <= 23) {
            getLifecycle().a(new ImmLeaksCleaner(this));
        }
        getSavedStateRegistry().h(ACTIVITY_RESULT_TAG, new a.c() { // from class: androidx.activity.d
            @Override // androidx.savedstate.a.c
            public final Bundle a() {
                Bundle lambda$new$1;
                lambda$new$1 = ComponentActivity.this.lambda$new$1();
                return lambda$new$1;
            }
        });
        addOnContextAvailableListener(new a.b() { // from class: androidx.activity.e
            @Override // a.b
            public final void a(Context context) {
                ComponentActivity.this.lambda$new$2(context);
            }
        });
    }

    public ComponentActivity(int i3) {
        this();
        this.mContentLayoutId = i3;
    }

    private f createFullyDrawnExecutor() {
        return new g();
    }

    private void initViewTreeOwners() {
        f0.a(getWindow().getDecorView(), this);
        g0.a(getWindow().getDecorView(), this);
        q.e.a(getWindow().getDecorView(), this);
        q.a(getWindow().getDecorView(), this);
        p.a(getWindow().getDecorView(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ g2.q lambda$new$0() {
        reportFullyDrawn();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$new$1() {
        Bundle bundle = new Bundle();
        this.mActivityResultRegistry.h(bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(Context context) {
        Bundle b4 = getSavedStateRegistry().b(ACTIVITY_RESULT_TAG);
        if (b4 != null) {
            this.mActivityResultRegistry.g(b4);
        }
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.e(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.core.view.d
    public void addMenuProvider(androidx.core.view.h hVar) {
        this.mMenuHostHelper.c(hVar);
    }

    public void addMenuProvider(androidx.core.view.h hVar, androidx.lifecycle.i iVar) {
        this.mMenuHostHelper.d(hVar, iVar);
    }

    public void addMenuProvider(androidx.core.view.h hVar, androidx.lifecycle.i iVar, e.b bVar) {
        this.mMenuHostHelper.e(hVar, iVar, bVar);
    }

    @Override // androidx.core.content.l
    public final void addOnConfigurationChangedListener(androidx.core.util.a<Configuration> aVar) {
        this.mOnConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(a.b bVar) {
        this.mContextAwareHelper.a(bVar);
    }

    @Override // androidx.core.app.a1
    public final void addOnMultiWindowModeChangedListener(androidx.core.util.a<androidx.core.app.q> aVar) {
        this.mOnMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(androidx.core.util.a<Intent> aVar) {
        this.mOnNewIntentListeners.add(aVar);
    }

    @Override // androidx.core.app.b1
    public final void addOnPictureInPictureModeChangedListener(androidx.core.util.a<d1> aVar) {
        this.mOnPictureInPictureModeChangedListeners.add(aVar);
    }

    @Override // androidx.core.content.m
    public final void addOnTrimMemoryListener(androidx.core.util.a<Integer> aVar) {
        this.mOnTrimMemoryListeners.add(aVar);
    }

    void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            e eVar = (e) getLastNonConfigurationInstance();
            if (eVar != null) {
                this.mViewModelStore = eVar.f251b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new d0();
            }
        }
    }

    @Override // androidx.activity.result.d
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.d
    public p.a getDefaultViewModelCreationExtras() {
        p.d dVar = new p.d();
        if (getApplication() != null) {
            dVar.c(a0.a.f1275g, getApplication());
        }
        dVar.c(u.f1324a, this);
        dVar.c(u.f1325b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            dVar.c(u.f1326c, getIntent().getExtras());
        }
        return dVar;
    }

    public a0.b getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new x(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    public j getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        e eVar = (e) getLastNonConfigurationInstance();
        if (eVar != null) {
            return eVar.f250a;
        }
        return null;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.i
    public androidx.lifecycle.e getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.n
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // q.d
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Override // androidx.lifecycle.e0
    public d0 getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    @Deprecated
    protected void onActivityResult(int i3, int i4, Intent intent) {
        if (this.mActivityResultRegistry.b(i3, i4, intent)) {
            return;
        }
        super.onActivityResult(i3, i4, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.e();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<androidx.core.util.a<Configuration>> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.d(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        androidx.lifecycle.q.e(this);
        if (androidx.core.os.a.b()) {
            this.mOnBackPressedDispatcher.f(d.a(this));
        }
        int i3 = this.mContentLayoutId;
        if (i3 != 0) {
            setContentView(i3);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i3, Menu menu) {
        if (i3 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i3, menu);
        this.mMenuHostHelper.h(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        if (super.onMenuItemSelected(i3, menuItem)) {
            return true;
        }
        if (i3 == 0) {
            return this.mMenuHostHelper.j(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z3) {
        if (this.mDispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<androidx.core.util.a<androidx.core.app.q>> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new androidx.core.app.q(z3));
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z3, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z3, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<androidx.core.util.a<androidx.core.app.q>> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new androidx.core.app.q(z3, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator<androidx.core.util.a<Intent>> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i3, Menu menu) {
        this.mMenuHostHelper.i(menu);
        super.onPanelClosed(i3, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z3) {
        if (this.mDispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<androidx.core.util.a<d1>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new d1(z3));
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z3, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z3, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<androidx.core.util.a<d1>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new d1(z3, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i3, View view, Menu menu) {
        if (i3 != 0) {
            return true;
        }
        super.onPreparePanel(i3, view, menu);
        this.mMenuHostHelper.k(menu);
        return true;
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.b(i3, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        e eVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        d0 d0Var = this.mViewModelStore;
        if (d0Var == null && (eVar = (e) getLastNonConfigurationInstance()) != null) {
            d0Var = eVar.f251b;
        }
        if (d0Var == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        e eVar2 = new e();
        eVar2.f250a = onRetainCustomNonConfigurationInstance;
        eVar2.f251b = d0Var;
        return eVar2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.e lifecycle = getLifecycle();
        if (lifecycle instanceof androidx.lifecycle.j) {
            ((androidx.lifecycle.j) lifecycle).n(e.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        super.onTrimMemory(i3);
        Iterator<androidx.core.util.a<Integer>> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i3));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    public final <I, O> androidx.activity.result.c<I> registerForActivityResult(b.a<I, O> aVar, ActivityResultRegistry activityResultRegistry, androidx.activity.result.b<O> bVar) {
        return activityResultRegistry.i("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, aVar, bVar);
    }

    public final <I, O> androidx.activity.result.c<I> registerForActivityResult(b.a<I, O> aVar, androidx.activity.result.b<O> bVar) {
        return registerForActivityResult(aVar, this.mActivityResultRegistry, bVar);
    }

    @Override // androidx.core.view.d
    public void removeMenuProvider(androidx.core.view.h hVar) {
        this.mMenuHostHelper.l(hVar);
    }

    @Override // androidx.core.content.l
    public final void removeOnConfigurationChangedListener(androidx.core.util.a<Configuration> aVar) {
        this.mOnConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(a.b bVar) {
        this.mContextAwareHelper.e(bVar);
    }

    @Override // androidx.core.app.a1
    public final void removeOnMultiWindowModeChangedListener(androidx.core.util.a<androidx.core.app.q> aVar) {
        this.mOnMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(androidx.core.util.a<Intent> aVar) {
        this.mOnNewIntentListeners.remove(aVar);
    }

    @Override // androidx.core.app.b1
    public final void removeOnPictureInPictureModeChangedListener(androidx.core.util.a<d1> aVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(aVar);
    }

    @Override // androidx.core.content.m
    public final void removeOnTrimMemoryListener(androidx.core.util.a<Integer> aVar) {
        this.mOnTrimMemoryListeners.remove(aVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (s.b.h()) {
                s.b.c("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.mFullyDrawnReporter.b();
        } finally {
            s.b.f();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i3) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.e(getWindow().getDecorView());
        super.setContentView(i3);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.e(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.e(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i3) {
        super.startActivityForResult(intent, i3);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i3, Bundle bundle) {
        super.startActivityForResult(intent, i3, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6) {
        super.startIntentSenderForResult(intentSender, i3, intent, i4, i5, i6);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i3, intent, i4, i5, i6, bundle);
    }
}
