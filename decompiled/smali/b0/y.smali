.class final Lb0/y;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lb0/y$a;
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private b(Landroid/content/pm/PackageManager;)Ljava/util/List;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/pm/PackageManager;",
            ")",
            "Ljava/util/List<",
            "Landroid/content/pm/ResolveInfo;",
            ">;"
        }
    .end annotation

    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.CALL"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v1, "tel:123123"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x21

    if-lt v1, v2, :cond_21

    const-wide/16 v1, 0x0

    invoke-static {v1, v2}, Landroid/content/pm/PackageManager$ResolveInfoFlags;->of(J)Landroid/content/pm/PackageManager$ResolveInfoFlags;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;Landroid/content/pm/PackageManager$ResolveInfoFlags;)Ljava/util/List;

    move-result-object p1

    return-object p1

    :cond_21
    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object p1

    return-object p1
.end method

.method private c(Landroid/content/Context;)Z
    .registers 3

    const-string v0, "bluetooth"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/bluetooth/BluetoothManager;

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothManager;->getAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object p1

    invoke-virtual {p1}, Landroid/bluetooth/BluetoothAdapter;->isEnabled()Z

    move-result p1

    return p1
.end method

.method private d(Landroid/content/Context;)Z
    .registers 4

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1c

    if-lt v0, v1, :cond_17

    const-class v0, Landroid/location/LocationManager;

    invoke-static {p1, v0}, Landroidx/core/app/g;->a(Landroid/content/Context;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/location/LocationManager;

    if-nez p1, :cond_12

    const/4 p1, 0x0

    return p1

    :cond_12
    invoke-static {p1}, Lb0/x;->a(Landroid/location/LocationManager;)Z

    move-result p1

    return p1

    :cond_17
    invoke-static {p1}, Lb0/y;->e(Landroid/content/Context;)Z

    move-result p1

    return p1
.end method

.method private static e(Landroid/content/Context;)Z
    .registers 3

    const/4 v0, 0x0

    :try_start_1
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object p0

    const-string v1, "location_mode"

    invoke-static {p0, v1}, Landroid/provider/Settings$Secure;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;)I

    move-result p0
    :try_end_b
    .catch Landroid/provider/Settings$SettingNotFoundException; {:try_start_1 .. :try_end_b} :catch_f

    if-eqz p0, :cond_e

    const/4 v0, 0x1

    :cond_e
    return v0

    :catch_f
    move-exception p0

    invoke-virtual {p0}, Ljava/lang/Throwable;->printStackTrace()V

    return v0
.end method


# virtual methods
.method a(ILandroid/content/Context;Lb0/y$a;Lb0/b;)V
    .registers 8

    if-nez p2, :cond_11

    const-string p1, "permissions_handler"

    const-string p2, "Context cannot be null."

    invoke-static {p1, p2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    const-string p1, "PermissionHandler.ServiceManager"

    const-string p2, "Android context cannot be null."

    invoke-interface {p4, p1, p2}, Lb0/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    return-void

    :cond_11
    const/4 p4, 0x3

    if-eq p1, p4, :cond_83

    const/4 p4, 0x4

    if-eq p1, p4, :cond_83

    const/4 p4, 0x5

    if-ne p1, p4, :cond_1b

    goto :goto_83

    :cond_1b
    const/16 v0, 0x15

    if-ne p1, v0, :cond_27

    invoke-direct {p0, p2}, Lb0/y;->c(Landroid/content/Context;)Z

    move-result p1

    invoke-interface {p3, p1}, Lb0/y$a;->a(I)V

    return-void

    :cond_27
    const/16 v0, 0x8

    const/4 v1, 0x1

    const/4 v2, 0x2

    if-ne p1, v0, :cond_6f

    invoke-virtual {p2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object p1

    const-string v0, "android.hardware.telephony"

    invoke-virtual {p1, v0}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3d

    invoke-interface {p3, v2}, Lb0/y$a;->a(I)V

    return-void

    :cond_3d
    const-string v0, "phone"

    invoke-virtual {p2, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroid/telephony/TelephonyManager;

    if-eqz p2, :cond_6b

    invoke-virtual {p2}, Landroid/telephony/TelephonyManager;->getPhoneType()I

    move-result v0

    if-nez v0, :cond_4e

    goto :goto_6b

    :cond_4e
    invoke-direct {p0, p1}, Lb0/y;->b(Landroid/content/pm/PackageManager;)Ljava/util/List;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result p1

    if-eqz p1, :cond_5c

    invoke-interface {p3, v2}, Lb0/y$a;->a(I)V

    return-void

    :cond_5c
    invoke-virtual {p2}, Landroid/telephony/TelephonyManager;->getSimState()I

    move-result p1

    if-eq p1, p4, :cond_67

    const/4 p1, 0x0

    invoke-interface {p3, p1}, Lb0/y$a;->a(I)V

    return-void

    :cond_67
    invoke-interface {p3, v1}, Lb0/y$a;->a(I)V

    return-void

    :cond_6b
    :goto_6b
    invoke-interface {p3, v2}, Lb0/y$a;->a(I)V

    return-void

    :cond_6f
    const/16 p2, 0x10

    if-ne p1, p2, :cond_7f

    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 p2, 0x17

    if-lt p1, p2, :cond_7a

    goto :goto_7b

    :cond_7a
    const/4 v1, 0x2

    :goto_7b
    invoke-interface {p3, v1}, Lb0/y$a;->a(I)V

    return-void

    :cond_7f
    invoke-interface {p3, v2}, Lb0/y$a;->a(I)V

    return-void

    :cond_83
    :goto_83
    invoke-direct {p0, p2}, Lb0/y;->d(Landroid/content/Context;)Z

    move-result p1

    invoke-interface {p3, p1}, Lb0/y$a;->a(I)V

    return-void
.end method
