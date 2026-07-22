.class public Lorg/mapsforge/map/rendertheme/rule/Rule$RuleVisitor;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/mapsforge/map/rendertheme/rule/Rule;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RuleVisitor"
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public apply(Lorg/mapsforge/map/rendertheme/rule/Rule;)V
    .registers 3

    iget-object p1, p1, Lorg/mapsforge/map/rendertheme/rule/Rule;->subRules:Ljava/util/ArrayList;

    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_6
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_16

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/mapsforge/map/rendertheme/rule/Rule;

    invoke-virtual {p0, v0}, Lorg/mapsforge/map/rendertheme/rule/Rule$RuleVisitor;->apply(Lorg/mapsforge/map/rendertheme/rule/Rule;)V

    goto :goto_6

    :cond_16
    return-void
.end method
