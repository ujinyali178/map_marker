.class public final La2/e$r$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La2/e$r;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field private a:Ljava/lang/Long;

.field private b:Ljava/lang/Long;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;

.field private e:Ljava/lang/String;

.field private f:Ljava/lang/String;

.field private g:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()La2/e$r;
    .registers 3

    new-instance v0, La2/e$r;

    invoke-direct {v0}, La2/e$r;-><init>()V

    iget-object v1, p0, La2/e$r$a;->a:Ljava/lang/Long;

    invoke-virtual {v0, v1}, La2/e$r;->g(Ljava/lang/Long;)V

    iget-object v1, p0, La2/e$r$a;->b:Ljava/lang/Long;

    invoke-virtual {v0, v1}, La2/e$r;->e(Ljava/lang/Long;)V

    iget-object v1, p0, La2/e$r$a;->c:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$r;->b(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$r$a;->d:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$r;->c(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$r$a;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$r;->f(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$r$a;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$r;->h(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$r$a;->g:Ljava/util/List;

    invoke-virtual {v0, v1}, La2/e$r;->d(Ljava/util/List;)V

    return-object v0
.end method

.method public b(Ljava/lang/String;)La2/e$r$a;
    .registers 2

    iput-object p1, p0, La2/e$r$a;->c:Ljava/lang/String;

    return-object p0
.end method

.method public c(Ljava/lang/String;)La2/e$r$a;
    .registers 2

    iput-object p1, p0, La2/e$r$a;->d:Ljava/lang/String;

    return-object p0
.end method

.method public d(Ljava/util/List;)La2/e$r$a;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)",
            "La2/e$r$a;"
        }
    .end annotation

    iput-object p1, p0, La2/e$r$a;->g:Ljava/util/List;

    return-object p0
.end method

.method public e(Ljava/lang/Long;)La2/e$r$a;
    .registers 2

    iput-object p1, p0, La2/e$r$a;->b:Ljava/lang/Long;

    return-object p0
.end method

.method public f(Ljava/lang/String;)La2/e$r$a;
    .registers 2

    iput-object p1, p0, La2/e$r$a;->e:Ljava/lang/String;

    return-object p0
.end method

.method public g(Ljava/lang/Long;)La2/e$r$a;
    .registers 2

    iput-object p1, p0, La2/e$r$a;->a:Ljava/lang/Long;

    return-object p0
.end method

.method public h(Ljava/lang/String;)La2/e$r$a;
    .registers 2

    iput-object p1, p0, La2/e$r$a;->f:Ljava/lang/String;

    return-object p0
.end method
