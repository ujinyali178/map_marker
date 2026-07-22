.class Lc0/g$q0;
.super Lc0/g$j;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "q0"
.end annotation


# instance fields
.field m:Lc0/g$p;

.field n:Lc0/g$p;

.field o:Lc0/g$p;

.field p:Lc0/g$p;

.field q:Lc0/g$p;


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lc0/g$j;-><init>()V

    return-void
.end method


# virtual methods
.method n()Ljava/lang/String;
    .registers 2

    const-string v0, "radialGradient"

    return-object v0
.end method
