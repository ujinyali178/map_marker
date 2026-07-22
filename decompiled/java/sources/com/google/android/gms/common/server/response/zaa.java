package com.google.android.gms.common.server.response;

import java.io.BufferedReader;

/* loaded from: /root/release/classes.dex */
final class zaa implements zai {
    zaa() {
    }

    @Override // com.google.android.gms.common.server.response.zai
    public final /* synthetic */ Object zaa(FastParser fastParser, BufferedReader bufferedReader) {
        int zal;
        zal = fastParser.zal(bufferedReader);
        return Integer.valueOf(zal);
    }
}
