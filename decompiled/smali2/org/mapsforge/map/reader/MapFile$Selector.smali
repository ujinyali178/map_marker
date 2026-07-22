.class final enum Lorg/mapsforge/map/reader/MapFile$Selector;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/reader/MapFile;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "Selector"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lorg/mapsforge/map/reader/MapFile$Selector;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lorg/mapsforge/map/reader/MapFile$Selector;

.field public static final enum ALL:Lorg/mapsforge/map/reader/MapFile$Selector;

.field public static final enum LABELS:Lorg/mapsforge/map/reader/MapFile$Selector;

.field public static final enum POIS:Lorg/mapsforge/map/reader/MapFile$Selector;


# direct methods
.method static constructor <clinit>()V
    .registers 7

    new-instance v0, Lorg/mapsforge/map/reader/MapFile$Selector;

    const-string v1, "ALL"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/map/reader/MapFile$Selector;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lorg/mapsforge/map/reader/MapFile$Selector;->ALL:Lorg/mapsforge/map/reader/MapFile$Selector;

    new-instance v1, Lorg/mapsforge/map/reader/MapFile$Selector;

    const-string v3, "POIS"

    const/4 v4, 0x1

    invoke-direct {v1, v3, v4}, Lorg/mapsforge/map/reader/MapFile$Selector;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lorg/mapsforge/map/reader/MapFile$Selector;->POIS:Lorg/mapsforge/map/reader/MapFile$Selector;

    new-instance v3, Lorg/mapsforge/map/reader/MapFile$Selector;

    const-string v5, "LABELS"

    const/4 v6, 0x2

    invoke-direct {v3, v5, v6}, Lorg/mapsforge/map/reader/MapFile$Selector;-><init>(Ljava/lang/String;I)V

    sput-object v3, Lorg/mapsforge/map/reader/MapFile$Selector;->LABELS:Lorg/mapsforge/map/reader/MapFile$Selector;

    const/4 v5, 0x3

    new-array v5, v5, [Lorg/mapsforge/map/reader/MapFile$Selector;

    aput-object v0, v5, v2

    aput-object v1, v5, v4

    aput-object v3, v5, v6

    sput-object v5, Lorg/mapsforge/map/reader/MapFile$Selector;->$VALUES:[Lorg/mapsforge/map/reader/MapFile$Selector;

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

.method public static valueOf(Ljava/lang/String;)Lorg/mapsforge/map/reader/MapFile$Selector;
    .registers 2

    const-class v0, Lorg/mapsforge/map/reader/MapFile$Selector;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lorg/mapsforge/map/reader/MapFile$Selector;

    return-object p0
.end method

.method public static values()[Lorg/mapsforge/map/reader/MapFile$Selector;
    .registers 1

    sget-object v0, Lorg/mapsforge/map/reader/MapFile$Selector;->$VALUES:[Lorg/mapsforge/map/reader/MapFile$Selector;

    invoke-virtual {v0}, [Lorg/mapsforge/map/reader/MapFile$Selector;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lorg/mapsforge/map/reader/MapFile$Selector;

    return-object v0
.end method
