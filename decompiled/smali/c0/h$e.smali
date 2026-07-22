.class Lc0/h$e;
.super Lc0/h$f;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/h;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "e"
.end annotation


# instance fields
.field private e:Landroid/graphics/Path;

.field final synthetic f:Lc0/h;


# direct methods
.method constructor <init>(Lc0/h;Landroid/graphics/Path;FF)V
    .registers 5

    iput-object p1, p0, Lc0/h$e;->f:Lc0/h;

    invoke-direct {p0, p1, p3, p4}, Lc0/h$f;-><init>(Lc0/h;FF)V

    iput-object p2, p0, Lc0/h$e;->e:Landroid/graphics/Path;

    return-void
.end method


# virtual methods
.method public b(Ljava/lang/String;)V
    .registers 9

    iget-object v0, p0, Lc0/h$e;->f:Lc0/h;

    invoke-static {v0}, Lc0/h;->b(Lc0/h;)Z

    move-result v0

    if-eqz v0, :cond_4c

    iget-object v0, p0, Lc0/h$e;->f:Lc0/h;

    invoke-static {v0}, Lc0/h;->c(Lc0/h;)Lc0/h$h;

    move-result-object v0

    iget-boolean v0, v0, Lc0/h$h;->b:Z

    if-eqz v0, :cond_2a

    iget-object v0, p0, Lc0/h$e;->f:Lc0/h;

    invoke-static {v0}, Lc0/h;->d(Lc0/h;)Landroid/graphics/Canvas;

    move-result-object v1

    iget-object v3, p0, Lc0/h$e;->e:Landroid/graphics/Path;

    iget v4, p0, Lc0/h$f;->b:F

    iget v5, p0, Lc0/h$f;->c:F

    iget-object v0, p0, Lc0/h$e;->f:Lc0/h;

    invoke-static {v0}, Lc0/h;->c(Lc0/h;)Lc0/h$h;

    move-result-object v0

    iget-object v6, v0, Lc0/h$h;->d:Landroid/graphics/Paint;

    move-object v2, p1

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawTextOnPath(Ljava/lang/String;Landroid/graphics/Path;FFLandroid/graphics/Paint;)V

    :cond_2a
    iget-object v0, p0, Lc0/h$e;->f:Lc0/h;

    invoke-static {v0}, Lc0/h;->c(Lc0/h;)Lc0/h$h;

    move-result-object v0

    iget-boolean v0, v0, Lc0/h$h;->c:Z

    if-eqz v0, :cond_4c

    iget-object v0, p0, Lc0/h$e;->f:Lc0/h;

    invoke-static {v0}, Lc0/h;->d(Lc0/h;)Landroid/graphics/Canvas;

    move-result-object v1

    iget-object v3, p0, Lc0/h$e;->e:Landroid/graphics/Path;

    iget v4, p0, Lc0/h$f;->b:F

    iget v5, p0, Lc0/h$f;->c:F

    iget-object v0, p0, Lc0/h$e;->f:Lc0/h;

    invoke-static {v0}, Lc0/h;->c(Lc0/h;)Lc0/h$h;

    move-result-object v0

    iget-object v6, v0, Lc0/h$h;->e:Landroid/graphics/Paint;

    move-object v2, p1

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawTextOnPath(Ljava/lang/String;Landroid/graphics/Path;FFLandroid/graphics/Paint;)V

    :cond_4c
    iget v0, p0, Lc0/h$f;->b:F

    iget-object v1, p0, Lc0/h$e;->f:Lc0/h;

    invoke-static {v1}, Lc0/h;->c(Lc0/h;)Lc0/h$h;

    move-result-object v1

    iget-object v1, v1, Lc0/h$h;->d:Landroid/graphics/Paint;

    invoke-virtual {v1, p1}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result p1

    add-float/2addr v0, p1

    iput v0, p0, Lc0/h$f;->b:F

    return-void
.end method
