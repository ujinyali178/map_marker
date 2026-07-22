.class public abstract Lcom/google/android/gms/internal/auth/zzev;
.super Lcom/google/android/gms/internal/auth/zzdq;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<MessageType:",
        "Lcom/google/android/gms/internal/auth/zzev<",
        "TMessageType;TBuilderType;>;BuilderType:",
        "Lcom/google/android/gms/internal/auth/zzet<",
        "TMessageType;TBuilderType;>;>",
        "Lcom/google/android/gms/internal/auth/zzdq<",
        "TMessageType;TBuilderType;>;"
    }
.end annotation


# static fields
.field private static final zzb:Ljava/util/Map;


# instance fields
.field protected zzc:Lcom/google/android/gms/internal/auth/zzha;

.field private zzd:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/auth/zzev;->zzb:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Lcom/google/android/gms/internal/auth/zzdq;-><init>()V

    const/4 v0, -0x1

    iput v0, p0, Lcom/google/android/gms/internal/auth/zzev;->zzd:I

    invoke-static {}, Lcom/google/android/gms/internal/auth/zzha;->zza()Lcom/google/android/gms/internal/auth/zzha;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/auth/zzev;->zzc:Lcom/google/android/gms/internal/auth/zzha;

    return-void
.end method

.method static zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/auth/zzev;
    .registers 5

    sget-object v0, Lcom/google/android/gms/internal/auth/zzev;->zzb:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/auth/zzev;

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

    check-cast v1, Lcom/google/android/gms/internal/auth/zzev;

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

    invoke-static {p0}, Lcom/google/android/gms/internal/auth/zzhj;->zze(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/auth/zzev;

    const/4 v2, 0x6

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v3}, Lcom/google/android/gms/internal/auth/zzev;->zzn(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/auth/zzev;

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

.method protected static zzd(Lcom/google/android/gms/internal/auth/zzev;[B)Lcom/google/android/gms/internal/auth/zzev;
    .registers 5

    array-length v0, p1

    sget-object v1, Lcom/google/android/gms/internal/auth/zzel;->zza:Lcom/google/android/gms/internal/auth/zzel;

    const/4 v2, 0x0

    invoke-static {p0, p1, v2, v0, v1}, Lcom/google/android/gms/internal/auth/zzev;->zzo(Lcom/google/android/gms/internal/auth/zzev;[BIILcom/google/android/gms/internal/auth/zzel;)Lcom/google/android/gms/internal/auth/zzev;

    move-result-object p0

    if-eqz p0, :cond_44

    const/4 p1, 0x1

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0, v0}, Lcom/google/android/gms/internal/auth/zzev;->zzn(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Byte;

    invoke-virtual {v1}, Ljava/lang/Byte;->byteValue()B

    move-result v1

    if-ne v1, p1, :cond_19

    goto :goto_44

    :cond_19
    if-eqz v1, :cond_37

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-static {}, Lcom/google/android/gms/internal/auth/zzgf;->zza()Lcom/google/android/gms/internal/auth/zzgf;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/google/android/gms/internal/auth/zzgf;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v1

    invoke-interface {v1, p0}, Lcom/google/android/gms/internal/auth/zzgi;->zzi(Ljava/lang/Object;)Z

    move-result v1

    if-eq p1, v1, :cond_2f

    move-object p1, v0

    goto :goto_30

    :cond_2f
    move-object p1, p0

    :goto_30
    const/4 v2, 0x2

    invoke-virtual {p0, v2, p1, v0}, Lcom/google/android/gms/internal/auth/zzev;->zzn(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    if-eqz v1, :cond_37

    goto :goto_44

    :cond_37
    new-instance p1, Lcom/google/android/gms/internal/auth/zzgy;

    invoke-direct {p1, p0}, Lcom/google/android/gms/internal/auth/zzgy;-><init>(Lcom/google/android/gms/internal/auth/zzfx;)V

    invoke-virtual {p1}, Lcom/google/android/gms/internal/auth/zzgy;->zza()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object p1

    invoke-virtual {p1, p0}, Lcom/google/android/gms/internal/auth/zzfb;->zze(Lcom/google/android/gms/internal/auth/zzfx;)Lcom/google/android/gms/internal/auth/zzfb;

    throw p1

    :cond_44
    :goto_44
    return-object p0
.end method

.method protected static zzf()Lcom/google/android/gms/internal/auth/zzez;
    .registers 1

    invoke-static {}, Lcom/google/android/gms/internal/auth/zzgg;->zze()Lcom/google/android/gms/internal/auth/zzgg;

    move-result-object v0

    return-object v0
.end method

.method static varargs zzg(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
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

.method protected static zzh(Lcom/google/android/gms/internal/auth/zzfx;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    .registers 4

    new-instance p1, Lcom/google/android/gms/internal/auth/zzgh;

    const-string v0, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a"

    invoke-direct {p1, p0, v0, p2}, Lcom/google/android/gms/internal/auth/zzgh;-><init>(Lcom/google/android/gms/internal/auth/zzfx;Ljava/lang/String;[Ljava/lang/Object;)V

    return-object p1
.end method

.method protected static zzk(Ljava/lang/Class;Lcom/google/android/gms/internal/auth/zzev;)V
    .registers 3

    invoke-virtual {p1}, Lcom/google/android/gms/internal/auth/zzev;->zzj()V

    sget-object v0, Lcom/google/android/gms/internal/auth/zzev;->zzb:Ljava/util/Map;

    invoke-interface {v0, p0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method private static zzo(Lcom/google/android/gms/internal/auth/zzev;[BIILcom/google/android/gms/internal/auth/zzel;)Lcom/google/android/gms/internal/auth/zzev;
    .registers 11

    invoke-virtual {p0}, Lcom/google/android/gms/internal/auth/zzev;->zzc()Lcom/google/android/gms/internal/auth/zzev;

    move-result-object p0

    :try_start_4
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzgf;->zza()Lcom/google/android/gms/internal/auth/zzgf;

    move-result-object p2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {p2, v0}, Lcom/google/android/gms/internal/auth/zzgf;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object p2

    const/4 v3, 0x0

    new-instance v5, Lcom/google/android/gms/internal/auth/zzdt;

    invoke-direct {v5, p4}, Lcom/google/android/gms/internal/auth/zzdt;-><init>(Lcom/google/android/gms/internal/auth/zzel;)V

    move-object v0, p2

    move-object v1, p0

    move-object v2, p1

    move v4, p3

    invoke-interface/range {v0 .. v5}, Lcom/google/android/gms/internal/auth/zzgi;->zzg(Ljava/lang/Object;[BIILcom/google/android/gms/internal/auth/zzdt;)V

    invoke-interface {p2, p0}, Lcom/google/android/gms/internal/auth/zzgi;->zze(Ljava/lang/Object;)V
    :try_end_20
    .catch Lcom/google/android/gms/internal/auth/zzfb; {:try_start_4 .. :try_end_20} :catch_4b
    .catch Lcom/google/android/gms/internal/auth/zzgy; {:try_start_4 .. :try_end_20} :catch_42
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_20} :catch_29
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_4 .. :try_end_20} :catch_21

    return-object p0

    :catch_21
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzf()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object p1

    invoke-virtual {p1, p0}, Lcom/google/android/gms/internal/auth/zzfb;->zze(Lcom/google/android/gms/internal/auth/zzfx;)Lcom/google/android/gms/internal/auth/zzfb;

    throw p1

    :catch_29
    move-exception p1

    invoke-virtual {p1}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object p2

    instance-of p2, p2, Lcom/google/android/gms/internal/auth/zzfb;

    if-eqz p2, :cond_39

    invoke-virtual {p1}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object p0

    check-cast p0, Lcom/google/android/gms/internal/auth/zzfb;

    throw p0

    :cond_39
    new-instance p2, Lcom/google/android/gms/internal/auth/zzfb;

    invoke-direct {p2, p1}, Lcom/google/android/gms/internal/auth/zzfb;-><init>(Ljava/io/IOException;)V

    invoke-virtual {p2, p0}, Lcom/google/android/gms/internal/auth/zzfb;->zze(Lcom/google/android/gms/internal/auth/zzfx;)Lcom/google/android/gms/internal/auth/zzfb;

    throw p2

    :catch_42
    move-exception p1

    invoke-virtual {p1}, Lcom/google/android/gms/internal/auth/zzgy;->zza()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object p1

    invoke-virtual {p1, p0}, Lcom/google/android/gms/internal/auth/zzfb;->zze(Lcom/google/android/gms/internal/auth/zzfx;)Lcom/google/android/gms/internal/auth/zzfb;

    throw p1

    :catch_4b
    move-exception p1

    invoke-virtual {p1, p0}, Lcom/google/android/gms/internal/auth/zzfb;->zze(Lcom/google/android/gms/internal/auth/zzfx;)Lcom/google/android/gms/internal/auth/zzfb;

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

    invoke-static {}, Lcom/google/android/gms/internal/auth/zzgf;->zza()Lcom/google/android/gms/internal/auth/zzgf;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/auth/zzgf;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v0

    check-cast p1, Lcom/google/android/gms/internal/auth/zzev;

    invoke-interface {v0, p0, p1}, Lcom/google/android/gms/internal/auth/zzgi;->zzh(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method public final hashCode()I
    .registers 2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/auth/zzev;->zzm()Z

    move-result v0

    if-nez v0, :cond_11

    iget v0, p0, Lcom/google/android/gms/internal/auth/zzdq;->zza:I

    if-nez v0, :cond_10

    invoke-virtual {p0}, Lcom/google/android/gms/internal/auth/zzev;->zza()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/internal/auth/zzdq;->zza:I

    :cond_10
    return v0

    :cond_11
    invoke-virtual {p0}, Lcom/google/android/gms/internal/auth/zzev;->zza()I

    move-result v0

    return v0
.end method

.method public final toString()Ljava/lang/String;
    .registers 2

    invoke-super {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/google/android/gms/internal/auth/zzfz;->zza(Lcom/google/android/gms/internal/auth/zzfx;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method final zza()I
    .registers 3

    invoke-static {}, Lcom/google/android/gms/internal/auth/zzgf;->zza()Lcom/google/android/gms/internal/auth/zzgf;

    move-result-object v0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/auth/zzgf;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v0

    invoke-interface {v0, p0}, Lcom/google/android/gms/internal/auth/zzgi;->zza(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method final zzc()Lcom/google/android/gms/internal/auth/zzev;
    .registers 3

    const/4 v0, 0x4

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1, v1}, Lcom/google/android/gms/internal/auth/zzev;->zzn(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/auth/zzev;

    return-object v0
.end method

.method public final synthetic zze()Lcom/google/android/gms/internal/auth/zzfx;
    .registers 3

    const/4 v0, 0x6

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1, v1}, Lcom/google/android/gms/internal/auth/zzev;->zzn(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/auth/zzev;

    return-object v0
.end method

.method protected final zzi()V
    .registers 3

    invoke-static {}, Lcom/google/android/gms/internal/auth/zzgf;->zza()Lcom/google/android/gms/internal/auth/zzgf;

    move-result-object v0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/auth/zzgf;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v0

    invoke-interface {v0, p0}, Lcom/google/android/gms/internal/auth/zzgi;->zze(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/auth/zzev;->zzj()V

    return-void
.end method

.method final zzj()V
    .registers 3

    iget v0, p0, Lcom/google/android/gms/internal/auth/zzev;->zzd:I

    const v1, 0x7fffffff

    and-int/2addr v0, v1

    iput v0, p0, Lcom/google/android/gms/internal/auth/zzev;->zzd:I

    return-void
.end method

.method final zzl(I)V
    .registers 3

    iget p1, p0, Lcom/google/android/gms/internal/auth/zzev;->zzd:I

    const/high16 v0, -0x80000000

    and-int/2addr p1, v0

    const v0, 0x7fffffff

    or-int/2addr p1, v0

    iput p1, p0, Lcom/google/android/gms/internal/auth/zzev;->zzd:I

    return-void
.end method

.method final zzm()Z
    .registers 3

    iget v0, p0, Lcom/google/android/gms/internal/auth/zzev;->zzd:I

    const/high16 v1, -0x80000000

    and-int/2addr v0, v1

    if-eqz v0, :cond_9

    const/4 v0, 0x1

    return v0

    :cond_9
    const/4 v0, 0x0

    return v0
.end method

.method protected abstract zzn(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end method
