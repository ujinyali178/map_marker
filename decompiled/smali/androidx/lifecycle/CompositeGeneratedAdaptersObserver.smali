.class public final Landroidx/lifecycle/CompositeGeneratedAdaptersObserver;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/lifecycle/g;


# instance fields
.field private final c:[Landroidx/lifecycle/c;


# direct methods
.method public constructor <init>([Landroidx/lifecycle/c;)V
    .registers 3

    const-string v0, "generatedAdapters"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/lifecycle/CompositeGeneratedAdaptersObserver;->c:[Landroidx/lifecycle/c;

    return-void
.end method


# virtual methods
.method public e(Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;)V
    .registers 9

    const-string v0, "source"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "event"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Landroidx/lifecycle/m;

    invoke-direct {v0}, Landroidx/lifecycle/m;-><init>()V

    iget-object v1, p0, Landroidx/lifecycle/CompositeGeneratedAdaptersObserver;->c:[Landroidx/lifecycle/c;

    array-length v2, v1

    const/4 v3, 0x0

    const/4 v4, 0x0

    :goto_14
    if-ge v4, v2, :cond_1e

    aget-object v5, v1, v4

    invoke-interface {v5, p1, p2, v3, v0}, Landroidx/lifecycle/c;->a(Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;ZLandroidx/lifecycle/m;)V

    add-int/lit8 v4, v4, 0x1

    goto :goto_14

    :cond_1e
    iget-object v1, p0, Landroidx/lifecycle/CompositeGeneratedAdaptersObserver;->c:[Landroidx/lifecycle/c;

    array-length v2, v1

    :goto_21
    if-ge v3, v2, :cond_2d

    aget-object v4, v1, v3

    const/4 v5, 0x1

    const/4 v5, 0x1

    invoke-interface {v4, p1, p2, v5, v0}, Landroidx/lifecycle/c;->a(Landroidx/lifecycle/i;Landroidx/lifecycle/e$a;ZLandroidx/lifecycle/m;)V

    add-int/lit8 v3, v3, 0x1

    goto :goto_21

    :cond_2d
    return-void
.end method
