.class public final synthetic Landroidx/fragment/app/u;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/core/util/a;


# instance fields
.field public final synthetic a:Landroidx/fragment/app/w;


# direct methods
.method public synthetic constructor <init>(Landroidx/fragment/app/w;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/fragment/app/u;->a:Landroidx/fragment/app/w;

    return-void
.end method


# virtual methods
.method public final accept(Ljava/lang/Object;)V
    .registers 3

    iget-object v0, p0, Landroidx/fragment/app/u;->a:Landroidx/fragment/app/w;

    check-cast p1, Landroidx/core/app/d1;

    invoke-static {v0, p1}, Landroidx/fragment/app/w;->b(Landroidx/fragment/app/w;Landroidx/core/app/d1;)V

    return-void
.end method
