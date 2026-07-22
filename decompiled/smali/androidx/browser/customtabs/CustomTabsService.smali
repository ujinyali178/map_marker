.class public abstract Landroidx/browser/customtabs/CustomTabsService;
.super Landroid/app/Service;
.source "SourceFile"


# instance fields
.field final c:Landroidx/collection/g;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/collection/g<",
            "Landroid/os/IBinder;",
            "Landroid/os/IBinder$DeathRecipient;",
            ">;"
        }
    .end annotation
.end field

.field private d:Landroid/support/customtabs/ICustomTabsService$Stub;


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    new-instance v0, Landroidx/collection/g;

    invoke-direct {v0}, Landroidx/collection/g;-><init>()V

    iput-object v0, p0, Landroidx/browser/customtabs/CustomTabsService;->c:Landroidx/collection/g;

    new-instance v0, Landroidx/browser/customtabs/CustomTabsService$a;

    invoke-direct {v0, p0}, Landroidx/browser/customtabs/CustomTabsService$a;-><init>(Landroidx/browser/customtabs/CustomTabsService;)V

    iput-object v0, p0, Landroidx/browser/customtabs/CustomTabsService;->d:Landroid/support/customtabs/ICustomTabsService$Stub;

    return-void
.end method


# virtual methods
.method protected a(Landroidx/browser/customtabs/f;)Z
    .registers 5

    const/4 v0, 0x0

    :try_start_1
    iget-object v1, p0, Landroidx/browser/customtabs/CustomTabsService;->c:Landroidx/collection/g;

    monitor-enter v1
    :try_end_4
    .catch Ljava/util/NoSuchElementException; {:try_start_1 .. :try_end_4} :catch_22

    :try_start_4
    invoke-virtual {p1}, Landroidx/browser/customtabs/f;->a()Landroid/os/IBinder;

    move-result-object p1

    if-nez p1, :cond_c

    monitor-exit v1

    return v0

    :cond_c
    iget-object v2, p0, Landroidx/browser/customtabs/CustomTabsService;->c:Landroidx/collection/g;

    invoke-virtual {v2, p1}, Landroidx/collection/g;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/IBinder$DeathRecipient;

    invoke-interface {p1, v2, v0}, Landroid/os/IBinder;->unlinkToDeath(Landroid/os/IBinder$DeathRecipient;I)Z

    iget-object v2, p0, Landroidx/browser/customtabs/CustomTabsService;->c:Landroidx/collection/g;

    invoke-virtual {v2, p1}, Landroidx/collection/g;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    monitor-exit v1

    const/4 p1, 0x1

    return p1

    :catchall_1f
    move-exception p1

    monitor-exit v1
    :try_end_21
    .catchall {:try_start_4 .. :try_end_21} :catchall_1f

    :try_start_21
    throw p1
    :try_end_22
    .catch Ljava/util/NoSuchElementException; {:try_start_21 .. :try_end_22} :catch_22

    :catch_22
    return v0
.end method

.method protected abstract b(Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
.end method

.method protected abstract c(Landroidx/browser/customtabs/f;Landroid/net/Uri;Landroid/os/Bundle;Ljava/util/List;)Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/browser/customtabs/f;",
            "Landroid/net/Uri;",
            "Landroid/os/Bundle;",
            "Ljava/util/List<",
            "Landroid/os/Bundle;",
            ">;)Z"
        }
    .end annotation
.end method

.method protected abstract d(Landroidx/browser/customtabs/f;)Z
.end method

.method protected abstract e(Landroidx/browser/customtabs/f;Ljava/lang/String;Landroid/os/Bundle;)I
.end method

.method protected abstract f(Landroidx/browser/customtabs/f;Landroid/net/Uri;ILandroid/os/Bundle;)Z
.end method

.method protected abstract g(Landroidx/browser/customtabs/f;Landroid/net/Uri;)Z
.end method

.method protected abstract h(Landroidx/browser/customtabs/f;Landroid/os/Bundle;)Z
.end method

.method protected abstract i(Landroidx/browser/customtabs/f;ILandroid/net/Uri;Landroid/os/Bundle;)Z
.end method

.method protected abstract j(J)Z
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .registers 2

    iget-object p1, p0, Landroidx/browser/customtabs/CustomTabsService;->d:Landroid/support/customtabs/ICustomTabsService$Stub;

    return-object p1
.end method
