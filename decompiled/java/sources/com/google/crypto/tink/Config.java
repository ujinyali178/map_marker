package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyTypeEntry;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
public final class Config {
    private Config() {
    }

    public static KeyTypeEntry getTinkKeyTypeEntry(String str, String str2, String str3, int i3, boolean z3) {
        return KeyTypeEntry.newBuilder().setPrimitiveName(str2).setTypeUrl("type.googleapis.com/google.crypto.tink." + str3).setKeyManagerVersion(i3).setNewKeyAllowed(z3).setCatalogueName(str).build();
    }

    public static void register(RegistryConfig registryConfig) {
        Iterator<KeyTypeEntry> it = registryConfig.getEntryList().iterator();
        while (it.hasNext()) {
            registerKeyType(it.next());
        }
    }

    public static void registerKeyType(KeyTypeEntry keyTypeEntry) {
        validate(keyTypeEntry);
        if (keyTypeEntry.getCatalogueName().equals("TinkAead") || keyTypeEntry.getCatalogueName().equals("TinkMac") || keyTypeEntry.getCatalogueName().equals("TinkHybridDecrypt") || keyTypeEntry.getCatalogueName().equals("TinkHybridEncrypt") || keyTypeEntry.getCatalogueName().equals("TinkPublicKeySign") || keyTypeEntry.getCatalogueName().equals("TinkPublicKeyVerify") || keyTypeEntry.getCatalogueName().equals("TinkStreamingAead") || keyTypeEntry.getCatalogueName().equals("TinkDeterministicAead")) {
            return;
        }
        Catalogue<?> catalogue = Registry.getCatalogue(keyTypeEntry.getCatalogueName());
        Registry.registerPrimitiveWrapper(catalogue.getPrimitiveWrapper());
        Registry.registerKeyManager(catalogue.getKeyManager(keyTypeEntry.getTypeUrl(), keyTypeEntry.getPrimitiveName(), keyTypeEntry.getKeyManagerVersion()), keyTypeEntry.getNewKeyAllowed());
    }

    private static void validate(KeyTypeEntry keyTypeEntry) {
        if (keyTypeEntry.getTypeUrl().isEmpty()) {
            throw new GeneralSecurityException("Missing type_url.");
        }
        if (keyTypeEntry.getPrimitiveName().isEmpty()) {
            throw new GeneralSecurityException("Missing primitive_name.");
        }
        if (keyTypeEntry.getCatalogueName().isEmpty()) {
            throw new GeneralSecurityException("Missing catalogue_name.");
        }
    }
}
