.class public Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;
.super Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria$Builder;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final zza:Lcom/google/android/gms/fido/fido2/api/common/Attachment;

.field private final zzb:Ljava/lang/Boolean;

.field private final zzc:Lcom/google/android/gms/fido/fido2/api/common/zzay;

.field private final zzd:Lcom/google/android/gms/fido/fido2/api/common/ResidentKeyRequirement;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/google/android/gms/fido/fido2/api/common/zzm;

    invoke-direct {v0}, Lcom/google/android/gms/fido/fido2/api/common/zzm;-><init>()V

    sput-object v0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V
    .registers 6

    invoke-direct {p0}, Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;-><init>()V

    const/4 v0, 0x0

    if-nez p1, :cond_8

    move-object p1, v0

    goto :goto_c

    :cond_8
    :try_start_8
    invoke-static {p1}, Lcom/google/android/gms/fido/fido2/api/common/Attachment;->fromString(Ljava/lang/String;)Lcom/google/android/gms/fido/fido2/api/common/Attachment;

    move-result-object p1

    :goto_c
    iput-object p1, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zza:Lcom/google/android/gms/fido/fido2/api/common/Attachment;

    iput-object p2, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zzb:Ljava/lang/Boolean;

    if-nez p3, :cond_14

    move-object p1, v0

    goto :goto_18

    :cond_14
    invoke-static {p3}, Lcom/google/android/gms/fido/fido2/api/common/zzay;->zza(Ljava/lang/String;)Lcom/google/android/gms/fido/fido2/api/common/zzay;

    move-result-object p1

    :goto_18
    iput-object p1, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zzc:Lcom/google/android/gms/fido/fido2/api/common/zzay;

    if-nez p4, :cond_1d

    goto :goto_21

    :cond_1d
    invoke-static {p4}, Lcom/google/android/gms/fido/fido2/api/common/ResidentKeyRequirement;->fromString(Ljava/lang/String;)Lcom/google/android/gms/fido/fido2/api/common/ResidentKeyRequirement;

    move-result-object v0

    :goto_21
    iput-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zzd:Lcom/google/android/gms/fido/fido2/api/common/ResidentKeyRequirement;
    :try_end_23
    .catch Lcom/google/android/gms/fido/fido2/api/common/Attachment$UnsupportedAttachmentException; {:try_start_8 .. :try_end_23} :catch_28
    .catch Lcom/google/android/gms/fido/fido2/api/common/zzax; {:try_start_8 .. :try_end_23} :catch_26
    .catch Lcom/google/android/gms/fido/fido2/api/common/ResidentKeyRequirement$UnsupportedResidentKeyRequirementException; {:try_start_8 .. :try_end_23} :catch_24

    return-void

    :catch_24
    move-exception p1

    goto :goto_29

    :catch_26
    move-exception p1

    goto :goto_29

    :catch_28
    move-exception p1

    :goto_29
    new-instance p2, Ljava/lang/IllegalArgumentException;

    invoke-direct {p2, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/Throwable;)V

    throw p2
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 5

    instance-of v0, p1, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;

    const/4 v1, 0x0

    if-nez v0, :cond_6

    return v1

    :cond_6
    check-cast p1, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;

    iget-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zza:Lcom/google/android/gms/fido/fido2/api/common/Attachment;

    iget-object v2, p1, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zza:Lcom/google/android/gms/fido/fido2/api/common/Attachment;

    invoke-static {v0, v2}, Lcom/google/android/gms/common/internal/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_32

    iget-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zzb:Ljava/lang/Boolean;

    iget-object v2, p1, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zzb:Ljava/lang/Boolean;

    invoke-static {v0, v2}, Lcom/google/android/gms/common/internal/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_32

    iget-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zzc:Lcom/google/android/gms/fido/fido2/api/common/zzay;

    iget-object v2, p1, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zzc:Lcom/google/android/gms/fido/fido2/api/common/zzay;

    invoke-static {v0, v2}, Lcom/google/android/gms/common/internal/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_32

    iget-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zzd:Lcom/google/android/gms/fido/fido2/api/common/ResidentKeyRequirement;

    iget-object p1, p1, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zzd:Lcom/google/android/gms/fido/fido2/api/common/ResidentKeyRequirement;

    invoke-static {v0, p1}, Lcom/google/android/gms/common/internal/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_32

    const/4 p1, 0x1

    return p1

    :cond_32
    return v1
.end method

.method public getAttachment()Lcom/google/android/gms/fido/fido2/api/common/Attachment;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zza:Lcom/google/android/gms/fido/fido2/api/common/Attachment;

    return-object v0
.end method

.method public getAttachmentAsString()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zza:Lcom/google/android/gms/fido/fido2/api/common/Attachment;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    return-object v0

    :cond_6
    invoke-virtual {v0}, Lcom/google/android/gms/fido/fido2/api/common/Attachment;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getRequireResidentKey()Ljava/lang/Boolean;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zzb:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getResidentKeyRequirement()Lcom/google/android/gms/fido/fido2/api/common/ResidentKeyRequirement;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zzd:Lcom/google/android/gms/fido/fido2/api/common/ResidentKeyRequirement;

    return-object v0
.end method

.method public getResidentKeyRequirementAsString()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zzd:Lcom/google/android/gms/fido/fido2/api/common/ResidentKeyRequirement;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    return-object v0

    :cond_6
    invoke-virtual {v0}, Lcom/google/android/gms/fido/fido2/api/common/ResidentKeyRequirement;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public hashCode()I
    .registers 4

    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/Object;

    iget-object v1, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zza:Lcom/google/android/gms/fido/fido2/api/common/Attachment;

    const/4 v2, 0x0

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zzb:Ljava/lang/Boolean;

    const/4 v2, 0x1

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zzc:Lcom/google/android/gms/fido/fido2/api/common/zzay;

    const/4 v2, 0x2

    aput-object v1, v0, v2

    iget-object v1, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zzd:Lcom/google/android/gms/fido/fido2/api/common/ResidentKeyRequirement;

    const/4 v2, 0x3

    aput-object v1, v0, v2

    invoke-static {v0}, Lcom/google/android/gms/common/internal/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 6

    invoke-static {p1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->beginObjectHeader(Landroid/os/Parcel;)I

    move-result p2

    invoke-virtual {p0}, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->getAttachmentAsString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x2

    const/4 v2, 0x0

    invoke-static {p1, v1, v0, v2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeString(Landroid/os/Parcel;ILjava/lang/String;Z)V

    invoke-virtual {p0}, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->getRequireResidentKey()Ljava/lang/Boolean;

    move-result-object v0

    const/4 v1, 0x3

    invoke-static {p1, v1, v0, v2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeBooleanObject(Landroid/os/Parcel;ILjava/lang/Boolean;Z)V

    iget-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->zzc:Lcom/google/android/gms/fido/fido2/api/common/zzay;

    if-nez v0, :cond_1b

    const/4 v0, 0x0

    goto :goto_1f

    :cond_1b
    invoke-virtual {v0}, Lcom/google/android/gms/fido/fido2/api/common/zzay;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_1f
    const/4 v1, 0x4

    invoke-static {p1, v1, v0, v2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeString(Landroid/os/Parcel;ILjava/lang/String;Z)V

    const/4 v0, 0x5

    invoke-virtual {p0}, Lcom/google/android/gms/fido/fido2/api/common/AuthenticatorSelectionCriteria;->getResidentKeyRequirementAsString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p1, v0, v1, v2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeString(Landroid/os/Parcel;ILjava/lang/String;Z)V

    invoke-static {p1, p2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->finishObjectHeader(Landroid/os/Parcel;I)V

    return-void
.end method
