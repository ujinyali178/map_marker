package n2;

import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: /root/release/classes.dex */
public final class m {
    public static final long a(Reader reader, Writer out, int i3) {
        kotlin.jvm.internal.k.e(reader, "<this>");
        kotlin.jvm.internal.k.e(out, "out");
        char[] cArr = new char[i3];
        int read = reader.read(cArr);
        long j3 = 0;
        while (read >= 0) {
            out.write(cArr, 0, read);
            j3 += read;
            read = reader.read(cArr);
        }
        return j3;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 8192;
        }
        return a(reader, writer, i3);
    }

    public static final String c(Reader reader) {
        kotlin.jvm.internal.k.e(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        kotlin.jvm.internal.k.d(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }
}
