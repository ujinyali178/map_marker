.class public final La2/e$m$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La2/e$m;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field private a:Ljava/lang/Long;

.field private b:La2/e$w;

.field private c:Ljava/lang/Long;

.field private d:Ljava/lang/String;

.field private e:Ljava/lang/String;

.field private f:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()La2/e$m;
    .registers 3

    new-instance v0, La2/e$m;

    invoke-direct {v0}, La2/e$m;-><init>()V

    iget-object v1, p0, La2/e$m$a;->a:Ljava/lang/Long;

    invoke-virtual {v0, v1}, La2/e$m;->b(Ljava/lang/Long;)V

    iget-object v1, p0, La2/e$m$a;->b:La2/e$w;

    invoke-virtual {v0, v1}, La2/e$m;->g(La2/e$w;)V

    iget-object v1, p0, La2/e$m$a;->c:Ljava/lang/Long;

    invoke-virtual {v0, v1}, La2/e$m;->e(Ljava/lang/Long;)V

    iget-object v1, p0, La2/e$m$a;->d:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$m;->c(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$m$a;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$m;->d(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$m$a;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$m;->f(Ljava/lang/String;)V

    return-object v0
.end method

.method public b(Ljava/lang/Long;)La2/e$m$a;
    .registers 2

    iput-object p1, p0, La2/e$m$a;->a:Ljava/lang/Long;

    return-object p0
.end method

.method public c(Ljava/lang/String;)La2/e$m$a;
    .registers 2

    iput-object p1, p0, La2/e$m$a;->d:Ljava/lang/String;

    return-object p0
.end method

.method public d(Ljava/lang/String;)La2/e$m$a;
    .registers 2

    iput-object p1, p0, La2/e$m$a;->e:Ljava/lang/String;

    return-object p0
.end method

.method public e(Ljava/lang/Long;)La2/e$m$a;
    .registers 2

    iput-object p1, p0, La2/e$m$a;->c:Ljava/lang/Long;

    return-object p0
.end method

.method public f(Ljava/lang/String;)La2/e$m$a;
    .registers 2

    iput-object p1, p0, La2/e$m$a;->f:Ljava/lang/String;

    return-object p0
.end method

.method public g(La2/e$w;)La2/e$m$a;
    .registers 2

    iput-object p1, p0, La2/e$m$a;->b:La2/e$w;

    return-object p0
.end method
