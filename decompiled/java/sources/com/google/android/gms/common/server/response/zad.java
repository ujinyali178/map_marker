package com.google.android.gms.common.server.response;

import java.io.BufferedReader;

/* loaded from: /root/release/classes.dex */
final class zad implements zai {
    zad() {
    }

    @Override // com.google.android.gms.common.server.response.zai
    public final /* synthetic */ Object zaa(FastParser fastParser, BufferedReader bufferedReader) {
        double zaj;
        zaj = fastParser.zaj(bufferedReader);
        return Double.valueOf(zaj);
    }
}
