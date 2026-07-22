.class Landroidx/lifecycle/ReflectiveGenericLifecycleObserver;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/lifecycle/g;


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# instance fields
.field private final c:Ljava/lang/Object;

.field private final d:Landroidx/lifecycle/b$a;


# direct methods
.method constructor <init>(Ljava/lang/Object;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/lifecycle/ReflectiveGenericLifecycleObserver;->c:Ljava/lang/Object;

    sget-object v0, Landroidx/lifecycle/b;->c:Landroidx/lifecycle/b;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroidx/lifecycle/b;->c(Ljava/lang/Class;)Landroidx/lifecycle/b$a;

    move-result-object p1

    iput-object p1, p0, Landroidx/lifecycle/ReflectiveGenericLifecycleObserver;->d:Landroidx/lifecycle/b$a;

    return-void
.end method


# virtual methods
.method public e(Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V
    .registers 5

    iget-object v0, p0, Landroidx/lifecycle/ReflectiveGenericLifecycleObserver;->d:Landroidx/lifecycle/b$a;

    iget-object v1, p0, Landroidx/lifecycle/ReflectiveGenericLifecycleObserver;->c:Ljava/lang/Object;

    invoke-virtual {v0, p1, p2, v1}, Landroidx/lifecycle/b$a;->a(Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;Ljava/lang/Object;)V

    return-void
.end method
