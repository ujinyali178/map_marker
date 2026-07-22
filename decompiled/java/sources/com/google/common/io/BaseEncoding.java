package com.google.common.io;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.CheckForNull;
import org.mapsforge.core.model.Tag;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class BaseEncoding {
    private static final BaseEncoding BASE16;
    private static final BaseEncoding BASE32;
    private static final BaseEncoding BASE32_HEX;
    private static final BaseEncoding BASE64;
    private static final BaseEncoding BASE64_URL;

    private static final class Alphabet {
        final int bitsPerChar;
        final int bytesPerChunk;
        private final char[] chars;
        final int charsPerChunk;
        private final byte[] decodabet;
        private final boolean ignoreCase;
        final int mask;
        private final String name;
        private final boolean[] validPadding;

        Alphabet(String str, char[] cArr) {
            this(str, cArr, decodabetFor(cArr), false);
        }

        private Alphabet(String str, char[] cArr, byte[] bArr, boolean z3) {
            this.name = (String) Preconditions.checkNotNull(str);
            this.chars = (char[]) Preconditions.checkNotNull(cArr);
            try {
                int log2 = IntMath.log2(cArr.length, RoundingMode.UNNECESSARY);
                this.bitsPerChar = log2;
                int numberOfTrailingZeros = Integer.numberOfTrailingZeros(log2);
                int i3 = 1 << (3 - numberOfTrailingZeros);
                this.charsPerChunk = i3;
                this.bytesPerChunk = log2 >> numberOfTrailingZeros;
                this.mask = cArr.length - 1;
                this.decodabet = bArr;
                boolean[] zArr = new boolean[i3];
                for (int i4 = 0; i4 < this.bytesPerChunk; i4++) {
                    zArr[IntMath.divide(i4 * 8, this.bitsPerChar, RoundingMode.CEILING)] = true;
                }
                this.validPadding = zArr;
                this.ignoreCase = z3;
            } catch (ArithmeticException e3) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e3);
            }
        }

        private static byte[] decodabetFor(char[] cArr) {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i3 = 0; i3 < cArr.length; i3++) {
                char c3 = cArr[i3];
                boolean z3 = true;
                Preconditions.checkArgument(c3 < 128, "Non-ASCII character: %s", c3);
                if (bArr[c3] != -1) {
                    z3 = false;
                }
                Preconditions.checkArgument(z3, "Duplicate character: %s", c3);
                bArr[c3] = (byte) i3;
            }
            return bArr;
        }

        private boolean hasLowerCase() {
            for (char c3 : this.chars) {
                if (Ascii.isLowerCase(c3)) {
                    return true;
                }
            }
            return false;
        }

        private boolean hasUpperCase() {
            for (char c3 : this.chars) {
                if (Ascii.isUpperCase(c3)) {
                    return true;
                }
            }
            return false;
        }

        boolean canDecode(char c3) {
            return c3 <= 127 && this.decodabet[c3] != -1;
        }

        int decode(char c3) {
            if (c3 > 127) {
                throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c3));
            }
            byte b4 = this.decodabet[c3];
            if (b4 != -1) {
                return b4;
            }
            if (c3 <= ' ' || c3 == 127) {
                throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c3));
            }
            throw new DecodingException("Unrecognized character: " + c3);
        }

        char encode(int i3) {
            return this.chars[i3];
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof Alphabet)) {
                return false;
            }
            Alphabet alphabet = (Alphabet) obj;
            return this.ignoreCase == alphabet.ignoreCase && Arrays.equals(this.chars, alphabet.chars);
        }

        public int hashCode() {
            return Arrays.hashCode(this.chars) + (this.ignoreCase ? 1231 : 1237);
        }

        Alphabet ignoreCase() {
            if (this.ignoreCase) {
                return this;
            }
            byte[] bArr = this.decodabet;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            int i3 = 65;
            while (true) {
                if (i3 > 90) {
                    return new Alphabet(this.name + ".ignoreCase()", this.chars, copyOf, true);
                }
                int i4 = i3 | 32;
                byte[] bArr2 = this.decodabet;
                byte b4 = bArr2[i3];
                byte b5 = bArr2[i4];
                if (b4 == -1) {
                    copyOf[i3] = b5;
                } else {
                    Preconditions.checkState(b5 == -1, "Can't ignoreCase() since '%s' and '%s' encode different values", (char) i3, (char) i4);
                    copyOf[i4] = b4;
                }
                i3++;
            }
        }

        boolean isValidPaddingStartPosition(int i3) {
            return this.validPadding[i3 % this.charsPerChunk];
        }

        Alphabet lowerCase() {
            if (!hasUpperCase()) {
                return this;
            }
            Preconditions.checkState(!hasLowerCase(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.chars.length];
            int i3 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i3 >= cArr2.length) {
                    break;
                }
                cArr[i3] = Ascii.toLowerCase(cArr2[i3]);
                i3++;
            }
            Alphabet alphabet = new Alphabet(this.name + ".lowerCase()", cArr);
            return this.ignoreCase ? alphabet.ignoreCase() : alphabet;
        }

        public boolean matches(char c3) {
            byte[] bArr = this.decodabet;
            return c3 < bArr.length && bArr[c3] != -1;
        }

        public String toString() {
            return this.name;
        }

        Alphabet upperCase() {
            if (!hasLowerCase()) {
                return this;
            }
            Preconditions.checkState(!hasUpperCase(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.chars.length];
            int i3 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i3 >= cArr2.length) {
                    break;
                }
                cArr[i3] = Ascii.toUpperCase(cArr2[i3]);
                i3++;
            }
            Alphabet alphabet = new Alphabet(this.name + ".upperCase()", cArr);
            return this.ignoreCase ? alphabet.ignoreCase() : alphabet;
        }
    }

    static final class Base16Encoding extends StandardBaseEncoding {
        final char[] encoding;

        private Base16Encoding(Alphabet alphabet) {
            super(alphabet, null);
            this.encoding = new char[UserVerificationMethods.USER_VERIFY_NONE];
            Preconditions.checkArgument(alphabet.chars.length == 16);
            for (int i3 = 0; i3 < 256; i3++) {
                this.encoding[i3] = alphabet.encode(i3 >>> 4);
                this.encoding[i3 | UserVerificationMethods.USER_VERIFY_HANDPRINT] = alphabet.encode(i3 & 15);
            }
        }

        Base16Encoding(String str, String str2) {
            this(new Alphabet(str, str2.toCharArray()));
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        int decodeTo(byte[] bArr, CharSequence charSequence) {
            Preconditions.checkNotNull(bArr);
            if (charSequence.length() % 2 == 1) {
                throw new DecodingException("Invalid input length " + charSequence.length());
            }
            int i3 = 0;
            int i4 = 0;
            while (i3 < charSequence.length()) {
                bArr[i4] = (byte) ((this.alphabet.decode(charSequence.charAt(i3)) << 4) | this.alphabet.decode(charSequence.charAt(i3 + 1)));
                i3 += 2;
                i4++;
            }
            return i4;
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        void encodeTo(Appendable appendable, byte[] bArr, int i3, int i4) {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i3, i3 + i4, bArr.length);
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = bArr[i3 + i5] & UnsignedBytes.MAX_VALUE;
                appendable.append(this.encoding[i6]);
                appendable.append(this.encoding[i6 | UserVerificationMethods.USER_VERIFY_HANDPRINT]);
            }
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        BaseEncoding newInstance(Alphabet alphabet, @CheckForNull Character ch) {
            return new Base16Encoding(alphabet);
        }
    }

    static final class Base64Encoding extends StandardBaseEncoding {
        private Base64Encoding(Alphabet alphabet, @CheckForNull Character ch) {
            super(alphabet, ch);
            Preconditions.checkArgument(alphabet.chars.length == 64);
        }

        Base64Encoding(String str, String str2, @CheckForNull Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        int decodeTo(byte[] bArr, CharSequence charSequence) {
            Preconditions.checkNotNull(bArr);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (!this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                throw new DecodingException("Invalid input length " + trimTrailingPadding.length());
            }
            int i3 = 0;
            int i4 = 0;
            while (i3 < trimTrailingPadding.length()) {
                int i5 = i3 + 1;
                int i6 = i5 + 1;
                int decode = (this.alphabet.decode(trimTrailingPadding.charAt(i3)) << 18) | (this.alphabet.decode(trimTrailingPadding.charAt(i5)) << 12);
                int i7 = i4 + 1;
                bArr[i4] = (byte) (decode >>> 16);
                if (i6 < trimTrailingPadding.length()) {
                    int i8 = i6 + 1;
                    int decode2 = decode | (this.alphabet.decode(trimTrailingPadding.charAt(i6)) << 6);
                    i4 = i7 + 1;
                    bArr[i7] = (byte) ((decode2 >>> 8) & 255);
                    if (i8 < trimTrailingPadding.length()) {
                        i6 = i8 + 1;
                        i7 = i4 + 1;
                        bArr[i4] = (byte) ((decode2 | this.alphabet.decode(trimTrailingPadding.charAt(i8))) & 255);
                    } else {
                        i3 = i8;
                    }
                }
                i4 = i7;
                i3 = i6;
            }
            return i4;
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        void encodeTo(Appendable appendable, byte[] bArr, int i3, int i4) {
            Preconditions.checkNotNull(appendable);
            int i5 = i3 + i4;
            Preconditions.checkPositionIndexes(i3, i5, bArr.length);
            while (i4 >= 3) {
                int i6 = i3 + 1;
                int i7 = i6 + 1;
                int i8 = ((bArr[i3] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i6] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[i7] & UnsignedBytes.MAX_VALUE);
                appendable.append(this.alphabet.encode(i8 >>> 18));
                appendable.append(this.alphabet.encode((i8 >>> 12) & 63));
                appendable.append(this.alphabet.encode((i8 >>> 6) & 63));
                appendable.append(this.alphabet.encode(i8 & 63));
                i4 -= 3;
                i3 = i7 + 1;
            }
            if (i3 < i5) {
                encodeChunkTo(appendable, bArr, i3, i5 - i3);
            }
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        BaseEncoding newInstance(Alphabet alphabet, @CheckForNull Character ch) {
            return new Base64Encoding(alphabet, ch);
        }
    }

    public static final class DecodingException extends IOException {
        DecodingException(String str) {
            super(str);
        }

        DecodingException(Throwable th) {
            super(th);
        }
    }

    static final class SeparatedBaseEncoding extends BaseEncoding {
        private final int afterEveryChars;
        private final BaseEncoding delegate;
        private final String separator;

        SeparatedBaseEncoding(BaseEncoding baseEncoding, String str, int i3) {
            this.delegate = (BaseEncoding) Preconditions.checkNotNull(baseEncoding);
            this.separator = (String) Preconditions.checkNotNull(str);
            this.afterEveryChars = i3;
            Preconditions.checkArgument(i3 > 0, "Cannot add a separator after every %s chars", i3);
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence charSequence) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < charSequence.length(); i3++) {
                char charAt = charSequence.charAt(i3);
                if (this.separator.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.delegate.canDecode(sb);
        }

        @Override // com.google.common.io.BaseEncoding
        int decodeTo(byte[] bArr, CharSequence charSequence) {
            StringBuilder sb = new StringBuilder(charSequence.length());
            for (int i3 = 0; i3 < charSequence.length(); i3++) {
                char charAt = charSequence.charAt(i3);
                if (this.separator.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.delegate.decodeTo(bArr, sb);
        }

        @Override // com.google.common.io.BaseEncoding
        public InputStream decodingStream(Reader reader) {
            return this.delegate.decodingStream(BaseEncoding.ignoringReader(reader, this.separator));
        }

        @Override // com.google.common.io.BaseEncoding
        void encodeTo(Appendable appendable, byte[] bArr, int i3, int i4) {
            this.delegate.encodeTo(BaseEncoding.separatingAppendable(appendable, this.separator, this.afterEveryChars), bArr, i3, i4);
        }

        @Override // com.google.common.io.BaseEncoding
        public OutputStream encodingStream(Writer writer) {
            return this.delegate.encodingStream(BaseEncoding.separatingWriter(writer, this.separator, this.afterEveryChars));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding ignoreCase() {
            return this.delegate.ignoreCase().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        int maxDecodedSize(int i3) {
            return this.delegate.maxDecodedSize(i3);
        }

        @Override // com.google.common.io.BaseEncoding
        int maxEncodedSize(int i3) {
            int maxEncodedSize = this.delegate.maxEncodedSize(i3);
            return maxEncodedSize + (this.separator.length() * IntMath.divide(Math.max(0, maxEncodedSize - 1), this.afterEveryChars, RoundingMode.FLOOR));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
        }

        public String toString() {
            return this.delegate + ".withSeparator(\"" + this.separator + "\", " + this.afterEveryChars + ")";
        }

        @Override // com.google.common.io.BaseEncoding
        CharSequence trimTrailingPadding(CharSequence charSequence) {
            return this.delegate.trimTrailingPadding(charSequence);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char c3) {
            return this.delegate.withPadChar(c3).withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String str, int i3) {
            throw new UnsupportedOperationException("Already have a separator");
        }
    }

    static class StandardBaseEncoding extends BaseEncoding {
        final Alphabet alphabet;

        @CheckForNull
        @LazyInit
        private volatile BaseEncoding ignoreCase;

        @CheckForNull
        @LazyInit
        private volatile BaseEncoding lowerCase;

        @CheckForNull
        final Character paddingChar;

        @CheckForNull
        @LazyInit
        private volatile BaseEncoding upperCase;

        StandardBaseEncoding(Alphabet alphabet, @CheckForNull Character ch) {
            this.alphabet = (Alphabet) Preconditions.checkNotNull(alphabet);
            Preconditions.checkArgument(ch == null || !alphabet.matches(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.paddingChar = ch;
        }

        StandardBaseEncoding(String str, String str2, @CheckForNull Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (!this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                return false;
            }
            for (int i3 = 0; i3 < trimTrailingPadding.length(); i3++) {
                if (!this.alphabet.canDecode(trimTrailingPadding.charAt(i3))) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.BaseEncoding
        int decodeTo(byte[] bArr, CharSequence charSequence) {
            Alphabet alphabet;
            Preconditions.checkNotNull(bArr);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (!this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                throw new DecodingException("Invalid input length " + trimTrailingPadding.length());
            }
            int i3 = 0;
            int i4 = 0;
            while (i3 < trimTrailingPadding.length()) {
                long j3 = 0;
                int i5 = 0;
                int i6 = 0;
                while (true) {
                    alphabet = this.alphabet;
                    if (i5 >= alphabet.charsPerChunk) {
                        break;
                    }
                    j3 <<= alphabet.bitsPerChar;
                    if (i3 + i5 < trimTrailingPadding.length()) {
                        j3 |= this.alphabet.decode(trimTrailingPadding.charAt(i6 + i3));
                        i6++;
                    }
                    i5++;
                }
                int i7 = alphabet.bytesPerChunk;
                int i8 = (i7 * 8) - (i6 * alphabet.bitsPerChar);
                int i9 = (i7 - 1) * 8;
                while (i9 >= i8) {
                    bArr[i4] = (byte) ((j3 >>> i9) & 255);
                    i9 -= 8;
                    i4++;
                }
                i3 += this.alphabet.charsPerChunk;
            }
            return i4;
        }

        @Override // com.google.common.io.BaseEncoding
        public InputStream decodingStream(final Reader reader) {
            Preconditions.checkNotNull(reader);
            return new InputStream() { // from class: com.google.common.io.BaseEncoding.StandardBaseEncoding.2
                int bitBuffer = 0;
                int bitBufferLength = 0;
                int readChars = 0;
                boolean hitPadding = false;

                @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    reader.close();
                }

                /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
                
                    throw new com.google.common.io.BaseEncoding.DecodingException("Padding cannot start at index " + r4.readChars);
                 */
                @Override // java.io.InputStream
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public int read() {
                    /*
                        r4 = this;
                    L0:
                        java.io.Reader r0 = r2
                        int r0 = r0.read()
                        r1 = -1
                        if (r0 != r1) goto L34
                        boolean r0 = r4.hitPadding
                        if (r0 != 0) goto L33
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r0 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r0 = r0.alphabet
                        int r2 = r4.readChars
                        boolean r0 = r0.isValidPaddingStartPosition(r2)
                        if (r0 == 0) goto L1a
                        goto L33
                    L1a:
                        com.google.common.io.BaseEncoding$DecodingException r0 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "Invalid input length "
                        r1.append(r2)
                        int r2 = r4.readChars
                        r1.append(r2)
                        java.lang.String r1 = r1.toString()
                        r0.<init>(r1)
                        throw r0
                    L33:
                        return r1
                    L34:
                        int r1 = r4.readChars
                        r2 = 1
                        int r1 = r1 + r2
                        r4.readChars = r1
                        char r0 = (char) r0
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r1 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        java.lang.Character r1 = r1.paddingChar
                        if (r1 == 0) goto L78
                        char r1 = r1.charValue()
                        if (r1 != r0) goto L78
                        boolean r0 = r4.hitPadding
                        if (r0 != 0) goto L75
                        int r0 = r4.readChars
                        if (r0 == r2) goto L5c
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r1 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r1 = r1.alphabet
                        int r0 = r0 + (-1)
                        boolean r0 = r1.isValidPaddingStartPosition(r0)
                        if (r0 == 0) goto L5c
                        goto L75
                    L5c:
                        com.google.common.io.BaseEncoding$DecodingException r0 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "Padding cannot start at index "
                        r1.append(r2)
                        int r2 = r4.readChars
                        r1.append(r2)
                        java.lang.String r1 = r1.toString()
                        r0.<init>(r1)
                        throw r0
                    L75:
                        r4.hitPadding = r2
                        goto L0
                    L78:
                        boolean r1 = r4.hitPadding
                        if (r1 != 0) goto La4
                        int r1 = r4.bitBuffer
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r2 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r2 = r2.alphabet
                        int r3 = r2.bitsPerChar
                        int r1 = r1 << r3
                        r4.bitBuffer = r1
                        int r0 = r2.decode(r0)
                        r0 = r0 | r1
                        r4.bitBuffer = r0
                        int r1 = r4.bitBufferLength
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r2 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r2 = r2.alphabet
                        int r2 = r2.bitsPerChar
                        int r1 = r1 + r2
                        r4.bitBufferLength = r1
                        r2 = 8
                        if (r1 < r2) goto L0
                        int r1 = r1 - r2
                        r4.bitBufferLength = r1
                        int r0 = r0 >> r1
                        r0 = r0 & 255(0xff, float:3.57E-43)
                        return r0
                    La4:
                        com.google.common.io.BaseEncoding$DecodingException r1 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r3 = "Expected padding character but found '"
                        r2.append(r3)
                        r2.append(r0)
                        java.lang.String r0 = "' at index "
                        r2.append(r0)
                        int r0 = r4.readChars
                        r2.append(r0)
                        java.lang.String r0 = r2.toString()
                        r1.<init>(r0)
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.StandardBaseEncoding.AnonymousClass2.read():int");
                }

                @Override // java.io.InputStream
                public int read(byte[] bArr, int i3, int i4) {
                    int i5 = i4 + i3;
                    Preconditions.checkPositionIndexes(i3, i5, bArr.length);
                    int i6 = i3;
                    while (i6 < i5) {
                        int read = read();
                        if (read == -1) {
                            int i7 = i6 - i3;
                            if (i7 == 0) {
                                return -1;
                            }
                            return i7;
                        }
                        bArr[i6] = (byte) read;
                        i6++;
                    }
                    return i6 - i3;
                }
            };
        }

        void encodeChunkTo(Appendable appendable, byte[] bArr, int i3, int i4) {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i3, i3 + i4, bArr.length);
            int i5 = 0;
            Preconditions.checkArgument(i4 <= this.alphabet.bytesPerChunk);
            long j3 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                j3 = (j3 | (bArr[i3 + i6] & UnsignedBytes.MAX_VALUE)) << 8;
            }
            int i7 = ((i4 + 1) * 8) - this.alphabet.bitsPerChar;
            while (i5 < i4 * 8) {
                Alphabet alphabet = this.alphabet;
                appendable.append(alphabet.encode(((int) (j3 >>> (i7 - i5))) & alphabet.mask));
                i5 += this.alphabet.bitsPerChar;
            }
            if (this.paddingChar != null) {
                while (i5 < this.alphabet.bytesPerChunk * 8) {
                    appendable.append(this.paddingChar.charValue());
                    i5 += this.alphabet.bitsPerChar;
                }
            }
        }

        @Override // com.google.common.io.BaseEncoding
        void encodeTo(Appendable appendable, byte[] bArr, int i3, int i4) {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i3, i3 + i4, bArr.length);
            int i5 = 0;
            while (i5 < i4) {
                encodeChunkTo(appendable, bArr, i3 + i5, Math.min(this.alphabet.bytesPerChunk, i4 - i5));
                i5 += this.alphabet.bytesPerChunk;
            }
        }

        @Override // com.google.common.io.BaseEncoding
        public OutputStream encodingStream(final Writer writer) {
            Preconditions.checkNotNull(writer);
            return new OutputStream() { // from class: com.google.common.io.BaseEncoding.StandardBaseEncoding.1
                int bitBuffer = 0;
                int bitBufferLength = 0;
                int writtenChars = 0;

                @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    int i3 = this.bitBufferLength;
                    if (i3 > 0) {
                        int i4 = this.bitBuffer;
                        Alphabet alphabet = StandardBaseEncoding.this.alphabet;
                        writer.write(alphabet.encode((i4 << (alphabet.bitsPerChar - i3)) & alphabet.mask));
                        this.writtenChars++;
                        if (StandardBaseEncoding.this.paddingChar != null) {
                            while (true) {
                                int i5 = this.writtenChars;
                                StandardBaseEncoding standardBaseEncoding = StandardBaseEncoding.this;
                                if (i5 % standardBaseEncoding.alphabet.charsPerChunk == 0) {
                                    break;
                                }
                                writer.write(standardBaseEncoding.paddingChar.charValue());
                                this.writtenChars++;
                            }
                        }
                    }
                    writer.close();
                }

                @Override // java.io.OutputStream, java.io.Flushable
                public void flush() {
                    writer.flush();
                }

                @Override // java.io.OutputStream
                public void write(int i3) {
                    this.bitBuffer = (i3 & 255) | (this.bitBuffer << 8);
                    int i4 = this.bitBufferLength + 8;
                    while (true) {
                        this.bitBufferLength = i4;
                        int i5 = this.bitBufferLength;
                        Alphabet alphabet = StandardBaseEncoding.this.alphabet;
                        int i6 = alphabet.bitsPerChar;
                        if (i5 < i6) {
                            return;
                        }
                        writer.write(alphabet.encode((this.bitBuffer >> (i5 - i6)) & alphabet.mask));
                        this.writtenChars++;
                        i4 = this.bitBufferLength - StandardBaseEncoding.this.alphabet.bitsPerChar;
                    }
                }
            };
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof StandardBaseEncoding)) {
                return false;
            }
            StandardBaseEncoding standardBaseEncoding = (StandardBaseEncoding) obj;
            return this.alphabet.equals(standardBaseEncoding.alphabet) && Objects.equals(this.paddingChar, standardBaseEncoding.paddingChar);
        }

        public int hashCode() {
            return this.alphabet.hashCode() ^ Objects.hashCode(this.paddingChar);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding ignoreCase() {
            BaseEncoding baseEncoding = this.ignoreCase;
            if (baseEncoding == null) {
                Alphabet ignoreCase = this.alphabet.ignoreCase();
                baseEncoding = ignoreCase == this.alphabet ? this : newInstance(ignoreCase, this.paddingChar);
                this.ignoreCase = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            BaseEncoding baseEncoding = this.lowerCase;
            if (baseEncoding == null) {
                Alphabet lowerCase = this.alphabet.lowerCase();
                baseEncoding = lowerCase == this.alphabet ? this : newInstance(lowerCase, this.paddingChar);
                this.lowerCase = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        int maxDecodedSize(int i3) {
            return (int) (((this.alphabet.bitsPerChar * i3) + 7) / 8);
        }

        @Override // com.google.common.io.BaseEncoding
        int maxEncodedSize(int i3) {
            Alphabet alphabet = this.alphabet;
            return alphabet.charsPerChunk * IntMath.divide(i3, alphabet.bytesPerChunk, RoundingMode.CEILING);
        }

        BaseEncoding newInstance(Alphabet alphabet, @CheckForNull Character ch) {
            return new StandardBaseEncoding(alphabet, ch);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.paddingChar == null ? this : newInstance(this.alphabet, null);
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.alphabet);
            if (8 % this.alphabet.bitsPerChar != 0) {
                if (this.paddingChar == null) {
                    str = ".omitPadding()";
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.paddingChar);
                    str = "')";
                }
                sb.append(str);
            }
            return sb.toString();
        }

        @Override // com.google.common.io.BaseEncoding
        CharSequence trimTrailingPadding(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            Character ch = this.paddingChar;
            if (ch == null) {
                return charSequence;
            }
            char charValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == charValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            BaseEncoding baseEncoding = this.upperCase;
            if (baseEncoding == null) {
                Alphabet upperCase = this.alphabet.upperCase();
                baseEncoding = upperCase == this.alphabet ? this : newInstance(upperCase, this.paddingChar);
                this.upperCase = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char c3) {
            Character ch;
            return (8 % this.alphabet.bitsPerChar == 0 || ((ch = this.paddingChar) != null && ch.charValue() == c3)) ? this : newInstance(this.alphabet, Character.valueOf(c3));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String str, int i3) {
            for (int i4 = 0; i4 < str.length(); i4++) {
                Preconditions.checkArgument(!this.alphabet.matches(str.charAt(i4)), "Separator (%s) cannot contain alphabet characters", str);
            }
            Character ch = this.paddingChar;
            if (ch != null) {
                Preconditions.checkArgument(str.indexOf(ch.charValue()) < 0, "Separator (%s) cannot contain padding character", str);
            }
            return new SeparatedBaseEncoding(this, str, i3);
        }
    }

    static {
        Character valueOf = Character.valueOf(Tag.KEY_VALUE_SEPARATOR);
        BASE64 = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", valueOf);
        BASE64_URL = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", valueOf);
        BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", valueOf);
        BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", valueOf);
        BASE16 = new Base16Encoding("base16()", "0123456789ABCDEF");
    }

    BaseEncoding() {
    }

    public static BaseEncoding base16() {
        return BASE16;
    }

    public static BaseEncoding base32() {
        return BASE32;
    }

    public static BaseEncoding base32Hex() {
        return BASE32_HEX;
    }

    public static BaseEncoding base64() {
        return BASE64;
    }

    public static BaseEncoding base64Url() {
        return BASE64_URL;
    }

    private static byte[] extract(byte[] bArr, int i3) {
        if (i3 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        return bArr2;
    }

    static Reader ignoringReader(final Reader reader, final String str) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(str);
        return new Reader() { // from class: com.google.common.io.BaseEncoding.3
            @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                reader.close();
            }

            @Override // java.io.Reader
            public int read() {
                int read;
                do {
                    read = reader.read();
                    if (read == -1) {
                        break;
                    }
                } while (str.indexOf((char) read) >= 0);
                return read;
            }

            @Override // java.io.Reader
            public int read(char[] cArr, int i3, int i4) {
                throw new UnsupportedOperationException();
            }
        };
    }

    static Appendable separatingAppendable(Appendable appendable, String str, int i3) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(i3 > 0);
        return new Appendable(i3, appendable, str) { // from class: com.google.common.io.BaseEncoding.4
            int charsUntilSeparator;
            final /* synthetic */ int val$afterEveryChars;
            final /* synthetic */ Appendable val$delegate;
            final /* synthetic */ String val$separator;

            {
                this.val$afterEveryChars = i3;
                this.val$delegate = appendable;
                this.val$separator = str;
                this.charsUntilSeparator = i3;
            }

            @Override // java.lang.Appendable
            public Appendable append(char c3) {
                if (this.charsUntilSeparator == 0) {
                    this.val$delegate.append(this.val$separator);
                    this.charsUntilSeparator = this.val$afterEveryChars;
                }
                this.val$delegate.append(c3);
                this.charsUntilSeparator--;
                return this;
            }

            @Override // java.lang.Appendable
            public Appendable append(@CheckForNull CharSequence charSequence) {
                throw new UnsupportedOperationException();
            }

            @Override // java.lang.Appendable
            public Appendable append(@CheckForNull CharSequence charSequence, int i4, int i5) {
                throw new UnsupportedOperationException();
            }
        };
    }

    static Writer separatingWriter(final Writer writer, String str, int i3) {
        final Appendable separatingAppendable = separatingAppendable(writer, str, i3);
        return new Writer() { // from class: com.google.common.io.BaseEncoding.5
            @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                writer.close();
            }

            @Override // java.io.Writer, java.io.Flushable
            public void flush() {
                writer.flush();
            }

            @Override // java.io.Writer
            public void write(int i4) {
                separatingAppendable.append((char) i4);
            }

            @Override // java.io.Writer
            public void write(char[] cArr, int i4, int i5) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public abstract boolean canDecode(CharSequence charSequence);

    public final byte[] decode(CharSequence charSequence) {
        try {
            return decodeChecked(charSequence);
        } catch (DecodingException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    final byte[] decodeChecked(CharSequence charSequence) {
        CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
        byte[] bArr = new byte[maxDecodedSize(trimTrailingPadding.length())];
        return extract(bArr, decodeTo(bArr, trimTrailingPadding));
    }

    abstract int decodeTo(byte[] bArr, CharSequence charSequence);

    public final ByteSource decodingSource(final CharSource charSource) {
        Preconditions.checkNotNull(charSource);
        return new ByteSource() { // from class: com.google.common.io.BaseEncoding.2
            @Override // com.google.common.io.ByteSource
            public InputStream openStream() {
                return BaseEncoding.this.decodingStream(charSource.openStream());
            }
        };
    }

    public abstract InputStream decodingStream(Reader reader);

    public String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public final String encode(byte[] bArr, int i3, int i4) {
        Preconditions.checkPositionIndexes(i3, i3 + i4, bArr.length);
        StringBuilder sb = new StringBuilder(maxEncodedSize(i4));
        try {
            encodeTo(sb, bArr, i3, i4);
            return sb.toString();
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }

    abstract void encodeTo(Appendable appendable, byte[] bArr, int i3, int i4);

    public final ByteSink encodingSink(final CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        return new ByteSink() { // from class: com.google.common.io.BaseEncoding.1
            @Override // com.google.common.io.ByteSink
            public OutputStream openStream() {
                return BaseEncoding.this.encodingStream(charSink.openStream());
            }
        };
    }

    public abstract OutputStream encodingStream(Writer writer);

    public abstract BaseEncoding ignoreCase();

    public abstract BaseEncoding lowerCase();

    abstract int maxDecodedSize(int i3);

    abstract int maxEncodedSize(int i3);

    public abstract BaseEncoding omitPadding();

    CharSequence trimTrailingPadding(CharSequence charSequence) {
        return (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    public abstract BaseEncoding upperCase();

    public abstract BaseEncoding withPadChar(char c3);

    public abstract BaseEncoding withSeparator(String str, int i3);
}
