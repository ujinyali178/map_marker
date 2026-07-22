.class public Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;
.super Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;
.source "SourceFile"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field zza:Ljava/lang/String;

.field private final zzb:Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;

.field private final zzc:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/google/android/gms/fido/u2f/api/common/zzj;

    invoke-direct {v0}, Lcom/google/android/gms/fido/u2f/api/common/zzj;-><init>()V

    sput-object v0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;)V
    .registers 3

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, v0}, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;-><init>(Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;Ljava/lang/String;Ljava/lang/String;)V
    .registers 4

    invoke-direct {p0}, Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;-><init>()V

    invoke-static {p1}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;

    iput-object p1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzb:Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;

    iput-object p2, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zza:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzc:Ljava/lang/String;

    return-void
.end method

.method public static parseFromJson(Lorg/json/JSONObject;)Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;
    .registers 6

    const-string v0, "challenge"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    const/4 v2, 0x0

    if-eqz v1, :cond_e

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_f

    :cond_e
    move-object v0, v2

    :goto_f
    invoke-static {p0}, Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;->parseFromJson(Lorg/json/JSONObject;)Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;

    move-result-object v1

    const-string v3, "appId"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1f

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    :cond_1f
    new-instance p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;

    invoke-direct {p0, v1, v0, v2}, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;-><init>(Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;Ljava/lang/String;Ljava/lang/String;)V

    return-object p0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zza:Ljava/lang/String;

    if-nez v1, :cond_16

    iget-object v1, p1, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zza:Ljava/lang/String;

    if-nez v1, :cond_15

    goto :goto_1f

    :cond_15
    return v2

    :cond_16
    iget-object v3, p1, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zza:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1f

    return v2

    :cond_1f
    :goto_1f
    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzb:Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;

    iget-object v3, p1, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzb:Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;

    invoke-virtual {v1, v3}, Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2a

    return v2

    :cond_2a
    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzc:Ljava/lang/String;

    iget-object p1, p1, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzc:Ljava/lang/String;

    if-nez v1, :cond_33

    if-eqz p1, :cond_3a

    return v2

    :cond_33
    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_3a

    return v2

    :cond_3a
    return v0
.end method

.method public getAppId()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzc:Ljava/lang/String;

    return-object v0
.end method

.method public getChallengeValue()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zza:Ljava/lang/String;

    return-object v0
.end method

.method public getKeyHandle()Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzb:Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;

    return-object v0
.end method

.method public hashCode()I
    .registers 4

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zza:Ljava/lang/String;

    const/4 v1, 0x0

    if-nez v0, :cond_7

    const/4 v0, 0x0

    goto :goto_b

    :cond_7
    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_b
    iget-object v2, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzb:Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;

    add-int/lit8 v0, v0, 0x1f

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {v2}, Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;->hashCode()I

    move-result v2

    add-int/2addr v0, v2

    iget-object v2, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzc:Ljava/lang/String;

    if-nez v2, :cond_1b

    goto :goto_1f

    :cond_1b
    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_1f
    mul-int/lit8 v0, v0, 0x1f

    add-int/2addr v0, v1

    return v0
.end method

.method public toJson()Lorg/json/JSONObject;
    .registers 6

    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    :try_start_5
    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zza:Ljava/lang/String;

    if-eqz v1, :cond_e

    const-string v2, "challenge"

    invoke-virtual {v0, v2, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    :cond_e
    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzb:Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;

    invoke-virtual {v1}, Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;->zza()Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {v1}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v2

    :goto_18
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2c

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_18

    :cond_2c
    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzc:Ljava/lang/String;

    if-eqz v1, :cond_35

    const-string v2, "appId"

    invoke-virtual {v0, v2, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_35
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_35} :catch_36

    :cond_35
    return-object v0

    :catch_36
    move-exception v0

    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public toString()Ljava/lang/String;
    .registers 5

    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    const-string v1, "keyHandle"

    iget-object v2, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzb:Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;

    invoke-virtual {v2}, Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;->getBytes()[B

    move-result-object v2

    const/16 v3, 0xb

    invoke-static {v2, v3}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzb:Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;

    invoke-virtual {v1}, Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;->getProtocolVersion()Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    move-result-object v1

    sget-object v2, Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;->UNKNOWN:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    if-eq v1, v2, :cond_2f

    const-string v1, "version"

    iget-object v2, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzb:Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;

    invoke-virtual {v2}, Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;->getProtocolVersion()Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    :cond_2f
    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzb:Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;

    invoke-virtual {v1}, Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;->getTransports()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_46

    const-string v1, "transports"

    iget-object v2, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzb:Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;

    invoke-virtual {v2}, Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;->getTransports()Ljava/util/List;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    :cond_46
    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zza:Ljava/lang/String;

    if-eqz v1, :cond_4f

    const-string v2, "challenge"

    invoke-virtual {v0, v2, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    :cond_4f
    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->zzc:Ljava/lang/String;

    if-eqz v1, :cond_58

    const-string v2, "appId"

    invoke-virtual {v0, v2, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    :cond_58
    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0
    :try_end_5c
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_5c} :catch_5d

    return-object v0

    :catch_5d
    move-exception v0

    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 7

    invoke-static {p1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->beginObjectHeader(Landroid/os/Parcel;)I

    move-result v0

    invoke-virtual {p0}, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->getKeyHandle()Lcom/google/android/gms/fido/u2f/api/common/KeyHandle;

    move-result-object v1

    const/4 v2, 0x2

    const/4 v3, 0x0

    invoke-static {p1, v2, v1, p2, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeParcelable(Landroid/os/Parcel;ILandroid/os/Parcelable;IZ)V

    invoke-virtual {p0}, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->getChallengeValue()Ljava/lang/String;

    move-result-object p2

    const/4 v1, 0x3

    invoke-static {p1, v1, p2, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeString(Landroid/os/Parcel;ILjava/lang/String;Z)V

    invoke-virtual {p0}, Lcom/google/android/gms/fido/u2f/api/common/RegisteredKey;->getAppId()Ljava/lang/String;

    move-result-object p2

    const/4 v1, 0x4

    invoke-static {p1, v1, p2, v3}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeString(Landroid/os/Parcel;ILjava/lang/String;Z)V

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->finishObjectHeader(Landroid/os/Parcel;I)V

    return-void
.end method
