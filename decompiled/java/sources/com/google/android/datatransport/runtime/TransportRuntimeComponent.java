package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistryModule;
import com.google.android.datatransport.runtime.dagger.BindsInstance;
import com.google.android.datatransport.runtime.dagger.Component;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule;
import com.google.android.datatransport.runtime.time.TimeModule;
import java.io.Closeable;
import javax.inject.Singleton;

@Singleton
@Component(modules = {BackendRegistryModule.class, EventStoreModule.class, ExecutionModule.class, SchedulingModule.class, SchedulingConfigModule.class, TimeModule.class})
/* loaded from: /root/release/classes.dex */
abstract class TransportRuntimeComponent implements Closeable {

    @Component.Builder
    interface Builder {
        TransportRuntimeComponent build();

        @BindsInstance
        Builder setApplicationContext(Context context);
    }

    TransportRuntimeComponent() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        getEventStore().close();
    }

    abstract EventStore getEventStore();

    abstract TransportRuntime getTransportRuntime();
}
