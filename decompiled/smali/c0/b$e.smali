.class final enum Lc0/b$e;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "e"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lc0/b$e;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum c:Lc0/b$e;

.field public static final enum d:Lc0/b$e;

.field public static final enum f:Lc0/b$e;

.field private static final synthetic g:[Lc0/b$e;


# direct methods
.method static constructor <clinit>()V
    .registers 7

    new-instance v0, Lc0/b$e;

    const-string v1, "DESCENDANT"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lc0/b$e;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lc0/b$e;->c:Lc0/b$e;

    new-instance v1, Lc0/b$e;

    const-string v3, "CHILD"

    const/4 v4, 0x1

    invoke-direct {v1, v3, v4}, Lc0/b$e;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lc0/b$e;->d:Lc0/b$e;

    new-instance v3, Lc0/b$e;

    const-string v5, "FOLLOWS"

    const/4 v6, 0x2

    invoke-direct {v3, v5, v6}, Lc0/b$e;-><init>(Ljava/lang/String;I)V

    sput-object v3, Lc0/b$e;->f:Lc0/b$e;

    const/4 v5, 0x3

    new-array v5, v5, [Lc0/b$e;

    aput-object v0, v5, v2

    aput-object v1, v5, v4

    aput-object v3, v5, v6

    sput-object v5, Lc0/b$e;->g:[Lc0/b$e;

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

.method public static valueOf(Ljava/lang/String;)Lc0/b$e;
    .registers 2

    const-class v0, Lc0/b$e;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lc0/b$e;

    return-object p0
.end method

.method public static values()[Lc0/b$e;
    .registers 1

    sget-object v0, Lc0/b$e;->g:[Lc0/b$e;

    invoke-virtual {v0}, [Lc0/b$e;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lc0/b$e;

    return-object v0
.end method
