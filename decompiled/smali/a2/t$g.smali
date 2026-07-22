.class La2/t$g;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements La2/e$a0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = La2/t;->p(Lu1/d;La2/e$b;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "La2/e$a0<",
        "La2/e$s;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Ljava/util/ArrayList;

.field final synthetic b:Lu1/b$e;


# direct methods
.method constructor <init>(Ljava/util/ArrayList;Lu1/b$e;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    iput-object p1, p0, La2/t$g;->a:Ljava/util/ArrayList;

    iput-object p2, p0, La2/t$g;->b:Lu1/b$e;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic a(Ljava/lang/Object;)V
    .registers 2

    check-cast p1, La2/e$s;

    invoke-virtual {p0, p1}, La2/t$g;->c(La2/e$s;)V

    return-void
.end method

.method public b(Ljava/lang/Throwable;)V
    .registers 3

    invoke-static {p1}, La2/e;->b(Ljava/lang/Throwable;)Ljava/util/ArrayList;

    move-result-object p1

    iget-object v0, p0, La2/t$g;->b:Lu1/b$e;

    invoke-interface {v0, p1}, Lu1/b$e;->a(Ljava/lang/Object;)V

    return-void
.end method

.method public c(La2/e$s;)V
    .registers 4

    iget-object v0, p0, La2/t$g;->a:Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    iget-object p1, p0, La2/t$g;->b:Lu1/b$e;

    iget-object v0, p0, La2/t$g;->a:Ljava/util/ArrayList;

    invoke-interface {p1, v0}, Lu1/b$e;->a(Ljava/lang/Object;)V

    return-void
.end method
