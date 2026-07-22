.class public final Lw2/g2;
.super Li2/a;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lw2/g2$a;
    }
.end annotation


# static fields
.field public static final f:Lw2/g2$a;


# instance fields
.field public d:Z


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lw2/g2$a;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lw2/g2$a;-><init>(Lkotlin/jvm/internal/g;)V

    sput-object v0, Lw2/g2;->f:Lw2/g2$a;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    sget-object v0, Lw2/g2;->f:Lw2/g2$a;

    invoke-direct {p0, v0}, Li2/a;-><init>(Li2/g$c;)V

    return-void
.end method
