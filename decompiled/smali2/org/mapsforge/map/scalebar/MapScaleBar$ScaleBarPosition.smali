.class public final enum Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/scalebar/MapScaleBar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ScaleBarPosition"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

.field public static final enum BOTTOM_CENTER:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

.field public static final enum BOTTOM_LEFT:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

.field public static final enum BOTTOM_RIGHT:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

.field public static final enum TOP_CENTER:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

.field public static final enum TOP_LEFT:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

.field public static final enum TOP_RIGHT:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;


# direct methods
.method static constructor <clinit>()V
    .registers 13

    new-instance v0, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    const-string v1, "BOTTOM_CENTER"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;->BOTTOM_CENTER:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    new-instance v1, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    const-string v3, "BOTTOM_LEFT"

    const/4 v4, 0x1

    invoke-direct {v1, v3, v4}, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;->BOTTOM_LEFT:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    new-instance v3, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    const-string v5, "BOTTOM_RIGHT"

    const/4 v6, 0x2

    invoke-direct {v3, v5, v6}, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;-><init>(Ljava/lang/String;I)V

    sput-object v3, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;->BOTTOM_RIGHT:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    new-instance v5, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    const-string v7, "TOP_CENTER"

    const/4 v8, 0x3

    invoke-direct {v5, v7, v8}, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;-><init>(Ljava/lang/String;I)V

    sput-object v5, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;->TOP_CENTER:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    new-instance v7, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    const-string v9, "TOP_LEFT"

    const/4 v10, 0x4

    invoke-direct {v7, v9, v10}, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;-><init>(Ljava/lang/String;I)V

    sput-object v7, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;->TOP_LEFT:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    new-instance v9, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    const-string v11, "TOP_RIGHT"

    const/4 v12, 0x5

    invoke-direct {v9, v11, v12}, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;-><init>(Ljava/lang/String;I)V

    sput-object v9, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;->TOP_RIGHT:Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    const/4 v11, 0x6

    new-array v11, v11, [Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    aput-object v0, v11, v2

    aput-object v1, v11, v4

    aput-object v3, v11, v6

    aput-object v5, v11, v8

    aput-object v7, v11, v10

    aput-object v9, v11, v12

    sput-object v11, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;->$VALUES:[Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

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

.method public static valueOf(Ljava/lang/String;)Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;
    .registers 2

    const-class v0, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    return-object p0
.end method

.method public static values()[Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;
    .registers 1

    sget-object v0, Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;->$VALUES:[Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    invoke-virtual {v0}, [Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lorg/mapsforge/map/scalebar/MapScaleBar$ScaleBarPosition;

    return-object v0
.end method
