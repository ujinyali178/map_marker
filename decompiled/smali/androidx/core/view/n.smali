.class public Landroidx/core/view/n;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/view/n$i;,
        Landroidx/core/view/n$d;,
        Landroidx/core/view/n$g;,
        Landroidx/core/view/n$c;,
        Landroidx/core/view/n$e;,
        Landroidx/core/view/n$f;,
        Landroidx/core/view/n$h;,
        Landroidx/core/view/n$j;,
        Landroidx/core/view/n$k;,
        Landroidx/core/view/n$b;
    }
.end annotation


# static fields
.field private static final a:Ljava/util/concurrent/atomic/AtomicInteger;

.field private static b:Ljava/util/WeakHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/WeakHashMap<",
            "Landroid/view/View;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private static c:Z

.field private static final d:[I

.field private static final e:Landroidx/core/view/j;

.field private static final f:Landroidx/core/view/n$b;


# direct methods
.method static constructor <clinit>()V
    .registers 4

    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    sput-object v0, Landroidx/core/view/n;->a:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v0, 0x0

    sput-object v0, Landroidx/core/view/n;->b:Ljava/util/WeakHashMap;

    const/4 v0, 0x0

    sput-boolean v0, Landroidx/core/view/n;->c:Z

    const/16 v2, 0x20

    new-array v2, v2, [I

    sget v3, Lh/d;->a:I

    aput v3, v2, v0

    sget v0, Lh/d;->b:I

    aput v0, v2, v1

    sget v0, Lh/d;->m:I

    const/4 v1, 0x2

    aput v0, v2, v1

    sget v0, Lh/d;->x:I

    const/4 v1, 0x3

    aput v0, v2, v1

    sget v0, Lh/d;->A:I

    const/4 v1, 0x4

    aput v0, v2, v1

    sget v0, Lh/d;->B:I

    const/4 v1, 0x5

    aput v0, v2, v1

    sget v0, Lh/d;->C:I

    const/4 v1, 0x6

    aput v0, v2, v1

    sget v0, Lh/d;->D:I

    const/4 v1, 0x7

    aput v0, v2, v1

    sget v0, Lh/d;->E:I

    const/16 v1, 0x8

    aput v0, v2, v1

    sget v0, Lh/d;->F:I

    const/16 v1, 0x9

    aput v0, v2, v1

    sget v0, Lh/d;->c:I

    const/16 v1, 0xa

    aput v0, v2, v1

    sget v0, Lh/d;->d:I

    const/16 v1, 0xb

    aput v0, v2, v1

    sget v0, Lh/d;->e:I

    const/16 v1, 0xc

    aput v0, v2, v1

    sget v0, Lh/d;->f:I

    const/16 v1, 0xd

    aput v0, v2, v1

    sget v0, Lh/d;->g:I

    const/16 v1, 0xe

    aput v0, v2, v1

    sget v0, Lh/d;->h:I

    const/16 v1, 0xf

    aput v0, v2, v1

    sget v0, Lh/d;->i:I

    const/16 v1, 0x10

    aput v0, v2, v1

    sget v0, Lh/d;->j:I

    const/16 v1, 0x11

    aput v0, v2, v1

    sget v0, Lh/d;->k:I

    const/16 v1, 0x12

    aput v0, v2, v1

    sget v0, Lh/d;->l:I

    const/16 v1, 0x13

    aput v0, v2, v1

    sget v0, Lh/d;->n:I

    const/16 v1, 0x14

    aput v0, v2, v1

    sget v0, Lh/d;->o:I

    const/16 v1, 0x15

    aput v0, v2, v1

    sget v0, Lh/d;->p:I

    const/16 v1, 0x16

    aput v0, v2, v1

    sget v0, Lh/d;->q:I

    const/16 v1, 0x17

    aput v0, v2, v1

    sget v0, Lh/d;->r:I

    const/16 v1, 0x18

    aput v0, v2, v1

    sget v0, Lh/d;->s:I

    const/16 v1, 0x19

    aput v0, v2, v1

    sget v0, Lh/d;->t:I

    const/16 v1, 0x1a

    aput v0, v2, v1

    sget v0, Lh/d;->u:I

    const/16 v1, 0x1b

    aput v0, v2, v1

    sget v0, Lh/d;->v:I

    const/16 v1, 0x1c

    aput v0, v2, v1

    sget v0, Lh/d;->w:I

    const/16 v1, 0x1d

    aput v0, v2, v1

    sget v0, Lh/d;->y:I

    const/16 v1, 0x1e

    aput v0, v2, v1

    sget v0, Lh/d;->z:I

    const/16 v1, 0x1f

    aput v0, v2, v1

    sput-object v2, Landroidx/core/view/n;->d:[I

    new-instance v0, Landroidx/core/view/m;

    invoke-direct {v0}, Landroidx/core/view/m;-><init>()V

    sput-object v0, Landroidx/core/view/n;->e:Landroidx/core/view/j;

    new-instance v0, Landroidx/core/view/n$b;

    invoke-direct {v0}, Landroidx/core/view/n$b;-><init>()V

    sput-object v0, Landroidx/core/view/n;->f:Landroidx/core/view/n$b;

    return-void
.end method

.method public static a(Landroid/view/View;Landroidx/core/view/e0;)Landroidx/core/view/e0;
    .registers 4

    invoke-virtual {p1}, Landroidx/core/view/e0;->m()Landroid/view/WindowInsets;

    move-result-object v0

    if-eqz v0, :cond_15

    invoke-static {p0, v0}, Landroidx/core/view/n$f;->a(Landroid/view/View;Landroid/view/WindowInsets;)Landroid/view/WindowInsets;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/WindowInsets;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_15

    invoke-static {v1, p0}, Landroidx/core/view/e0;->o(Landroid/view/WindowInsets;Landroid/view/View;)Landroidx/core/view/e0;

    move-result-object p0

    return-object p0

    :cond_15
    return-object p1
.end method

.method static b(Landroid/view/View;Landroid/view/KeyEvent;)Z
    .registers 4

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1c

    if-lt v0, v1, :cond_8

    const/4 p0, 0x0

    return p0

    :cond_8
    invoke-static {p0}, Landroidx/core/view/n$k;->a(Landroid/view/View;)Landroidx/core/view/n$k;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Landroidx/core/view/n$k;->b(Landroid/view/View;Landroid/view/KeyEvent;)Z

    move-result p0

    return p0
.end method

.method static c(Landroid/view/View;Landroid/view/KeyEvent;)Z
    .registers 4

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1c

    if-lt v0, v1, :cond_8

    const/4 p0, 0x0

    return p0

    :cond_8
    invoke-static {p0}, Landroidx/core/view/n$k;->a(Landroid/view/View;)Landroidx/core/view/n$k;

    move-result-object p0

    invoke-virtual {p0, p1}, Landroidx/core/view/n$k;->f(Landroid/view/KeyEvent;)Z

    move-result p0

    return p0
.end method

.method public static d(Landroid/view/View;)I
    .registers 1

    invoke-static {p0}, Landroidx/core/view/n$e;->a(Landroid/view/View;)I

    move-result p0

    return p0
.end method

.method public static e(Landroid/view/View;)Ljava/lang/CharSequence;
    .registers 2

    invoke-static {}, Landroidx/core/view/n;->m()Landroidx/core/view/n$c;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroidx/core/view/n$c;->d(Landroid/view/View;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/CharSequence;

    return-object p0
.end method

.method public static f(Landroid/view/View;)I
    .registers 1

    invoke-static {p0}, Landroidx/core/view/n$d;->c(Landroid/view/View;)I

    move-result p0

    return p0
.end method

.method public static g(Landroid/view/View;)Landroidx/core/view/e0;
    .registers 3

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_b

    invoke-static {p0}, Landroidx/core/view/n$h;->a(Landroid/view/View;)Landroidx/core/view/e0;

    move-result-object p0

    return-object p0

    :cond_b
    invoke-static {p0}, Landroidx/core/view/n$g;->j(Landroid/view/View;)Landroidx/core/view/e0;

    move-result-object p0

    return-object p0
.end method

.method public static h(Landroid/view/View;)Ljava/lang/String;
    .registers 1

    invoke-static {p0}, Landroidx/core/view/n$g;->k(Landroid/view/View;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static i(Landroid/view/View;)Z
    .registers 1

    invoke-static {p0}, Landroidx/core/view/n$e;->b(Landroid/view/View;)Z

    move-result p0

    return p0
.end method

.method public static j(Landroid/view/View;)Z
    .registers 1

    invoke-static {p0}, Landroidx/core/view/n$e;->c(Landroid/view/View;)Z

    move-result p0

    return p0
.end method

.method static k(Landroid/view/View;I)V
    .registers 6

    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "accessibility"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/accessibility/AccessibilityManager;

    invoke-virtual {v0}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v1

    if-nez v1, :cond_13

    return-void

    :cond_13
    invoke-static {p0}, Landroidx/core/view/n;->e(Landroid/view/View;)Ljava/lang/CharSequence;

    move-result-object v1

    if-eqz v1, :cond_27

    invoke-virtual {p0}, Landroid/view/View;->isShown()Z

    move-result v1

    if-eqz v1, :cond_27

    invoke-virtual {p0}, Landroid/view/View;->getWindowVisibility()I

    move-result v1

    if-nez v1, :cond_27

    const/4 v1, 0x1

    goto :goto_28

    :cond_27
    const/4 v1, 0x0

    :goto_28
    invoke-static {p0}, Landroidx/core/view/n;->d(Landroid/view/View;)I

    move-result v2

    const/16 v3, 0x20

    if-nez v2, :cond_89

    if-eqz v1, :cond_33

    goto :goto_89

    :cond_33
    if-ne p1, v3, :cond_57

    invoke-static {}, Landroid/view/accessibility/AccessibilityEvent;->obtain()Landroid/view/accessibility/AccessibilityEvent;

    move-result-object v1

    invoke-virtual {p0, v1}, Landroid/view/View;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    invoke-virtual {v1, v3}, Landroid/view/accessibility/AccessibilityEvent;->setEventType(I)V

    invoke-static {v1, p1}, Landroidx/core/view/n$e;->g(Landroid/view/accessibility/AccessibilityEvent;I)V

    invoke-virtual {v1, p0}, Landroid/view/accessibility/AccessibilityRecord;->setSource(Landroid/view/View;)V

    invoke-virtual {p0, v1}, Landroid/view/View;->onPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    invoke-virtual {v1}, Landroid/view/accessibility/AccessibilityRecord;->getText()Ljava/util/List;

    move-result-object p1

    invoke-static {p0}, Landroidx/core/view/n;->e(Landroid/view/View;)Ljava/lang/CharSequence;

    move-result-object p0

    invoke-interface {p1, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-virtual {v0, v1}, Landroid/view/accessibility/AccessibilityManager;->sendAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    goto :goto_ab

    :cond_57
    invoke-virtual {p0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_ab

    invoke-virtual {p0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    :try_start_61
    invoke-static {v0, p0, p0, p1}, Landroidx/core/view/n$e;->e(Landroid/view/ViewParent;Landroid/view/View;Landroid/view/View;I)V
    :try_end_64
    .catch Ljava/lang/AbstractMethodError; {:try_start_61 .. :try_end_64} :catch_65

    goto :goto_ab

    :catch_65
    move-exception p1

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p0, " does not fully implement ViewParent"

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    const-string v0, "ViewCompat"

    invoke-static {v0, p0, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_ab

    :cond_89
    :goto_89
    invoke-static {}, Landroid/view/accessibility/AccessibilityEvent;->obtain()Landroid/view/accessibility/AccessibilityEvent;

    move-result-object v0

    if-eqz v1, :cond_90

    goto :goto_92

    :cond_90
    const/16 v3, 0x800

    :goto_92
    invoke-virtual {v0, v3}, Landroid/view/accessibility/AccessibilityEvent;->setEventType(I)V

    invoke-static {v0, p1}, Landroidx/core/view/n$e;->g(Landroid/view/accessibility/AccessibilityEvent;I)V

    if-eqz v1, :cond_a8

    invoke-virtual {v0}, Landroid/view/accessibility/AccessibilityRecord;->getText()Ljava/util/List;

    move-result-object p1

    invoke-static {p0}, Landroidx/core/view/n;->e(Landroid/view/View;)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {p1, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-static {p0}, Landroidx/core/view/n;->p(Landroid/view/View;)V

    :cond_a8
    invoke-virtual {p0, v0}, Landroid/view/View;->sendAccessibilityEventUnchecked(Landroid/view/accessibility/AccessibilityEvent;)V

    :cond_ab
    :goto_ab
    return-void
.end method

.method public static l(Landroid/view/View;Landroidx/core/view/e0;)Landroidx/core/view/e0;
    .registers 4

    invoke-virtual {p1}, Landroidx/core/view/e0;->m()Landroid/view/WindowInsets;

    move-result-object v0

    if-eqz v0, :cond_15

    invoke-static {p0, v0}, Landroidx/core/view/n$f;->b(Landroid/view/View;Landroid/view/WindowInsets;)Landroid/view/WindowInsets;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/WindowInsets;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_15

    invoke-static {v1, p0}, Landroidx/core/view/e0;->o(Landroid/view/WindowInsets;Landroid/view/View;)Landroidx/core/view/e0;

    move-result-object p0

    return-object p0

    :cond_15
    return-object p1
.end method

.method private static m()Landroidx/core/view/n$c;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/core/view/n$c<",
            "Ljava/lang/CharSequence;",
            ">;"
        }
    .end annotation

    new-instance v0, Landroidx/core/view/n$a;

    sget v1, Lh/d;->G:I

    const-class v2, Ljava/lang/CharSequence;

    const/16 v3, 0x8

    const/16 v4, 0x1c

    invoke-direct {v0, v1, v2, v3, v4}, Landroidx/core/view/n$a;-><init>(ILjava/lang/Class;II)V

    return-object v0
.end method

.method public static n(Landroid/view/View;)V
    .registers 1

    invoke-static {p0}, Landroidx/core/view/n$f;->c(Landroid/view/View;)V

    return-void
.end method

.method public static o(Landroid/view/View;I)V
    .registers 2

    invoke-static {p0, p1}, Landroidx/core/view/n$d;->s(Landroid/view/View;I)V

    return-void
.end method

.method private static p(Landroid/view/View;)V
    .registers 2

    invoke-static {p0}, Landroidx/core/view/n;->f(Landroid/view/View;)I

    move-result v0

    if-nez v0, :cond_a

    const/4 v0, 0x1

    invoke-static {p0, v0}, Landroidx/core/view/n;->o(Landroid/view/View;I)V

    :cond_a
    return-void
.end method

.method public static q(Landroid/view/View;Ljava/lang/String;)V
    .registers 2

    invoke-static {p0, p1}, Landroidx/core/view/n$g;->v(Landroid/view/View;Ljava/lang/String;)V

    return-void
.end method
