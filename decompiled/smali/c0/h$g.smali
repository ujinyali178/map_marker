.class Lc0/h$g;
.super Lc0/h$j;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/h;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "g"
.end annotation


# instance fields
.field b:F

.field c:F

.field d:Landroid/graphics/Path;

.field final synthetic e:Lc0/h;


# direct methods
.method constructor <init>(Lc0/h;FFLandroid/graphics/Path;)V
    .registers 6

    iput-object p1, p0, Lc0/h$g;->e:Lc0/h;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lc0/h$j;-><init>(Lc0/h;Lc0/h$a;)V

    iput p2, p0, Lc0/h$g;->b:F

    iput p3, p0, Lc0/h$g;->c:F

    iput-object p4, p0, Lc0/h$g;->d:Landroid/graphics/Path;

    return-void
.end method


# virtual methods
.method public a(Lc0/g$y0;)Z
    .registers 4

    instance-of p1, p1, Lc0/g$z0;

    if-eqz p1, :cond_d

    const/4 p1, 0x0

    new-array v0, p1, [Ljava/lang/Object;

    const-string v1, "Using <textPath> elements in a clip path is not supported."

    invoke-static {v1, v0}, Lc0/h;->g(Ljava/lang/String;[Ljava/lang/Object;)V

    return p1

    :cond_d
    const/4 p1, 0x1

    return p1
.end method

.method public b(Ljava/lang/String;)V
    .registers 10

    iget-object v0, p0, Lc0/h$g;->e:Lc0/h;

    invoke-static {v0}, Lc0/h;->b(Lc0/h;)Z

    move-result v0

    if-eqz v0, :cond_28

    new-instance v0, Landroid/graphics/Path;

    invoke-direct {v0}, Landroid/graphics/Path;-><init>()V

    iget-object v1, p0, Lc0/h$g;->e:Lc0/h;

    invoke-static {v1}, Lc0/h;->c(Lc0/h;)Lc0/h$h;

    move-result-object v1

    iget-object v1, v1, Lc0/h$h;->d:Landroid/graphics/Paint;

    const/4 v3, 0x0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v4

    iget v5, p0, Lc0/h$g;->b:F

    iget v6, p0, Lc0/h$g;->c:F

    move-object v2, p1

    move-object v7, v0

    invoke-virtual/range {v1 .. v7}, Landroid/graphics/Paint;->getTextPath(Ljava/lang/String;IIFFLandroid/graphics/Path;)V

    iget-object v1, p0, Lc0/h$g;->d:Landroid/graphics/Path;

    invoke-virtual {v1, v0}, Landroid/graphics/Path;->addPath(Landroid/graphics/Path;)V

    :cond_28
    iget v0, p0, Lc0/h$g;->b:F

    iget-object v1, p0, Lc0/h$g;->e:Lc0/h;

    invoke-static {v1}, Lc0/h;->c(Lc0/h;)Lc0/h$h;

    move-result-object v1

    iget-object v1, v1, Lc0/h$h;->d:Landroid/graphics/Paint;

    invoke-virtual {v1, p1}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result p1

    add-float/2addr v0, p1

    iput v0, p0, Lc0/h$g;->b:F

    return-void
.end method
