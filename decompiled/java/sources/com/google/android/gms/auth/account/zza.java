package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.Parcel;

/* loaded from: /root/release/classes.dex */
public abstract class zza extends com.google.android.gms.internal.auth.zzb implements zzb {
    public zza() {
        super("com.google.android.gms.auth.account.IWorkAccountCallback");
    }

    @Override // com.google.android.gms.internal.auth.zzb
    protected final boolean zza(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 != 1) {
            if (i3 != 2) {
                return false;
            }
            int i5 = com.google.android.gms.internal.auth.zzc.zza;
            int readInt = parcel.readInt();
            com.google.android.gms.internal.auth.zzc.zzb(parcel);
            zzc(readInt != 0);
        } else {
            Account account = (Account) com.google.android.gms.internal.auth.zzc.zza(parcel, Account.CREATOR);
            com.google.android.gms.internal.auth.zzc.zzb(parcel);
            zzb(account);
        }
        return true;
    }
}
