.class Landroidx/core/view/n$i;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/view/n;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "i"
.end annotation


# direct methods
.method static a(Landroid/view/View;Landroidx/core/view/n$j;)V
    .registers 4

    sget v0, Lh/d;->J:I

    invoke-virtual {p0, v0}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/collection/g;

    if-nez v1, :cond_12

    new-instance v1, Landroidx/collection/g;

    invoke-direct {v1}, Landroidx/collection/g;-><init>()V

    invoke-virtual {p0, v0, v1}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    :cond_12
    invoke-static {p1}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v0, Landroidx/core/view/c0;

    invoke-direct {v0, p1}, Landroidx/core/view/c0;-><init>(Landroidx/core/view/n$j;)V

    invoke-virtual {v1, p1, v0}, Landroidx/collection/g;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {p0, v0}, Landroidx/core/view/u;->a(Landroid/view/View;Landroid/view/View$OnUnhandledKeyEventListener;)V

    return-void
.end method

.method static b(Landroid/view/View;)Ljava/lang/CharSequence;
    .registers 1

    invoke-static {p0}, Landroidx/core/view/b0;->a(Landroid/view/View;)Ljava/lang/CharSequence;

    move-result-object p0

    return-object p0
.end method

.method static c(Landroid/view/View;)Z
    .registers 1

    invoke-static {p0}, Landroidx/core/view/w;->a(Landroid/view/View;)Z

    move-result p0

    return p0
.end method

.method static d(Landroid/view/View;)Z
    .registers 1

    invoke-static {p0}, Landroidx/core/view/s;->a(Landroid/view/View;)Z

    move-result p0

    return p0
.end method

.method static e(Landroid/view/View;Landroidx/core/view/n$j;)V
    .registers 3

    sget v0, Lh/d;->J:I

    invoke-virtual {p0, v0}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/collection/g;

    if-nez v0, :cond_b

    return-void

    :cond_b
    invoke-virtual {v0, p1}, Landroidx/collection/g;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/view/View$OnUnhandledKeyEventListener;

    if-eqz p1, :cond_16

    invoke-static {p0, p1}, Landroidx/core/view/z;->a(Landroid/view/View;Landroid/view/View$OnUnhandledKeyEventListener;)V

    :cond_16
    return-void
.end method

.method static f(Landroid/view/View;I)Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/view/View;",
            "I)TT;"
        }
    .end annotation

    invoke-static {p0, p1}, Landroidx/core/view/a0;->a(Landroid/view/View;I)Landroid/view/View;

    move-result-object p0

    return-object p0
.end method

.method static g(Landroid/view/View;Z)V
    .registers 2

    invoke-static {p0, p1}, Landroidx/core/view/x;->a(Landroid/view/View;Z)V

    return-void
.end method

.method static h(Landroid/view/View;Ljava/lang/CharSequence;)V
    .registers 2

    invoke-static {p0, p1}, Landroidx/core/view/y;->a(Landroid/view/View;Ljava/lang/CharSequence;)V

    return-void
.end method

.method public static i(Landroid/view/View;Landroid/view/autofill/AutofillId;)V
    .registers 2

    invoke-static {p0, p1}, Landroidx/core/view/v;->a(Landroid/view/View;Landroid/view/autofill/AutofillId;)V

    return-void
.end method

.method static j(Landroid/view/View;Z)V
    .registers 2

    invoke-static {p0, p1}, Landroidx/core/view/t;->a(Landroid/view/View;Z)V

    return-void
.end method
