.class Landroidx/core/app/a$f;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/app/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "f"
.end annotation


# direct methods
.method static a(Landroid/app/Activity;Ljava/lang/String;)Z
    .registers 2

    invoke-static {p0, p1}, Landroidx/core/app/c;->a(Landroid/app/Activity;Ljava/lang/String;)Z

    move-result p0

    return p0
.end method
