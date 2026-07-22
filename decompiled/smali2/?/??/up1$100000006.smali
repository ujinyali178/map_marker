.class Lī/íì/up1$100000006;
.super Landroid/graphics/drawable/GradientDrawable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lī/íì/up1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x20
    name = "100000006"
.end annotation


# instance fields
.field private final this$0:Lī/íì/up1;


# direct methods
.method constructor <init>(Lī/íì/up1;)V
    .registers 2

    iput-object p1, p0, Lī/íì/up1$100000006;->this$0:Lī/íì/up1;

    invoke-direct {p0}, Landroid/graphics/drawable/GradientDrawable;-><init>()V

    return-void
.end method

.method static access$0(Lī/íì/up1$100000006;)Lī/íì/up1;
    .registers 2

    iget-object v0, p0, Lī/íì/up1$100000006;->this$0:Lī/íì/up1;

    return-object v0
.end method


# virtual methods
.method public getIns(II)Landroid/graphics/drawable/GradientDrawable;
    .registers 4

    int-to-float v0, p1

    invoke-virtual {p0, v0}, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V

    invoke-virtual {p0, p2}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    return-object p0
.end method
