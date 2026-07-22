.class public Lorg/mapsforge/core/model/Tag;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Comparable;
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable<",
        "Lorg/mapsforge/core/model/Tag;",
        ">;",
        "Ljava/io/Serializable;"
    }
.end annotation


# static fields
.field public static final KEY_VALUE_SEPARATOR:C = '='

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field public final key:Ljava/lang/String;

.field public final value:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .registers 3

    const/16 v0, 0x3d

    invoke-virtual {p1, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    invoke-direct {p0, p1, v0}, Lorg/mapsforge/core/model/Tag;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .registers 4

    const/4 v0, 0x0

    invoke-virtual {p1, v0, p2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    add-int/lit8 p2, p2, 0x1

    invoke-virtual {p1, p2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, v0, p1}, Lorg/mapsforge/core/model/Tag;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/core/model/Tag;->key:Ljava/lang/String;

    iput-object p2, p0, Lorg/mapsforge/core/model/Tag;->value:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .registers 2

    check-cast p1, Lorg/mapsforge/core/model/Tag;

    invoke-virtual {p0, p1}, Lorg/mapsforge/core/model/Tag;->compareTo(Lorg/mapsforge/core/model/Tag;)I

    move-result p1

    return p1
.end method

.method public compareTo(Lorg/mapsforge/core/model/Tag;)I
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/core/model/Tag;->key:Ljava/lang/String;

    iget-object v1, p1, Lorg/mapsforge/core/model/Tag;->key:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_b

    return v0

    :cond_b
    iget-object v0, p0, Lorg/mapsforge/core/model/Tag;->value:Ljava/lang/String;

    iget-object p1, p1, Lorg/mapsforge/core/model/Tag;->value:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result p1

    return p1
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lorg/mapsforge/core/model/Tag;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lorg/mapsforge/core/model/Tag;

    iget-object v1, p0, Lorg/mapsforge/core/model/Tag;->key:Ljava/lang/String;

    if-nez v1, :cond_15

    iget-object p1, p1, Lorg/mapsforge/core/model/Tag;->key:Ljava/lang/String;

    if-eqz p1, :cond_2e

    return v2

    :cond_15
    iget-object v3, p1, Lorg/mapsforge/core/model/Tag;->key:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1e

    return v2

    :cond_1e
    iget-object v1, p0, Lorg/mapsforge/core/model/Tag;->value:Ljava/lang/String;

    iget-object p1, p1, Lorg/mapsforge/core/model/Tag;->value:Ljava/lang/String;

    if-nez v1, :cond_27

    if-eqz p1, :cond_2e

    return v2

    :cond_27
    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_2e

    return v2

    :cond_2e
    return v0
.end method

.method public hashCode()I
    .registers 4

    iget-object v0, p0, Lorg/mapsforge/core/model/Tag;->key:Ljava/lang/String;

    const/4 v1, 0x0

    if-nez v0, :cond_7

    const/4 v0, 0x0

    goto :goto_b

    :cond_7
    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_b
    const/16 v2, 0x1f

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lorg/mapsforge/core/model/Tag;->value:Ljava/lang/String;

    if-nez v2, :cond_15

    goto :goto_19

    :cond_15
    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_19
    add-int/2addr v0, v1

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "key="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lorg/mapsforge/core/model/Tag;->key:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ", value="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lorg/mapsforge/core/model/Tag;->value:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
