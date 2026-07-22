.class public final Landroidx/core/os/k;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/os/k$b;,
        Landroidx/core/os/k$a;
    }
.end annotation


# static fields
.field private static final b:Landroidx/core/os/k;


# instance fields
.field private final a:Landroidx/core/os/m;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/util/Locale;

    invoke-static {v0}, Landroidx/core/os/k;->a([Ljava/util/Locale;)Landroidx/core/os/k;

    move-result-object v0

    sput-object v0, Landroidx/core/os/k;->b:Landroidx/core/os/k;

    return-void
.end method

.method private constructor <init>(Landroidx/core/os/m;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/core/os/k;->a:Landroidx/core/os/m;

    return-void
.end method

.method public static varargs a([Ljava/util/Locale;)Landroidx/core/os/k;
    .registers 3

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x18

    if-lt v0, v1, :cond_f

    invoke-static {p0}, Landroidx/core/os/k$b;->a([Ljava/util/Locale;)Landroid/os/LocaleList;

    move-result-object p0

    invoke-static {p0}, Landroidx/core/os/k;->h(Landroid/os/LocaleList;)Landroidx/core/os/k;

    move-result-object p0

    return-object p0

    :cond_f
    new-instance v0, Landroidx/core/os/k;

    new-instance v1, Landroidx/core/os/l;

    invoke-direct {v1, p0}, Landroidx/core/os/l;-><init>([Ljava/util/Locale;)V

    invoke-direct {v0, v1}, Landroidx/core/os/k;-><init>(Landroidx/core/os/m;)V

    return-object v0
.end method

.method static b(Ljava/lang/String;)Ljava/util/Locale;
    .registers 7

    const-string v0, "-"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    const/4 v2, -0x1

    const/4 v3, 0x2

    const/4 v4, 0x0

    const/4 v5, 0x1

    const/4 v5, 0x1

    if-eqz v1, :cond_38

    invoke-virtual {p0, v0, v2}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v0

    array-length v1, v0

    if-le v1, v3, :cond_20

    new-instance p0, Ljava/util/Locale;

    aget-object v1, v0, v4

    aget-object v2, v0, v5

    aget-object v0, v0, v3

    invoke-direct {p0, v1, v2, v0}, Ljava/util/Locale;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object p0

    :cond_20
    array-length v1, v0

    if-le v1, v5, :cond_2d

    new-instance p0, Ljava/util/Locale;

    aget-object v1, v0, v4

    aget-object v0, v0, v5

    invoke-direct {p0, v1, v0}, Ljava/util/Locale;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object p0

    :cond_2d
    array-length v1, v0

    if-ne v1, v5, :cond_6b

    new-instance p0, Ljava/util/Locale;

    aget-object v0, v0, v4

    invoke-direct {p0, v0}, Ljava/util/Locale;-><init>(Ljava/lang/String;)V

    return-object p0

    :cond_38
    const-string v0, "_"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_87

    invoke-virtual {p0, v0, v2}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v0

    array-length v1, v0

    if-le v1, v3, :cond_53

    new-instance p0, Ljava/util/Locale;

    aget-object v1, v0, v4

    aget-object v2, v0, v5

    aget-object v0, v0, v3

    invoke-direct {p0, v1, v2, v0}, Ljava/util/Locale;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object p0

    :cond_53
    array-length v1, v0

    if-le v1, v5, :cond_60

    new-instance p0, Ljava/util/Locale;

    aget-object v1, v0, v4

    aget-object v0, v0, v5

    invoke-direct {p0, v1, v0}, Ljava/util/Locale;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object p0

    :cond_60
    array-length v1, v0

    if-ne v1, v5, :cond_6b

    new-instance p0, Ljava/util/Locale;

    aget-object v0, v0, v4

    invoke-direct {p0, v0}, Ljava/util/Locale;-><init>(Ljava/lang/String;)V

    return-object p0

    :cond_6b
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Can not parse language tag: ["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p0, "]"

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_87
    new-instance v0, Ljava/util/Locale;

    invoke-direct {v0, p0}, Ljava/util/Locale;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method public static c(Ljava/lang/String;)Landroidx/core/os/k;
    .registers 5

    if-eqz p0, :cond_26

    invoke-virtual {p0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_9

    goto :goto_26

    :cond_9
    const/4 v0, -0x1

    const-string v1, ","

    invoke-virtual {p0, v1, v0}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object p0

    array-length v0, p0

    new-array v1, v0, [Ljava/util/Locale;

    const/4 v2, 0x0

    :goto_14
    if-ge v2, v0, :cond_21

    aget-object v3, p0, v2

    invoke-static {v3}, Landroidx/core/os/k$a;->a(Ljava/lang/String;)Ljava/util/Locale;

    move-result-object v3

    aput-object v3, v1, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_14

    :cond_21
    invoke-static {v1}, Landroidx/core/os/k;->a([Ljava/util/Locale;)Landroidx/core/os/k;

    move-result-object p0

    return-object p0

    :cond_26
    :goto_26
    invoke-static {}, Landroidx/core/os/k;->e()Landroidx/core/os/k;

    move-result-object p0

    return-object p0
.end method

.method public static e()Landroidx/core/os/k;
    .registers 1

    sget-object v0, Landroidx/core/os/k;->b:Landroidx/core/os/k;

    return-object v0
.end method

.method public static h(Landroid/os/LocaleList;)Landroidx/core/os/k;
    .registers 3

    new-instance v0, Landroidx/core/os/k;

    new-instance v1, Landroidx/core/os/n;

    invoke-direct {v1, p0}, Landroidx/core/os/n;-><init>(Ljava/lang/Object;)V

    invoke-direct {v0, v1}, Landroidx/core/os/k;-><init>(Landroidx/core/os/m;)V

    return-object v0
.end method


# virtual methods
.method public d(I)Ljava/util/Locale;
    .registers 3

    iget-object v0, p0, Landroidx/core/os/k;->a:Landroidx/core/os/m;

    invoke-interface {v0, p1}, Landroidx/core/os/m;->get(I)Ljava/util/Locale;

    move-result-object p1

    return-object p1
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 3

    instance-of v0, p1, Landroidx/core/os/k;

    if-eqz v0, :cond_12

    iget-object v0, p0, Landroidx/core/os/k;->a:Landroidx/core/os/m;

    check-cast p1, Landroidx/core/os/k;

    iget-object p1, p1, Landroidx/core/os/k;->a:Landroidx/core/os/m;

    invoke-virtual {v0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_12

    const/4 p1, 0x1

    goto :goto_13

    :cond_12
    const/4 p1, 0x0

    :goto_13
    return p1
.end method

.method public f()Z
    .registers 2

    iget-object v0, p0, Landroidx/core/os/k;->a:Landroidx/core/os/m;

    invoke-interface {v0}, Landroidx/core/os/m;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public g()Ljava/lang/Object;
    .registers 2

    iget-object v0, p0, Landroidx/core/os/k;->a:Landroidx/core/os/m;

    invoke-interface {v0}, Landroidx/core/os/m;->a()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public hashCode()I
    .registers 2

    iget-object v0, p0, Landroidx/core/os/k;->a:Landroidx/core/os/m;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Landroidx/core/os/k;->a:Landroidx/core/os/m;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
