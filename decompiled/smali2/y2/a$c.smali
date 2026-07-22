.class final Ly2/a$c;
.super Lw2/e;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ly2/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "c"
.end annotation


# instance fields
.field private final c:Ly2/o;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ly2/o<",
            "*>;"
        }
    .end annotation
.end field

.field final synthetic d:Ly2/a;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ly2/a<",
            "TE;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ly2/a;Ly2/o;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ly2/o<",
            "*>;)V"
        }
    .end annotation

    iput-object p1, p0, Ly2/a$c;->d:Ly2/a;

    invoke-direct {p0}, Lw2/e;-><init>()V

    iput-object p2, p0, Ly2/a$c;->c:Ly2/o;

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Throwable;)V
    .registers 2

    iget-object p1, p0, Ly2/a$c;->c:Ly2/o;

    invoke-virtual {p1}, Lkotlinx/coroutines/internal/o;->t()Z

    move-result p1

    if-eqz p1, :cond_d

    iget-object p1, p0, Ly2/a$c;->d:Ly2/a;

    invoke-virtual {p1}, Ly2/a;->t()V

    :cond_d
    return-void
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2

    check-cast p1, Ljava/lang/Throwable;

    invoke-virtual {p0, p1}, Ly2/a$c;->a(Ljava/lang/Throwable;)V

    sget-object p1, Lg2/q;->a:Lg2/q;

    return-object p1
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "RemoveReceiveOnCancel["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Ly2/a$c;->c:Ly2/o;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const/16 v1, 0x5d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
