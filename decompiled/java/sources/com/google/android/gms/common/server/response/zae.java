package com.google.android.gms.common.server.response;

import java.io.BufferedReader;

/* loaded from: /root/release/classes.dex */
final class zae implements zai {
    zae() {
    }

    @Override // com.google.android.gms.common.server.response.zai
    public final /* bridge */ /* synthetic */ Object zaa(FastParser fastParser, BufferedReader bufferedReader) {
        boolean zay;
        zay = fastParser.zay(bufferedReader, false);
        return Boolean.valueOf(zay);
    }
}
