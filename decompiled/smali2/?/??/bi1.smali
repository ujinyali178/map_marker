.class Lī/íì/bi1;
.super Landroid/graphics/drawable/GradientDrawable;


# direct methods
.method constructor <init>()V
    .registers 1

    invoke-direct {p0}, Landroid/graphics/drawable/GradientDrawable;-><init>()V

    return-void
.end method


# virtual methods
.method public getIns(II)Landroid/graphics/drawable/GradientDrawable;
    .registers 4

    int-to-float v0, p1

    invoke-virtual {p0, v0}, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V

    invoke-virtual {p0, p2}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    return-object p0
.end method
