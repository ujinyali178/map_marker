.class public Lcom/baseflow/geolocator/a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lm1/a;
.implements Ln1/a;


# instance fields
.field private final c:Lz/b;

.field private final d:Ly/k;

.field private final f:Ly/m;

.field private g:Lcom/baseflow/geolocator/GeolocatorLocationService;

.field private h:Lcom/baseflow/geolocator/j;

.field private i:Lcom/baseflow/geolocator/m;

.field private j:Lcom/baseflow/geolocator/m;

.field private final k:Landroid/content/ServiceConnection;

.field private l:Lcom/baseflow/geolocator/b;

.field private m:Ln1/c;


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/baseflow/geolocator/a$a;

    invoke-direct {v0, p0}, Lcom/baseflow/geolocator/a$a;-><init>(Lcom/baseflow/geolocator/a;)V

    iput-object v0, p0, Lcom/baseflow/geolocator/a;->k:Landroid/content/ServiceConnection;

    new-instance v0, Lz/b;

    invoke-direct {v0}, Lz/b;-><init>()V

    iput-object v0, p0, Lcom/baseflow/geolocator/a;->c:Lz/b;

    new-instance v0, Ly/k;

    invoke-direct {v0}, Ly/k;-><init>()V

    iput-object v0, p0, Lcom/baseflow/geolocator/a;->d:Ly/k;

    new-instance v0, Ly/m;

    invoke-direct {v0}, Ly/m;-><init>()V

    iput-object v0, p0, Lcom/baseflow/geolocator/a;->f:Ly/m;

    return-void
.end method

.method static synthetic a(Lcom/baseflow/geolocator/a;Lcom/baseflow/geolocator/GeolocatorLocationService;)V
    .registers 2

    invoke-direct {p0, p1}, Lcom/baseflow/geolocator/a;->m(Lcom/baseflow/geolocator/GeolocatorLocationService;)V

    return-void
.end method

.method static synthetic c(Lcom/baseflow/geolocator/a;)Lcom/baseflow/geolocator/GeolocatorLocationService;
    .registers 1

    iget-object p0, p0, Lcom/baseflow/geolocator/a;->g:Lcom/baseflow/geolocator/GeolocatorLocationService;

    return-object p0
.end method

.method static synthetic f(Lcom/baseflow/geolocator/a;Lcom/baseflow/geolocator/GeolocatorLocationService;)Lcom/baseflow/geolocator/GeolocatorLocationService;
    .registers 2

    iput-object p1, p0, Lcom/baseflow/geolocator/a;->g:Lcom/baseflow/geolocator/GeolocatorLocationService;

    return-object p1
.end method

.method private g(Landroid/content/Context;)V
    .registers 5

    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/baseflow/geolocator/GeolocatorLocationService;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    iget-object v1, p0, Lcom/baseflow/geolocator/a;->k:Landroid/content/ServiceConnection;

    const/4 v2, 0x1

    invoke-virtual {p1, v0, v1, v2}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    return-void
.end method

.method private k()V
    .registers 3

    iget-object v0, p0, Lcom/baseflow/geolocator/a;->m:Ln1/c;

    if-eqz v0, :cond_10

    iget-object v1, p0, Lcom/baseflow/geolocator/a;->d:Ly/k;

    invoke-interface {v0, v1}, Ln1/c;->d(Lu1/n$a;)V

    iget-object v0, p0, Lcom/baseflow/geolocator/a;->m:Ln1/c;

    iget-object v1, p0, Lcom/baseflow/geolocator/a;->c:Lz/b;

    invoke-interface {v0, v1}, Ln1/c;->c(Lu1/n$d;)V

    :cond_10
    return-void
.end method

.method private l()V
    .registers 3

    const-string v0, "FlutterGeolocator"

    const-string v1, "Disposing Geolocator services"

    invoke-static {v0, v1}, Lg1/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/baseflow/geolocator/a;->h:Lcom/baseflow/geolocator/j;

    const/4 v1, 0x0

    if-eqz v0, :cond_16

    invoke-virtual {v0}, Lcom/baseflow/geolocator/j;->y()V

    iget-object v0, p0, Lcom/baseflow/geolocator/a;->h:Lcom/baseflow/geolocator/j;

    invoke-virtual {v0, v1}, Lcom/baseflow/geolocator/j;->w(Landroid/app/Activity;)V

    iput-object v1, p0, Lcom/baseflow/geolocator/a;->h:Lcom/baseflow/geolocator/j;

    :cond_16
    iget-object v0, p0, Lcom/baseflow/geolocator/a;->i:Lcom/baseflow/geolocator/m;

    if-eqz v0, :cond_1f

    invoke-virtual {v0}, Lcom/baseflow/geolocator/m;->k()V

    iput-object v1, p0, Lcom/baseflow/geolocator/a;->i:Lcom/baseflow/geolocator/m;

    :cond_1f
    iget-object v0, p0, Lcom/baseflow/geolocator/a;->j:Lcom/baseflow/geolocator/m;

    if-eqz v0, :cond_2d

    invoke-virtual {v0}, Lcom/baseflow/geolocator/m;->k()V

    iget-object v0, p0, Lcom/baseflow/geolocator/a;->j:Lcom/baseflow/geolocator/m;

    invoke-virtual {v0, v1}, Lcom/baseflow/geolocator/m;->i(Lcom/baseflow/geolocator/GeolocatorLocationService;)V

    iput-object v1, p0, Lcom/baseflow/geolocator/a;->j:Lcom/baseflow/geolocator/m;

    :cond_2d
    iget-object v0, p0, Lcom/baseflow/geolocator/a;->l:Lcom/baseflow/geolocator/b;

    if-eqz v0, :cond_3b

    invoke-virtual {v0, v1}, Lcom/baseflow/geolocator/b;->d(Landroid/content/Context;)V

    iget-object v0, p0, Lcom/baseflow/geolocator/a;->l:Lcom/baseflow/geolocator/b;

    invoke-virtual {v0}, Lcom/baseflow/geolocator/b;->f()V

    iput-object v1, p0, Lcom/baseflow/geolocator/a;->l:Lcom/baseflow/geolocator/b;

    :cond_3b
    iget-object v0, p0, Lcom/baseflow/geolocator/a;->g:Lcom/baseflow/geolocator/GeolocatorLocationService;

    if-eqz v0, :cond_42

    invoke-virtual {v0, v1}, Lcom/baseflow/geolocator/GeolocatorLocationService;->n(Landroid/app/Activity;)V

    :cond_42
    return-void
.end method

.method private m(Lcom/baseflow/geolocator/GeolocatorLocationService;)V
    .registers 4

    const-string v0, "FlutterGeolocator"

    const-string v1, "Initializing Geolocator services"

    invoke-static {v0, v1}, Lg1/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    iput-object p1, p0, Lcom/baseflow/geolocator/a;->g:Lcom/baseflow/geolocator/GeolocatorLocationService;

    iget-object v0, p0, Lcom/baseflow/geolocator/a;->d:Ly/k;

    invoke-virtual {p1, v0}, Lcom/baseflow/geolocator/GeolocatorLocationService;->o(Ly/k;)V

    iget-object v0, p0, Lcom/baseflow/geolocator/a;->g:Lcom/baseflow/geolocator/GeolocatorLocationService;

    invoke-virtual {v0}, Lcom/baseflow/geolocator/GeolocatorLocationService;->g()V

    iget-object v0, p0, Lcom/baseflow/geolocator/a;->j:Lcom/baseflow/geolocator/m;

    if-eqz v0, :cond_1a

    invoke-virtual {v0, p1}, Lcom/baseflow/geolocator/m;->i(Lcom/baseflow/geolocator/GeolocatorLocationService;)V

    :cond_1a
    return-void
.end method

.method private n()V
    .registers 3

    iget-object v0, p0, Lcom/baseflow/geolocator/a;->m:Ln1/c;

    if-eqz v0, :cond_10

    iget-object v1, p0, Lcom/baseflow/geolocator/a;->d:Ly/k;

    invoke-interface {v0, v1}, Ln1/c;->a(Lu1/n$a;)V

    iget-object v0, p0, Lcom/baseflow/geolocator/a;->m:Ln1/c;

    iget-object v1, p0, Lcom/baseflow/geolocator/a;->c:Lz/b;

    invoke-interface {v0, v1}, Ln1/c;->b(Lu1/n$d;)V

    :cond_10
    return-void
.end method

.method private o(Landroid/content/Context;)V
    .registers 3

    iget-object v0, p0, Lcom/baseflow/geolocator/a;->g:Lcom/baseflow/geolocator/GeolocatorLocationService;

    if-eqz v0, :cond_7

    invoke-virtual {v0}, Lcom/baseflow/geolocator/GeolocatorLocationService;->h()V

    :cond_7
    iget-object v0, p0, Lcom/baseflow/geolocator/a;->k:Landroid/content/ServiceConnection;

    invoke-virtual {p1, v0}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V

    return-void
.end method


# virtual methods
.method public b(Lm1/a$b;)V
    .registers 6

    new-instance v0, Lcom/baseflow/geolocator/j;

    iget-object v1, p0, Lcom/baseflow/geolocator/a;->c:Lz/b;

    iget-object v2, p0, Lcom/baseflow/geolocator/a;->d:Ly/k;

    iget-object v3, p0, Lcom/baseflow/geolocator/a;->f:Ly/m;

    invoke-direct {v0, v1, v2, v3}, Lcom/baseflow/geolocator/j;-><init>(Lz/b;Ly/k;Ly/m;)V

    iput-object v0, p0, Lcom/baseflow/geolocator/a;->h:Lcom/baseflow/geolocator/j;

    invoke-virtual {p1}, Lm1/a$b;->a()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {p1}, Lm1/a$b;->b()Lu1/d;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/baseflow/geolocator/j;->x(Landroid/content/Context;Lu1/d;)V

    new-instance v0, Lcom/baseflow/geolocator/m;

    iget-object v1, p0, Lcom/baseflow/geolocator/a;->c:Lz/b;

    iget-object v2, p0, Lcom/baseflow/geolocator/a;->d:Ly/k;

    const-string v3, "flutter.baseflow.com/geolocator_updates_android"

    invoke-direct {v0, v1, v2, v3}, Lcom/baseflow/geolocator/m;-><init>(Lz/b;Ly/k;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/baseflow/geolocator/a;->i:Lcom/baseflow/geolocator/m;

    invoke-virtual {p1}, Lm1/a$b;->a()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {p1}, Lm1/a$b;->b()Lu1/d;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/baseflow/geolocator/m;->j(Landroid/content/Context;Lu1/d;)V

    new-instance v0, Lcom/baseflow/geolocator/m;

    iget-object v1, p0, Lcom/baseflow/geolocator/a;->c:Lz/b;

    iget-object v2, p0, Lcom/baseflow/geolocator/a;->d:Ly/k;

    const-string v3, "flutter.baseflow.com/geolocator_updates_android_fgn"

    invoke-direct {v0, v1, v2, v3}, Lcom/baseflow/geolocator/m;-><init>(Lz/b;Ly/k;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/baseflow/geolocator/a;->j:Lcom/baseflow/geolocator/m;

    invoke-virtual {p1}, Lm1/a$b;->a()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {p1}, Lm1/a$b;->b()Lu1/d;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/baseflow/geolocator/m;->j(Landroid/content/Context;Lu1/d;)V

    new-instance v0, Lcom/baseflow/geolocator/b;

    invoke-direct {v0}, Lcom/baseflow/geolocator/b;-><init>()V

    iput-object v0, p0, Lcom/baseflow/geolocator/a;->l:Lcom/baseflow/geolocator/b;

    invoke-virtual {p1}, Lm1/a$b;->a()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/baseflow/geolocator/b;->d(Landroid/content/Context;)V

    iget-object v0, p0, Lcom/baseflow/geolocator/a;->l:Lcom/baseflow/geolocator/b;

    invoke-virtual {p1}, Lm1/a$b;->a()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {p1}, Lm1/a$b;->b()Lu1/d;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/baseflow/geolocator/b;->e(Landroid/content/Context;Lu1/d;)V

    invoke-virtual {p1}, Lm1/a$b;->a()Landroid/content/Context;

    move-result-object p1

    invoke-direct {p0, p1}, Lcom/baseflow/geolocator/a;->g(Landroid/content/Context;)V

    return-void
.end method

.method public d(Ln1/c;)V
    .registers 2

    invoke-virtual {p0, p1}, Lcom/baseflow/geolocator/a;->j(Ln1/c;)V

    return-void
.end method

.method public e(Lm1/a$b;)V
    .registers 2

    invoke-virtual {p1}, Lm1/a$b;->a()Landroid/content/Context;

    move-result-object p1

    invoke-direct {p0, p1}, Lcom/baseflow/geolocator/a;->o(Landroid/content/Context;)V

    invoke-direct {p0}, Lcom/baseflow/geolocator/a;->l()V

    return-void
.end method

.method public h()V
    .registers 1

    invoke-virtual {p0}, Lcom/baseflow/geolocator/a;->i()V

    return-void
.end method

.method public i()V
    .registers 3

    const-string v0, "FlutterGeolocator"

    const-string v1, "Detaching Geolocator from activity"

    invoke-static {v0, v1}, Lg1/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/baseflow/geolocator/a;->k()V

    iget-object v0, p0, Lcom/baseflow/geolocator/a;->h:Lcom/baseflow/geolocator/j;

    const/4 v1, 0x0

    if-eqz v0, :cond_12

    invoke-virtual {v0, v1}, Lcom/baseflow/geolocator/j;->w(Landroid/app/Activity;)V

    :cond_12
    iget-object v0, p0, Lcom/baseflow/geolocator/a;->i:Lcom/baseflow/geolocator/m;

    if-eqz v0, :cond_19

    invoke-virtual {v0, v1}, Lcom/baseflow/geolocator/m;->h(Landroid/app/Activity;)V

    :cond_19
    iget-object v0, p0, Lcom/baseflow/geolocator/a;->j:Lcom/baseflow/geolocator/m;

    if-eqz v0, :cond_20

    invoke-virtual {v0, v1}, Lcom/baseflow/geolocator/m;->h(Landroid/app/Activity;)V

    :cond_20
    iget-object v0, p0, Lcom/baseflow/geolocator/a;->g:Lcom/baseflow/geolocator/GeolocatorLocationService;

    if-eqz v0, :cond_27

    invoke-virtual {v0, v1}, Lcom/baseflow/geolocator/GeolocatorLocationService;->n(Landroid/app/Activity;)V

    :cond_27
    iget-object v0, p0, Lcom/baseflow/geolocator/a;->m:Ln1/c;

    if-eqz v0, :cond_2d

    iput-object v1, p0, Lcom/baseflow/geolocator/a;->m:Ln1/c;

    :cond_2d
    return-void
.end method

.method public j(Ln1/c;)V
    .registers 4

    const-string v0, "FlutterGeolocator"

    const-string v1, "Attaching Geolocator to activity"

    invoke-static {v0, v1}, Lg1/b;->a(Ljava/lang/String;Ljava/lang/String;)V

    iput-object p1, p0, Lcom/baseflow/geolocator/a;->m:Ln1/c;

    invoke-direct {p0}, Lcom/baseflow/geolocator/a;->n()V

    iget-object v0, p0, Lcom/baseflow/geolocator/a;->h:Lcom/baseflow/geolocator/j;

    if-eqz v0, :cond_17

    invoke-interface {p1}, Ln1/c;->i()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/baseflow/geolocator/j;->w(Landroid/app/Activity;)V

    :cond_17
    iget-object v0, p0, Lcom/baseflow/geolocator/a;->i:Lcom/baseflow/geolocator/m;

    if-eqz v0, :cond_22

    invoke-interface {p1}, Ln1/c;->i()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/baseflow/geolocator/m;->h(Landroid/app/Activity;)V

    :cond_22
    iget-object v0, p0, Lcom/baseflow/geolocator/a;->j:Lcom/baseflow/geolocator/m;

    if-eqz v0, :cond_2d

    invoke-interface {p1}, Ln1/c;->i()Landroid/app/Activity;

    move-result-object p1

    invoke-virtual {v0, p1}, Lcom/baseflow/geolocator/m;->h(Landroid/app/Activity;)V

    :cond_2d
    iget-object p1, p0, Lcom/baseflow/geolocator/a;->g:Lcom/baseflow/geolocator/GeolocatorLocationService;

    if-eqz p1, :cond_3a

    iget-object v0, p0, Lcom/baseflow/geolocator/a;->m:Ln1/c;

    invoke-interface {v0}, Ln1/c;->i()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/baseflow/geolocator/GeolocatorLocationService;->n(Landroid/app/Activity;)V

    :cond_3a
    return-void
.end method
