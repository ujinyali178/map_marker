package h1;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.os.Bundle;
import u1.n;

/* loaded from: /root/release/classes.dex */
public interface a extends ComponentCallbacks2, n.a, n.d {
    boolean C();

    void onCreate(Bundle bundle);

    void onDestroy();

    void onNewIntent(Intent intent);

    void onPause();

    void onPostResume();

    void onResume();

    void onStart();

    void onStop();

    void onUserLeaveHint();

    void onWindowFocusChanged(boolean z3);
}
