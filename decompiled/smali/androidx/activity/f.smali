.class public final synthetic Landroidx/activity/f;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic c:Landroidx/activity/ComponentActivity$g;


# direct methods
.method public synthetic constructor <init>(Landroidx/activity/ComponentActivity$g;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/activity/f;->c:Landroidx/activity/ComponentActivity$g;

    return-void
.end method


# virtual methods
.method public final run()V
    .registers 2

    iget-object v0, p0, Landroidx/activity/f;->c:Landroidx/activity/ComponentActivity$g;

    invoke-static {v0}, Landroidx/activity/ComponentActivity$g;->a(Landroidx/activity/ComponentActivity$g;)V

    return-void
.end method
