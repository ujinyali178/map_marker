.class public final Lw2/x1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lw2/u0;
.implements Lw2/q;


# static fields
.field public static final c:Lw2/x1;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lw2/x1;

    invoke-direct {v0}, Lw2/x1;-><init>()V

    sput-object v0, Lw2/x1;->c:Lw2/x1;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .registers 1

    return-void
.end method

.method public d(Ljava/lang/Throwable;)Z
    .registers 2

    const/4 p1, 0x0

    return p1
.end method

.method public getParent()Lw2/l1;
    .registers 2

    const/4 v0, 0x0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    const-string v0, "NonDisposableHandle"

    return-object v0
.end method
