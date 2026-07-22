.class Lorg/mapsforge/map/android/graphics/AndroidPath;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/core/graphics/Path;


# instance fields
.field final path:Landroid/graphics/Path;


# direct methods
.method constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Landroid/graphics/Path;

    invoke-direct {v0}, Landroid/graphics/Path;-><init>()V

    iput-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPath;->path:Landroid/graphics/Path;

    return-void
.end method

.method private static getWindingRule(Lorg/mapsforge/core/graphics/FillRule;)Landroid/graphics/Path$FillType;
    .registers 4

    sget-object v0, Lorg/mapsforge/map/android/graphics/AndroidPath$1;->$SwitchMap$org$mapsforge$core$graphics$FillRule:[I

    invoke-virtual {p0}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_28

    const/4 v1, 0x2

    if-ne v0, v1, :cond_11

    sget-object p0, Landroid/graphics/Path$FillType;->WINDING:Landroid/graphics/Path$FillType;

    return-object p0

    :cond_11
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "unknown fill rule:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_28
    sget-object p0, Landroid/graphics/Path$FillType;->EVEN_ODD:Landroid/graphics/Path$FillType;

    return-object p0
.end method


# virtual methods
.method public clear()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPath;->path:Landroid/graphics/Path;

    invoke-virtual {v0}, Landroid/graphics/Path;->rewind()V

    return-void
.end method

.method public close()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPath;->path:Landroid/graphics/Path;

    invoke-virtual {v0}, Landroid/graphics/Path;->close()V

    return-void
.end method

.method public isEmpty()Z
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPath;->path:Landroid/graphics/Path;

    invoke-virtual {v0}, Landroid/graphics/Path;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public lineTo(FF)V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPath;->path:Landroid/graphics/Path;

    invoke-virtual {v0, p1, p2}, Landroid/graphics/Path;->lineTo(FF)V

    return-void
.end method

.method public moveTo(FF)V
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPath;->path:Landroid/graphics/Path;

    invoke-virtual {v0, p1, p2}, Landroid/graphics/Path;->moveTo(FF)V

    return-void
.end method

.method public setFillRule(Lorg/mapsforge/core/graphics/FillRule;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/android/graphics/AndroidPath;->path:Landroid/graphics/Path;

    invoke-static {p1}, Lorg/mapsforge/map/android/graphics/AndroidPath;->getWindingRule(Lorg/mapsforge/core/graphics/FillRule;)Landroid/graphics/Path$FillType;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/graphics/Path;->setFillType(Landroid/graphics/Path$FillType;)V

    return-void
.end method
