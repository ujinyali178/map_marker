.class final enum Lc0/b$u;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "u"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lc0/b$u;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum c:Lc0/b$u;

.field public static final enum d:Lc0/b$u;

.field private static final synthetic f:[Lc0/b$u;


# direct methods
.method static constructor <clinit>()V
    .registers 5

    new-instance v0, Lc0/b$u;

    const-string v1, "Document"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lc0/b$u;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lc0/b$u;->c:Lc0/b$u;

    new-instance v1, Lc0/b$u;

    const-string v3, "RenderOptions"

    const/4 v4, 0x1

    invoke-direct {v1, v3, v4}, Lc0/b$u;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lc0/b$u;->d:Lc0/b$u;

    const/4 v3, 0x2

    new-array v3, v3, [Lc0/b$u;

    aput-object v0, v3, v2

    aput-object v1, v3, v4

    sput-object v3, Lc0/b$u;->f:[Lc0/b$u;

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

.method public static valueOf(Ljava/lang/String;)Lc0/b$u;
    .registers 2

    const-class v0, Lc0/b$u;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lc0/b$u;

    return-object p0
.end method

.method public static values()[Lc0/b$u;
    .registers 1

    sget-object v0, Lc0/b$u;->f:[Lc0/b$u;

    invoke-virtual {v0}, [Lc0/b$u;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lc0/b$u;

    return-object v0
.end method
