.class Lc0/k;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lc0/k$i;,
        Lc0/k$f;,
        Lc0/k$j;,
        Lc0/k$b;,
        Lc0/k$e;,
        Lc0/k$d;,
        Lc0/k$c;,
        Lc0/k$g;,
        Lc0/k$h;
    }
.end annotation


# instance fields
.field private a:Lc0/g;

.field private b:Lc0/g$j0;

.field private c:Z

.field private d:I

.field private e:Z

.field private f:Lc0/k$h;

.field private g:Ljava/lang/StringBuilder;

.field private h:Z

.field private i:Ljava/lang/StringBuilder;


# direct methods
.method constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lc0/k;->a:Lc0/g;

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    const/4 v1, 0x0

    iput-boolean v1, p0, Lc0/k;->c:Z

    iput-boolean v1, p0, Lc0/k;->e:Z

    iput-object v0, p0, Lc0/k;->f:Lc0/k$h;

    iput-object v0, p0, Lc0/k;->g:Ljava/lang/StringBuilder;

    iput-boolean v1, p0, Lc0/k;->h:Z

    iput-object v0, p0, Lc0/k;->i:Ljava/lang/StringBuilder;

    return-void
.end method

.method private A(Lc0/g$d;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_48

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_4a

    goto :goto_45

    :pswitch_23
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$d;->q:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_30

    goto :goto_45

    :cond_30
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <circle> element. r cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :pswitch_38
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$d;->p:Lc0/g$p;

    goto :goto_45

    :pswitch_3f
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$d;->o:Lc0/g$p;

    :goto_45
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_48
    return-void

    nop

    :pswitch_data_4a
    .packed-switch 0xc
        :pswitch_3f
        :pswitch_38
        :pswitch_23
    .end packed-switch
.end method

.method private static A0(Ljava/lang/String;)Ljava/util/Set;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    new-instance v0, Lc0/k$i;

    invoke-direct {v0, p0}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    new-instance p0, Ljava/util/HashSet;

    invoke-direct {p0}, Ljava/util/HashSet;-><init>()V

    :goto_a
    invoke-virtual {v0}, Lc0/k$i;->h()Z

    move-result v1

    if-nez v1, :cond_1b

    invoke-virtual {v0}, Lc0/k$i;->r()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    invoke-virtual {v0}, Lc0/k$i;->A()V

    goto :goto_a

    :cond_1b
    return-object p0
.end method

.method private B(Lc0/g$e;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_47

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    const/16 v3, 0x26

    if-eq v2, v3, :cond_24

    goto :goto_3c

    :cond_24
    const-string v2, "objectBoundingBox"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_31

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    :goto_2e
    iput-object v1, p1, Lc0/g$e;->p:Ljava/lang/Boolean;

    goto :goto_3c

    :cond_31
    const-string v2, "userSpaceOnUse"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3f

    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    goto :goto_2e

    :goto_3c
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_3f
    new-instance p1, Lc0/j;

    const-string p2, "Invalid value for attribute clipPathUnits"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_47
    return-void
.end method

.method private static B0(Ljava/lang/String;)[Lc0/g$p;
    .registers 6

    new-instance v0, Lc0/k$i;

    invoke-direct {v0, p0}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lc0/k$i;->A()V

    invoke-virtual {v0}, Lc0/k$i;->h()Z

    move-result p0

    const/4 v1, 0x0

    if-eqz p0, :cond_10

    return-object v1

    :cond_10
    invoke-virtual {v0}, Lc0/k$i;->p()Lc0/g$p;

    move-result-object p0

    if-nez p0, :cond_17

    return-object v1

    :cond_17
    invoke-virtual {p0}, Lc0/g$p;->g()Z

    move-result v2

    if-eqz v2, :cond_1e

    return-object v1

    :cond_1e
    invoke-virtual {p0}, Lc0/g$p;->a()F

    move-result v2

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {v3, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :goto_2a
    invoke-virtual {v0}, Lc0/k$i;->h()Z

    move-result p0

    if-nez p0, :cond_4a

    invoke-virtual {v0}, Lc0/k$i;->z()Z

    invoke-virtual {v0}, Lc0/k$i;->p()Lc0/g$p;

    move-result-object p0

    if-nez p0, :cond_3a

    return-object v1

    :cond_3a
    invoke-virtual {p0}, Lc0/g$p;->g()Z

    move-result v4

    if-eqz v4, :cond_41

    return-object v1

    :cond_41
    invoke-interface {v3, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lc0/g$p;->a()F

    move-result p0

    add-float/2addr v2, p0

    goto :goto_2a

    :cond_4a
    const/4 p0, 0x0

    cmpl-float p0, v2, p0

    if-nez p0, :cond_50

    return-object v1

    :cond_50
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result p0

    new-array p0, p0, [Lc0/g$p;

    invoke-interface {v3, p0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Lc0/g$p;

    return-object p0
.end method

.method private C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V
    .registers 8

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_2
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v2

    if-ge v1, v2, :cond_55

    invoke-interface {p2, v1}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lc0/k$a;->b:[I

    invoke-interface {p2, v1}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Enum;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_56

    goto :goto_52

    :pswitch_24
    invoke-static {v2}, Lc0/k;->i0(Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    new-instance v3, Ljava/util/HashSet;

    if-eqz v2, :cond_30

    invoke-direct {v3, v2}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    goto :goto_33

    :cond_30
    invoke-direct {v3, v0}, Ljava/util/HashSet;-><init>(I)V

    :goto_33
    invoke-interface {p1, v3}, Lc0/g$g0;->e(Ljava/util/Set;)V

    goto :goto_52

    :pswitch_37
    invoke-static {v2}, Lc0/k;->A0(Ljava/lang/String;)Ljava/util/Set;

    move-result-object v2

    invoke-interface {p1, v2}, Lc0/g$g0;->c(Ljava/util/Set;)V

    goto :goto_52

    :pswitch_3f
    invoke-static {v2}, Lc0/k;->F0(Ljava/lang/String;)Ljava/util/Set;

    move-result-object v2

    invoke-interface {p1, v2}, Lc0/g$g0;->k(Ljava/util/Set;)V

    goto :goto_52

    :pswitch_47
    invoke-interface {p1, v2}, Lc0/g$g0;->h(Ljava/lang/String;)V

    goto :goto_52

    :pswitch_4b
    invoke-static {v2}, Lc0/k;->z0(Ljava/lang/String;)Ljava/util/Set;

    move-result-object v2

    invoke-interface {p1, v2}, Lc0/g$g0;->g(Ljava/util/Set;)V

    :goto_52
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_55
    return-void

    :pswitch_data_56
    .packed-switch 0x15
        :pswitch_4b
        :pswitch_47
        :pswitch_3f
        :pswitch_37
        :pswitch_24
    .end packed-switch
.end method

.method private static C0(Ljava/lang/String;)Lc0/g$e0$c;
    .registers 2

    const-string v0, "butt"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    sget-object p0, Lc0/g$e0$c;->c:Lc0/g$e0$c;

    return-object p0

    :cond_b
    const-string v0, "round"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_16

    sget-object p0, Lc0/g$e0$c;->d:Lc0/g$e0$c;

    return-object p0

    :cond_16
    const-string v0, "square"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_21

    sget-object p0, Lc0/g$e0$c;->f:Lc0/g$e0$c;

    return-object p0

    :cond_21
    const/4 p0, 0x0

    return-object p0
.end method

.method private D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V
    .registers 6

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_68

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getQName(I)Ljava/lang/String;

    move-result-object v1

    const-string v2, "id"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_5e

    const-string v2, "xml:id"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1c

    goto :goto_5e

    :cond_1c
    const-string v2, "xml:space"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5b

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p2

    const-string v0, "default"

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_39

    sget-object p2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    :goto_36
    iput-object p2, p1, Lc0/g$l0;->d:Ljava/lang/Boolean;

    goto :goto_68

    :cond_39
    const-string v0, "preserve"

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_44

    sget-object p2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    goto :goto_36

    :cond_44
    new-instance p1, Lc0/j;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Invalid value for \"xml:space\" attribute: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_5b
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_5e
    :goto_5e
    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p2

    iput-object p2, p1, Lc0/g$l0;->c:Ljava/lang/String;

    :cond_68
    :goto_68
    return-void
.end method

.method private static D0(Ljava/lang/String;)Lc0/g$e0$d;
    .registers 2

    const-string v0, "miter"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    sget-object p0, Lc0/g$e0$d;->c:Lc0/g$e0$d;

    return-object p0

    :cond_b
    const-string v0, "round"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_16

    sget-object p0, Lc0/g$e0$d;->d:Lc0/g$e0$d;

    return-object p0

    :cond_16
    const-string v0, "bevel"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_21

    sget-object p0, Lc0/g$e0$d;->f:Lc0/g$e0$d;

    return-object p0

    :cond_21
    const/4 p0, 0x0

    return-object p0
.end method

.method private E(Lc0/g$i;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_5e

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_60

    goto :goto_5b

    :pswitch_23
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$i;->p:Lc0/g$p;

    goto :goto_5b

    :pswitch_2a
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$i;->o:Lc0/g$p;

    goto :goto_5b

    :pswitch_31
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$i;->r:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_3e

    goto :goto_5b

    :cond_3e
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <ellipse> element. ry cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :pswitch_46
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$i;->q:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_53

    goto :goto_5b

    :cond_53
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <ellipse> element. rx cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :goto_5b
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_5e
    return-void

    nop

    :pswitch_data_60
    .packed-switch 0xa
        :pswitch_46
        :pswitch_31
        :pswitch_2a
        :pswitch_23
    .end packed-switch
.end method

.method private static E0(Lc0/g$l0;Ljava/lang/String;)V
    .registers 6

    new-instance v0, Lc0/k$i;

    const-string v1, "/\\*.*?\\*/"

    const-string v2, ""

    invoke-virtual {p1, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    :cond_d
    :goto_d
    const/16 p1, 0x3a

    invoke-virtual {v0, p1}, Lc0/k$i;->s(C)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lc0/k$i;->A()V

    invoke-virtual {v0, p1}, Lc0/k$i;->f(C)Z

    move-result p1

    if-nez p1, :cond_1d

    goto :goto_28

    :cond_1d
    invoke-virtual {v0}, Lc0/k$i;->A()V

    const/16 p1, 0x3b

    invoke-virtual {v0, p1}, Lc0/k$i;->u(C)Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_29

    :goto_28
    return-void

    :cond_29
    invoke-virtual {v0}, Lc0/k$i;->A()V

    invoke-virtual {v0}, Lc0/k$i;->h()Z

    move-result v3

    if-nez v3, :cond_38

    invoke-virtual {v0, p1}, Lc0/k$i;->f(C)Z

    move-result p1

    if-eqz p1, :cond_d

    :cond_38
    iget-object p1, p0, Lc0/g$l0;->f:Lc0/g$e0;

    if-nez p1, :cond_43

    new-instance p1, Lc0/g$e0;

    invoke-direct {p1}, Lc0/g$e0;-><init>()V

    iput-object p1, p0, Lc0/g$l0;->f:Lc0/g$e0;

    :cond_43
    iget-object p1, p0, Lc0/g$l0;->f:Lc0/g$e0;

    invoke-static {p1, v1, v2}, Lc0/k;->S0(Lc0/g$e0;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lc0/k$i;->A()V

    goto :goto_d
.end method

.method private F(Lc0/g$j;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_8e

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    const/4 v3, 0x6

    if-eq v2, v3, :cond_70

    packed-switch v2, :pswitch_data_90

    goto :goto_8a

    :pswitch_26
    :try_start_26
    invoke-static {v1}, Lc0/g$k;->valueOf(Ljava/lang/String;)Lc0/g$k;

    move-result-object v2

    iput-object v2, p1, Lc0/g$j;->k:Lc0/g$k;
    :try_end_2c
    .catch Ljava/lang/IllegalArgumentException; {:try_start_26 .. :try_end_2c} :catch_2d

    goto :goto_8a

    :catch_2d
    new-instance p1, Lc0/j;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, "Invalid spreadMethod attribute. \""

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, "\" is not a valid value."

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :pswitch_49
    invoke-direct {p0, v1}, Lc0/k;->J0(Ljava/lang/String;)Landroid/graphics/Matrix;

    move-result-object v1

    iput-object v1, p1, Lc0/g$j;->j:Landroid/graphics/Matrix;

    goto :goto_8a

    :pswitch_50
    const-string v2, "objectBoundingBox"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5d

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    :goto_5a
    iput-object v1, p1, Lc0/g$j;->i:Ljava/lang/Boolean;

    goto :goto_8a

    :cond_5d
    const-string v2, "userSpaceOnUse"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_68

    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    goto :goto_5a

    :cond_68
    new-instance p1, Lc0/j;

    const-string p2, "Invalid value for attribute gradientUnits"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_70
    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getURI(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_88

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getURI(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, "http://www.w3.org/1999/xlink"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8a

    :cond_88
    iput-object v1, p1, Lc0/g$j;->l:Ljava/lang/String;

    :cond_8a
    :goto_8a
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_1

    :cond_8e
    return-void

    nop

    :pswitch_data_90
    .packed-switch 0x20
        :pswitch_50
        :pswitch_49
        :pswitch_26
    .end packed-switch
.end method

.method private static F0(Ljava/lang/String;)Ljava/util/Set;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    new-instance v0, Lc0/k$i;

    invoke-direct {v0, p0}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    new-instance p0, Ljava/util/HashSet;

    invoke-direct {p0}, Ljava/util/HashSet;-><init>()V

    :goto_a
    invoke-virtual {v0}, Lc0/k$i;->h()Z

    move-result v1

    if-nez v1, :cond_34

    invoke-virtual {v0}, Lc0/k$i;->r()Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0x2d

    invoke-virtual {v1, v2}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    const/4 v3, -0x1

    if-eq v2, v3, :cond_22

    const/4 v3, 0x0

    invoke-virtual {v1, v3, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    :cond_22
    new-instance v2, Ljava/util/Locale;

    const-string v3, ""

    invoke-direct {v2, v1, v3, v3}, Ljava/util/Locale;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    invoke-virtual {v0}, Lc0/k$i;->A()V

    goto :goto_a

    :cond_34
    return-object p0
.end method

.method private G(Lc0/g$o;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_8c

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    const/4 v3, 0x1

    if-eq v2, v3, :cond_82

    const/4 v3, 0x2

    if-eq v2, v3, :cond_7b

    const/4 v3, 0x3

    if-eq v2, v3, :cond_66

    const/4 v3, 0x4

    if-eq v2, v3, :cond_51

    const/4 v3, 0x6

    if-eq v2, v3, :cond_36

    const/4 v3, 0x7

    if-eq v2, v3, :cond_32

    goto :goto_88

    :cond_32
    invoke-static {p1, v1}, Lc0/k;->w0(Lc0/g$p0;Ljava/lang/String;)V

    goto :goto_88

    :cond_36
    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getURI(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4e

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getURI(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, "http://www.w3.org/1999/xlink"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_88

    :cond_4e
    iput-object v1, p1, Lc0/g$o;->p:Ljava/lang/String;

    goto :goto_88

    :cond_51
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$o;->t:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_5e

    goto :goto_88

    :cond_5e
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <use> element. height cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_66
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$o;->s:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_73

    goto :goto_88

    :cond_73
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <use> element. width cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_7b
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$o;->r:Lc0/g$p;

    goto :goto_88

    :cond_82
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$o;->q:Lc0/g$p;

    :cond_88
    :goto_88
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_1

    :cond_8c
    return-void
.end method

.method private static G0(Ljava/lang/String;)Lc0/g$e0$f;
    .registers 3

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v0

    const/4 v1, -0x1

    sparse-switch v0, :sswitch_data_3a

    goto :goto_2c

    :sswitch_c
    const-string v0, "start"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_15

    goto :goto_2c

    :cond_15
    const/4 v1, 0x2

    goto :goto_2c

    :sswitch_17
    const-string v0, "end"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_20

    goto :goto_2c

    :cond_20
    const/4 v1, 0x1

    goto :goto_2c

    :sswitch_22
    const-string v0, "middle"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_2b

    goto :goto_2c

    :cond_2b
    const/4 v1, 0x0

    :goto_2c
    packed-switch v1, :pswitch_data_48

    const/4 p0, 0x0

    return-object p0

    :pswitch_31
    sget-object p0, Lc0/g$e0$f;->c:Lc0/g$e0$f;

    return-object p0

    :pswitch_34
    sget-object p0, Lc0/g$e0$f;->f:Lc0/g$e0$f;

    return-object p0

    :pswitch_37
    sget-object p0, Lc0/g$e0$f;->d:Lc0/g$e0$f;

    return-object p0

    :sswitch_data_3a
    .sparse-switch
        -0x4009266b -> :sswitch_22
        0x188db -> :sswitch_17
        0x68ac462 -> :sswitch_c
    .end sparse-switch

    :pswitch_data_48
    .packed-switch 0x0
        :pswitch_37
        :pswitch_34
        :pswitch_31
    .end packed-switch
.end method

.method private H(Lc0/g$q;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_41

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_42

    goto :goto_3e

    :pswitch_23
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$q;->r:Lc0/g$p;

    goto :goto_3e

    :pswitch_2a
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$q;->q:Lc0/g$p;

    goto :goto_3e

    :pswitch_31
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$q;->p:Lc0/g$p;

    goto :goto_3e

    :pswitch_38
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$q;->o:Lc0/g$p;

    :goto_3e
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_41
    return-void

    :pswitch_data_42
    .packed-switch 0xf
        :pswitch_38
        :pswitch_31
        :pswitch_2a
        :pswitch_23
    .end packed-switch
.end method

.method private static H0(Ljava/lang/String;)Lc0/g$e0$g;
    .registers 3

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v0

    const/4 v1, -0x1

    sparse-switch v0, :sswitch_data_56

    goto :goto_42

    :sswitch_c
    const-string v0, "overline"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_15

    goto :goto_42

    :cond_15
    const/4 v1, 0x4

    goto :goto_42

    :sswitch_17
    const-string v0, "blink"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_20

    goto :goto_42

    :cond_20
    const/4 v1, 0x3

    goto :goto_42

    :sswitch_22
    const-string v0, "none"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_2b

    goto :goto_42

    :cond_2b
    const/4 v1, 0x2

    goto :goto_42

    :sswitch_2d
    const-string v0, "underline"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_36

    goto :goto_42

    :cond_36
    const/4 v1, 0x1

    goto :goto_42

    :sswitch_38
    const-string v0, "line-through"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_41

    goto :goto_42

    :cond_41
    const/4 v1, 0x0

    :goto_42
    packed-switch v1, :pswitch_data_6c

    const/4 p0, 0x0

    return-object p0

    :pswitch_47
    sget-object p0, Lc0/g$e0$g;->f:Lc0/g$e0$g;

    return-object p0

    :pswitch_4a
    sget-object p0, Lc0/g$e0$g;->h:Lc0/g$e0$g;

    return-object p0

    :pswitch_4d
    sget-object p0, Lc0/g$e0$g;->c:Lc0/g$e0$g;

    return-object p0

    :pswitch_50
    sget-object p0, Lc0/g$e0$g;->d:Lc0/g$e0$g;

    return-object p0

    :pswitch_53
    sget-object p0, Lc0/g$e0$g;->g:Lc0/g$e0$g;

    return-object p0

    :sswitch_data_56
    .sparse-switch
        -0x45d81614 -> :sswitch_38
        -0x3d363934 -> :sswitch_2d
        0x33af38 -> :sswitch_22
        0x597af5c -> :sswitch_17
        0x1f9462c8 -> :sswitch_c
    .end sparse-switch

    :pswitch_data_6c
    .packed-switch 0x0
        :pswitch_53
        :pswitch_50
        :pswitch_4d
        :pswitch_4a
        :pswitch_47
    .end packed-switch
.end method

.method private I(Lc0/g$m0;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_41

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_42

    goto :goto_3e

    :pswitch_23
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$m0;->p:Lc0/g$p;

    goto :goto_3e

    :pswitch_2a
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$m0;->o:Lc0/g$p;

    goto :goto_3e

    :pswitch_31
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$m0;->n:Lc0/g$p;

    goto :goto_3e

    :pswitch_38
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$m0;->m:Lc0/g$p;

    :goto_3e
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_41
    return-void

    :pswitch_data_42
    .packed-switch 0xf
        :pswitch_38
        :pswitch_31
        :pswitch_2a
        :pswitch_23
    .end packed-switch
.end method

.method private static I0(Ljava/lang/String;)Lc0/g$e0$h;
    .registers 2

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    const-string v0, "ltr"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_18

    const-string v0, "rtl"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_15

    const/4 p0, 0x0

    return-object p0

    :cond_15
    sget-object p0, Lc0/g$e0$h;->d:Lc0/g$e0$h;

    return-object p0

    :cond_18
    sget-object p0, Lc0/g$e0$h;->c:Lc0/g$e0$h;

    return-object p0
.end method

.method private J(Lc0/g$r;Lorg/xml/sax/Attributes;)V
    .registers 8

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_2
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v2

    if-ge v1, v2, :cond_95

    invoke-interface {p2, v1}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lc0/k$a;->b:[I

    invoke-interface {p2, v1}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Enum;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_96

    goto/16 :goto_91

    :pswitch_25
    const-string v3, "auto"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_30

    const/high16 v2, 0x7fc00000    # Float.NaN

    goto :goto_34

    :cond_30
    invoke-static {v2}, Lc0/k;->f0(Ljava/lang/String;)F

    move-result v2

    :goto_34
    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    iput-object v2, p1, Lc0/g$r;->v:Ljava/lang/Float;

    goto :goto_91

    :pswitch_3b
    const-string v3, "strokeWidth"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_46

    iput-boolean v0, p1, Lc0/g$r;->q:Z

    goto :goto_91

    :cond_46
    const-string v3, "userSpaceOnUse"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_52

    const/4 v2, 0x1

    iput-boolean v2, p1, Lc0/g$r;->q:Z

    goto :goto_91

    :cond_52
    new-instance p1, Lc0/j;

    const-string p2, "Invalid value for attribute markerUnits"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :pswitch_5a
    invoke-static {v2}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v2

    iput-object v2, p1, Lc0/g$r;->u:Lc0/g$p;

    invoke-virtual {v2}, Lc0/g$p;->g()Z

    move-result v2

    if-nez v2, :cond_67

    goto :goto_91

    :cond_67
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <marker> element. markerHeight cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :pswitch_6f
    invoke-static {v2}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v2

    iput-object v2, p1, Lc0/g$r;->t:Lc0/g$p;

    invoke-virtual {v2}, Lc0/g$p;->g()Z

    move-result v2

    if-nez v2, :cond_7c

    goto :goto_91

    :cond_7c
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <marker> element. markerWidth cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :pswitch_84
    invoke-static {v2}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v2

    iput-object v2, p1, Lc0/g$r;->s:Lc0/g$p;

    goto :goto_91

    :pswitch_8b
    invoke-static {v2}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v2

    iput-object v2, p1, Lc0/g$r;->r:Lc0/g$p;

    :goto_91
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_2

    :cond_95
    return-void

    :pswitch_data_96
    .packed-switch 0x1a
        :pswitch_8b
        :pswitch_84
        :pswitch_6f
        :pswitch_5a
        :pswitch_3b
        :pswitch_25
    .end packed-switch
.end method

.method private J0(Ljava/lang/String;)Landroid/graphics/Matrix;
    .registers 21

    move-object/from16 v0, p1

    new-instance v1, Landroid/graphics/Matrix;

    invoke-direct {v1}, Landroid/graphics/Matrix;-><init>()V

    new-instance v2, Lc0/k$i;

    invoke-direct {v2, v0}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Lc0/k$i;->A()V

    :goto_f
    invoke-virtual {v2}, Lc0/k$i;->h()Z

    move-result v3

    if-nez v3, :cond_277

    invoke-virtual {v2}, Lc0/k$i;->o()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_260

    const/4 v4, -0x1

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v5

    const/4 v6, 0x5

    const/4 v7, 0x4

    const/4 v8, 0x3

    const/4 v9, 0x2

    const/4 v10, 0x1

    const/4 v11, 0x0

    sparse-switch v5, :sswitch_data_278

    goto :goto_6b

    :sswitch_2a
    const-string v5, "translate"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_33

    goto :goto_6b

    :cond_33
    const/4 v4, 0x5

    goto :goto_6b

    :sswitch_35
    const-string v5, "skewY"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_3e

    goto :goto_6b

    :cond_3e
    const/4 v4, 0x4

    goto :goto_6b

    :sswitch_40
    const-string v5, "skewX"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_49

    goto :goto_6b

    :cond_49
    const/4 v4, 0x3

    goto :goto_6b

    :sswitch_4b
    const-string v5, "scale"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_54

    goto :goto_6b

    :cond_54
    const/4 v4, 0x2

    goto :goto_6b

    :sswitch_56
    const-string v5, "rotate"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_5f

    goto :goto_6b

    :cond_5f
    const/4 v4, 0x1

    goto :goto_6b

    :sswitch_61
    const-string v5, "matrix"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_6a

    goto :goto_6b

    :cond_6a
    const/4 v4, 0x0

    :goto_6b
    const/4 v5, 0x0

    const/16 v12, 0x29

    const-string v13, "Invalid transform list: "

    packed-switch v4, :pswitch_data_292

    new-instance v0, Lc0/j;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid transform list fn: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_8f
    invoke-virtual {v2}, Lc0/k$i;->A()V

    invoke-virtual {v2}, Lc0/k$i;->n()F

    move-result v3

    invoke-virtual {v2}, Lc0/k$i;->x()F

    move-result v4

    invoke-virtual {v2}, Lc0/k$i;->A()V

    invoke-static {v3}, Ljava/lang/Float;->isNaN(F)Z

    move-result v6

    if-nez v6, :cond_b9

    invoke-virtual {v2, v12}, Lc0/k$i;->f(C)Z

    move-result v6

    if-eqz v6, :cond_b9

    invoke-static {v4}, Ljava/lang/Float;->isNaN(F)Z

    move-result v6

    if-eqz v6, :cond_b4

    invoke-virtual {v1, v3, v5}, Landroid/graphics/Matrix;->preTranslate(FF)Z

    goto/16 :goto_23f

    :cond_b4
    invoke-virtual {v1, v3, v4}, Landroid/graphics/Matrix;->preTranslate(FF)Z

    goto/16 :goto_23f

    :cond_b9
    new-instance v1, Lc0/j;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v1

    :pswitch_ce
    invoke-virtual {v2}, Lc0/k$i;->A()V

    invoke-virtual {v2}, Lc0/k$i;->n()F

    move-result v3

    invoke-virtual {v2}, Lc0/k$i;->A()V

    invoke-static {v3}, Ljava/lang/Float;->isNaN(F)Z

    move-result v4

    if-nez v4, :cond_f3

    invoke-virtual {v2, v12}, Lc0/k$i;->f(C)Z

    move-result v4

    if-eqz v4, :cond_f3

    float-to-double v3, v3

    invoke-static {v3, v4}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Math;->tan(D)D

    move-result-wide v3

    double-to-float v3, v3

    invoke-virtual {v1, v5, v3}, Landroid/graphics/Matrix;->preSkew(FF)Z

    goto/16 :goto_23f

    :cond_f3
    new-instance v1, Lc0/j;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v1

    :pswitch_108
    invoke-virtual {v2}, Lc0/k$i;->A()V

    invoke-virtual {v2}, Lc0/k$i;->n()F

    move-result v3

    invoke-virtual {v2}, Lc0/k$i;->A()V

    invoke-static {v3}, Ljava/lang/Float;->isNaN(F)Z

    move-result v4

    if-nez v4, :cond_12d

    invoke-virtual {v2, v12}, Lc0/k$i;->f(C)Z

    move-result v4

    if-eqz v4, :cond_12d

    float-to-double v3, v3

    invoke-static {v3, v4}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Math;->tan(D)D

    move-result-wide v3

    double-to-float v3, v3

    invoke-virtual {v1, v3, v5}, Landroid/graphics/Matrix;->preSkew(FF)Z

    goto/16 :goto_23f

    :cond_12d
    new-instance v1, Lc0/j;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v1

    :pswitch_142
    invoke-virtual {v2}, Lc0/k$i;->A()V

    invoke-virtual {v2}, Lc0/k$i;->n()F

    move-result v3

    invoke-virtual {v2}, Lc0/k$i;->x()F

    move-result v4

    invoke-virtual {v2}, Lc0/k$i;->A()V

    invoke-static {v3}, Ljava/lang/Float;->isNaN(F)Z

    move-result v5

    if-nez v5, :cond_16c

    invoke-virtual {v2, v12}, Lc0/k$i;->f(C)Z

    move-result v5

    if-eqz v5, :cond_16c

    invoke-static {v4}, Ljava/lang/Float;->isNaN(F)Z

    move-result v5

    if-eqz v5, :cond_167

    invoke-virtual {v1, v3, v3}, Landroid/graphics/Matrix;->preScale(FF)Z

    goto/16 :goto_23f

    :cond_167
    invoke-virtual {v1, v3, v4}, Landroid/graphics/Matrix;->preScale(FF)Z

    goto/16 :goto_23f

    :cond_16c
    new-instance v1, Lc0/j;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v1

    :pswitch_181
    invoke-virtual {v2}, Lc0/k$i;->A()V

    invoke-virtual {v2}, Lc0/k$i;->n()F

    move-result v3

    invoke-virtual {v2}, Lc0/k$i;->x()F

    move-result v4

    invoke-virtual {v2}, Lc0/k$i;->x()F

    move-result v5

    invoke-virtual {v2}, Lc0/k$i;->A()V

    invoke-static {v3}, Ljava/lang/Float;->isNaN(F)Z

    move-result v6

    if-nez v6, :cond_1ca

    invoke-virtual {v2, v12}, Lc0/k$i;->f(C)Z

    move-result v6

    if-eqz v6, :cond_1ca

    invoke-static {v4}, Ljava/lang/Float;->isNaN(F)Z

    move-result v6

    if-eqz v6, :cond_1aa

    invoke-virtual {v1, v3}, Landroid/graphics/Matrix;->preRotate(F)Z

    goto/16 :goto_23f

    :cond_1aa
    invoke-static {v5}, Ljava/lang/Float;->isNaN(F)Z

    move-result v6

    if-nez v6, :cond_1b5

    invoke-virtual {v1, v3, v4, v5}, Landroid/graphics/Matrix;->preRotate(FFF)Z

    goto/16 :goto_23f

    :cond_1b5
    new-instance v1, Lc0/j;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_1ca
    new-instance v1, Lc0/j;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v1

    :pswitch_1df
    invoke-virtual {v2}, Lc0/k$i;->A()V

    invoke-virtual {v2}, Lc0/k$i;->n()F

    move-result v3

    invoke-virtual {v2}, Lc0/k$i;->z()Z

    invoke-virtual {v2}, Lc0/k$i;->n()F

    move-result v4

    invoke-virtual {v2}, Lc0/k$i;->z()Z

    invoke-virtual {v2}, Lc0/k$i;->n()F

    move-result v14

    invoke-virtual {v2}, Lc0/k$i;->z()Z

    invoke-virtual {v2}, Lc0/k$i;->n()F

    move-result v15

    invoke-virtual {v2}, Lc0/k$i;->z()Z

    invoke-virtual {v2}, Lc0/k$i;->n()F

    move-result v16

    invoke-virtual {v2}, Lc0/k$i;->z()Z

    invoke-virtual {v2}, Lc0/k$i;->n()F

    move-result v17

    invoke-virtual {v2}, Lc0/k$i;->A()V

    invoke-static/range {v17 .. v17}, Ljava/lang/Float;->isNaN(F)Z

    move-result v18

    if-nez v18, :cond_24b

    invoke-virtual {v2, v12}, Lc0/k$i;->f(C)Z

    move-result v12

    if-eqz v12, :cond_24b

    new-instance v12, Landroid/graphics/Matrix;

    invoke-direct {v12}, Landroid/graphics/Matrix;-><init>()V

    const/16 v13, 0x9

    new-array v13, v13, [F

    aput v3, v13, v11

    aput v14, v13, v10

    aput v16, v13, v9

    aput v4, v13, v8

    aput v15, v13, v7

    aput v17, v13, v6

    const/4 v3, 0x6

    aput v5, v13, v3

    const/4 v3, 0x7

    aput v5, v13, v3

    const/16 v3, 0x8

    const/high16 v4, 0x3f800000    # 1.0f

    aput v4, v13, v3

    invoke-virtual {v12, v13}, Landroid/graphics/Matrix;->setValues([F)V

    invoke-virtual {v1, v12}, Landroid/graphics/Matrix;->preConcat(Landroid/graphics/Matrix;)Z

    :goto_23f
    invoke-virtual {v2}, Lc0/k$i;->h()Z

    move-result v3

    if-eqz v3, :cond_246

    goto :goto_277

    :cond_246
    invoke-virtual {v2}, Lc0/k$i;->z()Z

    goto/16 :goto_f

    :cond_24b
    new-instance v1, Lc0/j;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_260
    new-instance v1, Lc0/j;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Bad transform function encountered in transform list: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_277
    :goto_277
    return-object v1

    :sswitch_data_278
    .sparse-switch
        -0x4072683f -> :sswitch_61
        -0x372522a5 -> :sswitch_56
        0x683094a -> :sswitch_4b
        0x686bc8e -> :sswitch_40
        0x686bc8f -> :sswitch_35
        0x3ec0f14e -> :sswitch_2a
    .end sparse-switch

    :pswitch_data_292
    .packed-switch 0x0
        :pswitch_1df
        :pswitch_181
        :pswitch_142
        :pswitch_108
        :pswitch_ce
        :pswitch_8f
    .end packed-switch
.end method

.method private K(Lc0/g$s;Lorg/xml/sax/Attributes;)V
    .registers 9

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_ac

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    const/4 v3, 0x1

    if-eq v2, v3, :cond_a2

    const/4 v3, 0x2

    if-eq v2, v3, :cond_9b

    const/4 v3, 0x3

    if-eq v2, v3, :cond_86

    const/4 v3, 0x4

    if-eq v2, v3, :cond_71

    const/16 v3, 0x2b

    const-string v4, "userSpaceOnUse"

    const-string v5, "objectBoundingBox"

    if-eq v2, v3, :cond_55

    const/16 v3, 0x2c

    if-eq v2, v3, :cond_39

    goto/16 :goto_a8

    :cond_39
    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_44

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    :goto_41
    iput-object v1, p1, Lc0/g$s;->p:Ljava/lang/Boolean;

    goto :goto_a8

    :cond_44
    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4d

    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    goto :goto_41

    :cond_4d
    new-instance p1, Lc0/j;

    const-string p2, "Invalid value for attribute maskContentUnits"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_55
    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_60

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    :goto_5d
    iput-object v1, p1, Lc0/g$s;->o:Ljava/lang/Boolean;

    goto :goto_a8

    :cond_60
    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_69

    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    goto :goto_5d

    :cond_69
    new-instance p1, Lc0/j;

    const-string p2, "Invalid value for attribute maskUnits"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_71
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$s;->t:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_7e

    goto :goto_a8

    :cond_7e
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <mask> element. height cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_86
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$s;->s:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_93

    goto :goto_a8

    :cond_93
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <mask> element. width cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_9b
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$s;->r:Lc0/g$p;

    goto :goto_a8

    :cond_a2
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$s;->q:Lc0/g$p;

    :goto_a8
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_1

    :cond_ac
    return-void
.end method

.method private K0(Ljava/io/InputStream;)V
    .registers 5

    const-string v0, "SVGParser"

    const-string v1, "Falling back to SAX parser"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :try_start_7
    invoke-static {}, Ljavax/xml/parsers/SAXParserFactory;->newInstance()Ljavax/xml/parsers/SAXParserFactory;

    move-result-object v0

    const-string v1, "http://xml.org/sax/features/external-general-entities"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Ljavax/xml/parsers/SAXParserFactory;->setFeature(Ljava/lang/String;Z)V

    const-string v1, "http://xml.org/sax/features/external-parameter-entities"

    invoke-virtual {v0, v1, v2}, Ljavax/xml/parsers/SAXParserFactory;->setFeature(Ljava/lang/String;Z)V

    invoke-virtual {v0}, Ljavax/xml/parsers/SAXParserFactory;->newSAXParser()Ljavax/xml/parsers/SAXParser;

    move-result-object v0

    invoke-virtual {v0}, Ljavax/xml/parsers/SAXParser;->getXMLReader()Lorg/xml/sax/XMLReader;

    move-result-object v0

    new-instance v1, Lc0/k$f;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lc0/k$f;-><init>(Lc0/k;Lc0/k$a;)V

    invoke-interface {v0, v1}, Lorg/xml/sax/XMLReader;->setContentHandler(Lorg/xml/sax/ContentHandler;)V

    const-string v2, "http://xml.org/sax/properties/lexical-handler"

    invoke-interface {v0, v2, v1}, Lorg/xml/sax/XMLReader;->setProperty(Ljava/lang/String;Ljava/lang/Object;)V

    new-instance v1, Lorg/xml/sax/InputSource;

    invoke-direct {v1, p1}, Lorg/xml/sax/InputSource;-><init>(Ljava/io/InputStream;)V

    invoke-interface {v0, v1}, Lorg/xml/sax/XMLReader;->parse(Lorg/xml/sax/InputSource;)V
    :try_end_34
    .catch Ljavax/xml/parsers/ParserConfigurationException; {:try_start_7 .. :try_end_34} :catch_47
    .catch Lorg/xml/sax/SAXException; {:try_start_7 .. :try_end_34} :catch_3e
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_34} :catch_35

    return-void

    :catch_35
    move-exception p1

    new-instance v0, Lc0/j;

    const-string v1, "Stream error"

    invoke-direct {v0, v1, p1}, Lc0/j;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v0

    :catch_3e
    move-exception p1

    new-instance v0, Lc0/j;

    const-string v1, "SVG parse error"

    invoke-direct {v0, v1, p1}, Lc0/j;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v0

    :catch_47
    move-exception p1

    new-instance v0, Lc0/j;

    const-string v1, "XML parser problem"

    invoke-direct {v0, v1, p1}, Lc0/j;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v0
.end method

.method private L(Lc0/g$v;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_4d

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    const/16 v3, 0x8

    if-eq v2, v3, :cond_44

    const/16 v3, 0x9

    if-eq v2, v3, :cond_28

    goto :goto_4a

    :cond_28
    invoke-static {v1}, Lc0/k;->f0(Ljava/lang/String;)F

    move-result v1

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    iput-object v1, p1, Lc0/g$v;->p:Ljava/lang/Float;

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v1

    const/4 v2, 0x0

    cmpg-float v1, v1, v2

    if-ltz v1, :cond_3c

    goto :goto_4a

    :cond_3c
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <path> element. pathLength cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_44
    invoke-static {v1}, Lc0/k;->u0(Ljava/lang/String;)Lc0/g$w;

    move-result-object v1

    iput-object v1, p1, Lc0/g$v;->o:Lc0/g$w;

    :goto_4a
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_4d
    return-void
.end method

.method private L0(Ljava/io/InputStream;Z)V
    .registers 11

    :try_start_0
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v0

    new-instance v1, Lc0/k$j;

    invoke-direct {v1, p0, v0}, Lc0/k$j;-><init>(Lc0/k;Lorg/xmlpull/v1/XmlPullParser;)V

    const-string v2, "http://xmlpull.org/v1/doc/features.html#process-docdecl"

    const/4 v3, 0x0

    invoke-interface {v0, v2, v3}, Lorg/xmlpull/v1/XmlPullParser;->setFeature(Ljava/lang/String;Z)V

    const-string v2, "http://xmlpull.org/v1/doc/features.html#process-namespaces"

    const/4 v4, 0x1

    invoke-interface {v0, v2, v4}, Lorg/xmlpull/v1/XmlPullParser;->setFeature(Ljava/lang/String;Z)V

    const/4 v2, 0x0

    invoke-interface {v0, p1, v2}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v2
    :try_end_1d
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_1d} :catch_117
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_1d} :catch_10e

    :goto_1d
    if-eq v2, v4, :cond_10a

    if-eqz v2, :cond_101

    const/16 v5, 0x8

    const-string v6, "SVGParser"

    if-eq v2, v5, :cond_d4

    const/16 v5, 0xa

    if-eq v2, v5, :cond_ac

    const/16 v5, 0x3a

    const/4 v6, 0x2

    if-eq v2, v6, :cond_80

    const/4 v7, 0x3

    if-eq v2, v7, :cond_53

    const/4 v5, 0x4

    if-eq v2, v5, :cond_44

    const/4 v5, 0x5

    if-eq v2, v5, :cond_3b

    goto/16 :goto_104

    :cond_3b
    :try_start_3b
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Lc0/k;->c1(Ljava/lang/String;)V

    goto/16 :goto_104

    :cond_44
    new-array v2, v6, [I

    invoke-interface {v0, v2}, Lorg/xmlpull/v1/XmlPullParser;->getTextCharacters([I)[C

    move-result-object v5

    aget v6, v2, v3

    aget v2, v2, v4

    invoke-direct {p0, v5, v6, v2}, Lc0/k;->e1([CII)V

    goto/16 :goto_104

    :cond_53
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getPrefix()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_73

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getPrefix()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    :cond_73
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getNamespace()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-direct {p0, v5, v6, v2}, Lc0/k;->p(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_104

    :cond_80
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getPrefix()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_a0

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getPrefix()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    :cond_a0
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getNamespace()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-direct {p0, v5, v6, v2, v1}, Lc0/k;->X0(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/xml/sax/Attributes;)V

    goto :goto_104

    :cond_ac
    if-eqz p2, :cond_104

    iget-object v2, p0, Lc0/k;->a:Lc0/g;

    invoke-virtual {v2}, Lc0/g;->i()Lc0/g$f0;

    move-result-object v2

    if-nez v2, :cond_104

    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v2

    const-string v5, "<!ENTITY "

    invoke-virtual {v2, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2
    :try_end_c0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_3b .. :try_end_c0} :catch_117
    .catch Ljava/io/IOException; {:try_start_3b .. :try_end_c0} :catch_10e

    if-eqz v2, :cond_104

    :try_start_c2
    const-string p2, "Switching to SAX parser to process entities"

    invoke-static {v6, p2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {p1}, Ljava/io/InputStream;->reset()V

    invoke-direct {p0, p1}, Lc0/k;->K0(Ljava/io/InputStream;)V
    :try_end_cd
    .catch Ljava/io/IOException; {:try_start_c2 .. :try_end_cd} :catch_ce
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_c2 .. :try_end_cd} :catch_117

    goto :goto_d3

    :catch_ce
    :try_start_ce
    const-string p1, "Detected internal entity definitions, but could not parse them."

    invoke-static {v6, p1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :goto_d3
    return-void

    :cond_d4
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "PROC INSTR: "

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v6, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    new-instance v2, Lc0/k$i;

    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v5}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Lc0/k$i;->r()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v2}, Lc0/k;->x0(Lc0/k$i;)Ljava/util/Map;

    move-result-object v2

    invoke-direct {p0, v5, v2}, Lc0/k;->r(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_104

    :cond_101
    invoke-direct {p0}, Lc0/k;->W0()V

    :cond_104
    :goto_104
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->nextToken()I

    move-result v2

    goto/16 :goto_1d

    :cond_10a
    invoke-direct {p0}, Lc0/k;->o()V
    :try_end_10d
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_ce .. :try_end_10d} :catch_117
    .catch Ljava/io/IOException; {:try_start_ce .. :try_end_10d} :catch_10e

    return-void

    :catch_10e
    move-exception p1

    new-instance p2, Lc0/j;

    const-string v0, "Stream error"

    invoke-direct {p2, v0, p1}, Lc0/j;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw p2

    :catch_117
    move-exception p1

    new-instance p2, Lc0/j;

    const-string v0, "XML parser problem"

    invoke-direct {p2, v0, p1}, Lc0/j;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw p2
.end method

.method private M(Lc0/g$y;Lorg/xml/sax/Attributes;)V
    .registers 8

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_ce

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    const/4 v3, 0x1

    if-eq v2, v3, :cond_c4

    const/4 v3, 0x2

    if-eq v2, v3, :cond_bd

    const/4 v3, 0x3

    if-eq v2, v3, :cond_a8

    const/4 v3, 0x4

    if-eq v2, v3, :cond_93

    const/4 v3, 0x6

    if-eq v2, v3, :cond_78

    const-string v3, "userSpaceOnUse"

    const-string v4, "objectBoundingBox"

    packed-switch v2, :pswitch_data_d0

    goto/16 :goto_ca

    :pswitch_37
    invoke-direct {p0, v1}, Lc0/k;->J0(Ljava/lang/String;)Landroid/graphics/Matrix;

    move-result-object v1

    iput-object v1, p1, Lc0/g$y;->s:Landroid/graphics/Matrix;

    goto/16 :goto_ca

    :pswitch_3f
    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4b

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    :goto_47
    iput-object v1, p1, Lc0/g$y;->r:Ljava/lang/Boolean;

    goto/16 :goto_ca

    :cond_4b
    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_54

    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    goto :goto_47

    :cond_54
    new-instance p1, Lc0/j;

    const-string p2, "Invalid value for attribute patternContentUnits"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :pswitch_5c
    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_67

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    :goto_64
    iput-object v1, p1, Lc0/g$y;->q:Ljava/lang/Boolean;

    goto :goto_ca

    :cond_67
    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_70

    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    goto :goto_64

    :cond_70
    new-instance p1, Lc0/j;

    const-string p2, "Invalid value for attribute patternUnits"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_78
    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getURI(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_90

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getURI(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, "http://www.w3.org/1999/xlink"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_ca

    :cond_90
    iput-object v1, p1, Lc0/g$y;->x:Ljava/lang/String;

    goto :goto_ca

    :cond_93
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$y;->w:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_a0

    goto :goto_ca

    :cond_a0
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <pattern> element. height cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_a8
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$y;->v:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_b5

    goto :goto_ca

    :cond_b5
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <pattern> element. width cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_bd
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$y;->u:Lc0/g$p;

    goto :goto_ca

    :cond_c4
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$y;->t:Lc0/g$p;

    :cond_ca
    :goto_ca
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_1

    :cond_ce
    return-void

    nop

    :pswitch_data_d0
    .packed-switch 0x28
        :pswitch_5c
        :pswitch_3f
        :pswitch_37
    .end packed-switch
.end method

.method private static M0(Ljava/lang/String;)Lc0/g$e0$i;
    .registers 2

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    const-string v0, "none"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_18

    const-string v0, "non-scaling-stroke"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_15

    const/4 p0, 0x0

    return-object p0

    :cond_15
    sget-object p0, Lc0/g$e0$i;->d:Lc0/g$e0$i;

    return-object p0

    :cond_18
    sget-object p0, Lc0/g$e0$i;->c:Lc0/g$e0$i;

    return-object p0
.end method

.method private N(Lc0/g$z;Lorg/xml/sax/Attributes;Ljava/lang/String;)V
    .registers 12

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_2
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v2

    if-ge v1, v2, :cond_b3

    invoke-interface {p2, v1}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v2

    sget-object v3, Lc0/k$g;->Y:Lc0/k$g;

    if-ne v2, v3, :cond_af

    new-instance v2, Lc0/k$i;

    invoke-interface {p2, v1}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {v2}, Lc0/k$i;->A()V

    :goto_25
    invoke-virtual {v2}, Lc0/k$i;->h()Z

    move-result v4

    if-nez v4, :cond_8a

    invoke-virtual {v2}, Lc0/k$i;->n()F

    move-result v4

    invoke-static {v4}, Ljava/lang/Float;->isNaN(F)Z

    move-result v5

    const-string v6, "Invalid <"

    if-nez v5, :cond_70

    invoke-virtual {v2}, Lc0/k$i;->z()Z

    invoke-virtual {v2}, Lc0/k$i;->n()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->isNaN(F)Z

    move-result v7

    if-nez v7, :cond_56

    invoke-virtual {v2}, Lc0/k$i;->z()Z

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_25

    :cond_56
    new-instance p1, Lc0/j;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p3, "> points attribute. There should be an even number of coordinates."

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_70
    new-instance p1, Lc0/j;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p3, "> points attribute. Non-coordinate content found in list."

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_8a
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v2

    new-array v2, v2, [F

    iput-object v2, p1, Lc0/g$z;->o:[F

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    const/4 v3, 0x0

    :goto_97
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_af

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Float;

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v4

    iget-object v5, p1, Lc0/g$z;->o:[F

    add-int/lit8 v6, v3, 0x1

    aput v4, v5, v3

    move v3, v6

    goto :goto_97

    :cond_af
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_2

    :cond_b3
    return-void
.end method

.method private static N0(Ljava/lang/String;)Lc0/g$b;
    .registers 6

    new-instance v0, Lc0/k$i;

    invoke-direct {v0, p0}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lc0/k$i;->A()V

    invoke-virtual {v0}, Lc0/k$i;->n()F

    move-result p0

    invoke-virtual {v0}, Lc0/k$i;->z()Z

    invoke-virtual {v0}, Lc0/k$i;->n()F

    move-result v1

    invoke-virtual {v0}, Lc0/k$i;->z()Z

    invoke-virtual {v0}, Lc0/k$i;->n()F

    move-result v2

    invoke-virtual {v0}, Lc0/k$i;->z()Z

    invoke-virtual {v0}, Lc0/k$i;->n()F

    move-result v0

    invoke-static {p0}, Ljava/lang/Float;->isNaN(F)Z

    move-result v3

    if-nez v3, :cond_58

    invoke-static {v1}, Ljava/lang/Float;->isNaN(F)Z

    move-result v3

    if-nez v3, :cond_58

    invoke-static {v2}, Ljava/lang/Float;->isNaN(F)Z

    move-result v3

    if-nez v3, :cond_58

    invoke-static {v0}, Ljava/lang/Float;->isNaN(F)Z

    move-result v3

    if-nez v3, :cond_58

    const/4 v3, 0x0

    cmpg-float v4, v2, v3

    if-ltz v4, :cond_50

    cmpg-float v3, v0, v3

    if-ltz v3, :cond_48

    new-instance v3, Lc0/g$b;

    invoke-direct {v3, p0, v1, v2, v0}, Lc0/g$b;-><init>(FFFF)V

    return-object v3

    :cond_48
    new-instance p0, Lc0/j;

    const-string v0, "Invalid viewBox. height cannot be negative"

    invoke-direct {p0, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_50
    new-instance p0, Lc0/j;

    const-string v0, "Invalid viewBox. width cannot be negative"

    invoke-direct {p0, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_58
    new-instance p0, Lc0/j;

    const-string v0, "Invalid viewBox definition - should have four numbers"

    invoke-direct {p0, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method private O(Lc0/g$q0;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_5e

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    const/16 v3, 0x23

    if-eq v2, v3, :cond_55

    const/16 v3, 0x24

    if-eq v2, v3, :cond_4e

    packed-switch v2, :pswitch_data_60

    goto :goto_5b

    :pswitch_2b
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$q0;->o:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_38

    goto :goto_5b

    :cond_38
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <radialGradient> element. r cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :pswitch_40
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$q0;->n:Lc0/g$p;

    goto :goto_5b

    :pswitch_47
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$q0;->m:Lc0/g$p;

    goto :goto_5b

    :cond_4e
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$q0;->q:Lc0/g$p;

    goto :goto_5b

    :cond_55
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$q0;->p:Lc0/g$p;

    :goto_5b
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_5e
    return-void

    nop

    :pswitch_data_60
    .packed-switch 0xc
        :pswitch_47
        :pswitch_40
        :pswitch_2b
    .end packed-switch
.end method

.method private O0(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<path>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_2e

    new-instance v0, Lc0/g$v;

    invoke-direct {v0}, Lc0/g$v;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->W(Lc0/g$n;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->L(Lc0/g$v;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    return-void

    :cond_2e
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private P(Lc0/g$b0;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_99

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    const/4 v3, 0x1

    if-eq v2, v3, :cond_8f

    const/4 v3, 0x2

    if-eq v2, v3, :cond_88

    const/4 v3, 0x3

    if-eq v2, v3, :cond_73

    const/4 v3, 0x4

    if-eq v2, v3, :cond_5e

    const/16 v3, 0xa

    if-eq v2, v3, :cond_49

    const/16 v3, 0xb

    if-eq v2, v3, :cond_34

    goto :goto_95

    :cond_34
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$b0;->t:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_41

    goto :goto_95

    :cond_41
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <rect> element. ry cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_49
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$b0;->s:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_56

    goto :goto_95

    :cond_56
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <rect> element. rx cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_5e
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$b0;->r:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_6b

    goto :goto_95

    :cond_6b
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <rect> element. height cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_73
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$b0;->q:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_80

    goto :goto_95

    :cond_80
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <rect> element. width cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_88
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$b0;->p:Lc0/g$p;

    goto :goto_95

    :cond_8f
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$b0;->o:Lc0/g$p;

    :goto_95
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_1

    :cond_99
    return-void
.end method

.method private P0(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<pattern>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_30

    new-instance v0, Lc0/g$y;

    invoke-direct {v0}, Lc0/g$y;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->Y(Lc0/g$r0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->M(Lc0/g$y;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    return-void

    :cond_30
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private Q(Lc0/g$f0;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_6c

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    const/4 v3, 0x1

    if-eq v2, v3, :cond_63

    const/4 v3, 0x2

    if-eq v2, v3, :cond_5c

    const/4 v3, 0x3

    if-eq v2, v3, :cond_47

    const/4 v3, 0x4

    if-eq v2, v3, :cond_32

    const/4 v3, 0x5

    if-eq v2, v3, :cond_2f

    goto :goto_69

    :cond_2f
    iput-object v1, p1, Lc0/g$f0;->u:Ljava/lang/String;

    goto :goto_69

    :cond_32
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$f0;->t:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_3f

    goto :goto_69

    :cond_3f
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <svg> element. height cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_47
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$f0;->s:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_54

    goto :goto_69

    :cond_54
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <svg> element. width cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_5c
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$f0;->r:Lc0/g$p;

    goto :goto_69

    :cond_63
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$f0;->q:Lc0/g$p;

    :goto_69
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_6c
    return-void
.end method

.method private Q0(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<polygon>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_30

    new-instance v0, Lc0/g$a0;

    invoke-direct {v0}, Lc0/g$a0;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->W(Lc0/g$n;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    const-string v1, "polygon"

    invoke-direct {p0, v0, p1, v1}, Lc0/k;->N(Lc0/g$z;Lorg/xml/sax/Attributes;Ljava/lang/String;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    return-void

    :cond_30
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private R(Lc0/g$d0;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_2d

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    const/16 v3, 0x25

    if-eq v2, v3, :cond_24

    goto :goto_2a

    :cond_24
    invoke-direct {p0, v1}, Lc0/k;->n0(Ljava/lang/String;)Ljava/lang/Float;

    move-result-object v1

    iput-object v1, p1, Lc0/g$d0;->h:Ljava/lang/Float;

    :goto_2a
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_2d
    return-void
.end method

.method private R0(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<polyline>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_30

    new-instance v0, Lc0/g$z;

    invoke-direct {v0}, Lc0/g$z;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->W(Lc0/g$n;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    const-string v1, "polyline"

    invoke-direct {p0, v0, p1, v1}, Lc0/k;->N(Lc0/g$z;Lorg/xml/sax/Attributes;Ljava/lang/String;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    return-void

    :cond_30
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_58

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_16

    goto :goto_55

    :cond_16
    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    const/16 v3, 0x2d

    if-eq v2, v3, :cond_52

    const/16 v3, 0x2e

    if-eq v2, v3, :cond_4b

    iget-object v1, p1, Lc0/g$l0;->e:Lc0/g$e0;

    if-nez v1, :cond_39

    new-instance v1, Lc0/g$e0;

    invoke-direct {v1}, Lc0/g$e0;-><init>()V

    iput-object v1, p1, Lc0/g$l0;->e:Lc0/g$e0;

    :cond_39
    iget-object v1, p1, Lc0/g$l0;->e:Lc0/g$e0;

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v2, v3}, Lc0/k;->S0(Lc0/g$e0;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_55

    :cond_4b
    invoke-static {v1}, Lc0/b;->f(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    iput-object v1, p1, Lc0/g$l0;->g:Ljava/util/List;

    goto :goto_55

    :cond_52
    invoke-static {p1, v1}, Lc0/k;->E0(Lc0/g$l0;Ljava/lang/String;)V

    :goto_55
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_58
    return-void
.end method

.method static S0(Lc0/g$e0;Ljava/lang/String;Ljava/lang/String;)V
    .registers 8

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_7

    return-void

    :cond_7
    const-string v0, "inherit"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_10

    return-void

    :cond_10
    sget-object v0, Lc0/k$a;->b:[I

    invoke-static {p1}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const-string v1, "none"

    const-string v2, "SVGParser"

    const-string v3, "currentColor"

    const/16 v4, 0x7c

    packed-switch v0, :pswitch_data_2da

    goto/16 :goto_2d9

    :pswitch_29
    invoke-static {p2}, Lc0/k;->y0(Ljava/lang/String;)Lc0/g$e0$e;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->P:Lc0/g$e0$e;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide v0, 0x2000000000L

    goto/16 :goto_23a

    :pswitch_3a
    invoke-static {p2}, Lc0/k;->M0(Ljava/lang/String;)Lc0/g$e0$i;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->O:Lc0/g$e0$i;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide v0, 0x800000000L

    goto/16 :goto_23a

    :pswitch_4b
    invoke-static {p2}, Lc0/k;->r0(Ljava/lang/String;)Ljava/lang/Float;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->N:Ljava/lang/Float;

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide v0, 0x400000000L

    goto/16 :goto_23a

    :pswitch_5a
    invoke-virtual {p2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_67

    invoke-static {}, Lc0/g$g;->a()Lc0/g$g;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->M:Lc0/g$o0;

    goto :goto_6d

    :cond_67
    :try_start_67
    invoke-static {p2}, Lc0/k;->b0(Ljava/lang/String;)Lc0/g$f;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->M:Lc0/g$o0;
    :try_end_6d
    .catch Lc0/j; {:try_start_67 .. :try_end_6d} :catch_fe

    :goto_6d
    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide v0, 0x200000000L

    goto/16 :goto_23a

    :pswitch_76
    invoke-static {p2}, Lc0/k;->r0(Ljava/lang/String;)Ljava/lang/Float;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->L:Ljava/lang/Float;

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide v0, 0x100000000L

    goto/16 :goto_23a

    :pswitch_85
    invoke-virtual {p2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_92

    invoke-static {}, Lc0/g$g;->a()Lc0/g$g;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->K:Lc0/g$o0;

    goto :goto_98

    :cond_92
    :try_start_92
    invoke-static {p2}, Lc0/k;->b0(Ljava/lang/String;)Lc0/g$f;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->K:Lc0/g$o0;
    :try_end_98
    .catch Lc0/j; {:try_start_92 .. :try_end_98} :catch_fe

    :goto_98
    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide v0, 0x80000000L

    goto/16 :goto_23a

    :pswitch_a1
    invoke-static {p2, p1}, Lc0/k;->m0(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->J:Ljava/lang/String;

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/32 v0, 0x40000000

    goto/16 :goto_23a

    :pswitch_ae
    invoke-static {p2}, Lc0/k;->e0(Ljava/lang/String;)Lc0/g$e0$a;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->I:Lc0/g$e0$a;

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/32 v0, 0x20000000

    goto/16 :goto_23a

    :pswitch_bb
    invoke-static {p2, p1}, Lc0/k;->m0(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->H:Ljava/lang/String;

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/32 v0, 0x10000000

    goto/16 :goto_23a

    :pswitch_c8
    invoke-static {p2}, Lc0/k;->a0(Ljava/lang/String;)Lc0/g$c;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->z:Lc0/g$c;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/32 v0, 0x100000

    goto/16 :goto_23a

    :pswitch_d7
    invoke-static {p2}, Lc0/k;->r0(Ljava/lang/String;)Ljava/lang/Float;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->G:Ljava/lang/Float;

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/32 v0, 0x8000000

    goto/16 :goto_23a

    :pswitch_e4
    invoke-virtual {p2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_f1

    invoke-static {}, Lc0/g$g;->a()Lc0/g$g;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->F:Lc0/g$o0;

    goto :goto_f7

    :cond_f1
    :try_start_f1
    invoke-static {p2}, Lc0/k;->b0(Ljava/lang/String;)Lc0/g$f;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->F:Lc0/g$o0;
    :try_end_f7
    .catch Lc0/j; {:try_start_f1 .. :try_end_f7} :catch_fe

    :goto_f7
    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/32 v0, 0x4000000

    goto/16 :goto_23a

    :catch_fe
    move-exception p0

    invoke-virtual {p0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p0

    invoke-static {v2, p0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_2d9

    :pswitch_108
    invoke-virtual {p2, v4}, Ljava/lang/String;->indexOf(I)I

    move-result p1

    if-gez p1, :cond_2d9

    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string v0, "|visible|hidden|collapse|"

    invoke-virtual {v0, p1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result p1

    if-nez p1, :cond_12a

    goto/16 :goto_2d9

    :cond_12a
    const-string p1, "visible"

    invoke-virtual {p2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->E:Ljava/lang/Boolean;

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/32 v0, 0x2000000

    goto/16 :goto_23a

    :pswitch_13d
    invoke-virtual {p2, v4}, Ljava/lang/String;->indexOf(I)I

    move-result p1

    if-gez p1, :cond_2d9

    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string v0, "|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|"

    invoke-virtual {v0, p1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result p1

    if-nez p1, :cond_15f

    goto/16 :goto_2d9

    :cond_15f
    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    xor-int/lit8 p1, p1, 0x1

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->D:Ljava/lang/Boolean;

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/32 v0, 0x1000000

    goto/16 :goto_23a

    :pswitch_172
    invoke-static {p2, p1}, Lc0/k;->m0(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->C:Ljava/lang/String;

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/32 v0, 0x800000

    goto/16 :goto_23a

    :pswitch_17f
    invoke-static {p2, p1}, Lc0/k;->m0(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->B:Ljava/lang/String;

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/32 v0, 0x400000

    goto/16 :goto_23a

    :pswitch_18c
    invoke-static {p2, p1}, Lc0/k;->m0(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->A:Ljava/lang/String;

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/32 v0, 0x200000

    goto/16 :goto_23a

    :pswitch_199
    invoke-static {p2, p1}, Lc0/k;->m0(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->A:Ljava/lang/String;

    iput-object p1, p0, Lc0/g$e0;->B:Ljava/lang/String;

    iput-object p1, p0, Lc0/g$e0;->C:Ljava/lang/String;

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/32 v0, 0xe00000

    goto/16 :goto_23a

    :pswitch_1aa
    invoke-static {p2}, Lc0/k;->s0(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->y:Ljava/lang/Boolean;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/32 v0, 0x80000

    goto/16 :goto_23a

    :pswitch_1b9
    invoke-static {p2}, Lc0/k;->G0(Ljava/lang/String;)Lc0/g$e0$f;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->x:Lc0/g$e0$f;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/32 v0, 0x40000

    goto/16 :goto_23a

    :pswitch_1c8
    invoke-static {p2}, Lc0/k;->I0(Ljava/lang/String;)Lc0/g$e0$h;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->w:Lc0/g$e0$h;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide v0, 0x1000000000L

    goto :goto_23a

    :pswitch_1d8
    invoke-static {p2}, Lc0/k;->H0(Ljava/lang/String;)Lc0/g$e0$g;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->v:Lc0/g$e0$g;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/32 v0, 0x20000

    goto :goto_23a

    :pswitch_1e6
    invoke-static {p2}, Lc0/k;->k0(Ljava/lang/String;)Lc0/g$e0$b;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->u:Lc0/g$e0$b;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/32 v0, 0x10000

    goto :goto_23a

    :pswitch_1f4
    invoke-static {p2}, Lc0/k;->l0(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->t:Ljava/lang/Integer;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/32 v0, 0x8000

    goto :goto_23a

    :pswitch_202
    invoke-static {p2}, Lc0/k;->j0(Ljava/lang/String;)Lc0/g$p;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->s:Lc0/g$p;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/16 v0, 0x4000

    goto :goto_23a

    :pswitch_20f
    invoke-static {p2}, Lc0/k;->i0(Ljava/lang/String;)Ljava/util/List;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->r:Ljava/util/List;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/16 v0, 0x2000

    goto :goto_23a

    :pswitch_21c
    invoke-static {p0, p2}, Lc0/k;->h0(Lc0/g$e0;Ljava/lang/String;)V

    goto/16 :goto_2d9

    :pswitch_221
    :try_start_221
    invoke-static {p2}, Lc0/k;->b0(Ljava/lang/String;)Lc0/g$f;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->q:Lc0/g$f;

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/16 v0, 0x1000

    :goto_22b
    or-long/2addr p1, v0

    iput-wide p1, p0, Lc0/g$e0;->c:J
    :try_end_22e
    .catch Lc0/j; {:try_start_221 .. :try_end_22e} :catch_2d9

    goto/16 :goto_2d9

    :pswitch_230
    invoke-static {p2}, Lc0/k;->r0(Ljava/lang/String;)Ljava/lang/Float;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->p:Ljava/lang/Float;

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/16 v0, 0x800

    :goto_23a
    or-long/2addr p1, v0

    iput-wide p1, p0, Lc0/g$e0;->c:J

    goto/16 :goto_2d9

    :pswitch_23f
    :try_start_23f
    invoke-static {p2}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->o:Lc0/g$p;

    iget-wide p1, p0, Lc0/g$e0;->c:J
    :try_end_247
    .catch Lc0/j; {:try_start_23f .. :try_end_247} :catch_2d9

    const-wide/16 v0, 0x400

    goto :goto_22b

    :pswitch_24a
    invoke-virtual {v1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    const-wide/16 v0, 0x200

    if-eqz p1, :cond_258

    const/4 p1, 0x0

    iput-object p1, p0, Lc0/g$e0;->n:[Lc0/g$p;

    :goto_255
    iget-wide p1, p0, Lc0/g$e0;->c:J

    goto :goto_23a

    :cond_258
    invoke-static {p2}, Lc0/k;->B0(Ljava/lang/String;)[Lc0/g$p;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->n:[Lc0/g$p;

    if-eqz p1, :cond_2d9

    goto :goto_255

    :pswitch_261
    :try_start_261
    invoke-static {p2}, Lc0/k;->f0(Ljava/lang/String;)F

    move-result p1

    invoke-static {p1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->m:Ljava/lang/Float;

    iget-wide p1, p0, Lc0/g$e0;->c:J
    :try_end_26d
    .catch Lc0/j; {:try_start_261 .. :try_end_26d} :catch_2d9

    const-wide/16 v0, 0x100

    goto :goto_22b

    :pswitch_270
    invoke-static {p2}, Lc0/k;->D0(Ljava/lang/String;)Lc0/g$e0$d;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->l:Lc0/g$e0$d;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/16 v0, 0x80

    goto :goto_23a

    :pswitch_27d
    invoke-static {p2}, Lc0/k;->C0(Ljava/lang/String;)Lc0/g$e0$c;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->k:Lc0/g$e0$c;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/16 v0, 0x40

    goto :goto_23a

    :pswitch_28a
    :try_start_28a
    invoke-static {p2}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->j:Lc0/g$p;

    iget-wide p1, p0, Lc0/g$e0;->c:J
    :try_end_292
    .catch Lc0/j; {:try_start_28a .. :try_end_292} :catch_2d9

    const-wide/16 v0, 0x20

    goto :goto_22b

    :pswitch_295
    invoke-static {p2}, Lc0/k;->r0(Ljava/lang/String;)Ljava/lang/Float;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->i:Ljava/lang/Float;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/16 v0, 0x10

    goto :goto_23a

    :pswitch_2a2
    invoke-static {p2}, Lc0/k;->t0(Ljava/lang/String;)Lc0/g$o0;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->h:Lc0/g$o0;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/16 v0, 0x8

    goto :goto_23a

    :pswitch_2af
    invoke-static {p2}, Lc0/k;->r0(Ljava/lang/String;)Ljava/lang/Float;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->g:Ljava/lang/Float;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/16 v0, 0x4

    goto/16 :goto_23a

    :pswitch_2bd
    invoke-static {p2}, Lc0/k;->e0(Ljava/lang/String;)Lc0/g$e0$a;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->f:Lc0/g$e0$a;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/16 v0, 0x2

    goto/16 :goto_23a

    :pswitch_2cb
    invoke-static {p2}, Lc0/k;->t0(Ljava/lang/String;)Lc0/g$o0;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->d:Lc0/g$o0;

    if-eqz p1, :cond_2d9

    iget-wide p1, p0, Lc0/g$e0;->c:J

    const-wide/16 v0, 0x1

    goto/16 :goto_23a

    :catch_2d9
    :cond_2d9
    :goto_2d9
    return-void

    :pswitch_data_2da
    .packed-switch 0x2f
        :pswitch_2cb
        :pswitch_2bd
        :pswitch_2af
        :pswitch_2a2
        :pswitch_295
        :pswitch_28a
        :pswitch_27d
        :pswitch_270
        :pswitch_261
        :pswitch_24a
        :pswitch_23f
        :pswitch_230
        :pswitch_221
        :pswitch_21c
        :pswitch_20f
        :pswitch_202
        :pswitch_1f4
        :pswitch_1e6
        :pswitch_1d8
        :pswitch_1c8
        :pswitch_1b9
        :pswitch_1aa
        :pswitch_199
        :pswitch_18c
        :pswitch_17f
        :pswitch_172
        :pswitch_13d
        :pswitch_108
        :pswitch_e4
        :pswitch_d7
        :pswitch_c8
        :pswitch_bb
        :pswitch_ae
        :pswitch_a1
        :pswitch_85
        :pswitch_76
        :pswitch_5a
        :pswitch_4b
        :pswitch_3a
        :pswitch_29
    .end packed-switch
.end method

.method private T(Lc0/g$u0;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_40

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    const/4 v3, 0x6

    if-eq v2, v3, :cond_23

    goto :goto_3d

    :cond_23
    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getURI(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3b

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getURI(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, "http://www.w3.org/1999/xlink"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3d

    :cond_3b
    iput-object v1, p1, Lc0/g$u0;->o:Ljava/lang/String;

    :cond_3d
    :goto_3d
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_40
    return-void
.end method

.method private T0(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<radialGradient>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_2d

    new-instance v0, Lc0/g$q0;

    invoke-direct {v0}, Lc0/g$q0;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->F(Lc0/g$j;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->O(Lc0/g$q0;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    return-void

    :cond_2d
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private U(Lc0/g$z0;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_4b

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    const/4 v3, 0x6

    if-eq v2, v3, :cond_2e

    const/16 v3, 0x27

    if-eq v2, v3, :cond_27

    goto :goto_48

    :cond_27
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$z0;->p:Lc0/g$p;

    goto :goto_48

    :cond_2e
    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getURI(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_46

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getURI(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, "http://www.w3.org/1999/xlink"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_48

    :cond_46
    iput-object v1, p1, Lc0/g$z0;->o:Ljava/lang/String;

    :cond_48
    :goto_48
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_4b
    return-void
.end method

.method private U0(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<rect>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_2e

    new-instance v0, Lc0/g$b0;

    invoke-direct {v0}, Lc0/g$b0;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->W(Lc0/g$n;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->P(Lc0/g$b0;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    return-void

    :cond_2e
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private V(Lc0/g$a1;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_4c

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    const/4 v3, 0x1

    if-eq v2, v3, :cond_43

    const/4 v3, 0x2

    if-eq v2, v3, :cond_3c

    const/16 v3, 0x13

    if-eq v2, v3, :cond_35

    const/16 v3, 0x14

    if-eq v2, v3, :cond_2e

    goto :goto_49

    :cond_2e
    invoke-static {v1}, Lc0/k;->p0(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    iput-object v1, p1, Lc0/g$a1;->r:Ljava/util/List;

    goto :goto_49

    :cond_35
    invoke-static {v1}, Lc0/k;->p0(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    iput-object v1, p1, Lc0/g$a1;->q:Ljava/util/List;

    goto :goto_49

    :cond_3c
    invoke-static {v1}, Lc0/k;->p0(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    iput-object v1, p1, Lc0/g$a1;->p:Ljava/util/List;

    goto :goto_49

    :cond_43
    invoke-static {v1}, Lc0/k;->p0(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    iput-object v1, p1, Lc0/g$a1;->o:Ljava/util/List;

    :goto_49
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_4c
    return-void
.end method

.method private V0(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<solidColor>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_27

    new-instance v0, Lc0/g$c0;

    invoke-direct {v0}, Lc0/g$c0;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    return-void

    :cond_27
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private W(Lc0/g$n;Lorg/xml/sax/Attributes;)V
    .registers 6

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_21

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v1

    sget-object v2, Lc0/k$g;->B0:Lc0/k$g;

    if-ne v1, v2, :cond_1e

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lc0/k;->J0(Ljava/lang/String;)Landroid/graphics/Matrix;

    move-result-object v1

    invoke-interface {p1, v1}, Lc0/g$n;->j(Landroid/graphics/Matrix;)V

    :cond_1e
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_21
    return-void
.end method

.method private W0()V
    .registers 2

    new-instance v0, Lc0/g;

    invoke-direct {v0}, Lc0/g;-><init>()V

    iput-object v0, p0, Lc0/k;->a:Lc0/g;

    return-void
.end method

.method private X(Lc0/g$e1;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_85

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    const/4 v3, 0x1

    if-eq v2, v3, :cond_7b

    const/4 v3, 0x2

    if-eq v2, v3, :cond_74

    const/4 v3, 0x3

    if-eq v2, v3, :cond_5f

    const/4 v3, 0x4

    if-eq v2, v3, :cond_4a

    const/4 v3, 0x6

    if-eq v2, v3, :cond_2f

    goto :goto_81

    :cond_2f
    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getURI(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_47

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getURI(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, "http://www.w3.org/1999/xlink"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_81

    :cond_47
    iput-object v1, p1, Lc0/g$e1;->p:Ljava/lang/String;

    goto :goto_81

    :cond_4a
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$e1;->t:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_57

    goto :goto_81

    :cond_57
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <use> element. height cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_5f
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$e1;->s:Lc0/g$p;

    invoke-virtual {v1}, Lc0/g$p;->g()Z

    move-result v1

    if-nez v1, :cond_6c

    goto :goto_81

    :cond_6c
    new-instance p1, Lc0/j;

    const-string p2, "Invalid <use> element. width cannot be negative"

    invoke-direct {p1, p2}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_74
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$e1;->r:Lc0/g$p;

    goto :goto_81

    :cond_7b
    invoke-static {v1}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v1

    iput-object v1, p1, Lc0/g$e1;->q:Lc0/g$p;

    :cond_81
    :goto_81
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_1

    :cond_85
    return-void
.end method

.method private X0(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/xml/sax/Attributes;)V
    .registers 7

    iget-boolean v0, p0, Lc0/k;->c:Z

    const/4 v1, 0x1

    if-eqz v0, :cond_b

    iget p1, p0, Lc0/k;->d:I

    add-int/2addr p1, v1

    iput p1, p0, Lc0/k;->d:I

    return-void

    :cond_b
    const-string v0, "http://www.w3.org/2000/svg"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1c

    const-string v0, ""

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_1c

    return-void

    :cond_1c
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result p1

    if-lez p1, :cond_23

    goto :goto_24

    :cond_23
    move-object p2, p3

    :goto_24
    invoke-static {p2}, Lc0/k$h;->a(Ljava/lang/String;)Lc0/k$h;

    move-result-object p1

    sget-object p2, Lc0/k$a;->a:[I

    invoke-virtual {p1}, Ljava/lang/Enum;->ordinal()I

    move-result p3

    aget p2, p2, p3

    packed-switch p2, :pswitch_data_b6

    iput-boolean v1, p0, Lc0/k;->c:Z

    iput v1, p0, Lc0/k;->d:I

    goto/16 :goto_b4

    :pswitch_39
    invoke-direct {p0, p4}, Lc0/k;->V0(Lorg/xml/sax/Attributes;)V

    goto/16 :goto_b4

    :pswitch_3e
    invoke-direct {p0, p4}, Lc0/k;->Z0(Lorg/xml/sax/Attributes;)V

    goto/16 :goto_b4

    :pswitch_43
    invoke-direct {p0, p4}, Lc0/k;->y(Lorg/xml/sax/Attributes;)V

    goto/16 :goto_b4

    :pswitch_48
    invoke-direct {p0, p4}, Lc0/k;->j1(Lorg/xml/sax/Attributes;)V

    goto/16 :goto_b4

    :pswitch_4d
    invoke-direct {p0, p4}, Lc0/k;->u(Lorg/xml/sax/Attributes;)V

    goto/16 :goto_b4

    :pswitch_52
    invoke-direct {p0, p4}, Lc0/k;->P0(Lorg/xml/sax/Attributes;)V

    goto/16 :goto_b4

    :pswitch_57
    invoke-direct {p0, p4}, Lc0/k;->f1(Lorg/xml/sax/Attributes;)V

    goto/16 :goto_b4

    :pswitch_5c
    invoke-direct {p0, p4}, Lc0/k;->k(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_60
    iput-boolean v1, p0, Lc0/k;->e:Z

    iput-object p1, p0, Lc0/k;->f:Lc0/k$h;

    goto :goto_b4

    :pswitch_65
    invoke-direct {p0, p4}, Lc0/k;->Y0(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_69
    invoke-direct {p0, p4}, Lc0/k;->T0(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_6d
    invoke-direct {p0, p4}, Lc0/k;->w(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_71
    invoke-direct {p0, p4}, Lc0/k;->x(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_75
    invoke-direct {p0, p4}, Lc0/k;->b1(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_79
    invoke-direct {p0, p4}, Lc0/k;->k1(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_7d
    invoke-direct {p0, p4}, Lc0/k;->g1(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_81
    invoke-direct {p0, p4}, Lc0/k;->h1(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_85
    invoke-direct {p0, p4}, Lc0/k;->d1(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_89
    invoke-direct {p0, p4}, Lc0/k;->Q0(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_8d
    invoke-direct {p0, p4}, Lc0/k;->R0(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_91
    invoke-direct {p0, p4}, Lc0/k;->v(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_95
    invoke-direct {p0, p4}, Lc0/k;->n(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_99
    invoke-direct {p0, p4}, Lc0/k;->i(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_9d
    invoke-direct {p0, p4}, Lc0/k;->U0(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_a1
    invoke-direct {p0, p4}, Lc0/k;->O0(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_a5
    invoke-direct {p0, p4}, Lc0/k;->i1(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_a9
    invoke-direct {p0, p4}, Lc0/k;->m(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_ad
    invoke-direct {p0, p4}, Lc0/k;->q(Lorg/xml/sax/Attributes;)V

    goto :goto_b4

    :pswitch_b1
    invoke-direct {p0, p4}, Lc0/k;->a1(Lorg/xml/sax/Attributes;)V

    :goto_b4
    return-void

    nop

    :pswitch_data_b6
    .packed-switch 0x1
        :pswitch_b1
        :pswitch_ad
        :pswitch_ad
        :pswitch_a9
        :pswitch_a5
        :pswitch_a1
        :pswitch_9d
        :pswitch_99
        :pswitch_95
        :pswitch_91
        :pswitch_8d
        :pswitch_89
        :pswitch_85
        :pswitch_81
        :pswitch_7d
        :pswitch_79
        :pswitch_75
        :pswitch_71
        :pswitch_6d
        :pswitch_69
        :pswitch_65
        :pswitch_60
        :pswitch_60
        :pswitch_5c
        :pswitch_57
        :pswitch_52
        :pswitch_4d
        :pswitch_48
        :pswitch_43
        :pswitch_3e
        :pswitch_39
    .end packed-switch
.end method

.method private Y(Lc0/g$r0;Lorg/xml/sax/Attributes;)V
    .registers 7

    const/4 v0, 0x0

    :goto_1
    invoke-interface {p2}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v1

    if-ge v0, v1, :cond_34

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lc0/k$a;->b:[I

    invoke-interface {p2, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    move-result v3

    aget v2, v2, v3

    const/4 v3, 0x7

    if-eq v2, v3, :cond_2e

    const/16 v3, 0x57

    if-eq v2, v3, :cond_27

    goto :goto_31

    :cond_27
    invoke-static {v1}, Lc0/k;->N0(Ljava/lang/String;)Lc0/g$b;

    move-result-object v1

    iput-object v1, p1, Lc0/g$r0;->p:Lc0/g$b;

    goto :goto_31

    :cond_2e
    invoke-static {p1, v1}, Lc0/k;->w0(Lc0/g$p0;Ljava/lang/String;)V

    :goto_31
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_34
    return-void
.end method

.method private Y0(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<stop>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_36

    instance-of v0, v0, Lc0/g$j;

    if-eqz v0, :cond_2e

    new-instance v0, Lc0/g$d0;

    invoke-direct {v0}, Lc0/g$d0;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->R(Lc0/g$d0;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    return-void

    :cond_2e
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements."

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_36
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private Z(Ljava/lang/String;)V
    .registers 5

    new-instance v0, Lc0/b;

    sget-object v1, Lc0/b$f;->k:Lc0/b$f;

    sget-object v2, Lc0/b$u;->c:Lc0/b$u;

    invoke-direct {v0, v1, v2}, Lc0/b;-><init>(Lc0/b$f;Lc0/b$u;)V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    invoke-virtual {v0, p1}, Lc0/b;->d(Ljava/lang/String;)Lc0/b$r;

    move-result-object p1

    invoke-virtual {v1, p1}, Lc0/g;->a(Lc0/b$r;)V

    return-void
.end method

.method private Z0(Lorg/xml/sax/Attributes;)V
    .registers 9

    const/4 v0, 0x0

    new-array v1, v0, [Ljava/lang/Object;

    const-string v2, "<style>"

    invoke-direct {p0, v2, v1}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v1, :cond_54

    const/4 v1, 0x1

    const-string v2, "all"

    const/4 v3, 0x1

    :goto_10
    invoke-interface {p1}, Lorg/xml/sax/Attributes;->getLength()I

    move-result v4

    if-ge v0, v4, :cond_42

    invoke-interface {p1, v0}, Lorg/xml/sax/Attributes;->getValue(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lc0/k$a;->b:[I

    invoke-interface {p1, v0}, Lorg/xml/sax/Attributes;->getLocalName(I)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lc0/k$g;->a(Ljava/lang/String;)Lc0/k$g;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Enum;->ordinal()I

    move-result v6

    aget v5, v5, v6

    const/16 v6, 0x58

    if-eq v5, v6, :cond_39

    const/16 v6, 0x59

    if-eq v5, v6, :cond_37

    goto :goto_3f

    :cond_37
    move-object v2, v4

    goto :goto_3f

    :cond_39
    const-string v3, "text/css"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    :goto_3f
    add-int/lit8 v0, v0, 0x1

    goto :goto_10

    :cond_42
    if-eqz v3, :cond_4f

    sget-object p1, Lc0/b$f;->k:Lc0/b$f;

    invoke-static {v2, p1}, Lc0/b;->b(Ljava/lang/String;Lc0/b$f;)Z

    move-result p1

    if-eqz p1, :cond_4f

    iput-boolean v1, p0, Lc0/k;->h:Z

    goto :goto_53

    :cond_4f
    iput-boolean v1, p0, Lc0/k;->c:Z

    iput v1, p0, Lc0/k;->d:I

    :goto_53
    return-void

    :cond_54
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method static synthetic a(Lc0/k;)V
    .registers 1

    invoke-direct {p0}, Lc0/k;->W0()V

    return-void
.end method

.method private static a0(Ljava/lang/String;)Lc0/g$c;
    .registers 7

    const-string v0, "auto"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_a

    return-object v1

    :cond_a
    const-string v0, "rect("

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_13

    return-object v1

    :cond_13
    new-instance v0, Lc0/k$i;

    const/4 v2, 0x5

    invoke-virtual {p0, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lc0/k$i;->A()V

    invoke-static {v0}, Lc0/k;->q0(Lc0/k$i;)Lc0/g$p;

    move-result-object p0

    invoke-virtual {v0}, Lc0/k$i;->z()Z

    invoke-static {v0}, Lc0/k;->q0(Lc0/k$i;)Lc0/g$p;

    move-result-object v2

    invoke-virtual {v0}, Lc0/k$i;->z()Z

    invoke-static {v0}, Lc0/k;->q0(Lc0/k$i;)Lc0/g$p;

    move-result-object v3

    invoke-virtual {v0}, Lc0/k$i;->z()Z

    invoke-static {v0}, Lc0/k;->q0(Lc0/k$i;)Lc0/g$p;

    move-result-object v4

    invoke-virtual {v0}, Lc0/k$i;->A()V

    const/16 v5, 0x29

    invoke-virtual {v0, v5}, Lc0/k$i;->f(C)Z

    move-result v5

    if-nez v5, :cond_4b

    invoke-virtual {v0}, Lc0/k$i;->h()Z

    move-result v0

    if-nez v0, :cond_4b

    return-object v1

    :cond_4b
    new-instance v0, Lc0/g$c;

    invoke-direct {v0, p0, v2, v3, v4}, Lc0/g$c;-><init>(Lc0/g$p;Lc0/g$p;Lc0/g$p;Lc0/g$p;)V

    return-object v0
.end method

.method private a1(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<svg>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    new-instance v0, Lc0/g$f0;

    invoke-direct {v0}, Lc0/g$f0;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->Y(Lc0/g$r0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->Q(Lc0/g$f0;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    if-nez p1, :cond_2e

    iget-object p1, p0, Lc0/k;->a:Lc0/g;

    invoke-virtual {p1, v0}, Lc0/g;->p(Lc0/g$f0;)V

    goto :goto_31

    :cond_2e
    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    :goto_31
    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    return-void
.end method

.method static synthetic b(Lc0/k;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/xml/sax/Attributes;)V
    .registers 5

    invoke-direct {p0, p1, p2, p3, p4}, Lc0/k;->X0(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/xml/sax/Attributes;)V

    return-void
.end method

.method private static b0(Ljava/lang/String;)Lc0/g$f;
    .registers 12

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/4 v1, 0x5

    const/high16 v2, -0x1000000

    const/4 v3, 0x4

    const/16 v4, 0x23

    if-ne v0, v4, :cond_b6

    const/4 v0, 0x1

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    invoke-static {p0, v0, v4}, Lc0/c;->b(Ljava/lang/String;II)Lc0/c;

    move-result-object v0

    const-string v4, "Bad hex colour value: "

    if-eqz v0, :cond_a1

    invoke-virtual {v0}, Lc0/c;->a()I

    move-result v5

    if-eq v5, v3, :cond_82

    if-eq v5, v1, :cond_5c

    const/4 v1, 0x7

    if-eq v5, v1, :cond_51

    const/16 v1, 0x9

    if-ne v5, v1, :cond_3c

    new-instance p0, Lc0/g$f;

    invoke-virtual {v0}, Lc0/c;->d()I

    move-result v1

    shl-int/lit8 v1, v1, 0x18

    invoke-virtual {v0}, Lc0/c;->d()I

    move-result v0

    ushr-int/lit8 v0, v0, 0x8

    or-int/2addr v0, v1

    invoke-direct {p0, v0}, Lc0/g$f;-><init>(I)V

    return-object p0

    :cond_3c
    new-instance v0, Lc0/j;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_51
    new-instance p0, Lc0/g$f;

    invoke-virtual {v0}, Lc0/c;->d()I

    move-result v0

    or-int/2addr v0, v2

    invoke-direct {p0, v0}, Lc0/g$f;-><init>(I)V

    return-object p0

    :cond_5c
    invoke-virtual {v0}, Lc0/c;->d()I

    move-result p0

    const v0, 0xf000

    and-int/2addr v0, p0

    and-int/lit16 v1, p0, 0xf00

    and-int/lit16 v2, p0, 0xf0

    and-int/lit8 p0, p0, 0xf

    new-instance v4, Lc0/g$f;

    shl-int/lit8 v5, p0, 0x1c

    shl-int/lit8 p0, p0, 0x18

    or-int/2addr p0, v5

    shl-int/lit8 v5, v0, 0x8

    or-int/2addr p0, v5

    shl-int/2addr v0, v3

    or-int/2addr p0, v0

    shl-int/lit8 v0, v1, 0x4

    or-int/2addr p0, v0

    or-int/2addr p0, v1

    or-int/2addr p0, v2

    shr-int/lit8 v0, v2, 0x4

    or-int/2addr p0, v0

    invoke-direct {v4, p0}, Lc0/g$f;-><init>(I)V

    return-object v4

    :cond_82
    invoke-virtual {v0}, Lc0/c;->d()I

    move-result p0

    and-int/lit16 v0, p0, 0xf00

    and-int/lit16 v1, p0, 0xf0

    and-int/lit8 p0, p0, 0xf

    new-instance v4, Lc0/g$f;

    shl-int/lit8 v5, v0, 0xc

    or-int/2addr v2, v5

    shl-int/lit8 v0, v0, 0x8

    or-int/2addr v0, v2

    shl-int/lit8 v2, v1, 0x8

    or-int/2addr v0, v2

    shl-int/2addr v1, v3

    or-int/2addr v0, v1

    shl-int/lit8 v1, p0, 0x4

    or-int/2addr v0, v1

    or-int/2addr p0, v0

    invoke-direct {v4, p0}, Lc0/g$f;-><init>(I)V

    return-object v4

    :cond_a1
    new-instance v0, Lc0/j;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_b6
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p0, v0}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v4, "rgba("

    invoke-virtual {v0, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    const/16 v5, 0x29

    const/high16 v6, 0x43800000    # 256.0f

    const/16 v7, 0x25

    if-nez v4, :cond_188

    const-string v8, "rgb("

    invoke-virtual {v0, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_d4

    goto/16 :goto_188

    :cond_d4
    const-string v4, "hsla("

    invoke-virtual {v0, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_ea

    const-string v8, "hsl("

    invoke-virtual {v0, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_e5

    goto :goto_ea

    :cond_e5
    invoke-static {v0}, Lc0/k;->c0(Ljava/lang/String;)Lc0/g$f;

    move-result-object p0

    return-object p0

    :cond_ea
    :goto_ea
    new-instance v0, Lc0/k$i;

    if-eqz v4, :cond_ef

    goto :goto_f0

    :cond_ef
    const/4 v1, 0x4

    :goto_f0
    invoke-virtual {p0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lc0/k$i;->A()V

    invoke-virtual {v0}, Lc0/k$i;->n()F

    move-result v1

    invoke-virtual {v0, v1}, Lc0/k$i;->d(F)F

    move-result v3

    invoke-static {v3}, Ljava/lang/Float;->isNaN(F)Z

    move-result v8

    if-nez v8, :cond_10b

    invoke-virtual {v0, v7}, Lc0/k$i;->f(C)Z

    :cond_10b
    invoke-virtual {v0, v3}, Lc0/k$i;->d(F)F

    move-result v8

    invoke-static {v8}, Ljava/lang/Float;->isNaN(F)Z

    move-result v9

    if-nez v9, :cond_118

    invoke-virtual {v0, v7}, Lc0/k$i;->f(C)Z

    :cond_118
    if-eqz v4, :cond_157

    invoke-virtual {v0, v8}, Lc0/k$i;->d(F)F

    move-result v2

    invoke-virtual {v0}, Lc0/k$i;->A()V

    invoke-static {v2}, Ljava/lang/Float;->isNaN(F)Z

    move-result v4

    if-nez v4, :cond_140

    invoke-virtual {v0, v5}, Lc0/k$i;->f(C)Z

    move-result v0

    if-eqz v0, :cond_140

    new-instance p0, Lc0/g$f;

    mul-float v2, v2, v6

    invoke-static {v2}, Lc0/k;->j(F)I

    move-result v0

    shl-int/lit8 v0, v0, 0x18

    invoke-static {v1, v3, v8}, Lc0/k;->s(FFF)I

    move-result v1

    or-int/2addr v0, v1

    invoke-direct {p0, v0}, Lc0/g$f;-><init>(I)V

    return-object p0

    :cond_140
    new-instance v0, Lc0/j;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Bad hsla() colour value: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_157
    invoke-virtual {v0}, Lc0/k$i;->A()V

    invoke-static {v8}, Ljava/lang/Float;->isNaN(F)Z

    move-result v4

    if-nez v4, :cond_171

    invoke-virtual {v0, v5}, Lc0/k$i;->f(C)Z

    move-result v0

    if-eqz v0, :cond_171

    new-instance p0, Lc0/g$f;

    invoke-static {v1, v3, v8}, Lc0/k;->s(FFF)I

    move-result v0

    or-int/2addr v0, v2

    invoke-direct {p0, v0}, Lc0/g$f;-><init>(I)V

    return-object p0

    :cond_171
    new-instance v0, Lc0/j;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Bad hsl() colour value: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_188
    :goto_188
    new-instance v0, Lc0/k$i;

    if-eqz v4, :cond_18d

    goto :goto_18e

    :cond_18d
    const/4 v1, 0x4

    :goto_18e
    invoke-virtual {p0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lc0/k$i;->A()V

    invoke-virtual {v0}, Lc0/k$i;->n()F

    move-result v1

    invoke-static {v1}, Ljava/lang/Float;->isNaN(F)Z

    move-result v3

    const/high16 v8, 0x42c80000    # 100.0f

    if-nez v3, :cond_1ad

    invoke-virtual {v0, v7}, Lc0/k$i;->f(C)Z

    move-result v3

    if-eqz v3, :cond_1ad

    mul-float v1, v1, v6

    div-float/2addr v1, v8

    :cond_1ad
    invoke-virtual {v0, v1}, Lc0/k$i;->d(F)F

    move-result v3

    invoke-static {v3}, Ljava/lang/Float;->isNaN(F)Z

    move-result v9

    if-nez v9, :cond_1c0

    invoke-virtual {v0, v7}, Lc0/k$i;->f(C)Z

    move-result v9

    if-eqz v9, :cond_1c0

    mul-float v3, v3, v6

    div-float/2addr v3, v8

    :cond_1c0
    invoke-virtual {v0, v3}, Lc0/k$i;->d(F)F

    move-result v9

    invoke-static {v9}, Ljava/lang/Float;->isNaN(F)Z

    move-result v10

    if-nez v10, :cond_1d3

    invoke-virtual {v0, v7}, Lc0/k$i;->f(C)Z

    move-result v7

    if-eqz v7, :cond_1d3

    mul-float v9, v9, v6

    div-float/2addr v9, v8

    :cond_1d3
    if-eqz v4, :cond_220

    invoke-virtual {v0, v9}, Lc0/k$i;->d(F)F

    move-result v2

    invoke-virtual {v0}, Lc0/k$i;->A()V

    invoke-static {v2}, Ljava/lang/Float;->isNaN(F)Z

    move-result v4

    if-nez v4, :cond_209

    invoke-virtual {v0, v5}, Lc0/k$i;->f(C)Z

    move-result v0

    if-eqz v0, :cond_209

    new-instance p0, Lc0/g$f;

    mul-float v2, v2, v6

    invoke-static {v2}, Lc0/k;->j(F)I

    move-result v0

    shl-int/lit8 v0, v0, 0x18

    invoke-static {v1}, Lc0/k;->j(F)I

    move-result v1

    shl-int/lit8 v1, v1, 0x10

    or-int/2addr v0, v1

    invoke-static {v3}, Lc0/k;->j(F)I

    move-result v1

    shl-int/lit8 v1, v1, 0x8

    or-int/2addr v0, v1

    invoke-static {v9}, Lc0/k;->j(F)I

    move-result v1

    or-int/2addr v0, v1

    invoke-direct {p0, v0}, Lc0/g$f;-><init>(I)V

    return-object p0

    :cond_209
    new-instance v0, Lc0/j;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Bad rgba() colour value: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_220
    invoke-virtual {v0}, Lc0/k$i;->A()V

    invoke-static {v9}, Ljava/lang/Float;->isNaN(F)Z

    move-result v4

    if-nez v4, :cond_248

    invoke-virtual {v0, v5}, Lc0/k$i;->f(C)Z

    move-result v0

    if-eqz v0, :cond_248

    new-instance p0, Lc0/g$f;

    invoke-static {v1}, Lc0/k;->j(F)I

    move-result v0

    shl-int/lit8 v0, v0, 0x10

    or-int/2addr v0, v2

    invoke-static {v3}, Lc0/k;->j(F)I

    move-result v1

    shl-int/lit8 v1, v1, 0x8

    or-int/2addr v0, v1

    invoke-static {v9}, Lc0/k;->j(F)I

    move-result v1

    or-int/2addr v0, v1

    invoke-direct {p0, v0}, Lc0/g$f;-><init>(I)V

    return-object p0

    :cond_248
    new-instance v0, Lc0/j;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Bad rgb() colour value: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private b1(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<symbol>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_2d

    new-instance v0, Lc0/g$t0;

    invoke-direct {v0}, Lc0/g$t0;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->Y(Lc0/g$r0;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    return-void

    :cond_2d
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method static synthetic c(Lc0/k;Ljava/lang/String;)V
    .registers 2

    invoke-direct {p0, p1}, Lc0/k;->c1(Ljava/lang/String;)V

    return-void
.end method

.method private static c0(Ljava/lang/String;)Lc0/g$f;
    .registers 4

    invoke-static {p0}, Lc0/k$c;->a(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    if-eqz v0, :cond_10

    new-instance p0, Lc0/g$f;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-direct {p0, v0}, Lc0/g$f;-><init>(I)V

    return-object p0

    :cond_10
    new-instance v0, Lc0/j;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid colour keyword: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private c1(Ljava/lang/String;)V
    .registers 4

    iget-boolean v0, p0, Lc0/k;->c:Z

    if-eqz v0, :cond_5

    return-void

    :cond_5
    iget-boolean v0, p0, Lc0/k;->e:Z

    if-eqz v0, :cond_1e

    iget-object v0, p0, Lc0/k;->g:Ljava/lang/StringBuilder;

    if-nez v0, :cond_18

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    iput-object v0, p0, Lc0/k;->g:Ljava/lang/StringBuilder;

    :cond_18
    iget-object v0, p0, Lc0/k;->g:Ljava/lang/StringBuilder;

    :goto_1a
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_3d

    :cond_1e
    iget-boolean v0, p0, Lc0/k;->h:Z

    if-eqz v0, :cond_34

    iget-object v0, p0, Lc0/k;->i:Ljava/lang/StringBuilder;

    if-nez v0, :cond_31

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    iput-object v0, p0, Lc0/k;->i:Ljava/lang/StringBuilder;

    :cond_31
    iget-object v0, p0, Lc0/k;->i:Ljava/lang/StringBuilder;

    goto :goto_1a

    :cond_34
    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    instance-of v0, v0, Lc0/g$y0;

    if-eqz v0, :cond_3d

    invoke-direct {p0, p1}, Lc0/k;->h(Ljava/lang/String;)V

    :cond_3d
    :goto_3d
    return-void
.end method

.method static synthetic d(Lc0/k;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 4

    invoke-direct {p0, p1, p2, p3}, Lc0/k;->p(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private static d0(Ljava/lang/String;)Lc0/g$o0;
    .registers 2

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    const-string v0, "none"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1f

    const-string v0, "currentColor"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1a

    :try_start_13
    invoke-static {p0}, Lc0/k;->b0(Ljava/lang/String;)Lc0/g$f;

    move-result-object p0
    :try_end_17
    .catch Lc0/j; {:try_start_13 .. :try_end_17} :catch_18

    return-object p0

    :catch_18
    const/4 p0, 0x0

    return-object p0

    :cond_1a
    invoke-static {}, Lc0/g$g;->a()Lc0/g$g;

    move-result-object p0

    return-object p0

    :cond_1f
    sget-object p0, Lc0/g$f;->f:Lc0/g$f;

    return-object p0
.end method

.method private d1(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<text>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_30

    new-instance v0, Lc0/g$w0;

    invoke-direct {v0}, Lc0/g$w0;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->W(Lc0/g$n;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->V(Lc0/g$a1;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    return-void

    :cond_30
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method static synthetic e(Lc0/k;)V
    .registers 1

    invoke-direct {p0}, Lc0/k;->o()V

    return-void
.end method

.method private static e0(Ljava/lang/String;)Lc0/g$e0$a;
    .registers 2

    const-string v0, "nonzero"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    sget-object p0, Lc0/g$e0$a;->c:Lc0/g$e0$a;

    return-object p0

    :cond_b
    const-string v0, "evenodd"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_16

    sget-object p0, Lc0/g$e0$a;->d:Lc0/g$e0$a;

    return-object p0

    :cond_16
    const/4 p0, 0x0

    return-object p0
.end method

.method private e1([CII)V
    .registers 5

    iget-boolean v0, p0, Lc0/k;->c:Z

    if-eqz v0, :cond_5

    return-void

    :cond_5
    iget-boolean v0, p0, Lc0/k;->e:Z

    if-eqz v0, :cond_1a

    iget-object v0, p0, Lc0/k;->g:Ljava/lang/StringBuilder;

    if-nez v0, :cond_14

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, p3}, Ljava/lang/StringBuilder;-><init>(I)V

    iput-object v0, p0, Lc0/k;->g:Ljava/lang/StringBuilder;

    :cond_14
    iget-object v0, p0, Lc0/k;->g:Ljava/lang/StringBuilder;

    :goto_16
    invoke-virtual {v0, p1, p2, p3}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;

    goto :goto_3a

    :cond_1a
    iget-boolean v0, p0, Lc0/k;->h:Z

    if-eqz v0, :cond_2c

    iget-object v0, p0, Lc0/k;->i:Ljava/lang/StringBuilder;

    if-nez v0, :cond_29

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, p3}, Ljava/lang/StringBuilder;-><init>(I)V

    iput-object v0, p0, Lc0/k;->i:Ljava/lang/StringBuilder;

    :cond_29
    iget-object v0, p0, Lc0/k;->i:Ljava/lang/StringBuilder;

    goto :goto_16

    :cond_2c
    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    instance-of v0, v0, Lc0/g$y0;

    if-eqz v0, :cond_3a

    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, p1, p2, p3}, Ljava/lang/String;-><init>([CII)V

    invoke-direct {p0, v0}, Lc0/k;->h(Ljava/lang/String;)V

    :cond_3a
    :goto_3a
    return-void
.end method

.method static synthetic f(Lc0/k;Lc0/k$i;)Ljava/util/Map;
    .registers 2

    invoke-direct {p0, p1}, Lc0/k;->x0(Lc0/k$i;)Ljava/util/Map;

    move-result-object p0

    return-object p0
.end method

.method private static f0(Ljava/lang/String;)F
    .registers 3

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_c

    const/4 v1, 0x0

    invoke-static {p0, v1, v0}, Lc0/k;->g0(Ljava/lang/String;II)F

    move-result p0

    return p0

    :cond_c
    new-instance p0, Lc0/j;

    const-string v0, "Invalid float value (empty string)"

    invoke-direct {p0, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method private f1(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<textPath>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_3f

    new-instance v0, Lc0/g$z0;

    invoke-direct {v0}, Lc0/g$z0;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->U(Lc0/g$z0;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    iget-object p1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    instance-of v1, p1, Lc0/g$b1;

    if-eqz v1, :cond_35

    check-cast p1, Lc0/g$b1;

    goto :goto_3b

    :cond_35
    check-cast p1, Lc0/g$x0;

    invoke-interface {p1}, Lc0/g$x0;->f()Lc0/g$b1;

    move-result-object p1

    :goto_3b
    invoke-virtual {v0, p1}, Lc0/g$z0;->o(Lc0/g$b1;)V

    return-void

    :cond_3f
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method static synthetic g(Lc0/k;Ljava/lang/String;Ljava/util/Map;)V
    .registers 3

    invoke-direct {p0, p1, p2}, Lc0/k;->r(Ljava/lang/String;Ljava/util/Map;)V

    return-void
.end method

.method private static g0(Ljava/lang/String;II)F
    .registers 4

    new-instance v0, Lc0/d;

    invoke-direct {v0}, Lc0/d;-><init>()V

    invoke-virtual {v0, p0, p1, p2}, Lc0/d;->b(Ljava/lang/String;II)F

    move-result p1

    invoke-static {p1}, Ljava/lang/Float;->isNaN(F)Z

    move-result p2

    if-nez p2, :cond_10

    return p1

    :cond_10
    new-instance p1, Lc0/j;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, "Invalid float value: "

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {p1, p0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private g1(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<tref>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_49

    instance-of v0, v0, Lc0/g$y0;

    if-eqz v0, :cond_41

    new-instance v0, Lc0/g$u0;

    invoke-direct {v0}, Lc0/g$u0;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->T(Lc0/g$u0;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iget-object p1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    instance-of v1, p1, Lc0/g$b1;

    if-eqz v1, :cond_37

    check-cast p1, Lc0/g$b1;

    goto :goto_3d

    :cond_37
    check-cast p1, Lc0/g$x0;

    invoke-interface {p1}, Lc0/g$x0;->f()Lc0/g$b1;

    move-result-object p1

    :goto_3d
    invoke-virtual {v0, p1}, Lc0/g$u0;->o(Lc0/g$b1;)V

    return-void

    :cond_41
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. <tref> elements are only valid inside <text> or <tspan> elements."

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_49
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private h(Ljava/lang/String;)V
    .registers 5

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    check-cast v0, Lc0/g$h0;

    iget-object v1, v0, Lc0/g$h0;->i:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_e

    const/4 v0, 0x0

    goto :goto_18

    :cond_e
    iget-object v0, v0, Lc0/g$h0;->i:Ljava/util/List;

    add-int/lit8 v1, v1, -0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lc0/g$n0;

    :goto_18
    instance-of v1, v0, Lc0/g$c1;

    if-eqz v1, :cond_32

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    check-cast v0, Lc0/g$c1;

    iget-object v2, v0, Lc0/g$c1;->c:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    iput-object p1, v0, Lc0/g$c1;->c:Ljava/lang/String;

    goto :goto_3c

    :cond_32
    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    new-instance v1, Lc0/g$c1;

    invoke-direct {v1, p1}, Lc0/g$c1;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lc0/g$j0;->i(Lc0/g$n0;)V

    :goto_3c
    return-void
.end method

.method private static h0(Lc0/g$e0;Ljava/lang/String;)V
    .registers 8

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v1, 0x7c

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "|caption|icon|menu|message-box|small-caption|status-bar|"

    invoke-virtual {v1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1d

    return-void

    :cond_1d
    new-instance v0, Lc0/k$i;

    invoke-direct {v0, p1}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    const/4 p1, 0x0

    move-object v1, p1

    move-object v2, v1

    :goto_25
    const/16 v3, 0x2f

    invoke-virtual {v0, v3}, Lc0/k$i;->s(C)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lc0/k$i;->A()V

    if-nez v4, :cond_31

    return-void

    :cond_31
    if-eqz p1, :cond_36

    if-eqz v1, :cond_36

    goto :goto_5d

    :cond_36
    const-string v5, "normal"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3f

    goto :goto_25

    :cond_3f
    if-nez p1, :cond_48

    invoke-static {v4}, Lc0/k$e;->a(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object p1

    if-eqz p1, :cond_48

    goto :goto_25

    :cond_48
    if-nez v1, :cond_51

    invoke-static {v4}, Lc0/k;->k0(Ljava/lang/String;)Lc0/g$e0$b;

    move-result-object v1

    if-eqz v1, :cond_51

    goto :goto_25

    :cond_51
    if-nez v2, :cond_5d

    const-string v2, "small-caps"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5d

    move-object v2, v4

    goto :goto_25

    :cond_5d
    :goto_5d
    invoke-static {v4}, Lc0/k;->j0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v2

    invoke-virtual {v0, v3}, Lc0/k$i;->f(C)Z

    move-result v3

    if-eqz v3, :cond_78

    invoke-virtual {v0}, Lc0/k$i;->A()V

    invoke-virtual {v0}, Lc0/k$i;->r()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_75

    :try_start_70
    invoke-static {v3}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;
    :try_end_73
    .catch Lc0/j; {:try_start_70 .. :try_end_73} :catch_74

    goto :goto_75

    :catch_74
    return-void

    :cond_75
    :goto_75
    invoke-virtual {v0}, Lc0/k$i;->A()V

    :cond_78
    invoke-virtual {v0}, Lc0/k$i;->y()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lc0/k;->i0(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lc0/g$e0;->r:Ljava/util/List;

    iput-object v2, p0, Lc0/g$e0;->s:Lc0/g$p;

    if-nez p1, :cond_89

    const/16 p1, 0x190

    goto :goto_8d

    :cond_89
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    :goto_8d
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    iput-object p1, p0, Lc0/g$e0;->t:Ljava/lang/Integer;

    if-nez v1, :cond_97

    sget-object v1, Lc0/g$e0$b;->c:Lc0/g$e0$b;

    :cond_97
    iput-object v1, p0, Lc0/g$e0;->u:Lc0/g$e0$b;

    iget-wide v0, p0, Lc0/g$e0;->c:J

    const-wide/32 v2, 0x1e000

    or-long/2addr v0, v2

    iput-wide v0, p0, Lc0/g$e0;->c:J

    return-void
.end method

.method private h1(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<tspan>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_4b

    instance-of v0, v0, Lc0/g$y0;

    if-eqz v0, :cond_43

    new-instance v0, Lc0/g$v0;

    invoke-direct {v0}, Lc0/g$v0;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->V(Lc0/g$a1;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    iget-object p1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    instance-of v1, p1, Lc0/g$b1;

    if-eqz v1, :cond_39

    check-cast p1, Lc0/g$b1;

    goto :goto_3f

    :cond_39
    check-cast p1, Lc0/g$x0;

    invoke-interface {p1}, Lc0/g$x0;->f()Lc0/g$b1;

    move-result-object p1

    :goto_3f
    invoke-virtual {v0, p1}, Lc0/g$v0;->o(Lc0/g$b1;)V

    return-void

    :cond_43
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements."

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_4b
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private i(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<circle>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_2e

    new-instance v0, Lc0/g$d;

    invoke-direct {v0}, Lc0/g$d;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->W(Lc0/g$n;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->A(Lc0/g$d;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    return-void

    :cond_2e
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private static i0(Ljava/lang/String;)Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    new-instance v0, Lc0/k$i;

    invoke-direct {v0, p0}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    const/4 p0, 0x0

    :cond_6
    invoke-virtual {v0}, Lc0/k$i;->q()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_12

    const/16 v1, 0x2c

    invoke-virtual {v0, v1}, Lc0/k$i;->u(C)Ljava/lang/String;

    move-result-object v1

    :cond_12
    if-nez v1, :cond_15

    goto :goto_28

    :cond_15
    if-nez p0, :cond_1c

    new-instance p0, Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    :cond_1c
    invoke-interface {p0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-virtual {v0}, Lc0/k$i;->z()Z

    invoke-virtual {v0}, Lc0/k$i;->h()Z

    move-result v1

    if-eqz v1, :cond_6

    :goto_28
    return-object p0
.end method

.method private i1(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<use>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_30

    new-instance v0, Lc0/g$e1;

    invoke-direct {v0}, Lc0/g$e1;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->W(Lc0/g$n;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->X(Lc0/g$e1;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    return-void

    :cond_30
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private static j(F)I
    .registers 2

    const/4 v0, 0x0

    cmpg-float v0, p0, v0

    if-gez v0, :cond_7

    const/4 p0, 0x0

    goto :goto_14

    :cond_7
    const/high16 v0, 0x437f0000    # 255.0f

    cmpl-float v0, p0, v0

    if-lez v0, :cond_10

    const/16 p0, 0xff

    goto :goto_14

    :cond_10
    invoke-static {p0}, Ljava/lang/Math;->round(F)I

    move-result p0

    :goto_14
    return p0
.end method

.method private static j0(Ljava/lang/String;)Lc0/g$p;
    .registers 2

    :try_start_0
    invoke-static {p0}, Lc0/k$d;->a(Ljava/lang/String;)Lc0/g$p;

    move-result-object v0

    if-nez v0, :cond_a

    invoke-static {p0}, Lc0/k;->o0(Ljava/lang/String;)Lc0/g$p;

    move-result-object v0
    :try_end_a
    .catch Lc0/j; {:try_start_0 .. :try_end_a} :catch_b

    :cond_a
    return-object v0

    :catch_b
    const/4 p0, 0x0

    return-object p0
.end method

.method private j1(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<view>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_2a

    new-instance v0, Lc0/g$f1;

    invoke-direct {v0}, Lc0/g$f1;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->Y(Lc0/g$r0;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    return-void

    :cond_2a
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private k(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<clipPath>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_30

    new-instance v0, Lc0/g$e;

    invoke-direct {v0}, Lc0/g$e;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->W(Lc0/g$n;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->B(Lc0/g$e;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    return-void

    :cond_30
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private static k0(Ljava/lang/String;)Lc0/g$e0$b;
    .registers 3

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v0

    const/4 v1, -0x1

    sparse-switch v0, :sswitch_data_3a

    goto :goto_2c

    :sswitch_c
    const-string v0, "normal"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_15

    goto :goto_2c

    :cond_15
    const/4 v1, 0x2

    goto :goto_2c

    :sswitch_17
    const-string v0, "italic"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_20

    goto :goto_2c

    :cond_20
    const/4 v1, 0x1

    goto :goto_2c

    :sswitch_22
    const-string v0, "oblique"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_2b

    goto :goto_2c

    :cond_2b
    const/4 v1, 0x0

    :goto_2c
    packed-switch v1, :pswitch_data_48

    const/4 p0, 0x0

    return-object p0

    :pswitch_31
    sget-object p0, Lc0/g$e0$b;->c:Lc0/g$e0$b;

    return-object p0

    :pswitch_34
    sget-object p0, Lc0/g$e0$b;->d:Lc0/g$e0$b;

    return-object p0

    :pswitch_37
    sget-object p0, Lc0/g$e0$b;->f:Lc0/g$e0$b;

    return-object p0

    :sswitch_data_3a
    .sparse-switch
        -0x62ce05cf -> :sswitch_22
        -0x4642c5d0 -> :sswitch_17
        -0x3df94319 -> :sswitch_c
    .end sparse-switch

    :pswitch_data_48
    .packed-switch 0x0
        :pswitch_37
        :pswitch_34
        :pswitch_31
    .end packed-switch
.end method

.method private k1(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<switch>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_2d

    new-instance v0, Lc0/g$s0;

    invoke-direct {v0}, Lc0/g$s0;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->W(Lc0/g$n;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    return-void

    :cond_2d
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private varargs l(Ljava/lang/String;[Ljava/lang/Object;)V
    .registers 3

    return-void
.end method

.method private static l0(Ljava/lang/String;)Ljava/lang/Integer;
    .registers 1

    invoke-static {p0}, Lc0/k$e;->a(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object p0

    return-object p0
.end method

.method private m(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<defs>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_2a

    new-instance v0, Lc0/g$h;

    invoke-direct {v0}, Lc0/g$h;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->W(Lc0/g$n;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    return-void

    :cond_2a
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private static m0(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    const-string p1, "none"

    invoke-virtual {p0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    const/4 v0, 0x0

    if-eqz p1, :cond_a

    return-object v0

    :cond_a
    const-string p1, "url("

    invoke-virtual {p0, p1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result p1

    if-nez p1, :cond_13

    return-object v0

    :cond_13
    const-string p1, ")"

    invoke-virtual {p0, p1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result p1

    const/4 v0, 0x4

    if-eqz p1, :cond_2b

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result p1

    add-int/lit8 p1, p1, -0x1

    invoke-virtual {p0, v0, p1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0

    :goto_26
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_2b
    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    goto :goto_26
.end method

.method private n(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<ellipse>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_2e

    new-instance v0, Lc0/g$i;

    invoke-direct {v0}, Lc0/g$i;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->W(Lc0/g$n;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->E(Lc0/g$i;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    return-void

    :cond_2e
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private n0(Ljava/lang/String;)Ljava/lang/Float;
    .registers 7

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_50

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v2, 0x1

    sub-int/2addr v1, v2

    invoke-virtual {p1, v1}, Ljava/lang/String;->charAt(I)C

    move-result v1

    const/16 v3, 0x25

    const/4 v4, 0x0

    if-ne v1, v3, :cond_1c

    add-int/lit8 v0, v0, -0x1

    goto :goto_1d

    :cond_1c
    const/4 v2, 0x0

    :goto_1d
    :try_start_1d
    invoke-static {p1, v4, v0}, Lc0/k;->g0(Ljava/lang/String;II)F

    move-result v0

    const/high16 v1, 0x42c80000    # 100.0f

    if-eqz v2, :cond_26

    div-float/2addr v0, v1

    :cond_26
    const/4 v2, 0x0

    cmpg-float v3, v0, v2

    if-gez v3, :cond_2d

    const/4 v1, 0x0

    goto :goto_33

    :cond_2d
    cmpl-float v2, v0, v1

    if-lez v2, :cond_32

    goto :goto_33

    :cond_32
    move v1, v0

    :goto_33
    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p1
    :try_end_37
    .catch Ljava/lang/NumberFormatException; {:try_start_1d .. :try_end_37} :catch_38

    return-object p1

    :catch_38
    move-exception v0

    new-instance v1, Lc0/j;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Invalid offset value in <stop>: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v1, p1, v0}, Lc0/j;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v1

    :cond_50
    new-instance p1, Lc0/j;

    const-string v0, "Invalid offset value in <stop> (empty string)"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private o()V
    .registers 1

    return-void
.end method

.method static o0(Ljava/lang/String;)Lc0/g$p;
    .registers 5

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_7b

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    sget-object v1, Lc0/g$d1;->c:Lc0/g$d1;

    add-int/lit8 v2, v0, -0x1

    invoke-virtual {p0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v3, 0x25

    if-ne v2, v3, :cond_1b

    add-int/lit8 v0, v0, -0x1

    sget-object v1, Lc0/g$d1;->l:Lc0/g$d1;

    goto :goto_58

    :cond_1b
    const/4 v3, 0x2

    if-le v0, v3, :cond_58

    invoke-static {v2}, Ljava/lang/Character;->isLetter(C)Z

    move-result v2

    if-eqz v2, :cond_58

    add-int/lit8 v2, v0, -0x2

    invoke-virtual {p0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    invoke-static {v2}, Ljava/lang/Character;->isLetter(C)Z

    move-result v2

    if-eqz v2, :cond_58

    add-int/lit8 v0, v0, -0x2

    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    :try_start_36
    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lc0/g$d1;->valueOf(Ljava/lang/String;)Lc0/g$d1;

    move-result-object v1
    :try_end_40
    .catch Ljava/lang/IllegalArgumentException; {:try_start_36 .. :try_end_40} :catch_41

    goto :goto_58

    :catch_41
    new-instance v0, Lc0/j;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid length unit specifier: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_58
    :goto_58
    const/4 v2, 0x0

    :try_start_59
    invoke-static {p0, v2, v0}, Lc0/k;->g0(Ljava/lang/String;II)F

    move-result v0

    new-instance v2, Lc0/g$p;

    invoke-direct {v2, v0, v1}, Lc0/g$p;-><init>(FLc0/g$d1;)V
    :try_end_62
    .catch Ljava/lang/NumberFormatException; {:try_start_59 .. :try_end_62} :catch_63

    return-object v2

    :catch_63
    move-exception v0

    new-instance v1, Lc0/j;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Invalid length value: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v1, p0, v0}, Lc0/j;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v1

    :cond_7b
    new-instance p0, Lc0/j;

    const-string v0, "Invalid length value (empty string)"

    invoke-direct {p0, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method private p(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 7

    iget-boolean v0, p0, Lc0/k;->c:Z

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eqz v0, :cond_10

    iget v0, p0, Lc0/k;->d:I

    sub-int/2addr v0, v1

    iput v0, p0, Lc0/k;->d:I

    if-nez v0, :cond_10

    iput-boolean v2, p0, Lc0/k;->c:Z

    return-void

    :cond_10
    const-string v0, "http://www.w3.org/2000/svg"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_21

    const-string v0, ""

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_21

    return-void

    :cond_21
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result p1

    if-lez p1, :cond_28

    goto :goto_29

    :cond_28
    move-object p2, p3

    :goto_29
    sget-object p1, Lc0/k$a;->a:[I

    invoke-static {p2}, Lc0/k$h;->a(Ljava/lang/String;)Lc0/k$h;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/Enum;->ordinal()I

    move-result p2

    aget p1, p1, p2

    if-eq p1, v1, :cond_88

    const/4 p2, 0x2

    if-eq p1, p2, :cond_88

    const/4 p2, 0x4

    if-eq p1, p2, :cond_88

    const/4 p2, 0x5

    if-eq p1, p2, :cond_88

    const/16 p2, 0xd

    if-eq p1, p2, :cond_88

    const/16 p2, 0xe

    if-eq p1, p2, :cond_88

    packed-switch p1, :pswitch_data_92

    goto :goto_90

    :pswitch_4c
    iget-object p1, p0, Lc0/k;->i:Ljava/lang/StringBuilder;

    if-eqz p1, :cond_90

    iput-boolean v2, p0, Lc0/k;->h:Z

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Lc0/k;->Z(Ljava/lang/String;)V

    iget-object p1, p0, Lc0/k;->i:Ljava/lang/StringBuilder;

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->setLength(I)V

    return-void

    :pswitch_5f
    iput-boolean v2, p0, Lc0/k;->e:Z

    iget-object p1, p0, Lc0/k;->g:Ljava/lang/StringBuilder;

    if-eqz p1, :cond_87

    iget-object p2, p0, Lc0/k;->f:Lc0/k$h;

    sget-object p3, Lc0/k$h;->D:Lc0/k$h;

    if-ne p2, p3, :cond_75

    iget-object p2, p0, Lc0/k;->a:Lc0/g;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p2, p1}, Lc0/g;->q(Ljava/lang/String;)V

    goto :goto_82

    :cond_75
    sget-object p3, Lc0/k$h;->i:Lc0/k$h;

    if-ne p2, p3, :cond_82

    iget-object p2, p0, Lc0/k;->a:Lc0/g;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p2, p1}, Lc0/g;->o(Ljava/lang/String;)V

    :cond_82
    :goto_82
    iget-object p1, p0, Lc0/k;->g:Ljava/lang/StringBuilder;

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->setLength(I)V

    :cond_87
    return-void

    :cond_88
    :pswitch_88
    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    check-cast p1, Lc0/g$n0;

    iget-object p1, p1, Lc0/g$n0;->b:Lc0/g$j0;

    iput-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    :cond_90
    :goto_90
    return-void

    nop

    :pswitch_data_92
    .packed-switch 0x10
        :pswitch_88
        :pswitch_88
        :pswitch_88
        :pswitch_88
        :pswitch_88
        :pswitch_88
        :pswitch_5f
        :pswitch_5f
        :pswitch_88
        :pswitch_88
        :pswitch_88
        :pswitch_88
        :pswitch_88
        :pswitch_88
        :pswitch_4c
        :pswitch_88
    .end packed-switch
.end method

.method private static p0(Ljava/lang/String;)Ljava/util/List;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List<",
            "Lc0/g$p;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_54

    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    new-instance v1, Lc0/k$i;

    invoke-direct {v1, p0}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lc0/k$i;->A()V

    :goto_14
    invoke-virtual {v1}, Lc0/k$i;->h()Z

    move-result p0

    if-nez p0, :cond_53

    invoke-virtual {v1}, Lc0/k$i;->n()F

    move-result p0

    invoke-static {p0}, Ljava/lang/Float;->isNaN(F)Z

    move-result v2

    if-nez v2, :cond_38

    invoke-virtual {v1}, Lc0/k$i;->v()Lc0/g$d1;

    move-result-object v2

    if-nez v2, :cond_2c

    sget-object v2, Lc0/g$d1;->c:Lc0/g$d1;

    :cond_2c
    new-instance v3, Lc0/g$p;

    invoke-direct {v3, p0, v2}, Lc0/g$p;-><init>(FLc0/g$d1;)V

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-virtual {v1}, Lc0/k$i;->z()Z

    goto :goto_14

    :cond_38
    new-instance p0, Lc0/j;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid length list value: "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Lc0/k$i;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_53
    return-object v0

    :cond_54
    new-instance p0, Lc0/j;

    const-string v0, "Invalid length list (empty string)"

    invoke-direct {p0, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method private q(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<g>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_2d

    new-instance v0, Lc0/g$m;

    invoke-direct {v0}, Lc0/g$m;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->W(Lc0/g$n;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    return-void

    :cond_2d
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private static q0(Lc0/k$i;)Lc0/g$p;
    .registers 2

    const-string v0, "auto"

    invoke-virtual {p0, v0}, Lc0/k$i;->g(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_f

    new-instance p0, Lc0/g$p;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lc0/g$p;-><init>(F)V

    return-object p0

    :cond_f
    invoke-virtual {p0}, Lc0/k$i;->p()Lc0/g$p;

    move-result-object p0

    return-object p0
.end method

.method private r(Ljava/lang/String;Ljava/util/Map;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    const-string p2, "xml-stylesheet"

    invoke-virtual {p1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_b

    invoke-static {}, Lc0/g;->g()Lc0/i;

    :cond_b
    return-void
.end method

.method private static r0(Ljava/lang/String;)Ljava/lang/Float;
    .registers 4

    :try_start_0
    invoke-static {p0}, Lc0/k;->f0(Ljava/lang/String;)F

    move-result p0

    const/high16 v0, 0x3f800000    # 1.0f

    const/4 v1, 0x0

    cmpg-float v2, p0, v1

    if-gez v2, :cond_d

    const/4 p0, 0x0

    goto :goto_13

    :cond_d
    cmpl-float v1, p0, v0

    if-lez v1, :cond_13

    const/high16 p0, 0x3f800000    # 1.0f

    :cond_13
    :goto_13
    invoke-static {p0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p0
    :try_end_17
    .catch Lc0/j; {:try_start_0 .. :try_end_17} :catch_18

    return-object p0

    :catch_18
    const/4 p0, 0x0

    return-object p0
.end method

.method private static s(FFF)I
    .registers 6

    const/high16 v0, 0x43b40000    # 360.0f

    const/4 v1, 0x0

    cmpl-float v2, p0, v1

    rem-float/2addr p0, v0

    if-ltz v2, :cond_9

    goto :goto_a

    :cond_9
    add-float/2addr p0, v0

    :goto_a
    const/high16 v0, 0x42700000    # 60.0f

    div-float/2addr p0, v0

    const/high16 v0, 0x42c80000    # 100.0f

    div-float/2addr p1, v0

    div-float/2addr p2, v0

    const/high16 v0, 0x3f800000    # 1.0f

    cmpg-float v2, p1, v1

    if-gez v2, :cond_19

    const/4 p1, 0x0

    goto :goto_1f

    :cond_19
    cmpl-float v2, p1, v0

    if-lez v2, :cond_1f

    const/high16 p1, 0x3f800000    # 1.0f

    :cond_1f
    :goto_1f
    cmpg-float v2, p2, v1

    if-gez v2, :cond_24

    goto :goto_2c

    :cond_24
    cmpl-float v1, p2, v0

    if-lez v1, :cond_2b

    const/high16 v1, 0x3f800000    # 1.0f

    goto :goto_2c

    :cond_2b
    move v1, p2

    :goto_2c
    const/high16 p2, 0x3f000000    # 0.5f

    cmpg-float p2, v1, p2

    if-gtz p2, :cond_36

    add-float/2addr p1, v0

    mul-float p1, p1, v1

    goto :goto_3c

    :cond_36
    add-float p2, v1, p1

    mul-float p1, p1, v1

    sub-float p1, p2, p1

    :goto_3c
    const/high16 p2, 0x40000000    # 2.0f

    mul-float v1, v1, p2

    sub-float/2addr v1, p1

    add-float v0, p0, p2

    invoke-static {v1, p1, v0}, Lc0/k;->t(FFF)F

    move-result v0

    invoke-static {v1, p1, p0}, Lc0/k;->t(FFF)F

    move-result v2

    sub-float/2addr p0, p2

    invoke-static {v1, p1, p0}, Lc0/k;->t(FFF)F

    move-result p0

    const/high16 p1, 0x43800000    # 256.0f

    mul-float v0, v0, p1

    invoke-static {v0}, Lc0/k;->j(F)I

    move-result p2

    shl-int/lit8 p2, p2, 0x10

    mul-float v2, v2, p1

    invoke-static {v2}, Lc0/k;->j(F)I

    move-result v0

    shl-int/lit8 v0, v0, 0x8

    or-int/2addr p2, v0

    mul-float p0, p0, p1

    invoke-static {p0}, Lc0/k;->j(F)I

    move-result p0

    or-int/2addr p0, p2

    return p0
.end method

.method private static s0(Ljava/lang/String;)Ljava/lang/Boolean;
    .registers 3

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v0

    const/4 v1, -0x1

    sparse-switch v0, :sswitch_data_42

    goto :goto_37

    :sswitch_c
    const-string v0, "visible"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_15

    goto :goto_37

    :cond_15
    const/4 v1, 0x3

    goto :goto_37

    :sswitch_17
    const-string v0, "auto"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_20

    goto :goto_37

    :cond_20
    const/4 v1, 0x2

    goto :goto_37

    :sswitch_22
    const-string v0, "scroll"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_2b

    goto :goto_37

    :cond_2b
    const/4 v1, 0x1

    goto :goto_37

    :sswitch_2d
    const-string v0, "hidden"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_36

    goto :goto_37

    :cond_36
    const/4 v1, 0x0

    :goto_37
    packed-switch v1, :pswitch_data_54

    const/4 p0, 0x0

    return-object p0

    :pswitch_3c
    sget-object p0, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    return-object p0

    :pswitch_3f
    sget-object p0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    return-object p0

    :sswitch_data_42
    .sparse-switch
        -0x48916256 -> :sswitch_2d
        -0x361a1933 -> :sswitch_22
        0x2dddaf -> :sswitch_17
        0x1bd1f072 -> :sswitch_c
    .end sparse-switch

    :pswitch_data_54
    .packed-switch 0x0
        :pswitch_3f
        :pswitch_3f
        :pswitch_3c
        :pswitch_3c
    .end packed-switch
.end method

.method private static t(FFF)F
    .registers 5

    const/high16 v0, 0x40c00000    # 6.0f

    const/4 v1, 0x0

    cmpg-float v1, p2, v1

    if-gez v1, :cond_8

    add-float/2addr p2, v0

    :cond_8
    cmpl-float v1, p2, v0

    if-ltz v1, :cond_d

    sub-float/2addr p2, v0

    :cond_d
    const/high16 v0, 0x3f800000    # 1.0f

    cmpg-float v0, p2, v0

    if-gez v0, :cond_18

    sub-float/2addr p1, p0

    mul-float p1, p1, p2

    :goto_16
    add-float/2addr p1, p0

    return p1

    :cond_18
    const/high16 v0, 0x40400000    # 3.0f

    cmpg-float v0, p2, v0

    if-gez v0, :cond_1f

    return p1

    :cond_1f
    const/high16 v0, 0x40800000    # 4.0f

    cmpg-float v1, p2, v0

    if-gez v1, :cond_2a

    sub-float/2addr p1, p0

    sub-float/2addr v0, p2

    mul-float p1, p1, v0

    goto :goto_16

    :cond_2a
    return p0
.end method

.method private static t0(Ljava/lang/String;)Lc0/g$o0;
    .registers 5

    const-string v0, "url("

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_43

    const-string v0, ")"

    invoke-virtual {p0, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    const/4 v1, -0x1

    const/4 v2, 0x0

    const/4 v3, 0x4

    if-eq v0, v1, :cond_35

    invoke-virtual {p0, v3, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    add-int/lit8 v0, v0, 0x1

    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_2f

    invoke-static {p0}, Lc0/k;->d0(Ljava/lang/String;)Lc0/g$o0;

    move-result-object v2

    :cond_2f
    new-instance p0, Lc0/g$u;

    invoke-direct {p0, v1, v2}, Lc0/g$u;-><init>(Ljava/lang/String;Lc0/g$o0;)V

    return-object p0

    :cond_35
    invoke-virtual {p0, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p0

    new-instance v0, Lc0/g$u;

    invoke-direct {v0, p0, v2}, Lc0/g$u;-><init>(Ljava/lang/String;Lc0/g$o0;)V

    return-object v0

    :cond_43
    invoke-static {p0}, Lc0/k;->d0(Ljava/lang/String;)Lc0/g$o0;

    move-result-object p0

    return-object p0
.end method

.method private u(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<image>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_30

    new-instance v0, Lc0/g$o;

    invoke-direct {v0}, Lc0/g$o;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->W(Lc0/g$n;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->G(Lc0/g$o;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    return-void

    :cond_30
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private static u0(Ljava/lang/String;)Lc0/g$w;
    .registers 21

    new-instance v0, Lc0/k$i;

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    new-instance v9, Lc0/g$w;

    invoke-direct {v9}, Lc0/g$w;-><init>()V

    invoke-virtual {v0}, Lc0/k$i;->h()Z

    move-result v1

    if-eqz v1, :cond_13

    return-object v9

    :cond_13
    invoke-virtual {v0}, Lc0/k$i;->l()Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    const/16 v2, 0x4d

    const/16 v10, 0x6d

    if-eq v1, v2, :cond_24

    if-eq v1, v10, :cond_24

    return-object v9

    :cond_24
    move v12, v1

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    :goto_2b
    invoke-virtual {v0}, Lc0/k$i;->A()V

    const/16 v5, 0x6c

    const/high16 v6, 0x40000000    # 2.0f

    const-string v7, " path segment"

    const-string v8, "Bad path coords for "

    const-string v15, "SVGParser"

    sparse-switch v12, :sswitch_data_218

    return-object v9

    :sswitch_3c
    invoke-virtual {v9}, Lc0/g$w;->close()V

    move v1, v13

    move v2, v1

    move v3, v14

    :goto_42
    move v4, v3

    :goto_43
    const/16 v18, 0x0

    goto/16 :goto_1f5

    :sswitch_47
    invoke-virtual {v0}, Lc0/k$i;->n()F

    move-result v4

    invoke-static {v4}, Ljava/lang/Float;->isNaN(F)Z

    move-result v5

    if-eqz v5, :cond_68

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    :goto_56
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    int-to-char v1, v12

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v15, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    return-object v9

    :cond_68
    const/16 v5, 0x76

    if-ne v12, v5, :cond_6d

    add-float/2addr v4, v3

    :cond_6d
    move v3, v4

    invoke-virtual {v9, v1, v3}, Lc0/g$w;->lineTo(FF)V

    goto :goto_42

    :sswitch_72
    mul-float v5, v1, v6

    sub-float v2, v5, v2

    mul-float v6, v6, v3

    sub-float v4, v6, v4

    invoke-virtual {v0}, Lc0/k$i;->n()F

    move-result v5

    invoke-virtual {v0, v5}, Lc0/k$i;->d(F)F

    move-result v6

    invoke-static {v6}, Ljava/lang/Float;->isNaN(F)Z

    move-result v16

    if-eqz v16, :cond_8e

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    goto :goto_56

    :cond_8e
    const/16 v7, 0x74

    if-ne v12, v7, :cond_ed

    add-float/2addr v5, v1

    add-float/2addr v6, v3

    goto :goto_ed

    :sswitch_95
    mul-float v5, v1, v6

    sub-float v2, v5, v2

    mul-float v6, v6, v3

    sub-float v4, v6, v4

    invoke-virtual {v0}, Lc0/k$i;->n()F

    move-result v5

    invoke-virtual {v0, v5}, Lc0/k$i;->d(F)F

    move-result v6

    invoke-virtual {v0, v6}, Lc0/k$i;->d(F)F

    move-result v11

    invoke-virtual {v0, v11}, Lc0/k$i;->d(F)F

    move-result v16

    invoke-static/range {v16 .. v16}, Ljava/lang/Float;->isNaN(F)Z

    move-result v17

    if-eqz v17, :cond_b9

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    goto :goto_56

    :cond_b9
    const/16 v7, 0x73

    if-ne v12, v7, :cond_c2

    add-float/2addr v11, v1

    add-float v16, v16, v3

    add-float/2addr v5, v1

    add-float/2addr v6, v3

    :cond_c2
    move v8, v5

    move v15, v6

    move-object v1, v9

    move v3, v4

    goto/16 :goto_196

    :sswitch_c8
    invoke-virtual {v0}, Lc0/k$i;->n()F

    move-result v2

    invoke-virtual {v0, v2}, Lc0/k$i;->d(F)F

    move-result v4

    invoke-virtual {v0, v4}, Lc0/k$i;->d(F)F

    move-result v5

    invoke-virtual {v0, v5}, Lc0/k$i;->d(F)F

    move-result v6

    invoke-static {v6}, Ljava/lang/Float;->isNaN(F)Z

    move-result v11

    if-eqz v11, :cond_e5

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    goto/16 :goto_56

    :cond_e5
    const/16 v7, 0x71

    if-ne v12, v7, :cond_ed

    add-float/2addr v5, v1

    add-float/2addr v6, v3

    add-float/2addr v2, v1

    add-float/2addr v4, v3

    :cond_ed
    :goto_ed
    move v1, v5

    move v3, v6

    invoke-virtual {v9, v2, v4, v1, v3}, Lc0/g$w;->a(FFFF)V

    goto/16 :goto_43

    :sswitch_f4
    invoke-virtual {v0}, Lc0/k$i;->n()F

    move-result v2

    invoke-virtual {v0, v2}, Lc0/k$i;->d(F)F

    move-result v4

    invoke-static {v4}, Ljava/lang/Float;->isNaN(F)Z

    move-result v6

    if-eqz v6, :cond_109

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    goto/16 :goto_56

    :cond_109
    if-ne v12, v10, :cond_113

    invoke-virtual {v9}, Lc0/g$w;->g()Z

    move-result v6

    if-nez v6, :cond_113

    add-float/2addr v2, v1

    add-float/2addr v4, v3

    :cond_113
    move v1, v2

    move v3, v4

    invoke-virtual {v9, v1, v3}, Lc0/g$w;->moveTo(FF)V

    if-ne v12, v10, :cond_11b

    goto :goto_11d

    :cond_11b
    const/16 v5, 0x4c

    :goto_11d
    move v2, v1

    move v13, v2

    move v4, v3

    move v14, v4

    move v12, v5

    goto/16 :goto_43

    :sswitch_124
    invoke-virtual {v0}, Lc0/k$i;->n()F

    move-result v2

    invoke-virtual {v0, v2}, Lc0/k$i;->d(F)F

    move-result v4

    invoke-static {v4}, Ljava/lang/Float;->isNaN(F)Z

    move-result v6

    if-eqz v6, :cond_139

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    goto/16 :goto_56

    :cond_139
    if-ne v12, v5, :cond_13d

    add-float/2addr v2, v1

    add-float/2addr v4, v3

    :cond_13d
    move v1, v2

    move v3, v4

    invoke-virtual {v9, v1, v3}, Lc0/g$w;->lineTo(FF)V

    move v2, v1

    goto/16 :goto_42

    :sswitch_145
    invoke-virtual {v0}, Lc0/k$i;->n()F

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->isNaN(F)Z

    move-result v5

    if-eqz v5, :cond_156

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    goto/16 :goto_56

    :cond_156
    const/16 v5, 0x68

    if-ne v12, v5, :cond_15b

    add-float/2addr v2, v1

    :cond_15b
    move v1, v2

    invoke-virtual {v9, v1, v3}, Lc0/g$w;->lineTo(FF)V

    move v2, v1

    goto/16 :goto_43

    :sswitch_162
    invoke-virtual {v0}, Lc0/k$i;->n()F

    move-result v2

    invoke-virtual {v0, v2}, Lc0/k$i;->d(F)F

    move-result v4

    invoke-virtual {v0, v4}, Lc0/k$i;->d(F)F

    move-result v5

    invoke-virtual {v0, v5}, Lc0/k$i;->d(F)F

    move-result v6

    invoke-virtual {v0, v6}, Lc0/k$i;->d(F)F

    move-result v11

    invoke-virtual {v0, v11}, Lc0/k$i;->d(F)F

    move-result v16

    invoke-static/range {v16 .. v16}, Ljava/lang/Float;->isNaN(F)Z

    move-result v17

    if-eqz v17, :cond_187

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    goto/16 :goto_56

    :cond_187
    const/16 v7, 0x63

    if-ne v12, v7, :cond_192

    add-float/2addr v11, v1

    add-float v16, v16, v3

    add-float/2addr v2, v1

    add-float/2addr v4, v3

    add-float/2addr v5, v1

    add-float/2addr v6, v3

    :cond_192
    move v3, v4

    move v8, v5

    move v15, v6

    move-object v1, v9

    :goto_196
    move v4, v8

    move v5, v15

    move v6, v11

    move/from16 v7, v16

    invoke-virtual/range {v1 .. v7}, Lc0/g$w;->b(FFFFFF)V

    move v2, v8

    move v1, v11

    move v4, v15

    move/from16 v3, v16

    goto/16 :goto_43

    :sswitch_1a5
    invoke-virtual {v0}, Lc0/k$i;->n()F

    move-result v2

    invoke-virtual {v0, v2}, Lc0/k$i;->d(F)F

    move-result v4

    invoke-virtual {v0, v4}, Lc0/k$i;->d(F)F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v6

    invoke-virtual {v0, v6}, Lc0/k$i;->c(Ljava/lang/Object;)Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {v0, v6}, Lc0/k$i;->c(Ljava/lang/Object;)Ljava/lang/Boolean;

    move-result-object v11

    invoke-virtual {v0, v11}, Lc0/k$i;->e(Ljava/lang/Boolean;)F

    move-result v10

    invoke-virtual {v0, v10}, Lc0/k$i;->d(F)F

    move-result v17

    invoke-static/range {v17 .. v17}, Ljava/lang/Float;->isNaN(F)Z

    move-result v18

    if-nez v18, :cond_211

    const/16 v18, 0x0

    cmpg-float v19, v2, v18

    if-ltz v19, :cond_211

    cmpg-float v19, v4, v18

    if-gez v19, :cond_1d6

    goto :goto_211

    :cond_1d6
    const/16 v7, 0x61

    if-ne v12, v7, :cond_1dd

    add-float/2addr v10, v1

    add-float v17, v17, v3

    :cond_1dd
    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6

    invoke-virtual {v11}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    move-object v1, v9

    move v3, v4

    move v4, v5

    move v5, v6

    move v6, v7

    move v7, v10

    move/from16 v8, v17

    invoke-virtual/range {v1 .. v8}, Lc0/g$w;->c(FFFZZFF)V

    move v1, v10

    move v2, v1

    move/from16 v3, v17

    move v4, v3

    :goto_1f5
    invoke-virtual {v0}, Lc0/k$i;->z()Z

    invoke-virtual {v0}, Lc0/k$i;->h()Z

    move-result v5

    if-eqz v5, :cond_1ff

    return-object v9

    :cond_1ff
    invoke-virtual {v0}, Lc0/k$i;->i()Z

    move-result v5

    if-eqz v5, :cond_20d

    invoke-virtual {v0}, Lc0/k$i;->l()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v12

    :cond_20d
    const/16 v10, 0x6d

    goto/16 :goto_2b

    :cond_211
    :goto_211
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    goto/16 :goto_56

    :sswitch_data_218
    .sparse-switch
        0x41 -> :sswitch_1a5
        0x43 -> :sswitch_162
        0x48 -> :sswitch_145
        0x4c -> :sswitch_124
        0x4d -> :sswitch_f4
        0x51 -> :sswitch_c8
        0x53 -> :sswitch_95
        0x54 -> :sswitch_72
        0x56 -> :sswitch_47
        0x5a -> :sswitch_3c
        0x61 -> :sswitch_1a5
        0x63 -> :sswitch_162
        0x68 -> :sswitch_145
        0x6c -> :sswitch_124
        0x6d -> :sswitch_f4
        0x71 -> :sswitch_c8
        0x73 -> :sswitch_95
        0x74 -> :sswitch_72
        0x76 -> :sswitch_47
        0x7a -> :sswitch_3c
    .end sparse-switch
.end method

.method private v(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<line>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_2e

    new-instance v0, Lc0/g$q;

    invoke-direct {v0}, Lc0/g$q;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->W(Lc0/g$n;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->H(Lc0/g$q;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    return-void

    :cond_2e
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method static v0(Ljava/lang/String;)Lc0/e;
    .registers 5

    new-instance v0, Lc0/k$i;

    invoke-direct {v0, p0}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lc0/k$i;->A()V

    invoke-virtual {v0}, Lc0/k$i;->r()Ljava/lang/String;

    move-result-object v1

    const-string v2, "defer"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1b

    invoke-virtual {v0}, Lc0/k$i;->A()V

    invoke-virtual {v0}, Lc0/k$i;->r()Ljava/lang/String;

    move-result-object v1

    :cond_1b
    invoke-static {v1}, Lc0/k$b;->a(Ljava/lang/String;)Lc0/e$a;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0}, Lc0/k$i;->A()V

    invoke-virtual {v0}, Lc0/k$i;->h()Z

    move-result v3

    if-nez v3, :cond_5c

    invoke-virtual {v0}, Lc0/k$i;->r()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    const-string v2, "meet"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_5a

    const-string v2, "slice"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_43

    sget-object v2, Lc0/e$b;->d:Lc0/e$b;

    goto :goto_5c

    :cond_43
    new-instance v0, Lc0/j;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid preserveAspectRatio definition: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_5a
    sget-object v2, Lc0/e$b;->c:Lc0/e$b;

    :cond_5c
    :goto_5c
    new-instance p0, Lc0/e;

    invoke-direct {p0, v1, v2}, Lc0/e;-><init>(Lc0/e$a;Lc0/e$b;)V

    return-object p0
.end method

.method private w(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<linearGradient>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_2d

    new-instance v0, Lc0/g$m0;

    invoke-direct {v0}, Lc0/g$m0;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->F(Lc0/g$j;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->I(Lc0/g$m0;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    return-void

    :cond_2d
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private static w0(Lc0/g$p0;Ljava/lang/String;)V
    .registers 2

    invoke-static {p1}, Lc0/k;->v0(Ljava/lang/String;)Lc0/e;

    move-result-object p1

    iput-object p1, p0, Lc0/g$p0;->o:Lc0/e;

    return-void
.end method

.method private x(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<marker>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_30

    new-instance v0, Lc0/g$r;

    invoke-direct {v0}, Lc0/g$r;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->Y(Lc0/g$r0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->J(Lc0/g$r;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    return-void

    :cond_30
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private x0(Lc0/k$i;)Ljava/util/Map;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lc0/k$i;",
            ")",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {p1}, Lc0/k$i;->A()V

    const/16 v1, 0x3d

    :goto_a
    invoke-virtual {p1, v1}, Lc0/k$i;->s(C)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1e

    invoke-virtual {p1, v1}, Lc0/k$i;->f(C)Z

    invoke-virtual {p1}, Lc0/k$i;->q()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {p1}, Lc0/k$i;->A()V

    goto :goto_a

    :cond_1e
    return-object v0
.end method

.method private y(Lorg/xml/sax/Attributes;)V
    .registers 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    const-string v1, "<mask>"

    invoke-direct {p0, v1, v0}, Lc0/k;->l(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    if-eqz v0, :cond_2d

    new-instance v0, Lc0/g$s;

    invoke-direct {v0}, Lc0/g$s;-><init>()V

    iget-object v1, p0, Lc0/k;->a:Lc0/g;

    iput-object v1, v0, Lc0/g$n0;->a:Lc0/g;

    iget-object v1, p0, Lc0/k;->b:Lc0/g$j0;

    iput-object v1, v0, Lc0/g$n0;->b:Lc0/g$j0;

    invoke-direct {p0, v0, p1}, Lc0/k;->D(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->S(Lc0/g$l0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->C(Lc0/g$g0;Lorg/xml/sax/Attributes;)V

    invoke-direct {p0, v0, p1}, Lc0/k;->K(Lc0/g$s;Lorg/xml/sax/Attributes;)V

    iget-object p1, p0, Lc0/k;->b:Lc0/g$j0;

    invoke-interface {p1, v0}, Lc0/g$j0;->i(Lc0/g$n0;)V

    iput-object v0, p0, Lc0/k;->b:Lc0/g$j0;

    return-void

    :cond_2d
    new-instance p1, Lc0/j;

    const-string v0, "Invalid document. Root element must be <svg>"

    invoke-direct {p1, v0}, Lc0/j;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private static y0(Ljava/lang/String;)Lc0/g$e0$e;
    .registers 3

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v0

    const/4 v1, -0x1

    sparse-switch v0, :sswitch_data_3a

    goto :goto_2c

    :sswitch_c
    const-string v0, "optimizeSpeed"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_15

    goto :goto_2c

    :cond_15
    const/4 v1, 0x2

    goto :goto_2c

    :sswitch_17
    const-string v0, "auto"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_20

    goto :goto_2c

    :cond_20
    const/4 v1, 0x1

    goto :goto_2c

    :sswitch_22
    const-string v0, "optimizeQuality"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_2b

    goto :goto_2c

    :cond_2b
    const/4 v1, 0x0

    :goto_2c
    packed-switch v1, :pswitch_data_48

    const/4 p0, 0x0

    return-object p0

    :pswitch_31
    sget-object p0, Lc0/g$e0$e;->f:Lc0/g$e0$e;

    return-object p0

    :pswitch_34
    sget-object p0, Lc0/g$e0$e;->c:Lc0/g$e0$e;

    return-object p0

    :pswitch_37
    sget-object p0, Lc0/g$e0$e;->d:Lc0/g$e0$e;

    return-object p0

    :sswitch_data_3a
    .sparse-switch
        -0x379c7c9e -> :sswitch_22
        0x2dddaf -> :sswitch_17
        0x159eff6a -> :sswitch_c
    .end sparse-switch

    :pswitch_data_48
    .packed-switch 0x0
        :pswitch_37
        :pswitch_34
        :pswitch_31
    .end packed-switch
.end method

.method private static z0(Ljava/lang/String;)Ljava/util/Set;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    new-instance v0, Lc0/k$i;

    invoke-direct {v0, p0}, Lc0/k$i;-><init>(Ljava/lang/String;)V

    new-instance p0, Ljava/util/HashSet;

    invoke-direct {p0}, Ljava/util/HashSet;-><init>()V

    :goto_a
    invoke-virtual {v0}, Lc0/k$i;->h()Z

    move-result v1

    if-nez v1, :cond_2c

    invoke-virtual {v0}, Lc0/k$i;->r()Ljava/lang/String;

    move-result-object v1

    const-string v2, "http://www.w3.org/TR/SVG11/feature#"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_23

    const/16 v2, 0x23

    invoke-virtual {v1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_25

    :cond_23
    const-string v1, "UNSUPPORTED"

    :goto_25
    invoke-virtual {p0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    invoke-virtual {v0}, Lc0/k$i;->A()V

    goto :goto_a

    :cond_2c
    return-object p0
.end method


# virtual methods
.method z(Ljava/io/InputStream;Z)Lc0/g;
    .registers 7

    const-string v0, "Exception thrown closing input stream"

    const-string v1, "SVGParser"

    invoke-virtual {p1}, Ljava/io/InputStream;->markSupported()Z

    move-result v2

    if-nez v2, :cond_10

    new-instance v2, Ljava/io/BufferedInputStream;

    invoke-direct {v2, p1}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    move-object p1, v2

    :cond_10
    const/4 v2, 0x3

    :try_start_11
    invoke-virtual {p1, v2}, Ljava/io/InputStream;->mark(I)V

    invoke-virtual {p1}, Ljava/io/InputStream;->read()I

    move-result v2

    invoke-virtual {p1}, Ljava/io/InputStream;->read()I

    move-result v3

    shl-int/lit8 v3, v3, 0x8

    add-int/2addr v2, v3

    invoke-virtual {p1}, Ljava/io/InputStream;->reset()V

    const v3, 0x8b1f

    if-ne v2, v3, :cond_32

    new-instance v2, Ljava/io/BufferedInputStream;

    new-instance v3, Ljava/util/zip/GZIPInputStream;

    invoke-direct {v3, p1}, Ljava/util/zip/GZIPInputStream;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v2, v3}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_31
    .catch Ljava/io/IOException; {:try_start_11 .. :try_end_31} :catch_32

    move-object p1, v2

    :catch_32
    :cond_32
    const/16 v2, 0x1000

    :try_start_34
    invoke-virtual {p1, v2}, Ljava/io/InputStream;->mark(I)V

    invoke-direct {p0, p1, p2}, Lc0/k;->L0(Ljava/io/InputStream;Z)V
    :try_end_3a
    .catchall {:try_start_34 .. :try_end_3a} :catchall_44

    :try_start_3a
    invoke-virtual {p1}, Ljava/io/InputStream;->close()V
    :try_end_3d
    .catch Ljava/io/IOException; {:try_start_3a .. :try_end_3d} :catch_3e

    goto :goto_41

    :catch_3e
    invoke-static {v1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :goto_41
    iget-object p1, p0, Lc0/k;->a:Lc0/g;

    return-object p1

    :catchall_44
    move-exception p2

    :try_start_45
    invoke-virtual {p1}, Ljava/io/InputStream;->close()V
    :try_end_48
    .catch Ljava/io/IOException; {:try_start_45 .. :try_end_48} :catch_49

    goto :goto_4c

    :catch_49
    invoke-static {v1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :goto_4c
    throw p2
.end method
