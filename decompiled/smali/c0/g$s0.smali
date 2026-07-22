.class Lc0/g$s0;
.super Lc0/g$m;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "s0"
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lc0/g$m;-><init>()V

    return-void
.end method


# virtual methods
.method n()Ljava/lang/String;
    .registers 2

    const-string v0, "switch"

    return-object v0
.end method
