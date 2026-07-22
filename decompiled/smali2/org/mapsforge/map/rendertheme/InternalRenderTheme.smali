.class public final enum Lorg/mapsforge/map/rendertheme/InternalRenderTheme;
.super Ljava/lang/Enum;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/rendertheme/XmlRenderTheme;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lorg/mapsforge/map/rendertheme/InternalRenderTheme;",
        ">;",
        "Lorg/mapsforge/map/rendertheme/XmlRenderTheme;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lorg/mapsforge/map/rendertheme/InternalRenderTheme;

.field public static final enum DEFAULT:Lorg/mapsforge/map/rendertheme/InternalRenderTheme;

.field public static final enum OSMARENDER:Lorg/mapsforge/map/rendertheme/InternalRenderTheme;


# instance fields
.field private final path:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 6

    new-instance v0, Lorg/mapsforge/map/rendertheme/InternalRenderTheme;

    const-string v1, "DEFAULT"

    const/4 v2, 0x0

    const-string v3, "/assets/mapsforge/default.xml"

    invoke-direct {v0, v1, v2, v3}, Lorg/mapsforge/map/rendertheme/InternalRenderTheme;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lorg/mapsforge/map/rendertheme/InternalRenderTheme;->DEFAULT:Lorg/mapsforge/map/rendertheme/InternalRenderTheme;

    new-instance v1, Lorg/mapsforge/map/rendertheme/InternalRenderTheme;

    const-string v3, "OSMARENDER"

    const/4 v4, 0x1

    const-string v5, "/assets/mapsforge/osmarender.xml"

    invoke-direct {v1, v3, v4, v5}, Lorg/mapsforge/map/rendertheme/InternalRenderTheme;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v1, Lorg/mapsforge/map/rendertheme/InternalRenderTheme;->OSMARENDER:Lorg/mapsforge/map/rendertheme/InternalRenderTheme;

    const/4 v3, 0x2

    new-array v3, v3, [Lorg/mapsforge/map/rendertheme/InternalRenderTheme;

    aput-object v0, v3, v2

    aput-object v1, v3, v4

    sput-object v3, Lorg/mapsforge/map/rendertheme/InternalRenderTheme;->$VALUES:[Lorg/mapsforge/map/rendertheme/InternalRenderTheme;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput-object p3, p0, Lorg/mapsforge/map/rendertheme/InternalRenderTheme;->path:Ljava/lang/String;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lorg/mapsforge/map/rendertheme/InternalRenderTheme;
    .registers 2

    const-class v0, Lorg/mapsforge/map/rendertheme/InternalRenderTheme;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lorg/mapsforge/map/rendertheme/InternalRenderTheme;

    return-object p0
.end method

.method public static values()[Lorg/mapsforge/map/rendertheme/InternalRenderTheme;
    .registers 1

    sget-object v0, Lorg/mapsforge/map/rendertheme/InternalRenderTheme;->$VALUES:[Lorg/mapsforge/map/rendertheme/InternalRenderTheme;

    invoke-virtual {v0}, [Lorg/mapsforge/map/rendertheme/InternalRenderTheme;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lorg/mapsforge/map/rendertheme/InternalRenderTheme;

    return-object v0
.end method


# virtual methods
.method public getMenuCallback()Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;
    .registers 2

    const/4 v0, 0x0

    return-object v0
.end method

.method public getRelativePathPrefix()Ljava/lang/String;
    .registers 2

    const-string v0, "/assets/"

    return-object v0
.end method

.method public getRenderThemeAsStream()Ljava/io/InputStream;
    .registers 3

    const-class v0, Lorg/mapsforge/map/rendertheme/InternalRenderTheme;

    iget-object v1, p0, Lorg/mapsforge/map/rendertheme/InternalRenderTheme;->path:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/Class;->getResourceAsStream(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public setMenuCallback(Lorg/mapsforge/map/rendertheme/XmlRenderThemeMenuCallback;)V
    .registers 2

    return-void
.end method
