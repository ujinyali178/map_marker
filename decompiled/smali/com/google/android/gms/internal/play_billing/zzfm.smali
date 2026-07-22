.class final Lcom/google/android/gms/internal/play_billing/zzfm;
.super Lcom/google/android/gms/internal/play_billing/zzfq;
.source "SourceFile"


# static fields
.field private static final zza:Ljava/lang/Class;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzfm;->zza:Ljava/lang/Class;

    return-void
.end method

.method private constructor <init>()V
    .registers 2

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/play_billing/zzfq;-><init>(Lcom/google/android/gms/internal/play_billing/zzfp;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/gms/internal/play_billing/zzfl;)V
    .registers 2

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzfq;-><init>(Lcom/google/android/gms/internal/play_billing/zzfp;)V

    return-void
.end method


# virtual methods
.method final zza(Ljava/lang/Object;J)V
    .registers 7

    invoke-static {p1, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    instance-of v1, v0, Lcom/google/android/gms/internal/play_billing/zzfk;

    if-eqz v1, :cond_11

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzfk;

    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzfk;->zze()Lcom/google/android/gms/internal/play_billing/zzfk;

    move-result-object v0

    goto :goto_36

    :cond_11
    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzfm;->zza:Ljava/lang/Class;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v1

    if-eqz v1, :cond_1e

    goto :goto_31

    :cond_1e
    instance-of v1, v0, Lcom/google/android/gms/internal/play_billing/zzgj;

    if-eqz v1, :cond_32

    instance-of v1, v0, Lcom/google/android/gms/internal/play_billing/zzfc;

    if-eqz v1, :cond_32

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzfc;

    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzfc;->zzc()Z

    move-result p1

    if-eqz p1, :cond_31

    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzfc;->zzb()V

    :cond_31
    :goto_31
    return-void

    :cond_32
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    :goto_36
    invoke-static {p1, p2, p3, v0}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzs(Ljava/lang/Object;JLjava/lang/Object;)V

    return-void
.end method

.method final zzb(Ljava/lang/Object;Ljava/lang/Object;J)V
    .registers 9

    invoke-static {p2, p3, p4}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Ljava/util/List;

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    invoke-static {p1, p3, p4}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_39

    instance-of v2, v1, Lcom/google/android/gms/internal/play_billing/zzfk;

    if-eqz v2, :cond_20

    new-instance v1, Lcom/google/android/gms/internal/play_billing/zzfj;

    invoke-direct {v1, v0}, Lcom/google/android/gms/internal/play_billing/zzfj;-><init>(I)V

    goto :goto_35

    :cond_20
    instance-of v2, v1, Lcom/google/android/gms/internal/play_billing/zzgj;

    if-eqz v2, :cond_30

    instance-of v2, v1, Lcom/google/android/gms/internal/play_billing/zzfc;

    if-eqz v2, :cond_30

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzfc;

    invoke-interface {v1, v0}, Lcom/google/android/gms/internal/play_billing/zzfc;->zzd(I)Lcom/google/android/gms/internal/play_billing/zzfc;

    move-result-object v0

    move-object v1, v0

    goto :goto_35

    :cond_30
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(I)V

    :goto_35
    invoke-static {p1, p3, p4, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzs(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_8a

    :cond_39
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzfm;->zza:Ljava/lang/Class;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v2

    if-eqz v2, :cond_57

    new-instance v2, Ljava/util/ArrayList;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    add-int/2addr v3, v0

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(I)V

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    :goto_52
    invoke-static {p1, p3, p4, v2}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzs(Ljava/lang/Object;JLjava/lang/Object;)V

    move-object v1, v2

    goto :goto_8a

    :cond_57
    instance-of v2, v1, Lcom/google/android/gms/internal/play_billing/zzhi;

    if-eqz v2, :cond_6f

    new-instance v2, Lcom/google/android/gms/internal/play_billing/zzfj;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    add-int/2addr v3, v0

    invoke-direct {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzfj;-><init>(I)V

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzhi;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/play_billing/zzfj;->size()I

    move-result v0

    invoke-virtual {v2, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzdh;->addAll(ILjava/util/Collection;)Z

    goto :goto_52

    :cond_6f
    instance-of v2, v1, Lcom/google/android/gms/internal/play_billing/zzgj;

    if-eqz v2, :cond_8a

    instance-of v2, v1, Lcom/google/android/gms/internal/play_billing/zzfc;

    if-eqz v2, :cond_8a

    move-object v2, v1

    check-cast v2, Lcom/google/android/gms/internal/play_billing/zzfc;

    invoke-interface {v2}, Lcom/google/android/gms/internal/play_billing/zzfc;->zzc()Z

    move-result v3

    if-nez v3, :cond_8a

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v1, v0

    invoke-interface {v2, v1}, Lcom/google/android/gms/internal/play_billing/zzfc;->zzd(I)Lcom/google/android/gms/internal/play_billing/zzfc;

    move-result-object v1

    goto :goto_35

    :cond_8a
    :goto_8a
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v2

    if-lez v0, :cond_99

    if-lez v2, :cond_99

    invoke-interface {v1, p2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    :cond_99
    if-gtz v0, :cond_9c

    goto :goto_9d

    :cond_9c
    move-object p2, v1

    :goto_9d
    invoke-static {p1, p3, p4, p2}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzs(Ljava/lang/Object;JLjava/lang/Object;)V

    return-void
.end method
