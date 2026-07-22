.class Lc0/g$b;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "b"
.end annotation


# instance fields
.field a:F

.field b:F

.field c:F

.field d:F


# direct methods
.method constructor <init>(FFFF)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lc0/g$b;->a:F

    iput p2, p0, Lc0/g$b;->b:F

    iput p3, p0, Lc0/g$b;->c:F

    iput p4, p0, Lc0/g$b;->d:F

    return-void
.end method

.method constructor <init>(Lc0/g$b;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iget v0, p1, Lc0/g$b;->a:F

    iput v0, p0, Lc0/g$b;->a:F

    iget v0, p1, Lc0/g$b;->b:F

    iput v0, p0, Lc0/g$b;->b:F

    iget v0, p1, Lc0/g$b;->c:F

    iput v0, p0, Lc0/g$b;->c:F

    iget p1, p1, Lc0/g$b;->d:F

    iput p1, p0, Lc0/g$b;->d:F

    return-void
.end method

.method static a(FFFF)Lc0/g$b;
    .registers 5

    new-instance v0, Lc0/g$b;

    sub-float/2addr p2, p0

    sub-float/2addr p3, p1

    invoke-direct {v0, p0, p1, p2, p3}, Lc0/g$b;-><init>(FFFF)V

    return-object v0
.end method


# virtual methods
.method b()F
    .registers 3

    iget v0, p0, Lc0/g$b;->a:F

    iget v1, p0, Lc0/g$b;->c:F

    add-float/2addr v0, v1

    return v0
.end method

.method c()F
    .registers 3

    iget v0, p0, Lc0/g$b;->b:F

    iget v1, p0, Lc0/g$b;->d:F

    add-float/2addr v0, v1

    return v0
.end method

.method d(Lc0/g$b;)V
    .registers 4

    iget v0, p1, Lc0/g$b;->a:F

    iget v1, p0, Lc0/g$b;->a:F

    cmpg-float v1, v0, v1

    if-gez v1, :cond_a

    iput v0, p0, Lc0/g$b;->a:F

    :cond_a
    iget v0, p1, Lc0/g$b;->b:F

    iget v1, p0, Lc0/g$b;->b:F

    cmpg-float v1, v0, v1

    if-gez v1, :cond_14

    iput v0, p0, Lc0/g$b;->b:F

    :cond_14
    invoke-virtual {p1}, Lc0/g$b;->b()F

    move-result v0

    invoke-virtual {p0}, Lc0/g$b;->b()F

    move-result v1

    cmpl-float v0, v0, v1

    if-lez v0, :cond_29

    invoke-virtual {p1}, Lc0/g$b;->b()F

    move-result v0

    iget v1, p0, Lc0/g$b;->a:F

    sub-float/2addr v0, v1

    iput v0, p0, Lc0/g$b;->c:F

    :cond_29
    invoke-virtual {p1}, Lc0/g$b;->c()F

    move-result v0

    invoke-virtual {p0}, Lc0/g$b;->c()F

    move-result v1

    cmpl-float v0, v0, v1

    if-lez v0, :cond_3e

    invoke-virtual {p1}, Lc0/g$b;->c()F

    move-result p1

    iget v0, p0, Lc0/g$b;->b:F

    sub-float/2addr p1, v0

    iput p1, p0, Lc0/g$b;->d:F

    :cond_3e
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lc0/g$b;->a:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v2, p0, Lc0/g$b;->b:F

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v2, p0, Lc0/g$b;->c:F

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lc0/g$b;->d:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
