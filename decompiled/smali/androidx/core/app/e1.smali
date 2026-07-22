.class public final Landroidx/core/app/e1;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/app/e1$b;,
        Landroidx/core/app/e1$a;,
        Landroidx/core/app/e1$c;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/CharSequence;

.field private final c:[Ljava/lang/CharSequence;

.field private final d:Z

.field private final e:I

.field private final f:Landroid/os/Bundle;

.field private final g:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static a(Landroidx/core/app/e1;)Landroid/app/RemoteInput;
    .registers 1

    invoke-static {p0}, Landroidx/core/app/e1$a;->b(Landroidx/core/app/e1;)Landroid/app/RemoteInput;

    move-result-object p0

    return-object p0
.end method

.method static b([Landroidx/core/app/e1;)[Landroid/app/RemoteInput;
    .registers 4

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    new-array v0, v0, [Landroid/app/RemoteInput;

    const/4 v1, 0x0

    :goto_8
    array-length v2, p0

    if-ge v1, v2, :cond_16

    aget-object v2, p0, v1

    invoke-static {v2}, Landroidx/core/app/e1;->a(Landroidx/core/app/e1;)Landroid/app/RemoteInput;

    move-result-object v2

    aput-object v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_8

    :cond_16
    return-object v0
.end method


# virtual methods
.method public c()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/core/app/e1;->d:Z

    return v0
.end method

.method public d()Ljava/util/Set;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Landroidx/core/app/e1;->g:Ljava/util/Set;

    return-object v0
.end method

.method public e()[Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Landroidx/core/app/e1;->c:[Ljava/lang/CharSequence;

    return-object v0
.end method

.method public f()I
    .registers 2

    iget v0, p0, Landroidx/core/app/e1;->e:I

    return v0
.end method

.method public g()Landroid/os/Bundle;
    .registers 2

    iget-object v0, p0, Landroidx/core/app/e1;->f:Landroid/os/Bundle;

    return-object v0
.end method

.method public h()Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Landroidx/core/app/e1;->b:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public i()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Landroidx/core/app/e1;->a:Ljava/lang/String;

    return-object v0
.end method

.method public j()Z
    .registers 2

    invoke-virtual {p0}, Landroidx/core/app/e1;->c()Z

    move-result v0

    if-nez v0, :cond_25

    invoke-virtual {p0}, Landroidx/core/app/e1;->e()[Ljava/lang/CharSequence;

    move-result-object v0

    if-eqz v0, :cond_13

    invoke-virtual {p0}, Landroidx/core/app/e1;->e()[Ljava/lang/CharSequence;

    move-result-object v0

    array-length v0, v0

    if-nez v0, :cond_25

    :cond_13
    invoke-virtual {p0}, Landroidx/core/app/e1;->d()Ljava/util/Set;

    move-result-object v0

    if-eqz v0, :cond_25

    invoke-virtual {p0}, Landroidx/core/app/e1;->d()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_25

    const/4 v0, 0x1

    goto :goto_26

    :cond_25
    const/4 v0, 0x0

    :goto_26
    return v0
.end method
