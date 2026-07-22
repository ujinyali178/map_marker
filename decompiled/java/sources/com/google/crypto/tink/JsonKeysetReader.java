package com.google.crypto.tink;

import com.google.crypto.tink.internal.JsonParser;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;

/* loaded from: /root/release/classes.dex */
public final class JsonKeysetReader implements KeysetReader {
    private static final long MAX_KEY_ID = 4294967295L;
    private static final long MIN_KEY_ID = -2147483648L;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final InputStream inputStream;
    private boolean urlSafeBase64 = false;

    private JsonKeysetReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    private EncryptedKeyset encryptedKeysetFromJson(JsonObject jsonObject) {
        validateEncryptedKeyset(jsonObject);
        byte[] urlSafeDecode = this.urlSafeBase64 ? Base64.urlSafeDecode(jsonObject.get("encryptedKeyset").getAsString()) : Base64.decode(jsonObject.get("encryptedKeyset").getAsString());
        return (jsonObject.has("keysetInfo") ? EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(urlSafeDecode)).setKeysetInfo(keysetInfoFromJson(jsonObject.getAsJsonObject("keysetInfo"))) : EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(urlSafeDecode))).build();
    }

    private static int getKeyId(JsonElement jsonElement) {
        try {
            long parsedNumberAsLongOrThrow = JsonParser.getParsedNumberAsLongOrThrow(jsonElement);
            if (parsedNumberAsLongOrThrow > MAX_KEY_ID || parsedNumberAsLongOrThrow < MIN_KEY_ID) {
                throw new IOException("invalid key id");
            }
            return (int) jsonElement.getAsLong();
        } catch (NumberFormatException e3) {
            throw new IOException(e3);
        }
    }

    private static KeyData.KeyMaterialType getKeyMaterialType(String str) {
        str.hashCode();
        switch (str) {
            case "REMOTE":
                return KeyData.KeyMaterialType.REMOTE;
            case "SYMMETRIC":
                return KeyData.KeyMaterialType.SYMMETRIC;
            case "ASYMMETRIC_PRIVATE":
                return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
            case "ASYMMETRIC_PUBLIC":
                return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
            default:
                throw new JsonParseException("unknown key material type: " + str);
        }
    }

    private static OutputPrefixType getOutputPrefixType(String str) {
        str.hashCode();
        switch (str) {
            case "LEGACY":
                return OutputPrefixType.LEGACY;
            case "RAW":
                return OutputPrefixType.RAW;
            case "TINK":
                return OutputPrefixType.TINK;
            case "CRUNCHY":
                return OutputPrefixType.CRUNCHY;
            default:
                throw new JsonParseException("unknown output prefix type: " + str);
        }
    }

    private static KeyStatusType getStatus(String str) {
        str.hashCode();
        switch (str) {
            case "ENABLED":
                return KeyStatusType.ENABLED;
            case "DESTROYED":
                return KeyStatusType.DESTROYED;
            case "DISABLED":
                return KeyStatusType.DISABLED;
            default:
                throw new JsonParseException("unknown status: " + str);
        }
    }

    private KeyData keyDataFromJson(JsonObject jsonObject) {
        validateKeyData(jsonObject);
        return KeyData.newBuilder().setTypeUrl(jsonObject.get("typeUrl").getAsString()).setValue(ByteString.copyFrom(this.urlSafeBase64 ? Base64.urlSafeDecode(jsonObject.get("value").getAsString()) : Base64.decode(jsonObject.get("value").getAsString()))).setKeyMaterialType(getKeyMaterialType(jsonObject.get("keyMaterialType").getAsString())).build();
    }

    private Keyset.Key keyFromJson(JsonObject jsonObject) {
        validateKey(jsonObject);
        return Keyset.Key.newBuilder().setStatus(getStatus(jsonObject.get("status").getAsString())).setKeyId(getKeyId(jsonObject.get("keyId"))).setOutputPrefixType(getOutputPrefixType(jsonObject.get("outputPrefixType").getAsString())).setKeyData(keyDataFromJson(jsonObject.getAsJsonObject("keyData"))).build();
    }

    private static KeysetInfo.KeyInfo keyInfoFromJson(JsonObject jsonObject) {
        return KeysetInfo.KeyInfo.newBuilder().setStatus(getStatus(jsonObject.get("status").getAsString())).setKeyId(getKeyId(jsonObject.get("keyId"))).setOutputPrefixType(getOutputPrefixType(jsonObject.get("outputPrefixType").getAsString())).setTypeUrl(jsonObject.get("typeUrl").getAsString()).build();
    }

    private Keyset keysetFromJson(JsonObject jsonObject) {
        validateKeyset(jsonObject);
        Keyset.Builder newBuilder = Keyset.newBuilder();
        if (jsonObject.has("primaryKeyId")) {
            newBuilder.setPrimaryKeyId(getKeyId(jsonObject.get("primaryKeyId")));
        }
        JsonArray asJsonArray = jsonObject.getAsJsonArray("key");
        for (int i3 = 0; i3 < asJsonArray.size(); i3++) {
            newBuilder.addKey(keyFromJson(asJsonArray.get(i3).getAsJsonObject()));
        }
        return newBuilder.build();
    }

    private static KeysetInfo keysetInfoFromJson(JsonObject jsonObject) {
        KeysetInfo.Builder newBuilder = KeysetInfo.newBuilder();
        if (jsonObject.has("primaryKeyId")) {
            newBuilder.setPrimaryKeyId(getKeyId(jsonObject.get("primaryKeyId")));
        }
        if (jsonObject.has("keyInfo")) {
            JsonArray asJsonArray = jsonObject.getAsJsonArray("keyInfo");
            for (int i3 = 0; i3 < asJsonArray.size(); i3++) {
                newBuilder.addKeyInfo(keyInfoFromJson(asJsonArray.get(i3).getAsJsonObject()));
            }
        }
        return newBuilder.build();
    }

    private static void validateEncryptedKeyset(JsonObject jsonObject) {
        if (!jsonObject.has("encryptedKeyset")) {
            throw new JsonParseException("invalid encrypted keyset");
        }
    }

    private static void validateKey(JsonObject jsonObject) {
        if (!jsonObject.has("keyData") || !jsonObject.has("status") || !jsonObject.has("keyId") || !jsonObject.has("outputPrefixType")) {
            throw new JsonParseException("invalid key");
        }
    }

    private static void validateKeyData(JsonObject jsonObject) {
        if (!jsonObject.has("typeUrl") || !jsonObject.has("value") || !jsonObject.has("keyMaterialType")) {
            throw new JsonParseException("invalid keyData");
        }
    }

    private static void validateKeyset(JsonObject jsonObject) {
        if (!jsonObject.has("key") || jsonObject.getAsJsonArray("key").size() == 0) {
            throw new JsonParseException("invalid keyset");
        }
    }

    public static JsonKeysetReader withBytes(byte[] bArr) {
        return new JsonKeysetReader(new ByteArrayInputStream(bArr));
    }

    @Deprecated
    public static JsonKeysetReader withFile(File file) {
        return withInputStream(new FileInputStream(file));
    }

    public static JsonKeysetReader withInputStream(InputStream inputStream) {
        return new JsonKeysetReader(inputStream);
    }

    @Deprecated
    public static JsonKeysetReader withJsonObject(Object obj) {
        return withString(obj.toString());
    }

    @Deprecated
    public static JsonKeysetReader withPath(String str) {
        return withInputStream(new FileInputStream(new File(str)));
    }

    @Deprecated
    public static JsonKeysetReader withPath(Path path) {
        return withInputStream(new FileInputStream(path.toFile()));
    }

    public static JsonKeysetReader withString(String str) {
        return new JsonKeysetReader(new ByteArrayInputStream(str.getBytes(UTF_8)));
    }

    @Override // com.google.crypto.tink.KeysetReader
    public Keyset read() {
        try {
            try {
                return keysetFromJson(JsonParser.parse(new String(Util.readAll(this.inputStream), UTF_8)).getAsJsonObject());
            } finally {
                InputStream inputStream = this.inputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (JsonParseException | IllegalStateException e3) {
            throw new IOException(e3);
        }
    }

    @Override // com.google.crypto.tink.KeysetReader
    public EncryptedKeyset readEncrypted() {
        try {
            try {
                return encryptedKeysetFromJson(JsonParser.parse(new String(Util.readAll(this.inputStream), UTF_8)).getAsJsonObject());
            } finally {
                InputStream inputStream = this.inputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (JsonParseException | IllegalStateException e3) {
            throw new IOException(e3);
        }
    }

    public JsonKeysetReader withUrlSafeBase64() {
        this.urlSafeBase64 = true;
        return this;
    }
}
