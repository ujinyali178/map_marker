.class final Landroidx/activity/OnBackPressedDispatcher$d;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/activity/a;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/activity/OnBackPressedDispatcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "d"
.end annotation


# instance fields
.field private final c:Landroidx/activity/l;

.field final synthetic d:Landroidx/activity/OnBackPressedDispatcher;


# direct methods
.method public constructor <init>(Landroidx/activity/OnBackPressedDispatcher;Landroidx/activity/l;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/activity/l;",
            ")V"
        }
    .end annotation

    const-string v0, "onBackPressedCallback"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Landroidx/activity/OnBackPressedDispatcher$d;->d:Landroidx/activity/OnBackPressedDispatcher;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p2, p0, Landroidx/activity/OnBackPressedDispatcher$d;->c:Landroidx/activity/l;

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 3

    iget-object v0, p0, Landroidx/activity/OnBackPressedDispatcher$d;->d:Landroidx/activity/OnBackPressedDispatcher;

    invoke-static {v0}, Landroidx/activity/OnBackPressedDispatcher;->a(Landroidx/activity/OnBackPressedDispatcher;)Lh2/e;

    move-result-object v0

    iget-object v1, p0, Landroidx/activity/OnBackPressedDispatcher$d;->c:Landroidx/activity/l;

    invoke-virtual {v0, v1}, Lh2/e;->remove(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/activity/OnBackPressedDispatcher$d;->c:Landroidx/activity/l;

    invoke-virtual {v0, p0}, Landroidx/activity/l;->e(Landroidx/activity/a;)V

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x21

    if-lt v0, v1, :cond_21

    iget-object v0, p0, Landroidx/activity/OnBackPressedDispatcher$d;->c:Landroidx/activity/l;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroidx/activity/l;->g(Lp2/a;)V

    iget-object v0, p0, Landroidx/activity/OnBackPressedDispatcher$d;->d:Landroidx/activity/OnBackPressedDispatcher;

    invoke-virtual {v0}, Landroidx/activity/OnBackPressedDispatcher;->g()V

    :cond_21
    return-void
.end method
