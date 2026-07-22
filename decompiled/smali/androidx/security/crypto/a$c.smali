.class final enum Landroidx/security/crypto/a$c;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/security/crypto/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "c"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Landroidx/security/crypto/a$c;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum d:Landroidx/security/crypto/a$c;

.field public static final enum f:Landroidx/security/crypto/a$c;

.field public static final enum g:Landroidx/security/crypto/a$c;

.field public static final enum h:Landroidx/security/crypto/a$c;

.field public static final enum i:Landroidx/security/crypto/a$c;

.field public static final enum j:Landroidx/security/crypto/a$c;

.field private static final synthetic k:[Landroidx/security/crypto/a$c;


# instance fields
.field private final c:I


# direct methods
.method static constructor <clinit>()V
    .registers 3

    new-instance v0, Landroidx/security/crypto/a$c;

    const-string v1, "STRING"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2, v2}, Landroidx/security/crypto/a$c;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroidx/security/crypto/a$c;->d:Landroidx/security/crypto/a$c;

    new-instance v0, Landroidx/security/crypto/a$c;

    const-string v1, "STRING_SET"

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2, v2}, Landroidx/security/crypto/a$c;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroidx/security/crypto/a$c;->f:Landroidx/security/crypto/a$c;

    new-instance v0, Landroidx/security/crypto/a$c;

    const-string v1, "INT"

    const/4 v2, 0x2

    invoke-direct {v0, v1, v2, v2}, Landroidx/security/crypto/a$c;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroidx/security/crypto/a$c;->g:Landroidx/security/crypto/a$c;

    new-instance v0, Landroidx/security/crypto/a$c;

    const-string v1, "LONG"

    const/4 v2, 0x3

    invoke-direct {v0, v1, v2, v2}, Landroidx/security/crypto/a$c;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroidx/security/crypto/a$c;->h:Landroidx/security/crypto/a$c;

    new-instance v0, Landroidx/security/crypto/a$c;

    const-string v1, "FLOAT"

    const/4 v2, 0x4

    invoke-direct {v0, v1, v2, v2}, Landroidx/security/crypto/a$c;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroidx/security/crypto/a$c;->i:Landroidx/security/crypto/a$c;

    new-instance v0, Landroidx/security/crypto/a$c;

    const-string v1, "BOOLEAN"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2, v2}, Landroidx/security/crypto/a$c;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroidx/security/crypto/a$c;->j:Landroidx/security/crypto/a$c;

    invoke-static {}, Landroidx/security/crypto/a$c;->a()[Landroidx/security/crypto/a$c;

    move-result-object v0

    sput-object v0, Landroidx/security/crypto/a$c;->k:[Landroidx/security/crypto/a$c;

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

    iput p3, p0, Landroidx/security/crypto/a$c;->c:I

    return-void
.end method

.method private static synthetic a()[Landroidx/security/crypto/a$c;
    .registers 3

    const/4 v0, 0x6

    new-array v0, v0, [Landroidx/security/crypto/a$c;

    sget-object v1, Landroidx/security/crypto/a$c;->d:Landroidx/security/crypto/a$c;

    const/4 v2, 0x0

    aput-object v1, v0, v2

    sget-object v1, Landroidx/security/crypto/a$c;->f:Landroidx/security/crypto/a$c;

    const/4 v2, 0x1

    aput-object v1, v0, v2

    sget-object v1, Landroidx/security/crypto/a$c;->g:Landroidx/security/crypto/a$c;

    const/4 v2, 0x2

    aput-object v1, v0, v2

    sget-object v1, Landroidx/security/crypto/a$c;->h:Landroidx/security/crypto/a$c;

    const/4 v2, 0x3

    aput-object v1, v0, v2

    sget-object v1, Landroidx/security/crypto/a$c;->i:Landroidx/security/crypto/a$c;

    const/4 v2, 0x4

    aput-object v1, v0, v2

    sget-object v1, Landroidx/security/crypto/a$c;->j:Landroidx/security/crypto/a$c;

    const/4 v2, 0x5

    aput-object v1, v0, v2

    return-object v0
.end method

.method public static b(I)Landroidx/security/crypto/a$c;
    .registers 2

    if-eqz p0, :cond_22

    const/4 v0, 0x1

    if-eq p0, v0, :cond_1f

    const/4 v0, 0x2

    if-eq p0, v0, :cond_1c

    const/4 v0, 0x3

    if-eq p0, v0, :cond_19

    const/4 v0, 0x4

    if-eq p0, v0, :cond_16

    const/4 v0, 0x5

    if-eq p0, v0, :cond_13

    const/4 p0, 0x0

    return-object p0

    :cond_13
    sget-object p0, Landroidx/security/crypto/a$c;->j:Landroidx/security/crypto/a$c;

    return-object p0

    :cond_16
    sget-object p0, Landroidx/security/crypto/a$c;->i:Landroidx/security/crypto/a$c;

    return-object p0

    :cond_19
    sget-object p0, Landroidx/security/crypto/a$c;->h:Landroidx/security/crypto/a$c;

    return-object p0

    :cond_1c
    sget-object p0, Landroidx/security/crypto/a$c;->g:Landroidx/security/crypto/a$c;

    return-object p0

    :cond_1f
    sget-object p0, Landroidx/security/crypto/a$c;->f:Landroidx/security/crypto/a$c;

    return-object p0

    :cond_22
    sget-object p0, Landroidx/security/crypto/a$c;->d:Landroidx/security/crypto/a$c;

    return-object p0
.end method

.method public static valueOf(Ljava/lang/String;)Landroidx/security/crypto/a$c;
    .registers 2

    const-class v0, Landroidx/security/crypto/a$c;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Landroidx/security/crypto/a$c;

    return-object p0
.end method

.method public static values()[Landroidx/security/crypto/a$c;
    .registers 1

    sget-object v0, Landroidx/security/crypto/a$c;->k:[Landroidx/security/crypto/a$c;

    invoke-virtual {v0}, [Landroidx/security/crypto/a$c;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroidx/security/crypto/a$c;

    return-object v0
.end method


# virtual methods
.method public c()I
    .registers 2

    iget v0, p0, Landroidx/security/crypto/a$c;->c:I

    return v0
.end method
