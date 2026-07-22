.class Landroidx/security/crypto/c$a$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/security/crypto/c$a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/security/crypto/c$a$a$b;,
        Landroidx/security/crypto/c$a$a$a;
    }
.end annotation


# direct methods
.method static a(Landroidx/security/crypto/c$a;)Landroidx/security/crypto/c;
    .registers 5

    iget-object v0, p0, Landroidx/security/crypto/c$a;->c:Landroidx/security/crypto/c$b;

    if-nez v0, :cond_11

    iget-object v1, p0, Landroidx/security/crypto/c$a;->b:Landroid/security/keystore/KeyGenParameterSpec;

    if-eqz v1, :cond_9

    goto :goto_11

    :cond_9
    new-instance p0, Ljava/lang/IllegalArgumentException;

    const-string v0, "build() called before setKeyGenParameterSpec or setKeyScheme."

    invoke-direct {p0, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_11
    :goto_11
    sget-object v1, Landroidx/security/crypto/c$b;->c:Landroidx/security/crypto/c$b;

    if-ne v0, v1, :cond_71

    new-instance v0, Landroid/security/keystore/KeyGenParameterSpec$Builder;

    iget-object v1, p0, Landroidx/security/crypto/c$a;->a:Ljava/lang/String;

    const/4 v2, 0x3

    invoke-direct {v0, v1, v2}, Landroid/security/keystore/KeyGenParameterSpec$Builder;-><init>(Ljava/lang/String;I)V

    const-string v1, "GCM"

    filled-new-array {v1}, [Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/security/keystore/KeyGenParameterSpec$Builder;->setBlockModes([Ljava/lang/String;)Landroid/security/keystore/KeyGenParameterSpec$Builder;

    move-result-object v0

    const-string v1, "NoPadding"

    filled-new-array {v1}, [Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/security/keystore/KeyGenParameterSpec$Builder;->setEncryptionPaddings([Ljava/lang/String;)Landroid/security/keystore/KeyGenParameterSpec$Builder;

    move-result-object v0

    const/16 v1, 0x100

    invoke-virtual {v0, v1}, Landroid/security/keystore/KeyGenParameterSpec$Builder;->setKeySize(I)Landroid/security/keystore/KeyGenParameterSpec$Builder;

    move-result-object v0

    iget-boolean v1, p0, Landroidx/security/crypto/c$a;->d:Z

    if-eqz v1, :cond_50

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/security/keystore/KeyGenParameterSpec$Builder;->setUserAuthenticationRequired(Z)Landroid/security/keystore/KeyGenParameterSpec$Builder;

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x1e

    if-lt v1, v3, :cond_4b

    iget v1, p0, Landroidx/security/crypto/c$a;->e:I

    invoke-static {v0, v1, v2}, Landroidx/security/crypto/c$a$a$b;->a(Landroid/security/keystore/KeyGenParameterSpec$Builder;II)V

    goto :goto_50

    :cond_4b
    iget v1, p0, Landroidx/security/crypto/c$a;->e:I

    invoke-virtual {v0, v1}, Landroid/security/keystore/KeyGenParameterSpec$Builder;->setUserAuthenticationValidityDurationSeconds(I)Landroid/security/keystore/KeyGenParameterSpec$Builder;

    :cond_50
    :goto_50
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1c

    if-lt v1, v2, :cond_6b

    iget-boolean v1, p0, Landroidx/security/crypto/c$a;->f:Z

    if-eqz v1, :cond_6b

    iget-object v1, p0, Landroidx/security/crypto/c$a;->g:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    const-string v2, "android.hardware.strongbox_keystore"

    invoke-virtual {v1, v2}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_6b

    invoke-static {v0}, Landroidx/security/crypto/c$a$a$a;->a(Landroid/security/keystore/KeyGenParameterSpec$Builder;)V

    :cond_6b
    invoke-virtual {v0}, Landroid/security/keystore/KeyGenParameterSpec$Builder;->build()Landroid/security/keystore/KeyGenParameterSpec;

    move-result-object v0

    iput-object v0, p0, Landroidx/security/crypto/c$a;->b:Landroid/security/keystore/KeyGenParameterSpec;

    :cond_71
    iget-object v0, p0, Landroidx/security/crypto/c$a;->b:Landroid/security/keystore/KeyGenParameterSpec;

    if-eqz v0, :cond_81

    invoke-static {v0}, Landroidx/security/crypto/e;->c(Landroid/security/keystore/KeyGenParameterSpec;)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Landroidx/security/crypto/c;

    iget-object p0, p0, Landroidx/security/crypto/c$a;->b:Landroid/security/keystore/KeyGenParameterSpec;

    invoke-direct {v1, v0, p0}, Landroidx/security/crypto/c;-><init>(Ljava/lang/String;Ljava/lang/Object;)V

    return-object v1

    :cond_81
    new-instance p0, Ljava/lang/NullPointerException;

    const-string v0, "KeyGenParameterSpec was null after build() check"

    invoke-direct {p0, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method static b(Landroid/security/keystore/KeyGenParameterSpec;)Ljava/lang/String;
    .registers 1

    invoke-virtual {p0}, Landroid/security/keystore/KeyGenParameterSpec;->getKeystoreAlias()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method
