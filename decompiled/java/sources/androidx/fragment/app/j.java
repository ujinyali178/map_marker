package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

/* loaded from: /root/release/classes.dex */
class j {

    static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f1112a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f1113b;

        a(Animator animator) {
            this.f1112a = null;
            this.f1113b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        a(Animation animation) {
            this.f1112a = animation;
            this.f1113b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    static class b extends AnimationSet implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        private final ViewGroup f1114c;

        /* renamed from: d, reason: collision with root package name */
        private final View f1115d;

        /* renamed from: f, reason: collision with root package name */
        private boolean f1116f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f1117g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f1118h;

        b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1118h = true;
            this.f1114c = viewGroup;
            this.f1115d = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j3, Transformation transformation) {
            this.f1118h = true;
            if (this.f1116f) {
                return !this.f1117g;
            }
            if (!super.getTransformation(j3, transformation)) {
                this.f1116f = true;
                androidx.core.view.k.a(this.f1114c, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j3, Transformation transformation, float f3) {
            this.f1118h = true;
            if (this.f1116f) {
                return !this.f1117g;
            }
            if (!super.getTransformation(j3, transformation, f3)) {
                this.f1116f = true;
                androidx.core.view.k.a(this.f1114c, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1116f || !this.f1118h) {
                this.f1114c.endViewTransition(this.f1115d);
                this.f1117g = true;
            } else {
                this.f1118h = false;
                this.f1114c.post(this);
            }
        }
    }

    private static int a(Fragment fragment, boolean z3, boolean z4) {
        return z4 ? z3 ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z3 ? fragment.getEnterAnim() : fragment.getExitAnim();
    }

    static a b(Context context, Fragment fragment, boolean z3, boolean z4) {
        int nextTransition = fragment.getNextTransition();
        int a4 = a(fragment, z3, z4);
        boolean z5 = false;
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i3 = l.b.f3898c;
            if (viewGroup.getTag(i3) != null) {
                fragment.mContainer.setTag(i3, null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z3, a4);
        if (onCreateAnimation != null) {
            return new a(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z3, a4);
        if (onCreateAnimator != null) {
            return new a(onCreateAnimator);
        }
        if (a4 == 0 && nextTransition != 0) {
            a4 = d(context, nextTransition, z3);
        }
        if (a4 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(a4));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, a4);
                    if (loadAnimation != null) {
                        return new a(loadAnimation);
                    }
                    z5 = true;
                } catch (Resources.NotFoundException e3) {
                    throw e3;
                } catch (RuntimeException unused) {
                }
            }
            if (!z5) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, a4);
                    if (loadAnimator != null) {
                        return new a(loadAnimator);
                    }
                } catch (RuntimeException e4) {
                    if (equals) {
                        throw e4;
                    }
                    Animation loadAnimation2 = AnimationUtils.loadAnimation(context, a4);
                    if (loadAnimation2 != null) {
                        return new a(loadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    private static int c(Context context, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i3});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int d(Context context, int i3, boolean z3) {
        int i4;
        if (i3 == 4097) {
            return z3 ? l.a.f3894e : l.a.f3895f;
        }
        if (i3 == 8194) {
            return z3 ? l.a.f3890a : l.a.f3891b;
        }
        if (i3 == 8197) {
            i4 = z3 ? R.attr.activityCloseEnterAnimation : R.attr.activityCloseExitAnimation;
        } else {
            if (i3 == 4099) {
                return z3 ? l.a.f3892c : l.a.f3893d;
            }
            if (i3 != 4100) {
                return -1;
            }
            i4 = z3 ? R.attr.activityOpenEnterAnimation : R.attr.activityOpenExitAnimation;
        }
        return c(context, i4);
    }
}
