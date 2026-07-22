.class public final La2/e$k$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La2/e$k;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field private a:Ljava/lang/Long;

.field private b:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()La2/e$k;
    .registers 3

    new-instance v0, La2/e$k;

    invoke-direct {v0}, La2/e$k;-><init>()V

    iget-object v1, p0, La2/e$k$a;->a:Ljava/lang/Long;

    invoke-virtual {v0, v1}, La2/e$k;->c(Ljava/lang/Long;)V

    iget-object v1, p0, La2/e$k$a;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$k;->b(Ljava/lang/String;)V

    return-object v0
.end method

.method public b(Ljava/lang/String;)La2/e$k$a;
    .registers 2

    iput-object p1, p0, La2/e$k$a;->b:Ljava/lang/String;

    return-object p0
.end method

.method public c(Ljava/lang/Long;)La2/e$k$a;
    .registers 2

    iput-object p1, p0, La2/e$k$a;->a:Ljava/lang/Long;

    return-object p0
.end method
