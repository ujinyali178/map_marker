.class Lc0/h$f;
.super Lc0/h$j;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/h;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "f"
.end annotation


# instance fields
.field b:F

.field c:F

.field final synthetic d:Lc0/h;


# direct methods
.method constructor <init>(Lc0/h;FF)V
    .registers 5

    iput-object p1, p0, Lc0/h$f;->d:Lc0/h;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lc0/h$j;-><init>(Lc0/h;Lc0/h$a;)V

    iput p2, p0, Lc0/h$f;->b:F

    iput p3, p0, Lc0/h$f;->c:F

    return-void
.end method


# virtual methods
.method public b(Ljava/lang/String;)V
    .registers 6

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "TextSequence render"

    invoke-static {v1, v0}, Lc0/h;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/h$f;->d:Lc0/h;

    invoke-static {v0}, Lc0/h;->b(Lc0/h;)Z

    move-result v0

    if-eqz v0, :cond_4e

    iget-object v0, p0, Lc0/h$f;->d:Lc0/h;

    invoke-static {v0}, Lc0/h;->c(Lc0/h;)Lc0/h$h;

    move-result-object v0

    iget-boolean v0, v0, Lc0/h$h;->b:Z

    if-eqz v0, :cond_2f

    iget-object v0, p0, Lc0/h$f;->d:Lc0/h;

    invoke-static {v0}, Lc0/h;->d(Lc0/h;)Landroid/graphics/Canvas;

    move-result-object v0

    iget v1, p0, Lc0/h$f;->b:F

    iget v2, p0, Lc0/h$f;->c:F

    iget-object v3, p0, Lc0/h$f;->d:Lc0/h;

    invoke-static {v3}, Lc0/h;->c(Lc0/h;)Lc0/h$h;

    move-result-object v3

    iget-object v3, v3, Lc0/h$h;->d:Landroid/graphics/Paint;

    invoke-virtual {v0, p1, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    :cond_2f
    iget-object v0, p0, Lc0/h$f;->d:Lc0/h;

    invoke-static {v0}, Lc0/h;->c(Lc0/h;)Lc0/h$h;

    move-result-object v0

    iget-boolean v0, v0, Lc0/h$h;->c:Z

    if-eqz v0, :cond_4e

    iget-object v0, p0, Lc0/h$f;->d:Lc0/h;

    invoke-static {v0}, Lc0/h;->d(Lc0/h;)Landroid/graphics/Canvas;

    move-result-object v0

    iget v1, p0, Lc0/h$f;->b:F

    iget v2, p0, Lc0/h$f;->c:F

    iget-object v3, p0, Lc0/h$f;->d:Lc0/h;

    invoke-static {v3}, Lc0/h;->c(Lc0/h;)Lc0/h$h;

    move-result-object v3

    iget-object v3, v3, Lc0/h$h;->e:Landroid/graphics/Paint;

    invoke-virtual {v0, p1, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    :cond_4e
    iget v0, p0, Lc0/h$f;->b:F

    iget-object v1, p0, Lc0/h$f;->d:Lc0/h;

    invoke-static {v1}, Lc0/h;->c(Lc0/h;)Lc0/h$h;

    move-result-object v1

    iget-object v1, v1, Lc0/h$h;->d:Landroid/graphics/Paint;

    invoke-virtual {v1, p1}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result p1

    add-float/2addr v0, p1

    iput v0, p0, Lc0/h$f;->b:F

    return-void
.end method
