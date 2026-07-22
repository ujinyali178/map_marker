.class public final Landroidx/core/app/s0;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/app/s0$f;,
        Landroidx/core/app/s0$c;,
        Landroidx/core/app/s0$a;,
        Landroidx/core/app/s0$b;,
        Landroidx/core/app/s0$e;,
        Landroidx/core/app/s0$d;
    }
.end annotation


# static fields
.field private static final c:Ljava/lang/Object;

.field private static d:Ljava/lang/String;

.field private static e:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final f:Ljava/lang/Object;

.field private static g:Landroidx/core/app/s0$e;


# instance fields
.field private final a:Landroid/content/Context;

.field private final b:Landroid/app/NotificationManager;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroidx/core/app/s0;->c:Ljava/lang/Object;

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Landroidx/core/app/s0;->e:Ljava/util/Set;

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroidx/core/app/s0;->f:Ljava/lang/Object;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/core/app/s0;->a:Landroid/content/Context;

    const-string v0, "notification"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/app/NotificationManager;

    iput-object p1, p0, Landroidx/core/app/s0;->b:Landroid/app/NotificationManager;

    return-void
.end method

.method public static c(Landroid/content/Context;)Landroidx/core/app/s0;
    .registers 2

    new-instance v0, Landroidx/core/app/s0;

    invoke-direct {v0, p0}, Landroidx/core/app/s0;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method public static d(Landroid/content/Context;)Ljava/util/Set;
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object p0

    const-string v0, "enabled_notification_listeners"

    invoke-static {p0, v0}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    sget-object v0, Landroidx/core/app/s0;->c:Ljava/lang/Object;

    monitor-enter v0

    if-eqz p0, :cond_3e

    :try_start_f
    sget-object v1, Landroidx/core/app/s0;->d:Ljava/lang/String;

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3e

    const-string v1, ":"

    const/4 v2, -0x1

    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/util/HashSet;

    array-length v3, v1

    invoke-direct {v2, v3}, Ljava/util/HashSet;-><init>(I)V

    array-length v3, v1

    const/4 v4, 0x0

    :goto_26
    if-ge v4, v3, :cond_3a

    aget-object v5, v1, v4

    invoke-static {v5}, Landroid/content/ComponentName;->unflattenFromString(Ljava/lang/String;)Landroid/content/ComponentName;

    move-result-object v5

    if-eqz v5, :cond_37

    invoke-virtual {v5}, Landroid/content/ComponentName;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v5}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    :cond_37
    add-int/lit8 v4, v4, 0x1

    goto :goto_26

    :cond_3a
    sput-object v2, Landroidx/core/app/s0;->e:Ljava/util/Set;

    sput-object p0, Landroidx/core/app/s0;->d:Ljava/lang/String;

    :cond_3e
    sget-object p0, Landroidx/core/app/s0;->e:Ljava/util/Set;

    monitor-exit v0

    return-object p0

    :catchall_42
    move-exception p0

    monitor-exit v0
    :try_end_44
    .catchall {:try_start_f .. :try_end_44} :catchall_42

    throw p0
.end method

.method private g(Landroidx/core/app/s0$f;)V
    .registers 5

    sget-object v0, Landroidx/core/app/s0;->f:Ljava/lang/Object;

    monitor-enter v0

    :try_start_3
    sget-object v1, Landroidx/core/app/s0;->g:Landroidx/core/app/s0$e;

    if-nez v1, :cond_14

    new-instance v1, Landroidx/core/app/s0$e;

    iget-object v2, p0, Landroidx/core/app/s0;->a:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroidx/core/app/s0$e;-><init>(Landroid/content/Context;)V

    sput-object v1, Landroidx/core/app/s0;->g:Landroidx/core/app/s0$e;

    :cond_14
    sget-object v1, Landroidx/core/app/s0;->g:Landroidx/core/app/s0$e;

    invoke-virtual {v1, p1}, Landroidx/core/app/s0$e;->h(Landroidx/core/app/s0$f;)V

    monitor-exit v0

    return-void

    :catchall_1b
    move-exception p1

    monitor-exit v0
    :try_end_1d
    .catchall {:try_start_3 .. :try_end_1d} :catchall_1b

    throw p1
.end method

.method private static h(Landroid/app/Notification;)Z
    .registers 2

    invoke-static {p0}, Landroidx/core/app/s;->a(Landroid/app/Notification;)Landroid/os/Bundle;

    move-result-object p0

    if-eqz p0, :cond_10

    const-string v0, "android.support.useSideChannel"

    invoke-virtual {p0, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_10

    const/4 p0, 0x1

    goto :goto_11

    :cond_10
    const/4 p0, 0x0

    :goto_11
    return p0
.end method


# virtual methods
.method public a()Z
    .registers 12

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x18

    if-lt v0, v1, :cond_d

    iget-object v0, p0, Landroidx/core/app/s0;->b:Landroid/app/NotificationManager;

    invoke-static {v0}, Landroidx/core/app/s0$a;->a(Landroid/app/NotificationManager;)Z

    move-result v0

    return v0

    :cond_d
    iget-object v0, p0, Landroidx/core/app/s0;->a:Landroid/content/Context;

    const-string v1, "appops"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AppOpsManager;

    iget-object v1, p0, Landroidx/core/app/s0;->a:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    iget-object v2, p0, Landroidx/core/app/s0;->a:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    iget v1, v1, Landroid/content/pm/ApplicationInfo;->uid:I

    const/4 v3, 0x1

    :try_start_2a
    const-class v4, Landroid/app/AppOpsManager;

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v4

    const-string v5, "checkOpNoThrow"

    const/4 v6, 0x3

    new-array v7, v6, [Ljava/lang/Class;

    sget-object v8, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    const/4 v9, 0x0

    aput-object v8, v7, v9

    aput-object v8, v7, v3

    const-class v8, Ljava/lang/String;

    const/4 v10, 0x2

    aput-object v8, v7, v10

    invoke-virtual {v4, v5, v7}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v5

    const-string v7, "OP_POST_NOTIFICATION"

    invoke-virtual {v4, v7}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v4

    const-class v7, Ljava/lang/Integer;

    invoke-virtual {v4, v7}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v6, v9

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v6, v3

    aput-object v2, v6, v10

    invoke-virtual {v5, v0, v6}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0
    :try_end_75
    .catch Ljava/lang/ClassNotFoundException; {:try_start_2a .. :try_end_75} :catch_79
    .catch Ljava/lang/NoSuchMethodException; {:try_start_2a .. :try_end_75} :catch_79
    .catch Ljava/lang/NoSuchFieldException; {:try_start_2a .. :try_end_75} :catch_79
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_2a .. :try_end_75} :catch_79
    .catch Ljava/lang/IllegalAccessException; {:try_start_2a .. :try_end_75} :catch_79
    .catch Ljava/lang/RuntimeException; {:try_start_2a .. :try_end_75} :catch_79

    if-nez v0, :cond_78

    goto :goto_79

    :cond_78
    const/4 v3, 0x0

    :catch_79
    :goto_79
    return v3
.end method

.method public b(Landroid/app/NotificationChannel;)V
    .registers 4

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-lt v0, v1, :cond_b

    iget-object v0, p0, Landroidx/core/app/s0;->b:Landroid/app/NotificationManager;

    invoke-static {v0, p1}, Landroidx/core/app/s0$b;->a(Landroid/app/NotificationManager;Landroid/app/NotificationChannel;)V

    :cond_b
    return-void
.end method

.method public e(ILandroid/app/Notification;)V
    .registers 4

    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1, p2}, Landroidx/core/app/s0;->f(Ljava/lang/String;ILandroid/app/Notification;)V

    return-void
.end method

.method public f(Ljava/lang/String;ILandroid/app/Notification;)V
    .registers 6

    invoke-static {p3}, Landroidx/core/app/s0;->h(Landroid/app/Notification;)Z

    move-result v0

    if-eqz v0, :cond_1a

    new-instance v0, Landroidx/core/app/s0$c;

    iget-object v1, p0, Landroidx/core/app/s0;->a:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, p2, p1, p3}, Landroidx/core/app/s0$c;-><init>(Ljava/lang/String;ILjava/lang/String;Landroid/app/Notification;)V

    invoke-direct {p0, v0}, Landroidx/core/app/s0;->g(Landroidx/core/app/s0$f;)V

    iget-object p3, p0, Landroidx/core/app/s0;->b:Landroid/app/NotificationManager;

    invoke-virtual {p3, p1, p2}, Landroid/app/NotificationManager;->cancel(Ljava/lang/String;I)V

    goto :goto_1f

    :cond_1a
    iget-object v0, p0, Landroidx/core/app/s0;->b:Landroid/app/NotificationManager;

    invoke-virtual {v0, p1, p2, p3}, Landroid/app/NotificationManager;->notify(Ljava/lang/String;ILandroid/app/Notification;)V

    :goto_1f
    return-void
.end method
