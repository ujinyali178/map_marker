.class public Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;
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
            "Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;",
            ">;"
        }
    .end annotation
.end field

.field public static final U2F_V1_CHALLENGE_BYTE_LENGTH:I = 0x41


# instance fields
.field private final zza:I

.field private final zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

.field private final zzc:[B

.field private final zzd:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/google/android/gms/fido/u2f/api/common/zzg;

    invoke-direct {v0}, Lcom/google/android/gms/fido/u2f/api/common/zzg;-><init>()V

    sput-object v0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method constructor <init>(ILjava/lang/String;[BLjava/lang/String;)V
    .registers 5

    invoke-direct {p0}, Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;-><init>()V

    iput p1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zza:I

    :try_start_5
    invoke-static {p2}, Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;->fromString(Ljava/lang/String;)Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;
    :try_end_b
    .catch Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion$UnsupportedProtocolException; {:try_start_5 .. :try_end_b} :catch_10

    iput-object p3, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzc:[B

    iput-object p4, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzd:Ljava/lang/String;

    return-void

    :catch_10
    move-exception p1

    new-instance p2, Ljava/lang/IllegalArgumentException;

    invoke-direct {p2, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/Throwable;)V

    throw p2
.end method

.method public constructor <init>(Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;[BLjava/lang/String;)V
    .registers 6

    invoke-direct {p0}, Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;-><init>()V

    const/4 v0, 0x1

    iput v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zza:I

    invoke-static {p1}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    iput-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    invoke-static {p2}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [B

    iput-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzc:[B

    sget-object v1, Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;->V1:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    if-ne p1, v1, :cond_26

    array-length p1, p2

    const/16 p2, 0x41

    if-ne p1, p2, :cond_20

    goto :goto_21

    :cond_20
    const/4 v0, 0x0

    :goto_21
    const-string p1, "invalid challengeValue length for V1"

    invoke-static {v0, p1}, Lcom/google/android/gms/common/internal/Preconditions;->checkArgument(ZLjava/lang/Object;)V

    :cond_26
    iput-object p3, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzd:Ljava/lang/String;

    return-void
.end method

.method public static parseFromJson(Lorg/json/JSONObject;)Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;
    .registers 6

    const-string v0, "version"

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
    :try_start_f
    invoke-static {v0}, Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;->fromString(Ljava/lang/String;)Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    move-result-object v0
    :try_end_13
    .catch Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion$UnsupportedProtocolException; {:try_start_f .. :try_end_13} :catch_47

    const-string v1, "challenge"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const/16 v3, 0x8

    :try_start_1b
    invoke-static {v1, v3}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v1
    :try_end_1f
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1b .. :try_end_1f} :catch_3c

    const-string v3, "appId"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2b

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    :cond_2b
    :try_start_2b
    new-instance p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;

    invoke-direct {p0, v0, v1, v2}, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;-><init>(Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;[BLjava/lang/String;)V
    :try_end_30
    .catch Ljava/lang/IllegalArgumentException; {:try_start_2b .. :try_end_30} :catch_31

    return-object p0

    :catch_31
    move-exception p0

    new-instance v0, Lorg/json/JSONException;

    invoke-virtual {p0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v0

    :catch_3c
    move-exception p0

    new-instance v0, Lorg/json/JSONException;

    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v0

    :catch_47
    move-exception p0

    new-instance v0, Lorg/json/JSONException;

    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzc:[B

    iget-object v3, p1, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzc:[B

    invoke-static {v1, v3}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v1

    if-nez v1, :cond_17

    return v2

    :cond_17
    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    iget-object v3, p1, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    if-eq v1, v3, :cond_1e

    return v2

    :cond_1e
    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzd:Ljava/lang/String;

    iget-object p1, p1, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzd:Ljava/lang/String;

    if-nez v1, :cond_27

    if-eqz p1, :cond_2e

    return v2

    :cond_27
    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_2e

    return v2

    :cond_2e
    return v0
.end method

.method public getAppId()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzd:Ljava/lang/String;

    return-object v0
.end method

.method public getChallengeValue()[B
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzc:[B

    return-object v0
.end method

.method public getProtocolVersion()Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    return-object v0
.end method

.method public getVersionCode()I
    .registers 2

    iget v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zza:I

    return v0
.end method

.method public hashCode()I
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzc:[B

    invoke-static {v0}, Ljava/util/Arrays;->hashCode([B)I

    move-result v0

    add-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    mul-int/lit8 v0, v0, 0x1f

    add-int/2addr v0, v1

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzd:Ljava/lang/String;

    if-nez v1, :cond_17

    const/4 v1, 0x0

    goto :goto_1b

    :cond_17
    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_1b
    mul-int/lit8 v0, v0, 0x1f

    add-int/2addr v0, v1

    return v0
.end method

.method public toJson()Lorg/json/JSONObject;
    .registers 5

    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    :try_start_5
    const-string v1, "version"

    iget-object v2, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    invoke-virtual {v2}, Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    const-string v1, "challenge"

    iget-object v2, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzc:[B

    const/16 v3, 0xb

    invoke-static {v2, v3}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzd:Ljava/lang/String;

    if-eqz v1, :cond_26

    const-string v2, "appId"

    invoke-virtual {v0, v2, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_26
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_26} :catch_27

    :cond_26
    return-object v0

    :catch_27
    move-exception v0

    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 6

    invoke-static {p1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->beginObjectHeader(Landroid/os/Parcel;)I

    move-result p2

    invoke-virtual {p0}, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->getVersionCode()I

    move-result v0

    const/4 v1, 0x1

    invoke-static {p1, v1, v0}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeInt(Landroid/os/Parcel;II)V

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    invoke-virtual {v0}, Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x2

    const/4 v2, 0x0

    invoke-static {p1, v1, v0, v2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeString(Landroid/os/Parcel;ILjava/lang/String;Z)V

    invoke-virtual {p0}, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->getChallengeValue()[B

    move-result-object v0

    const/4 v1, 0x3

    invoke-static {p1, v1, v0, v2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeByteArray(Landroid/os/Parcel;I[BZ)V

    invoke-virtual {p0}, Lcom/google/android/gms/fido/u2f/api/common/RegisterRequest;->getAppId()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x4

    invoke-static {p1, v1, v0, v2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeString(Landroid/os/Parcel;ILjava/lang/String;Z)V

    invoke-static {p1, p2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->finishObjectHeader(Landroid/os/Parcel;I)V

    return-void
.end method
