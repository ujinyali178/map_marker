.class public Lorg/kxml2/io/KXmlSerializer;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/xmlpull/v1/XmlSerializer;


# instance fields
.field private auto:I

.field private depth:I

.field private elementStack:[Ljava/lang/String;

.field private encoding:Ljava/lang/String;

.field private indent:[Z

.field private nspCounts:[I

.field private nspStack:[Ljava/lang/String;

.field private pending:Z

.field private unicode:Z

.field private writer:Ljava/io/Writer;


# direct methods
.method public constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/16 v0, 0xc

    new-array v0, v0, [Ljava/lang/String;

    iput-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->elementStack:[Ljava/lang/String;

    const/4 v0, 0x4

    new-array v1, v0, [I

    iput-object v1, p0, Lorg/kxml2/io/KXmlSerializer;->nspCounts:[I

    const/16 v1, 0x8

    new-array v1, v1, [Ljava/lang/String;

    iput-object v1, p0, Lorg/kxml2/io/KXmlSerializer;->nspStack:[Ljava/lang/String;

    new-array v0, v0, [Z

    iput-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->indent:[Z

    return-void
.end method

.method private final check(Z)V
    .registers 8

    iget-boolean v0, p0, Lorg/kxml2/io/KXmlSerializer;->pending:Z

    if-nez v0, :cond_5

    return-void

    :cond_5
    iget v0, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    const/4 v1, 0x0

    iput-boolean v1, p0, Lorg/kxml2/io/KXmlSerializer;->pending:Z

    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->indent:[Z

    array-length v3, v2

    if-gt v3, v0, :cond_1c

    add-int/lit8 v3, v0, 0x4

    new-array v3, v3, [Z

    invoke-static {v2, v1, v3, v1, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iput-object v3, p0, Lorg/kxml2/io/KXmlSerializer;->indent:[Z

    :cond_1c
    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->indent:[Z

    iget v2, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    add-int/lit8 v3, v2, -0x1

    aget-boolean v3, v0, v3

    aput-boolean v3, v0, v2

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->nspCounts:[I

    add-int/lit8 v2, v2, -0x1

    aget v0, v0, v2

    :goto_2c
    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->nspCounts:[I

    iget v3, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    aget v4, v2, v3

    if-ge v0, v4, :cond_9a

    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const/16 v3, 0x20

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(I)V

    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v3, "xmlns"

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->nspStack:[Ljava/lang/String;

    mul-int/lit8 v3, v0, 0x2

    aget-object v2, v2, v3

    const-string v4, ""

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_61

    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const/16 v4, 0x3a

    invoke-virtual {v2, v4}, Ljava/io/Writer;->write(I)V

    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    iget-object v4, p0, Lorg/kxml2/io/KXmlSerializer;->nspStack:[Ljava/lang/String;

    aget-object v4, v4, v3

    invoke-virtual {v2, v4}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    goto :goto_80

    :cond_61
    invoke-virtual {p0}, Lorg/kxml2/io/KXmlSerializer;->getNamespace()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_80

    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->nspStack:[Ljava/lang/String;

    add-int/lit8 v5, v3, 0x1

    aget-object v2, v2, v5

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_78

    goto :goto_80

    :cond_78
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "Cannot set default namespace for elements in no namespace"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_80
    :goto_80
    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v4, "=\""

    invoke-virtual {v2, v4}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->nspStack:[Ljava/lang/String;

    add-int/lit8 v3, v3, 0x1

    aget-object v2, v2, v3

    const/16 v3, 0x22

    invoke-direct {p0, v2, v3}, Lorg/kxml2/io/KXmlSerializer;->writeEscaped(Ljava/lang/String;I)V

    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(I)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_2c

    :cond_9a
    array-length v0, v2

    add-int/lit8 v4, v3, 0x1

    if-gt v0, v4, :cond_aa

    add-int/lit8 v0, v3, 0x8

    new-array v0, v0, [I

    add-int/lit8 v3, v3, 0x1

    invoke-static {v2, v1, v0, v1, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iput-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->nspCounts:[I

    :cond_aa
    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->nspCounts:[I

    iget v1, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    add-int/lit8 v2, v1, 0x1

    aget v1, v0, v1

    aput v1, v0, v2

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    if-eqz p1, :cond_bb

    const-string p1, " />"

    goto :goto_bd

    :cond_bb
    const-string p1, ">"

    :goto_bd
    invoke-virtual {v0, p1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    return-void
.end method

.method private final getPrefix(Ljava/lang/String;ZZ)Ljava/lang/String;
    .registers 10

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->nspCounts:[I

    iget v1, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    add-int/lit8 v1, v1, 0x1

    aget v0, v0, v1

    mul-int/lit8 v0, v0, 0x2

    add-int/lit8 v0, v0, -0x2

    :goto_c
    const/4 v1, 0x0

    const-string v2, ""

    if-ltz v0, :cond_50

    iget-object v3, p0, Lorg/kxml2/io/KXmlSerializer;->nspStack:[Ljava/lang/String;

    add-int/lit8 v4, v0, 0x1

    aget-object v3, v3, v4

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4d

    if-nez p2, :cond_29

    iget-object v3, p0, Lorg/kxml2/io/KXmlSerializer;->nspStack:[Ljava/lang/String;

    aget-object v3, v3, v0

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4d

    :cond_29
    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->nspStack:[Ljava/lang/String;

    aget-object v2, v2, v0

    add-int/lit8 v3, v0, 0x2

    :goto_2f
    iget-object v4, p0, Lorg/kxml2/io/KXmlSerializer;->nspCounts:[I

    iget v5, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    add-int/lit8 v5, v5, 0x1

    aget v4, v4, v5

    mul-int/lit8 v4, v4, 0x2

    if-ge v3, v4, :cond_49

    iget-object v4, p0, Lorg/kxml2/io/KXmlSerializer;->nspStack:[Ljava/lang/String;

    aget-object v4, v4, v3

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_46

    goto :goto_4a

    :cond_46
    add-int/lit8 v3, v3, 0x1

    goto :goto_2f

    :cond_49
    move-object v1, v2

    :goto_4a
    if-eqz v1, :cond_4d

    return-object v1

    :cond_4d
    add-int/lit8 v0, v0, -0x2

    goto :goto_c

    :cond_50
    if-nez p3, :cond_53

    return-object v1

    :cond_53
    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_5a

    goto :goto_91

    :cond_5a
    new-instance p2, Ljava/lang/StringBuffer;

    invoke-direct {p2}, Ljava/lang/StringBuffer;-><init>()V

    const-string p3, "n"

    invoke-virtual {p2, p3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget p3, p0, Lorg/kxml2/io/KXmlSerializer;->auto:I

    add-int/lit8 v0, p3, 0x1

    iput v0, p0, Lorg/kxml2/io/KXmlSerializer;->auto:I

    invoke-virtual {p2, p3}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    invoke-virtual {p2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p2

    iget-object p3, p0, Lorg/kxml2/io/KXmlSerializer;->nspCounts:[I

    iget v0, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    add-int/lit8 v0, v0, 0x1

    aget p3, p3, v0

    mul-int/lit8 p3, p3, 0x2

    add-int/lit8 p3, p3, -0x2

    :goto_7d
    if-ltz p3, :cond_8e

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->nspStack:[Ljava/lang/String;

    aget-object v0, v0, p3

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8b

    move-object v2, v1

    goto :goto_8f

    :cond_8b
    add-int/lit8 p3, p3, -0x2

    goto :goto_7d

    :cond_8e
    move-object v2, p2

    :goto_8f
    if-eqz v2, :cond_5a

    :goto_91
    iget-boolean p2, p0, Lorg/kxml2/io/KXmlSerializer;->pending:Z

    const/4 p3, 0x0

    iput-boolean p3, p0, Lorg/kxml2/io/KXmlSerializer;->pending:Z

    invoke-virtual {p0, v2, p1}, Lorg/kxml2/io/KXmlSerializer;->setPrefix(Ljava/lang/String;Ljava/lang/String;)V

    iput-boolean p2, p0, Lorg/kxml2/io/KXmlSerializer;->pending:Z

    return-object v2
.end method

.method private final writeEscaped(Ljava/lang/String;I)V
    .registers 8

    const/4 v0, 0x0

    :goto_1
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-ge v0, v1, :cond_9a

    invoke-virtual {p1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v1

    const/16 v2, 0x9

    const-string v3, "&#"

    if-eq v1, v2, :cond_7a

    const/16 v2, 0xa

    if-eq v1, v2, :cond_7a

    const/16 v2, 0xd

    if-eq v1, v2, :cond_7a

    const/16 v2, 0x22

    if-eq v1, v2, :cond_40

    const/16 v4, 0x3c

    if-eq v1, v4, :cond_3b

    const/16 v4, 0x3e

    if-eq v1, v4, :cond_36

    const/16 v4, 0x26

    if-eq v1, v4, :cond_2e

    const/16 v4, 0x27

    if-eq v1, v4, :cond_40

    goto :goto_4f

    :cond_2e
    iget-object v1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v2, "&amp;"

    :goto_32
    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    goto :goto_96

    :cond_36
    iget-object v1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v2, "&gt;"

    goto :goto_32

    :cond_3b
    iget-object v1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v2, "&lt;"

    goto :goto_32

    :cond_40
    if-ne v1, p2, :cond_4f

    iget-object v3, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    if-ne v1, v2, :cond_49

    const-string v1, "&quot;"

    goto :goto_4b

    :cond_49
    const-string v1, "&apos;"

    :goto_4b
    invoke-virtual {v3, v1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    goto :goto_96

    :cond_4f
    :goto_4f
    const/16 v2, 0x20

    if-lt v1, v2, :cond_60

    const/16 v2, 0x40

    if-eq v1, v2, :cond_60

    const/16 v2, 0x7f

    if-lt v1, v2, :cond_7d

    iget-boolean v2, p0, Lorg/kxml2/io/KXmlSerializer;->unicode:Z

    if-eqz v2, :cond_60

    goto :goto_7d

    :cond_60
    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    new-instance v4, Ljava/lang/StringBuffer;

    invoke-direct {v4}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v4, v1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    const-string v1, ";"

    invoke-virtual {v4, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    :goto_72
    invoke-virtual {v4}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    goto :goto_96

    :cond_7a
    const/4 v2, -0x1

    if-ne p2, v2, :cond_83

    :cond_7d
    :goto_7d
    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {v2, v1}, Ljava/io/Writer;->write(I)V

    goto :goto_96

    :cond_83
    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    new-instance v4, Ljava/lang/StringBuffer;

    invoke-direct {v4}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v4, v1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    const/16 v1, 0x3b

    invoke-virtual {v4, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_72

    :goto_96
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_1

    :cond_9a
    return-void
.end method


# virtual methods
.method public attribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    .registers 7

    iget-boolean v0, p0, Lorg/kxml2/io/KXmlSerializer;->pending:Z

    if-eqz v0, :cond_56

    const-string v0, ""

    if-nez p1, :cond_9

    move-object p1, v0

    :cond_9
    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_11

    move-object p1, v0

    goto :goto_17

    :cond_11
    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-direct {p0, p1, v1, v2}, Lorg/kxml2/io/KXmlSerializer;->getPrefix(Ljava/lang/String;ZZ)Ljava/lang/String;

    move-result-object p1

    :goto_17
    iget-object v1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const/16 v2, 0x20

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(I)V

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_30

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {v0, p1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const/16 v0, 0x3a

    invoke-virtual {p1, v0}, Ljava/io/Writer;->write(I)V

    :cond_30
    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {p1, p2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const/16 p2, 0x3d

    invoke-virtual {p1, p2}, Ljava/io/Writer;->write(I)V

    const/16 p1, 0x22

    invoke-virtual {p3, p1}, Ljava/lang/String;->indexOf(I)I

    move-result p2

    const/4 v0, -0x1

    if-ne p2, v0, :cond_46

    goto :goto_48

    :cond_46
    const/16 p1, 0x27

    :goto_48
    iget-object p2, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {p2, p1}, Ljava/io/Writer;->write(I)V

    invoke-direct {p0, p3, p1}, Lorg/kxml2/io/KXmlSerializer;->writeEscaped(Ljava/lang/String;I)V

    iget-object p2, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {p2, p1}, Ljava/io/Writer;->write(I)V

    return-object p0

    :cond_56
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "illegal position for attribute"

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public cdsect(Ljava/lang/String;)V
    .registers 4

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lorg/kxml2/io/KXmlSerializer;->check(Z)V

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v1, "<![CDATA["

    invoke-virtual {v0, v1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {v0, p1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v0, "]]>"

    invoke-virtual {p1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    return-void
.end method

.method public comment(Ljava/lang/String;)V
    .registers 4

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lorg/kxml2/io/KXmlSerializer;->check(Z)V

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v1, "<!--"

    invoke-virtual {v0, v1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {v0, p1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v0, "-->"

    invoke-virtual {p1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    return-void
.end method

.method public docdecl(Ljava/lang/String;)V
    .registers 4

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v1, "<!DOCTYPE"

    invoke-virtual {v0, v1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {v0, p1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v0, ">"

    invoke-virtual {p1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    return-void
.end method

.method public endDocument()V
    .registers 4

    :goto_0
    iget v0, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    if-lez v0, :cond_16

    iget-object v1, p0, Lorg/kxml2/io/KXmlSerializer;->elementStack:[Ljava/lang/String;

    mul-int/lit8 v2, v0, 0x3

    add-int/lit8 v2, v2, -0x3

    aget-object v2, v1, v2

    mul-int/lit8 v0, v0, 0x3

    add-int/lit8 v0, v0, -0x1

    aget-object v0, v1, v0

    invoke-virtual {p0, v2, v0}, Lorg/kxml2/io/KXmlSerializer;->endTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    goto :goto_0

    :cond_16
    invoke-virtual {p0}, Lorg/kxml2/io/KXmlSerializer;->flush()V

    return-void
.end method

.method public endTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    .registers 6

    iget-boolean v0, p0, Lorg/kxml2/io/KXmlSerializer;->pending:Z

    const/4 v1, 0x1

    if-nez v0, :cond_a

    iget v0, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    sub-int/2addr v0, v1

    iput v0, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    :cond_a
    if-nez p1, :cond_16

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->elementStack:[Ljava/lang/String;

    iget v2, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    mul-int/lit8 v2, v2, 0x3

    aget-object v0, v0, v2

    if-nez v0, :cond_9d

    :cond_16
    if-eqz p1, :cond_26

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->elementStack:[Ljava/lang/String;

    iget v2, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    mul-int/lit8 v2, v2, 0x3

    aget-object v0, v0, v2

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9d

    :cond_26
    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->elementStack:[Ljava/lang/String;

    iget v2, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    mul-int/lit8 v2, v2, 0x3

    add-int/lit8 v2, v2, 0x2

    aget-object v0, v0, v2

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9d

    iget-boolean p1, p0, Lorg/kxml2/io/KXmlSerializer;->pending:Z

    if-eqz p1, :cond_43

    invoke-direct {p0, v1}, Lorg/kxml2/io/KXmlSerializer;->check(Z)V

    iget p1, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    sub-int/2addr p1, v1

    iput p1, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    goto :goto_92

    :cond_43
    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->indent:[Z

    iget v0, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    add-int/2addr v0, v1

    aget-boolean p1, p1, v0

    if-eqz p1, :cond_62

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v0, "\r\n"

    invoke-virtual {p1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    const/4 p1, 0x0

    :goto_54
    iget v0, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    if-ge p1, v0, :cond_62

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v2, "  "

    invoke-virtual {v0, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    add-int/lit8 p1, p1, 0x1

    goto :goto_54

    :cond_62
    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v0, "</"

    invoke-virtual {p1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->elementStack:[Ljava/lang/String;

    iget v0, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    mul-int/lit8 v0, v0, 0x3

    add-int/2addr v0, v1

    aget-object p1, p1, v0

    const-string v0, ""

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_86

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {v0, p1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const/16 v0, 0x3a

    invoke-virtual {p1, v0}, Ljava/io/Writer;->write(I)V

    :cond_86
    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {p1, p2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const/16 p2, 0x3e

    invoke-virtual {p1, p2}, Ljava/io/Writer;->write(I)V

    :goto_92
    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->nspCounts:[I

    iget p2, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    add-int/lit8 v0, p2, 0x1

    aget p2, p1, p2

    aput p2, p1, v0

    return-object p0

    :cond_9d
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    const-string v2, "</{"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string p1, "}"

    invoke-virtual {v1, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v1, p2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string p1, "> does not match start"

    invoke-virtual {v1, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public entityRef(Ljava/lang/String;)V
    .registers 4

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lorg/kxml2/io/KXmlSerializer;->check(Z)V

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const/16 v1, 0x26

    invoke-virtual {v0, v1}, Ljava/io/Writer;->write(I)V

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {v0, p1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const/16 v0, 0x3b

    invoke-virtual {p1, v0}, Ljava/io/Writer;->write(I)V

    return-void
.end method

.method public flush()V
    .registers 2

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lorg/kxml2/io/KXmlSerializer;->check(Z)V

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {v0}, Ljava/io/Writer;->flush()V

    return-void
.end method

.method public getDepth()I
    .registers 2

    iget-boolean v0, p0, Lorg/kxml2/io/KXmlSerializer;->pending:Z

    if-eqz v0, :cond_9

    iget v0, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    add-int/lit8 v0, v0, 0x1

    goto :goto_b

    :cond_9
    iget v0, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    :goto_b
    return v0
.end method

.method public getFeature(Ljava/lang/String;)Z
    .registers 3

    const-string v0, "http://xmlpull.org/v1/doc/features.html#indent-output"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_f

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->indent:[Z

    iget v0, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    aget-boolean p1, p1, v0

    goto :goto_10

    :cond_f
    const/4 p1, 0x0

    :goto_10
    return p1
.end method

.method public getName()Ljava/lang/String;
    .registers 3

    invoke-virtual {p0}, Lorg/kxml2/io/KXmlSerializer;->getDepth()I

    move-result v0

    if-nez v0, :cond_8

    const/4 v0, 0x0

    goto :goto_14

    :cond_8
    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->elementStack:[Ljava/lang/String;

    invoke-virtual {p0}, Lorg/kxml2/io/KXmlSerializer;->getDepth()I

    move-result v1

    mul-int/lit8 v1, v1, 0x3

    add-int/lit8 v1, v1, -0x1

    aget-object v0, v0, v1

    :goto_14
    return-object v0
.end method

.method public getNamespace()Ljava/lang/String;
    .registers 3

    invoke-virtual {p0}, Lorg/kxml2/io/KXmlSerializer;->getDepth()I

    move-result v0

    if-nez v0, :cond_8

    const/4 v0, 0x0

    goto :goto_14

    :cond_8
    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->elementStack:[Ljava/lang/String;

    invoke-virtual {p0}, Lorg/kxml2/io/KXmlSerializer;->getDepth()I

    move-result v1

    mul-int/lit8 v1, v1, 0x3

    add-int/lit8 v1, v1, -0x3

    aget-object v0, v0, v1

    :goto_14
    return-object v0
.end method

.method public getPrefix(Ljava/lang/String;Z)Ljava/lang/String;
    .registers 4

    const/4 v0, 0x0

    :try_start_1
    invoke-direct {p0, p1, v0, p2}, Lorg/kxml2/io/KXmlSerializer;->getPrefix(Ljava/lang/String;ZZ)Ljava/lang/String;

    move-result-object p1
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_5} :catch_6

    return-object p1

    :catch_6
    move-exception p1

    new-instance p2, Ljava/lang/RuntimeException;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p2
.end method

.method public getProperty(Ljava/lang/String;)Ljava/lang/Object;
    .registers 3

    new-instance p1, Ljava/lang/RuntimeException;

    const-string v0, "Unsupported property"

    invoke-direct {p1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public ignorableWhitespace(Ljava/lang/String;)V
    .registers 2

    invoke-virtual {p0, p1}, Lorg/kxml2/io/KXmlSerializer;->text(Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    return-void
.end method

.method public processingInstruction(Ljava/lang/String;)V
    .registers 4

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lorg/kxml2/io/KXmlSerializer;->check(Z)V

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v1, "<?"

    invoke-virtual {v0, v1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {v0, p1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v0, "?>"

    invoke-virtual {p1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    return-void
.end method

.method public setFeature(Ljava/lang/String;Z)V
    .registers 4

    const-string v0, "http://xmlpull.org/v1/doc/features.html#indent-output"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_f

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->indent:[Z

    iget v0, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    aput-boolean p2, p1, v0

    return-void

    :cond_f
    new-instance p1, Ljava/lang/RuntimeException;

    const-string p2, "Unsupported Feature"

    invoke-direct {p1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public setOutput(Ljava/io/OutputStream;Ljava/lang/String;)V
    .registers 4

    if-eqz p1, :cond_24

    new-instance v0, Ljava/io/OutputStreamWriter;

    if-nez p2, :cond_a

    invoke-direct {v0, p1}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    goto :goto_d

    :cond_a
    invoke-direct {v0, p1, p2}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;Ljava/lang/String;)V

    :goto_d
    invoke-virtual {p0, v0}, Lorg/kxml2/io/KXmlSerializer;->setOutput(Ljava/io/Writer;)V

    iput-object p2, p0, Lorg/kxml2/io/KXmlSerializer;->encoding:Ljava/lang/String;

    if-eqz p2, :cond_23

    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object p1

    const-string p2, "utf"

    invoke-virtual {p1, p2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_23

    const/4 p1, 0x1

    iput-boolean p1, p0, Lorg/kxml2/io/KXmlSerializer;->unicode:Z

    :cond_23
    return-void

    :cond_24
    new-instance p1, Ljava/lang/IllegalArgumentException;

    invoke-direct {p1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw p1
.end method

.method public setOutput(Ljava/io/Writer;)V
    .registers 6

    iput-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->nspCounts:[I

    const/4 v0, 0x0

    const/4 v1, 0x2

    aput v1, p1, v0

    const/4 v2, 0x1

    aput v1, p1, v2

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->nspStack:[Ljava/lang/String;

    const-string v3, ""

    aput-object v3, p1, v0

    aput-object v3, p1, v2

    const-string v2, "xml"

    aput-object v2, p1, v1

    const/4 v1, 0x3

    const-string v2, "http://www.w3.org/XML/1998/namespace"

    aput-object v2, p1, v1

    iput-boolean v0, p0, Lorg/kxml2/io/KXmlSerializer;->pending:Z

    iput v0, p0, Lorg/kxml2/io/KXmlSerializer;->auto:I

    iput v0, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    iput-boolean v0, p0, Lorg/kxml2/io/KXmlSerializer;->unicode:Z

    return-void
.end method

.method public setPrefix(Ljava/lang/String;Ljava/lang/String;)V
    .registers 9

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lorg/kxml2/io/KXmlSerializer;->check(Z)V

    const-string v1, ""

    if-nez p1, :cond_9

    move-object p1, v1

    :cond_9
    if-nez p2, :cond_c

    move-object p2, v1

    :cond_c
    const/4 v1, 0x1

    invoke-direct {p0, p2, v1, v0}, Lorg/kxml2/io/KXmlSerializer;->getPrefix(Ljava/lang/String;ZZ)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_18

    return-void

    :cond_18
    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->nspCounts:[I

    iget v3, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    add-int/2addr v3, v1

    aget v4, v2, v3

    add-int/lit8 v5, v4, 0x1

    aput v5, v2, v3

    shl-int/lit8 v1, v4, 0x1

    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->nspStack:[Ljava/lang/String;

    array-length v3, v2

    add-int/lit8 v4, v1, 0x1

    if-ge v3, v4, :cond_36

    array-length v3, v2

    add-int/lit8 v3, v3, 0x10

    new-array v3, v3, [Ljava/lang/String;

    invoke-static {v2, v0, v3, v0, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iput-object v3, p0, Lorg/kxml2/io/KXmlSerializer;->nspStack:[Ljava/lang/String;

    :cond_36
    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->nspStack:[Ljava/lang/String;

    aput-object p1, v0, v1

    aput-object p2, v0, v4

    return-void
.end method

.method public setProperty(Ljava/lang/String;Ljava/lang/Object;)V
    .registers 5

    new-instance p1, Ljava/lang/RuntimeException;

    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    const-string v1, "Unsupported Property:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public startDocument(Ljava/lang/String;Ljava/lang/Boolean;)V
    .registers 5

    iget-object v0, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v1, "<?xml version=\'1.0\' "

    invoke-virtual {v0, v1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    if-eqz p1, :cond_1a

    iput-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->encoding:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object p1

    const-string v0, "utf"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_1a

    const/4 p1, 0x1

    iput-boolean p1, p0, Lorg/kxml2/io/KXmlSerializer;->unicode:Z

    :cond_1a
    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->encoding:Ljava/lang/String;

    const-string v0, "\' "

    if-eqz p1, :cond_33

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v1, "encoding=\'"

    invoke-virtual {p1, v1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    iget-object v1, p0, Lorg/kxml2/io/KXmlSerializer;->encoding:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {p1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    :cond_33
    if-eqz p2, :cond_51

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v1, "standalone=\'"

    invoke-virtual {p1, v1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p2

    if-eqz p2, :cond_47

    const-string p2, "yes"

    goto :goto_49

    :cond_47
    const-string p2, "no"

    :goto_49
    invoke-virtual {p1, p2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {p1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    :cond_51
    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string p2, "?>"

    invoke-virtual {p1, p2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    return-void
.end method

.method public startTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    .registers 10

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lorg/kxml2/io/KXmlSerializer;->check(Z)V

    iget-object v1, p0, Lorg/kxml2/io/KXmlSerializer;->indent:[Z

    iget v2, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    aget-boolean v1, v1, v2

    if-eqz v1, :cond_22

    iget-object v1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v2, "\r\n"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    const/4 v1, 0x0

    :goto_14
    iget v2, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    if-ge v1, v2, :cond_22

    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const-string v3, "  "

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_14

    :cond_22
    iget v1, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    mul-int/lit8 v1, v1, 0x3

    iget-object v2, p0, Lorg/kxml2/io/KXmlSerializer;->elementStack:[Ljava/lang/String;

    array-length v3, v2

    add-int/lit8 v4, v1, 0x3

    if-ge v3, v4, :cond_37

    array-length v3, v2

    add-int/lit8 v3, v3, 0xc

    new-array v3, v3, [Ljava/lang/String;

    invoke-static {v2, v0, v3, v0, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iput-object v3, p0, Lorg/kxml2/io/KXmlSerializer;->elementStack:[Ljava/lang/String;

    :cond_37
    const-string v0, ""

    const/4 v2, 0x1

    if-nez p1, :cond_3e

    move-object v3, v0

    goto :goto_42

    :cond_3e
    invoke-direct {p0, p1, v2, v2}, Lorg/kxml2/io/KXmlSerializer;->getPrefix(Ljava/lang/String;ZZ)Ljava/lang/String;

    move-result-object v3

    :goto_42
    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7b

    iget-object v4, p0, Lorg/kxml2/io/KXmlSerializer;->nspCounts:[I

    iget v5, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    aget v4, v4, v5

    :goto_4e
    iget-object v5, p0, Lorg/kxml2/io/KXmlSerializer;->nspCounts:[I

    iget v6, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    add-int/2addr v6, v2

    aget v5, v5, v6

    if-ge v4, v5, :cond_7b

    iget-object v5, p0, Lorg/kxml2/io/KXmlSerializer;->nspStack:[Ljava/lang/String;

    mul-int/lit8 v6, v4, 0x2

    aget-object v5, v5, v6

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_78

    iget-object v5, p0, Lorg/kxml2/io/KXmlSerializer;->nspStack:[Ljava/lang/String;

    add-int/lit8 v6, v6, 0x1

    aget-object v5, v5, v6

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_70

    goto :goto_78

    :cond_70
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "Cannot set default namespace for elements in no namespace"

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_78
    :goto_78
    add-int/lit8 v4, v4, 0x1

    goto :goto_4e

    :cond_7b
    iget-object v4, p0, Lorg/kxml2/io/KXmlSerializer;->elementStack:[Ljava/lang/String;

    add-int/lit8 v5, v1, 0x1

    aput-object p1, v4, v1

    add-int/lit8 p1, v5, 0x1

    aput-object v3, v4, v5

    aput-object p2, v4, p1

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const/16 v1, 0x3c

    invoke-virtual {p1, v1}, Ljava/io/Writer;->write(I)V

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_a0

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {p1, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    const/16 v0, 0x3a

    invoke-virtual {p1, v0}, Ljava/io/Writer;->write(I)V

    :cond_a0
    iget-object p1, p0, Lorg/kxml2/io/KXmlSerializer;->writer:Ljava/io/Writer;

    invoke-virtual {p1, p2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iput-boolean v2, p0, Lorg/kxml2/io/KXmlSerializer;->pending:Z

    return-object p0
.end method

.method public text(Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    .registers 5

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lorg/kxml2/io/KXmlSerializer;->check(Z)V

    iget-object v1, p0, Lorg/kxml2/io/KXmlSerializer;->indent:[Z

    iget v2, p0, Lorg/kxml2/io/KXmlSerializer;->depth:I

    aput-boolean v0, v1, v2

    const/4 v0, -0x1

    invoke-direct {p0, p1, v0}, Lorg/kxml2/io/KXmlSerializer;->writeEscaped(Ljava/lang/String;I)V

    return-object p0
.end method

.method public text([CII)Lorg/xmlpull/v1/XmlSerializer;
    .registers 5

    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, p1, p2, p3}, Ljava/lang/String;-><init>([CII)V

    invoke-virtual {p0, v0}, Lorg/kxml2/io/KXmlSerializer;->text(Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    return-object p0
.end method
