.class Lc0/g$w0;
.super Lc0/g$a1;
.source "SourceFile"

# interfaces
.implements Lc0/g$b1;
.implements Lc0/g$n;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "w0"
.end annotation


# instance fields
.field s:Landroid/graphics/Matrix;


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lc0/g$a1;-><init>()V

    return-void
.end method


# virtual methods
.method public j(Landroid/graphics/Matrix;)V
    .registers 2

    iput-object p1, p0, Lc0/g$w0;->s:Landroid/graphics/Matrix;

    return-void
.end method

.method n()Ljava/lang/String;
    .registers 2

    const-string v0, "text"

    return-object v0
.end method
