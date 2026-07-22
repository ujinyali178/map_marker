.class Lc0/g$z0;
.super Lc0/g$y0;
.source "SourceFile"

# interfaces
.implements Lc0/g$x0;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "z0"
.end annotation


# instance fields
.field o:Ljava/lang/String;

.field p:Lc0/g$p;

.field private q:Lc0/g$b1;


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lc0/g$y0;-><init>()V

    return-void
.end method


# virtual methods
.method public f()Lc0/g$b1;
    .registers 2

    iget-object v0, p0, Lc0/g$z0;->q:Lc0/g$b1;

    return-object v0
.end method

.method n()Ljava/lang/String;
    .registers 2

    const-string v0, "textPath"

    return-object v0
.end method

.method public o(Lc0/g$b1;)V
    .registers 2

    iput-object p1, p0, Lc0/g$z0;->q:Lc0/g$b1;

    return-void
.end method
