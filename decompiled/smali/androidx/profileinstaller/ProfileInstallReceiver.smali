.class public Landroidx/profileinstaller/ProfileInstallReceiver;
.super Landroid/content/BroadcastReceiver;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/profileinstaller/ProfileInstallReceiver$a;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method static a(Landroidx/profileinstaller/i$c;)V
    .registers 4

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/4 v1, 0x0

    const/16 v2, 0x18

    if-lt v0, v2, :cond_13

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v0

    const/16 v2, 0xa

    invoke-static {v0, v2}, Landroid/os/Process;->sendSignal(II)V

    const/16 v0, 0xc

    goto :goto_15

    :cond_13
    const/16 v0, 0xd

    :goto_15
    invoke-interface {p0, v0, v1}, Landroidx/profileinstaller/i$c;->b(ILjava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .registers 5

    if-nez p2, :cond_3

    return-void

    :cond_3
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "androidx.profileinstaller.action.INSTALL_PROFILE"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1f

    new-instance p2, Landroidx/profileinstaller/g;

    invoke-direct {p2}, Landroidx/profileinstaller/g;-><init>()V

    new-instance v0, Landroidx/profileinstaller/ProfileInstallReceiver$a;

    invoke-direct {v0, p0}, Landroidx/profileinstaller/ProfileInstallReceiver$a;-><init>(Landroidx/profileinstaller/ProfileInstallReceiver;)V

    const/4 v1, 0x1

    invoke-static {p1, p2, v0, v1}, Landroidx/profileinstaller/i;->k(Landroid/content/Context;Ljava/util/concurrent/Executor;Landroidx/profileinstaller/i$c;Z)V

    goto/16 :goto_9b

    :cond_1f
    const-string v1, "androidx.profileinstaller.action.SKIP_FILE"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5f

    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object p2

    if-eqz p2, :cond_9b

    const-string v0, "EXTRA_SKIP_FILE_OPERATION"

    invoke-virtual {p2, v0}, Landroid/os/BaseBundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    const-string v0, "WRITE_SKIP_FILE"

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_49

    new-instance p2, Landroidx/profileinstaller/g;

    invoke-direct {p2}, Landroidx/profileinstaller/g;-><init>()V

    new-instance v0, Landroidx/profileinstaller/ProfileInstallReceiver$a;

    invoke-direct {v0, p0}, Landroidx/profileinstaller/ProfileInstallReceiver$a;-><init>(Landroidx/profileinstaller/ProfileInstallReceiver;)V

    invoke-static {p1, p2, v0}, Landroidx/profileinstaller/i;->l(Landroid/content/Context;Ljava/util/concurrent/Executor;Landroidx/profileinstaller/i$c;)V

    goto :goto_9b

    :cond_49
    const-string v0, "DELETE_SKIP_FILE"

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_9b

    new-instance p2, Landroidx/profileinstaller/g;

    invoke-direct {p2}, Landroidx/profileinstaller/g;-><init>()V

    new-instance v0, Landroidx/profileinstaller/ProfileInstallReceiver$a;

    invoke-direct {v0, p0}, Landroidx/profileinstaller/ProfileInstallReceiver$a;-><init>(Landroidx/profileinstaller/ProfileInstallReceiver;)V

    invoke-static {p1, p2, v0}, Landroidx/profileinstaller/i;->c(Landroid/content/Context;Ljava/util/concurrent/Executor;Landroidx/profileinstaller/i$c;)V

    goto :goto_9b

    :cond_5f
    const-string v1, "androidx.profileinstaller.action.SAVE_PROFILE"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_70

    new-instance p1, Landroidx/profileinstaller/ProfileInstallReceiver$a;

    invoke-direct {p1, p0}, Landroidx/profileinstaller/ProfileInstallReceiver$a;-><init>(Landroidx/profileinstaller/ProfileInstallReceiver;)V

    invoke-static {p1}, Landroidx/profileinstaller/ProfileInstallReceiver;->a(Landroidx/profileinstaller/i$c;)V

    goto :goto_9b

    :cond_70
    const-string v1, "androidx.profileinstaller.action.BENCHMARK_OPERATION"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9b

    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object p2

    if-eqz p2, :cond_9b

    const-string v0, "EXTRA_BENCHMARK_OPERATION"

    invoke-virtual {p2, v0}, Landroid/os/BaseBundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    new-instance v0, Landroidx/profileinstaller/ProfileInstallReceiver$a;

    invoke-direct {v0, p0}, Landroidx/profileinstaller/ProfileInstallReceiver$a;-><init>(Landroidx/profileinstaller/ProfileInstallReceiver;)V

    const-string v1, "DROP_SHADER_CACHE"

    invoke-virtual {v1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_95

    invoke-static {p1, v0}, Landroidx/profileinstaller/a;->b(Landroid/content/Context;Landroidx/profileinstaller/ProfileInstallReceiver$a;)V

    goto :goto_9b

    :cond_95
    const/16 p1, 0x10

    const/4 p2, 0x0

    invoke-virtual {v0, p1, p2}, Landroidx/profileinstaller/ProfileInstallReceiver$a;->b(ILjava/lang/Object;)V

    :cond_9b
    :goto_9b
    return-void
.end method
