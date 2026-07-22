package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public interface b extends LocationListener {
    @Override // android.location.LocationListener
    void onFlushComplete(int i3);

    @Override // android.location.LocationListener
    void onLocationChanged(List<Location> list);

    @Override // android.location.LocationListener
    void onProviderDisabled(String str);

    @Override // android.location.LocationListener
    void onProviderEnabled(String str);

    @Override // android.location.LocationListener
    void onStatusChanged(String str, int i3, Bundle bundle);
}
