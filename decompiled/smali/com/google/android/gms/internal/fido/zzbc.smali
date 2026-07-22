.class final Lcom/google/android/gms/internal/fido/zzbc;
.super Lcom/google/android/gms/internal/fido/zzbe;
.source "SourceFile"


# instance fields
.field final zza:[C


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .registers 6

    new-instance p1, Lcom/google/android/gms/internal/fido/zzbb;

    const-string p2, "0123456789ABCDEF"

    invoke-virtual {p2}, Ljava/lang/String;->toCharArray()[C

    move-result-object p2

    const-string v0, "base16()"

    invoke-direct {p1, v0, p2}, Lcom/google/android/gms/internal/fido/zzbb;-><init>(Ljava/lang/String;[C)V

    const/4 p2, 0x0

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/fido/zzbe;-><init>(Lcom/google/android/gms/internal/fido/zzbb;Ljava/lang/Character;)V

    const/16 p2, 0x200

    new-array p2, p2, [C

    iput-object p2, p0, Lcom/google/android/gms/internal/fido/zzbc;->zza:[C

    invoke-static {p1}, Lcom/google/android/gms/internal/fido/zzbb;->zzc(Lcom/google/android/gms/internal/fido/zzbb;)[C

    move-result-object p2

    array-length p2, p2

    const/4 v0, 0x0

    const/16 v1, 0x10

    if-ne p2, v1, :cond_23

    const/4 p2, 0x1

    goto :goto_24

    :cond_23
    const/4 p2, 0x0

    :goto_24
    invoke-static {p2}, Lcom/google/android/gms/internal/fido/zzam;->zzc(Z)V

    :goto_27
    const/16 p2, 0x100

    if-ge v0, p2, :cond_44

    iget-object p2, p0, Lcom/google/android/gms/internal/fido/zzbc;->zza:[C

    ushr-int/lit8 v1, v0, 0x4

    invoke-virtual {p1, v1}, Lcom/google/android/gms/internal/fido/zzbb;->zza(I)C

    move-result v1

    aput-char v1, p2, v0

    iget-object p2, p0, Lcom/google/android/gms/internal/fido/zzbc;->zza:[C

    or-int/lit16 v1, v0, 0x100

    and-int/lit8 v2, v0, 0xf

    invoke-virtual {p1, v2}, Lcom/google/android/gms/internal/fido/zzbb;->zza(I)C

    move-result v2

    aput-char v2, p2, v1

    add-int/lit8 v0, v0, 0x1

    goto :goto_27

    :cond_44
    return-void
.end method


# virtual methods
.method final zza(Ljava/lang/Appendable;[BII)V
    .registers 7

    array-length p3, p2

    const/4 v0, 0x0

    invoke-static {v0, p4, p3}, Lcom/google/android/gms/internal/fido/zzam;->zze(III)V

    :goto_5
    if-ge v0, p4, :cond_1e

    aget-byte p3, p2, v0

    and-int/lit16 p3, p3, 0xff

    iget-object v1, p0, Lcom/google/android/gms/internal/fido/zzbc;->zza:[C

    aget-char v1, v1, p3

    invoke-interface {p1, v1}, Ljava/lang/Appendable;->append(C)Ljava/lang/Appendable;

    iget-object v1, p0, Lcom/google/android/gms/internal/fido/zzbc;->zza:[C

    or-int/lit16 p3, p3, 0x100

    aget-char p3, v1, p3

    invoke-interface {p1, p3}, Ljava/lang/Appendable;->append(C)Ljava/lang/Appendable;

    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    :cond_1e
    return-void
.end method
