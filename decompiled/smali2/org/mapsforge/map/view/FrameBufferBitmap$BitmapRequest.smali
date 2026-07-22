.class Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/view/FrameBufferBitmap;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "BitmapRequest"
.end annotation


# instance fields
.field private final color:I

.field private final dimension:Lorg/mapsforge/core/model/Dimension;

.field private final factory:Lorg/mapsforge/core/graphics/GraphicFactory;

.field private final isTransparent:Z


# direct methods
.method constructor <init>(Lorg/mapsforge/core/graphics/GraphicFactory;Lorg/mapsforge/core/model/Dimension;IZ)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;->factory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iput-object p2, p0, Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;->dimension:Lorg/mapsforge/core/model/Dimension;

    iput p3, p0, Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;->color:I

    iput-boolean p4, p0, Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;->isTransparent:Z

    return-void
.end method


# virtual methods
.method create()Lorg/mapsforge/core/graphics/Bitmap;
    .registers 5

    iget-object v0, p0, Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;->dimension:Lorg/mapsforge/core/model/Dimension;

    iget v1, v0, Lorg/mapsforge/core/model/Dimension;->width:I

    if-lez v1, :cond_18

    iget v0, v0, Lorg/mapsforge/core/model/Dimension;->height:I

    if-lez v0, :cond_18

    iget-object v2, p0, Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;->factory:Lorg/mapsforge/core/graphics/GraphicFactory;

    iget-boolean v3, p0, Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;->isTransparent:Z

    invoke-interface {v2, v1, v0, v3}, Lorg/mapsforge/core/graphics/GraphicFactory;->createBitmap(IIZ)Lorg/mapsforge/core/graphics/Bitmap;

    move-result-object v0

    iget v1, p0, Lorg/mapsforge/map/view/FrameBufferBitmap$BitmapRequest;->color:I

    invoke-interface {v0, v1}, Lorg/mapsforge/core/graphics/Bitmap;->setBackgroundColor(I)V

    return-object v0

    :cond_18
    const/4 v0, 0x0

    return-object v0
.end method
