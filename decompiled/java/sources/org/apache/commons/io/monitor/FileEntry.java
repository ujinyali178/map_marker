package org.apache.commons.io.monitor;

import java.io.File;
import java.io.Serializable;

/* loaded from: /root/release/classes2.dex */
public class FileEntry implements Serializable {
    static final FileEntry[] EMPTY_ENTRIES = new FileEntry[0];
    private static final long serialVersionUID = -2505664948818681153L;
    private FileEntry[] children;
    private boolean directory;
    private boolean exists;
    private final File file;
    private long lastModified;
    private long length;
    private String name;
    private final FileEntry parent;

    public FileEntry(File file) {
        this(null, file);
    }

    public FileEntry(FileEntry fileEntry, File file) {
        if (file == null) {
            throw new IllegalArgumentException("File is missing");
        }
        this.file = file;
        this.parent = fileEntry;
        this.name = file.getName();
    }

    public FileEntry[] getChildren() {
        FileEntry[] fileEntryArr = this.children;
        return fileEntryArr != null ? fileEntryArr : EMPTY_ENTRIES;
    }

    public File getFile() {
        return this.file;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public long getLength() {
        return this.length;
    }

    public int getLevel() {
        FileEntry fileEntry = this.parent;
        if (fileEntry == null) {
            return 0;
        }
        return fileEntry.getLevel() + 1;
    }

    public String getName() {
        return this.name;
    }

    public FileEntry getParent() {
        return this.parent;
    }

    public boolean isDirectory() {
        return this.directory;
    }

    public boolean isExists() {
        return this.exists;
    }

    public FileEntry newChildInstance(File file) {
        return new FileEntry(this, file);
    }

    public boolean refresh(File file) {
        boolean z3 = this.exists;
        long j3 = this.lastModified;
        boolean z4 = this.directory;
        long j4 = this.length;
        this.name = file.getName();
        boolean exists = file.exists();
        this.exists = exists;
        this.directory = exists && file.isDirectory();
        long j5 = 0;
        this.lastModified = this.exists ? file.lastModified() : 0L;
        if (this.exists && !this.directory) {
            j5 = file.length();
        }
        this.length = j5;
        return (this.exists == z3 && this.lastModified == j3 && this.directory == z4 && j5 == j4) ? false : true;
    }

    public void setChildren(FileEntry[] fileEntryArr) {
        this.children = fileEntryArr;
    }

    public void setDirectory(boolean z3) {
        this.directory = z3;
    }

    public void setExists(boolean z3) {
        this.exists = z3;
    }

    public void setLastModified(long j3) {
        this.lastModified = j3;
    }

    public void setLength(long j3) {
        this.length = j3;
    }

    public void setName(String str) {
        this.name = str;
    }
}
