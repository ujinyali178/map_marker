.class abstract Lc0/g$l0;
.super Lc0/g$n0;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x408
    name = "l0"
.end annotation


# instance fields
.field c:Ljava/lang/String;

.field d:Ljava/lang/Boolean;

.field e:Lc0/g$e0;

.field f:Lc0/g$e0;

.field g:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .registers 2

    invoke-direct {p0}, Lc0/g$n0;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lc0/g$l0;->c:Ljava/lang/String;

    iput-object v0, p0, Lc0/g$l0;->d:Ljava/lang/Boolean;

    iput-object v0, p0, Lc0/g$l0;->e:Lc0/g$e0;

    iput-object v0, p0, Lc0/g$l0;->f:Lc0/g$e0;

    iput-object v0, p0, Lc0/g$l0;->g:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .registers 2

    invoke-virtual {p0}, Lc0/g$n0;->n()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
