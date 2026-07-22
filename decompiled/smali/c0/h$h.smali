.class Lc0/h$h;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/h;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "h"
.end annotation


# instance fields
.field a:Lc0/g$e0;

.field b:Z

.field c:Z

.field d:Landroid/graphics/Paint;

.field e:Landroid/graphics/Paint;

.field f:Lc0/g$b;

.field g:Lc0/g$b;

.field h:Z

.field final synthetic i:Lc0/h;


# direct methods
.method constructor <init>(Lc0/h;)V
    .registers 5

    iput-object p1, p0, Lc0/h$h;->i:Lc0/h;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance p1, Landroid/graphics/Paint;

    invoke-direct {p1}, Landroid/graphics/Paint;-><init>()V

    iput-object p1, p0, Lc0/h$h;->d:Landroid/graphics/Paint;

    const/16 v0, 0xc1

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setFlags(I)V

    iget-object p1, p0, Lc0/h$h;->d:Landroid/graphics/Paint;

    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Landroid/graphics/Paint;->setHinting(I)V

    iget-object p1, p0, Lc0/h$h;->d:Landroid/graphics/Paint;

    sget-object v2, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {p1, v2}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    iget-object p1, p0, Lc0/h$h;->d:Landroid/graphics/Paint;

    sget-object v2, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {p1, v2}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    new-instance p1, Landroid/graphics/Paint;

    invoke-direct {p1}, Landroid/graphics/Paint;-><init>()V

    iput-object p1, p0, Lc0/h$h;->e:Landroid/graphics/Paint;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setFlags(I)V

    iget-object p1, p0, Lc0/h$h;->e:Landroid/graphics/Paint;

    invoke-virtual {p1, v1}, Landroid/graphics/Paint;->setHinting(I)V

    iget-object p1, p0, Lc0/h$h;->e:Landroid/graphics/Paint;

    sget-object v0, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    iget-object p1, p0, Lc0/h$h;->e:Landroid/graphics/Paint;

    sget-object v0, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    invoke-static {}, Lc0/g$e0;->a()Lc0/g$e0;

    move-result-object p1

    iput-object p1, p0, Lc0/h$h;->a:Lc0/g$e0;

    return-void
.end method

.method constructor <init>(Lc0/h;Lc0/h$h;)V
    .registers 4

    iput-object p1, p0, Lc0/h$h;->i:Lc0/h;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iget-boolean p1, p2, Lc0/h$h;->b:Z

    iput-boolean p1, p0, Lc0/h$h;->b:Z

    iget-boolean p1, p2, Lc0/h$h;->c:Z

    iput-boolean p1, p0, Lc0/h$h;->c:Z

    new-instance p1, Landroid/graphics/Paint;

    iget-object v0, p2, Lc0/h$h;->d:Landroid/graphics/Paint;

    invoke-direct {p1, v0}, Landroid/graphics/Paint;-><init>(Landroid/graphics/Paint;)V

    iput-object p1, p0, Lc0/h$h;->d:Landroid/graphics/Paint;

    new-instance p1, Landroid/graphics/Paint;

    iget-object v0, p2, Lc0/h$h;->e:Landroid/graphics/Paint;

    invoke-direct {p1, v0}, Landroid/graphics/Paint;-><init>(Landroid/graphics/Paint;)V

    iput-object p1, p0, Lc0/h$h;->e:Landroid/graphics/Paint;

    iget-object p1, p2, Lc0/h$h;->f:Lc0/g$b;

    if-eqz p1, :cond_2a

    new-instance v0, Lc0/g$b;

    invoke-direct {v0, p1}, Lc0/g$b;-><init>(Lc0/g$b;)V

    iput-object v0, p0, Lc0/h$h;->f:Lc0/g$b;

    :cond_2a
    iget-object p1, p2, Lc0/h$h;->g:Lc0/g$b;

    if-eqz p1, :cond_35

    new-instance v0, Lc0/g$b;

    invoke-direct {v0, p1}, Lc0/g$b;-><init>(Lc0/g$b;)V

    iput-object v0, p0, Lc0/h$h;->g:Lc0/g$b;

    :cond_35
    iget-boolean p1, p2, Lc0/h$h;->h:Z

    iput-boolean p1, p0, Lc0/h$h;->h:Z

    :try_start_39
    iget-object p1, p2, Lc0/h$h;->a:Lc0/g$e0;

    invoke-virtual {p1}, Lc0/g$e0;->clone()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lc0/g$e0;

    iput-object p1, p0, Lc0/h$h;->a:Lc0/g$e0;
    :try_end_43
    .catch Ljava/lang/CloneNotSupportedException; {:try_start_39 .. :try_end_43} :catch_44

    goto :goto_52

    :catch_44
    move-exception p1

    const-string p2, "SVGAndroidRenderer"

    const-string v0, "Unexpected clone error"

    invoke-static {p2, v0, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    invoke-static {}, Lc0/g$e0;->a()Lc0/g$e0;

    move-result-object p1

    iput-object p1, p0, Lc0/h$h;->a:Lc0/g$e0;

    :goto_52
    return-void
.end method
