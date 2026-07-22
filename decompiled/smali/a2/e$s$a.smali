.class public final La2/e$s$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La2/e$s;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field private a:La2/e$k;

.field private b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "La2/e$r;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()La2/e$s;
    .registers 3

    new-instance v0, La2/e$s;

    invoke-direct {v0}, La2/e$s;-><init>()V

    iget-object v1, p0, La2/e$s$a;->a:La2/e$k;

    invoke-virtual {v0, v1}, La2/e$s;->b(La2/e$k;)V

    iget-object v1, p0, La2/e$s$a;->b:Ljava/util/List;

    invoke-virtual {v0, v1}, La2/e$s;->c(Ljava/util/List;)V

    return-object v0
.end method

.method public b(La2/e$k;)La2/e$s$a;
    .registers 2

    iput-object p1, p0, La2/e$s$a;->a:La2/e$k;

    return-object p0
.end method

.method public c(Ljava/util/List;)La2/e$s$a;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "La2/e$r;",
            ">;)",
            "La2/e$s$a;"
        }
    .end annotation

    iput-object p1, p0, La2/e$s$a;->b:Ljava/util/List;

    return-object p0
.end method
