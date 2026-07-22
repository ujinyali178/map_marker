.class Lc0/h$i;
.super Lc0/h$j;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/h;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "i"
.end annotation


# instance fields
.field b:F

.field c:F

.field d:Landroid/graphics/RectF;

.field final synthetic e:Lc0/h;


# direct methods
.method constructor <init>(Lc0/h;FF)V
    .registers 5

    iput-object p1, p0, Lc0/h$i;->e:Lc0/h;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lc0/h$j;-><init>(Lc0/h;Lc0/h$a;)V

    new-instance p1, Landroid/graphics/RectF;

    invoke-direct {p1}, Landroid/graphics/RectF;-><init>()V

    iput-object p1, p0, Lc0/h$i;->d:Landroid/graphics/RectF;

    iput p2, p0, Lc0/h$i;->b:F

    iput p3, p0, Lc0/h$i;->c:F

    return-void
.end method


# virtual methods
.method public a(Lc0/g$y0;)Z
    .registers 7

    instance-of v0, p1, Lc0/g$z0;

    const/4 v1, 0x1

    if-eqz v0, :cond_43

    move-object v0, p1

    check-cast v0, Lc0/g$z0;

    iget-object p1, p1, Lc0/g$n0;->a:Lc0/g;

    iget-object v2, v0, Lc0/g$z0;->o:Ljava/lang/String;

    invoke-virtual {p1, v2}, Lc0/g;->n(Ljava/lang/String;)Lc0/g$n0;

    move-result-object p1

    const/4 v2, 0x0

    if-nez p1, :cond_1f

    new-array p1, v1, [Ljava/lang/Object;

    iget-object v0, v0, Lc0/g$z0;->o:Ljava/lang/String;

    aput-object v0, p1, v2

    const-string v0, "TextPath path reference \'%s\' not found"

    invoke-static {v0, p1}, Lc0/h;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    return v2

    :cond_1f
    check-cast p1, Lc0/g$v;

    new-instance v0, Lc0/h$d;

    iget-object v3, p0, Lc0/h$i;->e:Lc0/h;

    iget-object v4, p1, Lc0/g$v;->o:Lc0/g$w;

    invoke-direct {v0, v3, v4}, Lc0/h$d;-><init>(Lc0/h;Lc0/g$w;)V

    invoke-virtual {v0}, Lc0/h$d;->d()Landroid/graphics/Path;

    move-result-object v0

    iget-object p1, p1, Lc0/g$l;->n:Landroid/graphics/Matrix;

    if-eqz p1, :cond_35

    invoke-virtual {v0, p1}, Landroid/graphics/Path;->transform(Landroid/graphics/Matrix;)V

    :cond_35
    new-instance p1, Landroid/graphics/RectF;

    invoke-direct {p1}, Landroid/graphics/RectF;-><init>()V

    invoke-virtual {v0, p1, v1}, Landroid/graphics/Path;->computeBounds(Landroid/graphics/RectF;Z)V

    iget-object v0, p0, Lc0/h$i;->d:Landroid/graphics/RectF;

    invoke-virtual {v0, p1}, Landroid/graphics/RectF;->union(Landroid/graphics/RectF;)V

    return v2

    :cond_43
    return v1
.end method

.method public b(Ljava/lang/String;)V
    .registers 6

    iget-object v0, p0, Lc0/h$i;->e:Lc0/h;

    invoke-static {v0}, Lc0/h;->b(Lc0/h;)Z

    move-result v0

    if-eqz v0, :cond_2e

    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iget-object v1, p0, Lc0/h$i;->e:Lc0/h;

    invoke-static {v1}, Lc0/h;->c(Lc0/h;)Lc0/h$h;

    move-result-object v1

    iget-object v1, v1, Lc0/h$h;->d:Landroid/graphics/Paint;

    const/4 v2, 0x0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    invoke-virtual {v1, p1, v2, v3, v0}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    new-instance v1, Landroid/graphics/RectF;

    invoke-direct {v1, v0}, Landroid/graphics/RectF;-><init>(Landroid/graphics/Rect;)V

    iget v0, p0, Lc0/h$i;->b:F

    iget v2, p0, Lc0/h$i;->c:F

    invoke-virtual {v1, v0, v2}, Landroid/graphics/RectF;->offset(FF)V

    iget-object v0, p0, Lc0/h$i;->d:Landroid/graphics/RectF;

    invoke-virtual {v0, v1}, Landroid/graphics/RectF;->union(Landroid/graphics/RectF;)V

    :cond_2e
    iget v0, p0, Lc0/h$i;->b:F

    iget-object v1, p0, Lc0/h$i;->e:Lc0/h;

    invoke-static {v1}, Lc0/h;->c(Lc0/h;)Lc0/h$h;

    move-result-object v1

    iget-object v1, v1, Lc0/h$h;->d:Landroid/graphics/Paint;

    invoke-virtual {v1, p1}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result p1

    add-float/2addr v0, p1

    iput v0, p0, Lc0/h$i;->b:F

    return-void
.end method
