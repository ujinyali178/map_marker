package androidx.core.location;

import android.location.Location;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public final /* synthetic */ class a {
    public static void a(b bVar, int i3) {
    }

    public static void b(b bVar, List list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            bVar.onLocationChanged((Location) list.get(i3));
        }
    }
}
