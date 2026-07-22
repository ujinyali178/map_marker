.class final La3/b;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Li2/d;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Li2/d<",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation


# static fields
.field public static final c:La3/b;

.field private static final d:Li2/g;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, La3/b;

    invoke-direct {v0}, La3/b;-><init>()V

    sput-object v0, La3/b;->c:La3/b;

    sget-object v0, Li2/h;->c:Li2/h;

    sput-object v0, La3/b;->d:Li2/g;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getContext()Li2/g;
    .registers 2

    sget-object v0, La3/b;->d:Li2/g;

    return-object v0
.end method

.method public resumeWith(Ljava/lang/Object;)V
    .registers 2

    return-void
.end method
