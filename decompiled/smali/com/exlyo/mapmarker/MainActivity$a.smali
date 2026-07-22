.class Lcom/exlyo/mapmarker/MainActivity$a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lu1/l$c;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/exlyo/mapmarker/MainActivity;->g(Lio/flutter/embedding/engine/a;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic c:Lcom/exlyo/mapmarker/MainActivity;


# direct methods
.method constructor <init>(Lcom/exlyo/mapmarker/MainActivity;)V
    .registers 2

    iput-object p1, p0, Lcom/exlyo/mapmarker/MainActivity$a;->c:Lcom/exlyo/mapmarker/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public n(Lu1/k;Lu1/l$d;)V
    .registers 5

    iget-object v0, p0, Lcom/exlyo/mapmarker/MainActivity$a;->c:Lcom/exlyo/mapmarker/MainActivity;

    iget-object v1, v0, Lcom/exlyo/mapmarker/MainActivity;->i:Lk0/b;

    if-nez v1, :cond_d

    new-instance v1, Lk0/b;

    invoke-direct {v1, v0}, Lk0/b;-><init>(Landroid/app/Activity;)V

    iput-object v1, v0, Lcom/exlyo/mapmarker/MainActivity;->i:Lk0/b;

    :cond_d
    iget-object v0, p0, Lcom/exlyo/mapmarker/MainActivity$a;->c:Lcom/exlyo/mapmarker/MainActivity;

    iget-object v0, v0, Lcom/exlyo/mapmarker/MainActivity;->i:Lk0/b;

    invoke-virtual {v0, p1, p2}, Lk0/b;->i(Lu1/k;Lu1/l$d;)V

    return-void
.end method
