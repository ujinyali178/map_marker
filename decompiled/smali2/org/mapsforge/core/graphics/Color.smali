.class public final enum Lorg/mapsforge/core/graphics/Color;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lorg/mapsforge/core/graphics/Color;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lorg/mapsforge/core/graphics/Color;

.field public static final enum BLACK:Lorg/mapsforge/core/graphics/Color;

.field public static final enum BLUE:Lorg/mapsforge/core/graphics/Color;

.field public static final enum GREEN:Lorg/mapsforge/core/graphics/Color;

.field public static final enum RED:Lorg/mapsforge/core/graphics/Color;

.field public static final enum TRANSPARENT:Lorg/mapsforge/core/graphics/Color;

.field public static final enum WHITE:Lorg/mapsforge/core/graphics/Color;


# direct methods
.method static constructor <clinit>()V
    .registers 13

    new-instance v0, Lorg/mapsforge/core/graphics/Color;

    const-string v1, "BLACK"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/core/graphics/Color;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lorg/mapsforge/core/graphics/Color;->BLACK:Lorg/mapsforge/core/graphics/Color;

    new-instance v1, Lorg/mapsforge/core/graphics/Color;

    const-string v3, "BLUE"

    const/4 v4, 0x1

    invoke-direct {v1, v3, v4}, Lorg/mapsforge/core/graphics/Color;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lorg/mapsforge/core/graphics/Color;->BLUE:Lorg/mapsforge/core/graphics/Color;

    new-instance v3, Lorg/mapsforge/core/graphics/Color;

    const-string v5, "GREEN"

    const/4 v6, 0x2

    invoke-direct {v3, v5, v6}, Lorg/mapsforge/core/graphics/Color;-><init>(Ljava/lang/String;I)V

    sput-object v3, Lorg/mapsforge/core/graphics/Color;->GREEN:Lorg/mapsforge/core/graphics/Color;

    new-instance v5, Lorg/mapsforge/core/graphics/Color;

    const-string v7, "RED"

    const/4 v8, 0x3

    invoke-direct {v5, v7, v8}, Lorg/mapsforge/core/graphics/Color;-><init>(Ljava/lang/String;I)V

    sput-object v5, Lorg/mapsforge/core/graphics/Color;->RED:Lorg/mapsforge/core/graphics/Color;

    new-instance v7, Lorg/mapsforge/core/graphics/Color;

    const-string v9, "TRANSPARENT"

    const/4 v10, 0x4

    invoke-direct {v7, v9, v10}, Lorg/mapsforge/core/graphics/Color;-><init>(Ljava/lang/String;I)V

    sput-object v7, Lorg/mapsforge/core/graphics/Color;->TRANSPARENT:Lorg/mapsforge/core/graphics/Color;

    new-instance v9, Lorg/mapsforge/core/graphics/Color;

    const-string v11, "WHITE"

    const/4 v12, 0x5

    invoke-direct {v9, v11, v12}, Lorg/mapsforge/core/graphics/Color;-><init>(Ljava/lang/String;I)V

    sput-object v9, Lorg/mapsforge/core/graphics/Color;->WHITE:Lorg/mapsforge/core/graphics/Color;

    const/4 v11, 0x6

    new-array v11, v11, [Lorg/mapsforge/core/graphics/Color;

    aput-object v0, v11, v2

    aput-object v1, v11, v4

    aput-object v3, v11, v6

    aput-object v5, v11, v8

    aput-object v7, v11, v10

    aput-object v9, v11, v12

    sput-object v11, Lorg/mapsforge/core/graphics/Color;->$VALUES:[Lorg/mapsforge/core/graphics/Color;

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

.method public static valueOf(Ljava/lang/String;)Lorg/mapsforge/core/graphics/Color;
    .registers 2

    const-class v0, Lorg/mapsforge/core/graphics/Color;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lorg/mapsforge/core/graphics/Color;

    return-object p0
.end method

.method public static values()[Lorg/mapsforge/core/graphics/Color;
    .registers 1

    sget-object v0, Lorg/mapsforge/core/graphics/Color;->$VALUES:[Lorg/mapsforge/core/graphics/Color;

    invoke-virtual {v0}, [Lorg/mapsforge/core/graphics/Color;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lorg/mapsforge/core/graphics/Color;

    return-object v0
.end method
