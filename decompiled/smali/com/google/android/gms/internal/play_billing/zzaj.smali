.class public abstract Lcom/google/android/gms/internal/play_billing/zzaj;
.super Lcom/google/android/gms/internal/play_billing/zzac;
.source "SourceFile"

# interfaces
.implements Ljava/util/Set;


# instance fields
.field private transient zza:Lcom/google/android/gms/internal/play_billing/zzaf;
    .annotation runtime Ljavax/annotation/CheckForNull;
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzac;-><init>()V

    return-void
.end method


# virtual methods
.method public final equals(Ljava/lang/Object;)Z
    .registers 6
    .param p1    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/CheckForNull;
        .end annotation
    .end param

    const/4 v0, 0x1

    if-ne p1, p0, :cond_4

    return v0

    :cond_4
    const/4 v1, 0x0

    if-ne p1, p0, :cond_8

    goto :goto_21

    :cond_8
    instance-of v2, p1, Ljava/util/Set;

    if-eqz v2, :cond_20

    check-cast p1, Ljava/util/Set;

    :try_start_e
    invoke-interface {p0}, Ljava/util/Set;->size()I

    move-result v2

    invoke-interface {p1}, Ljava/util/Set;->size()I

    move-result v3

    if-ne v2, v3, :cond_20

    invoke-interface {p0, p1}, Ljava/util/Set;->containsAll(Ljava/util/Collection;)Z

    move-result p1
    :try_end_1c
    .catch Ljava/lang/NullPointerException; {:try_start_e .. :try_end_1c} :catch_20
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_1c} :catch_20

    if-nez p1, :cond_1f

    goto :goto_20

    :cond_1f
    return v0

    :catch_20
    :cond_20
    :goto_20
    const/4 v0, 0x0

    :goto_21
    return v0
.end method

.method public final hashCode()I
    .registers 2

    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzar;->zza(Ljava/util/Set;)I

    move-result v0

    return v0
.end method

.method public bridge synthetic iterator()Ljava/util/Iterator;
    .registers 2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzaj;->zze()Lcom/google/android/gms/internal/play_billing/zzas;

    move-result-object v0

    return-object v0
.end method

.method public zzd()Lcom/google/android/gms/internal/play_billing/zzaf;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzaj;->zza:Lcom/google/android/gms/internal/play_billing/zzaf;

    if-nez v0, :cond_a

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzaj;->zzh()Lcom/google/android/gms/internal/play_billing/zzaf;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzaj;->zza:Lcom/google/android/gms/internal/play_billing/zzaf;

    :cond_a
    return-object v0
.end method

.method public abstract zze()Lcom/google/android/gms/internal/play_billing/zzas;
.end method

.method zzh()Lcom/google/android/gms/internal/play_billing/zzaf;
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzac;->toArray()[Ljava/lang/Object;

    move-result-object v0

    sget v1, Lcom/google/android/gms/internal/play_billing/zzaf;->zzd:I

    array-length v1, v0

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzaf;->zzi([Ljava/lang/Object;I)Lcom/google/android/gms/internal/play_billing/zzaf;

    move-result-object v0

    return-object v0
.end method
