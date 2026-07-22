package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

/* loaded from: /root/release/classes2.dex */
public class SizeFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 7388077430788600069L;
    private final boolean acceptLarger;
    private final long size;

    public SizeFileFilter(long j3) {
        this(j3, true);
    }

    public SizeFileFilter(long j3, boolean z3) {
        if (j3 < 0) {
            throw new IllegalArgumentException("The size must be non-negative");
        }
        this.size = j3;
        this.acceptLarger = z3;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        boolean z3 = file.length() < this.size;
        return this.acceptLarger ? !z3 : z3;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        return super.toString() + "(" + (this.acceptLarger ? ">=" : "<") + this.size + ")";
    }
}
