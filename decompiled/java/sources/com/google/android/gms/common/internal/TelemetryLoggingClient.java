package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import com.google.errorprone.annotations.DoNotMock;
import com.google.errorprone.annotations.RestrictedInheritance;

@DoNotMock("Use canonical fakes instead. go/cheezhead-testing-methodology")
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", explanation = "Use canonical fakes instead.", link = "go/gmscore-restrictedinheritance")
/* loaded from: /root/release/classes.dex */
public interface TelemetryLoggingClient extends HasApiKey<TelemetryLoggingOptions> {
    Task<Void> log(TelemetryData telemetryData);
}
