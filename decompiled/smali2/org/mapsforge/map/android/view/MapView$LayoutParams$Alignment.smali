.class public final enum Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/android/view/MapView$LayoutParams;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Alignment"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

.field public static final enum BOTTOM_CENTER:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

.field public static final enum BOTTOM_LEFT:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

.field public static final enum BOTTOM_RIGHT:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

.field public static final enum CENTER:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

.field public static final enum CENTER_LEFT:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

.field public static final enum CENTER_RIGHT:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

.field public static final enum TOP_CENTER:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

.field public static final enum TOP_LEFT:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

.field public static final enum TOP_RIGHT:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;


# direct methods
.method static constructor <clinit>()V
    .registers 16

    new-instance v0, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    const-string v1, "TOP_LEFT"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;->TOP_LEFT:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    new-instance v1, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    const-string v3, "TOP_CENTER"

    const/4 v4, 0x1

    invoke-direct {v1, v3, v4}, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;->TOP_CENTER:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    new-instance v3, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    const-string v5, "TOP_RIGHT"

    const/4 v6, 0x2

    invoke-direct {v3, v5, v6}, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;-><init>(Ljava/lang/String;I)V

    sput-object v3, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;->TOP_RIGHT:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    new-instance v5, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    const-string v7, "CENTER_LEFT"

    const/4 v8, 0x3

    invoke-direct {v5, v7, v8}, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;-><init>(Ljava/lang/String;I)V

    sput-object v5, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;->CENTER_LEFT:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    new-instance v7, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    const-string v9, "CENTER"

    const/4 v10, 0x4

    invoke-direct {v7, v9, v10}, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;-><init>(Ljava/lang/String;I)V

    sput-object v7, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;->CENTER:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    new-instance v9, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    const-string v11, "CENTER_RIGHT"

    const/4 v12, 0x5

    invoke-direct {v9, v11, v12}, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;-><init>(Ljava/lang/String;I)V

    sput-object v9, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;->CENTER_RIGHT:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    new-instance v11, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    const-string v13, "BOTTOM_LEFT"

    const/4 v14, 0x6

    invoke-direct {v11, v13, v14}, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;-><init>(Ljava/lang/String;I)V

    sput-object v11, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;->BOTTOM_LEFT:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    new-instance v13, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    const-string v15, "BOTTOM_CENTER"

    const/4 v14, 0x7

    invoke-direct {v13, v15, v14}, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;-><init>(Ljava/lang/String;I)V

    sput-object v13, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;->BOTTOM_CENTER:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    new-instance v15, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    const-string v14, "BOTTOM_RIGHT"

    const/16 v12, 0x8

    invoke-direct {v15, v14, v12}, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;-><init>(Ljava/lang/String;I)V

    sput-object v15, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;->BOTTOM_RIGHT:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    const/16 v14, 0x9

    new-array v14, v14, [Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    aput-object v0, v14, v2

    aput-object v1, v14, v4

    aput-object v3, v14, v6

    aput-object v5, v14, v8

    aput-object v7, v14, v10

    const/4 v0, 0x5

    aput-object v9, v14, v0

    const/4 v0, 0x6

    aput-object v11, v14, v0

    const/4 v0, 0x7

    aput-object v13, v14, v0

    aput-object v15, v14, v12

    sput-object v14, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;->$VALUES:[Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

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

.method public static valueOf(Ljava/lang/String;)Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;
    .registers 2

    const-class v0, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    return-object p0
.end method

.method public static values()[Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;
    .registers 1

    sget-object v0, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;->$VALUES:[Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    invoke-virtual {v0}, [Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    return-object v0
.end method
