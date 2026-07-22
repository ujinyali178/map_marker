.class public final Lw2/d0$a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Li2/g$c;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lw2/d0;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Li2/g$c<",
        "Lw2/d0;",
        ">;"
    }
.end annotation


# static fields
.field static final synthetic c:Lw2/d0$a;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lw2/d0$a;

    invoke-direct {v0}, Lw2/d0$a;-><init>()V

    sput-object v0, Lw2/d0$a;->c:Lw2/d0$a;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
