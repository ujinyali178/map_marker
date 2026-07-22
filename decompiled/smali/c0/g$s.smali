.class Lc0/g$s;
.super Lc0/g$h0;
.source "SourceFile"

# interfaces
.implements Lc0/g$t;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "s"
.end annotation


# instance fields
.field o:Ljava/lang/Boolean;

.field p:Ljava/lang/Boolean;

.field q:Lc0/g$p;

.field r:Lc0/g$p;

.field s:Lc0/g$p;

.field t:Lc0/g$p;


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lc0/g$h0;-><init>()V

    return-void
.end method


# virtual methods
.method n()Ljava/lang/String;
    .registers 2

    const-string v0, "mask"

    return-object v0
.end method
