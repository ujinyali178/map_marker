.class Lc0/g$f1;
.super Lc0/g$r0;
.source "SourceFile"

# interfaces
.implements Lc0/g$t;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "f1"
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lc0/g$r0;-><init>()V

    return-void
.end method


# virtual methods
.method n()Ljava/lang/String;
    .registers 2

    const-string v0, "view"

    return-object v0
.end method
