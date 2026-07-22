.class public final synthetic Landroidx/core/location/a;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a(Landroidx/core/location/b;I)V
    .registers 2

    return-void
.end method

.method public static b(Landroidx/core/location/b;Ljava/util/List;)V
    .registers 5

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_5
    if-ge v1, v0, :cond_13

    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/location/Location;

    invoke-interface {p0, v2}, Landroid/location/LocationListener;->onLocationChanged(Landroid/location/Location;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_13
    return-void
.end method
