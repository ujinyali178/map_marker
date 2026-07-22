.class public final synthetic Landroidx/activity/g;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic c:Landroidx/activity/h;


# direct methods
.method public synthetic constructor <init>(Landroidx/activity/h;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/activity/g;->c:Landroidx/activity/h;

    return-void
.end method


# virtual methods
.method public final run()V
    .registers 2

    iget-object v0, p0, Landroidx/activity/g;->c:Landroidx/activity/h;

    invoke-static {v0}, Landroidx/activity/h;->a(Landroidx/activity/h;)V

    return-void
.end method
