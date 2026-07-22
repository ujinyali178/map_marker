.class Lb1/d$a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lb1/f;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lb1/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "a"
.end annotation


# instance fields
.field final a:Lu1/l$d;

.field final synthetic b:Lb1/d;


# direct methods
.method constructor <init>(Lb1/d;Lu1/l$d;)V
    .registers 3

    iput-object p1, p0, Lb1/d$a;->b:Lb1/d;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p2, p0, Lb1/d$a;->a:Lu1/l$d;

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Object;)V
    .registers 3

    iget-object v0, p0, Lb1/d$a;->a:Lu1/l$d;

    invoke-interface {v0, p1}, Lu1/l$d;->a(Ljava/lang/Object;)V

    return-void
.end method

.method public b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    .registers 5

    iget-object v0, p0, Lb1/d$a;->a:Lu1/l$d;

    invoke-interface {v0, p1, p2, p3}, Lu1/l$d;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method
