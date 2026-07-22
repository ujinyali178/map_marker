.class final Lb0/l;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lu1/l$c;


# instance fields
.field private final c:Landroid/content/Context;

.field private final d:Lb0/a;

.field private final f:Lb0/u;

.field private final g:Lb0/y;


# direct methods
.method constructor <init>(Landroid/content/Context;Lb0/a;Lb0/u;Lb0/y;)V
    .registers 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lb0/l;->c:Landroid/content/Context;

    iput-object p2, p0, Lb0/l;->d:Lb0/a;

    iput-object p3, p0, Lb0/l;->f:Lb0/u;

    iput-object p4, p0, Lb0/l;->g:Lb0/y;

    return-void
.end method

.method public static synthetic a(Lu1/l$d;Ljava/lang/String;Ljava/lang/String;)V
    .registers 3

    invoke-static {p0, p1, p2}, Lb0/l;->f(Lu1/l$d;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public static synthetic b(Lu1/l$d;Ljava/lang/String;Ljava/lang/String;)V
    .registers 3

    invoke-static {p0, p1, p2}, Lb0/l;->e(Lu1/l$d;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public static synthetic c(Lu1/l$d;Ljava/lang/String;Ljava/lang/String;)V
    .registers 3

    invoke-static {p0, p1, p2}, Lb0/l;->h(Lu1/l$d;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public static synthetic d(Lu1/l$d;Ljava/lang/String;Ljava/lang/String;)V
    .registers 3

    invoke-static {p0, p1, p2}, Lb0/l;->g(Lu1/l$d;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private static synthetic e(Lu1/l$d;Ljava/lang/String;Ljava/lang/String;)V
    .registers 4

    const/4 v0, 0x0

    invoke-interface {p0, p1, p2, v0}, Lu1/l$d;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method private static synthetic f(Lu1/l$d;Ljava/lang/String;Ljava/lang/String;)V
    .registers 4

    const/4 v0, 0x0

    invoke-interface {p0, p1, p2, v0}, Lu1/l$d;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method private static synthetic g(Lu1/l$d;Ljava/lang/String;Ljava/lang/String;)V
    .registers 4

    const/4 v0, 0x0

    invoke-interface {p0, p1, p2, v0}, Lu1/l$d;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method private static synthetic h(Lu1/l$d;Ljava/lang/String;Ljava/lang/String;)V
    .registers 4

    const/4 v0, 0x0

    invoke-interface {p0, p1, p2, v0}, Lu1/l$d;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public n(Lu1/k;Lu1/l$d;)V
    .registers 7

    iget-object v0, p1, Lu1/k;->a:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v1

    const/4 v2, -0x1

    sparse-switch v1, :sswitch_data_ce

    goto :goto_44

    :sswitch_e
    const-string v1, "requestPermissions"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_17

    goto :goto_44

    :cond_17
    const/4 v2, 0x4

    goto :goto_44

    :sswitch_19
    const-string v1, "openAppSettings"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_22

    goto :goto_44

    :cond_22
    const/4 v2, 0x3

    goto :goto_44

    :sswitch_24
    const-string v1, "checkPermissionStatus"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2d

    goto :goto_44

    :cond_2d
    const/4 v2, 0x2

    goto :goto_44

    :sswitch_2f
    const-string v1, "shouldShowRequestPermissionRationale"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_38

    goto :goto_44

    :cond_38
    const/4 v2, 0x1

    goto :goto_44

    :sswitch_3a
    const-string v1, "checkServiceStatus"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_43

    goto :goto_44

    :cond_43
    const/4 v2, 0x0

    :goto_44
    packed-switch v2, :pswitch_data_e4

    invoke-interface {p2}, Lu1/l$d;->c()V

    goto/16 :goto_cd

    :pswitch_4c
    invoke-virtual {p1}, Lu1/k;->b()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/List;

    iget-object v0, p0, Lb0/l;->f:Lb0/u;

    invoke-static {p2}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v1, Lb0/f;

    invoke-direct {v1, p2}, Lb0/f;-><init>(Lu1/l$d;)V

    new-instance v2, Lb0/g;

    invoke-direct {v2, p2}, Lb0/g;-><init>(Lu1/l$d;)V

    invoke-virtual {v0, p1, v1, v2}, Lb0/u;->h(Ljava/util/List;Lb0/u$b;Lb0/b;)V

    goto :goto_cd

    :pswitch_65
    iget-object p1, p0, Lb0/l;->d:Lb0/a;

    iget-object v0, p0, Lb0/l;->c:Landroid/content/Context;

    invoke-static {p2}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v1, Lb0/j;

    invoke-direct {v1, p2}, Lb0/j;-><init>(Lu1/l$d;)V

    new-instance v2, Lb0/k;

    invoke-direct {v2, p2}, Lb0/k;-><init>(Lu1/l$d;)V

    invoke-virtual {p1, v0, v1, v2}, Lb0/a;->a(Landroid/content/Context;Lb0/a$a;Lb0/b;)V

    goto :goto_cd

    :pswitch_7a
    iget-object p1, p1, Lu1/k;->b:Ljava/lang/Object;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result p1

    iget-object v0, p0, Lb0/l;->f:Lb0/u;

    invoke-static {p2}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v1, Lb0/e;

    invoke-direct {v1, p2}, Lb0/e;-><init>(Lu1/l$d;)V

    invoke-virtual {v0, p1, v1}, Lb0/u;->d(ILb0/u$a;)V

    goto :goto_cd

    :pswitch_92
    iget-object p1, p1, Lu1/k;->b:Ljava/lang/Object;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result p1

    iget-object v0, p0, Lb0/l;->f:Lb0/u;

    invoke-static {p2}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v1, Lb0/h;

    invoke-direct {v1, p2}, Lb0/h;-><init>(Lu1/l$d;)V

    new-instance v2, Lb0/i;

    invoke-direct {v2, p2}, Lb0/i;-><init>(Lu1/l$d;)V

    invoke-virtual {v0, p1, v1, v2}, Lb0/u;->j(ILb0/u$c;Lb0/b;)V

    goto :goto_cd

    :pswitch_af
    iget-object p1, p1, Lu1/k;->b:Ljava/lang/Object;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result p1

    iget-object v0, p0, Lb0/l;->g:Lb0/y;

    iget-object v1, p0, Lb0/l;->c:Landroid/content/Context;

    invoke-static {p2}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v2, Lb0/c;

    invoke-direct {v2, p2}, Lb0/c;-><init>(Lu1/l$d;)V

    new-instance v3, Lb0/d;

    invoke-direct {v3, p2}, Lb0/d;-><init>(Lu1/l$d;)V

    invoke-virtual {v0, p1, v1, v2, v3}, Lb0/y;->a(ILandroid/content/Context;Lb0/y$a;Lb0/b;)V

    :goto_cd
    return-void

    :sswitch_data_ce
    .sparse-switch
        -0x5c086121 -> :sswitch_3a
        -0x3ca2ffb7 -> :sswitch_2f
        -0x22583c37 -> :sswitch_24
        0x14b278ba -> :sswitch_19
        0x637dca75 -> :sswitch_e
    .end sparse-switch

    :pswitch_data_e4
    .packed-switch 0x0
        :pswitch_af
        :pswitch_92
        :pswitch_7a
        :pswitch_65
        :pswitch_4c
    .end packed-switch
.end method
