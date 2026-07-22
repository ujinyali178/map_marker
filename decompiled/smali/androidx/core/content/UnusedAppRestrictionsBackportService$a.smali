.class Landroidx/core/content/UnusedAppRestrictionsBackportService$a;
.super Li/b$a;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/content/UnusedAppRestrictionsBackportService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic c:Landroidx/core/content/UnusedAppRestrictionsBackportService;


# direct methods
.method constructor <init>(Landroidx/core/content/UnusedAppRestrictionsBackportService;)V
    .registers 2

    iput-object p1, p0, Landroidx/core/content/UnusedAppRestrictionsBackportService$a;->c:Landroidx/core/content/UnusedAppRestrictionsBackportService;

    invoke-direct {p0}, Li/b$a;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Li/a;)V
    .registers 3

    if-nez p1, :cond_3

    return-void

    :cond_3
    new-instance v0, Landroidx/core/content/o;

    invoke-direct {v0, p1}, Landroidx/core/content/o;-><init>(Li/a;)V

    iget-object p1, p0, Landroidx/core/content/UnusedAppRestrictionsBackportService$a;->c:Landroidx/core/content/UnusedAppRestrictionsBackportService;

    invoke-virtual {p1, v0}, Landroidx/core/content/UnusedAppRestrictionsBackportService;->a(Landroidx/core/content/o;)V

    return-void
.end method
