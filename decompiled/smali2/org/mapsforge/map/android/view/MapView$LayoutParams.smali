.class public Lorg/mapsforge/map/android/view/MapView$LayoutParams;
.super Landroid/view/ViewGroup$LayoutParams;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/android/view/MapView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LayoutParams"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;
    }
.end annotation


# instance fields
.field public alignment:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

.field public latLong:Lorg/mapsforge/core/model/LatLong;


# direct methods
.method public constructor <init>(IILorg/mapsforge/core/model/LatLong;Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;)V
    .registers 5

    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    iput-object p3, p0, Lorg/mapsforge/map/android/view/MapView$LayoutParams;->latLong:Lorg/mapsforge/core/model/LatLong;

    iput-object p4, p0, Lorg/mapsforge/map/android/view/MapView$LayoutParams;->alignment:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 3

    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup$LayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    sget-object p1, Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;->BOTTOM_CENTER:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    iput-object p1, p0, Lorg/mapsforge/map/android/view/MapView$LayoutParams;->alignment:Lorg/mapsforge/map/android/view/MapView$LayoutParams$Alignment;

    return-void
.end method

.method public constructor <init>(Landroid/view/ViewGroup$LayoutParams;)V
    .registers 2

    invoke-direct {p0, p1}, Landroid/view/ViewGroup$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    return-void
.end method
