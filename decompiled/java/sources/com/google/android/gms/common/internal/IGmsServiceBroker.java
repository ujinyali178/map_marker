package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: /root/release/classes.dex */
public interface IGmsServiceBroker extends IInterface {

    public static abstract class Stub extends Binder implements IGmsServiceBroker {
        public Stub() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x009d, code lost:
        
            if (r5.readInt() != 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00e4, code lost:
        
            r4 = (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00ba, code lost:
        
            if (r5.readInt() != 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00cb, code lost:
        
            if (r5.readInt() != 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00d2, code lost:
        
            if (r5.readInt() != 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00e2, code lost:
        
            if (r5.readInt() != 0) goto L69;
         */
        @Override // android.os.Binder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) {
            /*
                Method dump skipped, instructions count: 278
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.IGmsServiceBroker.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest);
}
