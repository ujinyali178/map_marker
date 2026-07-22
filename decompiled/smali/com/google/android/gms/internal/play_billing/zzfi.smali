.class public Lcom/google/android/gms/internal/play_billing/zzfi;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final zzb:Lcom/google/android/gms/internal/play_billing/zzej;


# instance fields
.field protected volatile zza:Lcom/google/android/gms/internal/play_billing/zzgc;

.field private volatile zzc:Lcom/google/android/gms/internal/play_billing/zzdw;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzej;->zza:Lcom/google/android/gms/internal/play_billing/zzej;

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzfi;->zzb:Lcom/google/android/gms/internal/play_billing/zzej;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 4

    if-ne p0, p1, :cond_4

    const/4 p1, 0x1

    return p1

    :cond_4
    instance-of v0, p1, Lcom/google/android/gms/internal/play_billing/zzfi;

    if-nez v0, :cond_a

    const/4 p1, 0x0

    return p1

    :cond_a
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzfi;

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zza:Lcom/google/android/gms/internal/play_billing/zzgc;

    iget-object v1, p1, Lcom/google/android/gms/internal/play_billing/zzfi;->zza:Lcom/google/android/gms/internal/play_billing/zzgc;

    if-nez v0, :cond_22

    if-eqz v1, :cond_15

    goto :goto_22

    :cond_15
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzfi;->zzb()Lcom/google/android/gms/internal/play_billing/zzdw;

    move-result-object v0

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzfi;->zzb()Lcom/google/android/gms/internal/play_billing/zzdw;

    move-result-object p1

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzdw;->equals(Ljava/lang/Object;)Z

    move-result p1

    return p1

    :cond_22
    :goto_22
    if-eqz v0, :cond_2c

    if-nez v1, :cond_27

    goto :goto_2c

    :cond_27
    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result p1

    return p1

    :cond_2c
    :goto_2c
    if-eqz v0, :cond_3c

    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzgd;->zzf()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/google/android/gms/internal/play_billing/zzfi;->zzc(Lcom/google/android/gms/internal/play_billing/zzgc;)V

    iget-object p1, p1, Lcom/google/android/gms/internal/play_billing/zzfi;->zza:Lcom/google/android/gms/internal/play_billing/zzgc;

    invoke-virtual {v0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result p1

    return p1

    :cond_3c
    invoke-interface {v1}, Lcom/google/android/gms/internal/play_billing/zzgd;->zzf()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfi;->zzc(Lcom/google/android/gms/internal/play_billing/zzgc;)V

    iget-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zza:Lcom/google/android/gms/internal/play_billing/zzgc;

    invoke-virtual {p1, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method public hashCode()I
    .registers 2

    const/4 v0, 0x1

    return v0
.end method

.method public final zza()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zzc:Lcom/google/android/gms/internal/play_billing/zzdw;

    if-eqz v0, :cond_c

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zzc:Lcom/google/android/gms/internal/play_billing/zzdw;

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzdt;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzdt;->zza:[B

    array-length v0, v0

    return v0

    :cond_c
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zza:Lcom/google/android/gms/internal/play_billing/zzgc;

    if-eqz v0, :cond_17

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zza:Lcom/google/android/gms/internal/play_billing/zzgc;

    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zze()I

    move-result v0

    return v0

    :cond_17
    const/4 v0, 0x0

    return v0
.end method

.method public final zzb()Lcom/google/android/gms/internal/play_billing/zzdw;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zzc:Lcom/google/android/gms/internal/play_billing/zzdw;

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zzc:Lcom/google/android/gms/internal/play_billing/zzdw;

    return-object v0

    :cond_7
    monitor-enter p0

    :try_start_8
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zzc:Lcom/google/android/gms/internal/play_billing/zzdw;

    if-eqz v0, :cond_10

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zzc:Lcom/google/android/gms/internal/play_billing/zzdw;

    monitor-exit p0

    return-object v0

    :cond_10
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zza:Lcom/google/android/gms/internal/play_billing/zzgc;

    if-nez v0, :cond_19

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzdw;->zzb:Lcom/google/android/gms/internal/play_billing/zzdw;

    :goto_16
    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zzc:Lcom/google/android/gms/internal/play_billing/zzdw;

    goto :goto_20

    :cond_19
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zza:Lcom/google/android/gms/internal/play_billing/zzgc;

    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzgc;->zzb()Lcom/google/android/gms/internal/play_billing/zzdw;

    move-result-object v0

    goto :goto_16

    :goto_20
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zzc:Lcom/google/android/gms/internal/play_billing/zzdw;

    monitor-exit p0

    return-object v0

    :catchall_24
    move-exception v0

    monitor-exit p0
    :try_end_26
    .catchall {:try_start_8 .. :try_end_26} :catchall_24

    throw v0
.end method

.method protected final zzc(Lcom/google/android/gms/internal/play_billing/zzgc;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zza:Lcom/google/android/gms/internal/play_billing/zzgc;

    if-eqz v0, :cond_5

    return-void

    :cond_5
    monitor-enter p0

    :try_start_6
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zza:Lcom/google/android/gms/internal/play_billing/zzgc;

    if-eqz v0, :cond_c

    monitor-exit p0
    :try_end_b
    .catchall {:try_start_6 .. :try_end_b} :catchall_1b

    return-void

    :cond_c
    :try_start_c
    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zza:Lcom/google/android/gms/internal/play_billing/zzgc;

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzdw;->zzb:Lcom/google/android/gms/internal/play_billing/zzdw;

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zzc:Lcom/google/android/gms/internal/play_billing/zzdw;
    :try_end_12
    .catch Lcom/google/android/gms/internal/play_billing/zzff; {:try_start_c .. :try_end_12} :catch_13
    .catchall {:try_start_c .. :try_end_12} :catchall_1b

    goto :goto_19

    :catch_13
    :try_start_13
    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zza:Lcom/google/android/gms/internal/play_billing/zzgc;

    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzdw;->zzb:Lcom/google/android/gms/internal/play_billing/zzdw;

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzfi;->zzc:Lcom/google/android/gms/internal/play_billing/zzdw;

    :goto_19
    monitor-exit p0

    return-void

    :catchall_1b
    move-exception p1

    monitor-exit p0
    :try_end_1d
    .catchall {:try_start_13 .. :try_end_1d} :catchall_1b

    throw p1
.end method
