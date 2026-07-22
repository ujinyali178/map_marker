.class abstract Lc0/g$l;
.super Lc0/g$i0;
.source "SourceFile"

# interfaces
.implements Lc0/g$n;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x408
    name = "l"
.end annotation


# instance fields
.field n:Landroid/graphics/Matrix;


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lc0/g$i0;-><init>()V

    return-void
.end method


# virtual methods
.method public j(Landroid/graphics/Matrix;)V
    .registers 2

    iput-object p1, p0, Lc0/g$l;->n:Landroid/graphics/Matrix;

    return-void
.end method
