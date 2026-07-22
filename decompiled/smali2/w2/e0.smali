.class public final Lw2/e0;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lw2/d0;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 2

    const-class v0, Lw2/d0;

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v1

    invoke-static {v0, v1}, Ljava/util/ServiceLoader;->load(Ljava/lang/Class;Ljava/lang/ClassLoader;)Ljava/util/ServiceLoader;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ServiceLoader;->iterator()Ljava/util/Iterator;

    move-result-object v0

    invoke-static {v0}, Lu2/c;->a(Ljava/util/Iterator;)Lu2/b;

    move-result-object v0

    invoke-static {v0}, Lu2/c;->e(Lu2/b;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lw2/e0;->a:Ljava/util/List;

    return-void
.end method

.method public static final a(Li2/g;Ljava/lang/Throwable;)V
    .registers 6

    sget-object v0, Lw2/e0;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_27

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lw2/d0;

    :try_start_12
    invoke-interface {v1, p0, p1}, Lw2/d0;->u(Li2/g;Ljava/lang/Throwable;)V
    :try_end_15
    .catchall {:try_start_12 .. :try_end_15} :catchall_16

    goto :goto_6

    :catchall_16
    move-exception v1

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->getUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v3

    invoke-static {p1, v1}, Lw2/f0;->b(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;

    move-result-object v1

    invoke-interface {v3, v2, v1}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    goto :goto_6

    :cond_27
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    :try_start_2b
    sget-object v1, Lg2/k;->c:Lg2/k$a;

    new-instance v1, Lw2/o0;

    invoke-direct {v1, p0}, Lw2/o0;-><init>(Li2/g;)V

    invoke-static {p1, v1}, Lg2/a;->a(Ljava/lang/Throwable;Ljava/lang/Throwable;)V

    sget-object p0, Lg2/q;->a:Lg2/q;

    invoke-static {p0}, Lg2/k;->a(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_3a
    .catchall {:try_start_2b .. :try_end_3a} :catchall_3b

    goto :goto_45

    :catchall_3b
    move-exception p0

    sget-object v1, Lg2/k;->c:Lg2/k$a;

    invoke-static {p0}, Lg2/l;->a(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object p0

    invoke-static {p0}, Lg2/k;->a(Ljava/lang/Object;)Ljava/lang/Object;

    :goto_45
    invoke-virtual {v0}, Ljava/lang/Thread;->getUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object p0

    invoke-interface {p0, v0, p1}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    return-void
.end method
