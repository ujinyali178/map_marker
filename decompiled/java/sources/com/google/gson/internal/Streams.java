package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* loaded from: /root/release/classes.dex */
public final class Streams {

    private static final class AppendableWriter extends Writer {
        private final Appendable appendable;
        private final CurrentWrite currentWrite = new CurrentWrite();

        static class CurrentWrite implements CharSequence {
            char[] chars;

            CurrentWrite() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i3) {
                return this.chars[i3];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.chars.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i3, int i4) {
                return new String(this.chars, i3, i4 - i3);
            }
        }

        AppendableWriter(Appendable appendable) {
            this.appendable = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i3) {
            this.appendable.append((char) i3);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i3, int i4) {
            CurrentWrite currentWrite = this.currentWrite;
            currentWrite.chars = cArr;
            this.appendable.append(currentWrite, i3, i4 + i3);
        }
    }

    private Streams() {
        throw new UnsupportedOperationException();
    }

    public static JsonElement parse(JsonReader jsonReader) {
        boolean z3;
        try {
            try {
                jsonReader.peek();
                z3 = false;
            } catch (EOFException e3) {
                e = e3;
                z3 = true;
            }
            try {
                return TypeAdapters.JSON_ELEMENT.read(jsonReader);
            } catch (EOFException e4) {
                e = e4;
                if (z3) {
                    return JsonNull.INSTANCE;
                }
                throw new JsonSyntaxException(e);
            }
        } catch (MalformedJsonException e5) {
            throw new JsonSyntaxException(e5);
        } catch (IOException e6) {
            throw new JsonIOException(e6);
        } catch (NumberFormatException e7) {
            throw new JsonSyntaxException(e7);
        }
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new AppendableWriter(appendable);
    }
}
