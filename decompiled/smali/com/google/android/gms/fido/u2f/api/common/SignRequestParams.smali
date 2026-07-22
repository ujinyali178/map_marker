.class public Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;
.super Lcom/google/android/gms/fido/u2f/api/common/RequestParams;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams$Builder;
    }
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;",
            ">;"
        }
    .end annotation
.end field

.field public static final MAX_DISPLAY_HINT_LENGTH:I = 0x50


# instance fields
.field private final zza:Ljava/lang/Integer;

.field private final zzb:Ljava/lang/Double;

.field private final zzc:Landroid/net/Uri;

.field private final zzd:[B

.field private final zze:Ljava/util/List;

.field private final zzf:Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;

.field private final zzg:Ljava/lang/String;

.field private final zzh:Ljava/util/Set;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/google/android/gms/fido/u2f/api/common/zzk;

    invoke-direct {v0}, Lcom/google/android/gms/fido/u2f/api/common/zzk;-><init>()V

    sput-object v0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method constructor <init>(Ljava/lang/Integer;Ljava/lang/Double;Landroid/net/Uri;[BLjava/util/List;Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;Ljava/lang/String;)V
    .registers 10

    invoke-direct {p0}, Lcom/google/android/gms/fido/u2f/api/common/RequestParams;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zza:Ljava/lang/Integer;

    iput-object p2, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzb:Ljava/lang/Double;

    iput-object p3, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzc:Landroid/net/Uri;

    iput-object p4, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzd:[B

    const/4 p1, 0x0

    const/4 p2, 0x1

    if-eqz p5, :cond_17

    invoke-interface {p5}, Ljava/util/List;->isEmpty()Z

    move-result p4

    if-nez p4, :cond_17

    const/4 p4, 0x1

    goto :goto_18

    :cond_17
    const/4 p4, 0x0

    :goto_18
    const-string v0, "registeredKeys must not be null or empty"

    invoke-static {p4, v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkArgument(ZLjava/lang/Object;)V

    iput-object p5, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zze:Ljava/util/List;

    iput-object p6, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzf:Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;

    new-instance p4, Ljava/util/HashSet;

    invoke-direct {p4}, Ljava/util/HashSet;-><init>()V

    if-eqz p3, :cond_2b

    invoke-interface {p4, p3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    :cond_2b
    invoke-interface {p5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p5

    :cond_2f
    :goto_2f
    invoke-interface {p5}, Ljava/util/Iterator;->hasNext()Z

    move-result p6

    if-eqz p6, :cond_67

    invoke-interface {p5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p6

    check-cast p6, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;

    invoke-virtual {p6}, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->getAppId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_46

    if-eqz p3, :cond_44

    goto :goto_46

    :cond_44
    const/4 v0, 0x0

    goto :goto_47

    :cond_46
    :goto_46
    const/4 v0, 0x1

    :goto_47
    const-string v1, "registered key has null appId and no request appId is provided"

    invoke-static {v0, v1}, Lcom/google/android/gms/common/internal/Preconditions;->checkArgument(ZLjava/lang/Object;)V

    invoke-virtual {p6}, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->getChallengeValue()Ljava/lang/String;

    move-result-object v0

    const-string v0, "register request has null challenge and no default challenge isprovided"

    invoke-static {p2, v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkArgument(ZLjava/lang/Object;)V

    invoke-virtual {p6}, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->getAppId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2f

    invoke-virtual {p6}, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->getAppId()Ljava/lang/String;

    move-result-object p6

    invoke-static {p6}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object p6

    invoke-interface {p4, p6}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_2f

    :cond_67
    iput-object p4, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzh:Ljava/util/Set;

    if-eqz p7, :cond_73

    invoke-virtual {p7}, Ljava/lang/String;->length()I

    move-result p3

    const/16 p4, 0x50

    if-gt p3, p4, :cond_74

    :cond_73
    const/4 p1, 0x1

    :cond_74
    const-string p2, "Display Hint cannot be longer than 80 characters"

    invoke-static {p1, p2}, Lcom/google/android/gms/common/internal/Preconditions;->checkArgument(ZLjava/lang/Object;)V

    iput-object p7, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzg:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zza:Ljava/lang/Integer;

    iget-object v3, p1, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zza:Ljava/lang/Integer;

    invoke-static {v1, v3}, Lcom/google/android/gms/common/internal/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5d

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzb:Ljava/lang/Double;

    iget-object v3, p1, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzb:Ljava/lang/Double;

    invoke-static {v1, v3}, Lcom/google/android/gms/common/internal/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5d

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzc:Landroid/net/Uri;

    iget-object v3, p1, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzc:Landroid/net/Uri;

    invoke-static {v1, v3}, Lcom/google/android/gms/common/internal/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5d

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzd:[B

    iget-object v3, p1, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzd:[B

    invoke-static {v1, v3}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v1

    if-eqz v1, :cond_5d

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zze:Ljava/util/List;

    iget-object v3, p1, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zze:Ljava/util/List;

    invoke-interface {v1, v3}, Ljava/util/List;->containsAll(Ljava/util/Collection;)Z

    move-result v1

    if-eqz v1, :cond_5d

    iget-object v1, p1, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zze:Ljava/util/List;

    iget-object v3, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zze:Ljava/util/List;

    invoke-interface {v1, v3}, Ljava/util/List;->containsAll(Ljava/util/Collection;)Z

    move-result v1

    if-eqz v1, :cond_5d

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzf:Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;

    iget-object v3, p1, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzf:Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;

    invoke-static {v1, v3}, Lcom/google/android/gms/common/internal/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5d

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzg:Ljava/lang/String;

    iget-object p1, p1, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzg:Ljava/lang/String;

    invoke-static {v1, p1}, Lcom/google/android/gms/common/internal/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_5d

    return v0

    :cond_5d
    return v2
.end method

.method public getAllAppIds()Ljava/util/Set;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set<",
            "Landroid/net/Uri;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzh:Ljava/util/Set;

    return-object v0
.end method

.method public getAppId()Landroid/net/Uri;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzc:Landroid/net/Uri;

    return-object v0
.end method

.method public getChannelIdValue()Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzf:Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;

    return-object v0
.end method

.method public getDefaultSignChallenge()[B
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzd:[B

    return-object v0
.end method

.method public getDisplayHint()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzg:Ljava/lang/String;

    return-object v0
.end method

.method public getRegisteredKeys()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zze:Ljava/util/List;

    return-object v0
.end method

.method public getRequestId()Ljava/lang/Integer;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zza:Ljava/lang/Integer;

    return-object v0
.end method

.method public getTimeoutSeconds()Ljava/lang/Double;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzb:Ljava/lang/Double;

    return-object v0
.end method

.method public hashCode()I
    .registers 4

    const/4 v0, 0x7

    new-array v0, v0, [Ljava/lang/Object;

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zza:Ljava/lang/Integer;

    const/4 v2, 0x0

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzc:Landroid/net/Uri;

    const/4 v2, 0x1

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzb:Ljava/lang/Double;

    const/4 v2, 0x2

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zze:Ljava/util/List;

    const/4 v2, 0x3

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzf:Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;

    const/4 v2, 0x4

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzg:Ljava/lang/String;

    const/4 v2, 0x5

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->zzd:[B

    invoke-static {v1}, Ljava/util/Arrays;->hashCode([B)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const/4 v2, 0x6

    aput-object v1, v0, v2

    invoke-static {v0}, Lcom/google/android/gms/common/internal/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 7

    invoke-static {p1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->beginObjectHeader(Landroid/os/Parcel;)I

    move-result v0

    invoke-virtual {p0}, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->getRequestId()Ljava/lang/Integer;

    move-result-object v1

    const/4 v2, 0x2

    const/4 v3, 0x0

    invoke-static {p1, v2, v1, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeIntegerObject(Landroid/os/Parcel;ILjava/lang/Integer;Z)V

    invoke-virtual {p0}, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->getTimeoutSeconds()Ljava/lang/Double;

    move-result-object v1

    const/4 v2, 0x3

    invoke-static {p1, v2, v1, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeDoubleObject(Landroid/os/Parcel;ILjava/lang/Double;Z)V

    invoke-virtual {p0}, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->getAppId()Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x4

    invoke-static {p1, v2, v1, p2, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeParcelable(Landroid/os/Parcel;ILandroid/os/Parcelable;IZ)V

    invoke-virtual {p0}, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->getDefaultSignChallenge()[B

    move-result-object v1

    const/4 v2, 0x5

    invoke-static {p1, v2, v1, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeByteArray(Landroid/os/Parcel;I[BZ)V

    invoke-virtual {p0}, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->getRegisteredKeys()Ljava/util/List;

    move-result-object v1

    const/4 v2, 0x6

    invoke-static {p1, v2, v1, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeTypedList(Landroid/os/Parcel;ILjava/util/List;Z)V

    invoke-virtual {p0}, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->getChannelIdValue()Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;

    move-result-object v1

    const/4 v2, 0x7

    invoke-static {p1, v2, v1, p2, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeParcelable(Landroid/os/Parcel;ILandroid/os/Parcelable;IZ)V

    invoke-virtual {p0}, Lcom/google/android/gms/fido/u2f/api/common/SignRequestParams;->getDisplayHint()Ljava/lang/String;

    move-result-object p2

    const/16 v1, 0x8

    invoke-static {p1, v1, p2, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeString(Landroid/os/Parcel;ILjava/lang/String;Z)V

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->finishObjectHeader(Landroid/os/Parcel;I)V

    return-void
.end method
