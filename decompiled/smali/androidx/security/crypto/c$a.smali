.class public final Landroidx/security/crypto/c$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/security/crypto/c;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/security/crypto/c$a$a;
    }
.end annotation


# instance fields
.field final a:Ljava/lang/String;

.field b:Landroid/security/keystore/KeyGenParameterSpec;

.field c:Landroidx/security/crypto/c$b;

.field d:Z

.field e:I

.field f:Z

.field final g:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3

    const-string v0, "_androidx_security_master_key_"

    invoke-direct {p0, p1, v0}, Landroidx/security/crypto/c$a;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object p1

    iput-object p1, p0, Landroidx/security/crypto/c$a;->g:Landroid/content/Context;

    iput-object p2, p0, Landroidx/security/crypto/c$a;->a:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public a()Landroidx/security/crypto/c;
    .registers 4

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_b

    invoke-static {p0}, Landroidx/security/crypto/c$a$a;->a(Landroidx/security/crypto/c$a;)Landroidx/security/crypto/c;

    move-result-object v0

    return-object v0

    :cond_b
    new-instance v0, Landroidx/security/crypto/c;

    iget-object v1, p0, Landroidx/security/crypto/c$a;->a:Ljava/lang/String;

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Landroidx/security/crypto/c;-><init>(Ljava/lang/String;Ljava/lang/Object;)V

    return-object v0
.end method

.method public b(Landroid/security/keystore/KeyGenParameterSpec;)Landroidx/security/crypto/c$a;
    .registers 5

    iget-object v0, p0, Landroidx/security/crypto/c$a;->c:Landroidx/security/crypto/c$b;

    if-nez v0, :cond_38

    iget-object v0, p0, Landroidx/security/crypto/c$a;->a:Ljava/lang/String;

    invoke-static {p1}, Landroidx/security/crypto/c$a$a;->b(Landroid/security/keystore/KeyGenParameterSpec;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_13

    iput-object p1, p0, Landroidx/security/crypto/c$a;->b:Landroid/security/keystore/KeyGenParameterSpec;

    return-object p0

    :cond_13
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "KeyGenParamSpec\'s key alias does not match provided alias ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Landroidx/security/crypto/c$a;->a:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, " vs "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {p1}, Landroidx/security/crypto/c$a$a;->b(Landroid/security/keystore/KeyGenParameterSpec;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_38
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string v0, "KeyGenParamSpec set after setting a KeyScheme"

    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method
