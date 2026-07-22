.class Landroidx/profileinstaller/a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/profileinstaller/a$b;,
        Landroidx/profileinstaller/a$a;
    }
.end annotation


# direct methods
.method static a(Ljava/io/File;)Z
    .registers 7

    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v0

    const/4 v1, 0x1

    if-eqz v0, :cond_25

    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object p0

    const/4 v0, 0x0

    if-nez p0, :cond_f

    return v0

    :cond_f
    array-length v2, p0

    const/4 v3, 0x0

    const/4 v4, 0x1

    :goto_12
    if-ge v3, v2, :cond_24

    aget-object v5, p0, v3

    invoke-static {v5}, Landroidx/profileinstaller/a;->a(Ljava/io/File;)Z

    move-result v5

    if-eqz v5, :cond_20

    if-eqz v4, :cond_20

    const/4 v4, 0x1

    goto :goto_21

    :cond_20
    const/4 v4, 0x0

    :goto_21
    add-int/lit8 v3, v3, 0x1

    goto :goto_12

    :cond_24
    return v4

    :cond_25
    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    return v1
.end method

.method static b(Landroid/content/Context;Landroidx/profileinstaller/ProfileInstallReceiver$a;)V
    .registers 4

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x18

    if-lt v0, v1, :cond_b

    invoke-static {p0}, Landroidx/profileinstaller/a$b;->a(Landroid/content/Context;)Ljava/io/File;

    move-result-object p0

    goto :goto_18

    :cond_b
    const/16 v1, 0x17

    if-lt v0, v1, :cond_14

    invoke-static {p0}, Landroidx/profileinstaller/a$a;->a(Landroid/content/Context;)Ljava/io/File;

    move-result-object p0

    goto :goto_18

    :cond_14
    invoke-virtual {p0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object p0

    :goto_18
    invoke-static {p0}, Landroidx/profileinstaller/a;->a(Ljava/io/File;)Z

    move-result p0

    const/4 v0, 0x0

    if-eqz p0, :cond_22

    const/16 p0, 0xe

    goto :goto_24

    :cond_22
    const/16 p0, 0xf

    :goto_24
    invoke-virtual {p1, p0, v0}, Landroidx/profileinstaller/ProfileInstallReceiver$a;->b(ILjava/lang/Object;)V

    return-void
.end method
