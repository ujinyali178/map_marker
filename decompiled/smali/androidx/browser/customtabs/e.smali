.class public final synthetic Landroidx/browser/customtabs/e;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/os/IBinder$DeathRecipient;


# instance fields
.field public final synthetic a:Landroidx/browser/customtabs/CustomTabsService$a;

.field public final synthetic b:Landroidx/browser/customtabs/f;


# direct methods
.method public synthetic constructor <init>(Landroidx/browser/customtabs/CustomTabsService$a;Landroidx/browser/customtabs/f;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/browser/customtabs/e;->a:Landroidx/browser/customtabs/CustomTabsService$a;

    iput-object p2, p0, Landroidx/browser/customtabs/e;->b:Landroidx/browser/customtabs/f;

    return-void
.end method


# virtual methods
.method public final binderDied()V
    .registers 3

    iget-object v0, p0, Landroidx/browser/customtabs/e;->a:Landroidx/browser/customtabs/CustomTabsService$a;

    iget-object v1, p0, Landroidx/browser/customtabs/e;->b:Landroidx/browser/customtabs/f;

    invoke-static {v0, v1}, Landroidx/browser/customtabs/CustomTabsService$a;->b(Landroidx/browser/customtabs/CustomTabsService$a;Landroidx/browser/customtabs/f;)V

    return-void
.end method
