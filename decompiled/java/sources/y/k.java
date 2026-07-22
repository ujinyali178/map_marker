package y;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import u1.n;

/* loaded from: /root/release/classes.dex */
public class k implements n.a {

    /* renamed from: c, reason: collision with root package name */
    private final List<p> f4630c = new CopyOnWriteArrayList();

    private boolean d(Context context) {
        try {
            return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    @Override // u1.n.a
    public boolean a(int i3, int i4, Intent intent) {
        Iterator<p> it = this.f4630c.iterator();
        while (it.hasNext()) {
            if (it.next().d(i3, i4)) {
                return true;
            }
        }
        return false;
    }

    public p b(Context context, boolean z3, z zVar) {
        if (!z3 && d(context)) {
            return new j(context, zVar);
        }
        return new q(context, zVar);
    }

    public void c(Context context, boolean z3, h0 h0Var, x.a aVar) {
        b(context, z3, null).c(h0Var, aVar);
    }

    public void e(Context context, a0 a0Var) {
        if (context == null) {
            a0Var.b(x.b.locationServicesDisabled);
        }
        b(context, false, null).a(a0Var);
    }

    public void f(p pVar, Activity activity, h0 h0Var, x.a aVar) {
        this.f4630c.add(pVar);
        pVar.b(activity, h0Var, aVar);
    }

    public void g(p pVar) {
        this.f4630c.remove(pVar);
        pVar.e();
    }
}
