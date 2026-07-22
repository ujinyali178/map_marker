.class final enum Lc0/b$c;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "c"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lc0/b$c;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum c:Lc0/b$c;

.field public static final enum d:Lc0/b$c;

.field public static final enum f:Lc0/b$c;

.field public static final enum g:Lc0/b$c;

.field private static final synthetic h:[Lc0/b$c;


# direct methods
.method static constructor <clinit>()V
    .registers 9

    new-instance v0, Lc0/b$c;

    const-string v1, "EXISTS"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lc0/b$c;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lc0/b$c;->c:Lc0/b$c;

    new-instance v1, Lc0/b$c;

    const-string v3, "EQUALS"

    const/4 v4, 0x1

    invoke-direct {v1, v3, v4}, Lc0/b$c;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lc0/b$c;->d:Lc0/b$c;

    new-instance v3, Lc0/b$c;

    const-string v5, "INCLUDES"

    const/4 v6, 0x2

    invoke-direct {v3, v5, v6}, Lc0/b$c;-><init>(Ljava/lang/String;I)V

    sput-object v3, Lc0/b$c;->f:Lc0/b$c;

    new-instance v5, Lc0/b$c;

    const-string v7, "DASHMATCH"

    const/4 v8, 0x3

    invoke-direct {v5, v7, v8}, Lc0/b$c;-><init>(Ljava/lang/String;I)V

    sput-object v5, Lc0/b$c;->g:Lc0/b$c;

    const/4 v7, 0x4

    new-array v7, v7, [Lc0/b$c;

    aput-object v0, v7, v2

    aput-object v1, v7, v4

    aput-object v3, v7, v6

    aput-object v5, v7, v8

    sput-object v7, Lc0/b$c;->h:[Lc0/b$c;

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

.method public static valueOf(Ljava/lang/String;)Lc0/b$c;
    .registers 2

    const-class v0, Lc0/b$c;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lc0/b$c;

    return-object p0
.end method

.method public static values()[Lc0/b$c;
    .registers 1

    sget-object v0, Lc0/b$c;->h:[Lc0/b$c;

    invoke-virtual {v0}, [Lc0/b$c;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lc0/b$c;

    return-object v0
.end method
