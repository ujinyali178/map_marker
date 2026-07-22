.class public final Lcom/google/android/gms/internal/play_billing/zzhi;
.super Ljava/util/AbstractList;
.source "SourceFile"

# interfaces
.implements Ljava/util/RandomAccess;
.implements Lcom/google/android/gms/internal/play_billing/zzfk;


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# instance fields
.field private final zza:Lcom/google/android/gms/internal/play_billing/zzfk;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/play_billing/zzfk;)V
    .registers 2

    invoke-direct {p0}, Ljava/util/AbstractList;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzhi;->zza:Lcom/google/android/gms/internal/play_billing/zzfk;

    return-void
.end method

.method static bridge synthetic zza(Lcom/google/android/gms/internal/play_billing/zzhi;)Lcom/google/android/gms/internal/play_billing/zzfk;
    .registers 1

    iget-object p0, p0, Lcom/google/android/gms/internal/play_billing/zzhi;->zza:Lcom/google/android/gms/internal/play_billing/zzfk;

    return-object p0
.end method


# virtual methods
.method public final bridge synthetic get(I)Ljava/lang/Object;
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhi;->zza:Lcom/google/android/gms/internal/play_billing/zzfk;

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzfj;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzfj;->zzg(I)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method public final iterator()Ljava/util/Iterator;
    .registers 2

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzhh;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/play_billing/zzhh;-><init>(Lcom/google/android/gms/internal/play_billing/zzhi;)V

    return-object v0
.end method

.method public final listIterator(I)Ljava/util/ListIterator;
    .registers 3

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzhg;

    invoke-direct {v0, p0, p1}, Lcom/google/android/gms/internal/play_billing/zzhg;-><init>(Lcom/google/android/gms/internal/play_billing/zzhi;I)V

    return-object v0
.end method

.method public final size()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhi;->zza:Lcom/google/android/gms/internal/play_billing/zzfk;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public final zze()Lcom/google/android/gms/internal/play_billing/zzfk;
    .registers 1

    return-object p0
.end method

.method public final zzf(I)Ljava/lang/Object;
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhi;->zza:Lcom/google/android/gms/internal/play_billing/zzfk;

    invoke-interface {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzfk;->zzf(I)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public final zzh()Ljava/util/List;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzhi;->zza:Lcom/google/android/gms/internal/play_billing/zzfk;

    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzfk;->zzh()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
