package androidx.security.crypto;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTemplates;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.crypto.tink.integration.android.AndroidKeysetManager;
import com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient;
import com.google.crypto.tink.subtle.Base64;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /root/release/classes.dex */
public final class a implements SharedPreferences {

    /* renamed from: a, reason: collision with root package name */
    final SharedPreferences f1449a;

    /* renamed from: b, reason: collision with root package name */
    final CopyOnWriteArrayList<SharedPreferences.OnSharedPreferenceChangeListener> f1450b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    final String f1451c;

    /* renamed from: d, reason: collision with root package name */
    final String f1452d;

    /* renamed from: e, reason: collision with root package name */
    final Aead f1453e;

    /* renamed from: f, reason: collision with root package name */
    final DeterministicAead f1454f;

    /* renamed from: androidx.security.crypto.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0035a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1455a;

        static {
            int[] iArr = new int[c.values().length];
            f1455a = iArr;
            try {
                iArr[c.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1455a[c.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1455a[c.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1455a[c.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1455a[c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1455a[c.STRING_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static final class b implements SharedPreferences.Editor {

        /* renamed from: a, reason: collision with root package name */
        private final a f1456a;

        /* renamed from: b, reason: collision with root package name */
        private final SharedPreferences.Editor f1457b;

        /* renamed from: d, reason: collision with root package name */
        private final AtomicBoolean f1459d = new AtomicBoolean(false);

        /* renamed from: c, reason: collision with root package name */
        private final List<String> f1458c = new CopyOnWriteArrayList();

        b(a aVar, SharedPreferences.Editor editor) {
            this.f1456a = aVar;
            this.f1457b = editor;
        }

        private void a() {
            if (this.f1459d.getAndSet(false)) {
                for (String str : this.f1456a.getAll().keySet()) {
                    if (!this.f1458c.contains(str) && !this.f1456a.g(str)) {
                        this.f1457b.remove(this.f1456a.d(str));
                    }
                }
            }
        }

        private void b() {
            Iterator<SharedPreferences.OnSharedPreferenceChangeListener> it = this.f1456a.f1450b.iterator();
            while (it.hasNext()) {
                SharedPreferences.OnSharedPreferenceChangeListener next = it.next();
                Iterator<String> it2 = this.f1458c.iterator();
                while (it2.hasNext()) {
                    next.onSharedPreferenceChanged(this.f1456a, it2.next());
                }
            }
        }

        private void c(String str, byte[] bArr) {
            if (this.f1456a.g(str)) {
                throw new SecurityException(str + " is a reserved key for the encryption keyset.");
            }
            this.f1458c.add(str);
            if (str == null) {
                str = "__NULL__";
            }
            try {
                Pair<String, String> e3 = this.f1456a.e(str, bArr);
                this.f1457b.putString((String) e3.first, (String) e3.second);
            } catch (GeneralSecurityException e4) {
                throw new SecurityException("Could not encrypt data: " + e4.getMessage(), e4);
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            a();
            this.f1457b.apply();
            b();
            this.f1458c.clear();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f1459d.set(true);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            a();
            try {
                return this.f1457b.commit();
            } finally {
                b();
                this.f1458c.clear();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z3) {
            ByteBuffer allocate = ByteBuffer.allocate(5);
            allocate.putInt(c.BOOLEAN.c());
            allocate.put(z3 ? (byte) 1 : (byte) 0);
            c(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f3) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(c.FLOAT.c());
            allocate.putFloat(f3);
            c(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i3) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(c.INT.c());
            allocate.putInt(i3);
            c(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j3) {
            ByteBuffer allocate = ByteBuffer.allocate(12);
            allocate.putInt(c.LONG.c());
            allocate.putLong(j3);
            c(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            if (str2 == null) {
                str2 = "__NULL__";
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            ByteBuffer allocate = ByteBuffer.allocate(length + 8);
            allocate.putInt(c.STRING.c());
            allocate.putInt(length);
            allocate.put(bytes);
            c(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            if (set == null) {
                set = new androidx.collection.b<>();
                set.add("__NULL__");
            }
            ArrayList<byte[]> arrayList = new ArrayList(set.size());
            int size = set.size() * 4;
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                byte[] bytes = it.next().getBytes(StandardCharsets.UTF_8);
                arrayList.add(bytes);
                size += bytes.length;
            }
            ByteBuffer allocate = ByteBuffer.allocate(size + 4);
            allocate.putInt(c.STRING_SET.c());
            for (byte[] bArr : arrayList) {
                allocate.putInt(bArr.length);
                allocate.put(bArr);
            }
            c(str, allocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            if (!this.f1456a.g(str)) {
                this.f1457b.remove(this.f1456a.d(str));
                this.f1458c.add(str);
                return this;
            }
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
    }

    private enum c {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);


        /* renamed from: c, reason: collision with root package name */
        private final int f1467c;

        c(int i3) {
            this.f1467c = i3;
        }

        public static c b(int i3) {
            if (i3 == 0) {
                return STRING;
            }
            if (i3 == 1) {
                return STRING_SET;
            }
            if (i3 == 2) {
                return INT;
            }
            if (i3 == 3) {
                return LONG;
            }
            if (i3 == 4) {
                return FLOAT;
            }
            if (i3 != 5) {
                return null;
            }
            return BOOLEAN;
        }

        public int c() {
            return this.f1467c;
        }
    }

    public enum d {
        AES256_SIV("AES256_SIV");


        /* renamed from: c, reason: collision with root package name */
        private final String f1470c;

        d(String str) {
            this.f1470c = str;
        }

        KeyTemplate b() {
            return KeyTemplates.get(this.f1470c);
        }
    }

    public enum e {
        AES256_GCM("AES256_GCM");


        /* renamed from: c, reason: collision with root package name */
        private final String f1473c;

        e(String str) {
            this.f1473c = str;
        }

        KeyTemplate b() {
            return KeyTemplates.get(this.f1473c);
        }
    }

    a(String str, String str2, SharedPreferences sharedPreferences, Aead aead, DeterministicAead deterministicAead) {
        this.f1451c = str;
        this.f1449a = sharedPreferences;
        this.f1452d = str2;
        this.f1453e = aead;
        this.f1454f = deterministicAead;
    }

    public static SharedPreferences a(Context context, String str, androidx.security.crypto.c cVar, d dVar, e eVar) {
        return b(str, cVar.a(), context, dVar, eVar);
    }

    @Deprecated
    public static SharedPreferences b(String str, String str2, Context context, d dVar, e eVar) {
        DeterministicAeadConfig.register();
        AeadConfig.register();
        Context applicationContext = context.getApplicationContext();
        KeysetHandle keysetHandle = new AndroidKeysetManager.Builder().withKeyTemplate(dVar.b()).withSharedPref(applicationContext, "__androidx_security_crypto_encrypted_prefs_key_keyset__", str).withMasterKeyUri(AndroidKeystoreKmsClient.PREFIX + str2).build().getKeysetHandle();
        KeysetHandle keysetHandle2 = new AndroidKeysetManager.Builder().withKeyTemplate(eVar.b()).withSharedPref(applicationContext, "__androidx_security_crypto_encrypted_prefs_value_keyset__", str).withMasterKeyUri(AndroidKeystoreKmsClient.PREFIX + str2).build().getKeysetHandle();
        return new a(str, str2, applicationContext.getSharedPreferences(str, 0), (Aead) keysetHandle2.getPrimitive(Aead.class), (DeterministicAead) keysetHandle.getPrimitive(DeterministicAead.class));
    }

    private Object f(String str) {
        if (g(str)) {
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
        if (str == null) {
            str = "__NULL__";
        }
        try {
            String d3 = d(str);
            String string = this.f1449a.getString(d3, null);
            if (string == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(this.f1453e.decrypt(Base64.decode(string, 0), d3.getBytes(StandardCharsets.UTF_8)));
            wrap.position(0);
            int i3 = wrap.getInt();
            c b4 = c.b(i3);
            if (b4 == null) {
                throw new SecurityException("Unknown type ID for encrypted pref value: " + i3);
            }
            switch (C0035a.f1455a[b4.ordinal()]) {
                case 1:
                    int i4 = wrap.getInt();
                    ByteBuffer slice = wrap.slice();
                    wrap.limit(i4);
                    String charBuffer = StandardCharsets.UTF_8.decode(slice).toString();
                    if (charBuffer.equals("__NULL__")) {
                        return null;
                    }
                    return charBuffer;
                case 2:
                    return Integer.valueOf(wrap.getInt());
                case 3:
                    return Long.valueOf(wrap.getLong());
                case 4:
                    return Float.valueOf(wrap.getFloat());
                case 5:
                    return Boolean.valueOf(wrap.get() != 0);
                case 6:
                    androidx.collection.b bVar = new androidx.collection.b();
                    while (wrap.hasRemaining()) {
                        int i5 = wrap.getInt();
                        ByteBuffer slice2 = wrap.slice();
                        slice2.limit(i5);
                        wrap.position(wrap.position() + i5);
                        bVar.add(StandardCharsets.UTF_8.decode(slice2).toString());
                    }
                    if (bVar.size() == 1 && "__NULL__".equals(bVar.h(0))) {
                        return null;
                    }
                    return bVar;
                default:
                    throw new SecurityException("Unhandled type for encrypted pref value: " + b4);
            }
        } catch (GeneralSecurityException e3) {
            throw new SecurityException("Could not decrypt value. " + e3.getMessage(), e3);
        }
    }

    String c(String str) {
        try {
            String str2 = new String(this.f1454f.decryptDeterministically(Base64.decode(str, 0), this.f1451c.getBytes()), StandardCharsets.UTF_8);
            if (str2.equals("__NULL__")) {
                return null;
            }
            return str2;
        } catch (GeneralSecurityException e3) {
            throw new SecurityException("Could not decrypt key. " + e3.getMessage(), e3);
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (!g(str)) {
            return this.f1449a.contains(d(str));
        }
        throw new SecurityException(str + " is a reserved key for the encryption keyset.");
    }

    String d(String str) {
        if (str == null) {
            str = "__NULL__";
        }
        try {
            return Base64.encode(this.f1454f.encryptDeterministically(str.getBytes(StandardCharsets.UTF_8), this.f1451c.getBytes()));
        } catch (GeneralSecurityException e3) {
            throw new SecurityException("Could not encrypt key. " + e3.getMessage(), e3);
        }
    }

    Pair<String, String> e(String str, byte[] bArr) {
        String d3 = d(str);
        return new Pair<>(d3, Base64.encode(this.f1453e.encrypt(bArr, d3.getBytes(StandardCharsets.UTF_8))));
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new b(this, this.f1449a.edit());
    }

    boolean g(String str) {
        return "__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(str) || "__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(str);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : this.f1449a.getAll().entrySet()) {
            if (!g(entry.getKey())) {
                String c3 = c(entry.getKey());
                hashMap.put(c3, f(c3));
            }
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z3) {
        Object f3 = f(str);
        return f3 instanceof Boolean ? ((Boolean) f3).booleanValue() : z3;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f3) {
        Object f4 = f(str);
        return f4 instanceof Float ? ((Float) f4).floatValue() : f3;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i3) {
        Object f3 = f(str);
        return f3 instanceof Integer ? ((Integer) f3).intValue() : i3;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j3) {
        Object f3 = f(str);
        return f3 instanceof Long ? ((Long) f3).longValue() : j3;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object f3 = f(str);
        return f3 instanceof String ? (String) f3 : str2;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Object f3 = f(str);
        Set<String> bVar = f3 instanceof Set ? (Set) f3 : new androidx.collection.b<>();
        return bVar.size() > 0 ? bVar : set;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f1450b.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f1450b.remove(onSharedPreferenceChangeListener);
    }
}
