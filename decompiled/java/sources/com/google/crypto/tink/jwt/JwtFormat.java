package com.google.crypto.tink.jwt;

import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonObject;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Optional;

/* loaded from: /root/release/classes.dex */
final class JwtFormat {

    static class Parts {
        String header;
        String payload;
        byte[] signatureOrMac;
        String unsignedCompact;

        Parts(String str, byte[] bArr, String str2, String str3) {
            this.unsignedCompact = str;
            this.signatureOrMac = bArr;
            this.header = str2;
            this.payload = str3;
        }
    }

    private JwtFormat() {
    }

    static String createHeader(String str, Optional<String> optional, Optional<String> optional2) {
        validateAlgorithm(str);
        JsonObject jsonObject = new JsonObject();
        if (optional2.isPresent()) {
            jsonObject.addProperty("kid", optional2.get());
        }
        jsonObject.addProperty("alg", str);
        if (optional.isPresent()) {
            jsonObject.addProperty(ClientData.KEY_TYPE, optional.get());
        }
        return Base64.urlSafeEncode(jsonObject.toString().getBytes(Util.UTF_8));
    }

    static String createSignedCompact(String str, byte[] bArr) {
        return str + "." + encodeSignature(bArr);
    }

    static String createUnsignedCompact(String str, Optional<String> optional, RawJwt rawJwt) {
        String jsonPayload = rawJwt.getJsonPayload();
        return createHeader(str, rawJwt.hasTypeHeader() ? Optional.of(rawJwt.getTypeHeader()) : Optional.empty(), optional) + "." + encodePayload(jsonPayload);
    }

    static String decodeHeader(String str) {
        byte[] strictUrlSafeDecode = strictUrlSafeDecode(str);
        validateUtf8(strictUrlSafeDecode);
        return new String(strictUrlSafeDecode, Util.UTF_8);
    }

    static String decodePayload(String str) {
        byte[] strictUrlSafeDecode = strictUrlSafeDecode(str);
        validateUtf8(strictUrlSafeDecode);
        return new String(strictUrlSafeDecode, Util.UTF_8);
    }

    static byte[] decodeSignature(String str) {
        return strictUrlSafeDecode(str);
    }

    static String encodePayload(String str) {
        return Base64.urlSafeEncode(str.getBytes(Util.UTF_8));
    }

    static String encodeSignature(byte[] bArr) {
        return Base64.urlSafeEncode(bArr);
    }

    static Optional<Integer> getKeyId(String str) {
        byte[] urlSafeDecode = Base64.urlSafeDecode(str);
        return urlSafeDecode.length != 4 ? Optional.empty() : Optional.of(Integer.valueOf(ByteBuffer.wrap(urlSafeDecode).getInt()));
    }

    static Optional<String> getKid(int i3, OutputPrefixType outputPrefixType) {
        if (outputPrefixType == OutputPrefixType.RAW) {
            return Optional.empty();
        }
        if (outputPrefixType == OutputPrefixType.TINK) {
            return Optional.of(Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(i3).array()));
        }
        throw new JwtInvalidException("unsupported output prefix type");
    }

    private static String getStringHeader(JsonObject jsonObject, String str) {
        if (!jsonObject.has(str)) {
            throw new JwtInvalidException("header " + str + " does not exist");
        }
        if (jsonObject.get(str).isJsonPrimitive() && jsonObject.get(str).getAsJsonPrimitive().isString()) {
            return jsonObject.get(str).getAsString();
        }
        throw new JwtInvalidException("header " + str + " is not a string");
    }

    static Optional<String> getTypeHeader(JsonObject jsonObject) {
        return jsonObject.has(ClientData.KEY_TYPE) ? Optional.of(getStringHeader(jsonObject, ClientData.KEY_TYPE)) : Optional.empty();
    }

    static boolean isValidUrlsafeBase64Char(char c3) {
        return (c3 >= 'a' && c3 <= 'z') || (c3 >= 'A' && c3 <= 'Z') || ((c3 >= '0' && c3 <= '9') || c3 == '-' || c3 == '_');
    }

    static Parts splitSignedCompact(String str) {
        validateASCII(str);
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
        }
        String substring = str.substring(0, lastIndexOf);
        byte[] decodeSignature = decodeSignature(str.substring(lastIndexOf + 1));
        int indexOf = substring.indexOf(46);
        if (indexOf < 0) {
            throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
        }
        String substring2 = substring.substring(0, indexOf);
        String substring3 = substring.substring(indexOf + 1);
        if (substring3.indexOf(46) <= 0) {
            return new Parts(substring, decodeSignature, decodeHeader(substring2), decodePayload(substring3));
        }
        throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
    }

    static byte[] strictUrlSafeDecode(String str) {
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (!isValidUrlsafeBase64Char(str.charAt(i3))) {
                throw new JwtInvalidException("invalid encoding");
            }
        }
        try {
            return Base64.urlSafeDecode(str);
        } catch (IllegalArgumentException e3) {
            throw new JwtInvalidException("invalid encoding: " + e3);
        }
    }

    static void validateASCII(String str) {
        for (int i3 = 0; i3 < str.length(); i3++) {
            if ((str.charAt(i3) & 128) > 0) {
                throw new JwtInvalidException("Non ascii character");
            }
        }
    }

    private static void validateAlgorithm(String str) {
        str.hashCode();
        switch (str) {
            case "ES256":
            case "ES384":
            case "ES512":
            case "HS256":
            case "HS384":
            case "HS512":
            case "PS256":
            case "PS384":
            case "PS512":
            case "RS256":
            case "RS384":
            case "RS512":
                return;
            default:
                throw new InvalidAlgorithmParameterException("invalid algorithm: " + str);
        }
    }

    static void validateHeader(String str, Optional<String> optional, Optional<String> optional2, JsonObject jsonObject) {
        validateAlgorithm(str);
        String stringHeader = getStringHeader(jsonObject, "alg");
        if (!stringHeader.equals(str)) {
            throw new InvalidAlgorithmParameterException(String.format("invalid algorithm; expected %s, got %s", str, stringHeader));
        }
        if (jsonObject.has("crit")) {
            throw new JwtInvalidException("all tokens with crit headers are rejected");
        }
        if (optional.isPresent() && optional2.isPresent()) {
            throw new JwtInvalidException("custom_kid can only be set for RAW keys.");
        }
        boolean has = jsonObject.has("kid");
        if (optional.isPresent()) {
            if (!has) {
                throw new JwtInvalidException("missing kid in header");
            }
            validateKidInHeader(optional.get(), jsonObject);
        }
        if (optional2.isPresent() && has) {
            validateKidInHeader(optional2.get(), jsonObject);
        }
    }

    private static void validateKidInHeader(String str, JsonObject jsonObject) {
        if (!getStringHeader(jsonObject, "kid").equals(str)) {
            throw new JwtInvalidException("invalid kid in header");
        }
    }

    static void validateUtf8(byte[] bArr) {
        try {
            Util.UTF_8.newDecoder().decode(ByteBuffer.wrap(bArr));
        } catch (CharacterCodingException e3) {
            throw new JwtInvalidException(e3.getMessage());
        }
    }
}
