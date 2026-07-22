.class public final synthetic Lcom/baseflow/geolocator/i;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lx/a;


# instance fields
.field public final synthetic a:Lcom/baseflow/geolocator/j;

.field public final synthetic b:[Z

.field public final synthetic c:Ly/p;

.field public final synthetic d:Ljava/lang/String;

.field public final synthetic e:Lu1/l$d;


# direct methods
.method public synthetic constructor <init>(Lcom/baseflow/geolocator/j;[ZLy/p;Ljava/lang/String;Lu1/l$d;)V
    .registers 6

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/baseflow/geolocator/i;->a:Lcom/baseflow/geolocator/j;

    iput-object p2, p0, Lcom/baseflow/geolocator/i;->b:[Z

    iput-object p3, p0, Lcom/baseflow/geolocator/i;->c:Ly/p;

    iput-object p4, p0, Lcom/baseflow/geolocator/i;->d:Ljava/lang/String;

    iput-object p5, p0, Lcom/baseflow/geolocator/i;->e:Lu1/l$d;

    return-void
.end method


# virtual methods
.method public final a(Lx/b;)V
    .registers 8

    iget-object v0, p0, Lcom/baseflow/geolocator/i;->a:Lcom/baseflow/geolocator/j;

    iget-object v1, p0, Lcom/baseflow/geolocator/i;->b:[Z

    iget-object v2, p0, Lcom/baseflow/geolocator/i;->c:Ly/p;

    iget-object v3, p0, Lcom/baseflow/geolocator/i;->d:Ljava/lang/String;

    iget-object v4, p0, Lcom/baseflow/geolocator/i;->e:Lu1/l$d;

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/baseflow/geolocator/j;->a(Lcom/baseflow/geolocator/j;[ZLy/p;Ljava/lang/String;Lu1/l$d;Lx/b;)V

    return-void
.end method
