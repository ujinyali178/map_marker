.class public final enum Lorg/mapsforge/core/graphics/Align;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lorg/mapsforge/core/graphics/Align;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lorg/mapsforge/core/graphics/Align;

.field public static final enum CENTER:Lorg/mapsforge/core/graphics/Align;

.field public static final enum LEFT:Lorg/mapsforge/core/graphics/Align;

.field public static final enum RIGHT:Lorg/mapsforge/core/graphics/Align;


# direct methods
.method static constructor <clinit>()V
    .registers 7

    new-instance v0, Lorg/mapsforge/core/graphics/Align;

    const-string v1, "CENTER"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/core/graphics/Align;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lorg/mapsforge/core/graphics/Align;->CENTER:Lorg/mapsforge/core/graphics/Align;

    new-instance v1, Lorg/mapsforge/core/graphics/Align;

    const-string v3, "LEFT"

    const/4 v4, 0x1

    invoke-direct {v1, v3, v4}, Lorg/mapsforge/core/graphics/Align;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lorg/mapsforge/core/graphics/Align;->LEFT:Lorg/mapsforge/core/graphics/Align;

    new-instance v3, Lorg/mapsforge/core/graphics/Align;

    const-string v5, "RIGHT"

    const/4 v6, 0x2

    invoke-direct {v3, v5, v6}, Lorg/mapsforge/core/graphics/Align;-><init>(Ljava/lang/String;I)V

    sput-object v3, Lorg/mapsforge/core/graphics/Align;->RIGHT:Lorg/mapsforge/core/graphics/Align;

    const/4 v5, 0x3

    new-array v5, v5, [Lorg/mapsforge/core/graphics/Align;

    aput-object v0, v5, v2

    aput-object v1, v5, v4

    aput-object v3, v5, v6

    sput-object v5, Lorg/mapsforge/core/graphics/Align;->$VALUES:[Lorg/mapsforge/core/graphics/Align;

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

.method public static valueOf(Ljava/lang/String;)Lorg/mapsforge/core/graphics/Align;
    .registers 2

    const-class v0, Lorg/mapsforge/core/graphics/Align;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lorg/mapsforge/core/graphics/Align;

    return-object p0
.end method

.method public static values()[Lorg/mapsforge/core/graphics/Align;
    .registers 1

    sget-object v0, Lorg/mapsforge/core/graphics/Align;->$VALUES:[Lorg/mapsforge/core/graphics/Align;

    invoke-virtual {v0}, [Lorg/mapsforge/core/graphics/Align;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lorg/mapsforge/core/graphics/Align;

    return-object v0
.end method


# virtual methods
.method public fromString(Ljava/lang/String;)Lorg/mapsforge/core/graphics/Align;
    .registers 5

    const-string v0, "center"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    sget-object p1, Lorg/mapsforge/core/graphics/Align;->CENTER:Lorg/mapsforge/core/graphics/Align;

    return-object p1

    :cond_b
    const-string v0, "left"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_16

    sget-object p1, Lorg/mapsforge/core/graphics/Align;->LEFT:Lorg/mapsforge/core/graphics/Align;

    return-object p1

    :cond_16
    const-string v0, "right"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_21

    sget-object p1, Lorg/mapsforge/core/graphics/Align;->RIGHT:Lorg/mapsforge/core/graphics/Align;

    return-object p1

    :cond_21
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid value for Align: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
