.class public final synthetic Landroid/security/keystore/KeyGenParameterSpec;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/security/spec/AlgorithmParameterSpec;


# direct methods
.method static synthetic constructor <clinit>()V
    .registers 1

    new-instance v0, Ljava/lang/NoClassDefFoundError;

    invoke-direct {v0}, Ljava/lang/NoClassDefFoundError;-><init>()V

    throw v0
.end method


# virtual methods
.method public native synthetic getBlockModes()[Ljava/lang/String;
    .annotation build Landroid/annotation/NonNull;
    .end annotation
.end method

.method public native synthetic getEncryptionPaddings()[Ljava/lang/String;
    .annotation build Landroid/annotation/NonNull;
    .end annotation
.end method

.method public native synthetic getKeySize()I
.end method

.method public native synthetic getKeystoreAlias()Ljava/lang/String;
    .annotation build Landroid/annotation/NonNull;
    .end annotation
.end method

.method public native synthetic getPurposes()I
.end method

.method public native synthetic getUserAuthenticationValidityDurationSeconds()I
.end method

.method public native synthetic isUserAuthenticationRequired()Z
.end method
