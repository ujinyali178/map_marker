.class Lc0/g$y;
.super Lc0/g$r0;
.source "SourceFile"

# interfaces
.implements Lc0/g$t;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "y"
.end annotation


# instance fields
.field q:Ljava/lang/Boolean;

.field r:Ljava/lang/Boolean;

.field s:Landroid/graphics/Matrix;

.field t:Lc0/g$p;

.field u:Lc0/g$p;

.field v:Lc0/g$p;

.field w:Lc0/g$p;

.field x:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lc0/g$r0;-><init>()V

    return-void
.end method


# virtual methods
.method n()Ljava/lang/String;
    .registers 2

    const-string v0, "pattern"

    return-object v0
.end method
