package com.google.android.gms.fido.fido2.api.common;

import android.net.Uri;

/* loaded from: /root/release/classes.dex */
public abstract class BrowserRequestOptions extends RequestOptions {
    public abstract byte[] getClientDataHash();

    public abstract Uri getOrigin();
}
