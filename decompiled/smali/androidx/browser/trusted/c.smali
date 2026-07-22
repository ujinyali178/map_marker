.class public Landroidx/browser/trusted/c;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final a:Landroid/support/customtabs/trusted/ITrustedWebActivityCallback;


# direct methods
.method private constructor <init>(Landroid/support/customtabs/trusted/ITrustedWebActivityCallback;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/browser/trusted/c;->a:Landroid/support/customtabs/trusted/ITrustedWebActivityCallback;

    return-void
.end method

.method static a(Landroid/os/IBinder;)Landroidx/browser/trusted/c;
    .registers 2

    const/4 v0, 0x0

    if-nez p0, :cond_5

    move-object p0, v0

    goto :goto_9

    :cond_5
    invoke-static {p0}, Landroid/support/customtabs/trusted/ITrustedWebActivityCallback$Stub;->asInterface(Landroid/os/IBinder;)Landroid/support/customtabs/trusted/ITrustedWebActivityCallback;

    move-result-object p0

    :goto_9
    if-nez p0, :cond_c

    return-object v0

    :cond_c
    new-instance v0, Landroidx/browser/trusted/c;

    invoke-direct {v0, p0}, Landroidx/browser/trusted/c;-><init>(Landroid/support/customtabs/trusted/ITrustedWebActivityCallback;)V

    return-object v0
.end method
