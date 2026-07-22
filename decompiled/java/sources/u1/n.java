package u1;

import android.app.Activity;
import android.content.Intent;
import io.flutter.view.t;

/* loaded from: /root/release/classes.dex */
public interface n {

    public interface a {
        boolean a(int i3, int i4, Intent intent);
    }

    public interface b {
        boolean onNewIntent(Intent intent);
    }

    @Deprecated
    public interface c {
        c a(a aVar);

        c b(d dVar);

        Activity c();
    }

    public interface d {
        boolean onRequestPermissionsResult(int i3, String[] strArr, int[] iArr);
    }

    public interface e {
        void onUserLeaveHint();
    }

    @Deprecated
    public interface f {
        boolean b(t tVar);
    }

    public interface g {
        void onWindowFocusChanged(boolean z3);
    }
}
