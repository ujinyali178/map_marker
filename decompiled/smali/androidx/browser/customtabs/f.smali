.class public Landroidx/browser/customtabs/f;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:Landroid/support/customtabs/ICustomTabsCallback;

.field private final b:Landroid/app/PendingIntent;

.field private final c:Landroidx/browser/customtabs/b;


# direct methods
.method constructor <init>(Landroid/support/customtabs/ICustomTabsCallback;Landroid/app/PendingIntent;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-nez p1, :cond_10

    if-eqz p2, :cond_8

    goto :goto_10

    :cond_8
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "CustomTabsSessionToken must have either a session id or a callback (or both)."

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_10
    :goto_10
    iput-object p1, p0, Landroidx/browser/customtabs/f;->a:Landroid/support/customtabs/ICustomTabsCallback;

    iput-object p2, p0, Landroidx/browser/customtabs/f;->b:Landroid/app/PendingIntent;

    if-nez p1, :cond_18

    const/4 p1, 0x0

    goto :goto_1d

    :cond_18
    new-instance p1, Landroidx/browser/customtabs/f$a;

    invoke-direct {p1, p0}, Landroidx/browser/customtabs/f$a;-><init>(Landroidx/browser/customtabs/f;)V

    :goto_1d
    iput-object p1, p0, Landroidx/browser/customtabs/f;->c:Landroidx/browser/customtabs/b;

    return-void
.end method

.method private b()Landroid/os/IBinder;
    .registers 3

    iget-object v0, p0, Landroidx/browser/customtabs/f;->a:Landroid/support/customtabs/ICustomTabsCallback;

    if-eqz v0, :cond_9

    invoke-interface {v0}, Landroid/os/IInterface;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0

    :cond_9
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "CustomTabSessionToken must have valid binder or pending session"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method a()Landroid/os/IBinder;
    .registers 2

    iget-object v0, p0, Landroidx/browser/customtabs/f;->a:Landroid/support/customtabs/ICustomTabsCallback;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    return-object v0

    :cond_6
    invoke-interface {v0}, Landroid/os/IInterface;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method c()Landroid/app/PendingIntent;
    .registers 2

    iget-object v0, p0, Landroidx/browser/customtabs/f;->b:Landroid/app/PendingIntent;

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 7

    instance-of v0, p1, Landroidx/browser/customtabs/f;

    const/4 v1, 0x0

    if-nez v0, :cond_6

    return v1

    :cond_6
    check-cast p1, Landroidx/browser/customtabs/f;

    invoke-virtual {p1}, Landroidx/browser/customtabs/f;->c()Landroid/app/PendingIntent;

    move-result-object v0

    iget-object v2, p0, Landroidx/browser/customtabs/f;->b:Landroid/app/PendingIntent;

    const/4 v3, 0x1

    if-nez v2, :cond_13

    const/4 v4, 0x1

    goto :goto_14

    :cond_13
    const/4 v4, 0x0

    :goto_14
    if-nez v0, :cond_17

    goto :goto_18

    :cond_17
    const/4 v3, 0x0

    :goto_18
    if-eq v4, v3, :cond_1b

    return v1

    :cond_1b
    if-eqz v2, :cond_22

    invoke-virtual {v2, v0}, Landroid/app/PendingIntent;->equals(Ljava/lang/Object;)Z

    move-result p1

    return p1

    :cond_22
    invoke-direct {p0}, Landroidx/browser/customtabs/f;->b()Landroid/os/IBinder;

    move-result-object v0

    invoke-direct {p1}, Landroidx/browser/customtabs/f;->b()Landroid/os/IBinder;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method public hashCode()I
    .registers 2

    iget-object v0, p0, Landroidx/browser/customtabs/f;->b:Landroid/app/PendingIntent;

    if-eqz v0, :cond_9

    invoke-virtual {v0}, Landroid/app/PendingIntent;->hashCode()I

    move-result v0

    return v0

    :cond_9
    invoke-direct {p0}, Landroidx/browser/customtabs/f;->b()Landroid/os/IBinder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    return v0
.end method
