.class Lc0/g$z;
.super Lc0/g$l;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "z"
.end annotation


# instance fields
.field o:[F


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lc0/g$l;-><init>()V

    return-void
.end method


# virtual methods
.method n()Ljava/lang/String;
    .registers 2

    const-string v0, "polyline"

    return-object v0
.end method
