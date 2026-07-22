.class public Landroidx/collection/h;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Cloneable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/lang/Cloneable;"
    }
.end annotation


# static fields
.field private static final h:Ljava/lang/Object;


# instance fields
.field private c:Z

.field private d:[I

.field private f:[Ljava/lang/Object;

.field private g:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroidx/collection/h;->h:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    const/16 v0, 0xa

    invoke-direct {p0, v0}, Landroidx/collection/h;-><init>(I)V

    return-void
.end method

.method public constructor <init>(I)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/collection/h;->c:Z

    if-nez p1, :cond_11

    sget-object p1, Landroidx/collection/c;->a:[I

    iput-object p1, p0, Landroidx/collection/h;->d:[I

    sget-object p1, Landroidx/collection/c;->c:[Ljava/lang/Object;

    iput-object p1, p0, Landroidx/collection/h;->f:[Ljava/lang/Object;

    goto :goto_1d

    :cond_11
    invoke-static {p1}, Landroidx/collection/c;->e(I)I

    move-result p1

    new-array v0, p1, [I

    iput-object v0, p0, Landroidx/collection/h;->d:[I

    new-array p1, p1, [Ljava/lang/Object;

    iput-object p1, p0, Landroidx/collection/h;->f:[Ljava/lang/Object;

    :goto_1d
    return-void
.end method

.method private c()V
    .registers 9

    iget v0, p0, Landroidx/collection/h;->g:I

    iget-object v1, p0, Landroidx/collection/h;->d:[I

    iget-object v2, p0, Landroidx/collection/h;->f:[Ljava/lang/Object;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    :goto_9
    if-ge v4, v0, :cond_21

    aget-object v6, v2, v4

    sget-object v7, Landroidx/collection/h;->h:Ljava/lang/Object;

    if-eq v6, v7, :cond_1e

    if-eq v4, v5, :cond_1c

    aget v7, v1, v4

    aput v7, v1, v5

    aput-object v6, v2, v5

    const/4 v6, 0x0

    aput-object v6, v2, v4

    :cond_1c
    add-int/lit8 v5, v5, 0x1

    :cond_1e
    add-int/lit8 v4, v4, 0x1

    goto :goto_9

    :cond_21
    iput-boolean v3, p0, Landroidx/collection/h;->c:Z

    iput v5, p0, Landroidx/collection/h;->g:I

    return-void
.end method


# virtual methods
.method public a()V
    .registers 6

    iget v0, p0, Landroidx/collection/h;->g:I

    iget-object v1, p0, Landroidx/collection/h;->f:[Ljava/lang/Object;

    const/4 v2, 0x0

    const/4 v3, 0x0

    :goto_6
    if-ge v3, v0, :cond_e

    const/4 v4, 0x0

    aput-object v4, v1, v3

    add-int/lit8 v3, v3, 0x1

    goto :goto_6

    :cond_e
    iput v2, p0, Landroidx/collection/h;->g:I

    iput-boolean v2, p0, Landroidx/collection/h;->c:Z

    return-void
.end method

.method public b()Landroidx/collection/h;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/collection/h<",
            "TE;>;"
        }
    .end annotation

    :try_start_0
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/collection/h;

    iget-object v1, p0, Landroidx/collection/h;->d:[I

    invoke-virtual {v1}, [I->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [I

    iput-object v1, v0, Landroidx/collection/h;->d:[I

    iget-object v1, p0, Landroidx/collection/h;->f:[Ljava/lang/Object;

    invoke-virtual {v1}, [Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/Object;

    iput-object v1, v0, Landroidx/collection/h;->f:[Ljava/lang/Object;
    :try_end_1a
    .catch Ljava/lang/CloneNotSupportedException; {:try_start_0 .. :try_end_1a} :catch_1b

    return-object v0

    :catch_1b
    move-exception v0

    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1, v0}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v1
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .registers 2

    invoke-virtual {p0}, Landroidx/collection/h;->b()Landroidx/collection/h;

    move-result-object v0

    return-object v0
.end method

.method public d(I)Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TE;"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroidx/collection/h;->e(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public e(ILjava/lang/Object;)Ljava/lang/Object;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ITE;)TE;"
        }
    .end annotation

    iget-object v0, p0, Landroidx/collection/h;->d:[I

    iget v1, p0, Landroidx/collection/h;->g:I

    invoke-static {v0, v1, p1}, Landroidx/collection/c;->a([III)I

    move-result p1

    if-ltz p1, :cond_14

    iget-object v0, p0, Landroidx/collection/h;->f:[Ljava/lang/Object;

    aget-object p1, v0, p1

    sget-object v0, Landroidx/collection/h;->h:Ljava/lang/Object;

    if-ne p1, v0, :cond_13

    goto :goto_14

    :cond_13
    return-object p1

    :cond_14
    :goto_14
    return-object p2
.end method

.method public f(I)I
    .registers 3

    iget-boolean v0, p0, Landroidx/collection/h;->c:Z

    if-eqz v0, :cond_7

    invoke-direct {p0}, Landroidx/collection/h;->c()V

    :cond_7
    iget-object v0, p0, Landroidx/collection/h;->d:[I

    aget p1, v0, p1

    return p1
.end method

.method public g(ILjava/lang/Object;)V
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ITE;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/collection/h;->d:[I

    iget v1, p0, Landroidx/collection/h;->g:I

    invoke-static {v0, v1, p1}, Landroidx/collection/c;->a([III)I

    move-result v0

    if-ltz v0, :cond_f

    iget-object p1, p0, Landroidx/collection/h;->f:[Ljava/lang/Object;

    aput-object p2, p1, v0

    goto :goto_7e

    :cond_f
    not-int v0, v0

    iget v1, p0, Landroidx/collection/h;->g:I

    if-ge v0, v1, :cond_23

    iget-object v2, p0, Landroidx/collection/h;->f:[Ljava/lang/Object;

    aget-object v3, v2, v0

    sget-object v4, Landroidx/collection/h;->h:Ljava/lang/Object;

    if-ne v3, v4, :cond_23

    iget-object v1, p0, Landroidx/collection/h;->d:[I

    aput p1, v1, v0

    aput-object p2, v2, v0

    return-void

    :cond_23
    iget-boolean v2, p0, Landroidx/collection/h;->c:Z

    if-eqz v2, :cond_38

    iget-object v2, p0, Landroidx/collection/h;->d:[I

    array-length v2, v2

    if-lt v1, v2, :cond_38

    invoke-direct {p0}, Landroidx/collection/h;->c()V

    iget-object v0, p0, Landroidx/collection/h;->d:[I

    iget v1, p0, Landroidx/collection/h;->g:I

    invoke-static {v0, v1, p1}, Landroidx/collection/c;->a([III)I

    move-result v0

    not-int v0, v0

    :cond_38
    iget v1, p0, Landroidx/collection/h;->g:I

    iget-object v2, p0, Landroidx/collection/h;->d:[I

    array-length v2, v2

    if-lt v1, v2, :cond_5a

    add-int/lit8 v1, v1, 0x1

    invoke-static {v1}, Landroidx/collection/c;->e(I)I

    move-result v1

    new-array v2, v1, [I

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v3, p0, Landroidx/collection/h;->d:[I

    array-length v4, v3

    const/4 v5, 0x0

    invoke-static {v3, v5, v2, v5, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iget-object v3, p0, Landroidx/collection/h;->f:[Ljava/lang/Object;

    array-length v4, v3

    invoke-static {v3, v5, v1, v5, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iput-object v2, p0, Landroidx/collection/h;->d:[I

    iput-object v1, p0, Landroidx/collection/h;->f:[Ljava/lang/Object;

    :cond_5a
    iget v1, p0, Landroidx/collection/h;->g:I

    sub-int v2, v1, v0

    if-eqz v2, :cond_70

    iget-object v2, p0, Landroidx/collection/h;->d:[I

    add-int/lit8 v3, v0, 0x1

    sub-int/2addr v1, v0

    invoke-static {v2, v0, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iget-object v1, p0, Landroidx/collection/h;->f:[Ljava/lang/Object;

    iget v2, p0, Landroidx/collection/h;->g:I

    sub-int/2addr v2, v0

    invoke-static {v1, v0, v1, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_70
    iget-object v1, p0, Landroidx/collection/h;->d:[I

    aput p1, v1, v0

    iget-object p1, p0, Landroidx/collection/h;->f:[Ljava/lang/Object;

    aput-object p2, p1, v0

    iget p1, p0, Landroidx/collection/h;->g:I

    add-int/lit8 p1, p1, 0x1

    iput p1, p0, Landroidx/collection/h;->g:I

    :goto_7e
    return-void
.end method

.method public h()I
    .registers 2

    iget-boolean v0, p0, Landroidx/collection/h;->c:Z

    if-eqz v0, :cond_7

    invoke-direct {p0}, Landroidx/collection/h;->c()V

    :cond_7
    iget v0, p0, Landroidx/collection/h;->g:I

    return v0
.end method

.method public i(I)Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TE;"
        }
    .end annotation

    iget-boolean v0, p0, Landroidx/collection/h;->c:Z

    if-eqz v0, :cond_7

    invoke-direct {p0}, Landroidx/collection/h;->c()V

    :cond_7
    iget-object v0, p0, Landroidx/collection/h;->f:[Ljava/lang/Object;

    aget-object p1, v0, p1

    return-object p1
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    invoke-virtual {p0}, Landroidx/collection/h;->h()I

    move-result v0

    if-gtz v0, :cond_9

    const-string v0, "{}"

    return-object v0

    :cond_9
    new-instance v0, Ljava/lang/StringBuilder;

    iget v1, p0, Landroidx/collection/h;->g:I

    mul-int/lit8 v1, v1, 0x1c

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    const/16 v1, 0x7b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    const/4 v1, 0x0

    :goto_18
    iget v2, p0, Landroidx/collection/h;->g:I

    if-ge v1, v2, :cond_41

    if-lez v1, :cond_23

    const-string v2, ", "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_23
    invoke-virtual {p0, v1}, Landroidx/collection/h;->f(I)I

    move-result v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const/16 v2, 0x3d

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {p0, v1}, Landroidx/collection/h;->i(I)Ljava/lang/Object;

    move-result-object v2

    if-eq v2, p0, :cond_39

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    goto :goto_3e

    :cond_39
    const-string v2, "(this Map)"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :goto_3e
    add-int/lit8 v1, v1, 0x1

    goto :goto_18

    :cond_41
    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
