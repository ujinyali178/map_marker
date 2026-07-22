.class final enum Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "Element"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

.field public static final enum RENDERING_INSTRUCTION:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

.field public static final enum RENDERING_STYLE:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

.field public static final enum RENDER_THEME:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

.field public static final enum RULE:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;


# direct methods
.method static constructor <clinit>()V
    .registers 9

    new-instance v0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    const-string v1, "RENDER_THEME"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RENDER_THEME:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    new-instance v1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    const-string v3, "RENDERING_INSTRUCTION"

    const/4 v4, 0x1

    invoke-direct {v1, v3, v4}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RENDERING_INSTRUCTION:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    new-instance v3, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    const-string v5, "RULE"

    const/4 v6, 0x2

    invoke-direct {v3, v5, v6}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;-><init>(Ljava/lang/String;I)V

    sput-object v3, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RULE:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    new-instance v5, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    const-string v7, "RENDERING_STYLE"

    const/4 v8, 0x3

    invoke-direct {v5, v7, v8}, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;-><init>(Ljava/lang/String;I)V

    sput-object v5, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->RENDERING_STYLE:Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    const/4 v7, 0x4

    new-array v7, v7, [Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    aput-object v0, v7, v2

    aput-object v1, v7, v4

    aput-object v3, v7, v6

    aput-object v5, v7, v8

    sput-object v7, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->$VALUES:[Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

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

.method public static valueOf(Ljava/lang/String;)Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;
    .registers 2

    const-class v0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    return-object p0
.end method

.method public static values()[Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;
    .registers 1

    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->$VALUES:[Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    invoke-virtual {v0}, [Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lorg/mapsforge/map/rendertheme/rule/RenderThemeHandler$Element;

    return-object v0
.end method
