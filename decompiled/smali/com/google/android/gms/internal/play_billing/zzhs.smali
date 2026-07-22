.class final Lcom/google/android/gms/internal/play_billing/zzhs;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final synthetic zza:I

.field private static final zzb:Lcom/google/android/gms/internal/play_billing/zzhp;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzx()Z

    move-result v0

    if-eqz v0, :cond_e

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzy()Z

    move-result v0

    if-eqz v0, :cond_e

    sget v0, Lcom/google/android/gms/internal/play_billing/zzdi;->zza:I

    :cond_e
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzhq;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzhq;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzhs;->zzb:Lcom/google/android/gms/internal/play_billing/zzhp;

    return-void
.end method

.method static bridge synthetic zza([BII)I
    .registers 8

    sub-int/2addr p2, p1

    add-int/lit8 v0, p1, -0x1

    aget-byte v0, p0, v0

    const/16 v1, -0xc

    if-eqz p2, :cond_35

    const/4 v2, 0x1

    const/16 v3, -0x41

    if-eq p2, v2, :cond_2a

    const/4 v4, 0x2

    if-ne p2, v4, :cond_24

    aget-byte p2, p0, p1

    add-int/2addr p1, v2

    aget-byte p0, p0, p1

    if-gt v0, v1, :cond_38

    if-gt p2, v3, :cond_38

    if-le p0, v3, :cond_1d

    goto :goto_38

    :cond_1d
    shl-int/lit8 p1, p2, 0x8

    shl-int/lit8 p0, p0, 0x10

    xor-int/2addr p1, v0

    xor-int/2addr p0, p1

    return p0

    :cond_24
    new-instance p0, Ljava/lang/AssertionError;

    invoke-direct {p0}, Ljava/lang/AssertionError;-><init>()V

    throw p0

    :cond_2a
    aget-byte p0, p0, p1

    if-gt v0, v1, :cond_38

    if-le p0, v3, :cond_31

    goto :goto_38

    :cond_31
    shl-int/lit8 p0, p0, 0x8

    xor-int/2addr p0, v0

    return p0

    :cond_35
    if-gt v0, v1, :cond_38

    return v0

    :cond_38
    :goto_38
    const/4 p0, -0x1

    return p0
.end method

.method static zzb(Ljava/lang/CharSequence;[BII)I
    .registers 12

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    const/4 v1, 0x0

    :goto_5
    add-int v2, p2, p3

    const/16 v3, 0x80

    if-ge v1, v0, :cond_1b

    add-int v4, v1, p2

    if-ge v4, v2, :cond_1b

    invoke-interface {p0, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v5

    if-ge v5, v3, :cond_1b

    int-to-byte v2, v5

    aput-byte v2, p1, v4

    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_1b
    if-ne v1, v0, :cond_20

    add-int/2addr p2, v0

    goto/16 :goto_101

    :cond_20
    add-int/2addr p2, v1

    :goto_21
    if-ge v1, v0, :cond_101

    invoke-interface {p0, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result p3

    if-ge p3, v3, :cond_33

    if-ge p2, v2, :cond_33

    add-int/lit8 v4, p2, 0x1

    int-to-byte p3, p3

    aput-byte p3, p1, p2

    move p2, v4

    goto/16 :goto_b9

    :cond_33
    const/16 v4, 0x800

    if-ge p3, v4, :cond_4e

    add-int/lit8 v4, v2, -0x2

    if-gt p2, v4, :cond_4e

    add-int/lit8 v4, p2, 0x1

    add-int/lit8 v5, v4, 0x1

    ushr-int/lit8 v6, p3, 0x6

    or-int/lit16 v6, v6, 0x3c0

    int-to-byte v6, v6

    aput-byte v6, p1, p2

    and-int/lit8 p2, p3, 0x3f

    or-int/2addr p2, v3

    int-to-byte p2, p2

    aput-byte p2, p1, v4

    move p2, v5

    goto :goto_b9

    :cond_4e
    const v4, 0xdfff

    const v5, 0xd800

    if-lt p3, v5, :cond_58

    if-le p3, v4, :cond_79

    :cond_58
    add-int/lit8 v6, v2, -0x3

    if-gt p2, v6, :cond_79

    add-int/lit8 v4, p2, 0x1

    add-int/lit8 v5, v4, 0x1

    add-int/lit8 v6, v5, 0x1

    ushr-int/lit8 v7, p3, 0xc

    or-int/lit16 v7, v7, 0x1e0

    int-to-byte v7, v7

    aput-byte v7, p1, p2

    ushr-int/lit8 p2, p3, 0x6

    and-int/lit8 p2, p2, 0x3f

    or-int/2addr p2, v3

    int-to-byte p2, p2

    aput-byte p2, p1, v4

    and-int/lit8 p2, p3, 0x3f

    or-int/2addr p2, v3

    int-to-byte p2, p2

    aput-byte p2, p1, v5

    move p2, v6

    goto :goto_b9

    :cond_79
    add-int/lit8 v6, v2, -0x4

    if-gt p2, v6, :cond_c6

    add-int/lit8 v4, v1, 0x1

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v5

    if-eq v4, v5, :cond_be

    invoke-interface {p0, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v1

    invoke-static {p3, v1}, Ljava/lang/Character;->isSurrogatePair(CC)Z

    move-result v5

    if-eqz v5, :cond_bd

    add-int/lit8 v5, p2, 0x1

    add-int/lit8 v6, v5, 0x1

    add-int/lit8 v7, v6, 0x1

    invoke-static {p3, v1}, Ljava/lang/Character;->toCodePoint(CC)I

    move-result p3

    ushr-int/lit8 v1, p3, 0x12

    or-int/lit16 v1, v1, 0xf0

    int-to-byte v1, v1

    aput-byte v1, p1, p2

    ushr-int/lit8 p2, p3, 0xc

    and-int/lit8 p2, p2, 0x3f

    or-int/2addr p2, v3

    int-to-byte p2, p2

    aput-byte p2, p1, v5

    ushr-int/lit8 p2, p3, 0x6

    and-int/lit8 p2, p2, 0x3f

    or-int/2addr p2, v3

    int-to-byte p2, p2

    aput-byte p2, p1, v6

    add-int/lit8 p2, v7, 0x1

    and-int/lit8 p3, p3, 0x3f

    or-int/2addr p3, v3

    int-to-byte p3, p3

    aput-byte p3, p1, v7

    move v1, v4

    :goto_b9
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_21

    :cond_bd
    move v1, v4

    :cond_be
    new-instance p0, Lcom/google/android/gms/internal/play_billing/zzhr;

    add-int/lit8 v1, v1, -0x1

    invoke-direct {p0, v1, v0}, Lcom/google/android/gms/internal/play_billing/zzhr;-><init>(II)V

    throw p0

    :cond_c6
    if-lt p3, v5, :cond_e2

    if-gt p3, v4, :cond_e2

    add-int/lit8 p1, v1, 0x1

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v2

    if-eq p1, v2, :cond_dc

    invoke-interface {p0, p1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result p0

    invoke-static {p3, p0}, Ljava/lang/Character;->isSurrogatePair(CC)Z

    move-result p0

    if-nez p0, :cond_e2

    :cond_dc
    new-instance p0, Lcom/google/android/gms/internal/play_billing/zzhr;

    invoke-direct {p0, v1, v0}, Lcom/google/android/gms/internal/play_billing/zzhr;-><init>(II)V

    throw p0

    :cond_e2
    new-instance p0, Ljava/lang/ArrayIndexOutOfBoundsException;

    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, "Failed writing "

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, p3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    const-string p3, " at index "

    invoke-virtual {p1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_101
    :goto_101
    return p2
.end method

.method static zzc(Ljava/lang/CharSequence;)I
    .registers 9

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_6
    if-ge v2, v0, :cond_13

    invoke-interface {p0, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    const/16 v4, 0x80

    if-ge v3, v4, :cond_13

    add-int/lit8 v2, v2, 0x1

    goto :goto_6

    :cond_13
    move v3, v0

    :goto_14
    if-ge v2, v0, :cond_59

    invoke-interface {p0, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v4

    const/16 v5, 0x800

    if-ge v4, v5, :cond_26

    rsub-int/lit8 v4, v4, 0x7f

    ushr-int/lit8 v4, v4, 0x1f

    add-int/2addr v3, v4

    add-int/lit8 v2, v2, 0x1

    goto :goto_14

    :cond_26
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v4

    :goto_2a
    if-ge v2, v4, :cond_58

    invoke-interface {p0, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v6

    if-ge v6, v5, :cond_38

    rsub-int/lit8 v6, v6, 0x7f

    ushr-int/lit8 v6, v6, 0x1f

    add-int/2addr v1, v6

    goto :goto_55

    :cond_38
    add-int/lit8 v1, v1, 0x2

    const v7, 0xd800

    if-lt v6, v7, :cond_55

    const v7, 0xdfff

    if-gt v6, v7, :cond_55

    invoke-static {p0, v2}, Ljava/lang/Character;->codePointAt(Ljava/lang/CharSequence;I)I

    move-result v6

    const/high16 v7, 0x10000

    if-lt v6, v7, :cond_4f

    add-int/lit8 v2, v2, 0x1

    goto :goto_55

    :cond_4f
    new-instance p0, Lcom/google/android/gms/internal/play_billing/zzhr;

    invoke-direct {p0, v2, v4}, Lcom/google/android/gms/internal/play_billing/zzhr;-><init>(II)V

    throw p0

    :cond_55
    :goto_55
    add-int/lit8 v2, v2, 0x1

    goto :goto_2a

    :cond_58
    add-int/2addr v3, v1

    :cond_59
    if-lt v3, v0, :cond_5c

    return v3

    :cond_5c
    int-to-long v0, v3

    new-instance p0, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "UTF-8 length does not fit in int: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-wide v3, 0x100000000L

    add-long/2addr v0, v3

    invoke-virtual {v2, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method static zzd([B)Z
    .registers 4

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhs;->zzb:Lcom/google/android/gms/internal/play_billing/zzhp;

    array-length v1, p0

    const/4 v2, 0x0

    invoke-virtual {v0, p0, v2, v1}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzb([BII)Z

    move-result p0

    return p0
.end method

.method static zze([BII)Z
    .registers 4

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhs;->zzb:Lcom/google/android/gms/internal/play_billing/zzhp;

    invoke-virtual {v0, p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzhp;->zzb([BII)Z

    move-result p0

    return p0
.end method
