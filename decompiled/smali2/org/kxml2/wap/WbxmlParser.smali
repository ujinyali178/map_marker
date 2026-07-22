.class public Lorg/kxml2/wap/WbxmlParser;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/xmlpull/v1/XmlPullParser;


# static fields
.field static final HEX_DIGITS:Ljava/lang/String; = "0123456789abcdef"

.field private static final ILLEGAL_TYPE:Ljava/lang/String; = "Wrong event type"

.field private static final UNEXPECTED_EOF:Ljava/lang/String; = "Unexpected EOF"

.field public static final WAP_EXTENSION:I = 0x40


# instance fields
.field private ATTR_START_TABLE:I

.field private ATTR_VALUE_TABLE:I

.field private TAG_TABLE:I

.field private attrStartTable:[Ljava/lang/String;

.field private attrValueTable:[Ljava/lang/String;

.field private attributeCount:I

.field private attributes:[Ljava/lang/String;

.field private cacheStringTable:Ljava/util/Hashtable;

.field private degenerated:Z

.field private depth:I

.field private elementStack:[Ljava/lang/String;

.field private encoding:Ljava/lang/String;

.field private in:Ljava/io/InputStream;

.field private isWhitespace:Z

.field private name:Ljava/lang/String;

.field private namespace:Ljava/lang/String;

.field private nextId:I

.field private nspCounts:[I

.field private nspStack:[Ljava/lang/String;

.field private prefix:Ljava/lang/String;

.field private processNsp:Z

.field private publicIdentifierId:I

.field private stringTable:[B

.field private tables:Ljava/util/Vector;

.field private tagTable:[Ljava/lang/String;

.field private text:Ljava/lang/String;

.field private type:I

.field private version:I

.field private wapCode:I

.field private wapExtensionData:Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lorg/kxml2/wap/WbxmlParser;->TAG_TABLE:I

    const/4 v0, 0x1

    iput v0, p0, Lorg/kxml2/wap/WbxmlParser;->ATTR_START_TABLE:I

    const/4 v0, 0x2

    iput v0, p0, Lorg/kxml2/wap/WbxmlParser;->ATTR_VALUE_TABLE:I

    const/4 v0, 0x0

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->cacheStringTable:Ljava/util/Hashtable;

    const/16 v0, 0x10

    new-array v1, v0, [Ljava/lang/String;

    iput-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->elementStack:[Ljava/lang/String;

    const/16 v1, 0x8

    new-array v1, v1, [Ljava/lang/String;

    iput-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->nspStack:[Ljava/lang/String;

    const/4 v1, 0x4

    new-array v1, v1, [I

    iput-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->nspCounts:[I

    new-array v0, v0, [Ljava/lang/String;

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    const/4 v0, -0x2

    iput v0, p0, Lorg/kxml2/wap/WbxmlParser;->nextId:I

    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->tables:Ljava/util/Vector;

    return-void
.end method

.method private final adjustNsp()Z
    .registers 14

    const/4 v0, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_3
    iget v3, p0, Lorg/kxml2/wap/WbxmlParser;->attributeCount:I

    shl-int/lit8 v4, v3, 0x2

    const-string v5, ""

    const/4 v6, -0x1

    const/16 v7, 0x3a

    const/4 v8, 0x1

    if-ge v1, v4, :cond_7d

    iget-object v3, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    add-int/lit8 v4, v1, 0x2

    aget-object v3, v3, v4

    invoke-virtual {v3, v7}, Ljava/lang/String;->indexOf(I)I

    move-result v4

    const-string v7, "xmlns"

    if-eq v4, v6, :cond_2a

    invoke-virtual {v3, v0, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    add-int/lit8 v4, v4, 0x1

    invoke-virtual {v3, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    move-object v4, v3

    move-object v3, v6

    goto :goto_31

    :cond_2a
    invoke-virtual {v3, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7a

    const/4 v4, 0x0

    :goto_31
    invoke-virtual {v3, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_39

    const/4 v2, 0x1

    goto :goto_7a

    :cond_39
    iget-object v3, p0, Lorg/kxml2/wap/WbxmlParser;->nspCounts:[I

    iget v6, p0, Lorg/kxml2/wap/WbxmlParser;->depth:I

    aget v7, v3, v6

    add-int/lit8 v9, v7, 0x1

    aput v9, v3, v6

    shl-int/lit8 v3, v7, 0x1

    iget-object v6, p0, Lorg/kxml2/wap/WbxmlParser;->nspStack:[Ljava/lang/String;

    add-int/lit8 v7, v3, 0x2

    invoke-direct {p0, v6, v7}, Lorg/kxml2/wap/WbxmlParser;->ensureCapacity([Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lorg/kxml2/wap/WbxmlParser;->nspStack:[Ljava/lang/String;

    aput-object v4, v6, v3

    add-int/2addr v3, v8

    iget-object v7, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    add-int/lit8 v9, v1, 0x3

    aget-object v10, v7, v9

    aput-object v10, v6, v3

    if-eqz v4, :cond_69

    aget-object v3, v7, v9

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_69

    const-string v3, "illegal empty namespace"

    invoke-direct {p0, v3}, Lorg/kxml2/wap/WbxmlParser;->exception(Ljava/lang/String;)V

    :cond_69
    iget-object v3, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    add-int/lit8 v4, v1, 0x4

    iget v5, p0, Lorg/kxml2/wap/WbxmlParser;->attributeCount:I

    sub-int/2addr v5, v8

    iput v5, p0, Lorg/kxml2/wap/WbxmlParser;->attributeCount:I

    shl-int/lit8 v5, v5, 0x2

    sub-int/2addr v5, v1

    invoke-static {v3, v4, v3, v1, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    add-int/lit8 v1, v1, -0x4

    :cond_7a
    :goto_7a
    add-int/lit8 v1, v1, 0x4

    goto :goto_3

    :cond_7d
    if-eqz v2, :cond_12c

    shl-int/lit8 v1, v3, 0x2

    add-int/lit8 v1, v1, -0x4

    :goto_83
    if-ltz v1, :cond_12c

    iget-object v3, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    add-int/lit8 v4, v1, 0x2

    aget-object v3, v3, v4

    invoke-virtual {v3, v7}, Ljava/lang/String;->indexOf(I)I

    move-result v9

    if-eqz v9, :cond_10d

    if-eq v9, v6, :cond_109

    invoke-virtual {v3, v0, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v10

    add-int/lit8 v9, v9, 0x1

    invoke-virtual {v3, v9}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v10}, Lorg/kxml2/wap/WbxmlParser;->getNamespace(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    if-eqz v9, :cond_ea

    iget-object v11, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    aput-object v9, v11, v1

    add-int/lit8 v12, v1, 0x1

    aput-object v10, v11, v12

    aput-object v3, v11, v4

    iget v4, p0, Lorg/kxml2/wap/WbxmlParser;->attributeCount:I

    shl-int/lit8 v4, v4, 0x2

    add-int/lit8 v4, v4, -0x4

    :goto_b3
    if-le v4, v1, :cond_109

    iget-object v10, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    add-int/lit8 v11, v4, 0x2

    aget-object v10, v10, v11

    invoke-virtual {v3, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_e7

    iget-object v10, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    aget-object v10, v10, v4

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_e7

    new-instance v10, Ljava/lang/StringBuffer;

    invoke-direct {v10}, Ljava/lang/StringBuffer;-><init>()V

    const-string v11, "Duplicate Attribute: {"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v10, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v11, "}"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v10, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v10}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {p0, v10}, Lorg/kxml2/wap/WbxmlParser;->exception(Ljava/lang/String;)V

    :cond_e7
    add-int/lit8 v4, v4, -0x4

    goto :goto_b3

    :cond_ea
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    const-string v2, "Undefined Prefix: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v1, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v2, " in "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_109
    add-int/lit8 v1, v1, -0x4

    goto/16 :goto_83

    :cond_10d
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    const-string v2, "illegal attribute name: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v2, " at "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_12c
    iget-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->name:Ljava/lang/String;

    invoke-virtual {v1, v7}, Ljava/lang/String;->indexOf(I)I

    move-result v1

    if-nez v1, :cond_14b

    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    const-string v1, "illegal tag name: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lorg/kxml2/wap/WbxmlParser;->exception(Ljava/lang/String;)V

    goto :goto_15e

    :cond_14b
    if-eq v1, v6, :cond_15e

    iget-object v3, p0, Lorg/kxml2/wap/WbxmlParser;->name:Ljava/lang/String;

    invoke-virtual {v3, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->prefix:Ljava/lang/String;

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->name:Ljava/lang/String;

    add-int/2addr v1, v8

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->name:Ljava/lang/String;

    :cond_15e
    :goto_15e
    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->prefix:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lorg/kxml2/wap/WbxmlParser;->getNamespace(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->namespace:Ljava/lang/String;

    if-nez v0, :cond_184

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->prefix:Ljava/lang/String;

    if-eqz v0, :cond_182

    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    const-string v1, "undefined prefix: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->prefix:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lorg/kxml2/wap/WbxmlParser;->exception(Ljava/lang/String;)V

    :cond_182
    iput-object v5, p0, Lorg/kxml2/wap/WbxmlParser;->namespace:Ljava/lang/String;

    :cond_184
    return v2
.end method

.method private final ensureCapacity([Ljava/lang/String;I)[Ljava/lang/String;
    .registers 5

    array-length v0, p1

    if-lt v0, p2, :cond_4

    return-object p1

    :cond_4
    add-int/lit8 p2, p2, 0x10

    new-array p2, p2, [Ljava/lang/String;

    array-length v0, p1

    const/4 v1, 0x0

    invoke-static {p1, v1, p2, v1, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object p2
.end method

.method private final exception(Ljava/lang/String;)V
    .registers 4

    new-instance v0, Lorg/xmlpull/v1/XmlPullParserException;

    const/4 v1, 0x0

    invoke-direct {v0, p1, p0, v1}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/Throwable;)V

    throw v0
.end method

.method private final nextImpl()V
    .registers 5

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    const/4 v1, 0x3

    const/4 v2, 0x1

    if-ne v0, v1, :cond_b

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->depth:I

    sub-int/2addr v0, v2

    iput v0, p0, Lorg/kxml2/wap/WbxmlParser;->depth:I

    :cond_b
    iget-boolean v0, p0, Lorg/kxml2/wap/WbxmlParser;->degenerated:Z

    if-eqz v0, :cond_15

    iput v1, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/kxml2/wap/WbxmlParser;->degenerated:Z

    return-void

    :cond_15
    const/4 v0, 0x0

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->text:Ljava/lang/String;

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->prefix:Ljava/lang/String;

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->name:Ljava/lang/String;

    :goto_1c
    invoke-direct {p0}, Lorg/kxml2/wap/WbxmlParser;->peekId()I

    move-result v0

    const/4 v3, -0x2

    iput v3, p0, Lorg/kxml2/wap/WbxmlParser;->nextId:I

    if-nez v0, :cond_2d

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readByte()I

    move-result v0

    invoke-direct {p0, v0, v2}, Lorg/kxml2/wap/WbxmlParser;->selectPage(IZ)V

    goto :goto_1c

    :cond_2d
    const/4 v3, -0x1

    if-eq v0, v3, :cond_af

    const/4 v3, 0x2

    if-eq v0, v2, :cond_97

    if-eq v0, v3, :cond_6a

    const/4 v2, 0x4

    if-eq v0, v1, :cond_61

    packed-switch v0, :pswitch_data_b2

    packed-switch v0, :pswitch_data_be

    packed-switch v0, :pswitch_data_ca

    invoke-virtual {p0, v0}, Lorg/kxml2/wap/WbxmlParser;->parseElement(I)V

    goto :goto_b1

    :pswitch_45
    iput v2, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readStrT()Ljava/lang/String;

    move-result-object v0

    goto :goto_67

    :pswitch_4c
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "PI curr. not supp."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_54
    const/16 v1, 0x40

    iput v1, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    iput v0, p0, Lorg/kxml2/wap/WbxmlParser;->wapCode:I

    invoke-virtual {p0, v0}, Lorg/kxml2/wap/WbxmlParser;->parseWapExtension(I)Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->wapExtensionData:Ljava/lang/Object;

    goto :goto_b1

    :cond_61
    iput v2, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readStrI()Ljava/lang/String;

    move-result-object v0

    :goto_67
    iput-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->text:Ljava/lang/String;

    goto :goto_b1

    :cond_6a
    const/4 v0, 0x6

    iput v0, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readInt()I

    move-result v0

    int-to-char v0, v0

    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    const-string v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->text:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    const-string v2, "#"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_ac

    :cond_97
    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->depth:I

    sub-int/2addr v0, v2

    shl-int/2addr v0, v3

    iput v1, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->elementStack:[Ljava/lang/String;

    aget-object v2, v1, v0

    iput-object v2, p0, Lorg/kxml2/wap/WbxmlParser;->namespace:Ljava/lang/String;

    add-int/lit8 v2, v0, 0x1

    aget-object v2, v1, v2

    iput-object v2, p0, Lorg/kxml2/wap/WbxmlParser;->prefix:Ljava/lang/String;

    add-int/2addr v0, v3

    aget-object v0, v1, v0

    :goto_ac
    iput-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->name:Ljava/lang/String;

    goto :goto_b1

    :cond_af
    iput v2, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    :goto_b1
    return-void

    :pswitch_data_b2
    .packed-switch 0x40
        :pswitch_54
        :pswitch_54
        :pswitch_54
        :pswitch_4c
    .end packed-switch

    :pswitch_data_be
    .packed-switch 0x80
        :pswitch_54
        :pswitch_54
        :pswitch_54
        :pswitch_45
    .end packed-switch

    :pswitch_data_ca
    .packed-switch 0xc0
        :pswitch_54
        :pswitch_54
        :pswitch_54
        :pswitch_54
    .end packed-switch
.end method

.method private peekId()I
    .registers 3

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->nextId:I

    const/4 v1, -0x2

    if-ne v0, v1, :cond_d

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->in:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->read()I

    move-result v0

    iput v0, p0, Lorg/kxml2/wap/WbxmlParser;->nextId:I

    :cond_d
    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->nextId:I

    return v0
.end method

.method private selectPage(IZ)V
    .registers 6

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->tables:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->size()I

    move-result v0

    if-nez v0, :cond_b

    if-nez p1, :cond_b

    return-void

    :cond_b
    mul-int/lit8 v0, p1, 0x3

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->tables:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->size()I

    move-result v1

    if-le v0, v1, :cond_2e

    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    const-string v2, "Code Page "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    const-string p1, " undefined!"

    invoke-virtual {v1, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Lorg/kxml2/wap/WbxmlParser;->exception(Ljava/lang/String;)V

    :cond_2e
    iget-object p1, p0, Lorg/kxml2/wap/WbxmlParser;->tables:Ljava/util/Vector;

    if-eqz p2, :cond_3e

    iget p2, p0, Lorg/kxml2/wap/WbxmlParser;->TAG_TABLE:I

    add-int/2addr v0, p2

    invoke-virtual {p1, v0}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [Ljava/lang/String;

    iput-object p1, p0, Lorg/kxml2/wap/WbxmlParser;->tagTable:[Ljava/lang/String;

    goto :goto_56

    :cond_3e
    iget p2, p0, Lorg/kxml2/wap/WbxmlParser;->ATTR_START_TABLE:I

    add-int/2addr p2, v0

    invoke-virtual {p1, p2}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [Ljava/lang/String;

    iput-object p1, p0, Lorg/kxml2/wap/WbxmlParser;->attrStartTable:[Ljava/lang/String;

    iget-object p1, p0, Lorg/kxml2/wap/WbxmlParser;->tables:Ljava/util/Vector;

    iget p2, p0, Lorg/kxml2/wap/WbxmlParser;->ATTR_VALUE_TABLE:I

    add-int/2addr v0, p2

    invoke-virtual {p1, v0}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [Ljava/lang/String;

    iput-object p1, p0, Lorg/kxml2/wap/WbxmlParser;->attrValueTable:[Ljava/lang/String;

    :goto_56
    return-void
.end method

.method private final setTable(II[Ljava/lang/String;)V
    .registers 7

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->stringTable:[B

    if-nez v0, :cond_1e

    :goto_4
    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->tables:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->size()I

    move-result v0

    mul-int/lit8 v1, p1, 0x3

    add-int/lit8 v2, v1, 0x3

    if-ge v0, v2, :cond_17

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->tables:Ljava/util/Vector;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    goto :goto_4

    :cond_17
    iget-object p1, p0, Lorg/kxml2/wap/WbxmlParser;->tables:Ljava/util/Vector;

    add-int/2addr v1, p2

    invoke-virtual {p1, p3, v1}, Ljava/util/Vector;->setElementAt(Ljava/lang/Object;I)V

    return-void

    :cond_1e
    new-instance p1, Ljava/lang/RuntimeException;

    const-string p2, "setXxxTable must be called before setInput!"

    invoke-direct {p1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1
.end method


# virtual methods
.method public defineEntityReplacementText(Ljava/lang/String;Ljava/lang/String;)V
    .registers 3

    return-void
.end method

.method public getAttributeCount()I
    .registers 2

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->attributeCount:I

    return v0
.end method

.method public getAttributeName(I)Ljava/lang/String;
    .registers 3

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->attributeCount:I

    if-ge p1, v0, :cond_d

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    shl-int/lit8 p1, p1, 0x2

    add-int/lit8 p1, p1, 0x2

    aget-object p1, v0, p1

    return-object p1

    :cond_d
    new-instance p1, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {p1}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw p1
.end method

.method public getAttributeNamespace(I)Ljava/lang/String;
    .registers 3

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->attributeCount:I

    if-ge p1, v0, :cond_b

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    shl-int/lit8 p1, p1, 0x2

    aget-object p1, v0, p1

    return-object p1

    :cond_b
    new-instance p1, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {p1}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw p1
.end method

.method public getAttributePrefix(I)Ljava/lang/String;
    .registers 3

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->attributeCount:I

    if-ge p1, v0, :cond_d

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    shl-int/lit8 p1, p1, 0x2

    add-int/lit8 p1, p1, 0x1

    aget-object p1, v0, p1

    return-object p1

    :cond_d
    new-instance p1, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {p1}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw p1
.end method

.method public getAttributeType(I)Ljava/lang/String;
    .registers 2

    const-string p1, "CDATA"

    return-object p1
.end method

.method public getAttributeValue(I)Ljava/lang/String;
    .registers 3

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->attributeCount:I

    if-ge p1, v0, :cond_d

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    shl-int/lit8 p1, p1, 0x2

    add-int/lit8 p1, p1, 0x3

    aget-object p1, v0, p1

    return-object p1

    :cond_d
    new-instance p1, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {p1}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw p1
.end method

.method public getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 6

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->attributeCount:I

    shl-int/lit8 v0, v0, 0x2

    add-int/lit8 v0, v0, -0x4

    :goto_6
    if-ltz v0, :cond_2a

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    add-int/lit8 v2, v0, 0x2

    aget-object v1, v1, v2

    invoke-virtual {v1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_27

    if-eqz p1, :cond_20

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    aget-object v1, v1, v0

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_27

    :cond_20
    iget-object p1, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    add-int/lit8 v0, v0, 0x3

    aget-object p1, p1, v0

    return-object p1

    :cond_27
    add-int/lit8 v0, v0, -0x4

    goto :goto_6

    :cond_2a
    const/4 p1, 0x0

    return-object p1
.end method

.method public getColumnNumber()I
    .registers 2

    const/4 v0, -0x1

    return v0
.end method

.method public getDepth()I
    .registers 2

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->depth:I

    return v0
.end method

.method public getEventType()I
    .registers 2

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    return v0
.end method

.method public getFeature(Ljava/lang/String;)Z
    .registers 3

    const-string v0, "http://xmlpull.org/v1/doc/features.html#process-namespaces"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_b

    iget-boolean p1, p0, Lorg/kxml2/wap/WbxmlParser;->processNsp:Z

    return p1

    :cond_b
    const/4 p1, 0x0

    return p1
.end method

.method public getInputEncoding()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->encoding:Ljava/lang/String;

    return-object v0
.end method

.method public getLineNumber()I
    .registers 2

    const/4 v0, -0x1

    return v0
.end method

.method public getName()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getNamespace()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->namespace:Ljava/lang/String;

    return-object v0
.end method

.method public getNamespace(Ljava/lang/String;)Ljava/lang/String;
    .registers 5

    const-string v0, "xml"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    const-string p1, "http://www.w3.org/XML/1998/namespace"

    return-object p1

    :cond_b
    const-string v0, "xmlns"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_16

    const-string p1, "http://www.w3.org/2000/xmlns/"

    return-object p1

    :cond_16
    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->depth:I

    invoke-virtual {p0, v0}, Lorg/kxml2/wap/WbxmlParser;->getNamespaceCount(I)I

    move-result v0

    shl-int/lit8 v0, v0, 0x1

    add-int/lit8 v0, v0, -0x2

    :goto_20
    if-ltz v0, :cond_41

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->nspStack:[Ljava/lang/String;

    if-nez p1, :cond_2f

    aget-object v2, v1, v0

    if-nez v2, :cond_3e

    add-int/lit8 v0, v0, 0x1

    aget-object p1, v1, v0

    return-object p1

    :cond_2f
    aget-object v1, v1, v0

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3e

    iget-object p1, p0, Lorg/kxml2/wap/WbxmlParser;->nspStack:[Ljava/lang/String;

    add-int/lit8 v0, v0, 0x1

    aget-object p1, p1, v0

    return-object p1

    :cond_3e
    add-int/lit8 v0, v0, -0x2

    goto :goto_20

    :cond_41
    const/4 p1, 0x0

    return-object p1
.end method

.method public getNamespaceCount(I)I
    .registers 3

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->depth:I

    if-gt p1, v0, :cond_9

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->nspCounts:[I

    aget p1, v0, p1

    return p1

    :cond_9
    new-instance p1, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {p1}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw p1
.end method

.method public getNamespacePrefix(I)Ljava/lang/String;
    .registers 3

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->nspStack:[Ljava/lang/String;

    shl-int/lit8 p1, p1, 0x1

    aget-object p1, v0, p1

    return-object p1
.end method

.method public getNamespaceUri(I)Ljava/lang/String;
    .registers 3

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->nspStack:[Ljava/lang/String;

    shl-int/lit8 p1, p1, 0x1

    add-int/lit8 p1, p1, 0x1

    aget-object p1, v0, p1

    return-object p1
.end method

.method public getPositionDescription()Ljava/lang/String;
    .registers 11

    new-instance v0, Ljava/lang/StringBuffer;

    iget v1, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    sget-object v2, Lorg/xmlpull/v1/XmlPullParser;->TYPES:[Ljava/lang/String;

    array-length v3, v2

    if-ge v1, v3, :cond_c

    aget-object v1, v2, v1

    goto :goto_e

    :cond_c
    const-string v1, "unknown"

    :goto_e
    invoke-direct {v0, v1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    iget v2, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    const/4 v3, 0x0

    const/4 v4, 0x3

    const/4 v5, 0x2

    if-eq v2, v5, :cond_5a

    if-ne v2, v4, :cond_20

    goto :goto_5a

    :cond_20
    const/4 v1, 0x7

    if-ne v2, v1, :cond_25

    goto/16 :goto_102

    :cond_25
    const/4 v1, 0x4

    if-eq v2, v1, :cond_31

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->getText()Ljava/lang/String;

    move-result-object v1

    :cond_2c
    :goto_2c
    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_102

    :cond_31
    iget-boolean v1, p0, Lorg/kxml2/wap/WbxmlParser;->isWhitespace:Z

    if-eqz v1, :cond_38

    const-string v1, "(whitespace)"

    goto :goto_2c

    :cond_38
    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->getText()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    const/16 v4, 0x10

    if-le v2, v4, :cond_2c

    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v1, "..."

    invoke-virtual {v2, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_2c

    :cond_5a
    :goto_5a
    iget-boolean v2, p0, Lorg/kxml2/wap/WbxmlParser;->degenerated:Z

    if-eqz v2, :cond_63

    const-string v2, "(empty) "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    :cond_63
    const/16 v2, 0x3c

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    iget v2, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    if-ne v2, v4, :cond_71

    const/16 v2, 0x2f

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    :cond_71
    iget-object v2, p0, Lorg/kxml2/wap/WbxmlParser;->prefix:Ljava/lang/String;

    const-string v4, ":"

    const-string v6, "}"

    const-string v7, "{"

    if-eqz v2, :cond_9a

    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v2, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v8, p0, Lorg/kxml2/wap/WbxmlParser;->namespace:Ljava/lang/String;

    invoke-virtual {v2, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v2, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v8, p0, Lorg/kxml2/wap/WbxmlParser;->prefix:Ljava/lang/String;

    invoke-virtual {v2, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    :cond_9a
    iget-object v2, p0, Lorg/kxml2/wap/WbxmlParser;->name:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget v2, p0, Lorg/kxml2/wap/WbxmlParser;->attributeCount:I

    shl-int/2addr v2, v5

    :goto_a2
    if-ge v3, v2, :cond_fd

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    iget-object v5, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    add-int/lit8 v8, v3, 0x1

    aget-object v5, v5, v8

    if-eqz v5, :cond_d2

    new-instance v5, Ljava/lang/StringBuffer;

    invoke-direct {v5}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v5, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v9, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    aget-object v9, v9, v3

    invoke-virtual {v5, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v9, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    aget-object v8, v9, v8

    invoke-virtual {v5, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v5, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    :cond_d2
    new-instance v5, Ljava/lang/StringBuffer;

    invoke-direct {v5}, Ljava/lang/StringBuffer;-><init>()V

    iget-object v8, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    add-int/lit8 v9, v3, 0x2

    aget-object v8, v8, v9

    invoke-virtual {v5, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v8, "=\'"

    invoke-virtual {v5, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v8, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    add-int/lit8 v9, v3, 0x3

    aget-object v8, v8, v9

    invoke-virtual {v5, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v8, "\'"

    invoke-virtual {v5, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    add-int/lit8 v3, v3, 0x4

    goto :goto_a2

    :cond_fd
    const/16 v1, 0x3e

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    :goto_102
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPrefix()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->prefix:Ljava/lang/String;

    return-object v0
.end method

.method public getProperty(Ljava/lang/String;)Ljava/lang/Object;
    .registers 2

    const/4 p1, 0x0

    return-object p1
.end method

.method public getText()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->text:Ljava/lang/String;

    return-object v0
.end method

.method public getTextCharacters([I)[C
    .registers 6

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    const/4 v1, 0x1

    const/4 v2, 0x0

    const/4 v3, 0x4

    if-lt v0, v3, :cond_23

    aput v2, p1, v2

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->text:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    aput v0, p1, v1

    iget-object p1, p0, Lorg/kxml2/wap/WbxmlParser;->text:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result p1

    new-array p1, p1, [C

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->text:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {v0, v2, v1, p1, v2}, Ljava/lang/String;->getChars(II[CI)V

    return-object p1

    :cond_23
    const/4 v0, -0x1

    aput v0, p1, v2

    aput v0, p1, v1

    const/4 p1, 0x0

    return-object p1
.end method

.method public getWapCode()I
    .registers 2

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->wapCode:I

    return v0
.end method

.method public getWapExtensionData()Ljava/lang/Object;
    .registers 2

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->wapExtensionData:Ljava/lang/Object;

    return-object v0
.end method

.method public isAttributeDefault(I)Z
    .registers 2

    const/4 p1, 0x0

    return p1
.end method

.method public isEmptyElementTag()Z
    .registers 3

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    const/4 v1, 0x2

    if-eq v0, v1, :cond_a

    const-string v0, "Wrong event type"

    invoke-direct {p0, v0}, Lorg/kxml2/wap/WbxmlParser;->exception(Ljava/lang/String;)V

    :cond_a
    iget-boolean v0, p0, Lorg/kxml2/wap/WbxmlParser;->degenerated:Z

    return v0
.end method

.method public isWhitespace()Z
    .registers 3

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    const/4 v1, 0x4

    if-eq v0, v1, :cond_10

    const/4 v1, 0x7

    if-eq v0, v1, :cond_10

    const/4 v1, 0x5

    if-eq v0, v1, :cond_10

    const-string v0, "Wrong event type"

    invoke-direct {p0, v0}, Lorg/kxml2/wap/WbxmlParser;->exception(Ljava/lang/String;)V

    :cond_10
    iget-boolean v0, p0, Lorg/kxml2/wap/WbxmlParser;->isWhitespace:Z

    return v0
.end method

.method public next()I
    .registers 5

    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/kxml2/wap/WbxmlParser;->isWhitespace:Z

    const/16 v0, 0x270f

    :cond_5
    :goto_5
    iget-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->text:Ljava/lang/String;

    invoke-direct {p0}, Lorg/kxml2/wap/WbxmlParser;->nextImpl()V

    iget v2, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    if-ge v2, v0, :cond_f

    move v0, v2

    :cond_f
    const/4 v2, 0x5

    if-le v0, v2, :cond_13

    goto :goto_5

    :cond_13
    const/4 v2, 0x4

    if-lt v0, v2, :cond_4c

    if-eqz v1, :cond_30

    iget-object v3, p0, Lorg/kxml2/wap/WbxmlParser;->text:Ljava/lang/String;

    if-nez v3, :cond_1d

    goto :goto_2e

    :cond_1d
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->text:Ljava/lang/String;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_2e
    iput-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->text:Ljava/lang/String;

    :cond_30
    invoke-direct {p0}, Lorg/kxml2/wap/WbxmlParser;->peekId()I

    move-result v1

    const/4 v3, 0x2

    if-eq v1, v3, :cond_5

    const/4 v3, 0x3

    if-eq v1, v3, :cond_5

    if-eq v1, v2, :cond_5

    const/16 v3, 0x44

    if-eq v1, v3, :cond_5

    const/16 v3, 0xc4

    if-eq v1, v3, :cond_5

    const/16 v3, 0x83

    if-eq v1, v3, :cond_5

    const/16 v3, 0x84

    if-eq v1, v3, :cond_5

    :cond_4c
    iput v0, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    if-le v0, v2, :cond_52

    iput v2, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    :cond_52
    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    return v0
.end method

.method public nextTag()I
    .registers 3

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->next()I

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    const/4 v1, 0x4

    if-ne v0, v1, :cond_f

    iget-boolean v0, p0, Lorg/kxml2/wap/WbxmlParser;->isWhitespace:Z

    if-eqz v0, :cond_f

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->next()I

    :cond_f
    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    const/4 v1, 0x3

    if-eq v0, v1, :cond_1c

    const/4 v1, 0x2

    if-eq v0, v1, :cond_1c

    const-string v0, "unexpected type"

    invoke-direct {p0, v0}, Lorg/kxml2/wap/WbxmlParser;->exception(Ljava/lang/String;)V

    :cond_1c
    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    return v0
.end method

.method public nextText()Ljava/lang/String;
    .registers 4

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    const/4 v1, 0x2

    if-eq v0, v1, :cond_a

    const-string v0, "precondition: START_TAG"

    invoke-direct {p0, v0}, Lorg/kxml2/wap/WbxmlParser;->exception(Ljava/lang/String;)V

    :cond_a
    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->next()I

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    const/4 v1, 0x4

    if-ne v0, v1, :cond_1a

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->getText()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->next()I

    goto :goto_1c

    :cond_1a
    const-string v0, ""

    :goto_1c
    iget v1, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    const/4 v2, 0x3

    if-eq v1, v2, :cond_26

    const-string v1, "END_TAG expected"

    invoke-direct {p0, v1}, Lorg/kxml2/wap/WbxmlParser;->exception(Ljava/lang/String;)V

    :cond_26
    return-object v0
.end method

.method public nextToken()I
    .registers 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/kxml2/wap/WbxmlParser;->isWhitespace:Z

    invoke-direct {p0}, Lorg/kxml2/wap/WbxmlParser;->nextImpl()V

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    return v0
.end method

.method parseElement(I)V
    .registers 8

    const/4 v0, 0x2

    iput v0, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->tagTable:[Ljava/lang/String;

    and-int/lit8 v2, p1, 0x3f

    invoke-virtual {p0, v1, v2}, Lorg/kxml2/wap/WbxmlParser;->resolveId([Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->name:Ljava/lang/String;

    const/4 v1, 0x0

    iput v1, p0, Lorg/kxml2/wap/WbxmlParser;->attributeCount:I

    and-int/lit16 v2, p1, 0x80

    if-eqz v2, :cond_17

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readAttr()V

    :cond_17
    and-int/lit8 p1, p1, 0x40

    const/4 v2, 0x1

    if-nez p1, :cond_1e

    const/4 p1, 0x1

    goto :goto_1f

    :cond_1e
    const/4 p1, 0x0

    :goto_1f
    iput-boolean p1, p0, Lorg/kxml2/wap/WbxmlParser;->degenerated:Z

    iget p1, p0, Lorg/kxml2/wap/WbxmlParser;->depth:I

    add-int/lit8 v3, p1, 0x1

    iput v3, p0, Lorg/kxml2/wap/WbxmlParser;->depth:I

    shl-int/2addr p1, v0

    iget-object v3, p0, Lorg/kxml2/wap/WbxmlParser;->elementStack:[Ljava/lang/String;

    add-int/lit8 v4, p1, 0x4

    invoke-direct {p0, v3, v4}, Lorg/kxml2/wap/WbxmlParser;->ensureCapacity([Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lorg/kxml2/wap/WbxmlParser;->elementStack:[Ljava/lang/String;

    add-int/lit8 v4, p1, 0x3

    iget-object v5, p0, Lorg/kxml2/wap/WbxmlParser;->name:Ljava/lang/String;

    aput-object v5, v3, v4

    iget v3, p0, Lorg/kxml2/wap/WbxmlParser;->depth:I

    iget-object v4, p0, Lorg/kxml2/wap/WbxmlParser;->nspCounts:[I

    array-length v5, v4

    if-lt v3, v5, :cond_49

    add-int/lit8 v3, v3, 0x4

    new-array v3, v3, [I

    array-length v5, v4

    invoke-static {v4, v1, v3, v1, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iput-object v3, p0, Lorg/kxml2/wap/WbxmlParser;->nspCounts:[I

    :cond_49
    iget-object v3, p0, Lorg/kxml2/wap/WbxmlParser;->nspCounts:[I

    iget v4, p0, Lorg/kxml2/wap/WbxmlParser;->depth:I

    add-int/lit8 v5, v4, -0x1

    aget v5, v3, v5

    aput v5, v3, v4

    iget v3, p0, Lorg/kxml2/wap/WbxmlParser;->attributeCount:I

    sub-int/2addr v3, v2

    :goto_56
    if-lez v3, :cond_87

    const/4 v2, 0x0

    :goto_59
    if-ge v2, v3, :cond_84

    invoke-virtual {p0, v3}, Lorg/kxml2/wap/WbxmlParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v2}, Lorg/kxml2/wap/WbxmlParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_81

    new-instance v4, Ljava/lang/StringBuffer;

    invoke-direct {v4}, Ljava/lang/StringBuffer;-><init>()V

    const-string v5, "Duplicate Attribute: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {p0, v3}, Lorg/kxml2/wap/WbxmlParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v4}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v4}, Lorg/kxml2/wap/WbxmlParser;->exception(Ljava/lang/String;)V

    :cond_81
    add-int/lit8 v2, v2, 0x1

    goto :goto_59

    :cond_84
    add-int/lit8 v3, v3, -0x1

    goto :goto_56

    :cond_87
    iget-boolean v1, p0, Lorg/kxml2/wap/WbxmlParser;->processNsp:Z

    if-eqz v1, :cond_8f

    invoke-direct {p0}, Lorg/kxml2/wap/WbxmlParser;->adjustNsp()Z

    goto :goto_93

    :cond_8f
    const-string v1, ""

    iput-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->namespace:Ljava/lang/String;

    :goto_93
    iget-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->elementStack:[Ljava/lang/String;

    iget-object v2, p0, Lorg/kxml2/wap/WbxmlParser;->namespace:Ljava/lang/String;

    aput-object v2, v1, p1

    add-int/lit8 v2, p1, 0x1

    iget-object v3, p0, Lorg/kxml2/wap/WbxmlParser;->prefix:Ljava/lang/String;

    aput-object v3, v1, v2

    add-int/2addr p1, v0

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->name:Ljava/lang/String;

    aput-object v0, v1, p1

    return-void
.end method

.method public parseWapExtension(I)Ljava/lang/Object;
    .registers 6

    packed-switch p1, :pswitch_data_42

    packed-switch p1, :pswitch_data_4c

    const/4 v0, 0x0

    packed-switch p1, :pswitch_data_56

    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    const-string v2, "illegal id: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Lorg/kxml2/wap/WbxmlParser;->exception(Ljava/lang/String;)V

    return-object v0

    :pswitch_1f
    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readInt()I

    move-result p1

    new-array v0, p1, [B

    move v1, p1

    :goto_26
    if-lez v1, :cond_32

    iget-object v2, p0, Lorg/kxml2/wap/WbxmlParser;->in:Ljava/io/InputStream;

    sub-int v3, p1, v1

    invoke-virtual {v2, v0, v3, v1}, Ljava/io/InputStream;->read([BII)I

    move-result v2

    sub-int/2addr v1, v2

    goto :goto_26

    :cond_32
    :pswitch_32
    return-object v0

    :pswitch_33
    new-instance p1, Ljava/lang/Integer;

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readInt()I

    move-result v0

    invoke-direct {p1, v0}, Ljava/lang/Integer;-><init>(I)V

    return-object p1

    :pswitch_3d
    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readStrI()Ljava/lang/String;

    move-result-object p1

    return-object p1

    :pswitch_data_42
    .packed-switch 0x40
        :pswitch_3d
        :pswitch_3d
        :pswitch_3d
    .end packed-switch

    :pswitch_data_4c
    .packed-switch 0x80
        :pswitch_33
        :pswitch_33
        :pswitch_33
    .end packed-switch

    :pswitch_data_56
    .packed-switch 0xc0
        :pswitch_32
        :pswitch_32
        :pswitch_32
        :pswitch_1f
    .end packed-switch
.end method

.method public readAttr()V
    .registers 11

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readByte()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_6
    const/4 v3, 0x1

    if-eq v0, v3, :cond_c7

    :goto_9
    if-nez v0, :cond_17

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readByte()I

    move-result v0

    invoke-direct {p0, v0, v1}, Lorg/kxml2/wap/WbxmlParser;->selectPage(IZ)V

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readByte()I

    move-result v0

    goto :goto_9

    :cond_17
    iget-object v4, p0, Lorg/kxml2/wap/WbxmlParser;->attrStartTable:[Ljava/lang/String;

    invoke-virtual {p0, v4, v0}, Lorg/kxml2/wap/WbxmlParser;->resolveId([Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    const/16 v4, 0x3d

    invoke-virtual {v0, v4}, Ljava/lang/String;->indexOf(I)I

    move-result v4

    const/4 v5, -0x1

    if-ne v4, v5, :cond_2c

    new-instance v4, Ljava/lang/StringBuffer;

    invoke-direct {v4}, Ljava/lang/StringBuffer;-><init>()V

    goto :goto_3c

    :cond_2c
    new-instance v5, Ljava/lang/StringBuffer;

    add-int/lit8 v6, v4, 0x1

    invoke-virtual {v0, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    move-object v4, v5

    :goto_3c
    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readByte()I

    move-result v5

    const/4 v6, 0x3

    const/4 v7, 0x2

    const/16 v8, 0x80

    if-gt v5, v8, :cond_88

    if-eqz v5, :cond_88

    if-eq v5, v7, :cond_88

    if-eq v5, v6, :cond_88

    const/16 v9, 0x83

    if-eq v5, v9, :cond_88

    const/16 v9, 0x40

    if-lt v5, v9, :cond_58

    const/16 v9, 0x42

    if-le v5, v9, :cond_88

    :cond_58
    if-lt v5, v8, :cond_5f

    const/16 v8, 0x82

    if-gt v5, v8, :cond_5f

    goto :goto_88

    :cond_5f
    iget-object v6, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    add-int/lit8 v7, v2, 0x4

    invoke-direct {p0, v6, v7}, Lorg/kxml2/wap/WbxmlParser;->ensureCapacity([Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lorg/kxml2/wap/WbxmlParser;->attributes:[Ljava/lang/String;

    add-int/lit8 v7, v2, 0x1

    const-string v8, ""

    aput-object v8, v6, v2

    add-int/lit8 v2, v7, 0x1

    const/4 v8, 0x0

    aput-object v8, v6, v7

    add-int/lit8 v7, v2, 0x1

    aput-object v0, v6, v2

    add-int/lit8 v2, v7, 0x1

    invoke-virtual {v4}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v6, v7

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->attributeCount:I

    add-int/2addr v0, v3

    iput v0, p0, Lorg/kxml2/wap/WbxmlParser;->attributeCount:I

    move v0, v5

    goto/16 :goto_6

    :cond_88
    :goto_88
    if-eqz v5, :cond_be

    if-eq v5, v7, :cond_b4

    if-eq v5, v6, :cond_ac

    packed-switch v5, :pswitch_data_c8

    packed-switch v5, :pswitch_data_d2

    packed-switch v5, :pswitch_data_de

    iget-object v6, p0, Lorg/kxml2/wap/WbxmlParser;->attrValueTable:[Ljava/lang/String;

    invoke-virtual {p0, v6, v5}, Lorg/kxml2/wap/WbxmlParser;->resolveId([Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    goto :goto_b0

    :pswitch_9e
    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readStrT()Ljava/lang/String;

    move-result-object v5

    goto :goto_b0

    :pswitch_a3
    invoke-virtual {p0, v5}, Lorg/kxml2/wap/WbxmlParser;->parseWapExtension(I)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {p0, v5, v6}, Lorg/kxml2/wap/WbxmlParser;->resolveWapExtension(ILjava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    goto :goto_b0

    :cond_ac
    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readStrI()Ljava/lang/String;

    move-result-object v5

    :goto_b0
    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_3c

    :cond_b4
    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readInt()I

    move-result v5

    int-to-char v5, v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto/16 :goto_3c

    :cond_be
    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readByte()I

    move-result v5

    invoke-direct {p0, v5, v1}, Lorg/kxml2/wap/WbxmlParser;->selectPage(IZ)V

    goto/16 :goto_3c

    :cond_c7
    return-void

    :pswitch_data_c8
    .packed-switch 0x40
        :pswitch_a3
        :pswitch_a3
        :pswitch_a3
    .end packed-switch

    :pswitch_data_d2
    .packed-switch 0x80
        :pswitch_a3
        :pswitch_a3
        :pswitch_a3
        :pswitch_9e
    .end packed-switch

    :pswitch_data_de
    .packed-switch 0xc0
        :pswitch_a3
        :pswitch_a3
        :pswitch_a3
        :pswitch_a3
    .end packed-switch
.end method

.method readByte()I
    .registers 3

    iget-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->in:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->read()I

    move-result v0

    const/4 v1, -0x1

    if-eq v0, v1, :cond_a

    return v0

    :cond_a
    new-instance v0, Ljava/io/IOException;

    const-string v1, "Unexpected EOF"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method readInt()I
    .registers 4

    const/4 v0, 0x0

    :cond_1
    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readByte()I

    move-result v1

    shl-int/lit8 v0, v0, 0x7

    and-int/lit8 v2, v1, 0x7f

    or-int/2addr v0, v2

    and-int/lit16 v1, v1, 0x80

    if-nez v1, :cond_1

    return v0
.end method

.method readStrI()Ljava/lang/String;
    .registers 5

    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    const/4 v1, 0x1

    :goto_6
    iget-object v2, p0, Lorg/kxml2/wap/WbxmlParser;->in:Ljava/io/InputStream;

    invoke-virtual {v2}, Ljava/io/InputStream;->read()I

    move-result v2

    if-nez v2, :cond_1f

    iput-boolean v1, p0, Lorg/kxml2/wap/WbxmlParser;->isWhitespace:Z

    new-instance v1, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v2

    iget-object v3, p0, Lorg/kxml2/wap/WbxmlParser;->encoding:Ljava/lang/String;

    invoke-direct {v1, v2, v3}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->close()V

    return-object v1

    :cond_1f
    const/4 v3, -0x1

    if-eq v2, v3, :cond_2b

    const/16 v3, 0x20

    if-le v2, v3, :cond_27

    const/4 v1, 0x0

    :cond_27
    invoke-virtual {v0, v2}, Ljava/io/ByteArrayOutputStream;->write(I)V

    goto :goto_6

    :cond_2b
    new-instance v0, Ljava/io/IOException;

    const-string v1, "Unexpected EOF"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method readStrT()Ljava/lang/String;
    .registers 6

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readInt()I

    move-result v0

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->cacheStringTable:Ljava/util/Hashtable;

    if-nez v1, :cond_f

    new-instance v1, Ljava/util/Hashtable;

    invoke-direct {v1}, Ljava/util/Hashtable;-><init>()V

    iput-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->cacheStringTable:Ljava/util/Hashtable;

    :cond_f
    iget-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->cacheStringTable:Ljava/util/Hashtable;

    new-instance v2, Ljava/lang/Integer;

    invoke-direct {v2, v0}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v1, v2}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    if-nez v1, :cond_3e

    move v1, v0

    :goto_1f
    iget-object v2, p0, Lorg/kxml2/wap/WbxmlParser;->stringTable:[B

    array-length v3, v2

    if-ge v1, v3, :cond_2b

    aget-byte v3, v2, v1

    if-eqz v3, :cond_2b

    add-int/lit8 v1, v1, 0x1

    goto :goto_1f

    :cond_2b
    new-instance v3, Ljava/lang/String;

    sub-int/2addr v1, v0

    iget-object v4, p0, Lorg/kxml2/wap/WbxmlParser;->encoding:Ljava/lang/String;

    invoke-direct {v3, v2, v0, v1, v4}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V

    iget-object v1, p0, Lorg/kxml2/wap/WbxmlParser;->cacheStringTable:Ljava/util/Hashtable;

    new-instance v2, Ljava/lang/Integer;

    invoke-direct {v2, v0}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v1, v2, v3}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v1, v3

    :cond_3e
    return-object v1
.end method

.method public require(ILjava/lang/String;Ljava/lang/String;)V
    .registers 7

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->type:I

    if-ne p1, v0, :cond_1c

    if-eqz p2, :cond_10

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->getNamespace()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1c

    :cond_10
    if-eqz p3, :cond_57

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_57

    :cond_1c
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    const-string v1, "expected: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const/16 v1, 0x40

    if-ne p1, v1, :cond_2d

    const-string p1, "WAP Ext."

    goto :goto_4d

    :cond_2d
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    sget-object v2, Lorg/xmlpull/v1/XmlPullParser;->TYPES:[Ljava/lang/String;

    aget-object p1, v2, p1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string p1, " {"

    invoke-virtual {v1, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v1, p2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string p1, "}"

    invoke-virtual {v1, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v1, p3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p1

    :goto_4d
    invoke-virtual {v0, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Lorg/kxml2/wap/WbxmlParser;->exception(Ljava/lang/String;)V

    :cond_57
    return-void
.end method

.method resolveId([Ljava/lang/String;I)Ljava/lang/String;
    .registers 5

    and-int/lit8 v0, p2, 0x7f

    add-int/lit8 v0, v0, -0x5

    const/4 v1, -0x1

    if-ne v0, v1, :cond_e

    iput v1, p0, Lorg/kxml2/wap/WbxmlParser;->wapCode:I

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readStrT()Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_e
    if-ltz v0, :cond_1e

    if-eqz p1, :cond_1e

    array-length v1, p1

    if-ge v0, v1, :cond_1e

    aget-object p1, p1, v0

    if-eqz p1, :cond_1e

    add-int/lit8 v0, v0, 0x5

    iput v0, p0, Lorg/kxml2/wap/WbxmlParser;->wapCode:I

    return-object p1

    :cond_1e
    new-instance p1, Ljava/io/IOException;

    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    const-string v1, "id "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    const-string p2, " undef."

    invoke-virtual {v0, p2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method protected resolveWapExtension(ILjava/lang/Object;)Ljava/lang/String;
    .registers 6

    instance-of p1, p2, [B

    if-eqz p1, :cond_31

    new-instance p1, Ljava/lang/StringBuffer;

    invoke-direct {p1}, Ljava/lang/StringBuffer;-><init>()V

    check-cast p2, [B

    const/4 v0, 0x0

    :goto_c
    array-length v1, p2

    if-ge v0, v1, :cond_2c

    aget-byte v1, p2, v0

    shr-int/lit8 v1, v1, 0x4

    and-int/lit8 v1, v1, 0xf

    const-string v2, "0123456789abcdef"

    invoke-virtual {v2, v1}, Ljava/lang/String;->charAt(I)C

    move-result v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    aget-byte v1, p2, v0

    and-int/lit8 v1, v1, 0xf

    invoke-virtual {v2, v1}, Ljava/lang/String;->charAt(I)C

    move-result v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    add-int/lit8 v0, v0, 0x1

    goto :goto_c

    :cond_2c
    invoke-virtual {p1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_31
    new-instance p1, Ljava/lang/StringBuffer;

    invoke-direct {p1}, Ljava/lang/StringBuffer;-><init>()V

    const-string v0, "$("

    invoke-virtual {p1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {p1, p2}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    const-string p2, ")"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {p1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method public setAttrStartTable(I[Ljava/lang/String;)V
    .registers 4

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->ATTR_START_TABLE:I

    invoke-direct {p0, p1, v0, p2}, Lorg/kxml2/wap/WbxmlParser;->setTable(II[Ljava/lang/String;)V

    return-void
.end method

.method public setAttrValueTable(I[Ljava/lang/String;)V
    .registers 4

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->ATTR_VALUE_TABLE:I

    invoke-direct {p0, p1, v0, p2}, Lorg/kxml2/wap/WbxmlParser;->setTable(II[Ljava/lang/String;)V

    return-void
.end method

.method public setFeature(Ljava/lang/String;Z)V
    .registers 4

    const-string v0, "http://xmlpull.org/v1/doc/features.html#process-namespaces"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    iput-boolean p2, p0, Lorg/kxml2/wap/WbxmlParser;->processNsp:Z

    goto :goto_1f

    :cond_b
    new-instance p2, Ljava/lang/StringBuffer;

    invoke-direct {p2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v0, "unsupported feature: "

    invoke-virtual {p2, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {p2, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {p2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Lorg/kxml2/wap/WbxmlParser;->exception(Ljava/lang/String;)V

    :goto_1f
    return-void
.end method

.method public setInput(Ljava/io/InputStream;Ljava/lang/String;)V
    .registers 7

    iput-object p1, p0, Lorg/kxml2/wap/WbxmlParser;->in:Ljava/io/InputStream;

    :try_start_2
    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readByte()I

    move-result v0

    iput v0, p0, Lorg/kxml2/wap/WbxmlParser;->version:I

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readInt()I

    move-result v0

    iput v0, p0, Lorg/kxml2/wap/WbxmlParser;->publicIdentifierId:I

    if-nez v0, :cond_13

    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readInt()I

    :cond_13
    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readInt()I

    move-result v0

    if-nez p2, :cond_22

    const/4 p2, 0x4

    if-eq v0, p2, :cond_3c

    const/16 p2, 0x6a

    if-ne v0, p2, :cond_25

    const-string p2, "UTF-8"

    :cond_22
    :goto_22
    iput-object p2, p0, Lorg/kxml2/wap/WbxmlParser;->encoding:Ljava/lang/String;

    goto :goto_3f

    :cond_25
    new-instance p1, Ljava/io/UnsupportedEncodingException;

    new-instance p2, Ljava/lang/StringBuffer;

    invoke-direct {p2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v1, ""

    invoke-virtual {p2, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {p2, v0}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    invoke-virtual {p2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/io/UnsupportedEncodingException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_3c
    const-string p2, "ISO-8859-1"

    goto :goto_22

    :goto_3f
    invoke-virtual {p0}, Lorg/kxml2/wap/WbxmlParser;->readInt()I

    move-result p2

    new-array v0, p2, [B

    iput-object v0, p0, Lorg/kxml2/wap/WbxmlParser;->stringTable:[B

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_49
    if-ge v1, p2, :cond_58

    iget-object v2, p0, Lorg/kxml2/wap/WbxmlParser;->stringTable:[B

    sub-int v3, p2, v1

    invoke-virtual {p1, v2, v1, v3}, Ljava/io/InputStream;->read([BII)I

    move-result v2

    if-gtz v2, :cond_56

    goto :goto_58

    :cond_56
    add-int/2addr v1, v2

    goto :goto_49

    :cond_58
    :goto_58
    const/4 p1, 0x1

    invoke-direct {p0, v0, p1}, Lorg/kxml2/wap/WbxmlParser;->selectPage(IZ)V

    invoke-direct {p0, v0, v0}, Lorg/kxml2/wap/WbxmlParser;->selectPage(IZ)V
    :try_end_5f
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_5f} :catch_60

    goto :goto_65

    :catch_60
    const-string p1, "Illegal input format"

    invoke-direct {p0, p1}, Lorg/kxml2/wap/WbxmlParser;->exception(Ljava/lang/String;)V

    :goto_65
    return-void
.end method

.method public setInput(Ljava/io/Reader;)V
    .registers 2

    const-string p1, "InputStream required"

    invoke-direct {p0, p1}, Lorg/kxml2/wap/WbxmlParser;->exception(Ljava/lang/String;)V

    return-void
.end method

.method public setProperty(Ljava/lang/String;Ljava/lang/Object;)V
    .registers 5

    new-instance p2, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    const-string v1, "unsupported property: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw p2
.end method

.method public setTagTable(I[Ljava/lang/String;)V
    .registers 4

    iget v0, p0, Lorg/kxml2/wap/WbxmlParser;->TAG_TABLE:I

    invoke-direct {p0, p1, v0, p2}, Lorg/kxml2/wap/WbxmlParser;->setTable(II[Ljava/lang/String;)V

    return-void
.end method
