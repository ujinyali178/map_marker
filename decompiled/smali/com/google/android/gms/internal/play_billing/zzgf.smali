.class final Lcom/google/android/gms/internal/play_billing/zzgf;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/internal/play_billing/zzgm;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/google/android/gms/internal/play_billing/zzgm<",
        "TT;>;"
    }
.end annotation


# static fields
.field private static final zza:[I

.field private static final zzb:Lsun/misc/Unsafe;


# instance fields
.field private final zzc:[I

.field private final zzd:[Ljava/lang/Object;

.field private final zze:I

.field private final zzf:I

.field private final zzg:Lcom/google/android/gms/internal/play_billing/zzgc;

.field private final zzh:Z

.field private final zzi:[I

.field private final zzj:I

.field private final zzk:I

.field private final zzl:Lcom/google/android/gms/internal/play_billing/zzfq;

.field private final zzm:Lcom/google/android/gms/internal/play_billing/zzhd;

.field private final zzn:Lcom/google/android/gms/internal/play_billing/zzek;

.field private final zzo:Lcom/google/android/gms/internal/play_billing/zzgh;

.field private final zzp:Lcom/google/android/gms/internal/play_billing/zzfx;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const/4 v0, 0x0

    new-array v0, v0, [I

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzgf;->zza:[I

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzg()Lsun/misc/Unsafe;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzb:Lsun/misc/Unsafe;

    return-void
.end method

.method private constructor <init>([I[Ljava/lang/Object;IILcom/google/android/gms/internal/play_billing/zzgc;IZ[IIILcom/google/android/gms/internal/play_billing/zzgh;Lcom/google/android/gms/internal/play_billing/zzfq;Lcom/google/android/gms/internal/play_billing/zzhd;Lcom/google/android/gms/internal/play_billing/zzek;Lcom/google/android/gms/internal/play_billing/zzfx;)V
    .registers 16

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    iput-object p2, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzd:[Ljava/lang/Object;

    iput p3, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zze:I

    iput p4, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzf:I

    const/4 p1, 0x0

    if-eqz p14, :cond_15

    invoke-virtual {p14, p5}, Lcom/google/android/gms/internal/play_billing/zzek;->zzc(Lcom/google/android/gms/internal/play_billing/zzgc;)Z

    move-result p2

    if-eqz p2, :cond_15

    const/4 p1, 0x1

    :cond_15
    iput-boolean p1, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzh:Z

    iput-object p8, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzi:[I

    iput p9, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzj:I

    iput p10, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzk:I

    iput-object p11, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzo:Lcom/google/android/gms/internal/play_billing/zzgh;

    iput-object p12, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzl:Lcom/google/android/gms/internal/play_billing/zzfq;

    iput-object p13, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzm:Lcom/google/android/gms/internal/play_billing/zzhd;

    iput-object p14, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzn:Lcom/google/android/gms/internal/play_billing/zzek;

    iput-object p5, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzg:Lcom/google/android/gms/internal/play_billing/zzgc;

    iput-object p15, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzp:Lcom/google/android/gms/internal/play_billing/zzfx;

    return-void
.end method

.method private static zzA(Ljava/lang/Object;)V
    .registers 3

    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzL(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    return-void

    :cond_7
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-static {p0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    const-string v1, "Mutating immutable message: "

    invoke-virtual {v1, p0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private final zzB(Ljava/lang/Object;Ljava/lang/Object;I)V
    .registers 9

    invoke-direct {p0, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v0

    if-nez v0, :cond_7

    return-void

    :cond_7
    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzs(I)I

    move-result v0

    const v1, 0xfffff

    and-int/2addr v0, v1

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzgf;->zzb:Lsun/misc/Unsafe;

    int-to-long v2, v0

    invoke-virtual {v1, p2, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_53

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object p2

    invoke-direct {p0, p1, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v4

    if-nez v4, :cond_3a

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzL(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2c

    invoke-virtual {v1, p1, v2, v3, v0}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_36

    :cond_2c
    invoke-interface {p2}, Lcom/google/android/gms/internal/play_billing/zzgm;->zze()Ljava/lang/Object;

    move-result-object v4

    invoke-interface {p2, v4, v0}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzg(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v1, p1, v2, v3, v4}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    :goto_36
    invoke-direct {p0, p1, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzD(Ljava/lang/Object;I)V

    return-void

    :cond_3a
    invoke-virtual {v1, p1, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p3

    invoke-static {p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzL(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_4f

    invoke-interface {p2}, Lcom/google/android/gms/internal/play_billing/zzgm;->zze()Ljava/lang/Object;

    move-result-object v4

    invoke-interface {p2, v4, p3}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzg(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v1, p1, v2, v3, v4}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    move-object p3, v4

    :cond_4f
    invoke-interface {p2, p3, v0}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzg(Ljava/lang/Object;Ljava/lang/Object;)V

    return-void

    :cond_53
    iget-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    new-instance v0, Ljava/lang/IllegalStateException;

    aget p1, p1, p3

    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p2

    new-instance p3, Ljava/lang/StringBuilder;

    invoke-direct {p3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Source subfield "

    invoke-virtual {p3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, " is present but null: "

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private final zzC(Ljava/lang/Object;Ljava/lang/Object;I)V
    .registers 10

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, p3

    invoke-direct {p0, p2, v0, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v1

    if-nez v1, :cond_b

    return-void

    :cond_b
    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzs(I)I

    move-result v1

    const v2, 0xfffff

    and-int/2addr v1, v2

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzgf;->zzb:Lsun/misc/Unsafe;

    int-to-long v3, v1

    invoke-virtual {v2, p2, v3, v4}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_57

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object p2

    invoke-direct {p0, p1, v0, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v5

    if-nez v5, :cond_3e

    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzL(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_30

    invoke-virtual {v2, p1, v3, v4, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_3a

    :cond_30
    invoke-interface {p2}, Lcom/google/android/gms/internal/play_billing/zzgm;->zze()Ljava/lang/Object;

    move-result-object v5

    invoke-interface {p2, v5, v1}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzg(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v2, p1, v3, v4, v5}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    :goto_3a
    invoke-direct {p0, p1, v0, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzE(Ljava/lang/Object;II)V

    return-void

    :cond_3e
    invoke-virtual {v2, p1, v3, v4}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p3

    invoke-static {p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzL(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_53

    invoke-interface {p2}, Lcom/google/android/gms/internal/play_billing/zzgm;->zze()Ljava/lang/Object;

    move-result-object v0

    invoke-interface {p2, v0, p3}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzg(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v2, p1, v3, v4, v0}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    move-object p3, v0

    :cond_53
    invoke-interface {p2, p3, v1}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzg(Ljava/lang/Object;Ljava/lang/Object;)V

    return-void

    :cond_57
    iget-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    new-instance v0, Ljava/lang/IllegalStateException;

    aget p1, p1, p3

    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p2

    new-instance p3, Ljava/lang/StringBuilder;

    invoke-direct {p3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Source subfield "

    invoke-virtual {p3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, " is present but null: "

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private final zzD(Ljava/lang/Object;I)V
    .registers 8

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzp(I)I

    move-result p2

    const v0, 0xfffff

    and-int/2addr v0, p2

    int-to-long v0, v0

    const-wide/32 v2, 0xfffff

    cmp-long v4, v0, v2

    if-nez v4, :cond_11

    return-void

    :cond_11
    ushr-int/lit8 p2, p2, 0x14

    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result v2

    const/4 v3, 0x1

    shl-int p2, v3, p2

    or-int/2addr p2, v2

    invoke-static {p1, v0, v1, p2}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzq(Ljava/lang/Object;JI)V

    return-void
.end method

.method private final zzE(Ljava/lang/Object;II)V
    .registers 6

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzp(I)I

    move-result p3

    const v0, 0xfffff

    and-int/2addr p3, v0

    int-to-long v0, p3

    invoke-static {p1, v0, v1, p2}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzq(Ljava/lang/Object;JI)V

    return-void
.end method

.method private final zzF(Ljava/lang/Object;ILjava/lang/Object;)V
    .registers 7

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzb:Lsun/misc/Unsafe;

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzs(I)I

    move-result v1

    const v2, 0xfffff

    and-int/2addr v1, v2

    int-to-long v1, v1

    invoke-virtual {v0, p1, v1, v2, p3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzD(Ljava/lang/Object;I)V

    return-void
.end method

.method private final zzG(Ljava/lang/Object;IILjava/lang/Object;)V
    .registers 8

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzb:Lsun/misc/Unsafe;

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzs(I)I

    move-result v1

    const v2, 0xfffff

    and-int/2addr v1, v2

    int-to-long v1, v1

    invoke-virtual {v0, p1, v1, v2, p4}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzE(Ljava/lang/Object;II)V

    return-void
.end method

.method private final zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z
    .registers 4

    invoke-direct {p0, p1, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result p1

    invoke-direct {p0, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result p2

    if-ne p1, p2, :cond_c

    const/4 p1, 0x1

    return p1

    :cond_c
    const/4 p1, 0x0

    return p1
.end method

.method private final zzI(Ljava/lang/Object;I)Z
    .registers 12

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzp(I)I

    move-result v0

    const v1, 0xfffff

    and-int v2, v0, v1

    int-to-long v2, v2

    const/4 v4, 0x0

    const/4 v5, 0x1

    const/4 v5, 0x1

    const-wide/32 v6, 0xfffff

    cmp-long v8, v2, v6

    if-nez v8, :cond_ef

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzs(I)I

    move-result p2

    and-int v0, p2, v1

    invoke-static {p2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzr(I)I

    move-result p2

    int-to-long v0, v0

    const-wide/16 v2, 0x0

    packed-switch p2, :pswitch_data_fc

    new-instance p1, Ljava/lang/IllegalArgumentException;

    invoke-direct {p1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw p1

    :pswitch_2a
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    if-eqz p1, :cond_31

    return v5

    :cond_31
    return v4

    :pswitch_32
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long v0, p1, v2

    if-eqz v0, :cond_3b

    return v5

    :cond_3b
    return v4

    :pswitch_3c
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_43

    return v5

    :cond_43
    return v4

    :pswitch_44
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long v0, p1, v2

    if-eqz v0, :cond_4d

    return v5

    :cond_4d
    return v4

    :pswitch_4e
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_55

    return v5

    :cond_55
    return v4

    :pswitch_56
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_5d

    return v5

    :cond_5d
    return v4

    :pswitch_5e
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_65

    return v5

    :cond_65
    return v4

    :pswitch_66
    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzdw;->zzb:Lcom/google/android/gms/internal/play_billing/zzdw;

    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {p2, p1}, Lcom/google/android/gms/internal/play_billing/zzdw;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_73

    return v5

    :cond_73
    return v4

    :pswitch_74
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    if-eqz p1, :cond_7b

    return v5

    :cond_7b
    return v4

    :pswitch_7c
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    instance-of p2, p1, Ljava/lang/String;

    if-eqz p2, :cond_8e

    check-cast p1, Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result p1

    if-nez p1, :cond_8d

    return v5

    :cond_8d
    return v4

    :cond_8e
    instance-of p2, p1, Lcom/google/android/gms/internal/play_billing/zzdw;

    if-eqz p2, :cond_9c

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzdw;->zzb:Lcom/google/android/gms/internal/play_billing/zzdw;

    invoke-virtual {p2, p1}, Lcom/google/android/gms/internal/play_billing/zzdw;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_9b

    return v5

    :cond_9b
    return v4

    :cond_9c
    new-instance p1, Ljava/lang/IllegalArgumentException;

    invoke-direct {p1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw p1

    :pswitch_a2
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzw(Ljava/lang/Object;J)Z

    move-result p1

    return p1

    :pswitch_a7
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_ae

    return v5

    :cond_ae
    return v4

    :pswitch_af
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long v0, p1, v2

    if-eqz v0, :cond_b8

    return v5

    :cond_b8
    return v4

    :pswitch_b9
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_c0

    return v5

    :cond_c0
    return v4

    :pswitch_c1
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long v0, p1, v2

    if-eqz v0, :cond_ca

    return v5

    :cond_ca
    return v4

    :pswitch_cb
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long v0, p1, v2

    if-eqz v0, :cond_d4

    return v5

    :cond_d4
    return v4

    :pswitch_d5
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzb(Ljava/lang/Object;J)F

    move-result p1

    invoke-static {p1}, Ljava/lang/Float;->floatToRawIntBits(F)I

    move-result p1

    if-eqz p1, :cond_e0

    return v5

    :cond_e0
    return v4

    :pswitch_e1
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zza(Ljava/lang/Object;J)D

    move-result-wide p1

    invoke-static {p1, p2}, Ljava/lang/Double;->doubleToRawLongBits(D)J

    move-result-wide p1

    cmp-long v0, p1, v2

    if-eqz v0, :cond_ee

    return v5

    :cond_ee
    return v4

    :cond_ef
    ushr-int/lit8 p2, v0, 0x14

    shl-int p2, v5, p2

    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result p1

    and-int/2addr p1, p2

    if-eqz p1, :cond_fb

    return v5

    :cond_fb
    return v4

    :pswitch_data_fc
    .packed-switch 0x0
        :pswitch_e1
        :pswitch_d5
        :pswitch_cb
        :pswitch_c1
        :pswitch_b9
        :pswitch_af
        :pswitch_a7
        :pswitch_a2
        :pswitch_7c
        :pswitch_74
        :pswitch_66
        :pswitch_5e
        :pswitch_56
        :pswitch_4e
        :pswitch_44
        :pswitch_3c
        :pswitch_32
        :pswitch_2a
    .end packed-switch
.end method

.method private final zzJ(Ljava/lang/Object;IIII)Z
    .registers 7

    const v0, 0xfffff

    if-ne p3, v0, :cond_a

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result p1

    return p1

    :cond_a
    and-int p1, p4, p5

    if-eqz p1, :cond_10

    const/4 p1, 0x1

    return p1

    :cond_10
    const/4 p1, 0x0

    return p1
.end method

.method private static zzK(Ljava/lang/Object;ILcom/google/android/gms/internal/play_billing/zzgm;)Z
    .registers 5

    const v0, 0xfffff

    and-int/2addr p1, v0

    int-to-long v0, p1

    invoke-static {p0, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    invoke-interface {p2, p0}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzk(Ljava/lang/Object;)Z

    move-result p0

    return p0
.end method

.method private static zzL(Ljava/lang/Object;)Z
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return p0

    :cond_4
    instance-of v0, p0, Lcom/google/android/gms/internal/play_billing/zzex;

    if-eqz v0, :cond_f

    check-cast p0, Lcom/google/android/gms/internal/play_billing/zzex;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzex;->zzt()Z

    move-result p0

    return p0

    :cond_f
    const/4 p0, 0x1

    return p0
.end method

.method private final zzM(Ljava/lang/Object;II)Z
    .registers 6

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzp(I)I

    move-result p3

    const v0, 0xfffff

    and-int/2addr p3, v0

    int-to-long v0, p3

    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-ne p1, p2, :cond_11

    const/4 p1, 0x1

    return p1

    :cond_11
    const/4 p1, 0x0

    return p1
.end method

.method private static zzN(Ljava/lang/Object;J)Z
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Boolean;

    invoke-virtual {p0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p0

    return p0
.end method

.method private static final zzO(ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzhv;)V
    .registers 4

    instance-of v0, p1, Ljava/lang/String;

    if-eqz v0, :cond_a

    check-cast p1, Ljava/lang/String;

    invoke-interface {p2, p0, p1}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzF(ILjava/lang/String;)V

    return-void

    :cond_a
    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzdw;

    invoke-interface {p2, p0, p1}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzd(ILcom/google/android/gms/internal/play_billing/zzdw;)V

    return-void
.end method

.method static zzd(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzhe;
    .registers 3

    check-cast p0, Lcom/google/android/gms/internal/play_billing/zzex;

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzex;->zzc:Lcom/google/android/gms/internal/play_billing/zzhe;

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhe;->zzc()Lcom/google/android/gms/internal/play_billing/zzhe;

    move-result-object v1

    if-ne v0, v1, :cond_10

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhe;->zzf()Lcom/google/android/gms/internal/play_billing/zzhe;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzex;->zzc:Lcom/google/android/gms/internal/play_billing/zzhe;

    :cond_10
    return-object v0
.end method

.method static zzl(Ljava/lang/Class;Lcom/google/android/gms/internal/play_billing/zzfz;Lcom/google/android/gms/internal/play_billing/zzgh;Lcom/google/android/gms/internal/play_billing/zzfq;Lcom/google/android/gms/internal/play_billing/zzhd;Lcom/google/android/gms/internal/play_billing/zzek;Lcom/google/android/gms/internal/play_billing/zzfx;)Lcom/google/android/gms/internal/play_billing/zzgf;
    .registers 40

    move-object/from16 v0, p1

    instance-of v1, v0, Lcom/google/android/gms/internal/play_billing/zzgl;

    if-eqz v1, :cond_401

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgl;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgl;->zzd()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const v5, 0xd800

    if-lt v4, v5, :cond_25

    const/4 v4, 0x1

    :goto_1b
    add-int/lit8 v7, v4, 0x1

    invoke-virtual {v1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    if-lt v4, v5, :cond_26

    move v4, v7

    goto :goto_1b

    :cond_25
    const/4 v7, 0x1

    :cond_26
    add-int/lit8 v4, v7, 0x1

    invoke-virtual {v1, v7}, Ljava/lang/String;->charAt(I)C

    move-result v7

    if-lt v7, v5, :cond_45

    and-int/lit16 v7, v7, 0x1fff

    const/16 v9, 0xd

    :goto_32
    add-int/lit8 v10, v4, 0x1

    invoke-virtual {v1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    if-lt v4, v5, :cond_42

    and-int/lit16 v4, v4, 0x1fff

    shl-int/2addr v4, v9

    or-int/2addr v7, v4

    add-int/lit8 v9, v9, 0xd

    move v4, v10

    goto :goto_32

    :cond_42
    shl-int/2addr v4, v9

    or-int/2addr v7, v4

    move v4, v10

    :cond_45
    if-nez v7, :cond_56

    sget-object v7, Lcom/google/android/gms/internal/play_billing/zzgf;->zza:[I

    move-object/from16 v17, v7

    const/4 v7, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/16 v16, 0x0

    const/16 v18, 0x0

    goto/16 :goto_166

    :cond_56
    add-int/lit8 v7, v4, 0x1

    invoke-virtual {v1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    if-lt v4, v5, :cond_75

    and-int/lit16 v4, v4, 0x1fff

    const/16 v9, 0xd

    :goto_62
    add-int/lit8 v10, v7, 0x1

    invoke-virtual {v1, v7}, Ljava/lang/String;->charAt(I)C

    move-result v7

    if-lt v7, v5, :cond_72

    and-int/lit16 v7, v7, 0x1fff

    shl-int/2addr v7, v9

    or-int/2addr v4, v7

    add-int/lit8 v9, v9, 0xd

    move v7, v10

    goto :goto_62

    :cond_72
    shl-int/2addr v7, v9

    or-int/2addr v4, v7

    move v7, v10

    :cond_75
    add-int/lit8 v9, v7, 0x1

    invoke-virtual {v1, v7}, Ljava/lang/String;->charAt(I)C

    move-result v7

    if-lt v7, v5, :cond_94

    and-int/lit16 v7, v7, 0x1fff

    const/16 v10, 0xd

    :goto_81
    add-int/lit8 v11, v9, 0x1

    invoke-virtual {v1, v9}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-lt v9, v5, :cond_91

    and-int/lit16 v9, v9, 0x1fff

    shl-int/2addr v9, v10

    or-int/2addr v7, v9

    add-int/lit8 v10, v10, 0xd

    move v9, v11

    goto :goto_81

    :cond_91
    shl-int/2addr v9, v10

    or-int/2addr v7, v9

    move v9, v11

    :cond_94
    add-int/lit8 v10, v9, 0x1

    invoke-virtual {v1, v9}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-lt v9, v5, :cond_b3

    and-int/lit16 v9, v9, 0x1fff

    const/16 v11, 0xd

    :goto_a0
    add-int/lit8 v12, v10, 0x1

    invoke-virtual {v1, v10}, Ljava/lang/String;->charAt(I)C

    move-result v10

    if-lt v10, v5, :cond_b0

    and-int/lit16 v10, v10, 0x1fff

    shl-int/2addr v10, v11

    or-int/2addr v9, v10

    add-int/lit8 v11, v11, 0xd

    move v10, v12

    goto :goto_a0

    :cond_b0
    shl-int/2addr v10, v11

    or-int/2addr v9, v10

    move v10, v12

    :cond_b3
    add-int/lit8 v11, v10, 0x1

    invoke-virtual {v1, v10}, Ljava/lang/String;->charAt(I)C

    move-result v10

    if-lt v10, v5, :cond_d2

    and-int/lit16 v10, v10, 0x1fff

    const/16 v12, 0xd

    :goto_bf
    add-int/lit8 v13, v11, 0x1

    invoke-virtual {v1, v11}, Ljava/lang/String;->charAt(I)C

    move-result v11

    if-lt v11, v5, :cond_cf

    and-int/lit16 v11, v11, 0x1fff

    shl-int/2addr v11, v12

    or-int/2addr v10, v11

    add-int/lit8 v12, v12, 0xd

    move v11, v13

    goto :goto_bf

    :cond_cf
    shl-int/2addr v11, v12

    or-int/2addr v10, v11

    move v11, v13

    :cond_d2
    add-int/lit8 v12, v11, 0x1

    invoke-virtual {v1, v11}, Ljava/lang/String;->charAt(I)C

    move-result v11

    if-lt v11, v5, :cond_f1

    and-int/lit16 v11, v11, 0x1fff

    const/16 v13, 0xd

    :goto_de
    add-int/lit8 v14, v12, 0x1

    invoke-virtual {v1, v12}, Ljava/lang/String;->charAt(I)C

    move-result v12

    if-lt v12, v5, :cond_ee

    and-int/lit16 v12, v12, 0x1fff

    shl-int/2addr v12, v13

    or-int/2addr v11, v12

    add-int/lit8 v13, v13, 0xd

    move v12, v14

    goto :goto_de

    :cond_ee
    shl-int/2addr v12, v13

    or-int/2addr v11, v12

    move v12, v14

    :cond_f1
    add-int/lit8 v13, v12, 0x1

    invoke-virtual {v1, v12}, Ljava/lang/String;->charAt(I)C

    move-result v12

    if-lt v12, v5, :cond_110

    and-int/lit16 v12, v12, 0x1fff

    const/16 v14, 0xd

    :goto_fd
    add-int/lit8 v15, v13, 0x1

    invoke-virtual {v1, v13}, Ljava/lang/String;->charAt(I)C

    move-result v13

    if-lt v13, v5, :cond_10d

    and-int/lit16 v13, v13, 0x1fff

    shl-int/2addr v13, v14

    or-int/2addr v12, v13

    add-int/lit8 v14, v14, 0xd

    move v13, v15

    goto :goto_fd

    :cond_10d
    shl-int/2addr v13, v14

    or-int/2addr v12, v13

    move v13, v15

    :cond_110
    add-int/lit8 v14, v13, 0x1

    invoke-virtual {v1, v13}, Ljava/lang/String;->charAt(I)C

    move-result v13

    if-lt v13, v5, :cond_131

    and-int/lit16 v13, v13, 0x1fff

    const/16 v15, 0xd

    :goto_11c
    add-int/lit8 v16, v14, 0x1

    invoke-virtual {v1, v14}, Ljava/lang/String;->charAt(I)C

    move-result v14

    if-lt v14, v5, :cond_12d

    and-int/lit16 v14, v14, 0x1fff

    shl-int/2addr v14, v15

    or-int/2addr v13, v14

    add-int/lit8 v15, v15, 0xd

    move/from16 v14, v16

    goto :goto_11c

    :cond_12d
    shl-int/2addr v14, v15

    or-int/2addr v13, v14

    move/from16 v14, v16

    :cond_131
    add-int/lit8 v15, v14, 0x1

    invoke-virtual {v1, v14}, Ljava/lang/String;->charAt(I)C

    move-result v14

    if-lt v14, v5, :cond_154

    and-int/lit16 v14, v14, 0x1fff

    const/16 v16, 0xd

    :goto_13d
    add-int/lit8 v17, v15, 0x1

    invoke-virtual {v1, v15}, Ljava/lang/String;->charAt(I)C

    move-result v15

    if-lt v15, v5, :cond_14f

    and-int/lit16 v15, v15, 0x1fff

    shl-int v15, v15, v16

    or-int/2addr v14, v15

    add-int/lit8 v16, v16, 0xd

    move/from16 v15, v17

    goto :goto_13d

    :cond_14f
    shl-int v15, v15, v16

    or-int/2addr v14, v15

    move/from16 v15, v17

    :cond_154
    add-int v16, v14, v12

    add-int v13, v16, v13

    add-int v16, v4, v4

    add-int v16, v16, v7

    new-array v7, v13, [I

    move-object/from16 v17, v7

    move v13, v9

    move/from16 v18, v14

    move v7, v4

    move v14, v10

    move v4, v15

    :goto_166
    sget-object v9, Lcom/google/android/gms/internal/play_billing/zzgf;->zzb:Lsun/misc/Unsafe;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgl;->zze()[Ljava/lang/Object;

    move-result-object v10

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgl;->zza()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v15

    add-int v19, v18, v12

    add-int v12, v11, v11

    mul-int/lit8 v11, v11, 0x3

    new-array v11, v11, [I

    new-array v12, v12, [Ljava/lang/Object;

    move/from16 v22, v18

    move/from16 v23, v19

    const/16 v20, 0x0

    const/16 v21, 0x0

    :goto_186
    if-ge v4, v2, :cond_3da

    add-int/lit8 v24, v4, 0x1

    invoke-virtual {v1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    if-lt v4, v5, :cond_1ae

    and-int/lit16 v4, v4, 0x1fff

    move/from16 v3, v24

    const/16 v24, 0xd

    :goto_196
    add-int/lit8 v25, v3, 0x1

    invoke-virtual {v1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v3

    if-lt v3, v5, :cond_1a8

    and-int/lit16 v3, v3, 0x1fff

    shl-int v3, v3, v24

    or-int/2addr v4, v3

    add-int/lit8 v24, v24, 0xd

    move/from16 v3, v25

    goto :goto_196

    :cond_1a8
    shl-int v3, v3, v24

    or-int/2addr v4, v3

    move/from16 v3, v25

    goto :goto_1b0

    :cond_1ae
    move/from16 v3, v24

    :goto_1b0
    add-int/lit8 v24, v3, 0x1

    invoke-virtual {v1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v3

    if-lt v3, v5, :cond_1d6

    and-int/lit16 v3, v3, 0x1fff

    move/from16 v8, v24

    const/16 v24, 0xd

    :goto_1be
    add-int/lit8 v25, v8, 0x1

    invoke-virtual {v1, v8}, Ljava/lang/String;->charAt(I)C

    move-result v8

    if-lt v8, v5, :cond_1d0

    and-int/lit16 v8, v8, 0x1fff

    shl-int v8, v8, v24

    or-int/2addr v3, v8

    add-int/lit8 v24, v24, 0xd

    move/from16 v8, v25

    goto :goto_1be

    :cond_1d0
    shl-int v8, v8, v24

    or-int/2addr v3, v8

    move/from16 v8, v25

    goto :goto_1d8

    :cond_1d6
    move/from16 v8, v24

    :goto_1d8
    and-int/lit16 v6, v3, 0x400

    if-eqz v6, :cond_1e2

    add-int/lit8 v6, v20, 0x1

    aput v21, v17, v20

    move/from16 v20, v6

    :cond_1e2
    and-int/lit16 v6, v3, 0xff

    and-int/lit16 v5, v3, 0x800

    move/from16 v26, v2

    const/16 v2, 0x33

    if-lt v6, v2, :cond_299

    add-int/lit8 v2, v8, 0x1

    invoke-virtual {v1, v8}, Ljava/lang/String;->charAt(I)C

    move-result v8

    move/from16 v27, v2

    const v2, 0xd800

    if-lt v8, v2, :cond_220

    and-int/lit16 v8, v8, 0x1fff

    const/16 v30, 0xd

    move/from16 v32, v27

    move/from16 v27, v8

    move/from16 v8, v32

    :goto_203
    add-int/lit8 v31, v8, 0x1

    invoke-virtual {v1, v8}, Ljava/lang/String;->charAt(I)C

    move-result v8

    if-lt v8, v2, :cond_219

    and-int/lit16 v2, v8, 0x1fff

    shl-int v2, v2, v30

    or-int v27, v27, v2

    add-int/lit8 v30, v30, 0xd

    move/from16 v8, v31

    const v2, 0xd800

    goto :goto_203

    :cond_219
    shl-int v2, v8, v30

    or-int v8, v27, v2

    move/from16 v2, v31

    goto :goto_222

    :cond_220
    move/from16 v2, v27

    :goto_222
    move/from16 v27, v2

    add-int/lit8 v2, v6, -0x33

    move/from16 v30, v14

    const/16 v14, 0x9

    if-eq v2, v14, :cond_24e

    const/16 v14, 0x11

    if-ne v2, v14, :cond_231

    goto :goto_24e

    :cond_231
    const/16 v14, 0xc

    if-ne v2, v14, :cond_25d

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgl;->zzc()I

    move-result v2

    const/4 v14, 0x1

    if-eq v2, v14, :cond_241

    if-eqz v5, :cond_23f

    goto :goto_241

    :cond_23f
    const/4 v5, 0x0

    goto :goto_25d

    :cond_241
    :goto_241
    add-int/lit8 v2, v16, 0x1

    div-int/lit8 v24, v21, 0x3

    add-int v24, v24, v24

    add-int/lit8 v24, v24, 0x1

    aget-object v16, v10, v16

    aput-object v16, v12, v24

    goto :goto_25b

    :cond_24e
    :goto_24e
    const/4 v14, 0x1

    add-int/lit8 v2, v16, 0x1

    div-int/lit8 v24, v21, 0x3

    add-int v24, v24, v24

    add-int/lit8 v28, v24, 0x1

    aget-object v14, v10, v16

    aput-object v14, v12, v28

    :goto_25b
    move/from16 v16, v2

    :cond_25d
    :goto_25d
    add-int/2addr v8, v8

    aget-object v2, v10, v8

    instance-of v14, v2, Ljava/lang/reflect/Field;

    if-eqz v14, :cond_267

    check-cast v2, Ljava/lang/reflect/Field;

    goto :goto_26f

    :cond_267
    check-cast v2, Ljava/lang/String;

    invoke-static {v15, v2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzz(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v2

    aput-object v2, v10, v8

    :goto_26f
    move/from16 v31, v13

    invoke-virtual {v9, v2}, Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J

    move-result-wide v13

    long-to-int v2, v13

    add-int/lit8 v8, v8, 0x1

    aget-object v13, v10, v8

    instance-of v14, v13, Ljava/lang/reflect/Field;

    if-eqz v14, :cond_281

    check-cast v13, Ljava/lang/reflect/Field;

    goto :goto_289

    :cond_281
    check-cast v13, Ljava/lang/String;

    invoke-static {v15, v13}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzz(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v13

    aput-object v13, v10, v8

    :goto_289
    invoke-virtual {v9, v13}, Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J

    move-result-wide v13

    long-to-int v8, v13

    move-object/from16 v29, v1

    move/from16 v24, v8

    move/from16 v25, v27

    const/4 v8, 0x0

    move-object/from16 v27, v0

    goto/16 :goto_39c

    :cond_299
    move/from16 v31, v13

    move/from16 v30, v14

    add-int/lit8 v2, v16, 0x1

    aget-object v13, v10, v16

    check-cast v13, Ljava/lang/String;

    invoke-static {v15, v13}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzz(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v13

    const/16 v14, 0x9

    if-eq v6, v14, :cond_31f

    const/16 v14, 0x11

    if-ne v6, v14, :cond_2b1

    goto/16 :goto_31f

    :cond_2b1
    const/16 v14, 0x1b

    if-eq v6, v14, :cond_30e

    const/16 v14, 0x31

    if-ne v6, v14, :cond_2bf

    add-int/lit8 v14, v2, 0x1

    move-object/from16 v27, v0

    const/4 v0, 0x1

    goto :goto_313

    :cond_2bf
    const/16 v14, 0xc

    if-eq v6, v14, :cond_2f3

    const/16 v14, 0x1e

    if-eq v6, v14, :cond_2f3

    const/16 v14, 0x2c

    if-ne v6, v14, :cond_2cc

    goto :goto_2f3

    :cond_2cc
    const/16 v14, 0x32

    if-ne v6, v14, :cond_2ef

    add-int/lit8 v14, v2, 0x1

    add-int/lit8 v27, v22, 0x1

    aput v21, v17, v22

    div-int/lit8 v22, v21, 0x3

    aget-object v2, v10, v2

    add-int v22, v22, v22

    aput-object v2, v12, v22

    if-eqz v5, :cond_2eb

    add-int/lit8 v22, v22, 0x1

    add-int/lit8 v2, v14, 0x1

    aget-object v14, v10, v14

    aput-object v14, v12, v22

    move/from16 v22, v27

    goto :goto_2ef

    :cond_2eb
    move v2, v14

    move/from16 v22, v27

    const/4 v5, 0x0

    :cond_2ef
    :goto_2ef
    move-object/from16 v27, v0

    const/4 v0, 0x1

    goto :goto_32c

    :cond_2f3
    :goto_2f3
    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzgl;->zzc()I

    move-result v14

    move-object/from16 v27, v0

    const/4 v0, 0x1

    if-eq v14, v0, :cond_301

    if-eqz v5, :cond_2ff

    goto :goto_301

    :cond_2ff
    const/4 v5, 0x0

    goto :goto_32c

    :cond_301
    :goto_301
    add-int/lit8 v14, v2, 0x1

    div-int/lit8 v24, v21, 0x3

    add-int v24, v24, v24

    add-int/lit8 v24, v24, 0x1

    aget-object v2, v10, v2

    aput-object v2, v12, v24

    goto :goto_31d

    :cond_30e
    move-object/from16 v27, v0

    const/4 v0, 0x1

    add-int/lit8 v14, v2, 0x1

    :goto_313
    div-int/lit8 v24, v21, 0x3

    add-int v24, v24, v24

    add-int/lit8 v24, v24, 0x1

    aget-object v2, v10, v2

    aput-object v2, v12, v24

    :goto_31d
    move v2, v14

    goto :goto_32c

    :cond_31f
    :goto_31f
    move-object/from16 v27, v0

    const/4 v0, 0x1

    div-int/lit8 v14, v21, 0x3

    add-int/2addr v14, v14

    add-int/2addr v14, v0

    invoke-virtual {v13}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v24

    aput-object v24, v12, v14

    :goto_32c
    invoke-virtual {v9, v13}, Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J

    move-result-wide v13

    long-to-int v14, v13

    and-int/lit16 v13, v3, 0x1000

    const v24, 0xfffff

    if-eqz v13, :cond_386

    const/16 v13, 0x11

    if-gt v6, v13, :cond_386

    add-int/lit8 v13, v8, 0x1

    invoke-virtual {v1, v8}, Ljava/lang/String;->charAt(I)C

    move-result v8

    const v0, 0xd800

    if-lt v8, v0, :cond_361

    and-int/lit16 v8, v8, 0x1fff

    const/16 v24, 0xd

    :goto_34b
    add-int/lit8 v25, v13, 0x1

    invoke-virtual {v1, v13}, Ljava/lang/String;->charAt(I)C

    move-result v13

    if-lt v13, v0, :cond_35d

    and-int/lit16 v13, v13, 0x1fff

    shl-int v13, v13, v24

    or-int/2addr v8, v13

    add-int/lit8 v24, v24, 0xd

    move/from16 v13, v25

    goto :goto_34b

    :cond_35d
    shl-int v13, v13, v24

    or-int/2addr v8, v13

    goto :goto_363

    :cond_361
    move/from16 v25, v13

    :goto_363
    add-int v13, v7, v7

    div-int/lit8 v24, v8, 0x20

    add-int v13, v13, v24

    aget-object v0, v10, v13

    move-object/from16 v29, v1

    instance-of v1, v0, Ljava/lang/reflect/Field;

    if-eqz v1, :cond_374

    check-cast v0, Ljava/lang/reflect/Field;

    goto :goto_37c

    :cond_374
    check-cast v0, Ljava/lang/String;

    invoke-static {v15, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzz(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    aput-object v0, v10, v13

    :goto_37c
    invoke-virtual {v9, v0}, Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J

    move-result-wide v0

    long-to-int v1, v0

    rem-int/lit8 v8, v8, 0x20

    move/from16 v24, v1

    goto :goto_38b

    :cond_386
    move-object/from16 v29, v1

    move/from16 v25, v8

    const/4 v8, 0x0

    :goto_38b
    const/16 v0, 0x12

    if-lt v6, v0, :cond_399

    const/16 v0, 0x31

    if-gt v6, v0, :cond_399

    add-int/lit8 v0, v23, 0x1

    aput v14, v17, v23

    move/from16 v23, v0

    :cond_399
    move/from16 v16, v2

    move v2, v14

    :goto_39c
    add-int/lit8 v0, v21, 0x1

    aput v4, v11, v21

    add-int/lit8 v1, v0, 0x1

    and-int/lit16 v4, v3, 0x200

    if-eqz v4, :cond_3a9

    const/high16 v4, 0x20000000

    goto :goto_3aa

    :cond_3a9
    const/4 v4, 0x0

    :goto_3aa
    and-int/lit16 v3, v3, 0x100

    if-eqz v3, :cond_3b1

    const/high16 v3, 0x10000000

    goto :goto_3b2

    :cond_3b1
    const/4 v3, 0x0

    :goto_3b2
    if-eqz v5, :cond_3b7

    const/high16 v5, -0x80000000

    goto :goto_3b8

    :cond_3b7
    const/4 v5, 0x0

    :goto_3b8
    shl-int/lit8 v6, v6, 0x14

    or-int/2addr v3, v4

    or-int/2addr v3, v5

    or-int/2addr v3, v6

    or-int/2addr v2, v3

    aput v2, v11, v0

    add-int/lit8 v21, v1, 0x1

    shl-int/lit8 v0, v8, 0x14

    or-int v0, v0, v24

    aput v0, v11, v1

    move/from16 v4, v25

    move/from16 v2, v26

    move-object/from16 v0, v27

    move-object/from16 v1, v29

    move/from16 v14, v30

    move/from16 v13, v31

    const/4 v3, 0x0

    const v5, 0xd800

    goto/16 :goto_186

    :cond_3da
    move-object/from16 v27, v0

    move/from16 v31, v13

    move/from16 v30, v14

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzgf;

    invoke-virtual/range {v27 .. v27}, Lcom/google/android/gms/internal/play_billing/zzgl;->zza()Lcom/google/android/gms/internal/play_billing/zzgc;

    move-result-object v14

    invoke-virtual/range {v27 .. v27}, Lcom/google/android/gms/internal/play_billing/zzgl;->zzc()I

    move-result v15

    const/16 v16, 0x0

    move-object v9, v0

    move-object v10, v11

    move-object v11, v12

    move/from16 v12, v31

    move/from16 v13, v30

    move-object/from16 v20, p2

    move-object/from16 v21, p3

    move-object/from16 v22, p4

    move-object/from16 v23, p5

    move-object/from16 v24, p6

    invoke-direct/range {v9 .. v24}, Lcom/google/android/gms/internal/play_billing/zzgf;-><init>([I[Ljava/lang/Object;IILcom/google/android/gms/internal/play_billing/zzgc;IZ[IIILcom/google/android/gms/internal/play_billing/zzgh;Lcom/google/android/gms/internal/play_billing/zzfq;Lcom/google/android/gms/internal/play_billing/zzhd;Lcom/google/android/gms/internal/play_billing/zzek;Lcom/google/android/gms/internal/play_billing/zzfx;)V

    return-object v0

    :cond_401
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzha;

    const/4 v0, 0x0

    throw v0
.end method

.method private static zzm(Ljava/lang/Object;J)D
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Double;

    invoke-virtual {p0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide p0

    return-wide p0
.end method

.method private static zzn(Ljava/lang/Object;J)F
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Float;

    invoke-virtual {p0}, Ljava/lang/Float;->floatValue()F

    move-result p0

    return p0
.end method

.method private static zzo(Ljava/lang/Object;J)I
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Integer;

    invoke-virtual {p0}, Ljava/lang/Integer;->intValue()I

    move-result p0

    return p0
.end method

.method private final zzp(I)I
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    add-int/lit8 p1, p1, 0x2

    aget p1, v0, p1

    return p1
.end method

.method private final zzq(II)I
    .registers 8

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    array-length v0, v0

    div-int/lit8 v0, v0, 0x3

    const/4 v1, -0x1

    add-int/2addr v0, v1

    :goto_7
    if-gt p2, v0, :cond_1e

    add-int v2, v0, p2

    ushr-int/lit8 v2, v2, 0x1

    mul-int/lit8 v3, v2, 0x3

    iget-object v4, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v4, v4, v3

    if-ne p1, v4, :cond_16

    return v3

    :cond_16
    if-ge p1, v4, :cond_1b

    add-int/lit8 v0, v2, -0x1

    goto :goto_7

    :cond_1b
    add-int/lit8 p2, v2, 0x1

    goto :goto_7

    :cond_1e
    return v1
.end method

.method private static zzr(I)I
    .registers 1

    ushr-int/lit8 p0, p0, 0x14

    and-int/lit16 p0, p0, 0xff

    return p0
.end method

.method private final zzs(I)I
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    add-int/lit8 p1, p1, 0x1

    aget p1, v0, p1

    return p1
.end method

.method private static zzt(Ljava/lang/Object;J)J
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Long;

    invoke-virtual {p0}, Ljava/lang/Long;->longValue()J

    move-result-wide p0

    return-wide p0
.end method

.method private final zzu(I)Lcom/google/android/gms/internal/play_billing/zzfb;
    .registers 3

    div-int/lit8 p1, p1, 0x3

    add-int/2addr p1, p1

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzd:[Ljava/lang/Object;

    add-int/lit8 p1, p1, 0x1

    aget-object p1, v0, p1

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzfb;

    return-object p1
.end method

.method private final zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;
    .registers 5

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzd:[Ljava/lang/Object;

    div-int/lit8 p1, p1, 0x3

    add-int/2addr p1, p1

    aget-object v1, v0, p1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzgm;

    if-eqz v1, :cond_c

    return-object v1

    :cond_c
    add-int/lit8 v1, p1, 0x1

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzgk;->zza()Lcom/google/android/gms/internal/play_billing/zzgk;

    move-result-object v2

    aget-object v0, v0, v1

    check-cast v0, Ljava/lang/Class;

    invoke-virtual {v2, v0}, Lcom/google/android/gms/internal/play_billing/zzgk;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzd:[Ljava/lang/Object;

    aput-object v0, v1, p1

    return-object v0
.end method

.method private final zzw(I)Ljava/lang/Object;
    .registers 3

    div-int/lit8 p1, p1, 0x3

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzd:[Ljava/lang/Object;

    add-int/2addr p1, p1

    aget-object p1, v0, p1

    return-object p1
.end method

.method private final zzx(Ljava/lang/Object;I)Ljava/lang/Object;
    .registers 6

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v0

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzs(I)I

    move-result v1

    const v2, 0xfffff

    and-int/2addr v1, v2

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result p2

    if-nez p2, :cond_17

    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzgm;->zze()Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :cond_17
    int-to-long v1, v1

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzgf;->zzb:Lsun/misc/Unsafe;

    invoke-virtual {p2, p1, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzL(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_25

    return-object p1

    :cond_25
    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzgm;->zze()Ljava/lang/Object;

    move-result-object p2

    if-eqz p1, :cond_2e

    invoke-interface {v0, p2, p1}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzg(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_2e
    return-object p2
.end method

.method private final zzy(Ljava/lang/Object;II)Ljava/lang/Object;
    .registers 7

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v0

    invoke-direct {p0, p1, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result p2

    if-nez p2, :cond_f

    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzgm;->zze()Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :cond_f
    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzgf;->zzb:Lsun/misc/Unsafe;

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzs(I)I

    move-result p3

    const v1, 0xfffff

    and-int/2addr p3, v1

    int-to-long v1, p3

    invoke-virtual {p2, p1, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzL(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_25

    return-object p1

    :cond_25
    invoke-interface {v0}, Lcom/google/android/gms/internal/play_billing/zzgm;->zze()Ljava/lang/Object;

    move-result-object p2

    if-eqz p1, :cond_2e

    invoke-interface {v0, p2, p1}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzg(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_2e
    return-object p2
.end method

.method private static zzz(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    .registers 7

    :try_start_0
    invoke-virtual {p0, p1}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object p0
    :try_end_4
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_4} :catch_5

    return-object p0

    :catch_5
    invoke-virtual {p0}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v0

    array-length v1, v0

    const/4 v2, 0x0

    :goto_b
    if-ge v2, v1, :cond_1d

    aget-object v3, v0, v2

    invoke-virtual {v3}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1a

    return-object v3

    :cond_1a
    add-int/lit8 v2, v2, 0x1

    goto :goto_b

    :cond_1d
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object p0

    invoke-static {v0}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Field "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, " for "

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p0, " not found. Known fields are "

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v1, p0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
.end method


# virtual methods
.method public final zza(Ljava/lang/Object;)I
    .registers 20

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    sget-object v8, Lcom/google/android/gms/internal/play_billing/zzgf;->zzb:Lsun/misc/Unsafe;

    const v9, 0xfffff

    const/4 v10, 0x0

    const v0, 0xfffff

    const/4 v1, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    :goto_10
    iget-object v2, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    array-length v2, v2

    const/4 v3, 0x0

    if-ge v11, v2, :cond_5c6

    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzs(I)I

    move-result v2

    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzr(I)I

    move-result v4

    iget-object v5, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    add-int/lit8 v13, v11, 0x2

    aget v14, v5, v11

    aget v5, v5, v13

    and-int v13, v5, v9

    const/16 v15, 0x11

    const/16 v16, 0x1

    if-gt v4, v15, :cond_42

    if-eq v13, v0, :cond_3b

    if-ne v13, v9, :cond_34

    const/4 v0, 0x0

    goto :goto_39

    :cond_34
    int-to-long v0, v13

    invoke-virtual {v8, v7, v0, v1}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v0

    :goto_39
    move v1, v0

    move v0, v13

    :cond_3b
    ushr-int/lit8 v5, v5, 0x14

    shl-int v5, v16, v5

    move v13, v0

    move v15, v1

    goto :goto_45

    :cond_42
    move v13, v0

    move v15, v1

    const/4 v5, 0x0

    :goto_45
    and-int v0, v2, v9

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzep;->zzJ:Lcom/google/android/gms/internal/play_billing/zzep;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzep;->zza()I

    move-result v1

    if-lt v4, v1, :cond_54

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzep;->zzW:Lcom/google/android/gms/internal/play_billing/zzep;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzep;->zza()I

    :cond_54
    int-to-long v1, v0

    const/16 v17, 0x3f

    packed-switch v4, :pswitch_data_5dc

    goto/16 :goto_5bc

    :pswitch_5c
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_414

    :pswitch_68
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    shl-int/lit8 v0, v14, 0x3

    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzt(Ljava/lang/Object;J)J

    move-result-wide v1

    goto/16 :goto_433

    :pswitch_76
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    shl-int/lit8 v0, v14, 0x3

    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzo(Ljava/lang/Object;J)I

    move-result v1

    goto/16 :goto_456

    :pswitch_84
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    goto/16 :goto_5b2

    :pswitch_8c
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    goto/16 :goto_59b

    :pswitch_94
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    goto :goto_f3

    :pswitch_9b
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    shl-int/lit8 v0, v14, 0x3

    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzo(Ljava/lang/Object;J)I

    move-result v1

    goto/16 :goto_4a7

    :pswitch_a9
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    shl-int/lit8 v0, v14, 0x3

    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    goto/16 :goto_4c1

    :pswitch_b7
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_4e7

    :pswitch_c3
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    shl-int/lit8 v0, v14, 0x3

    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    instance-of v2, v1, Lcom/google/android/gms/internal/play_billing/zzdw;

    if-eqz v2, :cond_50a

    goto/16 :goto_509

    :pswitch_d5
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    goto/16 :goto_51f

    :pswitch_dd
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    goto/16 :goto_59b

    :pswitch_e5
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    goto/16 :goto_5b2

    :pswitch_ed
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    :goto_f3
    shl-int/lit8 v0, v14, 0x3

    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzo(Ljava/lang/Object;J)I

    move-result v1

    goto/16 :goto_55b

    :pswitch_fb
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    goto :goto_108

    :pswitch_102
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    :goto_108
    shl-int/lit8 v0, v14, 0x3

    invoke-static {v7, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzt(Ljava/lang/Object;J)J

    move-result-wide v1

    goto/16 :goto_583

    :pswitch_110
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    goto/16 :goto_59b

    :pswitch_118
    invoke-direct {v6, v7, v14, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_5bc

    goto/16 :goto_5b2

    :pswitch_120
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzw(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzfw;

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzfv;

    invoke-virtual {v0}, Ljava/util/AbstractMap;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_5bc

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzfw;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-nez v1, :cond_142

    goto/16 :goto_5bc

    :cond_142
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    throw v3

    :pswitch_14f
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v1

    sget v2, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-nez v2, :cond_163

    const/4 v4, 0x0

    goto :goto_175

    :cond_163
    const/4 v3, 0x0

    const/4 v4, 0x0

    :goto_165
    if-ge v3, v2, :cond_175

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/google/android/gms/internal/play_billing/zzgc;

    invoke-static {v14, v5, v1}, Lcom/google/android/gms/internal/play_billing/zzee;->zzt(ILcom/google/android/gms/internal/play_billing/zzgc;Lcom/google/android/gms/internal/play_billing/zzgm;)I

    move-result v5

    add-int/2addr v4, v5

    add-int/lit8 v3, v3, 0x1

    goto :goto_165

    :cond_175
    :goto_175
    add-int/2addr v12, v4

    goto/16 :goto_5bc

    :pswitch_178
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzj(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_5bc

    goto/16 :goto_235

    :pswitch_186
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzi(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_5bc

    goto/16 :goto_235

    :pswitch_194
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zze(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_5bc

    goto/16 :goto_235

    :pswitch_1a2
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzc(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_5bc

    goto/16 :goto_235

    :pswitch_1b0
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zza(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_5bc

    goto/16 :goto_235

    :pswitch_1be
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzk(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_5bc

    goto/16 :goto_235

    :pswitch_1cc
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    sget v1, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_5bc

    goto :goto_235

    :pswitch_1db
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzc(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_5bc

    goto :goto_235

    :pswitch_1e8
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zze(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_5bc

    goto :goto_235

    :pswitch_1f5
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzf(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_5bc

    goto :goto_235

    :pswitch_202
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzl(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_5bc

    goto :goto_235

    :pswitch_20f
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzg(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_5bc

    goto :goto_235

    :pswitch_21c
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzc(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_5bc

    goto :goto_235

    :pswitch_229
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zze(Ljava/util/List;)I

    move-result v0

    if-lez v0, :cond_5bc

    :goto_235
    shl-int/lit8 v1, v14, 0x3

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v2

    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v1

    add-int/2addr v1, v2

    add-int/2addr v1, v0

    :cond_241
    :goto_241
    add-int/2addr v12, v1

    goto/16 :goto_5bc

    :pswitch_244
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    sget v1, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_255

    :goto_252
    const/4 v0, 0x0

    goto/16 :goto_3fe

    :cond_255
    shl-int/lit8 v2, v14, 0x3

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzj(Ljava/util/List;)I

    move-result v0

    :goto_25b
    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v2

    mul-int v1, v1, v2

    goto/16 :goto_58b

    :pswitch_263
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    sget v1, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_272

    goto :goto_252

    :cond_272
    shl-int/lit8 v2, v14, 0x3

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzi(Ljava/util/List;)I

    move-result v0

    goto :goto_25b

    :pswitch_279
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    sget v1, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_288

    goto :goto_252

    :cond_288
    shl-int/lit8 v2, v14, 0x3

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zza(Ljava/util/List;)I

    move-result v0

    goto :goto_25b

    :pswitch_28f
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    sget v1, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_29e

    goto :goto_252

    :cond_29e
    shl-int/lit8 v2, v14, 0x3

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzk(Ljava/util/List;)I

    move-result v0

    goto :goto_25b

    :pswitch_2a5
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    sget v1, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_2b5

    const/4 v1, 0x0

    goto :goto_241

    :cond_2b5
    shl-int/lit8 v2, v14, 0x3

    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v2

    mul-int v1, v1, v2

    const/4 v2, 0x0

    :goto_2be
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    if-ge v2, v3, :cond_241

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/internal/play_billing/zzdw;

    invoke-virtual {v3}, Lcom/google/android/gms/internal/play_billing/zzdw;->zzd()I

    move-result v3

    invoke-static {v3}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v4

    add-int/2addr v4, v3

    add-int/2addr v1, v4

    add-int/lit8 v2, v2, 0x1

    goto :goto_2be

    :pswitch_2d7
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v1

    sget v2, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-nez v2, :cond_2eb

    const/4 v3, 0x0

    goto :goto_315

    :cond_2eb
    shl-int/lit8 v3, v14, 0x3

    invoke-static {v3}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v3

    mul-int v3, v3, v2

    const/4 v4, 0x0

    :goto_2f4
    if-ge v4, v2, :cond_315

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    instance-of v14, v5, Lcom/google/android/gms/internal/play_billing/zzfi;

    if-eqz v14, :cond_30b

    check-cast v5, Lcom/google/android/gms/internal/play_billing/zzfi;

    invoke-virtual {v5}, Lcom/google/android/gms/internal/play_billing/zzfi;->zza()I

    move-result v5

    invoke-static {v5}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v14

    add-int/2addr v14, v5

    add-int/2addr v3, v14

    goto :goto_312

    :cond_30b
    check-cast v5, Lcom/google/android/gms/internal/play_billing/zzgc;

    invoke-static {v5, v1}, Lcom/google/android/gms/internal/play_billing/zzee;->zzv(Lcom/google/android/gms/internal/play_billing/zzgc;Lcom/google/android/gms/internal/play_billing/zzgm;)I

    move-result v5

    add-int/2addr v3, v5

    :goto_312
    add-int/lit8 v4, v4, 0x1

    goto :goto_2f4

    :cond_315
    :goto_315
    add-int/2addr v12, v3

    goto/16 :goto_5bc

    :pswitch_318
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    sget v1, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_328

    goto/16 :goto_3d3

    :cond_328
    shl-int/lit8 v2, v14, 0x3

    instance-of v3, v0, Lcom/google/android/gms/internal/play_billing/zzfk;

    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v2

    mul-int v2, v2, v1

    if-eqz v3, :cond_358

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzfk;

    const/4 v3, 0x0

    :goto_337
    if-ge v3, v1, :cond_3e6

    invoke-interface {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzfk;->zzf(I)Ljava/lang/Object;

    move-result-object v4

    instance-of v5, v4, Lcom/google/android/gms/internal/play_billing/zzdw;

    if-eqz v5, :cond_34e

    check-cast v4, Lcom/google/android/gms/internal/play_billing/zzdw;

    invoke-virtual {v4}, Lcom/google/android/gms/internal/play_billing/zzdw;->zzd()I

    move-result v4

    invoke-static {v4}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v5

    add-int/2addr v5, v4

    add-int/2addr v2, v5

    goto :goto_355

    :cond_34e
    check-cast v4, Ljava/lang/String;

    invoke-static {v4}, Lcom/google/android/gms/internal/play_billing/zzee;->zzw(Ljava/lang/String;)I

    move-result v4

    add-int/2addr v2, v4

    :goto_355
    add-int/lit8 v3, v3, 0x1

    goto :goto_337

    :cond_358
    const/4 v3, 0x0

    :goto_359
    if-ge v3, v1, :cond_3e6

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    instance-of v5, v4, Lcom/google/android/gms/internal/play_billing/zzdw;

    if-eqz v5, :cond_370

    check-cast v4, Lcom/google/android/gms/internal/play_billing/zzdw;

    invoke-virtual {v4}, Lcom/google/android/gms/internal/play_billing/zzdw;->zzd()I

    move-result v4

    invoke-static {v4}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v5

    add-int/2addr v5, v4

    add-int/2addr v2, v5

    goto :goto_377

    :cond_370
    check-cast v4, Ljava/lang/String;

    invoke-static {v4}, Lcom/google/android/gms/internal/play_billing/zzee;->zzw(Ljava/lang/String;)I

    move-result v4

    add-int/2addr v2, v4

    :goto_377
    add-int/lit8 v3, v3, 0x1

    goto :goto_359

    :pswitch_37a
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    sget v1, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_38a

    goto/16 :goto_252

    :cond_38a
    shl-int/lit8 v1, v14, 0x3

    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    mul-int v0, v0, v1

    goto :goto_3fe

    :pswitch_395
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    sget v1, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_3a5

    goto/16 :goto_252

    :cond_3a5
    shl-int/lit8 v2, v14, 0x3

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzf(Ljava/util/List;)I

    move-result v0

    goto/16 :goto_25b

    :pswitch_3ad
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    sget v1, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_3bd

    goto/16 :goto_252

    :cond_3bd
    shl-int/lit8 v2, v14, 0x3

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzl(Ljava/util/List;)I

    move-result v0

    goto/16 :goto_25b

    :pswitch_3c5
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    sget v1, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_3d5

    :goto_3d3
    const/4 v2, 0x0

    goto :goto_3e6

    :cond_3d5
    shl-int/lit8 v1, v14, 0x3

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzg(Ljava/util/List;)I

    move-result v2

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v1

    mul-int v0, v0, v1

    add-int/2addr v2, v0

    :cond_3e6
    :goto_3e6
    add-int/2addr v12, v2

    goto/16 :goto_5bc

    :pswitch_3e9
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-static {v14, v0, v10}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzb(ILjava/util/List;Z)I

    move-result v0

    goto :goto_3fe

    :pswitch_3f4
    invoke-virtual {v8, v7, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-static {v14, v0, v10}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzd(ILjava/util/List;Z)I

    move-result v0

    :goto_3fe
    add-int/2addr v12, v0

    goto/16 :goto_5bc

    :pswitch_401
    move-object/from16 v0, p0

    move-wide v3, v1

    move-object/from16 v1, p1

    move v2, v11

    move-wide v9, v3

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    :goto_414
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzgc;

    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v1

    invoke-static {v14, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzee;->zzt(ILcom/google/android/gms/internal/play_billing/zzgc;Lcom/google/android/gms/internal/play_billing/zzgm;)I

    move-result v0

    goto :goto_3fe

    :pswitch_41f
    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    shl-int/lit8 v0, v14, 0x3

    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v1

    :goto_433
    add-long v3, v1, v1

    shr-long v1, v1, v17

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v0

    xor-long/2addr v1, v3

    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzee;->zzy(J)I

    move-result v1

    goto/16 :goto_58b

    :pswitch_442
    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    shl-int/lit8 v0, v14, 0x3

    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v1

    :goto_456
    add-int v2, v1, v1

    shr-int/lit8 v1, v1, 0x1f

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v0

    xor-int/2addr v1, v2

    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v1

    goto/16 :goto_58b

    :pswitch_465
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    goto/16 :goto_5b2

    :pswitch_474
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    goto/16 :goto_59b

    :pswitch_483
    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    goto/16 :goto_555

    :pswitch_493
    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    shl-int/lit8 v0, v14, 0x3

    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v1

    :goto_4a7
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v1

    goto/16 :goto_587

    :pswitch_4ad
    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    shl-int/lit8 v0, v14, 0x3

    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    :goto_4c1
    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzdw;

    sget v2, Lcom/google/android/gms/internal/play_billing/zzee;->zzb:I

    invoke-virtual {v1}, Lcom/google/android/gms/internal/play_billing/zzdw;->zzd()I

    move-result v1

    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v2

    add-int/2addr v2, v1

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v0

    add-int/2addr v0, v2

    goto/16 :goto_3fe

    :pswitch_4d5
    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    :goto_4e7
    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v1

    invoke-static {v14, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzh(ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzgm;)I

    move-result v0

    goto/16 :goto_3fe

    :pswitch_4f1
    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    shl-int/lit8 v0, v14, 0x3

    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    instance-of v2, v1, Lcom/google/android/gms/internal/play_billing/zzdw;

    if-eqz v2, :cond_50a

    :goto_509
    goto :goto_4c1

    :cond_50a
    check-cast v1, Ljava/lang/String;

    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzee;->zzw(Ljava/lang/String;)I

    move-result v1

    goto/16 :goto_587

    :pswitch_512
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    :goto_51f
    shl-int/lit8 v0, v14, 0x3

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_3fe

    :pswitch_529
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    goto/16 :goto_59b

    :pswitch_538
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    goto/16 :goto_5b2

    :pswitch_547
    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    :goto_555
    shl-int/lit8 v0, v14, 0x3

    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v1

    :goto_55b
    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzee;->zzu(I)I

    move-result v1

    goto :goto_587

    :pswitch_560
    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    goto :goto_57d

    :pswitch_56f
    move-wide v9, v1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    :goto_57d
    shl-int/lit8 v0, v14, 0x3

    invoke-virtual {v8, v7, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v1

    :goto_583
    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzee;->zzy(J)I

    move-result v1

    :goto_587
    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v0

    :goto_58b
    add-int/2addr v0, v1

    goto/16 :goto_3fe

    :pswitch_58e
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    :goto_59b
    shl-int/lit8 v0, v14, 0x3

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v0

    add-int/lit8 v0, v0, 0x4

    goto/16 :goto_3fe

    :pswitch_5a5
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v13

    move v4, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_5bc

    :goto_5b2
    shl-int/lit8 v0, v14, 0x3

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v0

    add-int/lit8 v0, v0, 0x8

    goto/16 :goto_3fe

    :cond_5bc
    :goto_5bc
    add-int/lit8 v11, v11, 0x3

    move v0, v13

    move v1, v15

    const v9, 0xfffff

    const/4 v10, 0x0

    goto/16 :goto_10

    :cond_5c6
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzm:Lcom/google/android/gms/internal/play_billing/zzhd;

    invoke-virtual {v0, v7}, Lcom/google/android/gms/internal/play_billing/zzhd;->zzd(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhd;->zza(Ljava/lang/Object;)I

    move-result v0

    add-int/2addr v12, v0

    iget-boolean v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzh:Z

    if-nez v0, :cond_5d6

    return v12

    :cond_5d6
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzn:Lcom/google/android/gms/internal/play_billing/zzek;

    invoke-virtual {v0, v7}, Lcom/google/android/gms/internal/play_billing/zzek;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzeo;

    throw v3

    :pswitch_data_5dc
    .packed-switch 0x0
        :pswitch_5a5
        :pswitch_58e
        :pswitch_56f
        :pswitch_560
        :pswitch_547
        :pswitch_538
        :pswitch_529
        :pswitch_512
        :pswitch_4f1
        :pswitch_4d5
        :pswitch_4ad
        :pswitch_493
        :pswitch_483
        :pswitch_474
        :pswitch_465
        :pswitch_442
        :pswitch_41f
        :pswitch_401
        :pswitch_3f4
        :pswitch_3e9
        :pswitch_3c5
        :pswitch_3ad
        :pswitch_395
        :pswitch_3f4
        :pswitch_3e9
        :pswitch_37a
        :pswitch_318
        :pswitch_2d7
        :pswitch_2a5
        :pswitch_28f
        :pswitch_279
        :pswitch_3e9
        :pswitch_3f4
        :pswitch_263
        :pswitch_244
        :pswitch_229
        :pswitch_21c
        :pswitch_20f
        :pswitch_202
        :pswitch_1f5
        :pswitch_1e8
        :pswitch_1db
        :pswitch_1cc
        :pswitch_1be
        :pswitch_1b0
        :pswitch_1a2
        :pswitch_194
        :pswitch_186
        :pswitch_178
        :pswitch_14f
        :pswitch_120
        :pswitch_118
        :pswitch_110
        :pswitch_102
        :pswitch_fb
        :pswitch_ed
        :pswitch_e5
        :pswitch_dd
        :pswitch_d5
        :pswitch_c3
        :pswitch_b7
        :pswitch_a9
        :pswitch_9b
        :pswitch_94
        :pswitch_8c
        :pswitch_84
        :pswitch_76
        :pswitch_68
        :pswitch_5c
    .end packed-switch
.end method

.method public final zzb(Ljava/lang/Object;)I
    .registers 10

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_2
    iget-object v2, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    array-length v2, v2

    if-ge v0, v2, :cond_12f

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzs(I)I

    move-result v2

    iget-object v3, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    const v4, 0xfffff

    and-int/2addr v4, v2

    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzr(I)I

    move-result v2

    aget v3, v3, v0

    int-to-long v4, v4

    const/16 v6, 0x25

    const/16 v7, 0x20

    packed-switch v2, :pswitch_data_148

    goto/16 :goto_12b

    :pswitch_21
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    goto/16 :goto_cf

    :pswitch_29
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    goto/16 :goto_a4

    :pswitch_31
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    goto :goto_4d

    :pswitch_38
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    goto/16 :goto_a4

    :pswitch_40
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    goto :goto_4d

    :pswitch_47
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    :goto_4d
    goto :goto_8f

    :pswitch_4e
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    goto :goto_8f

    :pswitch_55
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    goto/16 :goto_cf

    :pswitch_5d
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    goto/16 :goto_cf

    :pswitch_65
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    goto/16 :goto_e8

    :pswitch_6d
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    mul-int/lit8 v1, v1, 0x35

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzN(Ljava/lang/Object;J)Z

    move-result v2

    goto/16 :goto_fb

    :pswitch_7b
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    goto :goto_8f

    :pswitch_82
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    goto :goto_a4

    :pswitch_89
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    :goto_8f
    mul-int/lit8 v1, v1, 0x35

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzo(Ljava/lang/Object;J)I

    move-result v2

    goto/16 :goto_118

    :pswitch_97
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    goto :goto_a4

    :pswitch_9e
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    :goto_a4
    mul-int/lit8 v1, v1, 0x35

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzt(Ljava/lang/Object;J)J

    move-result-wide v2

    goto/16 :goto_124

    :pswitch_ac
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    mul-int/lit8 v1, v1, 0x35

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzn(Ljava/lang/Object;J)F

    move-result v2

    goto :goto_114

    :pswitch_b9
    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_12b

    mul-int/lit8 v1, v1, 0x35

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzm(Ljava/lang/Object;J)D

    move-result-wide v2

    goto :goto_120

    :pswitch_c6
    mul-int/lit8 v1, v1, 0x35

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_e6

    goto :goto_e2

    :goto_cf
    :pswitch_cf
    mul-int/lit8 v1, v1, 0x35

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    goto :goto_118

    :pswitch_da
    mul-int/lit8 v1, v1, 0x35

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_e6

    :goto_e2
    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v6

    :cond_e6
    add-int/2addr v1, v6

    goto :goto_12b

    :goto_e8
    :pswitch_e8
    mul-int/lit8 v1, v1, 0x35

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    goto :goto_118

    :pswitch_f5
    mul-int/lit8 v1, v1, 0x35

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzw(Ljava/lang/Object;J)Z

    move-result v2

    :goto_fb
    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzfd;->zza(Z)I

    move-result v2

    goto :goto_118

    :pswitch_100
    mul-int/lit8 v1, v1, 0x35

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result v2

    goto :goto_118

    :pswitch_107
    mul-int/lit8 v1, v1, 0x35

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd(Ljava/lang/Object;J)J

    move-result-wide v2

    goto :goto_124

    :pswitch_10e
    mul-int/lit8 v1, v1, 0x35

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzb(Ljava/lang/Object;J)F

    move-result v2

    :goto_114
    invoke-static {v2}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v2

    :goto_118
    add-int/2addr v1, v2

    goto :goto_12b

    :pswitch_11a
    mul-int/lit8 v1, v1, 0x35

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zza(Ljava/lang/Object;J)D

    move-result-wide v2

    :goto_120
    invoke-static {v2, v3}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v2

    :goto_124
    sget-object v4, Lcom/google/android/gms/internal/play_billing/zzfd;->zzd:[B

    ushr-long v4, v2, v7

    xor-long/2addr v2, v4

    long-to-int v3, v2

    add-int/2addr v1, v3

    :cond_12b
    :goto_12b
    add-int/lit8 v0, v0, 0x3

    goto/16 :goto_2

    :cond_12f
    mul-int/lit8 v1, v1, 0x35

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzm:Lcom/google/android/gms/internal/play_billing/zzhd;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzhd;->zzd(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    add-int/2addr v1, v0

    iget-boolean v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzh:Z

    if-nez v0, :cond_141

    return v1

    :cond_141
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzn:Lcom/google/android/gms/internal/play_billing/zzek;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzek;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzeo;

    const/4 p1, 0x0

    throw p1

    :pswitch_data_148
    .packed-switch 0x0
        :pswitch_11a
        :pswitch_10e
        :pswitch_107
        :pswitch_107
        :pswitch_100
        :pswitch_107
        :pswitch_100
        :pswitch_f5
        :pswitch_e8
        :pswitch_da
        :pswitch_cf
        :pswitch_100
        :pswitch_100
        :pswitch_100
        :pswitch_107
        :pswitch_100
        :pswitch_107
        :pswitch_c6
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_cf
        :pswitch_b9
        :pswitch_ac
        :pswitch_9e
        :pswitch_97
        :pswitch_89
        :pswitch_82
        :pswitch_7b
        :pswitch_6d
        :pswitch_65
        :pswitch_5d
        :pswitch_55
        :pswitch_4e
        :pswitch_47
        :pswitch_40
        :pswitch_38
        :pswitch_31
        :pswitch_29
        :pswitch_21
    .end packed-switch
.end method

.method final zzc(Ljava/lang/Object;[BIIILcom/google/android/gms/internal/play_billing/zzdj;)I
    .registers 42

    move-object/from16 v0, p0

    move-object/from16 v7, p1

    move-object/from16 v15, p2

    move/from16 v14, p4

    move/from16 v13, p5

    move-object/from16 v12, p6

    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzA(Ljava/lang/Object;)V

    sget-object v11, Lcom/google/android/gms/internal/play_billing/zzgf;->zzb:Lsun/misc/Unsafe;

    const/4 v8, 0x0

    move/from16 v1, p3

    const/4 v2, -0x1

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const v6, 0xfffff

    :goto_1b
    const/16 v16, 0x0

    if-ge v1, v14, :cond_c34

    add-int/lit8 v4, v1, 0x1

    aget-byte v1, v15, v1

    if-gez v1, :cond_2c

    invoke-static {v1, v15, v4, v12}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzi(I[BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    iget v4, v12, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    goto :goto_31

    :cond_2c
    move/from16 v34, v4

    move v4, v1

    move/from16 v1, v34

    :goto_31
    ushr-int/lit8 v9, v4, 0x3

    const/4 v10, 0x3

    if-le v9, v2, :cond_46

    div-int/2addr v3, v10

    iget v2, v0, Lcom/google/android/gms/internal/play_billing/zzgf;->zze:I

    if-lt v9, v2, :cond_44

    iget v2, v0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzf:I

    if-gt v9, v2, :cond_44

    invoke-direct {v0, v9, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzq(II)I

    move-result v2

    goto :goto_52

    :cond_44
    const/4 v2, -0x1

    goto :goto_52

    :cond_46
    iget v2, v0, Lcom/google/android/gms/internal/play_billing/zzgf;->zze:I

    if-lt v9, v2, :cond_55

    iget v2, v0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzf:I

    if-gt v9, v2, :cond_55

    invoke-direct {v0, v9, v8}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzq(II)I

    move-result v2

    :goto_52
    move v3, v2

    const/4 v2, -0x1

    goto :goto_57

    :cond_55
    const/4 v2, -0x1

    const/4 v3, -0x1

    :goto_57
    if-ne v3, v2, :cond_6b

    move v3, v1

    move/from16 v20, v5

    move/from16 v25, v6

    move v10, v9

    move-object/from16 v33, v11

    move-object v5, v12

    move v8, v13

    const/4 v11, 0x0

    const/16 v17, 0x0

    const/16 v18, -0x1

    move v12, v4

    goto/16 :goto_bdc

    :cond_6b
    and-int/lit8 v2, v4, 0x7

    iget-object v10, v0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    add-int/lit8 v19, v3, 0x1

    aget v8, v10, v19

    move/from16 v19, v4

    invoke-static {v8}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzr(I)I

    move-result v4

    const v17, 0xfffff

    and-int v13, v8, v17

    int-to-long v13, v13

    move/from16 v21, v9

    const/high16 v22, 0x20000000

    const-wide/16 v23, 0x0

    const-string v9, ""

    move-object/from16 v27, v9

    const/16 v9, 0x11

    if-gt v4, v9, :cond_3c7

    add-int/lit8 v9, v3, 0x2

    aget v9, v10, v9

    ushr-int/lit8 v10, v9, 0x14

    const/16 v25, 0x1

    shl-int v10, v25, v10

    move/from16 v30, v8

    const v8, 0xfffff

    and-int/2addr v9, v8

    if-eq v9, v6, :cond_bb

    if-eq v6, v8, :cond_ad

    move/from16 v25, v9

    int-to-long v8, v6

    invoke-virtual {v11, v7, v8, v9, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    move/from16 v5, v25

    const v8, 0xfffff

    goto :goto_ae

    :cond_ad
    move v5, v9

    :goto_ae
    if-ne v5, v8, :cond_b2

    const/4 v6, 0x0

    goto :goto_b7

    :cond_b2
    int-to-long v8, v5

    invoke-virtual {v11, v7, v8, v9}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v6

    :goto_b7
    move/from16 v25, v5

    move v5, v6

    goto :goto_bd

    :cond_bb
    move/from16 v25, v6

    :goto_bd
    packed-switch v4, :pswitch_data_c8a

    move v4, v1

    move v8, v3

    move/from16 v9, v19

    const/4 v1, 0x3

    const/16 v18, -0x1

    const/16 v19, 0x0

    if-ne v2, v1, :cond_3ab

    or-int/2addr v5, v10

    invoke-direct {v0, v7, v8}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzx(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object v1

    shl-int/lit8 v2, v21, 0x3

    or-int/lit8 v13, v2, 0x4

    invoke-direct {v0, v8}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v2

    move v3, v8

    const v6, 0xfffff

    const/16 v17, 0x0

    move-object v8, v1

    move v14, v9

    move/from16 v6, v21

    const v10, 0xfffff

    move-object v9, v2

    const v2, 0xfffff

    move-object/from16 v10, p2

    move-object v6, v11

    move v11, v4

    move-object v4, v12

    move/from16 v12, p4

    move/from16 p3, v5

    move/from16 v19, v14

    move/from16 v5, p4

    move-object/from16 v14, p6

    invoke-static/range {v8 .. v14}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzl(Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzgm;[BIIILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v8

    invoke-direct {v0, v7, v3, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzF(Ljava/lang/Object;ILjava/lang/Object;)V

    move/from16 v13, p5

    move-object v12, v4

    move v14, v5

    move-object v11, v6

    move v1, v8

    move/from16 v4, v19

    move/from16 v2, v21

    move/from16 v6, v25

    const/4 v8, 0x0

    move/from16 v5, p3

    goto/16 :goto_1b

    :pswitch_110
    if-nez v2, :cond_137

    or-int v8, v5, v10

    invoke-static {v15, v1, v12}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzk([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v9

    iget-wide v1, v12, Lcom/google/android/gms/internal/play_billing/zzdj;->zzb:J

    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzea;->zzc(J)J

    move-result-wide v5

    move-object v1, v11

    const/16 v18, -0x1

    move-object/from16 v2, p1

    move v10, v3

    move/from16 p3, v9

    move/from16 v9, v19

    move-wide v3, v13

    invoke-virtual/range {v1 .. v6}, Lsun/misc/Unsafe;->putLong(Ljava/lang/Object;JJ)V

    move/from16 v1, p3

    move/from16 v14, p4

    move/from16 v13, p5

    move v5, v8

    move v4, v9

    move v3, v10

    goto/16 :goto_3a4

    :cond_137
    const/16 v18, -0x1

    move v4, v1

    move v8, v5

    move-object v6, v11

    move-object v1, v12

    const v2, 0xfffff

    const/16 v17, 0x0

    goto/16 :goto_3b6

    :pswitch_144
    move v8, v3

    move/from16 v9, v19

    const/16 v18, -0x1

    if-nez v2, :cond_1c6

    or-int/2addr v5, v10

    invoke-static {v15, v1, v12}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    iget v2, v12, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzea;->zzb(I)I

    move-result v2

    goto/16 :goto_345

    :pswitch_158
    move v8, v3

    move/from16 v9, v19

    const/16 v18, -0x1

    if-nez v2, :cond_1c6

    invoke-static {v15, v1, v12}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    iget v2, v12, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    invoke-direct {v0, v8}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzu(I)Lcom/google/android/gms/internal/play_billing/zzfb;

    move-result-object v3

    const/high16 v4, -0x80000000

    and-int v4, v30, v4

    if-eqz v4, :cond_186

    if-eqz v3, :cond_186

    invoke-interface {v3, v2}, Lcom/google/android/gms/internal/play_billing/zzfb;->zza(I)Z

    move-result v3

    if-eqz v3, :cond_178

    goto :goto_186

    :cond_178
    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzd(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzhe;

    move-result-object v3

    int-to-long v13, v2

    invoke-static {v13, v14}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v3, v9, v2}, Lcom/google/android/gms/internal/play_billing/zzhe;->zzj(ILjava/lang/Object;)V

    goto/16 :goto_39e

    :cond_186
    :goto_186
    or-int/2addr v5, v10

    goto/16 :goto_345

    :pswitch_189
    move v8, v3

    move/from16 v9, v19

    const/4 v3, 0x2

    const/16 v18, -0x1

    if-ne v2, v3, :cond_1c6

    or-int/2addr v5, v10

    invoke-static {v15, v1, v12}, Lcom/google/android/gms/internal/play_billing/zzdk;->zza([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    :goto_196
    iget-object v2, v12, Lcom/google/android/gms/internal/play_billing/zzdj;->zzc:Ljava/lang/Object;

    invoke-virtual {v11, v7, v13, v14, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto/16 :goto_39e

    :pswitch_19d
    move v8, v3

    move/from16 v9, v19

    const/4 v3, 0x2

    const/16 v18, -0x1

    if-ne v2, v3, :cond_1c6

    or-int/2addr v10, v5

    invoke-direct {v0, v7, v8}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzx(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object v13

    invoke-direct {v0, v8}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v2

    move v4, v1

    move-object v1, v13

    move-object/from16 v3, p2

    move/from16 v5, p4

    move-object/from16 v6, p6

    invoke-static/range {v1 .. v6}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzm(Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzgm;[BIILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    invoke-direct {v0, v7, v8, v13}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzF(Ljava/lang/Object;ILjava/lang/Object;)V

    move/from16 v14, p4

    move/from16 v13, p5

    move v3, v8

    move v4, v9

    move v5, v10

    goto/16 :goto_3a4

    :cond_1c6
    move v4, v1

    goto/16 :goto_3ab

    :pswitch_1c9
    move v4, v1

    move v8, v3

    move/from16 v9, v19

    const/4 v1, 0x2

    const/16 v18, -0x1

    if-ne v2, v1, :cond_3ab

    and-int v1, v30, v22

    if-eqz v1, :cond_2cc

    or-int v1, v5, v10

    invoke-static {v15, v4, v12}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget v3, v12, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ltz v3, :cond_2c7

    if-nez v3, :cond_1eb

    move-object/from16 v6, v27

    iput-object v6, v12, Lcom/google/android/gms/internal/play_billing/zzdj;->zzc:Ljava/lang/Object;

    move/from16 v22, v1

    const/4 v6, 0x0

    goto/16 :goto_29c

    :cond_1eb
    sget v4, Lcom/google/android/gms/internal/play_billing/zzhs;->zza:I

    array-length v4, v15

    sub-int v5, v4, v2

    or-int v6, v2, v3

    sub-int/2addr v5, v3

    or-int/2addr v5, v6

    if-ltz v5, :cond_2a3

    add-int v4, v2, v3

    new-array v3, v3, [C

    const/4 v5, 0x0

    :goto_1fb
    if-ge v2, v4, :cond_20e

    aget-byte v6, v15, v2

    invoke-static {v6}, Lcom/google/android/gms/internal/play_billing/zzho;->zzd(B)Z

    move-result v10

    if-eqz v10, :cond_20e

    add-int/lit8 v2, v2, 0x1

    add-int/lit8 v10, v5, 0x1

    int-to-char v6, v6

    aput-char v6, v3, v5

    move v5, v10

    goto :goto_1fb

    :cond_20e
    :goto_20e
    if-ge v2, v4, :cond_291

    add-int/lit8 v6, v2, 0x1

    aget-byte v2, v15, v2

    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzho;->zzd(B)Z

    move-result v10

    if-eqz v10, :cond_233

    add-int/lit8 v10, v5, 0x1

    int-to-char v2, v2

    aput-char v2, v3, v5

    move v2, v6

    :goto_220
    move v5, v10

    if-ge v2, v4, :cond_20e

    aget-byte v6, v15, v2

    invoke-static {v6}, Lcom/google/android/gms/internal/play_billing/zzho;->zzd(B)Z

    move-result v10

    if-eqz v10, :cond_20e

    add-int/lit8 v2, v2, 0x1

    add-int/lit8 v10, v5, 0x1

    int-to-char v6, v6

    aput-char v6, v3, v5

    goto :goto_220

    :cond_233
    const/16 v10, -0x20

    if-ge v2, v10, :cond_24b

    if-ge v6, v4, :cond_246

    add-int/lit8 v10, v5, 0x1

    add-int/lit8 v16, v6, 0x1

    aget-byte v6, v15, v6

    invoke-static {v2, v6, v3, v5}, Lcom/google/android/gms/internal/play_billing/zzho;->zzc(BB[CI)V

    move v5, v10

    move/from16 v2, v16

    goto :goto_20e

    :cond_246
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzc()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_24b
    const/16 v10, -0x10

    if-ge v2, v10, :cond_26b

    add-int/lit8 v10, v4, -0x1

    if-ge v6, v10, :cond_266

    add-int/lit8 v10, v5, 0x1

    add-int/lit8 v16, v6, 0x1

    aget-byte v6, v15, v6

    add-int/lit8 v19, v16, 0x1

    move/from16 v22, v1

    aget-byte v1, v15, v16

    invoke-static {v2, v6, v1, v3, v5}, Lcom/google/android/gms/internal/play_billing/zzho;->zzb(BBB[CI)V

    move v5, v10

    move/from16 v2, v19

    goto :goto_289

    :cond_266
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzc()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_26b
    move/from16 v22, v1

    add-int/lit8 v1, v4, -0x2

    if-ge v6, v1, :cond_28c

    add-int/lit8 v1, v6, 0x1

    aget-byte v27, v15, v6

    add-int/lit8 v6, v1, 0x1

    aget-byte v28, v15, v1

    add-int/lit8 v1, v6, 0x1

    aget-byte v29, v15, v6

    move/from16 v26, v2

    move-object/from16 v30, v3

    move/from16 v31, v5

    invoke-static/range {v26 .. v31}, Lcom/google/android/gms/internal/play_billing/zzho;->zza(BBBB[CI)V

    add-int/lit8 v5, v5, 0x2

    move v2, v1

    :goto_289
    move/from16 v1, v22

    goto :goto_20e

    :cond_28c
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzc()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_291
    move/from16 v22, v1

    new-instance v1, Ljava/lang/String;

    const/4 v6, 0x0

    invoke-direct {v1, v3, v6, v5}, Ljava/lang/String;-><init>([CII)V

    iput-object v1, v12, Lcom/google/android/gms/internal/play_billing/zzdj;->zzc:Ljava/lang/Object;

    move v2, v4

    :goto_29c
    move v1, v2

    move/from16 v5, v22

    const/16 v19, 0x0

    goto/16 :goto_196

    :cond_2a3
    const/4 v6, 0x0

    new-instance v1, Ljava/lang/ArrayIndexOutOfBoundsException;

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v5, v6

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const/4 v4, 0x1

    aput-object v2, v5, v4

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const/4 v3, 0x2

    aput-object v2, v5, v3

    const-string v2, "buffer length=%d, index=%d, size=%d"

    invoke-static {v2, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_2c7
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzd()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_2cc
    move-object/from16 v6, v27

    const/16 v19, 0x0

    invoke-static {v15, v4, v12}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    iget v2, v12, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ltz v2, :cond_2ec

    or-int v3, v5, v10

    if-nez v2, :cond_2df

    iput-object v6, v12, Lcom/google/android/gms/internal/play_billing/zzdj;->zzc:Ljava/lang/Object;

    goto :goto_2e9

    :cond_2df
    new-instance v4, Ljava/lang/String;

    sget-object v5, Lcom/google/android/gms/internal/play_billing/zzfd;->zzb:Ljava/nio/charset/Charset;

    invoke-direct {v4, v15, v1, v2, v5}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    iput-object v4, v12, Lcom/google/android/gms/internal/play_billing/zzdj;->zzc:Ljava/lang/Object;

    add-int/2addr v1, v2

    :goto_2e9
    move v5, v3

    goto/16 :goto_196

    :cond_2ec
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzd()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :pswitch_2f1
    move v4, v1

    move v8, v3

    move/from16 v9, v19

    const/16 v18, -0x1

    const/16 v19, 0x0

    if-nez v2, :cond_3ab

    or-int/2addr v5, v10

    invoke-static {v15, v4, v12}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzk([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    iget-wide v2, v12, Lcom/google/android/gms/internal/play_billing/zzdj;->zzb:J

    cmp-long v4, v2, v23

    if-eqz v4, :cond_308

    const/4 v2, 0x1

    goto :goto_309

    :cond_308
    const/4 v2, 0x0

    :goto_309
    invoke-static {v7, v13, v14, v2}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzm(Ljava/lang/Object;JZ)V

    goto/16 :goto_39e

    :pswitch_30e
    move v4, v1

    move v8, v3

    move/from16 v9, v19

    const/4 v1, 0x5

    const/16 v18, -0x1

    const/16 v19, 0x0

    if-ne v2, v1, :cond_3ab

    add-int/lit8 v1, v4, 0x4

    or-int/2addr v5, v10

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzb([BI)I

    move-result v2

    goto :goto_345

    :pswitch_321
    move v4, v1

    move v8, v3

    move/from16 v9, v19

    const/4 v1, 0x1

    const/16 v18, -0x1

    const/16 v19, 0x0

    if-ne v2, v1, :cond_3ab

    add-int/lit8 v16, v4, 0x8

    or-int/2addr v10, v5

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzn([BI)J

    move-result-wide v5

    goto :goto_35a

    :pswitch_334
    move v4, v1

    move v8, v3

    move/from16 v9, v19

    const/16 v18, -0x1

    const/16 v19, 0x0

    if-nez v2, :cond_3ab

    or-int/2addr v5, v10

    invoke-static {v15, v4, v12}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    iget v2, v12, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    :goto_345
    invoke-virtual {v11, v7, v13, v14, v2}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto :goto_39e

    :pswitch_349
    move v4, v1

    move v8, v3

    move/from16 v9, v19

    const/16 v18, -0x1

    const/16 v19, 0x0

    if-nez v2, :cond_3ab

    or-int/2addr v10, v5

    invoke-static {v15, v4, v12}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzk([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v16

    iget-wide v5, v12, Lcom/google/android/gms/internal/play_billing/zzdj;->zzb:J

    :goto_35a
    move-object v1, v11

    move-object/from16 v2, p1

    move-wide v3, v13

    invoke-virtual/range {v1 .. v6}, Lsun/misc/Unsafe;->putLong(Ljava/lang/Object;JJ)V

    move/from16 v14, p4

    move/from16 v13, p5

    move v3, v8

    move v4, v9

    move v5, v10

    move/from16 v1, v16

    goto :goto_3a4

    :pswitch_36b
    move v4, v1

    move v8, v3

    move/from16 v9, v19

    const/4 v1, 0x5

    const/16 v18, -0x1

    const/16 v19, 0x0

    if-ne v2, v1, :cond_3ab

    add-int/lit8 v1, v4, 0x4

    or-int/2addr v5, v10

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzb([BI)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result v2

    invoke-static {v7, v13, v14, v2}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzp(Ljava/lang/Object;JF)V

    goto :goto_39e

    :pswitch_385
    move v4, v1

    move v8, v3

    move/from16 v9, v19

    const/4 v1, 0x1

    const/16 v18, -0x1

    const/16 v19, 0x0

    if-ne v2, v1, :cond_3ab

    add-int/lit8 v1, v4, 0x8

    or-int/2addr v5, v10

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzn([BI)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide v2

    invoke-static {v7, v13, v14, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzo(Ljava/lang/Object;JD)V

    :goto_39e
    move/from16 v14, p4

    move/from16 v13, p5

    move v3, v8

    move v4, v9

    :goto_3a4
    move/from16 v2, v21

    :goto_3a6
    move/from16 v6, v25

    const/4 v8, 0x0

    goto/16 :goto_1b

    :cond_3ab
    :goto_3ab
    move v3, v8

    move/from16 v19, v9

    move-object v6, v11

    move-object v1, v12

    const v2, 0xfffff

    const/16 v17, 0x0

    move v8, v5

    :goto_3b6
    move/from16 v5, p4

    move-object v5, v1

    move v11, v3

    move v3, v4

    move-object/from16 v33, v6

    move/from16 v20, v8

    move/from16 v12, v19

    move/from16 v10, v21

    move/from16 v8, p5

    goto/16 :goto_bdc

    :cond_3c7
    move/from16 v20, v5

    move/from16 v25, v6

    move/from16 v30, v8

    move-object v6, v11

    move-object/from16 v8, v27

    const/16 v17, 0x0

    const/16 v18, -0x1

    move/from16 v5, p4

    move v11, v1

    move-object v1, v12

    move/from16 v12, v21

    const/16 v9, 0x1b

    const/16 v27, 0xa

    if-ne v4, v9, :cond_42d

    const/4 v9, 0x2

    if-ne v2, v9, :cond_424

    invoke-virtual {v6, v7, v13, v14}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/play_billing/zzfc;

    invoke-interface {v2}, Lcom/google/android/gms/internal/play_billing/zzfc;->zzc()Z

    move-result v4

    if-nez v4, :cond_403

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v4

    if-nez v4, :cond_3f8

    const/16 v4, 0xa

    goto :goto_3fc

    :cond_3f8
    add-int v27, v4, v4

    move/from16 v4, v27

    :goto_3fc
    invoke-interface {v2, v4}, Lcom/google/android/gms/internal/play_billing/zzfc;->zzd(I)Lcom/google/android/gms/internal/play_billing/zzfc;

    move-result-object v2

    invoke-virtual {v6, v7, v13, v14, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    :cond_403
    move-object v13, v2

    invoke-direct {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v8

    const v2, 0xfffff

    move/from16 v9, v19

    move-object/from16 v10, p2

    move v4, v12

    move/from16 v12, p4

    move-object/from16 v14, p6

    invoke-static/range {v8 .. v14}, Lcom/google/android/gms/internal/play_billing/zzdk;->zze(Lcom/google/android/gms/internal/play_billing/zzgm;I[BIILcom/google/android/gms/internal/play_billing/zzfc;Lcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v8

    move/from16 v13, p5

    move-object v12, v1

    move v2, v4

    move v14, v5

    move-object v11, v6

    move v1, v8

    move/from16 v4, v19

    move/from16 v5, v20

    goto :goto_3a6

    :cond_424
    move-object/from16 v33, v6

    move v8, v11

    move v6, v5

    move-object v5, v1

    move/from16 v1, v19

    goto/16 :goto_a02

    :cond_42d
    const/16 v9, 0x31

    if-gt v4, v9, :cond_9c5

    move/from16 v9, v30

    int-to-long v9, v9

    move/from16 v30, v3

    sget-object v3, Lcom/google/android/gms/internal/play_billing/zzgf;->zzb:Lsun/misc/Unsafe;

    invoke-virtual {v3, v7, v13, v14}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v22

    move-object/from16 v31, v6

    move-object/from16 v6, v22

    check-cast v6, Lcom/google/android/gms/internal/play_billing/zzfc;

    invoke-interface {v6}, Lcom/google/android/gms/internal/play_billing/zzfc;->zzc()Z

    move-result v22

    if-nez v22, :cond_461

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v22

    if-nez v22, :cond_453

    move-object/from16 v32, v8

    const/16 v8, 0xa

    goto :goto_459

    :cond_453
    add-int v27, v22, v22

    move-object/from16 v32, v8

    move/from16 v8, v27

    :goto_459
    invoke-interface {v6, v8}, Lcom/google/android/gms/internal/play_billing/zzfc;->zzd(I)Lcom/google/android/gms/internal/play_billing/zzfc;

    move-result-object v6

    invoke-virtual {v3, v7, v13, v14, v6}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_463

    :cond_461
    move-object/from16 v32, v8

    :goto_463
    move-object v13, v6

    packed-switch v4, :pswitch_data_cb0

    move-object v9, v1

    move v14, v5

    move v8, v11

    move/from16 v7, v19

    move/from16 v11, v30

    move-object/from16 v33, v31

    const/4 v1, 0x3

    const v10, 0xfffff

    if-ne v2, v1, :cond_9a7

    and-int/lit8 v1, v7, -0x8

    or-int/lit8 v19, v1, 0x4

    invoke-direct {v0, v11}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v21

    move-object/from16 v1, v21

    move-object/from16 v2, p2

    move v3, v8

    move/from16 v4, p4

    move/from16 v5, v19

    move-object/from16 v6, p6

    invoke-static/range {v1 .. v6}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzc(Lcom/google/android/gms/internal/play_billing/zzgm;[BIIILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    :goto_48d
    iget-object v2, v9, Lcom/google/android/gms/internal/play_billing/zzdj;->zzc:Ljava/lang/Object;

    invoke-interface {v13, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_98d

    :pswitch_494
    const/4 v3, 0x2

    if-ne v2, v3, :cond_4c3

    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzfr;

    invoke-static {v15, v11, v1}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget v3, v1, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    add-int/2addr v3, v2

    :goto_4a0
    if-ge v2, v3, :cond_4b0

    invoke-static {v15, v2, v1}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzk([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget-wide v8, v1, Lcom/google/android/gms/internal/play_billing/zzdj;->zzb:J

    invoke-static {v8, v9}, Lcom/google/android/gms/internal/play_billing/zzea;->zzc(J)J

    move-result-wide v8

    invoke-virtual {v13, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzfr;->zzf(J)V

    goto :goto_4a0

    :cond_4b0
    if-ne v2, v3, :cond_4be

    move-object v9, v1

    move v1, v2

    move v14, v5

    move v8, v11

    move/from16 v7, v19

    move/from16 v11, v30

    move-object/from16 v33, v31

    goto/16 :goto_872

    :cond_4be
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzg()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_4c3
    if-nez v2, :cond_4f3

    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzfr;

    invoke-static {v15, v11, v1}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzk([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget-wide v3, v1, Lcom/google/android/gms/internal/play_billing/zzdj;->zzb:J

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/play_billing/zzea;->zzc(J)J

    move-result-wide v3

    invoke-virtual {v13, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzfr;->zzf(J)V

    :goto_4d4
    if-ge v2, v5, :cond_4f0

    invoke-static {v15, v2, v1}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v3

    iget v4, v1, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    move/from16 v14, v19

    if-ne v14, v4, :cond_544

    invoke-static {v15, v3, v1}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzk([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget-wide v3, v1, Lcom/google/android/gms/internal/play_billing/zzdj;->zzb:J

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/play_billing/zzea;->zzc(J)J

    move-result-wide v3

    invoke-virtual {v13, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzfr;->zzf(J)V

    move/from16 v19, v14

    goto :goto_4d4

    :cond_4f0
    move/from16 v14, v19

    goto :goto_544

    :cond_4f3
    move-object v9, v1

    move v14, v5

    move v8, v11

    move/from16 v7, v19

    move/from16 v11, v30

    move-object/from16 v33, v31

    goto/16 :goto_75b

    :pswitch_4fe
    move/from16 v14, v19

    const/4 v3, 0x2

    if-ne v2, v3, :cond_524

    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzey;

    invoke-static {v15, v11, v1}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget v3, v1, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    add-int/2addr v3, v2

    :goto_50c
    if-ge v2, v3, :cond_51c

    invoke-static {v15, v2, v1}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget v4, v1, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    invoke-static {v4}, Lcom/google/android/gms/internal/play_billing/zzea;->zzb(I)I

    move-result v4

    invoke-virtual {v13, v4}, Lcom/google/android/gms/internal/play_billing/zzey;->zzf(I)V

    goto :goto_50c

    :cond_51c
    if-ne v2, v3, :cond_51f

    goto :goto_544

    :cond_51f
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzg()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_524
    if-nez v2, :cond_552

    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzey;

    invoke-static {v15, v11, v1}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    :goto_52c
    iget v3, v1, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    invoke-static {v3}, Lcom/google/android/gms/internal/play_billing/zzea;->zzb(I)I

    move-result v3

    invoke-virtual {v13, v3}, Lcom/google/android/gms/internal/play_billing/zzey;->zzf(I)V

    if-ge v2, v5, :cond_544

    invoke-static {v15, v2, v1}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v3

    iget v4, v1, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ne v14, v4, :cond_544

    invoke-static {v15, v3, v1}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    goto :goto_52c

    :cond_544
    :goto_544
    move-object v9, v1

    move v1, v2

    move v8, v11

    move v7, v14

    move/from16 v11, v30

    move-object/from16 v33, v31

    const v10, 0xfffff

    move v14, v5

    goto/16 :goto_9a8

    :cond_552
    move-object v9, v1

    move v8, v11

    move v7, v14

    move/from16 v11, v30

    move-object/from16 v33, v31

    goto/16 :goto_605

    :pswitch_55b
    move/from16 v14, v19

    const/4 v3, 0x2

    if-ne v2, v3, :cond_56b

    invoke-static {v15, v11, v13, v1}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzf([BILcom/google/android/gms/internal/play_billing/zzfc;Lcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    move-object v10, v1

    move v8, v5

    move/from16 v9, v30

    move-object/from16 v33, v31

    goto :goto_580

    :cond_56b
    if-nez v2, :cond_5fc

    move-object v10, v1

    move v1, v14

    move-object/from16 v2, p2

    move/from16 v9, v30

    move v3, v11

    move/from16 v4, p4

    move v8, v5

    move-object v5, v13

    move-object/from16 v33, v31

    move-object/from16 v6, p6

    invoke-static/range {v1 .. v6}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzj(I[BIILcom/google/android/gms/internal/play_billing/zzfc;Lcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    :goto_580
    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzu(I)Lcom/google/android/gms/internal/play_billing/zzfb;

    move-result-object v1

    iget-object v3, v0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzm:Lcom/google/android/gms/internal/play_billing/zzhd;

    sget v4, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    if-eqz v1, :cond_5ef

    instance-of v4, v13, Ljava/util/RandomAccess;

    if-eqz v4, :cond_5c9

    invoke-interface {v13}, Ljava/util/List;->size()I

    move-result v4

    move/from16 p3, v2

    move-object/from16 v2, v16

    const/4 v5, 0x0

    const/4 v6, 0x0

    :goto_598
    if-ge v5, v4, :cond_5bf

    invoke-interface {v13, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/lang/Integer;

    invoke-virtual/range {v19 .. v19}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-interface {v1, v0}, Lcom/google/android/gms/internal/play_billing/zzfb;->zza(I)Z

    move-result v19

    if-eqz v19, :cond_5b6

    if-eq v5, v6, :cond_5b3

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {v13, v6, v0}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    :cond_5b3
    add-int/lit8 v6, v6, 0x1

    goto :goto_5ba

    :cond_5b6
    invoke-static {v7, v12, v0, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzo(Ljava/lang/Object;IILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzhd;)Ljava/lang/Object;

    move-result-object v2

    :goto_5ba
    add-int/lit8 v5, v5, 0x1

    move-object/from16 v0, p0

    goto :goto_598

    :cond_5bf
    if-eq v6, v4, :cond_5f1

    invoke-interface {v13, v6, v4}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_5f1

    :cond_5c9
    move/from16 p3, v2

    invoke-interface {v13}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    move-object/from16 v2, v16

    :cond_5d1
    :goto_5d1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_5f1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-interface {v1, v4}, Lcom/google/android/gms/internal/play_billing/zzfb;->zza(I)Z

    move-result v5

    if-nez v5, :cond_5d1

    invoke-static {v7, v12, v4, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzo(Ljava/lang/Object;IILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzhd;)Ljava/lang/Object;

    move-result-object v2

    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    goto :goto_5d1

    :cond_5ef
    move/from16 p3, v2

    :cond_5f1
    :goto_5f1
    move-object/from16 v0, p0

    move/from16 v1, p3

    move v7, v14

    :goto_5f6
    move v14, v8

    move v8, v11

    move v11, v9

    move-object v9, v10

    goto/16 :goto_872

    :cond_5fc
    move-object/from16 v33, v31

    move-object/from16 v0, p0

    move-object v9, v1

    move v8, v11

    move v7, v14

    move/from16 v11, v30

    :goto_605
    const v10, 0xfffff

    move v14, v5

    goto/16 :goto_9a7

    :pswitch_60b
    move-object v10, v1

    move v8, v5

    move/from16 v14, v19

    move/from16 v9, v30

    move-object/from16 v33, v31

    const/4 v0, 0x2

    if-ne v2, v0, :cond_698

    invoke-static {v15, v11, v10}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v0

    iget v1, v10, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ltz v1, :cond_65f

    array-length v2, v15

    sub-int/2addr v2, v0

    if-gt v1, v2, :cond_65a

    if-nez v1, :cond_62a

    :goto_624
    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzdw;->zzb:Lcom/google/android/gms/internal/play_billing/zzdw;

    invoke-interface {v13, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_632

    :cond_62a
    invoke-static {v15, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzdw;->zzl([BII)Lcom/google/android/gms/internal/play_billing/zzdw;

    move-result-object v2

    invoke-interface {v13, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/2addr v0, v1

    :goto_632
    if-ge v0, v8, :cond_655

    invoke-static {v15, v0, v10}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    iget v2, v10, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ne v14, v2, :cond_655

    invoke-static {v15, v1, v10}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v0

    iget v1, v10, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ltz v1, :cond_650

    array-length v2, v15

    sub-int/2addr v2, v0

    if-gt v1, v2, :cond_64b

    if-nez v1, :cond_62a

    goto :goto_624

    :cond_64b
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzg()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v0

    throw v0

    :cond_650
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzd()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v0

    throw v0

    :cond_655
    move v1, v0

    move v7, v14

    move-object/from16 v0, p0

    goto :goto_5f6

    :cond_65a
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzg()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v0

    throw v0

    :cond_65f
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzd()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v0

    throw v0

    :pswitch_664
    move-object v10, v1

    move v8, v5

    move/from16 v14, v19

    move/from16 v9, v30

    move-object/from16 v33, v31

    const/4 v0, 0x2

    if-ne v2, v0, :cond_698

    move-object/from16 v0, p0

    invoke-direct {v0, v9}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v1

    move v6, v8

    move-object v8, v1

    move v5, v9

    const v4, 0xfffff

    move v9, v14

    move-object v3, v10

    move-object/from16 v10, p2

    move v1, v11

    move v2, v12

    move/from16 v12, p4

    move v7, v14

    move-object/from16 v14, p6

    invoke-static/range {v8 .. v14}, Lcom/google/android/gms/internal/play_billing/zzdk;->zze(Lcom/google/android/gms/internal/play_billing/zzgm;I[BIILcom/google/android/gms/internal/play_billing/zzfc;Lcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v8

    move v12, v2

    move-object v9, v3

    move v11, v5

    move v14, v6

    const v10, 0xfffff

    move/from16 v34, v8

    move v8, v1

    move/from16 v1, v34

    goto/16 :goto_9a8

    :cond_698
    move-object/from16 v0, p0

    move v7, v14

    move v14, v8

    move v8, v11

    move v11, v9

    move-object v9, v10

    goto/16 :goto_75b

    :pswitch_6a1
    move-object v3, v1

    move v6, v5

    move v1, v11

    move/from16 v7, v19

    move/from16 v5, v30

    move-object/from16 v33, v31

    const v4, 0xfffff

    const/4 v8, 0x2

    if-ne v2, v8, :cond_757

    const-wide/32 v21, 0x20000000

    and-long v8, v9, v21

    cmp-long v2, v8, v23

    if-nez v2, :cond_6fb

    invoke-static {v15, v1, v3}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget v8, v3, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ltz v8, :cond_6f6

    move-object/from16 v11, v32

    if-nez v8, :cond_6c9

    :goto_6c5
    invoke-interface {v13, v11}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_6d4

    :cond_6c9
    new-instance v9, Ljava/lang/String;

    sget-object v10, Lcom/google/android/gms/internal/play_billing/zzfd;->zzb:Ljava/nio/charset/Charset;

    invoke-direct {v9, v15, v2, v8, v10}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    :goto_6d0
    invoke-interface {v13, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/2addr v2, v8

    :goto_6d4
    if-ge v2, v6, :cond_86d

    invoke-static {v15, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v8

    iget v9, v3, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ne v7, v9, :cond_86d

    invoke-static {v15, v8, v3}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget v8, v3, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ltz v8, :cond_6f1

    if-nez v8, :cond_6e9

    goto :goto_6c5

    :cond_6e9
    new-instance v9, Ljava/lang/String;

    sget-object v10, Lcom/google/android/gms/internal/play_billing/zzfd;->zzb:Ljava/nio/charset/Charset;

    invoke-direct {v9, v15, v2, v8, v10}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    goto :goto_6d0

    :cond_6f1
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzd()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_6f6
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzd()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_6fb
    move-object/from16 v11, v32

    invoke-static {v15, v1, v3}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget v8, v3, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ltz v8, :cond_752

    if-nez v8, :cond_70b

    :goto_707
    invoke-interface {v13, v11}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_71e

    :cond_70b
    add-int v9, v2, v8

    invoke-static {v15, v2, v9}, Lcom/google/android/gms/internal/play_billing/zzhs;->zze([BII)Z

    move-result v10

    if-eqz v10, :cond_74d

    new-instance v10, Ljava/lang/String;

    sget-object v14, Lcom/google/android/gms/internal/play_billing/zzfd;->zzb:Ljava/nio/charset/Charset;

    invoke-direct {v10, v15, v2, v8, v14}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    :goto_71a
    invoke-interface {v13, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move v2, v9

    :goto_71e
    if-ge v2, v6, :cond_86d

    invoke-static {v15, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v8

    iget v9, v3, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ne v7, v9, :cond_86d

    invoke-static {v15, v8, v3}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget v8, v3, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ltz v8, :cond_748

    if-nez v8, :cond_733

    goto :goto_707

    :cond_733
    add-int v9, v2, v8

    invoke-static {v15, v2, v9}, Lcom/google/android/gms/internal/play_billing/zzhs;->zze([BII)Z

    move-result v10

    if-eqz v10, :cond_743

    new-instance v10, Ljava/lang/String;

    sget-object v14, Lcom/google/android/gms/internal/play_billing/zzfd;->zzb:Ljava/nio/charset/Charset;

    invoke-direct {v10, v15, v2, v8, v14}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    goto :goto_71a

    :cond_743
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzc()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_748
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzd()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_74d
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzc()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_752
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzd()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_757
    move v8, v1

    move-object v9, v3

    move v11, v5

    move v14, v6

    :goto_75b
    const v10, 0xfffff

    goto/16 :goto_9a7

    :pswitch_760
    move-object v3, v1

    move v6, v5

    move v1, v11

    move/from16 v7, v19

    move/from16 v5, v30

    move-object/from16 v33, v31

    const v4, 0xfffff

    const/4 v8, 0x2

    if-ne v2, v8, :cond_794

    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzdl;

    invoke-static {v15, v1, v3}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget v8, v3, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    add-int/2addr v8, v2

    :goto_778
    if-ge v2, v8, :cond_78b

    invoke-static {v15, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzk([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget-wide v9, v3, Lcom/google/android/gms/internal/play_billing/zzdj;->zzb:J

    cmp-long v11, v9, v23

    if-eqz v11, :cond_786

    const/4 v9, 0x1

    goto :goto_787

    :cond_786
    const/4 v9, 0x0

    :goto_787
    invoke-virtual {v13, v9}, Lcom/google/android/gms/internal/play_billing/zzdl;->zze(Z)V

    goto :goto_778

    :cond_78b
    if-ne v2, v8, :cond_78f

    goto/16 :goto_86d

    :cond_78f
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzg()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_794
    if-nez v2, :cond_757

    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzdl;

    invoke-static {v15, v1, v3}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzk([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget-wide v8, v3, Lcom/google/android/gms/internal/play_billing/zzdj;->zzb:J

    cmp-long v10, v8, v23

    if-eqz v10, :cond_7a4

    :goto_7a2
    const/4 v8, 0x1

    goto :goto_7a5

    :cond_7a4
    const/4 v8, 0x0

    :goto_7a5
    invoke-virtual {v13, v8}, Lcom/google/android/gms/internal/play_billing/zzdl;->zze(Z)V

    if-ge v2, v6, :cond_86d

    invoke-static {v15, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v8

    iget v9, v3, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ne v7, v9, :cond_86d

    invoke-static {v15, v8, v3}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzk([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget-wide v8, v3, Lcom/google/android/gms/internal/play_billing/zzdj;->zzb:J

    cmp-long v10, v8, v23

    if-eqz v10, :cond_7a4

    goto :goto_7a2

    :pswitch_7bd
    move-object v3, v1

    move v6, v5

    move v1, v11

    move/from16 v7, v19

    move/from16 v5, v30

    move-object/from16 v33, v31

    const v4, 0xfffff

    const/4 v8, 0x2

    if-ne v2, v8, :cond_7ea

    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzey;

    invoke-static {v15, v1, v3}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget v8, v3, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    add-int/2addr v8, v2

    :goto_7d5
    if-ge v2, v8, :cond_7e1

    invoke-static {v15, v2}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzb([BI)I

    move-result v9

    invoke-virtual {v13, v9}, Lcom/google/android/gms/internal/play_billing/zzey;->zzf(I)V

    add-int/lit8 v2, v2, 0x4

    goto :goto_7d5

    :cond_7e1
    if-ne v2, v8, :cond_7e5

    goto/16 :goto_86d

    :cond_7e5
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzg()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_7ea
    const/4 v8, 0x5

    if-ne v2, v8, :cond_757

    add-int/lit8 v2, v1, 0x4

    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzey;

    invoke-static {v15, v1}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzb([BI)I

    move-result v8

    invoke-virtual {v13, v8}, Lcom/google/android/gms/internal/play_billing/zzey;->zzf(I)V

    :goto_7f8
    if-ge v2, v6, :cond_86d

    invoke-static {v15, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v8

    iget v9, v3, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ne v7, v9, :cond_86d

    invoke-static {v15, v8}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzb([BI)I

    move-result v2

    invoke-virtual {v13, v2}, Lcom/google/android/gms/internal/play_billing/zzey;->zzf(I)V

    add-int/lit8 v2, v8, 0x4

    goto :goto_7f8

    :pswitch_80c
    move-object v3, v1

    move v6, v5

    move v1, v11

    move/from16 v7, v19

    move/from16 v5, v30

    move-object/from16 v33, v31

    const v4, 0xfffff

    const/4 v8, 0x2

    if-ne v2, v8, :cond_838

    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzfr;

    invoke-static {v15, v1, v3}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget v8, v3, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    add-int/2addr v8, v2

    :goto_824
    if-ge v2, v8, :cond_830

    invoke-static {v15, v2}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzn([BI)J

    move-result-wide v9

    invoke-virtual {v13, v9, v10}, Lcom/google/android/gms/internal/play_billing/zzfr;->zzf(J)V

    add-int/lit8 v2, v2, 0x8

    goto :goto_824

    :cond_830
    if-ne v2, v8, :cond_833

    goto :goto_86d

    :cond_833
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzg()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_838
    const/4 v8, 0x1

    if-ne v2, v8, :cond_757

    add-int/lit8 v2, v1, 0x8

    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzfr;

    invoke-static {v15, v1}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzn([BI)J

    move-result-wide v8

    invoke-virtual {v13, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzfr;->zzf(J)V

    :goto_846
    if-ge v2, v6, :cond_86d

    invoke-static {v15, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v8

    iget v9, v3, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ne v7, v9, :cond_86d

    invoke-static {v15, v8}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzn([BI)J

    move-result-wide v9

    invoke-virtual {v13, v9, v10}, Lcom/google/android/gms/internal/play_billing/zzfr;->zzf(J)V

    add-int/lit8 v2, v8, 0x8

    goto :goto_846

    :pswitch_85a
    move-object v3, v1

    move v6, v5

    move v1, v11

    move/from16 v7, v19

    move/from16 v5, v30

    move-object/from16 v33, v31

    const v4, 0xfffff

    const/4 v8, 0x2

    if-ne v2, v8, :cond_877

    invoke-static {v15, v1, v13, v3}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzf([BILcom/google/android/gms/internal/play_billing/zzfc;Lcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    :cond_86d
    :goto_86d
    move v8, v1

    move v1, v2

    move-object v9, v3

    move v11, v5

    move v14, v6

    :goto_872
    const v10, 0xfffff

    goto/16 :goto_9a8

    :cond_877
    if-nez v2, :cond_757

    move v8, v1

    move v1, v7

    move-object/from16 v2, p2

    move-object v9, v3

    move v3, v8

    const v10, 0xfffff

    move/from16 v4, p4

    move v11, v5

    move-object v5, v13

    move v14, v6

    move-object/from16 v6, p6

    invoke-static/range {v1 .. v6}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzj(I[BIILcom/google/android/gms/internal/play_billing/zzfc;Lcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    goto/16 :goto_9a8

    :pswitch_88f
    move-object v9, v1

    move v14, v5

    move v8, v11

    move/from16 v7, v19

    move/from16 v11, v30

    move-object/from16 v33, v31

    const/4 v1, 0x2

    const v10, 0xfffff

    if-ne v2, v1, :cond_8bc

    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzfr;

    invoke-static {v15, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    iget v2, v9, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    add-int/2addr v2, v1

    :goto_8a7
    if-ge v1, v2, :cond_8b3

    invoke-static {v15, v1, v9}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzk([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    iget-wide v3, v9, Lcom/google/android/gms/internal/play_billing/zzdj;->zzb:J

    invoke-virtual {v13, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzfr;->zzf(J)V

    goto :goto_8a7

    :cond_8b3
    if-ne v1, v2, :cond_8b7

    goto/16 :goto_9a8

    :cond_8b7
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzg()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_8bc
    if-nez v2, :cond_9a7

    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzfr;

    invoke-static {v15, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzk([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    :goto_8c4
    iget-wide v2, v9, Lcom/google/android/gms/internal/play_billing/zzdj;->zzb:J

    invoke-virtual {v13, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzfr;->zzf(J)V

    if-ge v1, v14, :cond_9a8

    invoke-static {v15, v1, v9}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget v3, v9, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ne v7, v3, :cond_9a8

    invoke-static {v15, v2, v9}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzk([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    goto :goto_8c4

    :pswitch_8d8
    move-object v9, v1

    move v14, v5

    move v8, v11

    move/from16 v7, v19

    move/from16 v11, v30

    move-object/from16 v33, v31

    const/4 v1, 0x2

    const v10, 0xfffff

    if-ne v2, v1, :cond_909

    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzeq;

    invoke-static {v15, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    iget v2, v9, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    add-int/2addr v2, v1

    :goto_8f0
    if-ge v1, v2, :cond_900

    invoke-static {v15, v1}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzb([BI)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result v3

    invoke-virtual {v13, v3}, Lcom/google/android/gms/internal/play_billing/zzeq;->zze(F)V

    add-int/lit8 v1, v1, 0x4

    goto :goto_8f0

    :cond_900
    if-ne v1, v2, :cond_904

    goto/16 :goto_9a8

    :cond_904
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzg()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_909
    const/4 v1, 0x5

    if-ne v2, v1, :cond_9a7

    add-int/lit8 v1, v8, 0x4

    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzeq;

    invoke-static {v15, v8}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzb([BI)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result v2

    invoke-virtual {v13, v2}, Lcom/google/android/gms/internal/play_billing/zzeq;->zze(F)V

    :goto_91b
    if-ge v1, v14, :cond_9a8

    invoke-static {v15, v1, v9}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget v3, v9, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ne v7, v3, :cond_9a8

    invoke-static {v15, v2}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzb([BI)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result v1

    invoke-virtual {v13, v1}, Lcom/google/android/gms/internal/play_billing/zzeq;->zze(F)V

    add-int/lit8 v1, v2, 0x4

    goto :goto_91b

    :pswitch_933
    move-object v9, v1

    move v14, v5

    move v8, v11

    move/from16 v7, v19

    move/from16 v11, v30

    move-object/from16 v33, v31

    const/4 v1, 0x2

    const v10, 0xfffff

    if-ne v2, v1, :cond_963

    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzeg;

    invoke-static {v15, v8, v9}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    iget v2, v9, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    add-int/2addr v2, v1

    :goto_94b
    if-ge v1, v2, :cond_95b

    invoke-static {v15, v1}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzn([BI)J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide v3

    invoke-virtual {v13, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzeg;->zze(D)V

    add-int/lit8 v1, v1, 0x8

    goto :goto_94b

    :cond_95b
    if-ne v1, v2, :cond_95e

    goto :goto_9a8

    :cond_95e
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzg()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_963
    const/4 v1, 0x1

    if-ne v2, v1, :cond_9a7

    add-int/lit8 v1, v8, 0x8

    check-cast v13, Lcom/google/android/gms/internal/play_billing/zzeg;

    invoke-static {v15, v8}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzn([BI)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide v2

    invoke-virtual {v13, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzeg;->zze(D)V

    :goto_975
    if-ge v1, v14, :cond_9a8

    invoke-static {v15, v1, v9}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget v3, v9, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ne v7, v3, :cond_9a8

    invoke-static {v15, v2}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzn([BI)J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide v3

    invoke-virtual {v13, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzeg;->zze(D)V

    add-int/lit8 v1, v2, 0x8

    goto :goto_975

    :goto_98d
    if-ge v1, v14, :cond_9a8

    invoke-static {v15, v1, v9}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v3

    iget v2, v9, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-ne v7, v2, :cond_9a8

    move-object/from16 v1, v21

    move-object/from16 v2, p2

    move/from16 v4, p4

    move/from16 v5, v19

    move-object/from16 v6, p6

    invoke-static/range {v1 .. v6}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzc(Lcom/google/android/gms/internal/play_billing/zzgm;[BIIILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    goto/16 :goto_48d

    :cond_9a7
    :goto_9a7
    move v1, v8

    :cond_9a8
    :goto_9a8
    if-eq v1, v8, :cond_9bb

    move/from16 v13, p5

    move v4, v7

    move v3, v11

    move v2, v12

    move/from16 v5, v20

    move/from16 v6, v25

    move-object/from16 v11, v33

    const/4 v8, 0x0

    move-object/from16 v7, p1

    move-object v12, v9

    goto/16 :goto_1b

    :cond_9bb
    move/from16 v8, p5

    move v3, v1

    move-object v5, v9

    move v10, v12

    move v12, v7

    move-object/from16 v7, p1

    goto/16 :goto_bdc

    :cond_9c5
    move-object/from16 v33, v6

    move/from16 v7, v19

    move/from16 v9, v30

    move v6, v5

    move-object v5, v1

    move/from16 v34, v11

    move-object v11, v8

    move/from16 v8, v34

    const/16 v1, 0x32

    if-ne v4, v1, :cond_a0a

    const/4 v1, 0x2

    if-ne v2, v1, :cond_9ff

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzgf;->zzb:Lsun/misc/Unsafe;

    invoke-direct {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzw(I)Ljava/lang/Object;

    move-result-object v2

    move-object/from16 v7, p1

    invoke-virtual {v1, v7, v13, v14}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    move-object v4, v3

    check-cast v4, Lcom/google/android/gms/internal/play_billing/zzfw;

    invoke-virtual {v4}, Lcom/google/android/gms/internal/play_billing/zzfw;->zze()Z

    move-result v4

    if-nez v4, :cond_9fc

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzfw;->zza()Lcom/google/android/gms/internal/play_billing/zzfw;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/play_billing/zzfw;->zzb()Lcom/google/android/gms/internal/play_billing/zzfw;

    move-result-object v4

    invoke-static {v4, v3}, Lcom/google/android/gms/internal/play_billing/zzfx;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v1, v7, v13, v14, v4}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    :cond_9fc
    check-cast v2, Lcom/google/android/gms/internal/play_billing/zzfv;

    throw v16

    :cond_9ff
    move v1, v7

    move-object/from16 v7, p1

    :goto_a02
    move v11, v3

    move v3, v8

    move v10, v12

    move/from16 v8, p5

    move v12, v1

    goto/16 :goto_bdc

    :cond_a0a
    move v1, v7

    move-object/from16 v7, p1

    add-int/lit8 v19, v3, 0x2

    sget-object v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzb:Lsun/misc/Unsafe;

    aget v10, v10, v19

    const v19, 0xfffff

    and-int v10, v10, v19

    move/from16 v21, v8

    move/from16 v30, v9

    int-to-long v8, v10

    packed-switch v4, :pswitch_data_cf2

    :cond_a20
    move/from16 v30, v3

    move v10, v12

    move/from16 v4, v21

    move v12, v1

    goto/16 :goto_bc2

    :pswitch_a28
    const/4 v4, 0x3

    if-ne v2, v4, :cond_a20

    and-int/lit8 v2, v1, -0x8

    or-int/lit8 v13, v2, 0x4

    invoke-direct {v0, v7, v12, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzy(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object v2

    invoke-direct {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v9

    move/from16 v4, v21

    move-object v8, v2

    move-object/from16 v10, p2

    move v11, v4

    move v6, v12

    move/from16 v12, p4

    move-object/from16 v14, p6

    invoke-static/range {v8 .. v14}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzl(Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzgm;[BIIILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v8

    invoke-direct {v0, v7, v6, v3, v2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzG(Ljava/lang/Object;IILjava/lang/Object;)V

    move v12, v1

    move/from16 v30, v3

    move v10, v6

    move v1, v8

    goto/16 :goto_bc3

    :pswitch_a50
    move v10, v12

    move/from16 v4, v21

    if-nez v2, :cond_ae2

    invoke-static {v15, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzk([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget-wide v11, v5, Lcom/google/android/gms/internal/play_billing/zzdj;->zzb:J

    invoke-static {v11, v12}, Lcom/google/android/gms/internal/play_billing/zzea;->zzc(J)J

    move-result-wide v11

    invoke-static {v11, v12}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v11

    goto :goto_aae

    :pswitch_a64
    move v10, v12

    move/from16 v4, v21

    if-nez v2, :cond_ae2

    invoke-static {v15, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget v11, v5, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    invoke-static {v11}, Lcom/google/android/gms/internal/play_billing/zzea;->zzb(I)I

    move-result v11

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    goto :goto_aae

    :pswitch_a78
    move v10, v12

    move/from16 v4, v21

    if-nez v2, :cond_ae2

    invoke-static {v15, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget v11, v5, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    invoke-direct {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzu(I)Lcom/google/android/gms/internal/play_billing/zzfb;

    move-result-object v12

    if-eqz v12, :cond_a9d

    invoke-interface {v12, v11}, Lcom/google/android/gms/internal/play_billing/zzfb;->zza(I)Z

    move-result v12

    if-eqz v12, :cond_a90

    goto :goto_a9d

    :cond_a90
    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzd(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzhe;

    move-result-object v6

    int-to-long v8, v11

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v6, v1, v8}, Lcom/google/android/gms/internal/play_billing/zzhe;->zzj(ILjava/lang/Object;)V

    goto :goto_ab4

    :cond_a9d
    :goto_a9d
    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    goto :goto_aae

    :pswitch_aa2
    move v10, v12

    move/from16 v4, v21

    const/4 v11, 0x2

    if-ne v2, v11, :cond_ae2

    invoke-static {v15, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzdk;->zza([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget-object v11, v5, Lcom/google/android/gms/internal/play_billing/zzdj;->zzc:Ljava/lang/Object;

    :goto_aae
    invoke-virtual {v6, v7, v13, v14, v11}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-virtual {v6, v7, v8, v9, v10}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :goto_ab4
    move v12, v1

    move v1, v2

    move/from16 v30, v3

    goto/16 :goto_bc3

    :pswitch_aba
    move v10, v12

    move/from16 v4, v21

    const/4 v11, 0x2

    if-ne v2, v11, :cond_ae2

    invoke-direct {v0, v7, v10, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzy(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object v8

    invoke-direct {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v2

    move v12, v1

    const v9, 0xfffff

    move-object v1, v8

    move v11, v3

    move-object/from16 v3, p2

    move v13, v4

    move-object v14, v5

    move/from16 v5, p4

    move-object/from16 v6, p6

    invoke-static/range {v1 .. v6}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzm(Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzgm;[BIILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    invoke-direct {v0, v7, v10, v11, v8}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzG(Ljava/lang/Object;IILjava/lang/Object;)V

    move/from16 v30, v11

    move-object v5, v14

    goto/16 :goto_bc3

    :cond_ae2
    move v12, v1

    move/from16 v30, v3

    goto/16 :goto_bc2

    :pswitch_ae7
    move v10, v12

    move/from16 v4, v21

    move v12, v1

    move v1, v3

    const/4 v3, 0x2

    if-ne v2, v3, :cond_b25

    invoke-static {v15, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v2

    iget v3, v5, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    if-nez v3, :cond_afd

    invoke-virtual {v6, v7, v13, v14, v11}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    move/from16 v30, v1

    goto :goto_b1f

    :cond_afd
    and-int v11, v30, v22

    move/from16 v30, v1

    add-int v1, v2, v3

    if-eqz v11, :cond_b11

    invoke-static {v15, v2, v1}, Lcom/google/android/gms/internal/play_billing/zzhs;->zze([BII)Z

    move-result v11

    if-eqz v11, :cond_b0c

    goto :goto_b11

    :cond_b0c
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zzc()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_b11
    :goto_b11
    new-instance v11, Ljava/lang/String;

    move/from16 p3, v1

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzfd;->zzb:Ljava/nio/charset/Charset;

    invoke-direct {v11, v15, v2, v3, v1}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    invoke-virtual {v6, v7, v13, v14, v11}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    move/from16 v2, p3

    :goto_b1f
    invoke-virtual {v6, v7, v8, v9, v10}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    move v1, v2

    goto/16 :goto_bc3

    :cond_b25
    move/from16 v30, v1

    goto/16 :goto_bc2

    :pswitch_b29
    move/from16 v30, v3

    move v10, v12

    move/from16 v4, v21

    move v12, v1

    if-nez v2, :cond_bc2

    invoke-static {v15, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzk([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    iget-wide v2, v5, Lcom/google/android/gms/internal/play_billing/zzdj;->zzb:J

    cmp-long v11, v2, v23

    if-eqz v11, :cond_b3e

    const/16 v29, 0x1

    goto :goto_b40

    :cond_b3e
    const/16 v29, 0x0

    :goto_b40
    invoke-static/range {v29 .. v29}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    goto/16 :goto_bbb

    :pswitch_b46
    move/from16 v30, v3

    move v10, v12

    move/from16 v4, v21

    move v12, v1

    const/4 v1, 0x5

    if-ne v2, v1, :cond_bc2

    add-int/lit8 v1, v4, 0x4

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzb([BI)I

    move-result v2

    goto :goto_b74

    :pswitch_b56
    move/from16 v30, v3

    move v10, v12

    move/from16 v4, v21

    move v12, v1

    const/4 v1, 0x1

    if-ne v2, v1, :cond_bc2

    add-int/lit8 v1, v4, 0x8

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzn([BI)J

    move-result-wide v2

    goto :goto_b87

    :pswitch_b66
    move/from16 v30, v3

    move v10, v12

    move/from16 v4, v21

    move v12, v1

    if-nez v2, :cond_bc2

    invoke-static {v15, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzh([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    iget v2, v5, Lcom/google/android/gms/internal/play_billing/zzdj;->zza:I

    :goto_b74
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    goto :goto_bbb

    :pswitch_b79
    move/from16 v30, v3

    move v10, v12

    move/from16 v4, v21

    move v12, v1

    if-nez v2, :cond_bc2

    invoke-static {v15, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzk([BILcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    iget-wide v2, v5, Lcom/google/android/gms/internal/play_billing/zzdj;->zzb:J

    :goto_b87
    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    goto :goto_bbb

    :pswitch_b8c
    move/from16 v30, v3

    move v10, v12

    move/from16 v4, v21

    move v12, v1

    const/4 v1, 0x5

    if-ne v2, v1, :cond_bc2

    add-int/lit8 v1, v4, 0x4

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzb([BI)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    goto :goto_bbb

    :pswitch_ba4
    move/from16 v30, v3

    move v10, v12

    move/from16 v4, v21

    move v12, v1

    const/4 v1, 0x1

    if-ne v2, v1, :cond_bc2

    add-int/lit8 v1, v4, 0x8

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzn([BI)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    :goto_bbb
    invoke-virtual {v6, v7, v13, v14, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-virtual {v6, v7, v8, v9, v10}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto :goto_bc3

    :cond_bc2
    :goto_bc2
    move v1, v4

    :goto_bc3
    if-eq v1, v4, :cond_bd7

    move/from16 v14, p4

    move/from16 v13, p5

    move v2, v10

    move v4, v12

    move/from16 v6, v25

    move/from16 v3, v30

    move-object/from16 v11, v33

    const/4 v8, 0x0

    move-object v12, v5

    move/from16 v5, v20

    goto/16 :goto_1b

    :cond_bd7
    move/from16 v8, p5

    move v3, v1

    move/from16 v11, v30

    :goto_bdc
    if-ne v12, v8, :cond_be7

    if-eqz v8, :cond_be7

    move v1, v3

    move v4, v12

    move/from16 v5, v20

    move/from16 v6, v25

    goto :goto_c3b

    :cond_be7
    iget-boolean v1, v0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzh:Z

    if-eqz v1, :cond_c11

    iget-object v1, v5, Lcom/google/android/gms/internal/play_billing/zzdj;->zzd:Lcom/google/android/gms/internal/play_billing/zzej;

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzej;->zza:Lcom/google/android/gms/internal/play_billing/zzej;

    if-eq v1, v2, :cond_c11

    iget-object v2, v0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzg:Lcom/google/android/gms/internal/play_billing/zzgc;

    invoke-virtual {v1, v2, v10}, Lcom/google/android/gms/internal/play_billing/zzej;->zzb(Lcom/google/android/gms/internal/play_billing/zzgc;I)Lcom/google/android/gms/internal/play_billing/zzev;

    move-result-object v1

    if-nez v1, :cond_c0d

    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzd(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzhe;

    move-result-object v6

    move v1, v12

    move-object/from16 v2, p2

    const v9, 0xfffff

    move/from16 v4, p4

    move-object v5, v6

    move-object/from16 v6, p6

    invoke-static/range {v1 .. v6}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzg(I[BIILcom/google/android/gms/internal/play_billing/zzhe;Lcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    goto :goto_c23

    :cond_c0d
    move-object v1, v7

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzeu;

    throw v16

    :cond_c11
    const v9, 0xfffff

    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzd(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzhe;

    move-result-object v5

    move v1, v12

    move-object/from16 v2, p2

    move/from16 v4, p4

    move-object/from16 v6, p6

    invoke-static/range {v1 .. v6}, Lcom/google/android/gms/internal/play_billing/zzdk;->zzg(I[BIILcom/google/android/gms/internal/play_billing/zzhe;Lcom/google/android/gms/internal/play_billing/zzdj;)I

    move-result v1

    :goto_c23
    move/from16 v14, p4

    move v13, v8

    move v2, v10

    move v3, v11

    move v4, v12

    move/from16 v5, v20

    move/from16 v6, v25

    move-object/from16 v11, v33

    const/4 v8, 0x0

    move-object/from16 v12, p6

    goto/16 :goto_1b

    :cond_c34
    move/from16 v20, v5

    move/from16 v25, v6

    move-object/from16 v33, v11

    move v8, v13

    :goto_c3b
    const v9, 0xfffff

    if-eq v6, v9, :cond_c46

    int-to-long v2, v6

    move-object/from16 v6, v33

    invoke-virtual {v6, v7, v2, v3, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_c46
    iget v2, v0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzj:I

    :goto_c48
    iget v3, v0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzk:I

    if-ge v2, v3, :cond_c73

    iget-object v3, v0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzi:[I

    iget-object v5, v0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v3, v3, v2

    aget v5, v5, v3

    invoke-direct {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzs(I)I

    move-result v5

    and-int/2addr v5, v9

    int-to-long v5, v5

    invoke-static {v7, v5, v6}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    if-nez v5, :cond_c61

    goto :goto_c67

    :cond_c61
    invoke-direct {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzu(I)Lcom/google/android/gms/internal/play_billing/zzfb;

    move-result-object v6

    if-nez v6, :cond_c6a

    :goto_c67
    add-int/lit8 v2, v2, 0x1

    goto :goto_c48

    :cond_c6a
    check-cast v5, Lcom/google/android/gms/internal/play_billing/zzfw;

    invoke-direct {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzw(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/play_billing/zzfv;

    throw v16

    :cond_c73
    move/from16 v2, p4

    if-nez v8, :cond_c7f

    if-ne v1, v2, :cond_c7a

    goto :goto_c83

    :cond_c7a
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zze()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    :cond_c7f
    if-gt v1, v2, :cond_c84

    if-ne v4, v8, :cond_c84

    :goto_c83
    return v1

    :cond_c84
    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzff;->zze()Lcom/google/android/gms/internal/play_billing/zzff;

    move-result-object v1

    throw v1

    nop

    :pswitch_data_c8a
    .packed-switch 0x0
        :pswitch_385
        :pswitch_36b
        :pswitch_349
        :pswitch_349
        :pswitch_334
        :pswitch_321
        :pswitch_30e
        :pswitch_2f1
        :pswitch_1c9
        :pswitch_19d
        :pswitch_189
        :pswitch_334
        :pswitch_158
        :pswitch_30e
        :pswitch_321
        :pswitch_144
        :pswitch_110
    .end packed-switch

    :pswitch_data_cb0
    .packed-switch 0x12
        :pswitch_933
        :pswitch_8d8
        :pswitch_88f
        :pswitch_88f
        :pswitch_85a
        :pswitch_80c
        :pswitch_7bd
        :pswitch_760
        :pswitch_6a1
        :pswitch_664
        :pswitch_60b
        :pswitch_85a
        :pswitch_55b
        :pswitch_7bd
        :pswitch_80c
        :pswitch_4fe
        :pswitch_494
        :pswitch_933
        :pswitch_8d8
        :pswitch_88f
        :pswitch_88f
        :pswitch_85a
        :pswitch_80c
        :pswitch_7bd
        :pswitch_760
        :pswitch_85a
        :pswitch_55b
        :pswitch_7bd
        :pswitch_80c
        :pswitch_4fe
        :pswitch_494
    .end packed-switch

    :pswitch_data_cf2
    .packed-switch 0x33
        :pswitch_ba4
        :pswitch_b8c
        :pswitch_b79
        :pswitch_b79
        :pswitch_b66
        :pswitch_b56
        :pswitch_b46
        :pswitch_b29
        :pswitch_ae7
        :pswitch_aba
        :pswitch_aa2
        :pswitch_b66
        :pswitch_a78
        :pswitch_b46
        :pswitch_b56
        :pswitch_a64
        :pswitch_a50
        :pswitch_a28
    .end packed-switch
.end method

.method public final zze()Ljava/lang/Object;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzg:Lcom/google/android/gms/internal/play_billing/zzgc;

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzex;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzex;->zzi()Lcom/google/android/gms/internal/play_billing/zzex;

    move-result-object v0

    return-object v0
.end method

.method public final zzf(Ljava/lang/Object;)V
    .registers 9

    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzL(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_8

    goto/16 :goto_84

    :cond_8
    instance-of v0, p1, Lcom/google/android/gms/internal/play_billing/zzex;

    const/4 v1, 0x0

    if-eqz v0, :cond_1b

    move-object v0, p1

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzex;

    const v2, 0x7fffffff

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/play_billing/zzex;->zzq(I)V

    iput v1, v0, Lcom/google/android/gms/internal/play_billing/zzdg;->zza:I

    invoke-virtual {v0}, Lcom/google/android/gms/internal/play_billing/zzex;->zzo()V

    :cond_1b
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    :goto_1d
    array-length v2, v0

    if-ge v1, v2, :cond_76

    invoke-direct {p0, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzs(I)I

    move-result v2

    const v3, 0xfffff

    and-int/2addr v3, v2

    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzr(I)I

    move-result v2

    int-to-long v3, v3

    const/16 v5, 0x9

    if-eq v2, v5, :cond_60

    const/16 v5, 0x3c

    if-eq v2, v5, :cond_55

    const/16 v5, 0x44

    if-eq v2, v5, :cond_55

    packed-switch v2, :pswitch_data_86

    goto :goto_73

    :pswitch_3d
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzgf;->zzb:Lsun/misc/Unsafe;

    invoke-virtual {v2, p1, v3, v4}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_73

    move-object v6, v5

    check-cast v6, Lcom/google/android/gms/internal/play_billing/zzfw;

    invoke-virtual {v6}, Lcom/google/android/gms/internal/play_billing/zzfw;->zzc()V

    invoke-virtual {v2, p1, v3, v4, v5}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_73

    :pswitch_4f
    iget-object v2, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzl:Lcom/google/android/gms/internal/play_billing/zzfq;

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/play_billing/zzfq;->zza(Ljava/lang/Object;J)V

    goto :goto_73

    :cond_55
    iget-object v2, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v2, v2, v1

    invoke-direct {p0, p1, v2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_73

    goto :goto_66

    :cond_60
    :pswitch_60
    invoke-direct {p0, p1, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_73

    :goto_66
    invoke-direct {p0, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v2

    sget-object v5, Lcom/google/android/gms/internal/play_billing/zzgf;->zzb:Lsun/misc/Unsafe;

    invoke-virtual {v5, p1, v3, v4}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzf(Ljava/lang/Object;)V

    :cond_73
    :goto_73
    add-int/lit8 v1, v1, 0x3

    goto :goto_1d

    :cond_76
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzm:Lcom/google/android/gms/internal/play_billing/zzhd;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzhd;->zzg(Ljava/lang/Object;)V

    iget-boolean v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzh:Z

    if-eqz v0, :cond_84

    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzn:Lcom/google/android/gms/internal/play_billing/zzek;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzek;->zzb(Ljava/lang/Object;)V

    :cond_84
    :goto_84
    return-void

    nop

    :pswitch_data_86
    .packed-switch 0x11
        :pswitch_60
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_3d
    .end packed-switch
.end method

.method public final zzg(Ljava/lang/Object;Ljava/lang/Object;)V
    .registers 9

    invoke-static {p1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzA(Ljava/lang/Object;)V

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 v0, 0x0

    :goto_7
    iget-object v1, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    array-length v1, v1

    if-ge v0, v1, :cond_101

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzs(I)I

    move-result v1

    const v2, 0xfffff

    and-int/2addr v2, v1

    iget-object v3, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzr(I)I

    move-result v1

    aget v3, v3, v0

    int-to-long v4, v2

    packed-switch v1, :pswitch_data_112

    goto/16 :goto_fd

    :pswitch_22
    invoke-direct {p0, p2, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto :goto_34

    :pswitch_29
    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzC(Ljava/lang/Object;Ljava/lang/Object;I)V

    goto/16 :goto_fd

    :pswitch_2e
    invoke-direct {p0, p2, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v1

    if-eqz v1, :cond_fd

    :goto_34
    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    invoke-static {p1, v4, v5, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzs(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzE(Ljava/lang/Object;II)V

    goto/16 :goto_fd

    :pswitch_40
    sget v1, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/google/android/gms/internal/play_billing/zzfx;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-static {p1, v4, v5, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzs(Ljava/lang/Object;JLjava/lang/Object;)V

    goto/16 :goto_fd

    :pswitch_53
    iget-object v1, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzl:Lcom/google/android/gms/internal/play_billing/zzfq;

    invoke-virtual {v1, p1, p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzfq;->zzb(Ljava/lang/Object;Ljava/lang/Object;J)V

    goto/16 :goto_fd

    :pswitch_5a
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto/16 :goto_d7

    :pswitch_62
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto :goto_7e

    :pswitch_69
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto/16 :goto_d7

    :pswitch_71
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto :goto_7e

    :pswitch_78
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    :goto_7e
    goto :goto_c2

    :pswitch_7f
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto :goto_c2

    :pswitch_86
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto :goto_98

    :pswitch_8d
    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzB(Ljava/lang/Object;Ljava/lang/Object;I)V

    goto/16 :goto_fd

    :pswitch_92
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    :goto_98
    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    invoke-static {p1, v4, v5, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzs(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_fa

    :pswitch_a0
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzw(Ljava/lang/Object;J)Z

    move-result v1

    invoke-static {p1, v4, v5, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzm(Ljava/lang/Object;JZ)V

    goto :goto_fa

    :pswitch_ae
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto :goto_c2

    :pswitch_b5
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto :goto_d7

    :pswitch_bc
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    :goto_c2
    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result v1

    invoke-static {p1, v4, v5, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzq(Ljava/lang/Object;JI)V

    goto :goto_fa

    :pswitch_ca
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto :goto_d7

    :pswitch_d1
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    :goto_d7
    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd(Ljava/lang/Object;J)J

    move-result-wide v1

    invoke-static {p1, v4, v5, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzr(Ljava/lang/Object;JJ)V

    goto :goto_fa

    :pswitch_df
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzb(Ljava/lang/Object;J)F

    move-result v1

    invoke-static {p1, v4, v5, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzp(Ljava/lang/Object;JF)V

    goto :goto_fa

    :pswitch_ed
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzI(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zza(Ljava/lang/Object;J)D

    move-result-wide v1

    invoke-static {p1, v4, v5, v1, v2}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzo(Ljava/lang/Object;JD)V

    :goto_fa
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzD(Ljava/lang/Object;I)V

    :cond_fd
    :goto_fd
    add-int/lit8 v0, v0, 0x3

    goto/16 :goto_7

    :cond_101
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzm:Lcom/google/android/gms/internal/play_billing/zzhd;

    invoke-static {v0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzp(Lcom/google/android/gms/internal/play_billing/zzhd;Ljava/lang/Object;Ljava/lang/Object;)V

    iget-boolean p1, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzh:Z

    if-nez p1, :cond_10b

    return-void

    :cond_10b
    iget-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzn:Lcom/google/android/gms/internal/play_billing/zzek;

    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzek;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzeo;

    const/4 p1, 0x0

    throw p1

    :pswitch_data_112
    .packed-switch 0x0
        :pswitch_ed
        :pswitch_df
        :pswitch_d1
        :pswitch_ca
        :pswitch_bc
        :pswitch_b5
        :pswitch_ae
        :pswitch_a0
        :pswitch_92
        :pswitch_8d
        :pswitch_86
        :pswitch_7f
        :pswitch_78
        :pswitch_71
        :pswitch_69
        :pswitch_62
        :pswitch_5a
        :pswitch_8d
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_53
        :pswitch_40
        :pswitch_2e
        :pswitch_2e
        :pswitch_2e
        :pswitch_2e
        :pswitch_2e
        :pswitch_2e
        :pswitch_2e
        :pswitch_2e
        :pswitch_2e
        :pswitch_29
        :pswitch_22
        :pswitch_22
        :pswitch_22
        :pswitch_22
        :pswitch_22
        :pswitch_22
        :pswitch_22
        :pswitch_29
    .end packed-switch
.end method

.method public final zzh(Ljava/lang/Object;[BIILcom/google/android/gms/internal/play_billing/zzdj;)V
    .registers 13

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move v4, p4

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc(Ljava/lang/Object;[BIIILcom/google/android/gms/internal/play_billing/zzdj;)I

    return-void
.end method

.method public final zzi(Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzhv;)V
    .registers 21

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    move-object/from16 v8, p2

    iget-boolean v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzh:Z

    const/4 v9, 0x0

    if-nez v0, :cond_514

    iget-object v10, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    sget-object v11, Lcom/google/android/gms/internal/play_billing/zzgf;->zzb:Lsun/misc/Unsafe;

    const v12, 0xfffff

    const v0, 0xfffff

    const/4 v1, 0x0

    const/4 v14, 0x0

    :goto_17
    array-length v2, v10

    if-ge v14, v2, :cond_50a

    invoke-direct {v6, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzs(I)I

    move-result v2

    iget-object v3, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzr(I)I

    move-result v4

    aget v15, v3, v14

    const/16 v5, 0x11

    const/4 v13, 0x1

    if-gt v4, v5, :cond_48

    add-int/lit8 v5, v14, 0x2

    aget v3, v3, v5

    and-int v5, v3, v12

    if-eq v5, v0, :cond_3e

    if-ne v5, v12, :cond_37

    const/4 v0, 0x0

    goto :goto_3c

    :cond_37
    int-to-long v0, v5

    invoke-virtual {v11, v7, v0, v1}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v0

    :goto_3c
    move v1, v0

    move v0, v5

    :cond_3e
    ushr-int/lit8 v3, v3, 0x14

    shl-int v3, v13, v3

    move/from16 v16, v0

    move/from16 v17, v1

    move v5, v3

    goto :goto_4d

    :cond_48
    move/from16 v16, v0

    move/from16 v17, v1

    const/4 v5, 0x0

    :goto_4d
    and-int v0, v2, v12

    int-to-long v2, v0

    packed-switch v4, :pswitch_data_51a

    goto/16 :goto_4ff

    :pswitch_55
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_34c

    :pswitch_61
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzt(Ljava/lang/Object;J)J

    move-result-wide v0

    goto/16 :goto_369

    :pswitch_6d
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzo(Ljava/lang/Object;J)I

    move-result v0

    goto/16 :goto_382

    :pswitch_79
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzt(Ljava/lang/Object;J)J

    move-result-wide v0

    goto/16 :goto_39b

    :pswitch_85
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzo(Ljava/lang/Object;J)I

    move-result v0

    goto/16 :goto_3b4

    :pswitch_91
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzo(Ljava/lang/Object;J)I

    move-result v0

    goto/16 :goto_3cd

    :pswitch_9d
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzo(Ljava/lang/Object;J)I

    move-result v0

    goto/16 :goto_3e6

    :pswitch_a9
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_3ff

    :pswitch_b5
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_41a

    :pswitch_c1
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_437

    :pswitch_cd
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzN(Ljava/lang/Object;J)Z

    move-result v0

    goto/16 :goto_450

    :pswitch_d9
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzo(Ljava/lang/Object;J)I

    move-result v0

    goto/16 :goto_469

    :pswitch_e5
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzt(Ljava/lang/Object;J)J

    move-result-wide v0

    goto/16 :goto_482

    :pswitch_f1
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzo(Ljava/lang/Object;J)I

    move-result v0

    goto/16 :goto_49b

    :pswitch_fd
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzt(Ljava/lang/Object;J)J

    move-result-wide v0

    goto/16 :goto_4b4

    :pswitch_109
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzt(Ljava/lang/Object;J)J

    move-result-wide v0

    goto/16 :goto_4cc

    :pswitch_115
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzn(Ljava/lang/Object;J)F

    move-result v0

    goto/16 :goto_4e4

    :pswitch_121
    invoke-direct {v6, v7, v15, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-static {v7, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzm(Ljava/lang/Object;J)D

    move-result-wide v0

    goto/16 :goto_4fc

    :pswitch_12d
    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_135

    goto/16 :goto_4ff

    :cond_135
    invoke-direct {v6, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzw(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzfv;

    throw v9

    :pswitch_13c
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-direct {v6, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v2

    sget v3, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    if-eqz v1, :cond_4ff

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_4ff

    const/4 v3, 0x0

    :goto_155
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v4

    if-ge v3, v4, :cond_4ff

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    move-object v5, v8

    check-cast v5, Lcom/google/android/gms/internal/play_billing/zzef;

    invoke-virtual {v5, v0, v4, v2}, Lcom/google/android/gms/internal/play_billing/zzef;->zzq(ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzgm;)V

    add-int/lit8 v3, v3, 0x1

    goto :goto_155

    :pswitch_168
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v13}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzC(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_177
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v13}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzB(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_186
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v13}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzA(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_195
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v13}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzz(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_1a4
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v13}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzt(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_1b3
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v13}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzD(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_1c2
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    goto/16 :goto_2c1

    :pswitch_1ce
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    goto/16 :goto_2cb

    :pswitch_1d4
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    goto/16 :goto_2db

    :pswitch_1da
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    goto/16 :goto_2eb

    :pswitch_1e0
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    goto/16 :goto_2fb

    :pswitch_1e6
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    goto/16 :goto_30b

    :pswitch_1ec
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    goto/16 :goto_31b

    :pswitch_1f2
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    goto/16 :goto_32b

    :pswitch_1f8
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    const/4 v4, 0x0

    invoke-static {v0, v1, v8, v4}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzC(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_208
    const/4 v4, 0x0

    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v4}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzB(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_218
    const/4 v4, 0x0

    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v4}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzA(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_228
    const/4 v4, 0x0

    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v4}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzz(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_238
    const/4 v4, 0x0

    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v4}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzt(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_248
    const/4 v4, 0x0

    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v4}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzD(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_258
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    sget v2, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    if-eqz v1, :cond_4ff

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_4ff

    invoke-interface {v8, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhv;->zze(ILjava/util/List;)V

    goto/16 :goto_4ff

    :pswitch_271
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-direct {v6, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v2

    sget v3, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    if-eqz v1, :cond_4ff

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_4ff

    const/4 v4, 0x0

    :goto_28a
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-ge v4, v3, :cond_4ff

    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    move-object v5, v8

    check-cast v5, Lcom/google/android/gms/internal/play_billing/zzef;

    invoke-virtual {v5, v0, v3, v2}, Lcom/google/android/gms/internal/play_billing/zzef;->zzv(ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzgm;)V

    add-int/lit8 v4, v4, 0x1

    goto :goto_28a

    :pswitch_29d
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    sget v2, Lcom/google/android/gms/internal/play_billing/zzgo;->zza:I

    if-eqz v1, :cond_4ff

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_4ff

    invoke-interface {v8, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzG(ILjava/util/List;)V

    goto/16 :goto_4ff

    :pswitch_2b6
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    const/4 v13, 0x0

    :goto_2c1
    invoke-static {v0, v1, v8, v13}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzr(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_2c6
    const/4 v13, 0x0

    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    :goto_2cb
    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v13}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzu(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_2d6
    const/4 v13, 0x0

    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    :goto_2db
    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v13}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzv(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_2e6
    const/4 v13, 0x0

    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    :goto_2eb
    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v13}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzx(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_2f6
    const/4 v13, 0x0

    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    :goto_2fb
    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v13}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzE(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_306
    const/4 v13, 0x0

    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    :goto_30b
    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v13}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzy(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_316
    const/4 v13, 0x0

    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    :goto_31b
    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v13}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzw(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_326
    const/4 v13, 0x0

    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v0, v0, v14

    :goto_32b
    invoke-virtual {v11, v7, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, v8, v13}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzs(ILjava/util/List;Lcom/google/android/gms/internal/play_billing/zzhv;Z)V

    goto/16 :goto_4ff

    :pswitch_336
    const/4 v13, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-wide v3, v2

    move v2, v14

    move-wide v12, v3

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v12, v13}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    :goto_34c
    invoke-direct {v6, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v1

    invoke-interface {v8, v15, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzq(ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzgm;)V

    goto/16 :goto_4ff

    :pswitch_355
    move-wide v12, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v14

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v12, v13}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v0

    :goto_369
    invoke-interface {v8, v15, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzC(IJ)V

    goto/16 :goto_4ff

    :pswitch_36e
    move-wide v12, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v14

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v12, v13}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v0

    :goto_382
    invoke-interface {v8, v15, v0}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzA(II)V

    goto/16 :goto_4ff

    :pswitch_387
    move-wide v12, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v14

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v12, v13}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v0

    :goto_39b
    invoke-interface {v8, v15, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzy(IJ)V

    goto/16 :goto_4ff

    :pswitch_3a0
    move-wide v12, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v14

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v12, v13}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v0

    :goto_3b4
    invoke-interface {v8, v15, v0}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzw(II)V

    goto/16 :goto_4ff

    :pswitch_3b9
    move-wide v12, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v14

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v12, v13}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v0

    :goto_3cd
    invoke-interface {v8, v15, v0}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzi(II)V

    goto/16 :goto_4ff

    :pswitch_3d2
    move-wide v12, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v14

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v12, v13}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v0

    :goto_3e6
    invoke-interface {v8, v15, v0}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzH(II)V

    goto/16 :goto_4ff

    :pswitch_3eb
    move-wide v12, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v14

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v12, v13}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    :goto_3ff
    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzdw;

    invoke-interface {v8, v15, v0}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzd(ILcom/google/android/gms/internal/play_billing/zzdw;)V

    goto/16 :goto_4ff

    :pswitch_406
    move-wide v12, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v14

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v12, v13}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    :goto_41a
    invoke-direct {v6, v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v1

    invoke-interface {v8, v15, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzv(ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzgm;)V

    goto/16 :goto_4ff

    :pswitch_423
    move-wide v12, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v14

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v12, v13}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    :goto_437
    invoke-static {v15, v0, v8}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzO(ILjava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzhv;)V

    goto/16 :goto_4ff

    :pswitch_43c
    move-wide v12, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v14

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-static {v7, v12, v13}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzw(Ljava/lang/Object;J)Z

    move-result v0

    :goto_450
    invoke-interface {v8, v15, v0}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzb(IZ)V

    goto/16 :goto_4ff

    :pswitch_455
    move-wide v12, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v14

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v12, v13}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v0

    :goto_469
    invoke-interface {v8, v15, v0}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzk(II)V

    goto/16 :goto_4ff

    :pswitch_46e
    move-wide v12, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v14

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v12, v13}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v0

    :goto_482
    invoke-interface {v8, v15, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzm(IJ)V

    goto/16 :goto_4ff

    :pswitch_487
    move-wide v12, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v14

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v12, v13}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v0

    :goto_49b
    invoke-interface {v8, v15, v0}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzr(II)V

    goto/16 :goto_4ff

    :pswitch_4a0
    move-wide v12, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v14

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v12, v13}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v0

    :goto_4b4
    invoke-interface {v8, v15, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzJ(IJ)V

    goto :goto_4ff

    :pswitch_4b8
    move-wide v12, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v14

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-virtual {v11, v7, v12, v13}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v0

    :goto_4cc
    invoke-interface {v8, v15, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzt(IJ)V

    goto :goto_4ff

    :pswitch_4d0
    move-wide v12, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v14

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-static {v7, v12, v13}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzb(Ljava/lang/Object;J)F

    move-result v0

    :goto_4e4
    invoke-interface {v8, v15, v0}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzo(IF)V

    goto :goto_4ff

    :pswitch_4e8
    move-wide v12, v2

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v14

    move/from16 v3, v16

    move/from16 v4, v17

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_4ff

    invoke-static {v7, v12, v13}, Lcom/google/android/gms/internal/play_billing/zzhn;->zza(Ljava/lang/Object;J)D

    move-result-wide v0

    :goto_4fc
    invoke-interface {v8, v15, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhv;->zzf(ID)V

    :cond_4ff
    :goto_4ff
    add-int/lit8 v14, v14, 0x3

    move/from16 v0, v16

    move/from16 v1, v17

    const v12, 0xfffff

    goto/16 :goto_17

    :cond_50a
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzm:Lcom/google/android/gms/internal/play_billing/zzhd;

    invoke-virtual {v0, v7}, Lcom/google/android/gms/internal/play_billing/zzhd;->zzd(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1, v8}, Lcom/google/android/gms/internal/play_billing/zzhd;->zzi(Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzhv;)V

    return-void

    :cond_514
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzn:Lcom/google/android/gms/internal/play_billing/zzek;

    invoke-virtual {v0, v7}, Lcom/google/android/gms/internal/play_billing/zzek;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzeo;

    throw v9

    :pswitch_data_51a
    .packed-switch 0x0
        :pswitch_4e8
        :pswitch_4d0
        :pswitch_4b8
        :pswitch_4a0
        :pswitch_487
        :pswitch_46e
        :pswitch_455
        :pswitch_43c
        :pswitch_423
        :pswitch_406
        :pswitch_3eb
        :pswitch_3d2
        :pswitch_3b9
        :pswitch_3a0
        :pswitch_387
        :pswitch_36e
        :pswitch_355
        :pswitch_336
        :pswitch_326
        :pswitch_316
        :pswitch_306
        :pswitch_2f6
        :pswitch_2e6
        :pswitch_2d6
        :pswitch_2c6
        :pswitch_2b6
        :pswitch_29d
        :pswitch_271
        :pswitch_258
        :pswitch_248
        :pswitch_238
        :pswitch_228
        :pswitch_218
        :pswitch_208
        :pswitch_1f8
        :pswitch_1f2
        :pswitch_1ec
        :pswitch_1e6
        :pswitch_1e0
        :pswitch_1da
        :pswitch_1d4
        :pswitch_1ce
        :pswitch_1c2
        :pswitch_1b3
        :pswitch_1a4
        :pswitch_195
        :pswitch_186
        :pswitch_177
        :pswitch_168
        :pswitch_13c
        :pswitch_12d
        :pswitch_121
        :pswitch_115
        :pswitch_109
        :pswitch_fd
        :pswitch_f1
        :pswitch_e5
        :pswitch_d9
        :pswitch_cd
        :pswitch_c1
        :pswitch_b5
        :pswitch_a9
        :pswitch_9d
        :pswitch_91
        :pswitch_85
        :pswitch_79
        :pswitch_6d
        :pswitch_61
        :pswitch_55
    .end packed-switch
.end method

.method public final zzj(Ljava/lang/Object;Ljava/lang/Object;)Z
    .registers 10

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_2
    iget-object v2, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    array-length v2, v2

    if-ge v1, v2, :cond_1ba

    invoke-direct {p0, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzs(I)I

    move-result v2

    const v3, 0xfffff

    and-int v4, v2, v3

    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzr(I)I

    move-result v2

    int-to-long v4, v4

    packed-switch v2, :pswitch_data_1e0

    goto/16 :goto_1b6

    :pswitch_1a
    invoke-direct {p0, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzp(I)I

    move-result v2

    and-int/2addr v2, v3

    int-to-long v2, v2

    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result v6

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result v2

    if-ne v6, v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzF(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1b6

    goto/16 :goto_1b5

    :pswitch_3a
    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzF(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1b6

    goto/16 :goto_1b5

    :pswitch_4a
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzF(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_60
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd(Ljava/lang/Object;J)J

    move-result-wide v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd(Ljava/lang/Object;J)J

    move-result-wide v4

    cmp-long v6, v2, v4

    if-nez v6, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_74
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result v3

    if-ne v2, v3, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_86
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd(Ljava/lang/Object;J)J

    move-result-wide v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd(Ljava/lang/Object;J)J

    move-result-wide v4

    cmp-long v6, v2, v4

    if-nez v6, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_9a
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result v3

    if-ne v2, v3, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_ac
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result v3

    if-ne v2, v3, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_be
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result v3

    if-ne v2, v3, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_d0
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzF(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_e6
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzF(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_fc
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/play_billing/zzgo;->zzF(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_112
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzw(Ljava/lang/Object;J)Z

    move-result v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzw(Ljava/lang/Object;J)Z

    move-result v3

    if-ne v2, v3, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_124
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result v3

    if-ne v2, v3, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_136
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd(Ljava/lang/Object;J)J

    move-result-wide v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd(Ljava/lang/Object;J)J

    move-result-wide v4

    cmp-long v6, v2, v4

    if-nez v6, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_14a
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc(Ljava/lang/Object;J)I

    move-result v3

    if-ne v2, v3, :cond_1b5

    goto :goto_1b6

    :pswitch_15b
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd(Ljava/lang/Object;J)J

    move-result-wide v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd(Ljava/lang/Object;J)J

    move-result-wide v4

    cmp-long v6, v2, v4

    if-nez v6, :cond_1b5

    goto :goto_1b6

    :pswitch_16e
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd(Ljava/lang/Object;J)J

    move-result-wide v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd(Ljava/lang/Object;J)J

    move-result-wide v4

    cmp-long v6, v2, v4

    if-nez v6, :cond_1b5

    goto :goto_1b6

    :pswitch_181
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzb(Ljava/lang/Object;J)F

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzb(Ljava/lang/Object;J)F

    move-result v3

    invoke-static {v3}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v3

    if-ne v2, v3, :cond_1b5

    goto :goto_1b6

    :pswitch_19a
    invoke-direct {p0, p1, p2, v1}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzH(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_1b5

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zza(Ljava/lang/Object;J)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v2

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zza(Ljava/lang/Object;J)D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v4

    cmp-long v6, v2, v4

    if-nez v6, :cond_1b5

    goto :goto_1b6

    :cond_1b5
    :goto_1b5
    return v0

    :cond_1b6
    :goto_1b6
    add-int/lit8 v1, v1, 0x3

    goto/16 :goto_2

    :cond_1ba
    iget-object v1, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzm:Lcom/google/android/gms/internal/play_billing/zzhd;

    invoke-virtual {v1, p1}, Lcom/google/android/gms/internal/play_billing/zzhd;->zzd(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzm:Lcom/google/android/gms/internal/play_billing/zzhd;

    invoke-virtual {v2, p2}, Lcom/google/android/gms/internal/play_billing/zzhd;->zzd(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1cd

    return v0

    :cond_1cd
    iget-boolean v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzh:Z

    if-nez v0, :cond_1d3

    const/4 p1, 0x1

    return p1

    :cond_1d3
    iget-object v0, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzn:Lcom/google/android/gms/internal/play_billing/zzek;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/play_billing/zzek;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzeo;

    iget-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzgf;->zzn:Lcom/google/android/gms/internal/play_billing/zzek;

    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzek;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzeo;

    const/4 p1, 0x0

    throw p1

    nop

    :pswitch_data_1e0
    .packed-switch 0x0
        :pswitch_19a
        :pswitch_181
        :pswitch_16e
        :pswitch_15b
        :pswitch_14a
        :pswitch_136
        :pswitch_124
        :pswitch_112
        :pswitch_fc
        :pswitch_e6
        :pswitch_d0
        :pswitch_be
        :pswitch_ac
        :pswitch_9a
        :pswitch_86
        :pswitch_74
        :pswitch_60
        :pswitch_4a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_3a
        :pswitch_1a
        :pswitch_1a
        :pswitch_1a
        :pswitch_1a
        :pswitch_1a
        :pswitch_1a
        :pswitch_1a
        :pswitch_1a
        :pswitch_1a
        :pswitch_1a
        :pswitch_1a
        :pswitch_1a
        :pswitch_1a
        :pswitch_1a
        :pswitch_1a
        :pswitch_1a
        :pswitch_1a
        :pswitch_1a
    .end packed-switch
.end method

.method public final zzk(Ljava/lang/Object;)Z
    .registers 20

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    const v8, 0xfffff

    const/4 v9, 0x0

    const v0, 0xfffff

    const/4 v1, 0x0

    const/4 v10, 0x0

    :goto_d
    iget v2, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzj:I

    const/4 v11, 0x0

    const/4 v3, 0x1

    if-ge v10, v2, :cond_eb

    iget-object v2, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzi:[I

    iget-object v4, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    aget v12, v2, v10

    aget v13, v4, v12

    invoke-direct {v6, v12}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzs(I)I

    move-result v14

    iget-object v2, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzc:[I

    add-int/lit8 v4, v12, 0x2

    aget v2, v2, v4

    and-int v4, v2, v8

    ushr-int/lit8 v2, v2, 0x14

    shl-int v15, v3, v2

    if-eq v4, v0, :cond_3b

    if-eq v4, v8, :cond_36

    int-to-long v0, v4

    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzgf;->zzb:Lsun/misc/Unsafe;

    invoke-virtual {v2, v7, v0, v1}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v1

    :cond_36
    move/from16 v17, v1

    move/from16 v16, v4

    goto :goto_3f

    :cond_3b
    move/from16 v16, v0

    move/from16 v17, v1

    :goto_3f
    const/high16 v0, 0x10000000

    and-int/2addr v0, v14

    if-eqz v0, :cond_56

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v12

    move/from16 v3, v16

    move/from16 v4, v17

    move v5, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_55

    goto :goto_56

    :cond_55
    return v9

    :cond_56
    :goto_56
    invoke-static {v14}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzr(I)I

    move-result v0

    const/16 v1, 0x9

    if-eq v0, v1, :cond_c8

    const/16 v1, 0x11

    if-eq v0, v1, :cond_c8

    const/16 v1, 0x1b

    if-eq v0, v1, :cond_a0

    const/16 v1, 0x3c

    if-eq v0, v1, :cond_8f

    const/16 v1, 0x44

    if-eq v0, v1, :cond_8f

    const/16 v1, 0x31

    if-eq v0, v1, :cond_a0

    const/16 v1, 0x32

    if-eq v0, v1, :cond_78

    goto/16 :goto_e3

    :cond_78
    and-int v0, v14, v8

    int-to-long v0, v0

    invoke-static {v7, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzfw;

    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_88

    goto :goto_e3

    :cond_88
    invoke-direct {v6, v12}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzw(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzfv;

    throw v11

    :cond_8f
    invoke-direct {v6, v7, v13, v12}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzM(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_e3

    invoke-direct {v6, v12}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v0

    invoke-static {v7, v14, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzK(Ljava/lang/Object;ILcom/google/android/gms/internal/play_billing/zzgm;)Z

    move-result v0

    if-nez v0, :cond_e3

    return v9

    :cond_a0
    and-int v0, v14, v8

    int-to-long v0, v0

    invoke-static {v7, v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_e3

    invoke-direct {v6, v12}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v1

    const/4 v2, 0x0

    :goto_b4
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    if-ge v2, v3, :cond_e3

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v1, v3}, Lcom/google/android/gms/internal/play_billing/zzgm;->zzk(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_c5

    return v9

    :cond_c5
    add-int/lit8 v2, v2, 0x1

    goto :goto_b4

    :cond_c8
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v12

    move/from16 v3, v16

    move/from16 v4, v17

    move v5, v15

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzJ(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_e3

    invoke-direct {v6, v12}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzv(I)Lcom/google/android/gms/internal/play_billing/zzgm;

    move-result-object v0

    invoke-static {v7, v14, v0}, Lcom/google/android/gms/internal/play_billing/zzgf;->zzK(Ljava/lang/Object;ILcom/google/android/gms/internal/play_billing/zzgm;)Z

    move-result v0

    if-nez v0, :cond_e3

    return v9

    :cond_e3
    :goto_e3
    add-int/lit8 v10, v10, 0x1

    move/from16 v0, v16

    move/from16 v1, v17

    goto/16 :goto_d

    :cond_eb
    iget-boolean v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzh:Z

    if-nez v0, :cond_f0

    return v3

    :cond_f0
    iget-object v0, v6, Lcom/google/android/gms/internal/play_billing/zzgf;->zzn:Lcom/google/android/gms/internal/play_billing/zzek;

    invoke-virtual {v0, v7}, Lcom/google/android/gms/internal/play_billing/zzek;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/play_billing/zzeo;

    throw v11
.end method
