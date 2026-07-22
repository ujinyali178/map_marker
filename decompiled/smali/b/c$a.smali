.class public final Lb/c$a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lb/c;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# direct methods
.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/g;)V
    .registers 2

    invoke-direct {p0}, Lb/c$a;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()I
    .registers 2

    sget-object v0, Lb/d;->a:Lb/d$a;

    invoke-virtual {v0}, Lb/d$a;->f()Z

    move-result v0

    if-eqz v0, :cond_d

    invoke-static {}, Landroid/provider/MediaStore;->getPickImagesMaxLimit()I

    move-result v0

    goto :goto_10

    :cond_d
    const v0, 0x7fffffff

    :goto_10
    return v0
.end method
