package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: /root/release/classes.dex */
public abstract class RemoteCreator<T> {
    private final String zza;
    private Object zzb;

    public static class RemoteCreatorException extends Exception {
        public RemoteCreatorException(String str) {
            super(str);
        }

        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    protected RemoteCreator(String str) {
        this.zza = str;
    }

    protected abstract T getRemoteCreator(IBinder iBinder);

    protected final T getRemoteCreatorInstance(Context context) {
        if (this.zzb == null) {
            Preconditions.checkNotNull(context);
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext == null) {
                throw new RemoteCreatorException("Could not get remote context.");
            }
            try {
                this.zzb = getRemoteCreator((IBinder) remoteContext.getClassLoader().loadClass(this.zza).newInstance());
            } catch (ClassNotFoundException e3) {
                throw new RemoteCreatorException("Could not load creator class.", e3);
            } catch (IllegalAccessException e4) {
                throw new RemoteCreatorException("Could not access creator.", e4);
            } catch (InstantiationException e5) {
                throw new RemoteCreatorException("Could not instantiate creator.", e5);
            }
        }
        return (T) this.zzb;
    }
}
