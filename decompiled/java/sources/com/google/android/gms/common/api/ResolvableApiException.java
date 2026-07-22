package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;

/* loaded from: /root/release/classes.dex */
public class ResolvableApiException extends ApiException {
    public ResolvableApiException(Status status) {
        super(status);
    }

    public PendingIntent getResolution() {
        return getStatus().getResolution();
    }

    public void startResolutionForResult(Activity activity, int i3) {
        getStatus().startResolutionForResult(activity, i3);
    }
}
