.class public abstract Lcom/google/android/gms/internal/play_billing/zzaf;
.super Lcom/google/android/gms/internal/play_billing/zzac;
.source "SourceFile"

# interfaces
.implements Ljava/util/List;
.implements Ljava/util/RandomAccess;


# static fields
.field private static final zza:Lcom/google/android/gms/internal/play_billing/zzat;

.field public static final synthetic zzd:I


# direct methods
.method static constructor <clinit>()V
    .registers 3

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzad;

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzal;->zza:Lcom/google/android/gms/internal/play_billing/zzaf;

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzad;-><init>(Lcom/google/android/gms/internal/play_billing/zzaf;I)V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzaf;->zza:Lcom/google/android/gms/internal/play_billing/zzat;

    return-void
.end method

.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzac;-><init>()V

    return-void
.end method

.method static zzi([Ljava/lang/Object;I)Lcom/google/android/gms/internal/play_billing/zzaf;
    .registers 3

    if-nez p1, :cond_5

    sget-object p0, Lcom/google/android/gms/internal/play_billing/zzal;->zza:Lcom/google/android/gms/internal/play_billing/zzaf;

    return-object p0

    :cond_5
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzal;

    invoke-direct {v0, p0, p1}, Lcom/google/android/gms/internal/play_billing/zzal;-><init>([Ljava/lang/Object;I)V

    return-object v0
.end method

.method public static zzj(Ljava/util/Collection;)Lcom/google/android/gms/internal/play_billing/zzaf;
    .registers 4

    instance-of v0, p0, Lcom/google/android/gms/internal/play_billing/zzac;

    if-eqz v0, :cond_1a

    check-cast p0, Lcom/google/android/gms/internal/play_billing/zzac;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzac;->zzd()Lcom/google/android/gms/internal/play_billing/zzaf;

    move-result-object p0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzac;->zzf()Z

    move-result v0

    if-eqz v0, :cond_19

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzac;->toArray()[Ljava/lang/Object;

    move-result-object p0

    array-length v0, p0

    invoke-static {p0, v0}, Lcom/google/android/gms/internal/play_billing/zzaf;->zzi([Ljava/lang/Object;I)Lcom/google/android/gms/internal/play_billing/zzaf;

    move-result-object p0

    :cond_19
    return-object p0

    :cond_1a
    invoke-interface {p0}, Ljava/util/Collection;->toArray()[Ljava/lang/Object;

    move-result-object p0

    array-length v0, p0

    const/4 v1, 0x0

    :goto_20
    if-ge v1, v0, :cond_40

    aget-object v2, p0, v1

    if-eqz v2, :cond_29

    add-int/lit8 v1, v1, 0x1

    goto :goto_20

    :cond_29
    new-instance p0, Ljava/lang/NullPointerException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "at index "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_40
    invoke-static {p0, v0}, Lcom/google/android/gms/internal/play_billing/zzaf;->zzi([Ljava/lang/Object;I)Lcom/google/android/gms/internal/play_billing/zzaf;

    move-result-object p0

    return-object p0
.end method

.method public static zzk()Lcom/google/android/gms/internal/play_billing/zzaf;
    .registers 1

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzal;->zza:Lcom/google/android/gms/internal/play_billing/zzaf;

    return-object v0
.end method


# virtual methods
.method public final add(ILjava/lang/Object;)V
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    new-instance p1, Ljava/lang/UnsupportedOperationException;

    invoke-direct {p1}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw p1
.end method

.method public final addAll(ILjava/util/Collection;)Z
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    new-instance p1, Ljava/lang/UnsupportedOperationException;

    invoke-direct {p1}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw p1
.end method

.method public final contains(Ljava/lang/Object;)Z
    .registers 2
    .param p1    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/CheckForNull;
        .end annotation
    .end param

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzaf;->indexOf(Ljava/lang/Object;)I

    move-result p1

    if-ltz p1, :cond_8

    const/4 p1, 0x1

    return p1

    :cond_8
    const/4 p1, 0x0

    return p1
.end method

.method public final equals(Ljava/lang/Object;)Z
    .registers 8
    .param p1    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/CheckForNull;
        .end annotation
    .end param

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-ne p1, p0, :cond_5

    goto :goto_5b

    :cond_5
    instance-of v2, p1, Ljava/util/List;

    if-nez v2, :cond_b

    :cond_9
    :goto_9
    const/4 v0, 0x0

    goto :goto_5b

    :cond_b
    check-cast p1, Ljava/util/List;

    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v2

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v3

    if-eq v2, v3, :cond_18

    goto :goto_9

    :cond_18
    instance-of v3, p1, Ljava/util/RandomAccess;

    if-eqz v3, :cond_31

    const/4 v3, 0x0

    :goto_1d
    if-ge v3, v2, :cond_5b

    invoke-interface {p0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-interface {p1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/google/android/gms/internal/play_billing/zzt;->zza(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2e

    goto :goto_9

    :cond_2e
    add-int/lit8 v3, v3, 0x1

    goto :goto_1d

    :cond_31
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_39
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_55

    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_46

    goto :goto_9

    :cond_46
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/play_billing/zzt;->zza(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_39

    goto :goto_9

    :cond_55
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p1

    if-nez p1, :cond_9

    :cond_5b
    :goto_5b
    return v0
.end method

.method public final hashCode()I
    .registers 5

    invoke-virtual {p0}, Ljava/util/AbstractCollection;->size()I

    move-result v0

    const/4 v1, 0x1

    const/4 v2, 0x0

    :goto_6
    if-ge v2, v0, :cond_16

    mul-int/lit8 v1, v1, 0x1f

    invoke-interface {p0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v3

    add-int/2addr v1, v3

    add-int/lit8 v2, v2, 0x1

    goto :goto_6

    :cond_16
    return v1
.end method

.method public final indexOf(Ljava/lang/Object;)I
    .registers 6
    .param p1    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/CheckForNull;
        .end annotation
    .end param

    const/4 v0, -0x1

    if-nez p1, :cond_4

    return v0

    :cond_4
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v1

    const/4 v2, 0x0

    :goto_9
    if-ge v2, v1, :cond_1a

    invoke-interface {p0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {p1, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_17

    move v0, v2

    goto :goto_1a

    :cond_17
    add-int/lit8 v2, v2, 0x1

    goto :goto_9

    :cond_1a
    :goto_1a
    return v0
.end method

.method public final synthetic iterator()Ljava/util/Iterator;
    .registers 2

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/play_billing/zzaf;->zzl(I)Lcom/google/android/gms/internal/play_billing/zzat;

    move-result-object v0

    return-object v0
.end method

.method public final lastIndexOf(Ljava/lang/Object;)I
    .registers 5
    .param p1    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/CheckForNull;
        .end annotation
    .end param

    const/4 v0, -0x1

    if-nez p1, :cond_4

    return v0

    :cond_4
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v1, v0

    :goto_9
    if-ltz v1, :cond_1a

    invoke-interface {p0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_17

    move v0, v1

    goto :goto_1a

    :cond_17
    add-int/lit8 v1, v1, -0x1

    goto :goto_9

    :cond_1a
    :goto_1a
    return v0
.end method

.method public final synthetic listIterator()Ljava/util/ListIterator;
    .registers 2

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/play_billing/zzaf;->zzl(I)Lcom/google/android/gms/internal/play_billing/zzat;

    move-result-object v0

    return-object v0
.end method

.method public final bridge synthetic listIterator(I)Ljava/util/ListIterator;
    .registers 2

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzaf;->zzl(I)Lcom/google/android/gms/internal/play_billing/zzat;

    move-result-object p1

    return-object p1
.end method

.method public final remove(I)Ljava/lang/Object;
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    new-instance p1, Ljava/lang/UnsupportedOperationException;

    invoke-direct {p1}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw p1
.end method

.method public final set(ILjava/lang/Object;)Ljava/lang/Object;
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    new-instance p1, Ljava/lang/UnsupportedOperationException;

    invoke-direct {p1}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw p1
.end method

.method public bridge synthetic subList(II)Ljava/util/List;
    .registers 3

    invoke-virtual {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzaf;->zzh(II)Lcom/google/android/gms/internal/play_billing/zzaf;

    move-result-object p1

    return-object p1
.end method

.method zza([Ljava/lang/Object;I)I
    .registers 5

    invoke-virtual {p0}, Ljava/util/AbstractCollection;->size()I

    move-result p2

    const/4 v0, 0x0

    :goto_5
    if-ge v0, p2, :cond_10

    invoke-interface {p0, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    aput-object v1, p1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    :cond_10
    return p2
.end method

.method public final zzd()Lcom/google/android/gms/internal/play_billing/zzaf;
    .registers 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    return-object p0
.end method

.method public final zze()Lcom/google/android/gms/internal/play_billing/zzas;
    .registers 2

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/play_billing/zzaf;->zzl(I)Lcom/google/android/gms/internal/play_billing/zzat;

    move-result-object v0

    return-object v0
.end method

.method public zzh(II)Lcom/google/android/gms/internal/play_billing/zzaf;
    .registers 4

    invoke-virtual {p0}, Ljava/util/AbstractCollection;->size()I

    move-result v0

    invoke-static {p1, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzx;->zzd(III)V

    sub-int/2addr p2, p1

    invoke-virtual {p0}, Ljava/util/AbstractCollection;->size()I

    move-result v0

    if-ne p2, v0, :cond_f

    return-object p0

    :cond_f
    if-nez p2, :cond_14

    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzal;->zza:Lcom/google/android/gms/internal/play_billing/zzaf;

    return-object p1

    :cond_14
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzae;

    invoke-direct {v0, p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzae;-><init>(Lcom/google/android/gms/internal/play_billing/zzaf;II)V

    return-object v0
.end method

.method public final zzl(I)Lcom/google/android/gms/internal/play_billing/zzat;
    .registers 4

    invoke-virtual {p0}, Ljava/util/AbstractCollection;->size()I

    move-result v0

    const-string v1, "index"

    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzx;->zzb(IILjava/lang/String;)I

    invoke-virtual {p0}, Ljava/util/AbstractCollection;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_12

    sget-object p1, Lcom/google/android/gms/internal/play_billing/zzaf;->zza:Lcom/google/android/gms/internal/play_billing/zzat;

    return-object p1

    :cond_12
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzad;

    invoke-direct {v0, p0, p1}, Lcom/google/android/gms/internal/play_billing/zzad;-><init>(Lcom/google/android/gms/internal/play_billing/zzaf;I)V

    return-object v0
.end method
