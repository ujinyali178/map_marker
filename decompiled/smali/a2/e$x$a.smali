.class public final La2/e$x$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La2/e$x;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private e:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "La2/e$m;",
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
.method public a()La2/e$x;
    .registers 3

    new-instance v0, La2/e$x;

    invoke-direct {v0}, La2/e$x;-><init>()V

    iget-object v1, p0, La2/e$x$a;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$x;->b(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$x$a;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$x;->c(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$x$a;->c:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$x;->e(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$x$a;->d:Ljava/util/List;

    invoke-virtual {v0, v1}, La2/e$x;->d(Ljava/util/List;)V

    iget-object v1, p0, La2/e$x$a;->e:Ljava/util/List;

    invoke-virtual {v0, v1}, La2/e$x;->f(Ljava/util/List;)V

    return-object v0
.end method

.method public b(Ljava/lang/String;)La2/e$x$a;
    .registers 2

    iput-object p1, p0, La2/e$x$a;->a:Ljava/lang/String;

    return-object p0
.end method

.method public c(Ljava/lang/String;)La2/e$x$a;
    .registers 2

    iput-object p1, p0, La2/e$x$a;->b:Ljava/lang/String;

    return-object p0
.end method

.method public d(Ljava/util/List;)La2/e$x$a;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)",
            "La2/e$x$a;"
        }
    .end annotation

    iput-object p1, p0, La2/e$x$a;->d:Ljava/util/List;

    return-object p0
.end method

.method public e(Ljava/lang/String;)La2/e$x$a;
    .registers 2

    iput-object p1, p0, La2/e$x$a;->c:Ljava/lang/String;

    return-object p0
.end method

.method public f(Ljava/util/List;)La2/e$x$a;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "La2/e$m;",
            ">;)",
            "La2/e$x$a;"
        }
    .end annotation

    iput-object p1, p0, La2/e$x$a;->e:Ljava/util/List;

    return-object p0
.end method
