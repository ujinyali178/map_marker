package org.apache.commons.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

/* loaded from: /root/release/classes2.dex */
public abstract class DirectoryWalker<T> {
    private final int depthLimit;
    private final FileFilter filter;

    public static class CancelException extends IOException {
        private static final long serialVersionUID = 1347339620135041008L;
        private final int depth;
        private final File file;

        public CancelException(File file, int i3) {
            this("Operation Cancelled", file, i3);
        }

        public CancelException(String str, File file, int i3) {
            super(str);
            this.file = file;
            this.depth = i3;
        }

        public int getDepth() {
            return this.depth;
        }

        public File getFile() {
            return this.file;
        }
    }

    protected DirectoryWalker() {
        this(null, -1);
    }

    protected DirectoryWalker(FileFilter fileFilter, int i3) {
        this.filter = fileFilter;
        this.depthLimit = i3;
    }

    protected DirectoryWalker(IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2, int i3) {
        IOFileFilter or;
        if (iOFileFilter == null && iOFileFilter2 == null) {
            or = null;
        } else {
            or = FileFilterUtils.or(FileFilterUtils.makeDirectoryOnly(iOFileFilter == null ? TrueFileFilter.TRUE : iOFileFilter), FileFilterUtils.makeFileOnly(iOFileFilter2 == null ? TrueFileFilter.TRUE : iOFileFilter2));
        }
        this.filter = or;
        this.depthLimit = i3;
    }

    private void walk(File file, int i3, Collection<T> collection) {
        checkIfCancelled(file, i3, collection);
        if (handleDirectory(file, i3, collection)) {
            handleDirectoryStart(file, i3, collection);
            int i4 = i3 + 1;
            int i5 = this.depthLimit;
            if (i5 < 0 || i4 <= i5) {
                checkIfCancelled(file, i3, collection);
                FileFilter fileFilter = this.filter;
                File[] filterDirectoryContents = filterDirectoryContents(file, i3, fileFilter == null ? file.listFiles() : file.listFiles(fileFilter));
                if (filterDirectoryContents == null) {
                    handleRestricted(file, i4, collection);
                } else {
                    for (File file2 : filterDirectoryContents) {
                        if (file2.isDirectory()) {
                            walk(file2, i4, collection);
                        } else {
                            checkIfCancelled(file2, i4, collection);
                            handleFile(file2, i4, collection);
                            checkIfCancelled(file2, i4, collection);
                        }
                    }
                }
            }
            handleDirectoryEnd(file, i3, collection);
        }
        checkIfCancelled(file, i3, collection);
    }

    protected final void checkIfCancelled(File file, int i3, Collection<T> collection) {
        if (handleIsCancelled(file, i3, collection)) {
            throw new CancelException(file, i3);
        }
    }

    protected File[] filterDirectoryContents(File file, int i3, File[] fileArr) {
        return fileArr;
    }

    protected void handleCancelled(File file, Collection<T> collection, CancelException cancelException) {
        throw cancelException;
    }

    protected boolean handleDirectory(File file, int i3, Collection<T> collection) {
        return true;
    }

    protected void handleDirectoryEnd(File file, int i3, Collection<T> collection) {
    }

    protected void handleDirectoryStart(File file, int i3, Collection<T> collection) {
    }

    protected void handleEnd(Collection<T> collection) {
    }

    protected void handleFile(File file, int i3, Collection<T> collection) {
    }

    protected boolean handleIsCancelled(File file, int i3, Collection<T> collection) {
        return false;
    }

    protected void handleRestricted(File file, int i3, Collection<T> collection) {
    }

    protected void handleStart(File file, Collection<T> collection) {
    }

    protected final void walk(File file, Collection<T> collection) {
        if (file == null) {
            throw new NullPointerException("Start Directory is null");
        }
        try {
            handleStart(file, collection);
            walk(file, 0, collection);
            handleEnd(collection);
        } catch (CancelException e3) {
            handleCancelled(file, collection, e3);
        }
    }
}
