.class public final La2/e$i$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La2/e$i;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field private a:La2/e$k;

.field private b:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()La2/e$i;
    .registers 3

    new-instance v0, La2/e$i;

    invoke-direct {v0}, La2/e$i;-><init>()V

    iget-object v1, p0, La2/e$i$a;->a:La2/e$k;

    invoke-virtual {v0, v1}, La2/e$i;->b(La2/e$k;)V

    iget-object v1, p0, La2/e$i$a;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, La2/e$i;->c(Ljava/lang/String;)V

    return-object v0
.end method

.method public b(La2/e$k;)La2/e$i$a;
    .registers 2

    iput-object p1, p0, La2/e$i$a;->a:La2/e$k;

    return-object p0
.end method

.method public c(Ljava/lang/String;)La2/e$i$a;
    .registers 2

    iput-object p1, p0, La2/e$i$a;->b:Ljava/lang/String;

    return-object p0
.end method
