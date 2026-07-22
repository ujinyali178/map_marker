.class public abstract Lcom/google/android/gms/internal/play_billing/zzee;
.super Lcom/google/android/gms/internal/play_billing/zzdm;
.source "SourceFile"


# static fields
.field public static final synthetic zzb:I

.field private static final zzc:Ljava/util/logging/Logger;

.field private static final zzd:Z


# instance fields
.field zza:Lcom/google/android/gms/internal/play_billing/zzef;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lcom/google/android/gms/internal/play_billing/zzee;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzee;->zzc:Ljava/util/logging/Logger;

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzx()Z

    move-result v0

    sput-boolean v0, Lcom/google/android/gms/internal/play_billing/zzee;->zzd:Z

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzdm;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/gms/internal/play_billing/zzed;)V
    .registers 2

    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzdm;-><init>()V

    return-void
.end method

.method static bridge synthetic zzC()Z
    .registers 1

    sget-boolean v0, Lcom/google/android/gms/internal/play_billing/zzee;->zzd:Z

    return v0
.end method

.method static zzt(ILcom/google/android/gms/internal/play_billing/zzgc;Lcom/google/android/gms/internal/play_billing/zzgm;)I
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    check-cast p1, Lcom/google/android/gms/internal/play_billing/zzdg;

    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/play_billing/zzdg;->zza(Lcom/google/android/gms/internal/play_billing/zzgm;)I

    move-result p1

    shl-int/lit8 p0, p0, 0x3

    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result p0

    add-int/2addr p0, p0

    add-int/2addr p0, p1

    return p0
.end method

.method public static zzu(I)I
    .registers 1

    if-ltz p0, :cond_7

    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result p0

    return p0

    :cond_7
    const/16 p0, 0xa

    return p0
.end method

.method static zzv(Lcom/google/android/gms/internal/play_billing/zzgc;Lcom/google/android/gms/internal/play_billing/zzgm;)I
    .registers 2

    check-cast p0, Lcom/google/android/gms/internal/play_billing/zzdg;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/play_billing/zzdg;->zza(Lcom/google/android/gms/internal/play_billing/zzgm;)I

    move-result p0

    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result p1

    add-int/2addr p1, p0

    return p1
.end method

.method public static zzw(Ljava/lang/String;)I
    .registers 2

    :try_start_0
    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzhs;->zzc(Ljava/lang/CharSequence;)I

    move-result p0
    :try_end_4
    .catch Lcom/google/android/gms/internal/play_billing/zzhr; {:try_start_0 .. :try_end_4} :catch_5

    goto :goto_c

    :catch_5
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzfd;->zzb:Ljava/nio/charset/Charset;

    invoke-virtual {p0, v0}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object p0

    array-length p0, p0

    :goto_c
    invoke-static {p0}, Lcom/google/android/gms/internal/play_billing/zzee;->zzx(I)I

    move-result v0

    add-int/2addr v0, p0

    return v0
.end method

.method public static zzx(I)I
    .registers 2

    and-int/lit8 v0, p0, -0x80

    if-nez v0, :cond_6

    const/4 p0, 0x1

    return p0

    :cond_6
    and-int/lit16 v0, p0, -0x4000

    if-nez v0, :cond_c

    const/4 p0, 0x2

    return p0

    :cond_c
    const/high16 v0, -0x200000

    and-int/2addr v0, p0

    if-nez v0, :cond_13

    const/4 p0, 0x3

    return p0

    :cond_13
    const/high16 v0, -0x10000000

    and-int/2addr p0, v0

    if-nez p0, :cond_1a

    const/4 p0, 0x4

    return p0

    :cond_1a
    const/4 p0, 0x5

    return p0
.end method

.method public static zzy(J)I
    .registers 9

    const-wide/16 v0, -0x80

    and-long/2addr v0, p0

    const/4 v2, 0x1

    const-wide/16 v3, 0x0

    cmp-long v5, v0, v3

    if-nez v5, :cond_b

    return v2

    :cond_b
    cmp-long v0, p0, v3

    if-gez v0, :cond_12

    const/16 p0, 0xa

    return p0

    :cond_12
    const-wide v0, -0x800000000L

    and-long/2addr v0, p0

    cmp-long v5, v0, v3

    if-eqz v5, :cond_21

    const/4 v0, 0x6

    const/16 v1, 0x1c

    ushr-long/2addr p0, v1

    goto :goto_22

    :cond_21
    const/4 v0, 0x2

    :goto_22
    const-wide/32 v5, -0x200000

    and-long/2addr v5, p0

    cmp-long v1, v5, v3

    if-eqz v1, :cond_2f

    const/16 v1, 0xe

    ushr-long/2addr p0, v1

    add-int/lit8 v0, v0, 0x2

    :cond_2f
    const-wide/16 v5, -0x4000

    and-long/2addr p0, v5

    cmp-long v1, p0, v3

    if-eqz v1, :cond_37

    add-int/2addr v0, v2

    :cond_37
    return v0
.end method

.method public static zzz([BII)Lcom/google/android/gms/internal/play_billing/zzee;
    .registers 4

    new-instance p1, Lcom/google/android/gms/internal/play_billing/zzeb;

    const/4 v0, 0x0

    invoke-direct {p1, p0, v0, p2}, Lcom/google/android/gms/internal/play_billing/zzeb;-><init>([BII)V

    return-object p1
.end method


# virtual methods
.method public final zzA()V
    .registers 3

    invoke-virtual {p0}, Lcom/google/android/gms/internal/play_billing/zzee;->zza()I

    move-result v0

    if-nez v0, :cond_7

    return-void

    :cond_7
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Did not write as much data as expected."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method final zzB(Ljava/lang/String;Lcom/google/android/gms/internal/play_billing/zzhr;)V
    .registers 9

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzee;->zzc:Ljava/util/logging/Logger;

    sget-object v1, Ljava/util/logging/Level;->WARNING:Ljava/util/logging/Level;

    const-string v2, "com.google.protobuf.CodedOutputStream"

    const-string v3, "inefficientWriteStringNoTag"

    const-string v4, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!"

    move-object v5, p2

    invoke-virtual/range {v0 .. v5}, Ljava/util/logging/Logger;->logp(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    sget-object p2, Lcom/google/android/gms/internal/play_billing/zzfd;->zzb:Ljava/nio/charset/Charset;

    invoke-virtual {p1, p2}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object p1

    :try_start_14
    array-length p2, p1

    invoke-virtual {p0, p2}, Lcom/google/android/gms/internal/play_billing/zzee;->zzq(I)V

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0, p2}, Lcom/google/android/gms/internal/play_billing/zzee;->zzl([BII)V
    :try_end_1c
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_14 .. :try_end_1c} :catch_1d

    return-void

    :catch_1d
    move-exception p1

    new-instance p2, Lcom/google/android/gms/internal/play_billing/zzec;

    invoke-direct {p2, p1}, Lcom/google/android/gms/internal/play_billing/zzec;-><init>(Ljava/lang/Throwable;)V

    throw p2
.end method

.method public abstract zza()I
.end method

.method public abstract zzb(B)V
.end method

.method public abstract zzd(IZ)V
.end method

.method public abstract zze(ILcom/google/android/gms/internal/play_billing/zzdw;)V
.end method

.method public abstract zzf(II)V
.end method

.method public abstract zzg(I)V
.end method

.method public abstract zzh(IJ)V
.end method

.method public abstract zzi(J)V
.end method

.method public abstract zzj(II)V
.end method

.method public abstract zzk(I)V
.end method

.method public abstract zzl([BII)V
.end method

.method public abstract zzm(ILjava/lang/String;)V
.end method

.method public abstract zzo(II)V
.end method

.method public abstract zzp(II)V
.end method

.method public abstract zzq(I)V
.end method

.method public abstract zzr(IJ)V
.end method

.method public abstract zzs(J)V
.end method
