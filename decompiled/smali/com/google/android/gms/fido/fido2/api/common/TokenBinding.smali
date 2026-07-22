.class public Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;
.super Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;,
        Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$UnsupportedTokenBindingStatusException;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;",
            ">;"
        }
    .end annotation
.end field

.field public static final NOT_SUPPORTED:Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;

.field public static final SUPPORTED:Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;


# instance fields
.field private final zza:Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;

.field private final zzb:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    new-instance v0, Lcom/google/android/gms/fido/fido2/api/common/zzau;

    invoke-direct {v0}, Lcom/google/android/gms/fido/fido2/api/common/zzau;-><init>()V

    sput-object v0, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;->CREATOR:Landroid/os/Parcelable$Creator;

    new-instance v0, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;

    sget-object v1, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;->SUPPORTED:Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;

    invoke-virtual {v1}, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;->SUPPORTED:Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;

    new-instance v0, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;

    sget-object v1, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;->NOT_SUPPORTED:Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;

    invoke-virtual {v1}, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;->NOT_SUPPORTED:Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 3

    sget-object v0, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;->PRESENT:Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;

    invoke-virtual {v0}, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    invoke-direct {p0, v0, p1}, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .registers 3

    invoke-direct {p0}, Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;-><init>()V

    invoke-static {p1}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    :try_start_6
    invoke-static {p1}, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;->fromString(Ljava/lang/String;)Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;->zza:Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;
    :try_end_c
    .catch Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$UnsupportedTokenBindingStatusException; {:try_start_6 .. :try_end_c} :catch_f

    iput-object p2, p0, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;->zzb:Ljava/lang/String;

    return-void

    :catch_f
    move-exception p1

    new-instance p2, Ljava/lang/IllegalArgumentException;

    invoke-direct {p2, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/Throwable;)V

    throw p2
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 5

    instance-of v0, p1, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;

    const/4 v1, 0x0

    if-nez v0, :cond_6

    return v1

    :cond_6
    check-cast p1, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;

    iget-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;->zza:Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;

    iget-object v2, p1, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;->zza:Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;

    invoke-static {v0, v2}, Lcom/google/android/gms/internal/fido/zzal;->zza(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1e

    iget-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;->zzb:Ljava/lang/String;

    iget-object p1, p1, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;->zzb:Ljava/lang/String;

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/fido/zzal;->zza(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_1e

    const/4 p1, 0x1

    return p1

    :cond_1e
    return v1
.end method

.method public getTokenBindingId()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;->zzb:Ljava/lang/String;

    return-object v0
.end method

.method public getTokenBindingStatusAsString()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;->zza:Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;

    invoke-virtual {v0}, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public hashCode()I
    .registers 4

    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    iget-object v1, p0, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;->zza:Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;

    const/4 v2, 0x0

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;->zzb:Ljava/lang/String;

    const/4 v2, 0x1

    aput-object v1, v0, v2

    invoke-static {v0}, Ljava/util/Arrays;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public toJsonObject()Lorg/json/JSONObject;
    .registers 4

    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    const-string v1, "status"

    iget-object v2, p0, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;->zza:Lcom/google/android/gms/fido/fido2/api/common/TokenBinding$TokenBindingStatus;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "id"

    iget-object v2, p0, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;->zzb:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v0
    :try_end_15
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_15} :catch_16

    return-object v0

    :catch_16
    move-exception v0

    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 6

    invoke-static {p1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->beginObjectHeader(Landroid/os/Parcel;)I

    move-result p2

    invoke-virtual {p0}, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;->getTokenBindingStatusAsString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x2

    const/4 v2, 0x0

    invoke-static {p1, v1, v0, v2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeString(Landroid/os/Parcel;ILjava/lang/String;Z)V

    invoke-virtual {p0}, Lcom/google/android/gms/fido/fido2/api/common/TokenBinding;->getTokenBindingId()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x3

    invoke-static {p1, v1, v0, v2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeString(Landroid/os/Parcel;ILjava/lang/String;Z)V

    invoke-static {p1, p2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->finishObjectHeader(Landroid/os/Parcel;I)V

    return-void
.end method
