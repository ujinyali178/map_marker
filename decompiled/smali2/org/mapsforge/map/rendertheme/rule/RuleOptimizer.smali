.class final Lorg/mapsforge/map/rendertheme/rule/RuleOptimizer;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final LOGGER:Ljava/util/logging/Logger;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-class v0, Lorg/mapsforge/map/rendertheme/rule/RuleOptimizer;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lorg/mapsforge/map/rendertheme/rule/RuleOptimizer;->LOGGER:Ljava/util/logging/Logger;

    return-void
.end method

.method private constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
.end method

.method static optimize(Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;Ljava/util/Stack;)Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;",
            "Ljava/util/Stack<",
            "Lorg/mapsforge/map/rendertheme/rule/Rule;",
            ">;)",
            "Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;"
        }
    .end annotation

    instance-of v0, p0, Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;

    if-nez v0, :cond_32

    instance-of v0, p0, Lorg/mapsforge/map/rendertheme/rule/NegativeMatcher;

    if-eqz v0, :cond_9

    goto :goto_32

    :cond_9
    instance-of v0, p0, Lorg/mapsforge/map/rendertheme/rule/KeyMatcher;

    if-eqz v0, :cond_12

    invoke-static {p0, p1}, Lorg/mapsforge/map/rendertheme/rule/RuleOptimizer;->optimizeKeyMatcher(Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;Ljava/util/Stack;)Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;

    move-result-object p0

    return-object p0

    :cond_12
    instance-of v0, p0, Lorg/mapsforge/map/rendertheme/rule/ValueMatcher;

    if-eqz v0, :cond_1b

    invoke-static {p0, p1}, Lorg/mapsforge/map/rendertheme/rule/RuleOptimizer;->optimizeValueMatcher(Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;Ljava/util/Stack;)Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;

    move-result-object p0

    return-object p0

    :cond_1b
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "unknown AttributeMatcher: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {p1, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_32
    :goto_32
    return-object p0
.end method

.method static optimize(Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;Ljava/util/Stack;)Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;",
            "Ljava/util/Stack<",
            "Lorg/mapsforge/map/rendertheme/rule/Rule;",
            ">;)",
            "Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;"
        }
    .end annotation

    instance-of v0, p0, Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;

    if-eqz v0, :cond_5

    return-object p0

    :cond_5
    const/4 v0, 0x0

    invoke-virtual {p1}, Ljava/util/AbstractCollection;->size()I

    move-result v1

    :goto_a
    if-ge v0, v1, :cond_35

    invoke-virtual {p1, v0}, Ljava/util/AbstractList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/rendertheme/rule/Rule;

    iget-object v2, v2, Lorg/mapsforge/map/rendertheme/rule/Rule;->closedMatcher:Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;

    invoke-interface {v2, p0}, Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;->isCoveredBy(Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;)Z

    move-result v2

    if-eqz v2, :cond_1d

    sget-object p0, Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;->INSTANCE:Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;

    return-object p0

    :cond_1d
    invoke-virtual {p1, v0}, Ljava/util/AbstractList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/rendertheme/rule/Rule;

    iget-object v2, v2, Lorg/mapsforge/map/rendertheme/rule/Rule;->closedMatcher:Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;

    invoke-interface {p0, v2}, Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;->isCoveredBy(Lorg/mapsforge/map/rendertheme/rule/ClosedMatcher;)Z

    move-result v2

    if-nez v2, :cond_32

    sget-object v2, Lorg/mapsforge/map/rendertheme/rule/RuleOptimizer;->LOGGER:Ljava/util/logging/Logger;

    const-string v3, "unreachable rule (closed)"

    invoke-virtual {v2, v3}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    :cond_32
    add-int/lit8 v0, v0, 0x1

    goto :goto_a

    :cond_35
    return-object p0
.end method

.method static optimize(Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;Ljava/util/Stack;)Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;",
            "Ljava/util/Stack<",
            "Lorg/mapsforge/map/rendertheme/rule/Rule;",
            ">;)",
            "Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;"
        }
    .end annotation

    instance-of v0, p0, Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;

    if-eqz v0, :cond_5

    return-object p0

    :cond_5
    const/4 v0, 0x0

    invoke-virtual {p1}, Ljava/util/AbstractCollection;->size()I

    move-result v1

    :goto_a
    if-ge v0, v1, :cond_2f

    invoke-virtual {p1, v0}, Ljava/util/AbstractList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/rendertheme/rule/Rule;

    iget-object v3, v2, Lorg/mapsforge/map/rendertheme/rule/Rule;->elementMatcher:Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;

    invoke-interface {v3, p0}, Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;->isCoveredBy(Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;)Z

    move-result v3

    if-eqz v3, :cond_1d

    sget-object p0, Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;->INSTANCE:Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;

    return-object p0

    :cond_1d
    iget-object v2, v2, Lorg/mapsforge/map/rendertheme/rule/Rule;->elementMatcher:Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;

    invoke-interface {p0, v2}, Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;->isCoveredBy(Lorg/mapsforge/map/rendertheme/rule/ElementMatcher;)Z

    move-result v2

    if-nez v2, :cond_2c

    sget-object v2, Lorg/mapsforge/map/rendertheme/rule/RuleOptimizer;->LOGGER:Ljava/util/logging/Logger;

    const-string v3, "unreachable rule (e)"

    invoke-virtual {v2, v3}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    :cond_2c
    add-int/lit8 v0, v0, 0x1

    goto :goto_a

    :cond_2f
    return-object p0
.end method

.method private static optimizeKeyMatcher(Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;Ljava/util/Stack;)Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;",
            "Ljava/util/Stack<",
            "Lorg/mapsforge/map/rendertheme/rule/Rule;",
            ">;)",
            "Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;"
        }
    .end annotation

    invoke-virtual {p1}, Ljava/util/AbstractCollection;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_5
    if-ge v1, v0, :cond_23

    invoke-virtual {p1, v1}, Ljava/util/AbstractList;->get(I)Ljava/lang/Object;

    move-result-object v2

    instance-of v2, v2, Lorg/mapsforge/map/rendertheme/rule/PositiveRule;

    if-eqz v2, :cond_20

    invoke-virtual {p1, v1}, Ljava/util/AbstractList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/rendertheme/rule/PositiveRule;

    iget-object v2, v2, Lorg/mapsforge/map/rendertheme/rule/PositiveRule;->keyMatcher:Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;

    invoke-interface {v2, p0}, Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;->isCoveredBy(Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;)Z

    move-result v2

    if-eqz v2, :cond_20

    sget-object p0, Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;->INSTANCE:Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;

    return-object p0

    :cond_20
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_23
    return-object p0
.end method

.method private static optimizeValueMatcher(Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;Ljava/util/Stack;)Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;",
            "Ljava/util/Stack<",
            "Lorg/mapsforge/map/rendertheme/rule/Rule;",
            ">;)",
            "Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;"
        }
    .end annotation

    invoke-virtual {p1}, Ljava/util/AbstractCollection;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_5
    if-ge v1, v0, :cond_23

    invoke-virtual {p1, v1}, Ljava/util/AbstractList;->get(I)Ljava/lang/Object;

    move-result-object v2

    instance-of v2, v2, Lorg/mapsforge/map/rendertheme/rule/PositiveRule;

    if-eqz v2, :cond_20

    invoke-virtual {p1, v1}, Ljava/util/AbstractList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/mapsforge/map/rendertheme/rule/PositiveRule;

    iget-object v2, v2, Lorg/mapsforge/map/rendertheme/rule/PositiveRule;->valueMatcher:Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;

    invoke-interface {v2, p0}, Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;->isCoveredBy(Lorg/mapsforge/map/rendertheme/rule/AttributeMatcher;)Z

    move-result v2

    if-eqz v2, :cond_20

    sget-object p0, Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;->INSTANCE:Lorg/mapsforge/map/rendertheme/rule/AnyMatcher;

    return-object p0

    :cond_20
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_23
    return-object p0
.end method
