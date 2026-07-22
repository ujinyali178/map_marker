.class public final enum Landroidx/lifecycle/e$b;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/lifecycle/e;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "b"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Landroidx/lifecycle/e$b;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum c:Landroidx/lifecycle/e$b;

.field public static final enum d:Landroidx/lifecycle/e$b;

.field public static final enum f:Landroidx/lifecycle/e$b;

.field public static final enum g:Landroidx/lifecycle/e$b;

.field public static final enum h:Landroidx/lifecycle/e$b;

.field private static final synthetic i:[Landroidx/lifecycle/e$b;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    new-instance v0, Landroidx/lifecycle/e$b;

    const-string v1, "DESTROYED"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Landroidx/lifecycle/e$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroidx/lifecycle/e$b;->c:Landroidx/lifecycle/e$b;

    new-instance v0, Landroidx/lifecycle/e$b;

    const-string v1, "INITIALIZED"

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Landroidx/lifecycle/e$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroidx/lifecycle/e$b;->d:Landroidx/lifecycle/e$b;

    new-instance v0, Landroidx/lifecycle/e$b;

    const-string v1, "CREATED"

    const/4 v2, 0x2

    invoke-direct {v0, v1, v2}, Landroidx/lifecycle/e$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroidx/lifecycle/e$b;->f:Landroidx/lifecycle/e$b;

    new-instance v0, Landroidx/lifecycle/e$b;

    const-string v1, "STARTED"

    const/4 v2, 0x3

    invoke-direct {v0, v1, v2}, Landroidx/lifecycle/e$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroidx/lifecycle/e$b;->g:Landroidx/lifecycle/e$b;

    new-instance v0, Landroidx/lifecycle/e$b;

    const-string v1, "RESUMED"

    const/4 v2, 0x4

    invoke-direct {v0, v1, v2}, Landroidx/lifecycle/e$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Landroidx/lifecycle/e$b;->h:Landroidx/lifecycle/e$b;

    invoke-static {}, Landroidx/lifecycle/e$b;->a()[Landroidx/lifecycle/e$b;

    move-result-object v0

    sput-object v0, Landroidx/lifecycle/e$b;->i:[Landroidx/lifecycle/e$b;

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

.method private static final synthetic a()[Landroidx/lifecycle/e$b;
    .registers 3

    const/4 v0, 0x5

    new-array v0, v0, [Landroidx/lifecycle/e$b;

    sget-object v1, Landroidx/lifecycle/e$b;->c:Landroidx/lifecycle/e$b;

    const/4 v2, 0x0

    aput-object v1, v0, v2

    sget-object v1, Landroidx/lifecycle/e$b;->d:Landroidx/lifecycle/e$b;

    const/4 v2, 0x1

    aput-object v1, v0, v2

    sget-object v1, Landroidx/lifecycle/e$b;->f:Landroidx/lifecycle/e$b;

    const/4 v2, 0x2

    aput-object v1, v0, v2

    sget-object v1, Landroidx/lifecycle/e$b;->g:Landroidx/lifecycle/e$b;

    const/4 v2, 0x3

    aput-object v1, v0, v2

    sget-object v1, Landroidx/lifecycle/e$b;->h:Landroidx/lifecycle/e$b;

    const/4 v2, 0x4

    aput-object v1, v0, v2

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Landroidx/lifecycle/e$b;
    .registers 2

    const-class v0, Landroidx/lifecycle/e$b;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Landroidx/lifecycle/e$b;

    return-object p0
.end method

.method public static values()[Landroidx/lifecycle/e$b;
    .registers 1

    sget-object v0, Landroidx/lifecycle/e$b;->i:[Landroidx/lifecycle/e$b;

    invoke-virtual {v0}, [Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroidx/lifecycle/e$b;

    return-object v0
.end method


# virtual methods
.method public final b(Landroidx/lifecycle/e$b;)Z
    .registers 3

    const-string v0, "state"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/k;->e(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Ljava/lang/Enum;->compareTo(Ljava/lang/Enum;)I

    move-result p1

    if-ltz p1, :cond_d

    const/4 p1, 0x1

    goto :goto_e

    :cond_d
    const/4 p1, 0x0

    :goto_e
    return p1
.end method
