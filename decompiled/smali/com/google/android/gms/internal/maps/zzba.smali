.class public abstract Lcom/google/android/gms/internal/maps/zzba;
.super Lcom/google/android/gms/internal/maps/zzaw;
.source "SourceFile"

# interfaces
.implements Ljava/util/Set;


# instance fields
.field private transient zza:Lcom/google/android/gms/internal/maps/zzaz;
    .annotation runtime Ljavax/annotation/CheckForNull;
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lcom/google/android/gms/internal/maps/zzaw;-><init>()V

    return-void
.end method

.method static zzf(I)I
    .registers 7

    const/4 v0, 0x2

    invoke-static {p0, v0}, Ljava/lang/Math;->max(II)I

    move-result p0

    const v0, 0x2ccccccc

    if-ge p0, v0, :cond_20

    add-int/lit8 v0, p0, -0x1

    invoke-static {v0}, Ljava/lang/Integer;->highestOneBit(I)I

    move-result v0

    :goto_10
    add-int/2addr v0, v0

    int-to-double v1, v0

    const-wide v3, 0x3fe6666666666666L    # 0.7

    mul-double v1, v1, v3

    int-to-double v3, p0

    cmpg-double v5, v1, v3

    if-gez v5, :cond_1f

    goto :goto_10

    :cond_1f
    return v0

    :cond_20
    const/high16 v0, 0x40000000    # 2.0f

    if-ge p0, v0, :cond_25

    return v0

    :cond_25
    new-instance p0, Ljava/lang/IllegalArgumentException;

    const-string v0, "collection too large"

    invoke-direct {p0, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static varargs zzi(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Lcom/google/android/gms/internal/maps/zzba;
    .registers 7
    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    const/4 p0, 0x6

    new-array p1, p0, [Ljava/lang/Object;

    const-string p2, "ADMINISTRATIVE_AREA_LEVEL_1"

    const/4 p3, 0x0

    aput-object p2, p1, p3

    const/4 p2, 0x1

    const-string p4, "ADMINISTRATIVE_AREA_LEVEL_2"

    aput-object p4, p1, p2

    const/4 p2, 0x2

    const-string p4, "COUNTRY"

    aput-object p4, p1, p2

    const/4 p2, 0x3

    const-string p4, "LOCALITY"

    aput-object p4, p1, p2

    const/4 p2, 0x4

    const-string p4, "POSTAL_CODE"

    aput-object p4, p1, p2

    const/4 p2, 0x5

    const-string p4, "SCHOOL_DISTRICT"

    aput-object p4, p1, p2

    invoke-static {p6, p3, p1, p0, p3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    invoke-static {p0, p1}, Lcom/google/android/gms/internal/maps/zzba;->zzk(I[Ljava/lang/Object;)Lcom/google/android/gms/internal/maps/zzba;

    move-result-object p0

    return-object p0
.end method

.method private static varargs zzk(I[Ljava/lang/Object;)Lcom/google/android/gms/internal/maps/zzba;
    .registers 15

    if-eqz p0, :cond_89

    const/4 v0, 0x0

    const/4 v1, 0x1

    if-eq p0, v1, :cond_7e

    invoke-static {p0}, Lcom/google/android/gms/internal/maps/zzba;->zzf(I)I

    move-result v2

    new-array v6, v2, [Ljava/lang/Object;

    add-int/lit8 v7, v2, -0x1

    const/4 v3, 0x0

    const/4 v5, 0x0

    const/4 v8, 0x0

    :goto_11
    if-ge v3, p0, :cond_51

    aget-object v4, p1, v3

    if-eqz v4, :cond_3a

    invoke-virtual {v4}, Ljava/lang/Object;->hashCode()I

    move-result v9

    invoke-static {v9}, Lcom/google/android/gms/internal/maps/zzav;->zza(I)I

    move-result v10

    :goto_1f
    and-int v11, v10, v7

    aget-object v12, v6, v11

    if-nez v12, :cond_2e

    add-int/lit8 v10, v8, 0x1

    aput-object v4, p1, v8

    aput-object v4, v6, v11

    add-int/2addr v5, v9

    move v8, v10

    goto :goto_37

    :cond_2e
    invoke-virtual {v12, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_37

    add-int/lit8 v10, v10, 0x1

    goto :goto_1f

    :cond_37
    :goto_37
    add-int/lit8 v3, v3, 0x1

    goto :goto_11

    :cond_3a
    new-instance p0, Ljava/lang/NullPointerException;

    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, "at index "

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_51
    const/4 v3, 0x0

    invoke-static {p1, v8, p0, v3}, Ljava/util/Arrays;->fill([Ljava/lang/Object;IILjava/lang/Object;)V

    if-ne v8, v1, :cond_62

    aget-object p0, p1, v0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    new-instance p1, Lcom/google/android/gms/internal/maps/zzbe;

    invoke-direct {p1, p0}, Lcom/google/android/gms/internal/maps/zzbe;-><init>(Ljava/lang/Object;)V

    return-object p1

    :cond_62
    div-int/lit8 v2, v2, 0x2

    invoke-static {v8}, Lcom/google/android/gms/internal/maps/zzba;->zzf(I)I

    move-result p0

    if-lt p0, v2, :cond_79

    const/4 p0, 0x4

    if-ge v8, p0, :cond_71

    invoke-static {p1, v8}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object p1

    :cond_71
    move-object v4, p1

    new-instance p0, Lcom/google/android/gms/internal/maps/zzbd;

    move-object v3, p0

    invoke-direct/range {v3 .. v8}, Lcom/google/android/gms/internal/maps/zzbd;-><init>([Ljava/lang/Object;I[Ljava/lang/Object;II)V

    return-object p0

    :cond_79
    invoke-static {v8, p1}, Lcom/google/android/gms/internal/maps/zzba;->zzk(I[Ljava/lang/Object;)Lcom/google/android/gms/internal/maps/zzba;

    move-result-object p0

    return-object p0

    :cond_7e
    aget-object p0, p1, v0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    new-instance p1, Lcom/google/android/gms/internal/maps/zzbe;

    invoke-direct {p1, p0}, Lcom/google/android/gms/internal/maps/zzbe;-><init>(Ljava/lang/Object;)V

    return-object p1

    :cond_89
    sget-object p0, Lcom/google/android/gms/internal/maps/zzbd;->zza:Lcom/google/android/gms/internal/maps/zzbd;

    return-object p0
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
    instance-of v1, p1, Lcom/google/android/gms/internal/maps/zzba;

    const/4 v2, 0x0

    if-eqz v1, :cond_24

    invoke-virtual {p0}, Lcom/google/android/gms/internal/maps/zzba;->zzj()Z

    move-result v1

    if-eqz v1, :cond_24

    move-object v1, p1

    check-cast v1, Lcom/google/android/gms/internal/maps/zzba;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/maps/zzba;->zzj()Z

    move-result v1

    if-eqz v1, :cond_24

    invoke-virtual {p0}, Lcom/google/android/gms/internal/maps/zzba;->hashCode()I

    move-result v1

    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v3

    if-ne v1, v3, :cond_23

    goto :goto_24

    :cond_23
    return v2

    :cond_24
    :goto_24
    if-ne p1, p0, :cond_27

    goto :goto_40

    :cond_27
    instance-of v1, p1, Ljava/util/Set;

    if-eqz v1, :cond_3f

    check-cast p1, Ljava/util/Set;

    :try_start_2d
    invoke-interface {p0}, Ljava/util/Set;->size()I

    move-result v1

    invoke-interface {p1}, Ljava/util/Set;->size()I

    move-result v3

    if-ne v1, v3, :cond_3f

    invoke-interface {p0, p1}, Ljava/util/Set;->containsAll(Ljava/util/Collection;)Z

    move-result p1
    :try_end_3b
    .catch Ljava/lang/NullPointerException; {:try_start_2d .. :try_end_3b} :catch_3f
    .catch Ljava/lang/ClassCastException; {:try_start_2d .. :try_end_3b} :catch_3f

    if-nez p1, :cond_3e

    goto :goto_3f

    :cond_3e
    return v0

    :catch_3f
    :cond_3f
    :goto_3f
    const/4 v0, 0x0

    :goto_40
    return v0
.end method

.method public hashCode()I
    .registers 5

    invoke-interface {p0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1a

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_17

    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v3

    goto :goto_18

    :cond_17
    const/4 v3, 0x0

    :goto_18
    add-int/2addr v2, v3

    goto :goto_6

    :cond_1a
    return v2
.end method

.method public bridge synthetic iterator()Ljava/util/Iterator;
    .registers 2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/maps/zzba;->zzd()Lcom/google/android/gms/internal/maps/zzbf;

    move-result-object v0

    return-object v0
.end method

.method public abstract zzd()Lcom/google/android/gms/internal/maps/zzbf;
.end method

.method public final zzg()Lcom/google/android/gms/internal/maps/zzaz;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/internal/maps/zzba;->zza:Lcom/google/android/gms/internal/maps/zzaz;

    if-nez v0, :cond_a

    invoke-virtual {p0}, Lcom/google/android/gms/internal/maps/zzba;->zzh()Lcom/google/android/gms/internal/maps/zzaz;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/maps/zzba;->zza:Lcom/google/android/gms/internal/maps/zzaz;

    :cond_a
    return-object v0
.end method

.method zzh()Lcom/google/android/gms/internal/maps/zzaz;
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/gms/internal/maps/zzaw;->toArray()[Ljava/lang/Object;

    move-result-object v0

    sget v1, Lcom/google/android/gms/internal/maps/zzaz;->zzd:I

    array-length v1, v0

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/maps/zzaz;->zzg([Ljava/lang/Object;I)Lcom/google/android/gms/internal/maps/zzaz;

    move-result-object v0

    return-object v0
.end method

.method zzj()Z
    .registers 2

    const/4 v0, 0x0

    return v0
.end method
