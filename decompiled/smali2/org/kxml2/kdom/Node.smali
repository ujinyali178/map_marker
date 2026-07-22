.class public Lorg/kxml2/kdom/Node;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final CDSECT:I = 0x5

.field public static final COMMENT:I = 0x9

.field public static final DOCDECL:I = 0xa

.field public static final DOCUMENT:I = 0x0

.field public static final ELEMENT:I = 0x2

.field public static final ENTITY_REF:I = 0x6

.field public static final IGNORABLE_WHITESPACE:I = 0x7

.field public static final PROCESSING_INSTRUCTION:I = 0x8

.field public static final TEXT:I = 0x4


# instance fields
.field protected children:Ljava/util/Vector;

.field protected types:Ljava/lang/StringBuffer;


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public addChild(IILjava/lang/Object;)V
    .registers 5

    invoke-virtual {p3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iget-object v0, p0, Lorg/kxml2/kdom/Node;->children:Ljava/util/Vector;

    if-nez v0, :cond_15

    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lorg/kxml2/kdom/Node;->children:Ljava/util/Vector;

    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    iput-object v0, p0, Lorg/kxml2/kdom/Node;->types:Ljava/lang/StringBuffer;

    :cond_15
    const/4 v0, 0x2

    if-ne p2, v0, :cond_2b

    instance-of v0, p3, Lorg/kxml2/kdom/Element;

    if-eqz v0, :cond_23

    move-object v0, p3

    check-cast v0, Lorg/kxml2/kdom/Element;

    invoke-virtual {v0, p0}, Lorg/kxml2/kdom/Element;->setParent(Lorg/kxml2/kdom/Node;)V

    goto :goto_2f

    :cond_23
    new-instance p1, Ljava/lang/RuntimeException;

    const-string p2, "Element obj expected)"

    invoke-direct {p1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_2b
    instance-of v0, p3, Ljava/lang/String;

    if-eqz v0, :cond_3b

    :goto_2f
    iget-object v0, p0, Lorg/kxml2/kdom/Node;->children:Ljava/util/Vector;

    invoke-virtual {v0, p3, p1}, Ljava/util/Vector;->insertElementAt(Ljava/lang/Object;I)V

    iget-object p3, p0, Lorg/kxml2/kdom/Node;->types:Ljava/lang/StringBuffer;

    int-to-char p2, p2

    invoke-virtual {p3, p1, p2}, Ljava/lang/StringBuffer;->insert(IC)Ljava/lang/StringBuffer;

    return-void

    :cond_3b
    new-instance p1, Ljava/lang/RuntimeException;

    const-string p2, "String expected"

    invoke-direct {p1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public addChild(ILjava/lang/Object;)V
    .registers 4

    invoke-virtual {p0}, Lorg/kxml2/kdom/Node;->getChildCount()I

    move-result v0

    invoke-virtual {p0, v0, p1, p2}, Lorg/kxml2/kdom/Node;->addChild(IILjava/lang/Object;)V

    return-void
.end method

.method public createElement(Ljava/lang/String;Ljava/lang/String;)Lorg/kxml2/kdom/Element;
    .registers 4

    new-instance v0, Lorg/kxml2/kdom/Element;

    invoke-direct {v0}, Lorg/kxml2/kdom/Element;-><init>()V

    if-nez p1, :cond_9

    const-string p1, ""

    :cond_9
    iput-object p1, v0, Lorg/kxml2/kdom/Element;->namespace:Ljava/lang/String;

    iput-object p2, v0, Lorg/kxml2/kdom/Element;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getChild(I)Ljava/lang/Object;
    .registers 3

    iget-object v0, p0, Lorg/kxml2/kdom/Node;->children:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public getChildCount()I
    .registers 2

    iget-object v0, p0, Lorg/kxml2/kdom/Node;->children:Ljava/util/Vector;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    goto :goto_a

    :cond_6
    invoke-virtual {v0}, Ljava/util/Vector;->size()I

    move-result v0

    :goto_a
    return v0
.end method

.method public getElement(I)Lorg/kxml2/kdom/Element;
    .registers 3

    invoke-virtual {p0, p1}, Lorg/kxml2/kdom/Node;->getChild(I)Ljava/lang/Object;

    move-result-object p1

    instance-of v0, p1, Lorg/kxml2/kdom/Element;

    if-eqz v0, :cond_b

    check-cast p1, Lorg/kxml2/kdom/Element;

    goto :goto_c

    :cond_b
    const/4 p1, 0x0

    :goto_c
    return-object p1
.end method

.method public getElement(Ljava/lang/String;Ljava/lang/String;)Lorg/kxml2/kdom/Element;
    .registers 8

    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lorg/kxml2/kdom/Node;->indexOf(Ljava/lang/String;Ljava/lang/String;I)I

    move-result v0

    add-int/lit8 v1, v0, 0x1

    invoke-virtual {p0, p1, p2, v1}, Lorg/kxml2/kdom/Node;->indexOf(Ljava/lang/String;Ljava/lang/String;I)I

    move-result v1

    const/4 v2, -0x1

    if-eq v0, v2, :cond_16

    if-eq v1, v2, :cond_11

    goto :goto_16

    :cond_11
    invoke-virtual {p0, v0}, Lorg/kxml2/kdom/Node;->getElement(I)Lorg/kxml2/kdom/Element;

    move-result-object p1

    return-object p1

    :cond_16
    :goto_16
    new-instance v1, Ljava/lang/RuntimeException;

    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    const-string v4, "Element {"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v3, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string p1, "}"

    invoke-virtual {v3, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v3, p2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    if-ne v0, v2, :cond_32

    const-string p1, " not found in "

    goto :goto_34

    :cond_32
    const-string p1, " more than once in "

    :goto_34
    invoke-virtual {v3, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v3, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v1, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public getText(I)Ljava/lang/String;
    .registers 3

    invoke-virtual {p0, p1}, Lorg/kxml2/kdom/Node;->isText(I)Z

    move-result v0

    if-eqz v0, :cond_d

    invoke-virtual {p0, p1}, Lorg/kxml2/kdom/Node;->getChild(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    goto :goto_e

    :cond_d
    const/4 p1, 0x0

    :goto_e
    return-object p1
.end method

.method public getType(I)I
    .registers 3

    iget-object v0, p0, Lorg/kxml2/kdom/Node;->types:Ljava/lang/StringBuffer;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result p1

    return p1
.end method

.method public indexOf(Ljava/lang/String;Ljava/lang/String;I)I
    .registers 7

    invoke-virtual {p0}, Lorg/kxml2/kdom/Node;->getChildCount()I

    move-result v0

    :goto_4
    if-ge p3, v0, :cond_26

    invoke-virtual {p0, p3}, Lorg/kxml2/kdom/Node;->getElement(I)Lorg/kxml2/kdom/Element;

    move-result-object v1

    if-eqz v1, :cond_23

    invoke-virtual {v1}, Lorg/kxml2/kdom/Element;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_23

    if-eqz p1, :cond_22

    invoke-virtual {v1}, Lorg/kxml2/kdom/Element;->getNamespace()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_23

    :cond_22
    return p3

    :cond_23
    add-int/lit8 p3, p3, 0x1

    goto :goto_4

    :cond_26
    const/4 p1, -0x1

    return p1
.end method

.method public isText(I)Z
    .registers 3

    invoke-virtual {p0, p1}, Lorg/kxml2/kdom/Node;->getType(I)I

    move-result p1

    const/4 v0, 0x4

    if-eq p1, v0, :cond_10

    const/4 v0, 0x7

    if-eq p1, v0, :cond_10

    const/4 v0, 0x5

    if-ne p1, v0, :cond_e

    goto :goto_10

    :cond_e
    const/4 p1, 0x0

    goto :goto_11

    :cond_10
    :goto_10
    const/4 p1, 0x1

    :goto_11
    return p1
.end method

.method public parse(Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 6

    const/4 v0, 0x0

    :cond_1
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v1

    const/4 v2, 0x1

    if-eq v1, v2, :cond_46

    const/4 v3, 0x2

    if-eq v1, v3, :cond_33

    const/4 v3, 0x3

    if-eq v1, v3, :cond_46

    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x6

    if-eqz v2, :cond_20

    if-ne v1, v3, :cond_18

    const/4 v1, 0x4

    :cond_18
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lorg/kxml2/kdom/Node;->addChild(ILjava/lang/Object;)V

    goto :goto_2f

    :cond_20
    if-ne v1, v3, :cond_2f

    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2f

    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v3, v1}, Lorg/kxml2/kdom/Node;->addChild(ILjava/lang/Object;)V

    :cond_2f
    :goto_2f
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->nextToken()I

    goto :goto_47

    :cond_33
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getNamespace()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lorg/kxml2/kdom/Node;->createElement(Ljava/lang/String;Ljava/lang/String;)Lorg/kxml2/kdom/Element;

    move-result-object v1

    invoke-virtual {p0, v3, v1}, Lorg/kxml2/kdom/Node;->addChild(ILjava/lang/Object;)V

    invoke-virtual {v1, p1}, Lorg/kxml2/kdom/Element;->parse(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_47

    :cond_46
    const/4 v0, 0x1

    :goto_47
    if-eqz v0, :cond_1

    return-void
.end method

.method public removeChild(I)V
    .registers 6

    iget-object v0, p0, Lorg/kxml2/kdom/Node;->children:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->removeElementAt(I)V

    iget-object v0, p0, Lorg/kxml2/kdom/Node;->types:Ljava/lang/StringBuffer;

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->length()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    :goto_d
    if-ge p1, v0, :cond_1c

    iget-object v1, p0, Lorg/kxml2/kdom/Node;->types:Ljava/lang/StringBuffer;

    add-int/lit8 v2, p1, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v3

    invoke-virtual {v1, p1, v3}, Ljava/lang/StringBuffer;->setCharAt(IC)V

    move p1, v2

    goto :goto_d

    :cond_1c
    iget-object p1, p0, Lorg/kxml2/kdom/Node;->types:Ljava/lang/StringBuffer;

    invoke-virtual {p1, v0}, Ljava/lang/StringBuffer;->setLength(I)V

    return-void
.end method

.method public write(Lorg/xmlpull/v1/XmlSerializer;)V
    .registers 2

    invoke-virtual {p0, p1}, Lorg/kxml2/kdom/Node;->writeChildren(Lorg/xmlpull/v1/XmlSerializer;)V

    invoke-interface {p1}, Lorg/xmlpull/v1/XmlSerializer;->flush()V

    return-void
.end method

.method public writeChildren(Lorg/xmlpull/v1/XmlSerializer;)V
    .registers 6

    iget-object v0, p0, Lorg/kxml2/kdom/Node;->children:Ljava/util/Vector;

    if-nez v0, :cond_5

    return-void

    :cond_5
    invoke-virtual {v0}, Ljava/util/Vector;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_a
    if-ge v1, v0, :cond_62

    invoke-virtual {p0, v1}, Lorg/kxml2/kdom/Node;->getType(I)I

    move-result v2

    iget-object v3, p0, Lorg/kxml2/kdom/Node;->children:Ljava/util/Vector;

    invoke-virtual {v3, v1}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v3

    packed-switch v2, :pswitch_data_64

    :pswitch_19
    new-instance p1, Ljava/lang/RuntimeException;

    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    const-string v1, "Illegal type: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1

    :pswitch_30
    check-cast v3, Ljava/lang/String;

    invoke-interface {p1, v3}, Lorg/xmlpull/v1/XmlSerializer;->docdecl(Ljava/lang/String;)V

    goto :goto_5f

    :pswitch_36
    check-cast v3, Ljava/lang/String;

    invoke-interface {p1, v3}, Lorg/xmlpull/v1/XmlSerializer;->comment(Ljava/lang/String;)V

    goto :goto_5f

    :pswitch_3c
    check-cast v3, Ljava/lang/String;

    invoke-interface {p1, v3}, Lorg/xmlpull/v1/XmlSerializer;->processingInstruction(Ljava/lang/String;)V

    goto :goto_5f

    :pswitch_42
    check-cast v3, Ljava/lang/String;

    invoke-interface {p1, v3}, Lorg/xmlpull/v1/XmlSerializer;->ignorableWhitespace(Ljava/lang/String;)V

    goto :goto_5f

    :pswitch_48
    check-cast v3, Ljava/lang/String;

    invoke-interface {p1, v3}, Lorg/xmlpull/v1/XmlSerializer;->entityRef(Ljava/lang/String;)V

    goto :goto_5f

    :pswitch_4e
    check-cast v3, Ljava/lang/String;

    invoke-interface {p1, v3}, Lorg/xmlpull/v1/XmlSerializer;->cdsect(Ljava/lang/String;)V

    goto :goto_5f

    :pswitch_54
    check-cast v3, Ljava/lang/String;

    invoke-interface {p1, v3}, Lorg/xmlpull/v1/XmlSerializer;->text(Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    goto :goto_5f

    :pswitch_5a
    check-cast v3, Lorg/kxml2/kdom/Element;

    invoke-virtual {v3, p1}, Lorg/kxml2/kdom/Element;->write(Lorg/xmlpull/v1/XmlSerializer;)V

    :goto_5f
    add-int/lit8 v1, v1, 0x1

    goto :goto_a

    :cond_62
    return-void

    nop

    :pswitch_data_64
    .packed-switch 0x2
        :pswitch_5a
        :pswitch_19
        :pswitch_54
        :pswitch_4e
        :pswitch_48
        :pswitch_42
        :pswitch_3c
        :pswitch_36
        :pswitch_30
    .end packed-switch
.end method
