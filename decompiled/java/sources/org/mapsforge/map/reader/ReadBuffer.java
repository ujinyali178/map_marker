package org.mapsforge.map.reader;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.mapsforge.core.model.Tag;
import org.mapsforge.core.util.Parameters;

/* loaded from: /root/release/classes2.dex */
public class ReadBuffer {
    private static final String CHARSET_UTF8 = "UTF-8";
    private static final Logger LOGGER = Logger.getLogger(ReadBuffer.class.getName());
    private byte[] bufferData;
    private int bufferPosition;
    private ByteBuffer bufferWrapper;
    private final FileChannel inputChannel;
    private final List<Integer> tagIds = new ArrayList();

    ReadBuffer(FileChannel fileChannel) {
        this.inputChannel = fileChannel;
    }

    int getBufferPosition() {
        return this.bufferPosition;
    }

    int getBufferSize() {
        return this.bufferData.length;
    }

    public byte readByte() {
        byte[] bArr = this.bufferData;
        int i3 = this.bufferPosition;
        this.bufferPosition = i3 + 1;
        return bArr[i3];
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public boolean readFromFile(int i3) {
        byte[] bArr = this.bufferData;
        if (bArr == null || bArr.length < i3) {
            if (i3 > Parameters.MAXIMUM_BUFFER_SIZE) {
                LOGGER.warning("invalid read length: " + i3);
                return false;
            }
            byte[] bArr2 = new byte[i3];
            this.bufferData = bArr2;
            this.bufferWrapper = ByteBuffer.wrap(bArr2, 0, i3);
        }
        this.bufferPosition = 0;
        this.bufferWrapper.clear();
        return this.inputChannel.read(this.bufferWrapper) == i3;
    }

    public boolean readFromFile(long j3, int i3) {
        boolean z3;
        byte[] bArr = this.bufferData;
        if (bArr == null || bArr.length < i3) {
            if (i3 > Parameters.MAXIMUM_BUFFER_SIZE) {
                LOGGER.warning("invalid read length: " + i3);
                return false;
            }
            byte[] bArr2 = new byte[i3];
            this.bufferData = bArr2;
            this.bufferWrapper = ByteBuffer.wrap(bArr2, 0, i3);
        }
        this.bufferPosition = 0;
        this.bufferWrapper.clear();
        synchronized (this.inputChannel) {
            this.inputChannel.position(j3);
            z3 = this.inputChannel.read(this.bufferWrapper) == i3;
        }
        return z3;
    }

    public int readInt() {
        int i3 = this.bufferPosition + 4;
        this.bufferPosition = i3;
        return Deserializer.getInt(this.bufferData, i3 - 4);
    }

    public long readLong() {
        int i3 = this.bufferPosition + 8;
        this.bufferPosition = i3;
        return Deserializer.getLong(this.bufferData, i3 - 8);
    }

    public int readShort() {
        int i3 = this.bufferPosition + 2;
        this.bufferPosition = i3;
        return Deserializer.getShort(this.bufferData, i3 - 2);
    }

    public int readSignedInt() {
        int i3;
        byte b4;
        int i4 = 0;
        byte b5 = 0;
        while (true) {
            byte[] bArr = this.bufferData;
            i3 = this.bufferPosition;
            b4 = bArr[i3];
            if ((b4 & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                break;
            }
            this.bufferPosition = i3 + 1;
            i4 |= (b4 & Ascii.DEL) << b5;
            b5 = (byte) (b5 + 7);
        }
        int i5 = b4 & SignedBytes.MAX_POWER_OF_TWO;
        this.bufferPosition = i3 + 1;
        int i6 = i4 | ((b4 & 63) << b5);
        return i5 != 0 ? -i6 : i6;
    }

    List<Tag> readTags(Tag[] tagArr, byte b4) {
        int readShort;
        ArrayList arrayList = new ArrayList();
        this.tagIds.clear();
        int length = tagArr.length;
        while (b4 != 0) {
            int readUnsignedInt = readUnsignedInt();
            if (readUnsignedInt < 0 || readUnsignedInt >= length) {
                LOGGER.warning("invalid tag ID: " + readUnsignedInt);
                return null;
            }
            this.tagIds.add(Integer.valueOf(readUnsignedInt));
            b4 = (byte) (b4 - 1);
        }
        Iterator<Integer> it = this.tagIds.iterator();
        while (it.hasNext()) {
            Tag tag = tagArr[it.next().intValue()];
            if (tag.value.length() == 2 && tag.value.charAt(0) == '%') {
                String str = tag.value;
                if (str.charAt(1) == 'b') {
                    readShort = readByte();
                } else if (str.charAt(1) != 'i') {
                    if (str.charAt(1) == 'f') {
                        str = String.valueOf(readFloat());
                    } else if (str.charAt(1) == 'h') {
                        readShort = readShort();
                    } else if (str.charAt(1) == 's') {
                        str = readUTF8EncodedString();
                    }
                    tag = new Tag(tag.key, str);
                } else if (tag.key.contains(":colour")) {
                    str = "#" + Integer.toHexString(readInt());
                    tag = new Tag(tag.key, str);
                } else {
                    readShort = readInt();
                }
                str = String.valueOf(readShort);
                tag = new Tag(tag.key, str);
            }
            arrayList.add(tag);
        }
        return arrayList;
    }

    public String readUTF8EncodedString() {
        return readUTF8EncodedString(readUnsignedInt());
    }

    public String readUTF8EncodedString(int i3) {
        if (i3 > 0) {
            int i4 = this.bufferPosition;
            int i5 = i4 + i3;
            byte[] bArr = this.bufferData;
            if (i5 <= bArr.length) {
                int i6 = i4 + i3;
                this.bufferPosition = i6;
                try {
                    return new String(bArr, i6 - i3, i3, CHARSET_UTF8);
                } catch (UnsupportedEncodingException e3) {
                    throw new IllegalStateException(e3);
                }
            }
        }
        LOGGER.warning("invalid string length: " + i3);
        return null;
    }

    public int readUnsignedInt() {
        int i3 = 0;
        byte b4 = 0;
        while (true) {
            byte[] bArr = this.bufferData;
            int i4 = this.bufferPosition;
            byte b5 = bArr[i4];
            int i5 = b5 & UnsignedBytes.MAX_POWER_OF_TWO;
            this.bufferPosition = i4 + 1;
            if (i5 == 0) {
                return i3 | (b5 << b4);
            }
            i3 |= (b5 & Ascii.DEL) << b4;
            b4 = (byte) (b4 + 7);
        }
    }

    void setBufferPosition(int i3) {
        this.bufferPosition = i3;
    }

    void skipBytes(int i3) {
        this.bufferPosition += i3;
    }
}
