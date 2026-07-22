.class Lc0/g$e0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Cloneable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "e0"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lc0/g$e0$e;,
        Lc0/g$e0$i;,
        Lc0/g$e0$h;,
        Lc0/g$e0$g;,
        Lc0/g$e0$f;,
        Lc0/g$e0$b;,
        Lc0/g$e0$d;,
        Lc0/g$e0$c;,
        Lc0/g$e0$a;
    }
.end annotation


# instance fields
.field A:Ljava/lang/String;

.field B:Ljava/lang/String;

.field C:Ljava/lang/String;

.field D:Ljava/lang/Boolean;

.field E:Ljava/lang/Boolean;

.field F:Lc0/g$o0;

.field G:Ljava/lang/Float;

.field H:Ljava/lang/String;

.field I:Lc0/g$e0$a;

.field J:Ljava/lang/String;

.field K:Lc0/g$o0;

.field L:Ljava/lang/Float;

.field M:Lc0/g$o0;

.field N:Ljava/lang/Float;

.field O:Lc0/g$e0$i;

.field P:Lc0/g$e0$e;

.field c:J

.field d:Lc0/g$o0;

.field f:Lc0/g$e0$a;

.field g:Ljava/lang/Float;

.field h:Lc0/g$o0;

.field i:Ljava/lang/Float;

.field j:Lc0/g$p;

.field k:Lc0/g$e0$c;

.field l:Lc0/g$e0$d;

.field m:Ljava/lang/Float;

.field n:[Lc0/g$p;

.field o:Lc0/g$p;

.field p:Ljava/lang/Float;

.field q:Lc0/g$f;

.field r:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field s:Lc0/g$p;

.field t:Ljava/lang/Integer;

.field u:Lc0/g$e0$b;

.field v:Lc0/g$e0$g;

.field w:Lc0/g$e0$h;

.field x:Lc0/g$e0$f;

.field y:Ljava/lang/Boolean;

.field z:Lc0/g$c;


# direct methods
.method constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lc0/g$e0;->c:J

    return-void
.end method

.method static a()Lc0/g$e0;
    .registers 8

    new-instance v0, Lc0/g$e0;

    invoke-direct {v0}, Lc0/g$e0;-><init>()V

    const-wide/16 v1, -0x1

    iput-wide v1, v0, Lc0/g$e0;->c:J

    sget-object v1, Lc0/g$f;->d:Lc0/g$f;

    iput-object v1, v0, Lc0/g$e0;->d:Lc0/g$o0;

    sget-object v2, Lc0/g$e0$a;->c:Lc0/g$e0$a;

    iput-object v2, v0, Lc0/g$e0;->f:Lc0/g$e0$a;

    const/high16 v3, 0x3f800000    # 1.0f

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    iput-object v4, v0, Lc0/g$e0;->g:Ljava/lang/Float;

    const/4 v5, 0x0

    iput-object v5, v0, Lc0/g$e0;->h:Lc0/g$o0;

    iput-object v4, v0, Lc0/g$e0;->i:Ljava/lang/Float;

    new-instance v6, Lc0/g$p;

    invoke-direct {v6, v3}, Lc0/g$p;-><init>(F)V

    iput-object v6, v0, Lc0/g$e0;->j:Lc0/g$p;

    sget-object v3, Lc0/g$e0$c;->c:Lc0/g$e0$c;

    iput-object v3, v0, Lc0/g$e0;->k:Lc0/g$e0$c;

    sget-object v3, Lc0/g$e0$d;->c:Lc0/g$e0$d;

    iput-object v3, v0, Lc0/g$e0;->l:Lc0/g$e0$d;

    const/high16 v3, 0x40800000    # 4.0f

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    iput-object v3, v0, Lc0/g$e0;->m:Ljava/lang/Float;

    iput-object v5, v0, Lc0/g$e0;->n:[Lc0/g$p;

    new-instance v3, Lc0/g$p;

    const/4 v6, 0x0

    invoke-direct {v3, v6}, Lc0/g$p;-><init>(F)V

    iput-object v3, v0, Lc0/g$e0;->o:Lc0/g$p;

    iput-object v4, v0, Lc0/g$e0;->p:Ljava/lang/Float;

    iput-object v1, v0, Lc0/g$e0;->q:Lc0/g$f;

    iput-object v5, v0, Lc0/g$e0;->r:Ljava/util/List;

    new-instance v3, Lc0/g$p;

    sget-object v6, Lc0/g$d1;->j:Lc0/g$d1;

    const/high16 v7, 0x41400000    # 12.0f

    invoke-direct {v3, v7, v6}, Lc0/g$p;-><init>(FLc0/g$d1;)V

    iput-object v3, v0, Lc0/g$e0;->s:Lc0/g$p;

    const/16 v3, 0x190

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    iput-object v3, v0, Lc0/g$e0;->t:Ljava/lang/Integer;

    sget-object v3, Lc0/g$e0$b;->c:Lc0/g$e0$b;

    iput-object v3, v0, Lc0/g$e0;->u:Lc0/g$e0$b;

    sget-object v3, Lc0/g$e0$g;->c:Lc0/g$e0$g;

    iput-object v3, v0, Lc0/g$e0;->v:Lc0/g$e0$g;

    sget-object v3, Lc0/g$e0$h;->c:Lc0/g$e0$h;

    iput-object v3, v0, Lc0/g$e0;->w:Lc0/g$e0$h;

    sget-object v3, Lc0/g$e0$f;->c:Lc0/g$e0$f;

    iput-object v3, v0, Lc0/g$e0;->x:Lc0/g$e0$f;

    sget-object v3, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    iput-object v3, v0, Lc0/g$e0;->y:Ljava/lang/Boolean;

    iput-object v5, v0, Lc0/g$e0;->z:Lc0/g$c;

    iput-object v5, v0, Lc0/g$e0;->A:Ljava/lang/String;

    iput-object v5, v0, Lc0/g$e0;->B:Ljava/lang/String;

    iput-object v5, v0, Lc0/g$e0;->C:Ljava/lang/String;

    iput-object v3, v0, Lc0/g$e0;->D:Ljava/lang/Boolean;

    iput-object v3, v0, Lc0/g$e0;->E:Ljava/lang/Boolean;

    iput-object v1, v0, Lc0/g$e0;->F:Lc0/g$o0;

    iput-object v4, v0, Lc0/g$e0;->G:Ljava/lang/Float;

    iput-object v5, v0, Lc0/g$e0;->H:Ljava/lang/String;

    iput-object v2, v0, Lc0/g$e0;->I:Lc0/g$e0$a;

    iput-object v5, v0, Lc0/g$e0;->J:Ljava/lang/String;

    iput-object v5, v0, Lc0/g$e0;->K:Lc0/g$o0;

    iput-object v4, v0, Lc0/g$e0;->L:Ljava/lang/Float;

    iput-object v5, v0, Lc0/g$e0;->M:Lc0/g$o0;

    iput-object v4, v0, Lc0/g$e0;->N:Ljava/lang/Float;

    sget-object v1, Lc0/g$e0$i;->c:Lc0/g$e0$i;

    iput-object v1, v0, Lc0/g$e0;->O:Lc0/g$e0$i;

    sget-object v1, Lc0/g$e0$e;->c:Lc0/g$e0$e;

    iput-object v1, v0, Lc0/g$e0;->P:Lc0/g$e0$e;

    return-object v0
.end method


# virtual methods
.method b(Z)V
    .registers 4

    sget-object v0, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    iput-object v0, p0, Lc0/g$e0;->D:Ljava/lang/Boolean;

    if-eqz p1, :cond_7

    goto :goto_9

    :cond_7
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    :goto_9
    iput-object v0, p0, Lc0/g$e0;->y:Ljava/lang/Boolean;

    const/4 p1, 0x0

    iput-object p1, p0, Lc0/g$e0;->z:Lc0/g$c;

    iput-object p1, p0, Lc0/g$e0;->H:Ljava/lang/String;

    const/high16 v0, 0x3f800000    # 1.0f

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    iput-object v1, p0, Lc0/g$e0;->p:Ljava/lang/Float;

    sget-object v1, Lc0/g$f;->d:Lc0/g$f;

    iput-object v1, p0, Lc0/g$e0;->F:Lc0/g$o0;

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    iput-object v1, p0, Lc0/g$e0;->G:Ljava/lang/Float;

    iput-object p1, p0, Lc0/g$e0;->J:Ljava/lang/String;

    iput-object p1, p0, Lc0/g$e0;->K:Lc0/g$o0;

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    iput-object v1, p0, Lc0/g$e0;->L:Ljava/lang/Float;

    iput-object p1, p0, Lc0/g$e0;->M:Lc0/g$o0;

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->N:Ljava/lang/Float;

    sget-object p1, Lc0/g$e0$i;->c:Lc0/g$e0$i;

    iput-object p1, p0, Lc0/g$e0;->O:Lc0/g$e0$i;

    return-void
.end method

.method protected clone()Ljava/lang/Object;
    .registers 3

    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lc0/g$e0;

    iget-object v1, p0, Lc0/g$e0;->n:[Lc0/g$p;

    if-eqz v1, :cond_12

    invoke-virtual {v1}, [Lc0/g$p;->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lc0/g$p;

    iput-object v1, v0, Lc0/g$e0;->n:[Lc0/g$p;

    :cond_12
    return-object v0
.end method
