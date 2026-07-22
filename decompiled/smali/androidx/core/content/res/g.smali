.class public final Landroidx/core/content/res/g;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/content/res/g$c;,
        Landroidx/core/content/res/g$a;,
        Landroidx/core/content/res/g$b;
    }
.end annotation


# static fields
.field private static final a:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal<",
            "Landroid/util/TypedValue;",
            ">;"
        }
    .end annotation
.end field

.field private static final b:Ljava/util/WeakHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/WeakHashMap<",
            "Landroidx/core/content/res/g$c;",
            "Landroid/util/SparseArray<",
            "Landroidx/core/content/res/g$b;",
            ">;>;"
        }
    .end annotation
.end field

.field private static final c:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Ljava/lang/ThreadLocal;

    invoke-direct {v0}, Ljava/lang/ThreadLocal;-><init>()V

    sput-object v0, Landroidx/core/content/res/g;->a:Ljava/lang/ThreadLocal;

    new-instance v0, Ljava/util/WeakHashMap;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/WeakHashMap;-><init>(I)V

    sput-object v0, Landroidx/core/content/res/g;->b:Ljava/util/WeakHashMap;

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroidx/core/content/res/g;->c:Ljava/lang/Object;

    return-void
.end method

.method private static a(Landroidx/core/content/res/g$c;ILandroid/content/res/ColorStateList;Landroid/content/res/Resources$Theme;)V
    .registers 7

    sget-object v0, Landroidx/core/content/res/g;->c:Ljava/lang/Object;

    monitor-enter v0

    :try_start_3
    sget-object v1, Landroidx/core/content/res/g;->b:Ljava/util/WeakHashMap;

    invoke-virtual {v1, p0}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/util/SparseArray;

    if-nez v2, :cond_15

    new-instance v2, Landroid/util/SparseArray;

    invoke-direct {v2}, Landroid/util/SparseArray;-><init>()V

    invoke-virtual {v1, p0, v2}, Ljava/util/WeakHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_15
    new-instance v1, Landroidx/core/content/res/g$b;

    iget-object p0, p0, Landroidx/core/content/res/g$c;->a:Landroid/content/res/Resources;

    invoke-virtual {p0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object p0

    invoke-direct {v1, p2, p0, p3}, Landroidx/core/content/res/g$b;-><init>(Landroid/content/res/ColorStateList;Landroid/content/res/Configuration;Landroid/content/res/Resources$Theme;)V

    invoke-virtual {v2, p1, v1}, Landroid/util/SparseArray;->append(ILjava/lang/Object;)V

    monitor-exit v0

    return-void

    :catchall_25
    move-exception p0

    monitor-exit v0
    :try_end_27
    .catchall {:try_start_3 .. :try_end_27} :catchall_25

    throw p0
.end method

.method private static b(Landroidx/core/content/res/g$c;I)Landroid/content/res/ColorStateList;
    .registers 7

    sget-object v0, Landroidx/core/content/res/g;->c:Ljava/lang/Object;

    monitor-enter v0

    :try_start_3
    sget-object v1, Landroidx/core/content/res/g;->b:Ljava/util/WeakHashMap;

    invoke-virtual {v1, p0}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/util/SparseArray;

    if-eqz v1, :cond_42

    invoke-virtual {v1}, Landroid/util/SparseArray;->size()I

    move-result v2

    if-lez v2, :cond_42

    invoke-virtual {v1, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/core/content/res/g$b;

    if-eqz v2, :cond_42

    iget-object v3, v2, Landroidx/core/content/res/g$b;->b:Landroid/content/res/Configuration;

    iget-object v4, p0, Landroidx/core/content/res/g$c;->a:Landroid/content/res/Resources;

    invoke-virtual {v4}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/content/res/Configuration;->equals(Landroid/content/res/Configuration;)Z

    move-result v3

    if-eqz v3, :cond_3f

    iget-object p0, p0, Landroidx/core/content/res/g$c;->b:Landroid/content/res/Resources$Theme;

    if-nez p0, :cond_31

    iget v3, v2, Landroidx/core/content/res/g$b;->c:I

    if-eqz v3, :cond_3b

    :cond_31
    if-eqz p0, :cond_3f

    iget v3, v2, Landroidx/core/content/res/g$b;->c:I

    invoke-virtual {p0}, Landroid/content/res/Resources$Theme;->hashCode()I

    move-result p0

    if-ne v3, p0, :cond_3f

    :cond_3b
    iget-object p0, v2, Landroidx/core/content/res/g$b;->a:Landroid/content/res/ColorStateList;

    monitor-exit v0

    return-object p0

    :cond_3f
    invoke-virtual {v1, p1}, Landroid/util/SparseArray;->remove(I)V

    :cond_42
    monitor-exit v0

    const/4 p0, 0x0

    return-object p0

    :catchall_45
    move-exception p0

    monitor-exit v0
    :try_end_47
    .catchall {:try_start_3 .. :try_end_47} :catchall_45

    throw p0
.end method

.method public static c(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)Landroid/content/res/ColorStateList;
    .registers 5

    new-instance v0, Landroidx/core/content/res/g$c;

    invoke-direct {v0, p0, p2}, Landroidx/core/content/res/g$c;-><init>(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;)V

    invoke-static {v0, p1}, Landroidx/core/content/res/g;->b(Landroidx/core/content/res/g$c;I)Landroid/content/res/ColorStateList;

    move-result-object v1

    if-eqz v1, :cond_c

    return-object v1

    :cond_c
    invoke-static {p0, p1, p2}, Landroidx/core/content/res/g;->e(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)Landroid/content/res/ColorStateList;

    move-result-object v1

    if-eqz v1, :cond_16

    invoke-static {v0, p1, v1, p2}, Landroidx/core/content/res/g;->a(Landroidx/core/content/res/g$c;ILandroid/content/res/ColorStateList;Landroid/content/res/Resources$Theme;)V

    return-object v1

    :cond_16
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_21

    invoke-static {p0, p1, p2}, Landroidx/core/content/res/g$a;->b(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)Landroid/content/res/ColorStateList;

    move-result-object p0

    return-object p0

    :cond_21
    invoke-virtual {p0, p1}, Landroid/content/res/Resources;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object p0

    return-object p0
.end method

.method private static d()Landroid/util/TypedValue;
    .registers 2

    sget-object v0, Landroidx/core/content/res/g;->a:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/util/TypedValue;

    if-nez v1, :cond_12

    new-instance v1, Landroid/util/TypedValue;

    invoke-direct {v1}, Landroid/util/TypedValue;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V

    :cond_12
    return-object v1
.end method

.method private static e(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)Landroid/content/res/ColorStateList;
    .registers 5

    invoke-static {p0, p1}, Landroidx/core/content/res/g;->f(Landroid/content/res/Resources;I)Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_8

    return-object v1

    :cond_8
    invoke-virtual {p0, p1}, Landroid/content/res/Resources;->getXml(I)Landroid/content/res/XmlResourceParser;

    move-result-object p1

    :try_start_c
    invoke-static {p0, p1, p2}, Landroidx/core/content/res/c;->a(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/content/res/Resources$Theme;)Landroid/content/res/ColorStateList;

    move-result-object p0
    :try_end_10
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_10} :catch_11

    return-object p0

    :catch_11
    move-exception p0

    const-string p1, "ResourcesCompat"

    const-string p2, "Failed to inflate ColorStateList, leaving it to the framework"

    invoke-static {p1, p2, p0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    return-object v1
.end method

.method private static f(Landroid/content/res/Resources;I)Z
    .registers 4

    invoke-static {}, Landroidx/core/content/res/g;->d()Landroid/util/TypedValue;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {p0, p1, v0, v1}, Landroid/content/res/Resources;->getValue(ILandroid/util/TypedValue;Z)V

    iget p0, v0, Landroid/util/TypedValue;->type:I

    const/16 p1, 0x1c

    if-lt p0, p1, :cond_13

    const/16 p1, 0x1f

    if-gt p0, p1, :cond_13

    goto :goto_14

    :cond_13
    const/4 v1, 0x0

    :goto_14
    return v1
.end method
