.class public final synthetic Lb0/e;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lb0/u$a;


# instance fields
.field public final synthetic a:Lu1/l$d;


# direct methods
.method public synthetic constructor <init>(Lu1/l$d;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lb0/e;->a:Lu1/l$d;

    return-void
.end method


# virtual methods
.method public final a(I)V
    .registers 3

    iget-object v0, p0, Lb0/e;->a:Lu1/l$d;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-interface {v0, p1}, Lu1/l$d;->a(Ljava/lang/Object;)V

    return-void
.end method
