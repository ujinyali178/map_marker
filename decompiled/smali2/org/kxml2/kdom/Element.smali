.class public Lorg/kxml2/kdom/Element;
.super Lorg/kxml2/kdom/Node;
.source "SourceFile"


# instance fields
.field protected attributes:Ljava/util/Vector;

.field protected name:Ljava/lang/String;

.field protected namespace:Ljava/lang/String;

.field protected parent:Lorg/kxml2/kdom/Node;

.field protected prefixes:Ljava/util/Vector;


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lorg/kxml2/kdom/Node;-><init>()V

    return-void
.end method


# virtual methods
.method public clear()V
    .registers 2

    const/4 v0, 0x0

    iput-object v0, p0, Lorg/kxml2/kdom/Element;->attributes:Ljava/util/Vector;

    iput-object v0, p0, Lorg/kxml2/kdom/Node;->children:Ljava/util/Vector;

    return-void
.end method

.method public createElement(Ljava/lang/String;Ljava/lang/String;)Lorg/kxml2/kdom/Element;
    .registers 4

    iget-object v0, p0, Lorg/kxml2/kdom/Element;->parent:Lorg/kxml2/kdom/Node;

    if-nez v0, :cond_9

    invoke-super {p0, p1, p2}, Lorg/kxml2/kdom/Node;->createElement(Ljava/lang/String;Ljava/lang/String;)Lorg/kxml2/kdom/Element;

    move-result-object p1

    goto :goto_d

    :cond_9
    invoke-virtual {v0, p1, p2}, Lorg/kxml2/kdom/Node;->createElement(Ljava/lang/String;Ljava/lang/String;)Lorg/kxml2/kdom/Element;

    move-result-object p1

    :goto_d
    return-object p1
.end method

.method public getAttributeCount()I
    .registers 2

    iget-object v0, p0, Lorg/kxml2/kdom/Element;->attributes:Ljava/util/Vector;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    goto :goto_a

    :cond_6
    invoke-virtual {v0}, Ljava/util/Vector;->size()I

    move-result v0

    :goto_a
    return v0
.end method

.method public getAttributeName(I)Ljava/lang/String;
    .registers 3

    iget-object v0, p0, Lorg/kxml2/kdom/Element;->attributes:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [Ljava/lang/String;

    const/4 v0, 0x1

    aget-object p1, p1, v0

    return-object p1
.end method

.method public getAttributeNamespace(I)Ljava/lang/String;
    .registers 3

    iget-object v0, p0, Lorg/kxml2/kdom/Element;->attributes:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [Ljava/lang/String;

    const/4 v0, 0x0

    aget-object p1, p1, v0

    return-object p1
.end method

.method public getAttributeValue(I)Ljava/lang/String;
    .registers 3

    iget-object v0, p0, Lorg/kxml2/kdom/Element;->attributes:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [Ljava/lang/String;

    const/4 v0, 0x2

    aget-object p1, p1, v0

    return-object p1
.end method

.method public getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 5

    const/4 v0, 0x0

    :goto_1
    invoke-virtual {p0}, Lorg/kxml2/kdom/Element;->getAttributeCount()I

    move-result v1

    if-ge v0, v1, :cond_25

    invoke-virtual {p0, v0}, Lorg/kxml2/kdom/Element;->getAttributeName(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_22

    if-eqz p1, :cond_1d

    invoke-virtual {p0, v0}, Lorg/kxml2/kdom/Element;->getAttributeNamespace(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_22

    :cond_1d
    invoke-virtual {p0, v0}, Lorg/kxml2/kdom/Element;->getAttributeValue(I)Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_22
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_25
    const/4 p1, 0x0

    return-object p1
.end method

.method public getName()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/kxml2/kdom/Element;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getNamespace()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/kxml2/kdom/Element;->namespace:Ljava/lang/String;

    return-object v0
.end method

.method public getNamespaceCount()I
    .registers 2

    iget-object v0, p0, Lorg/kxml2/kdom/Element;->prefixes:Ljava/util/Vector;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    goto :goto_a

    :cond_6
    invoke-virtual {v0}, Ljava/util/Vector;->size()I

    move-result v0

    :goto_a
    return v0
.end method

.method public getNamespacePrefix(I)Ljava/lang/String;
    .registers 3

    iget-object v0, p0, Lorg/kxml2/kdom/Element;->prefixes:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [Ljava/lang/String;

    const/4 v0, 0x0

    aget-object p1, p1, v0

    return-object p1
.end method

.method public getNamespaceUri(I)Ljava/lang/String;
    .registers 3

    iget-object v0, p0, Lorg/kxml2/kdom/Element;->prefixes:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [Ljava/lang/String;

    const/4 v0, 0x1

    aget-object p1, p1, v0

    return-object p1
.end method

.method public getNamespaceUri(Ljava/lang/String;)Ljava/lang/String;
    .registers 5

    invoke-virtual {p0}, Lorg/kxml2/kdom/Element;->getNamespaceCount()I

    move-result v0

    const/4 v1, 0x0

    :goto_5
    if-ge v1, v0, :cond_22

    invoke-virtual {p0, v1}, Lorg/kxml2/kdom/Element;->getNamespacePrefix(I)Ljava/lang/String;

    move-result-object v2

    if-eq p1, v2, :cond_1d

    if-eqz p1, :cond_1a

    invoke-virtual {p0, v1}, Lorg/kxml2/kdom/Element;->getNamespacePrefix(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1a

    goto :goto_1d

    :cond_1a
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_1d
    :goto_1d
    invoke-virtual {p0, v1}, Lorg/kxml2/kdom/Element;->getNamespaceUri(I)Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_22
    iget-object v0, p0, Lorg/kxml2/kdom/Element;->parent:Lorg/kxml2/kdom/Node;

    instance-of v1, v0, Lorg/kxml2/kdom/Element;

    if-eqz v1, :cond_2f

    check-cast v0, Lorg/kxml2/kdom/Element;

    invoke-virtual {v0, p1}, Lorg/kxml2/kdom/Element;->getNamespaceUri(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    goto :goto_30

    :cond_2f
    const/4 p1, 0x0

    :goto_30
    return-object p1
.end method

.method public getParent()Lorg/kxml2/kdom/Node;
    .registers 2

    iget-object v0, p0, Lorg/kxml2/kdom/Element;->parent:Lorg/kxml2/kdom/Node;

    return-object v0
.end method

.method public getRoot()Lorg/kxml2/kdom/Node;
    .registers 3

    move-object v0, p0

    :goto_1
    iget-object v1, v0, Lorg/kxml2/kdom/Element;->parent:Lorg/kxml2/kdom/Node;

    if-eqz v1, :cond_e

    instance-of v0, v1, Lorg/kxml2/kdom/Element;

    if-nez v0, :cond_a

    return-object v1

    :cond_a
    move-object v0, v1

    check-cast v0, Lorg/kxml2/kdom/Element;

    goto :goto_1

    :cond_e
    return-object v0
.end method

.method public init()V
    .registers 1

    return-void
.end method

.method public parse(Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 6

    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-interface {p1, v0}, Lorg/xmlpull/v1/XmlPullParser;->getNamespaceCount(I)I

    move-result v0

    :goto_a
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v1

    invoke-interface {p1, v1}, Lorg/xmlpull/v1/XmlPullParser;->getNamespaceCount(I)I

    move-result v1

    if-ge v0, v1, :cond_22

    invoke-interface {p1, v0}, Lorg/xmlpull/v1/XmlPullParser;->getNamespacePrefix(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0}, Lorg/xmlpull/v1/XmlPullParser;->getNamespaceUri(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lorg/kxml2/kdom/Element;->setPrefix(Ljava/lang/String;Ljava/lang/String;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_a

    :cond_22
    const/4 v0, 0x0

    :goto_23
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v1

    if-ge v0, v1, :cond_3b

    invoke-interface {p1, v0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeNamespace(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1, v0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v1, v2, v3}, Lorg/kxml2/kdom/Element;->setAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_23

    :cond_3b
    invoke-virtual {p0}, Lorg/kxml2/kdom/Element;->init()V

    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->isEmptyElementTag()Z

    move-result v0

    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->nextToken()I

    if-eqz v0, :cond_48

    goto :goto_57

    :cond_48
    invoke-super {p0, p1}, Lorg/kxml2/kdom/Node;->parse(Lorg/xmlpull/v1/XmlPullParser;)V

    invoke-virtual {p0}, Lorg/kxml2/kdom/Node;->getChildCount()I

    move-result v0

    if-nez v0, :cond_57

    const/4 v0, 0x7

    const-string v1, ""

    invoke-virtual {p0, v0, v1}, Lorg/kxml2/kdom/Node;->addChild(ILjava/lang/Object;)V

    :cond_57
    :goto_57
    const/4 v0, 0x3

    invoke-virtual {p0}, Lorg/kxml2/kdom/Element;->getNamespace()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lorg/kxml2/kdom/Element;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1, v0, v1, v2}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->nextToken()I

    return-void
.end method

.method public setAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 9

    iget-object v0, p0, Lorg/kxml2/kdom/Element;->attributes:Ljava/util/Vector;

    if-nez v0, :cond_b

    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lorg/kxml2/kdom/Element;->attributes:Ljava/util/Vector;

    :cond_b
    if-nez p1, :cond_f

    const-string p1, ""

    :cond_f
    iget-object v0, p0, Lorg/kxml2/kdom/Element;->attributes:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->size()I

    move-result v0

    const/4 v1, 0x1

    sub-int/2addr v0, v1

    :goto_17
    const/4 v2, 0x2

    const/4 v3, 0x0

    if-ltz v0, :cond_41

    iget-object v4, p0, Lorg/kxml2/kdom/Element;->attributes:Ljava/util/Vector;

    invoke-virtual {v4, v0}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Ljava/lang/String;

    aget-object v3, v4, v3

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3e

    aget-object v3, v4, v1

    invoke-virtual {v3, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3e

    if-nez p3, :cond_3b

    iget-object p1, p0, Lorg/kxml2/kdom/Element;->attributes:Ljava/util/Vector;

    invoke-virtual {p1, v0}, Ljava/util/Vector;->removeElementAt(I)V

    goto :goto_3d

    :cond_3b
    aput-object p3, v4, v2

    :goto_3d
    return-void

    :cond_3e
    add-int/lit8 v0, v0, -0x1

    goto :goto_17

    :cond_41
    iget-object v0, p0, Lorg/kxml2/kdom/Element;->attributes:Ljava/util/Vector;

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/String;

    aput-object p1, v4, v3

    aput-object p2, v4, v1

    aput-object p3, v4, v2

    invoke-virtual {v0, v4}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .registers 2

    iput-object p1, p0, Lorg/kxml2/kdom/Element;->name:Ljava/lang/String;

    return-void
.end method

.method public setNamespace(Ljava/lang/String;)V
    .registers 3

    if-eqz p1, :cond_5

    iput-object p1, p0, Lorg/kxml2/kdom/Element;->namespace:Ljava/lang/String;

    return-void

    :cond_5
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v0, "Use \"\" for empty namespace"

    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method protected setParent(Lorg/kxml2/kdom/Node;)V
    .registers 2

    iput-object p1, p0, Lorg/kxml2/kdom/Element;->parent:Lorg/kxml2/kdom/Node;

    return-void
.end method

.method public setPrefix(Ljava/lang/String;Ljava/lang/String;)V
    .registers 6

    iget-object v0, p0, Lorg/kxml2/kdom/Element;->prefixes:Ljava/util/Vector;

    if-nez v0, :cond_b

    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lorg/kxml2/kdom/Element;->prefixes:Ljava/util/Vector;

    :cond_b
    iget-object v0, p0, Lorg/kxml2/kdom/Element;->prefixes:Ljava/util/Vector;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const/4 p1, 0x1

    aput-object p2, v1, p1

    invoke-virtual {v0, v1}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    return-void
.end method

.method public write(Lorg/xmlpull/v1/XmlSerializer;)V
    .registers 7

    iget-object v0, p0, Lorg/kxml2/kdom/Element;->prefixes:Ljava/util/Vector;

    const/4 v1, 0x0

    if-eqz v0, :cond_1c

    const/4 v0, 0x0

    :goto_6
    iget-object v2, p0, Lorg/kxml2/kdom/Element;->prefixes:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_1c

    invoke-virtual {p0, v0}, Lorg/kxml2/kdom/Element;->getNamespacePrefix(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v0}, Lorg/kxml2/kdom/Element;->getNamespaceUri(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {p1, v2, v3}, Lorg/xmlpull/v1/XmlSerializer;->setPrefix(Ljava/lang/String;Ljava/lang/String;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_6

    :cond_1c
    invoke-virtual {p0}, Lorg/kxml2/kdom/Element;->getNamespace()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lorg/kxml2/kdom/Element;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1, v0, v2}, Lorg/xmlpull/v1/XmlSerializer;->startTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    invoke-virtual {p0}, Lorg/kxml2/kdom/Element;->getAttributeCount()I

    move-result v0

    :goto_2b
    if-ge v1, v0, :cond_3f

    invoke-virtual {p0, v1}, Lorg/kxml2/kdom/Element;->getAttributeNamespace(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1}, Lorg/kxml2/kdom/Element;->getAttributeName(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v1}, Lorg/kxml2/kdom/Element;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v2, v3, v4}, Lorg/xmlpull/v1/XmlSerializer;->attribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    add-int/lit8 v1, v1, 0x1

    goto :goto_2b

    :cond_3f
    invoke-virtual {p0, p1}, Lorg/kxml2/kdom/Node;->writeChildren(Lorg/xmlpull/v1/XmlSerializer;)V

    invoke-virtual {p0}, Lorg/kxml2/kdom/Element;->getNamespace()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lorg/kxml2/kdom/Element;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Lorg/xmlpull/v1/XmlSerializer;->endTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    return-void
.end method
