.class public final Lcom/google/android/gms/location/zzai;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static zza(I)Ljava/lang/String;
    .registers 2

    if-eqz p0, :cond_14

    const/4 v0, 0x1

    if-eq p0, v0, :cond_11

    const/4 v0, 0x2

    if-ne p0, v0, :cond_b

    const-string p0, "THROTTLE_NEVER"

    return-object p0

    :cond_b
    new-instance p0, Ljava/lang/IllegalArgumentException;

    invoke-direct {p0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw p0

    :cond_11
    const-string p0, "THROTTLE_ALWAYS"

    return-object p0

    :cond_14
    const-string p0, "THROTTLE_BACKGROUND"

    return-object p0
.end method
