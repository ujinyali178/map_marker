.class public final enum Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/core/util/Parameters;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ParentTilesRendering"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

.field public static final enum OFF:Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

.field public static final enum QUALITY:Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

.field public static final enum SPEED:Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;


# direct methods
.method static constructor <clinit>()V
    .registers 7

    new-instance v0, Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    const-string v1, "QUALITY"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;->QUALITY:Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    new-instance v1, Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    const-string v3, "SPEED"

    const/4 v4, 0x1

    invoke-direct {v1, v3, v4}, Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;->SPEED:Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    new-instance v3, Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    const-string v5, "OFF"

    const/4 v6, 0x2

    invoke-direct {v3, v5, v6}, Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;-><init>(Ljava/lang/String;I)V

    sput-object v3, Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;->OFF:Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    const/4 v5, 0x3

    new-array v5, v5, [Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    aput-object v0, v5, v2

    aput-object v1, v5, v4

    aput-object v3, v5, v6

    sput-object v5, Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;->$VALUES:[Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;
    .registers 2

    const-class v0, Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    return-object p0
.end method

.method public static values()[Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;
    .registers 1

    sget-object v0, Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;->$VALUES:[Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    invoke-virtual {v0}, [Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lorg/mapsforge/core/util/Parameters$ParentTilesRendering;

    return-object v0
.end method
