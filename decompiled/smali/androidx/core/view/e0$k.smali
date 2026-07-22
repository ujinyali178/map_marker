.class Landroidx/core/view/e0$k;
.super Landroidx/core/view/e0$j;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/view/e0;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "k"
.end annotation


# static fields
.field static final q:Landroidx/core/view/e0;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    sget-object v0, Landroid/view/WindowInsets;->CONSUMED:Landroid/view/WindowInsets;

    invoke-static {v0}, Landroidx/core/view/e0;->n(Landroid/view/WindowInsets;)Landroidx/core/view/e0;

    move-result-object v0

    sput-object v0, Landroidx/core/view/e0$k;->q:Landroidx/core/view/e0;

    return-void
.end method

.method constructor <init>(Landroidx/core/view/e0;Landroid/view/WindowInsets;)V
    .registers 3

    invoke-direct {p0, p1, p2}, Landroidx/core/view/e0$j;-><init>(Landroidx/core/view/e0;Landroid/view/WindowInsets;)V

    return-void
.end method

.method constructor <init>(Landroidx/core/view/e0;Landroidx/core/view/e0$k;)V
    .registers 3

    invoke-direct {p0, p1, p2}, Landroidx/core/view/e0$j;-><init>(Landroidx/core/view/e0;Landroidx/core/view/e0$j;)V

    return-void
.end method


# virtual methods
.method final d(Landroid/view/View;)V
    .registers 2

    return-void
.end method

.method public g(I)Landroidx/core/graphics/b;
    .registers 3

    iget-object v0, p0, Landroidx/core/view/e0$g;->c:Landroid/view/WindowInsets;

    invoke-static {p1}, Landroidx/core/view/e0$n;->a(I)I

    move-result p1

    invoke-static {v0, p1}, Landroidx/core/view/k0;->a(Landroid/view/WindowInsets;I)Landroid/graphics/Insets;

    move-result-object p1

    invoke-static {p1}, Landroidx/core/graphics/b;->d(Landroid/graphics/Insets;)Landroidx/core/graphics/b;

    move-result-object p1

    return-object p1
.end method
