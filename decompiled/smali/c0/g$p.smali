.class Lc0/g$p;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Cloneable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "p"
.end annotation


# instance fields
.field c:F

.field d:Lc0/g$d1;


# direct methods
.method constructor <init>(F)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lc0/g$p;->c:F

    sget-object p1, Lc0/g$d1;->c:Lc0/g$d1;

    iput-object p1, p0, Lc0/g$p;->d:Lc0/g$d1;

    return-void
.end method

.method constructor <init>(FLc0/g$d1;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lc0/g$p;->c:F

    iput-object p2, p0, Lc0/g$p;->d:Lc0/g$d1;

    return-void
.end method


# virtual methods
.method a()F
    .registers 2

    iget v0, p0, Lc0/g$p;->c:F

    return v0
.end method

.method b(F)F
    .registers 4

    sget-object v0, Lc0/g$a;->a:[I

    iget-object v1, p0, Lc0/g$p;->d:Lc0/g$d1;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_3a

    packed-switch v0, :pswitch_data_3e

    iget p1, p0, Lc0/g$p;->c:F

    return p1

    :pswitch_13
    iget v0, p0, Lc0/g$p;->c:F

    mul-float v0, v0, p1

    const/high16 p1, 0x40c00000    # 6.0f

    div-float/2addr v0, p1

    return v0

    :pswitch_1b
    iget v0, p0, Lc0/g$p;->c:F

    mul-float v0, v0, p1

    const/high16 p1, 0x42900000    # 72.0f

    div-float/2addr v0, p1

    return v0

    :pswitch_23
    iget v0, p0, Lc0/g$p;->c:F

    mul-float v0, v0, p1

    const p1, 0x41cb3333    # 25.4f

    div-float/2addr v0, p1

    return v0

    :pswitch_2c
    iget v0, p0, Lc0/g$p;->c:F

    mul-float v0, v0, p1

    const p1, 0x40228f5c    # 2.54f

    div-float/2addr v0, p1

    return v0

    :pswitch_35
    iget v0, p0, Lc0/g$p;->c:F

    mul-float v0, v0, p1

    return v0

    :cond_3a
    iget p1, p0, Lc0/g$p;->c:F

    return p1

    nop

    :pswitch_data_3e
    .packed-switch 0x4
        :pswitch_35
        :pswitch_2c
        :pswitch_23
        :pswitch_1b
        :pswitch_13
    .end packed-switch
.end method

.method c(Lc0/h;)F
    .registers 8

    iget-object v0, p0, Lc0/g$p;->d:Lc0/g$d1;

    sget-object v1, Lc0/g$d1;->l:Lc0/g$d1;

    if-ne v0, v1, :cond_36

    invoke-virtual {p1}, Lc0/h;->S()Lc0/g$b;

    move-result-object p1

    if-nez p1, :cond_f

    iget p1, p0, Lc0/g$p;->c:F

    return p1

    :cond_f
    iget v0, p1, Lc0/g$b;->c:F

    iget p1, p1, Lc0/g$b;->d:F

    const/high16 v1, 0x42c80000    # 100.0f

    cmpl-float v2, v0, p1

    if-nez v2, :cond_1f

    iget p1, p0, Lc0/g$p;->c:F

    mul-float p1, p1, v0

    div-float/2addr p1, v1

    return p1

    :cond_1f
    mul-float v0, v0, v0

    mul-float p1, p1, p1

    add-float/2addr v0, p1

    float-to-double v2, v0

    invoke-static {v2, v3}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v2

    const-wide v4, 0x3ff6a09e667f3bccL    # 1.414213562373095

    div-double/2addr v2, v4

    double-to-float p1, v2

    iget v0, p0, Lc0/g$p;->c:F

    mul-float v0, v0, p1

    div-float/2addr v0, v1

    return v0

    :cond_36
    invoke-virtual {p0, p1}, Lc0/g$p;->e(Lc0/h;)F

    move-result p1

    return p1
.end method

.method d(Lc0/h;F)F
    .registers 5

    iget-object v0, p0, Lc0/g$p;->d:Lc0/g$d1;

    sget-object v1, Lc0/g$d1;->l:Lc0/g$d1;

    if-ne v0, v1, :cond_e

    iget p1, p0, Lc0/g$p;->c:F

    mul-float p1, p1, p2

    const/high16 p2, 0x42c80000    # 100.0f

    div-float/2addr p1, p2

    return p1

    :cond_e
    invoke-virtual {p0, p1}, Lc0/g$p;->e(Lc0/h;)F

    move-result p1

    return p1
.end method

.method e(Lc0/h;)F
    .registers 4

    sget-object v0, Lc0/g$a;->a:[I

    iget-object v1, p0, Lc0/g$p;->d:Lc0/g$d1;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_74

    iget p1, p0, Lc0/g$p;->c:F

    return p1

    :pswitch_10
    invoke-virtual {p1}, Lc0/h;->S()Lc0/g$b;

    move-result-object p1

    if-nez p1, :cond_19

    iget p1, p0, Lc0/g$p;->c:F

    return p1

    :cond_19
    iget v0, p0, Lc0/g$p;->c:F

    iget p1, p1, Lc0/g$b;->c:F

    mul-float v0, v0, p1

    const/high16 p1, 0x42c80000    # 100.0f

    div-float/2addr v0, p1

    return v0

    :pswitch_23
    iget v0, p0, Lc0/g$p;->c:F

    invoke-virtual {p1}, Lc0/h;->T()F

    move-result p1

    mul-float v0, v0, p1

    const/high16 p1, 0x40c00000    # 6.0f

    div-float/2addr v0, p1

    return v0

    :pswitch_2f
    iget v0, p0, Lc0/g$p;->c:F

    invoke-virtual {p1}, Lc0/h;->T()F

    move-result p1

    mul-float v0, v0, p1

    const/high16 p1, 0x42900000    # 72.0f

    div-float/2addr v0, p1

    return v0

    :pswitch_3b
    iget v0, p0, Lc0/g$p;->c:F

    invoke-virtual {p1}, Lc0/h;->T()F

    move-result p1

    mul-float v0, v0, p1

    const p1, 0x41cb3333    # 25.4f

    div-float/2addr v0, p1

    return v0

    :pswitch_48
    iget v0, p0, Lc0/g$p;->c:F

    invoke-virtual {p1}, Lc0/h;->T()F

    move-result p1

    mul-float v0, v0, p1

    const p1, 0x40228f5c    # 2.54f

    div-float/2addr v0, p1

    return v0

    :pswitch_55
    iget v0, p0, Lc0/g$p;->c:F

    invoke-virtual {p1}, Lc0/h;->T()F

    move-result p1

    mul-float v0, v0, p1

    return v0

    :pswitch_5e
    iget v0, p0, Lc0/g$p;->c:F

    invoke-virtual {p1}, Lc0/h;->R()F

    move-result p1

    mul-float v0, v0, p1

    return v0

    :pswitch_67
    iget v0, p0, Lc0/g$p;->c:F

    invoke-virtual {p1}, Lc0/h;->Q()F

    move-result p1

    mul-float v0, v0, p1

    return v0

    :pswitch_70
    iget p1, p0, Lc0/g$p;->c:F

    return p1

    nop

    :pswitch_data_74
    .packed-switch 0x1
        :pswitch_70
        :pswitch_67
        :pswitch_5e
        :pswitch_55
        :pswitch_48
        :pswitch_3b
        :pswitch_2f
        :pswitch_23
        :pswitch_10
    .end packed-switch
.end method

.method f(Lc0/h;)F
    .registers 4

    iget-object v0, p0, Lc0/g$p;->d:Lc0/g$d1;

    sget-object v1, Lc0/g$d1;->l:Lc0/g$d1;

    if-ne v0, v1, :cond_19

    invoke-virtual {p1}, Lc0/h;->S()Lc0/g$b;

    move-result-object p1

    if-nez p1, :cond_f

    iget p1, p0, Lc0/g$p;->c:F

    return p1

    :cond_f
    iget v0, p0, Lc0/g$p;->c:F

    iget p1, p1, Lc0/g$b;->d:F

    mul-float v0, v0, p1

    const/high16 p1, 0x42c80000    # 100.0f

    div-float/2addr v0, p1

    return v0

    :cond_19
    invoke-virtual {p0, p1}, Lc0/g$p;->e(Lc0/h;)F

    move-result p1

    return p1
.end method

.method g()Z
    .registers 3

    iget v0, p0, Lc0/g$p;->c:F

    const/4 v1, 0x0

    cmpg-float v0, v0, v1

    if-gez v0, :cond_9

    const/4 v0, 0x1

    goto :goto_a

    :cond_9
    const/4 v0, 0x0

    :goto_a
    return v0
.end method

.method h()Z
    .registers 3

    iget v0, p0, Lc0/g$p;->c:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-nez v0, :cond_9

    const/4 v0, 0x1

    goto :goto_a

    :cond_9
    const/4 v0, 0x0

    :goto_a
    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget v1, p0, Lc0/g$p;->c:F

    invoke-static {v1}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lc0/g$p;->d:Lc0/g$d1;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
