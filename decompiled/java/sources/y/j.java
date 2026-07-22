package y;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.security.SecureRandom;
import java.util.Objects;

/* loaded from: /root/release/classes.dex */
class j implements p {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4619a;

    /* renamed from: b, reason: collision with root package name */
    private final LocationCallback f4620b;

    /* renamed from: c, reason: collision with root package name */
    private final FusedLocationProviderClient f4621c;

    /* renamed from: d, reason: collision with root package name */
    private final g0 f4622d;

    /* renamed from: e, reason: collision with root package name */
    private final int f4623e = s();

    /* renamed from: f, reason: collision with root package name */
    private final z f4624f;

    /* renamed from: g, reason: collision with root package name */
    private x.a f4625g;

    /* renamed from: h, reason: collision with root package name */
    private h0 f4626h;

    class a extends LocationCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4627a;

        a(Context context) {
            this.f4627a = context;
        }

        @Override // com.google.android.gms.location.LocationCallback
        public synchronized void onLocationAvailability(LocationAvailability locationAvailability) {
            if (!locationAvailability.isLocationAvailable() && !j.this.r(this.f4627a) && j.this.f4625g != null) {
                j.this.f4625g.a(x.b.locationServicesDisabled);
            }
        }

        @Override // com.google.android.gms.location.LocationCallback
        public synchronized void onLocationResult(LocationResult locationResult) {
            if (j.this.f4626h != null) {
                Location lastLocation = locationResult.getLastLocation();
                j.this.f4622d.f(lastLocation);
                j.this.f4626h.a(lastLocation);
            } else {
                Log.e("FlutterGeolocator", "LocationCallback was called with empty locationResult or no positionChangedCallback was registered.");
                j.this.f4621c.removeLocationUpdates(j.this.f4620b);
                if (j.this.f4625g != null) {
                    j.this.f4625g.a(x.b.errorWhileAcquiringPosition);
                }
            }
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4629a;

        static {
            int[] iArr = new int[l.values().length];
            f4629a = iArr;
            try {
                iArr[l.lowest.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4629a[l.low.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4629a[l.medium.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public j(Context context, z zVar) {
        this.f4619a = context;
        this.f4621c = LocationServices.getFusedLocationProviderClient(context);
        this.f4624f = zVar;
        this.f4622d = new g0(context, zVar);
        this.f4620b = new a(context);
    }

    private static LocationRequest o(z zVar) {
        if (Build.VERSION.SDK_INT < 33) {
            return p(zVar);
        }
        LocationRequest.Builder builder = new LocationRequest.Builder(0L);
        if (zVar != null) {
            builder.setPriority(y(zVar.a()));
            builder.setIntervalMillis(zVar.c());
            builder.setMinUpdateIntervalMillis(zVar.c());
            builder.setMinUpdateDistanceMeters(zVar.b());
        }
        return builder.build();
    }

    private static LocationRequest p(z zVar) {
        LocationRequest create = LocationRequest.create();
        if (zVar != null) {
            create.setPriority(y(zVar.a()));
            create.setInterval(zVar.c());
            create.setFastestInterval(zVar.c() / 2);
            create.setSmallestDisplacement(zVar.b());
        }
        return create;
    }

    private static LocationSettingsRequest q(LocationRequest locationRequest) {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(locationRequest);
        return builder.build();
    }

    private synchronized int s() {
        return new SecureRandom().nextInt(65536);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(x.a aVar, Exception exc) {
        Log.e("Geolocator", "Error trying to get last the last known GPS location");
        if (aVar != null) {
            aVar.a(x.b.errorWhileAcquiringPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(a0 a0Var, Task task) {
        if (!task.isSuccessful()) {
            a0Var.b(x.b.locationServicesDisabled);
        }
        LocationSettingsResponse locationSettingsResponse = (LocationSettingsResponse) task.getResult();
        if (locationSettingsResponse == null) {
            a0Var.b(x.b.locationServicesDisabled);
            return;
        }
        LocationSettingsStates locationSettingsStates = locationSettingsResponse.getLocationSettingsStates();
        boolean z3 = true;
        boolean z4 = locationSettingsStates != null && locationSettingsStates.isGpsUsable();
        boolean z5 = locationSettingsStates != null && locationSettingsStates.isNetworkLocationUsable();
        if (!z4 && !z5) {
            z3 = false;
        }
        a0Var.a(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(LocationSettingsResponse locationSettingsResponse) {
        x(this.f4624f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(Activity activity, x.a aVar, Exception exc) {
        if (exc instanceof ResolvableApiException) {
            if (activity == null) {
                aVar.a(x.b.locationServicesDisabled);
                return;
            }
            ResolvableApiException resolvableApiException = (ResolvableApiException) exc;
            if (resolvableApiException.getStatusCode() == 6) {
                try {
                    resolvableApiException.startResolutionForResult(activity, this.f4623e);
                    return;
                } catch (IntentSender.SendIntentException unused) {
                }
            }
        } else if (((ApiException) exc).getStatusCode() == 8502) {
            x(this.f4624f);
            return;
        }
        aVar.a(x.b.locationServicesDisabled);
    }

    private void x(z zVar) {
        LocationRequest o3 = o(zVar);
        this.f4622d.h();
        this.f4621c.requestLocationUpdates(o3, this.f4620b, Looper.getMainLooper());
    }

    private static int y(l lVar) {
        int i3 = b.f4629a[lVar.ordinal()];
        if (i3 == 1) {
            return 105;
        }
        if (i3 != 2) {
            return i3 != 3 ? 100 : 102;
        }
        return 104;
    }

    @Override // y.p
    public void a(final a0 a0Var) {
        LocationServices.getSettingsClient(this.f4619a).checkLocationSettings(new LocationSettingsRequest.Builder().build()).addOnCompleteListener(new OnCompleteListener() { // from class: y.e
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                j.u(a0.this, task);
            }
        });
    }

    @Override // y.p
    public void b(final Activity activity, h0 h0Var, final x.a aVar) {
        this.f4626h = h0Var;
        this.f4625g = aVar;
        LocationServices.getSettingsClient(this.f4619a).checkLocationSettings(q(o(this.f4624f))).addOnSuccessListener(new OnSuccessListener() { // from class: y.h
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                j.this.v((LocationSettingsResponse) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: y.i
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                j.this.w(activity, aVar, exc);
            }
        });
    }

    @Override // y.p
    public void c(final h0 h0Var, final x.a aVar) {
        Task<Location> lastLocation = this.f4621c.getLastLocation();
        Objects.requireNonNull(h0Var);
        lastLocation.addOnSuccessListener(new OnSuccessListener() { // from class: y.f
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                h0.this.a((Location) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: y.g
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                j.t(x.a.this, exc);
            }
        });
    }

    @Override // y.p
    public boolean d(int i3, int i4) {
        if (i3 == this.f4623e) {
            if (i4 == -1) {
                z zVar = this.f4624f;
                if (zVar == null || this.f4626h == null || this.f4625g == null) {
                    return false;
                }
                x(zVar);
                return true;
            }
            x.a aVar = this.f4625g;
            if (aVar != null) {
                aVar.a(x.b.locationServicesDisabled);
            }
        }
        return false;
    }

    @Override // y.p
    public void e() {
        this.f4622d.i();
        this.f4621c.removeLocationUpdates(this.f4620b);
    }

    public /* synthetic */ boolean r(Context context) {
        return o.a(this, context);
    }
}
