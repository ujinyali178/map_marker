.class public final La2/e$q$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La2/e$q;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/Long;

.field private d:Ljava/lang/String;

.field private e:Ljava/lang/String;

.field private f:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private g:Ljava/lang/Boolean;

.field private h:Ljava/lang/String;

.field private i:Ljava/lang/String;

.field private j:Ljava/lang/Boolean;

.field private k:Ljava/lang/Long;

.field private l:La2/e$t;

.field private m:La2/e$f;


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()La2/e$q;
    .registers 3

    new-instance v0, La2/e$q;

    invoke-direct {v0}, La2/e$q;-><init>()V

    iget-object v1, p0, La2/e$q$a;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$q;->f(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$q$a;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$q;->h(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$q$a;->c:Ljava/lang/Long;

    invoke-virtual {v0, v1}, La2/e$q;->k(Ljava/lang/Long;)V

    iget-object v1, p0, La2/e$q$a;->d:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$q;->l(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$q$a;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$q;->n(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$q$a;->f:Ljava/util/List;

    invoke-virtual {v0, v1}, La2/e$q;->i(Ljava/util/List;)V

    iget-object v1, p0, La2/e$q$a;->g:Ljava/lang/Boolean;

    invoke-virtual {v0, v1}, La2/e$q;->e(Ljava/lang/Boolean;)V

    iget-object v1, p0, La2/e$q$a;->h:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$q;->g(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$q$a;->i:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$q;->c(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$q$a;->j:Ljava/lang/Boolean;

    invoke-virtual {v0, v1}, La2/e$q;->d(Ljava/lang/Boolean;)V

    iget-object v1, p0, La2/e$q$a;->k:Ljava/lang/Long;

    invoke-virtual {v0, v1}, La2/e$q;->m(Ljava/lang/Long;)V

    iget-object v1, p0, La2/e$q$a;->l:La2/e$t;

    invoke-virtual {v0, v1}, La2/e$q;->j(La2/e$t;)V

    iget-object v1, p0, La2/e$q$a;->m:La2/e$f;

    invoke-virtual {v0, v1}, La2/e$q;->b(La2/e$f;)V

    return-object v0
.end method

.method public b(La2/e$f;)La2/e$q$a;
    .registers 2

    iput-object p1, p0, La2/e$q$a;->m:La2/e$f;

    return-object p0
.end method

.method public c(Ljava/lang/String;)La2/e$q$a;
    .registers 2

    iput-object p1, p0, La2/e$q$a;->i:Ljava/lang/String;

    return-object p0
.end method

.method public d(Ljava/lang/Boolean;)La2/e$q$a;
    .registers 2

    iput-object p1, p0, La2/e$q$a;->j:Ljava/lang/Boolean;

    return-object p0
.end method

.method public e(Ljava/lang/Boolean;)La2/e$q$a;
    .registers 2

    iput-object p1, p0, La2/e$q$a;->g:Ljava/lang/Boolean;

    return-object p0
.end method

.method public f(Ljava/lang/String;)La2/e$q$a;
    .registers 2

    iput-object p1, p0, La2/e$q$a;->a:Ljava/lang/String;

    return-object p0
.end method

.method public g(Ljava/lang/String;)La2/e$q$a;
    .registers 2

    iput-object p1, p0, La2/e$q$a;->h:Ljava/lang/String;

    return-object p0
.end method

.method public h(Ljava/lang/String;)La2/e$q$a;
    .registers 2

    iput-object p1, p0, La2/e$q$a;->b:Ljava/lang/String;

    return-object p0
.end method

.method public i(Ljava/util/List;)La2/e$q$a;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)",
            "La2/e$q$a;"
        }
    .end annotation

    iput-object p1, p0, La2/e$q$a;->f:Ljava/util/List;

    return-object p0
.end method

.method public j(La2/e$t;)La2/e$q$a;
    .registers 2

    iput-object p1, p0, La2/e$q$a;->l:La2/e$t;

    return-object p0
.end method

.method public k(Ljava/lang/Long;)La2/e$q$a;
    .registers 2

    iput-object p1, p0, La2/e$q$a;->c:Ljava/lang/Long;

    return-object p0
.end method

.method public l(Ljava/lang/String;)La2/e$q$a;
    .registers 2

    iput-object p1, p0, La2/e$q$a;->d:Ljava/lang/String;

    return-object p0
.end method

.method public m(Ljava/lang/Long;)La2/e$q$a;
    .registers 2

    iput-object p1, p0, La2/e$q$a;->k:Ljava/lang/Long;

    return-object p0
.end method

.method public n(Ljava/lang/String;)La2/e$q$a;
    .registers 2

    iput-object p1, p0, La2/e$q$a;->e:Ljava/lang/String;

    return-object p0
.end method
