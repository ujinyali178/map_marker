.class final Lcom/google/android/gms/internal/auth/zzga;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/internal/auth/zzgi;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/google/android/gms/internal/auth/zzgi<",
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

.field private final zzg:Lcom/google/android/gms/internal/auth/zzfx;

.field private final zzh:[I

.field private final zzi:I

.field private final zzj:I

.field private final zzk:Lcom/google/android/gms/internal/auth/zzfl;

.field private final zzl:Lcom/google/android/gms/internal/auth/zzgz;

.field private final zzm:Lcom/google/android/gms/internal/auth/zzem;

.field private final zzn:Lcom/google/android/gms/internal/auth/zzgc;

.field private final zzo:Lcom/google/android/gms/internal/auth/zzfs;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const/4 v0, 0x0

    new-array v0, v0, [I

    sput-object v0, Lcom/google/android/gms/internal/auth/zzga;->zza:[I

    invoke-static {}, Lcom/google/android/gms/internal/auth/zzhj;->zzg()Lsun/misc/Unsafe;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/internal/auth/zzga;->zzb:Lsun/misc/Unsafe;

    return-void
.end method

.method private constructor <init>([I[Ljava/lang/Object;IILcom/google/android/gms/internal/auth/zzfx;IZ[IIILcom/google/android/gms/internal/auth/zzgc;Lcom/google/android/gms/internal/auth/zzfl;Lcom/google/android/gms/internal/auth/zzgz;Lcom/google/android/gms/internal/auth/zzem;Lcom/google/android/gms/internal/auth/zzfs;)V
    .registers 16

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    iput-object p2, p0, Lcom/google/android/gms/internal/auth/zzga;->zzd:[Ljava/lang/Object;

    iput p3, p0, Lcom/google/android/gms/internal/auth/zzga;->zze:I

    iput p4, p0, Lcom/google/android/gms/internal/auth/zzga;->zzf:I

    iput-object p8, p0, Lcom/google/android/gms/internal/auth/zzga;->zzh:[I

    iput p9, p0, Lcom/google/android/gms/internal/auth/zzga;->zzi:I

    iput p10, p0, Lcom/google/android/gms/internal/auth/zzga;->zzj:I

    iput-object p11, p0, Lcom/google/android/gms/internal/auth/zzga;->zzn:Lcom/google/android/gms/internal/auth/zzgc;

    iput-object p12, p0, Lcom/google/android/gms/internal/auth/zzga;->zzk:Lcom/google/android/gms/internal/auth/zzfl;

    iput-object p13, p0, Lcom/google/android/gms/internal/auth/zzga;->zzl:Lcom/google/android/gms/internal/auth/zzgz;

    iput-object p14, p0, Lcom/google/android/gms/internal/auth/zzga;->zzm:Lcom/google/android/gms/internal/auth/zzem;

    iput-object p5, p0, Lcom/google/android/gms/internal/auth/zzga;->zzg:Lcom/google/android/gms/internal/auth/zzfx;

    iput-object p15, p0, Lcom/google/android/gms/internal/auth/zzga;->zzo:Lcom/google/android/gms/internal/auth/zzfs;

    return-void
.end method

.method private final zzA(Ljava/lang/Object;II)V
    .registers 6

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzl(I)I

    move-result p3

    const v0, 0xfffff

    and-int/2addr p3, v0

    int-to-long v0, p3

    invoke-static {p1, v0, v1, p2}, Lcom/google/android/gms/internal/auth/zzhj;->zzn(Ljava/lang/Object;JI)V

    return-void
.end method

.method private final zzB(Ljava/lang/Object;ILjava/lang/Object;)V
    .registers 7

    sget-object v0, Lcom/google/android/gms/internal/auth/zzga;->zzb:Lsun/misc/Unsafe;

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/auth/zzga;->zzo(I)I

    move-result v1

    const v2, 0xfffff

    and-int/2addr v1, v2

    int-to-long v1, v1

    invoke-virtual {v0, p1, v1, v2, p3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/auth/zzga;->zzz(Ljava/lang/Object;I)V

    return-void
.end method

.method private final zzC(Ljava/lang/Object;IILjava/lang/Object;)V
    .registers 8

    sget-object v0, Lcom/google/android/gms/internal/auth/zzga;->zzb:Lsun/misc/Unsafe;

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzo(I)I

    move-result v1

    const v2, 0xfffff

    and-int/2addr v1, v2

    int-to-long v1, v1

    invoke-virtual {v0, p1, v1, v2, p4}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, p2, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzA(Ljava/lang/Object;II)V

    return-void
.end method

.method private final zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z
    .registers 4

    invoke-direct {p0, p1, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result p1

    invoke-direct {p0, p2, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result p2

    if-ne p1, p2, :cond_c

    const/4 p1, 0x1

    return p1

    :cond_c
    const/4 p1, 0x0

    return p1
.end method

.method private final zzE(Ljava/lang/Object;I)Z
    .registers 12

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/auth/zzga;->zzl(I)I

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

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/auth/zzga;->zzo(I)I

    move-result p2

    and-int v0, p2, v1

    invoke-static {p2}, Lcom/google/android/gms/internal/auth/zzga;->zzn(I)I

    move-result p2

    int-to-long v0, v0

    const-wide/16 v2, 0x0

    packed-switch p2, :pswitch_data_fc

    new-instance p1, Ljava/lang/IllegalArgumentException;

    invoke-direct {p1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw p1

    :pswitch_2a
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    if-eqz p1, :cond_31

    return v5

    :cond_31
    return v4

    :pswitch_32
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzd(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long v0, p1, v2

    if-eqz v0, :cond_3b

    return v5

    :cond_3b
    return v4

    :pswitch_3c
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_43

    return v5

    :cond_43
    return v4

    :pswitch_44
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzd(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long v0, p1, v2

    if-eqz v0, :cond_4d

    return v5

    :cond_4d
    return v4

    :pswitch_4e
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_55

    return v5

    :cond_55
    return v4

    :pswitch_56
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_5d

    return v5

    :cond_5d
    return v4

    :pswitch_5e
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_65

    return v5

    :cond_65
    return v4

    :pswitch_66
    sget-object p2, Lcom/google/android/gms/internal/auth/zzef;->zzb:Lcom/google/android/gms/internal/auth/zzef;

    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {p2, p1}, Lcom/google/android/gms/internal/auth/zzef;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_73

    return v5

    :cond_73
    return v4

    :pswitch_74
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    if-eqz p1, :cond_7b

    return v5

    :cond_7b
    return v4

    :pswitch_7c
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

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
    instance-of p2, p1, Lcom/google/android/gms/internal/auth/zzef;

    if-eqz p2, :cond_9c

    sget-object p2, Lcom/google/android/gms/internal/auth/zzef;->zzb:Lcom/google/android/gms/internal/auth/zzef;

    invoke-virtual {p2, p1}, Lcom/google/android/gms/internal/auth/zzef;->equals(Ljava/lang/Object;)Z

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
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzt(Ljava/lang/Object;J)Z

    move-result p1

    return p1

    :pswitch_a7
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_ae

    return v5

    :cond_ae
    return v4

    :pswitch_af
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzd(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long v0, p1, v2

    if-eqz v0, :cond_b8

    return v5

    :cond_b8
    return v4

    :pswitch_b9
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_c0

    return v5

    :cond_c0
    return v4

    :pswitch_c1
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzd(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long v0, p1, v2

    if-eqz v0, :cond_ca

    return v5

    :cond_ca
    return v4

    :pswitch_cb
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzd(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long v0, p1, v2

    if-eqz v0, :cond_d4

    return v5

    :cond_d4
    return v4

    :pswitch_d5
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzb(Ljava/lang/Object;J)F

    move-result p1

    invoke-static {p1}, Ljava/lang/Float;->floatToRawIntBits(F)I

    move-result p1

    if-eqz p1, :cond_e0

    return v5

    :cond_e0
    return v4

    :pswitch_e1
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zza(Ljava/lang/Object;J)D

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

    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

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

.method private final zzF(Ljava/lang/Object;IIII)Z
    .registers 7

    const v0, 0xfffff

    if-ne p3, v0, :cond_a

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

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

.method private static zzG(Ljava/lang/Object;ILcom/google/android/gms/internal/auth/zzgi;)Z
    .registers 5

    const v0, 0xfffff

    and-int/2addr p1, v0

    int-to-long v0, p1

    invoke-static {p0, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    invoke-interface {p2, p0}, Lcom/google/android/gms/internal/auth/zzgi;->zzi(Ljava/lang/Object;)Z

    move-result p0

    return p0
.end method

.method private static zzH(Ljava/lang/Object;)Z
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return p0

    :cond_4
    instance-of v0, p0, Lcom/google/android/gms/internal/auth/zzev;

    if-eqz v0, :cond_f

    check-cast p0, Lcom/google/android/gms/internal/auth/zzev;

    invoke-virtual {p0}, Lcom/google/android/gms/internal/auth/zzev;->zzm()Z

    move-result p0

    return p0

    :cond_f
    const/4 p0, 0x1

    return p0
.end method

.method private final zzI(Ljava/lang/Object;II)Z
    .registers 6

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzl(I)I

    move-result p3

    const v0, 0xfffff

    and-int/2addr p3, v0

    int-to-long v0, p3

    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result p1

    if-ne p1, p2, :cond_11

    const/4 p1, 0x1

    return p1

    :cond_11
    const/4 p1, 0x0

    return p1
.end method

.method static zzc(Ljava/lang/Object;)Lcom/google/android/gms/internal/auth/zzha;
    .registers 3

    check-cast p0, Lcom/google/android/gms/internal/auth/zzev;

    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzev;->zzc:Lcom/google/android/gms/internal/auth/zzha;

    invoke-static {}, Lcom/google/android/gms/internal/auth/zzha;->zza()Lcom/google/android/gms/internal/auth/zzha;

    move-result-object v1

    if-ne v0, v1, :cond_10

    invoke-static {}, Lcom/google/android/gms/internal/auth/zzha;->zzd()Lcom/google/android/gms/internal/auth/zzha;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/auth/zzev;->zzc:Lcom/google/android/gms/internal/auth/zzha;

    :cond_10
    return-object v0
.end method

.method static zzj(Ljava/lang/Class;Lcom/google/android/gms/internal/auth/zzfu;Lcom/google/android/gms/internal/auth/zzgc;Lcom/google/android/gms/internal/auth/zzfl;Lcom/google/android/gms/internal/auth/zzgz;Lcom/google/android/gms/internal/auth/zzem;Lcom/google/android/gms/internal/auth/zzfs;)Lcom/google/android/gms/internal/auth/zzga;
    .registers 37

    move-object/from16 v0, p1

    instance-of v1, v0, Lcom/google/android/gms/internal/auth/zzgh;

    if-eqz v1, :cond_3ee

    check-cast v0, Lcom/google/android/gms/internal/auth/zzgh;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/auth/zzgh;->zzd()Ljava/lang/String;

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

    sget-object v7, Lcom/google/android/gms/internal/auth/zzga;->zza:[I

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
    sget-object v9, Lcom/google/android/gms/internal/auth/zzga;->zzb:Lsun/misc/Unsafe;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/auth/zzgh;->zze()[Ljava/lang/Object;

    move-result-object v10

    invoke-virtual {v0}, Lcom/google/android/gms/internal/auth/zzgh;->zza()Lcom/google/android/gms/internal/auth/zzfx;

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
    if-ge v4, v2, :cond_3c9

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

    const/16 v5, 0x33

    if-lt v6, v5, :cond_286

    add-int/lit8 v5, v8, 0x1

    invoke-virtual {v1, v8}, Ljava/lang/String;->charAt(I)C

    move-result v8

    move/from16 v26, v2

    const v2, 0xd800

    if-lt v8, v2, :cond_213

    and-int/lit16 v8, v8, 0x1fff

    const/16 v28, 0xd

    :goto_1f9
    add-int/lit8 v29, v5, 0x1

    invoke-virtual {v1, v5}, Ljava/lang/String;->charAt(I)C

    move-result v5

    if-lt v5, v2, :cond_20e

    and-int/lit16 v2, v5, 0x1fff

    shl-int v2, v2, v28

    or-int/2addr v8, v2

    add-int/lit8 v28, v28, 0xd

    move/from16 v5, v29

    const v2, 0xd800

    goto :goto_1f9

    :cond_20e
    shl-int v2, v5, v28

    or-int/2addr v8, v2

    move/from16 v5, v29

    :cond_213
    add-int/lit8 v2, v6, -0x33

    move/from16 v28, v5

    const/16 v5, 0x9

    if-eq v2, v5, :cond_23b

    const/16 v5, 0x11

    if-ne v2, v5, :cond_220

    goto :goto_23b

    :cond_220
    const/16 v5, 0xc

    if-ne v2, v5, :cond_249

    invoke-virtual {v0}, Lcom/google/android/gms/internal/auth/zzgh;->zzc()I

    move-result v2

    const/4 v5, 0x1

    const/4 v5, 0x1

    if-eq v2, v5, :cond_230

    and-int/lit16 v2, v3, 0x800

    if-eqz v2, :cond_249

    :cond_230
    div-int/lit8 v2, v21, 0x3

    add-int/2addr v2, v2

    add-int/2addr v2, v5

    add-int/lit8 v5, v16, 0x1

    aget-object v16, v10, v16

    aput-object v16, v12, v2

    goto :goto_247

    :cond_23b
    :goto_23b
    div-int/lit8 v2, v21, 0x3

    add-int/2addr v2, v2

    const/4 v5, 0x1

    const/4 v5, 0x1

    add-int/2addr v2, v5

    add-int/lit8 v5, v16, 0x1

    aget-object v16, v10, v16

    aput-object v16, v12, v2

    :goto_247
    move/from16 v16, v5

    :cond_249
    add-int/2addr v8, v8

    aget-object v2, v10, v8

    instance-of v5, v2, Ljava/lang/reflect/Field;

    if-eqz v5, :cond_253

    check-cast v2, Ljava/lang/reflect/Field;

    goto :goto_25b

    :cond_253
    check-cast v2, Ljava/lang/String;

    invoke-static {v15, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzv(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v2

    aput-object v2, v10, v8

    :goto_25b
    move v5, v13

    move/from16 v29, v14

    invoke-virtual {v9, v2}, Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J

    move-result-wide v13

    long-to-int v2, v13

    add-int/lit8 v8, v8, 0x1

    aget-object v13, v10, v8

    instance-of v14, v13, Ljava/lang/reflect/Field;

    if-eqz v14, :cond_26e

    check-cast v13, Ljava/lang/reflect/Field;

    goto :goto_276

    :cond_26e
    check-cast v13, Ljava/lang/String;

    invoke-static {v15, v13}, Lcom/google/android/gms/internal/auth/zzga;->zzv(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v13

    aput-object v13, v10, v8

    :goto_276
    invoke-virtual {v9, v13}, Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J

    move-result-wide v13

    long-to-int v8, v13

    move/from16 v27, v5

    move/from16 v24, v8

    move/from16 v25, v28

    const/4 v8, 0x0

    move-object/from16 v28, v1

    goto/16 :goto_38b

    :cond_286
    move/from16 v26, v2

    move v5, v13

    move/from16 v29, v14

    add-int/lit8 v2, v16, 0x1

    aget-object v13, v10, v16

    check-cast v13, Ljava/lang/String;

    invoke-static {v15, v13}, Lcom/google/android/gms/internal/auth/zzga;->zzv(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v13

    const/16 v14, 0x9

    if-eq v6, v14, :cond_30b

    const/16 v14, 0x11

    if-ne v6, v14, :cond_29f

    goto/16 :goto_30b

    :cond_29f
    const/16 v14, 0x1b

    if-eq v6, v14, :cond_2fa

    const/16 v14, 0x31

    if-ne v6, v14, :cond_2a8

    goto :goto_2fa

    :cond_2a8
    const/16 v14, 0xc

    if-eq v6, v14, :cond_2e1

    const/16 v14, 0x1e

    if-eq v6, v14, :cond_2e1

    const/16 v14, 0x2c

    if-ne v6, v14, :cond_2b5

    goto :goto_2e1

    :cond_2b5
    const/16 v14, 0x32

    if-ne v6, v14, :cond_2dc

    add-int/lit8 v14, v22, 0x1

    aput v21, v17, v22

    div-int/lit8 v22, v21, 0x3

    add-int/lit8 v27, v2, 0x1

    aget-object v2, v10, v2

    add-int v22, v22, v22

    aput-object v2, v12, v22

    and-int/lit16 v2, v3, 0x800

    if-eqz v2, :cond_2d8

    add-int/lit8 v22, v22, 0x1

    add-int/lit8 v2, v27, 0x1

    aget-object v27, v10, v27

    aput-object v27, v12, v22

    move/from16 v27, v5

    move/from16 v22, v14

    goto :goto_2de

    :cond_2d8
    move/from16 v22, v14

    move/from16 v2, v27

    :cond_2dc
    move/from16 v27, v5

    :goto_2de
    const/4 v5, 0x1

    const/4 v5, 0x1

    goto :goto_319

    :cond_2e1
    :goto_2e1
    invoke-virtual {v0}, Lcom/google/android/gms/internal/auth/zzgh;->zzc()I

    move-result v14

    move/from16 v27, v5

    const/4 v5, 0x1

    const/4 v5, 0x1

    if-eq v14, v5, :cond_2ef

    and-int/lit16 v14, v3, 0x800

    if-eqz v14, :cond_319

    :cond_2ef
    div-int/lit8 v14, v21, 0x3

    add-int/2addr v14, v14

    add-int/2addr v14, v5

    add-int/lit8 v24, v2, 0x1

    aget-object v2, v10, v2

    aput-object v2, v12, v14

    goto :goto_308

    :cond_2fa
    :goto_2fa
    move/from16 v27, v5

    const/4 v5, 0x1

    const/4 v5, 0x1

    div-int/lit8 v14, v21, 0x3

    add-int/2addr v14, v14

    add-int/2addr v14, v5

    add-int/lit8 v24, v2, 0x1

    aget-object v2, v10, v2

    aput-object v2, v12, v14

    :goto_308
    move/from16 v2, v24

    goto :goto_319

    :cond_30b
    :goto_30b
    move/from16 v27, v5

    const/4 v5, 0x1

    const/4 v5, 0x1

    div-int/lit8 v14, v21, 0x3

    add-int/2addr v14, v14

    add-int/2addr v14, v5

    invoke-virtual {v13}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v24

    aput-object v24, v12, v14

    :cond_319
    :goto_319
    invoke-virtual {v9, v13}, Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J

    move-result-wide v13

    long-to-int v14, v13

    and-int/lit16 v13, v3, 0x1000

    const v24, 0xfffff

    if-eqz v13, :cond_374

    const/16 v13, 0x11

    if-gt v6, v13, :cond_374

    add-int/lit8 v13, v8, 0x1

    invoke-virtual {v1, v8}, Ljava/lang/String;->charAt(I)C

    move-result v8

    const v5, 0xd800

    if-lt v8, v5, :cond_34e

    and-int/lit16 v8, v8, 0x1fff

    const/16 v24, 0xd

    :goto_338
    add-int/lit8 v25, v13, 0x1

    invoke-virtual {v1, v13}, Ljava/lang/String;->charAt(I)C

    move-result v13

    if-lt v13, v5, :cond_34a

    and-int/lit16 v13, v13, 0x1fff

    shl-int v13, v13, v24

    or-int/2addr v8, v13

    add-int/lit8 v24, v24, 0xd

    move/from16 v13, v25

    goto :goto_338

    :cond_34a
    shl-int v13, v13, v24

    or-int/2addr v8, v13

    goto :goto_350

    :cond_34e
    move/from16 v25, v13

    :goto_350
    add-int v13, v7, v7

    div-int/lit8 v24, v8, 0x20

    add-int v13, v13, v24

    aget-object v5, v10, v13

    move-object/from16 v28, v1

    instance-of v1, v5, Ljava/lang/reflect/Field;

    if-eqz v1, :cond_361

    check-cast v5, Ljava/lang/reflect/Field;

    goto :goto_369

    :cond_361
    check-cast v5, Ljava/lang/String;

    invoke-static {v15, v5}, Lcom/google/android/gms/internal/auth/zzga;->zzv(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v5

    aput-object v5, v10, v13

    :goto_369
    move v13, v2

    invoke-virtual {v9, v5}, Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J

    move-result-wide v1

    long-to-int v2, v1

    rem-int/lit8 v8, v8, 0x20

    move/from16 v24, v2

    goto :goto_37a

    :cond_374
    move-object/from16 v28, v1

    move v13, v2

    move/from16 v25, v8

    const/4 v8, 0x0

    :goto_37a
    const/16 v1, 0x12

    if-lt v6, v1, :cond_388

    const/16 v1, 0x31

    if-gt v6, v1, :cond_388

    add-int/lit8 v1, v23, 0x1

    aput v14, v17, v23

    move/from16 v23, v1

    :cond_388
    move/from16 v16, v13

    move v2, v14

    :goto_38b
    add-int/lit8 v1, v21, 0x1

    aput v4, v11, v21

    add-int/lit8 v4, v1, 0x1

    and-int/lit16 v5, v3, 0x200

    if-eqz v5, :cond_398

    const/high16 v5, 0x20000000

    goto :goto_399

    :cond_398
    const/4 v5, 0x0

    :goto_399
    and-int/lit16 v13, v3, 0x100

    if-eqz v13, :cond_3a0

    const/high16 v13, 0x10000000

    goto :goto_3a1

    :cond_3a0
    const/4 v13, 0x0

    :goto_3a1
    and-int/lit16 v3, v3, 0x800

    if-eqz v3, :cond_3a8

    const/high16 v3, -0x80000000

    goto :goto_3a9

    :cond_3a8
    const/4 v3, 0x0

    :goto_3a9
    shl-int/lit8 v6, v6, 0x14

    or-int/2addr v5, v13

    or-int/2addr v3, v5

    or-int/2addr v3, v6

    or-int/2addr v2, v3

    aput v2, v11, v1

    add-int/lit8 v21, v4, 0x1

    shl-int/lit8 v1, v8, 0x14

    or-int v1, v1, v24

    aput v1, v11, v4

    move/from16 v4, v25

    move/from16 v2, v26

    move/from16 v13, v27

    move-object/from16 v1, v28

    move/from16 v14, v29

    const/4 v3, 0x0

    const v5, 0xd800

    goto/16 :goto_186

    :cond_3c9
    move/from16 v27, v13

    move/from16 v29, v14

    new-instance v1, Lcom/google/android/gms/internal/auth/zzga;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/auth/zzgh;->zza()Lcom/google/android/gms/internal/auth/zzfx;

    move-result-object v14

    invoke-virtual {v0}, Lcom/google/android/gms/internal/auth/zzgh;->zzc()I

    move-result v15

    const/16 v16, 0x0

    move-object v9, v1

    move-object v10, v11

    move-object v11, v12

    move/from16 v12, v27

    move/from16 v13, v29

    move-object/from16 v20, p2

    move-object/from16 v21, p3

    move-object/from16 v22, p4

    move-object/from16 v23, p5

    move-object/from16 v24, p6

    invoke-direct/range {v9 .. v24}, Lcom/google/android/gms/internal/auth/zzga;-><init>([I[Ljava/lang/Object;IILcom/google/android/gms/internal/auth/zzfx;IZ[IIILcom/google/android/gms/internal/auth/zzgc;Lcom/google/android/gms/internal/auth/zzfl;Lcom/google/android/gms/internal/auth/zzgz;Lcom/google/android/gms/internal/auth/zzem;Lcom/google/android/gms/internal/auth/zzfs;)V

    return-object v1

    :cond_3ee
    check-cast v0, Lcom/google/android/gms/internal/auth/zzgw;

    const/4 v0, 0x0

    throw v0
.end method

.method private static zzk(Ljava/lang/Object;J)I
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Integer;

    invoke-virtual {p0}, Ljava/lang/Integer;->intValue()I

    move-result p0

    return p0
.end method

.method private final zzl(I)I
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    add-int/lit8 p1, p1, 0x2

    aget p1, v0, p1

    return p1
.end method

.method private final zzm(II)I
    .registers 8

    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    array-length v0, v0

    div-int/lit8 v0, v0, 0x3

    const/4 v1, -0x1

    add-int/2addr v0, v1

    :goto_7
    if-gt p2, v0, :cond_1e

    add-int v2, v0, p2

    ushr-int/lit8 v2, v2, 0x1

    mul-int/lit8 v3, v2, 0x3

    iget-object v4, p0, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

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

.method private static zzn(I)I
    .registers 1

    ushr-int/lit8 p0, p0, 0x14

    and-int/lit16 p0, p0, 0xff

    return p0
.end method

.method private final zzo(I)I
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    add-int/lit8 p1, p1, 0x1

    aget p1, v0, p1

    return p1
.end method

.method private static zzp(Ljava/lang/Object;J)J
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Long;

    invoke-virtual {p0}, Ljava/lang/Long;->longValue()J

    move-result-wide p0

    return-wide p0
.end method

.method private final zzq(I)Lcom/google/android/gms/internal/auth/zzey;
    .registers 3

    div-int/lit8 p1, p1, 0x3

    add-int/2addr p1, p1

    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzd:[Ljava/lang/Object;

    add-int/lit8 p1, p1, 0x1

    aget-object p1, v0, p1

    check-cast p1, Lcom/google/android/gms/internal/auth/zzey;

    return-object p1
.end method

.method private final zzr(I)Lcom/google/android/gms/internal/auth/zzgi;
    .registers 5

    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzd:[Ljava/lang/Object;

    div-int/lit8 p1, p1, 0x3

    add-int/2addr p1, p1

    aget-object v0, v0, p1

    check-cast v0, Lcom/google/android/gms/internal/auth/zzgi;

    if-eqz v0, :cond_c

    return-object v0

    :cond_c
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzgf;->zza()Lcom/google/android/gms/internal/auth/zzgf;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/auth/zzga;->zzd:[Ljava/lang/Object;

    add-int/lit8 v2, p1, 0x1

    aget-object v1, v1, v2

    check-cast v1, Ljava/lang/Class;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/auth/zzgf;->zzb(Ljava/lang/Class;)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/auth/zzga;->zzd:[Ljava/lang/Object;

    aput-object v0, v1, p1

    return-object v0
.end method

.method private final zzs(I)Ljava/lang/Object;
    .registers 3

    div-int/lit8 p1, p1, 0x3

    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzd:[Ljava/lang/Object;

    add-int/2addr p1, p1

    aget-object p1, v0, p1

    return-object p1
.end method

.method private final zzt(Ljava/lang/Object;I)Ljava/lang/Object;
    .registers 6

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/auth/zzga;->zzr(I)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v0

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/auth/zzga;->zzo(I)I

    move-result v1

    const v2, 0xfffff

    and-int/2addr v1, v2

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result p2

    if-nez p2, :cond_17

    invoke-interface {v0}, Lcom/google/android/gms/internal/auth/zzgi;->zzd()Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :cond_17
    int-to-long v1, v1

    sget-object p2, Lcom/google/android/gms/internal/auth/zzga;->zzb:Lsun/misc/Unsafe;

    invoke-virtual {p2, p1, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    invoke-static {p1}, Lcom/google/android/gms/internal/auth/zzga;->zzH(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_25

    return-object p1

    :cond_25
    invoke-interface {v0}, Lcom/google/android/gms/internal/auth/zzgi;->zzd()Ljava/lang/Object;

    move-result-object p2

    if-eqz p1, :cond_2e

    invoke-interface {v0, p2, p1}, Lcom/google/android/gms/internal/auth/zzgi;->zzf(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_2e
    return-object p2
.end method

.method private final zzu(Ljava/lang/Object;II)Ljava/lang/Object;
    .registers 7

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzr(I)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v0

    invoke-direct {p0, p1, p2, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result p2

    if-nez p2, :cond_f

    invoke-interface {v0}, Lcom/google/android/gms/internal/auth/zzgi;->zzd()Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :cond_f
    sget-object p2, Lcom/google/android/gms/internal/auth/zzga;->zzb:Lsun/misc/Unsafe;

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzo(I)I

    move-result p3

    const v1, 0xfffff

    and-int/2addr p3, v1

    int-to-long v1, p3

    invoke-virtual {p2, p1, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    invoke-static {p1}, Lcom/google/android/gms/internal/auth/zzga;->zzH(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_25

    return-object p1

    :cond_25
    invoke-interface {v0}, Lcom/google/android/gms/internal/auth/zzgi;->zzd()Ljava/lang/Object;

    move-result-object p2

    if-eqz p1, :cond_2e

    invoke-interface {v0, p2, p1}, Lcom/google/android/gms/internal/auth/zzgi;->zzf(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_2e
    return-object p2
.end method

.method private static zzv(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
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

.method private static zzw(Ljava/lang/Object;)V
    .registers 3

    invoke-static {p0}, Lcom/google/android/gms/internal/auth/zzga;->zzH(Ljava/lang/Object;)Z

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

.method private final zzx(Ljava/lang/Object;Ljava/lang/Object;I)V
    .registers 9

    invoke-direct {p0, p2, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v0

    if-nez v0, :cond_7

    return-void

    :cond_7
    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzo(I)I

    move-result v0

    const v1, 0xfffff

    and-int/2addr v0, v1

    sget-object v1, Lcom/google/android/gms/internal/auth/zzga;->zzb:Lsun/misc/Unsafe;

    int-to-long v2, v0

    invoke-virtual {v1, p2, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_53

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzr(I)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object p2

    invoke-direct {p0, p1, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v4

    if-nez v4, :cond_3a

    invoke-static {v0}, Lcom/google/android/gms/internal/auth/zzga;->zzH(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2c

    invoke-virtual {v1, p1, v2, v3, v0}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_36

    :cond_2c
    invoke-interface {p2}, Lcom/google/android/gms/internal/auth/zzgi;->zzd()Ljava/lang/Object;

    move-result-object v4

    invoke-interface {p2, v4, v0}, Lcom/google/android/gms/internal/auth/zzgi;->zzf(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v1, p1, v2, v3, v4}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    :goto_36
    invoke-direct {p0, p1, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzz(Ljava/lang/Object;I)V

    return-void

    :cond_3a
    invoke-virtual {v1, p1, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p3

    invoke-static {p3}, Lcom/google/android/gms/internal/auth/zzga;->zzH(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_4f

    invoke-interface {p2}, Lcom/google/android/gms/internal/auth/zzgi;->zzd()Ljava/lang/Object;

    move-result-object v4

    invoke-interface {p2, v4, p3}, Lcom/google/android/gms/internal/auth/zzgi;->zzf(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v1, p1, v2, v3, v4}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    move-object p3, v4

    :cond_4f
    invoke-interface {p2, p3, v0}, Lcom/google/android/gms/internal/auth/zzgi;->zzf(Ljava/lang/Object;Ljava/lang/Object;)V

    return-void

    :cond_53
    new-instance p1, Ljava/lang/IllegalStateException;

    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    aget p3, v0, p3

    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Source subfield "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p3, " is present but null: "

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private final zzy(Ljava/lang/Object;Ljava/lang/Object;I)V
    .registers 10

    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    aget v0, v0, p3

    invoke-direct {p0, p2, v0, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v1

    if-nez v1, :cond_b

    return-void

    :cond_b
    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzo(I)I

    move-result v1

    const v2, 0xfffff

    and-int/2addr v1, v2

    sget-object v2, Lcom/google/android/gms/internal/auth/zzga;->zzb:Lsun/misc/Unsafe;

    int-to-long v3, v1

    invoke-virtual {v2, p2, v3, v4}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_57

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzr(I)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object p2

    invoke-direct {p0, p1, v0, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v5

    if-nez v5, :cond_3e

    invoke-static {v1}, Lcom/google/android/gms/internal/auth/zzga;->zzH(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_30

    invoke-virtual {v2, p1, v3, v4, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_3a

    :cond_30
    invoke-interface {p2}, Lcom/google/android/gms/internal/auth/zzgi;->zzd()Ljava/lang/Object;

    move-result-object v5

    invoke-interface {p2, v5, v1}, Lcom/google/android/gms/internal/auth/zzgi;->zzf(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v2, p1, v3, v4, v5}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    :goto_3a
    invoke-direct {p0, p1, v0, p3}, Lcom/google/android/gms/internal/auth/zzga;->zzA(Ljava/lang/Object;II)V

    return-void

    :cond_3e
    invoke-virtual {v2, p1, v3, v4}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p3

    invoke-static {p3}, Lcom/google/android/gms/internal/auth/zzga;->zzH(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_53

    invoke-interface {p2}, Lcom/google/android/gms/internal/auth/zzgi;->zzd()Ljava/lang/Object;

    move-result-object v0

    invoke-interface {p2, v0, p3}, Lcom/google/android/gms/internal/auth/zzgi;->zzf(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v2, p1, v3, v4, v0}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    move-object p3, v0

    :cond_53
    invoke-interface {p2, p3, v1}, Lcom/google/android/gms/internal/auth/zzgi;->zzf(Ljava/lang/Object;Ljava/lang/Object;)V

    return-void

    :cond_57
    new-instance p1, Ljava/lang/IllegalStateException;

    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    aget p3, v0, p3

    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Source subfield "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p3, " is present but null: "

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private final zzz(Ljava/lang/Object;I)V
    .registers 8

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/auth/zzga;->zzl(I)I

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

    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result v2

    const/4 v3, 0x1

    shl-int p2, v3, p2

    or-int/2addr p2, v2

    invoke-static {p1, v0, v1, p2}, Lcom/google/android/gms/internal/auth/zzhj;->zzn(Ljava/lang/Object;JI)V

    return-void
.end method


# virtual methods
.method public final zza(Ljava/lang/Object;)I
    .registers 11

    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    array-length v0, v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_5
    if-ge v1, v0, :cond_144

    invoke-direct {p0, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzo(I)I

    move-result v3

    iget-object v4, p0, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    aget v4, v4, v1

    const v5, 0xfffff

    and-int/2addr v5, v3

    invoke-static {v3}, Lcom/google/android/gms/internal/auth/zzga;->zzn(I)I

    move-result v3

    int-to-long v5, v5

    const/16 v7, 0x25

    const/16 v8, 0x20

    packed-switch v3, :pswitch_data_152

    goto/16 :goto_140

    :pswitch_21
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    goto :goto_62

    :pswitch_28
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    goto/16 :goto_af

    :pswitch_30
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    goto :goto_4c

    :pswitch_37
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    goto/16 :goto_af

    :pswitch_3f
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    goto :goto_4c

    :pswitch_46
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    :goto_4c
    goto :goto_9a

    :pswitch_4d
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    goto :goto_9a

    :pswitch_54
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    goto/16 :goto_e4

    :pswitch_5c
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    :goto_62
    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    mul-int/lit8 v2, v2, 0x35

    goto/16 :goto_ea

    :pswitch_6a
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    goto/16 :goto_fd

    :pswitch_72
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    goto/16 :goto_110

    :pswitch_86
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    goto :goto_9a

    :pswitch_8d
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    goto :goto_af

    :pswitch_94
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    :goto_9a
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzga;->zzk(Ljava/lang/Object;J)I

    move-result v3

    goto/16 :goto_12d

    :pswitch_a2
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    goto :goto_af

    :pswitch_a9
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    :goto_af
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzga;->zzp(Ljava/lang/Object;J)J

    move-result-wide v3

    goto/16 :goto_139

    :pswitch_b7
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    goto :goto_129

    :pswitch_ca
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_140

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Double;

    invoke-virtual {v3}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v3

    goto :goto_135

    :pswitch_dd
    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_f9

    goto :goto_f5

    :goto_e4
    :pswitch_e4
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    :goto_ea
    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v3

    goto :goto_12d

    :pswitch_ef
    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_f9

    :goto_f5
    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v7

    :cond_f9
    mul-int/lit8 v2, v2, 0x35

    add-int/2addr v2, v7

    goto :goto_140

    :goto_fd
    :pswitch_fd
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v3

    goto :goto_12d

    :pswitch_10a
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzt(Ljava/lang/Object;J)Z

    move-result v3

    :goto_110
    invoke-static {v3}, Lcom/google/android/gms/internal/auth/zzfa;->zza(Z)I

    move-result v3

    goto :goto_12d

    :pswitch_115
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result v3

    goto :goto_12d

    :pswitch_11c
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzd(Ljava/lang/Object;J)J

    move-result-wide v3

    goto :goto_139

    :pswitch_123
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzb(Ljava/lang/Object;J)F

    move-result v3

    :goto_129
    invoke-static {v3}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v3

    :goto_12d
    add-int/2addr v2, v3

    goto :goto_140

    :pswitch_12f
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zza(Ljava/lang/Object;J)D

    move-result-wide v3

    :goto_135
    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    :goto_139
    sget-object v5, Lcom/google/android/gms/internal/auth/zzfa;->zzd:[B

    ushr-long v5, v3, v8

    xor-long/2addr v3, v5

    long-to-int v4, v3

    add-int/2addr v2, v4

    :cond_140
    :goto_140
    add-int/lit8 v1, v1, 0x3

    goto/16 :goto_5

    :cond_144
    mul-int/lit8 v2, v2, 0x35

    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzl:Lcom/google/android/gms/internal/auth/zzgz;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/auth/zzgz;->zzb(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result p1

    add-int/2addr v2, p1

    return v2

    :pswitch_data_152
    .packed-switch 0x0
        :pswitch_12f
        :pswitch_123
        :pswitch_11c
        :pswitch_11c
        :pswitch_115
        :pswitch_11c
        :pswitch_115
        :pswitch_10a
        :pswitch_fd
        :pswitch_ef
        :pswitch_e4
        :pswitch_115
        :pswitch_115
        :pswitch_115
        :pswitch_11c
        :pswitch_115
        :pswitch_11c
        :pswitch_dd
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_ca
        :pswitch_b7
        :pswitch_a9
        :pswitch_a2
        :pswitch_94
        :pswitch_8d
        :pswitch_86
        :pswitch_72
        :pswitch_6a
        :pswitch_5c
        :pswitch_54
        :pswitch_4d
        :pswitch_46
        :pswitch_3f
        :pswitch_37
        :pswitch_30
        :pswitch_28
        :pswitch_21
    .end packed-switch
.end method

.method final zzb(Ljava/lang/Object;[BIIILcom/google/android/gms/internal/auth/zzdt;)I
    .registers 43

    move-object/from16 v0, p0

    move-object/from16 v7, p1

    move-object/from16 v15, p2

    move/from16 v14, p4

    move/from16 v13, p5

    move-object/from16 v12, p6

    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/auth/zzga;->zzw(Ljava/lang/Object;)V

    sget-object v11, Lcom/google/android/gms/internal/auth/zzga;->zzb:Lsun/misc/Unsafe;

    const/4 v8, 0x0

    move/from16 v1, p3

    const/4 v2, -0x1

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const v6, 0xfffff

    :goto_1b
    const/16 v16, 0x0

    if-ge v1, v14, :cond_c4f

    add-int/lit8 v4, v1, 0x1

    aget-byte v1, v15, v1

    if-gez v1, :cond_2c

    invoke-static {v1, v15, v4, v12}, Lcom/google/android/gms/internal/auth/zzdu;->zzi(I[BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v1

    iget v4, v12, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

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

    iget v2, v0, Lcom/google/android/gms/internal/auth/zzga;->zze:I

    if-lt v9, v2, :cond_44

    iget v2, v0, Lcom/google/android/gms/internal/auth/zzga;->zzf:I

    if-gt v9, v2, :cond_44

    invoke-direct {v0, v9, v3}, Lcom/google/android/gms/internal/auth/zzga;->zzm(II)I

    move-result v2

    goto :goto_52

    :cond_44
    const/4 v2, -0x1

    goto :goto_52

    :cond_46
    iget v2, v0, Lcom/google/android/gms/internal/auth/zzga;->zze:I

    if-lt v9, v2, :cond_55

    iget v2, v0, Lcom/google/android/gms/internal/auth/zzga;->zzf:I

    if-gt v9, v2, :cond_55

    invoke-direct {v0, v9, v8}, Lcom/google/android/gms/internal/auth/zzga;->zzm(II)I

    move-result v2

    :goto_52
    move v3, v2

    const/4 v2, -0x1

    goto :goto_57

    :cond_55
    const/4 v2, -0x1

    const/4 v3, -0x1

    :goto_57
    if-ne v3, v2, :cond_6c

    move v3, v1

    move/from16 v17, v5

    move/from16 v25, v6

    move-object/from16 v21, v11

    move v8, v13

    move v6, v14

    const/16 v18, -0x1

    const/16 v19, 0x0

    move v13, v9

    move-object v14, v12

    const/4 v12, 0x0

    move v9, v4

    goto/16 :goto_c20

    :cond_6c
    and-int/lit8 v2, v4, 0x7

    iget-object v10, v0, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    add-int/lit8 v19, v3, 0x1

    aget v8, v10, v19

    move/from16 v19, v4

    invoke-static {v8}, Lcom/google/android/gms/internal/auth/zzga;->zzn(I)I

    move-result v4

    const v17, 0xfffff

    and-int v13, v8, v17

    int-to-long v13, v13

    move/from16 v21, v9

    const/high16 v22, 0x20000000

    const-wide/16 v23, 0x0

    const-string v9, ""

    move-object/from16 v26, v9

    const/16 v9, 0x11

    if-gt v4, v9, :cond_3ba

    add-int/lit8 v9, v3, 0x2

    aget v9, v10, v9

    ushr-int/lit8 v10, v9, 0x14

    const/16 v25, 0x1

    shl-int v27, v25, v10

    const v10, 0xfffff

    and-int/2addr v9, v10

    move-wide/from16 v28, v13

    if-eq v9, v6, :cond_b4

    if-eq v6, v10, :cond_a6

    int-to-long v13, v6

    invoke-virtual {v11, v7, v13, v14, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_a6
    if-ne v9, v10, :cond_aa

    const/4 v5, 0x0

    goto :goto_af

    :cond_aa
    int-to-long v5, v9

    invoke-virtual {v11, v7, v5, v6}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v5

    :goto_af
    move/from16 v17, v5

    move/from16 v25, v9

    goto :goto_b8

    :cond_b4
    move/from16 v17, v5

    move/from16 v25, v6

    :goto_b8
    packed-switch v4, :pswitch_data_ca0

    move v10, v1

    move v14, v3

    move/from16 v9, v19

    const/4 v1, 0x3

    const/4 v8, 0x0

    const/4 v13, -0x1

    if-ne v2, v1, :cond_39f

    invoke-direct {v0, v7, v14}, Lcom/google/android/gms/internal/auth/zzga;->zzt(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object v1

    shl-int/lit8 v2, v21, 0x3

    or-int/lit8 v2, v2, 0x4

    invoke-direct {v0, v14}, Lcom/google/android/gms/internal/auth/zzga;->zzr(I)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v3

    const/16 v19, 0x0

    move-object v8, v1

    move v5, v9

    move/from16 v4, v21

    const v6, 0xfffff

    move-object v9, v3

    move v13, v10

    const/16 v18, -0x1

    move-object/from16 v10, p2

    move-object v3, v11

    move v11, v13

    move-object v13, v12

    move/from16 v12, p4

    move-object v6, v13

    move v13, v2

    move/from16 v2, p4

    move/from16 v20, v5

    move v5, v14

    move-object/from16 v14, p6

    invoke-static/range {v8 .. v14}, Lcom/google/android/gms/internal/auth/zzdu;->zzl(Ljava/lang/Object;Lcom/google/android/gms/internal/auth/zzgi;[BIIILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v8

    invoke-direct {v0, v7, v5, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzB(Ljava/lang/Object;ILjava/lang/Object;)V

    or-int v1, v17, v27

    move/from16 v13, p5

    move v14, v2

    move-object v11, v3

    move v2, v4

    move v3, v5

    move-object v12, v6

    move/from16 v4, v20

    move/from16 v6, v25

    move v5, v1

    move v1, v8

    const/4 v8, 0x0

    goto/16 :goto_1b

    :pswitch_106
    if-nez v2, :cond_125

    invoke-static {v15, v1, v12}, Lcom/google/android/gms/internal/auth/zzdu;->zzk([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v8

    iget-wide v1, v12, Lcom/google/android/gms/internal/auth/zzdt;->zzb:J

    invoke-static {v1, v2}, Lcom/google/android/gms/internal/auth/zzej;->zzc(J)J

    move-result-wide v5

    move-object v1, v11

    const/4 v13, -0x1

    move-object/from16 v2, p1

    move v14, v3

    move/from16 v9, v19

    move-wide/from16 v3, v28

    invoke-virtual/range {v1 .. v6}, Lsun/misc/Unsafe;->putLong(Ljava/lang/Object;JJ)V

    or-int v5, v17, v27

    move/from16 v13, p5

    move v1, v8

    goto/16 :goto_1af

    :cond_125
    move/from16 v2, p4

    move v13, v1

    move v5, v3

    move-object v3, v11

    move-object v6, v12

    move/from16 v20, v19

    goto/16 :goto_3a7

    :pswitch_12f
    move v14, v3

    move/from16 v9, v19

    const/4 v13, -0x1

    if-nez v2, :cond_1b8

    invoke-static {v15, v1, v12}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v1

    iget v2, v12, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    invoke-static {v2}, Lcom/google/android/gms/internal/auth/zzej;->zzb(I)I

    move-result v2

    move-wide/from16 v3, v28

    :cond_141
    :goto_141
    invoke-virtual {v11, v7, v3, v4, v2}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto/16 :goto_1ab

    :pswitch_146
    move v14, v3

    move/from16 v9, v19

    move-wide/from16 v3, v28

    const/4 v13, -0x1

    if-nez v2, :cond_1b8

    invoke-static {v15, v1, v12}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v1

    iget v2, v12, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    invoke-direct {v0, v14}, Lcom/google/android/gms/internal/auth/zzga;->zzq(I)Lcom/google/android/gms/internal/auth/zzey;

    move-result-object v5

    const/high16 v6, -0x80000000

    and-int/2addr v6, v8

    if-eqz v6, :cond_141

    if-eqz v5, :cond_141

    invoke-interface {v5}, Lcom/google/android/gms/internal/auth/zzey;->zza()Z

    move-result v5

    if-eqz v5, :cond_166

    goto :goto_141

    :cond_166
    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/auth/zzga;->zzc(Ljava/lang/Object;)Lcom/google/android/gms/internal/auth/zzha;

    move-result-object v3

    int-to-long v4, v2

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v3, v9, v2}, Lcom/google/android/gms/internal/auth/zzha;->zzh(ILjava/lang/Object;)V

    move/from16 v13, p5

    move v4, v9

    move v3, v14

    move/from16 v5, v17

    goto :goto_1b1

    :pswitch_179
    move v14, v3

    move/from16 v9, v19

    move-wide/from16 v3, v28

    const/4 v5, 0x2

    const/4 v13, -0x1

    if-ne v2, v5, :cond_1b8

    invoke-static {v15, v1, v12}, Lcom/google/android/gms/internal/auth/zzdu;->zza([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v1

    iget-object v2, v12, Lcom/google/android/gms/internal/auth/zzdt;->zzc:Ljava/lang/Object;

    invoke-virtual {v11, v7, v3, v4, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_1ab

    :pswitch_18c
    move v14, v3

    move/from16 v9, v19

    const/4 v5, 0x2

    const/4 v13, -0x1

    if-ne v2, v5, :cond_1b8

    invoke-direct {v0, v7, v14}, Lcom/google/android/gms/internal/auth/zzga;->zzt(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object v8

    invoke-direct {v0, v14}, Lcom/google/android/gms/internal/auth/zzga;->zzr(I)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v2

    move v5, v1

    move-object v1, v8

    move-object/from16 v3, p2

    move v4, v5

    move/from16 v5, p4

    move-object/from16 v6, p6

    invoke-static/range {v1 .. v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzm(Ljava/lang/Object;Lcom/google/android/gms/internal/auth/zzgi;[BIILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v1

    invoke-direct {v0, v7, v14, v8}, Lcom/google/android/gms/internal/auth/zzga;->zzB(Ljava/lang/Object;ILjava/lang/Object;)V

    :goto_1ab
    or-int v5, v17, v27

    move/from16 v13, p5

    :goto_1af
    move v4, v9

    move v3, v14

    :goto_1b1
    move/from16 v2, v21

    move/from16 v6, v25

    const/4 v8, 0x0

    goto/16 :goto_39b

    :cond_1b8
    move/from16 v2, p4

    move v13, v1

    goto/16 :goto_32b

    :pswitch_1bd
    move v5, v1

    move v14, v3

    move/from16 v9, v19

    move-wide/from16 v3, v28

    const/4 v1, 0x2

    const/4 v13, -0x1

    if-ne v2, v1, :cond_328

    and-int v1, v8, v22

    if-eqz v1, :cond_2b6

    invoke-static {v15, v5, v12}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v1

    iget v2, v12, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ltz v2, :cond_2b1

    if-nez v2, :cond_1dc

    move-object/from16 v6, v26

    iput-object v6, v12, Lcom/google/android/gms/internal/auth/zzdt;->zzc:Ljava/lang/Object;

    const/4 v8, 0x0

    goto/16 :goto_2d0

    :cond_1dc
    sget v5, Lcom/google/android/gms/internal/auth/zzhn;->zza:I

    array-length v5, v15

    sub-int v6, v5, v1

    or-int v8, v1, v2

    sub-int/2addr v6, v2

    or-int/2addr v6, v8

    if-ltz v6, :cond_28c

    add-int v5, v1, v2

    new-array v2, v2, [C

    const/4 v6, 0x0

    :goto_1ec
    if-ge v1, v5, :cond_200

    aget-byte v8, v15, v1

    invoke-static {v8}, Lcom/google/android/gms/internal/auth/zzhk;->zzd(B)Z

    move-result v16

    if-eqz v16, :cond_200

    add-int/lit8 v1, v1, 0x1

    add-int/lit8 v16, v6, 0x1

    int-to-char v8, v8

    aput-char v8, v2, v6

    move/from16 v6, v16

    goto :goto_1ec

    :cond_200
    :goto_200
    if-ge v1, v5, :cond_282

    add-int/lit8 v8, v1, 0x1

    aget-byte v1, v15, v1

    invoke-static {v1}, Lcom/google/android/gms/internal/auth/zzhk;->zzd(B)Z

    move-result v16

    if-eqz v16, :cond_226

    add-int/lit8 v16, v6, 0x1

    int-to-char v1, v1

    aput-char v1, v2, v6

    move v1, v8

    :goto_212
    move/from16 v6, v16

    if-ge v1, v5, :cond_200

    aget-byte v8, v15, v1

    invoke-static {v8}, Lcom/google/android/gms/internal/auth/zzhk;->zzd(B)Z

    move-result v16

    if-eqz v16, :cond_200

    add-int/lit8 v1, v1, 0x1

    add-int/lit8 v16, v6, 0x1

    int-to-char v8, v8

    aput-char v8, v2, v6

    goto :goto_212

    :cond_226
    const/16 v10, -0x20

    if-ge v1, v10, :cond_241

    if-ge v8, v5, :cond_23c

    add-int/lit8 v10, v8, 0x1

    aget-byte v8, v15, v8

    add-int/lit8 v16, v6, 0x1

    invoke-static {v1, v8, v2, v6}, Lcom/google/android/gms/internal/auth/zzhk;->zzc(BB[CI)V

    move v1, v10

    move/from16 v6, v16

    :goto_238
    const v10, 0xfffff

    goto :goto_200

    :cond_23c
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzb()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_241
    const/16 v10, -0x10

    if-ge v1, v10, :cond_260

    add-int/lit8 v10, v5, -0x1

    if-ge v8, v10, :cond_25b

    add-int/lit8 v10, v8, 0x1

    aget-byte v8, v15, v8

    add-int/lit8 v16, v10, 0x1

    aget-byte v10, v15, v10

    add-int/lit8 v19, v6, 0x1

    invoke-static {v1, v8, v10, v2, v6}, Lcom/google/android/gms/internal/auth/zzhk;->zzb(BBB[CI)V

    move/from16 v1, v16

    move/from16 v6, v19

    goto :goto_238

    :cond_25b
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzb()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_260
    add-int/lit8 v10, v5, -0x2

    if-ge v8, v10, :cond_27d

    add-int/lit8 v10, v8, 0x1

    aget-byte v29, v15, v8

    add-int/lit8 v8, v10, 0x1

    aget-byte v30, v15, v10

    add-int/lit8 v10, v8, 0x1

    aget-byte v31, v15, v8

    move/from16 v28, v1

    move-object/from16 v32, v2

    move/from16 v33, v6

    invoke-static/range {v28 .. v33}, Lcom/google/android/gms/internal/auth/zzhk;->zza(BBBB[CI)V

    add-int/lit8 v6, v6, 0x2

    move v1, v10

    goto :goto_238

    :cond_27d
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzb()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_282
    new-instance v1, Ljava/lang/String;

    const/4 v8, 0x0

    invoke-direct {v1, v2, v8, v6}, Ljava/lang/String;-><init>([CII)V

    iput-object v1, v12, Lcom/google/android/gms/internal/auth/zzdt;->zzc:Ljava/lang/Object;

    move v1, v5

    goto :goto_2d0

    :cond_28c
    const/4 v8, 0x0

    new-instance v3, Ljava/lang/ArrayIndexOutOfBoundsException;

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v8

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const/4 v5, 0x1

    const/4 v5, 0x1

    aput-object v1, v4, v5

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const/4 v2, 0x2

    aput-object v1, v4, v2

    const-string v1, "buffer length=%d, index=%d, size=%d"

    invoke-static {v1, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v3, v1}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v3

    :cond_2b1
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzc()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_2b6
    move-object/from16 v6, v26

    const/4 v8, 0x0

    invoke-static {v15, v5, v12}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v1

    iget v2, v12, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ltz v2, :cond_2d7

    if-nez v2, :cond_2c6

    iput-object v6, v12, Lcom/google/android/gms/internal/auth/zzdt;->zzc:Ljava/lang/Object;

    goto :goto_2d0

    :cond_2c6
    new-instance v5, Ljava/lang/String;

    sget-object v6, Lcom/google/android/gms/internal/auth/zzfa;->zzb:Ljava/nio/charset/Charset;

    invoke-direct {v5, v15, v1, v2, v6}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    iput-object v5, v12, Lcom/google/android/gms/internal/auth/zzdt;->zzc:Ljava/lang/Object;

    add-int/2addr v1, v2

    :goto_2d0
    iget-object v2, v12, Lcom/google/android/gms/internal/auth/zzdt;->zzc:Ljava/lang/Object;

    invoke-virtual {v11, v7, v3, v4, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto/16 :goto_391

    :cond_2d7
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzc()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :pswitch_2dc
    move v5, v1

    move v14, v3

    move/from16 v9, v19

    move-wide/from16 v3, v28

    const/4 v8, 0x0

    const/4 v13, -0x1

    if-nez v2, :cond_328

    invoke-static {v15, v5, v12}, Lcom/google/android/gms/internal/auth/zzdu;->zzk([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v1

    iget-wide v5, v12, Lcom/google/android/gms/internal/auth/zzdt;->zzb:J

    cmp-long v2, v5, v23

    if-eqz v2, :cond_2f2

    const/4 v2, 0x1

    goto :goto_2f3

    :cond_2f2
    const/4 v2, 0x0

    :goto_2f3
    invoke-static {v7, v3, v4, v2}, Lcom/google/android/gms/internal/auth/zzhj;->zzk(Ljava/lang/Object;JZ)V

    goto/16 :goto_391

    :pswitch_2f8
    move v5, v1

    move v14, v3

    move/from16 v9, v19

    move-wide/from16 v3, v28

    const/4 v1, 0x5

    const/4 v8, 0x0

    const/4 v13, -0x1

    if-ne v2, v1, :cond_328

    invoke-static {v15, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzb([BI)I

    move-result v1

    invoke-virtual {v11, v7, v3, v4, v1}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    add-int/lit8 v1, v5, 0x4

    goto/16 :goto_391

    :pswitch_30e
    move v5, v1

    move v14, v3

    move/from16 v9, v19

    move-wide/from16 v3, v28

    const/4 v1, 0x1

    const/4 v8, 0x0

    const/4 v13, -0x1

    if-ne v2, v1, :cond_328

    invoke-static {v15, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzn([BI)J

    move-result-wide v19

    move-object v1, v11

    move-object/from16 v2, p1

    move v10, v5

    move-wide/from16 v5, v19

    invoke-virtual/range {v1 .. v6}, Lsun/misc/Unsafe;->putLong(Ljava/lang/Object;JJ)V

    goto/16 :goto_38f

    :cond_328
    move/from16 v2, p4

    move v13, v5

    :goto_32b
    move/from16 v20, v9

    goto/16 :goto_3a4

    :pswitch_32f
    move v10, v1

    move v14, v3

    move/from16 v9, v19

    move-wide/from16 v3, v28

    const/4 v8, 0x0

    const/4 v13, -0x1

    if-nez v2, :cond_39f

    invoke-static {v15, v10, v12}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v1

    iget v2, v12, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    invoke-virtual {v11, v7, v3, v4, v2}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto :goto_391

    :pswitch_343
    move v10, v1

    move v14, v3

    move/from16 v9, v19

    move-wide/from16 v3, v28

    const/4 v8, 0x0

    const/4 v13, -0x1

    if-nez v2, :cond_39f

    invoke-static {v15, v10, v12}, Lcom/google/android/gms/internal/auth/zzdu;->zzk([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v10

    iget-wide v5, v12, Lcom/google/android/gms/internal/auth/zzdt;->zzb:J

    move-object v1, v11

    move-object/from16 v2, p1

    invoke-virtual/range {v1 .. v6}, Lsun/misc/Unsafe;->putLong(Ljava/lang/Object;JJ)V

    or-int v5, v17, v27

    move/from16 v13, p5

    move v4, v9

    move v1, v10

    goto :goto_396

    :pswitch_360
    move v10, v1

    move v14, v3

    move/from16 v9, v19

    move-wide/from16 v3, v28

    const/4 v1, 0x5

    const/4 v8, 0x0

    const/4 v13, -0x1

    if-ne v2, v1, :cond_39f

    invoke-static {v15, v10}, Lcom/google/android/gms/internal/auth/zzdu;->zzb([BI)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result v1

    invoke-static {v7, v3, v4, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzm(Ljava/lang/Object;JF)V

    add-int/lit8 v1, v10, 0x4

    goto :goto_391

    :pswitch_379
    move v10, v1

    move v14, v3

    move/from16 v9, v19

    move-wide/from16 v3, v28

    const/4 v1, 0x1

    const/4 v8, 0x0

    const/4 v13, -0x1

    if-ne v2, v1, :cond_39f

    invoke-static {v15, v10}, Lcom/google/android/gms/internal/auth/zzdu;->zzn([BI)J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide v1

    invoke-static {v7, v3, v4, v1, v2}, Lcom/google/android/gms/internal/auth/zzhj;->zzl(Ljava/lang/Object;JD)V

    :goto_38f
    add-int/lit8 v1, v10, 0x8

    :goto_391
    or-int v5, v17, v27

    move/from16 v13, p5

    move v4, v9

    :goto_396
    move v3, v14

    move/from16 v2, v21

    move/from16 v6, v25

    :goto_39b
    move/from16 v14, p4

    goto/16 :goto_1b

    :cond_39f
    move/from16 v2, p4

    move/from16 v20, v9

    move v13, v10

    :goto_3a4
    move-object v3, v11

    move-object v6, v12

    move v5, v14

    :goto_3a7
    move/from16 v4, v21

    const/16 v18, -0x1

    const/16 v19, 0x0

    move/from16 v8, p5

    move-object/from16 v21, v3

    move v12, v5

    move-object v14, v6

    move v3, v13

    move/from16 v9, v20

    move v6, v2

    move v13, v4

    goto/16 :goto_c20

    :cond_3ba
    move/from16 v17, v5

    move/from16 v25, v6

    move-object/from16 v20, v10

    move-object v6, v12

    move-object/from16 v9, v26

    const/16 v18, -0x1

    move v5, v3

    move-object v3, v11

    move-wide v11, v13

    move/from16 v14, v19

    const/16 v19, 0x0

    move v13, v1

    move/from16 v1, p4

    const/16 v10, 0x1b

    const/16 v26, 0xa

    if-ne v4, v10, :cond_42d

    const/4 v10, 0x2

    if-ne v2, v10, :cond_41f

    invoke-virtual {v3, v7, v11, v12}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/auth/zzez;

    invoke-interface {v2}, Lcom/google/android/gms/internal/auth/zzez;->zzc()Z

    move-result v4

    if-nez v4, :cond_3f8

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v4

    if-nez v4, :cond_3ed

    const/16 v4, 0xa

    goto :goto_3f1

    :cond_3ed
    add-int v26, v4, v4

    move/from16 v4, v26

    :goto_3f1
    invoke-interface {v2, v4}, Lcom/google/android/gms/internal/auth/zzez;->zzd(I)Lcom/google/android/gms/internal/auth/zzez;

    move-result-object v2

    invoke-virtual {v3, v7, v11, v12, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    :cond_3f8
    invoke-direct {v0, v5}, Lcom/google/android/gms/internal/auth/zzga;->zzr(I)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v8

    move v9, v14

    move-object/from16 v10, p2

    move v11, v13

    move/from16 v4, v21

    move/from16 v12, p4

    move-object v13, v2

    move v2, v14

    move-object/from16 v14, p6

    invoke-static/range {v8 .. v14}, Lcom/google/android/gms/internal/auth/zzdu;->zze(Lcom/google/android/gms/internal/auth/zzgi;I[BIILcom/google/android/gms/internal/auth/zzez;Lcom/google/android/gms/internal/auth/zzdt;)I

    move-result v8

    move/from16 v13, p5

    move v14, v1

    move-object v11, v3

    move v3, v5

    move-object v12, v6

    move v1, v8

    move/from16 v5, v17

    move/from16 v6, v25

    const/4 v8, 0x0

    move/from16 v34, v4

    move v4, v2

    move/from16 v2, v34

    goto/16 :goto_1b

    :cond_41f
    move/from16 v9, v21

    move/from16 v34, v13

    move v13, v1

    move/from16 v1, v34

    move/from16 v35, v5

    move-object v5, v3

    move/from16 v3, v35

    goto/16 :goto_9af

    :cond_42d
    move/from16 v10, v21

    move-object/from16 v21, v3

    const/16 v3, 0x31

    if-gt v4, v3, :cond_975

    move-object v3, v9

    int-to-long v8, v8

    move/from16 v27, v5

    sget-object v5, Lcom/google/android/gms/internal/auth/zzga;->zzb:Lsun/misc/Unsafe;

    invoke-virtual {v5, v7, v11, v12}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v20

    move-object/from16 v28, v3

    move-object/from16 v3, v20

    check-cast v3, Lcom/google/android/gms/internal/auth/zzez;

    invoke-interface {v3}, Lcom/google/android/gms/internal/auth/zzez;->zzc()Z

    move-result v20

    if-nez v20, :cond_464

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v20

    if-nez v20, :cond_456

    move-wide/from16 v29, v8

    const/16 v8, 0xa

    goto :goto_45c

    :cond_456
    add-int v26, v20, v20

    move-wide/from16 v29, v8

    move/from16 v8, v26

    :goto_45c
    invoke-interface {v3, v8}, Lcom/google/android/gms/internal/auth/zzez;->zzd(I)Lcom/google/android/gms/internal/auth/zzez;

    move-result-object v3

    invoke-virtual {v5, v7, v11, v12, v3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_466

    :cond_464
    move-wide/from16 v29, v8

    :goto_466
    move-object v12, v3

    packed-switch v4, :pswitch_data_cc6

    move-object v11, v6

    move v9, v10

    move-object v8, v12

    move v7, v13

    move-object/from16 v10, v21

    move/from16 v12, v27

    move v13, v1

    const/4 v1, 0x3

    if-ne v2, v1, :cond_955

    invoke-direct {v0, v12}, Lcom/google/android/gms/internal/auth/zzga;->zzr(I)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v20

    and-int/lit8 v1, v14, -0x8

    or-int/lit8 v21, v1, 0x4

    move-object/from16 v1, v20

    move-object/from16 v2, p2

    move v3, v7

    move/from16 v4, p4

    move/from16 v5, v21

    move-object/from16 v6, p6

    invoke-static/range {v1 .. v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzc(Lcom/google/android/gms/internal/auth/zzgi;[BIIILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v1

    :goto_48d
    iget-object v2, v11, Lcom/google/android/gms/internal/auth/zzdt;->zzc:Ljava/lang/Object;

    invoke-interface {v8, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_93b

    :pswitch_494
    const/4 v3, 0x2

    if-ne v2, v3, :cond_4b8

    check-cast v12, Lcom/google/android/gms/internal/auth/zzfm;

    invoke-static {v15, v13, v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget v3, v6, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    add-int/2addr v3, v2

    :goto_4a0
    if-ge v2, v3, :cond_4b0

    invoke-static {v15, v2, v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzk([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget-wide v4, v6, Lcom/google/android/gms/internal/auth/zzdt;->zzb:J

    invoke-static {v4, v5}, Lcom/google/android/gms/internal/auth/zzej;->zzc(J)J

    move-result-wide v4

    invoke-virtual {v12, v4, v5}, Lcom/google/android/gms/internal/auth/zzfm;->zze(J)V

    goto :goto_4a0

    :cond_4b0
    if-ne v2, v3, :cond_4b3

    goto :goto_51c

    :cond_4b3
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzf()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_4b8
    if-nez v2, :cond_5c7

    check-cast v12, Lcom/google/android/gms/internal/auth/zzfm;

    invoke-static {v15, v13, v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzk([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    :goto_4c0
    iget-wide v3, v6, Lcom/google/android/gms/internal/auth/zzdt;->zzb:J

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/auth/zzej;->zzc(J)J

    move-result-wide v3

    invoke-virtual {v12, v3, v4}, Lcom/google/android/gms/internal/auth/zzfm;->zze(J)V

    if-ge v2, v1, :cond_51c

    invoke-static {v15, v2, v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v3

    iget v4, v6, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ne v14, v4, :cond_51c

    invoke-static {v15, v3, v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzk([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    goto :goto_4c0

    :pswitch_4d8
    const/4 v3, 0x2

    if-ne v2, v3, :cond_4fc

    check-cast v12, Lcom/google/android/gms/internal/auth/zzew;

    invoke-static {v15, v13, v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget v3, v6, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    add-int/2addr v3, v2

    :goto_4e4
    if-ge v2, v3, :cond_4f4

    invoke-static {v15, v2, v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget v4, v6, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    invoke-static {v4}, Lcom/google/android/gms/internal/auth/zzej;->zzb(I)I

    move-result v4

    invoke-virtual {v12, v4}, Lcom/google/android/gms/internal/auth/zzew;->zze(I)V

    goto :goto_4e4

    :cond_4f4
    if-ne v2, v3, :cond_4f7

    goto :goto_51c

    :cond_4f7
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzf()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_4fc
    if-nez v2, :cond_5c7

    check-cast v12, Lcom/google/android/gms/internal/auth/zzew;

    invoke-static {v15, v13, v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    :goto_504
    iget v3, v6, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    invoke-static {v3}, Lcom/google/android/gms/internal/auth/zzej;->zzb(I)I

    move-result v3

    invoke-virtual {v12, v3}, Lcom/google/android/gms/internal/auth/zzew;->zze(I)V

    if-ge v2, v1, :cond_51c

    invoke-static {v15, v2, v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v3

    iget v4, v6, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ne v14, v4, :cond_51c

    invoke-static {v15, v3, v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    goto :goto_504

    :cond_51c
    :goto_51c
    move-object v11, v6

    move v9, v10

    move v7, v13

    move-object/from16 v10, v21

    move/from16 v12, v27

    move v13, v1

    goto/16 :goto_939

    :pswitch_526
    const/4 v3, 0x2

    if-ne v2, v3, :cond_532

    invoke-static {v15, v13, v12, v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzf([BILcom/google/android/gms/internal/auth/zzez;Lcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    move v11, v1

    move-object v9, v6

    move/from16 v8, v27

    goto :goto_547

    :cond_532
    if-nez v2, :cond_5c5

    move v11, v1

    move v1, v14

    move-object/from16 v2, p2

    move-object/from16 v9, v21

    move v3, v13

    move/from16 v4, p4

    move/from16 v8, v27

    move-object v5, v12

    move-object v9, v6

    move-object/from16 v6, p6

    invoke-static/range {v1 .. v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzj(I[BIILcom/google/android/gms/internal/auth/zzez;Lcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    :goto_547
    invoke-direct {v0, v8}, Lcom/google/android/gms/internal/auth/zzga;->zzq(I)Lcom/google/android/gms/internal/auth/zzey;

    move-result-object v1

    iget-object v3, v0, Lcom/google/android/gms/internal/auth/zzga;->zzl:Lcom/google/android/gms/internal/auth/zzgz;

    sget v4, Lcom/google/android/gms/internal/auth/zzgk;->zza:I

    if-eqz v1, :cond_5b6

    instance-of v4, v12, Ljava/util/RandomAccess;

    if-eqz v4, :cond_590

    invoke-interface {v12}, Ljava/util/List;->size()I

    move-result v4

    move/from16 p3, v2

    move-object/from16 v2, v16

    const/4 v5, 0x0

    const/4 v6, 0x0

    :goto_55f
    if-ge v5, v4, :cond_586

    invoke-interface {v12, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/lang/Integer;

    invoke-virtual/range {v20 .. v20}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-interface {v1}, Lcom/google/android/gms/internal/auth/zzey;->zza()Z

    move-result v20

    if-eqz v20, :cond_57d

    if-eq v5, v6, :cond_57a

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {v12, v6, v0}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    :cond_57a
    add-int/lit8 v6, v6, 0x1

    goto :goto_581

    :cond_57d
    invoke-static {v7, v10, v0, v2, v3}, Lcom/google/android/gms/internal/auth/zzgk;->zzc(Ljava/lang/Object;IILjava/lang/Object;Lcom/google/android/gms/internal/auth/zzgz;)Ljava/lang/Object;

    move-result-object v2

    :goto_581
    add-int/lit8 v5, v5, 0x1

    move-object/from16 v0, p0

    goto :goto_55f

    :cond_586
    if-eq v6, v4, :cond_5b8

    invoke-interface {v12, v6, v4}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_5b8

    :cond_590
    move/from16 p3, v2

    invoke-interface {v12}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    move-object/from16 v2, v16

    :cond_598
    :goto_598
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_5b8

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-interface {v1}, Lcom/google/android/gms/internal/auth/zzey;->zza()Z

    move-result v5

    if-nez v5, :cond_598

    invoke-static {v7, v10, v4, v2, v3}, Lcom/google/android/gms/internal/auth/zzgk;->zzc(Ljava/lang/Object;IILjava/lang/Object;Lcom/google/android/gms/internal/auth/zzgz;)Ljava/lang/Object;

    move-result-object v2

    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    goto :goto_598

    :cond_5b6
    move/from16 p3, v2

    :cond_5b8
    :goto_5b8
    move-object/from16 v0, p0

    move/from16 v1, p3

    move v12, v8

    move v7, v13

    :goto_5be
    move v13, v11

    move-object v11, v9

    move v9, v10

    move-object/from16 v10, v21

    goto/16 :goto_956

    :cond_5c5
    move-object/from16 v0, p0

    :cond_5c7
    move-object v11, v6

    move v9, v10

    move v7, v13

    move-object/from16 v10, v21

    move/from16 v12, v27

    move v13, v1

    goto/16 :goto_955

    :pswitch_5d1
    move v11, v1

    move-object v9, v6

    move/from16 v8, v27

    const/4 v0, 0x2

    if-ne v2, v0, :cond_627

    invoke-static {v15, v13, v9}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v0

    iget v1, v9, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ltz v1, :cond_622

    array-length v2, v15

    sub-int/2addr v2, v0

    if-gt v1, v2, :cond_61d

    if-nez v1, :cond_5ec

    :goto_5e6
    sget-object v1, Lcom/google/android/gms/internal/auth/zzef;->zzb:Lcom/google/android/gms/internal/auth/zzef;

    invoke-interface {v12, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_5f4

    :cond_5ec
    invoke-static {v15, v0, v1}, Lcom/google/android/gms/internal/auth/zzef;->zzk([BII)Lcom/google/android/gms/internal/auth/zzef;

    move-result-object v2

    invoke-interface {v12, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/2addr v0, v1

    :goto_5f4
    if-ge v0, v11, :cond_617

    invoke-static {v15, v0, v9}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v1

    iget v2, v9, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ne v14, v2, :cond_617

    invoke-static {v15, v1, v9}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v0

    iget v1, v9, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ltz v1, :cond_612

    array-length v2, v15

    sub-int/2addr v2, v0

    if-gt v1, v2, :cond_60d

    if-nez v1, :cond_5ec

    goto :goto_5e6

    :cond_60d
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzf()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v0

    throw v0

    :cond_612
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzc()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v0

    throw v0

    :cond_617
    move v1, v0

    move v12, v8

    move v7, v13

    move-object/from16 v0, p0

    goto :goto_5be

    :cond_61d
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzf()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v0

    throw v0

    :cond_622
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzc()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v0

    throw v0

    :cond_627
    move-object/from16 v0, p0

    move v12, v8

    move v7, v13

    goto :goto_65d

    :pswitch_62c
    move v11, v1

    move-object v9, v6

    move/from16 v8, v27

    const/4 v0, 0x2

    if-ne v2, v0, :cond_659

    move-object/from16 v0, p0

    invoke-direct {v0, v8}, Lcom/google/android/gms/internal/auth/zzga;->zzr(I)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v1

    move v6, v8

    move-object v8, v1

    move-object v5, v9

    move-object/from16 v4, v21

    move v9, v14

    move v3, v10

    move-object/from16 v10, p2

    move v1, v11

    move v11, v13

    move-object v2, v12

    move/from16 v12, p4

    move v7, v13

    move-object v13, v2

    move v2, v14

    move-object/from16 v14, p6

    invoke-static/range {v8 .. v14}, Lcom/google/android/gms/internal/auth/zzdu;->zze(Lcom/google/android/gms/internal/auth/zzgi;I[BIILcom/google/android/gms/internal/auth/zzez;Lcom/google/android/gms/internal/auth/zzdt;)I

    move-result v8

    move v13, v1

    move v14, v2

    move v9, v3

    move-object v10, v4

    move-object v11, v5

    move v12, v6

    move v1, v8

    goto/16 :goto_956

    :cond_659
    move-object/from16 v0, p0

    move v7, v13

    move v12, v8

    :goto_65d
    move v13, v11

    move-object v11, v9

    move v9, v10

    move-object/from16 v10, v21

    goto/16 :goto_955

    :pswitch_664
    move-object v5, v6

    move v3, v10

    move-object v8, v12

    move v7, v13

    move-object/from16 v4, v21

    move/from16 v6, v27

    const/4 v9, 0x2

    if-ne v2, v9, :cond_716

    const-wide/32 v9, 0x20000000

    and-long v9, v29, v9

    cmp-long v2, v9, v23

    if-nez v2, :cond_6ba

    invoke-static {v15, v7, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget v9, v5, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ltz v9, :cond_6b5

    move-object/from16 v10, v28

    if-nez v9, :cond_688

    :goto_684
    invoke-interface {v8, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_693

    :cond_688
    new-instance v11, Ljava/lang/String;

    sget-object v12, Lcom/google/android/gms/internal/auth/zzfa;->zzb:Ljava/nio/charset/Charset;

    invoke-direct {v11, v15, v2, v9, v12}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    :goto_68f
    invoke-interface {v8, v11}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/2addr v2, v9

    :goto_693
    if-ge v2, v1, :cond_820

    invoke-static {v15, v2, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v9

    iget v11, v5, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ne v14, v11, :cond_820

    invoke-static {v15, v9, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget v9, v5, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ltz v9, :cond_6b0

    if-nez v9, :cond_6a8

    goto :goto_684

    :cond_6a8
    new-instance v11, Ljava/lang/String;

    sget-object v12, Lcom/google/android/gms/internal/auth/zzfa;->zzb:Ljava/nio/charset/Charset;

    invoke-direct {v11, v15, v2, v9, v12}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    goto :goto_68f

    :cond_6b0
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzc()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_6b5
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzc()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_6ba
    move-object/from16 v10, v28

    invoke-static {v15, v7, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget v9, v5, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ltz v9, :cond_711

    if-nez v9, :cond_6ca

    :goto_6c6
    invoke-interface {v8, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_6dd

    :cond_6ca
    add-int v11, v2, v9

    invoke-static {v15, v2, v11}, Lcom/google/android/gms/internal/auth/zzhn;->zzc([BII)Z

    move-result v12

    if-eqz v12, :cond_70c

    new-instance v12, Ljava/lang/String;

    sget-object v13, Lcom/google/android/gms/internal/auth/zzfa;->zzb:Ljava/nio/charset/Charset;

    invoke-direct {v12, v15, v2, v9, v13}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    :goto_6d9
    invoke-interface {v8, v12}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move v2, v11

    :goto_6dd
    if-ge v2, v1, :cond_820

    invoke-static {v15, v2, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v9

    iget v11, v5, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ne v14, v11, :cond_820

    invoke-static {v15, v9, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget v9, v5, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ltz v9, :cond_707

    if-nez v9, :cond_6f2

    goto :goto_6c6

    :cond_6f2
    add-int v11, v2, v9

    invoke-static {v15, v2, v11}, Lcom/google/android/gms/internal/auth/zzhn;->zzc([BII)Z

    move-result v12

    if-eqz v12, :cond_702

    new-instance v12, Ljava/lang/String;

    sget-object v13, Lcom/google/android/gms/internal/auth/zzfa;->zzb:Ljava/nio/charset/Charset;

    invoke-direct {v12, v15, v2, v9, v13}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    goto :goto_6d9

    :cond_702
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzb()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_707
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzc()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_70c
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzb()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_711
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzc()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_716
    move v13, v1

    move v9, v3

    move-object v10, v4

    move-object v11, v5

    move v12, v6

    goto/16 :goto_955

    :pswitch_71d
    move-object v5, v6

    move v3, v10

    move-object v8, v12

    move v7, v13

    move-object/from16 v4, v21

    move/from16 v6, v27

    const/4 v9, 0x2

    if-ne v2, v9, :cond_74e

    move-object v12, v8

    check-cast v12, Lcom/google/android/gms/internal/auth/zzdv;

    invoke-static {v15, v7, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget v8, v5, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    add-int/2addr v8, v2

    :goto_732
    if-ge v2, v8, :cond_745

    invoke-static {v15, v2, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzk([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget-wide v9, v5, Lcom/google/android/gms/internal/auth/zzdt;->zzb:J

    cmp-long v11, v9, v23

    if-eqz v11, :cond_740

    const/4 v9, 0x1

    goto :goto_741

    :cond_740
    const/4 v9, 0x0

    :goto_741
    invoke-virtual {v12, v9}, Lcom/google/android/gms/internal/auth/zzdv;->zze(Z)V

    goto :goto_732

    :cond_745
    if-ne v2, v8, :cond_749

    goto/16 :goto_7e8

    :cond_749
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzf()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_74e
    if-nez v2, :cond_716

    move-object v12, v8

    check-cast v12, Lcom/google/android/gms/internal/auth/zzdv;

    invoke-static {v15, v7, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzk([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget-wide v8, v5, Lcom/google/android/gms/internal/auth/zzdt;->zzb:J

    cmp-long v10, v8, v23

    if-eqz v10, :cond_75f

    :goto_75d
    const/4 v8, 0x1

    goto :goto_760

    :cond_75f
    const/4 v8, 0x0

    :goto_760
    invoke-virtual {v12, v8}, Lcom/google/android/gms/internal/auth/zzdv;->zze(Z)V

    if-ge v2, v1, :cond_820

    invoke-static {v15, v2, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v8

    iget v9, v5, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ne v14, v9, :cond_820

    invoke-static {v15, v8, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzk([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget-wide v8, v5, Lcom/google/android/gms/internal/auth/zzdt;->zzb:J

    cmp-long v10, v8, v23

    if-eqz v10, :cond_75f

    goto :goto_75d

    :pswitch_778
    move-object v5, v6

    move v3, v10

    move-object v8, v12

    move v7, v13

    move-object/from16 v4, v21

    move/from16 v6, v27

    const/4 v9, 0x2

    if-ne v2, v9, :cond_7a2

    move-object v12, v8

    check-cast v12, Lcom/google/android/gms/internal/auth/zzew;

    invoke-static {v15, v7, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget v8, v5, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    add-int/2addr v8, v2

    :goto_78d
    if-ge v2, v8, :cond_799

    invoke-static {v15, v2}, Lcom/google/android/gms/internal/auth/zzdu;->zzb([BI)I

    move-result v9

    invoke-virtual {v12, v9}, Lcom/google/android/gms/internal/auth/zzew;->zze(I)V

    add-int/lit8 v2, v2, 0x4

    goto :goto_78d

    :cond_799
    if-ne v2, v8, :cond_79d

    goto/16 :goto_820

    :cond_79d
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzf()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_7a2
    const/4 v9, 0x5

    if-ne v2, v9, :cond_716

    move-object v12, v8

    check-cast v12, Lcom/google/android/gms/internal/auth/zzew;

    invoke-static {v15, v7}, Lcom/google/android/gms/internal/auth/zzdu;->zzb([BI)I

    move-result v2

    invoke-virtual {v12, v2}, Lcom/google/android/gms/internal/auth/zzew;->zze(I)V

    add-int/lit8 v2, v7, 0x4

    :goto_7b1
    if-ge v2, v1, :cond_820

    invoke-static {v15, v2, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v8

    iget v9, v5, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ne v14, v9, :cond_820

    invoke-static {v15, v8}, Lcom/google/android/gms/internal/auth/zzdu;->zzb([BI)I

    move-result v2

    invoke-virtual {v12, v2}, Lcom/google/android/gms/internal/auth/zzew;->zze(I)V

    add-int/lit8 v2, v8, 0x4

    goto :goto_7b1

    :pswitch_7c5
    move-object v5, v6

    move v3, v10

    move-object v8, v12

    move v7, v13

    move-object/from16 v4, v21

    move/from16 v6, v27

    const/4 v9, 0x2

    if-ne v2, v9, :cond_7ee

    move-object v12, v8

    check-cast v12, Lcom/google/android/gms/internal/auth/zzfm;

    invoke-static {v15, v7, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget v8, v5, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    add-int/2addr v8, v2

    :goto_7da
    if-ge v2, v8, :cond_7e6

    invoke-static {v15, v2}, Lcom/google/android/gms/internal/auth/zzdu;->zzn([BI)J

    move-result-wide v9

    invoke-virtual {v12, v9, v10}, Lcom/google/android/gms/internal/auth/zzfm;->zze(J)V

    add-int/lit8 v2, v2, 0x8

    goto :goto_7da

    :cond_7e6
    if-ne v2, v8, :cond_7e9

    :goto_7e8
    goto :goto_820

    :cond_7e9
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzf()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_7ee
    const/4 v9, 0x1

    if-ne v2, v9, :cond_716

    move-object v12, v8

    check-cast v12, Lcom/google/android/gms/internal/auth/zzfm;

    invoke-static {v15, v7}, Lcom/google/android/gms/internal/auth/zzdu;->zzn([BI)J

    move-result-wide v8

    invoke-virtual {v12, v8, v9}, Lcom/google/android/gms/internal/auth/zzfm;->zze(J)V

    add-int/lit8 v2, v7, 0x8

    :goto_7fd
    if-ge v2, v1, :cond_820

    invoke-static {v15, v2, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v8

    iget v9, v5, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ne v14, v9, :cond_820

    invoke-static {v15, v8}, Lcom/google/android/gms/internal/auth/zzdu;->zzn([BI)J

    move-result-wide v9

    invoke-virtual {v12, v9, v10}, Lcom/google/android/gms/internal/auth/zzfm;->zze(J)V

    add-int/lit8 v2, v8, 0x8

    goto :goto_7fd

    :pswitch_811
    move-object v5, v6

    move v3, v10

    move-object v8, v12

    move v7, v13

    move-object/from16 v4, v21

    move/from16 v6, v27

    const/4 v9, 0x2

    if-ne v2, v9, :cond_828

    invoke-static {v15, v7, v8, v5}, Lcom/google/android/gms/internal/auth/zzdu;->zzf([BILcom/google/android/gms/internal/auth/zzez;Lcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    :cond_820
    :goto_820
    move v13, v1

    move v1, v2

    move v9, v3

    move-object v10, v4

    move-object v11, v5

    move v12, v6

    goto/16 :goto_956

    :cond_828
    if-nez v2, :cond_716

    move v13, v1

    move v1, v14

    move-object/from16 v2, p2

    move v9, v3

    move v3, v7

    move-object v10, v4

    move/from16 v4, p4

    move-object v11, v5

    move-object v5, v8

    move v12, v6

    move-object/from16 v6, p6

    invoke-static/range {v1 .. v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzj(I[BIILcom/google/android/gms/internal/auth/zzez;Lcom/google/android/gms/internal/auth/zzdt;)I

    move-result v1

    goto/16 :goto_956

    :pswitch_83e
    move-object v11, v6

    move v9, v10

    move-object v8, v12

    move v7, v13

    move-object/from16 v10, v21

    move/from16 v12, v27

    move v13, v1

    const/4 v1, 0x2

    if-ne v2, v1, :cond_869

    move-object v1, v8

    check-cast v1, Lcom/google/android/gms/internal/auth/zzfm;

    invoke-static {v15, v7, v11}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget v3, v11, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    add-int/2addr v3, v2

    :goto_854
    if-ge v2, v3, :cond_860

    invoke-static {v15, v2, v11}, Lcom/google/android/gms/internal/auth/zzdu;->zzk([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget-wide v4, v11, Lcom/google/android/gms/internal/auth/zzdt;->zzb:J

    invoke-virtual {v1, v4, v5}, Lcom/google/android/gms/internal/auth/zzfm;->zze(J)V

    goto :goto_854

    :cond_860
    if-ne v2, v3, :cond_864

    goto/16 :goto_939

    :cond_864
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzf()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_869
    if-nez v2, :cond_955

    move-object v1, v8

    check-cast v1, Lcom/google/android/gms/internal/auth/zzfm;

    invoke-static {v15, v7, v11}, Lcom/google/android/gms/internal/auth/zzdu;->zzk([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    :goto_872
    iget-wide v3, v11, Lcom/google/android/gms/internal/auth/zzdt;->zzb:J

    invoke-virtual {v1, v3, v4}, Lcom/google/android/gms/internal/auth/zzfm;->zze(J)V

    if-ge v2, v13, :cond_939

    invoke-static {v15, v2, v11}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v3

    iget v4, v11, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ne v14, v4, :cond_939

    invoke-static {v15, v3, v11}, Lcom/google/android/gms/internal/auth/zzdu;->zzk([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    goto :goto_872

    :pswitch_886
    move-object v11, v6

    move v9, v10

    move-object v8, v12

    move v7, v13

    move-object/from16 v10, v21

    move/from16 v12, v27

    move v13, v1

    const/4 v1, 0x2

    if-ne v2, v1, :cond_8b5

    move-object v1, v8

    check-cast v1, Lcom/google/android/gms/internal/auth/zzer;

    invoke-static {v15, v7, v11}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget v3, v11, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    add-int/2addr v3, v2

    :goto_89c
    if-ge v2, v3, :cond_8ac

    invoke-static {v15, v2}, Lcom/google/android/gms/internal/auth/zzdu;->zzb([BI)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result v4

    invoke-virtual {v1, v4}, Lcom/google/android/gms/internal/auth/zzer;->zze(F)V

    add-int/lit8 v2, v2, 0x4

    goto :goto_89c

    :cond_8ac
    if-ne v2, v3, :cond_8b0

    goto/16 :goto_939

    :cond_8b0
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzf()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_8b5
    const/4 v1, 0x5

    if-ne v2, v1, :cond_955

    move-object v1, v8

    check-cast v1, Lcom/google/android/gms/internal/auth/zzer;

    invoke-static {v15, v7}, Lcom/google/android/gms/internal/auth/zzdu;->zzb([BI)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/auth/zzer;->zze(F)V

    add-int/lit8 v2, v7, 0x4

    :goto_8c8
    if-ge v2, v13, :cond_939

    invoke-static {v15, v2, v11}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v3

    iget v4, v11, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ne v14, v4, :cond_939

    invoke-static {v15, v3}, Lcom/google/android/gms/internal/auth/zzdu;->zzb([BI)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/auth/zzer;->zze(F)V

    add-int/lit8 v2, v3, 0x4

    goto :goto_8c8

    :pswitch_8e0
    move-object v11, v6

    move v9, v10

    move-object v8, v12

    move v7, v13

    move-object/from16 v10, v21

    move/from16 v12, v27

    move v13, v1

    const/4 v1, 0x2

    if-ne v2, v1, :cond_90e

    move-object v1, v8

    check-cast v1, Lcom/google/android/gms/internal/auth/zzek;

    invoke-static {v15, v7, v11}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget v3, v11, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    add-int/2addr v3, v2

    :goto_8f6
    if-ge v2, v3, :cond_906

    invoke-static {v15, v2}, Lcom/google/android/gms/internal/auth/zzdu;->zzn([BI)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide v4

    invoke-virtual {v1, v4, v5}, Lcom/google/android/gms/internal/auth/zzek;->zze(D)V

    add-int/lit8 v2, v2, 0x8

    goto :goto_8f6

    :cond_906
    if-ne v2, v3, :cond_909

    goto :goto_939

    :cond_909
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzf()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_90e
    const/4 v1, 0x1

    if-ne v2, v1, :cond_955

    move-object v1, v8

    check-cast v1, Lcom/google/android/gms/internal/auth/zzek;

    invoke-static {v15, v7}, Lcom/google/android/gms/internal/auth/zzdu;->zzn([BI)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gms/internal/auth/zzek;->zze(D)V

    add-int/lit8 v2, v7, 0x8

    :goto_921
    if-ge v2, v13, :cond_939

    invoke-static {v15, v2, v11}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v3

    iget v4, v11, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ne v14, v4, :cond_939

    invoke-static {v15, v3}, Lcom/google/android/gms/internal/auth/zzdu;->zzn([BI)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide v4

    invoke-virtual {v1, v4, v5}, Lcom/google/android/gms/internal/auth/zzek;->zze(D)V

    add-int/lit8 v2, v3, 0x8

    goto :goto_921

    :cond_939
    :goto_939
    move v1, v2

    goto :goto_956

    :goto_93b
    if-ge v1, v13, :cond_956

    invoke-static {v15, v1, v11}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v3

    iget v2, v11, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-ne v14, v2, :cond_956

    move-object/from16 v1, v20

    move-object/from16 v2, p2

    move/from16 v4, p4

    move/from16 v5, v21

    move-object/from16 v6, p6

    invoke-static/range {v1 .. v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzc(Lcom/google/android/gms/internal/auth/zzgi;[BIIILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v1

    goto/16 :goto_48d

    :cond_955
    :goto_955
    move v1, v7

    :cond_956
    :goto_956
    if-eq v1, v7, :cond_968

    move-object/from16 v7, p1

    move v2, v9

    move v3, v12

    move v4, v14

    move/from16 v5, v17

    move/from16 v6, v25

    const/4 v8, 0x0

    move-object v12, v11

    move v14, v13

    move/from16 v13, p5

    goto/16 :goto_c4c

    :cond_968
    move-object/from16 v7, p1

    move/from16 v8, p5

    move v3, v1

    move-object/from16 v21, v10

    move v6, v13

    move v13, v9

    move v9, v14

    move-object v14, v11

    goto/16 :goto_c20

    :cond_975
    move v3, v5

    move v7, v13

    move-object/from16 v5, v21

    move v13, v1

    move/from16 v34, v10

    move-object v10, v9

    move/from16 v9, v34

    const/16 v1, 0x32

    if-ne v4, v1, :cond_9be

    const/4 v1, 0x2

    if-ne v2, v1, :cond_9ac

    sget-object v1, Lcom/google/android/gms/internal/auth/zzga;->zzb:Lsun/misc/Unsafe;

    invoke-direct {v0, v3}, Lcom/google/android/gms/internal/auth/zzga;->zzs(I)Ljava/lang/Object;

    move-result-object v2

    move-object/from16 v7, p1

    invoke-virtual {v1, v7, v11, v12}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    move-object v4, v3

    check-cast v4, Lcom/google/android/gms/internal/auth/zzfr;

    invoke-virtual {v4}, Lcom/google/android/gms/internal/auth/zzfr;->zze()Z

    move-result v4

    if-nez v4, :cond_9a9

    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfr;->zza()Lcom/google/android/gms/internal/auth/zzfr;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/internal/auth/zzfr;->zzb()Lcom/google/android/gms/internal/auth/zzfr;

    move-result-object v4

    invoke-static {v4, v3}, Lcom/google/android/gms/internal/auth/zzfs;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v1, v7, v11, v12, v4}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    :cond_9a9
    check-cast v2, Lcom/google/android/gms/internal/auth/zzfq;

    throw v16

    :cond_9ac
    move v1, v7

    move-object/from16 v7, p1

    :goto_9af
    move/from16 v8, p5

    move v12, v3

    move-object/from16 v21, v5

    move v3, v1

    move/from16 v34, v14

    move-object v14, v6

    move v6, v13

    move v13, v9

    move/from16 v9, v34

    goto/16 :goto_c20

    :cond_9be
    move v1, v7

    move-object/from16 v7, p1

    add-int/lit8 v21, v3, 0x2

    move-object/from16 v26, v5

    sget-object v5, Lcom/google/android/gms/internal/auth/zzga;->zzb:Lsun/misc/Unsafe;

    aget v20, v20, v21

    move-object/from16 v21, v5

    const v5, 0xfffff

    and-int v13, v20, v5

    int-to-long v5, v13

    packed-switch v4, :pswitch_data_d08

    :cond_9d4
    move/from16 v6, p4

    move/from16 v27, v3

    move v13, v9

    move/from16 v20, v14

    move-object/from16 v21, v26

    move-object/from16 v14, p6

    goto/16 :goto_c03

    :pswitch_9e1
    const/4 v4, 0x3

    if-ne v2, v4, :cond_9d4

    invoke-direct {v0, v7, v9, v3}, Lcom/google/android/gms/internal/auth/zzga;->zzu(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object v2

    and-int/lit8 v4, v14, -0x8

    or-int/lit8 v13, v4, 0x4

    invoke-direct {v0, v3}, Lcom/google/android/gms/internal/auth/zzga;->zzr(I)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v4

    move-object v8, v2

    move v5, v9

    move-object v9, v4

    move-object/from16 v10, p2

    move v11, v1

    move/from16 v12, p4

    move/from16 v4, p4

    move v6, v14

    move-object/from16 v14, p6

    invoke-static/range {v8 .. v14}, Lcom/google/android/gms/internal/auth/zzdu;->zzl(Ljava/lang/Object;Lcom/google/android/gms/internal/auth/zzgi;[BIIILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v8

    invoke-direct {v0, v7, v5, v3, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzC(Ljava/lang/Object;IILjava/lang/Object;)V

    move/from16 v27, v3

    move v13, v5

    move/from16 v20, v6

    move v2, v8

    move-object/from16 v21, v26

    move v6, v4

    goto/16 :goto_c04

    :pswitch_a0f
    move/from16 v4, p4

    move v13, v9

    move v9, v14

    if-nez v2, :cond_a2b

    move-wide v4, v5

    move-object/from16 v6, p6

    invoke-static {v15, v1, v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzk([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    move v14, v9

    iget-wide v8, v6, Lcom/google/android/gms/internal/auth/zzdt;->zzb:J

    invoke-static {v8, v9}, Lcom/google/android/gms/internal/auth/zzej;->zzc(J)J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    move-object/from16 v9, v21

    goto/16 :goto_a88

    :cond_a2b
    move/from16 v6, p4

    move-object/from16 v14, p6

    move/from16 v27, v3

    move/from16 v20, v9

    goto/16 :goto_ada

    :pswitch_a35
    move-wide v4, v5

    move v13, v9

    move-object/from16 v9, v21

    move-object/from16 v6, p6

    if-nez v2, :cond_a99

    invoke-static {v15, v1, v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget v8, v6, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    invoke-static {v8}, Lcom/google/android/gms/internal/auth/zzej;->zzb(I)I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    goto :goto_a88

    :pswitch_a4c
    move-wide v4, v5

    move v13, v9

    move-object/from16 v9, v21

    move-object/from16 v6, p6

    if-nez v2, :cond_a99

    invoke-static {v15, v1, v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget v8, v6, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    invoke-direct {v0, v3}, Lcom/google/android/gms/internal/auth/zzga;->zzq(I)Lcom/google/android/gms/internal/auth/zzey;

    move-result-object v10

    if-eqz v10, :cond_a74

    invoke-interface {v10}, Lcom/google/android/gms/internal/auth/zzey;->zza()Z

    move-result v10

    if-eqz v10, :cond_a67

    goto :goto_a74

    :cond_a67
    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/auth/zzga;->zzc(Ljava/lang/Object;)Lcom/google/android/gms/internal/auth/zzha;

    move-result-object v4

    int-to-long v8, v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v4, v14, v5}, Lcom/google/android/gms/internal/auth/zzha;->zzh(ILjava/lang/Object;)V

    goto :goto_a8e

    :cond_a74
    :goto_a74
    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    goto :goto_a88

    :pswitch_a79
    move-wide v4, v5

    move v13, v9

    move-object/from16 v9, v21

    const/4 v8, 0x2

    move-object/from16 v6, p6

    if-ne v2, v8, :cond_a99

    invoke-static {v15, v1, v6}, Lcom/google/android/gms/internal/auth/zzdu;->zza([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget-object v8, v6, Lcom/google/android/gms/internal/auth/zzdt;->zzc:Ljava/lang/Object;

    :goto_a88
    invoke-virtual {v9, v7, v11, v12, v8}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-virtual {v9, v7, v4, v5, v13}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :goto_a8e
    move/from16 v27, v3

    move/from16 v20, v14

    move-object/from16 v21, v26

    move-object v14, v6

    move/from16 v6, p4

    goto/16 :goto_c04

    :cond_a99
    move/from16 v27, v3

    move/from16 v20, v14

    move-object/from16 v21, v26

    move-object v14, v6

    move/from16 v6, p4

    goto/16 :goto_c03

    :pswitch_aa4
    move-object/from16 v6, p6

    move v13, v9

    const/4 v8, 0x2

    if-ne v2, v8, :cond_ad3

    invoke-direct {v0, v7, v13, v3}, Lcom/google/android/gms/internal/auth/zzga;->zzu(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object v8

    invoke-direct {v0, v3}, Lcom/google/android/gms/internal/auth/zzga;->zzr(I)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v2

    move v9, v1

    move-object v1, v8

    move v10, v3

    move-object/from16 v3, p2

    move/from16 v11, p4

    move v4, v9

    move-object/from16 v12, v26

    move/from16 v5, p4

    move/from16 v20, v14

    move-object v14, v6

    move-object/from16 v6, p6

    invoke-static/range {v1 .. v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzm(Ljava/lang/Object;Lcom/google/android/gms/internal/auth/zzgi;[BIILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v1

    invoke-direct {v0, v7, v13, v10, v8}, Lcom/google/android/gms/internal/auth/zzga;->zzC(Ljava/lang/Object;IILjava/lang/Object;)V

    move v2, v1

    move v1, v9

    move/from16 v27, v10

    move v6, v11

    move-object/from16 v21, v12

    goto/16 :goto_c04

    :cond_ad3
    move/from16 v20, v14

    move-object v14, v6

    move/from16 v6, p4

    move/from16 v27, v3

    :goto_ada
    move-object/from16 v21, v26

    goto/16 :goto_c03

    :pswitch_ade
    move/from16 v27, v3

    move-wide v4, v5

    move v13, v9

    move/from16 v20, v14

    move-object/from16 v9, v21

    move-object/from16 v21, v26

    const/4 v3, 0x2

    move/from16 v6, p4

    move-object/from16 v14, p6

    if-ne v2, v3, :cond_c03

    invoke-static {v15, v1, v14}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget v3, v14, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    if-nez v3, :cond_afc

    invoke-virtual {v9, v7, v11, v12, v10}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto/16 :goto_bff

    :cond_afc
    and-int v8, v8, v22

    if-eqz v8, :cond_b0e

    add-int v8, v2, v3

    invoke-static {v15, v2, v8}, Lcom/google/android/gms/internal/auth/zzhn;->zzc([BII)Z

    move-result v8

    if-eqz v8, :cond_b09

    goto :goto_b0e

    :cond_b09
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzb()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_b0e
    :goto_b0e
    new-instance v8, Ljava/lang/String;

    sget-object v10, Lcom/google/android/gms/internal/auth/zzfa;->zzb:Ljava/nio/charset/Charset;

    invoke-direct {v8, v15, v2, v3, v10}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    invoke-virtual {v9, v7, v11, v12, v8}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    add-int/2addr v2, v3

    goto/16 :goto_bff

    :pswitch_b1b
    move/from16 v27, v3

    move-wide v4, v5

    move v13, v9

    move/from16 v20, v14

    move-object/from16 v9, v21

    move-object/from16 v21, v26

    move/from16 v6, p4

    move-object/from16 v14, p6

    if-nez v2, :cond_c03

    invoke-static {v15, v1, v14}, Lcom/google/android/gms/internal/auth/zzdu;->zzk([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    move/from16 p3, v2

    iget-wide v2, v14, Lcom/google/android/gms/internal/auth/zzdt;->zzb:J

    cmp-long v8, v2, v23

    if-eqz v8, :cond_b39

    const/4 v8, 0x1

    goto :goto_b3a

    :cond_b39
    const/4 v8, 0x0

    :goto_b3a
    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    goto/16 :goto_bb1

    :pswitch_b40
    move/from16 v27, v3

    move-wide v4, v5

    move v13, v9

    move/from16 v20, v14

    move-object/from16 v9, v21

    move-object/from16 v21, v26

    const/4 v3, 0x5

    move/from16 v6, p4

    move-object/from16 v14, p6

    if-ne v2, v3, :cond_c03

    invoke-static {v15, v1}, Lcom/google/android/gms/internal/auth/zzdu;->zzb([BI)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    goto/16 :goto_bd7

    :pswitch_b5b
    move/from16 v27, v3

    move-wide v4, v5

    move v13, v9

    move/from16 v20, v14

    move-object/from16 v9, v21

    move-object/from16 v21, v26

    const/4 v3, 0x1

    move/from16 v6, p4

    move-object/from16 v14, p6

    if-ne v2, v3, :cond_c03

    invoke-static {v15, v1}, Lcom/google/android/gms/internal/auth/zzdu;->zzn([BI)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    goto/16 :goto_bfa

    :pswitch_b76
    move/from16 v27, v3

    move-wide v4, v5

    move v13, v9

    move/from16 v20, v14

    move-object/from16 v9, v21

    move-object/from16 v21, v26

    move/from16 v6, p4

    move-object/from16 v14, p6

    if-nez v2, :cond_c03

    invoke-static {v15, v1, v14}, Lcom/google/android/gms/internal/auth/zzdu;->zzh([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    iget v3, v14, Lcom/google/android/gms/internal/auth/zzdt;->zza:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v9, v7, v11, v12, v3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto/16 :goto_bff

    :pswitch_b95
    move/from16 v27, v3

    move-wide v4, v5

    move v13, v9

    move/from16 v20, v14

    move-object/from16 v9, v21

    move-object/from16 v21, v26

    move/from16 v6, p4

    move-object/from16 v14, p6

    if-nez v2, :cond_c03

    invoke-static {v15, v1, v14}, Lcom/google/android/gms/internal/auth/zzdu;->zzk([BILcom/google/android/gms/internal/auth/zzdt;)I

    move-result v2

    move/from16 p3, v2

    iget-wide v2, v14, Lcom/google/android/gms/internal/auth/zzdt;->zzb:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    :goto_bb1
    invoke-virtual {v9, v7, v11, v12, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-virtual {v9, v7, v4, v5, v13}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    move/from16 v2, p3

    goto :goto_c04

    :pswitch_bba
    move/from16 v27, v3

    move-wide v4, v5

    move v13, v9

    move/from16 v20, v14

    move-object/from16 v9, v21

    move-object/from16 v21, v26

    const/4 v3, 0x5

    move/from16 v6, p4

    move-object/from16 v14, p6

    if-ne v2, v3, :cond_c03

    invoke-static {v15, v1}, Lcom/google/android/gms/internal/auth/zzdu;->zzb([BI)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->intBitsToFloat(I)F

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    :goto_bd7
    invoke-virtual {v9, v7, v11, v12, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    add-int/lit8 v2, v1, 0x4

    goto :goto_bff

    :pswitch_bdd
    move/from16 v27, v3

    move-wide v4, v5

    move v13, v9

    move/from16 v20, v14

    move-object/from16 v9, v21

    move-object/from16 v21, v26

    const/4 v3, 0x1

    move/from16 v6, p4

    move-object/from16 v14, p6

    if-ne v2, v3, :cond_c03

    invoke-static {v15, v1}, Lcom/google/android/gms/internal/auth/zzdu;->zzn([BI)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    :goto_bfa
    invoke-virtual {v9, v7, v11, v12, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    add-int/lit8 v2, v1, 0x8

    :goto_bff
    invoke-virtual {v9, v7, v4, v5, v13}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto :goto_c04

    :cond_c03
    :goto_c03
    move v2, v1

    :goto_c04
    if-eq v2, v1, :cond_c19

    move v1, v2

    move v2, v13

    move-object v12, v14

    move/from16 v5, v17

    move/from16 v4, v20

    move-object/from16 v11, v21

    move/from16 v3, v27

    const/4 v8, 0x0

    move/from16 v13, p5

    move v14, v6

    move/from16 v6, v25

    goto/16 :goto_1b

    :cond_c19
    move/from16 v8, p5

    move v3, v2

    move/from16 v9, v20

    move/from16 v12, v27

    :goto_c20
    if-ne v9, v8, :cond_c2f

    if-nez v8, :cond_c25

    goto :goto_c2f

    :cond_c25
    move v1, v3

    move v11, v6

    move v4, v9

    move/from16 v5, v17

    move-object/from16 v10, v21

    move/from16 v6, v25

    goto :goto_c56

    :cond_c2f
    :goto_c2f
    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/auth/zzga;->zzc(Ljava/lang/Object;)Lcom/google/android/gms/internal/auth/zzha;

    move-result-object v5

    move v1, v9

    move-object/from16 v2, p2

    move-object/from16 v10, v21

    move/from16 v4, p4

    move v11, v6

    move-object/from16 v6, p6

    invoke-static/range {v1 .. v6}, Lcom/google/android/gms/internal/auth/zzdu;->zzg(I[BIILcom/google/android/gms/internal/auth/zzha;Lcom/google/android/gms/internal/auth/zzdt;)I

    move-result v1

    move v4, v9

    move v3, v12

    move v2, v13

    move-object v12, v14

    move/from16 v5, v17

    move/from16 v6, v25

    move v13, v8

    move v14, v11

    const/4 v8, 0x0

    :goto_c4c
    move-object v11, v10

    goto/16 :goto_1b

    :cond_c4f
    move/from16 v17, v5

    move/from16 v25, v6

    move-object v10, v11

    move v8, v13

    move v11, v14

    :goto_c56
    const v2, 0xfffff

    if-eq v6, v2, :cond_c5f

    int-to-long v12, v6

    invoke-virtual {v10, v7, v12, v13, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_c5f
    iget v3, v0, Lcom/google/android/gms/internal/auth/zzga;->zzi:I

    :goto_c61
    iget v5, v0, Lcom/google/android/gms/internal/auth/zzga;->zzj:I

    if-ge v3, v5, :cond_c8c

    iget-object v5, v0, Lcom/google/android/gms/internal/auth/zzga;->zzh:[I

    aget v5, v5, v3

    iget-object v6, v0, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    aget v6, v6, v5

    invoke-direct {v0, v5}, Lcom/google/android/gms/internal/auth/zzga;->zzo(I)I

    move-result v6

    and-int/2addr v6, v2

    int-to-long v9, v6

    invoke-static {v7, v9, v10}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v6

    if-nez v6, :cond_c7a

    goto :goto_c80

    :cond_c7a
    invoke-direct {v0, v5}, Lcom/google/android/gms/internal/auth/zzga;->zzq(I)Lcom/google/android/gms/internal/auth/zzey;

    move-result-object v9

    if-nez v9, :cond_c83

    :goto_c80
    add-int/lit8 v3, v3, 0x1

    goto :goto_c61

    :cond_c83
    check-cast v6, Lcom/google/android/gms/internal/auth/zzfr;

    invoke-direct {v0, v5}, Lcom/google/android/gms/internal/auth/zzga;->zzs(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/auth/zzfq;

    throw v16

    :cond_c8c
    if-nez v8, :cond_c96

    if-ne v1, v11, :cond_c91

    goto :goto_c9a

    :cond_c91
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzd()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :cond_c96
    if-gt v1, v11, :cond_c9b

    if-ne v4, v8, :cond_c9b

    :goto_c9a
    return v1

    :cond_c9b
    invoke-static {}, Lcom/google/android/gms/internal/auth/zzfb;->zzd()Lcom/google/android/gms/internal/auth/zzfb;

    move-result-object v1

    throw v1

    :pswitch_data_ca0
    .packed-switch 0x0
        :pswitch_379
        :pswitch_360
        :pswitch_343
        :pswitch_343
        :pswitch_32f
        :pswitch_30e
        :pswitch_2f8
        :pswitch_2dc
        :pswitch_1bd
        :pswitch_18c
        :pswitch_179
        :pswitch_32f
        :pswitch_146
        :pswitch_2f8
        :pswitch_30e
        :pswitch_12f
        :pswitch_106
    .end packed-switch

    :pswitch_data_cc6
    .packed-switch 0x12
        :pswitch_8e0
        :pswitch_886
        :pswitch_83e
        :pswitch_83e
        :pswitch_811
        :pswitch_7c5
        :pswitch_778
        :pswitch_71d
        :pswitch_664
        :pswitch_62c
        :pswitch_5d1
        :pswitch_811
        :pswitch_526
        :pswitch_778
        :pswitch_7c5
        :pswitch_4d8
        :pswitch_494
        :pswitch_8e0
        :pswitch_886
        :pswitch_83e
        :pswitch_83e
        :pswitch_811
        :pswitch_7c5
        :pswitch_778
        :pswitch_71d
        :pswitch_811
        :pswitch_526
        :pswitch_778
        :pswitch_7c5
        :pswitch_4d8
        :pswitch_494
    .end packed-switch

    :pswitch_data_d08
    .packed-switch 0x33
        :pswitch_bdd
        :pswitch_bba
        :pswitch_b95
        :pswitch_b95
        :pswitch_b76
        :pswitch_b5b
        :pswitch_b40
        :pswitch_b1b
        :pswitch_ade
        :pswitch_aa4
        :pswitch_a79
        :pswitch_b76
        :pswitch_a4c
        :pswitch_b40
        :pswitch_b5b
        :pswitch_a35
        :pswitch_a0f
        :pswitch_9e1
    .end packed-switch
.end method

.method public final zzd()Ljava/lang/Object;
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzg:Lcom/google/android/gms/internal/auth/zzfx;

    check-cast v0, Lcom/google/android/gms/internal/auth/zzev;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/auth/zzev;->zzc()Lcom/google/android/gms/internal/auth/zzev;

    move-result-object v0

    return-object v0
.end method

.method public final zze(Ljava/lang/Object;)V
    .registers 9

    invoke-static {p1}, Lcom/google/android/gms/internal/auth/zzga;->zzH(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_7

    return-void

    :cond_7
    instance-of v0, p1, Lcom/google/android/gms/internal/auth/zzev;

    const/4 v1, 0x0

    if-eqz v0, :cond_1a

    move-object v0, p1

    check-cast v0, Lcom/google/android/gms/internal/auth/zzev;

    const v2, 0x7fffffff

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/auth/zzev;->zzl(I)V

    iput v1, v0, Lcom/google/android/gms/internal/auth/zzdq;->zza:I

    invoke-virtual {v0}, Lcom/google/android/gms/internal/auth/zzev;->zzj()V

    :cond_1a
    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    array-length v0, v0

    :goto_1d
    if-ge v1, v0, :cond_75

    invoke-direct {p0, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzo(I)I

    move-result v2

    const v3, 0xfffff

    and-int/2addr v3, v2

    invoke-static {v2}, Lcom/google/android/gms/internal/auth/zzga;->zzn(I)I

    move-result v2

    int-to-long v3, v3

    const/16 v5, 0x9

    if-eq v2, v5, :cond_5f

    const/16 v5, 0x3c

    if-eq v2, v5, :cond_54

    const/16 v5, 0x44

    if-eq v2, v5, :cond_54

    packed-switch v2, :pswitch_data_7c

    goto :goto_72

    :pswitch_3c
    sget-object v2, Lcom/google/android/gms/internal/auth/zzga;->zzb:Lsun/misc/Unsafe;

    invoke-virtual {v2, p1, v3, v4}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_72

    move-object v6, v5

    check-cast v6, Lcom/google/android/gms/internal/auth/zzfr;

    invoke-virtual {v6}, Lcom/google/android/gms/internal/auth/zzfr;->zzc()V

    invoke-virtual {v2, p1, v3, v4, v5}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_72

    :pswitch_4e
    iget-object v2, p0, Lcom/google/android/gms/internal/auth/zzga;->zzk:Lcom/google/android/gms/internal/auth/zzfl;

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/auth/zzfl;->zza(Ljava/lang/Object;J)V

    goto :goto_72

    :cond_54
    iget-object v2, p0, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    aget v2, v2, v1

    invoke-direct {p0, p1, v2, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v2

    if-eqz v2, :cond_72

    goto :goto_65

    :cond_5f
    :pswitch_5f
    invoke-direct {p0, p1, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_72

    :goto_65
    invoke-direct {p0, v1}, Lcom/google/android/gms/internal/auth/zzga;->zzr(I)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v2

    sget-object v5, Lcom/google/android/gms/internal/auth/zzga;->zzb:Lsun/misc/Unsafe;

    invoke-virtual {v5, p1, v3, v4}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/google/android/gms/internal/auth/zzgi;->zze(Ljava/lang/Object;)V

    :cond_72
    :goto_72
    add-int/lit8 v1, v1, 0x3

    goto :goto_1d

    :cond_75
    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzl:Lcom/google/android/gms/internal/auth/zzgz;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/auth/zzgz;->zze(Ljava/lang/Object;)V

    return-void

    nop

    :pswitch_data_7c
    .packed-switch 0x11
        :pswitch_5f
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_4e
        :pswitch_3c
    .end packed-switch
.end method

.method public final zzf(Ljava/lang/Object;Ljava/lang/Object;)V
    .registers 9

    invoke-static {p1}, Lcom/google/android/gms/internal/auth/zzga;->zzw(Ljava/lang/Object;)V

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 v0, 0x0

    :goto_7
    iget-object v1, p0, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    array-length v1, v1

    if-ge v0, v1, :cond_101

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzo(I)I

    move-result v1

    const v2, 0xfffff

    and-int/2addr v2, v1

    iget-object v3, p0, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    aget v3, v3, v0

    invoke-static {v1}, Lcom/google/android/gms/internal/auth/zzga;->zzn(I)I

    move-result v1

    int-to-long v4, v2

    packed-switch v1, :pswitch_data_108

    goto/16 :goto_fd

    :pswitch_22
    invoke-direct {p0, p2, v3, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto :goto_34

    :pswitch_29
    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzy(Ljava/lang/Object;Ljava/lang/Object;I)V

    goto/16 :goto_fd

    :pswitch_2e
    invoke-direct {p0, p2, v3, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v1

    if-eqz v1, :cond_fd

    :goto_34
    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    invoke-static {p1, v4, v5, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzp(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v3, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzA(Ljava/lang/Object;II)V

    goto/16 :goto_fd

    :pswitch_40
    sget v1, Lcom/google/android/gms/internal/auth/zzgk;->zza:I

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/google/android/gms/internal/auth/zzfs;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-static {p1, v4, v5, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzp(Ljava/lang/Object;JLjava/lang/Object;)V

    goto/16 :goto_fd

    :pswitch_53
    iget-object v1, p0, Lcom/google/android/gms/internal/auth/zzga;->zzk:Lcom/google/android/gms/internal/auth/zzfl;

    invoke-virtual {v1, p1, p2, v4, v5}, Lcom/google/android/gms/internal/auth/zzfl;->zzb(Ljava/lang/Object;Ljava/lang/Object;J)V

    goto/16 :goto_fd

    :pswitch_5a
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto/16 :goto_d7

    :pswitch_62
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto :goto_7e

    :pswitch_69
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto/16 :goto_d7

    :pswitch_71
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto :goto_7e

    :pswitch_78
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    :goto_7e
    goto :goto_c2

    :pswitch_7f
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto :goto_c2

    :pswitch_86
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto :goto_98

    :pswitch_8d
    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzx(Ljava/lang/Object;Ljava/lang/Object;I)V

    goto/16 :goto_fd

    :pswitch_92
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    :goto_98
    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    invoke-static {p1, v4, v5, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzp(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_fa

    :pswitch_a0
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/auth/zzhj;->zzt(Ljava/lang/Object;J)Z

    move-result v1

    invoke-static {p1, v4, v5, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzk(Ljava/lang/Object;JZ)V

    goto :goto_fa

    :pswitch_ae
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto :goto_c2

    :pswitch_b5
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto :goto_d7

    :pswitch_bc
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    :goto_c2
    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result v1

    invoke-static {p1, v4, v5, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzn(Ljava/lang/Object;JI)V

    goto :goto_fa

    :pswitch_ca
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    goto :goto_d7

    :pswitch_d1
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    :goto_d7
    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/auth/zzhj;->zzd(Ljava/lang/Object;J)J

    move-result-wide v1

    invoke-static {p1, v4, v5, v1, v2}, Lcom/google/android/gms/internal/auth/zzhj;->zzo(Ljava/lang/Object;JJ)V

    goto :goto_fa

    :pswitch_df
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/auth/zzhj;->zzb(Ljava/lang/Object;J)F

    move-result v1

    invoke-static {p1, v4, v5, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzm(Ljava/lang/Object;JF)V

    goto :goto_fa

    :pswitch_ed
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzE(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_fd

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/auth/zzhj;->zza(Ljava/lang/Object;J)D

    move-result-wide v1

    invoke-static {p1, v4, v5, v1, v2}, Lcom/google/android/gms/internal/auth/zzhj;->zzl(Ljava/lang/Object;JD)V

    :goto_fa
    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzz(Ljava/lang/Object;I)V

    :cond_fd
    :goto_fd
    add-int/lit8 v0, v0, 0x3

    goto/16 :goto_7

    :cond_101
    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzl:Lcom/google/android/gms/internal/auth/zzgz;

    invoke-static {v0, p1, p2}, Lcom/google/android/gms/internal/auth/zzgk;->zzd(Lcom/google/android/gms/internal/auth/zzgz;Ljava/lang/Object;Ljava/lang/Object;)V

    return-void

    nop

    :pswitch_data_108
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

.method public final zzg(Ljava/lang/Object;[BIILcom/google/android/gms/internal/auth/zzdt;)V
    .registers 13

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move v4, p4

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Lcom/google/android/gms/internal/auth/zzga;->zzb(Ljava/lang/Object;[BIIILcom/google/android/gms/internal/auth/zzdt;)I

    return-void
.end method

.method public final zzh(Ljava/lang/Object;Ljava/lang/Object;)Z
    .registers 11

    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    array-length v0, v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_5
    if-ge v2, v0, :cond_1ba

    invoke-direct {p0, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzo(I)I

    move-result v3

    const v4, 0xfffff

    and-int v5, v3, v4

    invoke-static {v3}, Lcom/google/android/gms/internal/auth/zzga;->zzn(I)I

    move-result v3

    int-to-long v5, v5

    packed-switch v3, :pswitch_data_1d0

    goto/16 :goto_1b6

    :pswitch_1a
    invoke-direct {p0, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzl(I)I

    move-result v3

    and-int/2addr v3, v4

    int-to-long v3, v3

    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result v7

    invoke-static {p2, v3, v4}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result v3

    if-ne v7, v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/auth/zzgk;->zzf(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1b6

    goto/16 :goto_1b5

    :pswitch_3a
    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/auth/zzgk;->zzf(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1b6

    goto/16 :goto_1b5

    :pswitch_4a
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/auth/zzgk;->zzf(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_60
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzd(Ljava/lang/Object;J)J

    move-result-wide v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzd(Ljava/lang/Object;J)J

    move-result-wide v5

    cmp-long v7, v3, v5

    if-nez v7, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_74
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result v4

    if-ne v3, v4, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_86
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzd(Ljava/lang/Object;J)J

    move-result-wide v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzd(Ljava/lang/Object;J)J

    move-result-wide v5

    cmp-long v7, v3, v5

    if-nez v7, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_9a
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result v4

    if-ne v3, v4, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_ac
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result v4

    if-ne v3, v4, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_be
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result v4

    if-ne v3, v4, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_d0
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/auth/zzgk;->zzf(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_e6
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/auth/zzgk;->zzf(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_fc
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/auth/zzgk;->zzf(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_112
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzt(Ljava/lang/Object;J)Z

    move-result v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzt(Ljava/lang/Object;J)Z

    move-result v4

    if-ne v3, v4, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_124
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result v4

    if-ne v3, v4, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_136
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzd(Ljava/lang/Object;J)J

    move-result-wide v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzd(Ljava/lang/Object;J)J

    move-result-wide v5

    cmp-long v7, v3, v5

    if-nez v7, :cond_1b5

    goto/16 :goto_1b6

    :pswitch_14a
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzc(Ljava/lang/Object;J)I

    move-result v4

    if-ne v3, v4, :cond_1b5

    goto :goto_1b6

    :pswitch_15b
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzd(Ljava/lang/Object;J)J

    move-result-wide v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzd(Ljava/lang/Object;J)J

    move-result-wide v5

    cmp-long v7, v3, v5

    if-nez v7, :cond_1b5

    goto :goto_1b6

    :pswitch_16e
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzd(Ljava/lang/Object;J)J

    move-result-wide v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzd(Ljava/lang/Object;J)J

    move-result-wide v5

    cmp-long v7, v3, v5

    if-nez v7, :cond_1b5

    goto :goto_1b6

    :pswitch_181
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzb(Ljava/lang/Object;J)F

    move-result v3

    invoke-static {v3}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zzb(Ljava/lang/Object;J)F

    move-result v4

    invoke-static {v4}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v4

    if-ne v3, v4, :cond_1b5

    goto :goto_1b6

    :pswitch_19a
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/auth/zzga;->zzD(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v3

    if-eqz v3, :cond_1b5

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zza(Ljava/lang/Object;J)D

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    invoke-static {p2, v5, v6}, Lcom/google/android/gms/internal/auth/zzhj;->zza(Ljava/lang/Object;J)D

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v5

    cmp-long v7, v3, v5

    if-nez v7, :cond_1b5

    goto :goto_1b6

    :cond_1b5
    :goto_1b5
    return v1

    :cond_1b6
    :goto_1b6
    add-int/lit8 v2, v2, 0x3

    goto/16 :goto_5

    :cond_1ba
    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzl:Lcom/google/android/gms/internal/auth/zzgz;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/auth/zzgz;->zzb(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    iget-object v0, p0, Lcom/google/android/gms/internal/auth/zzga;->zzl:Lcom/google/android/gms/internal/auth/zzgz;

    invoke-virtual {v0, p2}, Lcom/google/android/gms/internal/auth/zzgz;->zzb(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    invoke-virtual {p1, p2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_1cd

    return v1

    :cond_1cd
    const/4 p1, 0x1

    return p1

    nop

    :pswitch_data_1d0
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

.method public final zzi(Ljava/lang/Object;)Z
    .registers 19

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    const v8, 0xfffff

    const/4 v9, 0x0

    const v0, 0xfffff

    const/4 v1, 0x0

    const/4 v10, 0x0

    :goto_d
    iget v2, v6, Lcom/google/android/gms/internal/auth/zzga;->zzi:I

    const/4 v3, 0x1

    if-ge v10, v2, :cond_e6

    iget-object v2, v6, Lcom/google/android/gms/internal/auth/zzga;->zzh:[I

    aget v11, v2, v10

    iget-object v2, v6, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    aget v12, v2, v11

    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/auth/zzga;->zzo(I)I

    move-result v13

    iget-object v2, v6, Lcom/google/android/gms/internal/auth/zzga;->zzc:[I

    add-int/lit8 v4, v11, 0x2

    aget v2, v2, v4

    and-int v4, v2, v8

    ushr-int/lit8 v2, v2, 0x14

    shl-int v14, v3, v2

    if-eq v4, v0, :cond_39

    if-eq v4, v8, :cond_35

    int-to-long v0, v4

    sget-object v2, Lcom/google/android/gms/internal/auth/zzga;->zzb:Lsun/misc/Unsafe;

    invoke-virtual {v2, v7, v0, v1}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v1

    :cond_35
    move/from16 v16, v1

    move v15, v4

    goto :goto_3c

    :cond_39
    move v15, v0

    move/from16 v16, v1

    :goto_3c
    const/high16 v0, 0x10000000

    and-int/2addr v0, v13

    if-eqz v0, :cond_52

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v15

    move/from16 v4, v16

    move v5, v14

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/auth/zzga;->zzF(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_51

    goto :goto_52

    :cond_51
    return v9

    :cond_52
    :goto_52
    invoke-static {v13}, Lcom/google/android/gms/internal/auth/zzga;->zzn(I)I

    move-result v0

    const/16 v1, 0x9

    if-eq v0, v1, :cond_c5

    const/16 v1, 0x11

    if-eq v0, v1, :cond_c5

    const/16 v1, 0x1b

    if-eq v0, v1, :cond_9d

    const/16 v1, 0x3c

    if-eq v0, v1, :cond_8c

    const/16 v1, 0x44

    if-eq v0, v1, :cond_8c

    const/16 v1, 0x31

    if-eq v0, v1, :cond_9d

    const/16 v1, 0x32

    if-eq v0, v1, :cond_74

    goto/16 :goto_df

    :cond_74
    and-int v0, v13, v8

    int-to-long v0, v0

    invoke-static {v7, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/auth/zzfr;

    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_84

    goto :goto_df

    :cond_84
    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/auth/zzga;->zzs(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/auth/zzfq;

    const/4 v0, 0x0

    throw v0

    :cond_8c
    invoke-direct {v6, v7, v12, v11}, Lcom/google/android/gms/internal/auth/zzga;->zzI(Ljava/lang/Object;II)Z

    move-result v0

    if-eqz v0, :cond_df

    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/auth/zzga;->zzr(I)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v0

    invoke-static {v7, v13, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzG(Ljava/lang/Object;ILcom/google/android/gms/internal/auth/zzgi;)Z

    move-result v0

    if-nez v0, :cond_df

    return v9

    :cond_9d
    and-int v0, v13, v8

    int-to-long v0, v0

    invoke-static {v7, v0, v1}, Lcom/google/android/gms/internal/auth/zzhj;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_df

    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/auth/zzga;->zzr(I)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v1

    const/4 v2, 0x0

    :goto_b1
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    if-ge v2, v3, :cond_df

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v1, v3}, Lcom/google/android/gms/internal/auth/zzgi;->zzi(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_c2

    return v9

    :cond_c2
    add-int/lit8 v2, v2, 0x1

    goto :goto_b1

    :cond_c5
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v11

    move v3, v15

    move/from16 v4, v16

    move v5, v14

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/auth/zzga;->zzF(Ljava/lang/Object;IIII)Z

    move-result v0

    if-eqz v0, :cond_df

    invoke-direct {v6, v11}, Lcom/google/android/gms/internal/auth/zzga;->zzr(I)Lcom/google/android/gms/internal/auth/zzgi;

    move-result-object v0

    invoke-static {v7, v13, v0}, Lcom/google/android/gms/internal/auth/zzga;->zzG(Ljava/lang/Object;ILcom/google/android/gms/internal/auth/zzgi;)Z

    move-result v0

    if-nez v0, :cond_df

    return v9

    :cond_df
    :goto_df
    add-int/lit8 v10, v10, 0x1

    move v0, v15

    move/from16 v1, v16

    goto/16 :goto_d

    :cond_e6
    return v3
.end method
