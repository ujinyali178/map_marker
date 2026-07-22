.class Lc0/b$b;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lc0/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "b"
.end annotation


# instance fields
.field public final a:Ljava/lang/String;

.field final b:Lc0/b$c;

.field public final c:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;Lc0/b$c;Ljava/lang/String;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lc0/b$b;->a:Ljava/lang/String;

    iput-object p2, p0, Lc0/b$b;->b:Lc0/b$c;

    iput-object p3, p0, Lc0/b$b;->c:Ljava/lang/String;

    return-void
.end method
