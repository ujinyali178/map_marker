.class public final synthetic Lb0/f;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lb0/u$b;


# instance fields
.field public final synthetic a:Lu1/l$d;


# direct methods
.method public synthetic constructor <init>(Lu1/l$d;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lb0/f;->a:Lu1/l$d;

    return-void
.end method


# virtual methods
.method public final a(Ljava/util/Map;)V
    .registers 3

    iget-object v0, p0, Lb0/f;->a:Lu1/l$d;

    invoke-interface {v0, p1}, Lu1/l$d;->a(Ljava/lang/Object;)V

    return-void
.end method
