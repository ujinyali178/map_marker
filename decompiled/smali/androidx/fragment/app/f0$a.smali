.class final Landroidx/fragment/app/f0$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/fragment/app/f0;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "a"
.end annotation


# instance fields
.field a:I

.field b:Landroidx/fragment/app/Fragment;

.field c:Z

.field d:I

.field e:I

.field f:I

.field g:I

.field h:Landroidx/lifecycle/e$b;

.field i:Landroidx/lifecycle/e$b;


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method constructor <init>(ILandroidx/fragment/app/Fragment;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Landroidx/fragment/app/f0$a;->a:I

    iput-object p2, p0, Landroidx/fragment/app/f0$a;->b:Landroidx/fragment/app/Fragment;

    const/4 p1, 0x0

    iput-boolean p1, p0, Landroidx/fragment/app/f0$a;->c:Z

    sget-object p1, Landroidx/lifecycle/e$b;->h:Landroidx/lifecycle/e$b;

    iput-object p1, p0, Landroidx/fragment/app/f0$a;->h:Landroidx/lifecycle/e$b;

    iput-object p1, p0, Landroidx/fragment/app/f0$a;->i:Landroidx/lifecycle/e$b;

    return-void
.end method

.method constructor <init>(ILandroidx/fragment/app/Fragment;Z)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Landroidx/fragment/app/f0$a;->a:I

    iput-object p2, p0, Landroidx/fragment/app/f0$a;->b:Landroidx/fragment/app/Fragment;

    iput-boolean p3, p0, Landroidx/fragment/app/f0$a;->c:Z

    sget-object p1, Landroidx/lifecycle/e$b;->h:Landroidx/lifecycle/e$b;

    iput-object p1, p0, Landroidx/fragment/app/f0$a;->h:Landroidx/lifecycle/e$b;

    iput-object p1, p0, Landroidx/fragment/app/f0$a;->i:Landroidx/lifecycle/e$b;

    return-void
.end method
