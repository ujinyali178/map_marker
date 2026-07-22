package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: /root/release/classes.dex */
public class BaseImplementation {

    public static abstract class ApiMethodImpl<R extends Result, A extends Api.AnyClient> extends BasePendingResult<R> implements ResultHolder<R> {
        private final Api<?> mApi;
        private final Api.AnyClientKey<A> mClientKey;

        @Deprecated
        protected ApiMethodImpl(Api.AnyClientKey<A> anyClientKey, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) Preconditions.checkNotNull(googleApiClient, "GoogleApiClient must not be null"));
            this.mClientKey = (Api.AnyClientKey) Preconditions.checkNotNull(anyClientKey);
            this.mApi = null;
        }

        protected ApiMethodImpl(Api<?> api, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) Preconditions.checkNotNull(googleApiClient, "GoogleApiClient must not be null"));
            Preconditions.checkNotNull(api, "Api must not be null");
            this.mClientKey = api.zab();
            this.mApi = api;
        }

        protected ApiMethodImpl(BasePendingResult.CallbackHandler<R> callbackHandler) {
            super(callbackHandler);
            this.mClientKey = new Api.AnyClientKey<>();
            this.mApi = null;
        }

        private void setFailedResult(RemoteException remoteException) {
            setFailedResult(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
        }

        protected abstract void doExecute(A a4);

        public final Api<?> getApi() {
            return this.mApi;
        }

        public final Api.AnyClientKey<A> getClientKey() {
            return this.mClientKey;
        }

        protected void onSetFailedResult(R r3) {
        }

        public final void run(A a4) {
            try {
                doExecute(a4);
            } catch (DeadObjectException e3) {
                setFailedResult(e3);
                throw e3;
            } catch (RemoteException e4) {
                setFailedResult(e4);
            }
        }

        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        public final void setFailedResult(Status status) {
            Preconditions.checkArgument(!status.isSuccess(), "Failed result must not be success");
            R createFailedResult = createFailedResult(status);
            setResult((ApiMethodImpl<R, A>) createFailedResult);
            onSetFailedResult(createFailedResult);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            super.setResult((ApiMethodImpl<R, A>) obj);
        }
    }

    public interface ResultHolder<R> {
        void setFailedResult(Status status);

        void setResult(R r3);
    }
}
