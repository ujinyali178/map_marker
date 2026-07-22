package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import android.os.Bundle;
import androidx.loader.app.a;
import androidx.loader.content.b;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: /root/release/classes.dex */
final class zbw implements a.InterfaceC0028a {
    final /* synthetic */ SignInHubActivity zba;

    /* synthetic */ zbw(SignInHubActivity signInHubActivity, zbv zbvVar) {
        this.zba = signInHubActivity;
    }

    @Override // androidx.loader.app.a.InterfaceC0028a
    public final b onCreateLoader(int i3, Bundle bundle) {
        return new zbc(this.zba, GoogleApiClient.getAllClients());
    }

    @Override // androidx.loader.app.a.InterfaceC0028a
    public final /* bridge */ /* synthetic */ void onLoadFinished(b bVar, Object obj) {
        int i3;
        Intent intent;
        SignInHubActivity signInHubActivity = this.zba;
        i3 = signInHubActivity.zbe;
        intent = signInHubActivity.zbf;
        signInHubActivity.setResult(i3, intent);
        this.zba.finish();
    }

    @Override // androidx.loader.app.a.InterfaceC0028a
    public final void onLoaderReset(b bVar) {
    }
}
