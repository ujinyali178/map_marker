.class public abstract Lb1/a;
.super Lb1/b;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lb1/b;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Object;)V
    .registers 3

    invoke-virtual {p0}, Lb1/a;->n()Lb1/f;

    move-result-object v0

    invoke-interface {v0, p1}, Lb1/f;->a(Ljava/lang/Object;)V

    return-void
.end method

.method public b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    .registers 5

    invoke-virtual {p0}, Lb1/a;->n()Lb1/f;

    move-result-object v0

    invoke-interface {v0, p1, p2, p3}, Lb1/f;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method protected abstract n()Lb1/f;
.end method
