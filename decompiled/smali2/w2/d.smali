.class final Lw2/d;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lw2/y1;


# static fields
.field public static final c:Lw2/d;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lw2/d;

    invoke-direct {v0}, Lw2/d;-><init>()V

    sput-object v0, Lw2/d;->c:Lw2/d;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .registers 2

    const-string v0, "Active"

    return-object v0
.end method
