.class Landroidx/security/crypto/c$a$a$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/security/crypto/c$a$a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "a"
.end annotation


# direct methods
.method static a(Landroid/security/keystore/KeyGenParameterSpec$Builder;)V
    .registers 2

    const/4 v0, 0x1

    invoke-static {p0, v0}, Landroidx/security/crypto/b;->a(Landroid/security/keystore/KeyGenParameterSpec$Builder;Z)Landroid/security/keystore/KeyGenParameterSpec$Builder;

    return-void
.end method
