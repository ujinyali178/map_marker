package com.google.maps.android;

import com.google.android.gms.maps.model.LatLng;
import i2.d;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import org.json.JSONObject;
import w2.t0;

/* loaded from: /root/release/classes.dex */
public final class StreetViewUtils {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ResponseStreetView deserializeResponse(String str) {
            String statusString = new JSONObject(str).optString("status");
            k.d(statusString, "statusString");
            return new ResponseStreetView(Status.valueOf(statusString));
        }

        public final Object fetchStreetViewData(LatLng latLng, String str, d<? super Status> dVar) {
            return w2.g.c(t0.b(), new StreetViewUtils$Companion$fetchStreetViewData$2("https://maps.googleapis.com/maps/api/streetview/metadata?location=" + latLng.latitude + ',' + latLng.longitude + "&key=" + str, null), dVar);
        }
    }
}
