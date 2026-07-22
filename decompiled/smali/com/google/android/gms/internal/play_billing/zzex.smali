.class public abstract Lcom/google/android/gms/internal/play_billing/zzex;
.super Lcom/google/android/gms/internal/play_billing/zzdg;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<MessageType:",
        "Lcom/google/android/gms/internal/play_billing/zzex<",
        "TMessageType;TBuilderType;>;BuilderType:",
        "Lcom/google/android/gms/internal/play_billing/zzet<",
        "TMessageType;TBuilderType;>;>",
        "Lcom/google/android/gms/internal/play_billing/zzdg<",
        "TMessageType;TBuilderType;>;"
    }
.end annotation


# static fields
.field private static final zzb:Ljava/util/Map;


# instance fields
.field protected zzc:Lcom/google/android/gms/internal/play_billing/zzhe;

.field private zzd:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzex;->zzb:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzdg;-><init>()V

    const/4 v0, -0x1

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzex;->zzd:I

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhe;->zzc()Lcom/google/android/gms/internal/play_billing/zzhe;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzex;->zzc:Lcom/google/android/gms/internal/play_billing/zzhe;

    return-void
.end method

.method static zzh(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzex;
    .registers 5

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzex;->zzb:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzex;

    if-nez v1, :cond_26

    :try_start_a
    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {p0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v3

    invoke-static {v1, v2, v3}, Ljava/lang/Class;->forName(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    :try_end_16
    .catch Ljava/lang/ClassNotFoundException; {:try_start_a .. :try_end_16} :catch_1d

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzex;

    goto :goto_26

    :catch_1d
    move-exception p0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Class initialization cannot fail."

    invoke-direct {v0, v1, p0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v0

    :cond_26
    :goto_26
    if-nez v1, :cond_42

    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzhn;->zze(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzex;

    const/4 v2, 0x6

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v3}, Lcom/google/android/gms/internal/play_billing/zzex;->zzu(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzex;

    if-eqz v1, :cond_3c

    invoke-interface {v0, p0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_42

    :cond_3c
    new-instance p0, Ljava/lang/IllegalStateException;

    invoke-direct {p0}, Ljava/lang/IllegalStateException;-><init>()V

    throw p0

    :cond_42
    :goto_42
    return-object v1
.end method

.method protected static zzj(Lcom/google/android/gms/internal/play_billing/zzex;[BLcom/google/android/gms/internal/play_billing/zzej;)Lcom/google/android/gms/internal/play_billing/zzex;
    .registers 5

    array-length v0, p1

    const/4 v1, 0x0

    invoke-static {p0, p1, v1, v0, p2}, Lcom/google/android/gms/internal/play_billing/zzex;->zzw(Lcom/google/android/gms/internal/play_billing/zzex;[BIILcom/google/android/gms/internal/play_billing/zzej;)Lcom/google/android/gms/internal/play_billing/zzex;

    move-result-object p0

    if-eqz p0, :cond_1c

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzex;->zzs()Z

    move-result p1

    if-eqz p1, :cond_f

    goto :goto_1c

    :cond_f
    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzhc;

    invoke-direct {p1, p0}, Lcom/google/android/gms/internal/play_billing/zzhc;-><init>(Lcom/google/android/gms/internal/play_billing/zzgc;)V

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzhc;->zza()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object p1

    invoke-virtual {p1, p0}, Lcom/google/android/gms/internal/play_billing/zzff;->zzf(Lcom/google/android/gms/internal/play_billing/zzgc;)Lcom/google/android/gms/internal/play_billing/zzff;

    throw p1

    :cond_1c
    :goto_1c
    return-object p0
.end method

.method static varargs zzl(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3

    :try_start_0
    invoke-virtual {p0, p1, p2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0
    :try_end_4
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_4} :catch_20
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_4} :catch_5

    return-object p0

    :catch_5
    move-exception p0

    invoke-virtual {p0}, Ljava/lang/reflect/InvocationTargetException;->getCause()Ljava/lang/Throwable;

    move-result-object p0

    instance-of p1, p0, Ljava/lang/RuntimeException;

    if-nez p1, :cond_1d

    instance-of p1, p0, Ljava/lang/Error;

    if-eqz p1, :cond_15

    check-cast p0, Ljava/lang/Error;

    throw p0

    :cond_15
    new-instance p1, Ljava/lang/RuntimeException;

    const-string p2, "Unexpected exception thrown by generated accessor method."

    invoke-direct {p1, p2, p0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw p1

    :cond_1d
    check-cast p0, Ljava/lang/RuntimeException;

    throw p0

    :catch_20
    move-exception p0

    new-instance p1, Ljava/lang/RuntimeException;

    const-string p2, "Couldn\'t use Java reflection to implement protocol message reflection."

    invoke-direct {p1, p2, p0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw p1
.end method

.method protected static zzm(Lcom/google/android/gms/internal/play_billing/zzgc;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    .registers 4

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgl;

    invoke-direct {v0, p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzgl;-><init>(Lcom/google/android/gms/internal/play_billing/zzgc;Ljava/lang/String;[Ljava/lang/Object;)V

    return-object v0
.end method

.method protected static zzp(Ljava/lang/Class;Lcom/google/android/gms/internal/play_billing/zzex;)V
    .registers 3

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzex;->zzo()V

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzex;->zzb:Ljava/util/Map;

    invoke-interface {v0, p0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method private final zzv(Lcom/google/android/gms/internal/play_billing/zzgm;)I
    .registers 3

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzgk;->zza()Lcom/google/android/gms/internal/play_billing/zzgk;

    move-result-object p1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/play_billing/zzgk;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object p1

    invoke-interface {p1, p0}, Lcom/google/android/gms/internal/play_billing/zzgm;->zza(Ljava/lang/Object;)I

    move-result p1

    return p1
.end method

.method private static zzw(Lcom/google/android/gms/internal/play_billing/zzex;[BIILcom/google/android/gms/internal/play_billing/zzej;)Lcom/google/android/gms/internal/play_billing/zzex;
    .registers 11

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzex;->zzi()Lcom/google/android/gms/internal/play_billing/zzex;

    move-result-object p0

    :try_start_4
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzgk;->zza()Lcom/google/android/gms/internal/play_billing/zzgk;

    move-result-object p2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgk;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object p2

    const/4 v3, 0x0

    new-instance v5, Lcom/google/android/gms/internal/play_billing/zzdj;

    invoke-direct {v5, p4}, Lcom/google/android/gms/internal/play_billing/zzdj;-><init>(Lcom/google/android/gms/internal/play_billing/zzej;)V

    move-object v0, p2

    move-object v1, p0

    move-object v2, p1

    move v4, p3

    invoke-interface/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzh(Ljava/lang/Object;[BIILcom/google/android/gms/internal/play_billing/zzdj;)V

    invoke-interface {p2, p0}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzf(Ljava/lang/Object;)V
    :try_end_20
    .catch Lcom/google/android/gms/internal/play_billing/zzff; {:try_start_4 .. :try_end_20} :catch_4b
    .catch Lcom/google/android/gms/internal/play_billing/zzhc; {:try_start_4 .. :try_end_20} :catch_42
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_20} :catch_29
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_4 .. :try_end_20} :catch_21

    return-object p0

    :catch_21
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzg()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object p1

    invoke-virtual {p1, p0}, Lcom/google/android/gms/internal/play_billing/zzff;->zzf(Lcom/google/android/gms/internal/play_billing/zzgc;)Lcom/google/android/gms/internal/play_billing/zzff;

    throw p1

    :catch_29
    move-exception p1

    invoke-virtual {p1}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object p2

    instance-of p2, p2, Lcom/google/android/gms/internal/play_billing/zzff;

    if-eqz p2, :cond_39

    invoke-virtual {p1}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object p0

    check-cast p0, Lcom/google/android/gms/internal/play_billing/zzff;

    throw p0

    :cond_39
    new-instance p2, Lcom/google/android/gms/internal/play_billing/zzff;

    invoke-direct {p2, p1}, Lcom/google/android/gms/internal/play_billing/zzff;-><init>(Ljava/io/IOException;)V

    invoke-virtual {p2, p0}, Lcom/google/android/gms/internal/play_billing/zzff;->zzf(Lcom/google/android/gms/internal/play_billing/zzgc;)Lcom/google/android/gms/internal/play_billing/zzff;

    throw p2

    :catch_42
    move-exception p1

    invoke-virtual {p1}, Lcom/google/android/gms/internal/play_billing/zzhc;->zza()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object p1

    invoke-virtual {p1, p0}, Lcom/google/android/gms/internal/play_billing/zzff;->zzf(Lcom/google/android/gms/internal/play_billing/zzgc;)Lcom/google/android/gms/internal/play_billing/zzff;

    throw p1

    :catch_4b
    move-exception p1

    invoke-virtual {p1, p0}, Lcom/google/android/gms/internal/play_billing/zzff;->zzf(Lcom/google/android/gms/internal/play_billing/zzgc;)Lcom/google/android/gms/internal/play_billing/zzff;

    throw p1
.end method


# virtual methods
.method public final equals(Ljava/lang/Object;)Z
    .registers 5

    if-ne p0, p1, :cond_4

    const/4 p1, 0x1

    return p1

    :cond_4
    const/4 v0, 0x0

    if-nez p1, :cond_8

    return v0

    :cond_8
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    if-eq v1, v2, :cond_13

    return v0

    :cond_13
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzgk;->zza()Lcom/google/android/gms/internal/play_billing/zzgk;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/play_billing/zzgk;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v0

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzex;

    invoke-interface {v0, p0, p1}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzj(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method public final hashCode()I
    .registers 2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzex;->zzt()Z

    move-result v0

    if-nez v0, :cond_11

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzdg;->zza:I

    if-nez v0, :cond_10

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzex;->zzd()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzdg;->zza:I

    :cond_10
    return v0

    :cond_11
    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzex;->zzd()I

    move-result v0

    return v0
.end method

.method public final toString()Ljava/lang/String;
    .registers 2

    invoke-super {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/google/android/gms/internal/play_billing/zzge;->zza(Lcom/google/android/gms/internal/play_billing/zzgc;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method final zza(Lcom/google/android/gms/internal/play_billing/zzgm;)I
    .registers 5

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzex;->zzt()Z

    move-result v0

    const-string v1, "serialized size must be non-negative, was "

    if-eqz v0, :cond_24

    invoke-interface {p1, p0}, Lcom/google/android/gms/internal/play_billing/zzgm;->zza(Ljava/lang/Object;)I

    move-result p1

    if-ltz p1, :cond_f

    return p1

    :cond_f
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_24
    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzex;->zzd:I

    const v2, 0x7fffffff

    and-int/2addr v0, v2

    if-ne v0, v2, :cond_50

    invoke-interface {p1, p0}, Lcom/google/android/gms/internal/play_billing/zzgm;->zza(Ljava/lang/Object;)I

    move-result p1

    if-ltz p1, :cond_3b

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzex;->zzd:I

    const/high16 v1, -0x80000000

    and-int/2addr v0, v1

    or-int/2addr v0, p1

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzex;->zzd:I

    return p1

    :cond_3b
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_50
    return v0
.end method

.method final zzd()I
    .registers 3

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzgk;->zza()Lcom/google/android/gms/internal/play_billing/zzgk;

    move-result-object v0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgk;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v0

    invoke-interface {v0, p0}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzb(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public final zze()I
    .registers 5

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzex;->zzt()Z

    move-result v0

    const-string v1, "serialized size must be non-negative, was "

    const/4 v2, 0x0

    if-eqz v0, :cond_25

    invoke-direct {p0, v2}, Lcom/google/android/gms/internal/play_billing/zzex;->zzv(Lcom/google/android/gms/internal/play_billing/zzgm;)I

    move-result v0

    if-ltz v0, :cond_10

    goto :goto_3c

    :cond_10
    new-instance v2, Ljava/lang/IllegalStateException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    :cond_25
    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzex;->zzd:I

    const v3, 0x7fffffff

    and-int/2addr v0, v3

    if-eq v0, v3, :cond_2e

    goto :goto_3c

    :cond_2e
    invoke-direct {p0, v2}, Lcom/google/android/gms/internal/play_billing/zzex;->zzv(Lcom/google/android/gms/internal/play_billing/zzgm;)I

    move-result v0

    if-ltz v0, :cond_3d

    iget v1, p0, Lcom/google/android/gms/internal/play_billing/zzex;->zzd:I

    const/high16 v2, -0x80000000

    and-int/2addr v1, v2

    or-int/2addr v1, v0

    iput v1, p0, Lcom/google/android/gms/internal/play_billing/zzex;->zzd:I

    :goto_3c
    return v0

    :cond_3d
    new-instance v2, Ljava/lang/IllegalStateException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public final synthetic zzf()Lcom/google/android/gms/internal/play_billing/zzgc;
    .registers 3

    const/4 v0, 0x6

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1, v1}, Lcom/google/android/gms/internal/play_billing/zzex;->zzu(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzex;

    return-object v0
.end method

.method protected final zzg()Lcom/google/android/gms/internal/play_billing/zzet;
    .registers 3

    const/4 v0, 0x5

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1, v1}, Lcom/google/android/gms/internal/play_billing/zzex;->zzu(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzet;

    return-object v0
.end method

.method final zzi()Lcom/google/android/gms/internal/play_billing/zzex;
    .registers 3

    const/4 v0, 0x4

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1, v1}, Lcom/google/android/gms/internal/play_billing/zzex;->zzu(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzex;

    return-object v0
.end method

.method public final synthetic zzk()Lcom/google/android/gms/internal/play_billing/zzgb;
    .registers 3

    const/4 v0, 0x5

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1, v1}, Lcom/google/android/gms/internal/play_billing/zzex;->zzu(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzet;

    return-object v0
.end method

.method protected final zzn()V
    .registers 3

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzgk;->zza()Lcom/google/android/gms/internal/play_billing/zzgk;

    move-result-object v0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgk;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v0

    invoke-interface {v0, p0}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzf(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzex;->zzo()V

    return-void
.end method

.method final zzo()V
    .registers 3

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzex;->zzd:I

    const v1, 0x7fffffff

    and-int/2addr v0, v1

    iput v0, p0, Lcom/google/android/gms/internal/play_billing/zzex;->zzd:I

    return-void
.end method

.method final zzq(I)V
    .registers 3

    iget p1, p0, Lcom/google/android/gms/internal/play_billing/zzex;->zzd:I

    const/high16 v0, -0x80000000

    and-int/2addr p1, v0

    const v0, 0x7fffffff

    or-int/2addr p1, v0

    iput p1, p0, Lcom/google/android/gms/internal/play_billing/zzex;->zzd:I

    return-void
.end method

.method public final zzr(Lcom/google/android/gms/internal/play_billing/zzee;)V
    .registers 4

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzgk;->zza()Lcom/google/android/gms/internal/play_billing/zzgk;

    move-result-object v0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgk;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v0

    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzef;->zza(Lcom/google/android/gms/internal/play_billing/zzee;)Lcom/google/android/gms/internal/play_billing/zzef;

    move-result-object p1

    invoke-interface {v0, p0, p1}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzi(Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzhv;)V

    return-void
.end method

.method public final zzs()Z
    .registers 5

    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1, v1}, Lcom/google/android/gms/internal/play_billing/zzex;->zzu(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Byte;

    invoke-virtual {v2}, Ljava/lang/Byte;->byteValue()B

    move-result v2

    if-ne v2, v0, :cond_f

    goto :goto_12

    :cond_f
    if-nez v2, :cond_13

    const/4 v0, 0x0

    :goto_12
    return v0

    :cond_13
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzgk;->zza()Lcom/google/android/gms/internal/play_billing/zzgk;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/google/android/gms/internal/play_billing/zzgk;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v2

    invoke-interface {v2, p0}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzk(Ljava/lang/Object;)Z

    move-result v2

    if-eq v0, v2, :cond_27

    move-object v0, v1

    goto :goto_28

    :cond_27
    move-object v0, p0

    :goto_28
    const/4 v3, 0x2

    invoke-virtual {p0, v3, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzex;->zzu(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return v2
.end method

.method final zzt()Z
    .registers 3

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzex;->zzd:I

    const/high16 v1, -0x80000000

    and-int/2addr v0, v1

    if-eqz v0, :cond_9

    const/4 v0, 0x1

    return v0

    :cond_9
    const/4 v0, 0x0

    return v0
.end method

.method protected abstract zzu(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method
