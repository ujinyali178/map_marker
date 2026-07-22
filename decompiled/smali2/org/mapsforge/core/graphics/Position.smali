.class public final enum Lorg/mapsforge/core/graphics/Position;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lorg/mapsforge/core/graphics/Position;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lorg/mapsforge/core/graphics/Position;

.field public static final enum ABOVE:Lorg/mapsforge/core/graphics/Position;

.field public static final enum ABOVE_LEFT:Lorg/mapsforge/core/graphics/Position;

.field public static final enum ABOVE_RIGHT:Lorg/mapsforge/core/graphics/Position;

.field public static final enum AUTO:Lorg/mapsforge/core/graphics/Position;

.field public static final enum BELOW:Lorg/mapsforge/core/graphics/Position;

.field public static final enum BELOW_LEFT:Lorg/mapsforge/core/graphics/Position;

.field public static final enum BELOW_RIGHT:Lorg/mapsforge/core/graphics/Position;

.field public static final enum CENTER:Lorg/mapsforge/core/graphics/Position;

.field public static final enum LEFT:Lorg/mapsforge/core/graphics/Position;

.field public static final enum RIGHT:Lorg/mapsforge/core/graphics/Position;


# direct methods
.method static constructor <clinit>()V
    .registers 16

    new-instance v0, Lorg/mapsforge/core/graphics/Position;

    const-string v1, "AUTO"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/core/graphics/Position;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lorg/mapsforge/core/graphics/Position;->AUTO:Lorg/mapsforge/core/graphics/Position;

    new-instance v1, Lorg/mapsforge/core/graphics/Position;

    const-string v3, "CENTER"

    const/4 v4, 0x1

    invoke-direct {v1, v3, v4}, Lorg/mapsforge/core/graphics/Position;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lorg/mapsforge/core/graphics/Position;->CENTER:Lorg/mapsforge/core/graphics/Position;

    new-instance v3, Lorg/mapsforge/core/graphics/Position;

    const-string v5, "BELOW"

    const/4 v6, 0x2

    invoke-direct {v3, v5, v6}, Lorg/mapsforge/core/graphics/Position;-><init>(Ljava/lang/String;I)V

    sput-object v3, Lorg/mapsforge/core/graphics/Position;->BELOW:Lorg/mapsforge/core/graphics/Position;

    new-instance v5, Lorg/mapsforge/core/graphics/Position;

    const-string v7, "BELOW_LEFT"

    const/4 v8, 0x3

    invoke-direct {v5, v7, v8}, Lorg/mapsforge/core/graphics/Position;-><init>(Ljava/lang/String;I)V

    sput-object v5, Lorg/mapsforge/core/graphics/Position;->BELOW_LEFT:Lorg/mapsforge/core/graphics/Position;

    new-instance v7, Lorg/mapsforge/core/graphics/Position;

    const-string v9, "BELOW_RIGHT"

    const/4 v10, 0x4

    invoke-direct {v7, v9, v10}, Lorg/mapsforge/core/graphics/Position;-><init>(Ljava/lang/String;I)V

    sput-object v7, Lorg/mapsforge/core/graphics/Position;->BELOW_RIGHT:Lorg/mapsforge/core/graphics/Position;

    new-instance v9, Lorg/mapsforge/core/graphics/Position;

    const-string v11, "ABOVE"

    const/4 v12, 0x5

    invoke-direct {v9, v11, v12}, Lorg/mapsforge/core/graphics/Position;-><init>(Ljava/lang/String;I)V

    sput-object v9, Lorg/mapsforge/core/graphics/Position;->ABOVE:Lorg/mapsforge/core/graphics/Position;

    new-instance v11, Lorg/mapsforge/core/graphics/Position;

    const-string v13, "ABOVE_LEFT"

    const/4 v14, 0x6

    invoke-direct {v11, v13, v14}, Lorg/mapsforge/core/graphics/Position;-><init>(Ljava/lang/String;I)V

    sput-object v11, Lorg/mapsforge/core/graphics/Position;->ABOVE_LEFT:Lorg/mapsforge/core/graphics/Position;

    new-instance v13, Lorg/mapsforge/core/graphics/Position;

    const-string v15, "ABOVE_RIGHT"

    const/4 v14, 0x7

    invoke-direct {v13, v15, v14}, Lorg/mapsforge/core/graphics/Position;-><init>(Ljava/lang/String;I)V

    sput-object v13, Lorg/mapsforge/core/graphics/Position;->ABOVE_RIGHT:Lorg/mapsforge/core/graphics/Position;

    new-instance v15, Lorg/mapsforge/core/graphics/Position;

    const-string v14, "LEFT"

    const/16 v12, 0x8

    invoke-direct {v15, v14, v12}, Lorg/mapsforge/core/graphics/Position;-><init>(Ljava/lang/String;I)V

    sput-object v15, Lorg/mapsforge/core/graphics/Position;->LEFT:Lorg/mapsforge/core/graphics/Position;

    new-instance v14, Lorg/mapsforge/core/graphics/Position;

    const-string v12, "RIGHT"

    const/16 v10, 0x9

    invoke-direct {v14, v12, v10}, Lorg/mapsforge/core/graphics/Position;-><init>(Ljava/lang/String;I)V

    sput-object v14, Lorg/mapsforge/core/graphics/Position;->RIGHT:Lorg/mapsforge/core/graphics/Position;

    const/16 v12, 0xa

    new-array v12, v12, [Lorg/mapsforge/core/graphics/Position;

    aput-object v0, v12, v2

    aput-object v1, v12, v4

    aput-object v3, v12, v6

    aput-object v5, v12, v8

    const/4 v0, 0x4

    aput-object v7, v12, v0

    const/4 v0, 0x5

    aput-object v9, v12, v0

    const/4 v0, 0x6

    aput-object v11, v12, v0

    const/4 v0, 0x7

    aput-object v13, v12, v0

    const/16 v0, 0x8

    aput-object v15, v12, v0

    aput-object v14, v12, v10

    sput-object v12, Lorg/mapsforge/core/graphics/Position;->$VALUES:[Lorg/mapsforge/core/graphics/Position;

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

.method public static fromString(Ljava/lang/String;)Lorg/mapsforge/core/graphics/Position;
    .registers 4

    const-string v0, "auto"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    sget-object p0, Lorg/mapsforge/core/graphics/Position;->BELOW:Lorg/mapsforge/core/graphics/Position;

    return-object p0

    :cond_b
    const-string v0, "center"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_16

    sget-object p0, Lorg/mapsforge/core/graphics/Position;->CENTER:Lorg/mapsforge/core/graphics/Position;

    return-object p0

    :cond_16
    const-string v0, "below"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_21

    sget-object p0, Lorg/mapsforge/core/graphics/Position;->BELOW:Lorg/mapsforge/core/graphics/Position;

    return-object p0

    :cond_21
    const-string v0, "below_left"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2c

    sget-object p0, Lorg/mapsforge/core/graphics/Position;->BELOW_LEFT:Lorg/mapsforge/core/graphics/Position;

    return-object p0

    :cond_2c
    const-string v0, "below_right"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_37

    sget-object p0, Lorg/mapsforge/core/graphics/Position;->BELOW_RIGHT:Lorg/mapsforge/core/graphics/Position;

    return-object p0

    :cond_37
    const-string v0, "above"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_42

    sget-object p0, Lorg/mapsforge/core/graphics/Position;->ABOVE:Lorg/mapsforge/core/graphics/Position;

    return-object p0

    :cond_42
    const-string v0, "above_left"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4d

    sget-object p0, Lorg/mapsforge/core/graphics/Position;->ABOVE_LEFT:Lorg/mapsforge/core/graphics/Position;

    return-object p0

    :cond_4d
    const-string v0, "above_right"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_58

    sget-object p0, Lorg/mapsforge/core/graphics/Position;->ABOVE_RIGHT:Lorg/mapsforge/core/graphics/Position;

    return-object p0

    :cond_58
    const-string v0, "left"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_63

    sget-object p0, Lorg/mapsforge/core/graphics/Position;->LEFT:Lorg/mapsforge/core/graphics/Position;

    return-object p0

    :cond_63
    const-string v0, "right"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6e

    sget-object p0, Lorg/mapsforge/core/graphics/Position;->RIGHT:Lorg/mapsforge/core/graphics/Position;

    return-object p0

    :cond_6e
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid value for Position: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static valueOf(Ljava/lang/String;)Lorg/mapsforge/core/graphics/Position;
    .registers 2

    const-class v0, Lorg/mapsforge/core/graphics/Position;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lorg/mapsforge/core/graphics/Position;

    return-object p0
.end method

.method public static values()[Lorg/mapsforge/core/graphics/Position;
    .registers 1

    sget-object v0, Lorg/mapsforge/core/graphics/Position;->$VALUES:[Lorg/mapsforge/core/graphics/Position;

    invoke-virtual {v0}, [Lorg/mapsforge/core/graphics/Position;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lorg/mapsforge/core/graphics/Position;

    return-object v0
.end method
