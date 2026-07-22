package androidx.core.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
public final class e1 {

    /* renamed from: a, reason: collision with root package name */
    private final String f509a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f510b;

    /* renamed from: c, reason: collision with root package name */
    private final CharSequence[] f511c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f512d;

    /* renamed from: e, reason: collision with root package name */
    private final int f513e;

    /* renamed from: f, reason: collision with root package name */
    private final Bundle f514f;

    /* renamed from: g, reason: collision with root package name */
    private final Set<String> f515g;

    static class a {
        static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(e1 e1Var) {
            Set<String> d3;
            RemoteInput.Builder addExtras = new RemoteInput.Builder(e1Var.i()).setLabel(e1Var.h()).setChoices(e1Var.e()).setAllowFreeFormInput(e1Var.c()).addExtras(e1Var.g());
            if (Build.VERSION.SDK_INT >= 26 && (d3 = e1Var.d()) != null) {
                Iterator<String> it = d3.iterator();
                while (it.hasNext()) {
                    b.d(addExtras, it.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(addExtras, e1Var.f());
            }
            return addExtras.build();
        }

        static Bundle c(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    static class b {
        static void a(e1 e1Var, Intent intent, Map<String, Uri> map) {
            RemoteInput.addDataResultToIntent(e1.a(e1Var), intent, map);
        }

        static Set<String> b(Object obj) {
            Set<String> allowedDataTypes;
            allowedDataTypes = ((RemoteInput) obj).getAllowedDataTypes();
            return allowedDataTypes;
        }

        static Map<String, Uri> c(Intent intent, String str) {
            Map<String, Uri> dataResultsFromIntent;
            dataResultsFromIntent = RemoteInput.getDataResultsFromIntent(intent, str);
            return dataResultsFromIntent;
        }

        static RemoteInput.Builder d(RemoteInput.Builder builder, String str, boolean z3) {
            RemoteInput.Builder allowDataType;
            allowDataType = builder.setAllowDataType(str, z3);
            return allowDataType;
        }
    }

    static class c {
        static int a(Object obj) {
            int editChoicesBeforeSending;
            editChoicesBeforeSending = ((RemoteInput) obj).getEditChoicesBeforeSending();
            return editChoicesBeforeSending;
        }

        static RemoteInput.Builder b(RemoteInput.Builder builder, int i3) {
            RemoteInput.Builder editChoicesBeforeSending;
            editChoicesBeforeSending = builder.setEditChoicesBeforeSending(i3);
            return editChoicesBeforeSending;
        }
    }

    static RemoteInput a(e1 e1Var) {
        return a.b(e1Var);
    }

    static RemoteInput[] b(e1[] e1VarArr) {
        if (e1VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[e1VarArr.length];
        for (int i3 = 0; i3 < e1VarArr.length; i3++) {
            remoteInputArr[i3] = a(e1VarArr[i3]);
        }
        return remoteInputArr;
    }

    public boolean c() {
        return this.f512d;
    }

    public Set<String> d() {
        return this.f515g;
    }

    public CharSequence[] e() {
        return this.f511c;
    }

    public int f() {
        return this.f513e;
    }

    public Bundle g() {
        return this.f514f;
    }

    public CharSequence h() {
        return this.f510b;
    }

    public String i() {
        return this.f509a;
    }

    public boolean j() {
        return (c() || (e() != null && e().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }
}
