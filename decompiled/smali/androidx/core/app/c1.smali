.class public Landroidx/core/app/c1;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/app/c1$b;,
        Landroidx/core/app/c1$a;
    }
.end annotation


# instance fields
.field a:Ljava/lang/CharSequence;

.field b:Landroidx/core/graphics/drawable/IconCompat;

.field c:Ljava/lang/String;

.field d:Ljava/lang/String;

.field e:Z

.field f:Z


# direct methods
.method constructor <init>(Landroidx/core/app/c1$b;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iget-object v0, p1, Landroidx/core/app/c1$b;->a:Ljava/lang/CharSequence;

    iput-object v0, p0, Landroidx/core/app/c1;->a:Ljava/lang/CharSequence;

    iget-object v0, p1, Landroidx/core/app/c1$b;->b:Landroidx/core/graphics/drawable/IconCompat;

    iput-object v0, p0, Landroidx/core/app/c1;->b:Landroidx/core/graphics/drawable/IconCompat;

    iget-object v0, p1, Landroidx/core/app/c1$b;->c:Ljava/lang/String;

    iput-object v0, p0, Landroidx/core/app/c1;->c:Ljava/lang/String;

    iget-object v0, p1, Landroidx/core/app/c1$b;->d:Ljava/lang/String;

    iput-object v0, p0, Landroidx/core/app/c1;->d:Ljava/lang/String;

    iget-boolean v0, p1, Landroidx/core/app/c1$b;->e:Z

    iput-boolean v0, p0, Landroidx/core/app/c1;->e:Z

    iget-boolean p1, p1, Landroidx/core/app/c1$b;->f:Z

    iput-boolean p1, p0, Landroidx/core/app/c1;->f:Z

    return-void
.end method


# virtual methods
.method public a()Landroidx/core/graphics/drawable/IconCompat;
    .registers 2

    iget-object v0, p0, Landroidx/core/app/c1;->b:Landroidx/core/graphics/drawable/IconCompat;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Landroidx/core/app/c1;->d:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Landroidx/core/app/c1;->a:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Landroidx/core/app/c1;->c:Ljava/lang/String;

    return-object v0
.end method

.method public e()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/core/app/c1;->e:Z

    return v0
.end method

.method public f()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/core/app/c1;->f:Z

    return v0
.end method

.method public g()Ljava/lang/String;
    .registers 3

    iget-object v0, p0, Landroidx/core/app/c1;->c:Ljava/lang/String;

    if-eqz v0, :cond_5

    return-object v0

    :cond_5
    iget-object v0, p0, Landroidx/core/app/c1;->a:Ljava/lang/CharSequence;

    if-eqz v0, :cond_1d

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "name:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Landroidx/core/app/c1;->a:Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_1d
    const-string v0, ""

    return-object v0
.end method

.method public h()Landroid/app/Person;
    .registers 2

    invoke-static {p0}, Landroidx/core/app/c1$a;->b(Landroidx/core/app/c1;)Landroid/app/Person;

    move-result-object v0

    return-object v0
.end method

.method public i()Landroid/os/Bundle;
    .registers 4

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iget-object v1, p0, Landroidx/core/app/c1;->a:Ljava/lang/CharSequence;

    const-string v2, "name"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putCharSequence(Ljava/lang/String;Ljava/lang/CharSequence;)V

    iget-object v1, p0, Landroidx/core/app/c1;->b:Landroidx/core/graphics/drawable/IconCompat;

    if-eqz v1, :cond_15

    invoke-virtual {v1}, Landroidx/core/graphics/drawable/IconCompat;->q()Landroid/os/Bundle;

    move-result-object v1

    goto :goto_16

    :cond_15
    const/4 v1, 0x0

    :goto_16
    const-string v2, "icon"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    iget-object v1, p0, Landroidx/core/app/c1;->c:Ljava/lang/String;

    const-string v2, "uri"

    invoke-virtual {v0, v2, v1}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Landroidx/core/app/c1;->d:Ljava/lang/String;

    const-string v2, "key"

    invoke-virtual {v0, v2, v1}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    iget-boolean v1, p0, Landroidx/core/app/c1;->e:Z

    const-string v2, "isBot"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    iget-boolean v1, p0, Landroidx/core/app/c1;->f:Z

    const-string v2, "isImportant"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    return-object v0
.end method
