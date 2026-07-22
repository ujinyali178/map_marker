package n2;

import java.io.File;

/* loaded from: /root/release/classes.dex */
public final class l extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(File file, File file2, String str) {
        super(file, file2, str);
        kotlin.jvm.internal.k.e(file, "file");
    }

    public /* synthetic */ l(File file, File file2, String str, int i3, kotlin.jvm.internal.g gVar) {
        this(file, (i3 & 2) != 0 ? null : file2, (i3 & 4) != 0 ? null : str);
    }
}
