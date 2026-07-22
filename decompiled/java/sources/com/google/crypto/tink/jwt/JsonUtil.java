package com.google.crypto.tink.jwt;

import com.google.crypto.tink.internal.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.IOException;

/* loaded from: /root/release/classes.dex */
final class JsonUtil {
    private JsonUtil() {
    }

    static boolean isValidString(String str) {
        return JsonParser.isValidString(str);
    }

    static JsonObject parseJson(String str) {
        try {
            return JsonParser.parse(str).getAsJsonObject();
        } catch (JsonParseException | IOException | IllegalStateException e3) {
            throw new JwtInvalidException("invalid JSON: " + e3);
        }
    }

    static JsonArray parseJsonArray(String str) {
        try {
            return JsonParser.parse(str).getAsJsonArray();
        } catch (JsonParseException | IOException | IllegalStateException e3) {
            throw new JwtInvalidException("invalid JSON: " + e3);
        }
    }
}
