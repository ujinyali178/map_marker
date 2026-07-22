.class Lc0/k$f;
.super Lorg/xml/sax/ext/DefaultHandler2;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/k;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "f"
.end annotation


# instance fields
.field final synthetic a:Lc0/k;


# direct methods
.method private constructor <init>(Lc0/k;)V
    .registers 2

    iput-object p1, p0, Lc0/k$f;->a:Lc0/k;

    invoke-direct {p0}, Lorg/xml/sax/ext/DefaultHandler2;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lc0/k;Lc0/k$a;)V
    .registers 3

    invoke-direct {p0, p1}, Lc0/k$f;-><init>(Lc0/k;)V

    return-void
.end method


# virtual methods
.method public characters([CII)V
    .registers 6

    iget-object v0, p0, Lc0/k$f;->a:Lc0/k;

    new-instance v1, Ljava/lang/String;

    invoke-direct {v1, p1, p2, p3}, Ljava/lang/String;-><init>([CII)V

    invoke-static {v0, v1}, Lc0/k;->c(Lc0/k;Ljava/lang/String;)V

    return-void
.end method

.method public endDocument()V
    .registers 2

    iget-object v0, p0, Lc0/k$f;->a:Lc0/k;

    invoke-static {v0}, Lc0/k;->e(Lc0/k;)V

    return-void
.end method

.method public endElement(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 5

    iget-object v0, p0, Lc0/k$f;->a:Lc0/k;

    invoke-static {v0, p1, p2, p3}, Lc0/k;->d(Lc0/k;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public processingInstruction(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4

    new-instance v0, Lc0/k$i;

    invoke-direct {v0, p2}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    iget-object p2, p0, Lc0/k$f;->a:Lc0/k;

    invoke-static {p2, v0}, Lc0/k;->f(Lc0/k;Lc0/k$i;)Ljava/util/Map;

    move-result-object p2

    iget-object v0, p0, Lc0/k$f;->a:Lc0/k;

    invoke-static {v0, p1, p2}, Lc0/k;->g(Lc0/k;Ljava/lang/String;Ljava/util/Map;)V

    return-void
.end method

.method public startDocument()V
    .registers 2

    iget-object v0, p0, Lc0/k$f;->a:Lc0/k;

    invoke-static {v0}, Lc0/k;->a(Lc0/k;)V

    return-void
.end method

.method public startElement(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/xml/sax/Attributes;)V
    .registers 6

    iget-object v0, p0, Lc0/k$f;->a:Lc0/k;

    invoke-static {v0, p1, p2, p3, p4}, Lc0/k;->b(Lc0/k;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/xml/sax/Attributes;)V

    return-void
.end method
