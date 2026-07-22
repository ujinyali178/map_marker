.class public final enum Lw2/i0;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lw2/i0$a;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lw2/i0;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum c:Lw2/i0;

.field public static final enum d:Lw2/i0;

.field public static final enum f:Lw2/i0;

.field public static final enum g:Lw2/i0;

.field private static final synthetic h:[Lw2/i0;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    new-instance v0, Lw2/i0;

    const-string v1, "DEFAULT"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lw2/i0;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lw2/i0;->c:Lw2/i0;

    new-instance v0, Lw2/i0;

    const-string v1, "LAZY"

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lw2/i0;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lw2/i0;->d:Lw2/i0;

    new-instance v0, Lw2/i0;

    const-string v1, "ATOMIC"

    const/4 v2, 0x2

    invoke-direct {v0, v1, v2}, Lw2/i0;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lw2/i0;->f:Lw2/i0;

    new-instance v0, Lw2/i0;

    const-string v1, "UNDISPATCHED"

    const/4 v2, 0x3

    invoke-direct {v0, v1, v2}, Lw2/i0;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lw2/i0;->g:Lw2/i0;

    invoke-static {}, Lw2/i0;->a()[Lw2/i0;

    move-result-object v0

    sput-object v0, Lw2/i0;->h:[Lw2/i0;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method private static final synthetic a()[Lw2/i0;
    .registers 3

    const/4 v0, 0x4

    new-array v0, v0, [Lw2/i0;

    sget-object v1, Lw2/i0;->c:Lw2/i0;

    const/4 v2, 0x0

    aput-object v1, v0, v2

    sget-object v1, Lw2/i0;->d:Lw2/i0;

    const/4 v2, 0x1

    aput-object v1, v0, v2

    sget-object v1, Lw2/i0;->f:Lw2/i0;

    const/4 v2, 0x2

    aput-object v1, v0, v2

    sget-object v1, Lw2/i0;->g:Lw2/i0;

    const/4 v2, 0x3

    aput-object v1, v0, v2

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lw2/i0;
    .registers 2

    const-class v0, Lw2/i0;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lw2/i0;

    return-object p0
.end method

.method public static values()[Lw2/i0;
    .registers 1

    sget-object v0, Lw2/i0;->h:[Lw2/i0;

    invoke-virtual {v0}, [Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lw2/i0;

    return-object v0
.end method


# virtual methods
.method public final b(Lp2/p;Ljava/lang/Object;Li2/d;)V
    .registers 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<R:",
            "Ljava/lang/Object;",
            "T:",
            "Ljava/lang/Object;",
            ">(",
            "Lp2/p<",
            "-TR;-",
            "Li2/d<",
            "-TT;>;+",
            "Ljava/lang/Object;",
            ">;TR;",
            "Li2/d<",
            "-TT;>;)V"
        }
    .end annotation

    sget-object v0, Lw2/i0$a;->a:[I

    invoke-virtual {p0}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_23

    const/4 v1, 0x2

    if-eq v0, v1, :cond_1f

    const/4 v1, 0x3

    if-eq v0, v1, :cond_1b

    const/4 p1, 0x4

    if-ne v0, p1, :cond_15

    goto :goto_2c

    :cond_15
    new-instance p1, Lg2/i;

    invoke-direct {p1}, Lg2/i;-><init>()V

    throw p1

    :cond_1b
    invoke-static {p1, p2, p3}, Lb3/b;->a(Lp2/p;Ljava/lang/Object;Li2/d;)V

    goto :goto_2c

    :cond_1f
    invoke-static {p1, p2, p3}, Li2/f;->a(Lp2/p;Ljava/lang/Object;Li2/d;)V

    goto :goto_2c

    :cond_23
    const/4 v3, 0x0

    const/4 v4, 0x4

    const/4 v5, 0x0

    move-object v0, p1

    move-object v1, p2

    move-object v2, p3

    invoke-static/range {v0 .. v5}, Lb3/a;->d(Lp2/p;Ljava/lang/Object;Li2/d;Lp2/l;ILjava/lang/Object;)V

    :goto_2c
    return-void
.end method

.method public final c()Z
    .registers 2

    sget-object v0, Lw2/i0;->d:Lw2/i0;

    if-ne p0, v0, :cond_6

    const/4 v0, 0x1

    goto :goto_7

    :cond_6
    const/4 v0, 0x0

    :goto_7
    return v0
.end method
