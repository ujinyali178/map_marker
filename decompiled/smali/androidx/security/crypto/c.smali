.class public final Landroidx/security/crypto/c;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/security/crypto/c$a;,
        Landroidx/security/crypto/c$b;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Landroid/security/keystore/KeyGenParameterSpec;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/Object;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/security/crypto/c;->a:Ljava/lang/String;

    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v0, 0x17

    if-lt p1, v0, :cond_10

    check-cast p2, Landroid/security/keystore/KeyGenParameterSpec;

    iput-object p2, p0, Landroidx/security/crypto/c;->b:Landroid/security/keystore/KeyGenParameterSpec;

    goto :goto_13

    :cond_10
    const/4 p1, 0x0

    iput-object p1, p0, Landroidx/security/crypto/c;->b:Landroid/security/keystore/KeyGenParameterSpec;

    :goto_13
    return-void
.end method


# virtual methods
.method a()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Landroidx/security/crypto/c;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Z
    .registers 4

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/4 v1, 0x0

    const/16 v2, 0x17

    if-ge v0, v2, :cond_8

    return v1

    :cond_8
    :try_start_8
    const-string v0, "AndroidKeyStore"

    invoke-static {v0}, Ljava/security/KeyStore;->getInstance(Ljava/lang/String;)Ljava/security/KeyStore;

    move-result-object v0

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Ljava/security/KeyStore;->load(Ljava/security/KeyStore$LoadStoreParameter;)V

    iget-object v2, p0, Landroidx/security/crypto/c;->a:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/security/KeyStore;->containsAlias(Ljava/lang/String;)Z

    move-result v0
    :try_end_18
    .catch Ljava/security/KeyStoreException; {:try_start_8 .. :try_end_18} :catch_19
    .catch Ljava/security/cert/CertificateException; {:try_start_8 .. :try_end_18} :catch_19
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_8 .. :try_end_18} :catch_19
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_18} :catch_19

    return v0

    :catch_19
    return v1
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "MasterKey{keyAlias="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Landroidx/security/crypto/c;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ", isKeyStoreBacked="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Landroidx/security/crypto/c;->b()Z

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
