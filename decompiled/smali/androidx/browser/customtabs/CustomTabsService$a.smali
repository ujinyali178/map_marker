.class Landroidx/browser/customtabs/CustomTabsService$a;
.super Landroid/support/customtabs/ICustomTabsService$Stub;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/browser/customtabs/CustomTabsService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic c:Landroidx/browser/customtabs/CustomTabsService;


# direct methods
.method constructor <init>(Landroidx/browser/customtabs/CustomTabsService;)V
    .registers 2

    iput-object p1, p0, Landroidx/browser/customtabs/CustomTabsService$a;->c:Landroidx/browser/customtabs/CustomTabsService;

    invoke-direct {p0}, Landroid/support/customtabs/ICustomTabsService$Stub;-><init>()V

    return-void
.end method

.method public static synthetic b(Landroidx/browser/customtabs/CustomTabsService$a;Landroidx/browser/customtabs/f;)V
    .registers 2

    invoke-direct {p0, p1}, Landroidx/browser/customtabs/CustomTabsService$a;->d(Landroidx/browser/customtabs/f;)V

    return-void
.end method

.method private c(Landroid/os/Bundle;)Landroid/app/PendingIntent;
    .registers 4

    if-nez p1, :cond_4

    const/4 p1, 0x0

    return-object p1

    :cond_4
    const-string v0, "android.support.customtabs.extra.SESSION_ID"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/app/PendingIntent;

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    return-object v1
.end method

.method private synthetic d(Landroidx/browser/customtabs/f;)V
    .registers 3

    iget-object v0, p0, Landroidx/browser/customtabs/CustomTabsService$a;->c:Landroidx/browser/customtabs/CustomTabsService;

    invoke-virtual {v0, p1}, Landroidx/browser/customtabs/CustomTabsService;->a(Landroidx/browser/customtabs/f;)Z

    return-void
.end method

.method private e(Landroid/support/customtabs/ICustomTabsCallback;Landroid/app/PendingIntent;)Z
    .registers 7

    new-instance v0, Landroidx/browser/customtabs/f;

    invoke-direct {v0, p1, p2}, Landroidx/browser/customtabs/f;-><init>(Landroid/support/customtabs/ICustomTabsCallback;Landroid/app/PendingIntent;)V

    const/4 p2, 0x0

    :try_start_6
    new-instance v1, Landroidx/browser/customtabs/e;

    invoke-direct {v1, p0, v0}, Landroidx/browser/customtabs/e;-><init>(Landroidx/browser/customtabs/CustomTabsService$a;Landroidx/browser/customtabs/f;)V

    iget-object v2, p0, Landroidx/browser/customtabs/CustomTabsService$a;->c:Landroidx/browser/customtabs/CustomTabsService;

    iget-object v2, v2, Landroidx/browser/customtabs/CustomTabsService;->c:Landroidx/collection/g;

    monitor-enter v2
    :try_end_10
    .catch Landroid/os/RemoteException; {:try_start_6 .. :try_end_10} :catch_2d

    :try_start_10
    invoke-interface {p1}, Landroid/os/IInterface;->asBinder()Landroid/os/IBinder;

    move-result-object v3

    invoke-interface {v3, v1, p2}, Landroid/os/IBinder;->linkToDeath(Landroid/os/IBinder$DeathRecipient;I)V

    iget-object v3, p0, Landroidx/browser/customtabs/CustomTabsService$a;->c:Landroidx/browser/customtabs/CustomTabsService;

    iget-object v3, v3, Landroidx/browser/customtabs/CustomTabsService;->c:Landroidx/collection/g;

    invoke-interface {p1}, Landroid/os/IInterface;->asBinder()Landroid/os/IBinder;

    move-result-object p1

    invoke-virtual {v3, p1, v1}, Landroidx/collection/g;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    monitor-exit v2
    :try_end_23
    .catchall {:try_start_10 .. :try_end_23} :catchall_2a

    :try_start_23
    iget-object p1, p0, Landroidx/browser/customtabs/CustomTabsService$a;->c:Landroidx/browser/customtabs/CustomTabsService;

    invoke-virtual {p1, v0}, Landroidx/browser/customtabs/CustomTabsService;->d(Landroidx/browser/customtabs/f;)Z

    move-result p1
    :try_end_29
    .catch Landroid/os/RemoteException; {:try_start_23 .. :try_end_29} :catch_2d

    return p1

    :catchall_2a
    move-exception p1

    :try_start_2b
    monitor-exit v2
    :try_end_2c
    .catchall {:try_start_2b .. :try_end_2c} :catchall_2a

    :try_start_2c
    throw p1
    :try_end_2d
    .catch Landroid/os/RemoteException; {:try_start_2c .. :try_end_2d} :catch_2d

    :catch_2d
    return p2
.end method


# virtual methods
.method public extraCommand(Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    .registers 4

    iget-object v0, p0, Landroidx/browser/customtabs/CustomTabsService$a;->c:Landroidx/browser/customtabs/CustomTabsService;

    invoke-virtual {v0, p1, p2}, Landroidx/browser/customtabs/CustomTabsService;->b(Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object p1

    return-object p1
.end method

.method public mayLaunchUrl(Landroid/support/customtabs/ICustomTabsCallback;Landroid/net/Uri;Landroid/os/Bundle;Ljava/util/List;)Z
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/customtabs/ICustomTabsCallback;",
            "Landroid/net/Uri;",
            "Landroid/os/Bundle;",
            "Ljava/util/List<",
            "Landroid/os/Bundle;",
            ">;)Z"
        }
    .end annotation

    iget-object v0, p0, Landroidx/browser/customtabs/CustomTabsService$a;->c:Landroidx/browser/customtabs/CustomTabsService;

    new-instance v1, Landroidx/browser/customtabs/f;

    invoke-direct {p0, p3}, Landroidx/browser/customtabs/CustomTabsService$a;->c(Landroid/os/Bundle;)Landroid/app/PendingIntent;

    move-result-object v2

    invoke-direct {v1, p1, v2}, Landroidx/browser/customtabs/f;-><init>(Landroid/support/customtabs/ICustomTabsCallback;Landroid/app/PendingIntent;)V

    invoke-virtual {v0, v1, p2, p3, p4}, Landroidx/browser/customtabs/CustomTabsService;->c(Landroidx/browser/customtabs/f;Landroid/net/Uri;Landroid/os/Bundle;Ljava/util/List;)Z

    move-result p1

    return p1
.end method

.method public newSession(Landroid/support/customtabs/ICustomTabsCallback;)Z
    .registers 3

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroidx/browser/customtabs/CustomTabsService$a;->e(Landroid/support/customtabs/ICustomTabsCallback;Landroid/app/PendingIntent;)Z

    move-result p1

    return p1
.end method

.method public newSessionWithExtras(Landroid/support/customtabs/ICustomTabsCallback;Landroid/os/Bundle;)Z
    .registers 3

    invoke-direct {p0, p2}, Landroidx/browser/customtabs/CustomTabsService$a;->c(Landroid/os/Bundle;)Landroid/app/PendingIntent;

    move-result-object p2

    invoke-direct {p0, p1, p2}, Landroidx/browser/customtabs/CustomTabsService$a;->e(Landroid/support/customtabs/ICustomTabsCallback;Landroid/app/PendingIntent;)Z

    move-result p1

    return p1
.end method

.method public postMessage(Landroid/support/customtabs/ICustomTabsCallback;Ljava/lang/String;Landroid/os/Bundle;)I
    .registers 7

    iget-object v0, p0, Landroidx/browser/customtabs/CustomTabsService$a;->c:Landroidx/browser/customtabs/CustomTabsService;

    new-instance v1, Landroidx/browser/customtabs/f;

    invoke-direct {p0, p3}, Landroidx/browser/customtabs/CustomTabsService$a;->c(Landroid/os/Bundle;)Landroid/app/PendingIntent;

    move-result-object v2

    invoke-direct {v1, p1, v2}, Landroidx/browser/customtabs/f;-><init>(Landroid/support/customtabs/ICustomTabsCallback;Landroid/app/PendingIntent;)V

    invoke-virtual {v0, v1, p2, p3}, Landroidx/browser/customtabs/CustomTabsService;->e(Landroidx/browser/customtabs/f;Ljava/lang/String;Landroid/os/Bundle;)I

    move-result p1

    return p1
.end method

.method public receiveFile(Landroid/support/customtabs/ICustomTabsCallback;Landroid/net/Uri;ILandroid/os/Bundle;)Z
    .registers 8

    iget-object v0, p0, Landroidx/browser/customtabs/CustomTabsService$a;->c:Landroidx/browser/customtabs/CustomTabsService;

    new-instance v1, Landroidx/browser/customtabs/f;

    invoke-direct {p0, p4}, Landroidx/browser/customtabs/CustomTabsService$a;->c(Landroid/os/Bundle;)Landroid/app/PendingIntent;

    move-result-object v2

    invoke-direct {v1, p1, v2}, Landroidx/browser/customtabs/f;-><init>(Landroid/support/customtabs/ICustomTabsCallback;Landroid/app/PendingIntent;)V

    invoke-virtual {v0, v1, p2, p3, p4}, Landroidx/browser/customtabs/CustomTabsService;->f(Landroidx/browser/customtabs/f;Landroid/net/Uri;ILandroid/os/Bundle;)Z

    move-result p1

    return p1
.end method

.method public requestPostMessageChannel(Landroid/support/customtabs/ICustomTabsCallback;Landroid/net/Uri;)Z
    .registers 6

    iget-object v0, p0, Landroidx/browser/customtabs/CustomTabsService$a;->c:Landroidx/browser/customtabs/CustomTabsService;

    new-instance v1, Landroidx/browser/customtabs/f;

    const/4 v2, 0x0

    invoke-direct {v1, p1, v2}, Landroidx/browser/customtabs/f;-><init>(Landroid/support/customtabs/ICustomTabsCallback;Landroid/app/PendingIntent;)V

    invoke-virtual {v0, v1, p2}, Landroidx/browser/customtabs/CustomTabsService;->g(Landroidx/browser/customtabs/f;Landroid/net/Uri;)Z

    move-result p1

    return p1
.end method

.method public requestPostMessageChannelWithExtras(Landroid/support/customtabs/ICustomTabsCallback;Landroid/net/Uri;Landroid/os/Bundle;)Z
    .registers 6

    iget-object v0, p0, Landroidx/browser/customtabs/CustomTabsService$a;->c:Landroidx/browser/customtabs/CustomTabsService;

    new-instance v1, Landroidx/browser/customtabs/f;

    invoke-direct {p0, p3}, Landroidx/browser/customtabs/CustomTabsService$a;->c(Landroid/os/Bundle;)Landroid/app/PendingIntent;

    move-result-object p3

    invoke-direct {v1, p1, p3}, Landroidx/browser/customtabs/f;-><init>(Landroid/support/customtabs/ICustomTabsCallback;Landroid/app/PendingIntent;)V

    invoke-virtual {v0, v1, p2}, Landroidx/browser/customtabs/CustomTabsService;->g(Landroidx/browser/customtabs/f;Landroid/net/Uri;)Z

    move-result p1

    return p1
.end method

.method public updateVisuals(Landroid/support/customtabs/ICustomTabsCallback;Landroid/os/Bundle;)Z
    .registers 6

    iget-object v0, p0, Landroidx/browser/customtabs/CustomTabsService$a;->c:Landroidx/browser/customtabs/CustomTabsService;

    new-instance v1, Landroidx/browser/customtabs/f;

    invoke-direct {p0, p2}, Landroidx/browser/customtabs/CustomTabsService$a;->c(Landroid/os/Bundle;)Landroid/app/PendingIntent;

    move-result-object v2

    invoke-direct {v1, p1, v2}, Landroidx/browser/customtabs/f;-><init>(Landroid/support/customtabs/ICustomTabsCallback;Landroid/app/PendingIntent;)V

    invoke-virtual {v0, v1, p2}, Landroidx/browser/customtabs/CustomTabsService;->h(Landroidx/browser/customtabs/f;Landroid/os/Bundle;)Z

    move-result p1

    return p1
.end method

.method public validateRelationship(Landroid/support/customtabs/ICustomTabsCallback;ILandroid/net/Uri;Landroid/os/Bundle;)Z
    .registers 8

    iget-object v0, p0, Landroidx/browser/customtabs/CustomTabsService$a;->c:Landroidx/browser/customtabs/CustomTabsService;

    new-instance v1, Landroidx/browser/customtabs/f;

    invoke-direct {p0, p4}, Landroidx/browser/customtabs/CustomTabsService$a;->c(Landroid/os/Bundle;)Landroid/app/PendingIntent;

    move-result-object v2

    invoke-direct {v1, p1, v2}, Landroidx/browser/customtabs/f;-><init>(Landroid/support/customtabs/ICustomTabsCallback;Landroid/app/PendingIntent;)V

    invoke-virtual {v0, v1, p2, p3, p4}, Landroidx/browser/customtabs/CustomTabsService;->i(Landroidx/browser/customtabs/f;ILandroid/net/Uri;Landroid/os/Bundle;)Z

    move-result p1

    return p1
.end method

.method public warmup(J)Z
    .registers 4

    iget-object v0, p0, Landroidx/browser/customtabs/CustomTabsService$a;->c:Landroidx/browser/customtabs/CustomTabsService;

    invoke-virtual {v0, p1, p2}, Landroidx/browser/customtabs/CustomTabsService;->j(J)Z

    move-result p1

    return p1
.end method
