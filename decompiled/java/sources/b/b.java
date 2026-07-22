package b;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import h2.n;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public class b extends b.a<String, List<Uri>> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1517a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final List<Uri> a(Intent intent) {
            k.e(intent, "<this>");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Uri data = intent.getData();
            if (data != null) {
                linkedHashSet.add(data);
            }
            ClipData clipData = intent.getClipData();
            if (clipData == null && linkedHashSet.isEmpty()) {
                return n.d();
            }
            if (clipData != null) {
                int itemCount = clipData.getItemCount();
                for (int i3 = 0; i3 < itemCount; i3++) {
                    Uri uri = clipData.getItemAt(i3).getUri();
                    if (uri != null) {
                        linkedHashSet.add(uri);
                    }
                }
            }
            return new ArrayList(linkedHashSet);
        }
    }
}
