package dev.fluttercommunity.plus.connectivity;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final ConnectivityManager f2472a;

    public a(ConnectivityManager connectivityManager) {
        this.f2472a = connectivityManager;
    }

    private List<String> e() {
        String str;
        NetworkInfo activeNetworkInfo = this.f2472a.getActiveNetworkInfo();
        ArrayList arrayList = new ArrayList();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            arrayList.add(DevicePublicKeyStringDef.NONE);
            return arrayList;
        }
        int type = activeNetworkInfo.getType();
        if (type != 0) {
            if (type != 1) {
                if (type != 4 && type != 5) {
                    if (type != 6) {
                        str = type != 7 ? type != 9 ? type != 17 ? "other" : "vpn" : "ethernet" : "bluetooth";
                        arrayList.add(str);
                        return arrayList;
                    }
                }
            }
            str = "wifi";
            arrayList.add(str);
            return arrayList;
        }
        str = "mobile";
        arrayList.add(str);
        return arrayList;
    }

    List<String> a(Network network) {
        return b(this.f2472a.getNetworkCapabilities(network));
    }

    List<String> b(NetworkCapabilities networkCapabilities) {
        ArrayList arrayList = new ArrayList();
        if (networkCapabilities == null || !networkCapabilities.hasCapability(12)) {
            arrayList.add(DevicePublicKeyStringDef.NONE);
            return arrayList;
        }
        if (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(5)) {
            arrayList.add("wifi");
        }
        if (networkCapabilities.hasTransport(3)) {
            arrayList.add("ethernet");
        }
        if (networkCapabilities.hasTransport(4)) {
            arrayList.add("vpn");
        }
        if (networkCapabilities.hasTransport(0)) {
            arrayList.add("mobile");
        }
        if (networkCapabilities.hasTransport(2)) {
            arrayList.add("bluetooth");
        }
        if (arrayList.isEmpty() && networkCapabilities.hasCapability(12)) {
            arrayList.add("other");
        }
        if (arrayList.isEmpty()) {
            arrayList.add(DevicePublicKeyStringDef.NONE);
        }
        return arrayList;
    }

    public ConnectivityManager c() {
        return this.f2472a;
    }

    List<String> d() {
        Network activeNetwork;
        if (Build.VERSION.SDK_INT < 23) {
            return e();
        }
        activeNetwork = this.f2472a.getActiveNetwork();
        return a(activeNetwork);
    }
}
