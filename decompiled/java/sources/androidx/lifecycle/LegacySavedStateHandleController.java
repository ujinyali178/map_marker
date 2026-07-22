package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.LegacySavedStateHandleController;
import androidx.lifecycle.e;
import androidx.savedstate.a;
import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
public final class LegacySavedStateHandleController {

    /* renamed from: a, reason: collision with root package name */
    public static final LegacySavedStateHandleController f1239a = new LegacySavedStateHandleController();

    public static final class a implements a.InterfaceC0034a {
        @Override // androidx.savedstate.a.InterfaceC0034a
        public void a(q.d owner) {
            kotlin.jvm.internal.k.e(owner, "owner");
            if (!(owner instanceof e0)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
            }
            d0 viewModelStore = ((e0) owner).getViewModelStore();
            androidx.savedstate.a savedStateRegistry = owner.getSavedStateRegistry();
            Iterator<String> it = viewModelStore.c().iterator();
            while (it.hasNext()) {
                z b4 = viewModelStore.b(it.next());
                kotlin.jvm.internal.k.b(b4);
                LegacySavedStateHandleController.a(b4, savedStateRegistry, owner.getLifecycle());
            }
            if (!viewModelStore.c().isEmpty()) {
                savedStateRegistry.i(a.class);
            }
        }
    }

    private LegacySavedStateHandleController() {
    }

    public static final void a(z viewModel, androidx.savedstate.a registry, e lifecycle) {
        kotlin.jvm.internal.k.e(viewModel, "viewModel");
        kotlin.jvm.internal.k.e(registry, "registry");
        kotlin.jvm.internal.k.e(lifecycle, "lifecycle");
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.g()) {
            return;
        }
        savedStateHandleController.a(registry, lifecycle);
        f1239a.c(registry, lifecycle);
    }

    public static final SavedStateHandleController b(androidx.savedstate.a registry, e lifecycle, String str, Bundle bundle) {
        kotlin.jvm.internal.k.e(registry, "registry");
        kotlin.jvm.internal.k.e(lifecycle, "lifecycle");
        kotlin.jvm.internal.k.b(str);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, t.f1317f.a(registry.b(str), bundle));
        savedStateHandleController.a(registry, lifecycle);
        f1239a.c(registry, lifecycle);
        return savedStateHandleController;
    }

    private final void c(final androidx.savedstate.a aVar, final e eVar) {
        e.b b4 = eVar.b();
        if (b4 == e.b.INITIALIZED || b4.b(e.b.STARTED)) {
            aVar.i(a.class);
        } else {
            eVar.a(new g() { // from class: androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1
                @Override // androidx.lifecycle.g
                public void e(i source, e.a event) {
                    kotlin.jvm.internal.k.e(source, "source");
                    kotlin.jvm.internal.k.e(event, "event");
                    if (event == e.a.ON_START) {
                        e.this.c(this);
                        aVar.i(LegacySavedStateHandleController.a.class);
                    }
                }
            });
        }
    }
}
