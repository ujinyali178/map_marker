package com.google.android.gms.internal.play_billing;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /root/release/classes.dex */
abstract class zzer {
    private static final Logger zza = Logger.getLogger(zzee.class.getName());
    private static final String zzb = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    zzer() {
    }

    static zzej zzb(Class cls) {
        String format;
        ClassLoader classLoader = zzer.class.getClassLoader();
        if (cls.equals(zzej.class)) {
            format = zzb;
        } else {
            if (!cls.getPackage().equals(zzer.class.getPackage())) {
                throw new IllegalArgumentException(cls.getName());
            }
            format = String.format("%s.BlazeGenerated%sLoader", cls.getPackage().getName(), cls.getSimpleName());
        }
        try {
            try {
                try {
                    try {
                        return (zzej) cls.cast(((zzer) Class.forName(format, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zza());
                    } catch (IllegalAccessException e3) {
                        throw new IllegalStateException(e3);
                    }
                } catch (InvocationTargetException e4) {
                    throw new IllegalStateException(e4);
                }
            } catch (InstantiationException e5) {
                throw new IllegalStateException(e5);
            } catch (NoSuchMethodException e6) {
                throw new IllegalStateException(e6);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(zzer.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add((zzej) cls.cast(((zzer) it.next()).zza()));
                } catch (ServiceConfigurationError e7) {
                    zza.logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(cls.getSimpleName()), (Throwable) e7);
                }
            }
            if (arrayList.size() == 1) {
                return (zzej) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (zzej) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e8) {
                throw new IllegalStateException(e8);
            } catch (NoSuchMethodException e9) {
                throw new IllegalStateException(e9);
            } catch (InvocationTargetException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    protected abstract zzej zza();
}
