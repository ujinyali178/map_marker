.class public final enum Lorg/mapsforge/core/graphics/FontStyle;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lorg/mapsforge/core/graphics/FontStyle;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lorg/mapsforge/core/graphics/FontStyle;

.field public static final enum BOLD:Lorg/mapsforge/core/graphics/FontStyle;

.field public static final enum BOLD_ITALIC:Lorg/mapsforge/core/graphics/FontStyle;

.field public static final enum ITALIC:Lorg/mapsforge/core/graphics/FontStyle;

.field public static final enum NORMAL:Lorg/mapsforge/core/graphics/FontStyle;


# direct methods
.method static constructor <clinit>()V
    .registers 9

    new-instance v0, Lorg/mapsforge/core/graphics/FontStyle;

    const-string v1, "BOLD"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/core/graphics/FontStyle;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lorg/mapsforge/core/graphics/FontStyle;->BOLD:Lorg/mapsforge/core/graphics/FontStyle;

    new-instance v1, Lorg/mapsforge/core/graphics/FontStyle;

    const-string v3, "BOLD_ITALIC"

    const/4 v4, 0x1

    invoke-direct {v1, v3, v4}, Lorg/mapsforge/core/graphics/FontStyle;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lorg/mapsforge/core/graphics/FontStyle;->BOLD_ITALIC:Lorg/mapsforge/core/graphics/FontStyle;

    new-instance v3, Lorg/mapsforge/core/graphics/FontStyle;

    const-string v5, "ITALIC"

    const/4 v6, 0x2

    invoke-direct {v3, v5, v6}, Lorg/mapsforge/core/graphics/FontStyle;-><init>(Ljava/lang/String;I)V

    sput-object v3, Lorg/mapsforge/core/graphics/FontStyle;->ITALIC:Lorg/mapsforge/core/graphics/FontStyle;

    new-instance v5, Lorg/mapsforge/core/graphics/FontStyle;

    const-string v7, "NORMAL"

    const/4 v8, 0x3

    invoke-direct {v5, v7, v8}, Lorg/mapsforge/core/graphics/FontStyle;-><init>(Ljava/lang/String;I)V

    sput-object v5, Lorg/mapsforge/core/graphics/FontStyle;->NORMAL:Lorg/mapsforge/core/graphics/FontStyle;

    const/4 v7, 0x4

    new-array v7, v7, [Lorg/mapsforge/core/graphics/FontStyle;

    aput-object v0, v7, v2

    aput-object v1, v7, v4

    aput-object v3, v7, v6

    aput-object v5, v7, v8

    sput-object v7, Lorg/mapsforge/core/graphics/FontStyle;->$VALUES:[Lorg/mapsforge/core/graphics/FontStyle;

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

.method public static fromString(Ljava/lang/String;)Lorg/mapsforge/core/graphics/FontStyle;
    .registers 4

    const-string v0, "bold"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    sget-object p0, Lorg/mapsforge/core/graphics/FontStyle;->BOLD:Lorg/mapsforge/core/graphics/FontStyle;

    return-object p0

    :cond_b
    const-string v0, "bold_italic"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_16

    sget-object p0, Lorg/mapsforge/core/graphics/FontStyle;->BOLD_ITALIC:Lorg/mapsforge/core/graphics/FontStyle;

    return-object p0

    :cond_16
    const-string v0, "italic"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_21

    sget-object p0, Lorg/mapsforge/core/graphics/FontStyle;->ITALIC:Lorg/mapsforge/core/graphics/FontStyle;

    return-object p0

    :cond_21
    const-string v0, "normal"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2c

    sget-object p0, Lorg/mapsforge/core/graphics/FontStyle;->NORMAL:Lorg/mapsforge/core/graphics/FontStyle;

    return-object p0

    :cond_2c
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid value for FontStyle: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static valueOf(Ljava/lang/String;)Lorg/mapsforge/core/graphics/FontStyle;
    .registers 2

    const-class v0, Lorg/mapsforge/core/graphics/FontStyle;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lorg/mapsforge/core/graphics/FontStyle;

    return-object p0
.end method

.method public static values()[Lorg/mapsforge/core/graphics/FontStyle;
    .registers 1

    sget-object v0, Lorg/mapsforge/core/graphics/FontStyle;->$VALUES:[Lorg/mapsforge/core/graphics/FontStyle;

    invoke-virtual {v0}, [Lorg/mapsforge/core/graphics/FontStyle;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lorg/mapsforge/core/graphics/FontStyle;

    return-object v0
.end method
