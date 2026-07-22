.class final Lb0/u;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lu1/n$a;
.implements Lu1/n$d;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lb0/u$b;,
        Lb0/u$a;,
        Lb0/u$c;
    }
.end annotation


# instance fields
.field private final c:Landroid/content/Context;

.field private d:Lb0/u$b;

.field private f:Landroid/app/Activity;

.field private g:I

.field private h:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lb0/u;->c:Landroid/content/Context;

    return-void
.end method

.method private b()I
    .registers 4

    iget-object v0, p0, Lb0/u;->c:Landroid/content/Context;

    const/16 v1, 0x15

    invoke-static {v0, v1}, Lb0/w;->c(Landroid/content/Context;I)Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-eqz v0, :cond_15

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_13

    goto :goto_15

    :cond_13
    const/4 v0, 0x0

    goto :goto_16

    :cond_15
    :goto_15
    const/4 v0, 0x1

    :goto_16
    if-eqz v0, :cond_20

    const-string v0, "permissions_handler"

    const-string v2, "Bluetooth permission missing in manifest"

    invoke-static {v0, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return v1

    :cond_20
    return v2
.end method

.method private c()I
    .registers 4

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/4 v1, 0x1

    const/16 v2, 0x21

    if-ge v0, v2, :cond_16

    iget-object v0, p0, Lb0/u;->c:Landroid/content/Context;

    invoke-static {v0}, Landroidx/core/app/s0;->c(Landroid/content/Context;)Landroidx/core/app/s0;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/core/app/s0;->a()Z

    move-result v0

    if-eqz v0, :cond_14

    return v1

    :cond_14
    const/4 v0, 0x0

    return v0

    :cond_16
    iget-object v0, p0, Lb0/u;->c:Landroid/content/Context;

    const-string v2, "android.permission.POST_NOTIFICATIONS"

    invoke-static {v0, v2}, Lb0/t;->a(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_21

    return v1

    :cond_21
    iget-object v0, p0, Lb0/u;->f:Landroid/app/Activity;

    invoke-static {v0, v2}, Lb0/w;->b(Landroid/app/Activity;Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method private e(I)I
    .registers 15

    const/16 v0, 0x11

    if-ne p1, v0, :cond_9

    invoke-direct {p0}, Lb0/u;->c()I

    move-result p1

    return p1

    :cond_9
    const/16 v0, 0x15

    if-ne p1, v0, :cond_12

    invoke-direct {p0}, Lb0/u;->b()I

    move-result p1

    return p1

    :cond_12
    const/16 v0, 0x1f

    const/16 v1, 0x1e

    if-eq p1, v1, :cond_20

    const/16 v2, 0x1c

    if-eq p1, v2, :cond_20

    const/16 v2, 0x1d

    if-ne p1, v2, :cond_29

    :cond_20
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ge v2, v0, :cond_29

    invoke-direct {p0}, Lb0/u;->b()I

    move-result p1

    return p1

    :cond_29
    const/16 v2, 0x25

    const/4 v3, 0x0

    if-eq p1, v2, :cond_30

    if-nez p1, :cond_37

    :cond_30
    invoke-direct {p0}, Lb0/u;->f()Z

    move-result v2

    if-nez v2, :cond_37

    return v3

    :cond_37
    iget-object v2, p0, Lb0/u;->c:Landroid/content/Context;

    invoke-static {v2, p1}, Lb0/w;->c(Landroid/content/Context;I)Ljava/util/List;

    move-result-object v2

    const-string v4, "permissions_handler"

    const/4 v5, 0x1

    const/4 v5, 0x1

    if-nez v2, :cond_58

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "No android specific permissions needed for: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v4, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return v5

    :cond_58
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v6

    const/16 v7, 0x16

    const/16 v8, 0x10

    const/4 v9, 0x2

    const/16 v10, 0x17

    if-nez v6, :cond_90

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "No permissions found in manifest for: "

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v4, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    if-ne p1, v8, :cond_83

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ge v0, v10, :cond_83

    return v9

    :cond_83
    if-ne p1, v7, :cond_8a

    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ge p1, v1, :cond_8a

    return v9

    :cond_8a
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ge p1, v10, :cond_8f

    const/4 v3, 0x1

    :cond_8f
    return v3

    :cond_90
    iget-object v4, p0, Lb0/u;->c:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v4

    iget v4, v4, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    if-lt v4, v10, :cond_9c

    const/4 v4, 0x1

    goto :goto_9d

    :cond_9c
    const/4 v4, 0x0

    :goto_9d
    if-eqz v4, :cond_157

    new-instance v4, Ljava/util/HashSet;

    invoke-direct {v4}, Ljava/util/HashSet;-><init>()V

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_a8
    :goto_a8
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_148

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    if-ne p1, v8, :cond_db

    iget-object v6, p0, Lb0/u;->c:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    iget-object v11, p0, Lb0/u;->c:Landroid/content/Context;

    const-string v12, "power"

    invoke-virtual {v11, v12}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroid/os/PowerManager;

    if-eqz v11, :cond_d3

    invoke-static {v11, v6}, Lb0/n;->a(Landroid/os/PowerManager;Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_d3

    :cond_ce
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    goto :goto_d7

    :cond_d3
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    :goto_d7
    invoke-interface {v4, v6}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_a8

    :cond_db
    if-ne p1, v7, :cond_ed

    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ge v6, v1, :cond_e8

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v4, v6}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    :cond_e8
    invoke-static {}, Lb0/o;->a()Z

    move-result v6

    goto :goto_f5

    :cond_ed
    if-ne p1, v10, :cond_fa

    iget-object v6, p0, Lb0/u;->c:Landroid/content/Context;

    invoke-static {v6}, Lb0/p;->a(Landroid/content/Context;)Z

    move-result v6

    :goto_f5
    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    goto :goto_d7

    :cond_fa
    const/16 v11, 0x18

    if-ne p1, v11, :cond_10f

    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v11, 0x1a

    if-lt v6, v11, :cond_a8

    iget-object v6, p0, Lb0/u;->c:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    invoke-static {v6}, Lb0/q;->a(Landroid/content/pm/PackageManager;)Z

    move-result v6

    goto :goto_f5

    :cond_10f
    const/16 v11, 0x1b

    if-ne p1, v11, :cond_122

    iget-object v6, p0, Lb0/u;->c:Landroid/content/Context;

    const-string v11, "notification"

    invoke-virtual {v6, v11}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/app/NotificationManager;

    invoke-static {v6}, Lb0/r;->a(Landroid/app/NotificationManager;)Z

    move-result v6

    goto :goto_f5

    :cond_122
    const/16 v11, 0x22

    if-ne p1, v11, :cond_139

    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v6, v0, :cond_ce

    iget-object v6, p0, Lb0/u;->c:Landroid/content/Context;

    const-string v11, "alarm"

    invoke-virtual {v6, v11}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/app/AlarmManager;

    invoke-static {v6}, Lb0/s;->a(Landroid/app/AlarmManager;)Z

    move-result v6

    goto :goto_f5

    :cond_139
    iget-object v11, p0, Lb0/u;->c:Landroid/content/Context;

    invoke-static {v11, v6}, Landroidx/core/content/a;->checkSelfPermission(Landroid/content/Context;Ljava/lang/String;)I

    move-result v11

    if-eqz v11, :cond_a8

    iget-object v11, p0, Lb0/u;->f:Landroid/app/Activity;

    invoke-static {v11, v6}, Lb0/w;->b(Landroid/app/Activity;Ljava/lang/String;)I

    move-result v6

    goto :goto_f5

    :cond_148
    invoke-interface {v4}, Ljava/util/Set;->isEmpty()Z

    move-result p1

    if-nez p1, :cond_157

    invoke-static {v4}, Lb0/w;->j(Ljava/util/Collection;)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    return p1

    :cond_157
    return v5
.end method

.method private f()Z
    .registers 6

    iget-object v0, p0, Lb0/u;->c:Landroid/content/Context;

    const/16 v1, 0x25

    invoke-static {v0, v1}, Lb0/w;->c(Landroid/content/Context;I)Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eqz v0, :cond_16

    const-string v3, "android.permission.WRITE_CALENDAR"

    invoke-interface {v0, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_16

    const/4 v3, 0x1

    goto :goto_17

    :cond_16
    const/4 v3, 0x0

    :goto_17
    if-eqz v0, :cond_23

    const-string v4, "android.permission.READ_CALENDAR"

    invoke-interface {v0, v4}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_23

    const/4 v0, 0x1

    goto :goto_24

    :cond_23
    const/4 v0, 0x0

    :goto_24
    if-eqz v3, :cond_2a

    if-eqz v0, :cond_2a

    const/4 v4, 0x1

    goto :goto_2b

    :cond_2a
    const/4 v4, 0x0

    :goto_2b
    if-nez v4, :cond_3e

    const-string v1, "permissions_handler"

    if-nez v3, :cond_36

    const-string v3, "android.permission.WRITE_CALENDAR missing in manifest"

    invoke-static {v1, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_36
    if-nez v0, :cond_3d

    const-string v0, "android.permission.READ_CALENDAR missing in manifest"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_3d
    return v2

    :cond_3e
    return v1
.end method

.method private g(Ljava/lang/String;I)V
    .registers 6

    iget-object v0, p0, Lb0/u;->f:Landroid/app/Activity;

    if-nez v0, :cond_5

    return-void

    :cond_5
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v1, "android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_30

    iget-object p1, p0, Lb0/u;->f:Landroid/app/Activity;

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object p1

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "package:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    :cond_30
    iget-object p1, p0, Lb0/u;->f:Landroid/app/Activity;

    invoke-virtual {p1, v0, p2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    iget p1, p0, Lb0/u;->g:I

    add-int/lit8 p1, p1, 0x1

    iput p1, p0, Lb0/u;->g:I

    return-void
.end method


# virtual methods
.method public a(IILandroid/content/Intent;)Z
    .registers 7

    iget-object p2, p0, Lb0/u;->f:Landroid/app/Activity;

    const/4 p3, 0x0

    if-nez p2, :cond_6

    return p3

    :cond_6
    const/16 v0, 0xd1

    const/4 v1, 0x1

    const/16 v2, 0x17

    if-ne p1, v0, :cond_32

    const/16 p1, 0x10

    sget p2, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt p2, v2, :cond_2d

    iget-object p2, p0, Lb0/u;->c:Landroid/content/Context;

    invoke-virtual {p2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object p2

    iget-object v0, p0, Lb0/u;->c:Landroid/content/Context;

    const-string v2, "power"

    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/PowerManager;

    if-eqz v0, :cond_2e

    invoke-static {v0, p2}, Lb0/n;->a(Landroid/os/PowerManager;Ljava/lang/String;)Z

    move-result p2

    if-eqz p2, :cond_2e

    const/4 p3, 0x1

    goto :goto_2e

    :cond_2d
    const/4 p3, 0x2

    :cond_2e
    :goto_2e
    const/16 v2, 0x10

    goto/16 :goto_9b

    :cond_32
    const/16 v0, 0xd2

    if-ne p1, v0, :cond_44

    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 p2, 0x1e

    if-lt p1, p2, :cond_43

    invoke-static {}, Lb0/o;->a()Z

    move-result p3

    const/16 v2, 0x16

    goto :goto_9b

    :cond_43
    return p3

    :cond_44
    const/16 v0, 0xd3

    if-ne p1, v0, :cond_52

    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt p1, v2, :cond_51

    invoke-static {p2}, Lb0/p;->a(Landroid/content/Context;)Z

    move-result p3

    goto :goto_9b

    :cond_51
    return p3

    :cond_52
    const/16 v0, 0xd4

    if-ne p1, v0, :cond_68

    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v0, 0x1a

    if-lt p1, v0, :cond_67

    invoke-virtual {p2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object p1

    invoke-static {p1}, Lb0/q;->a(Landroid/content/pm/PackageManager;)Z

    move-result p3

    const/16 v2, 0x18

    goto :goto_9b

    :cond_67
    return p3

    :cond_68
    const/16 v0, 0xd5

    if-ne p1, v0, :cond_80

    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt p1, v2, :cond_7f

    const-string p1, "notification"

    invoke-virtual {p2, p1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/app/NotificationManager;

    invoke-static {p1}, Lb0/r;->a(Landroid/app/NotificationManager;)Z

    move-result p3

    const/16 v2, 0x1b

    goto :goto_9b

    :cond_7f
    return p3

    :cond_80
    const/16 v0, 0xd6

    if-ne p1, v0, :cond_b9

    const/16 v2, 0x22

    const-string p1, "alarm"

    invoke-virtual {p2, p1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/app/AlarmManager;

    sget p2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 p3, 0x1f

    if-lt p2, p3, :cond_9a

    invoke-static {p1}, Lb0/s;->a(Landroid/app/AlarmManager;)Z

    move-result p1

    move p3, p1

    goto :goto_9b

    :cond_9a
    const/4 p3, 0x1

    :goto_9b
    iget-object p1, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    invoke-interface {p1, p2, p3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget p1, p0, Lb0/u;->g:I

    sub-int/2addr p1, v1

    iput p1, p0, Lb0/u;->g:I

    iget-object p2, p0, Lb0/u;->d:Lb0/u$b;

    if-eqz p2, :cond_b8

    if-nez p1, :cond_b8

    iget-object p1, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-interface {p2, p1}, Lb0/u$b;->a(Ljava/util/Map;)V

    :cond_b8
    return v1

    :cond_b9
    return p3
.end method

.method d(ILb0/u$a;)V
    .registers 3

    invoke-direct {p0, p1}, Lb0/u;->e(I)I

    move-result p1

    invoke-interface {p2, p1}, Lb0/u$a;->a(I)V

    return-void
.end method

.method h(Ljava/util/List;Lb0/u$b;Lb0/b;)V
    .registers 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/Integer;",
            ">;",
            "Lb0/u$b;",
            "Lb0/b;",
            ")V"
        }
    .end annotation

    iget v0, p0, Lb0/u;->g:I

    const-string v1, "PermissionHandler.PermissionManager"

    if-lez v0, :cond_c

    const-string p1, "A request for permissions is already running, please wait for it to finish before doing another request (note that you can request multiple permissions at the same time)."

    :goto_8
    invoke-interface {p3, v1, p1}, Lb0/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    return-void

    :cond_c
    iget-object v0, p0, Lb0/u;->f:Landroid/app/Activity;

    if-nez v0, :cond_1a

    const-string p1, "permissions_handler"

    const-string p2, "Unable to detect current Activity."

    invoke-static {p1, p2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    const-string p1, "Unable to detect current Android Activity."

    goto :goto_8

    :cond_1a
    iput-object p2, p0, Lb0/u;->d:Lb0/u$b;

    new-instance p2, Ljava/util/HashMap;

    invoke-direct {p2}, Ljava/util/HashMap;-><init>()V

    iput-object p2, p0, Lb0/u;->h:Ljava/util/Map;

    const/4 p2, 0x0

    iput p2, p0, Lb0/u;->g:I

    new-instance p3, Ljava/util/ArrayList;

    invoke-direct {p3}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_2f
    :goto_2f
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    const/16 v1, 0x18

    if-eqz v0, :cond_13f

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-direct {p0, v2}, Lb0/u;->e(I)I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_5a

    iget-object v1, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2f

    iget-object v1, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    :goto_56
    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2f

    :cond_5a
    iget-object v2, p0, Lb0/u;->f:Landroid/app/Activity;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-static {v2, v3}, Lb0/w;->c(Landroid/content/Context;I)Ljava/util/List;

    move-result-object v2

    const/16 v3, 0x16

    const/16 v4, 0x1e

    const/16 v5, 0x10

    const/4 v6, 0x2

    const/16 v7, 0x17

    if-eqz v2, :cond_103

    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v8

    if-eqz v8, :cond_77

    goto/16 :goto_103

    :cond_77
    sget v8, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v8, v7, :cond_89

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v9

    if-ne v9, v5, :cond_89

    const/16 v0, 0xd1

    const-string v1, "android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS"

    :goto_85
    invoke-direct {p0, v1, v0}, Lb0/u;->g(Ljava/lang/String;I)V

    goto :goto_2f

    :cond_89
    if-lt v8, v4, :cond_96

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v4

    if-ne v4, v3, :cond_96

    const/16 v0, 0xd2

    const-string v1, "android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION"

    goto :goto_85

    :cond_96
    if-lt v8, v7, :cond_a3

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v3

    if-ne v3, v7, :cond_a3

    const/16 v0, 0xd3

    const-string v1, "android.settings.action.MANAGE_OVERLAY_PERMISSION"

    goto :goto_85

    :cond_a3
    const/16 v3, 0x1a

    if-lt v8, v3, :cond_b2

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v3

    if-ne v3, v1, :cond_b2

    const/16 v0, 0xd4

    const-string v1, "android.settings.MANAGE_UNKNOWN_APP_SOURCES"

    goto :goto_85

    :cond_b2
    if-lt v8, v7, :cond_c1

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    const/16 v3, 0x1b

    if-ne v1, v3, :cond_c1

    const/16 v0, 0xd5

    const-string v1, "android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"

    goto :goto_85

    :cond_c1
    const/16 v1, 0x1f

    if-lt v8, v1, :cond_d2

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    const/16 v3, 0x22

    if-ne v1, v3, :cond_d2

    const/16 v0, 0xd6

    const-string v1, "android.settings.REQUEST_SCHEDULE_EXACT_ALARM"

    goto :goto_85

    :cond_d2
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    const/16 v3, 0x25

    if-eq v1, v3, :cond_ec

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-nez v1, :cond_e1

    goto :goto_ec

    :cond_e1
    invoke-virtual {p3, v2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    iget v0, p0, Lb0/u;->g:I

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v0, v1

    goto :goto_ff

    :cond_ec
    :goto_ec
    invoke-direct {p0}, Lb0/u;->f()Z

    move-result v1

    if-eqz v1, :cond_137

    const-string v0, "android.permission.WRITE_CALENDAR"

    invoke-virtual {p3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const-string v0, "android.permission.READ_CALENDAR"

    invoke-virtual {p3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    iget v0, p0, Lb0/u;->g:I

    add-int/2addr v0, v6

    :goto_ff
    iput v0, p0, Lb0/u;->g:I

    goto/16 :goto_2f

    :cond_103
    :goto_103
    iget-object v1, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2f

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-ne v1, v5, :cond_11c

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ge v1, v7, :cond_11c

    iget-object v1, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    goto :goto_122

    :cond_11c
    iget-object v1, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    :goto_122
    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-ne v1, v3, :cond_137

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ge v1, v4, :cond_137

    iget-object v1, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    goto/16 :goto_56

    :cond_137
    iget-object v1, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    goto/16 :goto_56

    :cond_13f
    invoke-virtual {p3}, Ljava/util/ArrayList;->size()I

    move-result p1

    if-lez p1, :cond_152

    new-array p1, p2, [Ljava/lang/String;

    invoke-virtual {p3, p1}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [Ljava/lang/String;

    iget-object p2, p0, Lb0/u;->f:Landroid/app/Activity;

    invoke-static {p2, p1, v1}, Landroidx/core/app/a;->c(Landroid/app/Activity;[Ljava/lang/String;I)V

    :cond_152
    iget-object p1, p0, Lb0/u;->d:Lb0/u$b;

    if-eqz p1, :cond_15f

    iget p2, p0, Lb0/u;->g:I

    if-nez p2, :cond_15f

    iget-object p2, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-interface {p1, p2}, Lb0/u$b;->a(Ljava/util/Map;)V

    :cond_15f
    return-void
.end method

.method public i(Landroid/app/Activity;)V
    .registers 2

    iput-object p1, p0, Lb0/u;->f:Landroid/app/Activity;

    return-void
.end method

.method j(ILb0/u$c;Lb0/b;)V
    .registers 7

    iget-object v0, p0, Lb0/u;->f:Landroid/app/Activity;

    const-string v1, "permissions_handler"

    if-nez v0, :cond_13

    const-string p1, "Unable to detect current Activity."

    invoke-static {v1, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    const-string p1, "PermissionHandler.PermissionManager"

    const-string p2, "Unable to detect current Android Activity."

    invoke-interface {p3, p1, p2}, Lb0/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    return-void

    :cond_13
    invoke-static {v0, p1}, Lb0/w;->c(Landroid/content/Context;I)Ljava/util/List;

    move-result-object p3

    const/4 v0, 0x0

    if-nez p3, :cond_32

    new-instance p3, Ljava/lang/StringBuilder;

    invoke-direct {p3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "No android specific permissions needed for: "

    invoke-virtual {p3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v1, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    invoke-interface {p2, v0}, Lb0/u$c;->a(Z)V

    return-void

    :cond_32
    invoke-interface {p3}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_55

    new-instance p3, Ljava/lang/StringBuilder;

    invoke-direct {p3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "No permissions found in manifest for: "

    invoke-virtual {p3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, " no need to show request rationale"

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v1, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    invoke-interface {p2, v0}, Lb0/u$c;->a(Z)V

    return-void

    :cond_55
    iget-object p1, p0, Lb0/u;->f:Landroid/app/Activity;

    invoke-interface {p3, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p3

    check-cast p3, Ljava/lang/String;

    invoke-static {p1, p3}, Landroidx/core/app/a;->f(Landroid/app/Activity;Ljava/lang/String;)Z

    move-result p1

    invoke-interface {p2, p1}, Lb0/u$c;->a(Z)V

    return-void
.end method

.method public onRequestPermissionsResult(I[Ljava/lang/String;[I)Z
    .registers 11

    const/4 v0, 0x0

    const/16 v1, 0x18

    if-eq p1, v1, :cond_8

    iput v0, p0, Lb0/u;->g:I

    return v0

    :cond_8
    iget-object p1, p0, Lb0/u;->h:Ljava/util/Map;

    if-nez p1, :cond_d

    return v0

    :cond_d
    array-length p1, p2

    if-nez p1, :cond_1b

    array-length p1, p3

    if-nez p1, :cond_1b

    const-string p1, "permissions_handler"

    const-string p2, "onRequestPermissionsResult is called without results. This is probably caused by interfering request codes. If you see this error, please file an issue in flutter-permission-handler, including a list of plugins used by this application: https://github.com/Baseflow/flutter-permission-handler/issues"

    invoke-static {p1, p2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    return v0

    :cond_1b
    invoke-static {p2}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object p1

    const-string v1, "android.permission.WRITE_CALENDAR"

    invoke-interface {p1, v1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v2

    const-string v3, "android.permission.READ_CALENDAR"

    if-ltz v2, :cond_7a

    aget v2, p3, v2

    iget-object v4, p0, Lb0/u;->f:Landroid/app/Activity;

    invoke-static {v4, v1, v2}, Lb0/w;->k(Landroid/app/Activity;Ljava/lang/String;I)I

    move-result v2

    iget-object v4, p0, Lb0/u;->h:Ljava/util/Map;

    const/16 v5, 0x24

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-interface {p1, v3}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result p1

    if-ltz p1, :cond_7a

    aget p1, p3, p1

    iget-object v4, p0, Lb0/u;->f:Landroid/app/Activity;

    invoke-static {v4, v3, p1}, Lb0/w;->k(Landroid/app/Activity;Ljava/lang/String;I)I

    move-result p1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-static {v2, p1}, Lb0/w;->i(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    iget-object v2, p0, Lb0/u;->h:Ljava/util/Map;

    const/16 v4, 0x25

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v2, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v2, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-interface {v2, v4, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_7a
    :goto_7a
    array-length p1, p2

    if-ge v0, p1, :cond_19a

    aget-object p1, p2, v0

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_196

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8d

    goto/16 :goto_196

    :cond_8d
    invoke-static {p1}, Lb0/w;->g(Ljava/lang/String;)I

    move-result v2

    const/16 v4, 0x14

    if-ne v2, v4, :cond_97

    goto/16 :goto_196

    :cond_97
    aget v4, p3, v0

    const/16 v5, 0x8

    if-ne v2, v5, :cond_c2

    iget-object v2, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v2, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    iget-object v6, p0, Lb0/u;->f:Landroid/app/Activity;

    invoke-static {v6, p1, v4}, Lb0/w;->k(Landroid/app/Activity;Ljava/lang/String;I)I

    move-result p1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-static {v2, p1}, Lb0/w;->i(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/Integer;

    move-result-object p1

    iget-object v2, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    :goto_bd
    invoke-interface {v2, v4, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_196

    :cond_c2
    const/4 v5, 0x7

    if-ne v2, v5, :cond_107

    iget-object v2, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v2, v6}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_e4

    iget-object v2, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    iget-object v6, p0, Lb0/u;->f:Landroid/app/Activity;

    invoke-static {v6, p1, v4}, Lb0/w;->k(Landroid/app/Activity;Ljava/lang/String;I)I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v2, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_e4
    iget-object v2, p0, Lb0/u;->h:Ljava/util/Map;

    const/16 v5, 0xe

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v2, v6}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_196

    iget-object v2, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    iget-object v6, p0, Lb0/u;->f:Landroid/app/Activity;

    invoke-static {v6, p1, v4}, Lb0/w;->k(Landroid/app/Activity;Ljava/lang/String;I)I

    move-result p1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-interface {v2, v5, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_196

    :cond_107
    const/4 v5, 0x4

    if-ne v2, v5, :cond_127

    iget-object v2, p0, Lb0/u;->f:Landroid/app/Activity;

    invoke-static {v2, p1, v4}, Lb0/w;->k(Landroid/app/Activity;Ljava/lang/String;I)I

    move-result p1

    iget-object v2, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_196

    iget-object v2, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    goto :goto_bd

    :cond_127
    const/4 v6, 0x3

    if-ne v2, v6, :cond_177

    iget-object v6, p0, Lb0/u;->f:Landroid/app/Activity;

    invoke-static {v6, p1, v4}, Lb0/w;->k(Landroid/app/Activity;Ljava/lang/String;I)I

    move-result p1

    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0x1d

    if-ge v4, v6, :cond_14f

    iget-object v4, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v4, v6}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_14f

    iget-object v4, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_14f
    iget-object v4, p0, Lb0/u;->h:Ljava/util/Map;

    const/4 v5, 0x5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v4, v6}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_169

    iget-object v4, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_169
    iget-object v4, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-interface {v4, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_196

    :cond_177
    iget-object v5, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v5, v6}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_196

    iget-object v5, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget-object v6, p0, Lb0/u;->f:Landroid/app/Activity;

    invoke-static {v6, p1, v4}, Lb0/w;->k(Landroid/app/Activity;Ljava/lang/String;I)I

    move-result p1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-interface {v5, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_196
    :goto_196
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_7a

    :cond_19a
    iget p1, p0, Lb0/u;->g:I

    array-length p2, p3

    sub-int/2addr p1, p2

    iput p1, p0, Lb0/u;->g:I

    iget-object p2, p0, Lb0/u;->d:Lb0/u$b;

    if-eqz p2, :cond_1ab

    if-nez p1, :cond_1ab

    iget-object p1, p0, Lb0/u;->h:Ljava/util/Map;

    invoke-interface {p2, p1}, Lb0/u$b;->a(Ljava/util/Map;)V

    :cond_1ab
    const/4 p1, 0x1

    return p1
.end method
