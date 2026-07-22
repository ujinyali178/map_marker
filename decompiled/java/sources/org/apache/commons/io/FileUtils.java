package org.apache.commons.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.output.NullOutputStream;

/* loaded from: /root/release/classes2.dex */
public class FileUtils {
    public static final File[] EMPTY_FILE_ARRAY;
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final long ONE_EB = 1152921504606846976L;
    public static final BigInteger ONE_EB_BI;
    public static final long ONE_GB = 1073741824;
    public static final BigInteger ONE_GB_BI;
    public static final long ONE_KB = 1024;
    public static final BigInteger ONE_KB_BI;
    public static final long ONE_MB = 1048576;
    public static final BigInteger ONE_MB_BI;
    public static final long ONE_PB = 1125899906842624L;
    public static final BigInteger ONE_PB_BI;
    public static final long ONE_TB = 1099511627776L;
    public static final BigInteger ONE_TB_BI;
    public static final BigInteger ONE_YB;
    public static final BigInteger ONE_ZB;

    static {
        BigInteger valueOf = BigInteger.valueOf(ONE_KB);
        ONE_KB_BI = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        ONE_MB_BI = multiply;
        BigInteger multiply2 = valueOf.multiply(multiply);
        ONE_GB_BI = multiply2;
        BigInteger multiply3 = valueOf.multiply(multiply2);
        ONE_TB_BI = multiply3;
        BigInteger multiply4 = valueOf.multiply(multiply3);
        ONE_PB_BI = multiply4;
        ONE_EB_BI = valueOf.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(ONE_KB).multiply(BigInteger.valueOf(ONE_EB));
        ONE_ZB = multiply5;
        ONE_YB = valueOf.multiply(multiply5);
        EMPTY_FILE_ARRAY = new File[0];
    }

    public static String byteCountToDisplaySize(long j3) {
        return byteCountToDisplaySize(BigInteger.valueOf(j3));
    }

    public static String byteCountToDisplaySize(BigInteger bigInteger) {
        StringBuilder sb;
        String str;
        BigInteger bigInteger2 = ONE_EB_BI;
        BigInteger divide = bigInteger.divide(bigInteger2);
        BigInteger bigInteger3 = BigInteger.ZERO;
        if (divide.compareTo(bigInteger3) > 0) {
            sb = new StringBuilder();
            sb.append(String.valueOf(bigInteger.divide(bigInteger2)));
            str = " EB";
        } else {
            BigInteger bigInteger4 = ONE_PB_BI;
            if (bigInteger.divide(bigInteger4).compareTo(bigInteger3) > 0) {
                sb = new StringBuilder();
                sb.append(String.valueOf(bigInteger.divide(bigInteger4)));
                str = " PB";
            } else {
                BigInteger bigInteger5 = ONE_TB_BI;
                if (bigInteger.divide(bigInteger5).compareTo(bigInteger3) > 0) {
                    sb = new StringBuilder();
                    sb.append(String.valueOf(bigInteger.divide(bigInteger5)));
                    str = " TB";
                } else {
                    BigInteger bigInteger6 = ONE_GB_BI;
                    if (bigInteger.divide(bigInteger6).compareTo(bigInteger3) > 0) {
                        sb = new StringBuilder();
                        sb.append(String.valueOf(bigInteger.divide(bigInteger6)));
                        str = " GB";
                    } else {
                        BigInteger bigInteger7 = ONE_MB_BI;
                        if (bigInteger.divide(bigInteger7).compareTo(bigInteger3) > 0) {
                            sb = new StringBuilder();
                            sb.append(String.valueOf(bigInteger.divide(bigInteger7)));
                            str = " MB";
                        } else {
                            BigInteger bigInteger8 = ONE_KB_BI;
                            if (bigInteger.divide(bigInteger8).compareTo(bigInteger3) <= 0) {
                                return String.valueOf(bigInteger) + " bytes";
                            }
                            sb = new StringBuilder();
                            sb.append(String.valueOf(bigInteger.divide(bigInteger8)));
                            str = " KB";
                        }
                    }
                }
            }
        }
        sb.append(str);
        return sb.toString();
    }

    private static void checkDirectory(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (file.isDirectory()) {
            return;
        }
        throw new IllegalArgumentException(file + " is not a directory");
    }

    private static void checkFileRequirements(File file, File file2) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (file.exists()) {
            return;
        }
        throw new FileNotFoundException("Source '" + file + "' does not exist");
    }

    public static Checksum checksum(File file, Checksum checksum) {
        if (file.isDirectory()) {
            throw new IllegalArgumentException("Checksums can't be computed on directories");
        }
        CheckedInputStream checkedInputStream = new CheckedInputStream(new FileInputStream(file), checksum);
        try {
            IOUtils.copy(checkedInputStream, new NullOutputStream());
            checkedInputStream.close();
            return checksum;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    checkedInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static long checksumCRC32(File file) {
        CRC32 crc32 = new CRC32();
        checksum(file, crc32);
        return crc32.getValue();
    }

    public static void cleanDirectory(File file) {
        IOException e3 = null;
        for (File file2 : verifiedListFiles(file)) {
            try {
                forceDelete(file2);
            } catch (IOException e4) {
                e3 = e4;
            }
        }
        if (e3 != null) {
            throw e3;
        }
    }

    private static void cleanDirectoryOnExit(File file) {
        IOException e3 = null;
        for (File file2 : verifiedListFiles(file)) {
            try {
                forceDeleteOnExit(file2);
            } catch (IOException e4) {
                e3 = e4;
            }
        }
        if (e3 != null) {
            throw e3;
        }
    }

    public static boolean contentEquals(File file, File file2) {
        boolean exists = file.exists();
        if (exists != file2.exists()) {
            return false;
        }
        if (!exists) {
            return true;
        }
        if (file.isDirectory() || file2.isDirectory()) {
            throw new IOException("Can't compare directories, only files");
        }
        if (file.length() != file2.length()) {
            return false;
        }
        if (file.getCanonicalFile().equals(file2.getCanonicalFile())) {
            return true;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            try {
                boolean contentEquals = IOUtils.contentEquals(fileInputStream, fileInputStream2);
                fileInputStream2.close();
                fileInputStream.close();
                return contentEquals;
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static boolean contentEqualsIgnoreEOL(File file, File file2, String str) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        boolean exists = file.exists();
        if (exists != file2.exists()) {
            return false;
        }
        if (!exists) {
            return true;
        }
        if (file.isDirectory() || file2.isDirectory()) {
            throw new IOException("Can't compare directories, only files");
        }
        if (file.getCanonicalFile().equals(file2.getCanonicalFile())) {
            return true;
        }
        if (str == null) {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream, Charset.defaultCharset());
        } else {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream, str);
        }
        try {
            InputStreamReader inputStreamReader2 = str == null ? new InputStreamReader(new FileInputStream(file2), Charset.defaultCharset()) : new InputStreamReader(new FileInputStream(file2), str);
            try {
                boolean contentEqualsIgnoreEOL = IOUtils.contentEqualsIgnoreEOL(inputStreamReader, inputStreamReader2);
                inputStreamReader2.close();
                inputStreamReader.close();
                return contentEqualsIgnoreEOL;
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    inputStreamReader.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static File[] convertFileCollectionToFileArray(Collection<File> collection) {
        return (File[]) collection.toArray(new File[collection.size()]);
    }

    public static void copyDirectory(File file, File file2) {
        copyDirectory(file, file2, true);
    }

    public static void copyDirectory(File file, File file2, FileFilter fileFilter) {
        copyDirectory(file, file2, fileFilter, true);
    }

    public static void copyDirectory(File file, File file2, FileFilter fileFilter, boolean z3) {
        checkFileRequirements(file, file2);
        if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is not a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        ArrayList arrayList = null;
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
            if (listFiles != null && listFiles.length > 0) {
                arrayList = new ArrayList(listFiles.length);
                for (File file3 : listFiles) {
                    arrayList.add(new File(file2, file3.getName()).getCanonicalPath());
                }
            }
        }
        doCopyDirectory(file, file2, fileFilter, z3, arrayList);
    }

    public static void copyDirectory(File file, File file2, boolean z3) {
        copyDirectory(file, file2, null, z3);
    }

    public static void copyDirectoryToDirectory(File file, File file2) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file.exists() && !file.isDirectory()) {
            throw new IllegalArgumentException("Source '" + file2 + "' is not a directory");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file2.exists() || file2.isDirectory()) {
            copyDirectory(file, new File(file2, file.getName()), true);
            return;
        }
        throw new IllegalArgumentException("Destination '" + file2 + "' is not a directory");
    }

    public static long copyFile(File file, OutputStream outputStream) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long copyLarge = IOUtils.copyLarge(fileInputStream, outputStream);
            fileInputStream.close();
            return copyLarge;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static void copyFile(File file, File file2) {
        copyFile(file, file2, true);
    }

    public static void copyFile(File file, File file2, boolean z3) {
        checkFileRequirements(file, file2);
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException("Destination '" + parentFile + "' directory cannot be created");
        }
        if (!file2.exists() || file2.canWrite()) {
            doCopyFile(file, file2, z3);
            return;
        }
        throw new IOException("Destination '" + file2 + "' exists but is read-only");
    }

    public static void copyFileToDirectory(File file, File file2) {
        copyFileToDirectory(file, file2, true);
    }

    public static void copyFileToDirectory(File file, File file2, boolean z3) {
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file2.exists() || file2.isDirectory()) {
            copyFile(file, new File(file2, file.getName()), z3);
            return;
        }
        throw new IllegalArgumentException("Destination '" + file2 + "' is not a directory");
    }

    public static void copyInputStreamToFile(InputStream inputStream, File file) {
        try {
            copyToFile(inputStream, file);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static void copyToDirectory(File file, File file2) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file.isFile()) {
            copyFileToDirectory(file, file2);
            return;
        }
        if (file.isDirectory()) {
            copyDirectoryToDirectory(file, file2);
            return;
        }
        throw new IOException("The source " + file + " does not exist");
    }

    public static void copyToDirectory(Iterable<File> iterable, File file) {
        if (iterable == null) {
            throw new NullPointerException("Sources must not be null");
        }
        Iterator<File> it = iterable.iterator();
        while (it.hasNext()) {
            copyFileToDirectory(it.next(), file);
        }
    }

    public static void copyToFile(InputStream inputStream, File file) {
        try {
            FileOutputStream openOutputStream = openOutputStream(file);
            try {
                IOUtils.copy(inputStream, openOutputStream);
                if (openOutputStream != null) {
                    openOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static void copyURLToFile(URL url, File file) {
        copyInputStreamToFile(url.openStream(), file);
    }

    public static void copyURLToFile(URL url, File file, int i3, int i4) {
        URLConnection openConnection = url.openConnection();
        openConnection.setConnectTimeout(i3);
        openConnection.setReadTimeout(i4);
        copyInputStreamToFile(openConnection.getInputStream(), file);
    }

    static String decodeUrl(String str) {
        int i3;
        if (str == null || str.indexOf(37) < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        ByteBuffer allocate = ByteBuffer.allocate(length);
        int i4 = 0;
        while (i4 < length) {
            if (str.charAt(i4) == '%') {
                while (true) {
                    i3 = i4 + 3;
                    try {
                        try {
                            allocate.put((byte) Integer.parseInt(str.substring(i4 + 1, i3), 16));
                            if (i3 >= length) {
                                break;
                            }
                            try {
                                if (str.charAt(i3) != '%') {
                                    break;
                                }
                                i4 = i3;
                            } catch (RuntimeException unused) {
                                i4 = i3;
                                if (allocate.position() > 0) {
                                    allocate.flip();
                                    sb.append(StandardCharsets.UTF_8.decode(allocate).toString());
                                    allocate.clear();
                                }
                                sb.append(str.charAt(i4));
                                i4++;
                            }
                        } catch (RuntimeException unused2) {
                        }
                    } finally {
                        if (allocate.position() > 0) {
                            allocate.flip();
                            sb.append(StandardCharsets.UTF_8.decode(allocate).toString());
                            allocate.clear();
                        }
                    }
                }
                i4 = i3;
            }
            sb.append(str.charAt(i4));
            i4++;
        }
        return sb.toString();
    }

    public static void deleteDirectory(File file) {
        if (file.exists()) {
            if (!isSymlink(file)) {
                cleanDirectory(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    private static void deleteDirectoryOnExit(File file) {
        if (file.exists()) {
            file.deleteOnExit();
            if (isSymlink(file)) {
                return;
            }
            cleanDirectoryOnExit(file);
        }
    }

    public static boolean deleteQuietly(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                cleanDirectory(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean directoryContains(File file, File file2) {
        if (file == null) {
            throw new IllegalArgumentException("Directory must not be null");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Not a directory: " + file);
        }
        if (file2 != null && file.exists() && file2.exists()) {
            return FilenameUtils.directoryContains(file.getCanonicalPath(), file2.getCanonicalPath());
        }
        return false;
    }

    private static void doCopyDirectory(File file, File file2, FileFilter fileFilter, boolean z3, List<String> list) {
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (listFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        if (file2.exists()) {
            if (!file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' exists but is not a directory");
            }
        } else if (!file2.mkdirs() && !file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' directory cannot be created");
        }
        if (!file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        for (File file3 : listFiles) {
            File file4 = new File(file2, file3.getName());
            if (list == null || !list.contains(file3.getCanonicalPath())) {
                if (file3.isDirectory()) {
                    doCopyDirectory(file3, file4, fileFilter, z3, list);
                } else {
                    doCopyFile(file3, file4, z3);
                }
            }
        }
        if (z3) {
            file2.setLastModified(file.lastModified());
        }
    }

    private static void doCopyFile(File file, File file2, boolean z3) {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j3 = 0;
                        while (j3 < size) {
                            long j4 = size - j3;
                            long transferFrom = channel2.transferFrom(channel, j3, j4 > FILE_COPY_BUFFER_SIZE ? 31457280L : j4);
                            if (transferFrom == 0) {
                                break;
                            } else {
                                j3 += transferFrom;
                            }
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        fileOutputStream.close();
                        channel.close();
                        fileInputStream.close();
                        long length = file.length();
                        long length2 = file2.length();
                        if (length == length2) {
                            if (z3) {
                                file2.setLastModified(file.lastModified());
                                return;
                            }
                            return;
                        }
                        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public static void forceDelete(File file) {
        if (file.isDirectory()) {
            deleteDirectory(file);
            return;
        }
        boolean exists = file.exists();
        if (file.delete()) {
            return;
        }
        if (exists) {
            throw new IOException("Unable to delete file: " + file);
        }
        throw new FileNotFoundException("File does not exist: " + file);
    }

    public static void forceDeleteOnExit(File file) {
        if (file.isDirectory()) {
            deleteDirectoryOnExit(file);
        } else {
            file.deleteOnExit();
        }
    }

    public static void forceMkdir(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            throw new IOException("File " + file + " exists and is not a directory. Unable to create directory.");
        }
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        throw new IOException("Unable to create directory " + file);
    }

    public static void forceMkdirParent(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return;
        }
        forceMkdir(parentFile);
    }

    public static File getFile(File file, String... strArr) {
        if (file == null) {
            throw new NullPointerException("directory must not be null");
        }
        if (strArr == null) {
            throw new NullPointerException("names must not be null");
        }
        int length = strArr.length;
        int i3 = 0;
        while (i3 < length) {
            File file2 = new File(file, strArr[i3]);
            i3++;
            file = file2;
        }
        return file;
    }

    public static File getFile(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("names must not be null");
        }
        File file = null;
        for (String str : strArr) {
            file = file == null ? new File(str) : new File(file, str);
        }
        return file;
    }

    public static File getTempDirectory() {
        return new File(getTempDirectoryPath());
    }

    public static String getTempDirectoryPath() {
        return System.getProperty("java.io.tmpdir");
    }

    public static File getUserDirectory() {
        return new File(getUserDirectoryPath());
    }

    public static String getUserDirectoryPath() {
        return System.getProperty("user.home");
    }

    private static void innerListFiles(Collection<File> collection, File file, IOFileFilter iOFileFilter, boolean z3) {
        File[] listFiles = file.listFiles((FileFilter) iOFileFilter);
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    if (z3) {
                        collection.add(file2);
                    }
                    innerListFiles(collection, file2, iOFileFilter, z3);
                } else {
                    collection.add(file2);
                }
            }
        }
    }

    public static boolean isFileNewer(File file, long j3) {
        if (file != null) {
            return file.exists() && file.lastModified() > j3;
        }
        throw new IllegalArgumentException("No specified file");
    }

    public static boolean isFileNewer(File file, File file2) {
        if (file2 == null) {
            throw new IllegalArgumentException("No specified reference file");
        }
        if (file2.exists()) {
            return isFileNewer(file, file2.lastModified());
        }
        throw new IllegalArgumentException("The reference file '" + file2 + "' doesn't exist");
    }

    public static boolean isFileNewer(File file, Date date) {
        if (date != null) {
            return isFileNewer(file, date.getTime());
        }
        throw new IllegalArgumentException("No specified date");
    }

    public static boolean isFileOlder(File file, long j3) {
        if (file != null) {
            return file.exists() && file.lastModified() < j3;
        }
        throw new IllegalArgumentException("No specified file");
    }

    public static boolean isFileOlder(File file, File file2) {
        if (file2 == null) {
            throw new IllegalArgumentException("No specified reference file");
        }
        if (file2.exists()) {
            return isFileOlder(file, file2.lastModified());
        }
        throw new IllegalArgumentException("The reference file '" + file2 + "' doesn't exist");
    }

    public static boolean isFileOlder(File file, Date date) {
        if (date != null) {
            return isFileOlder(file, date.getTime());
        }
        throw new IllegalArgumentException("No specified date");
    }

    public static boolean isSymlink(File file) {
        Path path;
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }
        path = file.toPath();
        return Files.isSymbolicLink(path);
    }

    public static Iterator<File> iterateFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return listFiles(file, iOFileFilter, iOFileFilter2).iterator();
    }

    public static Iterator<File> iterateFiles(File file, String[] strArr, boolean z3) {
        return listFiles(file, strArr, z3).iterator();
    }

    public static Iterator<File> iterateFilesAndDirs(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return listFilesAndDirs(file, iOFileFilter, iOFileFilter2).iterator();
    }

    public static LineIterator lineIterator(File file) {
        return lineIterator(file, null);
    }

    public static LineIterator lineIterator(File file, String str) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openInputStream(file);
            return IOUtils.lineIterator(fileInputStream, str);
        } catch (IOException | RuntimeException e3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    e3.addSuppressed(e4);
                }
            }
            throw e3;
        }
    }

    public static Collection<File> listFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        validateListFilesParameters(file, iOFileFilter);
        IOFileFilter upEffectiveFileFilter = setUpEffectiveFileFilter(iOFileFilter);
        IOFileFilter upEffectiveDirFilter = setUpEffectiveDirFilter(iOFileFilter2);
        LinkedList linkedList = new LinkedList();
        innerListFiles(linkedList, file, FileFilterUtils.or(upEffectiveFileFilter, upEffectiveDirFilter), false);
        return linkedList;
    }

    public static Collection<File> listFiles(File file, String[] strArr, boolean z3) {
        return listFiles(file, strArr == null ? TrueFileFilter.INSTANCE : new SuffixFileFilter(toSuffixes(strArr)), z3 ? TrueFileFilter.INSTANCE : FalseFileFilter.INSTANCE);
    }

    public static Collection<File> listFilesAndDirs(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        validateListFilesParameters(file, iOFileFilter);
        IOFileFilter upEffectiveFileFilter = setUpEffectiveFileFilter(iOFileFilter);
        IOFileFilter upEffectiveDirFilter = setUpEffectiveDirFilter(iOFileFilter2);
        LinkedList linkedList = new LinkedList();
        if (file.isDirectory()) {
            linkedList.add(file);
        }
        innerListFiles(linkedList, file, FileFilterUtils.or(upEffectiveFileFilter, upEffectiveDirFilter), true);
        return linkedList;
    }

    public static void moveDirectory(File file, File file2) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' is not a directory");
        }
        if (file2.exists()) {
            throw new FileExistsException("Destination '" + file2 + "' already exists");
        }
        if (file.renameTo(file2)) {
            return;
        }
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath() + File.separator)) {
            throw new IOException("Cannot move directory: " + file + " to a subdirectory of itself: " + file2);
        }
        copyDirectory(file, file2);
        deleteDirectory(file);
        if (file.exists()) {
            throw new IOException("Failed to delete original directory '" + file + "' after copy to '" + file2 + "'");
        }
    }

    public static void moveDirectoryToDirectory(File file, File file2, boolean z3) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination directory must not be null");
        }
        if (!file2.exists() && z3) {
            file2.mkdirs();
        }
        if (!file2.exists()) {
            throw new FileNotFoundException("Destination directory '" + file2 + "' does not exist [createDestDir=" + z3 + "]");
        }
        if (file2.isDirectory()) {
            moveDirectory(file, new File(file2, file.getName()));
            return;
        }
        throw new IOException("Destination '" + file2 + "' is not a directory");
    }

    public static void moveFile(File file, File file2) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' is a directory");
        }
        if (file2.exists()) {
            throw new FileExistsException("Destination '" + file2 + "' already exists");
        }
        if (file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' is a directory");
        }
        if (file.renameTo(file2)) {
            return;
        }
        copyFile(file, file2);
        if (file.delete()) {
            return;
        }
        deleteQuietly(file2);
        throw new IOException("Failed to delete original file '" + file + "' after copy to '" + file2 + "'");
    }

    public static void moveFileToDirectory(File file, File file2, boolean z3) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination directory must not be null");
        }
        if (!file2.exists() && z3) {
            file2.mkdirs();
        }
        if (!file2.exists()) {
            throw new FileNotFoundException("Destination directory '" + file2 + "' does not exist [createDestDir=" + z3 + "]");
        }
        if (file2.isDirectory()) {
            moveFile(file, new File(file2, file.getName()));
            return;
        }
        throw new IOException("Destination '" + file2 + "' is not a directory");
    }

    public static void moveToDirectory(File file, File file2, boolean z3) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                moveDirectoryToDirectory(file, file2, z3);
                return;
            } else {
                moveFileToDirectory(file, file2, z3);
                return;
            }
        }
        throw new FileNotFoundException("Source '" + file + "' does not exist");
    }

    public static FileInputStream openInputStream(File file) {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        if (file.canRead()) {
            return new FileInputStream(file);
        }
        throw new IOException("File '" + file + "' cannot be read");
    }

    public static FileOutputStream openOutputStream(File file) {
        return openOutputStream(file, false);
    }

    public static FileOutputStream openOutputStream(File file, boolean z3) {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        } else {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        }
        return new FileOutputStream(file, z3);
    }

    public static byte[] readFileToByteArray(File file) {
        FileInputStream openInputStream = openInputStream(file);
        try {
            long length = file.length();
            byte[] byteArray = length > 0 ? IOUtils.toByteArray(openInputStream, length) : IOUtils.toByteArray(openInputStream);
            if (openInputStream != null) {
                openInputStream.close();
            }
            return byteArray;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (openInputStream != null) {
                    try {
                        openInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Deprecated
    public static String readFileToString(File file) {
        return readFileToString(file, Charset.defaultCharset());
    }

    public static String readFileToString(File file, String str) {
        return readFileToString(file, Charsets.toCharset(str));
    }

    public static String readFileToString(File file, Charset charset) {
        FileInputStream openInputStream = openInputStream(file);
        try {
            String iOUtils = IOUtils.toString(openInputStream, Charsets.toCharset(charset));
            if (openInputStream != null) {
                openInputStream.close();
            }
            return iOUtils;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (openInputStream != null) {
                    try {
                        openInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Deprecated
    public static List<String> readLines(File file) {
        return readLines(file, Charset.defaultCharset());
    }

    public static List<String> readLines(File file, String str) {
        return readLines(file, Charsets.toCharset(str));
    }

    public static List<String> readLines(File file, Charset charset) {
        FileInputStream openInputStream = openInputStream(file);
        try {
            List<String> readLines = IOUtils.readLines(openInputStream, Charsets.toCharset(charset));
            if (openInputStream != null) {
                openInputStream.close();
            }
            return readLines;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (openInputStream != null) {
                    try {
                        openInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    private static IOFileFilter setUpEffectiveDirFilter(IOFileFilter iOFileFilter) {
        return iOFileFilter == null ? FalseFileFilter.INSTANCE : FileFilterUtils.and(iOFileFilter, DirectoryFileFilter.INSTANCE);
    }

    private static IOFileFilter setUpEffectiveFileFilter(IOFileFilter iOFileFilter) {
        return FileFilterUtils.and(iOFileFilter, FileFilterUtils.notFileFilter(DirectoryFileFilter.INSTANCE));
    }

    public static long sizeOf(File file) {
        if (file.exists()) {
            return file.isDirectory() ? sizeOfDirectory0(file) : file.length();
        }
        throw new IllegalArgumentException(file + " does not exist");
    }

    private static long sizeOf0(File file) {
        return file.isDirectory() ? sizeOfDirectory0(file) : file.length();
    }

    public static BigInteger sizeOfAsBigInteger(File file) {
        if (file.exists()) {
            return file.isDirectory() ? sizeOfDirectoryBig0(file) : BigInteger.valueOf(file.length());
        }
        throw new IllegalArgumentException(file + " does not exist");
    }

    private static BigInteger sizeOfBig0(File file) {
        return file.isDirectory() ? sizeOfDirectoryBig0(file) : BigInteger.valueOf(file.length());
    }

    public static long sizeOfDirectory(File file) {
        checkDirectory(file);
        return sizeOfDirectory0(file);
    }

    private static long sizeOfDirectory0(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0L;
        }
        long j3 = 0;
        for (File file2 : listFiles) {
            try {
                if (!isSymlink(file2)) {
                    j3 += sizeOf0(file2);
                    if (j3 < 0) {
                        break;
                    }
                } else {
                    continue;
                }
            } catch (IOException unused) {
            }
        }
        return j3;
    }

    public static BigInteger sizeOfDirectoryAsBigInteger(File file) {
        checkDirectory(file);
        return sizeOfDirectoryBig0(file);
    }

    private static BigInteger sizeOfDirectoryBig0(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return BigInteger.ZERO;
        }
        BigInteger bigInteger = BigInteger.ZERO;
        for (File file2 : listFiles) {
            try {
                if (!isSymlink(file2)) {
                    bigInteger = bigInteger.add(sizeOfBig0(file2));
                }
            } catch (IOException unused) {
            }
        }
        return bigInteger;
    }

    public static File toFile(URL url) {
        if (url == null || !"file".equalsIgnoreCase(url.getProtocol())) {
            return null;
        }
        return new File(decodeUrl(url.getFile().replace(IOUtils.DIR_SEPARATOR_UNIX, File.separatorChar)));
    }

    public static File[] toFiles(URL[] urlArr) {
        if (urlArr == null || urlArr.length == 0) {
            return EMPTY_FILE_ARRAY;
        }
        File[] fileArr = new File[urlArr.length];
        for (int i3 = 0; i3 < urlArr.length; i3++) {
            URL url = urlArr[i3];
            if (url != null) {
                if (!url.getProtocol().equals("file")) {
                    throw new IllegalArgumentException("URL could not be converted to a File: " + url);
                }
                fileArr[i3] = toFile(url);
            }
        }
        return fileArr;
    }

    private static String[] toSuffixes(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            strArr2[i3] = "." + strArr[i3];
        }
        return strArr2;
    }

    public static URL[] toURLs(File[] fileArr) {
        int length = fileArr.length;
        URL[] urlArr = new URL[length];
        for (int i3 = 0; i3 < length; i3++) {
            urlArr[i3] = fileArr[i3].toURI().toURL();
        }
        return urlArr;
    }

    public static void touch(File file) {
        if (!file.exists()) {
            openOutputStream(file).close();
        }
        if (file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        throw new IOException("Unable to set the last modification time for " + file);
    }

    private static void validateListFilesParameters(File file, IOFileFilter iOFileFilter) {
        if (file.isDirectory()) {
            if (iOFileFilter == null) {
                throw new NullPointerException("Parameter 'fileFilter' is null");
            }
        } else {
            throw new IllegalArgumentException("Parameter 'directory' is not a directory: " + file);
        }
    }

    private static File[] verifiedListFiles(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            return listFiles;
        }
        throw new IOException("Failed to list contents of " + file);
    }

    public static boolean waitFor(File file, int i3) {
        long currentTimeMillis = System.currentTimeMillis() + (i3 * 1000);
        boolean z3 = false;
        while (!file.exists()) {
            try {
                long currentTimeMillis2 = currentTimeMillis - System.currentTimeMillis();
                if (currentTimeMillis2 < 0) {
                    return false;
                }
                try {
                    Thread.sleep(Math.min(100L, currentTimeMillis2));
                } catch (InterruptedException unused) {
                    z3 = true;
                } catch (Exception unused2) {
                }
            } finally {
                if (z3) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        if (z3) {
            Thread.currentThread().interrupt();
        }
        return true;
    }

    @Deprecated
    public static void write(File file, CharSequence charSequence) {
        write(file, charSequence, Charset.defaultCharset(), false);
    }

    public static void write(File file, CharSequence charSequence, String str) {
        write(file, charSequence, str, false);
    }

    public static void write(File file, CharSequence charSequence, String str, boolean z3) {
        write(file, charSequence, Charsets.toCharset(str), z3);
    }

    public static void write(File file, CharSequence charSequence, Charset charset) {
        write(file, charSequence, charset, false);
    }

    public static void write(File file, CharSequence charSequence, Charset charset, boolean z3) {
        writeStringToFile(file, charSequence == null ? null : charSequence.toString(), charset, z3);
    }

    @Deprecated
    public static void write(File file, CharSequence charSequence, boolean z3) {
        write(file, charSequence, Charset.defaultCharset(), z3);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr) {
        writeByteArrayToFile(file, bArr, false);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, int i3, int i4) {
        writeByteArrayToFile(file, bArr, i3, i4, false);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, int i3, int i4, boolean z3) {
        FileOutputStream openOutputStream = openOutputStream(file, z3);
        try {
            openOutputStream.write(bArr, i3, i4);
            openOutputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (openOutputStream != null) {
                    try {
                        openOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, boolean z3) {
        writeByteArrayToFile(file, bArr, 0, bArr.length, z3);
    }

    public static void writeLines(File file, String str, Collection<?> collection) {
        writeLines(file, str, collection, null, false);
    }

    public static void writeLines(File file, String str, Collection<?> collection, String str2) {
        writeLines(file, str, collection, str2, false);
    }

    public static void writeLines(File file, String str, Collection<?> collection, String str2, boolean z3) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(openOutputStream(file, z3));
        try {
            IOUtils.writeLines(collection, str2, bufferedOutputStream, str);
            bufferedOutputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static void writeLines(File file, String str, Collection<?> collection, boolean z3) {
        writeLines(file, str, collection, null, z3);
    }

    public static void writeLines(File file, Collection<?> collection) {
        writeLines(file, null, collection, null, false);
    }

    public static void writeLines(File file, Collection<?> collection, String str) {
        writeLines(file, null, collection, str, false);
    }

    public static void writeLines(File file, Collection<?> collection, String str, boolean z3) {
        writeLines(file, null, collection, str, z3);
    }

    public static void writeLines(File file, Collection<?> collection, boolean z3) {
        writeLines(file, null, collection, null, z3);
    }

    @Deprecated
    public static void writeStringToFile(File file, String str) {
        writeStringToFile(file, str, Charset.defaultCharset(), false);
    }

    public static void writeStringToFile(File file, String str, String str2) {
        writeStringToFile(file, str, str2, false);
    }

    public static void writeStringToFile(File file, String str, String str2, boolean z3) {
        writeStringToFile(file, str, Charsets.toCharset(str2), z3);
    }

    public static void writeStringToFile(File file, String str, Charset charset) {
        writeStringToFile(file, str, charset, false);
    }

    public static void writeStringToFile(File file, String str, Charset charset, boolean z3) {
        FileOutputStream openOutputStream = openOutputStream(file, z3);
        try {
            IOUtils.write(str, (OutputStream) openOutputStream, charset);
            if (openOutputStream != null) {
                openOutputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (openOutputStream != null) {
                    try {
                        openOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Deprecated
    public static void writeStringToFile(File file, String str, boolean z3) {
        writeStringToFile(file, str, Charset.defaultCharset(), z3);
    }
}
