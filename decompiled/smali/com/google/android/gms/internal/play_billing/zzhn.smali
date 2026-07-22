.class final Lcom/google/android/gms/internal/play_billing/zzhn;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static final zza:J

.field static final zzb:Z

.field private static final zzc:Lsun/misc/Unsafe;

.field private static final zzd:Ljava/lang/Class;

.field private static final zze:Z

.field private static final zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

.field private static final zzg:Z

.field private static final zzh:Z


# direct methods
.method static constructor <clinit>()V
    .registers 17

    const-class v1, [Ljava/lang/Object;

    const-class v2, [D

    const-class v3, [F

    const-class v4, [J

    const-class v5, [I

    const-class v6, [Z

    const-class v7, Ljava/lang/Object;

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzg()Lsun/misc/Unsafe;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc:Lsun/misc/Unsafe;

    sget v8, Lcom/google/android/gms/internal/play_billing/zzdi;->zza:I

    const-class v8, Llibcore/io/Memory;

    sput-object v8, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd:Ljava/lang/Class;

    sget-object v8, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    invoke-static {v8}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzv(Ljava/lang/Class;)Z

    move-result v9

    sput-boolean v9, Lcom/google/android/gms/internal/play_billing/zzhn;->zze:Z

    sget-object v10, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-static {v10}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzv(Ljava/lang/Class;)Z

    move-result v10

    const/4 v11, 0x0

    if-nez v0, :cond_2c

    goto :goto_3b

    :cond_2c
    if-eqz v9, :cond_34

    new-instance v11, Lcom/google/android/gms/internal/play_billing/zzhl;

    invoke-direct {v11, v0}, Lcom/google/android/gms/internal/play_billing/zzhl;-><init>(Lsun/misc/Unsafe;)V

    goto :goto_3b

    :cond_34
    if-eqz v10, :cond_3b

    new-instance v11, Lcom/google/android/gms/internal/play_billing/zzhk;

    invoke-direct {v11, v0}, Lcom/google/android/gms/internal/play_billing/zzhk;-><init>(Lsun/misc/Unsafe;)V

    :cond_3b
    :goto_3b
    sput-object v11, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    const-string v9, "getLong"

    const-string v10, "objectFieldOffset"

    const/4 v12, 0x2

    const/4 v13, 0x1

    const/4 v14, 0x0

    if-nez v11, :cond_48

    :goto_46
    const/4 v0, 0x0

    goto :goto_6e

    :cond_48
    iget-object v0, v11, Lcom/google/android/gms/internal/play_billing/zzhm;->zza:Lsun/misc/Unsafe;

    :try_start_4a
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    new-array v11, v13, [Ljava/lang/Class;

    const-class v15, Ljava/lang/reflect/Field;

    aput-object v15, v11, v14

    invoke-virtual {v0, v10, v11}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    new-array v11, v12, [Ljava/lang/Class;

    aput-object v7, v11, v14

    aput-object v8, v11, v13

    invoke-virtual {v0, v9, v11}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzB()Ljava/lang/reflect/Field;

    move-result-object v0
    :try_end_64
    .catchall {:try_start_4a .. :try_end_64} :catchall_69

    if-nez v0, :cond_67

    goto :goto_46

    :cond_67
    const/4 v0, 0x1

    goto :goto_6e

    :catchall_69
    move-exception v0

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzh(Ljava/lang/Throwable;)V

    goto :goto_46

    :goto_6e
    sput-boolean v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzg:Z

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    if-nez v0, :cond_76

    :goto_74
    const/4 v0, 0x0

    goto :goto_ed

    :cond_76
    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzhm;->zza:Lsun/misc/Unsafe;

    :try_start_78
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    new-array v8, v13, [Ljava/lang/Class;

    const-class v11, Ljava/lang/reflect/Field;

    aput-object v11, v8, v14

    invoke-virtual {v0, v10, v8}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    const-string v8, "arrayBaseOffset"

    new-array v10, v13, [Ljava/lang/Class;

    const-class v11, Ljava/lang/Class;

    aput-object v11, v10, v14

    invoke-virtual {v0, v8, v10}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    const-string v8, "arrayIndexScale"

    new-array v10, v13, [Ljava/lang/Class;

    const-class v11, Ljava/lang/Class;

    aput-object v11, v10, v14

    invoke-virtual {v0, v8, v10}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    const-string v8, "getInt"

    new-array v10, v12, [Ljava/lang/Class;

    aput-object v7, v10, v14

    sget-object v11, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    aput-object v11, v10, v13

    invoke-virtual {v0, v8, v10}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    const-string v8, "putInt"

    const/4 v10, 0x3

    new-array v15, v10, [Ljava/lang/Class;

    aput-object v7, v15, v14

    aput-object v11, v15, v13

    sget-object v16, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v16, v15, v12

    invoke-virtual {v0, v8, v15}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    new-array v8, v12, [Ljava/lang/Class;

    aput-object v7, v8, v14

    aput-object v11, v8, v13

    invoke-virtual {v0, v9, v8}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    const-string v8, "putLong"

    new-array v9, v10, [Ljava/lang/Class;

    aput-object v7, v9, v14

    aput-object v11, v9, v13

    aput-object v11, v9, v12

    invoke-virtual {v0, v8, v9}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    const-string v8, "getObject"

    new-array v9, v12, [Ljava/lang/Class;

    aput-object v7, v9, v14

    aput-object v11, v9, v13

    invoke-virtual {v0, v8, v9}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    const-string v8, "putObject"

    new-array v9, v10, [Ljava/lang/Class;

    aput-object v7, v9, v14

    aput-object v11, v9, v13

    aput-object v7, v9, v12

    invoke-virtual {v0, v8, v9}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    :try_end_e6
    .catchall {:try_start_78 .. :try_end_e6} :catchall_e8

    const/4 v0, 0x1

    goto :goto_ed

    :catchall_e8
    move-exception v0

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzh(Ljava/lang/Throwable;)V

    goto :goto_74

    :goto_ed
    sput-boolean v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzh:Z

    const-class v0, [B

    invoke-static {v0}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzz(Ljava/lang/Class;)I

    move-result v0

    int-to-long v7, v0

    sput-wide v7, Lcom/google/android/gms/internal/play_billing/zzhn;->zza:J

    invoke-static {v6}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzz(Ljava/lang/Class;)I

    invoke-static {v6}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzA(Ljava/lang/Class;)I

    invoke-static {v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzz(Ljava/lang/Class;)I

    invoke-static {v5}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzA(Ljava/lang/Class;)I

    invoke-static {v4}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzz(Ljava/lang/Class;)I

    invoke-static {v4}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzA(Ljava/lang/Class;)I

    invoke-static {v3}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzz(Ljava/lang/Class;)I

    invoke-static {v3}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzA(Ljava/lang/Class;)I

    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzz(Ljava/lang/Class;)I

    invoke-static {v2}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzA(Ljava/lang/Class;)I

    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzz(Ljava/lang/Class;)I

    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzA(Ljava/lang/Class;)I

    invoke-static {}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzB()Ljava/lang/reflect/Field;

    move-result-object v0

    if-eqz v0, :cond_12b

    sget-object v1, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    if-eqz v1, :cond_12b

    iget-object v1, v1, Lcom/google/android/gms/internal/play_billing/zzhm;->zza:Lsun/misc/Unsafe;

    invoke-virtual {v1, v0}, Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J

    :cond_12b
    invoke-static {}, Ljava/nio/ByteOrder;->nativeOrder()Ljava/nio/ByteOrder;

    move-result-object v0

    sget-object v1, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    if-ne v0, v1, :cond_134

    goto :goto_135

    :cond_134
    const/4 v13, 0x0

    :goto_135
    sput-boolean v13, Lcom/google/android/gms/internal/play_billing/zzhn;->zzb:Z

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static zzA(Ljava/lang/Class;)I
    .registers 2

    sget-boolean v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzh:Z

    if-eqz v0, :cond_d

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzhm;->zza:Lsun/misc/Unsafe;

    invoke-virtual {v0, p0}, Lsun/misc/Unsafe;->arrayIndexScale(Ljava/lang/Class;)I

    move-result p0

    return p0

    :cond_d
    const/4 p0, -0x1

    return p0
.end method

.method private static zzB()Ljava/lang/reflect/Field;
    .registers 3

    sget v0, Lcom/google/android/gms/internal/play_billing/zzdi;->zza:I

    const-class v0, Ljava/nio/Buffer;

    const-string v1, "effectiveDirectAddress"

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzC(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    if-nez v0, :cond_20

    const-class v0, Ljava/nio/Buffer;

    const-string v1, "address"

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzC(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    if-eqz v0, :cond_1f

    invoke-virtual {v0}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v1

    sget-object v2, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    if-ne v1, v2, :cond_1f

    return-object v0

    :cond_1f
    const/4 v0, 0x0

    :cond_20
    return-object v0
.end method

.method private static zzC(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    .registers 2

    :try_start_0
    invoke-virtual {p0, p1}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object p0
    :try_end_4
    .catchall {:try_start_0 .. :try_end_4} :catchall_5

    goto :goto_6

    :catchall_5
    const/4 p0, 0x0

    :goto_6
    return-object p0
.end method

.method private static zzD(Ljava/lang/Object;JB)V
    .registers 9

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    iget-object v1, v0, Lcom/google/android/gms/internal/play_billing/zzhm;->zza:Lsun/misc/Unsafe;

    const-wide/16 v2, -0x4

    and-long/2addr v2, p1

    invoke-virtual {v1, p0, v2, v3}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v1

    long-to-int p2, p1

    not-int p1, p2

    and-int/lit8 p1, p1, 0x3

    shl-int/lit8 p1, p1, 0x3

    const/16 p2, 0xff

    shl-int v4, p2, p1

    not-int v4, v4

    and-int/2addr v1, v4

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzhm;->zza:Lsun/misc/Unsafe;

    and-int/2addr p2, p3

    shl-int p1, p2, p1

    or-int/2addr p1, v1

    invoke-virtual {v0, p0, v2, v3, p1}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    return-void
.end method

.method private static zzE(Ljava/lang/Object;JB)V
    .registers 9

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    iget-object v1, v0, Lcom/google/android/gms/internal/play_billing/zzhm;->zza:Lsun/misc/Unsafe;

    const-wide/16 v2, -0x4

    and-long/2addr v2, p1

    invoke-virtual {v1, p0, v2, v3}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v1

    long-to-int p2, p1

    and-int/lit8 p1, p2, 0x3

    shl-int/lit8 p1, p1, 0x3

    const/16 p2, 0xff

    shl-int v4, p2, p1

    not-int v4, v4

    and-int/2addr v1, v4

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzhm;->zza:Lsun/misc/Unsafe;

    and-int/2addr p2, p3

    shl-int p1, p2, p1

    or-int/2addr p1, v1

    invoke-virtual {v0, p0, v2, v3, p1}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    return-void
.end method

.method static zza(Ljava/lang/Object;J)D
    .registers 4

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    invoke-virtual {v0, p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzhm;->zza(Ljava/lang/Object;J)D

    move-result-wide p0

    return-wide p0
.end method

.method static zzb(Ljava/lang/Object;J)F
    .registers 4

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    invoke-virtual {v0, p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzhm;->zzb(Ljava/lang/Object;J)F

    move-result p0

    return p0
.end method

.method static zzc(Ljava/lang/Object;J)I
    .registers 4

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzhm;->zza:Lsun/misc/Unsafe;

    invoke-virtual {v0, p0, p1, p2}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result p0

    return p0
.end method

.method static zzd(Ljava/lang/Object;J)J
    .registers 4

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzhm;->zza:Lsun/misc/Unsafe;

    invoke-virtual {v0, p0, p1, p2}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide p0

    return-wide p0
.end method

.method static zze(Ljava/lang/Class;)Ljava/lang/Object;
    .registers 2

    :try_start_0
    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzc:Lsun/misc/Unsafe;

    invoke-virtual {v0, p0}, Lsun/misc/Unsafe;->allocateInstance(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0
    :try_end_6
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_6} :catch_7

    return-object p0

    :catch_7
    move-exception p0

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0, p0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v0
.end method

.method static zzf(Ljava/lang/Object;J)Ljava/lang/Object;
    .registers 4

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzhm;->zza:Lsun/misc/Unsafe;

    invoke-virtual {v0, p0, p1, p2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method static zzg()Lsun/misc/Unsafe;
    .registers 1

    :try_start_0
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzhj;

    invoke-direct {v0}, Lcom/google/android/gms/internal/play_billing/zzhj;-><init>()V

    invoke-static {v0}, Ljava/security/AccessController;->doPrivileged(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lsun/misc/Unsafe;
    :try_end_b
    .catchall {:try_start_0 .. :try_end_b} :catchall_c

    goto :goto_d

    :catchall_c
    const/4 v0, 0x0

    :goto_d
    return-object v0
.end method

.method static bridge synthetic zzh(Ljava/lang/Throwable;)V
    .registers 5

    const-class v0, Lcom/google/android/gms/internal/play_billing/zzhn;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sget-object v1, Ljava/util/logging/Level;->WARNING:Ljava/util/logging/Level;

    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p0

    const-string v2, "platform method missing - proto runtime falling back to safer methods: "

    invoke-virtual {v2, p0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    const-string v2, "com.google.protobuf.UnsafeUtil"

    const-string v3, "logMissingMethod"

    invoke-virtual {v0, v1, v2, v3, p0}, Ljava/util/logging/Logger;->logp(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic zzi(Ljava/lang/Object;JZ)V
    .registers 4

    invoke-static {p0, p1, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzD(Ljava/lang/Object;JB)V

    return-void
.end method

.method static synthetic zzj(Ljava/lang/Object;JZ)V
    .registers 4

    invoke-static {p0, p1, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzE(Ljava/lang/Object;JB)V

    return-void
.end method

.method static bridge synthetic zzk(Ljava/lang/Object;JB)V
    .registers 4

    invoke-static {p0, p1, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzD(Ljava/lang/Object;JB)V

    return-void
.end method

.method static bridge synthetic zzl(Ljava/lang/Object;JB)V
    .registers 4

    invoke-static {p0, p1, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzhn;->zzE(Ljava/lang/Object;JB)V

    return-void
.end method

.method static zzm(Ljava/lang/Object;JZ)V
    .registers 5

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    invoke-virtual {v0, p0, p1, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzhm;->zzc(Ljava/lang/Object;JZ)V

    return-void
.end method

.method static zzn([BJB)V
    .registers 7

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    sget-wide v1, Lcom/google/android/gms/internal/play_billing/zzhn;->zza:J

    add-long/2addr v1, p1

    invoke-virtual {v0, p0, v1, v2, p3}, Lcom/google/android/gms/internal/play_billing/zzhm;->zzd(Ljava/lang/Object;JB)V

    return-void
.end method

.method static zzo(Ljava/lang/Object;JD)V
    .registers 11

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    move-object v1, p0

    move-wide v2, p1

    move-wide v4, p3

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gms/internal/play_billing/zzhm;->zze(Ljava/lang/Object;JD)V

    return-void
.end method

.method static zzp(Ljava/lang/Object;JF)V
    .registers 5

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    invoke-virtual {v0, p0, p1, p2, p3}, Lcom/google/android/gms/internal/play_billing/zzhm;->zzf(Ljava/lang/Object;JF)V

    return-void
.end method

.method static zzq(Ljava/lang/Object;JI)V
    .registers 5

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzhm;->zza:Lsun/misc/Unsafe;

    invoke-virtual {v0, p0, p1, p2, p3}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    return-void
.end method

.method static zzr(Ljava/lang/Object;JJ)V
    .registers 12

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    iget-object v1, v0, Lcom/google/android/gms/internal/play_billing/zzhm;->zza:Lsun/misc/Unsafe;

    move-object v2, p0

    move-wide v3, p1

    move-wide v5, p3

    invoke-virtual/range {v1 .. v6}, Lsun/misc/Unsafe;->putLong(Ljava/lang/Object;JJ)V

    return-void
.end method

.method static zzs(Ljava/lang/Object;JLjava/lang/Object;)V
    .registers 5

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzhm;->zza:Lsun/misc/Unsafe;

    invoke-virtual {v0, p0, p1, p2, p3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    return-void
.end method

.method static bridge synthetic zzt(Ljava/lang/Object;J)Z
    .registers 6

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzhm;->zza:Lsun/misc/Unsafe;

    const-wide/16 v1, -0x4

    and-long/2addr v1, p1

    invoke-virtual {v0, p0, v1, v2}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result p0

    not-long p1, p1

    const-wide/16 v0, 0x3

    and-long/2addr p1, v0

    const/4 v0, 0x3

    shl-long/2addr p1, v0

    long-to-int p2, p1

    ushr-int/2addr p0, p2

    and-int/lit16 p0, p0, 0xff

    int-to-byte p0, p0

    if-eqz p0, :cond_1a

    const/4 p0, 0x1

    return p0

    :cond_1a
    const/4 p0, 0x0

    return p0
.end method

.method static bridge synthetic zzu(Ljava/lang/Object;J)Z
    .registers 6

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzhm;->zza:Lsun/misc/Unsafe;

    const-wide/16 v1, -0x4

    and-long/2addr v1, p1

    invoke-virtual {v0, p0, v1, v2}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result p0

    const-wide/16 v0, 0x3

    and-long/2addr p1, v0

    const/4 v0, 0x3

    shl-long/2addr p1, v0

    long-to-int p2, p1

    ushr-int/2addr p0, p2

    and-int/lit16 p0, p0, 0xff

    int-to-byte p0, p0

    if-eqz p0, :cond_19

    const/4 p0, 0x1

    return p0

    :cond_19
    const/4 p0, 0x0

    return p0
.end method

.method static zzv(Ljava/lang/Class;)Z
    .registers 11

    const-class v0, [B

    sget v1, Lcom/google/android/gms/internal/play_billing/zzdi;->zza:I

    const/4 v1, 0x0

    :try_start_5
    sget-object v2, Lcom/google/android/gms/internal/play_billing/zzhn;->zzd:Ljava/lang/Class;

    const-string v3, "peekLong"

    const/4 v4, 0x2

    new-array v5, v4, [Ljava/lang/Class;

    aput-object p0, v5, v1

    sget-object v6, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    const/4 v7, 0x1

    aput-object v6, v5, v7

    invoke-virtual {v2, v3, v5}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    const-string v3, "pokeLong"

    const/4 v5, 0x3

    new-array v8, v5, [Ljava/lang/Class;

    aput-object p0, v8, v1

    sget-object v9, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    aput-object v9, v8, v7

    aput-object v6, v8, v4

    invoke-virtual {v2, v3, v8}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    const-string v3, "pokeInt"

    new-array v8, v5, [Ljava/lang/Class;

    aput-object p0, v8, v1

    sget-object v9, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v9, v8, v7

    aput-object v6, v8, v4

    invoke-virtual {v2, v3, v8}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    const-string v3, "peekInt"

    new-array v8, v4, [Ljava/lang/Class;

    aput-object p0, v8, v1

    aput-object v6, v8, v7

    invoke-virtual {v2, v3, v8}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    const-string v3, "pokeByte"

    new-array v6, v4, [Ljava/lang/Class;

    aput-object p0, v6, v1

    sget-object v8, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    aput-object v8, v6, v7

    invoke-virtual {v2, v3, v6}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    const-string v3, "peekByte"

    new-array v6, v7, [Ljava/lang/Class;

    aput-object p0, v6, v1

    invoke-virtual {v2, v3, v6}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    const-string v3, "pokeByteArray"

    const/4 v6, 0x4

    new-array v8, v6, [Ljava/lang/Class;

    aput-object p0, v8, v1

    aput-object v0, v8, v7

    aput-object v9, v8, v4

    aput-object v9, v8, v5

    invoke-virtual {v2, v3, v8}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    const-string v3, "peekByteArray"

    new-array v6, v6, [Ljava/lang/Class;

    aput-object p0, v6, v1

    aput-object v0, v6, v7

    aput-object v9, v6, v4

    aput-object v9, v6, v5

    invoke-virtual {v2, v3, v6}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    :try_end_75
    .catchall {:try_start_5 .. :try_end_75} :catchall_76

    return v7

    :catchall_76
    return v1
.end method

.method static zzw(Ljava/lang/Object;J)Z
    .registers 4

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    invoke-virtual {v0, p0, p1, p2}, Lcom/google/android/gms/internal/play_billing/zzhm;->zzg(Ljava/lang/Object;J)Z

    move-result p0

    return p0
.end method

.method static zzx()Z
    .registers 1

    sget-boolean v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzh:Z

    return v0
.end method

.method static zzy()Z
    .registers 1

    sget-boolean v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzg:Z

    return v0
.end method

.method private static zzz(Ljava/lang/Class;)I
    .registers 2

    sget-boolean v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzh:Z

    if-eqz v0, :cond_d

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzhn;->zzf:Lcom/google/android/gms/internal/play_billing/zzhm;

    iget-object v0, v0, Lcom/google/android/gms/internal/play_billing/zzhm;->zza:Lsun/misc/Unsafe;

    invoke-virtual {v0, p0}, Lsun/misc/Unsafe;->arrayBaseOffset(Ljava/lang/Class;)I

    move-result p0

    return p0

    :cond_d
    const/4 p0, -0x1

    return p0
.end method
