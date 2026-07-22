package com.google.android.gms.auth.api;

@Deprecated
/* loaded from: /root/release/classes.dex */
public final class zbc {
    protected Boolean zba;
    protected String zbb;

    public zbc() {
        this.zba = Boolean.FALSE;
    }

    public zbc(zbd zbdVar) {
        boolean z3;
        String str;
        this.zba = Boolean.FALSE;
        zbd.zbb(zbdVar);
        z3 = zbdVar.zbc;
        this.zba = Boolean.valueOf(z3);
        str = zbdVar.zbd;
        this.zbb = str;
    }

    public final zbc zba(String str) {
        this.zbb = str;
        return this;
    }
}
