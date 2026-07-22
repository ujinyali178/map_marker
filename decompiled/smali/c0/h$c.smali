.class Lc0/h$c;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/h;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "c"
.end annotation


# instance fields
.field a:F

.field b:F

.field c:F

.field d:F

.field e:Z

.field final synthetic f:Lc0/h;


# direct methods
.method constructor <init>(Lc0/h;FFFF)V
    .registers 8

    iput-object p1, p0, Lc0/h$c;->f:Lc0/h;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 p1, 0x0

    iput p1, p0, Lc0/h$c;->c:F

    iput p1, p0, Lc0/h$c;->d:F

    const/4 p1, 0x0

    iput-boolean p1, p0, Lc0/h$c;->e:Z

    iput p2, p0, Lc0/h$c;->a:F

    iput p3, p0, Lc0/h$c;->b:F

    mul-float p1, p4, p4

    mul-float p2, p5, p5

    add-float/2addr p1, p2

    float-to-double p1, p1

    invoke-static {p1, p2}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide p1

    const-wide/16 v0, 0x0

    cmpl-double p3, p1, v0

    if-eqz p3, :cond_2b

    float-to-double p3, p4

    div-double/2addr p3, p1

    double-to-float p3, p3

    iput p3, p0, Lc0/h$c;->c:F

    float-to-double p3, p5

    div-double/2addr p3, p1

    double-to-float p1, p3

    iput p1, p0, Lc0/h$c;->d:F

    :cond_2b
    return-void
.end method


# virtual methods
.method a(FF)V
    .registers 8

    iget v0, p0, Lc0/h$c;->a:F

    sub-float/2addr p1, v0

    iget v0, p0, Lc0/h$c;->b:F

    sub-float/2addr p2, v0

    mul-float v0, p1, p1

    mul-float v1, p2, p2

    add-float/2addr v0, v1

    float-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmpl-double v4, v0, v2

    if-eqz v4, :cond_1c

    float-to-double v2, p1

    div-double/2addr v2, v0

    double-to-float p1, v2

    float-to-double v2, p2

    div-double/2addr v2, v0

    double-to-float p2, v2

    :cond_1c
    iget v0, p0, Lc0/h$c;->c:F

    neg-float v1, v0

    cmpl-float v1, p1, v1

    if-nez v1, :cond_31

    iget v1, p0, Lc0/h$c;->d:F

    neg-float v1, v1

    cmpl-float v1, p2, v1

    if-nez v1, :cond_31

    const/4 v0, 0x1

    iput-boolean v0, p0, Lc0/h$c;->e:Z

    neg-float p2, p2

    iput p2, p0, Lc0/h$c;->c:F

    goto :goto_37

    :cond_31
    add-float/2addr v0, p1

    iput v0, p0, Lc0/h$c;->c:F

    iget p1, p0, Lc0/h$c;->d:F

    add-float/2addr p1, p2

    :goto_37
    iput p1, p0, Lc0/h$c;->d:F

    return-void
.end method

.method b(Lc0/h$c;)V
    .registers 6

    iget v0, p1, Lc0/h$c;->c:F

    iget v1, p0, Lc0/h$c;->c:F

    neg-float v2, v1

    cmpl-float v2, v0, v2

    if-nez v2, :cond_1d

    iget v2, p1, Lc0/h$c;->d:F

    iget v3, p0, Lc0/h$c;->d:F

    neg-float v3, v3

    cmpl-float v3, v2, v3

    if-nez v3, :cond_1d

    const/4 v0, 0x1

    iput-boolean v0, p0, Lc0/h$c;->e:Z

    neg-float v0, v2

    iput v0, p0, Lc0/h$c;->c:F

    iget p1, p1, Lc0/h$c;->c:F

    iput p1, p0, Lc0/h$c;->d:F

    goto :goto_27

    :cond_1d
    add-float/2addr v1, v0

    iput v1, p0, Lc0/h$c;->c:F

    iget v0, p0, Lc0/h$c;->d:F

    iget p1, p1, Lc0/h$c;->d:F

    add-float/2addr v0, p1

    iput v0, p0, Lc0/h$c;->d:F

    :goto_27
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lc0/h$c;->a:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v2, p0, Lc0/h$c;->b:F

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v2, " "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v2, p0, Lc0/h$c;->c:F

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lc0/h$c;->d:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
