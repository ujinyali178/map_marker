.class Lc0/h$k;
.super Lc0/h$j;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/h;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "k"
.end annotation


# instance fields
.field b:F

.field final synthetic c:Lc0/h;


# direct methods
.method private constructor <init>(Lc0/h;)V
    .registers 3

    iput-object p1, p0, Lc0/h$k;->c:Lc0/h;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lc0/h$j;-><init>(Lc0/h;Lc0/h$a;)V

    const/4 p1, 0x0

    iput p1, p0, Lc0/h$k;->b:F

    return-void
.end method

.method synthetic constructor <init>(Lc0/h;Lc0/h$a;)V
    .registers 3

    invoke-direct {p0, p1}, Lc0/h$k;-><init>(Lc0/h;)V

    return-void
.end method


# virtual methods
.method public b(Ljava/lang/String;)V
    .registers 4

    iget v0, p0, Lc0/h$k;->b:F

    iget-object v1, p0, Lc0/h$k;->c:Lc0/h;

    invoke-static {v1}, Lc0/h;->c(Lc0/h;)Lc0/h$h;

    move-result-object v1

    iget-object v1, v1, Lc0/h$h;->d:Landroid/graphics/Paint;

    invoke-virtual {v1, p1}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result p1

    add-float/2addr v0, p1

    iput v0, p0, Lc0/h$k;->b:F

    return-void
.end method
