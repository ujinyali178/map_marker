package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.BinaryKeysetReader;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.KeysetManager;
import com.google.crypto.tink.KeysetWriter;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Hex;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;

/* loaded from: /root/release/classes.dex */
public final class AndroidKeysetManager {
    private static final String TAG = "AndroidKeysetManager";
    private static final Object lock = new Object();
    private KeysetManager keysetManager;
    private final Aead masterAead;
    private final KeysetWriter writer;

    /* renamed from: com.google.crypto.tink.integration.android.AndroidKeysetManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        static {
            int[] iArr = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = iArr;
            try {
                iArr[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static final class Builder {
        private KeysetManager keysetManager;
        private Context context = null;
        private String keysetName = null;
        private String prefFileName = null;
        private String masterKeyUri = null;
        private Aead masterAead = null;
        private boolean useKeystore = true;
        private KeyTemplate keyTemplate = null;

        private KeysetManager generateKeysetAndWriteToPrefs() {
            if (this.keyTemplate == null) {
                throw new GeneralSecurityException("cannot read or generate keyset");
            }
            KeysetManager add = KeysetManager.withEmptyKeyset().add(this.keyTemplate);
            KeysetManager primary = add.setPrimary(add.getKeysetHandle().getKeysetInfo().getKeyInfo(0).getKeyId());
            SharedPrefKeysetWriter sharedPrefKeysetWriter = new SharedPrefKeysetWriter(this.context, this.keysetName, this.prefFileName);
            if (this.masterAead != null) {
                primary.getKeysetHandle().write(sharedPrefKeysetWriter, this.masterAead);
            } else {
                CleartextKeysetHandle.write(primary.getKeysetHandle(), sharedPrefKeysetWriter);
            }
            return primary;
        }

        private static byte[] readKeysetFromPrefs(Context context, String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
            Context applicationContext = context.getApplicationContext();
            try {
                String string = (str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext) : applicationContext.getSharedPreferences(str2, 0)).getString(str, null);
                if (string == null) {
                    return null;
                }
                return Hex.decode(string);
            } catch (ClassCastException | IllegalArgumentException unused) {
                throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", str));
            }
        }

        private KeysetManager readKeysetInCleartext(byte[] bArr) {
            return KeysetManager.withKeysetHandle(CleartextKeysetHandle.read(BinaryKeysetReader.withBytes(bArr)));
        }

        private KeysetManager readMasterkeyDecryptAndParseKeyset(byte[] bArr) {
            try {
                this.masterAead = new AndroidKeystoreKmsClient().getAead(this.masterKeyUri);
                try {
                    return KeysetManager.withKeysetHandle(KeysetHandle.read(BinaryKeysetReader.withBytes(bArr), this.masterAead));
                } catch (IOException | GeneralSecurityException e3) {
                    try {
                        return readKeysetInCleartext(bArr);
                    } catch (IOException unused) {
                        throw e3;
                    }
                }
            } catch (GeneralSecurityException | ProviderException e4) {
                try {
                    KeysetManager readKeysetInCleartext = readKeysetInCleartext(bArr);
                    Log.w(AndroidKeysetManager.TAG, "cannot use Android Keystore, it'll be disabled", e4);
                    return readKeysetInCleartext;
                } catch (IOException unused2) {
                    throw e4;
                }
            }
        }

        private Aead readOrGenerateNewMasterKey() {
            if (!AndroidKeysetManager.isAtLeastM()) {
                Log.w(AndroidKeysetManager.TAG, "Android Keystore requires at least Android M");
                return null;
            }
            AndroidKeystoreKmsClient androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
            try {
                boolean generateKeyIfNotExist = AndroidKeystoreKmsClient.generateKeyIfNotExist(this.masterKeyUri);
                try {
                    return androidKeystoreKmsClient.getAead(this.masterKeyUri);
                } catch (GeneralSecurityException | ProviderException e3) {
                    if (!generateKeyIfNotExist) {
                        throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.masterKeyUri), e3);
                    }
                    Log.w(AndroidKeysetManager.TAG, "cannot use Android Keystore, it'll be disabled", e3);
                    return null;
                }
            } catch (GeneralSecurityException | ProviderException e4) {
                Log.w(AndroidKeysetManager.TAG, "cannot use Android Keystore, it'll be disabled", e4);
                return null;
            }
        }

        public synchronized AndroidKeysetManager build() {
            KeysetManager readKeysetInCleartext;
            AndroidKeysetManager androidKeysetManager;
            if (this.keysetName == null) {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
            synchronized (AndroidKeysetManager.lock) {
                byte[] readKeysetFromPrefs = readKeysetFromPrefs(this.context, this.keysetName, this.prefFileName);
                if (readKeysetFromPrefs == null) {
                    if (this.masterKeyUri != null) {
                        this.masterAead = readOrGenerateNewMasterKey();
                    }
                    readKeysetInCleartext = generateKeysetAndWriteToPrefs();
                } else {
                    if (this.masterKeyUri != null && AndroidKeysetManager.isAtLeastM()) {
                        readKeysetInCleartext = readMasterkeyDecryptAndParseKeyset(readKeysetFromPrefs);
                    }
                    readKeysetInCleartext = readKeysetInCleartext(readKeysetFromPrefs);
                }
                this.keysetManager = readKeysetInCleartext;
                androidKeysetManager = new AndroidKeysetManager(this, null);
            }
            return androidKeysetManager;
        }

        @Deprecated
        public Builder doNotUseKeystore() {
            this.masterKeyUri = null;
            this.useKeystore = false;
            return this;
        }

        public Builder withKeyTemplate(KeyTemplate keyTemplate) {
            this.keyTemplate = keyTemplate;
            return this;
        }

        @Deprecated
        public Builder withKeyTemplate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
            this.keyTemplate = KeyTemplate.create(keyTemplate.getTypeUrl(), keyTemplate.getValue().toByteArray(), AndroidKeysetManager.fromProto(keyTemplate.getOutputPrefixType()));
            return this;
        }

        public Builder withMasterKeyUri(String str) {
            if (!str.startsWith(AndroidKeystoreKmsClient.PREFIX)) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            }
            if (!this.useKeystore) {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
            this.masterKeyUri = str;
            return this;
        }

        public Builder withSharedPref(Context context, String str, String str2) {
            if (context == null) {
                throw new IllegalArgumentException("need an Android context");
            }
            if (str == null) {
                throw new IllegalArgumentException("need a keyset name");
            }
            this.context = context;
            this.keysetName = str;
            this.prefFileName = str2;
            return this;
        }
    }

    private AndroidKeysetManager(Builder builder) {
        this.writer = new SharedPrefKeysetWriter(builder.context, builder.keysetName, builder.prefFileName);
        this.masterAead = builder.masterAead;
        this.keysetManager = builder.keysetManager;
    }

    /* synthetic */ AndroidKeysetManager(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTemplate.OutputPrefixType fromProto(OutputPrefixType outputPrefixType) {
        int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i3 == 1) {
            return KeyTemplate.OutputPrefixType.TINK;
        }
        if (i3 == 2) {
            return KeyTemplate.OutputPrefixType.LEGACY;
        }
        if (i3 == 3) {
            return KeyTemplate.OutputPrefixType.RAW;
        }
        if (i3 == 4) {
            return KeyTemplate.OutputPrefixType.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAtLeastM() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private boolean shouldUseKeystore() {
        return this.masterAead != null && isAtLeastM();
    }

    private void write(KeysetManager keysetManager) {
        try {
            if (shouldUseKeystore()) {
                keysetManager.getKeysetHandle().write(this.writer, this.masterAead);
            } else {
                CleartextKeysetHandle.write(keysetManager.getKeysetHandle(), this.writer);
            }
        } catch (IOException e3) {
            throw new GeneralSecurityException(e3);
        }
    }

    public synchronized AndroidKeysetManager add(KeyTemplate keyTemplate) {
        KeysetManager add = this.keysetManager.add(keyTemplate);
        this.keysetManager = add;
        write(add);
        return this;
    }

    @Deprecated
    public synchronized AndroidKeysetManager add(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
        KeysetManager add = this.keysetManager.add(keyTemplate);
        this.keysetManager = add;
        write(add);
        return this;
    }

    public synchronized AndroidKeysetManager delete(int i3) {
        KeysetManager delete = this.keysetManager.delete(i3);
        this.keysetManager = delete;
        write(delete);
        return this;
    }

    public synchronized AndroidKeysetManager destroy(int i3) {
        KeysetManager destroy = this.keysetManager.destroy(i3);
        this.keysetManager = destroy;
        write(destroy);
        return this;
    }

    public synchronized AndroidKeysetManager disable(int i3) {
        KeysetManager disable = this.keysetManager.disable(i3);
        this.keysetManager = disable;
        write(disable);
        return this;
    }

    public synchronized AndroidKeysetManager enable(int i3) {
        KeysetManager enable = this.keysetManager.enable(i3);
        this.keysetManager = enable;
        write(enable);
        return this;
    }

    public synchronized KeysetHandle getKeysetHandle() {
        return this.keysetManager.getKeysetHandle();
    }

    public synchronized boolean isUsingKeystore() {
        return shouldUseKeystore();
    }

    @Deprecated
    public synchronized AndroidKeysetManager promote(int i3) {
        return setPrimary(i3);
    }

    @Deprecated
    public synchronized AndroidKeysetManager rotate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
        KeysetManager rotate = this.keysetManager.rotate(keyTemplate);
        this.keysetManager = rotate;
        write(rotate);
        return this;
    }

    public synchronized AndroidKeysetManager setPrimary(int i3) {
        KeysetManager primary = this.keysetManager.setPrimary(i3);
        this.keysetManager = primary;
        write(primary);
        return this;
    }
}
