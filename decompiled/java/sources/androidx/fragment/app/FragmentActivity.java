package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.app.a;
import androidx.core.app.a1;
import androidx.core.app.b1;
import androidx.core.app.d1;
import androidx.core.app.l1;
import androidx.lifecycle.e;
import androidx.savedstate.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: /root/release/classes.dex */
public class FragmentActivity extends ComponentActivity implements a.g, a.i {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final androidx.lifecycle.j mFragmentLifecycleRegistry;
    final m mFragments;
    boolean mResumed;
    boolean mStopped;

    class a extends o<FragmentActivity> implements androidx.core.content.l, androidx.core.content.m, a1, b1, androidx.lifecycle.e0, androidx.activity.n, androidx.activity.result.d, q.d, a0, androidx.core.view.d {
        public a() {
            super(FragmentActivity.this);
        }

        @Override // androidx.fragment.app.a0
        public void a(w wVar, Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        @Override // androidx.core.view.d
        public void addMenuProvider(androidx.core.view.h hVar) {
            FragmentActivity.this.addMenuProvider(hVar);
        }

        @Override // androidx.core.content.l
        public void addOnConfigurationChangedListener(androidx.core.util.a<Configuration> aVar) {
            FragmentActivity.this.addOnConfigurationChangedListener(aVar);
        }

        @Override // androidx.core.app.a1
        public void addOnMultiWindowModeChangedListener(androidx.core.util.a<androidx.core.app.q> aVar) {
            FragmentActivity.this.addOnMultiWindowModeChangedListener(aVar);
        }

        @Override // androidx.core.app.b1
        public void addOnPictureInPictureModeChangedListener(androidx.core.util.a<d1> aVar) {
            FragmentActivity.this.addOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // androidx.core.content.m
        public void addOnTrimMemoryListener(androidx.core.util.a<Integer> aVar) {
            FragmentActivity.this.addOnTrimMemoryListener(aVar);
        }

        @Override // androidx.fragment.app.o, androidx.fragment.app.k
        public View c(int i3) {
            return FragmentActivity.this.findViewById(i3);
        }

        @Override // androidx.fragment.app.o, androidx.fragment.app.k
        public boolean d() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.activity.result.d
        public ActivityResultRegistry getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.i
        public androidx.lifecycle.e getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.n
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        @Override // q.d
        public androidx.savedstate.a getSavedStateRegistry() {
            return FragmentActivity.this.getSavedStateRegistry();
        }

        @Override // androidx.lifecycle.e0
        public androidx.lifecycle.d0 getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.o
        public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.o
        public LayoutInflater j() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // androidx.fragment.app.o
        public boolean l(String str) {
            return androidx.core.app.a.f(FragmentActivity.this, str);
        }

        @Override // androidx.fragment.app.o
        public void o() {
            p();
        }

        public void p() {
            FragmentActivity.this.invalidateMenu();
        }

        @Override // androidx.fragment.app.o
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public FragmentActivity i() {
            return FragmentActivity.this;
        }

        @Override // androidx.core.view.d
        public void removeMenuProvider(androidx.core.view.h hVar) {
            FragmentActivity.this.removeMenuProvider(hVar);
        }

        @Override // androidx.core.content.l
        public void removeOnConfigurationChangedListener(androidx.core.util.a<Configuration> aVar) {
            FragmentActivity.this.removeOnConfigurationChangedListener(aVar);
        }

        @Override // androidx.core.app.a1
        public void removeOnMultiWindowModeChangedListener(androidx.core.util.a<androidx.core.app.q> aVar) {
            FragmentActivity.this.removeOnMultiWindowModeChangedListener(aVar);
        }

        @Override // androidx.core.app.b1
        public void removeOnPictureInPictureModeChangedListener(androidx.core.util.a<d1> aVar) {
            FragmentActivity.this.removeOnPictureInPictureModeChangedListener(aVar);
        }

        @Override // androidx.core.content.m
        public void removeOnTrimMemoryListener(androidx.core.util.a<Integer> aVar) {
            FragmentActivity.this.removeOnTrimMemoryListener(aVar);
        }
    }

    public FragmentActivity() {
        this.mFragments = m.b(new a());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.j(this);
        this.mStopped = true;
        init();
    }

    public FragmentActivity(int i3) {
        super(i3);
        this.mFragments = m.b(new a());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.j(this);
        this.mStopped = true;
        init();
    }

    private void init() {
        getSavedStateRegistry().h(LIFECYCLE_TAG, new a.c() { // from class: androidx.fragment.app.f
            @Override // androidx.savedstate.a.c
            public final Bundle a() {
                Bundle lambda$init$0;
                lambda$init$0 = FragmentActivity.this.lambda$init$0();
                return lambda$init$0;
            }
        });
        addOnConfigurationChangedListener(new androidx.core.util.a() { // from class: androidx.fragment.app.g
            @Override // androidx.core.util.a
            public final void accept(Object obj) {
                FragmentActivity.this.lambda$init$1((Configuration) obj);
            }
        });
        addOnNewIntentListener(new androidx.core.util.a() { // from class: androidx.fragment.app.h
            @Override // androidx.core.util.a
            public final void accept(Object obj) {
                FragmentActivity.this.lambda$init$2((Intent) obj);
            }
        });
        addOnContextAvailableListener(new a.b() { // from class: androidx.fragment.app.i
            @Override // a.b
            public final void a(Context context) {
                FragmentActivity.this.lambda$init$3(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$init$0() {
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.h(e.a.ON_STOP);
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(Configuration configuration) {
        this.mFragments.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(Intent intent) {
        this.mFragments.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$3(Context context) {
        this.mFragments.a(null);
    }

    private static boolean markState(w wVar, e.b bVar) {
        boolean z3 = false;
        for (Fragment fragment : wVar.u0()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    z3 |= markState(fragment.getChildFragmentManager(), bVar);
                }
                j0 j0Var = fragment.mViewLifecycleOwner;
                if (j0Var != null && j0Var.getLifecycle().b().b(e.b.STARTED)) {
                    fragment.mViewLifecycleOwner.f(bVar);
                    z3 = true;
                }
                if (fragment.mLifecycleRegistry.b().b(e.b.STARTED)) {
                    fragment.mLifecycleRegistry.n(bVar);
                    z3 = true;
                }
            }
        }
        return z3;
    }

    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.n(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (shouldDumpInternalState(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print(" mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            if (getApplication() != null) {
                androidx.loader.app.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.mFragments.l().Y(str, fileDescriptor, printWriter, strArr);
        }
    }

    public w getSupportFragmentManager() {
        return this.mFragments.l();
    }

    @Deprecated
    public androidx.loader.app.a getSupportLoaderManager() {
        return androidx.loader.app.a.b(this);
    }

    void markFragmentsCreated() {
        while (markState(getSupportFragmentManager(), e.b.CREATED)) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        this.mFragments.m();
        super.onActivityResult(i3, i4, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.h(e.a.ON_CREATE);
        this.mFragments.e();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mFragments.f();
        this.mFragmentLifecycleRegistry.h(e.a.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        if (super.onMenuItemSelected(i3, menuItem)) {
            return true;
        }
        if (i3 == 6) {
            return this.mFragments.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.g();
        this.mFragmentLifecycleRegistry.h(e.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        this.mFragments.m();
        super.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.mFragments.m();
        super.onResume();
        this.mResumed = true;
        this.mFragments.k();
    }

    protected void onResumeFragments() {
        this.mFragmentLifecycleRegistry.h(e.a.ON_RESUME);
        this.mFragments.h();
    }

    @Override // android.app.Activity
    protected void onStart() {
        this.mFragments.m();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.k();
        this.mFragmentLifecycleRegistry.h(e.a.ON_START);
        this.mFragments.i();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.m();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.j();
        this.mFragmentLifecycleRegistry.h(e.a.ON_STOP);
    }

    public void setEnterSharedElementCallback(l1 l1Var) {
        androidx.core.app.a.d(this, l1Var);
    }

    public void setExitSharedElementCallback(l1 l1Var) {
        androidx.core.app.a.e(this, l1Var);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i3) {
        startActivityFromFragment(fragment, intent, i3, (Bundle) null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i3, Bundle bundle) {
        if (i3 == -1) {
            androidx.core.app.a.g(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i3, bundle);
        }
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        if (i3 == -1) {
            androidx.core.app.a.h(this, intentSender, i3, intent, i4, i5, i6, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i3, intent, i4, i5, i6, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        androidx.core.app.a.a(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateMenu();
    }

    public void supportPostponeEnterTransition() {
        androidx.core.app.a.b(this);
    }

    public void supportStartPostponedEnterTransition() {
        androidx.core.app.a.i(this);
    }

    @Override // androidx.core.app.a.i
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i3) {
    }
}
