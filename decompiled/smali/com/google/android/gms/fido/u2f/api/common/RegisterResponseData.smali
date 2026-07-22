.class public Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;
.super Lcom/google/android/gms/fido/u2f/api/common/ResponseData;
.source "SourceFile"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final zza:[B

.field private final zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

.field private final zzc:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/google/android/gms/fido/u2f/api/common/zzi;

    invoke-direct {v0}, Lcom/google/android/gms/fido/u2f/api/common/zzi;-><init>()V

    sput-object v0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>([B)V
    .registers 2

    invoke-direct {p0}, Lcom/google/android/gms/fido/u2f/api/common/ResponseData;-><init>()V

    invoke-static {p1}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [B

    iput-object p1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zza:[B

    sget-object p1, Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;->V1:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    iput-object p1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    const/4 p1, 0x0

    iput-object p1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzc:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>([BLcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;Ljava/lang/String;)V
    .registers 6

    invoke-direct {p0}, Lcom/google/android/gms/fido/u2f/api/common/ResponseData;-><init>()V

    invoke-static {p1}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [B

    iput-object p1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zza:[B

    invoke-static {p2}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    iput-object p1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    sget-object p1, Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;->UNKNOWN:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-eq p2, p1, :cond_1b

    const/4 p1, 0x1

    goto :goto_1c

    :cond_1b
    const/4 p1, 0x0

    :goto_1c
    invoke-static {p1}, Lcom/google/android/gms/common/internal/Preconditions;->checkArgument(Z)V

    sget-object p1, Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;->V1:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    if-ne p2, p1, :cond_2e

    if-nez p3, :cond_26

    goto :goto_27

    :cond_26
    const/4 v0, 0x0

    :goto_27
    invoke-static {v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkArgument(Z)V

    const/4 p1, 0x0

    :goto_2b
    iput-object p1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzc:Ljava/lang/String;

    return-void

    :cond_2e
    invoke-static {p3}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    goto :goto_2b
.end method

.method constructor <init>([BLjava/lang/String;Ljava/lang/String;)V
    .registers 4

    invoke-direct {p0}, Lcom/google/android/gms/fido/u2f/api/common/ResponseData;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zza:[B

    :try_start_5
    invoke-static {p2}, Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;->fromString(Ljava/lang/String;)Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;
    :try_end_b
    .catch Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion$UnsupportedProtocolException; {:try_start_5 .. :try_end_b} :catch_e

    iput-object p3, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzc:Ljava/lang/String;

    return-void

    :catch_e
    move-exception p1

    new-instance p2, Ljava/lang/IllegalArgumentException;

    invoke-direct {p2, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/Throwable;)V

    throw p2
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 5

    instance-of v0, p1, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;

    const/4 v1, 0x0

    if-nez v0, :cond_6

    return v1

    :cond_6
    check-cast p1, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    iget-object v2, p1, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    invoke-static {v0, v2}, Lcom/google/android/gms/common/internal/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_28

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zza:[B

    iget-object v2, p1, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zza:[B

    invoke-static {v0, v2}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v0

    if-eqz v0, :cond_28

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzc:Ljava/lang/String;

    iget-object p1, p1, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzc:Ljava/lang/String;

    invoke-static {v0, p1}, Lcom/google/android/gms/common/internal/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_28

    const/4 p1, 0x1

    return p1

    :cond_28
    return v1
.end method

.method public getClientDataString()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzc:Ljava/lang/String;

    return-object v0
.end method

.method public getProtocolVersion()Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    return-object v0
.end method

.method public getRegisterData()[B
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zza:[B

    return-object v0
.end method

.method public getVersionCode()I
    .registers 3

    sget-object v0, Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;->UNKNOWN:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    invoke-virtual {v0}, Ljava/lang/Enum;->ordinal()I

    move-result v0

    const/4 v1, 0x1

    if-eq v0, v1, :cond_10

    const/4 v1, 0x2

    if-eq v0, v1, :cond_10

    const/4 v0, -0x1

    return v0

    :cond_10
    return v1
.end method

.method public hashCode()I
    .registers 4

    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/Object;

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    const/4 v2, 0x0

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zza:[B

    invoke-static {v1}, Ljava/util/Arrays;->hashCode([B)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const/4 v2, 0x1

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzc:Ljava/lang/String;

    const/4 v2, 0x2

    aput-object v1, v0, v2

    invoke-static {v0}, Lcom/google/android/gms/common/internal/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public toJsonObject()Lorg/json/JSONObject;
    .registers 5

    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    const-string v1, "registrationData"

    iget-object v2, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zza:[B

    const/16 v3, 0xb

    invoke-static {v2, v3}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    const-string v1, "version"

    iget-object v2, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    invoke-virtual {v2}, Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzc:Ljava/lang/String;

    if-eqz v1, :cond_2e

    const-string v2, "clientData"

    invoke-virtual {v1}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    invoke-static {v1, v3}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_2e
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_2e} :catch_2f

    :cond_2e
    return-object v0

    :catch_2f
    move-exception v0

    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public toString()Ljava/lang/String;
    .registers 6

    invoke-static {p0}, Lcom/google/android/gms/internal/fido/zzak;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/fido/zzaj;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    const-string v2, "protocolVersion"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/internal/fido/zzaj;->zzb(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/fido/zzaj;

    invoke-static {}, Lcom/google/android/gms/internal/fido/zzbf;->zzd()Lcom/google/android/gms/internal/fido/zzbf;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zza:[B

    array-length v3, v2

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v4, v3}, Lcom/google/android/gms/internal/fido/zzbf;->zze([BII)Ljava/lang/String;

    move-result-object v1

    const-string v2, "registerData"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/internal/fido/zzaj;->zzb(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/fido/zzaj;

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzc:Ljava/lang/String;

    if-eqz v1, :cond_25

    const-string v2, "clientDataString"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/internal/fido/zzaj;->zzb(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/fido/zzaj;

    :cond_25
    invoke-virtual {v0}, Lcom/google/android/gms/internal/fido/zzaj;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 6

    invoke-static {p1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->beginObjectHeader(Landroid/os/Parcel;)I

    move-result p2

    invoke-virtual {p0}, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->getRegisterData()[B

    move-result-object v0

    const/4 v1, 0x2

    const/4 v2, 0x0

    invoke-static {p1, v1, v0, v2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeByteArray(Landroid/os/Parcel;I[BZ)V

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->zzb:Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;

    invoke-virtual {v0}, Lcom/google/android/gms/fido/u2f/api/common/ProtocolVersion;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x3

    invoke-static {p1, v1, v0, v2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeString(Landroid/os/Parcel;ILjava/lang/String;Z)V

    invoke-virtual {p0}, Lcom/google/android/gms/fido/u2f/api/common/RegisterResponseData;->getClientDataString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x4

    invoke-static {p1, v1, v0, v2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeString(Landroid/os/Parcel;ILjava/lang/String;Z)V

    invoke-static {p1, p2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->finishObjectHeader(Landroid/os/Parcel;I)V

    return-void
.end method
