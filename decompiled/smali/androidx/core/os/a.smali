.class public final Landroidx/core/os/a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/os/a$a;
    }
.end annotation


# static fields
.field public static final a:Landroidx/core/os/a;

.field public static final b:I

.field public static final c:I

.field public static final d:I

.field public static final e:I


# direct methods
.method static constructor <clinit>()V
    .registers 5

    new-instance v0, Landroidx/core/os/a;

    invoke-direct {v0}, Landroidx/core/os/a;-><init>()V

    sput-object v0, Landroidx/core/os/a;->a:Landroidx/core/os/a;

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/4 v1, 0x0

    const/16 v2, 0x1e

    if-lt v0, v2, :cond_15

    sget-object v3, Landroidx/core/os/a$a;->a:Landroidx/core/os/a$a;

    invoke-virtual {v3, v2}, Landroidx/core/os/a$a;->a(I)I

    move-result v3

    goto :goto_16

    :cond_15
    const/4 v3, 0x0

    :goto_16
    sput v3, Landroidx/core/os/a;->b:I

    if-lt v0, v2, :cond_23

    sget-object v3, Landroidx/core/os/a$a;->a:Landroidx/core/os/a$a;

    const/16 v4, 0x1f

    invoke-virtual {v3, v4}, Landroidx/core/os/a$a;->a(I)I

    move-result v3

    goto :goto_24

    :cond_23
    const/4 v3, 0x0

    :goto_24
    sput v3, Landroidx/core/os/a;->c:I

    if-lt v0, v2, :cond_31

    sget-object v3, Landroidx/core/os/a$a;->a:Landroidx/core/os/a$a;

    const/16 v4, 0x21

    invoke-virtual {v3, v4}, Landroidx/core/os/a$a;->a(I)I

    move-result v3

    goto :goto_32

    :cond_31
    const/4 v3, 0x0

    :goto_32
    sput v3, Landroidx/core/os/a;->d:I

    if-lt v0, v2, :cond_3f

    sget-object v0, Landroidx/core/os/a$a;->a:Landroidx/core/os/a$a;

    const v1, 0xf4240

    invoke-virtual {v0, v1}, Landroidx/core/os/a$a;->a(I)I

    move-result v1

    :cond_3f
    sput v1, Landroidx/core/os/a;->e:I

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final a(Ljava/lang/String;Ljava/lang/String;)Z
    .registers 5

    const-string v0, "codename"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "buildCodename"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "REL"

    invoke-static {v0, p1}, Lkotlin/jvm/internal/k;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_14

    return v1

    :cond_14
    sget-object v0, Ljava/util/Locale;->ROOT:Ljava/util/Locale;

    invoke-virtual {p1, v0}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object p1

    const-string v2, "this as java.lang.String).toUpperCase(Locale.ROOT)"

    invoke-static {p1, v2}, Lkotlin/jvm/internal/k;->d(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object p0

    invoke-static {p0, v2}, Lkotlin/jvm/internal/k;->d(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1, p0}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result p0

    if-ltz p0, :cond_2d

    const/4 v1, 0x1

    :cond_2d
    return v1
.end method

.method public static final b()Z
    .registers 2

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x21

    if-ge v0, v1, :cond_1c

    const/16 v1, 0x20

    if-lt v0, v1, :cond_1a

    sget-object v0, Landroid/os/Build$VERSION;->CODENAME:Ljava/lang/String;

    const-string v1, "CODENAME"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/k;->d(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v1, "Tiramisu"

    invoke-static {v1, v0}, Landroidx/core/os/a;->a(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1a

    goto :goto_1c

    :cond_1a
    const/4 v0, 0x0

    goto :goto_1d

    :cond_1c
    :goto_1c
    const/4 v0, 0x1

    :goto_1d
    return v0
.end method

.method public static final c()Z
    .registers 2

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x22

    if-ge v0, v1, :cond_1c

    const/16 v1, 0x21

    if-lt v0, v1, :cond_1a

    sget-object v0, Landroid/os/Build$VERSION;->CODENAME:Ljava/lang/String;

    const-string v1, "CODENAME"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/k;->d(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v1, "UpsideDownCake"

    invoke-static {v1, v0}, Landroidx/core/os/a;->a(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1a

    goto :goto_1c

    :cond_1a
    const/4 v0, 0x0

    goto :goto_1d

    :cond_1c
    :goto_1c
    const/4 v0, 0x1

    :goto_1d
    return v0
.end method
