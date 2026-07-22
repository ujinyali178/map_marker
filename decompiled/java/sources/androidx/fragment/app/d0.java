package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.l0;
import androidx.lifecycle.e;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: /root/release/classes.dex */
class d0 {

    /* renamed from: a, reason: collision with root package name */
    private final q f1038a;

    /* renamed from: b, reason: collision with root package name */
    private final e0 f1039b;

    /* renamed from: c, reason: collision with root package name */
    private final Fragment f1040c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1041d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f1042e = -1;

    class a implements View.OnAttachStateChangeListener {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f1043c;

        a(View view) {
            this.f1043c = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f1043c.removeOnAttachStateChangeListener(this);
            androidx.core.view.n.n(this.f1043c);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1045a;

        static {
            int[] iArr = new int[e.b.values().length];
            f1045a = iArr;
            try {
                iArr[e.b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1045a[e.b.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1045a[e.b.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1045a[e.b.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    d0(q qVar, e0 e0Var, Fragment fragment) {
        this.f1038a = qVar;
        this.f1039b = e0Var;
        this.f1040c = fragment;
    }

    d0(q qVar, e0 e0Var, Fragment fragment, c0 c0Var) {
        this.f1038a = qVar;
        this.f1039b = e0Var;
        this.f1040c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = c0Var.f991p;
        fragment.mSavedFragmentState = bundle == null ? new Bundle() : bundle;
    }

    d0(q qVar, e0 e0Var, ClassLoader classLoader, n nVar, c0 c0Var) {
        this.f1038a = qVar;
        this.f1039b = e0Var;
        Fragment a4 = c0Var.a(nVar, classLoader);
        this.f1040c = a4;
        if (w.I0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a4);
        }
    }

    private boolean l(View view) {
        if (view == this.f1040c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f1040c.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f1040c.performSaveInstanceState(bundle);
        this.f1038a.j(this.f1040c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f1040c.mView != null) {
            s();
        }
        if (this.f1040c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f1040c.mSavedViewState);
        }
        if (this.f1040c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f1040c.mSavedViewRegistryState);
        }
        if (!this.f1040c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f1040c.mUserVisibleHint);
        }
        return bundle;
    }

    void a() {
        if (w.I0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f1040c);
        }
        Fragment fragment = this.f1040c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        q qVar = this.f1038a;
        Fragment fragment2 = this.f1040c;
        qVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    void b() {
        int j3 = this.f1039b.j(this.f1040c);
        Fragment fragment = this.f1040c;
        fragment.mContainer.addView(fragment.mView, j3);
    }

    void c() {
        if (w.I0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f1040c);
        }
        Fragment fragment = this.f1040c;
        Fragment fragment2 = fragment.mTarget;
        d0 d0Var = null;
        if (fragment2 != null) {
            d0 n3 = this.f1039b.n(fragment2.mWho);
            if (n3 == null) {
                throw new IllegalStateException("Fragment " + this.f1040c + " declared target fragment " + this.f1040c.mTarget + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f1040c;
            fragment3.mTargetWho = fragment3.mTarget.mWho;
            fragment3.mTarget = null;
            d0Var = n3;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (d0Var = this.f1039b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f1040c + " declared target fragment " + this.f1040c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (d0Var != null) {
            d0Var.m();
        }
        Fragment fragment4 = this.f1040c;
        fragment4.mHost = fragment4.mFragmentManager.v0();
        Fragment fragment5 = this.f1040c;
        fragment5.mParentFragment = fragment5.mFragmentManager.y0();
        this.f1038a.g(this.f1040c, false);
        this.f1040c.performAttach();
        this.f1038a.b(this.f1040c, false);
    }

    int d() {
        Fragment fragment = this.f1040c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int i3 = this.f1042e;
        int i4 = b.f1045a[fragment.mMaxState.ordinal()];
        if (i4 != 1) {
            i3 = i4 != 2 ? i4 != 3 ? i4 != 4 ? Math.min(i3, -1) : Math.min(i3, 0) : Math.min(i3, 1) : Math.min(i3, 5);
        }
        Fragment fragment2 = this.f1040c;
        if (fragment2.mFromLayout) {
            if (fragment2.mInLayout) {
                i3 = Math.max(this.f1042e, 2);
                View view = this.f1040c.mView;
                if (view != null && view.getParent() == null) {
                    i3 = Math.min(i3, 2);
                }
            } else {
                i3 = this.f1042e < 4 ? Math.min(i3, fragment2.mState) : Math.min(i3, 1);
            }
        }
        if (!this.f1040c.mAdded) {
            i3 = Math.min(i3, 1);
        }
        Fragment fragment3 = this.f1040c;
        ViewGroup viewGroup = fragment3.mContainer;
        l0.e.b l3 = viewGroup != null ? l0.n(viewGroup, fragment3.getParentFragmentManager()).l(this) : null;
        if (l3 == l0.e.b.ADDING) {
            i3 = Math.min(i3, 6);
        } else if (l3 == l0.e.b.REMOVING) {
            i3 = Math.max(i3, 3);
        } else {
            Fragment fragment4 = this.f1040c;
            if (fragment4.mRemoving) {
                i3 = fragment4.isInBackStack() ? Math.min(i3, 1) : Math.min(i3, -1);
            }
        }
        Fragment fragment5 = this.f1040c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i3 = Math.min(i3, 4);
        }
        if (w.I0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i3 + " for " + this.f1040c);
        }
        return i3;
    }

    void e() {
        if (w.I0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f1040c);
        }
        Fragment fragment = this.f1040c;
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            this.f1040c.mState = 1;
            return;
        }
        this.f1038a.h(fragment, fragment.mSavedFragmentState, false);
        Fragment fragment2 = this.f1040c;
        fragment2.performCreate(fragment2.mSavedFragmentState);
        q qVar = this.f1038a;
        Fragment fragment3 = this.f1040c;
        qVar.c(fragment3, fragment3.mSavedFragmentState, false);
    }

    void f() {
        String str;
        if (this.f1040c.mFromLayout) {
            return;
        }
        if (w.I0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f1040c);
        }
        Fragment fragment = this.f1040c;
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = null;
        Fragment fragment2 = this.f1040c;
        ViewGroup viewGroup2 = fragment2.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i3 = fragment2.mContainerId;
            if (i3 != 0) {
                if (i3 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f1040c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment2.mFragmentManager.r0().c(this.f1040c.mContainerId);
                if (viewGroup == null) {
                    Fragment fragment3 = this.f1040c;
                    if (!fragment3.mRestored) {
                        try {
                            str = fragment3.getResources().getResourceName(this.f1040c.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f1040c.mContainerId) + " (" + str + ") for fragment " + this.f1040c);
                    }
                } else if (!(viewGroup instanceof l)) {
                    m.d.p(this.f1040c, viewGroup);
                }
            }
        }
        Fragment fragment4 = this.f1040c;
        fragment4.mContainer = viewGroup;
        fragment4.performCreateView(performGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
        View view = this.f1040c.mView;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f1040c;
            fragment5.mView.setTag(l.b.f3896a, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.f1040c;
            if (fragment6.mHidden) {
                fragment6.mView.setVisibility(8);
            }
            if (androidx.core.view.n.i(this.f1040c.mView)) {
                androidx.core.view.n.n(this.f1040c.mView);
            } else {
                View view2 = this.f1040c.mView;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            this.f1040c.performViewCreated();
            q qVar = this.f1038a;
            Fragment fragment7 = this.f1040c;
            qVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            int visibility = this.f1040c.mView.getVisibility();
            this.f1040c.setPostOnViewCreatedAlpha(this.f1040c.mView.getAlpha());
            Fragment fragment8 = this.f1040c;
            if (fragment8.mContainer != null && visibility == 0) {
                View findFocus = fragment8.mView.findFocus();
                if (findFocus != null) {
                    this.f1040c.setFocusedView(findFocus);
                    if (w.I0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f1040c);
                    }
                }
                this.f1040c.mView.setAlpha(BitmapDescriptorFactory.HUE_RED);
            }
        }
        this.f1040c.mState = 2;
    }

    void g() {
        Fragment f3;
        if (w.I0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f1040c);
        }
        Fragment fragment = this.f1040c;
        boolean z3 = true;
        boolean z4 = fragment.mRemoving && !fragment.isInBackStack();
        if (z4) {
            Fragment fragment2 = this.f1040c;
            if (!fragment2.mBeingSaved) {
                this.f1039b.B(fragment2.mWho, null);
            }
        }
        if (!(z4 || this.f1039b.p().r(this.f1040c))) {
            String str = this.f1040c.mTargetWho;
            if (str != null && (f3 = this.f1039b.f(str)) != null && f3.mRetainInstance) {
                this.f1040c.mTarget = f3;
            }
            this.f1040c.mState = 0;
            return;
        }
        o<?> oVar = this.f1040c.mHost;
        if (oVar instanceof androidx.lifecycle.e0) {
            z3 = this.f1039b.p().o();
        } else if (oVar.f() instanceof Activity) {
            z3 = true ^ ((Activity) oVar.f()).isChangingConfigurations();
        }
        if ((z4 && !this.f1040c.mBeingSaved) || z3) {
            this.f1039b.p().g(this.f1040c);
        }
        this.f1040c.performDestroy();
        this.f1038a.d(this.f1040c, false);
        for (d0 d0Var : this.f1039b.k()) {
            if (d0Var != null) {
                Fragment k3 = d0Var.k();
                if (this.f1040c.mWho.equals(k3.mTargetWho)) {
                    k3.mTarget = this.f1040c;
                    k3.mTargetWho = null;
                }
            }
        }
        Fragment fragment3 = this.f1040c;
        String str2 = fragment3.mTargetWho;
        if (str2 != null) {
            fragment3.mTarget = this.f1039b.f(str2);
        }
        this.f1039b.s(this);
    }

    void h() {
        View view;
        if (w.I0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f1040c);
        }
        Fragment fragment = this.f1040c;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.f1040c.performDestroyView();
        this.f1038a.n(this.f1040c, false);
        Fragment fragment2 = this.f1040c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.n(null);
        this.f1040c.mInLayout = false;
    }

    void i() {
        if (w.I0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f1040c);
        }
        this.f1040c.performDetach();
        boolean z3 = false;
        this.f1038a.e(this.f1040c, false);
        Fragment fragment = this.f1040c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z3 = true;
        }
        if (z3 || this.f1039b.p().r(this.f1040c)) {
            if (w.I0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f1040c);
            }
            this.f1040c.initState();
        }
    }

    void j() {
        Fragment fragment = this.f1040c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (w.I0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f1040c);
            }
            Fragment fragment2 = this.f1040c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.f1040c.mSavedFragmentState);
            View view = this.f1040c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f1040c;
                fragment3.mView.setTag(l.b.f3896a, fragment3);
                Fragment fragment4 = this.f1040c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f1040c.performViewCreated();
                q qVar = this.f1038a;
                Fragment fragment5 = this.f1040c;
                qVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f1040c.mState = 2;
            }
        }
    }

    Fragment k() {
        return this.f1040c;
    }

    void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f1041d) {
            if (w.I0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f1041d = true;
            boolean z3 = false;
            while (true) {
                int d3 = d();
                Fragment fragment = this.f1040c;
                int i3 = fragment.mState;
                if (d3 == i3) {
                    if (!z3 && i3 == -1 && fragment.mRemoving && !fragment.isInBackStack() && !this.f1040c.mBeingSaved) {
                        if (w.I0(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.f1040c);
                        }
                        this.f1039b.p().g(this.f1040c);
                        this.f1039b.s(this);
                        if (w.I0(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + this.f1040c);
                        }
                        this.f1040c.initState();
                    }
                    Fragment fragment2 = this.f1040c;
                    if (fragment2.mHiddenChanged) {
                        if (fragment2.mView != null && (viewGroup = fragment2.mContainer) != null) {
                            l0 n3 = l0.n(viewGroup, fragment2.getParentFragmentManager());
                            if (this.f1040c.mHidden) {
                                n3.c(this);
                            } else {
                                n3.e(this);
                            }
                        }
                        Fragment fragment3 = this.f1040c;
                        w wVar = fragment3.mFragmentManager;
                        if (wVar != null) {
                            wVar.G0(fragment3);
                        }
                        Fragment fragment4 = this.f1040c;
                        fragment4.mHiddenChanged = false;
                        fragment4.onHiddenChanged(fragment4.mHidden);
                        this.f1040c.mChildFragmentManager.K();
                    }
                    return;
                }
                if (d3 <= i3) {
                    switch (i3 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            if (fragment.mBeingSaved && this.f1039b.q(fragment.mWho) == null) {
                                r();
                            }
                            g();
                            break;
                        case 1:
                            h();
                            this.f1040c.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (w.I0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f1040c);
                            }
                            Fragment fragment5 = this.f1040c;
                            if (fragment5.mBeingSaved) {
                                r();
                            } else if (fragment5.mView != null && fragment5.mSavedViewState == null) {
                                s();
                            }
                            Fragment fragment6 = this.f1040c;
                            if (fragment6.mView != null && (viewGroup2 = fragment6.mContainer) != null) {
                                l0.n(viewGroup2, fragment6.getParentFragmentManager()).d(this);
                            }
                            this.f1040c.mState = 3;
                            break;
                        case 4:
                            v();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i3 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup3 = fragment.mContainer) != null) {
                                l0.n(viewGroup3, fragment.getParentFragmentManager()).b(l0.e.c.b(this.f1040c.mView.getVisibility()), this);
                            }
                            this.f1040c.mState = 4;
                            break;
                        case 5:
                            u();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
                z3 = true;
            }
        } finally {
            this.f1041d = false;
        }
    }

    void n() {
        if (w.I0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f1040c);
        }
        this.f1040c.performPause();
        this.f1038a.f(this.f1040c, false);
    }

    void o(ClassLoader classLoader) {
        Bundle bundle = this.f1040c.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f1040c;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f1040c;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
        Fragment fragment3 = this.f1040c;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
        Fragment fragment4 = this.f1040c;
        if (fragment4.mTargetWho != null) {
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.f1040c;
        Boolean bool = fragment5.mSavedUserVisibleHint;
        if (bool != null) {
            fragment5.mUserVisibleHint = bool.booleanValue();
            this.f1040c.mSavedUserVisibleHint = null;
        } else {
            fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.f1040c;
        if (fragment6.mUserVisibleHint) {
            return;
        }
        fragment6.mDeferStart = true;
    }

    void p() {
        if (w.I0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f1040c);
        }
        View focusedView = this.f1040c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (w.I0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(requestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.f1040c);
                sb.append(" resulting in focused view ");
                sb.append(this.f1040c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f1040c.setFocusedView(null);
        this.f1040c.performResume();
        this.f1038a.i(this.f1040c, false);
        Fragment fragment = this.f1040c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    void r() {
        c0 c0Var = new c0(this.f1040c);
        Fragment fragment = this.f1040c;
        if (fragment.mState <= -1 || c0Var.f991p != null) {
            c0Var.f991p = fragment.mSavedFragmentState;
        } else {
            Bundle q3 = q();
            c0Var.f991p = q3;
            if (this.f1040c.mTargetWho != null) {
                if (q3 == null) {
                    c0Var.f991p = new Bundle();
                }
                c0Var.f991p.putString("android:target_state", this.f1040c.mTargetWho);
                int i3 = this.f1040c.mTargetRequestCode;
                if (i3 != 0) {
                    c0Var.f991p.putInt("android:target_req_state", i3);
                }
            }
        }
        this.f1039b.B(this.f1040c.mWho, c0Var);
    }

    void s() {
        if (this.f1040c.mView == null) {
            return;
        }
        if (w.I0(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + this.f1040c + " with view " + this.f1040c.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f1040c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f1040c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f1040c.mViewLifecycleOwner.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f1040c.mSavedViewRegistryState = bundle;
    }

    void t(int i3) {
        this.f1042e = i3;
    }

    void u() {
        if (w.I0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f1040c);
        }
        this.f1040c.performStart();
        this.f1038a.k(this.f1040c, false);
    }

    void v() {
        if (w.I0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f1040c);
        }
        this.f1040c.performStop();
        this.f1038a.l(this.f1040c, false);
    }
}
