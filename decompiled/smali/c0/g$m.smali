.class Lc0/g$m;
.super Lc0/g$h0;
.source "SourceFile"

# interfaces
.implements Lc0/g$n;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "m"
.end annotation


# instance fields
.field o:Landroid/graphics/Matrix;


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lc0/g$h0;-><init>()V

    return-void
.end method


# virtual methods
.method public j(Landroid/graphics/Matrix;)V
    .registers 2

    iput-object p1, p0, Lc0/g$m;->o:Landroid/graphics/Matrix;

    return-void
.end method

.method n()Ljava/lang/String;
    .registers 2

    const-string v0, "group"

    return-object v0
.end method
