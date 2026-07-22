.class final Lw2/v0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lw2/g1;


# instance fields
.field private final c:Z


# direct methods
.method public constructor <init>(Z)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean p1, p0, Lw2/v0;->c:Z

    return-void
.end method


# virtual methods
.method public e()Lw2/w1;
    .registers 2

    const/4 v0, 0x0

    return-object v0
.end method

.method public isActive()Z
    .registers 2

    iget-boolean v0, p0, Lw2/v0;->c:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Empty{"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lw2/v0;->isActive()Z

    move-result v1

    if-eqz v1, :cond_13

    const-string v1, "Active"

    goto :goto_15

    :cond_13
    const-string v1, "New"

    :goto_15
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
