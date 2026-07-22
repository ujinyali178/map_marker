package com.google.maps.android;

import g2.l;
import g2.q;
import i2.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.k;
import n2.b;
import n2.m;
import p2.p;
import w2.g0;

@f(c = "com.google.maps.android.StreetViewUtils$Companion$fetchStreetViewData$2", f = "StreetViewUtil.kt", l = {}, m = "invokeSuspend")
/* loaded from: /root/release/classes.dex */
final class StreetViewUtils$Companion$fetchStreetViewData$2 extends k implements p<g0, d<? super Status>, Object> {
    final /* synthetic */ String $urlString;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreetViewUtils$Companion$fetchStreetViewData$2(String str, d<? super StreetViewUtils$Companion$fetchStreetViewData$2> dVar) {
        super(2, dVar);
        this.$urlString = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d<q> create(Object obj, d<?> dVar) {
        return new StreetViewUtils$Companion$fetchStreetViewData$2(this.$urlString, dVar);
    }

    @Override // p2.p
    public final Object invoke(g0 g0Var, d<? super Status> dVar) {
        return ((StreetViewUtils$Companion$fetchStreetViewData$2) create(g0Var, dVar)).invokeSuspend(q.f2555a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        ResponseStreetView deserializeResponse;
        j2.d.c();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.b(obj);
        try {
            URLConnection openConnection = new URL(this.$urlString).openConnection();
            kotlin.jvm.internal.k.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestMethod("GET");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                throw new IOException("HTTP Error: " + responseCode);
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                String c3 = m.c(bufferedReader);
                b.a(bufferedReader, null);
                bufferedReader.close();
                inputStream.close();
                deserializeResponse = StreetViewUtils.Companion.deserializeResponse(c3);
                return deserializeResponse.getStatus();
            } finally {
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            throw new IOException("Network error: " + e3.getMessage());
        }
    }
}
