package n2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes.dex */
public class k extends j {
    public static final File b(File file, File target, boolean z3, int i3) {
        kotlin.jvm.internal.k.e(file, "<this>");
        kotlin.jvm.internal.k.e(target, "target");
        if (!file.exists()) {
            throw new l(file, null, "The source file doesn't exist.", 2, null);
        }
        if (target.exists()) {
            if (!z3) {
                throw new e(file, target, "The destination file already exists.");
            }
            if (!target.delete()) {
                throw new e(file, target, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (!file.isDirectory()) {
            File parentFile = target.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(target);
                try {
                    a.a(fileInputStream, fileOutputStream, i3);
                    b.a(fileOutputStream, null);
                    b.a(fileInputStream, null);
                } finally {
                }
            } finally {
            }
        } else if (!target.mkdirs()) {
            throw new f(file, target, "Failed to create target directory.");
        }
        return target;
    }

    public static /* synthetic */ File c(File file, File file2, boolean z3, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        if ((i4 & 4) != 0) {
            i3 = 8192;
        }
        return b(file, file2, z3, i3);
    }
}
