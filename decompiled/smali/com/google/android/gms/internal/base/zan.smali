.class final Lcom/google/android/gms/internal/base/zan;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method static zaa()Z
    .registers 3

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x21

    if-ge v0, v1, :cond_13

    sget-object v0, Landroid/os/Build$VERSION;->CODENAME:Ljava/lang/String;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v2, 0x54

    if-ne v0, v2, :cond_12

    goto :goto_13

    :cond_12
    return v1

    :cond_13
    :goto_13
    const/4 v0, 0x1

    return v0
.end method
