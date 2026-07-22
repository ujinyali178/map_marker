.class Lc0/g$g;
.super Lc0/g$o0;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "g"
.end annotation


# static fields
.field private static c:Lc0/g$g;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lc0/g$g;

    invoke-direct {v0}, Lc0/g$g;-><init>()V

    sput-object v0, Lc0/g$g;->c:Lc0/g$g;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lc0/g$o0;-><init>()V

    return-void
.end method

.method static a()Lc0/g$g;
    .registers 1

    sget-object v0, Lc0/g$g;->c:Lc0/g$g;

    return-object v0
.end method
