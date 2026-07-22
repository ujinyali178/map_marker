.class Lcom/baseflow/geolocator/j;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lu1/l$c;


# instance fields
.field private final c:Lz/b;

.field private final d:Ly/k;

.field private final f:Ly/m;

.field final g:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ly/p;",
            ">;"
        }
    .end annotation
.end field

.field private h:Landroid/content/Context;

.field private i:Landroid/app/Activity;

.field private j:Lu1/l;


# direct methods
.method constructor <init>(Lz/b;Ly/k;Ly/m;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/baseflow/geolocator/j;->c:Lz/b;

    iput-object p2, p0, Lcom/baseflow/geolocator/j;->d:Ly/k;

    iput-object p3, p0, Lcom/baseflow/geolocator/j;->f:Ly/m;

    new-instance p1, Ljava/util/HashMap;

    invoke-direct {p1}, Ljava/util/HashMap;-><init>()V

    iput-object p1, p0, Lcom/baseflow/geolocator/j;->g:Ljava/util/Map;

    return-void
.end method

.method public static synthetic a(Lcom/baseflow/geolocator/j;[ZLy/p;Ljava/lang/String;Lu1/l$d;Lx/b;)V
    .registers 6

    invoke-direct/range {p0 .. p5}, Lcom/baseflow/geolocator/j;->k([ZLy/p;Ljava/lang/String;Lu1/l$d;Lx/b;)V

    return-void
.end method

.method public static synthetic b(Lu1/l$d;Lx/b;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/baseflow/geolocator/j;->i(Lu1/l$d;Lx/b;)V

    return-void
.end method

.method public static synthetic c(Lu1/l$d;Lx/b;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/baseflow/geolocator/j;->p(Lu1/l$d;Lx/b;)V

    return-void
.end method

.method public static synthetic d(Lu1/l$d;Landroid/location/Location;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/baseflow/geolocator/j;->l(Lu1/l$d;Landroid/location/Location;)V

    return-void
.end method

.method public static synthetic e(Lu1/l$d;Lz/a;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/baseflow/geolocator/j;->o(Lu1/l$d;Lz/a;)V

    return-void
.end method

.method public static synthetic f(Lcom/baseflow/geolocator/j;[ZLy/p;Ljava/lang/String;Lu1/l$d;Landroid/location/Location;)V
    .registers 6

    invoke-direct/range {p0 .. p5}, Lcom/baseflow/geolocator/j;->j([ZLy/p;Ljava/lang/String;Lu1/l$d;Landroid/location/Location;)V

    return-void
.end method

.method public static synthetic g(Lu1/l$d;Lx/b;)V
    .registers 2

    invoke-static {p0, p1}, Lcom/baseflow/geolocator/j;->m(Lu1/l$d;Lx/b;)V

    return-void
.end method

.method private h(Lu1/l$d;Landroid/content/Context;)V
    .registers 5

    iget-object v0, p0, Lcom/baseflow/geolocator/j;->f:Ly/m;

    new-instance v1, Lcom/baseflow/geolocator/e;

    invoke-direct {v1, p1}, Lcom/baseflow/geolocator/e;-><init>(Lu1/l$d;)V

    invoke-virtual {v0, p2, v1}, Ly/m;->a(Landroid/content/Context;Lx/a;)Ly/n;

    move-result-object p2

    if-eqz p2, :cond_18

    invoke-virtual {p2}, Ljava/lang/Enum;->ordinal()I

    move-result p2

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    invoke-interface {p1, p2}, Lu1/l$d;->a(Ljava/lang/Object;)V

    :cond_18
    return-void
.end method

.method private static synthetic i(Lu1/l$d;Lx/b;)V
    .registers 4

    invoke-virtual {p1}, Lx/b;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lx/b;->b()Ljava/lang/String;

    move-result-object p1

    const/4 v1, 0x0

    invoke-interface {p0, v0, p1, v1}, Lu1/l$d;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method private synthetic j([ZLy/p;Ljava/lang/String;Lu1/l$d;Landroid/location/Location;)V
    .registers 8

    const/4 v0, 0x0

    aget-boolean v1, p1, v0

    if-eqz v1, :cond_6

    return-void

    :cond_6
    const/4 v1, 0x1

    aput-boolean v1, p1, v0

    iget-object p1, p0, Lcom/baseflow/geolocator/j;->d:Ly/k;

    invoke-virtual {p1, p2}, Ly/k;->g(Ly/p;)V

    iget-object p1, p0, Lcom/baseflow/geolocator/j;->g:Ljava/util/Map;

    invoke-interface {p1, p3}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {p5}, Ly/y;->b(Landroid/location/Location;)Ljava/util/Map;

    move-result-object p1

    invoke-interface {p4, p1}, Lu1/l$d;->a(Ljava/lang/Object;)V

    return-void
.end method

.method private synthetic k([ZLy/p;Ljava/lang/String;Lu1/l$d;Lx/b;)V
    .registers 8

    const/4 v0, 0x0

    aget-boolean v1, p1, v0

    if-eqz v1, :cond_6

    return-void

    :cond_6
    const/4 v1, 0x1

    aput-boolean v1, p1, v0

    iget-object p1, p0, Lcom/baseflow/geolocator/j;->d:Ly/k;

    invoke-virtual {p1, p2}, Ly/k;->g(Ly/p;)V

    iget-object p1, p0, Lcom/baseflow/geolocator/j;->g:Ljava/util/Map;

    invoke-interface {p1, p3}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {p5}, Lx/b;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p5}, Lx/b;->b()Ljava/lang/String;

    move-result-object p2

    const/4 p3, 0x0

    invoke-interface {p4, p1, p2, p3}, Lu1/l$d;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method private static synthetic l(Lu1/l$d;Landroid/location/Location;)V
    .registers 2

    invoke-static {p1}, Ly/y;->b(Landroid/location/Location;)Ljava/util/Map;

    move-result-object p1

    invoke-interface {p0, p1}, Lu1/l$d;->a(Ljava/lang/Object;)V

    return-void
.end method

.method private static synthetic m(Lu1/l$d;Lx/b;)V
    .registers 4

    invoke-virtual {p1}, Lx/b;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lx/b;->b()Ljava/lang/String;

    move-result-object p1

    const/4 v1, 0x0

    invoke-interface {p0, v0, p1, v1}, Lu1/l$d;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method private static synthetic o(Lu1/l$d;Lz/a;)V
    .registers 2

    invoke-virtual {p1}, Lz/a;->b()I

    move-result p1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-interface {p0, p1}, Lu1/l$d;->a(Ljava/lang/Object;)V

    return-void
.end method

.method private static synthetic p(Lu1/l$d;Lx/b;)V
    .registers 4

    invoke-virtual {p1}, Lx/b;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lx/b;->b()Ljava/lang/String;

    move-result-object p1

    const/4 v1, 0x0

    invoke-interface {p0, v0, p1, v1}, Lu1/l$d;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method private q(Lu1/k;Lu1/l$d;)V
    .registers 4

    iget-object p1, p1, Lu1/k;->b:Ljava/lang/Object;

    check-cast p1, Ljava/util/Map;

    const-string v0, "requestId"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    iget-object v0, p0, Lcom/baseflow/geolocator/j;->g:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ly/p;

    if-eqz v0, :cond_19

    invoke-interface {v0}, Ly/p;->e()V

    :cond_19
    iget-object v0, p0, Lcom/baseflow/geolocator/j;->g:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    const/4 p1, 0x0

    invoke-interface {p2, p1}, Lu1/l$d;->a(Ljava/lang/Object;)V

    return-void
.end method

.method private r(Lu1/l$d;)V
    .registers 5

    :try_start_0
    iget-object v0, p0, Lcom/baseflow/geolocator/j;->c:Lz/b;

    iget-object v1, p0, Lcom/baseflow/geolocator/j;->h:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lz/b;->a(Landroid/content/Context;)Lz/a;

    move-result-object v0

    invoke-virtual {v0}, Lz/a;->b()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {p1, v0}, Lu1/l$d;->a(Ljava/lang/Object;)V
    :try_end_13
    .catch Lx/c; {:try_start_0 .. :try_end_13} :catch_14

    goto :goto_22

    :catch_14
    sget-object v0, Lx/b;->g:Lx/b;

    invoke-virtual {v0}, Lx/b;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lx/b;->b()Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {p1, v1, v0, v2}, Lu1/l$d;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    :goto_22
    return-void
.end method

.method private s(Lu1/k;Lu1/l$d;)V
    .registers 15

    const/4 v0, 0x0

    :try_start_1
    iget-object v1, p0, Lcom/baseflow/geolocator/j;->c:Lz/b;

    iget-object v2, p0, Lcom/baseflow/geolocator/j;->h:Landroid/content/Context;

    invoke-virtual {v1, v2}, Lz/b;->d(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_19

    sget-object p1, Lx/b;->h:Lx/b;

    invoke-virtual {p1}, Lx/b;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lx/b;->b()Ljava/lang/String;

    move-result-object p1

    invoke-interface {p2, v1, p1, v0}, Lu1/l$d;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_18
    .catch Lx/c; {:try_start_1 .. :try_end_18} :catch_69

    return-void

    :cond_19
    iget-object p1, p1, Lu1/k;->b:Ljava/lang/Object;

    check-cast p1, Ljava/util/Map;

    const-string v0, "forceLocationManager"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    const/4 v2, 0x0

    if-eqz v1, :cond_31

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    goto :goto_32

    :cond_31
    const/4 v0, 0x0

    :goto_32
    invoke-static {p1}, Ly/z;->e(Ljava/util/Map;)Ly/z;

    move-result-object v1

    const-string v3, "requestId"

    invoke-interface {p1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    const/4 v3, 0x1

    new-array v9, v3, [Z

    aput-boolean v2, v9, v2

    iget-object v2, p0, Lcom/baseflow/geolocator/j;->d:Ly/k;

    iget-object v3, p0, Lcom/baseflow/geolocator/j;->h:Landroid/content/Context;

    invoke-virtual {v2, v3, v0, v1}, Ly/k;->b(Landroid/content/Context;ZLy/z;)Ly/p;

    move-result-object v0

    iget-object v1, p0, Lcom/baseflow/geolocator/j;->g:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v1, p0, Lcom/baseflow/geolocator/j;->d:Ly/k;

    iget-object v2, p0, Lcom/baseflow/geolocator/j;->i:Landroid/app/Activity;

    new-instance v10, Lcom/baseflow/geolocator/h;

    move-object v3, v10

    move-object v4, p0

    move-object v5, v9

    move-object v6, v0

    move-object v7, p1

    move-object v8, p2

    invoke-direct/range {v3 .. v8}, Lcom/baseflow/geolocator/h;-><init>(Lcom/baseflow/geolocator/j;[ZLy/p;Ljava/lang/String;Lu1/l$d;)V

    new-instance v11, Lcom/baseflow/geolocator/i;

    move-object v3, v11

    invoke-direct/range {v3 .. v8}, Lcom/baseflow/geolocator/i;-><init>(Lcom/baseflow/geolocator/j;[ZLy/p;Ljava/lang/String;Lu1/l$d;)V

    invoke-virtual {v1, v0, v2, v10, v11}, Ly/k;->f(Ly/p;Landroid/app/Activity;Ly/h0;Lx/a;)V

    return-void

    :catch_69
    sget-object p1, Lx/b;->g:Lx/b;

    invoke-virtual {p1}, Lx/b;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lx/b;->b()Ljava/lang/String;

    move-result-object p1

    invoke-interface {p2, v1, p1, v0}, Lu1/l$d;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method private t(Lu1/k;Lu1/l$d;)V
    .registers 7

    const/4 v0, 0x0

    :try_start_1
    iget-object v1, p0, Lcom/baseflow/geolocator/j;->c:Lz/b;

    iget-object v2, p0, Lcom/baseflow/geolocator/j;->h:Landroid/content/Context;

    invoke-virtual {v1, v2}, Lz/b;->d(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_19

    sget-object p1, Lx/b;->h:Lx/b;

    invoke-virtual {p1}, Lx/b;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lx/b;->b()Ljava/lang/String;

    move-result-object p1

    invoke-interface {p2, v1, p1, v0}, Lu1/l$d;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_18
    .catch Lx/c; {:try_start_1 .. :try_end_18} :catch_3e

    return-void

    :cond_19
    const-string v0, "forceLocationManager"

    invoke-virtual {p1, v0}, Lu1/k;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Boolean;

    iget-object v0, p0, Lcom/baseflow/geolocator/j;->d:Ly/k;

    iget-object v1, p0, Lcom/baseflow/geolocator/j;->h:Landroid/content/Context;

    if-eqz p1, :cond_2f

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p1

    if-eqz p1, :cond_2f

    const/4 p1, 0x1

    goto :goto_30

    :cond_2f
    const/4 p1, 0x0

    :goto_30
    new-instance v2, Lcom/baseflow/geolocator/c;

    invoke-direct {v2, p2}, Lcom/baseflow/geolocator/c;-><init>(Lu1/l$d;)V

    new-instance v3, Lcom/baseflow/geolocator/d;

    invoke-direct {v3, p2}, Lcom/baseflow/geolocator/d;-><init>(Lu1/l$d;)V

    invoke-virtual {v0, v1, p1, v2, v3}, Ly/k;->c(Landroid/content/Context;ZLy/h0;Lx/a;)V

    return-void

    :catch_3e
    sget-object p1, Lx/b;->g:Lx/b;

    invoke-virtual {p1}, Lx/b;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lx/b;->b()Ljava/lang/String;

    move-result-object p1

    invoke-interface {p2, v1, p1, v0}, Lu1/l$d;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method private u(Lu1/l$d;)V
    .registers 5

    iget-object v0, p0, Lcom/baseflow/geolocator/j;->d:Ly/k;

    iget-object v1, p0, Lcom/baseflow/geolocator/j;->h:Landroid/content/Context;

    new-instance v2, Ly/c;

    invoke-direct {v2, p1}, Ly/c;-><init>(Lu1/l$d;)V

    invoke-virtual {v0, v1, v2}, Ly/k;->e(Landroid/content/Context;Ly/a0;)V

    return-void
.end method

.method private v(Lu1/l$d;)V
    .registers 6

    :try_start_0
    iget-object v0, p0, Lcom/baseflow/geolocator/j;->c:Lz/b;

    iget-object v1, p0, Lcom/baseflow/geolocator/j;->i:Landroid/app/Activity;

    new-instance v2, Lcom/baseflow/geolocator/f;

    invoke-direct {v2, p1}, Lcom/baseflow/geolocator/f;-><init>(Lu1/l$d;)V

    new-instance v3, Lcom/baseflow/geolocator/g;

    invoke-direct {v3, p1}, Lcom/baseflow/geolocator/g;-><init>(Lu1/l$d;)V

    invoke-virtual {v0, v1, v2, v3}, Lz/b;->f(Landroid/app/Activity;Lz/c;Lx/a;)V
    :try_end_11
    .catch Lx/c; {:try_start_0 .. :try_end_11} :catch_12

    goto :goto_20

    :catch_12
    sget-object v0, Lx/b;->g:Lx/b;

    invoke-virtual {v0}, Lx/b;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lx/b;->b()Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {p1, v1, v0, v2}, Lu1/l$d;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    :goto_20
    return-void
.end method


# virtual methods
.method public n(Lu1/k;Lu1/l$d;)V
    .registers 6

    iget-object v0, p1, Lu1/k;->a:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v1

    const/4 v2, -0x1

    sparse-switch v1, :sswitch_data_ae

    goto/16 :goto_74

    :sswitch_f
    const-string v1, "cancelGetCurrentPosition"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_19

    goto/16 :goto_74

    :cond_19
    const/16 v2, 0x8

    goto/16 :goto_74

    :sswitch_1d
    const-string v1, "getLocationAccuracy"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_26

    goto :goto_74

    :cond_26
    const/4 v2, 0x7

    goto :goto_74

    :sswitch_28
    const-string v1, "requestPermission"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_31

    goto :goto_74

    :cond_31
    const/4 v2, 0x6

    goto :goto_74

    :sswitch_33
    const-string v1, "checkPermission"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3c

    goto :goto_74

    :cond_3c
    const/4 v2, 0x5

    goto :goto_74

    :sswitch_3e
    const-string v1, "isLocationServiceEnabled"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_47

    goto :goto_74

    :cond_47
    const/4 v2, 0x4

    goto :goto_74

    :sswitch_49
    const-string v1, "openAppSettings"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_52

    goto :goto_74

    :cond_52
    const/4 v2, 0x3

    goto :goto_74

    :sswitch_54
    const-string v1, "openLocationSettings"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_5d

    goto :goto_74

    :cond_5d
    const/4 v2, 0x2

    goto :goto_74

    :sswitch_5f
    const-string v1, "getLastKnownPosition"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_68

    goto :goto_74

    :cond_68
    const/4 v2, 0x1

    goto :goto_74

    :sswitch_6a
    const-string v1, "getCurrentPosition"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_73

    goto :goto_74

    :cond_73
    const/4 v2, 0x0

    :goto_74
    packed-switch v2, :pswitch_data_d4

    invoke-interface {p2}, Lu1/l$d;->c()V

    goto :goto_ad

    :pswitch_7b
    invoke-direct {p0, p1, p2}, Lcom/baseflow/geolocator/j;->q(Lu1/k;Lu1/l$d;)V

    goto :goto_ad

    :pswitch_7f
    iget-object p1, p0, Lcom/baseflow/geolocator/j;->h:Landroid/content/Context;

    invoke-direct {p0, p2, p1}, Lcom/baseflow/geolocator/j;->h(Lu1/l$d;Landroid/content/Context;)V

    goto :goto_ad

    :pswitch_85
    invoke-direct {p0, p2}, Lcom/baseflow/geolocator/j;->v(Lu1/l$d;)V

    goto :goto_ad

    :pswitch_89
    invoke-direct {p0, p2}, Lcom/baseflow/geolocator/j;->r(Lu1/l$d;)V

    goto :goto_ad

    :pswitch_8d
    invoke-direct {p0, p2}, Lcom/baseflow/geolocator/j;->u(Lu1/l$d;)V

    goto :goto_ad

    :pswitch_91
    iget-object p1, p0, Lcom/baseflow/geolocator/j;->h:Landroid/content/Context;

    invoke-static {p1}, La0/a;->a(Landroid/content/Context;)Z

    move-result p1

    :goto_97
    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    invoke-interface {p2, p1}, Lu1/l$d;->a(Ljava/lang/Object;)V

    goto :goto_ad

    :pswitch_9f
    iget-object p1, p0, Lcom/baseflow/geolocator/j;->h:Landroid/content/Context;

    invoke-static {p1}, La0/a;->b(Landroid/content/Context;)Z

    move-result p1

    goto :goto_97

    :pswitch_a6
    invoke-direct {p0, p1, p2}, Lcom/baseflow/geolocator/j;->t(Lu1/k;Lu1/l$d;)V

    goto :goto_ad

    :pswitch_aa
    invoke-direct {p0, p1, p2}, Lcom/baseflow/geolocator/j;->s(Lu1/k;Lu1/l$d;)V

    :goto_ad
    return-void

    :sswitch_data_ae
    .sparse-switch
        -0x68b9fc74 -> :sswitch_6a
        -0x44f2ea20 -> :sswitch_5f
        -0x30f92e9e -> :sswitch_54
        0x14b278ba -> :sswitch_49
        0x1538bfab -> :sswitch_3e
        0x28e6dcf7 -> :sswitch_33
        0x2c7fedbe -> :sswitch_28
        0x34469f44 -> :sswitch_1d
        0x69c703a6 -> :sswitch_f
    .end sparse-switch

    :pswitch_data_d4
    .packed-switch 0x0
        :pswitch_aa
        :pswitch_a6
        :pswitch_9f
        :pswitch_91
        :pswitch_8d
        :pswitch_89
        :pswitch_85
        :pswitch_7f
        :pswitch_7b
    .end packed-switch
.end method

.method w(Landroid/app/Activity;)V
    .registers 2

    iput-object p1, p0, Lcom/baseflow/geolocator/j;->i:Landroid/app/Activity;

    return-void
.end method

.method x(Landroid/content/Context;Lu1/d;)V
    .registers 5

    iget-object v0, p0, Lcom/baseflow/geolocator/j;->j:Lu1/l;

    if-eqz v0, :cond_e

    const-string v0, "MethodCallHandlerImpl"

    const-string v1, "Setting a method call handler before the last was disposed."

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {p0}, Lcom/baseflow/geolocator/j;->y()V

    :cond_e
    new-instance v0, Lu1/l;

    const-string v1, "flutter.baseflow.com/geolocator_android"

    invoke-direct {v0, p2, v1}, Lu1/l;-><init>(Lu1/d;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/baseflow/geolocator/j;->j:Lu1/l;

    invoke-virtual {v0, p0}, Lu1/l;->e(Lu1/l$c;)V

    iput-object p1, p0, Lcom/baseflow/geolocator/j;->h:Landroid/content/Context;

    return-void
.end method

.method y()V
    .registers 3

    iget-object v0, p0, Lcom/baseflow/geolocator/j;->j:Lu1/l;

    if-nez v0, :cond_c

    const-string v0, "MethodCallHandlerImpl"

    const-string v1, "Tried to stop listening when no MethodChannel had been initialized."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    :cond_c
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lu1/l;->e(Lu1/l$c;)V

    iput-object v1, p0, Lcom/baseflow/geolocator/j;->j:Lu1/l;

    return-void
.end method
