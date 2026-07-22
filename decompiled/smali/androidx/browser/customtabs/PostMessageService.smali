.class public Landroidx/browser/customtabs/PostMessageService;
.super Landroid/app/Service;
.source "SourceFile"


# instance fields
.field private c:Landroid/support/customtabs/IPostMessageService$Stub;


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    new-instance v0, Landroidx/browser/customtabs/PostMessageService$a;

    invoke-direct {v0, p0}, Landroidx/browser/customtabs/PostMessageService$a;-><init>(Landroidx/browser/customtabs/PostMessageService;)V

    iput-object v0, p0, Landroidx/browser/customtabs/PostMessageService;->c:Landroid/support/customtabs/IPostMessageService$Stub;

    return-void
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .registers 2

    iget-object p1, p0, Landroidx/browser/customtabs/PostMessageService;->c:Landroid/support/customtabs/IPostMessageService$Stub;

    return-object p1
.end method
