.class public final Landroidx/profileinstaller/o;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/profileinstaller/o$c;,
        Landroidx/profileinstaller/o$b;,
        Landroidx/profileinstaller/o$a;
    }
.end annotation


# static fields
.field private static final a:Landroidx/concurrent/futures/c;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/concurrent/futures/c<",
            "Landroidx/profileinstaller/o$c;",
            ">;"
        }
    .end annotation
.end field

.field private static final b:Ljava/lang/Object;

.field private static c:Landroidx/profileinstaller/o$c;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    invoke-static {}, Landroidx/concurrent/futures/c;->q()Landroidx/concurrent/futures/c;

    move-result-object v0

    sput-object v0, Landroidx/profileinstaller/o;->a:Landroidx/concurrent/futures/c;

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroidx/profileinstaller/o;->b:Ljava/lang/Object;

    const/4 v0, 0x0

    sput-object v0, Landroidx/profileinstaller/o;->c:Landroidx/profileinstaller/o$c;

    return-void
.end method

.method private static a(Landroid/content/Context;)J
    .registers 4

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x21

    if-lt v1, v2, :cond_15

    invoke-static {v0, p0}, Landroidx/profileinstaller/o$a;->a(Landroid/content/pm/PackageManager;Landroid/content/Context;)Landroid/content/pm/PackageInfo;

    move-result-object p0

    :goto_12
    iget-wide v0, p0, Landroid/content/pm/PackageInfo;->lastUpdateTime:J

    return-wide v0

    :cond_15
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object p0

    const/4 v1, 0x0

    invoke-virtual {v0, p0, v1}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object p0

    goto :goto_12
.end method

.method private static b(IZZ)Landroidx/profileinstaller/o$c;
    .registers 4

    new-instance v0, Landroidx/profileinstaller/o$c;

    invoke-direct {v0, p0, p1, p2}, Landroidx/profileinstaller/o$c;-><init>(IZZ)V

    sput-object v0, Landroidx/profileinstaller/o;->c:Landroidx/profileinstaller/o$c;

    sget-object p0, Landroidx/profileinstaller/o;->a:Landroidx/concurrent/futures/c;

    invoke-virtual {p0, v0}, Landroidx/concurrent/futures/c;->o(Ljava/lang/Object;)Z

    sget-object p0, Landroidx/profileinstaller/o;->c:Landroidx/profileinstaller/o$c;

    return-object p0
.end method

.method static c(Landroid/content/Context;Z)Landroidx/profileinstaller/o$c;
    .registers 20

    if-nez p1, :cond_7

    sget-object v0, Landroidx/profileinstaller/o;->c:Landroidx/profileinstaller/o$c;

    if-eqz v0, :cond_7

    return-object v0

    :cond_7
    sget-object v1, Landroidx/profileinstaller/o;->b:Ljava/lang/Object;

    monitor-enter v1

    if-nez p1, :cond_12

    :try_start_c
    sget-object v0, Landroidx/profileinstaller/o;->c:Landroidx/profileinstaller/o$c;

    if-eqz v0, :cond_12

    monitor-exit v1

    return-object v0

    :cond_12
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1c

    const/4 v3, 0x0

    if-lt v0, v2, :cond_dc

    const/16 v2, 0x1e

    if-ne v0, v2, :cond_1f

    goto/16 :goto_dc

    :cond_1f
    new-instance v0, Ljava/io/File;

    new-instance v2, Ljava/io/File;

    const-string v4, "/data/misc/profiles/ref/"

    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v4, v5}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const-string v4, "primary.prof"

    invoke-direct {v0, v2, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v4

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    const-wide/16 v6, 0x0

    const/4 v2, 0x1

    if-eqz v0, :cond_44

    cmp-long v0, v4, v6

    if-lez v0, :cond_44

    const/4 v0, 0x1

    goto :goto_45

    :cond_44
    const/4 v0, 0x0

    :goto_45
    new-instance v8, Ljava/io/File;

    new-instance v9, Ljava/io/File;

    const-string v10, "/data/misc/profiles/cur/0/"

    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v9, v10, v11}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const-string v10, "primary.prof"

    invoke-direct {v8, v9, v10}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v8}, Ljava/io/File;->length()J

    move-result-wide v16

    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v8
    :try_end_5f
    .catchall {:try_start_c .. :try_end_5f} :catchall_e4

    if-eqz v8, :cond_67

    cmp-long v8, v16, v6

    if-lez v8, :cond_67

    const/4 v6, 0x1

    goto :goto_68

    :cond_67
    const/4 v6, 0x0

    :goto_68
    :try_start_68
    invoke-static/range {p0 .. p0}, Landroidx/profileinstaller/o;->a(Landroid/content/Context;)J

    move-result-wide v14
    :try_end_6c
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_68 .. :try_end_6c} :catch_d4
    .catchall {:try_start_68 .. :try_end_6c} :catchall_e4

    :try_start_6c
    new-instance v7, Ljava/io/File;

    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v8

    const-string v9, "profileInstalled"

    invoke-direct {v7, v8, v9}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    const/4 v8, 0x0

    invoke-virtual {v7}, Ljava/io/File;->exists()Z

    move-result v9
    :try_end_7c
    .catchall {:try_start_6c .. :try_end_7c} :catchall_e4

    if-eqz v9, :cond_8b

    :try_start_7e
    invoke-static {v7}, Landroidx/profileinstaller/o$b;->a(Ljava/io/File;)Landroidx/profileinstaller/o$b;

    move-result-object v8
    :try_end_82
    .catch Ljava/io/IOException; {:try_start_7e .. :try_end_82} :catch_83
    .catchall {:try_start_7e .. :try_end_82} :catchall_e4

    goto :goto_8b

    :catch_83
    const/high16 v2, 0x20000

    :try_start_85
    invoke-static {v2, v0, v6}, Landroidx/profileinstaller/o;->b(IZZ)Landroidx/profileinstaller/o$c;

    move-result-object v0

    monitor-exit v1

    return-object v0

    :cond_8b
    :goto_8b
    const/4 v9, 0x2

    if-eqz v8, :cond_9b

    iget-wide v10, v8, Landroidx/profileinstaller/o$b;->c:J

    cmp-long v12, v10, v14

    if-nez v12, :cond_9b

    iget v10, v8, Landroidx/profileinstaller/o$b;->b:I

    if-ne v10, v9, :cond_99

    goto :goto_9b

    :cond_99
    move v3, v10

    goto :goto_a2

    :cond_9b
    :goto_9b
    if-eqz v0, :cond_9f

    const/4 v3, 0x1

    goto :goto_a2

    :cond_9f
    if-eqz v6, :cond_a2

    const/4 v3, 0x2

    :cond_a2
    :goto_a2
    if-eqz p1, :cond_a9

    if-eqz v6, :cond_a9

    if-eq v3, v2, :cond_a9

    const/4 v3, 0x2

    :cond_a9
    if-eqz v8, :cond_b8

    iget v10, v8, Landroidx/profileinstaller/o$b;->b:I

    if-ne v10, v9, :cond_b8

    if-ne v3, v2, :cond_b8

    iget-wide v9, v8, Landroidx/profileinstaller/o$b;->d:J

    cmp-long v2, v4, v9

    if-gez v2, :cond_b8

    const/4 v3, 0x3

    :cond_b8
    new-instance v2, Landroidx/profileinstaller/o$b;

    const/4 v12, 0x1

    move-object v11, v2

    move v13, v3

    invoke-direct/range {v11 .. v17}, Landroidx/profileinstaller/o$b;-><init>(IIJJ)V

    if-eqz v8, :cond_c8

    invoke-virtual {v8, v2}, Landroidx/profileinstaller/o$b;->equals(Ljava/lang/Object;)Z

    move-result v4
    :try_end_c6
    .catchall {:try_start_85 .. :try_end_c6} :catchall_e4

    if-nez v4, :cond_ce

    :cond_c8
    :try_start_c8
    invoke-virtual {v2, v7}, Landroidx/profileinstaller/o$b;->b(Ljava/io/File;)V
    :try_end_cb
    .catch Ljava/io/IOException; {:try_start_c8 .. :try_end_cb} :catch_cc
    .catchall {:try_start_c8 .. :try_end_cb} :catchall_e4

    goto :goto_ce

    :catch_cc
    const/high16 v3, 0x30000

    :cond_ce
    :goto_ce
    :try_start_ce
    invoke-static {v3, v0, v6}, Landroidx/profileinstaller/o;->b(IZZ)Landroidx/profileinstaller/o$c;

    move-result-object v0

    monitor-exit v1

    return-object v0

    :catch_d4
    const/high16 v2, 0x10000

    invoke-static {v2, v0, v6}, Landroidx/profileinstaller/o;->b(IZZ)Landroidx/profileinstaller/o$c;

    move-result-object v0

    monitor-exit v1

    return-object v0

    :cond_dc
    :goto_dc
    const/high16 v0, 0x40000

    invoke-static {v0, v3, v3}, Landroidx/profileinstaller/o;->b(IZZ)Landroidx/profileinstaller/o$c;

    move-result-object v0

    monitor-exit v1

    return-object v0

    :catchall_e4
    move-exception v0

    monitor-exit v1
    :try_end_e6
    .catchall {:try_start_ce .. :try_end_e6} :catchall_e4

    throw v0
.end method
