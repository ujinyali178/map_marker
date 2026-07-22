.class public final Lorg/mapsforge/core/util/Parameters;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;
    }
.end annotation


# static fields
.field public static ANTI_ALIASING:Z = true

.field public static MAXIMUM_BUFFER_SIZE:I = 0x7a1200

.field public static NUMBER_OF_THREADS:I = 0x1

.field public static PARENT_TILES_RENDERING:Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

.field public static SQUARE_FRAME_BUFFER:Z


# direct methods
.method static constructor <clinit>()V
    .registers 1

    sget-object v0, Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;->QUALITY:Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    sput-object v0, Lorg/mapsforge/core/util/Parameters;->PARENT_TILES_RENDERING:Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    const/4 v0, 0x1

    sput-boolean v0, Lorg/mapsforge/core/util/Parameters;->SQUARE_FRAME_BUFFER:Z

    return-void
.end method

.method private constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
.end method
