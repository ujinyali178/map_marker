package n1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.e;
import io.flutter.embedding.android.d;

/* loaded from: /root/release/classes.dex */
public interface b {
    boolean a(int i3, int i4, Intent intent);

    void b(Bundle bundle);

    void c(d<Activity> dVar, e eVar);

    void e();

    void f();

    void onNewIntent(Intent intent);

    boolean onRequestPermissionsResult(int i3, String[] strArr, int[] iArr);

    void onSaveInstanceState(Bundle bundle);

    void onUserLeaveHint();
}
