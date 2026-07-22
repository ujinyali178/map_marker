.class public final Landroidx/core/text/a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/text/a$b;,
        Landroidx/core/text/a$a;
    }
.end annotation


# static fields
.field private static a:Ljava/lang/reflect/Method;


# direct methods
.method static constructor <clinit>()V
    .registers 5

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x18

    if-ge v0, v1, :cond_24

    :try_start_6
    const-string v0, "libcore.icu.ICU"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    const-string v1, "addLikelySubtags"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Class;

    const/4 v3, 0x0

    const-class v4, Ljava/util/Locale;

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Landroidx/core/text/a;->a:Ljava/lang/reflect/Method;
    :try_end_1c
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_1c} :catch_1d

    goto :goto_24

    :catch_1d
    move-exception v0

    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    :cond_24
    :goto_24
    return-void
.end method

.method public static a(Ljava/util/Locale;)Ljava/lang/String;
    .registers 5

    const-string v0, "ICUCompat"

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x18

    if-lt v1, v2, :cond_15

    invoke-static {p0}, Landroidx/core/text/a$b;->b(Ljava/util/Locale;)Landroid/icu/util/ULocale;

    move-result-object p0

    invoke-static {p0}, Landroidx/core/text/a$b;->a(Ljava/lang/Object;)Landroid/icu/util/ULocale;

    move-result-object p0

    invoke-static {p0}, Landroidx/core/text/a$b;->c(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_15
    const/4 v1, 0x1

    :try_start_16
    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    sget-object v2, Landroidx/core/text/a;->a:Ljava/lang/reflect/Method;

    const/4 v3, 0x0

    invoke-virtual {v2, v3, v1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Locale;

    invoke-static {v1}, Landroidx/core/text/a$a;->a(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object p0
    :try_end_28
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_16 .. :try_end_28} :catch_2b
    .catch Ljava/lang/IllegalAccessException; {:try_start_16 .. :try_end_28} :catch_29

    return-object p0

    :catch_29
    move-exception v1

    goto :goto_2c

    :catch_2b
    move-exception v1

    :goto_2c
    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    invoke-static {p0}, Landroidx/core/text/a$a;->a(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method
