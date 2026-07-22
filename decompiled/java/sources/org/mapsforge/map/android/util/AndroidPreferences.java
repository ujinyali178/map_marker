package org.mapsforge.map.android.util;

import android.content.SharedPreferences;
import org.mapsforge.map.model.common.PreferencesFacade;

/* loaded from: /root/release/classes2.dex */
public class AndroidPreferences implements PreferencesFacade {
    private SharedPreferences.Editor editor;
    private final SharedPreferences sharedPreferences;

    public AndroidPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    private void createEditor() {
        if (this.editor == null) {
            this.editor = this.sharedPreferences.edit();
        }
    }

    @Override // org.mapsforge.map.model.common.PreferencesFacade
    public synchronized void clear() {
        createEditor();
        this.editor.clear();
    }

    @Override // org.mapsforge.map.model.common.PreferencesFacade
    public synchronized boolean getBoolean(String str, boolean z3) {
        return this.sharedPreferences.getBoolean(str, z3);
    }

    @Override // org.mapsforge.map.model.common.PreferencesFacade
    public synchronized byte getByte(String str, byte b4) {
        int i3;
        i3 = this.sharedPreferences.getInt(str, b4);
        if (i3 < -128 || i3 > 127) {
            throw new IllegalStateException("byte value out of range: " + i3);
        }
        return (byte) i3;
    }

    @Override // org.mapsforge.map.model.common.PreferencesFacade
    public synchronized double getDouble(String str, double d3) {
        return Double.longBitsToDouble(this.sharedPreferences.getLong(str, Double.doubleToLongBits(d3)));
    }

    @Override // org.mapsforge.map.model.common.PreferencesFacade
    public synchronized float getFloat(String str, float f3) {
        return this.sharedPreferences.getFloat(str, f3);
    }

    @Override // org.mapsforge.map.model.common.PreferencesFacade
    public synchronized int getInt(String str, int i3) {
        return this.sharedPreferences.getInt(str, i3);
    }

    @Override // org.mapsforge.map.model.common.PreferencesFacade
    public synchronized long getLong(String str, long j3) {
        return this.sharedPreferences.getLong(str, j3);
    }

    @Override // org.mapsforge.map.model.common.PreferencesFacade
    public synchronized String getString(String str, String str2) {
        return this.sharedPreferences.getString(str, str2);
    }

    @Override // org.mapsforge.map.model.common.PreferencesFacade
    public synchronized void putBoolean(String str, boolean z3) {
        createEditor();
        this.editor.putBoolean(str, z3);
    }

    @Override // org.mapsforge.map.model.common.PreferencesFacade
    public synchronized void putByte(String str, byte b4) {
        createEditor();
        this.editor.putInt(str, b4);
    }

    @Override // org.mapsforge.map.model.common.PreferencesFacade
    public synchronized void putDouble(String str, double d3) {
        createEditor();
        this.editor.putLong(str, Double.doubleToLongBits(d3));
    }

    @Override // org.mapsforge.map.model.common.PreferencesFacade
    public synchronized void putFloat(String str, float f3) {
        createEditor();
        this.editor.putFloat(str, f3);
    }

    @Override // org.mapsforge.map.model.common.PreferencesFacade
    public synchronized void putInt(String str, int i3) {
        createEditor();
        this.editor.putInt(str, i3);
    }

    @Override // org.mapsforge.map.model.common.PreferencesFacade
    public synchronized void putLong(String str, long j3) {
        createEditor();
        this.editor.putLong(str, j3);
    }

    @Override // org.mapsforge.map.model.common.PreferencesFacade
    public synchronized void putString(String str, String str2) {
        createEditor();
        this.editor.putString(str, str2);
    }

    @Override // org.mapsforge.map.model.common.PreferencesFacade
    public synchronized void save() {
        SharedPreferences.Editor editor = this.editor;
        if (editor != null) {
            editor.apply();
            this.editor = null;
        }
    }
}
