.class public final Lb/d$e;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lb/d$f;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lb/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "e"
.end annotation


# static fields
.field public static final a:Lb/d$e;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lb/d$e;

    invoke-direct {v0}, Lb/d$e;-><init>()V

    sput-object v0, Lb/d$e;->a:Lb/d$e;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
