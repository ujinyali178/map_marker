.class public abstract Landroidx/browser/trusted/TrustedWebActivityService;
.super Landroid/app/Service;
.source "SourceFile"


# instance fields
.field private c:Landroid/app/NotificationManager;

.field d:I

.field private final f:Landroid/support/customtabs/trusted/ITrustedWebActivityService$Stub;


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    const/4 v0, -0x1

    iput v0, p0, Landroidx/browser/trusted/TrustedWebActivityService;->d:I

    new-instance v0, Landroidx/browser/trusted/TrustedWebActivityService$a;

    invoke-direct {v0, p0}, Landroidx/browser/trusted/TrustedWebActivityService$a;-><init>(Landroidx/browser/trusted/TrustedWebActivityService;)V

    iput-object v0, p0, Landroidx/browser/trusted/TrustedWebActivityService;->f:Landroid/support/customtabs/trusted/ITrustedWebActivityService$Stub;

    return-void
.end method

.method private static a(Ljava/lang/String;)Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Ljava/util/Locale;->ROOT:Ljava/util/Locale;

    invoke-virtual {p0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object p0

    const/16 v1, 0x20

    const/16 v2, 0x5f

    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p0, "_channel_id"

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method private b()V
    .registers 3

    iget-object v0, p0, Landroidx/browser/trusted/TrustedWebActivityService;->c:Landroid/app/NotificationManager;

    if-eqz v0, :cond_5

    return-void

    :cond_5
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public abstract c()Lg/g;
.end method

.method public d(Ljava/lang/String;)Z
    .registers 4

    invoke-direct {p0}, Landroidx/browser/trusted/TrustedWebActivityService;->b()V

    invoke-static {p0}, Landroidx/core/app/s0;->c(Landroid/content/Context;)Landroidx/core/app/s0;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/core/app/s0;->a()Z

    move-result v0

    if-nez v0, :cond_f

    const/4 p1, 0x0

    return p1

    :cond_f
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-ge v0, v1, :cond_17

    const/4 p1, 0x1

    return p1

    :cond_17
    iget-object v0, p0, Landroidx/browser/trusted/TrustedWebActivityService;->c:Landroid/app/NotificationManager;

    invoke-static {p1}, Landroidx/browser/trusted/TrustedWebActivityService;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-static {v0, p1}, Landroidx/browser/trusted/b;->b(Landroid/app/NotificationManager;Ljava/lang/String;)Z

    move-result p1

    return p1
.end method

.method public e(Ljava/lang/String;I)V
    .registers 4

    invoke-direct {p0}, Landroidx/browser/trusted/TrustedWebActivityService;->b()V

    iget-object v0, p0, Landroidx/browser/trusted/TrustedWebActivityService;->c:Landroid/app/NotificationManager;

    invoke-virtual {v0, p1, p2}, Landroid/app/NotificationManager;->cancel(Ljava/lang/String;I)V

    return-void
.end method

.method public f(Ljava/lang/String;Landroid/os/Bundle;Landroidx/browser/trusted/c;)Landroid/os/Bundle;
    .registers 4

    const/4 p1, 0x0

    return-object p1
.end method

.method public g()[Landroid/os/Parcelable;
    .registers 3

    invoke-direct {p0}, Landroidx/browser/trusted/TrustedWebActivityService;->b()V

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_10

    iget-object v0, p0, Landroidx/browser/trusted/TrustedWebActivityService;->c:Landroid/app/NotificationManager;

    invoke-static {v0}, Landroidx/browser/trusted/a;->a(Landroid/app/NotificationManager;)[Landroid/os/Parcelable;

    move-result-object v0

    return-object v0

    :cond_10
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "onGetActiveNotifications cannot be called pre-M."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public h()Landroid/os/Bundle;
    .registers 4

    invoke-virtual {p0}, Landroidx/browser/trusted/TrustedWebActivityService;->i()I

    move-result v0

    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    const/4 v2, -0x1

    if-ne v0, v2, :cond_d

    return-object v1

    :cond_d
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-static {v2, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    const-string v2, "android.support.customtabs.trusted.SMALL_ICON_BITMAP"

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    return-object v1
.end method

.method public i()I
    .registers 5

    const/4 v0, -0x1

    :try_start_1
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    new-instance v2, Landroid/content/ComponentName;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const/16 v3, 0x80

    invoke-virtual {v1, v2, v3}, Landroid/content/pm/PackageManager;->getServiceInfo(Landroid/content/ComponentName;I)Landroid/content/pm/ServiceInfo;

    move-result-object v1

    iget-object v1, v1, Landroid/content/pm/ServiceInfo;->metaData:Landroid/os/Bundle;

    if-nez v1, :cond_19

    return v0

    :cond_19
    const-string v2, "android.support.customtabs.trusted.SMALL_ICON"

    invoke-virtual {v1, v2, v0}, Landroid/os/BaseBundle;->getInt(Ljava/lang/String;I)I

    move-result v0
    :try_end_1f
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1f} :catch_1f

    :catch_1f
    return v0
.end method

.method public j(Ljava/lang/String;ILandroid/app/Notification;Ljava/lang/String;)Z
    .registers 8

    invoke-direct {p0}, Landroidx/browser/trusted/TrustedWebActivityService;->b()V

    invoke-static {p0}, Landroidx/core/app/s0;->c(Landroid/content/Context;)Landroidx/core/app/s0;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/core/app/s0;->a()Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_f

    return v1

    :cond_f
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1a

    if-lt v0, v2, :cond_28

    invoke-static {p4}, Landroidx/browser/trusted/TrustedWebActivityService;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Landroidx/browser/trusted/TrustedWebActivityService;->c:Landroid/app/NotificationManager;

    invoke-static {p0, v2, p3, v0, p4}, Landroidx/browser/trusted/b;->a(Landroid/content/Context;Landroid/app/NotificationManager;Landroid/app/Notification;Ljava/lang/String;Ljava/lang/String;)Landroid/app/Notification;

    move-result-object p3

    iget-object p4, p0, Landroidx/browser/trusted/TrustedWebActivityService;->c:Landroid/app/NotificationManager;

    invoke-static {p4, v0}, Landroidx/browser/trusted/b;->b(Landroid/app/NotificationManager;Ljava/lang/String;)Z

    move-result p4

    if-nez p4, :cond_28

    return v1

    :cond_28
    iget-object p4, p0, Landroidx/browser/trusted/TrustedWebActivityService;->c:Landroid/app/NotificationManager;

    invoke-virtual {p4, p1, p2, p3}, Landroid/app/NotificationManager;->notify(Ljava/lang/String;ILandroid/app/Notification;)V

    const/4 p1, 0x1

    return p1
.end method

.method public final onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .registers 2

    iget-object p1, p0, Landroidx/browser/trusted/TrustedWebActivityService;->f:Landroid/support/customtabs/trusted/ITrustedWebActivityService$Stub;

    return-object p1
.end method

.method public onCreate()V
    .registers 2

    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    const-string v0, "notification"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    iput-object v0, p0, Landroidx/browser/trusted/TrustedWebActivityService;->c:Landroid/app/NotificationManager;

    return-void
.end method

.method public final onUnbind(Landroid/content/Intent;)Z
    .registers 3

    const/4 v0, -0x1

    iput v0, p0, Landroidx/browser/trusted/TrustedWebActivityService;->d:I

    invoke-super {p0, p1}, Landroid/app/Service;->onUnbind(Landroid/content/Intent;)Z

    move-result p1

    return p1
.end method
