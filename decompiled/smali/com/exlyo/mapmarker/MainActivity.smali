.class public Lcom/exlyo/mapmarker/MainActivity;
.super Lio/flutter/embedding/android/FlutterActivity;
.source "SourceFile"


# instance fields
.field i:Lk0/b;

.field private final j:Lh0/a;

.field private final k:Li0/a;

.field private final l:Lf0/a;

.field private final m:Lg0/a;

.field private final n:Lj0/a;

.field private final o:Le0/a;


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Lio/flutter/embedding/android/FlutterActivity;-><init>()V

    new-instance v0, Lh0/a;

    invoke-direct {v0, p0}, Lh0/a;-><init>(Lio/flutter/embedding/android/FlutterActivity;)V

    iput-object v0, p0, Lcom/exlyo/mapmarker/MainActivity;->j:Lh0/a;

    new-instance v0, Li0/a;

    invoke-direct {v0, p0}, Li0/a;-><init>(Lio/flutter/embedding/android/FlutterActivity;)V

    iput-object v0, p0, Lcom/exlyo/mapmarker/MainActivity;->k:Li0/a;

    new-instance v0, Lf0/a;

    invoke-direct {v0, p0}, Lf0/a;-><init>(Lio/flutter/embedding/android/FlutterActivity;)V

    iput-object v0, p0, Lcom/exlyo/mapmarker/MainActivity;->l:Lf0/a;

    new-instance v0, Lg0/a;

    invoke-direct {v0, p0}, Lg0/a;-><init>(Lio/flutter/embedding/android/FlutterActivity;)V

    iput-object v0, p0, Lcom/exlyo/mapmarker/MainActivity;->m:Lg0/a;

    new-instance v0, Lj0/a;

    invoke-direct {v0, p0}, Lj0/a;-><init>(Lio/flutter/embedding/android/FlutterActivity;)V

    iput-object v0, p0, Lcom/exlyo/mapmarker/MainActivity;->n:Lj0/a;

    new-instance v0, Le0/a;

    invoke-direct {v0, p0}, Le0/a;-><init>(Lio/flutter/embedding/android/FlutterActivity;)V

    iput-object v0, p0, Lcom/exlyo/mapmarker/MainActivity;->o:Le0/a;

    return-void
.end method

.method private U(Landroid/content/Intent;)V
    .registers 3

    iget-object v0, p0, Lcom/exlyo/mapmarker/MainActivity;->o:Le0/a;

    invoke-virtual {v0, p1}, Le0/a;->c(Landroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_9

    return-void

    :cond_9
    iget-object v0, p0, Lcom/exlyo/mapmarker/MainActivity;->j:Lh0/a;

    invoke-virtual {v0, p1}, Lh0/a;->l(Landroid/content/Intent;)V

    return-void
.end method


# virtual methods
.method public g(Lio/flutter/embedding/engine/a;)V
    .registers 5

    invoke-super {p0, p1}, Lio/flutter/embedding/android/FlutterActivity;->g(Lio/flutter/embedding/engine/a;)V

    new-instance v0, Lu1/l;

    invoke-virtual {p1}, Lio/flutter/embedding/engine/a;->k()Li1/a;

    move-result-object v1

    invoke-virtual {v1}, Li1/a;->k()Lu1/d;

    move-result-object v1

    const-string v2, "com.exlyo.mapmarker/offline_maps"

    invoke-direct {v0, v1, v2}, Lu1/l;-><init>(Lu1/d;Ljava/lang/String;)V

    new-instance v1, Lcom/exlyo/mapmarker/MainActivity$a;

    invoke-direct {v1, p0}, Lcom/exlyo/mapmarker/MainActivity$a;-><init>(Lcom/exlyo/mapmarker/MainActivity;)V

    invoke-virtual {v0, v1}, Lu1/l;->e(Lu1/l$c;)V

    iget-object v0, p0, Lcom/exlyo/mapmarker/MainActivity;->j:Lh0/a;

    invoke-virtual {v0, p1}, Lh0/a;->d(Lio/flutter/embedding/engine/a;)V

    iget-object v0, p0, Lcom/exlyo/mapmarker/MainActivity;->k:Li0/a;

    invoke-virtual {v0, p1}, Li0/a;->b(Lio/flutter/embedding/engine/a;)V

    iget-object v0, p0, Lcom/exlyo/mapmarker/MainActivity;->l:Lf0/a;

    invoke-virtual {v0, p1}, Lf0/a;->h(Lio/flutter/embedding/engine/a;)V

    iget-object v0, p0, Lcom/exlyo/mapmarker/MainActivity;->m:Lg0/a;

    invoke-virtual {v0, p1}, Lg0/a;->c(Lio/flutter/embedding/engine/a;)V

    iget-object v0, p0, Lcom/exlyo/mapmarker/MainActivity;->n:Lj0/a;

    invoke-virtual {v0, p1}, Lj0/a;->c(Lio/flutter/embedding/engine/a;)V

    iget-object v0, p0, Lcom/exlyo/mapmarker/MainActivity;->o:Le0/a;

    invoke-virtual {v0, p1}, Le0/a;->b(Lio/flutter/embedding/engine/a;)V

    return-void
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .registers 5

    invoke-super {p0, p1, p2, p3}, Lio/flutter/embedding/android/FlutterActivity;->onActivityResult(IILandroid/content/Intent;)V

    iget-object v0, p0, Lcom/exlyo/mapmarker/MainActivity;->l:Lf0/a;

    invoke-virtual {v0, p1, p2, p3}, Lf0/a;->l(IILandroid/content/Intent;)V

    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .registers 2

    invoke-super {p0, p1}, Lio/flutter/embedding/android/FlutterActivity;->onCreate(Landroid/os/Bundle;)V

    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object p1

    invoke-direct {p0, p1}, Lcom/exlyo/mapmarker/MainActivity;->U(Landroid/content/Intent;)V

    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .registers 2

    invoke-super {p0, p1}, Lio/flutter/embedding/android/FlutterActivity;->onNewIntent(Landroid/content/Intent;)V

    invoke-direct {p0, p1}, Lcom/exlyo/mapmarker/MainActivity;->U(Landroid/content/Intent;)V

    return-void
.end method

.method protected onResume()V
    .registers 2

    invoke-super {p0}, Lio/flutter/embedding/android/FlutterActivity;->onResume()V

    iget-object v0, p0, Lcom/exlyo/mapmarker/MainActivity;->o:Le0/a;

    invoke-virtual {v0}, Le0/a;->d()V

    return-void
.end method
