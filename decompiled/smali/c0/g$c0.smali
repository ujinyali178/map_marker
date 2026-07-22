.class Lc0/g$c0;
.super Lc0/g$l0;
.source "SourceFile"

# interfaces
.implements Lc0/g$j0;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "c0"
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lc0/g$l0;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lc0/g$n0;",
            ">;"
        }
    .end annotation

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public i(Lc0/g$n0;)V
    .registers 2

    return-void
.end method

.method n()Ljava/lang/String;
    .registers 2

    const-string v0, "solidColor"

    return-object v0
.end method
