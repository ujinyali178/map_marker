package com.google.android.gms.common.server.response;

import java.io.BufferedReader;

/* loaded from: /root/release/classes.dex */
final class zab implements zai {
    zab() {
    }

    @Override // com.google.android.gms.common.server.response.zai
    public final /* synthetic */ Object zaa(FastParser fastParser, BufferedReader bufferedReader) {
        long zan;
        zan = fastParser.zan(bufferedReader);
        return Long.valueOf(zan);
    }
}
