package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.b;
import androidx.lifecycle.e;

/* loaded from: /root/release/classes.dex */
public class ComponentActivity extends Activity implements androidx.lifecycle.i, b.a {
    private androidx.collection.g<Class<? extends a>, a> mExtraDataMap = new androidx.collection.g<>();
    private androidx.lifecycle.j mLifecycleRegistry = new androidx.lifecycle.j(this);

    @Deprecated
    public static class a {
    }

    private static boolean shouldSkipDump(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return false;
        }
        String str = strArr[0];
        str.hashCode();
        switch (str) {
            case "--translation":
                if (Build.VERSION.SDK_INT >= 31) {
                }
                break;
            case "--dump-dumpable":
            case "--list-dumpables":
                if (Build.VERSION.SDK_INT >= 33) {
                }
                break;
            case "--contentcapture":
                if (Build.VERSION.SDK_INT >= 29) {
                }
                break;
            case "--autofill":
                if (Build.VERSION.SDK_INT >= 26) {
                }
                break;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.view.b.d(decorView, keyEvent)) {
            return androidx.core.view.b.e(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.view.b.d(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Deprecated
    public <T extends a> T getExtraData(Class<T> cls) {
        return (T) this.mExtraDataMap.get(cls);
    }

    public androidx.lifecycle.e getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.lifecycle.q.e(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.j(e.b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public void putExtraData(a aVar) {
        this.mExtraDataMap.put(aVar.getClass(), aVar);
    }

    protected final boolean shouldDumpInternalState(String[] strArr) {
        return !shouldSkipDump(strArr);
    }

    @Override // androidx.core.view.b.a
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
