package com.google.crypto.tink.internal;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import javax.annotation.Nullable;

/* loaded from: /root/release/classes.dex */
public final class JsonParser {
    private static final JsonElementTypeAdapter JSON_ELEMENT = new JsonElementTypeAdapter(null);

    /* renamed from: com.google.crypto.tink.internal.JsonParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static final class JsonElementTypeAdapter extends TypeAdapter<JsonElement> {
        private static final int RECURSION_LIMIT = 100;

        private JsonElementTypeAdapter() {
        }

        /* synthetic */ JsonElementTypeAdapter(AnonymousClass1 anonymousClass1) {
            this();
        }

        private JsonElement readTerminal(JsonReader jsonReader, JsonToken jsonToken) {
            int i3 = AnonymousClass1.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
            if (i3 == 3) {
                String nextString = jsonReader.nextString();
                if (JsonParser.isValidString(nextString)) {
                    return new JsonPrimitive(nextString);
                }
                throw new IOException("illegal characters in string");
            }
            if (i3 == 4) {
                return new JsonPrimitive(new LazilyParsedNumber(jsonReader.nextString()));
            }
            if (i3 == 5) {
                return new JsonPrimitive(Boolean.valueOf(jsonReader.nextBoolean()));
            }
            if (i3 == 6) {
                jsonReader.nextNull();
                return JsonNull.INSTANCE;
            }
            throw new IllegalStateException("Unexpected token: " + jsonToken);
        }

        @Nullable
        private JsonElement tryBeginNesting(JsonReader jsonReader, JsonToken jsonToken) {
            int i3 = AnonymousClass1.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
            if (i3 == 1) {
                jsonReader.beginArray();
                return new JsonArray();
            }
            if (i3 != 2) {
                return null;
            }
            jsonReader.beginObject();
            return new JsonObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public JsonElement read(JsonReader jsonReader) {
            JsonToken peek = jsonReader.peek();
            JsonElement tryBeginNesting = tryBeginNesting(jsonReader, peek);
            if (tryBeginNesting == null) {
                return readTerminal(jsonReader, peek);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (jsonReader.hasNext()) {
                    String str = null;
                    if (tryBeginNesting instanceof JsonObject) {
                        str = jsonReader.nextName();
                        if (!JsonParser.isValidString(str)) {
                            throw new IOException("illegal characters in string");
                        }
                    }
                    JsonToken peek2 = jsonReader.peek();
                    JsonElement tryBeginNesting2 = tryBeginNesting(jsonReader, peek2);
                    boolean z3 = tryBeginNesting2 != null;
                    if (tryBeginNesting2 == null) {
                        tryBeginNesting2 = readTerminal(jsonReader, peek2);
                    }
                    if (tryBeginNesting instanceof JsonArray) {
                        ((JsonArray) tryBeginNesting).add(tryBeginNesting2);
                    } else {
                        JsonObject jsonObject = (JsonObject) tryBeginNesting;
                        if (jsonObject.has(str)) {
                            throw new IOException("duplicate key: " + str);
                        }
                        jsonObject.add(str, tryBeginNesting2);
                    }
                    if (z3) {
                        arrayDeque.addLast(tryBeginNesting);
                        if (arrayDeque.size() > 100) {
                            throw new IOException("too many recursions");
                        }
                        tryBeginNesting = tryBeginNesting2;
                    } else {
                        continue;
                    }
                } else {
                    if (tryBeginNesting instanceof JsonArray) {
                        jsonReader.endArray();
                    } else {
                        jsonReader.endObject();
                    }
                    if (arrayDeque.isEmpty()) {
                        return tryBeginNesting;
                    }
                    tryBeginNesting = (JsonElement) arrayDeque.removeLast();
                }
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, JsonElement jsonElement) {
            throw new UnsupportedOperationException("write is not supported");
        }
    }

    private static final class LazilyParsedNumber extends Number {
        private final String value;

        public LazilyParsedNumber(String str) {
            this.value = str;
        }

        private void readObject(ObjectInputStream objectInputStream) {
            throw new NotSerializableException("serialization is not supported");
        }

        private Object writeReplace() {
            throw new NotSerializableException("serialization is not supported");
        }

        @Override // java.lang.Number
        public double doubleValue() {
            return Double.parseDouble(this.value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LazilyParsedNumber) {
                return this.value.equals(((LazilyParsedNumber) obj).value);
            }
            return false;
        }

        @Override // java.lang.Number
        public float floatValue() {
            return Float.parseFloat(this.value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @Override // java.lang.Number
        public int intValue() {
            try {
                try {
                    return Integer.parseInt(this.value);
                } catch (NumberFormatException unused) {
                    return (int) Long.parseLong(this.value);
                }
            } catch (NumberFormatException unused2) {
                return new BigDecimal(this.value).intValue();
            }
        }

        @Override // java.lang.Number
        public long longValue() {
            try {
                return Long.parseLong(this.value);
            } catch (NumberFormatException unused) {
                return new BigDecimal(this.value).longValue();
            }
        }

        public String toString() {
            return this.value;
        }
    }

    private JsonParser() {
    }

    public static long getParsedNumberAsLongOrThrow(JsonElement jsonElement) {
        if (jsonElement.getAsNumber() instanceof LazilyParsedNumber) {
            return Long.parseLong(jsonElement.getAsNumber().toString());
        }
        throw new IllegalArgumentException("does not contain a parsed number.");
    }

    public static boolean isValidString(String str) {
        int length = str.length();
        int i3 = 0;
        while (i3 != length) {
            char charAt = str.charAt(i3);
            i3++;
            if (Character.isSurrogate(charAt)) {
                if (Character.isLowSurrogate(charAt) || i3 == length || !Character.isLowSurrogate(str.charAt(i3))) {
                    return false;
                }
                i3++;
            }
        }
        return true;
    }

    public static JsonElement parse(String str) {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            jsonReader.setLenient(false);
            return JSON_ELEMENT.read(jsonReader);
        } catch (NumberFormatException e3) {
            throw new IOException(e3);
        }
    }
}
