.class final Landroidx/loader/content/a$a;
.super Landroidx/loader/content/c;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/loader/content/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/loader/content/c<",
        "TD;>;",
        "Ljava/lang/Runnable;"
    }
.end annotation


# instance fields
.field i:Z

.field final synthetic j:Landroidx/loader/content/a;


# direct methods
.method constructor <init>(Landroidx/loader/content/a;)V
    .registers 2

    iput-object p1, p0, Landroidx/loader/content/a$a;->j:Landroidx/loader/content/a;

    invoke-direct {p0}, Landroidx/loader/content/c;-><init>()V

    return-void
.end method


# virtual methods
.method protected b()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TD;"
        }
    .end annotation

    iget-object v0, p0, Landroidx/loader/content/a$a;->j:Landroidx/loader/content/a;

    invoke-virtual {v0}, Landroidx/loader/content/a;->onLoadInBackground()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method protected g(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/loader/content/a$a;->j:Landroidx/loader/content/a;

    invoke-virtual {v0, p0, p1}, Landroidx/loader/content/a;->dispatchOnCancelled(Landroidx/loader/content/a$a;Ljava/lang/Object;)V

    return-void
.end method

.method protected h(Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/loader/content/a$a;->j:Landroidx/loader/content/a;

    invoke-virtual {v0, p0, p1}, Landroidx/loader/content/a;->dispatchOnLoadComplete(Landroidx/loader/content/a$a;Ljava/lang/Object;)V

    return-void
.end method

.method public run()V
    .registers 2

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/loader/content/a$a;->i:Z

    iget-object v0, p0, Landroidx/loader/content/a$a;->j:Landroidx/loader/content/a;

    invoke-virtual {v0}, Landroidx/loader/content/a;->executePendingTask()V

    return-void
.end method
