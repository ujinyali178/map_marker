.class public abstract Lw2/c1;
.super Lw2/c0;
.source "SourceFile"

# interfaces
.implements Ljava/io/Closeable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lw2/c1$a;
    }
.end annotation


# static fields
.field public static final f:Lw2/c1$a;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lw2/c1$a;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lw2/c1$a;-><init>(Lkotlin/jvm/internal/g;)V

    sput-object v0, Lw2/c1;->f:Lw2/c1$a;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Lw2/c0;-><init>()V

    return-void
.end method
