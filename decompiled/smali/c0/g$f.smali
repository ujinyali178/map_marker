.class Lc0/g$f;
.super Lc0/g$o0;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "f"
.end annotation


# static fields
.field static final d:Lc0/g$f;

.field static final f:Lc0/g$f;


# instance fields
.field c:I


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lc0/g$f;

    const/high16 v1, -0x1000000

    invoke-direct {v0, v1}, Lc0/g$f;-><init>(I)V

    sput-object v0, Lc0/g$f;->d:Lc0/g$f;

    new-instance v0, Lc0/g$f;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lc0/g$f;-><init>(I)V

    sput-object v0, Lc0/g$f;->f:Lc0/g$f;

    return-void
.end method

.method constructor <init>(I)V
    .registers 2

    invoke-direct {p0}, Lc0/g$o0;-><init>()V

    iput p1, p0, Lc0/g$f;->c:I

    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .registers 4

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    iget v1, p0, Lc0/g$f;->c:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const/4 v2, 0x0

    aput-object v1, v0, v2

    const-string v1, "#%08x"

    invoke-static {v1, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
