.class public final synthetic Lb2/i;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a()Lu1/j;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lu1/j<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    new-instance v0, Lu1/o;

    invoke-direct {v0}, Lu1/o;-><init>()V

    return-object v0
.end method

.method public static synthetic b(Lb2/a$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 4

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    :try_start_5
    invoke-interface {p0}, Lb2/a$b;->d()Ljava/lang/String;

    move-result-object p0

    const/4 v0, 0x0

    invoke-virtual {p1, v0, p0}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V
    :try_end_d
    .catchall {:try_start_5 .. :try_end_d} :catchall_e

    goto :goto_13

    :catchall_e
    move-exception p0

    invoke-static {p0}, Lb2/a;->a(Ljava/lang/Throwable;)Ljava/util/ArrayList;

    move-result-object p1

    :goto_13
    invoke-interface {p2, p1}, Lu1/b$e;->a(Ljava/lang/Object;)V

    return-void
.end method

.method public static synthetic c(Lb2/a$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 4

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    :try_start_5
    invoke-interface {p0}, Lb2/a$b;->i()Ljava/lang/String;

    move-result-object p0

    const/4 v0, 0x0

    invoke-virtual {p1, v0, p0}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V
    :try_end_d
    .catchall {:try_start_5 .. :try_end_d} :catchall_e

    goto :goto_13

    :catchall_e
    move-exception p0

    invoke-static {p0}, Lb2/a;->a(Ljava/lang/Throwable;)Ljava/util/ArrayList;

    move-result-object p1

    :goto_13
    invoke-interface {p2, p1}, Lu1/b$e;->a(Ljava/lang/Object;)V

    return-void
.end method

.method public static synthetic d(Lb2/a$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 4

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    :try_start_5
    invoke-interface {p0}, Lb2/a$b;->g()Ljava/lang/String;

    move-result-object p0

    const/4 v0, 0x0

    invoke-virtual {p1, v0, p0}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V
    :try_end_d
    .catchall {:try_start_5 .. :try_end_d} :catchall_e

    goto :goto_13

    :catchall_e
    move-exception p0

    invoke-static {p0}, Lb2/a;->a(Ljava/lang/Throwable;)Ljava/util/ArrayList;

    move-result-object p1

    :goto_13
    invoke-interface {p2, p1}, Lu1/b$e;->a(Ljava/lang/Object;)V

    return-void
.end method

.method public static synthetic e(Lb2/a$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 4

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    :try_start_5
    invoke-interface {p0}, Lb2/a$b;->f()Ljava/lang/String;

    move-result-object p0

    const/4 v0, 0x0

    invoke-virtual {p1, v0, p0}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V
    :try_end_d
    .catchall {:try_start_5 .. :try_end_d} :catchall_e

    goto :goto_13

    :catchall_e
    move-exception p0

    invoke-static {p0}, Lb2/a;->a(Ljava/lang/Throwable;)Ljava/util/ArrayList;

    move-result-object p1

    :goto_13
    invoke-interface {p2, p1}, Lu1/b$e;->a(Ljava/lang/Object;)V

    return-void
.end method

.method public static synthetic f(Lb2/a$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 4

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    :try_start_5
    invoke-interface {p0}, Lb2/a$b;->c()Ljava/lang/String;

    move-result-object p0

    const/4 v0, 0x0

    invoke-virtual {p1, v0, p0}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V
    :try_end_d
    .catchall {:try_start_5 .. :try_end_d} :catchall_e

    goto :goto_13

    :catchall_e
    move-exception p0

    invoke-static {p0}, Lb2/a;->a(Ljava/lang/Throwable;)Ljava/util/ArrayList;

    move-result-object p1

    :goto_13
    invoke-interface {p2, p1}, Lu1/b$e;->a(Ljava/lang/Object;)V

    return-void
.end method

.method public static synthetic g(Lb2/a$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 4

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    :try_start_5
    invoke-interface {p0}, Lb2/a$b;->a()Ljava/util/List;

    move-result-object p0

    const/4 v0, 0x0

    invoke-virtual {p1, v0, p0}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V
    :try_end_d
    .catchall {:try_start_5 .. :try_end_d} :catchall_e

    goto :goto_13

    :catchall_e
    move-exception p0

    invoke-static {p0}, Lb2/a;->a(Ljava/lang/Throwable;)Ljava/util/ArrayList;

    move-result-object p1

    :goto_13
    invoke-interface {p2, p1}, Lu1/b$e;->a(Ljava/lang/Object;)V

    return-void
.end method

.method public static synthetic h(Lb2/a$b;Ljava/lang/Object;Lu1/b$e;)V
    .registers 6

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast p1, Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_10

    const/4 p1, 0x0

    goto :goto_20

    :cond_10
    invoke-static {}, Lb2/a$c;->values()[Lb2/a$c;

    move-result-object v2

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    aget-object p1, v2, p1

    :goto_20
    :try_start_20
    invoke-interface {p0, p1}, Lb2/a$b;->h(Lb2/a$c;)Ljava/util/List;

    move-result-object p0

    invoke-virtual {v0, v1, p0}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V
    :try_end_27
    .catchall {:try_start_20 .. :try_end_27} :catchall_28

    goto :goto_2d

    :catchall_28
    move-exception p0

    invoke-static {p0}, Lb2/a;->a(Ljava/lang/Throwable;)Ljava/util/ArrayList;

    move-result-object v0

    :goto_2d
    invoke-interface {p2, v0}, Lu1/b$e;->a(Ljava/lang/Object;)V

    return-void
.end method

.method public static i(Lu1/d;Lb2/a$b;)V
    .registers 7

    invoke-interface {p0}, Lu1/d;->b()Lu1/d$c;

    move-result-object v0

    new-instance v1, Lu1/b;

    invoke-static {}, Lb2/i;->a()Lu1/j;

    move-result-object v2

    const-string v3, "dev.flutter.pigeon.PathProviderApi.getTemporaryPath"

    invoke-direct {v1, p0, v3, v2, v0}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;Lu1/d$c;)V

    const/4 v0, 0x0

    if-eqz p1, :cond_1b

    new-instance v2, Lb2/b;

    invoke-direct {v2, p1}, Lb2/b;-><init>(Lb2/a$b;)V

    invoke-virtual {v1, v2}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_1e

    :cond_1b
    invoke-virtual {v1, v0}, Lu1/b;->e(Lu1/b$d;)V

    :goto_1e
    invoke-interface {p0}, Lu1/d;->b()Lu1/d$c;

    move-result-object v1

    new-instance v2, Lu1/b;

    invoke-static {}, Lb2/i;->a()Lu1/j;

    move-result-object v3

    const-string v4, "dev.flutter.pigeon.PathProviderApi.getApplicationSupportPath"

    invoke-direct {v2, p0, v4, v3, v1}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;Lu1/d$c;)V

    if-eqz p1, :cond_38

    new-instance v1, Lb2/c;

    invoke-direct {v1, p1}, Lb2/c;-><init>(Lb2/a$b;)V

    invoke-virtual {v2, v1}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_3b

    :cond_38
    invoke-virtual {v2, v0}, Lu1/b;->e(Lu1/b$d;)V

    :goto_3b
    invoke-interface {p0}, Lu1/d;->b()Lu1/d$c;

    move-result-object v1

    new-instance v2, Lu1/b;

    invoke-static {}, Lb2/i;->a()Lu1/j;

    move-result-object v3

    const-string v4, "dev.flutter.pigeon.PathProviderApi.getApplicationDocumentsPath"

    invoke-direct {v2, p0, v4, v3, v1}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;Lu1/d$c;)V

    if-eqz p1, :cond_55

    new-instance v1, Lb2/d;

    invoke-direct {v1, p1}, Lb2/d;-><init>(Lb2/a$b;)V

    invoke-virtual {v2, v1}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_58

    :cond_55
    invoke-virtual {v2, v0}, Lu1/b;->e(Lu1/b$d;)V

    :goto_58
    invoke-interface {p0}, Lu1/d;->b()Lu1/d$c;

    move-result-object v1

    new-instance v2, Lu1/b;

    invoke-static {}, Lb2/i;->a()Lu1/j;

    move-result-object v3

    const-string v4, "dev.flutter.pigeon.PathProviderApi.getApplicationCachePath"

    invoke-direct {v2, p0, v4, v3, v1}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;Lu1/d$c;)V

    if-eqz p1, :cond_72

    new-instance v1, Lb2/e;

    invoke-direct {v1, p1}, Lb2/e;-><init>(Lb2/a$b;)V

    invoke-virtual {v2, v1}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_75

    :cond_72
    invoke-virtual {v2, v0}, Lu1/b;->e(Lu1/b$d;)V

    :goto_75
    invoke-interface {p0}, Lu1/d;->b()Lu1/d$c;

    move-result-object v1

    new-instance v2, Lu1/b;

    invoke-static {}, Lb2/i;->a()Lu1/j;

    move-result-object v3

    const-string v4, "dev.flutter.pigeon.PathProviderApi.getExternalStoragePath"

    invoke-direct {v2, p0, v4, v3, v1}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;Lu1/d$c;)V

    if-eqz p1, :cond_8f

    new-instance v1, Lb2/f;

    invoke-direct {v1, p1}, Lb2/f;-><init>(Lb2/a$b;)V

    invoke-virtual {v2, v1}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_92

    :cond_8f
    invoke-virtual {v2, v0}, Lu1/b;->e(Lu1/b$d;)V

    :goto_92
    invoke-interface {p0}, Lu1/d;->b()Lu1/d$c;

    move-result-object v1

    new-instance v2, Lu1/b;

    invoke-static {}, Lb2/i;->a()Lu1/j;

    move-result-object v3

    const-string v4, "dev.flutter.pigeon.PathProviderApi.getExternalCachePaths"

    invoke-direct {v2, p0, v4, v3, v1}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;Lu1/d$c;)V

    if-eqz p1, :cond_ac

    new-instance v1, Lb2/g;

    invoke-direct {v1, p1}, Lb2/g;-><init>(Lb2/a$b;)V

    invoke-virtual {v2, v1}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_af

    :cond_ac
    invoke-virtual {v2, v0}, Lu1/b;->e(Lu1/b$d;)V

    :goto_af
    invoke-interface {p0}, Lu1/d;->b()Lu1/d$c;

    move-result-object v1

    new-instance v2, Lu1/b;

    invoke-static {}, Lb2/i;->a()Lu1/j;

    move-result-object v3

    const-string v4, "dev.flutter.pigeon.PathProviderApi.getExternalStoragePaths"

    invoke-direct {v2, p0, v4, v3, v1}, Lu1/b;-><init>(Lu1/d;Ljava/lang/String;Lu1/j;Lu1/d$c;)V

    if-eqz p1, :cond_c9

    new-instance p0, Lb2/h;

    invoke-direct {p0, p1}, Lb2/h;-><init>(Lb2/a$b;)V

    invoke-virtual {v2, p0}, Lu1/b;->e(Lu1/b$d;)V

    goto :goto_cc

    :cond_c9
    invoke-virtual {v2, v0}, Lu1/b;->e(Lu1/b$d;)V

    :goto_cc
    return-void
.end method
