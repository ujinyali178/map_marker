.class public final synthetic Landroidx/activity/i;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic c:Landroidx/activity/j;


# direct methods
.method public synthetic constructor <init>(Landroidx/activity/j;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/activity/i;->c:Landroidx/activity/j;

    return-void
.end method


# virtual methods
.method public final run()V
    .registers 2

    iget-object v0, p0, Landroidx/activity/i;->c:Landroidx/activity/j;

    invoke-static {v0}, Landroidx/activity/j;->a(Landroidx/activity/j;)V

    return-void
.end method
