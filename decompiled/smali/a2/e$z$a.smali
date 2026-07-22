.class public final La2/e$z$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La2/e$z;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:La2/e$p;


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()La2/e$z;
    .registers 3

    new-instance v0, La2/e$z;

    invoke-direct {v0}, La2/e$z;-><init>()V

    iget-object v1, p0, La2/e$z$a;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$z;->b(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$z$a;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$z;->c(Ljava/lang/String;)V

    iget-object v1, p0, La2/e$z$a;->c:La2/e$p;

    invoke-virtual {v0, v1}, La2/e$z;->d(La2/e$p;)V

    return-object v0
.end method

.method public b(Ljava/lang/String;)La2/e$z$a;
    .registers 2

    iput-object p1, p0, La2/e$z$a;->a:Ljava/lang/String;

    return-object p0
.end method

.method public c(Ljava/lang/String;)La2/e$z$a;
    .registers 2

    iput-object p1, p0, La2/e$z$a;->b:Ljava/lang/String;

    return-object p0
.end method

.method public d(La2/e$p;)La2/e$z$a;
    .registers 2

    iput-object p1, p0, La2/e$z$a;->c:La2/e$p;

    return-object p0
.end method
