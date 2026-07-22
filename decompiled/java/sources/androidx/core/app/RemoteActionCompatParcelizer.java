package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: /root/release/classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(androidx.versionedparcelable.a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f485a = (IconCompat) aVar.v(remoteActionCompat.f485a, 1);
        remoteActionCompat.f486b = aVar.l(remoteActionCompat.f486b, 2);
        remoteActionCompat.f487c = aVar.l(remoteActionCompat.f487c, 3);
        remoteActionCompat.f488d = (PendingIntent) aVar.r(remoteActionCompat.f488d, 4);
        remoteActionCompat.f489e = aVar.h(remoteActionCompat.f489e, 5);
        remoteActionCompat.f490f = aVar.h(remoteActionCompat.f490f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f485a, 1);
        aVar.D(remoteActionCompat.f486b, 2);
        aVar.D(remoteActionCompat.f487c, 3);
        aVar.H(remoteActionCompat.f488d, 4);
        aVar.z(remoteActionCompat.f489e, 5);
        aVar.z(remoteActionCompat.f490f, 6);
    }
}
