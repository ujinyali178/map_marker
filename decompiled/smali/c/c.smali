.class public Lc/c;
.super Lc/f;
.source "SourceFile"


# static fields
.field private static volatile c:Lc/c;

.field private static final d:Ljava/util/concurrent/Executor;

.field private static final e:Ljava/util/concurrent/Executor;


# instance fields
.field private a:Lc/f;

.field private final b:Lc/f;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lc/a;

    invoke-direct {v0}, Lc/a;-><init>()V

    sput-object v0, Lc/c;->d:Ljava/util/concurrent/Executor;

    new-instance v0, Lc/b;

    invoke-direct {v0}, Lc/b;-><init>()V

    sput-object v0, Lc/c;->e:Ljava/util/concurrent/Executor;

    return-void
.end method

.method private constructor <init>()V
    .registers 2

    invoke-direct {p0}, Lc/f;-><init>()V

    new-instance v0, Lc/d;

    invoke-direct {v0}, Lc/d;-><init>()V

    iput-object v0, p0, Lc/c;->b:Lc/f;

    iput-object v0, p0, Lc/c;->a:Lc/f;

    return-void
.end method

.method public static synthetic d(Ljava/lang/Runnable;)V
    .registers 1

    invoke-static {p0}, Lc/c;->h(Ljava/lang/Runnable;)V

    return-void
.end method

.method public static synthetic e(Ljava/lang/Runnable;)V
    .registers 1

    invoke-static {p0}, Lc/c;->g(Ljava/lang/Runnable;)V

    return-void
.end method

.method public static f()Lc/c;
    .registers 2

    sget-object v0, Lc/c;->c:Lc/c;

    if-eqz v0, :cond_7

    sget-object v0, Lc/c;->c:Lc/c;

    return-object v0

    :cond_7
    const-class v0, Lc/c;

    monitor-enter v0

    :try_start_a
    sget-object v1, Lc/c;->c:Lc/c;

    if-nez v1, :cond_15

    new-instance v1, Lc/c;

    invoke-direct {v1}, Lc/c;-><init>()V

    sput-object v1, Lc/c;->c:Lc/c;

    :cond_15
    monitor-exit v0
    :try_end_16
    .catchall {:try_start_a .. :try_end_16} :catchall_19

    sget-object v0, Lc/c;->c:Lc/c;

    return-object v0

    :catchall_19
    move-exception v1

    :try_start_1a
    monitor-exit v0
    :try_end_1b
    .catchall {:try_start_1a .. :try_end_1b} :catchall_19

    throw v1
.end method

.method private static synthetic g(Ljava/lang/Runnable;)V
    .registers 2

    invoke-static {}, Lc/c;->f()Lc/c;

    move-result-object v0

    invoke-virtual {v0, p0}, Lc/c;->c(Ljava/lang/Runnable;)V

    return-void
.end method

.method private static synthetic h(Ljava/lang/Runnable;)V
    .registers 2

    invoke-static {}, Lc/c;->f()Lc/c;

    move-result-object v0

    invoke-virtual {v0, p0}, Lc/c;->a(Ljava/lang/Runnable;)V

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Runnable;)V
    .registers 3

    iget-object v0, p0, Lc/c;->a:Lc/f;

    invoke-virtual {v0, p1}, Lc/f;->a(Ljava/lang/Runnable;)V

    return-void
.end method

.method public b()Z
    .registers 2

    iget-object v0, p0, Lc/c;->a:Lc/f;

    invoke-virtual {v0}, Lc/f;->b()Z

    move-result v0

    return v0
.end method

.method public c(Ljava/lang/Runnable;)V
    .registers 3

    iget-object v0, p0, Lc/c;->a:Lc/f;

    invoke-virtual {v0, p1}, Lc/f;->c(Ljava/lang/Runnable;)V

    return-void
.end method
