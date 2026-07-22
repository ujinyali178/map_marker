.class Lc0/h$d;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lc0/g$x;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/h;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "d"
.end annotation


# instance fields
.field a:Landroid/graphics/Path;

.field b:F

.field c:F

.field final synthetic d:Lc0/h;


# direct methods
.method constructor <init>(Lc0/h;Lc0/g$w;)V
    .registers 3

    iput-object p1, p0, Lc0/h$d;->d:Lc0/h;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance p1, Landroid/graphics/Path;

    invoke-direct {p1}, Landroid/graphics/Path;-><init>()V

    iput-object p1, p0, Lc0/h$d;->a:Landroid/graphics/Path;

    if-nez p2, :cond_f

    return-void

    :cond_f
    invoke-virtual {p2, p0}, Lc0/g$w;->f(Lc0/g$x;)V

    return-void
.end method


# virtual methods
.method public a(FFFF)V
    .registers 6

    iget-object v0, p0, Lc0/h$d;->a:Landroid/graphics/Path;

    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/graphics/Path;->quadTo(FFFF)V

    iput p3, p0, Lc0/h$d;->b:F

    iput p4, p0, Lc0/h$d;->c:F

    return-void
.end method

.method public b(FFFFFF)V
    .registers 14

    iget-object v0, p0, Lc0/h$d;->a:Landroid/graphics/Path;

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    move v6, p6

    invoke-virtual/range {v0 .. v6}, Landroid/graphics/Path;->cubicTo(FFFFFF)V

    iput p5, p0, Lc0/h$d;->b:F

    iput p6, p0, Lc0/h$d;->c:F

    return-void
.end method

.method public c(FFFZZFF)V
    .registers 19

    move-object v10, p0

    iget v0, v10, Lc0/h$d;->b:F

    iget v1, v10, Lc0/h$d;->c:F

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move/from16 v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move-object v9, p0

    invoke-static/range {v0 .. v9}, Lc0/h;->f(FFFFFZZFFLc0/g$x;)V

    move/from16 v0, p6

    iput v0, v10, Lc0/h$d;->b:F

    move/from16 v0, p7

    iput v0, v10, Lc0/h$d;->c:F

    return-void
.end method

.method public close()V
    .registers 2

    iget-object v0, p0, Lc0/h$d;->a:Landroid/graphics/Path;

    invoke-virtual {v0}, Landroid/graphics/Path;->close()V

    return-void
.end method

.method d()Landroid/graphics/Path;
    .registers 2

    iget-object v0, p0, Lc0/h$d;->a:Landroid/graphics/Path;

    return-object v0
.end method

.method public lineTo(FF)V
    .registers 4

    iget-object v0, p0, Lc0/h$d;->a:Landroid/graphics/Path;

    invoke-virtual {v0, p1, p2}, Landroid/graphics/Path;->lineTo(FF)V

    iput p1, p0, Lc0/h$d;->b:F

    iput p2, p0, Lc0/h$d;->c:F

    return-void
.end method

.method public moveTo(FF)V
    .registers 4

    iget-object v0, p0, Lc0/h$d;->a:Landroid/graphics/Path;

    invoke-virtual {v0, p1, p2}, Landroid/graphics/Path;->moveTo(FF)V

    iput p1, p0, Lc0/h$d;->b:F

    iput p2, p0, Lc0/h$d;->c:F

    return-void
.end method
