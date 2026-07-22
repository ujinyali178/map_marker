package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.maps.android.BuildConfig;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.io.FilenameUtils;

/* loaded from: /root/release/classes.dex */
public final class JsonTreeReader extends JsonReader {
    private int[] pathIndices;
    private String[] pathNames;
    private Object[] stack;
    private int stackSize;
    private static final Reader UNREADABLE_READER = new Reader() { // from class: com.google.gson.internal.bind.JsonTreeReader.1
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i3, int i4) {
            throw new AssertionError();
        }
    };
    private static final Object SENTINEL_CLOSED = new Object();

    public JsonTreeReader(JsonElement jsonElement) {
        super(UNREADABLE_READER);
        this.stack = new Object[32];
        this.stackSize = 0;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        push(jsonElement);
    }

    private void expect(JsonToken jsonToken) {
        if (peek() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek() + locationString());
    }

    private String locationString() {
        return " at path " + getPath();
    }

    private Object peekStack() {
        return this.stack[this.stackSize - 1];
    }

    private Object popStack() {
        Object[] objArr = this.stack;
        int i3 = this.stackSize - 1;
        this.stackSize = i3;
        Object obj = objArr[i3];
        objArr[i3] = null;
        return obj;
    }

    private void push(Object obj) {
        int i3 = this.stackSize;
        Object[] objArr = this.stack;
        if (i3 == objArr.length) {
            int i4 = i3 * 2;
            this.stack = Arrays.copyOf(objArr, i4);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i4);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i4);
        }
        Object[] objArr2 = this.stack;
        int i5 = this.stackSize;
        this.stackSize = i5 + 1;
        objArr2[i5] = obj;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() {
        expect(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) peekStack()).iterator());
        this.pathIndices[this.stackSize - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() {
        expect(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) peekStack()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.stack = new Object[]{SENTINEL_CLOSED};
        this.stackSize = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() {
        expect(JsonToken.END_ARRAY);
        popStack();
        popStack();
        int i3 = this.stackSize;
        if (i3 > 0) {
            int[] iArr = this.pathIndices;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() {
        expect(JsonToken.END_OBJECT);
        popStack();
        popStack();
        int i3 = this.stackSize;
        if (i3 > 0) {
            int[] iArr = this.pathIndices;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i3 = 0;
        while (true) {
            int i4 = this.stackSize;
            if (i3 >= i4) {
                return sb.toString();
            }
            Object[] objArr = this.stack;
            Object obj = objArr[i3];
            if (obj instanceof JsonArray) {
                i3++;
                if (i3 < i4 && (objArr[i3] instanceof Iterator)) {
                    sb.append('[');
                    sb.append(this.pathIndices[i3]);
                    sb.append(']');
                }
            } else if ((obj instanceof JsonObject) && (i3 = i3 + 1) < i4 && (objArr[i3] instanceof Iterator)) {
                sb.append(FilenameUtils.EXTENSION_SEPARATOR);
                String str = this.pathNames[i3];
                if (str != null) {
                    sb.append(str);
                }
            }
            i3++;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() {
        JsonToken peek = peek();
        return (peek == JsonToken.END_OBJECT || peek == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() {
        expect(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) popStack()).getAsBoolean();
        int i3 = this.stackSize;
        if (i3 > 0) {
            int[] iArr = this.pathIndices;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        double asDouble = ((JsonPrimitive) peekStack()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        popStack();
        int i3 = this.stackSize;
        if (i3 > 0) {
            int[] iArr = this.pathIndices;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        int asInt = ((JsonPrimitive) peekStack()).getAsInt();
        popStack();
        int i3 = this.stackSize;
        if (i3 > 0) {
            int[] iArr = this.pathIndices;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
        return asInt;
    }

    JsonElement nextJsonElement() {
        JsonToken peek = peek();
        if (peek != JsonToken.NAME && peek != JsonToken.END_ARRAY && peek != JsonToken.END_OBJECT && peek != JsonToken.END_DOCUMENT) {
            JsonElement jsonElement = (JsonElement) peekStack();
            skipValue();
            return jsonElement;
        }
        throw new IllegalStateException("Unexpected " + peek + " when reading a JsonElement.");
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        long asLong = ((JsonPrimitive) peekStack()).getAsLong();
        popStack();
        int i3 = this.stackSize;
        if (i3 > 0) {
            int[] iArr = this.pathIndices;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
        return asLong;
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() {
        expect(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) peekStack()).next();
        String str = (String) entry.getKey();
        this.pathNames[this.stackSize - 1] = str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() {
        expect(JsonToken.NULL);
        popStack();
        int i3 = this.stackSize;
        if (i3 > 0) {
            int[] iArr = this.pathIndices;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.STRING;
        if (peek == jsonToken || peek == JsonToken.NUMBER) {
            String asString = ((JsonPrimitive) popStack()).getAsString();
            int i3 = this.stackSize;
            if (i3 > 0) {
                int[] iArr = this.pathIndices;
                int i4 = i3 - 1;
                iArr[i4] = iArr[i4] + 1;
            }
            return asString;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() {
        if (this.stackSize == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object peekStack = peekStack();
        if (peekStack instanceof Iterator) {
            boolean z3 = this.stack[this.stackSize - 2] instanceof JsonObject;
            Iterator it = (Iterator) peekStack;
            if (!it.hasNext()) {
                return z3 ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z3) {
                return JsonToken.NAME;
            }
            push(it.next());
            return peek();
        }
        if (peekStack instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (peekStack instanceof JsonArray) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (!(peekStack instanceof JsonPrimitive)) {
            if (peekStack instanceof JsonNull) {
                return JsonToken.NULL;
            }
            if (peekStack == SENTINEL_CLOSED) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) peekStack;
        if (jsonPrimitive.isString()) {
            return JsonToken.STRING;
        }
        if (jsonPrimitive.isBoolean()) {
            return JsonToken.BOOLEAN;
        }
        if (jsonPrimitive.isNumber()) {
            return JsonToken.NUMBER;
        }
        throw new AssertionError();
    }

    public void promoteNameToValue() {
        expect(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) peekStack()).next();
        push(entry.getValue());
        push(new JsonPrimitive((String) entry.getKey()));
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() {
        if (peek() == JsonToken.NAME) {
            nextName();
            this.pathNames[this.stackSize - 2] = BuildConfig.TRAVIS;
        } else {
            popStack();
            int i3 = this.stackSize;
            if (i3 > 0) {
                this.pathNames[i3 - 1] = BuildConfig.TRAVIS;
            }
        }
        int i4 = this.stackSize;
        if (i4 > 0) {
            int[] iArr = this.pathIndices;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return JsonTreeReader.class.getSimpleName() + locationString();
    }
}
