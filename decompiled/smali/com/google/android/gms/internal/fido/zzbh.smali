.class public final Lcom/google/android/gms/internal/fido/zzbh;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static zza(IILjava/math/RoundingMode;)I
    .registers 8

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    if-eqz p1, :cond_54

    div-int v0, p0, p1

    mul-int v1, p1, v0

    sub-int v1, p0, v1

    if-nez v1, :cond_e

    return v0

    :cond_e
    xor-int/2addr p0, p1

    sget-object v2, Lcom/google/android/gms/internal/fido/zzbg;->zza:[I

    invoke-virtual {p2}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    shr-int/lit8 p0, p0, 0x1f

    const/4 v3, 0x1

    or-int/2addr p0, v3

    const/4 v4, 0x0

    packed-switch v2, :pswitch_data_5c

    new-instance p0, Ljava/lang/AssertionError;

    invoke-direct {p0}, Ljava/lang/AssertionError;-><init>()V

    throw p0

    :pswitch_25
    invoke-static {v1}, Ljava/lang/Math;->abs(I)I

    move-result v1

    invoke-static {p1}, Ljava/lang/Math;->abs(I)I

    move-result p1

    sub-int/2addr p1, v1

    sub-int/2addr v1, p1

    if-nez v1, :cond_42

    sget-object p1, Ljava/math/RoundingMode;->HALF_UP:Ljava/math/RoundingMode;

    if-eq p2, p1, :cond_4c

    sget-object p1, Ljava/math/RoundingMode;->HALF_EVEN:Ljava/math/RoundingMode;

    if-ne p2, p1, :cond_3b

    const/4 p1, 0x1

    goto :goto_3c

    :cond_3b
    const/4 p1, 0x0

    :goto_3c
    and-int/lit8 p2, v0, 0x1

    and-int/2addr p1, p2

    if-eqz p1, :cond_4b

    goto :goto_4c

    :cond_42
    if-lez v1, :cond_4b

    goto :goto_4c

    :pswitch_45
    if-lez p0, :cond_4b

    goto :goto_4c

    :pswitch_48
    if-gez p0, :cond_4b

    goto :goto_4c

    :cond_4b
    const/4 v3, 0x0

    :cond_4c
    :goto_4c
    if-eqz v3, :cond_53

    :pswitch_4e
    add-int/2addr v0, p0

    return v0

    :pswitch_50
    invoke-static {v4}, Lcom/google/android/gms/internal/fido/zzbi;->zza(Z)V

    :cond_53
    :pswitch_53
    return v0

    :cond_54
    new-instance p0, Ljava/lang/ArithmeticException;

    const-string p1, "/ by zero"

    invoke-direct {p0, p1}, Ljava/lang/ArithmeticException;-><init>(Ljava/lang/String;)V

    throw p0

    :pswitch_data_5c
    .packed-switch 0x1
        :pswitch_50
        :pswitch_53
        :pswitch_48
        :pswitch_4e
        :pswitch_45
        :pswitch_25
        :pswitch_25
        :pswitch_25
    .end packed-switch
.end method

.method public static zzb(ILjava/math/RoundingMode;)I
    .registers 3

    if-lez p0, :cond_3d

    sget-object v0, Lcom/google/android/gms/internal/fido/zzbg;->zza:[I

    invoke-virtual {p1}, Ljava/lang/Enum;->ordinal()I

    move-result p1

    aget p1, v0, p1

    packed-switch p1, :pswitch_data_46

    new-instance p0, Ljava/lang/AssertionError;

    invoke-direct {p0}, Ljava/lang/AssertionError;-><init>()V

    throw p0

    :pswitch_13
    const p1, -0x4afb0ccd

    invoke-static {p0}, Ljava/lang/Integer;->numberOfLeadingZeros(I)I

    move-result v0

    ushr-int/2addr p1, v0

    rsub-int/lit8 v0, v0, 0x1f

    sub-int/2addr p1, p0

    ushr-int/lit8 p0, p1, 0x1f

    add-int/2addr v0, p0

    return v0

    :pswitch_22
    add-int/lit8 p0, p0, -0x1

    invoke-static {p0}, Ljava/lang/Integer;->numberOfLeadingZeros(I)I

    move-result p0

    rsub-int/lit8 p0, p0, 0x20

    return p0

    :pswitch_2b
    add-int/lit8 p1, p0, -0x1

    and-int/2addr p1, p0

    if-nez p1, :cond_32

    const/4 p1, 0x1

    goto :goto_33

    :cond_32
    const/4 p1, 0x0

    :goto_33
    invoke-static {p1}, Lcom/google/android/gms/internal/fido/zzbi;->zza(Z)V

    :pswitch_36
    invoke-static {p0}, Ljava/lang/Integer;->numberOfLeadingZeros(I)I

    move-result p0

    rsub-int/lit8 p0, p0, 0x1f

    return p0

    :cond_3d
    new-instance p0, Ljava/lang/IllegalArgumentException;

    const-string p1, "x (0) must be > 0"

    invoke-direct {p0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0

    nop

    :pswitch_data_46
    .packed-switch 0x1
        :pswitch_2b
        :pswitch_36
        :pswitch_36
        :pswitch_22
        :pswitch_22
        :pswitch_13
        :pswitch_13
        :pswitch_13
    .end packed-switch
.end method
