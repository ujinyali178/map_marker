.class final enum Lc0/g$k;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "k"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lc0/g$k;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum c:Lc0/g$k;

.field public static final enum d:Lc0/g$k;

.field public static final enum f:Lc0/g$k;

.field private static final synthetic g:[Lc0/g$k;


# direct methods
.method static constructor <clinit>()V
    .registers 7

    new-instance v0, Lc0/g$k;

    const-string v1, "pad"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lc0/g$k;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lc0/g$k;->c:Lc0/g$k;

    new-instance v1, Lc0/g$k;

    const-string v3, "reflect"

    const/4 v4, 0x1

    invoke-direct {v1, v3, v4}, Lc0/g$k;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lc0/g$k;->d:Lc0/g$k;

    new-instance v3, Lc0/g$k;

    const-string v5, "repeat"

    const/4 v6, 0x2

    invoke-direct {v3, v5, v6}, Lc0/g$k;-><init>(Ljava/lang/String;I)V

    sput-object v3, Lc0/g$k;->f:Lc0/g$k;

    const/4 v5, 0x3

    new-array v5, v5, [Lc0/g$k;

    aput-object v0, v5, v2

    aput-object v1, v5, v4

    aput-object v3, v5, v6

    sput-object v5, Lc0/g$k;->g:[Lc0/g$k;

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

.method public static valueOf(Ljava/lang/String;)Lc0/g$k;
    .registers 2

    const-class v0, Lc0/g$k;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lc0/g$k;

    return-object p0
.end method

.method public static values()[Lc0/g$k;
    .registers 1

    sget-object v0, Lc0/g$k;->g:[Lc0/g$k;

    invoke-virtual {v0}, [Lc0/g$k;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lc0/g$k;

    return-object v0
.end method
