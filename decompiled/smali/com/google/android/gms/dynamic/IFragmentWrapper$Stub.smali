.class public abstract Lcom/google/android/gms/dynamic/IFragmentWrapper$Stub;
.super Lcom/google/android/gms/internal/common/zzb;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/dynamic/IFragmentWrapper;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/dynamic/IFragmentWrapper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 2

    const-string v0, "com.google.android.gms.dynamic.IFragmentWrapper"

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/common/zzb;-><init>(Ljava/lang/String;)V

    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/IFragmentWrapper;
    .registers 3

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    const-string v0, "com.google.android.gms.dynamic.IFragmentWrapper"

    invoke-interface {p0, v0}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    instance-of v1, v0, Lcom/google/android/gms/dynamic/IFragmentWrapper;

    if-eqz v1, :cond_11

    check-cast v0, Lcom/google/android/gms/dynamic/IFragmentWrapper;

    return-object v0

    :cond_11
    new-instance v0, Lcom/google/android/gms/dynamic/zza;

    invoke-direct {v0, p0}, Lcom/google/android/gms/dynamic/zza;-><init>(Landroid/os/IBinder;)V

    return-object v0
.end method


# virtual methods
.method protected final zza(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 5

    packed-switch p1, :pswitch_data_ee

    const/4 p1, 0x0

    return p1

    :pswitch_5
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object p1

    invoke-static {p1}, Lcom/google/android/gms/dynamic/IObjectWrapper$Stub;->asInterface(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/IObjectWrapper;

    move-result-object p1

    invoke-static {p2}, Lcom/google/android/gms/internal/common/zzc;->zzb(Landroid/os/Parcel;)V

    invoke-interface {p0, p1}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzr(Lcom/google/android/gms/dynamic/IObjectWrapper;)V

    goto :goto_70

    :pswitch_14
    sget-object p1, Landroid/content/Intent;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/common/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Landroid/content/Intent;

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result p4

    invoke-static {p2}, Lcom/google/android/gms/internal/common/zzc;->zzb(Landroid/os/Parcel;)V

    invoke-interface {p0, p1, p4}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzq(Landroid/content/Intent;I)V

    goto :goto_70

    :pswitch_27
    sget-object p1, Landroid/content/Intent;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/common/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Landroid/content/Intent;

    invoke-static {p2}, Lcom/google/android/gms/internal/common/zzc;->zzb(Landroid/os/Parcel;)V

    invoke-interface {p0, p1}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzp(Landroid/content/Intent;)V

    goto :goto_70

    :pswitch_36
    invoke-static {p2}, Lcom/google/android/gms/internal/common/zzc;->zzf(Landroid/os/Parcel;)Z

    move-result p1

    invoke-static {p2}, Lcom/google/android/gms/internal/common/zzc;->zzb(Landroid/os/Parcel;)V

    invoke-interface {p0, p1}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzo(Z)V

    goto :goto_70

    :pswitch_41
    invoke-static {p2}, Lcom/google/android/gms/internal/common/zzc;->zzf(Landroid/os/Parcel;)Z

    move-result p1

    invoke-static {p2}, Lcom/google/android/gms/internal/common/zzc;->zzb(Landroid/os/Parcel;)V

    invoke-interface {p0, p1}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzn(Z)V

    goto :goto_70

    :pswitch_4c
    invoke-static {p2}, Lcom/google/android/gms/internal/common/zzc;->zzf(Landroid/os/Parcel;)Z

    move-result p1

    invoke-static {p2}, Lcom/google/android/gms/internal/common/zzc;->zzb(Landroid/os/Parcel;)V

    invoke-interface {p0, p1}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzm(Z)V

    goto :goto_70

    :pswitch_57
    invoke-static {p2}, Lcom/google/android/gms/internal/common/zzc;->zzf(Landroid/os/Parcel;)Z

    move-result p1

    invoke-static {p2}, Lcom/google/android/gms/internal/common/zzc;->zzb(Landroid/os/Parcel;)V

    invoke-interface {p0, p1}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzl(Z)V

    goto :goto_70

    :pswitch_62
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object p1

    invoke-static {p1}, Lcom/google/android/gms/dynamic/IObjectWrapper$Stub;->asInterface(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/IObjectWrapper;

    move-result-object p1

    invoke-static {p2}, Lcom/google/android/gms/internal/common/zzc;->zzb(Landroid/os/Parcel;)V

    invoke-interface {p0, p1}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzk(Lcom/google/android/gms/dynamic/IObjectWrapper;)V

    :goto_70
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_eb

    :pswitch_75
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzA()Z

    move-result p1

    goto :goto_bb

    :pswitch_7a
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzz()Z

    move-result p1

    goto :goto_bb

    :pswitch_7f
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzy()Z

    move-result p1

    goto :goto_bb

    :pswitch_84
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzx()Z

    move-result p1

    goto :goto_bb

    :pswitch_89
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzw()Z

    move-result p1

    goto :goto_bb

    :pswitch_8e
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzv()Z

    move-result p1

    goto :goto_bb

    :pswitch_93
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzu()Z

    move-result p1

    goto :goto_bb

    :pswitch_98
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzi()Lcom/google/android/gms/dynamic/IObjectWrapper;

    move-result-object p1

    goto :goto_e5

    :pswitch_9d
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzt()Z

    move-result p1

    goto :goto_bb

    :pswitch_a2
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzc()I

    move-result p1

    goto :goto_cf

    :pswitch_a7
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzf()Lcom/google/android/gms/dynamic/IFragmentWrapper;

    move-result-object p1

    goto :goto_e5

    :pswitch_ac
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzj()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    invoke-virtual {p3, p1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_eb

    :pswitch_b7
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzs()Z

    move-result p1

    :goto_bb
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    sget p2, Lcom/google/android/gms/internal/common/zzc;->zza:I

    goto :goto_d2

    :pswitch_c1
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzh()Lcom/google/android/gms/dynamic/IObjectWrapper;

    move-result-object p1

    goto :goto_e5

    :pswitch_c6
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zze()Lcom/google/android/gms/dynamic/IFragmentWrapper;

    move-result-object p1

    goto :goto_e5

    :pswitch_cb
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzb()I

    move-result p1

    :goto_cf
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    :goto_d2
    invoke-virtual {p3, p1}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_eb

    :pswitch_d6
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzd()Landroid/os/Bundle;

    move-result-object p1

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    invoke-static {p3, p1}, Lcom/google/android/gms/internal/common/zzc;->zzd(Landroid/os/Parcel;Landroid/os/Parcelable;)V

    goto :goto_eb

    :pswitch_e1
    invoke-interface {p0}, Lcom/google/android/gms/dynamic/IFragmentWrapper;->zzg()Lcom/google/android/gms/dynamic/IObjectWrapper;

    move-result-object p1

    :goto_e5
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    invoke-static {p3, p1}, Lcom/google/android/gms/internal/common/zzc;->zze(Landroid/os/Parcel;Landroid/os/IInterface;)V

    :goto_eb
    const/4 p1, 0x1

    return p1

    nop

    :pswitch_data_ee
    .packed-switch 0x2
        :pswitch_e1
        :pswitch_d6
        :pswitch_cb
        :pswitch_c6
        :pswitch_c1
        :pswitch_b7
        :pswitch_ac
        :pswitch_a7
        :pswitch_a2
        :pswitch_9d
        :pswitch_98
        :pswitch_93
        :pswitch_8e
        :pswitch_89
        :pswitch_84
        :pswitch_7f
        :pswitch_7a
        :pswitch_75
        :pswitch_62
        :pswitch_57
        :pswitch_4c
        :pswitch_41
        :pswitch_36
        :pswitch_27
        :pswitch_14
        :pswitch_5
    .end packed-switch
.end method
