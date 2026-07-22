.class public final enum Lorg/mapsforge/core/graphics/Filter;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lorg/mapsforge/core/graphics/Filter;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lorg/mapsforge/core/graphics/Filter;

.field public static final enum GRAYSCALE:Lorg/mapsforge/core/graphics/Filter;

.field public static final enum GRAYSCALE_INVERT:Lorg/mapsforge/core/graphics/Filter;

.field public static final enum INVERT:Lorg/mapsforge/core/graphics/Filter;

.field public static final enum NONE:Lorg/mapsforge/core/graphics/Filter;


# direct methods
.method static constructor <clinit>()V
    .registers 9

    new-instance v0, Lorg/mapsforge/core/graphics/Filter;

    const-string v1, "GRAYSCALE"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/core/graphics/Filter;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lorg/mapsforge/core/graphics/Filter;->GRAYSCALE:Lorg/mapsforge/core/graphics/Filter;

    new-instance v1, Lorg/mapsforge/core/graphics/Filter;

    const-string v3, "GRAYSCALE_INVERT"

    const/4 v4, 0x1

    invoke-direct {v1, v3, v4}, Lorg/mapsforge/core/graphics/Filter;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lorg/mapsforge/core/graphics/Filter;->GRAYSCALE_INVERT:Lorg/mapsforge/core/graphics/Filter;

    new-instance v3, Lorg/mapsforge/core/graphics/Filter;

    const-string v5, "INVERT"

    const/4 v6, 0x2

    invoke-direct {v3, v5, v6}, Lorg/mapsforge/core/graphics/Filter;-><init>(Ljava/lang/String;I)V

    sput-object v3, Lorg/mapsforge/core/graphics/Filter;->INVERT:Lorg/mapsforge/core/graphics/Filter;

    new-instance v5, Lorg/mapsforge/core/graphics/Filter;

    const-string v7, "NONE"

    const/4 v8, 0x3

    invoke-direct {v5, v7, v8}, Lorg/mapsforge/core/graphics/Filter;-><init>(Ljava/lang/String;I)V

    sput-object v5, Lorg/mapsforge/core/graphics/Filter;->NONE:Lorg/mapsforge/core/graphics/Filter;

    const/4 v7, 0x4

    new-array v7, v7, [Lorg/mapsforge/core/graphics/Filter;

    aput-object v0, v7, v2

    aput-object v1, v7, v4

    aput-object v3, v7, v6

    aput-object v5, v7, v8

    sput-object v7, Lorg/mapsforge/core/graphics/Filter;->$VALUES:[Lorg/mapsforge/core/graphics/Filter;

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

.method public static valueOf(Ljava/lang/String;)Lorg/mapsforge/core/graphics/Filter;
    .registers 2

    const-class v0, Lorg/mapsforge/core/graphics/Filter;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lorg/mapsforge/core/graphics/Filter;

    return-object p0
.end method

.method public static values()[Lorg/mapsforge/core/graphics/Filter;
    .registers 1

    sget-object v0, Lorg/mapsforge/core/graphics/Filter;->$VALUES:[Lorg/mapsforge/core/graphics/Filter;

    invoke-virtual {v0}, [Lorg/mapsforge/core/graphics/Filter;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lorg/mapsforge/core/graphics/Filter;

    return-object v0
.end method
