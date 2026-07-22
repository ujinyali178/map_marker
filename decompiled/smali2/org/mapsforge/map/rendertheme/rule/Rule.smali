.class public abstract Lorg/mapsforge/map/rendertheme/rule/Rule;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/mapsforge/map/rendertheme/rule/Rule$RuleVisitor;
    }
.end annotation


# static fields
.field static final MATCHERS_CACHE_KEY:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;",
            "Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;",
            ">;"
        }
    .end annotation
.end field

.field static final MATCHERS_CACHE_VALUE:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;",
            "Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field cat:Ljava/lang/String;

.field final closedMatcher:Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;

.field final elementMatcher:Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;

.field public final renderInstructions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;",
            ">;"
        }
    .end annotation
.end field

.field public final subRules:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lorg/mapsforge/map/rendertheme/rule/Rule;",
            ">;"
        }
    .end annotation
.end field

.field final zoomMax:B

.field final zoomMin:B


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lorg/mapsforge/map/rendertheme/rule/Rule;->MATCHERS_CACHE_KEY:Ljava/util/Map;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lorg/mapsforge/map/rendertheme/rule/Rule;->MATCHERS_CACHE_VALUE:Ljava/util/Map;

    return-void
.end method

.method constructor <init>(Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iget-object v0, p1, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->cat:Ljava/lang/String;

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->cat:Ljava/lang/String;

    iget-object v0, p1, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->closedMatcher:Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->closedMatcher:Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;

    iget-object v0, p1, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->elementMatcher:Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;

    iput-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->elementMatcher:Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;

    iget-byte v0, p1, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->zoomMax:B

    iput-byte v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->zoomMax:B

    iget-byte p1, p1, Lorg/mapsforge/map/rendertheme/rule/RuleBuilder;->zoomMin:B

    iput-byte p1, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->zoomMin:B

    new-instance p1, Ljava/util/ArrayList;

    const/4 v0, 0x4

    invoke-direct {p1, v0}, Ljava/util/ArrayList;-><init>(I)V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->renderInstructions:Ljava/util/ArrayList;

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1, v0}, Ljava/util/ArrayList;-><init>(I)V

    iput-object p1, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->subRules:Ljava/util/ArrayList;

    return-void
.end method


# virtual methods
.method addRenderingInstruction(Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->renderInstructions:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method addSubRule(Lorg/mapsforge/map/rendertheme/rule/Rule;)V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->subRules:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method apply(Lorg/mapsforge/map/rendertheme/rule/Rule$RuleVisitor;)V
    .registers 2

    invoke-virtual {p1, p0}, Lorg/mapsforge/map/rendertheme/rule/Rule$RuleVisitor;->apply(Lorg/mapsforge/map/rendertheme/rule/Rule;)V

    return-void
.end method

.method destroy()V
    .registers 3

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->renderInstructions:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_16

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;

    invoke-virtual {v1}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->destroy()V

    goto :goto_6

    :cond_16
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->subRules:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1c
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2c

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/mapsforge/map/rendertheme/rule/Rule;

    invoke-virtual {v1}, Lorg/mapsforge/map/rendertheme/rule/Rule;->destroy()V

    goto :goto_1c

    :cond_2c
    return-void
.end method

.method matchNode(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Ljava/util/List;Lorg/mapsforge/map/datastore/PointOfInterest;)V
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/map/rendertheme/RenderCallback;",
            "Lorg/mapsforge/map/rendertheme/RenderContext;",
            "Ljava/util/List<",
            "Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;",
            ">;",
            "Lorg/mapsforge/map/datastore/PointOfInterest;",
            ")V"
        }
    .end annotation

    iget-object v0, p4, Lorg/mapsforge/map/datastore/PointOfInterest;->tags:Ljava/util/List;

    iget-object v1, p2, Lorg/mapsforge/map/rendertheme/RenderContext;->rendererJob:Lorg/mapsforge/map/layer/renderer/RendererJob;

    iget-object v1, v1, Lorg/mapsforge/map/layer/queue/Job;->tile:Lorg/mapsforge/core/model/Tile;

    iget-byte v1, v1, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    invoke-virtual {p0, v0, v1}, Lorg/mapsforge/map/rendertheme/rule/Rule;->matchesNode(Ljava/util/List;B)Z

    move-result v0

    if-eqz v0, :cond_45

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->renderInstructions:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_16
    if-ge v2, v0, :cond_2f

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->renderInstructions:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;

    invoke-virtual {v3, p1, p2, p4}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->renderNode(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/datastore/PointOfInterest;)V

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->renderInstructions:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {p3, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_16

    :cond_2f
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->subRules:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    :goto_35
    if-ge v1, v0, :cond_45

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->subRules:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/rendertheme/rule/Rule;

    invoke-virtual {v2, p1, p2, p3, p4}, Lorg/mapsforge/map/rendertheme/rule/Rule;->matchNode(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Ljava/util/List;Lorg/mapsforge/map/datastore/PointOfInterest;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_35

    :cond_45
    return-void
.end method

.method matchWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/layer/renderer/PolylineContainer;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/rendertheme/rule/Closed;Ljava/util/List;Lorg/mapsforge/map/rendertheme/RenderContext;)V
    .registers 23
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/map/rendertheme/RenderCallback;",
            "Lorg/mapsforge/map/layer/renderer/PolylineContainer;",
            "Lorg/mapsforge/core/model/Tile;",
            "Lorg/mapsforge/map/rendertheme/rule/Closed;",
            "Ljava/util/List<",
            "Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;",
            ">;",
            "Lorg/mapsforge/map/rendertheme/RenderContext;",
            ")V"
        }
    .end annotation

    move-object/from16 v0, p0

    invoke-virtual/range {p2 .. p2}, Lorg/mapsforge/map/layer/renderer/PolylineContainer;->getTags()Ljava/util/List;

    move-result-object v1

    move-object/from16 v9, p3

    iget-byte v2, v9, Lorg/mapsforge/core/model/Tile;->zoomLevel:B

    move-object/from16 v10, p4

    invoke-virtual {v0, v1, v2, v10}, Lorg/mapsforge/map/rendertheme/rule/Rule;->matchesWay(Ljava/util/List;BLorg/mapsforge/map/rendertheme/rule/Closed;)Z

    move-result v1

    if-eqz v1, :cond_66

    iget-object v1, v0, Lorg/mapsforge/map/rendertheme/rule/Rule;->renderInstructions:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    :goto_1a
    if-ge v3, v1, :cond_3b

    iget-object v4, v0, Lorg/mapsforge/map/rendertheme/rule/Rule;->renderInstructions:Ljava/util/ArrayList;

    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;

    move-object/from16 v11, p1

    move-object/from16 v12, p2

    move-object/from16 v13, p6

    invoke-virtual {v4, v11, v13, v12}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->renderWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/rendertheme/RenderContext;Lorg/mapsforge/map/layer/renderer/PolylineContainer;)V

    iget-object v4, v0, Lorg/mapsforge/map/rendertheme/rule/Rule;->renderInstructions:Ljava/util/ArrayList;

    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    move-object/from16 v14, p5

    invoke-interface {v14, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v3, v3, 0x1

    goto :goto_1a

    :cond_3b
    move-object/from16 v11, p1

    move-object/from16 v12, p2

    move-object/from16 v14, p5

    move-object/from16 v13, p6

    iget-object v1, v0, Lorg/mapsforge/map/rendertheme/rule/Rule;->subRules:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    const/4 v15, 0x0

    :goto_4a
    if-ge v15, v1, :cond_66

    iget-object v2, v0, Lorg/mapsforge/map/rendertheme/rule/Rule;->subRules:Ljava/util/ArrayList;

    invoke-virtual {v2, v15}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/rendertheme/rule/Rule;

    move-object/from16 v3, p1

    move-object/from16 v4, p2

    move-object/from16 v5, p3

    move-object/from16 v6, p4

    move-object/from16 v7, p5

    move-object/from16 v8, p6

    invoke-virtual/range {v2 .. v8}, Lorg/mapsforge/map/rendertheme/rule/Rule;->matchWay(Lorg/mapsforge/map/rendertheme/RenderCallback;Lorg/mapsforge/map/layer/renderer/PolylineContainer;Lorg/mapsforge/core/model/Tile;Lorg/mapsforge/map/rendertheme/rule/Closed;Ljava/util/List;Lorg/mapsforge/map/rendertheme/RenderContext;)V

    add-int/lit8 v15, v15, 0x1

    goto :goto_4a

    :cond_66
    return-void
.end method

.method abstract matchesNode(Ljava/util/List;B)Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/Tag;",
            ">;B)Z"
        }
    .end annotation
.end method

.method abstract matchesWay(Ljava/util/List;BLorg/mapsforge/map/rendertheme/rule/Closed;)Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lorg/mapsforge/core/model/Tag;",
            ">;B",
            "Lorg/mapsforge/map/rendertheme/rule/Closed;",
            ")Z"
        }
    .end annotation
.end method

.method onComplete()V
    .registers 4

    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/Rule;->MATCHERS_CACHE_KEY:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    sget-object v0, Lorg/mapsforge/map/rendertheme/rule/Rule;->MATCHERS_CACHE_VALUE:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->renderInstructions:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->trimToSize()V

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->subRules:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->trimToSize()V

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->subRules:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_1b
    if-ge v1, v0, :cond_2b

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->subRules:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/rendertheme/rule/Rule;

    invoke-virtual {v2}, Lorg/mapsforge/map/rendertheme/rule/Rule;->onComplete()V

    add-int/lit8 v1, v1, 0x1

    goto :goto_1b

    :cond_2b
    return-void
.end method

.method scaleStrokeWidth(FB)V
    .registers 7

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->renderInstructions:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_8
    if-ge v2, v0, :cond_18

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->renderInstructions:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;

    invoke-virtual {v3, p1, p2}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->scaleStrokeWidth(FB)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_8

    :cond_18
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->subRules:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    :goto_1e
    if-ge v1, v0, :cond_2e

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->subRules:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/rendertheme/rule/Rule;

    invoke-virtual {v2, p1, p2}, Lorg/mapsforge/map/rendertheme/rule/Rule;->scaleStrokeWidth(FB)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_1e

    :cond_2e
    return-void
.end method

.method scaleTextSize(FB)V
    .registers 7

    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->renderInstructions:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_8
    if-ge v2, v0, :cond_18

    iget-object v3, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->renderInstructions:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;

    invoke-virtual {v3, p1, p2}, Lorg/mapsforge/map/rendertheme/renderinstruction/RenderInstruction;->scaleTextSize(FB)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_8

    :cond_18
    iget-object v0, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->subRules:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    :goto_1e
    if-ge v1, v0, :cond_2e

    iget-object v2, p0, Lorg/mapsforge/map/rendertheme/rule/Rule;->subRules:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/rendertheme/rule/Rule;

    invoke-virtual {v2, p1, p2}, Lorg/mapsforge/map/rendertheme/rule/Rule;->scaleTextSize(FB)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_1e

    :cond_2e
    return-void
.end method
