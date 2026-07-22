package com.google.gson;

import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: /root/release/classes.dex */
public abstract class TypeAdapter<T> {
    public final T fromJson(Reader reader) {
        return read(new JsonReader(reader));
    }

    public final T fromJson(String str) {
        return fromJson(new StringReader(str));
    }

    public final T fromJsonTree(JsonElement jsonElement) {
        try {
            return read(new JsonTreeReader(jsonElement));
        } catch (IOException e3) {
            throw new JsonIOException(e3);
        }
    }

    public final TypeAdapter<T> nullSafe() {
        return new TypeAdapter<T>() { // from class: com.google.gson.TypeAdapter.1
            @Override // com.google.gson.TypeAdapter
            public T read(JsonReader jsonReader) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return (T) TypeAdapter.this.read(jsonReader);
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T t3) {
                if (t3 == null) {
                    jsonWriter.nullValue();
                } else {
                    TypeAdapter.this.write(jsonWriter, t3);
                }
            }
        };
    }

    public abstract T read(JsonReader jsonReader);

    public final String toJson(T t3) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t3);
            return stringWriter.toString();
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }

    public final void toJson(Writer writer, T t3) {
        write(new JsonWriter(writer), t3);
    }

    public final JsonElement toJsonTree(T t3) {
        try {
            JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
            write(jsonTreeWriter, t3);
            return jsonTreeWriter.get();
        } catch (IOException e3) {
            throw new JsonIOException(e3);
        }
    }

    public abstract void write(JsonWriter jsonWriter, T t3);
}
