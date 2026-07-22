.class public final La2/e$n$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La2/e$n;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:La2/e$p;

.field private e:Ljava/lang/String;

.field private f:La2/e$l;

.field private g:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "La2/e$x;",
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
.method public a()La2/e$n;
    .registers 3

    new-instance v0, La2/e$n;

    invoke-direct {v0}, La2/e$n;-><init>()V

    iget-object v1, p0, La2/e$n$a;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$n;->b(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$n$a;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$n;->c(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$n$a;->c:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$n;->e(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$n$a;->d:La2/e$p;

    invoke-virtual {v0, v1}, La2/e$n;->f(La2/e$p;)V

    iget-object v1, p0, La2/e$n$a;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$n;->h(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$n$a;->f:La2/e$l;

    invoke-virtual {v0, v1}, La2/e$n;->d(La2/e$l;)V

    iget-object v1, p0, La2/e$n$a;->g:Ljava/util/List;

    invoke-virtual {v0, v1}, La2/e$n;->g(Ljava/util/List;)V

    return-object v0
.end method

.method public b(Ljava/lang/String;)La2/e$n$a;
    .registers 2

    iput-object p1, p0, La2/e$n$a;->a:Ljava/lang/String;

    return-object p0
.end method

.method public c(Ljava/lang/String;)La2/e$n$a;
    .registers 2

    iput-object p1, p0, La2/e$n$a;->b:Ljava/lang/String;

    return-object p0
.end method

.method public d(La2/e$l;)La2/e$n$a;
    .registers 2

    iput-object p1, p0, La2/e$n$a;->f:La2/e$l;

    return-object p0
.end method

.method public e(Ljava/lang/String;)La2/e$n$a;
    .registers 2

    iput-object p1, p0, La2/e$n$a;->c:Ljava/lang/String;

    return-object p0
.end method

.method public f(La2/e$p;)La2/e$n$a;
    .registers 2

    iput-object p1, p0, La2/e$n$a;->d:La2/e$p;

    return-object p0
.end method

.method public g(Ljava/util/List;)La2/e$n$a;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "La2/e$x;",
            ">;)",
            "La2/e$n$a;"
        }
    .end annotation

    iput-object p1, p0, La2/e$n$a;->g:Ljava/util/List;

    return-object p0
.end method

.method public h(Ljava/lang/String;)La2/e$n$a;
    .registers 2

    iput-object p1, p0, La2/e$n$a;->e:Ljava/lang/String;

    return-object p0
.end method
