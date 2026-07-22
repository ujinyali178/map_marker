package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /root/release/classes.dex */
public final class JsonStreamParser implements Iterator<JsonElement> {
    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        this.parser = jsonReader;
        jsonReader.setLenient(true);
        this.lock = new Object();
    }

    public JsonStreamParser(String str) {
        this(new StringReader(str));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z3;
        synchronized (this.lock) {
            try {
                try {
                    try {
                        z3 = this.parser.peek() != JsonToken.END_DOCUMENT;
                    } catch (IOException e3) {
                        throw new JsonIOException(e3);
                    }
                } catch (MalformedJsonException e4) {
                    throw new JsonSyntaxException(e4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public JsonElement next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return Streams.parse(this.parser);
        } catch (JsonParseException e3) {
            if (e3.getCause() instanceof EOFException) {
                throw new NoSuchElementException();
            }
            throw e3;
        } catch (OutOfMemoryError e4) {
            throw new JsonParseException("Failed parsing JSON source to Json", e4);
        } catch (StackOverflowError e5) {
            throw new JsonParseException("Failed parsing JSON source to Json", e5);
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
