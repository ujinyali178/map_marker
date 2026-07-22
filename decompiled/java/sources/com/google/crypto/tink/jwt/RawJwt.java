package com.google.crypto.tink.jwt;

import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.google.errorprone.annotations.Immutable;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Immutable
/* loaded from: /root/release/classes.dex */
public final class RawJwt {
    private static final long MAX_TIMESTAMP_VALUE = 253402300799L;
    private final JsonObject payload;
    private final Optional<String> typeHeader;

    public static final class Builder {
        private final JsonObject payload;
        private Optional<String> typeHeader;
        private boolean withoutExpiration;

        private Builder() {
            this.typeHeader = Optional.empty();
            this.withoutExpiration = false;
            this.payload = new JsonObject();
        }

        private void setTimestampClaim(String str, Instant instant) {
            long epochSecond = instant.getEpochSecond();
            if (epochSecond <= RawJwt.MAX_TIMESTAMP_VALUE && epochSecond >= 0) {
                this.payload.add(str, new JsonPrimitive(Long.valueOf(epochSecond)));
                return;
            }
            throw new IllegalArgumentException("timestamp of claim " + str + " is out of range");
        }

        public Builder addAudience(String str) {
            JsonArray jsonArray;
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException("invalid string");
            }
            if (this.payload.has("aud")) {
                JsonElement jsonElement = this.payload.get("aud");
                if (!jsonElement.isJsonArray()) {
                    throw new IllegalArgumentException("addAudience can't be used together with setAudience");
                }
                jsonArray = jsonElement.getAsJsonArray();
            } else {
                jsonArray = new JsonArray();
            }
            jsonArray.add(str);
            this.payload.add("aud", jsonArray);
            return this;
        }

        public Builder addBooleanClaim(String str, boolean z3) {
            JwtNames.validate(str);
            this.payload.add(str, new JsonPrimitive(Boolean.valueOf(z3)));
            return this;
        }

        public Builder addJsonArrayClaim(String str, String str2) {
            JwtNames.validate(str);
            this.payload.add(str, JsonUtil.parseJsonArray(str2));
            return this;
        }

        public Builder addJsonObjectClaim(String str, String str2) {
            JwtNames.validate(str);
            this.payload.add(str, JsonUtil.parseJson(str2));
            return this;
        }

        public Builder addNullClaim(String str) {
            JwtNames.validate(str);
            this.payload.add(str, JsonNull.INSTANCE);
            return this;
        }

        public Builder addNumberClaim(String str, double d3) {
            JwtNames.validate(str);
            this.payload.add(str, new JsonPrimitive(Double.valueOf(d3)));
            return this;
        }

        public Builder addStringClaim(String str, String str2) {
            if (!JsonUtil.isValidString(str2)) {
                throw new IllegalArgumentException();
            }
            JwtNames.validate(str);
            this.payload.add(str, new JsonPrimitive(str2));
            return this;
        }

        public RawJwt build() {
            return new RawJwt(this);
        }

        public Builder setAudience(String str) {
            if (this.payload.has("aud") && this.payload.get("aud").isJsonArray()) {
                throw new IllegalArgumentException("setAudience can't be used together with setAudiences or addAudience");
            }
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException("invalid string");
            }
            this.payload.add("aud", new JsonPrimitive(str));
            return this;
        }

        public Builder setAudiences(List<String> list) {
            if (this.payload.has("aud") && !this.payload.get("aud").isJsonArray()) {
                throw new IllegalArgumentException("setAudiences can't be used together with setAudience");
            }
            if (list.isEmpty()) {
                throw new IllegalArgumentException("audiences must not be empty");
            }
            JsonArray jsonArray = new JsonArray();
            for (String str : list) {
                if (!JsonUtil.isValidString(str)) {
                    throw new IllegalArgumentException("invalid string");
                }
                jsonArray.add(str);
            }
            this.payload.add("aud", jsonArray);
            return this;
        }

        public Builder setExpiration(Instant instant) {
            setTimestampClaim("exp", instant);
            return this;
        }

        public Builder setIssuedAt(Instant instant) {
            setTimestampClaim("iat", instant);
            return this;
        }

        public Builder setIssuer(String str) {
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException();
            }
            this.payload.add("iss", new JsonPrimitive(str));
            return this;
        }

        public Builder setJwtId(String str) {
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException();
            }
            this.payload.add("jti", new JsonPrimitive(str));
            return this;
        }

        public Builder setNotBefore(Instant instant) {
            setTimestampClaim("nbf", instant);
            return this;
        }

        public Builder setSubject(String str) {
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException();
            }
            this.payload.add("sub", new JsonPrimitive(str));
            return this;
        }

        public Builder setTypeHeader(String str) {
            this.typeHeader = Optional.of(str);
            return this;
        }

        public Builder withoutExpiration() {
            this.withoutExpiration = true;
            return this;
        }
    }

    private RawJwt(Builder builder) {
        if (!builder.payload.has("exp") && !builder.withoutExpiration) {
            throw new IllegalArgumentException("neither setExpiration() nor withoutExpiration() was called");
        }
        if (builder.payload.has("exp") && builder.withoutExpiration) {
            throw new IllegalArgumentException("setExpiration() and withoutExpiration() must not be called together");
        }
        this.typeHeader = builder.typeHeader;
        this.payload = builder.payload.deepCopy();
    }

    private RawJwt(Optional<String> optional, String str) {
        this.typeHeader = optional;
        this.payload = JsonUtil.parseJson(str);
        validateStringClaim("iss");
        validateStringClaim("sub");
        validateStringClaim("jti");
        validateTimestampClaim("exp");
        validateTimestampClaim("nbf");
        validateTimestampClaim("iat");
        validateAudienceClaim();
    }

    static RawJwt fromJsonPayload(Optional<String> optional, String str) {
        return new RawJwt(optional, str);
    }

    private Instant getInstant(String str) {
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (!this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isNumber()) {
            throw new JwtInvalidException("claim " + str + " is not a timestamp");
        }
        try {
            return Instant.ofEpochMilli((long) (this.payload.get(str).getAsJsonPrimitive().getAsDouble() * 1000.0d));
        } catch (NumberFormatException e3) {
            throw new JwtInvalidException("claim " + str + " is not a timestamp: " + e3);
        }
    }

    private String getStringClaimInternal(String str) {
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isString()) {
            return this.payload.get(str).getAsString();
        }
        throw new JwtInvalidException("claim " + str + " is not a string");
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private void validateAudienceClaim() {
        if (this.payload.has("aud")) {
            if (!(this.payload.get("aud").isJsonPrimitive() && this.payload.get("aud").getAsJsonPrimitive().isString()) && getAudiences().size() < 1) {
                throw new JwtInvalidException("invalid JWT payload: claim aud is present but empty.");
            }
        }
    }

    private void validateStringClaim(String str) {
        if (this.payload.has(str)) {
            if (this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isString()) {
                return;
            }
            throw new JwtInvalidException("invalid JWT payload: claim " + str + " is not a string.");
        }
    }

    private void validateTimestampClaim(String str) {
        if (this.payload.has(str)) {
            if (!this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isNumber()) {
                throw new JwtInvalidException("invalid JWT payload: claim " + str + " is not a number.");
            }
            double asDouble = this.payload.get(str).getAsJsonPrimitive().getAsDouble();
            if (asDouble > 2.53402300799E11d || asDouble < 0.0d) {
                throw new JwtInvalidException("invalid JWT payload: claim " + str + " has an invalid timestamp");
            }
        }
    }

    Set<String> customClaimNames() {
        HashSet hashSet = new HashSet();
        for (String str : this.payload.keySet()) {
            if (!JwtNames.isRegisteredName(str)) {
                hashSet.add(str);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    List<String> getAudiences() {
        if (!hasAudiences()) {
            throw new JwtInvalidException("claim aud does not exist");
        }
        JsonElement jsonElement = this.payload.get("aud");
        if (jsonElement.isJsonPrimitive()) {
            if (jsonElement.getAsJsonPrimitive().isString()) {
                return Collections.unmodifiableList(Arrays.asList(jsonElement.getAsString()));
            }
            throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", jsonElement));
        }
        if (!jsonElement.isJsonArray()) {
            throw new JwtInvalidException("claim aud is not a string or a JSON array");
        }
        JsonArray asJsonArray = jsonElement.getAsJsonArray();
        ArrayList arrayList = new ArrayList(asJsonArray.size());
        for (int i3 = 0; i3 < asJsonArray.size(); i3++) {
            if (!asJsonArray.get(i3).isJsonPrimitive() || !asJsonArray.get(i3).getAsJsonPrimitive().isString()) {
                throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", asJsonArray.get(i3)));
            }
            arrayList.add(asJsonArray.get(i3).getAsString());
        }
        return Collections.unmodifiableList(arrayList);
    }

    Boolean getBooleanClaim(String str) {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isBoolean()) {
            return Boolean.valueOf(this.payload.get(str).getAsBoolean());
        }
        throw new JwtInvalidException("claim " + str + " is not a boolean");
    }

    Instant getExpiration() {
        return getInstant("exp");
    }

    Instant getIssuedAt() {
        return getInstant("iat");
    }

    String getIssuer() {
        return getStringClaimInternal("iss");
    }

    String getJsonArrayClaim(String str) {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (this.payload.get(str).isJsonArray()) {
            return this.payload.get(str).getAsJsonArray().toString();
        }
        throw new JwtInvalidException("claim " + str + " is not a JSON array");
    }

    String getJsonObjectClaim(String str) {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (this.payload.get(str).isJsonObject()) {
            return this.payload.get(str).getAsJsonObject().toString();
        }
        throw new JwtInvalidException("claim " + str + " is not a JSON object");
    }

    String getJsonPayload() {
        return this.payload.toString();
    }

    String getJwtId() {
        return getStringClaimInternal("jti");
    }

    Instant getNotBefore() {
        return getInstant("nbf");
    }

    Double getNumberClaim(String str) {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isNumber()) {
            return Double.valueOf(this.payload.get(str).getAsDouble());
        }
        throw new JwtInvalidException("claim " + str + " is not a number");
    }

    String getStringClaim(String str) {
        JwtNames.validate(str);
        return getStringClaimInternal(str);
    }

    String getSubject() {
        return getStringClaimInternal("sub");
    }

    String getTypeHeader() {
        if (this.typeHeader.isPresent()) {
            return this.typeHeader.get();
        }
        throw new JwtInvalidException("type header is not set");
    }

    boolean hasAudiences() {
        return this.payload.has("aud");
    }

    boolean hasBooleanClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isBoolean();
    }

    boolean hasExpiration() {
        return this.payload.has("exp");
    }

    boolean hasIssuedAt() {
        return this.payload.has("iat");
    }

    boolean hasIssuer() {
        return this.payload.has("iss");
    }

    boolean hasJsonArrayClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonArray();
    }

    boolean hasJsonObjectClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonObject();
    }

    boolean hasJwtId() {
        return this.payload.has("jti");
    }

    boolean hasNotBefore() {
        return this.payload.has("nbf");
    }

    boolean hasNumberClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isNumber();
    }

    boolean hasStringClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isString();
    }

    boolean hasSubject() {
        return this.payload.has("sub");
    }

    boolean hasTypeHeader() {
        return this.typeHeader.isPresent();
    }

    boolean isNullClaim(String str) {
        JwtNames.validate(str);
        try {
            return JsonNull.INSTANCE.equals(this.payload.get(str));
        } catch (JsonParseException unused) {
            return false;
        }
    }

    public String toString() {
        JsonObject jsonObject = new JsonObject();
        if (this.typeHeader.isPresent()) {
            jsonObject.add(ClientData.KEY_TYPE, new JsonPrimitive(this.typeHeader.get()));
        }
        return jsonObject + "." + this.payload;
    }
}
