.class public Lorg/apache/commons/io/input/InfiniteCircularInputStream;
.super Ljava/io/InputStream;
.source "SourceFile"


# instance fields
.field private position:I

.field private final repeatedContent:[B


# direct methods
.method public constructor <init>([B)V
    .registers 3

    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    const/4 v0, -0x1

    iput v0, p0, Lorg/apache/commons/io/input/InfiniteCircularInputStream;->position:I

    iput-object p1, p0, Lorg/apache/commons/io/input/InfiniteCircularInputStream;->repeatedContent:[B

    return-void
.end method


# virtual methods
.method public read()I
    .registers 4

    iget v0, p0, Lorg/apache/commons/io/input/InfiniteCircularInputStream;->position:I

    add-int/lit8 v0, v0, 0x1

    iget-object v1, p0, Lorg/apache/commons/io/input/InfiniteCircularInputStream;->repeatedContent:[B

    array-length v2, v1

    rem-int/2addr v0, v2

    iput v0, p0, Lorg/apache/commons/io/input/InfiniteCircularInputStream;->position:I

    aget-byte v0, v1, v0

    and-int/lit16 v0, v0, 0xff

    return v0
.end method
