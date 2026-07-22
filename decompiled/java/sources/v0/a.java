package v0;

import android.content.Context;
import java.io.File;
import java.util.UUID;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4397a = new a();

    private a() {
    }

    public final File a(Context context) {
        k.e(context, "context");
        String uuid = UUID.randomUUID().toString();
        k.d(uuid, "randomUUID().toString()");
        return new File(context.getCacheDir(), uuid);
    }
}
