package com.google.common.escape;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class Platform {
    private static final ThreadLocal<char[]> DEST_TL = new ThreadLocal<char[]>() { // from class: com.google.common.escape.Platform.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public char[] initialValue() {
            return new char[UserVerificationMethods.USER_VERIFY_ALL];
        }
    };

    private Platform() {
    }

    static char[] charBufferFromThreadLocal() {
        return DEST_TL.get();
    }
}
