package com.google.android.gms.common.server.response;

import java.io.BufferedReader;
import java.math.BigDecimal;

/* loaded from: /root/release/classes.dex */
final class zah implements zai {
    zah() {
    }

    @Override // com.google.android.gms.common.server.response.zai
    public final /* synthetic */ Object zaa(FastParser fastParser, BufferedReader bufferedReader) {
        BigDecimal zas;
        zas = fastParser.zas(bufferedReader);
        return zas;
    }
}
