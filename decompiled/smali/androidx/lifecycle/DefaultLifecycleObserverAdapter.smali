.class public final Landroidx/lifecycle/DefaultLifecycleObserverAdapter;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/lifecycle/g;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/lifecycle/DefaultLifecycleObserverAdapter$a;
    }
.end annotation


# instance fields
.field private final c:Landroidx/lifecycle/DefaultLifecycleObserver;

.field private final d:Landroidx/lifecycle/g;


# direct methods
.method public constructor <init>(Landroidx/lifecycle/DefaultLifecycleObserver;Landroidx/lifecycle/g;)V
    .registers 4

    const-string v0, "defaultLifecycleObserver"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/lifecycle/DefaultLifecycleObserverAdapter;->c:Landroidx/lifecycle/DefaultLifecycleObserver;

    iput-object p2, p0, Landroidx/lifecycle/DefaultLifecycleObserverAdapter;->d:Landroidx/lifecycle/g;

    return-void
.end method


# virtual methods
.method public e(Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V
    .registers 5

    const-string v0, "source"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "event"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    sget-object v0, Landroidx/lifecycle/DefaultLifecycleObserverAdapter$a;->a:[I

    invoke-virtual {p2}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_4a

    goto :goto_41

    :pswitch_16
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "ON_ANY must not been send by anybody"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :pswitch_1e
    iget-object v0, p0, Landroidx/lifecycle/DefaultLifecycleObserverAdapter;->c:Landroidx/lifecycle/DefaultLifecycleObserver;

    invoke-interface {v0, p1}, Landroidx/lifecycle/DefaultLifecycleObserver;->m(Landroidx/lifecycle/i;)V

    goto :goto_41

    :pswitch_24
    iget-object v0, p0, Landroidx/lifecycle/DefaultLifecycleObserverAdapter;->c:Landroidx/lifecycle/DefaultLifecycleObserver;

    invoke-interface {v0, p1}, Landroidx/lifecycle/DefaultLifecycleObserver;->i(Landroidx/lifecycle/i;)V

    goto :goto_41

    :pswitch_2a
    iget-object v0, p0, Landroidx/lifecycle/DefaultLifecycleObserverAdapter;->c:Landroidx/lifecycle/DefaultLifecycleObserver;

    invoke-interface {v0, p1}, Landroidx/lifecycle/DefaultLifecycleObserver;->f(Landroidx/lifecycle/i;)V

    goto :goto_41

    :pswitch_30
    iget-object v0, p0, Landroidx/lifecycle/DefaultLifecycleObserverAdapter;->c:Landroidx/lifecycle/DefaultLifecycleObserver;

    invoke-interface {v0, p1}, Landroidx/lifecycle/DefaultLifecycleObserver;->c(Landroidx/lifecycle/i;)V

    goto :goto_41

    :pswitch_36
    iget-object v0, p0, Landroidx/lifecycle/DefaultLifecycleObserverAdapter;->c:Landroidx/lifecycle/DefaultLifecycleObserver;

    invoke-interface {v0, p1}, Landroidx/lifecycle/DefaultLifecycleObserver;->q(Landroidx/lifecycle/i;)V

    goto :goto_41

    :pswitch_3c
    iget-object v0, p0, Landroidx/lifecycle/DefaultLifecycleObserverAdapter;->c:Landroidx/lifecycle/DefaultLifecycleObserver;

    invoke-interface {v0, p1}, Landroidx/lifecycle/DefaultLifecycleObserver;->d(Landroidx/lifecycle/i;)V

    :goto_41
    iget-object v0, p0, Landroidx/lifecycle/DefaultLifecycleObserverAdapter;->d:Landroidx/lifecycle/g;

    if-eqz v0, :cond_48

    invoke-interface {v0, p1, p2}, Landroidx/lifecycle/g;->e(Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V

    :cond_48
    return-void

    nop

    :pswitch_data_4a
    .packed-switch 0x1
        :pswitch_3c
        :pswitch_36
        :pswitch_30
        :pswitch_2a
        :pswitch_24
        :pswitch_1e
        :pswitch_16
    .end packed-switch
.end method
