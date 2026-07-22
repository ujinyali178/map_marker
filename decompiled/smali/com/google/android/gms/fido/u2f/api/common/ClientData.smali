.class public Lcom/google/android/gms/fido/u2f/api/common/ClientData;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/fido/u2f/api/common/ClientData$Builder;
    }
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field public static final KEY_CHALLENGE:Ljava/lang/String; = "challenge"

.field public static final KEY_CID_PUBKEY:Ljava/lang/String; = "cid_pubkey"

.field public static final KEY_ORIGIN:Ljava/lang/String; = "origin"

.field public static final KEY_TYPE:Ljava/lang/String; = "typ"

.field public static final TYPE_FINISH_ENROLLMENT:Ljava/lang/String; = "navigator.id.finishEnrollment"

.field public static final TYPE_GET_ASSERTION:Ljava/lang/String; = "navigator.id.getAssertion"


# instance fields
.field private final zza:Ljava/lang/String;

.field private final zzb:Ljava/lang/String;

.field private final zzc:Ljava/lang/String;

.field private final zzd:Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    iput-object p1, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zza:Ljava/lang/String;

    invoke-static {p2}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    iput-object p1, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zzb:Ljava/lang/String;

    invoke-static {p3}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    iput-object p1, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zzc:Ljava/lang/String;

    invoke-static {p4}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;

    iput-object p1, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zzd:Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lcom/google/android/gms/fido/u2f/api/common/ClientData;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lcom/google/android/gms/fido/u2f/api/common/ClientData;

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zza:Ljava/lang/String;

    iget-object v3, p1, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zza:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_35

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zzb:Ljava/lang/String;

    iget-object v3, p1, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zzb:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_35

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zzc:Ljava/lang/String;

    iget-object v3, p1, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zzc:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_35

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zzd:Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;

    iget-object p1, p1, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zzd:Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;

    invoke-virtual {v1, p1}, Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_35

    return v0

    :cond_35
    return v2
.end method

.method public hashCode()I
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zza:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    add-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zzb:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    mul-int/lit8 v0, v0, 0x1f

    add-int/2addr v0, v1

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zzc:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    mul-int/lit8 v0, v0, 0x1f

    add-int/2addr v0, v1

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zzd:Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;

    invoke-virtual {v1}, Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;->hashCode()I

    move-result v1

    mul-int/lit8 v0, v0, 0x1f

    add-int/2addr v0, v1

    return v0
.end method

.method public toJsonString()Ljava/lang/String;
    .registers 5

    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    :try_start_5
    const-string v1, "typ"

    iget-object v2, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zza:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    const-string v1, "challenge"

    iget-object v2, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zzb:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    const-string v1, "origin"

    iget-object v2, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zzc:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    sget-object v1, Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue$ChannelIdValueType;->ABSENT:Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue$ChannelIdValueType;

    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zzd:Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;

    invoke-virtual {v1}, Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;->getType()Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue$ChannelIdValueType;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1
    :try_end_26
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_26} :catch_45

    const/4 v2, 0x1

    const-string v3, "cid_pubkey"

    if-eq v1, v2, :cond_39

    const/4 v2, 0x2

    if-eq v1, v2, :cond_2f

    goto :goto_40

    :cond_2f
    :try_start_2f
    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zzd:Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;

    invoke-virtual {v1}, Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;->getObjectValue()Lorg/json/JSONObject;

    move-result-object v1

    :goto_35
    invoke-virtual {v0, v3, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_40

    :cond_39
    iget-object v1, p0, Lcom/google/android/gms/fido/u2f/api/common/ClientData;->zzd:Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;

    invoke-virtual {v1}, Lcom/google/android/gms/fido/u2f/api/common/ChannelIdValue;->getStringValue()Ljava/lang/String;

    move-result-object v1
    :try_end_3f
    .catch Lorg/json/JSONException; {:try_start_2f .. :try_end_3f} :catch_45

    goto :goto_35

    :goto_40
    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :catch_45
    move-exception v0

    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method
