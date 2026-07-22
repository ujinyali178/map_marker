.class public final enum Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/core/graphics/HillshadingBitmap;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Border"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

.field public static final enum EAST:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

.field public static final enum NORTH:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

.field public static final enum SOUTH:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

.field public static final enum WEST:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;


# instance fields
.field public final vertical:Z


# direct methods
.method static constructor <clinit>()V
    .registers 9

    new-instance v0, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    const-string v1, "WEST"

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-direct {v0, v1, v2, v3}, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;-><init>(Ljava/lang/String;IZ)V

    sput-object v0, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->WEST:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    new-instance v1, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    const-string v4, "NORTH"

    invoke-direct {v1, v4, v3, v2}, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;-><init>(Ljava/lang/String;IZ)V

    sput-object v1, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->NORTH:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    new-instance v4, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    const-string v5, "EAST"

    const/4 v6, 0x2

    invoke-direct {v4, v5, v6, v3}, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;-><init>(Ljava/lang/String;IZ)V

    sput-object v4, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->EAST:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    new-instance v5, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    const-string v7, "SOUTH"

    const/4 v8, 0x3

    invoke-direct {v5, v7, v8, v2}, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;-><init>(Ljava/lang/String;IZ)V

    sput-object v5, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->SOUTH:Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    const/4 v7, 0x4

    new-array v7, v7, [Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    aput-object v0, v7, v2

    aput-object v1, v7, v3

    aput-object v4, v7, v6

    aput-object v5, v7, v8

    sput-object v7, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->$VALUES:[Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IZ)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput-boolean p3, p0, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->vertical:Z

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;
    .registers 2

    const-class v0, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    return-object p0
.end method

.method public static values()[Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;
    .registers 1

    sget-object v0, Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->$VALUES:[Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    invoke-virtual {v0}, [Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lorg/mapsforge/core/graphics/HillshadingBitmap$Border;

    return-object v0
.end method
