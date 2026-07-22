.class public final synthetic Lb0/g;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lb0/b;


# instance fields
.field public final synthetic a:Lu1/l$d;


# direct methods
.method public synthetic constructor <init>(Lu1/l$d;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lb0/g;->a:Lu1/l$d;

    return-void
.end method


# virtual methods
.method public final a(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4

    iget-object v0, p0, Lb0/g;->a:Lu1/l$d;

    invoke-static {v0, p1, p2}, Lb0/l;->a(Lu1/l$d;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
