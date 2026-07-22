.class public Lorg/kxml2/wap/WbxmlSerializer;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/xmlpull/v1/XmlSerializer;


# instance fields
.field private attrPage:I

.field attrStartTable:Ljava/util/Hashtable;

.field attrValueTable:Ljava/util/Hashtable;

.field attributes:Ljava/util/Vector;

.field buf:Ljava/io/ByteArrayOutputStream;

.field depth:I

.field private encoding:Ljava/lang/String;

.field name:Ljava/lang/String;

.field namespace:Ljava/lang/String;

.field out:Ljava/io/OutputStream;

.field pending:Ljava/lang/String;

.field stringTable:Ljava/util/Hashtable;

.field stringTableBuf:Ljava/io/ByteArrayOutputStream;

.field private tagPage:I

.field tagTable:Ljava/util/Hashtable;


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/Hashtable;

    invoke-direct {v0}, Ljava/util/Hashtable;-><init>()V

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlSerializer;->stringTable:Ljava/util/Hashtable;

    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlSerializer;->stringTableBuf:Ljava/io/ByteArrayOutputStream;

    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlSerializer;->attributes:Ljava/util/Vector;

    new-instance v0, Ljava/util/Hashtable;

    invoke-direct {v0}, Ljava/util/Hashtable;-><init>()V

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlSerializer;->attrStartTable:Ljava/util/Hashtable;

    new-instance v0, Ljava/util/Hashtable;

    invoke-direct {v0}, Ljava/util/Hashtable;-><init>()V

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlSerializer;->attrValueTable:Ljava/util/Hashtable;

    new-instance v0, Ljava/util/Hashtable;

    invoke-direct {v0}, Ljava/util/Hashtable;-><init>()V

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlSerializer;->tagTable:Ljava/util/Hashtable;

    return-void
.end method

.method static writeInt(Ljava/io/OutputStream;I)V
    .registers 7

    const/4 v0, 0x5

    new-array v0, v0, [B

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_5
    add-int/lit8 v3, v2, 0x1

    and-int/lit8 v4, p1, 0x7f

    int-to-byte v4, v4

    aput-byte v4, v0, v2

    shr-int/lit8 p1, p1, 0x7

    if-nez p1, :cond_23

    :goto_10
    const/4 p1, 0x1

    if-le v3, p1, :cond_1d

    add-int/lit8 v3, v3, -0x1

    aget-byte p1, v0, v3

    or-int/lit16 p1, p1, 0x80

    invoke-virtual {p0, p1}, Ljava/io/OutputStream;->write(I)V

    goto :goto_10

    :cond_1d
    aget-byte p1, v0, v1

    invoke-virtual {p0, p1}, Ljava/io/OutputStream;->write(I)V

    return-void

    :cond_23
    move v2, v3

    goto :goto_5
.end method

.method private writeStr(Ljava/lang/String;)V
    .registers 11

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    :goto_7
    const/16 v4, 0x83

    if-ge v2, v0, :cond_79

    :goto_b
    const/16 v5, 0x41

    if-ge v2, v0, :cond_18

    invoke-virtual {p1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v6

    if-ge v6, v5, :cond_18

    add-int/lit8 v2, v2, 0x1

    goto :goto_b

    :cond_18
    move v6, v2

    :goto_19
    if-ge v6, v0, :cond_24

    invoke-virtual {p1, v6}, Ljava/lang/String;->charAt(I)C

    move-result v7

    if-lt v7, v5, :cond_24

    add-int/lit8 v6, v6, 0x1

    goto :goto_19

    :cond_24
    sub-int v5, v6, v2

    const/16 v7, 0xa

    if-le v5, v7, :cond_77

    const/16 v5, 0x20

    if-le v2, v3, :cond_4f

    add-int/lit8 v7, v2, -0x1

    invoke-virtual {p1, v7}, Ljava/lang/String;->charAt(I)C

    move-result v7

    if-ne v7, v5, :cond_4f

    iget-object v7, p0, Lorg/kxml2/wap/WbxmlSerializer;->stringTable:Ljava/util/Hashtable;

    invoke-virtual {p1, v2, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-nez v7, :cond_4f

    iget-object v2, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v2, v4}, Ljava/io/ByteArrayOutputStream;->write(I)V

    invoke-virtual {p1, v3, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2, v1}, Lorg/kxml2/wap/WbxmlSerializer;->writeStrT(Ljava/lang/String;Z)V

    goto :goto_76

    :cond_4f
    if-le v2, v3, :cond_5b

    add-int/lit8 v7, v2, -0x1

    invoke-virtual {p1, v7}, Ljava/lang/String;->charAt(I)C

    move-result v7

    if-ne v7, v5, :cond_5b

    add-int/lit8 v2, v2, -0x1

    :cond_5b
    if-le v2, v3, :cond_69

    iget-object v5, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v5, v4}, Ljava/io/ByteArrayOutputStream;->write(I)V

    invoke-virtual {p1, v3, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v3, v1}, Lorg/kxml2/wap/WbxmlSerializer;->writeStrT(Ljava/lang/String;Z)V

    :cond_69
    iget-object v3, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v3, v4}, Ljava/io/ByteArrayOutputStream;->write(I)V

    invoke-virtual {p1, v2, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    invoke-direct {p0, v2, v3}, Lorg/kxml2/wap/WbxmlSerializer;->writeStrT(Ljava/lang/String;Z)V

    :goto_76
    move v3, v6

    :cond_77
    move v2, v6

    goto :goto_7

    :cond_79
    if-ge v3, v0, :cond_87

    iget-object v2, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v2, v4}, Ljava/io/ByteArrayOutputStream;->write(I)V

    invoke-virtual {p1, v3, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1, v1}, Lorg/kxml2/wap/WbxmlSerializer;->writeStrT(Ljava/lang/String;Z)V

    :cond_87
    return-void
.end method

.method private final writeStrT(Ljava/lang/String;Z)V
    .registers 9

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlSerializer;->stringTable:Ljava/util/Hashtable;

    invoke-virtual {v0, p1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    if-eqz v0, :cond_15

    iget-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result p2

    invoke-static {p1, p2}, Lorg/kxml2/wap/WbxmlSerializer;->writeInt(Ljava/io/OutputStream;I)V

    goto/16 :goto_94

    :cond_15
    iget-object v0, p0, Lorg/kxml2/wap/WbxmlSerializer;->stringTableBuf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->size()I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v3, 0x30

    const/16 v4, 0x20

    if-lt v2, v3, :cond_3f

    if-eqz p2, :cond_3f

    new-instance p2, Ljava/lang/StringBuffer;

    invoke-direct {p2}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {p2, v4}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    invoke-virtual {p2, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {p2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p1

    iget-object p2, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    add-int/lit8 v2, v0, 0x1

    invoke-static {p2, v2}, Lorg/kxml2/wap/WbxmlSerializer;->writeInt(Ljava/io/OutputStream;I)V

    goto :goto_44

    :cond_3f
    iget-object p2, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    invoke-static {p2, v0}, Lorg/kxml2/wap/WbxmlSerializer;->writeInt(Ljava/io/OutputStream;I)V

    :goto_44
    iget-object p2, p0, Lorg/kxml2/wap/WbxmlSerializer;->stringTable:Ljava/util/Hashtable;

    new-instance v2, Ljava/lang/Integer;

    invoke-direct {v2, v0}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {p2, p1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {p1, v1}, Ljava/lang/String;->charAt(I)C

    move-result p2

    const/4 v1, 0x1

    if-ne p2, v4, :cond_65

    iget-object p2, p0, Lorg/kxml2/wap/WbxmlSerializer;->stringTable:Ljava/util/Hashtable;

    invoke-virtual {p1, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/Integer;

    add-int/lit8 v5, v0, 0x1

    invoke-direct {v3, v5}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {p2, v2, v3}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_65
    invoke-virtual {p1, v4}, Ljava/lang/String;->lastIndexOf(I)I

    move-result p2

    if-le p2, v1, :cond_8a

    iget-object v2, p0, Lorg/kxml2/wap/WbxmlSerializer;->stringTable:Ljava/util/Hashtable;

    invoke-virtual {p1, p2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/Integer;

    add-int/2addr v0, p2

    invoke-direct {v4, v0}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v2, v3, v4}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v2, p0, Lorg/kxml2/wap/WbxmlSerializer;->stringTable:Ljava/util/Hashtable;

    add-int/2addr p2, v1

    invoke-virtual {p1, p2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p2

    new-instance v3, Ljava/lang/Integer;

    add-int/2addr v0, v1

    invoke-direct {v3, v0}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v2, p2, v3}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_8a
    iget-object p2, p0, Lorg/kxml2/wap/WbxmlSerializer;->stringTableBuf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {p0, p2, p1}, Lorg/kxml2/wap/WbxmlSerializer;->writeStrI(Ljava/io/OutputStream;Ljava/lang/String;)V

    iget-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->stringTableBuf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {p1}, Ljava/io/OutputStream;->flush()V

    :goto_94
    return-void
.end method


# virtual methods
.method public attribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    .registers 4

    iget-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->attributes:Ljava/util/Vector;

    invoke-virtual {p1, p2}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    iget-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->attributes:Ljava/util/Vector;

    invoke-virtual {p1, p3}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    return-object p0
.end method

.method public cdsect(Ljava/lang/String;)V
    .registers 2

    invoke-virtual {p0, p1}, Lorg/kxml2/wap/WbxmlSerializer;->text(Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    return-void
.end method

.method public checkPending(Z)V
    .registers 9

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlSerializer;->pending:Ljava/lang/String;

    if-nez v0, :cond_5

    return-void

    :cond_5
    iget-object v0, p0, Lorg/kxml2/wap/WbxmlSerializer;->attributes:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->size()I

    move-result v0

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlSerializer;->tagTable:Ljava/util/Hashtable;

    iget-object v2, p0, Lorg/kxml2/wap/WbxmlSerializer;->pending:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [I

    const/4 v2, 0x4

    const/4 v3, 0x1

    const/4 v4, 0x0

    if-nez v1, :cond_35

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    if-nez v0, :cond_25

    if-eqz p1, :cond_22

    const/4 p1, 0x4

    goto :goto_2c

    :cond_22
    const/16 p1, 0x44

    goto :goto_2c

    :cond_25
    if-eqz p1, :cond_2a

    const/16 p1, 0x84

    goto :goto_2c

    :cond_2a
    const/16 p1, 0xc4

    :goto_2c
    invoke-virtual {v1, p1}, Ljava/io/ByteArrayOutputStream;->write(I)V

    iget-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->pending:Ljava/lang/String;

    invoke-direct {p0, p1, v4}, Lorg/kxml2/wap/WbxmlSerializer;->writeStrT(Ljava/lang/String;Z)V

    goto :goto_65

    :cond_35
    aget v5, v1, v4

    iget v6, p0, Lorg/kxml2/wap/WbxmlSerializer;->tagPage:I

    if-eq v5, v6, :cond_49

    iput v5, p0, Lorg/kxml2/wap/WbxmlSerializer;->tagPage:I

    iget-object v5, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v5, v4}, Ljava/io/ByteArrayOutputStream;->write(I)V

    iget-object v5, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    iget v6, p0, Lorg/kxml2/wap/WbxmlSerializer;->tagPage:I

    invoke-virtual {v5, v6}, Ljava/io/ByteArrayOutputStream;->write(I)V

    :cond_49
    iget-object v5, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    if-nez v0, :cond_57

    if-eqz p1, :cond_52

    aget p1, v1, v3

    goto :goto_62

    :cond_52
    aget p1, v1, v3

    or-int/lit8 p1, p1, 0x40

    goto :goto_62

    :cond_57
    if-eqz p1, :cond_5e

    aget p1, v1, v3

    or-int/lit16 p1, p1, 0x80

    goto :goto_62

    :cond_5e
    aget p1, v1, v3

    or-int/lit16 p1, p1, 0xc0

    :goto_62
    invoke-virtual {v5, p1}, Ljava/io/ByteArrayOutputStream;->write(I)V

    :goto_65
    const/4 p1, 0x0

    :goto_66
    if-ge p1, v0, :cond_e0

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlSerializer;->attrStartTable:Ljava/util/Hashtable;

    iget-object v5, p0, Lorg/kxml2/wap/WbxmlSerializer;->attributes:Ljava/util/Vector;

    invoke-virtual {v5, p1}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [I

    if-nez v1, :cond_89

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v1, v2}, Ljava/io/ByteArrayOutputStream;->write(I)V

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlSerializer;->attributes:Ljava/util/Vector;

    invoke-virtual {v1, p1}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-direct {p0, v1, v4}, Lorg/kxml2/wap/WbxmlSerializer;->writeStrT(Ljava/lang/String;Z)V

    goto :goto_a4

    :cond_89
    aget v5, v1, v4

    iget v6, p0, Lorg/kxml2/wap/WbxmlSerializer;->attrPage:I

    if-eq v5, v6, :cond_9d

    iput v5, p0, Lorg/kxml2/wap/WbxmlSerializer;->attrPage:I

    iget-object v5, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v5, v4}, Ljava/io/ByteArrayOutputStream;->write(I)V

    iget-object v5, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    iget v6, p0, Lorg/kxml2/wap/WbxmlSerializer;->attrPage:I

    invoke-virtual {v5, v6}, Ljava/io/ByteArrayOutputStream;->write(I)V

    :cond_9d
    iget-object v5, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    aget v1, v1, v3

    invoke-virtual {v5, v1}, Ljava/io/ByteArrayOutputStream;->write(I)V

    :goto_a4
    iget-object v1, p0, Lorg/kxml2/wap/WbxmlSerializer;->attrValueTable:Ljava/util/Hashtable;

    iget-object v5, p0, Lorg/kxml2/wap/WbxmlSerializer;->attributes:Ljava/util/Vector;

    add-int/lit8 p1, p1, 0x1

    invoke-virtual {v5, p1}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [I

    if-nez v1, :cond_c2

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlSerializer;->attributes:Ljava/util/Vector;

    invoke-virtual {v1, p1}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-direct {p0, v1}, Lorg/kxml2/wap/WbxmlSerializer;->writeStr(Ljava/lang/String;)V

    goto :goto_dd

    :cond_c2
    aget v5, v1, v4

    iget v6, p0, Lorg/kxml2/wap/WbxmlSerializer;->attrPage:I

    if-eq v5, v6, :cond_d6

    iput v5, p0, Lorg/kxml2/wap/WbxmlSerializer;->attrPage:I

    iget-object v5, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v5, v4}, Ljava/io/ByteArrayOutputStream;->write(I)V

    iget-object v5, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    iget v6, p0, Lorg/kxml2/wap/WbxmlSerializer;->attrPage:I

    invoke-virtual {v5, v6}, Ljava/io/ByteArrayOutputStream;->write(I)V

    :cond_d6
    iget-object v5, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    aget v1, v1, v3

    invoke-virtual {v5, v1}, Ljava/io/ByteArrayOutputStream;->write(I)V

    :goto_dd
    add-int/lit8 p1, p1, 0x1

    goto :goto_66

    :cond_e0
    if-lez v0, :cond_e7

    iget-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {p1, v3}, Ljava/io/ByteArrayOutputStream;->write(I)V

    :cond_e7
    const/4 p1, 0x0

    iput-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->pending:Ljava/lang/String;

    iget-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->attributes:Ljava/util/Vector;

    invoke-virtual {p1}, Ljava/util/Vector;->removeAllElements()V

    return-void
.end method

.method public comment(Ljava/lang/String;)V
    .registers 2

    return-void
.end method

.method public docdecl(Ljava/lang/String;)V
    .registers 3

    new-instance p1, Ljava/lang/RuntimeException;

    const-string v0, "Cannot write docdecl for WBXML"

    invoke-direct {p1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public endDocument()V
    .registers 3

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlSerializer;->out:Ljava/io/OutputStream;

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlSerializer;->stringTableBuf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->size()I

    move-result v1

    invoke-static {v0, v1}, Lorg/kxml2/wap/WbxmlSerializer;->writeInt(Ljava/io/OutputStream;I)V

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlSerializer;->out:Ljava/io/OutputStream;

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlSerializer;->stringTableBuf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write([B)V

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlSerializer;->out:Ljava/io/OutputStream;

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write([B)V

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlSerializer;->out:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->flush()V

    return-void
.end method

.method public endTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    .registers 3

    iget-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->pending:Ljava/lang/String;

    const/4 p2, 0x1

    if-eqz p1, :cond_9

    invoke-virtual {p0, p2}, Lorg/kxml2/wap/WbxmlSerializer;->checkPending(Z)V

    goto :goto_e

    :cond_9
    iget-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {p1, p2}, Ljava/io/ByteArrayOutputStream;->write(I)V

    :goto_e
    iget p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->depth:I

    sub-int/2addr p1, p2

    iput p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->depth:I

    return-object p0
.end method

.method public entityRef(Ljava/lang/String;)V
    .registers 3

    new-instance p1, Ljava/lang/RuntimeException;

    const-string v0, "EntityReference not supported for WBXML"

    invoke-direct {p1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public flush()V
    .registers 1

    return-void
.end method

.method public getDepth()I
    .registers 2

    iget v0, p0, Lorg/kxml2/wap/WbxmlSerializer;->depth:I

    return v0
.end method

.method public getFeature(Ljava/lang/String;)Z
    .registers 2

    const/4 p1, 0x0

    return p1
.end method

.method public getName()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "NYI"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getNamespace()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "NYI"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getPrefix(Ljava/lang/String;Z)Ljava/lang/String;
    .registers 3

    new-instance p1, Ljava/lang/RuntimeException;

    const-string p2, "NYI"

    invoke-direct {p1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public getProperty(Ljava/lang/String;)Ljava/lang/Object;
    .registers 2

    const/4 p1, 0x0

    return-object p1
.end method

.method public ignorableWhitespace(Ljava/lang/String;)V
    .registers 2

    return-void
.end method

.method public processingInstruction(Ljava/lang/String;)V
    .registers 3

    new-instance p1, Ljava/lang/RuntimeException;

    const-string v0, "PI NYI"

    invoke-direct {p1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public setAttrStartTable(I[Ljava/lang/String;)V
    .registers 9

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_2
    array-length v2, p2

    if-ge v1, v2, :cond_1c

    aget-object v2, p2, v1

    if-eqz v2, :cond_19

    const/4 v3, 0x2

    new-array v3, v3, [I

    aput p1, v3, v0

    add-int/lit8 v4, v1, 0x5

    const/4 v5, 0x1

    const/4 v5, 0x1

    aput v4, v3, v5

    iget-object v4, p0, Lorg/kxml2/wap/WbxmlSerializer;->attrStartTable:Ljava/util/Hashtable;

    invoke-virtual {v4, v2, v3}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_19
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_1c
    return-void
.end method

.method public setAttrValueTable(I[Ljava/lang/String;)V
    .registers 9

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_2
    array-length v2, p2

    if-ge v1, v2, :cond_1c

    aget-object v2, p2, v1

    if-eqz v2, :cond_19

    const/4 v3, 0x2

    new-array v3, v3, [I

    aput p1, v3, v0

    add-int/lit16 v4, v1, 0x85

    const/4 v5, 0x1

    const/4 v5, 0x1

    aput v4, v3, v5

    iget-object v4, p0, Lorg/kxml2/wap/WbxmlSerializer;->attrValueTable:Ljava/util/Hashtable;

    invoke-virtual {v4, v2, v3}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_19
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_1c
    return-void
.end method

.method public setFeature(Ljava/lang/String;Z)V
    .registers 5

    new-instance p2, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    const-string v1, "unknown feature "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p2
.end method

.method public setOutput(Ljava/io/OutputStream;Ljava/lang/String;)V
    .registers 3

    if-nez p2, :cond_4

    const-string p2, "UTF-8"

    :cond_4
    iput-object p2, p0, Lorg/kxml2/wap/WbxmlSerializer;->encoding:Ljava/lang/String;

    iput-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->out:Ljava/io/OutputStream;

    new-instance p1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {p1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    iput-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    new-instance p1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {p1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    iput-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->stringTableBuf:Ljava/io/ByteArrayOutputStream;

    return-void
.end method

.method public setOutput(Ljava/io/Writer;)V
    .registers 3

    new-instance p1, Ljava/lang/RuntimeException;

    const-string v0, "Wbxml requires an OutputStream!"

    invoke-direct {p1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public setPrefix(Ljava/lang/String;Ljava/lang/String;)V
    .registers 3

    new-instance p1, Ljava/lang/RuntimeException;

    const-string p2, "NYI"

    invoke-direct {p1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public setProperty(Ljava/lang/String;Ljava/lang/Object;)V
    .registers 5

    new-instance p2, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    const-string v1, "unknown property "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p2
.end method

.method public setTagTable(I[Ljava/lang/String;)V
    .registers 9

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_2
    array-length v2, p2

    if-ge v1, v2, :cond_1c

    aget-object v2, p2, v1

    if-eqz v2, :cond_19

    const/4 v3, 0x2

    new-array v3, v3, [I

    aput p1, v3, v0

    add-int/lit8 v4, v1, 0x5

    const/4 v5, 0x1

    const/4 v5, 0x1

    aput v4, v3, v5

    iget-object v4, p0, Lorg/kxml2/wap/WbxmlSerializer;->tagTable:Ljava/util/Hashtable;

    invoke-virtual {v4, v2, v3}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_19
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_1c
    return-void
.end method

.method public startDocument(Ljava/lang/String;Ljava/lang/Boolean;)V
    .registers 4

    iget-object p2, p0, Lorg/kxml2/wap/WbxmlSerializer;->out:Ljava/io/OutputStream;

    const/4 v0, 0x3

    invoke-virtual {p2, v0}, Ljava/io/OutputStream;->write(I)V

    iget-object p2, p0, Lorg/kxml2/wap/WbxmlSerializer;->out:Ljava/io/OutputStream;

    const/4 v0, 0x1

    invoke-virtual {p2, v0}, Ljava/io/OutputStream;->write(I)V

    if-eqz p1, :cond_10

    iput-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->encoding:Ljava/lang/String;

    :cond_10
    iget-object p2, p0, Lorg/kxml2/wap/WbxmlSerializer;->encoding:Ljava/lang/String;

    invoke-virtual {p2}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object p2

    const-string v0, "UTF-8"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_26

    iget-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->out:Ljava/io/OutputStream;

    const/16 p2, 0x6a

    :goto_22
    invoke-virtual {p1, p2}, Ljava/io/OutputStream;->write(I)V

    goto :goto_38

    :cond_26
    iget-object p2, p0, Lorg/kxml2/wap/WbxmlSerializer;->encoding:Ljava/lang/String;

    invoke-virtual {p2}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object p2

    const-string v0, "ISO-8859-1"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_39

    iget-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->out:Ljava/io/OutputStream;

    const/4 p2, 0x4

    goto :goto_22

    :goto_38
    return-void

    :cond_39
    new-instance p2, Ljava/io/UnsupportedEncodingException;

    invoke-direct {p2, p1}, Ljava/io/UnsupportedEncodingException;-><init>(Ljava/lang/String;)V

    throw p2
.end method

.method public startTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    .registers 4

    if-eqz p1, :cond_13

    const-string v0, ""

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_b

    goto :goto_13

    :cond_b
    new-instance p1, Ljava/lang/RuntimeException;

    const-string p2, "NSP NYI"

    invoke-direct {p1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_13
    :goto_13
    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Lorg/kxml2/wap/WbxmlSerializer;->checkPending(Z)V

    iput-object p2, p0, Lorg/kxml2/wap/WbxmlSerializer;->pending:Ljava/lang/String;

    iget p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->depth:I

    add-int/lit8 p1, p1, 0x1

    iput p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->depth:I

    return-object p0
.end method

.method public text(Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    .registers 3

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lorg/kxml2/wap/WbxmlSerializer;->checkPending(Z)V

    invoke-direct {p0, p1}, Lorg/kxml2/wap/WbxmlSerializer;->writeStr(Ljava/lang/String;)V

    return-object p0
.end method

.method public text([CII)Lorg/xmlpull/v1/XmlSerializer;
    .registers 5

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lorg/kxml2/wap/WbxmlSerializer;->checkPending(Z)V

    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, p1, p2, p3}, Ljava/lang/String;-><init>([CII)V

    invoke-direct {p0, v0}, Lorg/kxml2/wap/WbxmlSerializer;->writeStr(Ljava/lang/String;)V

    return-object p0
.end method

.method writeStrI(Ljava/io/OutputStream;Ljava/lang/String;)V
    .registers 4

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlSerializer;->encoding:Ljava/lang/String;

    invoke-virtual {p2, v0}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object p2

    invoke-virtual {p1, p2}, Ljava/io/OutputStream;->write([B)V

    const/4 p2, 0x0

    invoke-virtual {p1, p2}, Ljava/io/OutputStream;->write(I)V

    return-void
.end method

.method public writeWapExtension(ILjava/lang/Object;)V
    .registers 5

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lorg/kxml2/wap/WbxmlSerializer;->checkPending(Z)V

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v1, p1}, Ljava/io/ByteArrayOutputStream;->write(I)V

    packed-switch p1, :pswitch_data_34

    packed-switch p1, :pswitch_data_3e

    packed-switch p1, :pswitch_data_48

    new-instance p1, Ljava/lang/IllegalArgumentException;

    invoke-direct {p1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw p1

    :pswitch_18
    check-cast p2, [B

    iget-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    array-length v0, p2

    invoke-static {p1, v0}, Lorg/kxml2/wap/WbxmlSerializer;->writeInt(Ljava/io/OutputStream;I)V

    iget-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {p1, p2}, Ljava/io/OutputStream;->write([B)V

    goto :goto_33

    :pswitch_26
    check-cast p2, Ljava/lang/String;

    invoke-direct {p0, p2, v0}, Lorg/kxml2/wap/WbxmlSerializer;->writeStrT(Ljava/lang/String;Z)V

    goto :goto_33

    :pswitch_2c
    iget-object p1, p0, Lorg/kxml2/wap/WbxmlSerializer;->buf:Ljava/io/ByteArrayOutputStream;

    check-cast p2, Ljava/lang/String;

    invoke-virtual {p0, p1, p2}, Lorg/kxml2/wap/WbxmlSerializer;->writeStrI(Ljava/io/OutputStream;Ljava/lang/String;)V

    :goto_33
    :pswitch_33
    return-void

    :pswitch_data_34
    .packed-switch 0x40
        :pswitch_2c
        :pswitch_2c
        :pswitch_2c
    .end packed-switch

    :pswitch_data_3e
    .packed-switch 0x80
        :pswitch_26
        :pswitch_26
        :pswitch_26
    .end packed-switch

    :pswitch_data_48
    .packed-switch 0xc0
        :pswitch_33
        :pswitch_33
        :pswitch_33
        :pswitch_18
    .end packed-switch
.end method
