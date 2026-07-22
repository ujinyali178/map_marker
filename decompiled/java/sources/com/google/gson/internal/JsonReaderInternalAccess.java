package com.google.gson.internal;

import com.google.gson.stream.JsonReader;

/* loaded from: /root/release/classes.dex */
public abstract class JsonReaderInternalAccess {
    public static JsonReaderInternalAccess INSTANCE;

    public abstract void promoteNameToValue(JsonReader jsonReader);
}
