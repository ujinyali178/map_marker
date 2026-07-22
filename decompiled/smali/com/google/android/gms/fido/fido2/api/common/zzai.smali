.class public final Lcom/google/android/gms/fido/fido2/api/common/zzai;
.super Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;
.source "SourceFile"


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Lcom/google/android/gms/fido/fido2/api/common/zzai;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final zza:[[B


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/google/android/gms/fido/fido2/api/common/zzaj;

    invoke-direct {v0}, Lcom/google/android/gms/fido/fido2/api/common/zzaj;-><init>()V

    sput-object v0, Lcom/google/android/gms/fido/fido2/api/common/zzai;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>([[B)V
    .registers 7

    invoke-direct {p0}, Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;-><init>()V

    const/4 v0, 0x0

    const/4 v1, 0x1

    if-eqz p1, :cond_9

    const/4 v2, 0x1

    goto :goto_a

    :cond_9
    const/4 v2, 0x0

    :goto_a
    invoke-static {v2}, Lcom/google/android/gms/common/internal/Preconditions;->checkArgument(Z)V

    array-length v2, p1

    and-int/2addr v2, v1

    xor-int/2addr v2, v1

    if-eq v1, v2, :cond_14

    const/4 v2, 0x0

    goto :goto_15

    :cond_14
    const/4 v2, 0x1

    :goto_15
    invoke-static {v2}, Lcom/google/android/gms/common/internal/Preconditions;->checkArgument(Z)V

    const/4 v2, 0x0

    :goto_19
    array-length v3, p1

    if-ge v2, v3, :cond_4a

    if-eqz v2, :cond_25

    aget-object v3, p1, v2

    if-eqz v3, :cond_23

    goto :goto_25

    :cond_23
    const/4 v3, 0x0

    goto :goto_26

    :cond_25
    :goto_25
    const/4 v3, 0x1

    :goto_26
    invoke-static {v3}, Lcom/google/android/gms/common/internal/Preconditions;->checkArgument(Z)V

    add-int/lit8 v3, v2, 0x1

    aget-object v4, p1, v3

    if-eqz v4, :cond_31

    const/4 v4, 0x1

    goto :goto_32

    :cond_31
    const/4 v4, 0x0

    :goto_32
    invoke-static {v4}, Lcom/google/android/gms/common/internal/Preconditions;->checkArgument(Z)V

    aget-object v3, p1, v3

    array-length v3, v3

    const/16 v4, 0x20

    if-eq v3, v4, :cond_43

    const/16 v4, 0x40

    if-ne v3, v4, :cond_41

    goto :goto_43

    :cond_41
    const/4 v3, 0x0

    goto :goto_44

    :cond_43
    :goto_43
    const/4 v3, 0x1

    :goto_44
    invoke-static {v3}, Lcom/google/android/gms/common/internal/Preconditions;->checkArgument(Z)V

    add-int/lit8 v2, v2, 0x2

    goto :goto_19

    :cond_4a
    iput-object p1, p0, Lcom/google/android/gms/fido/fido2/api/common/zzai;->zza:[[B

    return-void
.end method


# virtual methods
.method public final equals(Ljava/lang/Object;)Z
    .registers 3

    instance-of v0, p1, Lcom/google/android/gms/fido/fido2/api/common/zzai;

    if-nez v0, :cond_6

    const/4 p1, 0x0

    return p1

    :cond_6
    check-cast p1, Lcom/google/android/gms/fido/fido2/api/common/zzai;

    iget-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/zzai;->zza:[[B

    iget-object p1, p1, Lcom/google/android/gms/fido/fido2/api/common/zzai;->zza:[[B

    invoke-static {v0, p1}, Ljava/util/Arrays;->deepEquals([Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method public final hashCode()I
    .registers 8

    iget-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/zzai;->zza:[[B

    array-length v1, v0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    :goto_6
    if-ge v3, v1, :cond_17

    aget-object v5, v0, v3

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    aput-object v5, v6, v2

    invoke-static {v6}, Lcom/google/android/gms/common/internal/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v5

    xor-int/2addr v4, v5

    add-int/lit8 v3, v3, 0x1

    goto :goto_6

    :cond_17
    return v4
.end method

.method public final writeToParcel(Landroid/os/Parcel;I)V
    .registers 6

    invoke-static {p1}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->beginObjectHeader(Landroid/os/Parcel;)I

    move-result p2

    iget-object v0, p0, Lcom/google/android/gms/fido/fido2/api/common/zzai;->zza:[[B

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-static {p1, v1, v0, v2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->writeByteArrayArray(Landroid/os/Parcel;I[[BZ)V

    invoke-static {p1, p2}, Lcom/google/android/gms/common/internal/safeparcel/SafeParcelWriter;->finishObjectHeader(Landroid/os/Parcel;I)V

    return-void
.end method
