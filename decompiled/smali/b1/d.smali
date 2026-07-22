.class public Lb1/d;
.super Lb1/a;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lb1/d$a;
    }
.end annotation


# instance fields
.field public final a:Lb1/d$a;

.field final b:Lu1/k;


# direct methods
.method public constructor <init>(Lu1/k;Lu1/l$d;)V
    .registers 3

    invoke-direct {p0}, Lb1/a;-><init>()V

    iput-object p1, p0, Lb1/d;->b:Lu1/k;

    new-instance p1, Lb1/d$a;

    invoke-direct {p1, p0, p2}, Lb1/d$a;-><init>(Lb1/d;Lu1/l$d;)V

    iput-object p1, p0, Lb1/d;->a:Lb1/d$a;

    return-void
.end method


# virtual methods
.method public c(Ljava/lang/String;)Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    iget-object v0, p0, Lb1/d;->b:Lu1/k;

    invoke-virtual {v0, p1}, Lu1/k;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public getMethod()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lb1/d;->b:Lu1/k;

    iget-object v0, v0, Lu1/k;->a:Ljava/lang/String;

    return-object v0
.end method

.method public h(Ljava/lang/String;)Z
    .registers 3

    iget-object v0, p0, Lb1/d;->b:Lu1/k;

    invoke-virtual {v0, p1}, Lu1/k;->c(Ljava/lang/String;)Z

    move-result p1

    return p1
.end method

.method public n()Lb1/f;
    .registers 2

    iget-object v0, p0, Lb1/d;->a:Lb1/d$a;

    return-object v0
.end method
