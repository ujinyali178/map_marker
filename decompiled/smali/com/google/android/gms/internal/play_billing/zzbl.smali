.class public final Lcom/google/android/gms/internal/play_billing/zzbl;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final zza:Lcom/google/android/gms/internal/play_billing/zzbp;

.field private static final zzb:Lcom/google/android/gms/internal/play_billing/zzbo;


# instance fields
.field private final zzc:Ljava/util/Map;

.field private final zzd:Ljava/util/Map;

.field private final zze:Lcom/google/android/gms/internal/play_billing/zzbp;

.field private zzf:Lcom/google/android/gms/internal/play_billing/zzbo;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzbi;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzbi;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzbl;->zza:Lcom/google/android/gms/internal/play_billing/zzbp;

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzbj;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzbj;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzbl;->zzb:Lcom/google/android/gms/internal/play_billing/zzbo;

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/gms/internal/play_billing/zzbp;Lcom/google/android/gms/internal/play_billing/zzbk;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance p2, Ljava/util/HashMap;

    invoke-direct {p2}, Ljava/util/HashMap;-><init>()V

    iput-object p2, p0, Lcom/google/android/gms/internal/play_billing/zzbl;->zzc:Ljava/util/Map;

    new-instance p2, Ljava/util/HashMap;

    invoke-direct {p2}, Ljava/util/HashMap;-><init>()V

    iput-object p2, p0, Lcom/google/android/gms/internal/play_billing/zzbl;->zzd:Ljava/util/Map;

    const/4 p2, 0x0

    iput-object p2, p0, Lcom/google/android/gms/internal/play_billing/zzbl;->zzf:Lcom/google/android/gms/internal/play_billing/zzbo;

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzbl;->zze:Lcom/google/android/gms/internal/play_billing/zzbp;

    return-void
.end method

.method static bridge synthetic zzb(Lcom/google/android/gms/internal/play_billing/zzbl;)Lcom/google/android/gms/internal/play_billing/zzbo;
    .registers 1

    iget-object p0, p0, Lcom/google/android/gms/internal/play_billing/zzbl;->zzf:Lcom/google/android/gms/internal/play_billing/zzbo;

    return-object p0
.end method

.method static bridge synthetic zzc(Lcom/google/android/gms/internal/play_billing/zzbl;)Lcom/google/android/gms/internal/play_billing/zzbp;
    .registers 1

    iget-object p0, p0, Lcom/google/android/gms/internal/play_billing/zzbl;->zze:Lcom/google/android/gms/internal/play_billing/zzbp;

    return-object p0
.end method

.method static bridge synthetic zze(Lcom/google/android/gms/internal/play_billing/zzbl;)Ljava/util/Map;
    .registers 1

    iget-object p0, p0, Lcom/google/android/gms/internal/play_billing/zzbl;->zzd:Ljava/util/Map;

    return-object p0
.end method

.method static bridge synthetic zzf(Lcom/google/android/gms/internal/play_billing/zzbl;)Ljava/util/Map;
    .registers 1

    iget-object p0, p0, Lcom/google/android/gms/internal/play_billing/zzbl;->zzc:Ljava/util/Map;

    return-object p0
.end method


# virtual methods
.method public final zza(Lcom/google/android/gms/internal/play_billing/zzbo;)Lcom/google/android/gms/internal/play_billing/zzbl;
    .registers 2

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzbl;->zzf:Lcom/google/android/gms/internal/play_billing/zzbo;

    return-object p0
.end method

.method public final zzd()Lcom/google/android/gms/internal/play_billing/zzbq;
    .registers 3

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzbn;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/google/android/gms/internal/play_billing/zzbn;-><init>(Lcom/google/android/gms/internal/play_billing/zzbl;Lcom/google/android/gms/internal/play_billing/zzbm;)V

    return-object v0
.end method

.method final zzg(Lcom/google/android/gms/internal/play_billing/zzba;)V
    .registers 4

    const-string v0, "key"

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzda;->zza(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzba;->zzb()Z

    move-result v1

    if-eqz v1, :cond_29

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzbl;->zzb:Lcom/google/android/gms/internal/play_billing/zzbo;

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzda;->zza(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzba;->zzb()Z

    move-result v0

    if-eqz v0, :cond_21

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzbl;->zzc:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzbl;->zzd:Ljava/util/Map;

    :goto_1d
    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void

    :cond_21
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "key must be repeating"

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_29
    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzbl;->zza:Lcom/google/android/gms/internal/play_billing/zzbp;

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzda;->zza(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzbl;->zzd:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzbl;->zzc:Ljava/util/Map;

    goto :goto_1d
.end method
