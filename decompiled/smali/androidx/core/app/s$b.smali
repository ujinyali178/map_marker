.class public Landroidx/core/app/s$b;
.super Landroidx/core/app/s$f;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/app/s;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "b"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/app/s$b$a;
    }
.end annotation


# instance fields
.field private e:Ljava/lang/CharSequence;


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Landroidx/core/app/s$f;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/os/Bundle;)V
    .registers 2

    invoke-super {p0, p1}, Landroidx/core/app/s$f;->a(Landroid/os/Bundle;)V

    return-void
.end method

.method public b(Landroidx/core/app/r;)V
    .registers 3

    invoke-interface {p1}, Landroidx/core/app/r;->a()Landroid/app/Notification$Builder;

    move-result-object p1

    invoke-static {p1}, Landroidx/core/app/s$b$a;->b(Landroid/app/Notification$Builder;)Landroid/app/Notification$BigTextStyle;

    move-result-object p1

    iget-object v0, p0, Landroidx/core/app/s$f;->b:Ljava/lang/CharSequence;

    invoke-static {p1, v0}, Landroidx/core/app/s$b$a;->c(Landroid/app/Notification$BigTextStyle;Ljava/lang/CharSequence;)Landroid/app/Notification$BigTextStyle;

    move-result-object p1

    iget-object v0, p0, Landroidx/core/app/s$b;->e:Ljava/lang/CharSequence;

    invoke-static {p1, v0}, Landroidx/core/app/s$b$a;->a(Landroid/app/Notification$BigTextStyle;Ljava/lang/CharSequence;)Landroid/app/Notification$BigTextStyle;

    move-result-object p1

    iget-boolean v0, p0, Landroidx/core/app/s$f;->d:Z

    if-eqz v0, :cond_1d

    iget-object v0, p0, Landroidx/core/app/s$f;->c:Ljava/lang/CharSequence;

    invoke-static {p1, v0}, Landroidx/core/app/s$b$a;->d(Landroid/app/Notification$BigTextStyle;Ljava/lang/CharSequence;)Landroid/app/Notification$BigTextStyle;

    :cond_1d
    return-void
.end method

.method protected c()Ljava/lang/String;
    .registers 2

    const-string v0, "androidx.core.app.NotificationCompat$BigTextStyle"

    return-object v0
.end method

.method public h(Ljava/lang/CharSequence;)Landroidx/core/app/s$b;
    .registers 2

    invoke-static {p1}, Landroidx/core/app/s$d;->d(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object p1

    iput-object p1, p0, Landroidx/core/app/s$b;->e:Ljava/lang/CharSequence;

    return-object p0
.end method
