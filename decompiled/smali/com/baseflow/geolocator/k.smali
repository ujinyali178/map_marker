.class public final synthetic Lcom/baseflow/geolocator/k;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ly/h0;


# instance fields
.field public final synthetic a:Lu1/e$b;


# direct methods
.method public synthetic constructor <init>(Lu1/e$b;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/baseflow/geolocator/k;->a:Lu1/e$b;

    return-void
.end method


# virtual methods
.method public final a(Landroid/location/Location;)V
    .registers 3

    iget-object v0, p0, Lcom/baseflow/geolocator/k;->a:Lu1/e$b;

    invoke-static {v0, p1}, Lcom/baseflow/geolocator/m;->d(Lu1/e$b;Landroid/location/Location;)V

    return-void
.end method
