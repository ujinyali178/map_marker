.class Landroidx/fragment/app/Fragment$j;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/fragment/app/Fragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "j"
.end annotation


# instance fields
.field a:Landroid/view/View;

.field b:Z

.field c:I

.field d:I

.field e:I

.field f:I

.field g:I

.field h:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field i:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field j:Ljava/lang/Object;

.field k:Ljava/lang/Object;

.field l:Ljava/lang/Object;

.field m:Ljava/lang/Object;

.field n:Ljava/lang/Object;

.field o:Ljava/lang/Object;

.field p:Ljava/lang/Boolean;

.field q:Ljava/lang/Boolean;

.field r:F

.field s:Landroid/view/View;

.field t:Z


# direct methods
.method constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/fragment/app/Fragment$j;->j:Ljava/lang/Object;

    sget-object v1, Landroidx/fragment/app/Fragment;->USE_DEFAULT_TRANSITION:Ljava/lang/Object;

    iput-object v1, p0, Landroidx/fragment/app/Fragment$j;->k:Ljava/lang/Object;

    iput-object v0, p0, Landroidx/fragment/app/Fragment$j;->l:Ljava/lang/Object;

    iput-object v1, p0, Landroidx/fragment/app/Fragment$j;->m:Ljava/lang/Object;

    iput-object v0, p0, Landroidx/fragment/app/Fragment$j;->n:Ljava/lang/Object;

    iput-object v1, p0, Landroidx/fragment/app/Fragment$j;->o:Ljava/lang/Object;

    const/high16 v1, 0x3f800000    # 1.0f

    iput v1, p0, Landroidx/fragment/app/Fragment$j;->r:F

    iput-object v0, p0, Landroidx/fragment/app/Fragment$j;->s:Landroid/view/View;

    return-void
.end method
