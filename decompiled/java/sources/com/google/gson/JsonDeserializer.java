package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: /root/release/classes.dex */
public interface JsonDeserializer<T> {
    T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext);
}
