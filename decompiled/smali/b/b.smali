.class public Lb/b;
.super Lb/a;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lb/b$a;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lb/a<",
        "Ljava/lang/String;",
        "Ljava/util/List<",
        "Landroid/net/Uri;",
        ">;>;"
    }
.end annotation


# static fields
.field public static final a:Lb/b$a;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lb/b$a;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lb/b$a;-><init>(Lkotlin/jvm/internal/g;)V

    sput-object v0, Lb/b;->a:Lb/b$a;

    return-void
.end method
