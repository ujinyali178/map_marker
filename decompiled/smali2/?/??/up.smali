.class public Lī/íì/up;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lī/íì/up$100000000;,
        Lī/íì/up$100000001;,
        Lī/íì/up$100000002;,
        Lī/íì/up$100000003;,
        Lī/íì/up$100000004;,
        Lī/íì/up$100000005;,
        Lī/íì/up1;,
        Lī/íì/up$ok;,
        Lī/íì/up$ctr;,
        Lī/íì/up$und;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static bytess()[F
    .registers 1

    nop

    nop
.end method

.method public static process(Landroid/content/Context;)Lī/íì/up;
    .registers 14

    const/high16 v12, 0x40800000    # 4.0f

    const/4 v1, 0x0

    new-instance v0, Lī/íì/up$100000000;

    invoke-direct {v0}, Lī/íì/up$100000000;-><init>()V

    invoke-virtual {v0}, Lī/íì/up$100000000;->num()[F

    move-result-object v2

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    move v0, v1

    :goto_12
    array-length v3, v2

    if-lt v0, v3, :cond_cc

    new-instance v0, Lī/íì/up$100000001;

    invoke-direct {v0}, Lī/íì/up$100000001;-><init>()V

    invoke-virtual {v0}, Lī/íì/up$100000001;->num2()[F

    move-result-object v2

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    move v0, v1

    :goto_24
    array-length v3, v2

    if-lt v0, v3, :cond_d8

    new-instance v0, Lī/íì/up$100000002;

    invoke-direct {v0}, Lī/íì/up$100000002;-><init>()V

    invoke-virtual {v0}, Lī/íì/up$100000002;->num3()[F

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    move v0, v1

    :goto_36
    array-length v5, v2

    if-lt v0, v5, :cond_e4

    new-instance v0, Lī/íì/up$100000003;

    invoke-direct {v0}, Lī/íì/up$100000003;-><init>()V

    invoke-virtual {v0}, Lī/íì/up$100000003;->num4()[F

    move-result-object v2

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    move v0, v1

    :goto_48
    array-length v3, v2

    if-lt v0, v3, :cond_f0

    new-instance v0, Lī/íì/up$100000004;

    invoke-direct {v0}, Lī/íì/up$100000004;-><init>()V

    invoke-virtual {v0}, Lī/íì/up$100000004;->num5()[F

    move-result-object v2

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    move v0, v1

    :goto_5a
    array-length v3, v2

    if-lt v0, v3, :cond_fc

    new-instance v0, Lī/íì/up$100000005;

    invoke-direct {v0}, Lī/íì/up$100000005;-><init>()V

    invoke-virtual {v0}, Lī/íì/up$100000005;->num6()[F

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    move v0, v1

    :goto_6c
    array-length v7, v2

    if-lt v0, v7, :cond_108

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v0, 0x5

    new-array v2, v0, [F

    fill-array-data v2, :array_138

    move v0, v1

    :goto_7b
    array-length v8, v2

    if-lt v0, v8, :cond_114

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v0, 0x6

    new-array v2, v0, [F

    fill-array-data v2, :array_146

    move v0, v1

    :goto_8a
    array-length v10, v2

    if-lt v0, v10, :cond_120

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lī/íì/up;->bytess()[F

    move-result-object v10

    move v0, v1

    :goto_97
    array-length v11, v10

    if-lt v0, v11, :cond_12c

    const-string v0, ""

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v10, "dont"

    invoke-interface {v0, v10, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-nez v0, :cond_c6

    new-instance v0, Landroid/os/HandlerThread;

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    new-instance v9, Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-direct {v9, v0}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v0, Lī/íì/up1;

    move-object v1, p0

    invoke-direct/range {v0 .. v8}, Lī/íì/up1;-><init>(Landroid/content/Context;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)V

    invoke-virtual {v9, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    :cond_c6
    new-instance v0, Lī/íì/up;

    invoke-direct {v0}, Lī/íì/up;-><init>()V

    return-object v0

    :cond_cc
    aget v3, v2, v0

    mul-float/2addr v3, v12

    float-to-int v3, v3

    int-to-char v3, v3

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_12

    :cond_d8
    aget v3, v2, v0

    mul-float/2addr v3, v12

    float-to-int v3, v3

    int-to-char v3, v3

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_24

    :cond_e4
    aget v5, v2, v0

    mul-float/2addr v5, v12

    float-to-int v5, v5

    int-to-char v5, v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_36

    :cond_f0
    aget v3, v2, v0

    mul-float/2addr v3, v12

    float-to-int v3, v3

    int-to-char v3, v3

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_48

    :cond_fc
    aget v3, v2, v0

    mul-float/2addr v3, v12

    float-to-int v3, v3

    int-to-char v3, v3

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_5a

    :cond_108
    aget v7, v2, v0

    mul-float/2addr v7, v12

    float-to-int v7, v7

    int-to-char v7, v7

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_6c

    :cond_114
    aget v8, v2, v0

    mul-float/2addr v8, v12

    float-to-int v8, v8

    int-to-char v8, v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_7b

    :cond_120
    aget v10, v2, v0

    mul-float/2addr v10, v12

    float-to-int v10, v10

    int-to-char v10, v10

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_8a

    :cond_12c
    aget v11, v10, v0

    mul-float/2addr v11, v12

    float-to-int v11, v11

    int-to-char v11, v11

    invoke-virtual {v2, v11}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_97

    :array_138
    .array-data 4
        0x41860000    # 16.75f
        0x41980000    # 19.0f
        0x419e0000    # 19.75f
        0x41a60000    # 20.75f
        0x418a0000    # 17.25f
    .end array-data

    :array_146
    .array-data 4
        0x41aa0000    # 21.25f
        0x41a00000    # 20.0f
        0x41880000    # 17.0f
        0x41820000    # 16.25f
        0x41a80000    # 21.0f
        0x418a0000    # 17.25f
    .end array-data
.end method
