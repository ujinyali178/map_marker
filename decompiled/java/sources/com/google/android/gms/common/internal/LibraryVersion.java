package com.google.android.gms.common.internal;

import java.util.concurrent.ConcurrentHashMap;

@Deprecated
/* loaded from: /root/release/classes.dex */
public class LibraryVersion {
    private static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
    private static final LibraryVersion zzb = new LibraryVersion();
    private final ConcurrentHashMap zzc = new ConcurrentHashMap();

    protected LibraryVersion() {
    }

    public static LibraryVersion getInstance() {
        return zzb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009a  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getVersion(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "Failed to get app version for libraryName: "
            java.lang.String r1 = "LibraryVersion"
            java.lang.String r2 = "Please provide a valid libraryName"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9, r2)
            java.util.concurrent.ConcurrentHashMap r2 = r8.zzc
            boolean r2 = r2.containsKey(r9)
            if (r2 == 0) goto L1a
            java.util.concurrent.ConcurrentHashMap r0 = r8.zzc
            java.lang.Object r9 = r0.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            return r9
        L1a:
            java.util.Properties r2 = new java.util.Properties
            r2.<init>()
            r3 = 0
            java.lang.String r4 = "/%s.properties"
            r5 = 1
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            r6 = 0
            r5[r6] = r9     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            java.lang.Class<com.google.android.gms.common.internal.LibraryVersion> r5 = com.google.android.gms.common.internal.LibraryVersion.class
            java.io.InputStream r4 = r5.getResourceAsStream(r4)     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L7c
            if (r4 == 0) goto L58
            r2.load(r4)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            java.lang.String r5 = "version"
            java.lang.String r3 = r2.getProperty(r5, r3)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            com.google.android.gms.common.internal.GmsLogger r2 = com.google.android.gms.common.internal.LibraryVersion.zza     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            r5.<init>()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            r5.append(r9)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            java.lang.String r6 = " version is "
            r5.append(r6)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            r5.append(r3)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            r2.v(r1, r5)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            goto L6c
        L58:
            com.google.android.gms.common.internal.GmsLogger r2 = com.google.android.gms.common.internal.LibraryVersion.zza     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            r5.<init>()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            r5.append(r0)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            r5.append(r9)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            r2.w(r1, r5)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
        L6c:
            if (r4 == 0) goto L98
            com.google.android.gms.common.util.IOUtils.closeQuietly(r4)
            goto L98
        L72:
            r9 = move-exception
            r3 = r4
            goto La9
        L75:
            r2 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
            goto L7e
        L7a:
            r9 = move-exception
            goto La9
        L7c:
            r2 = move-exception
            r4 = r3
        L7e:
            com.google.android.gms.common.internal.GmsLogger r5 = com.google.android.gms.common.internal.LibraryVersion.zza     // Catch: java.lang.Throwable -> L7a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7a
            r6.<init>()     // Catch: java.lang.Throwable -> L7a
            r6.append(r0)     // Catch: java.lang.Throwable -> L7a
            r6.append(r9)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r0 = r6.toString()     // Catch: java.lang.Throwable -> L7a
            r5.e(r1, r0, r2)     // Catch: java.lang.Throwable -> L7a
            if (r3 == 0) goto L97
            com.google.android.gms.common.util.IOUtils.closeQuietly(r3)
        L97:
            r3 = r4
        L98:
            if (r3 != 0) goto La3
            com.google.android.gms.common.internal.GmsLogger r0 = com.google.android.gms.common.internal.LibraryVersion.zza
            java.lang.String r2 = ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used"
            r0.d(r1, r2)
            java.lang.String r3 = "UNKNOWN"
        La3:
            java.util.concurrent.ConcurrentHashMap r0 = r8.zzc
            r0.put(r9, r3)
            return r3
        La9:
            if (r3 == 0) goto Lae
            com.google.android.gms.common.util.IOUtils.closeQuietly(r3)
        Lae:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.LibraryVersion.getVersion(java.lang.String):java.lang.String");
    }
}
