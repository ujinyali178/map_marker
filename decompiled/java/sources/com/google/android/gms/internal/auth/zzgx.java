package com.google.android.gms.internal.auth;

import org.apache.commons.io.IOUtils;

/* loaded from: /root/release/classes.dex */
final class zzgx {
    static String zza(zzef zzefVar) {
        String str;
        StringBuilder sb = new StringBuilder(zzefVar.zzd());
        for (int i3 = 0; i3 < zzefVar.zzd(); i3++) {
            int zza = zzefVar.zza(i3);
            if (zza == 34) {
                str = "\\\"";
            } else if (zza == 39) {
                str = "\\'";
            } else if (zza != 92) {
                switch (zza) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (zza < 32 || zza > 126) {
                            sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                            sb.append((char) (((zza >>> 6) & 3) + 48));
                            sb.append((char) (((zza >>> 3) & 7) + 48));
                            zza = (zza & 7) + 48;
                        }
                        sb.append((char) zza);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
