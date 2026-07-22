package io.flutter.plugin.editing;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsets$Builder;
import android.view.WindowInsets$Type;
import android.view.WindowInsetsAnimation;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.Iterator;
import java.util.List;

/* loaded from: /root/release/classes.dex */
class ImeSyncDeferringInsetsCallback {
    private WindowInsets lastWindowInsets;
    private View view;
    private final int deferredInsetTypes = WindowInsets$Type.ime();
    private boolean animating = false;
    private boolean needsSave = false;
    private AnimationCallback animationCallback = new AnimationCallback();
    private b insetsListener = new b();

    private class AnimationCallback extends WindowInsetsAnimation.Callback {
        AnimationCallback() {
            new Object(1) { // from class: android.view.WindowInsetsAnimation.Callback
                static {
                    throw new NoClassDefFoundError();
                }

                public /* synthetic */ Callback(int i3) {
                }
            };
        }

        public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
            if (!ImeSyncDeferringInsetsCallback.this.animating || (windowInsetsAnimation.getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) == 0) {
                return;
            }
            ImeSyncDeferringInsetsCallback.this.animating = false;
            if (ImeSyncDeferringInsetsCallback.this.lastWindowInsets == null || ImeSyncDeferringInsetsCallback.this.view == null) {
                return;
            }
            ImeSyncDeferringInsetsCallback.this.view.dispatchApplyWindowInsets(ImeSyncDeferringInsetsCallback.this.lastWindowInsets);
        }

        public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
            ImeSyncDeferringInsetsCallback.this.needsSave = true;
            if ((windowInsetsAnimation.getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0) {
                ImeSyncDeferringInsetsCallback.this.animating = true;
            }
        }

        public WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
            int i3;
            Insets insets;
            Insets insets2;
            if (ImeSyncDeferringInsetsCallback.this.animating && !ImeSyncDeferringInsetsCallback.this.needsSave) {
                Iterator<WindowInsetsAnimation> it = list.iterator();
                boolean z3 = false;
                while (it.hasNext()) {
                    if ((it.next().getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0) {
                        z3 = true;
                    }
                }
                if (!z3) {
                    return windowInsets;
                }
                int windowSystemUiVisibility = ImeSyncDeferringInsetsCallback.this.view.getWindowSystemUiVisibility();
                if ((windowSystemUiVisibility & UserVerificationMethods.USER_VERIFY_NONE) == 0 && (windowSystemUiVisibility & 2) == 0) {
                    insets2 = windowInsets.getInsets(WindowInsets$Type.navigationBars());
                    i3 = insets2.bottom;
                } else {
                    i3 = 0;
                }
                WindowInsets$Builder windowInsets$Builder = new WindowInsets$Builder(ImeSyncDeferringInsetsCallback.this.lastWindowInsets);
                insets = windowInsets.getInsets(ImeSyncDeferringInsetsCallback.this.deferredInsetTypes);
                windowInsets$Builder.setInsets(ImeSyncDeferringInsetsCallback.this.deferredInsetTypes, Insets.of(0, 0, 0, Math.max(insets.bottom - i3, 0)));
                ImeSyncDeferringInsetsCallback.this.view.onApplyWindowInsets(windowInsets$Builder.build());
            }
            return windowInsets;
        }
    }

    private class b implements View.OnApplyWindowInsetsListener {
        private b() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ImeSyncDeferringInsetsCallback.this.view = view;
            if (ImeSyncDeferringInsetsCallback.this.needsSave) {
                ImeSyncDeferringInsetsCallback.this.lastWindowInsets = windowInsets;
                ImeSyncDeferringInsetsCallback.this.needsSave = false;
            }
            return ImeSyncDeferringInsetsCallback.this.animating ? WindowInsets.CONSUMED : view.onApplyWindowInsets(windowInsets);
        }
    }

    ImeSyncDeferringInsetsCallback(View view) {
        this.view = view;
    }

    WindowInsetsAnimation.Callback getAnimationCallback() {
        return this.animationCallback;
    }

    View.OnApplyWindowInsetsListener getInsetsListener() {
        return this.insetsListener;
    }

    void install() {
        this.view.setWindowInsetsAnimationCallback(this.animationCallback);
        this.view.setOnApplyWindowInsetsListener(this.insetsListener);
    }

    void remove() {
        this.view.setWindowInsetsAnimationCallback(null);
        this.view.setOnApplyWindowInsetsListener(null);
    }
}
