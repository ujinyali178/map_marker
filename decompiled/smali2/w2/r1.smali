.class public abstract Lw2/r1;
.super Lw2/x;
.source "SourceFile"

# interfaces
.implements Lw2/u0;
.implements Lw2/g1;


# instance fields
.field public g:Lw2/s1;


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lw2/x;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .registers 2

    invoke-virtual {p0}, Lw2/r1;->y()Lw2/s1;

    move-result-object v0

    invoke-virtual {v0, p0}, Lw2/s1;->m0(Lw2/r1;)V

    return-void
.end method

.method public e()Lw2/w1;
    .registers 2

    const/4 v0, 0x0

    return-object v0
.end method

.method public isActive()Z
    .registers 2

    const/4 v0, 0x1

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lw2/k0;->a(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v1, 0x40

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-static {p0}, Lw2/k0;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "[job@"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lw2/r1;->y()Lw2/s1;

    move-result-object v1

    invoke-static {v1}, Lw2/k0;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v1, 0x5d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final y()Lw2/s1;
    .registers 2

    iget-object v0, p0, Lw2/r1;->g:Lw2/s1;

    if-eqz v0, :cond_5

    return-object v0

    :cond_5
    const-string v0, "job"

    invoke-static {v0}, Lkotlin/jvm/internal/k;->o(Ljava/lang/String;)V

    const/4 v0, 0x0

    return-object v0
.end method

.method public final z(Lw2/s1;)V
    .registers 2

    iput-object p1, p0, Lw2/r1;->g:Lw2/s1;

    return-void
.end method
