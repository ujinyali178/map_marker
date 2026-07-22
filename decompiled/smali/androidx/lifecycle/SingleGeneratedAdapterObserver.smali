.class public final Landroidx/lifecycle/SingleGeneratedAdapterObserver;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/lifecycle/g;


# instance fields
.field private final c:Landroidx/lifecycle/c;


# direct methods
.method public constructor <init>(Landroidx/lifecycle/c;)V
    .registers 3

    const-string v0, "generatedAdapter"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/lifecycle/SingleGeneratedAdapterObserver;->c:Landroidx/lifecycle/c;

    return-void
.end method


# virtual methods
.method public e(Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V
    .registers 6

    const-string v0, "source"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "event"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    iget-object v0, p0, Landroidx/lifecycle/SingleGeneratedAdapterObserver;->c:Landroidx/lifecycle/c;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-interface {v0, p1, p2, v1, v2}, Landroidx/lifecycle/c;->a(Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;ZLandroidx/lifecycle/m;)V

    iget-object v0, p0, Landroidx/lifecycle/SingleGeneratedAdapterObserver;->c:Landroidx/lifecycle/c;

    const/4 v1, 0x1

    invoke-interface {v0, p1, p2, v1, v2}, Landroidx/lifecycle/c;->a(Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;ZLandroidx/lifecycle/m;)V

    return-void
.end method
