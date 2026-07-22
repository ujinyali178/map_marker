.class public final enum La2/e$p;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La2/e;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "p"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "La2/e$p;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum d:La2/e$p;

.field public static final enum f:La2/e$p;

.field private static final synthetic g:[La2/e$p;


# instance fields
.field final c:I


# direct methods
.method static constructor <clinit>()V
    .registers 3

    new-instance v0, La2/e$p;

    const-string v1, "INAPP"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2, v2}, La2/e$p;-><init>(Ljava/lang/String;II)V

    sput-object v0, La2/e$p;->d:La2/e$p;

    new-instance v0, La2/e$p;

    const-string v1, "SUBS"

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2, v2}, La2/e$p;-><init>(Ljava/lang/String;II)V

    sput-object v0, La2/e$p;->f:La2/e$p;

    invoke-static {}, La2/e$p;->a()[La2/e$p;

    move-result-object v0

    sput-object v0, La2/e$p;->g:[La2/e$p;

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

    iput p3, p0, La2/e$p;->c:I

    return-void
.end method

.method private static synthetic a()[La2/e$p;
    .registers 3

    const/4 v0, 0x2

    new-array v0, v0, [La2/e$p;

    sget-object v1, La2/e$p;->d:La2/e$p;

    const/4 v2, 0x0

    aput-object v1, v0, v2

    sget-object v1, La2/e$p;->f:La2/e$p;

    const/4 v2, 0x1

    aput-object v1, v0, v2

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)La2/e$p;
    .registers 2

    const-class v0, La2/e$p;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, La2/e$p;

    return-object p0
.end method

.method public static values()[La2/e$p;
    .registers 1

    sget-object v0, La2/e$p;->g:[La2/e$p;

    invoke-virtual {v0}, [La2/e$p;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [La2/e$p;

    return-object v0
.end method
