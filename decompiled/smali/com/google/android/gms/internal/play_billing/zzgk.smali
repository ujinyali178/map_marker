.class final Lcom/google/android/gms/internal/play_billing/zzgk;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final zza:Lcom/google/android/gms/internal/play_billing/zzgk;


# instance fields
.field private final zzb:Lcom/google/android/gms/internal/play_billing/zzgn;

.field private final zzc:Ljava/util/concurrent/ConcurrentMap;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgk;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzgk;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzgk;->zza:Lcom/google/android/gms/internal/play_billing/zzgk;

    return-void
.end method

.method private constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgk;->zzc:Ljava/util/concurrent/ConcurrentMap;

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzfu;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzfu;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgk;->zzb:Lcom/google/android/gms/internal/play_billing/zzgn;

    return-void
.end method

.method public static zza()Lcom/google/android/gms/internal/play_billing/zzgk;
    .registers 1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzgk;->zza:Lcom/google/android/gms/internal/play_billing/zzgk;

    return-object v0
.end method


# virtual methods
.method public final zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzgm;
    .registers 4

    const-string v0, "messageType"

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzfd;->zzc(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    iget-object v1, p0, Lcom/google/android/gms/internal/play_billing/zzgk;->zzc:Ljava/util/concurrent/ConcurrentMap;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzgm;

    if-nez v1, :cond_24

    iget-object v1, p0, Lcom/google/android/gms/internal/play_billing/zzgk;->zzb:Lcom/google/android/gms/internal/play_billing/zzgn;

    invoke-interface {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzgn;->zza(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v1

    invoke-static {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzfd;->zzc(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgk;->zzc:Ljava/util/concurrent/ConcurrentMap;

    invoke-interface {v0, p1, v1}, Ljava/util/concurrent/ConcurrentMap;->putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzgm;

    if-nez p1, :cond_23

    goto :goto_24

    :cond_23
    return-object p1

    :cond_24
    :goto_24
    return-object v1
.end method
