.class final Lcom/google/android/gms/internal/play_billing/zzaq;
.super Lcom/google/android/gms/internal/play_billing/zzai;
.source "SourceFile"


# static fields
.field static final zza:Lcom/google/android/gms/internal/play_billing/zzai;


# instance fields
.field final transient zzb:[Ljava/lang/Object;

.field private final transient zzc:Ljava/lang/Object;
    .annotation runtime Ljavax/annotation/CheckForNull;
    .end annotation
.end field

.field private final transient zzd:I


# direct methods
.method static constructor <clinit>()V
    .registers 4

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzaq;

    const/4 v1, 0x0

    new-array v2, v1, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-direct {v0, v3, v2, v1}, Lcom/google/android/gms/internal/play_billing/zzaq;-><init>(Ljava/lang/Object;[Ljava/lang/Object;I)V

    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzaq;->zza:Lcom/google/android/gms/internal/play_billing/zzai;

    return-void
.end method

.method private constructor <init>(Ljava/lang/Object;[Ljava/lang/Object;I)V
    .registers 4
    .param p1    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/CheckForNull;
        .end annotation
    .end param

    invoke-direct {p0}, Lcom/google/android/gms/internal/play_billing/zzai;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/play_billing/zzaq;->zzc:Ljava/lang/Object;

    iput-object p2, p0, Lcom/google/android/gms/internal/play_billing/zzaq;->zzb:[Ljava/lang/Object;

    iput p3, p0, Lcom/google/android/gms/internal/play_billing/zzaq;->zzd:I

    return-void
.end method

.method static zzf(I[Ljava/lang/Object;Lcom/google/android/gms/internal/play_billing/zzah;)Lcom/google/android/gms/internal/play_billing/zzaq;
    .registers 20

    move/from16 v0, p0

    move-object/from16 v1, p1

    if-nez v0, :cond_b

    sget-object v0, Lcom/google/android/gms/internal/play_billing/zzaq;->zza:Lcom/google/android/gms/internal/play_billing/zzai;

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzaq;

    return-object v0

    :cond_b
    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x1

    if-ne v0, v4, :cond_23

    aget-object v0, v1, v3

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    aget-object v3, v1, v4

    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-static {v0, v3}, Lcom/google/android/gms/internal/play_billing/zzaa;->zza(Ljava/lang/Object;Ljava/lang/Object;)V

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzaq;

    invoke-direct {v0, v2, v1, v4}, Lcom/google/android/gms/internal/play_billing/zzaq;-><init>(Ljava/lang/Object;[Ljava/lang/Object;I)V

    return-object v0

    :cond_23
    array-length v5, v1

    shr-int/2addr v5, v4

    const-string v6, "index"

    invoke-static {v0, v5, v6}, Lcom/google/android/gms/internal/play_billing/zzx;->zzb(IILjava/lang/String;)I

    const/4 v5, 0x2

    invoke-static {v0, v5}, Ljava/lang/Math;->max(II)I

    move-result v6

    const v7, 0x2ccccccc

    const/high16 v8, 0x40000000    # 2.0f

    if-ge v6, v7, :cond_4d

    add-int/lit8 v7, v6, -0x1

    invoke-static {v7}, Ljava/lang/Integer;->highestOneBit(I)I

    move-result v7

    add-int/2addr v7, v7

    move v8, v7

    :goto_3e
    int-to-double v9, v8

    const-wide v11, 0x3fe6666666666666L    # 0.7

    mul-double v9, v9, v11

    int-to-double v11, v6

    cmpg-double v7, v9, v11

    if-gez v7, :cond_4f

    add-int/2addr v8, v8

    goto :goto_3e

    :cond_4d
    if-ge v6, v8, :cond_1d3

    :cond_4f
    if-ne v0, v4, :cond_61

    aget-object v0, v1, v3

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    aget-object v6, v1, v4

    invoke-virtual {v6}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-static {v0, v6}, Lcom/google/android/gms/internal/play_billing/zzaa;->zza(Ljava/lang/Object;Ljava/lang/Object;)V

    const/4 v0, 0x1

    goto/16 :goto_1a9

    :cond_61
    add-int/lit8 v6, v8, -0x1

    const/16 v7, 0x80

    const/4 v9, 0x3

    const/4 v10, -0x1

    if-gt v8, v7, :cond_d6

    new-array v7, v8, [B

    invoke-static {v7, v10}, Ljava/util/Arrays;->fill([BB)V

    const/4 v8, 0x0

    const/4 v10, 0x0

    :goto_70
    if-ge v8, v0, :cond_c1

    add-int v11, v10, v10

    add-int v12, v8, v8

    aget-object v13, v1, v12

    invoke-virtual {v13}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    xor-int/2addr v12, v4

    aget-object v12, v1, v12

    invoke-virtual {v12}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-static {v13, v12}, Lcom/google/android/gms/internal/play_billing/zzaa;->zza(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v13}, Ljava/lang/Object;->hashCode()I

    move-result v14

    invoke-static {v14}, Lcom/google/android/gms/internal/play_billing/zzab;->zza(I)I

    move-result v14

    :goto_8c
    and-int/2addr v14, v6

    aget-byte v15, v7, v14

    const/16 v5, 0xff

    and-int/2addr v15, v5

    if-ne v15, v5, :cond_a2

    int-to-byte v5, v11

    aput-byte v5, v7, v14

    if-ge v10, v8, :cond_9f

    aput-object v13, v1, v11

    xor-int/lit8 v5, v11, 0x1

    aput-object v12, v1, v5

    :cond_9f
    add-int/lit8 v10, v10, 0x1

    goto :goto_b9

    :cond_a2
    aget-object v5, v1, v15

    invoke-virtual {v13, v5}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_bd

    xor-int/lit8 v2, v15, 0x1

    new-instance v5, Lcom/google/android/gms/internal/play_billing/zzag;

    aget-object v11, v1, v2

    invoke-virtual {v11}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-direct {v5, v13, v12, v11}, Lcom/google/android/gms/internal/play_billing/zzag;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    aput-object v12, v1, v2

    move-object v2, v5

    :goto_b9
    add-int/lit8 v8, v8, 0x1

    const/4 v5, 0x2

    goto :goto_70

    :cond_bd
    add-int/lit8 v14, v14, 0x1

    const/4 v5, 0x2

    goto :goto_8c

    :cond_c1
    if-ne v10, v0, :cond_c5

    move-object v2, v7

    goto :goto_d3

    :cond_c5
    new-array v5, v9, [Ljava/lang/Object;

    aput-object v7, v5, v3

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v4

    const/4 v6, 0x2

    aput-object v2, v5, v6

    :goto_d2
    move-object v2, v5

    :goto_d3
    const/4 v5, 0x2

    goto/16 :goto_1a9

    :cond_d6
    const v5, 0x8000

    if-gt v8, v5, :cond_143

    new-array v5, v8, [S

    invoke-static {v5, v10}, Ljava/util/Arrays;->fill([SS)V

    const/4 v7, 0x0

    const/4 v8, 0x0

    :goto_e2
    if-ge v7, v0, :cond_132

    add-int v10, v8, v8

    add-int v11, v7, v7

    aget-object v12, v1, v11

    invoke-virtual {v12}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    xor-int/2addr v11, v4

    aget-object v11, v1, v11

    invoke-virtual {v11}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-static {v12, v11}, Lcom/google/android/gms/internal/play_billing/zzaa;->zza(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v12}, Ljava/lang/Object;->hashCode()I

    move-result v13

    invoke-static {v13}, Lcom/google/android/gms/internal/play_billing/zzab;->zza(I)I

    move-result v13

    :goto_fe
    and-int/2addr v13, v6

    aget-short v14, v5, v13

    int-to-char v14, v14

    const v15, 0xffff

    if-ne v14, v15, :cond_115

    int-to-short v14, v10

    aput-short v14, v5, v13

    if-ge v8, v7, :cond_112

    aput-object v12, v1, v10

    xor-int/lit8 v10, v10, 0x1

    aput-object v11, v1, v10

    :cond_112
    add-int/lit8 v8, v8, 0x1

    goto :goto_12c

    :cond_115
    aget-object v15, v1, v14

    invoke-virtual {v12, v15}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v15

    if-eqz v15, :cond_12f

    xor-int/lit8 v2, v14, 0x1

    new-instance v10, Lcom/google/android/gms/internal/play_billing/zzag;

    aget-object v13, v1, v2

    invoke-virtual {v13}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-direct {v10, v12, v11, v13}, Lcom/google/android/gms/internal/play_billing/zzag;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    aput-object v11, v1, v2

    move-object v2, v10

    :goto_12c
    add-int/lit8 v7, v7, 0x1

    goto :goto_e2

    :cond_12f
    add-int/lit8 v13, v13, 0x1

    goto :goto_fe

    :cond_132
    if-ne v8, v0, :cond_135

    goto :goto_199

    :cond_135
    new-array v6, v9, [Ljava/lang/Object;

    aput-object v5, v6, v3

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v6, v4

    const/4 v5, 0x2

    aput-object v2, v6, v5

    goto :goto_1a8

    :cond_143
    new-array v5, v8, [I

    invoke-static {v5, v10}, Ljava/util/Arrays;->fill([II)V

    const/4 v7, 0x0

    const/4 v8, 0x0

    :goto_14a
    if-ge v7, v0, :cond_197

    add-int v11, v8, v8

    add-int v12, v7, v7

    aget-object v13, v1, v12

    invoke-virtual {v13}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    xor-int/2addr v12, v4

    aget-object v12, v1, v12

    invoke-virtual {v12}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-static {v13, v12}, Lcom/google/android/gms/internal/play_billing/zzaa;->zza(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v13}, Ljava/lang/Object;->hashCode()I

    move-result v14

    invoke-static {v14}, Lcom/google/android/gms/internal/play_billing/zzab;->zza(I)I

    move-result v14

    :goto_166
    and-int/2addr v14, v6

    aget v15, v5, v14

    if-ne v15, v10, :cond_178

    aput v11, v5, v14

    if-ge v8, v7, :cond_175

    aput-object v13, v1, v11

    xor-int/lit8 v11, v11, 0x1

    aput-object v12, v1, v11

    :cond_175
    add-int/lit8 v8, v8, 0x1

    goto :goto_18f

    :cond_178
    aget-object v10, v1, v15

    invoke-virtual {v13, v10}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_193

    xor-int/lit8 v2, v15, 0x1

    new-instance v10, Lcom/google/android/gms/internal/play_billing/zzag;

    aget-object v11, v1, v2

    invoke-virtual {v11}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-direct {v10, v13, v12, v11}, Lcom/google/android/gms/internal/play_billing/zzag;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    aput-object v12, v1, v2

    move-object v2, v10

    :goto_18f
    add-int/lit8 v7, v7, 0x1

    const/4 v10, -0x1

    goto :goto_14a

    :cond_193
    add-int/lit8 v14, v14, 0x1

    const/4 v10, -0x1

    goto :goto_166

    :cond_197
    if-ne v8, v0, :cond_19b

    :goto_199
    goto/16 :goto_d2

    :cond_19b
    new-array v6, v9, [Ljava/lang/Object;

    aput-object v5, v6, v3

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v6, v4

    const/4 v5, 0x2

    aput-object v2, v6, v5

    :goto_1a8
    move-object v2, v6

    :goto_1a9
    nop

    instance-of v6, v2, [Ljava/lang/Object;

    if-eqz v6, :cond_1cd

    check-cast v2, [Ljava/lang/Object;

    aget-object v0, v2, v5

    check-cast v0, Lcom/google/android/gms/internal/play_billing/zzag;

    move-object/from16 v5, p2

    iput-object v0, v5, Lcom/google/android/gms/internal/play_billing/zzah;->zzc:Lcom/google/android/gms/internal/play_billing/zzag;

    aget-object v0, v2, v3

    aget-object v2, v2, v4

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    add-int v3, v2, v2

    invoke-static {v1, v3}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v1

    move/from16 v16, v2

    move-object v2, v0

    move/from16 v0, v16

    :cond_1cd
    new-instance v3, Lcom/google/android/gms/internal/play_billing/zzaq;

    invoke-direct {v3, v2, v1, v0}, Lcom/google/android/gms/internal/play_billing/zzaq;-><init>(Ljava/lang/Object;[Ljava/lang/Object;I)V

    return-object v3

    :cond_1d3
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "collection too large"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public final get(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 11
    .param p1    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/CheckForNull;
        .end annotation
    .end param
    .annotation runtime Ljavax/annotation/CheckForNull;
    .end annotation

    const/4 v0, 0x0

    if-nez p1, :cond_6

    :cond_3
    :goto_3
    move-object p1, v0

    goto/16 :goto_9c

    :cond_6
    iget v1, p0, Lcom/google/android/gms/internal/play_billing/zzaq;->zzd:I

    iget-object v2, p0, Lcom/google/android/gms/internal/play_billing/zzaq;->zzb:[Ljava/lang/Object;

    const/4 v3, 0x1

    if-ne v1, v3, :cond_20

    const/4 v1, 0x0

    aget-object v1, v2, v1

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-virtual {v1, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_3

    aget-object p1, v2, v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    goto/16 :goto_9c

    :cond_20
    iget-object v1, p0, Lcom/google/android/gms/internal/play_billing/zzaq;->zzc:Ljava/lang/Object;

    if-nez v1, :cond_25

    goto :goto_3

    :cond_25
    instance-of v4, v1, [B

    const/4 v5, -0x1

    if-eqz v4, :cond_51

    move-object v4, v1

    check-cast v4, [B

    array-length v1, v4

    add-int/lit8 v6, v1, -0x1

    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzab;->zza(I)I

    move-result v1

    :goto_38
    and-int/2addr v1, v6

    aget-byte v5, v4, v1

    const/16 v7, 0xff

    and-int/2addr v5, v7

    if-ne v5, v7, :cond_41

    goto :goto_3

    :cond_41
    aget-object v7, v2, v5

    invoke-virtual {p1, v7}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_4e

    xor-int/lit8 p1, v5, 0x1

    aget-object p1, v2, p1

    goto :goto_9c

    :cond_4e
    add-int/lit8 v1, v1, 0x1

    goto :goto_38

    :cond_51
    instance-of v4, v1, [S

    if-eqz v4, :cond_7d

    move-object v4, v1

    check-cast v4, [S

    array-length v1, v4

    add-int/lit8 v6, v1, -0x1

    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    invoke-static {v1}, Lcom/google/android/gms/internal/play_billing/zzab;->zza(I)I

    move-result v1

    :goto_63
    and-int/2addr v1, v6

    aget-short v5, v4, v1

    int-to-char v5, v5

    const v7, 0xffff

    if-ne v5, v7, :cond_6d

    goto :goto_3

    :cond_6d
    aget-object v7, v2, v5

    invoke-virtual {p1, v7}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_7a

    xor-int/lit8 p1, v5, 0x1

    aget-object p1, v2, p1

    goto :goto_9c

    :cond_7a
    add-int/lit8 v1, v1, 0x1

    goto :goto_63

    :cond_7d
    check-cast v1, [I

    array-length v4, v1

    add-int/2addr v4, v5

    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v6

    invoke-static {v6}, Lcom/google/android/gms/internal/play_billing/zzab;->zza(I)I

    move-result v6

    :goto_89
    and-int/2addr v6, v4

    aget v7, v1, v6

    if-ne v7, v5, :cond_90

    goto/16 :goto_3

    :cond_90
    aget-object v8, v2, v7

    invoke-virtual {p1, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_a0

    xor-int/lit8 p1, v7, 0x1

    aget-object p1, v2, p1

    :goto_9c
    if-nez p1, :cond_9f

    return-object v0

    :cond_9f
    return-object p1

    :cond_a0
    add-int/lit8 v6, v6, 0x1

    goto :goto_89
.end method

.method public final size()I
    .registers 2

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzaq;->zzd:I

    return v0
.end method

.method final zza()Lcom/google/android/gms/internal/play_billing/zzac;
    .registers 5

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzaq;->zzd:I

    new-instance v1, Lcom/google/android/gms/internal/play_billing/zzap;

    iget-object v2, p0, Lcom/google/android/gms/internal/play_billing/zzaq;->zzb:[Ljava/lang/Object;

    const/4 v3, 0x1

    invoke-direct {v1, v2, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzap;-><init>([Ljava/lang/Object;II)V

    return-object v1
.end method

.method final zzc()Lcom/google/android/gms/internal/play_billing/zzaj;
    .registers 5

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzaq;->zzd:I

    iget-object v1, p0, Lcom/google/android/gms/internal/play_billing/zzaq;->zzb:[Ljava/lang/Object;

    new-instance v2, Lcom/google/android/gms/internal/play_billing/zzan;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v1, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzan;-><init>(Lcom/google/android/gms/internal/play_billing/zzai;[Ljava/lang/Object;II)V

    return-object v2
.end method

.method final zzd()Lcom/google/android/gms/internal/play_billing/zzaj;
    .registers 5

    iget v0, p0, Lcom/google/android/gms/internal/play_billing/zzaq;->zzd:I

    new-instance v1, Lcom/google/android/gms/internal/play_billing/zzap;

    iget-object v2, p0, Lcom/google/android/gms/internal/play_billing/zzaq;->zzb:[Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3, v0}, Lcom/google/android/gms/internal/play_billing/zzap;-><init>([Ljava/lang/Object;II)V

    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzao;

    invoke-direct {v0, p0, v1}, Lcom/google/android/gms/internal/play_billing/zzao;-><init>(Lcom/google/android/gms/internal/play_billing/zzai;Lcom/google/android/gms/internal/play_billing/zzaf;)V

    return-object v0
.end method
