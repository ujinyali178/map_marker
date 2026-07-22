package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.proto.JwtEcdsaAlgorithm;
import com.google.crypto.tink.proto.JwtEcdsaPublicKey;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey;
import com.google.crypto.tink.proto.JwtRsaSsaPssAlgorithm;
import com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Base64;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Optional;
import javax.annotation.Nullable;

/* loaded from: /root/release/classes.dex */
public final class JwkSetConverter {
    private static final String JWT_ECDSA_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey";
    private static final String JWT_RSA_SSA_PKCS1_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PublicKey";
    private static final String JWT_RSA_SSA_PSS_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPublicKey";

    /* renamed from: com.google.crypto.tink.jwt.JwkSetConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm;

        static {
            int[] iArr = new int[JwtRsaSsaPssAlgorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm = iArr;
            try {
                iArr[JwtRsaSsaPssAlgorithm.PS256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[JwtRsaSsaPssAlgorithm.PS384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[JwtRsaSsaPssAlgorithm.PS512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[JwtRsaSsaPkcs1Algorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm = iArr2;
            try {
                iArr2[JwtRsaSsaPkcs1Algorithm.RS256.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[JwtRsaSsaPkcs1Algorithm.RS384.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[JwtRsaSsaPkcs1Algorithm.RS512.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[JwtEcdsaAlgorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm = iArr3;
            try {
                iArr3[JwtEcdsaAlgorithm.ES256.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES384.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES512.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private JwkSetConverter() {
    }

    private static JsonObject convertJwtEcdsaKey(ProtoKeySerialization protoKeySerialization) {
        String str;
        String str2;
        String value;
        try {
            JwtEcdsaPublicKey parseFrom = JwtEcdsaPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[parseFrom.getAlgorithm().ordinal()];
            if (i3 == 1) {
                str = "ES256";
                str2 = "P-256";
            } else if (i3 == 2) {
                str = "ES384";
                str2 = "P-384";
            } else {
                if (i3 != 3) {
                    throw new GeneralSecurityException("unknown algorithm");
                }
                str = "ES512";
                str2 = "P-521";
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("kty", "EC");
            jsonObject.addProperty("crv", str2);
            jsonObject.addProperty("x", Base64.urlSafeEncode(parseFrom.getX().toByteArray()));
            jsonObject.addProperty("y", Base64.urlSafeEncode(parseFrom.getY().toByteArray()));
            jsonObject.addProperty("use", "sig");
            jsonObject.addProperty("alg", str);
            JsonArray jsonArray = new JsonArray();
            jsonArray.add("verify");
            jsonObject.add("key_ops", jsonArray);
            Optional<String> kid = getKid(protoKeySerialization.getIdRequirementOrNull());
            if (!kid.isPresent()) {
                if (parseFrom.hasCustomKid()) {
                    value = parseFrom.getCustomKid().getValue();
                }
                return jsonObject;
            }
            value = kid.get();
            jsonObject.addProperty("kid", value);
            return jsonObject;
        } catch (InvalidProtocolBufferException e3) {
            throw new GeneralSecurityException("failed to parse value as JwtEcdsaPublicKey proto", e3);
        }
    }

    private static JsonObject convertJwtRsaSsaPkcs1(ProtoKeySerialization protoKeySerialization) {
        String str;
        String value;
        try {
            JwtRsaSsaPkcs1PublicKey parseFrom = JwtRsaSsaPkcs1PublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[parseFrom.getAlgorithm().ordinal()];
            if (i3 == 1) {
                str = "RS256";
            } else if (i3 == 2) {
                str = "RS384";
            } else {
                if (i3 != 3) {
                    throw new GeneralSecurityException("unknown algorithm");
                }
                str = "RS512";
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("kty", "RSA");
            jsonObject.addProperty("n", Base64.urlSafeEncode(parseFrom.getN().toByteArray()));
            jsonObject.addProperty("e", Base64.urlSafeEncode(parseFrom.getE().toByteArray()));
            jsonObject.addProperty("use", "sig");
            jsonObject.addProperty("alg", str);
            JsonArray jsonArray = new JsonArray();
            jsonArray.add("verify");
            jsonObject.add("key_ops", jsonArray);
            Optional<String> kid = getKid(protoKeySerialization.getIdRequirementOrNull());
            if (!kid.isPresent()) {
                if (parseFrom.hasCustomKid()) {
                    value = parseFrom.getCustomKid().getValue();
                }
                return jsonObject;
            }
            value = kid.get();
            jsonObject.addProperty("kid", value);
            return jsonObject;
        } catch (InvalidProtocolBufferException e3) {
            throw new GeneralSecurityException("failed to parse value as JwtRsaSsaPkcs1PublicKey proto", e3);
        }
    }

    private static JsonObject convertJwtRsaSsaPss(ProtoKeySerialization protoKeySerialization) {
        String str;
        String value;
        try {
            JwtRsaSsaPssPublicKey parseFrom = JwtRsaSsaPssPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[parseFrom.getAlgorithm().ordinal()];
            if (i3 == 1) {
                str = "PS256";
            } else if (i3 == 2) {
                str = "PS384";
            } else {
                if (i3 != 3) {
                    throw new GeneralSecurityException("unknown algorithm");
                }
                str = "PS512";
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("kty", "RSA");
            jsonObject.addProperty("n", Base64.urlSafeEncode(parseFrom.getN().toByteArray()));
            jsonObject.addProperty("e", Base64.urlSafeEncode(parseFrom.getE().toByteArray()));
            jsonObject.addProperty("use", "sig");
            jsonObject.addProperty("alg", str);
            JsonArray jsonArray = new JsonArray();
            jsonArray.add("verify");
            jsonObject.add("key_ops", jsonArray);
            Optional<String> kid = getKid(protoKeySerialization.getIdRequirementOrNull());
            if (!kid.isPresent()) {
                if (parseFrom.hasCustomKid()) {
                    value = parseFrom.getCustomKid().getValue();
                }
                return jsonObject;
            }
            value = kid.get();
            jsonObject.addProperty("kid", value);
            return jsonObject;
        } catch (InvalidProtocolBufferException e3) {
            throw new GeneralSecurityException("failed to parse value as JwtRsaSsaPssPublicKey proto", e3);
        }
    }

    private static ProtoKeySerialization convertToEcdsaKey(JsonObject jsonObject) {
        JwtEcdsaAlgorithm jwtEcdsaAlgorithm;
        String stringItem = getStringItem(jsonObject, "alg");
        stringItem.hashCode();
        switch (stringItem) {
            case "ES256":
                expectStringItem(jsonObject, "crv", "P-256");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES256;
                break;
            case "ES384":
                expectStringItem(jsonObject, "crv", "P-384");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES384;
                break;
            case "ES512":
                expectStringItem(jsonObject, "crv", "P-521");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Ecdsa Algorithm: " + getStringItem(jsonObject, "alg"));
        }
        if (jsonObject.has("d")) {
            throw new UnsupportedOperationException("importing ECDSA private keys is not implemented");
        }
        expectStringItem(jsonObject, "kty", "EC");
        validateUseIsSig(jsonObject);
        validateKeyOpsIsVerify(jsonObject);
        JwtEcdsaPublicKey.Builder y3 = JwtEcdsaPublicKey.newBuilder().setVersion(0).setAlgorithm(jwtEcdsaAlgorithm).setX(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonObject, "x")))).setY(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonObject, "y"))));
        if (jsonObject.has("kid")) {
            y3.setCustomKid(JwtEcdsaPublicKey.CustomKid.newBuilder().setValue(getStringItem(jsonObject, "kid")).build());
        }
        return ProtoKeySerialization.create(JWT_ECDSA_PUBLIC_KEY_URL, y3.build().toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, null);
    }

    private static ProtoKeySerialization convertToRsaSsaPkcs1Key(JsonObject jsonObject) {
        JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm;
        String stringItem = getStringItem(jsonObject, "alg");
        stringItem.hashCode();
        switch (stringItem) {
            case "RS256":
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS256;
                break;
            case "RS384":
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS384;
                break;
            case "RS512":
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(jsonObject, "alg"));
        }
        if (jsonObject.has("p") || jsonObject.has("q") || jsonObject.has("dp") || jsonObject.has("dq") || jsonObject.has("d") || jsonObject.has("qi")) {
            throw new UnsupportedOperationException("importing RSA private keys is not implemented");
        }
        expectStringItem(jsonObject, "kty", "RSA");
        validateUseIsSig(jsonObject);
        validateKeyOpsIsVerify(jsonObject);
        JwtRsaSsaPkcs1PublicKey.Builder n3 = JwtRsaSsaPkcs1PublicKey.newBuilder().setVersion(0).setAlgorithm(jwtRsaSsaPkcs1Algorithm).setE(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonObject, "e")))).setN(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonObject, "n"))));
        if (jsonObject.has("kid")) {
            n3.setCustomKid(JwtRsaSsaPkcs1PublicKey.CustomKid.newBuilder().setValue(getStringItem(jsonObject, "kid")).build());
        }
        return ProtoKeySerialization.create(JWT_RSA_SSA_PKCS1_PUBLIC_KEY_URL, n3.build().toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, null);
    }

    private static ProtoKeySerialization convertToRsaSsaPssKey(JsonObject jsonObject) {
        JwtRsaSsaPssAlgorithm jwtRsaSsaPssAlgorithm;
        String stringItem = getStringItem(jsonObject, "alg");
        stringItem.hashCode();
        switch (stringItem) {
            case "PS256":
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS256;
                break;
            case "PS384":
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS384;
                break;
            case "PS512":
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(jsonObject, "alg"));
        }
        if (jsonObject.has("p") || jsonObject.has("q") || jsonObject.has("dq") || jsonObject.has("dq") || jsonObject.has("d") || jsonObject.has("qi")) {
            throw new UnsupportedOperationException("importing RSA private keys is not implemented");
        }
        expectStringItem(jsonObject, "kty", "RSA");
        validateUseIsSig(jsonObject);
        validateKeyOpsIsVerify(jsonObject);
        JwtRsaSsaPssPublicKey.Builder n3 = JwtRsaSsaPssPublicKey.newBuilder().setVersion(0).setAlgorithm(jwtRsaSsaPssAlgorithm).setE(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonObject, "e")))).setN(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jsonObject, "n"))));
        if (jsonObject.has("kid")) {
            n3.setCustomKid(JwtRsaSsaPssPublicKey.CustomKid.newBuilder().setValue(getStringItem(jsonObject, "kid")).build());
        }
        return ProtoKeySerialization.create(JWT_RSA_SSA_PSS_PUBLIC_KEY_URL, n3.build().toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, null);
    }

    private static void expectStringItem(JsonObject jsonObject, String str, String str2) {
        String stringItem = getStringItem(jsonObject, str);
        if (stringItem.equals(str2)) {
            return;
        }
        throw new GeneralSecurityException("unexpected " + str + " value: " + stringItem);
    }

    @Deprecated
    public static String fromKeysetHandle(KeysetHandle keysetHandle, KeyAccess keyAccess) {
        return fromPublicKeysetHandle(keysetHandle);
    }

    public static String fromPublicKeysetHandle(KeysetHandle keysetHandle) {
        JsonObject convertJwtEcdsaKey;
        JsonArray jsonArray = new JsonArray();
        for (int i3 = 0; i3 < keysetHandle.size(); i3++) {
            KeysetHandle.Entry at = keysetHandle.getAt(i3);
            if (at.getStatus() == KeyStatus.ENABLED) {
                Key key = at.getKey();
                if (!(key instanceof LegacyProtoKey)) {
                    throw new GeneralSecurityException("only LegacyProtoKey is currently supported");
                }
                ProtoKeySerialization serialization = ((LegacyProtoKey) key).getSerialization(null);
                if (serialization.getOutputPrefixType() != OutputPrefixType.RAW && serialization.getOutputPrefixType() != OutputPrefixType.TINK) {
                    throw new GeneralSecurityException("only OutputPrefixType RAW and TINK are supported");
                }
                if (serialization.getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC) {
                    throw new GeneralSecurityException("only public keys can be converted");
                }
                String typeUrl = serialization.getTypeUrl();
                typeUrl.hashCode();
                switch (typeUrl) {
                    case "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey":
                        convertJwtEcdsaKey = convertJwtEcdsaKey(serialization);
                        break;
                    case "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PublicKey":
                        convertJwtEcdsaKey = convertJwtRsaSsaPkcs1(serialization);
                        break;
                    case "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPublicKey":
                        convertJwtEcdsaKey = convertJwtRsaSsaPss(serialization);
                        break;
                    default:
                        throw new GeneralSecurityException(String.format("key type %s is not supported", serialization.getTypeUrl()));
                }
                jsonArray.add(convertJwtEcdsaKey);
            }
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("keys", jsonArray);
        return jsonObject.toString();
    }

    private static Optional<String> getKid(@Nullable Integer num) {
        return num == null ? Optional.empty() : Optional.of(Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(num.intValue()).array()));
    }

    private static String getStringItem(JsonObject jsonObject, String str) {
        if (!jsonObject.has(str)) {
            throw new GeneralSecurityException(str + " not found");
        }
        if (jsonObject.get(str).isJsonPrimitive() && jsonObject.get(str).getAsJsonPrimitive().isString()) {
            return jsonObject.get(str).getAsString();
        }
        throw new GeneralSecurityException(str + " is not a string");
    }

    @Deprecated
    public static KeysetHandle toKeysetHandle(String str, KeyAccess keyAccess) {
        return toPublicKeysetHandle(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
    
        if (r4.equals("RS") == false) goto L8;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.crypto.tink.KeysetHandle toPublicKeysetHandle(java.lang.String r8) {
        /*
            com.google.gson.stream.JsonReader r0 = new com.google.gson.stream.JsonReader     // Catch: java.lang.StackOverflowError -> Lc8 com.google.gson.JsonParseException -> Lca java.lang.IllegalStateException -> Lcc
            java.io.StringReader r1 = new java.io.StringReader     // Catch: java.lang.StackOverflowError -> Lc8 com.google.gson.JsonParseException -> Lca java.lang.IllegalStateException -> Lcc
            r1.<init>(r8)     // Catch: java.lang.StackOverflowError -> Lc8 com.google.gson.JsonParseException -> Lca java.lang.IllegalStateException -> Lcc
            r0.<init>(r1)     // Catch: java.lang.StackOverflowError -> Lc8 com.google.gson.JsonParseException -> Lca java.lang.IllegalStateException -> Lcc
            r8 = 0
            r0.setLenient(r8)     // Catch: java.lang.StackOverflowError -> Lc8 com.google.gson.JsonParseException -> Lca java.lang.IllegalStateException -> Lcc
            com.google.gson.JsonElement r0 = com.google.gson.internal.Streams.parse(r0)     // Catch: java.lang.StackOverflowError -> Lc8 com.google.gson.JsonParseException -> Lca java.lang.IllegalStateException -> Lcc
            com.google.gson.JsonObject r0 = r0.getAsJsonObject()     // Catch: java.lang.StackOverflowError -> Lc8 com.google.gson.JsonParseException -> Lca java.lang.IllegalStateException -> Lcc
            com.google.crypto.tink.KeysetHandle$Builder r1 = com.google.crypto.tink.KeysetHandle.newBuilder()
            java.lang.String r2 = "keys"
            com.google.gson.JsonElement r0 = r0.get(r2)
            com.google.gson.JsonArray r0 = r0.getAsJsonArray()
            java.util.Iterator r0 = r0.iterator()
        L28:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto Lae
            java.lang.Object r2 = r0.next()
            com.google.gson.JsonElement r2 = (com.google.gson.JsonElement) r2
            com.google.gson.JsonObject r2 = r2.getAsJsonObject()
            java.lang.String r3 = "alg"
            java.lang.String r4 = getStringItem(r2, r3)
            r5 = 2
            java.lang.String r4 = r4.substring(r8, r5)
            r4.hashCode()
            r6 = -1
            int r7 = r4.hashCode()
            switch(r7) {
                case 2222: goto L65;
                case 2563: goto L59;
                case 2625: goto L50;
                default: goto L4e;
            }
        L4e:
            r5 = -1
            goto L6f
        L50:
            java.lang.String r7 = "RS"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L6f
            goto L4e
        L59:
            java.lang.String r5 = "PS"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L62
            goto L4e
        L62:
            r5 = 1
            r5 = 1
            goto L6f
        L65:
            java.lang.String r5 = "ES"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L6e
            goto L4e
        L6e:
            r5 = 0
        L6f:
            switch(r5) {
                case 0: goto L97;
                case 1: goto L92;
                case 2: goto L8d;
                default: goto L72;
            }
        L72:
            java.security.GeneralSecurityException r8 = new java.security.GeneralSecurityException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "unexpected alg value: "
            r0.append(r1)
            java.lang.String r1 = getStringItem(r2, r3)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L8d:
            com.google.crypto.tink.internal.ProtoKeySerialization r2 = convertToRsaSsaPkcs1Key(r2)
            goto L9b
        L92:
            com.google.crypto.tink.internal.ProtoKeySerialization r2 = convertToRsaSsaPssKey(r2)
            goto L9b
        L97:
            com.google.crypto.tink.internal.ProtoKeySerialization r2 = convertToEcdsaKey(r2)
        L9b:
            com.google.crypto.tink.internal.LegacyProtoKey r3 = new com.google.crypto.tink.internal.LegacyProtoKey
            r4 = 0
            r3.<init>(r2, r4)
            com.google.crypto.tink.KeysetHandle$Builder$Entry r2 = com.google.crypto.tink.KeysetHandle.importKey(r3)
            com.google.crypto.tink.KeysetHandle$Builder$Entry r2 = r2.withRandomId()
            r1.addEntry(r2)
            goto L28
        Lae:
            int r0 = r1.size()
            if (r0 <= 0) goto Lc0
            com.google.crypto.tink.KeysetHandle$Builder$Entry r8 = r1.getAt(r8)
            r8.makePrimary()
            com.google.crypto.tink.KeysetHandle r8 = r1.build()
            return r8
        Lc0:
            java.security.GeneralSecurityException r8 = new java.security.GeneralSecurityException
            java.lang.String r0 = "empty keyset"
            r8.<init>(r0)
            throw r8
        Lc8:
            r8 = move-exception
            goto Lcd
        Lca:
            r8 = move-exception
            goto Lcd
        Lcc:
            r8 = move-exception
        Lcd:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.String r1 = "JWK set is invalid JSON"
            r0.<init>(r1, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.jwt.JwkSetConverter.toPublicKeysetHandle(java.lang.String):com.google.crypto.tink.KeysetHandle");
    }

    private static void validateKeyOpsIsVerify(JsonObject jsonObject) {
        if (jsonObject.has("key_ops")) {
            if (!jsonObject.get("key_ops").isJsonArray()) {
                throw new GeneralSecurityException("key_ops is not an array");
            }
            JsonArray asJsonArray = jsonObject.get("key_ops").getAsJsonArray();
            if (asJsonArray.size() != 1) {
                throw new GeneralSecurityException("key_ops must contain exactly one element");
            }
            if (!asJsonArray.get(0).isJsonPrimitive() || !asJsonArray.get(0).getAsJsonPrimitive().isString()) {
                throw new GeneralSecurityException("key_ops is not a string");
            }
            if (asJsonArray.get(0).getAsString().equals("verify")) {
                return;
            }
            throw new GeneralSecurityException("unexpected keyOps value: " + asJsonArray.get(0).getAsString());
        }
    }

    private static void validateUseIsSig(JsonObject jsonObject) {
        if (jsonObject.has("use")) {
            expectStringItem(jsonObject, "use", "sig");
        }
    }
}
