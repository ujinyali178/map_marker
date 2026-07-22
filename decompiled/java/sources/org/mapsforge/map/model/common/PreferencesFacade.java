package org.mapsforge.map.model.common;

/* loaded from: /root/release/classes2.dex */
public interface PreferencesFacade {
    void clear();

    boolean getBoolean(String str, boolean z3);

    byte getByte(String str, byte b4);

    double getDouble(String str, double d3);

    float getFloat(String str, float f3);

    int getInt(String str, int i3);

    long getLong(String str, long j3);

    String getString(String str, String str2);

    void putBoolean(String str, boolean z3);

    void putByte(String str, byte b4);

    void putDouble(String str, double d3);

    void putFloat(String str, float f3);

    void putInt(String str, int i3);

    void putLong(String str, long j3);

    void putString(String str, String str2);

    void save();
}
