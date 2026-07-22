.class public final enum La2/e$t;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La2/e;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "t"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "La2/e$t;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum d:La2/e$t;

.field public static final enum f:La2/e$t;

.field public static final enum g:La2/e$t;

.field private static final synthetic h:[La2/e$t;


# instance fields
.field final c:I


# direct methods
.method static constructor <clinit>()V
    .registers 3

    new-instance v0, La2/e$t;

    const-string v1, "UNSPECIFIED"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2, v2}, La2/e$t;-><init>(Ljava/lang/String;II)V

    sput-object v0, La2/e$t;->d:La2/e$t;

    new-instance v0, La2/e$t;

    const-string v1, "PURCHASED"

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2, v2}, La2/e$t;-><init>(Ljava/lang/String;II)V

    sput-object v0, La2/e$t;->f:La2/e$t;

    new-instance v0, La2/e$t;

    const-string v1, "PENDING"

    const/4 v2, 0x2

    invoke-direct {v0, v1, v2, v2}, La2/e$t;-><init>(Ljava/lang/String;II)V

    sput-object v0, La2/e$t;->g:La2/e$t;

    invoke-static {}, La2/e$t;->a()[La2/e$t;

    move-result-object v0

    sput-object v0, La2/e$t;->h:[La2/e$t;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput p3, p0, La2/e$t;->c:I

    return-void
.end method

.method private static synthetic a()[La2/e$t;
    .registers 3

    const/4 v0, 0x3

    new-array v0, v0, [La2/e$t;

    sget-object v1, La2/e$t;->d:La2/e$t;

    const/4 v2, 0x0

    aput-object v1, v0, v2

    sget-object v1, La2/e$t;->f:La2/e$t;

    const/4 v2, 0x1

    aput-object v1, v0, v2

    sget-object v1, La2/e$t;->g:La2/e$t;

    const/4 v2, 0x2

    aput-object v1, v0, v2

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)La2/e$t;
    .registers 2

    const-class v0, La2/e$t;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, La2/e$t;

    return-object p0
.end method

.method public static values()[La2/e$t;
    .registers 1

    sget-object v0, La2/e$t;->h:[La2/e$t;

    invoke-virtual {v0}, [La2/e$t;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [La2/e$t;

    return-object v0
.end method
