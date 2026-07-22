package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* loaded from: /root/release/classes.dex */
public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor {
    private AbstractWindowedCursor zza;

    public CursorWrapper(Cursor cursor) {
        super(cursor);
        for (int i3 = 0; i3 < 10 && (cursor instanceof android.database.CursorWrapper); i3++) {
            cursor = ((android.database.CursorWrapper) cursor).getWrappedCursor();
        }
        if (!(cursor instanceof AbstractWindowedCursor)) {
            throw new IllegalArgumentException("Unknown type: ".concat(cursor.getClass().getName()));
        }
        this.zza = (AbstractWindowedCursor) cursor;
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int i3, CursorWindow cursorWindow) {
        this.zza.fillWindow(i3, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    @ResultIgnorabilityUnspecified
    public CursorWindow getWindow() {
        return this.zza.getWindow();
    }

    @Override // android.database.CursorWrapper
    public final /* synthetic */ Cursor getWrappedCursor() {
        return this.zza;
    }

    @Override // android.database.CrossProcessCursor
    @ResultIgnorabilityUnspecified
    public final boolean onMove(int i3, int i4) {
        return this.zza.onMove(i3, i4);
    }

    public void setWindow(CursorWindow cursorWindow) {
        this.zza.setWindow(cursorWindow);
    }
}
