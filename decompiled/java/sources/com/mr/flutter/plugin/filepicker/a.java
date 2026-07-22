package com.mr.flutter.plugin.filepicker;

import android.net.Uri;
import java.util.HashMap;

/* loaded from: /root/release/classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    final String f2403a;

    /* renamed from: b, reason: collision with root package name */
    final String f2404b;

    /* renamed from: c, reason: collision with root package name */
    final Uri f2405c;

    /* renamed from: d, reason: collision with root package name */
    final long f2406d;

    /* renamed from: e, reason: collision with root package name */
    final byte[] f2407e;

    /* renamed from: com.mr.flutter.plugin.filepicker.a$a, reason: collision with other inner class name */
    public static class C0068a {

        /* renamed from: a, reason: collision with root package name */
        private String f2408a;

        /* renamed from: b, reason: collision with root package name */
        private String f2409b;

        /* renamed from: c, reason: collision with root package name */
        private Uri f2410c;

        /* renamed from: d, reason: collision with root package name */
        private long f2411d;

        /* renamed from: e, reason: collision with root package name */
        private byte[] f2412e;

        public a a() {
            return new a(this.f2408a, this.f2409b, this.f2410c, this.f2411d, this.f2412e);
        }

        public C0068a b(byte[] bArr) {
            this.f2412e = bArr;
            return this;
        }

        public C0068a c(String str) {
            this.f2409b = str;
            return this;
        }

        public C0068a d(String str) {
            this.f2408a = str;
            return this;
        }

        public C0068a e(long j3) {
            this.f2411d = j3;
            return this;
        }

        public C0068a f(Uri uri) {
            this.f2410c = uri;
            return this;
        }
    }

    public a(String str, String str2, Uri uri, long j3, byte[] bArr) {
        this.f2403a = str;
        this.f2404b = str2;
        this.f2406d = j3;
        this.f2407e = bArr;
        this.f2405c = uri;
    }

    public HashMap<String, Object> a() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("path", this.f2403a);
        hashMap.put("name", this.f2404b);
        hashMap.put("size", Long.valueOf(this.f2406d));
        hashMap.put("bytes", this.f2407e);
        hashMap.put("identifier", this.f2405c.toString());
        return hashMap;
    }
}
